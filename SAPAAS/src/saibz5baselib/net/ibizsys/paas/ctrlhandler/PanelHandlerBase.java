package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IPanelModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.PanelAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * 面板后台处理对象基类
 * 
 * @author lionlau
 *
 */
public abstract class PanelHandlerBase extends CtrlHandlerBase implements IPanelHandler {
	
	/**
	 * 获取面板模型
	 * 
	 * @return
	 */
	protected abstract IPanelModel getPanelModel();

	
	@Override
	public ICtrlModel getCtrlModel() {
		return getPanelModel();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.CtrlHandlerBase#onProcessAction(java.lang .String)
	 */
	@Override
	protected AjaxActionResult onProcessAction(String strAction) throws Exception {
		
		if (StringHelper.compare(strAction, ACTION_LOAD, true) == 0) {
			return onLoad();
		}

		return super.onProcessAction(strAction);
	}

	
	/**
	 * 通过数据实体填充面板
	 * 
	 * @param iDataObject
	 * @return
	 */
	protected void fillOutputDatas(IDataObject iDataObject, PanelAjaxActionResult panelAjaxActionResult) throws Exception {
		JSONObject outputData = panelAjaxActionResult.getData(true);
		JSONObject outputConfig = panelAjaxActionResult.getConfig(true);
		this.getPanelModel().fillOutputDatas(iDataObject, outputData, outputConfig);
	}



	/**
	 * 加载数据
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onLoad() throws Exception {
		PanelAjaxActionResult panelAjaxActionResult = new PanelAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(panelAjaxActionResult);

		String strKey = WebContext.getKey(this.getWebContext());
		if(StringHelper.isNullOrEmpty(strKey)){
			strKey = WebContext.getKeys(this.getWebContext());
		}
		IEntity iEntity = getEntity(strKey);
		// 获取数据
		this.fillOutputDatas(iEntity, panelAjaxActionResult);
		return panelAjaxActionResult;
	}
	
	
	/**
	 * 获取数据
	 * 
	 * @param objKeyValue
	 * @return
	 * @throws Exception
	 */
	protected IEntity getEntity(Object objKeyValue) throws Exception {
		return new SimpleEntity();
	}

}
