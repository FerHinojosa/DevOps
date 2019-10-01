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

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * The class implements methods to convert PDF files into image files
 *
 * @author Andy Bazualdo on 9/23/19.
 * @version v1.0
 */
public class ImageConvert implements IConvert{

    /**
     *  Creates the Controller Model using Tesseract with the wrapper Tess4J.
     *
     */
    public String convert(Criteria imageCriteria) {
        ImageCriteria imgCriteria = (ImageCriteria) imageCriteria;
        try {

            String source = imgCriteria.getFilePath();
            String destination = imgCriteria.getDestinationPath();
            int dpi = imgCriteria.getDpi();
            String ext = imgCriteria.getExtension();

            //Loading an existing PDF document
            File file = new File(source);
            PDDocument document = PDDocument.load(file);

            //Instantiating the PDFRenderer class
            PDFRenderer renderer = new PDFRenderer(document);
            int count = document.getNumberOfPages();
            for (int page = 0; page < count; ++page) {

                BufferedImage img = renderer.renderImageWithDPI(page, dpi, ImageType.RGB);
                String fileName = destination + page + ext;
                ImageIOUtil.writeImage(img, fileName, 300);
            }

            document.close();
            return "Image created";
        } catch (Exception e) {
            String error = "error message" + e;
            return error;

        }
    }
}
