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

import java.io.File;

/**
 * Implements the criteria needs for convert the video in other format.
 *
 * @author Raul Laredo
 * @version v1.0
 */
public class VideoConverterCriteria extends Criteria {

     private File target;
     private String setCodec;
     private int setBitRate;
     private int setChannels;
     private int setSamplingRate;
     private int setFrameRate;
     private int setSizeX;
     private int setSizeY;
     private String setFormat;
     private String setAudioAttributes;
     private String setVideoAttributes;

    public File getTarget() {
        return target;
    }

    public void setTarget(File target) {
        this.target = target;
    }

    public String getSetCodec() {
        return setCodec;
    }

    public void setSetCodec(String setCodec) {
        this.setCodec = setCodec;
    }

    public int getSetBitRate() {
        return setBitRate;
    }

    public void setSetBitRate(int setBitRate) {
        this.setBitRate = setBitRate;
    }

    public int getSetChannels() {
        return setChannels;
    }

    public void setSetChannels(int setChannels) {
        this.setChannels = setChannels;
    }

    public int getSetSamplingRate() {
        return setSamplingRate;
    }

    public void setSetSamplingRate(int setSamplingRate) {
        this.setSamplingRate = setSamplingRate;
    }

    public int getSetFrameRate() {
        return setFrameRate;
    }

    public void setSetFrameRate(int setFrameRate) {
        this.setFrameRate = setFrameRate;
    }

    public int getSetSizeX() {
        return setSizeX;
    }

    public void setSetSizeX(int setSizeX) {
        this.setSizeX = setSizeX;
    }

    public int getSetSizeY() {
        return setSizeY;
    }

    public void setSetSizeY(int setSizeY) {
        this.setSizeY = setSizeY;
    }

    public String getSetFormat() {
        return setFormat;
    }

    public void setSetFormat(String setFormat) {
        this.setFormat = setFormat;
    }

    public String getSetAudioAttributes() {
        return setAudioAttributes;
    }

    public void setSetAudioAttributes(String setAudioAttributes) {
        this.setAudioAttributes = setAudioAttributes;
    }

    public String getSetVideoAttributes() {
        return setVideoAttributes;
    }

    public void setSetVideoAttributes(String setVideoAttributes) {
        this.setVideoAttributes = setVideoAttributes;
    }

}
