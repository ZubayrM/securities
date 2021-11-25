package com.zubayr.egar.securities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateToPrice {

    private LocalDate date;

    private Integer price;

}
