package com.sample.ecommerce.seller.main;


import org.elasticsearch.common.joda.time.DateTime;
import org.elasticsearch.common.joda.time.DateTimeZone;

import java.util.HashMap;
import java.util.UUID;

import lombok.Data;

/**
 * Created by I307690 on 05-Dec-15.
 */
@Data
public class HashMapStorage implements ISellerInterface {
  private static HashMap<String, Seller> storage = new HashMap<String, Seller>();
  ;

  @Override
  public String persistenceSeller(SellerRequest request) {
    String sellerId = UUID.randomUUID().toString();
    Seller seller = new Seller();
    seller.setFirstName(request.getFirstName());
    seller.setLastName(request.getLastName());
    seller.setCreatedAt(DateTime.now(DateTimeZone.UTC));
    seller.setSellerId(sellerId);
    HashMapStorage.storage.put(sellerId, seller);
    return sellerId;
  }

  @Override
  public Seller getSellerDetails(String sellerId) {
    Seller seller = HashMapStorage.storage.get(sellerId);
    return seller;
  }
}
