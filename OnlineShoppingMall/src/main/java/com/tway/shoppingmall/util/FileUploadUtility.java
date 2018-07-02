package com.tway.shoppingmall.util;



import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABS_PATH = "D:\\Developer\\gitProject\\OnlineShoppingMallProject\\OnlineShoppingMallProject\\OnlineShoppingMall\\src\\main\\webapp\\resources\\images\\";
	private static String REAL_PATH = null;

	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);

	public static boolean uploadFile(HttpServletRequest request, MultipartFile file, String code) {

		// get the rela path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/resources/images/");

		logger.info(REAL_PATH);

		// to make sure all the directory exists

		if (!new File(REAL_PATH).exists()) {
			new File(REAL_PATH).mkdirs();
		}

		// please create the directories
		if (!new File(ABS_PATH).exists()) {
			new File(ABS_PATH).mkdirs();
		}

		try {
			// server upload
			file.transferTo(new File(REAL_PATH + code + ".jpg"));

			// project directory upload
			file.transferTo(new File(ABS_PATH + code + ".jpg"));

		} catch (IOException ex) {

			ex.printStackTrace();

		}

		return true;

	}

}
