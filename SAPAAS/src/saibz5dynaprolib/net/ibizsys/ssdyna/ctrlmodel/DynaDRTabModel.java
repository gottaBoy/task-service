package net.ibizsys.ssdyna.ctrlmodel;

import com.fasterxml.jackson.databind.node.ObjectNode;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.drctrl.IPSDEDRTab;
import net.ibizsys.paas.control.drctrl.DRCtrlItem;
import net.ibizsys.paas.control.drctrl.DRCtrlRootItem;
import net.ibizsys.paas.control.drctrl.IDRCtrlItem;
import net.ibizsys.paas.ctrlmodel.DRTabModelBase;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.view.IDynaViewModel;

public class DynaDRTabModel extends DRTabModelBase implements IDynaCtrlModel {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaDRTabModel.class);
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

	public IPSDEDRTab getPSDEDRTab() {
		return (IPSDEDRTab) getPSControl();
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
	 * 准备数据关系根节点
	 * 
	 * @param drCtrlRootItem
	 * @throws Exception
	 */
	@Override
	protected void onPrepareRootItem(DRCtrlRootItem drCtrlRootItem) throws Exception {

		java.util.ArrayList<IDRCtrlItem> items = getPSDEDRTab().getRootItem().getAllItems();
		for (IDRCtrlItem dritem : items) {
			// 添加 ${dritem.text}
			DRCtrlItem drCtrlItem = drCtrlRootItem.addItem(dritem.getId(), dritem.getPId());
			drCtrlItem.setText(dritem.getText());
			drCtrlItem.setDRViewId(dritem.getDRViewId());
			if (dritem.isExpanded()) {
				drCtrlItem.setExpanded(true);
			}
			if (!StringHelper.isNullOrEmpty(dritem.getIconPath())) {
				drCtrlItem.setIconPath(dritem.getIconPath());
			}
			if (!StringHelper.isNullOrEmpty(dritem.getIconCls())) {
				drCtrlItem.setIconCls(dritem.getIconCls());
			}
			if (!StringHelper.isNullOrEmpty(dritem.getCounterId())) {
				drCtrlItem.setCounterId(dritem.getCounterId());
			}
			if (!StringHelper.isNullOrEmpty(dritem.getEnableMode())) {
				drCtrlItem.setEnableMode(dritem.getEnableMode());
			}
			if (!StringHelper.isNullOrEmpty(dritem.getTestEnableDEActionName())) {
				drCtrlItem.setTestEnableDEActionName(dritem.getTestEnableDEActionName());
			}
			if (!StringHelper.isNullOrEmpty(dritem.getTestEnableDEOPPriv())) {
				drCtrlItem.setTestEnableDEOPPriv(dritem.getTestEnableDEOPPriv());
			}
			java.util.Iterator<String> viewparams = dritem.getViewParamNames();
			while (viewparams.hasNext()) {
				String strParamName = viewparams.next();
				drCtrlItem.setViewParam(strParamName, dritem.getViewParam(strParamName));
			}
		}
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
