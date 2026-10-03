package net.ibizsys.paas.view;

import net.ibizsys.paas.core.ModelBase2Impl;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONObject;

/**
 * 视图向导对象
 * 
 * @author Administrator
 *
 */
public class ViewWizard extends ModelBase2Impl implements IViewWizard {

	/**
	 * 标识
	 */
	public final static String ID = "id";
	
	/**
	 * 名称
	 */
	public final static String NAME = "name";
	
	
	/**
	 * URL
	 */
	public final static String URL = "url";
	

	private String strWizardUrl = null;



	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.view.IViewWizard#getWizardUrl()
	 */
	@Override
	public String getWizardUrl() {
		return this.strWizardUrl;
	}

	
	/**
	 * 设置向导的Url路径
	 * 
	 * @param strWizardUrl
	 */
	public void setWizardUrl(String strWizardUrl) {
		this.strWizardUrl = strWizardUrl;
	}

	
	/**
	 * 设置标识
	 * @param strId
	 */
	public void setId(String strId){
		this.strId = strId;
	}
	
	/**
	 * 设置名称
	 * @param strName
	 */
	public void setName(String strName){
		this.strName = strName;
	}
	

	/**
	 * 导出JSON对象
	 * 
	 * @param jsonObject
	 * @param iViewWizard
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(JSONObject jsonObject, IViewWizard iViewWizard) throws Exception {
		if (jsonObject == null) jsonObject = new JSONObject();

		jsonObject.put(ID, JSONObjectHelper.stripQuotes(iViewWizard.getId(),true));
		jsonObject.put(NAME, JSONObjectHelper.stripQuotes(iViewWizard.getName(),true));
		jsonObject.put(URL, JSONObjectHelper.stripQuotes(iViewWizard.getWizardUrl(),true));
		
		return jsonObject;
	}

	

}
