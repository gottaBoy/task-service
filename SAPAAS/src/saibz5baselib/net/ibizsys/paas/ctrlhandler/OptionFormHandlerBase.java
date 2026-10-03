package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.web.AjaxActionResult;

/**
 * 选项表单后台处理对象
 * 
 * @author Administrator
 *
 */
public abstract class OptionFormHandlerBase extends EditFormHandlerBase {
	@Override
	protected AjaxActionResult onLoad() throws Exception {
		return onLoadDraft();
	}
}
