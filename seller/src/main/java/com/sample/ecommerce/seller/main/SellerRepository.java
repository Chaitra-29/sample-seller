package com.sample.ecommerce.seller.main;

/**
 * Created by I307690 on 05-Dec-15.
 */

public interface SellerRepository {
  public String persistenceSeller(Seller seller);

  public Seller getSellerDetails(String sellerId);
}
