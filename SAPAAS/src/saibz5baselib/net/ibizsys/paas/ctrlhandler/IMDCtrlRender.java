package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.core.DEDataSetFetchContext;

/**
 * 多项数据绘制器接口
 * 
 * @author Administrator
 *
 */
public interface IMDCtrlRender extends ICtrlRender {
	/**
	 * 填充数据集合查询上下文
	 * 
	 * @param deDataSetFetchContextImpl
	 * @throws Exception
	 */
	void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception;

	/**
	 * 获取快速搜索条件
	 * 
	 * @return
	 */
	String getFetchQuickSearch();
}
