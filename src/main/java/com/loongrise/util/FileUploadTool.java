package com.loongrise.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

//import com.yy.yoga.entity.Video;

public class FileUploadTool {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	
	Random random = new Random();
	
	//允许最大上传限制
	private static long upload_maxisize = 500 * 1024 * 1024;
	
	//允许上传视频文件的类型
	private static String[] allowFiles = { ".rar", ".doc", ".docx", ".zip",
            ".pdf", ".txt", ".swf", ".xlsx", ".gif", ".png", ".jpg", ".jpeg",
            ".bmp", ".xls", ".mp4", ".flv", ".ppt", ".avi", ".mpg", ".wmv",
            ".3gp", ".mov", ".asf", ".asx", ".vob", ".wmv9", ".rm", ".rmvb" };
	
//    public Video createFile(Video video,CommonsMultipartFile multipartFile, HttpServletRequest request) {
//    	boolean bFlag = false;
//    	String fileName = multipartFile.getOriginalFilename().toString();
//
//    	//判断文件不为空且上传文件是否符合指定的要求;
//    	if(multipartFile.getSize() != 0 && !multipartFile.isEmpty()) {
//    		bFlag = true;
//    		//判断文件大小
//    		if(multipartFile.getSize() <= upload_maxisize) {
//    			bFlag = true;
//    			if(this.checkFileType(fileName)) {
//    				bFlag = true;
//    			}else {
//    				bFlag = false;
//    				System.out.println("文件类型不允许!");
//    			}
//    		}else {
//    			bFlag = false;
//    			System.out.println("文件大小超出范围!");
//    		}
//    	}else {
//    		bFlag = false;
//    		System.out.println("文件为空！");
//    	}
//
//    	if(bFlag) {
//    		String realPathDir = PathUtil.getVideoBasePath() + PathUtil.getVideoPath();
//    		System.out.println("realPathDir :" + realPathDir);
//    		File saveFile = new File(realPathDir);
//    		if(!saveFile.exists()) {
//    			saveFile.mkdirs();
//    		}
//    		String name = fileName.substring(0,fileName.lastIndexOf("."));
//    		System.out.println("文件名称 :" + name);
//
//    		//生成新的文件名;
//    		String newFileName = this.getName(fileName);
//
//    		//文件扩展名
//    		String fileEnd = this.getFileExt(fileName);
//
//    		//绝对路径
//    		String fileNameDirs = realPathDir + File.separator + newFileName + fileEnd;
//    		System.out.println("绝对路径:" + fileNameDirs);
//
//    		File fileDirs = new File(fileNameDirs);
//
//    		//转入文件
//    		try {
//    			multipartFile.transferTo(fileDirs);
//    		}catch(IllegalStateException e) {
//    			e.printStackTrace();
//    		}catch(IOException e) {
//    			e.printStackTrace();
//    		}
//
//    		//相对路径
//    		String videoAddr = PathUtil.getVideoPath() + newFileName + fileEnd;
//    		System.out.println("相对路径:" + videoAddr);
//    		video.setVideoAddr(videoAddr);
//    		return video;
//    	}else {
//    		return null;
//    	}
//    }
    
    /**
     * 判断是否为指定的上传文件类型;
     * @param fileName
     * @return
     */
	private boolean checkFileType(String fileName) {
		Iterator<String> type = Arrays.asList(allowFiles).iterator();
        while (type.hasNext()) {
            String ext = type.next();
            if (fileName.toLowerCase().endsWith(ext)) {
                return true;
            }
        }
        return false;
	}
	
    /**
     * 获取文件扩展名
     *
     * @return string
     */
    private String getFileExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 依据原始文件名生成新文件名
     * @return
     */
    private String getName(String fileName) {
        Iterator<String> type = Arrays.asList(allowFiles).iterator();
        int  randomNum = random.nextInt(89999)+10000;
        while (type.hasNext()) {
            String ext = type.next();
            if (fileName.contains(ext)) {
                String newFileName = fileName.substring(0, fileName.lastIndexOf(ext));
                String str = sdf.format(new Date());
                return newFileName+str+randomNum;
            }
        }
        return "";
    }
}
