package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.IDRBarModel;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 数据关系栏自定义绘制器接口
 * 
 * @author Administrator
 *
 */
public interface IDRBarRender extends ICtrlRender {
	/**
	 * 获取填充结果
	 * 
	 * @param IDRBarModel
	 * @param fetchResult
	 * @throws Exception
	 */
	void fillFetchResult(IDRBarModel iDRBarModel, MDAjaxActionResult fetchResult) throws Exception;
}
