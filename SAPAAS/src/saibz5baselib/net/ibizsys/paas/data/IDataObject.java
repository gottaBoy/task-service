package net.ibizsys.paas.data;

import java.util.HashMap;

import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;

/**
 * 数据对象接口
 * 
 * @author lionlau
 *
 */
public interface IDataObject extends ISimpleDataObject {
	
	/**
	 * 设置属性
	 * 
	 * @param strParamName
	 * @param objValue
	 */
	void set(String strParamName, Object objValue) throws Exception;

	/**
	 * 删除属性
	 * 
	 * @param strParamName
	 */
	boolean remove(String strParamName) throws Exception;

	// /**
	// * 删除多参数
	// * @param strParamName
	// */
	// void removeParams(String strParamName)throws Exception;

	/**
	 * 重置全部属性
	 */
	void reset();

	/**
	 * 指定属性复制至指定数据对象（支持多个参数进行复制，参数之间可使用 ';'、','、'|' 进行分割
	 * 
	 * @param dataEntity
	 * @param strParamNames
	 * @param bReset
	 */
	void copyTo(IDataObject dataEntity, String strParamNames, boolean bReset) throws Exception;

	/**
	 * 是否存在指定参数
	 * 
	 * @param strParamName
	 * @return
	 * @throws Exception
	 */
	boolean contains(String strParamName) throws Exception;

	/**
	 * 填充到Map中
	 * 
	 * @param params
	 */
	void fillMap(HashMap<String, Object> params) throws Exception;

	/**
	 * 填充JSON对象
	 * 
	 * @param objJSON
	 * @param bIncludeEmpty
	 */
	void fillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception;
	
	/**
	 * 填充JSON对象，支持设置是否只导出被修改的值
	 * 
	 * @param objJSON
	 * @param bDirtyOnly 是否只导出修改值
	 * @param bIncludeEmpty
	 */
	void fillJSONObject(JSONObject objJSON, boolean bDirtyOnly,boolean bIncludeEmpty) throws Exception;
	

	/**
	 * 填充到XMLNode对象中
	 * 
	 * @param xmlNode
	 * @param bIncludeEmpty
	 */
	void fillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception;

	/**
	 * 复制至指定数据对象
	 * 
	 * @param dataEntity
	 * @param bReset
	 */
	void copyTo(IDataObject dataEntity, boolean bReset) throws Exception;

	/**
	 * 复制至指定数据对象
	 * 
	 * @param dataEntity
	 * @param bReset
	 * @param bIncludeEmpty 包括空值
	 */
	void copyTo(IDataObject dataEntity, boolean bReset, boolean bIncludeEmpty) throws Exception;

	/**
	 * 代理数据对象
	 * 
	 * @param proxyDataObject
	 */
	void proxy(IDataObject proxyDataObject);

}
