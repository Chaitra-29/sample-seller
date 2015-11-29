package com.sample.ecommerce.seller.manager.config.hystrix;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import io.dropwizard.Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by ali.nalawala on 5/21/14.
 */
public class HystrixRequestContextBundle implements Bundle {

  public static final String NAME = HystrixContextFilter.class.getName();
  public static final String DEFAULT_PATTERN = "/*";
  private final String pattern;

  public HystrixRequestContextBundle() {
    this(DEFAULT_PATTERN);
  }

  public HystrixRequestContextBundle(String pattern) {
    this.pattern = pattern;
  }

  @Override
  public void initialize(Bootstrap<?> bootstrap) {
  }

  @Override
  public void run(Environment environment) {
    environment.servlets().addFilter(NAME, HystrixContextFilter.class)
        .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, DEFAULT_PATTERN);
  }
}
