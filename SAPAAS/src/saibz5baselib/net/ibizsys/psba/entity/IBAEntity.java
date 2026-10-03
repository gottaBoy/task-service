package net.ibizsys.psba.entity;

import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.psba.dao.BASelectContext;

/**
 * 大数据体系数据对象
 * @author Administrator
 *
 */
public interface IBAEntity extends IEntity ,IBAEntityActionSupporter{


	
	/**
	 * 获取行记录值
	 * @return
	 */
	String getRowKey();
	
	
	
	/**
	 * 设置行键值
	 * @param strRowKey
	 */
	void setRowKey(String strRowKey);
	
	
	/**
	 * 获取数据创建时间
	 * @return
	 */
	java.sql.Timestamp getCreateDate();
	
	
	
	/**
	 * 设置创建时间
	 * @param createDate
	 */
	void setCreateDate(java.sql.Timestamp createDate);
	
	/**
	 * 获取数据更新时间
	 * @return
	 */
	java.sql.Timestamp getUpdateDate();
	
	
	
	/**
	 * 设置更新时间
	 * @param updateDate
	 */
	void setUpdateDate(java.sql.Timestamp updateDate);
	
	
	/**
	 * 获取列族数据
	 * @param strFamily
	 * @return
	 */
	ISimpleDataObject getFamily(String strFamily) throws Exception;
	
	
	
	/**
	 * 获取列族数据
	 * @param strFamily
	 * @param bCreateIfNotExists
	 * @return
	 */
	ISimpleDataObject getFamily(String strFamily,boolean bCreateIfNotExists) throws Exception;
	
	
	/**
	 * 设置列族数据
	 * @param strFamily
	 * @param iEntity
	 */
	void setFamily(String strFamily,ISimpleDataObject iEntity);
	
	/**
	 * 获取列族名称集合
	 * @return
	 */
	java.util.Iterator<String> getFamilyNames();
	
	
	
	/**
	 * 获取子数据
	 * @param strChildName
	 * @return
	 * @throws Exception
	 */
	java.util.ArrayList<IBAEntity> children(String strChildName)throws Exception;
	
	
	
	/**
	 * 获取子数据
	 * @param strChildName
	 * @param iBASelectContext 
	 * @return
	 * @throws Exception
	 */
	java.util.ArrayList<IBAEntity> children(String strChildName,BASelectContext iBASelectContext)throws Exception;
	
	
	
	
	/**
	 * 设置属性
	 * @param strFamily 列族
	 * @param strParamName
	 * @param objValue
	 */
	void set(String strFamily,String strParamName, Object objValue) throws Exception;
	
	
	/**
	 * 设置属性
	 * @param strFamily 列族
	 * @param strParamName
	 * @param objValue
	 * @param nTimestamp
	 */
	void set(String strFamily,String strParamName, Object objValue,long nTimestamp) throws Exception;
	
	
	
	
	/**
	 * 获取属性值
	 * @param strFamily 列族
	 * @param strParamName
	 * @return
	 */
	Object get(String strFamily,String strParamName) throws Exception;

	/**
	 * 判断参数是否为空
	 * @param strFamily 列族
	 * @param strParamName
	 * @return
	 */
	boolean isNull(String strFamily,String strParamName) throws Exception;

	/**
	 * 判断是否存在指定参数
	 * @param strFamily 列族
	 * @param strParamName
	 * @return
	 * @throws Exception
	 */
	boolean contains(String strFamily,String strParamName) throws Exception; 
	
	
	
	/**
	 * 获取大数据列历史对象
	 * @param strFamily
	 * @param strParamName
	 * @return
	 * @throws Exception
	 */
	IBAColumnHistory getBAColumnHistory(String strFamily,String strParamName) throws Exception;
	
}
