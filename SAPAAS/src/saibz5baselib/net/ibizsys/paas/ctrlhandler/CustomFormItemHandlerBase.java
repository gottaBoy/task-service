package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 自定义表单项后台处理
 * 
 * @author lionlau
 *
 */
public abstract class CustomFormItemHandlerBase extends FormItemHandlerBase {
	@Override
	protected AjaxActionResult onItemFetch() throws Exception {
		MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
		fillFetchResult(mdAjaxActionResult);
		return mdAjaxActionResult;
	}

	/**
	 * 填充数据获取结果
	 * 
	 * @param fetchResult 请求结果
	 * @throws Exception
	 */
	protected void fillFetchResult(MDAjaxActionResult fetchResult) throws Exception {

	}

}
