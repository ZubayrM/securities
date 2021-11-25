package com.zubayr.egar.securities.controller;

import com.zubayr.egar.securities.controller.URL.SecurityURL;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@org.springframework.stereotype.Controller
public class ControllerImpl implements Controller {

    private final SecurityURL securityURL;
    private final RestTemplate restTemplate;

    public ControllerImpl(SecurityURL securityURL , RestTemplate restTemplate) {
        this.securityURL = securityURL;
        this.restTemplate = restTemplate;
    }

    @Override
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute(
                "list",
                restTemplate
                        .getForEntity(securityURL.getURL() + securityURL.ALL, List.class).getBody());
        return "index";
    }

}
