package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEDataSet;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.web.IWebContext;

/**
 * 实体数据集合模型
 * 
 * @author Administrator
 *
 */
public interface IDEDataSetModel extends IDEDataSet,IModelBase3 {

	/**
	 * 是否为自定义的数据集
	 * 
	 * @return
	 */
	boolean isCustomDS();

	/**
	 * 获取数据集合
	 * 
	 * @param iDEDataSetFetchContext
	 * @return
	 * @throws Exception
	 */
	DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception;
	
	
	
	/**
	 * 填充获取的数据范围
	 * @param iService
	 * @param iWebContext
	 * @param deDataSetFetchContextImpl
	 * @throws Exception
	 */
	void fillDEDataSetFetchDataRange(IService iService,IWebContext iWebContext,IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception;
	
	
	
	
	/**
	 * 是否启用实体数据范围
	 * @return
	 */
	boolean isEnableDEDataRange();
	
}
