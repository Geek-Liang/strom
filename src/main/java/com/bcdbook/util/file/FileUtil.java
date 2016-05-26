package com.bcdbook.util.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
     * @Title: FileUtil.java    
     * @Description: 用于文件处理的工具类
     * @author lason       
     * @created 2016年5月24日 下午8:27:12
 */
public class FileUtil {
	/**
	 * 
	    * @Discription 根据传入的路径返回对应文件的字符串
	    * @author lason       
	    * @created 2016年5月24日 下午8:27:57     
	    * @param path
	    * @return
	 */
	public String readJson(String path){
		// 从给定位置获取文件
		File file = new File(path);
		BufferedReader reader = null;
		// 返回值,使用StringBuffer
		StringBuffer data = new StringBuffer();
		//
		try {
			reader = new BufferedReader(new FileReader(file));
			// 每次读取文件的缓存
			String temp = null;
			while ((temp = reader.readLine()) != null) {
				data.append(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭文件流
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data.toString();
	}
}
