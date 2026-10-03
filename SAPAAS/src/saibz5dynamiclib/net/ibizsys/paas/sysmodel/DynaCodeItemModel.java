package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.paas.util.JsonNodeHelper;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态代码项模型对象
 * @author Administrator
 *
 */
public class DynaCodeItemModel extends CodeItemModel implements IDynaCodeItemModel {

	private ObjectNode modelJsonObject = null;
	private IDynaCodeListModel iDynaCodeListModel;
	private IDynaCodeItemModel parentModel ;
	
	
	@Override
	public void init(IDynaCodeListModel iDynaCodeListModel, IDynaCodeItemModel parentModel, Object modelObject) throws Exception {
		this.iDynaCodeListModel = iDynaCodeListModel;
		this.parentModel = parentModel;
		this.iCodeList = this.iDynaCodeListModel;
		this.parentCodeItem = parentModel;
		this.onInit();
		if(modelObject !=null ){
			if(modelObject instanceof ObjectNode){
				loadJsonObject((ObjectNode)modelObject);
				return;
			}
		}
	}


	

	@Override
	public IDynaCodeListModel getDynaCodeListModel() {
		return this.iDynaCodeListModel;
	}




	@Override
	public IDynaCodeItemModel getParentModel() {
		return this.parentModel;
	}




	/**
	 * 加载Json模型
	 * @param jsonObject
	 * @throws Exception
	 */
	public void loadJsonObject(ObjectNode jsonObject) throws Exception {
		this.modelJsonObject = jsonObject;
		onLoadJsonObject(jsonObject);
	}
	
	
	
	/**
	 * 加载Json对象模型
	 * @param jsonObject
	 * @throws Exception
	 */
	protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
		
		this.setValue(JsonNodeHelper.getString(jsonObject, ATTR_VALUE, this.getValue()));
		this.setText(JsonNodeHelper.getString(jsonObject, ATTR_TEXT, this.getText()));
		this.setRealText(JsonNodeHelper.getString(jsonObject, ATTR_REALTEXT, this.getRealText()));
		this.setParentValue(JsonNodeHelper.getString(jsonObject, ATTR_PARENTVALUE, this.getParentValue()));
		this.setIconCls(JsonNodeHelper.getString(jsonObject, ATTR_ICONCLS, this.getIconCls()));
		this.setIconClsX(JsonNodeHelper.getString(jsonObject, ATTR_ICONCLSX, this.getIconClsX()));
		this.setIconPath(JsonNodeHelper.getString(jsonObject, ATTR_ICONPATH, this.getIconPath()));
		this.setIconPathX(JsonNodeHelper.getString(jsonObject, ATTR_ICONPATHX, this.getIconPathX()));
		this.setDisableSelect(JsonNodeHelper.getBoolean(jsonObject, ATTR_DISABLESELECT, this.isDisableSelect()));
		this.setUserData(JsonNodeHelper.getString(jsonObject, ATTR_USERDATA, this.getUserData()));
		this.setUserData2(JsonNodeHelper.getString(jsonObject, ATTR_USERDATA2, this.getUserData2()));
		
		ArrayNode arrayNode = JsonNodeHelper.getArray(jsonObject, IDynaCtrlModel.ATTR_ITEMS);
		if(arrayNode!=null){
			int nSize = arrayNode.size();
			for(int i =0;i<nSize;i++){
				ObjectNode itemNode = (ObjectNode)arrayNode.get(i);
				DynaCodeItemModel iDynaCodeItemModel = new DynaCodeItemModel();
				iDynaCodeItemModel.init(this.getDynaCodeListModel(), this, itemNode);
				this.registerChildCodeItemModel(iDynaCodeItemModel);
			}
		}
		
	}

	
	/**
	 * 获取最后导入的模型对象（json）
	 * @return
	 */
	protected ObjectNode getModelJsonObject(){
		return this.modelJsonObject;
	}
}
