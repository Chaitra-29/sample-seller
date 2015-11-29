package com.sample.ecommerce.seller.manager;

import com.google.inject.Stage;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.hubspot.dropwizard.guice.GuiceBundle;
import com.palominolabs.metrics.guice.MetricsInstrumentationModule;
import com.sample.ecommerce.seller.manager.config.ManagerConfiguration;
import com.sample.ecommerce.seller.manager.config.ManagerModule;
import com.sample.ecommerce.seller.manager.config.hystrix.HystrixMetricsBundle;
import com.sample.ecommerce.seller.manager.config.hystrix.HystrixRequestContextBundle;

import org.glassfish.jersey.filter.LoggingFilter;

import java.util.logging.Logger;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lombok.extern.slf4j.Slf4j;

import static java.util.TimeZone.getTimeZone;

/**
 * Created by ali.nalawala on 11/29/15.
 */
@Slf4j
public class ManagerApplication extends Application<ManagerConfiguration> {

  public static void main(String[] args) throws Exception {
    new ManagerApplication().run(args);
  }

  @Override
  public void initialize(final Bootstrap<ManagerConfiguration> bootstrap) {

    bootstrap.addBundle(new HystrixMetricsBundle());
    bootstrap.addBundle(new HystrixRequestContextBundle());

    GuiceBundle.Builder<ManagerConfiguration> builder = GuiceBundle.newBuilder();
    builder.setConfigClass(ManagerConfiguration.class)
        .addModule(new ManagerModule())
        .addModule(new MetricsInstrumentationModule(bootstrap.getMetricRegistry()))
        .enableAutoConfig("com.sample.ecommerce.seller");
    GuiceBundle<ManagerConfiguration> guiceBundle = builder.build(Stage.DEVELOPMENT);
    bootstrap.addBundle(guiceBundle);
  }

  @Override
  public void run(ManagerConfiguration configuration, Environment environment) {
    log.info("Server has started!!");
    environment.getObjectMapper().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    environment.getObjectMapper().setTimeZone(getTimeZone("GMT+5:30"));
    environment.getObjectMapper().registerModule(new Jdk8Module());

    environment.jersey().register(new LoggingFilter(Logger.getLogger(LoggingFilter.class.getName()),
                                                    true));

  }
}