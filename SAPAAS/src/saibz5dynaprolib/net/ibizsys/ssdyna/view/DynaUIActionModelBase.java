package net.ibizsys.ssdyna.view;

import com.fasterxml.jackson.databind.node.ObjectNode;

import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.view.UIActionModelBase;

/**
 * 动态界面行为模型对象基类
 * @author Administrator
 *
 */
public abstract class DynaUIActionModelBase extends UIActionModelBase implements IDynaUIActionModel{

	private IDynaViewModel iDynaViewModel = null;
	private IPSUIAction iPSUIAction = null;
	
	@Override
	public void init(IDynaViewModel iDynaViewModel, IPSUIAction iPSUIAction) throws Exception {
		this.iDynaViewModel = iDynaViewModel;
		this.iPSUIAction = iPSUIAction;
		this.strId = iPSUIAction.getId();
		this.strName = iPSUIAction.getName();
		this.onInit();
	}

	@Override
	public IDynaViewModel getDynaViewModel() {
		return this.iDynaViewModel;
	}

	@Override
	public IPSUIAction getPSUIAction() {
		return this.iPSUIAction;
	}
	
	@Override
	public ObjectNode toJsonObject(ObjectNode objectNode) throws Exception {
		if(objectNode == null){
			objectNode = JsonNodeHelper.createObjectNode();
		}
		onFillJsonObject(objectNode);
		return objectNode;
	}

	protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
		if(this.getPSUIAction()!=null){
			this.getPSUIAction().toJsonObject(objectNode);
		}
	}
}
