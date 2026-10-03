package net.ibizsys.paas.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 对象辅助对象
 * 
 * @author Administrator
 *
 */
public class ObjectHelper {
	private static final Log log = LogFactory.getLog(ObjectHelper.class);

	/**
	 * 建立对象
	 * 
	 * @param strType
	 * @return
	 * @throws Exception
	 */
	public static Object create(String strType) throws Exception {
		return Class.forName(strType).newInstance();
	}

	/**
	 * 建立对象
	 * 
	 * @param classType (对象类别）
	 * @return
	 */
	public static Object create(Class classType) throws Exception {
		return classType.newInstance();
	}

	/**
	 * 对象转数组
	 * 
	 * @param obj
	 * @return
	 */
	public byte[] toByteArray(Object obj) throws Exception {
		byte[] bytes = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			oos.flush();
			bytes = bos.toByteArray();
			oos.close();
			bos.close();
		} catch (IOException ex) {
			if (oos != null) oos.close();
			bos.close();
			throw ex;
		}
		return bytes;
	}

	/**
	 * 数组转对象
	 * 
	 * @param bytes
	 * @return
	 */
	public Object toObject(byte[] bytes) throws Exception {
		Object obj = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			bis = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bis);
			obj = ois.readObject();
			ois.close();
			bis.close();
		} catch (IOException ex) {
			if (ois != null) ois.close();
			if (bis != null) bis.close();
			throw ex;
		} catch (ClassNotFoundException ex) {
			if (ois != null) ois.close();
			if (bis != null) bis.close();
			throw ex;
		}
		return obj;
	}
}
