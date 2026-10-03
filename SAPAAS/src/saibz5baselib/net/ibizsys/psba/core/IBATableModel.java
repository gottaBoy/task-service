package net.ibizsys.psba.core;



/**
 * 大数据库架构表架构
 * 
 * @author Administrator
 *
 */
public interface IBATableModel extends IBAModelBase, IBATable,IBATableRuntime {


	/**
	 * 注册数据列族
	 * 
	 * @param iBAColSet
	 */
	void registerBAColSet(IBAColSet iBAColSet)throws Exception;

	/**
	 * 注册数据列
	 * 
	 * @param iBAColumn
	 */
	void registerBAColumn(IBAColumn iBAColumn)throws Exception;

	/**
	 * 注册数据表实体
	 * 
	 * @param iBATableDE
	 */
	void registerBATableDE(IBATableDE iBATableDE)throws Exception;
	
	
	/**
	 * 注册数据表实体关系
	 * 
	 * @param iBATableDER
	 */
	void registerBATableDER(IBATableDER iBATableDER)throws Exception;
	

	
	/**
	 * 获取大数据表关系数量
	 * @return
	 */
	int getBATableDERCount();
	
	
	
	/**
	 * 获取大数据表关系对象（通过位置）
	 * @param nPos
	 * @return
	 */
	IBATableDER getBATableDERAt(int nPos)throws Exception;
	
	
	
	

}
