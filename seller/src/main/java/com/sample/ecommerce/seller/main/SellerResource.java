package com.sample.ecommerce.seller.main;


import com.google.inject.Inject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by I307690 on 05-Dec-15.
 */
@Path("/seller")
@Slf4j
public class SellerResource {
  @Inject
  public SellerResource() {
  }

  @Path("/{seller_id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public SellerResponse getSellerDetails(@PathParam("seller_id") String sellerId) {
    SellerResponse sellerres = new SellerResponse();
    sellerres.setId("1");
    sellerres.setFirstName("Foo");
    sellerres.setLastName("Far");
    return sellerres;

  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public void persistSeller(SellerRequest request) {
    log.info("got a request {}", request);

  }




}
