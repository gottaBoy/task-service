package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 代码表表单项处理基类
 * 
 * @author lionlau
 *
 */
public abstract class CodeListFormItemHandlerBase extends FormItemHandlerBase {
	/**
	 * 获取代码表模型
	 * 
	 * @return
	 */
	protected abstract ICodeList getCodeList() throws Exception;

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlhandler.FormItemHandlerBase#onItemFetch()
	 */
	@Override
	protected AjaxActionResult onItemFetch() throws Exception {
		MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();

		ICodeList iCodeList = this.getCodeList();
		fillFetchResult(mdAjaxActionResult, iCodeList);
		return mdAjaxActionResult;
	}


	/**
	 * 填充数据获取结果
	 * @param fetchResult
	 * @param iCodeList
	 * @throws Exception
	 */
	protected void fillFetchResult(MDAjaxActionResult fetchResult, ICodeList iCodeList) throws Exception {

		ICodeListModel iCodeListModel = null;
		if (iCodeList instanceof ICodeListModel) {
			iCodeListModel = (ICodeListModel) iCodeList;
			iCodeListModel.fillFetchResult(fetchResult, this.getWebContext());
		} else {
			// 没有实现
		}
	}
}
