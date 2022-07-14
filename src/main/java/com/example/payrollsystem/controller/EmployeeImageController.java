package com.example.payrollsystem.controller;

import com.example.payrollsystem.messaage.ResponseFile;
import com.example.payrollsystem.messaage.ResponseMessage;
import com.example.payrollsystem.model.EmployeeImage;
import com.example.payrollsystem.service.EmployeeImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/employees")
public class EmployeeImageController {

    @Autowired
    private EmployeeImageService employeeImageService;

    // upload image of an employee
    @PostMapping("/upload/employee-image")
    public ResponseEntity<ResponseMessage> uploadEmployeeImage(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            employeeImageService.saveEmployeeImage(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    // get list of all employee images
    @GetMapping("/employee-images")
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
    @GetMapping("/employees-image/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable("id") String id) {
        EmployeeImage employeeImage = employeeImageService.getEmployeeImage(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + employeeImage.getName() + "\"")
                .body(employeeImage.getData());
    }
}
