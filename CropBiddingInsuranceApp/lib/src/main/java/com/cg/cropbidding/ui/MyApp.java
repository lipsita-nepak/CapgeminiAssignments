package com.cg.cropbidding.ui;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.cropbidding.utils.MainUtils;

public class MyApp {

	public static void main(String[] args)throws IOException {
		Logger logger = LogManager.getLogger("MyApp.class");
		MainUtils mainUtils = new MainUtils();
		logger.info("Instantiated MyApp.");
		mainUtils.start();

	}

}
