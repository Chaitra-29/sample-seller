package com.sample.ecommerce.seller.main;

import io.dropwizard.jackson.JsonSnakeCase;
import lombok.Data;

/**
 * Created by I307690 on 05-Dec-15.
 */
@Data
@JsonSnakeCase
public class SellerRequest {
  String firstName;
  String lastName;

}
