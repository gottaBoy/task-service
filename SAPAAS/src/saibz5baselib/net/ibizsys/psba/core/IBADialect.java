package net.ibizsys.psba.core;

import java.util.ArrayList;
import java.util.List;

import net.ibizsys.psba.dao.IBAAsyncSelectHandler;
import net.ibizsys.psba.dao.IBASelectContext;
import net.ibizsys.psba.entity.IBAEntity;

/**
 * 大数据体系数据库访问设配器
 * 
 * @author Administrator
 *
 */
public interface IBADialect  {

	/**
	 * 获取大数据架构类型
	 * @return
	 */
	String getBAType();
	
	/**
	 * 获取数据库的函数
	 * 
	 * @param strFuncType
	 * @param args
	 * @return
	 * @throws Exception
	 */
	Object getFuncValue(String strFuncType, String[] args) throws Exception;

	/**
	 * 获取数据库的函数
	 * 
	 * @param strFuncType
	 * @param 插入使用
	 * @param 列名称
	 * @return
	 * @throws Exception
	 */
	Object getFuncValue(String strFuncType, boolean bInsert, String[] args) throws Exception;

	/**
	 * 安装大数据库
	 * 
	 * @param connection
	 * @param iBAScheme
	 * @throws Exception
	 */
	void install(Object connection, IBAScheme iBAScheme) throws Exception;

	/**
	 * 执行建立数据命令
	 * 
	 * @param iBACallContext
	 * @param connection 数据库连接
	 * @param columnsMap 建立的Map集合
	 * @param et
	 * @param families
	 * @return
	 * @throws Exception
	 */
	void executeCreateCmd(IBACallContext iBACallContext, Object connection, java.util.Map<IBAColumn, Object> columnsMap, IBAEntity et, String[] families) throws Exception;

	/**
	 * 执行更新数据命令
	 * 
	 * @param iBACallContext
	 * @param connection 数据库连接
	 * @param columnsMap 建立的Map集合
	 * @param et
	 * @param families
	 * @return
	 * @throws Exception
	 */
	void executeUpdateCmd(IBACallContext iBACallContext, Object connection, java.util.Map<IBAColumn, Object> columnsMap, IBAEntity et, String[] families) throws Exception;

	/**
	 * 执行获取数据命令
	 * 
	 * @param iBACallContext
	 * @param connection 数据库连接
	 * @param et
	 * @param families
	 * @return
	 * @throws Exception
	 */
	void executeGetCmd(IBACallContext iBACallContext, Object connection, IBAEntity et, String[] families) throws Exception;

	/**
	 * 执行删除数据命令
	 * 
	 * @param iBACallContext
	 * @param connection 数据库连接
	 * @param et
	 * @return
	 * @throws Exception
	 */
	void executeRemoveCmd(IBACallContext iBACallContext, Object connection, IBAEntity et) throws Exception;
	
	
	
	/**
	 * 执行查询数据命令
	 * 
	 * @param iBACallContext
	 * @param connection 数据库连接
	 * @param iSelectCond
	 * @param families 
	 * @param iBAAsyncSelectHandler 
	 * @return
	 * @throws Exception
	 */
	ArrayList<IBAEntity> executeSelectCmd(IBACallContext iBACallContext, Object connection, IBASelectContext iBASelectContext,IBAAsyncSelectHandler iBAAsyncSelectHandler) throws Exception;

//	/**
//	 * 获取实体结果集合
//	 * 
//	 * @param iBACallContext
//	 * @param connection
//	 * @param iDEDataSetFetchContext
//	 * @param strDEDataSetName
//	 * @param families
//	 * @return
//	 * @throws Exception
//	 */
//	 DBFetchResult fetchDEDataSet(IBACallContext iBACallContext, Object connection, IDEDataSetFetchContext iDEDataSetFetchContext, String strDEDataSetName, String[] families) throws Exception;

	
	/**
	 * 执行批建立数据命令
	 * @param iBACallContext
	 * @param connection 数据库连接
	 * @param columnsMaps 建立的Map数组
	 * @param ets
	 * @param families
	 * @throws Exception
	 */
	void executeBatchCreateCmd(IBACallContext iBACallContext, Object connection, List<java.util.Map<IBAColumn, Object>> columnsMaps, IBAEntity[] ets, String[] families) throws Exception;
	
}
