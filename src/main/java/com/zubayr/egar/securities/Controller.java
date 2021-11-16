package com.zubayr.egar.securities;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String index(Model model) throws IOException {

        URL url = new URL("http:localhost/all");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("get");



        model.addAttribute("list",urlConnection.getInputStream());

        return "index";
    }
}
