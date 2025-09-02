package com.varun.api.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author varun.kumar
 */
@Slf4j
@Aspect
@Component
@EnableAspectJAutoProxy
public class AspectConfig {

  @Autowired private ObjectMapper objectMapper;

  private static final int _ARGUMENTS_TOPRINT_LENGTH = 300;

  @Around("@annotation(com.varun.api.aop.annotation.ExecutionTracker)")
  public Object methodEntryLoggerClasses(ProceedingJoinPoint joinPoint) throws Throwable {
    try {
      objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
      String methodName = joinPoint.getSignature().getName();
      String className = joinPoint.getSignature().getDeclaringTypeName();
      Object[] arguments = joinPoint.getArgs();

      String finalArgument = return100LengthArguments(objectMapper.writeValueAsString(arguments));
      long startTime = System.currentTimeMillis();
      // method
      Object result = joinPoint.proceed();
      long executionTime = System.currentTimeMillis() - startTime;
      log.debug(
          "Executed Method Name : [{}.{}]... time taken : [{}] ms... with arguments : [{}]",
          className,
          methodName,
          executionTime,
          finalArgument);
      return result;
    } catch (Exception e) {
      log.trace("Exception found in ExecutionTracker... Printing stack trace below...", e);
    } catch (Throwable e) {
      log.trace("Threw error... Printing stack trace below...", e);
    }
    return joinPoint.proceed();
  }

  private String return100LengthArguments(String inputString) {
    if (StringUtils.isEmpty(inputString)) {
      return StringUtils.EMPTY;
    }
    return inputString.length() > _ARGUMENTS_TOPRINT_LENGTH
        ? inputString.substring(0, _ARGUMENTS_TOPRINT_LENGTH) + "..."
        : inputString;
  }
}
