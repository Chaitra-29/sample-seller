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
  HashMapStorage sellerDetails = new HashMapStorage();
  @Inject
  public SellerResource() {
  }

  @Path("/{seller_id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Seller getSellerDetails(@PathParam("seller_id") String sellerId) {
    Seller seller = sellerDetails.getSellerDetails(sellerId);
    return seller;

  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public String persistSeller(SellerRequest request) {
    log.info("got a request {}", request);
    String sellerId = sellerDetails.persistenceSeller(request);
    return sellerId;
  }




}
