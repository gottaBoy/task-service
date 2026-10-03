package net.ibizsys.paas.data;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Clob;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.db.IDataColumn;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

/**
 * iBizSys 5.0 基础数据对象
 * 
 * @author lionlau
 *
 */
public class DataObject implements IDataObject {
	
	private static final Log log = LogFactory.getLog(DataObject.class);
	
	final public static Object EMPTY = new Object();

	private HashMap<String, Object> paramMap = null;
	private Object objParamMapLock = new Object();
	private IDataObject proxyDataObject = null;

	public DataObject() {

	}

	/**
	 * 代理数据对象
	 * 
	 * @param proxyDataObject
	 */
	public void proxy(IDataObject proxyDataObject) {
		this.proxyDataObject = proxyDataObject;
		this.onProxy(proxyDataObject);
	}

	/**
	 * 代理数据对象
	 * 
	 * @param proxyDataObject
	 */
	protected void onProxy(IDataObject proxyDataObject) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.IDataObject#reset()
	 */
	public void reset() {
		if (this.proxyDataObject != null) {
			this.proxyDataObject.reset();
		} else {
			synchronized(objParamMapLock){
				if (paramMap != null){
					paramMap.clear();
					paramMap = null;
				}
			}
			onReset();
		}
	}

	/**
	 * 在重置实体中调用
	 */
	protected void onReset() {

	}

	/**
	 * 从JSON 字符串中导出实体对象
	 * 
	 * @param jsonObject
	 * @return
	 */
	public static IDataObject fromJSONString(String strJSONString) throws Exception {
		JSONObject jsonObject = JSONObjectHelper.fromString(strJSONString);
		return fromJSONObject(jsonObject);
	}

	/**
	 * 从JSONObject导出实体对象
	 * 
	 * @param jsonObject
	 * @return
	 */
	public static IDataObject fromJSONObject(JSONObject jsonObject) throws Exception {
		return fromJSONObject(null, jsonObject);
	}

	/**
	 * 从JSONObject导出实体对象
	 * @param baseDataEntity 参数数据对象，不指定则进行新建
	 * @param jsonObject
	 * @return
	 */
	public static IDataObject fromJSONObject(IDataObject baseDataEntity, JSONObject jsonObject) throws Exception {
		return fromJSONObject(baseDataEntity,  jsonObject,false);
	}
	
	/**
	 * 从JSONObject导出实体对象
	 * @param baseDataEntity 参数数据对象，不指定则进行新建
	 * @param jsonObject
	 * @param bIgnoreException 忽略异常
	 * @return
	 */
	public static IDataObject fromJSONObject(IDataObject baseDataEntity, JSONObject jsonObject,boolean bIgnoreException) throws Exception {
		return fromJSONObject(baseDataEntity,  jsonObject,bIgnoreException,false);
	}
	
	/**
	 * 从JSONObject导出实体对象
	 * @param baseDataEntity 参数数据对象，不指定则进行新建
	 * @param jsonObject
	 * @param bIgnoreException 忽略异常
	 * @param bIgnoreArray 忽略数组，将数组转为字符串
	 * @return
	 */
	public static IDataObject fromJSONObject(IDataObject baseDataEntity, JSONObject jsonObject,boolean bIgnoreException,boolean bIgnoreArray) throws Exception {
		if (baseDataEntity == null) baseDataEntity = new DataObject();
		java.util.Iterator it = jsonObject.keys();
		while (it.hasNext()) {
			Object objKey = it.next();
			Object objValue = jsonObject.get(objKey.toString());

			try{
				if (objValue instanceof JSONNull) {
					baseDataEntity.set(objKey.toString(), null);
				} else if (objValue instanceof JSONArray) {
					if(bIgnoreArray){
						baseDataEntity.set(objKey.toString(), objValue.toString());
					}
					else{
						baseDataEntity.set(objKey.toString(), DataObjectList.fromJSONArray((JSONArray) objValue));
					}
				} else if (objValue instanceof JSONObject) {
					JSONObject jo = (JSONObject) objValue;
					if (jo.has("time")||jo.has("timestr")) {
						long lTime = 0l;
						if(jo.has("timestr")){
							lTime = Long.parseLong(jo.getString("timestr"));
						}
						else{
							lTime = jo.getLong("time");
						}
						java.sql.Timestamp date = new java.sql.Timestamp(lTime);
						baseDataEntity.set(objKey.toString(), date);
					} else {
						baseDataEntity.set(objKey.toString(), jo.toString());
					}
				} else {
					baseDataEntity.set(objKey.toString(), objValue);
				}
			}
			catch(Exception ex){
				if(bIgnoreException){
					continue;
				}
				throw ex;
			}
		}
		return baseDataEntity;
	}
	
	

