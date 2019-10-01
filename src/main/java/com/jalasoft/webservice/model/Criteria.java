package com.jalasoft.webservice.model;

/**
 *
 * @project WebService feature(OCRController)
 * @author Fernando Hinojosa on 09/23/2019
 */

public abstract class Criteria {
    private String filePath;

    public String getFilePath() {

        return filePath;
    }

    public void setFilePath(String filePath) {

        this.filePath = filePath;
    }
}
