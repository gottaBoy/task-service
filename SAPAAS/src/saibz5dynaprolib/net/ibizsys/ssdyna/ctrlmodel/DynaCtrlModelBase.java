package net.ibizsys.ssdyna.ctrlmodel;

import net.ibizsys.model.IPSModelJsonExporter;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.paas.ctrlmodel.CtrlModelBase;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.view.IDynaViewModel;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态部件模型基类
 * @author Administrator
 *
 */
public abstract class DynaCtrlModelBase extends CtrlModelBase implements IDynaCtrlModel {
	
	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaCtrlModelBase.class);
	private IPSControl iPSControl = null;

	@Override
	public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
		this.iPSControl = iPSControl;
		this.init(iDynaViewModel);
	}

	@Override
	public IPSControl getPSControl() {
		return this.iPSControl;
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
		DynaCtrlModelBase.toJsonObject(objectNode,getPSControl());
	}
	
	@Override
	public boolean isDynaCtrl() {
		if(this.getPSControl()!=null){
			return this.getPSControl().isDynamicCtrl();
		}
		return false;
	}
	
	
	@Override
	public IDataEntityModel getDEModel() {
		try {
			if (getPSControl().getPSDataEntity() != null) {
				return ((IDynaViewModel)this.getViewController()).getDynaSysModel().getDynaDEModel(getPSControl().getPSDataEntity().getId());
			}
		} catch (Exception ex) {
			log.error(ex);
		}
		return super.getDEModel();
	}
	
	/**
	 * 默认导出部件模型实现
	 * @param objectNode
	 * @param iPSControl
	 * @return
	 * @throws Exception
	 */
	public static ObjectNode toJsonObject(ObjectNode objectNode,IPSControl iPSControl) throws Exception {
		if(iPSControl!=null){
			if(objectNode == null){
				objectNode = JsonNodeHelper.createObjectNode();
			}
			JsonNodeHelper.put(objectNode,IPSModelJsonExporter.ATTR_NAME, iPSControl.getName());
			JsonNodeHelper.put(objectNode, IPSModelJsonExporter.ATTR_TYPE, iPSControl.getControlType());
			if(!StringHelper.isNullOrEmpty(iPSControl.getControlSubType())){
				JsonNodeHelper.put(objectNode, "subtype", iPSControl.getControlSubType());
			}
			
			JsonNodeHelper.put(objectNode, "dynaview", iPSControl.getDynaViewContent());
			JsonNodeHelper.put(objectNode, "dynamodel", iPSControl.getDynaModelContent());
			return objectNode;
		}
		return null;
		
	}
	
	
	
}
