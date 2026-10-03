package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaCodeList;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态静态代码表模型对象
 * @author Administrator
 *
 */
public class DefaultDynaStaticCodeListModel extends StaticCodeListModelBase implements IDynaCodeListModel {

	private String strDynaInstId = null;
	private ObjectNode modelJsonObject = null;
	private DSDynaCodeList dsDynaCodeList = new DSDynaCodeList();
	private IDynaCodeListModelContainer iDynaCodeListModelContainer = null;
	
	@Override
	public void init(IDynaCodeListModelContainer iDynaCodeListModelContainer, IEntity iEntity) throws Exception {
		iEntity.copyTo(dsDynaCodeList, false);
		this.iDynaCodeListModelContainer = iDynaCodeListModelContainer;
		this.strId = dsDynaCodeList.getDSDynaCodeListId();
		this.strName = dsDynaCodeList.getDSDynaCodeListName();
		this.strDynaInstId = dsDynaCodeList.getDynaSysInstId();
		if(!StringHelper.isNullOrEmpty(dsDynaCodeList.getDynaModel())){
			ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString(dsDynaCodeList.getDynaModel());
			this.loadJsonObject(objectNode);
		}
	}



	@Override
	public String getDynaInstId() {
		return this.strDynaInstId;
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
		
		ArrayNode arrayNode = JsonNodeHelper.getArray(jsonObject, IDynaCtrlModel.ATTR_ITEMS);
		if(arrayNode!=null){
			int nSize = arrayNode.size();
			for(int i =0;i<nSize;i++){
				ObjectNode itemNode = (ObjectNode)arrayNode.get(i);
				DynaCodeItemModel iDynaCodeItemModel = new DynaCodeItemModel();
				iDynaCodeItemModel.init(this, null, itemNode);
				this.registerCodeItemModel(iDynaCodeItemModel);
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



	@Override
	public ISystem getSystem() {
		return iDynaCodeListModelContainer.getSystem();
	}



	@Override
	public String getCodeListType() {
		return iDynaCodeListModelContainer.getCodeListType();
	}



	@Override
	public String getOrMode() {
		return iDynaCodeListModelContainer.getOrMode();
	}



	@Override
	public String getValueSeparator() {
		return iDynaCodeListModelContainer.getValueSeparator();
	}



	@Override
	public String getTextSeparator() {
		return iDynaCodeListModelContainer.getTextSeparator();
	}



	@Override
	public String getEmptyText() {
		return iDynaCodeListModelContainer.getEmptyText();
	}


	@Override
	public boolean isUserScope() {
		return iDynaCodeListModelContainer.isUserScope();
	}

	
	
	
	
}
