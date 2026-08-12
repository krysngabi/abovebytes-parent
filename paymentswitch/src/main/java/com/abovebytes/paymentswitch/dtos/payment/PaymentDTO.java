package com.abovebytes.paymentswitch.dtos.payment;

import com.abovebytes.paymentswitch.models.enums.PaymentStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "PaymentDTO")
public class PaymentDTO {

    private Long paymentId;

    private String paymentIntentId;

    private String internalAppCustomerId;

    private String internalAgentId;

    private String internalAppCustomerPhone;

    private String customerName;

    private String productName;

    private String amount;

    private PaymentStatus status;

    private LocalDateTime createDate;

    private LocalDateTime lastModified;
}