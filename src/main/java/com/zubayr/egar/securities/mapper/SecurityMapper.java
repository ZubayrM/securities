package com.zubayr.egar.securities.mapper;

import com.zubayr.egar.securities.dto.SecurityDto;
import com.zubayr.egar.securities.model.Security;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SecurityMapper {

    SecurityMapper INSTANCE = Mappers.getMapper(SecurityMapper.class);

    @Mappings({
            @Mapping(target = "date", source = "date" ,dateFormat = "yyyy-MM-dd")
    })
    Security dtoToModel(SecurityDto dto);

    @Mappings({
            @Mapping(target = "date", source = "date" , dateFormat = "yyyy-MM-dd")
    })
    SecurityDto modelToDto(Security model);


}
