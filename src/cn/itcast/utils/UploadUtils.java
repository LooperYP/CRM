package cn.itcast.utils;



import java.util.UUID;

public class UploadUtils {
	
	// 获得随机UUID文件名
	public static String generateRandonFileName(String fileName) {
		// 获得扩展名
		String ext = fileName.substring(fileName.lastIndexOf("."));
		return UUID.randomUUID().toString() + ext;
	}
	
	public static String subFileName(String fileName) {
		// 查找最后一个 \出现位置
		int index = fileName.lastIndexOf("\\");
		if (index == -1) {
			return fileName;
		}
		return fileName.substring(index + 1);
	}
	
	public static String generateRandomDir(String uuidFileName){
		int i = uuidFileName.hashCode();
		String hex = Integer.toHexString(i);
		int j=hex.length();
		for(int k=0;k<8-j;k++){
			hex="0"+hex;
		}
//		return "/"+hex.charAt(0)+"/"+hex.charAt(1)+"/"+hex.charAt(2)+"/"+hex.charAt(3)+"/"+hex.charAt(4)+"/"+hex.charAt(5)+"/"+hex.charAt(6)+"/"+hex.charAt(7);
		return "/"+hex.charAt(0)+"/"+hex.charAt(1)+"/"+hex.charAt(2);
	}
	
}
