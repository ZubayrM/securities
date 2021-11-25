package com.zubayr.egar.securities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecuritiesInfoDto {

    private String name;

    private Object[] list;

}