	/**
	 * 从XmlNode导出实体对象
	 * @param baseDataEntity 数据对象
	 * @param xmlNode xml 节点
	 * @return
	 */
	public static IDataObject fromXmlNode(IDataObject baseDataEntity, XmlNode xmlNode) throws Exception {
		if (baseDataEntity == null) baseDataEntity = new DataObject();
		java.util.Iterator<String> keys = xmlNode.getAttributes();
		while (keys.hasNext()) {
			String strKey = keys.next();
			String strValue = xmlNode.getAttribute(strKey, null);
			baseDataEntity.set(strKey, strValue);
		}
		return baseDataEntity;
	}

	/**
	 * 判断实体中是否包含指定参数
	 * 
	 * @param strParamName
	 * @return
	 */
	public boolean contains(String strParamName) throws Exception {
		if (this.proxyDataObject != null) {
			return this.proxyDataObject.contains(strParamName);
		} else {
			if (strParamName == null){
				return false;
			}
			strParamName = strParamName.toUpperCase();
			synchronized(objParamMapLock){
				if (paramMap != null) {
					return paramMap.containsKey(strParamName);
				}
			}
			return false;
		}
	}

	/**
	 * 判断参数是否为空
	 * 
	 * @param strParamName
	 * @return
	 */
	public boolean isNull(String strParamName) throws Exception {
		if (this.proxyDataObject != null) {
			return this.proxyDataObject.isNull(strParamName);
		} else {
			strParamName = strParamName.toUpperCase();
			synchronized(objParamMapLock){
				if (paramMap != null) {
					Object objValue = paramMap.get(strParamName);
					return (objValue == null || objValue == EMPTY);
				}
			}
			return true;
		}
	}

	// /**
	// * 移除多个属性，属性使用 ; 或 | 分割
	// * @param strParamName 属性使用 ; 或 | 分割
	// */
	// final public void removeParams(String strParamName)throws Exception
	// {
	// if (this.proxyDataObject != null)
	// {
	// this.proxyDataObject.removeParams(strParamName);
	// }
	// else
	// {
	// String [] params = StringHelper.splitEx(strParamName) ;
	// if(params == null)return;
	// for(int i = 0;i<params.length;i++)
	// {
	// remove(params[i]);
	// }
	// }
	// }

	/**
	 * 删除参数
	 * 
	 * @param strParamName
	 */
	@Override
	public boolean remove(String strParamName) throws Exception {
		if (this.proxyDataObject != null) {
			return this.proxyDataObject.remove(strParamName);
		} else {
			if (StringHelper.length(strParamName) == 0) return false;
			strParamName = strParamName.toUpperCase();
			synchronized(objParamMapLock){
				if (paramMap != null) {
					return paramMap.remove(strParamName) != null;
				}
			}
			return false;
		}
	}

