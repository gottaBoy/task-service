package net.ibizsys.psba.core;


/**
 * 大数据库架构表实体关系接口
 * 
 * @author Administrator
 *
 */
public interface IBATableDER extends IBATableObject {

	/**
	 * 获取主实体名称
	 * @return
	 */
	String getMajorDEName();

	
	/**
	 * 获取主实体名称
	 * @return
	 */
	String getMinorDEName();
	
	
	
	/**
	 * 获取实体关系属性名称
	 * @return
	 */
	String getDERFieldName();
}
