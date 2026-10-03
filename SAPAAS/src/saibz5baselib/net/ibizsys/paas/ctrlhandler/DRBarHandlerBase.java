package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.IDRBarModel;
import net.ibizsys.paas.ctrlmodel.IDRCtrlModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;


/**
 * 数据关系栏后台处理对象基类
 * 
 * @author lionlau
 *
 */
public abstract class DRBarHandlerBase extends DRCtrlHandlerBase implements IDRBarHandler {
	
	
	
	/**
	 * 获取数据关系栏模型
	 * 
	 * @return
	 */
	protected abstract IDRBarModel getDRBarModel();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.DRCtrlHandlerBase#getDRCtrlModel()
	 */
	@Override
	protected IDRCtrlModel getDRCtrlModel() {
		return getDRBarModel();
	}

	/**
	 * 填充数据获取结果
	 * 
	 * @param fetchResult 请求结果
	 * @throws Exception
	 */
	protected void fillFetchResult(MDAjaxActionResult fetchResult) throws Exception {
		
		String strDataTreeId = this.getWebContext().getPostOrParamValue(PARAM_DATATREEID);
		if(StringHelper.isNullOrEmpty(strDataTreeId)){
			String strRender = WebContext.getRender(this.getWebContext());
			if (!StringHelper.isNullOrEmpty(strRender)) {
				IDRBarRender iDRBarRender = (IDRBarRender) this.getViewController().getAppModel().getCtrlRender(this.getDRBarModel().getControlType(), strRender);
				if (iDRBarRender != null) {
					iDRBarRender.fillFetchResult(getDRBarModel(), fetchResult);
					return;
				}
			}
			this.getDRBarModel().fillFetchResult(fetchResult);
		}
		else{
			ITreeHandler iTreeHandler = (ITreeHandler)this.getViewController().getCtrlHandler(strDataTreeId);
			AjaxActionResult ajaxActionResult = iTreeHandler.processAction(ACTION_FETCH, this.getWebContext());
			fetchResult.fromJSONObject(ajaxActionResult.toJSONObject());
		}
	}
}
