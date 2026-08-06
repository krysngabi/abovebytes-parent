package com.abovebytes.dtos.document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DocumentReviewDto {
    // This is used at the VerifyIdDocumentsDocumentScreen in the mobile app
    // So be careful when changing this
    private Long userId;
    private Long pictureId;
    private String pictureUrl;
    private String status;
    private String statusColor;
}
