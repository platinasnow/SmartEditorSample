package org.sample.se.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

	private static int  maxUploadFileSize = 4096*1024;
	public static int getMaxUploadFileSize(){
		return maxUploadFileSize;
	}
	public static void fileUpload(MultipartFile fileData, String path, String fileName) {
		//String fileName = fileData.getName();
		String originalFileName = fileData.getOriginalFilename();
		String contentType = fileData.getContentType();
		long fileSize = fileData.getSize();
/*
		System.out.println("file Info");
		System.out.println("fileName " + fileName);
		System.out.println("originalFileName :" + originalFileName);
		System.out.println("contentType :" + contentType);
		System.out.println("fileSize :" + fileSize);
*/
		InputStream is = null;
		OutputStream out = null;

		try {
			if (fileSize > 0) {
				is = fileData.getInputStream();
				/*
				 * File realUploadDir = new File(
				 * "C:\\Users\\Administrator\\Documents\\Snow\\upload");
				 */
				System.out.println(path);
				File realUploadDir = new File(path);
				if (!realUploadDir.exists()) {
					realUploadDir.mkdirs();
				}
				out = new FileOutputStream(
				// "C:\\Users\\Administrator\\Documents\\Snow\\upload\\"
						path +"/upload/"+ fileName);

				int readByte = 0;
				byte[] buffer = new byte[maxUploadFileSize];

				while ((readByte = is.read(buffer, 0, maxUploadFileSize)) != -1) {
					out.write(buffer, 0, readByte);
				}
			}
			try {
				out.close();
			} catch (IOException e) {}
			try {
				is.close();
			} catch (IOException e) {}
		} catch (Exception e) {
			System.out.println("파일업로드에 실패하였습니다.");
			e.printStackTrace();
		}
	}
}