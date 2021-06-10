package com.dawrop.XBook.controllers;

import com.dawrop.XBook.utils.JsonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@CrossOrigin("http://localhost:8081")
@RestController
public class FileController {
    @PostMapping("/covers")
    public Object addCover(@RequestBody MultipartFile file) {
        String uuid = UUID.randomUUID().toString();
        File myFile = new File("frontend/src/assets/covers/" + uuid + ".png");
        try {
            FileOutputStream fw = new FileOutputStream(myFile);
            fw.write(file.getBytes());
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            return JsonResponse.internalServerError(e.getMessage());
        }

        return JsonResponse.ok(uuid);
    }

}
