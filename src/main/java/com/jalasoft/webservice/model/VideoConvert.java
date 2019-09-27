/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.webservice.model;

import ws.schild.jave.*;
import java.io.File;
import java.io.IOException;

/**
 * Implements the video convert implementing IConvert for using in the conversion.
 *
 * @author Raul Laredo
 * @version v1.0
 */
public class VideoConvert implements IConvert {

      /**
      * Converts the data video data type in another type using the criterias
      *
      * @param criteria has the params of the convert method
      * @return the video transformed in another video data type
      * @throws IOException
      */
    @Override
    public String convert(Criteria criteria) throws IOException {
        try {
            VideoConverterCriteria videocri = (VideoConverterCriteria)criteria;

             File source = new File(videocri.getFilePath()) ;
             File target = videocri.getTarget();

             //Audio Attributes
             AudioAttributes audio = new AudioAttributes();
             audio.setCodec(videocri.getSetCodec());
             audio.setBitRate(videocri.getSetBitRate());
             audio.setChannels(videocri.getSetChannels());
             audio.setSamplingRate(videocri.getSetSamplingRate());

            //Video settings
             VideoAttributes video = new VideoAttributes();
             video.setCodec(videocri.getSetCodec());
             video.setBitRate(videocri.getSetBitRate());
             video.setFrameRate(videocri.getSetFrameRate());
             video.setSize(new VideoSize(videocri.getSetSizeX(), videocri.getSetSizeY()));
             EncodingAttributes attrs = new EncodingAttributes();
             attrs.setFormat(videocri.getSetFormat());
             attrs.setAudioAttributes(audio);
             attrs.setVideoAttributes(video);
             Encoder encoder = new Encoder();
             encoder.encode(new MultimediaObject(source), target, attrs);
             return "Done";
        } catch (Exception e) {
             return e.getMessage();
        }
    }



}
