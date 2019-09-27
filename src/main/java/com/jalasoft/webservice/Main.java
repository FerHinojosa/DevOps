package com.jalasoft.webservice;

import com.jalasoft.webservice.model.ImageConvert;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.io.IOException;

@SpringBootApplication
public class Main{

        public static void main (String [] args ) throws IOException{

            SpringApplication.run(Main.class, args);

            /*
            test for ImageConvert uncomment and run to test

            ImageConvert imageConvert =new ImageConvert();
            String res = imageConvert.ImageConvert("",300,"","");

             */
        }


}
