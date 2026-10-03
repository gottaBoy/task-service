package net.ibizsys.psba.core;

import net.ibizsys.paas.core.IDataEntity;

/**
 * 大数据库架构表实体接口
 * 
 * @author Administrator
 *
 */
public interface IBATableDE extends IBATableObject {

	/**
	 * 默认实体
	 */
	final static int BATABLEDETYPE_DEFAULT = 1;
	
	
	/**
	 * 关系主实体
	 */
	final static int BATABLEDETYPE_MAJOR = 2;
	
	
	
	/**
	 * 关系从实体
	 */
	final static int BATABLEDETYPE_MINOR = 3;
	
	
	/**
	 * 附属实体
	 */
	final static int BATABLEDETYPE_RELATED = 0;
	
	
	/**
	 * 获取大数据表实体类型
	 * @return
	 */
	int getBATableDEType();
	
	/**
	 * 获取实体模型
	 * 
	 * @return
	 */
	IDataEntity getDataEntity();

	
	
	/**
	 * 获取默认列族名称
	 * @return
	 */
	String getBAColSetName();
	
	
	
	
	/**
	 * 获取行键值格式化
	 * @return
	 */
	String getRowKeyFormat();
	
	
	
	
	
	/**
	 * 获取行键值格式化参数，使用 ; 分隔
	 * @return
	 */
	String getRowKeyParams();
}
