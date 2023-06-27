package com.example.simpleapps.controller;

import com.example.simpleapps.util.HttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/recruitment")
public class RecruitmentController extends HttpClient {

    @Value("${url.getJobList}")
    private String getJobListUrl;

    @Value("${url.getJobDetail}")
    private String getJobDetailUrl;

    @GetMapping(value = "/getJobList")
    public String getJobList() throws IOException, InterruptedException {
        String url = getJobListUrl;

        HttpResponse<String> response = httpClientGet(url);

        return response.body();
    }

    @GetMapping(value = "/getJobDetail")
    public String getJobDetail(String id) throws IOException, InterruptedException {
        String url = getJobDetailUrl.concat("/").concat(id);

        HttpResponse<String> response = httpClientGet(url);

        return response.body();
    }
}
