package com.sample.ecommerce.seller.main.config;

import com.google.inject.AbstractModule;

import com.sample.ecommerce.seller.main.SellerResource;

/**
 * Created by I307690 on 05-Dec-15.
 */
public class SellerModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(SellerResource.class);
  }
}
