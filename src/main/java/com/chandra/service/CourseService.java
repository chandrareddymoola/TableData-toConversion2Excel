package com.chandra.service;

import com.chandra.entity.Course;
import com.chandra.repository.CourseRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public void saveCourse() {
        Course cs = new Course();
        cs.setPrice(400.00);
        cs.setCName("Nagalakshmi");
        courseRepository.save(cs);
    }

    public void GenerateExcel(HttpServletResponse response) throws IOException {
        List<Course> courseList=courseRepository.findAll();
        //workbook/sheet/row/cell
        HSSFWorkbook hssfWorkbook=new HSSFWorkbook();
        HSSFSheet hssfSheet=hssfWorkbook.createSheet("Course_Info");
       HSSFRow row= hssfSheet.createRow(0);
        row.createCell(0).setCellValue("ID");
        row.createCell(0).setCellValue("Name");
        row.createCell(0).setCellValue("PRICE");

        int dataRowIndex=1;
        for(Course course :courseList){
            HSSFRow dataRow=hssfSheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(course.getCId());
            dataRow.createCell(1).setCellValue(course.getCName());
            dataRow.createCell(2).setCellValue(course.getPrice());
            dataRowIndex++;
        }
       ServletOutputStream ops= response.getOutputStream();
        hssfWorkbook.write(ops);

        ops.close();

    }
}
