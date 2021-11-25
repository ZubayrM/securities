package com.zubayr.egar.securities.controller;

import com.zubayr.egar.securities.dto.SecuritiesInfoDto;
import com.zubayr.egar.securities.dto.SecurityDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SecurityController {

    ResponseEntity<SecurityDto> add(SecurityDto dto);

    ResponseEntity<Boolean> update(SecurityDto dto);

    ResponseEntity<List<SecuritiesInfoDto>> getInfoToDiagram();

    ResponseEntity<List<SecurityDto>> getAll();

}
