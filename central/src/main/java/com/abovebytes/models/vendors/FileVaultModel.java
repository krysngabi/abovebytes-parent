package com.abovebytes.models.vendors;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileVaultModel {
    private String status;
    private String name;
    private String uuid;
    private String url;
    private String message;
    private String card_id;
    private String account_id;
    private String dailyLimit;
    private String cardHolder;
    private boolean found;
}
