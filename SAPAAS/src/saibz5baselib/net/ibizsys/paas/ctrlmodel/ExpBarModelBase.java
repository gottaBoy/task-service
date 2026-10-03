package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.ControlTypes;
import net.ibizsys.paas.control.expbar.ExpBarItem;
import net.ibizsys.paas.control.expbar.ExpBarRootItem;
import net.ibizsys.paas.control.expbar.IExpBarItem;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.sf.json.JSONObject;

/**
 * 导航栏部件模型
 * 
 * @author lionlau
 *
 */
public abstract class ExpBarModelBase extends CtrlModelBase implements IExpBarModel {
	protected ExpBarRootItem expBarRootItem = new ExpBarRootItem();

	@Override
	protected void onInit() throws Exception {
		super.onInit();
		onPrepareRootItem(this.getRootItem());
	}

	@Override
	public String getControlType() {
		return ControlTypes.ExpBar;
	}

	/**
	 * 准备导航栏根节点
	 * 
	 * @param expBarRootItem
	 * @throws Exception
	 */
	protected void onPrepareRootItem(ExpBarRootItem expBarRootItem) throws Exception {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IExpBarModel#fillFetchResult(net.ibizsys.paas.web.MDAjaxActionResult)
	 */
	@Override
	public void fillFetchResult(MDAjaxActionResult fetchResult) throws Exception {
		for (IExpBarItem iExpBarItem : getRootItem().getItems()) {
			JSONObject jo = ExpBarItem.toJSONObject(iExpBarItem, null);
			fetchResult.getRows().add(jo);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IExpBarModel#getRootItem()
	 */
	@Override
	public ExpBarRootItem getRootItem() {
		return this.expBarRootItem;
	}

}
