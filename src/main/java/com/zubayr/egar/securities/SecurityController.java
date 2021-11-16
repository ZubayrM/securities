package com.zubayr.egar.securities;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SecurityController {


    private SecurityRepository repository;

    public SecurityController(SecurityRepository repository) {
        this.repository = repository;
    }

    private static final SecurityMapper mapper = SecurityMapper.INSTANCE;

    @PostMapping("/add")
    public ResponseEntity<SecurityDto> add(@ModelAttribute SecurityDto dto){

        Security security = mapper.dtoToModel(dto);
        SecurityDto toDto = mapper.modelToDto(repository.save(security));
        return ResponseEntity.ok(toDto);
    }

    @PutMapping("/update")
    public ResponseEntity update(@ModelAttribute SecurityDto dto){
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok(true);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SecurityDto>> getAll(){

        ArrayList<SecurityDto> list = new ArrayList<>();
        repository.findAll().forEach(o -> list.add(mapper.modelToDto(o)));
        return ResponseEntity.ok(list);
    }

}
