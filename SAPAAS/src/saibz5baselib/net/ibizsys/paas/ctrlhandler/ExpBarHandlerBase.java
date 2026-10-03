package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IExpBarModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.psrt.srv.web.WebContext;

/**
 * 导航栏后台处理对象基类
 * 
 * @author lionlau
 *
 */
public abstract class ExpBarHandlerBase extends CtrlHandlerBase implements IExpBarHandler {

	/**
	 * 获取导航栏模型
	 * 
	 * @return
	 */
	protected abstract IExpBarModel getExpBarModel();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ICtrlHandler#getCtrlModel()
	 */
	@Override
	public ICtrlModel getCtrlModel() {
		return getExpBarModel();
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
	 * 后台处理
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
	protected void fillFetchResult(MDAjaxActionResult fetchResult) throws Exception {
		String strRender = WebContext.getRender(this.getWebContext());
		if (!StringHelper.isNullOrEmpty(strRender)) {
			IExpBarRender iExpBarRender = (IExpBarRender) this.getViewController().getAppModel().getCtrlRender(this.getExpBarModel().getControlType(), strRender);
			if (iExpBarRender != null) {
				iExpBarRender.fillFetchResult(getExpBarModel(), fetchResult);
				return;
			}
		}
		this.getExpBarModel().fillFetchResult(fetchResult);
	}
}
