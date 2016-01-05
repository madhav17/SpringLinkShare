package com.intelligrape.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by madhav on 5/1/16.
 */
public class Util {

    public static Logger getLogger(Class clazz){
        return  LoggerFactory.getLogger(clazz);
    }
}