	/**
	 * 获取参数值
	 * 
	 * @param strParamName
	 * @return
	 */
	public Object get(String strParamName) throws Exception {
		if (this.proxyDataObject != null) {
			return this.proxyDataObject.get(strParamName);
		} else {
			String strParamName2 = strParamName.toUpperCase();
			synchronized(objParamMapLock){
				if (paramMap == null) {
					return null;
				}
				Object objValue = paramMap.get(strParamName2);
				if (objValue == EMPTY) return null;
				return objValue;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.IDataObject#set(java.lang.String, java.lang.Object)
	 */
	public void set(String strParamName, Object objParamValue) throws Exception {
		if (this.proxyDataObject != null) {
			this.proxyDataObject.set(strParamName, objParamValue);
		} else {
			if (StringHelper.isNullOrEmpty(strParamName)) return;
			strParamName = strParamName.toUpperCase();
			synchronized(objParamMapLock){
				if(paramMap == null){
					paramMap = new HashMap<String, Object>();
				}
				if (objParamValue == null) {
					paramMap.put(strParamName, EMPTY);
				} else {
					paramMap.put(strParamName, objParamValue);
				}
			}
		}
	}

	/**
	 * 获取参数的整数型值
	 * 
	 * @param iDataObject 数据对象
	 * @param strParamName
	 * @param nDefault
	 * @return
	 */
	final static public int getIntegerValue(IDataObject iDataObject, String strParamName, int nDefault) throws Exception {
		Object objValue = iDataObject.get(strParamName);
		if (objValue == null) {
			return nDefault;
		}

		if(objValue instanceof Integer)
			return (Integer)objValue;
		
		if (objValue instanceof Double) {
			return ((Double) objValue).intValue();
		}

		if (objValue instanceof BigDecimal) {
			return ((BigDecimal) objValue).intValue();
		}
		
		String strValue = objValue.toString();
		if(StringHelper.isNullOrEmpty(strValue))
			return nDefault;
		strValue = strValue.replace(",", "");
		return Integer.parseInt(strValue);
	}

	/**
	 * 获取值的对象值
	 * 
	 * @param objValue
	 * @return
	 * @throws Exception
	 */
	final static public Object getObjectValue(Object objValue) throws Exception {
		return objValue;
	}

	/**
	 * 转换对象值到整形值
	 * 
	 * @param objValue
	 * @return
	 * @throws Exception
	 */
	final static public Integer getIntegerValue(Object objValue) throws Exception {
		return getIntegerValue(objValue, null);
	}

	/**
	 * 转换对象值到整形值
	 * 
	 * @param objValue
	 * @param def
	 * @return
	 * @throws Exception
	 */
	final static public Integer getIntegerValue(Object objValue, Integer def) throws Exception {
		if (objValue == null) return def;

		if (objValue instanceof Integer) {
			return (Integer) objValue;
		}
		
		if (objValue instanceof Long) {
			return ((Long) objValue).intValue();
		}
		
		if (objValue instanceof Double) {
			return ((Double) objValue).intValue();
		}

		if (objValue instanceof BigDecimal) {
			return ((BigDecimal) objValue).intValue();
		}
		
		String strValue = objValue.toString();
		if (StringHelper.isNullOrEmpty(strValue)) return def;
		strValue = strValue.replace(",", "");
		return Integer.parseInt(strValue);
	}

	/**
	 * 获取数据对象指定属性浮点值
	 * 
	 * @param iDataObject
	 * @param strParamName
	 * @param fDefault
	 * @return
	 * @throws Exception
	 */
	final static public Float getFloatValue(IDataObject iDataObject, String strParamName, float fDefault) throws Exception {
		Object objValue = iDataObject.get(strParamName);
		if (objValue == null) {
			return fDefault;
		}
		try {
			
			if(objValue instanceof Float)
				return (Float)objValue;
			
			String strValue = objValue.toString();
			if(StringHelper.isNullOrEmpty(strValue))
				return fDefault;
			strValue = strValue.replace(",", "");
			return Float.parseFloat(strValue);
		} catch (Exception ex) {
			return fDefault;
		}
	}

	/**
	 * 转换对象值到浮点值
	 * 
	 * @param objValue
	 * @return
	 * @throws Exception
	 */
	final static public Float getFloatValue(Object objValue) throws Exception {
		if (objValue == null) return null;

		if (objValue instanceof Float) {
			return (Float) objValue;
		}

		String strValue = objValue.toString();
		if (StringHelper.isNullOrEmpty(strValue)) return null;
		strValue = strValue.replace(",", "");
		return Float.parseFloat(strValue);
	}

	/**
	 * 获取数据对象指定属性大数值
	 * 
	 * @param iDataObject
	 * @param strParamName
	 * @param fDefault
	 * @return
	 * @throws Exception
	 */
	final static public BigDecimal getBigDecimalValue(IDataObject iDataObject, String strParamName, BigDecimal fDefault) throws Exception {
		Object objValue = iDataObject.get(strParamName);
		if (objValue == null) {
			return fDefault;
		}
		try {
			if(objValue instanceof Double){
				return BigDecimal.valueOf((Double)objValue);
			}
			if(objValue instanceof Long){
				return BigDecimal.valueOf((Long)objValue);
			}
			String strValue = objValue.toString();
			if(StringHelper.isNullOrEmpty(strValue))
				return fDefault;
			strValue = strValue.replace(",", "");
			return BigDecimal.valueOf(Double.parseDouble(strValue));
		} catch (Exception ex) {
			return fDefault;
		}
	}
	
	
	/**
	 * 转换对象值到大整数值
	 * 
	 * @param objValue
	 * @return
	 * @throws Exception
	 */
	final static public BigDecimal getBigDecimalValue(Object objValue) throws Exception {
		if (objValue == null) return null;

		if(objValue instanceof BigDecimal){
			return (BigDecimal)objValue;
		}
		
		if (objValue instanceof Double) {
			return BigDecimal.valueOf((Double) objValue);
		}
		
		if (objValue instanceof Long) {
			return BigDecimal.valueOf((Long) objValue);
		}

		String strValue = objValue.toString();
		if (StringHelper.isNullOrEmpty(strValue)) return null;
		strValue = strValue.replace(",", "");
		return BigDecimal.valueOf(Double.parseDouble(strValue));
	}
	
	
	/**
	 * 获取数据对象指定属性大整数
	 * 
	 * @param iDataObject
	 * @param strParamName
	 * @param nDefault
	 * @return
	 * @throws Exception
	 */
	final static public BigInteger getBigIntegerValue(IDataObject iDataObject, String strParamName, BigInteger nDefault) throws Exception {
		Object objValue = iDataObject.get(strParamName);
		if (objValue == null) {
			return nDefault;
		}
		try {
			if(objValue instanceof Long){
				return BigInteger.valueOf((Long)objValue);
			}
			
			String strValue = objValue.toString();
			if(StringHelper.isNullOrEmpty(strValue))
				return nDefault;
			strValue = strValue.replace(",", "");
			return BigInteger.valueOf(Long.parseLong(strValue));
				
		} catch (Exception ex) {
			return nDefault;
		}
	}
	
	
	/**
	 * 转换对象值到大整数值
	 * 
	 * @param objValue
	 * @return
	 * @throws Exception
	 */
	final static public BigInteger getBigIntegerValue(Object objValue) throws Exception {
		if (objValue == null) return null;

		if(objValue instanceof BigInteger){
			return (BigInteger)objValue;
		}
		
		if (objValue instanceof Long) {
			return BigInteger.valueOf((Long) objValue);
		}

		String strValue = objValue.toString();
		if (StringHelper.isNullOrEmpty(strValue)) return null;
		strValue = strValue.replace(",", "");
		return BigInteger.valueOf(Long.parseLong(strValue));
	}

	/**
	 * 获取数据对象指定属性Double值
	 * 
	 * @param iDataObject
	 * @param strParamName
	 * @param fDefault
	 * @return
	 * @throws Exception
	 */
	final static public double getDoubleValue(IDataObject iDataObject, String strParamName, double fDefault) throws Exception {
		Object objValue = iDataObject.get(strParamName);
		if (objValue == null) {
			return fDefault;
		}
		try {
			if(objValue instanceof Double)
				return (Double)objValue;
			
			String strValue = objValue.toString();
			if(StringHelper.isNullOrEmpty(strValue))
				return fDefault;
			strValue = strValue.replace(",", "");
			return Double.parseDouble(strValue);
		} catch (Exception ex) {
			return fDefault;
		}
	}

	/**
	 * 转换对象值到Double值
	 * 
	 * @param objValue
	 * @return
	 * @throws Exception
	 */
	final static public Double getDoubleValue(Object objValue) throws Exception {
		if (objValue == null) return null;

		if (objValue instanceof Double) {
			return (Double) objValue;
		}

		String strValue = objValue.toString();
		if (StringHelper.isNullOrEmpty(strValue)) return null;
		strValue = strValue.replace(",", "");
		return Double.parseDouble(strValue);
	}

	/**
	 * 获取数据对象指定属性Long值
	 * 
	 * @param iDataObject
	 * @param strParamName
	 * @param nDefault
	 * @return
	 * @throws Exception
	 */
	final static public long getLongValue(IDataObject iDataObject, String strParamName, long nDefault) throws Exception {
		Object objValue = iDataObject.get(strParamName);
		if (objValue == null) {
			return nDefault;
		}
		try {
			if (objValue instanceof Long) return (Long) objValue;

			if (objValue instanceof Integer) {
				return ((Integer) objValue).longValue();
			}
			
			if (objValue instanceof Double) {
				return ((Double) objValue).longValue();
			}

			if (objValue instanceof BigDecimal) {
				return ((BigDecimal) objValue).longValue();
			}
			
			String strValue = objValue.toString();
			if(StringHelper.isNullOrEmpty(strValue))
				return nDefault;
			strValue = strValue.replace(",", "");
			return Long.parseLong(objValue.toString());
		} catch (Exception ex) {
			return nDefault;
		}
	}
	
	
	/**
	 * 获取数据对象指定属性Long值
	 * 
	 * @param objValue
	 * @param nDefault
	 * @return
	 * @throws Exception
	 */
	final static public Long getLongValue(Object objValue, Long nDefault) throws Exception {
		if (objValue == null) {
			return nDefault;
		}
		try {
			if (objValue instanceof Long) return (Long) objValue;

			if (objValue instanceof Integer) {
				return ((Integer) objValue).longValue();
			}
			
			if (objValue instanceof Double) {
				return ((Double) objValue).longValue();
			}

			if (objValue instanceof BigDecimal) {
				return ((BigDecimal) objValue).longValue();
			}
			
			String strValue = objValue.toString();
			if(StringHelper.isNullOrEmpty(strValue))
				return nDefault;
			strValue = strValue.replace(",", "");
			return Long.parseLong(objValue.toString());
		} catch (Exception ex) {
			return nDefault;
		}
	}
	

	/**
	 * 获取数据对象指定属性字符串值
	 * 
	 * @param iDataObject
	 * @param strParamName
	 * @param strDefault
	 * @return
	 * @throws Exception
	 */
	final static public String getStringValue(IDataObject iDataObject, String strParamName, String strDefault) throws Exception {
		Object objValue = iDataObject.get(strParamName);
		if (objValue == null) {
			return strDefault;
		}
		try {
			return getStringValue(objValue);
		} catch (Exception ex) {
			return strDefault;
		}
	}

	/**
	 * 转换对象值到字符串值
	 * 
	 * @param objValue
	 * @return
	 * @throws Exception
	 */
	final static public String getStringValue(Object objValue) throws Exception {
		return getStringValue(objValue, null);
	}

	/**
	 * 转换对象值到二进制值
	 * 
	 * @param objValue
	 * @param strDefault
	 * @return
	 * @throws Exception
	 */
	final static public String getStringValue(Object objValue, String strDefault) throws Exception {
		if (objValue == null) return strDefault;
		if (objValue instanceof String) return (String) objValue;
		return objValue.toString();
	}
	
	/**
	 * 转换对象值到字符串值
	 * 
	 * @param objValue
	 * @return
	 * @throws Exception
	 */
	final static public byte[] getBinaryValue(Object objValue) throws Exception {
		return getBinaryValue(objValue, null);
	}

	/**
	 * 转换对象值到字符串值
	 * 
	 * @param objValue
	 * @param strDefault
	 * @return
	 * @throws Exception
	 */
	final static public byte[] getBinaryValue(Object objValue, byte[] def) throws Exception {
		if (objValue == null) return def;
		if(objValue instanceof byte[]){
			return (byte[])objValue;
		}
		if (objValue instanceof String){
			return Base64Helper.decode((String) objValue);
		}
		return def;
	}

	/**
	 * 获取数据对象指定属性字符串值
	 * 
	 * @param iDataObject
	 * @param strParamName
	 * @param strDefault
	 * @return
	 * @throws Exception
	 */
	final static public String getClobValue(IDataObject iDataObject, String strParamName, String strDefault) throws Exception {
		Object objValue = iDataObject.get(strParamName);
		if (objValue == null) {
			return strDefault;
		}
		try {
			if (objValue instanceof java.sql.Clob) {
				boolean bFirst = true;
				Clob clob = (Clob) objValue;
				BufferedReader br = new BufferedReader(clob.getCharacterStream());
				String s = br.readLine();
				StringBuffer sb = new StringBuffer();
				while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
					if (bFirst)
						bFirst = false;
					else
						sb.append("\r\n");
					sb.append(s);
					s = br.readLine();
				}
				return sb.toString();
			} else
				return objValue.toString();
		} catch (Exception ex) {
			return strDefault;
		}
	}

	/**
	 * 获取数据对象指定属性时间值
	 * 
	 * @param iDataObject
	 * @param strParamName
	 * @param dtDefault
	 * @return
	 * @throws Exception
	 */
	final static public java.sql.Timestamp getTimestampValue(IDataObject iDataObject, String strParamName, java.sql.Timestamp dtDefault) throws Exception {
		Object objValue = iDataObject.get(strParamName);
		if (objValue == null) {
			return dtDefault;
		}
		try {
			return getTimestampValue(objValue);
		} catch (Exception ex) {
			return dtDefault;
		}
	}

	/**
	 * 转换对象值到时间值
	 * 
	 * @param objValue
	 * @return
	 * @throws Exception
	 */
	final static public java.sql.Timestamp getTimestampValue(Object objValue) throws Exception {
		if (objValue == null) return null;

		if (objValue instanceof java.sql.Timestamp) {
			java.sql.Timestamp ti = (java.sql.Timestamp) objValue;
			return ti;
		}

		if (objValue instanceof java.sql.Date) {
			java.sql.Date date = (java.sql.Date) objValue;
			return new java.sql.Timestamp(date.getTime());
		}

		if (objValue instanceof java.util.Date) {
			java.util.Date date = (java.util.Date) objValue;
			return new java.sql.Timestamp(date.getTime());
		}

		if (objValue instanceof String) {
			String strValue = (String) objValue;
			strValue = strValue.trim();
			if (StringHelper.isNullOrEmpty(strValue)) return null;

			java.util.Date date = DateHelper.parse((String) objValue);
			return new java.sql.Timestamp(date.getTime());
		}
		
		if(objValue instanceof Long)
		{
			Long lValue = (Long)objValue;
			return new  java.sql.Timestamp(lValue); 
		}
		
		if(objValue instanceof Integer)
		{
			int lValue = (int)objValue;
			return new  java.sql.Timestamp(lValue); 
		}
		
		throw new Exception(StringHelper.format("无法转换时间[%1$s]", objValue));
	}

	/**
	 * 获取数据对象指定属性数据对象值
	 * 
	 * @param iDataObject
	 * @param strParamName
	 * @return
	 * @throws Exception
	 */
	final static public DataObjectList getDataObjectsValue(IDataObject iDataObject, String strParamName) throws Exception {
		Object objValue = iDataObject.get(strParamName);
		if (objValue == null) {
			return null;
		}
		if (objValue instanceof DataObjectList) return (DataObjectList) objValue;
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.IDataObject#copyTo(net.ibizsys.paas.data.IDataObject, java.lang.String, boolean)
	 */
	@Override
	final public void copyTo(IDataObject dataEntity, String strParamNames, boolean bReset) throws Exception {
		if (this.proxyDataObject != null) {
			this.proxyDataObject.copyTo(dataEntity, strParamNames, bReset);

		} else {
			if (bReset) dataEntity.reset();
			strParamNames = strParamNames.replace(';', '|');
			strParamNames = strParamNames.replace(',', '|');
			String strParamName[] = strParamNames.split("[|]");
			int nCount = strParamName.length;
			for (int i = 0; i < nCount; i++) {
				if (this.contains(strParamName[i])) {
					dataEntity.set(strParamName[i], this.get(strParamName[i]));
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.IDataObject#copyTo(net.ibizsys.paas.data.IDataObject, boolean)
	 */
	@Override
	public void copyTo(IDataObject dataEntity, boolean bReset) throws Exception {
		copyTo(dataEntity, bReset, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.IDataObject#copyTo(net.ibizsys.paas.data.IDataObject, boolean, boolean)
	 */
	@Override
	public void copyTo(IDataObject dataEntity, boolean bReset, boolean bIncludeEmpty) throws Exception {
		if (this.proxyDataObject != null) {
			this.proxyDataObject.copyTo(dataEntity, bReset, bIncludeEmpty);

		} else {
			if (bReset){
				dataEntity.reset();
			}
			synchronized (objParamMapLock) {
				if(paramMap!=null){
					for (Entry<String, Object> entry: paramMap.entrySet()){
						Object objValue = entry.getValue();
						if (objValue == EMPTY) objValue = null;
						if (!bIncludeEmpty && objValue == null) continue;
						dataEntity.set(entry.getKey(), objValue);
					}
				}
			}
		}
	}

	/**
	 * 从数据行记录填充数据对象
	 * 
	 * @param iDataObject
	 * @param dr
	 * @param bReset 是否重置数据对象
	 * @throws Exception
	 */
	public static void fromDataRow(IDataObject iDataObject, IDataRow dr, boolean bReset) throws Exception {
		if (bReset) {
			iDataObject.reset();
		}

		IDataTable dataTable = dr.getDataTable();
		if(dataTable!=null){
			int nColumnCount = dataTable.getColumnCount();
			for (int i = 0; i < nColumnCount; i++) {
				IDataColumn dataColumn = dataTable.getDataColumn(i);
				if (dr.isDBNull(i)) {
					iDataObject.set(dataColumn.getName(), null);
				} else
					iDataObject.set(dataColumn.getName(), dr.get(i));
			}
		}
		else{
			if(dr instanceof IDataObject){
				IDataObject srcDataObject = (IDataObject)dr;
				srcDataObject.copyTo(iDataObject, true);
			}
			else{
				throw new Exception("无效的行数据对象");
			}
		}
		
	}

	/**
	 * 从数据行记录填充数据对象
	 * 
	 * @param iDataObject
	 * @param dr
	 * @throws Exception
	 */
	public static void fromDataRow(IDataObject iDataObject, IDataRow dr) throws Exception {
		fromDataRow(iDataObject, dr, true);
	}

	@Override
	public void fillMap(HashMap<String, Object> params) {
		synchronized(this.objParamMapLock){
			if(this.paramMap!=null){
				params.putAll(this.paramMap);
			}
		}
	}

	/**
	 * 导出为JSON对象
	 * 
	 * @param iDataObject
	 * @param bIncludeEmpty
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(IDataObject iDataObject, boolean bIncludeEmpty) throws Exception {
		JSONObject jsonObj = new JSONObject();
		iDataObject.fillJSONObject(jsonObj, bIncludeEmpty);
		return jsonObj;
	}
	
	/**
	 * 导出为JSON对象
	 * 
	 * @param iDataObject
	 * @param bDirtyOnly
	 * @param bIncludeEmpty
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(IDataObject iDataObject,boolean bDirtyOnly,boolean bIncludeEmpty) throws Exception {
		JSONObject jsonObj = new JSONObject();
		iDataObject.fillJSONObject(jsonObj,bDirtyOnly, bIncludeEmpty);
		return jsonObj;
	}
	
	
	/**
	 * 导出为JSON对象
	 * 
	 * @param iDataObject
	 * @param bIncludeEmpty
	 * @param jsonObj 
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(IDataObject iDataObject, boolean bIncludeEmpty,JSONObject jsonObj) throws Exception {
		if(jsonObj == null)
			jsonObj = new JSONObject();
		iDataObject.fillJSONObject(jsonObj, bIncludeEmpty);
		return jsonObj;
	}
	
	/**
	 * 导出为JSON对象
	 * 
	 * @param iDataObject
	 * @param bIncludeEmpty
	 * @param jsonObj 
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(IDataObject iDataObject, boolean bDirtyOnly,boolean bIncludeEmpty,JSONObject jsonObj) throws Exception {
		if(jsonObj == null)
			jsonObj = new JSONObject();
		iDataObject.fillJSONObject(jsonObj,bDirtyOnly,bIncludeEmpty);
		return jsonObj;
	}
	

	/**
	 * 转换JSON中的时间值到文本
	 * 
	 * @param jsonObject
	 * @param strTimeFormat 时间格式化
	 * @return
	 * @throws Exception
	 */
	public static JSONObject convertJSONValueTimeFmt(JSONObject jsonObject, String strTimeFormat) throws Exception {
		JSONObject newJsonObject = new JSONObject();
		java.util.Iterator it = jsonObject.keys();
		while (it.hasNext()) {
			Object objKey = it.next();
			Object objValue = jsonObject.get(objKey.toString());

			if (objValue instanceof JSONObject) {
				JSONObject jo = (JSONObject) objValue;

				if (jo.has("time")) {
					long lTime = jo.getLong("time");
					java.sql.Timestamp date = new java.sql.Timestamp(lTime);
					newJsonObject.put(objKey.toString(), StringHelper.format(strTimeFormat, date));
				} else {
					newJsonObject.put(objKey.toString(), jo);
				}
			} else {
				newJsonObject.put(objKey.toString(), objValue);
			}
		}
		return newJsonObject;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.IDataObject#fillJSONObject(net.sf.json.JSONObject, boolean)
	 */
	public void fillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
		if (this.proxyDataObject != null) {
			this.proxyDataObject.fillJSONObject(objJSON, bIncludeEmpty);
		} else {
			onFillJSONObject(objJSON, bIncludeEmpty);
		}
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.data.IDataObject#fillJSONObject(net.sf.json.JSONObject, boolean, boolean)
	 */
	@Override
	public void fillJSONObject(JSONObject objJSON, boolean bDirtyOnly, boolean bIncludeEmpty) throws Exception {
		if (this.proxyDataObject != null) {
			this.proxyDataObject.fillJSONObject(objJSON,bDirtyOnly, bIncludeEmpty);
		} else {
			onFillJSONObject(objJSON,bDirtyOnly,bIncludeEmpty);
		}
	}
	
	/**
	 * 在填充到JSON对象中调用
	 * 
	 * @param objJSON
	 * @param bIncludeEmpty
	 * @throws Exception
	 */
	protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
		synchronized(this.objParamMapLock){
			if (this.paramMap != null) {
				fillJSONObject(this.paramMap, objJSON, bIncludeEmpty);
			}
		}
	}
	
	
	
	/**
	 * 在填充到JSON对象中调用
	 * 
	 * @param objJSON
	 * @param bIncludeEmpty
	 * @throws Exception
	 */
	protected void onFillJSONObject(JSONObject objJSON, boolean bDirtyOnly,boolean bIncludeEmpty) throws Exception {
		synchronized(this.objParamMapLock){
			if (this.paramMap != null) {
				fillJSONObject(this.paramMap, objJSON, bIncludeEmpty);
			}
		}
	}
	

	

	/**
	 * 将Map填充至JSON对象中
	 * 
	 * @param paramMap
	 * @param objJSON
	 * @param bIncludeEmpty
	 * @throws Exception
	 */
	private static void fillJSONObject(HashMap<String, Object> paramMap, JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
		if (paramMap != null) {
			for (Entry<String, Object> entry: paramMap.entrySet()){
				Object objValue = entry.getValue();
				String objKey = entry.getKey();
				
				if (objKey == null || objValue == null) continue;

				if (objValue == EMPTY) {
					objValue = null;
					if (!bIncludeEmpty) continue;
				}

				try {
					if (objValue instanceof DataObjectList) {
						objJSON.put(objKey.toString().toLowerCase(), ((DataObjectList) objValue).toJSONArray(bIncludeEmpty));
					} else {
						objJSON.put(objKey.toString().toLowerCase(), getJSONValue(objValue));
					}
				} catch (Exception ex) {
					StringHelper.format("Object[%1$s][%2$s] to JSON Error！", objKey, objValue);
					objJSON.put(objKey.toString().toLowerCase(), objValue.toString());
				}
			}
		}
	}

	
	/**
	 * 获取json的值
	 * 
	 * @param objValue
	 * @return
	 * @throws Exception
	 */
	protected static Object getJSONValue(Object objValue) throws Exception {
		return getJSONValue(objValue,false);
	}
	/**
	 * 获取json的值
	 * 
	 * @param objValue
	 * @return
	 * @throws Exception
	 */
	protected static Object getJSONValue(Object objValue,boolean bStripQuotes) throws Exception {
		if (objValue == null) return JSONNull.getInstance();
		
		Long nValue  = null;
		if (objValue instanceof java.sql.Timestamp) {
			nValue = ((java.sql.Timestamp) objValue).getTime();
		}
		else if (objValue instanceof java.sql.Date) {
			nValue = ((java.sql.Date) objValue).getTime();
		} else 
		if (objValue instanceof java.util.Date) {
			nValue = ((java.util.Date) objValue).getTime();
		} else
		if (objValue instanceof byte[]) {
			return Base64Helper.encodeBytes((byte[])objValue);
		}
		else
		{
			if(bStripQuotes){
				return JSONObjectHelper.stripQuotes(objValue, true);
			}
			return objValue;
		}
		
		JSONObject dt = new JSONObject();
		if(nValue <0 ){
			/**
			 * JSON组件包有BUG
			 */
			dt.put("timestr",Long.toString(nValue));
		}
		else
			dt.put("time", nValue);
		return dt;
	}

	/**
	 * 导出为JSON字符串
	 * 
	 * @return
	 */
	public String toJSONString() throws Exception {
		return toJSONString(this, false);
	}

	/**
	 * 导出JSON字符
	 * 
	 * @param dataEntity
	 * @param bIncludeEmpty 是否包括空值
	 * @return
	 * @throws Exception
	 */
	public static String toJSONString(IDataObject dataEntity, boolean bIncludeEmpty) throws Exception {
		JSONObject jsonObj = new JSONObject();
		dataEntity.fillJSONObject(jsonObj, bIncludeEmpty);
		return jsonObj.toString();
	}

	/**
	 * 填充到XMLNode对象中
	 * 
	 * @param xmlNode
	 * @param bIncludeEmpty
	 */
	public void fillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
		if (this.proxyDataObject != null) {
			this.proxyDataObject.fillXmlNode(xmlNode, bIncludeEmpty);
		} else {
			onFillXmlNode(xmlNode, bIncludeEmpty);
		}
	}

	/**
	 * 在填充到Xml对象中调用
	 * 
	 * @param xmlNode
	 * @param bIncludeEmpty
	 * @throws Exception
	 */
	protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
		synchronized(this.objParamMapLock){
			if (this.paramMap != null) {
				fillXmlNode(this.paramMap, xmlNode, bIncludeEmpty);
			}
		}
		
	}

	/**
	 * 将Map填充至JSON对象中
	 * 
	 * @param paramMap
	 * @param xmlNode
	 * @param bIncludeEmpty
	 * @throws Exception
	 */
	private static void fillXmlNode(HashMap<String, Object> paramMap, XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
		if (paramMap != null) {
			for (Entry<String, Object> entry: paramMap.entrySet()){
				Object objValue = entry.getValue();
				String objKey = entry.getKey();
				if (objKey == null || objValue == null) continue;

				if (objValue == EMPTY) {
					objValue = null;
					if (!bIncludeEmpty) continue;
				}

				if (objValue == null)
					xmlNode.setAttribute(objKey, "");
				else {
					xmlNode.setAttribute(objKey, objValue.toString());
				}
			}
		}
	}

	/**
	 * 获取数据对象指定属性布尔值
	 * 
	 * @param iDataObject
	 * @param strParamName
	 * @param bDefault
	 * @return
	 */
	final static public Boolean getBoolValue(IDataObject iDataObject, String strParamName, Boolean bDefault) throws Exception {
		Object objValue = iDataObject.get(strParamName);
		if (objValue == null) {
			return bDefault;
		}
		try {
			String strValueString = objValue.toString();
			if (StringHelper.compare(strValueString, "TRUE", true) == 0) return true;
			if (StringHelper.compare(strValueString, "1", true) == 0) return true;
			return Boolean.parseBoolean(strValueString);
		} catch (Exception ex) {
			return bDefault;
		}
	}

	/**
	 * 获取Boolean 值
	 * 
	 * @param nValue
	 * @param bDefault
	 * @return
	 */
	public static boolean getBoolValue(Integer nValue, boolean bDefault) {
		if (nValue == null) return bDefault;
		return nValue == 1;
	}
	
	
	/**
	 * 获取Boolean 值
	 * 
	 * @param objValue
	 * @param bDefault
	 * @return
	 */
	public static boolean getBoolValue(Object objValue, boolean bDefault) {
		if (objValue == null) {
			return bDefault;
		}
		try {
			String strValueString = objValue.toString();
			if (StringHelper.compare(strValueString, "TRUE", true) == 0) return true;
			if (StringHelper.compare(strValueString, "1", true) == 0) return true;
			return Boolean.parseBoolean(strValueString);
		} catch (Exception ex) {
			return bDefault;
		}
	}
}
