package com.zubayr.egar.securities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecurityDto {

    private String id;

    private String date;

    private String name;

    private String price;

}
