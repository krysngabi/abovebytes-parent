package com.abovebytes.notifications.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;


@XmlRootElement
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseCentral {
    private String message;
    private String code;
    private String timestamp;
    private String title;
    private String path;
}
