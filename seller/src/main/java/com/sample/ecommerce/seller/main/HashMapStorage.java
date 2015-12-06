package com.sample.ecommerce.seller.main;

import java.util.HashMap;
import java.util.UUID;

import lombok.Data;

/**
 * Created by I307690 on 05-Dec-15.
 */
@Data
public class HashMapStorage implements ISellerInterface {
  private static HashMap<String, SellerRequest> storage = new HashMap<String, SellerRequest>();
  ;

  @Override
  public String persistenceSeller(SellerRequest request) {
    String sellerId = UUID.randomUUID().toString();
    HashMapStorage.storage.put(sellerId, request);

    return sellerId;
  }

  @Override
  public SellerResponse getSellerDetails(String sellerId) {
    SellerRequest request = HashMapStorage.storage.get(sellerId);
    SellerResponse response = new SellerResponse();
    response.setId(sellerId);
    response.setFirstName(request.getFirstName());
    response.setLastName(request.getLastName());
    return response;
  }
}
