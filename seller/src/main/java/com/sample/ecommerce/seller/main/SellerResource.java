package com.sample.ecommerce.seller.main;


import com.google.inject.Inject;

import org.joda.time.DateTime;

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
  private final SellerRepository sellerRepository;

  @Inject
  public SellerResource(SellerRepository sellerRepository) {
    this.sellerRepository = sellerRepository;
  }

  @Path("/{seller_id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Seller getSellerDetails(@PathParam("seller_id") String sellerId) {
    Seller seller = sellerRepository.getSellerDetails(sellerId);
    return seller;

  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public String persistSeller(SellerRequest request) {
    log.info("got a request {}", request);
    Seller seller = new Seller();
    seller.setFirstName(request.getFirstName());
    seller.setLastName(request.getLastName());
    seller.setCreatedAt(DateTime.now());
    String sellerId = sellerRepository.persistenceSeller(seller);
    return sellerId;
  }




}
