package com.example.payrollsystem.controller;

import com.example.payrollsystem.messaage.ResponseFile;
import com.example.payrollsystem.model.EmployeeImage;
import com.example.payrollsystem.service.EmployeeImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/employees")
public class EmployeeImageController {

    @Autowired
    private EmployeeImageService employeeImageService;

    // get list of all employee images
    @GetMapping("/images")
    public ResponseEntity<List<ResponseFile>> getAllEmployeeImages() {
        List<ResponseFile> files = employeeImageService.getAllEmployeeImages().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/images/")
                    .path(dbFile.getId())
                    .toUriString();
            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    (long) dbFile.getData().length);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    // get an employee's image
    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable("id") String id) {
        EmployeeImage employeeImage = employeeImageService.getEmployeeImage(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + employeeImage.getName() + "\"")
                .body(employeeImage.getData());
    }
}
