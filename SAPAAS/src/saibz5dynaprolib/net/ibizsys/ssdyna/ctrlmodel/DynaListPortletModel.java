package net.ibizsys.ssdyna.ctrlmodel;

import com.fasterxml.jackson.databind.node.ObjectNode;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.ssdyna.view.IDynaViewModel;


/**
 * JIT 列表门户部件模型
 * @author Administrator
 *
 */
public class DynaListPortletModel extends net.ibizsys.paas.ctrlmodel.ListPortletModelBase implements IDynaCtrlModel {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaListPortletModel.class);
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
		if(getPSControl()!=null){
			DynaCtrlModelBase.toJsonObject(objectNode,getPSControl());
		}
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
}
