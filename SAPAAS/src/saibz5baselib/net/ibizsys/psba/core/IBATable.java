package net.ibizsys.psba.core;

/**
 * 大数据库架构表架构
 * 
 * @author Administrator
 *
 */
public interface IBATable extends IBASchemeObject {

	/**
	 * 系统保留的创建信息列族
	 */
	public final static String COLSET_CREATEINFO = "CREATEINFO";
	
	/**
	 * 系统保留的更新信息列族
	 */
	public final static String COLSET_UPDATEINFO = "UPDATEINFO";
	
	/**
	 * 系统保留的创建时间列
	 */
	public final static String COL_CREATEINFO_CREATEDATE = "SRFCREATEDATE";
	
	/**
	 * 系统保留的更新时间列
	 */
	public final static String COL_UPDATEINFO_UPDATEDATE = "SRFUPDATEDATE";
	
	/**
	*主实体
	*/
	final static int BATABLETYPE_MAJOR = 1 ;

	/**
	*关系实体
	*/
	final static int BATABLETYPE_RELATED = 3 ;

	/**
	*继承从实体
	*/
	final static int BATABLETYPE_INHERIT = 9 ;
	
	
	
	/**
	 * 获取大数据表类型
	 * @return
	 */
	int getBATableType();
	
	
	/**
	 * 获取表模型中的列族模型集合
	 * 
	 * @return
	 */
	java.util.Iterator<IBAColSet> getBAColSets();

	/**
	 * 获取表模型中的列模型集合
	 * 
	 * @return
	 */
	java.util.Iterator<IBAColumn> getBAColumns();

	/**
	 * 获取对应的表实体模型对象
	 * 
	 * @param strDEName
	 * @return
	 * @throws Exception
	 */
	IBATableDE getBATableDE(String strDEName) throws Exception;
	
	
	
	/**
	 * 获取大数据表实体集合
	 * @return
	 */
	java.util.Iterator<IBATableDE> getBATableDEs();
	
	
	/**
	 * 获取对应的表实体模型对象
	 * 
	 * @param strDEName
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	IBATableDE getBATableDE(String strDEName,boolean bTryMode) throws Exception;

	/**
	 * 获取指定列族对象
	 * 
	 * @param strBAColSetName
	 * @return
	 * @throws Exception
	 */
	IBAColSet getBAColSet(String strBAColSetName) throws Exception;

	/**
	 * 获取指定列对象
	 * 
	 * @param strBAColumnId
	 * @return
	 * @throws Exception
	 */
	IBAColumn getBAColumn(String strBAColumnId) throws Exception;
	
	
	/**
	 * 获取指定列对象
	 * @param strBAColSetId
	 * @param strBAColumnId
	 * @return
	 * @throws Exception
	 */
	IBAColumn getBAColumn(String strBAColSetId,String strBAColumnId) throws Exception;
	
	
	/**
	 * 获取指定大数据实体关系对象
	 * @param strDERName
	 * @return
	 * @throws Exception
	 */
	IBATableDER getBATableDER(String strDERName) throws Exception ;
}
