package com.sample.ecommerce.seller.main;


import java.util.HashMap;

import lombok.Data;

/**
 * Created by I307690 on 05-Dec-15.
 */
@Data
public class HashMapStorage implements ISellerInterface {
  private static HashMap<String, Seller> storage = new HashMap<String, Seller>();
  ;

  @Override
  public String persistenceSeller(Seller seller) {
    String sellerId = seller.getId();
    HashMapStorage.storage.put(sellerId, seller);
    return sellerId;
  }

  @Override
  public Seller getSellerDetails(String sellerId) {
    Seller seller = HashMapStorage.storage.get(sellerId);
    return seller;
  }
}
