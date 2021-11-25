package com.zubayr.egar.securities.controller.URL;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "security")
public class SecurityURL {

    @Getter
    public String ALL;

    @Getter
    private String URL;

    @Getter
    private String DIAGRAM;


}
