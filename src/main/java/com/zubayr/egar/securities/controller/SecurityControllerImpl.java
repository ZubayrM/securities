package com.zubayr.egar.securities.controller;

import com.zubayr.egar.securities.dto.SecuritiesInfoDto;
import com.zubayr.egar.securities.dto.SecurityDto;
import com.zubayr.egar.securities.mapper.SecurityMapper;
import com.zubayr.egar.securities.model.Security;
import com.zubayr.egar.securities.repository.SecurityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SecurityControllerImpl implements SecurityController {

    private static final SecurityMapper mapper = SecurityMapper.INSTANCE;
    private final SecurityRepository repository;

    public SecurityControllerImpl(SecurityRepository repository) {
        this.repository = repository;
    }

    @Override
    @PostMapping("/add")
    public ResponseEntity<SecurityDto> add(@ModelAttribute SecurityDto dto){

        Security security = mapper.dtoToModel(dto);
        SecurityDto toDto = mapper.modelToDto(repository.save(security));
        return ResponseEntity.ok(toDto);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<Boolean> update(@ModelAttribute SecurityDto dto){

        Security dtoToModel = mapper.dtoToModel(dto);
        Optional<Security> optionalSecurity = repository.findById(dtoToModel.getId());
        Security security = optionalSecurity.orElseThrow(() -> new EntityNotFoundException("Not found by ID"));

        security.setDate(dtoToModel.getDate() != null ? dtoToModel.getDate() : security.getDate());
        security.setName(dtoToModel.getName() != null ? dtoToModel.getName() : security.getName());
        security.setPrice(dtoToModel.getPrice() != null ? dtoToModel.getPrice() : security.getPrice());

        repository.save(security);

        return ResponseEntity.ok(true);
    }


    @Override
    @GetMapping( value =  "getDataInDiagram")
    public ResponseEntity<List<SecuritiesInfoDto>> getInfoToDiagram(){
        return ResponseEntity.ok(generatedListToDiagram());
    }

    @Override
    @GetMapping(value = "getAll")
    public ResponseEntity<List<SecurityDto>> getAll() {
        List<SecurityDto> list = new ArrayList<>();
        repository.findAll().forEach(o -> list.add(mapper.modelToDto(o)));
        return ResponseEntity.ok(list);
    }

    private List<SecuritiesInfoDto> generatedListToDiagram() {
        String[] allNameToDiagram = repository.getAllNameToDiagram();
        List<SecuritiesInfoDto> listDiagram = new ArrayList<>();
        if (allNameToDiagram.length > 0){
            Arrays.stream(allNameToDiagram)
                    .forEach(o -> listDiagram
                            .add(new SecuritiesInfoDto(o, repository.getDateAndPriceByName(o))));
        }
        return listDiagram;
    }

}
