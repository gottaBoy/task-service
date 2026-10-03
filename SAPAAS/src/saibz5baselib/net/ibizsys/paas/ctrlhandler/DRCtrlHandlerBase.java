package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IDRCtrlModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;

/**
 * 数据关系部件后台处理对象基类
 * 
 * @author lionlau
 *
 */
public abstract class DRCtrlHandlerBase extends CtrlHandlerBase implements IDRTabHandler {
	/**
	 * 获取数据关系栏模型
	 * 
	 * @return
	 */
	protected abstract IDRCtrlModel getDRCtrlModel();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ICtrlHandler#getCtrlModel()
	 */
	@Override
	public ICtrlModel getCtrlModel() {
		return getDRCtrlModel();
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

	/**
	 * 数据获取处理
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onFetch() throws Exception {
		MDAjaxActionResult mdAjaxActionResult = createFetchActionResult();
		fillFetchResult(mdAjaxActionResult);
		return mdAjaxActionResult;
	}

	/**
	 * 填充数据获取结果
	 * 
	 * @param fetchResult
	 * @throws Exception
	 */
	protected abstract void fillFetchResult(MDAjaxActionResult fetchResult) throws Exception;

}
