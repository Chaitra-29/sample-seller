package com.sample.ecommerce.seller.manager.config;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.dropwizard.Configuration;
import io.dropwizard.client.JerseyClientConfiguration;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by ali.nalawala on 11/29/15.
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class ManagerConfiguration extends Configuration {

  @Valid
  @NotNull
  private JerseyClientConfiguration clientConfiguration = new JerseyClientConfiguration();


}
