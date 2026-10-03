package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.IDRTabModel;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 数据关系分布自定义绘制器接口
 * 
 * @author Administrator
 *
 */
public interface IDRTabRender extends ICtrlRender {
	/**
	 * 获取填充结果
	 * 
	 * @param IDRTabModel
	 * @param fetchResult
	 * @throws Exception
	 */
	void fillFetchResult(IDRTabModel iDRTabModel, MDAjaxActionResult fetchResult) throws Exception;
}
