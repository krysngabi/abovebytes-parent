package com.abovebytes.dtos.search;

import com.abovebytes.dtos.document.DocumentSearchDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ServiceSearchDto {
    private Long id;
    private String name;
    private List<DocumentSearchDto> documents;
}