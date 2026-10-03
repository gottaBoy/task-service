package net.ibizsys.ssdyna.ctrlmodel;


import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.expbar.IPSWFExpBar;
import net.ibizsys.paas.control.expbar.ExpBarItem;
import net.ibizsys.paas.control.expbar.ExpBarRootItem;
import net.ibizsys.paas.control.expbar.IExpBarItem;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import net.ibizsys.pswf.ctrlmodel.WFExpBarModelBase;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class DynaWFExpBarModel extends WFExpBarModelBase  implements IDynaCtrlModel {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaWFExpBarModel.class);
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

	public IPSWFExpBar getPSWFExpBar() {
		return (IPSWFExpBar) getPSControl();
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
	 * 准备导航栏根节点
	 * 
	 * @param expBarRootItem
	 * @throws Exception
	 */
	@Override
	protected void onPrepareRootItem(ExpBarRootItem expBarRootItem) throws Exception {

		java.util.ArrayList<IExpBarItem> items = getPSWFExpBar().getRootItem().getAllItems();
		for (IExpBarItem expitem : items) {
			// 添加 ${expitem.text}
			ExpBarItem expBarItem = expBarRootItem.addItem(expitem.getId(), expitem.getPId());
			expBarItem.setText(expitem.getText());
			expBarItem.setExpViewId(expitem.getExpViewId());
			if (expitem.isExpanded()) {
				expBarItem.setExpanded(true);
			}
			if (!StringHelper.isNullOrEmpty(expitem.getIconPath())) {
				expBarItem.setIconPath(expitem.getIconPath());
			}
			if (!StringHelper.isNullOrEmpty(expitem.getIconCls())) {
				expBarItem.setIconCls(expitem.getIconCls());
			}
			if (!StringHelper.isNullOrEmpty(expitem.getCounterId())) {
				expBarItem.setCounterId(expitem.getCounterId());
				expBarItem.setCounterMode(expitem.getCounterMode());
			}

			java.util.Iterator<String> viewparams = expitem.getViewParamNames();
			while (viewparams.hasNext()) {
				String strParamName = viewparams.next();
				expBarItem.setViewParam(strParamName, expitem.getViewParam(strParamName));
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
