package net.ibizsys.paas.web;

import java.util.ArrayList;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 视图模型异步请求对象结果
 * @author Administrator
 *
 */
public class ViewModelAjaxActionResult extends ViewAjaxActionResult {
	
	/**
	 * 数据访问对象
	 */
	protected JSONObject dataAccAction = null;
	
	/**
	 * 视图消息项集合
	 */
	protected ArrayList msgList = new ArrayList();
	
	/**
	 * 语言资源标签对象
	 */
	protected JSONObject lanResObject = null;
	
	
	protected JSONObject viewObject = null;
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.web.ViewAjaxActionResult#fillJSONObject(net.sf.json.JSONObject)
	 */
	@Override
	protected void fillJSONObject(JSONObject objJSON) {
		
		super.fillJSONObject(objJSON);
		
		if (this.getRetCode() == Errors.OK) {
			if (this.getDataAccAction(false) != null) {
				objJSON.put("dataaccaction", this.getDataAccAction(false));
			}
			
			if (this.getLanRes(false) != null) {
				objJSON.put("lanres", this.getLanRes(false));
			}
			
			if (this.getView(false) != null) {
				objJSON.put("view", this.getView(false));
			}
			
			objJSON.put("msgs", JSONArray.fromArray(msgList.toArray()));
		}
	}
	
	/**
	 * 获取数据访问控制对象
	 * 
	 * @param bCreate 不存在时是否建立
	 * @return
	 */
	public JSONObject getDataAccAction(boolean bCreate) {
		if (dataAccAction != null) return dataAccAction;

		if (bCreate) dataAccAction = new JSONObject();
		return dataAccAction;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.web.ViewAjaxActionResult#fromJSONObject(net.sf.json.JSONObject)
	 */
	@Override
	public void fromJSONObject(JSONObject jo) throws Exception {
		this.dataAccAction = jo.optJSONObject("dataaccaction");
		JSONObjectHelper.remove(jo, "dataaccaction");
		
		this.lanResObject = jo.optJSONObject("lanres");
		JSONObjectHelper.remove(jo, "lanres");
		
		this.viewObject = jo.optJSONObject("view");
		JSONObjectHelper.remove(jo, "view");
		
		
		if(true){
			JSONArray ja = jo.optJSONArray("msgs");
			this.msgList.clear();
			if (ja != null) {
				for (int i = 0; i < ja.length(); i++) {
					this.msgList.add(ja.get(i));
				}
			}
			JSONObjectHelper.remove(jo, "msgs");
		}
		
		super.fromJSONObject(jo);
	}
	
	
	
	
	/**
	 * 获取视图消息集合列表对象
	 * @return
	 */
	public ArrayList getMsgs(){
		return this.msgList;
	}
	
	
	/**
	 * 获取语言资源对象
	 * @param bCreate
	 * @return
	 */
	public JSONObject getLanRes(boolean bCreate){
		if (lanResObject != null) return lanResObject;
		if (bCreate) lanResObject = new JSONObject();
		return lanResObject;
	}
	
	
	
	public JSONObject getView(boolean bCreate){
		if (viewObject != null) return viewObject;
		if (bCreate) viewObject = new JSONObject();
		return viewObject;
	}
}
