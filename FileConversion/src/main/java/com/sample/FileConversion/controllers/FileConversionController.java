package com.sample.FileConversion.controllers;

import com.sample.FileConversion.services.FileConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/file-conversion")
@CrossOrigin("*")
public class FileConversionController {

    @Autowired
    private FileConversionService fileConversionService;

    @PostMapping("/convert")
    public ResponseEntity<byte[]> convertFile(@RequestParam("file") MultipartFile file, @RequestParam("format") String format) {
        try {
            byte[] convertedFile = fileConversionService.convertFile(file, format);
            String originalFilename = file.getOriginalFilename();
            String newFilename = originalFilename != null ? originalFilename.replaceFirst("[.][^.]+$", "") + "." + format : "converted." + format;

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", newFilename);

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(convertedFile);
        } catch (UnsupportedOperationException e) {
            return ResponseEntity.status(415).body(e.getMessage().getBytes());
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error during file conversion".getBytes());
        }
    }
}
