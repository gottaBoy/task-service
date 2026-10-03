package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.web.AjaxActionResult;

/**
 * 编辑表单处理对象基类2，在源对象基础上修改loaddraft方法
 * @author Administrator
 *
 */
public abstract class EditFormHandlerBase2 extends EditFormHandlerBase {

	@Override
	protected AjaxActionResult onLoadDraft() throws Exception {
		return onLoadDraft(true);
	}
	
}
