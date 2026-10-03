package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IReportModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 报表部件后台处理对象基类
 * 
 * @author lionlau
 *
 */
public abstract class ReportHandlerBase extends CtrlHandlerBase implements IReportHandler {
	/**
	 * 获取报表部件模型
	 * 
	 * @return
	 */
	protected abstract IReportModel getReportModel();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ICtrlHandler#getCtrlModel()
	 */
	@Override
	public ICtrlModel getCtrlModel() {
		return getReportModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.CtrlHandlerBase#onProcessAction(java.lang .String)
	 */
	@Override
	protected AjaxActionResult onProcessAction(String strAction) throws Exception {
		if (StringHelper.compare(strAction, ACTION_FETCH, true) == 0) {
			return onFetch();
		}

		return super.onProcessAction(strAction);
	}

	/**
	 * 建立获取行为结果
	 * 
	 * @return
	 */
	protected MDAjaxActionResult createFetchActionResult() {
		return new MDAjaxActionResult();
	}

	/*
	 * 后台处理
	 */
	protected AjaxActionResult onFetch() throws Exception {
		MDAjaxActionResult mdAjaxActionResult = createFetchActionResult();
		// fillFetchResult(mdAjaxActionResult);
		return mdAjaxActionResult;
	}

}
