package com.sample.ecommerce.seller.main;

import io.dropwizard.jackson.JsonSnakeCase;
import lombok.Data;

/**
 * Created by I307690 on 05-Dec-15.
 */
@JsonSnakeCase
@Data
public class SellerResponse {
  String id;
  String firstName;
  String lastName;

}
