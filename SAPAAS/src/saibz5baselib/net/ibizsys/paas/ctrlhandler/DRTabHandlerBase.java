package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.IDRCtrlModel;
import net.ibizsys.paas.ctrlmodel.IDRTabModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.psrt.srv.web.WebContext;

/**
 * 数据关系栏后台处理对象基类
 * 
 * @author lionlau
 *
 */
public abstract class DRTabHandlerBase extends DRCtrlHandlerBase implements IDRTabHandler {
	/**
	 * 获取数据关系栏模型
	 * 
	 * @return
	 */
	protected abstract IDRTabModel getDRTabModel();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.DRCtrlHandlerBase#getDRCtrlModel()
	 */
	@Override
	protected IDRCtrlModel getDRCtrlModel() {
		return getDRTabModel();
	}

	/**
	 * 填充数据获取结果
	 * 
	 * @param fetchResult 请求结果
	 * @throws Exception
	 */
	protected void fillFetchResult(MDAjaxActionResult fetchResult) throws Exception {
		String strRender = WebContext.getRender(this.getWebContext());
		if (!StringHelper.isNullOrEmpty(strRender)) {
			IDRTabRender iDRTabRender = (IDRTabRender) this.getViewController().getAppModel().getCtrlRender(this.getDRTabModel().getControlType(), strRender);
			if (iDRTabRender != null) {
				iDRTabRender.fillFetchResult(getDRTabModel(), fetchResult);
				return;
			}
		}
		this.getDRTabModel().fillFetchResult(fetchResult);
	}

}
