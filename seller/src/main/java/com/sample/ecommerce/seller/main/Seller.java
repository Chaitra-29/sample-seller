package com.sample.ecommerce.seller.main;


import org.elasticsearch.common.joda.time.DateTime;

import java.util.UUID;

import lombok.Data;

/**
 * Created by I307690 on 06-Dec-15.
 */
@Data
public class Seller {
  String id = UUID.randomUUID().toString();
  String firstName;
  String lastName;
  DateTime createdAt;

}