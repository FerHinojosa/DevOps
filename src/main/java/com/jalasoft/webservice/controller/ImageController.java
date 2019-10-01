/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.webservice.controller;

import com.jalasoft.webservice.model.ImageConvert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Implements ImageController with the Imageconvert classes
 * @author Fernando Hinojosa on 09/24/2019
 * @version v1.0
 */
@RestController
@RequestMapping("/api/v1.0/image")
public class ImageController {

        @PostMapping
        public String imageConvert (@RequestParam("file") MultipartFile file,
                 @RequestParam (value = "dpi", defaultValue = "") int dpi,
                 @RequestParam (value = "dest", defaultValue = "") String dest,
                 @RequestParam(value = "ext", defaultValue = "") String ext) throws IOException {
            String filePath = FileManager.getFilePath(file);

            //ImageConvert img = new ImageConvert();
            //String res = img.convert(filePath,dpi,dest,ext);

            return "Done";
        }
}

