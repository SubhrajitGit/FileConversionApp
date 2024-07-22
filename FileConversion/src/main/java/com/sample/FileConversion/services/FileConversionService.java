package com.sample.FileConversion.services;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileConversionService {

    public byte[] convertFile(MultipartFile file, String format) throws IOException {
        if ("xls".equalsIgnoreCase(format)) {
            return convertTxtToXls(file);
        } else {
            throw new UnsupportedOperationException("Conversion for the specified format is not supported");
        }
    }

    private byte[] convertTxtToXls(MultipartFile file) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            int rowIndex = 0;
            while ((line = reader.readLine()) != null) {
                Row row = sheet.createRow(rowIndex++);
                String[] columns = line.split("\t");
                for (int i = 0; i < columns.length; i++) {
                    Cell cell = row.createCell(i);
                    cell.setCellValue(columns[i]);
                }
            }
        }

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            workbook.write(outputStream);
            return outputStream.toByteArray();
        }
    }
}
