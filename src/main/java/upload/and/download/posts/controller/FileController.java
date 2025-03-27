package upload.and.download.posts.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import upload.and.download.posts.entity.File;
import upload.and.download.posts.service.FileService;

@RestController
public class FileController {
    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        fileService.saveFile(file);
        return new ResponseEntity("File uploaded successfully", HttpStatus.CREATED);
    }

    @GetMapping("/download/{fileID}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable("fileID") int fileID) {
        File file = fileService.getFile(fileID);
        return ResponseEntity.ok()
                .header("Content-type", "file/jpeg")
                .body(file.getFile());
    }

}
