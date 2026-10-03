package net.ibizsys.paas.ctrlmodel.toolbar;

import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.view.DefaultDynaFrontUIActionModel;
import net.ibizsys.paas.view.IDynaUIActionModel;
import net.sf.json.JSONObject;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态工具栏界面行为项模型基类
 * @author Administrator
 *
 */
public  class DynaToolbarUIActionItemModel  extends DynaToolbarItemModelBase implements IDynaToolbarUIActionItemModel{

	/**
	 * 界面行为对象
	 */
	public final static String MODEL_ATTR_UIACTION = "uiaction";
	
	
	
	private IDynaUIActionModel iUIActionModel = null;
	private JSONObject uiActionParam = null;


	@Override
	protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
		
		ObjectNode uiActionModelObject = JsonNodeHelper.getObject(jsonObject, MODEL_ATTR_UIACTION);
		if(uiActionModelObject!=null){
			DefaultDynaFrontUIActionModel defaultDynaUIActionModel = new DefaultDynaFrontUIActionModel();
			defaultDynaUIActionModel.init(this.getDynaToolbarModel().getViewController().getDEModel(), uiActionModelObject);
			this.iUIActionModel = defaultDynaUIActionModel;
		}
		super.onLoadJsonObject(jsonObject);
	}
	
	
	
	@Override
	public String getItemType() {
		return IDynaToolbarItemModel.ITEMTYPE_UIACTION;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlmodel.toolbar.IDynaToolbarUIActionItemModel#getUIActionModel()
	 */
	@Override
	public IDynaUIActionModel getUIActionModel() {
		return this.iUIActionModel;
	}
	
	 
	/**
	 * 设置界面行为模型
	 * @param iUIActionModel
	 */
	public void setUIActionModel(IDynaUIActionModel iUIActionModel){
		this.iUIActionModel = iUIActionModel;
	}
	
	/**
	 * 设置界面行为参数
	 * @param uiActionParam
	 */
	public void setUIActionParam(JSONObject uiActionParam){
		this.uiActionParam = uiActionParam;
	}
	


	@Override
	public boolean isEnableToggleMode() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHiddenItem() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getNoPrivDisplayMode() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public JSONObject getUIActionParam() {
		return this.uiActionParam;
	}
	
}
