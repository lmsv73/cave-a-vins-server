package com.reference.api.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    //Save the uploaded file to this folder
    private static String uploadedFolder = "images/";

    /***
     * Get uploaded images on the server
     * @param imageName
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/{imageName}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    @ApiOperation(value = "Get uploaded images from the server")
    public ResponseEntity<byte[]> getImage(@PathVariable("imageName") String imageName) throws IOException {


        File file = new File(uploadedFolder + imageName + ".jpg");
        InputStream targetStream = new FileInputStream(file);
        byte[] bytes = StreamUtils.copyToByteArray(targetStream);

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }

    /***
     * Upload images on the server
     * @param file
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value= "/", method = RequestMethod.POST, produces = MediaType.MULTIPART_FORM_DATA_VALUE) // //new annotation since 4.3
    @ApiOperation(value = "Upload image on the server")
    public ResponseEntity<String> singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {


        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadedFolder + file.getOriginalFilename()).toAbsolutePath();

            Files.write(path, bytes);

                redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            // we do nothing atm
        }

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
