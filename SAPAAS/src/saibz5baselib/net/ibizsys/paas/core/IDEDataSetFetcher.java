package net.ibizsys.paas.core;

import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.util.IGlobalContext;

/**
 * 实体数据集合获取对象
 * 
 * @author Administrator
 *
 */
public interface IDEDataSetFetcher {
	/**
	 * @param iGlobalContext
	 * @param iDEDataSet
	 * @throws Exception
	 */
	void init(IGlobalContext iGlobalContext, IDEDataSet iDEDataSet) throws Exception;

	/**
	 * 执行操作
	 * 
	 * @param iDEActionContext
	 * @throws Exception
	 */
	DBFetchResult fetch(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception;

	/**
	 * 关闭
	 */
	void close();

	/**
	 * 获取数据获取调用上下文对象
	 * 
	 * @return
	 */
	IDEDataSetFetchContext getDEDataSetFetchContext();
}
