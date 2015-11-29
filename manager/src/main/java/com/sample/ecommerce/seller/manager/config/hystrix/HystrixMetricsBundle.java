package com.sample.ecommerce.seller.manager.config.hystrix;

import com.netflix.hystrix.contrib.codahalemetricspublisher.HystrixCodaHaleMetricsPublisher;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.hystrix.strategy.HystrixPlugins;

import io.dropwizard.Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by ali.nalawala on 5/19/14.
 */
public class HystrixMetricsBundle implements Bundle {

  @Override
  public void initialize(Bootstrap<?> bootstrap) {
    HystrixPlugins.getInstance().registerMetricsPublisher(
        new HystrixCodaHaleMetricsPublisher(bootstrap.getMetricRegistry()));
  }

  @Override
  public void run(Environment environment) {
    environment.getApplicationContext().addServlet(HystrixMetricsStreamServlet.class,
                                                   "/hystrix.stream");
  }
}
