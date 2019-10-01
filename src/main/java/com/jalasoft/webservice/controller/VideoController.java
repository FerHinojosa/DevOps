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

import com.jalasoft.webservice.model.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Implements the conversion video.
 *
 * @author Raul Laredo
 * @version v1.0
 */
@RestController
@RequestMapping ("/api/v1.0/video")
public class VideoController {

     /**
     *
     * Converts the data video data type in another type
     *
     * @throws IOException
     */
    @PostMapping
    public String Convert (@RequestParam("File") MultipartFile file,
                           @RequestParam("targetFile") MultipartFile targetFile,
                           @RequestParam(value = "audioAttributes", defaultValue = "") String audioAttributes,
                           @RequestParam(value = "codec", defaultValue = "") String codec,
                           @RequestParam(value = "bitRate", defaultValue = "") int bitRate,
                           @RequestParam(value = "channels", defaultValue = "") int channels,
                           @RequestParam(value = "samplingRate", defaultValue = "") int samplingRate,
                           @RequestParam(value = "videoCodec", defaultValue = "") String videoCodec,
                           @RequestParam(value = "videoBitRate", defaultValue = "") int videoBitRate,
                           @RequestParam(value = "frameRate", defaultValue = "") int frameRate,
                           @RequestParam(value = "sizeX", defaultValue = "") int sizeX,
                           @RequestParam(value = "sizeY", defaultValue = "") int sizeY,
                           @RequestParam(value = "format", defaultValue = "") String format
                           ) throws IOException {

        String filePath = FileManager.getFilePath(file);

        VideoConverterCriteria cri = new VideoConverterCriteria();
        cri.setFilePath(filePath);
        cri.setTarget((File)targetFile);
        cri.setSetAudioAttributes(audioAttributes);
        cri.setSetCodec(codec);
        cri.setSetBitRate(bitRate);
        cri.setSetChannels(channels);
        cri.setSetSamplingRate(samplingRate);
        cri.setSetCodec(videoCodec);
        cri.setSetBitRate(videoBitRate);
        cri.setSetFrameRate(frameRate);
        cri.setSetSizeX(sizeX);
        cri.setSetSizeX(sizeY);
        cri.setSetFormat(format);

        IConvert video = new VideoConvert();
        video.convert((Criteria)cri);

        return "done";
    }
}
