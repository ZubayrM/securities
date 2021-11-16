package com.zubayr.egar.securities;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SecurityMapper {

    SecurityMapper INSTANCE = Mappers.getMapper(SecurityMapper.class);

    @Mappings({
            @Mapping(target = "date", source = "dto.date" ,dateFormat = "dd.MM.yyyy")
    })
    Security dtoToModel(SecurityDto dto);


    SecurityDto modelToDto(Security model);


}
