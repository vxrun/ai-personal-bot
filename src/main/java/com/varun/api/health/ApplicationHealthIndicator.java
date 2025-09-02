package com.varun.api.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @author varun.kumar
 */
@Component
public class ApplicationHealthIndicator implements HealthIndicator {

  @Override
  public Health health() {
    return Health.up()
        .withDetail("application", "Running")
        .withDetail("upTime", System.currentTimeMillis())
        .build();
  }
}
