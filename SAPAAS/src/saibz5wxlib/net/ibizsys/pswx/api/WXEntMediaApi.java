package net.ibizsys.pswx.api;

import java.io.File;

import net.sf.json.JSONObject;

/**
 * 企业号素材接口
 * 
 * @author Enmaai
 */
public class WXEntMediaApi extends WXBaseApi {
	private static final String DownloadApiUrl = "https://qyapi.weixin.qq.com/cgi-bin/media/get";

	private static final String UploadApiUrl = "https://qyapi.weixin.qq.com/cgi-bin/media/upload";

	/**
	 * 下载多媒体文件
	 * 
	 * @param accessToken 票据
	 * @param mediaId 多媒体标识
	 * @param target 目标文件地址
	 * @return
	 * @throws Exception
	 */
	public static boolean downloadMedia(String accessToken, String mediaId, File target) throws Exception {
		return download(String.format("%1$s?access_token=%2$s&media_id=%3$s", DownloadApiUrl, accessToken, mediaId), null, target);
	}

	/**
	 * 上传多媒体文件
	 * 
	 * @param accessToken 票据
	 * @param type 文件类型<image,voice,video,file>
	 * @param file 文件
	 * @return
	 * @throws Exception
	 */
	public static JSONObject uploadImage(String accessToken, String type, File file) throws Exception {
		return upload(String.format("%1$s?access_token=%2$s&type=%3$s", UploadApiUrl, accessToken, type), file);
	}
}
