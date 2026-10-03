package net.ibizsys.paas.controller;

import java.util.ArrayList;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 选择视图控制器对象
 * 
 * @author Administrator
 *
 */
public abstract class PickupViewControllerBase extends ViewControllerBase implements IPickupViewController{
	
	public PickupViewControllerBase() throws Exception {
		super();
	}

	/**
	 * 是否支持多项选择
	 * 
	 * @return
	 */
	protected boolean isEnableMultiSelect() {
		return false;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.controller.ViewControllerBase#onViewAjaxAction(java. lang.String)
	 */
	@Override
	protected AjaxActionResult onViewAjaxAction(String strAction) throws Exception {
		if (StringHelper.compare(strAction, VIEWACTION_CONVERTPICKUPDATA, true) == 0) {
			return onConvertPickupData();
		}
		return super.onViewAjaxAction(strAction);
	}

	/**
	 * 获取应用视图
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onConvertPickupData() throws Exception {
		MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();

		// 获取数据
		String strPostValue = WebContext.getRemoteCallArg(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strPostValue)) {
			throw new Exception(StringHelper.format("没有提交选择转化数据"));
		}
		
		ArrayList<IEntity> entityList = new ArrayList<IEntity>();
		JSONArray ja = JSONArray.fromString(strPostValue);
		for(int i=0;i<ja.length();i++){
			JSONObject jo = ja.getJSONObject(i);
			SimpleEntity simpleEntity = new SimpleEntity();
			DataObject.fromJSONObject(simpleEntity, jo);
			entityList.add(simpleEntity);
		}
		
		entityList = this.getService().convertPickupData(entityList);
		for(IEntity iEntity:entityList){
			ajaxActionResult.getRows().add(DataObject.toJSONObject(iEntity, false));
		}
		return ajaxActionResult;
	}
}
