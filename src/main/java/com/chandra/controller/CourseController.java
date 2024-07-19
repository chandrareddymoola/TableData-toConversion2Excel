package com.chandra.controller;

import com.chandra.service.CourseService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping("/excel")
    public void GenerateExcel(HttpServletResponse response) throws IOException {
        // the above method is responsible for the download the excel file
        response.setContentType("Application /Octet-stream");
        String headerkey=   "Content-Disposition";
        String headervalue="attachment;filename=courses.xlxs";
        response.setHeader(headerkey,headervalue);
        courseService.GenerateExcel(response);

    }



}
