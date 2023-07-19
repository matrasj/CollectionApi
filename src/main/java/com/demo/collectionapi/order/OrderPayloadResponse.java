package com.demo.collectionapi.order;

import com.demo.collectionapi.infrastructure.helpers.RequestStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderPayloadResponse {
    private RequestStatus requestStatus;
}
