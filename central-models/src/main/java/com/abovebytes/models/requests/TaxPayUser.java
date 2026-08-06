package com.abovebytes.models.requests;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class TaxPayUser {

    private Long userId;

    @Override
    public String toString() {
        return "TaxPayUser {" +
                "userId=" + userId +
                '}';
    }
}
