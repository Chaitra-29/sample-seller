package com.sample.ecommerce.seller.main;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by I307690 on 16-Dec-15.
 */
public class HashMapStorageTest {
  HashMapStorage storage;

  @Before
  public void setUp() throws Exception {
    storage = new HashMapStorage();
  }

  @Test
  public void testPersistsWorks() throws Exception {
    Seller seller = new Seller();
    seller.setFirstName("F");
    String sellerId = storage.persistenceSeller(seller);
    Seller sellerDetails = storage.getSellerDetails(sellerId);
    assertEquals("F", sellerDetails.firstName);


  }
}