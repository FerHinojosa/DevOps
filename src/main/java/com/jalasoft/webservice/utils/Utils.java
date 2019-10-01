/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */

package com.jalasoft.webservice.utils;

import java.nio.file.Paths;

/**
 * The class is a gestor for path and files destinations
 *
 * @author Andy Bazualdo on 9/26/2019.
 * @version v1.0
 */
public class Utils{
    private String absolutePath;

    //class constructor
    public Utils(){
        this.absolutePath = Paths.get("").toAbsolutePath().toString();
    }

    /**
     * Getter method for absolute path
     * @return absolute path as a String
     */
    public String getAbsolutePath(){
        return absolutePath;
    }

    /**
     * Getter method for ThirdParty path
     * @return method returns as a String the absolute path of ThirdParty folder
     */
    public String getThirdParty(){

        return this.getAbsolutePath() + "/ThirdParty/";
    }

    /**
     * Getter method for utils path
     * @return method returns as a String the absolute path of resources folder
     */
    public String getResources(){

        return this.getAbsolutePath() + "/src/main/java/com/jalasoft/webservice/resources/";
    }

    /**
     * Getter method for public path
     * @return
     */
    public String getPublic(){

        return this.getAbsolutePath() + "/publics/";
    }

    /**
     * Getter method for temp path
     * @return
     */
    public String getTemp(){

        return this.getAbsolutePath() + "/temp/";
    }

    /**
     * Getter method for config path
     * @return
     */
    public String getConig(){

        return this.getAbsolutePath() + "/config/";
    }

}
