package com.loongrise.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.loongrise.util.PathUtil;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * 图片工具类
 * @author yy
 *
 */
public class ImageUtil {
	
	
	private static final Random random = new Random();
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	
	//获取classPath路径
	private static final String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	/**
	 * 将CommonsMultipartFile 转换为 file文件,service层的测试
	 * @param cFile
	 * @return
	 */
	public static File transferCommonsMultipartFiletoFile(CommonsMultipartFile cFile) {
		File newFile = new File(cFile.getOriginalFilename());
		try {
			//转换
			cFile.transferTo(newFile);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return newFile;
	}
	
	/**
	 * 处理图片，并返回图片新生成的相对路径
	 * @param thumbnail
	 * @param targetAddr
	 * @return
	 */
	public static String generateThumbnail(ImageHolder thumbnail,String targetAddr) {
		//生成随机文件名;
		String realFileName = getRandomFileName();
		//获取用户上传图片的扩展名
		String extension = getFileExtensionName(thumbnail.getImageName());
		makeDir(targetAddr);
				
		//上传图片的相对路径
		String relativeAddr = targetAddr + realFileName + extension;
		
		//最后生成 的文件
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		
		try {
			Thumbnails.of(thumbnail.getImage()).size(50,60)
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath+"/watermark.jpg")), 0.2f)
			.outputQuality(0.8f).toFile(dest);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return relativeAddr;
	}
	
	/**
	 *	处理 视频缩略图地方;
	 * @param thumbnail
	 * @param targetAddr
	 * @return
	 */
	public static String generateVideoThumbnail(ImageHolder thumbnail,String targetAddr) {
		//生成随机文件名;
		String realFileName = getRandomFileName();
		//获取用户上传图片的扩展名
		String extension = getFileExtensionName(thumbnail.getImageName());
		makeDir(targetAddr);
				
		//上传图片的相对路径
		String relativeAddr = targetAddr + realFileName + extension;
		
		//最后生成 的文件
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		
		try {
			Thumbnails.of(thumbnail.getImage()).size(640,400)
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath+"/watermark.jpg")), 0.2f)
			.outputQuality(0.8f).toFile(dest);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return relativeAddr;
	}
	
	/**
	 * 处理 会馆缩略图/详情图片
	 * @param thumbnail
	 * @param targetAddr
	 * @return
	 */
	public static String generateHallThumbnail(ImageHolder thumbnail,String targetAddr) {
		//生成随机文件名;
		String realFileName = getRandomFileName();
		//获取用户上传图片的扩展名
		String extension = getFileExtensionName(thumbnail.getImageName());
		makeDir(targetAddr);
				
		//上传图片的相对路径
		String relativeAddr = targetAddr + realFileName + extension;
		
		//最后生成 的文件
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		
		try {
			Thumbnails.of(thumbnail.getImage()).size(270,270)
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath+"/watermark.jpg")), 0.2f)
			.outputQuality(0.8f).toFile(dest);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return relativeAddr;
	}
	
	
	
	/**
	 * 创建目标路径所涉及到的目录
	 * @param targetAddr
	 */
	private static void makeDir(String targetAddr) {
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath =  new File(realFileParentPath);
		if(!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}

	/**
	 * 获取上传文件的扩展名
	 * @param name
	 * @return
	 */
	private static String getFileExtensionName(String name) {
		return name.substring(name.lastIndexOf("."));
	}
	
	/**
	 * 生成随机文件名
	 * @return
	 */
	private static String getRandomFileName() {
		//获取随机的五位数;
		int  randomNum = random.nextInt(89999)+10000;
				
		String nowTimeStr = sdf.format(new Date());
		return nowTimeStr+randomNum;
	}
	
	/**
	 * 删除路径或文件
	 * @param profileImg
	 */
	public static void deleteFileOrPath(String profileImg) {
		File fileOrPath = new File(PathUtil.getImgBasePath() + profileImg);
		if(fileOrPath.exists()) {
			if(fileOrPath.isDirectory()) {
				File[] files = fileOrPath.listFiles();
				for(int i = 0; i < files.length; i++) {
					files[i].delete();
				}
			}
			fileOrPath.delete();
		}
	} 
	
	
}
