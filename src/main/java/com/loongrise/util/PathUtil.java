package com.loongrise.util;
/**
 * 路径工具类
 * @author yy
 *
 */
public class PathUtil {
	
	//获取OS文件路径的分隔符
	private static String separator = System.getProperty("file.separator");
	
	/**
	 * 获取存储图片的根路径
	 * @return
	 */
	public static String getImgBasePath() {
		//获取操作系统的名称
		String os = System.getProperty("os.name");
		String basePath = "";
		if(os.toLowerCase().startsWith("win")) {
			basePath = "D:/yoga/image";
		}else {
			basePath ="/home/yy/image";
		}
		basePath = basePath.replace("/",separator);
		return basePath;
	}
	
	/**
	 * 获取存储视频的根路径
	 * @return
	 */
	public static String getVideoBasePath() {
		//获取操作系统的名称
		String os = System.getProperty("os.name");
		String basePath = "";
		if(os.toLowerCase().startsWith("win")) {
			basePath = "D:/yoga/video";
		}else {
			basePath ="/home/yy/video";
		}
		basePath = basePath.replace("/",separator);
		return basePath;
	}
	
	/**
	 * 获取视频的相对路径;
	 * @return
	 */
	public static String getVideoPath() {
		String imagePath = "/uploadVideo/item/" ;
		return imagePath.replace("/",separator);
	}
	
	
	/**
	 * 获取用户头像的相对路径
	 * @param personId
	 * @return
	 */
	public static String getPersonImgPath(long personId) {
		String imagePath = "/upload/item/person/" + personId + "/" ;
		return imagePath.replace("/",separator);
	}
	
	/**
	 * 获取瑜伽馆缩略图及详情图的相对路径
	 * @param hallId
	 * @return
	 */
	public static String getHallDetailImgPath(long hallId) {
		String imagePath = "/upload/item/hall/" + hallId + "/" ;
		return imagePath.replace("/",separator);
	}
	
	public static String getVideoThumbnailPath(long videoId) {
		String imagePath = "/upload/item/video/"+videoId+"/";
		return imagePath.replace("/",separator);
	}
}
