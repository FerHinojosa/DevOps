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

/**
 * The class implements methods to constructor, get and set methods
 *
 * @author Andy Bazualdo on 9/24/19.
 * @version v1.0
 */
public class OCRCriteria extends Criteria {
    private String lang;

    /**
     * Constructor method
     *
     * @param lang the parameter lang set the language used
     * @param path the parameter saves the path file location
     */
    public OCRCriteria(String lang, String path) {
        this.lang = lang;
        super.setFilePath(path);
        return;
    }

    /**
     * getter method for language parameter
     *
     * @return
     */
    public String getLang() {
        return lang;
    }

    /**
     * Setter parameter for language parameter
     *
     * @param lang
     */
    public void setLang(String lang) {
        this.lang = lang;
        return;
    }
}
