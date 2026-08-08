package com.abovebytes.dtos.images;


import com.abovebytes.models.responses.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ImageDto extends BaseResponse {
    private Long id;
    private String dataType;
    private String label;
    private String url;
    private UUID uuid;
}
