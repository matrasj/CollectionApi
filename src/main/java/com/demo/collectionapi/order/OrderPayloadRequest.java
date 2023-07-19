package com.demo.collectionapi.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderPayloadRequest {
    @NotBlank
    private String productName;
    private String comments;
    @NotBlank
    private String purchaserFirstName;
    @NotBlank
    private String purchaserLastName;

}
