package com.sample.ecommerce.seller.main;


import com.google.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by I307690 on 05-Dec-15.
 */
@Path("/seller")
public class SellerResource {
  @Inject
  public SellerResource() {
  }

  @Path("/{seller_id}")
  @GET
  public String getSellerDetails(@PathParam("seller_id") String sellerId) {
    return sellerId + " Is " + "Awesome";

  }
}
