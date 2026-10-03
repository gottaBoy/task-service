package net.ibizsys.ssdyna.ctrlmodel;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.ssdyna.view.IDynaViewModel;

import com.fasterxml.jackson.databind.node.ObjectNode;


/**
 * JIT 图形门户部件模型
 * @author Administrator
 *
 */
public class DynaChartPortletModel extends net.ibizsys.paas.ctrlmodel.ChartPortletModelBase implements IDynaCtrlModel {

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
	
	
}
