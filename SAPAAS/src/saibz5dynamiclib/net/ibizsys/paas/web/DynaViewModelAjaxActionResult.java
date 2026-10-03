package net.ibizsys.paas.web;

import java.util.ArrayList;

import net.ibizsys.paas.core.Errors;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 动态视图模型异步请求结果对象
 * @author Administrator
 *
 */
public class DynaViewModelAjaxActionResult extends ViewModelAjaxActionResult {

	/**
	 * 结果属性：界面行为集合
	 */
	public final static String ATTR_UIACTIONS = "uiactions";
	
	/**
	 * 结果属性：动态部件集合
	 */
	public final static String ATTR_CTRLS = "ctrls";
	
	
	/**
	 * 视图界面行为集合
	 */
	protected ArrayList uiActionList = new ArrayList();
	
	
	/**
	 * 视图动态部件集合
	 */
	protected ArrayList ctrlList = new ArrayList();
	
	
	

	/**
	 * 获取视图界面行为集合对象
	 * @return
	 */
	public ArrayList getUIActions(){
		return this.uiActionList;
	}
	
	
	/**
	 * 获取视图动态部件集合对象
	 * @return
	 */
	public ArrayList getCtrls(){
		return this.ctrlList;
	}
	
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.web.ViewAjaxActionResult#fillJSONObject(net.sf.json.JSONObject)
	 */
	@Override
	protected void fillJSONObject(JSONObject objJSON) {
		
		super.fillJSONObject(objJSON);
		
		if (this.getRetCode() == Errors.OK) {
			objJSON.put(ATTR_UIACTIONS, JSONArray.fromArray(getUIActions().toArray()));
			objJSON.put(ATTR_CTRLS, JSONArray.fromArray(getCtrls().toArray()));
		}
	}
	
}
