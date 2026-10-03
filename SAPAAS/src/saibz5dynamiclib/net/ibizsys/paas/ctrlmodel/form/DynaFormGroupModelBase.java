package net.ibizsys.paas.ctrlmodel.form;

import java.util.ArrayList;

import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态表单分组模型对象接口实现基类
 * @author Administrator
 *
 */
public abstract class DynaFormGroupModelBase extends DynaFormDetailModelBase implements IDynaFormGroupModelBase {

	protected ArrayList<IDynaFormDetailModel> itemModelList = new ArrayList<IDynaFormDetailModel>();
	
	/**
	 * 增加子成员模型对象
	 * @param iDynaFormDetailModel
	 */
	public void addItemModel(IDynaFormDetailModel iDynaFormDetailModel){
		this.itemModelList.add(iDynaFormDetailModel);
	}
	
	
	/**
	 * 加载Json对象模型
	 * @param jsonObject
	 * @throws Exception
	 */
	protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
		super.onLoadJsonObject(jsonObject);
		//加载项集合
		if(true){
			ArrayNode arrayNode = JsonNodeHelper.getArray(jsonObject, IDynaCtrlModel.ATTR_ITEMS);
			if(arrayNode!=null){
				int nSize = arrayNode.size();
				for(int i =0;i<nSize;i++){
					ObjectNode itemNode = (ObjectNode)arrayNode.get(i);
					IDynaFormDetailModel iDynaFormDetailModel = loadFormDetailModel(itemNode);
					this.addItemModel(iDynaFormDetailModel);
				}
			}
		}
	}
	
	
	/**
	 * 获取子项模型集合
	 * @return
	 */
	public java.util.Iterator<IDynaFormDetailModel> getItemModels(){
		if(this.itemModelList.size() == 0)
			return null;
		return this.itemModelList.iterator();
	}
	
	@Override
	protected void onFillJsonObject(ObjectNode jo) throws Exception {
		super.onFillJsonObject(jo);
		
		//导出成员
		if(this.itemModelList.size() > 0){
			ArrayList<ObjectNode> objectNodeList = new ArrayList<ObjectNode>();
			for(IDynaFormDetailModel iDynaFormDetailModel:this.itemModelList){
				ObjectNode objectNode = iDynaFormDetailModel.toJsonObject(null);
				objectNodeList.add(objectNode);
			}
			JsonNodeHelper.put(jo, IDynaCtrlModel.ATTR_ITEMS, objectNodeList);
		}
	}
	
	
	/**
	 * 加载表单成员模型
	 * @param tbItemModelNode
	 * @return
	 * @throws Exception
	 */
	protected IDynaFormDetailModel loadFormDetailModel(ObjectNode tbItemModelNode) throws Exception{
		String strItemType = JsonNodeHelper.getString(tbItemModelNode,IDynaCtrlModel.ATTR_TYPE,null);
		if(StringHelper.isNullOrEmpty(strItemType)){
			throw new Exception(StringHelper.format("没有指定表单成员类型"));
		}
		IDynaFormDetailModel iDynaFormDetailModel = this.getDynaFormModel().createDynaFormDetailModel(strItemType);
		iDynaFormDetailModel.init(this.getDynaFormModel(), this.getParentModel(), tbItemModelNode);
		return iDynaFormDetailModel;
	}


	@Override
	public void fillDynaFormItemModels(ArrayList<IDynaFormItemModel> dynaFormItemModelList) throws Exception {
		for(IDynaFormDetailModel iDynaFormDetailModel:this.itemModelList){
			if(iDynaFormDetailModel instanceof IDynaFormItemModel){
				dynaFormItemModelList.add((IDynaFormItemModel)iDynaFormDetailModel);
			}
			else{
				if(iDynaFormDetailModel instanceof IDynaFormGroupModelBase){
					IDynaFormGroupModelBase iDynaFormGroupModelBase = (IDynaFormGroupModelBase)iDynaFormDetailModel;
					iDynaFormGroupModelBase.fillDynaFormItemModels(dynaFormItemModelList);
				}
			}
		}
	}
	
	
}
