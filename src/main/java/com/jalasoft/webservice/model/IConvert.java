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

import java.io.IOException;

/**
 * The interface implements convert function for ImageConvert, videoConvert and OCRExtractor classes
 *
 * @author Andy Bazualdo on 9/23/19.
 * @version v1.0
 */

public interface IConvert {
    String convert(Criteria criteria) throws IOException;
}
