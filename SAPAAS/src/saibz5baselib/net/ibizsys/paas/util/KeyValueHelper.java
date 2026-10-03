package net.ibizsys.paas.util;

import java.rmi.server.UID;
import java.security.MessageDigest;
import java.util.UUID;

import net.ibizsys.paas.service.ServiceBase;

/**
 * 主键辅助对象
 * 
 * @author Administrator
 * 
 */
public final class KeyValueHelper {
	public KeyValueHelper() {
	}

	private static Integer nGlobalId = 0;

	/**
	 * 新建一个UID
	 * 
	 * @return
	 */
	final public static String genGuid() {
		UID uid = new UID();
		String strId = "uid_" + uid.toString();
		strId = strId.replace(":", "");
		strId = strId.replace("-", "");
		return strId;
		// return strGuid;
	}

	/**
	 * 新建一个GUID
	 * 
	 * @return
	 */
	final public static String genGuidEx() {
		UUID idOne = UUID.randomUUID();
		return idOne.toString().toUpperCase();
	}

	final private static String convertToHex(byte[] data) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			int halfbyte = (data[i] >>> 4) & 0x0F;
			int two_halfs = 0;
			do {
				if ((0 <= halfbyte) && (halfbyte <= 9))
					buf.append((char) ('0' + halfbyte));
				else
					buf.append((char) ('a' + (halfbyte - 10)));
				halfbyte = data[i] & 0x0F;
			} while (two_halfs++ < 1);
		}
		return buf.toString();
	}

	/**
	 * 获取指定文本的MD5字符串
	 * 
	 * @param text
	 * @return
	 */
	final public static String genMD5(String text) {
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("MD5");
			byte[] md5hash = new byte[32];
			// md.update(text.getBytes("iso-8859-1"), 0, text.length());
			md.update(text.getBytes("iso-8859-1"), 0, text.length());
			md5hash = md.digest();
			return convertToHex(md5hash);
		} catch (Exception ex) {
			return "";
		}
	}

	/**
	 * 获取指定文本的MD5字符串
	 * 
	 * @param text
	 * @return
	 */
	final public static String genMD5Ex(String text) {
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("MD5");
			byte[] md5hash = new byte[32];
			// md.update(text.getBytes("iso-8859-1"), 0, text.length());
			md.update(text.getBytes("utf-8"));
			md5hash = md.digest();
			return convertToHex(md5hash);
		} catch (Exception ex) {
			return "";
		}
	}

	/**
	 * 获取当前的时间
	 * 
	 * @return
	 */
	final public static long curTime() {
		return (new java.util.Date()).getTime();
	}

	/**
	 * 产生唯一标识
	 * 
	 * @param strSrc1
	 * @return
	 */
	final public static String genUniqueId(String strSrc1) {
		return genMD5Ex(strSrc1);
	}

	/**
	 * 产生唯一标识
	 * 
	 * @param strSrc1
	 * @param strSrc2
	 * @return
	 */
	final public static String genUniqueId(String strSrc1, String strSrc2) {
		return genMD5Ex(StringHelper.format("%1$s||%2$s", strSrc1, strSrc2));
	}

	/**
	 * 产生唯一标识
	 * 
	 * @param strSrc1
	 * @param strSrc2
	 * @param strSrc3
	 * @return
	 */
	final public static String genUniqueId(String strSrc1, String strSrc2, String strSrc3) {
		return genMD5Ex(StringHelper.format("%1$s||%2$s||%3$s", strSrc1, strSrc2, strSrc3));
	}

	/**
	 * 产生唯一标识
	 * 
	 * @param strSrc1
	 * @param strSrc2
	 * @param strSrc3
	 * @param strSrc4
	 * @return
	 */
	final public static String genUniqueId(String strSrc1, String strSrc2, String strSrc3, String strSrc4) {
		return genMD5Ex(StringHelper.format("%1$s||%2$s||%3$s||%4$s", strSrc1, strSrc2, strSrc3, strSrc4));
	}

	/**
	 * 产生唯一标识
	 * 
	 * @param strSrc1
	 * @param strSrc2
	 * @param strSrc3
	 * @param strSrc4
	 * @param strSrc5
	 * @return
	 */
	final public static String genUniqueId(String strSrc1, String strSrc2, String strSrc3, String strSrc4, String strSrc5) {
		return genMD5Ex(StringHelper.format("%1$s||%2$s||%3$s||%4$s||%5$s", strSrc1, strSrc2, strSrc3, strSrc4, strSrc5));
	}

	/**
	 * 产生唯一标识
	 * 
	 * @param strSrc1
	 * @param strSrc2
	 * @param strSrc3
	 * @param strSrc4
	 * @param strSrc5
	 * @param strSrc6
	 * @return
	 */
	final public static String genUniqueId(String strSrc1, String strSrc2, String strSrc3, String strSrc4, String strSrc5, String strSrc6) {
		return genMD5Ex(StringHelper.format("%1$s||%2$s||%3$s||%4$s||%5$s||%6$s", strSrc1, strSrc2, strSrc3, strSrc4, strSrc5, strSrc6));
	}

	/**
	 * 是否为临时主键
	 * 
	 * @param strKeyValue
	 * @return
	 */
	final public static boolean isTempKey(String strKeyValue) {
		return strKeyValue.indexOf(ServiceBase.TEMPKEY) == 0;
	}
}
