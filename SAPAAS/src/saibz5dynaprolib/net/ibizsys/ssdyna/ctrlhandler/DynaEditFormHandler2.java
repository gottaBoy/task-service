package net.ibizsys.ssdyna.ctrlhandler;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.paas.ctrlhandler.EditFormHandlerBase2;
import net.ibizsys.paas.ctrlmodel.IEditFormModel;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;


/**
 * 动态表单处理器对象
 * @author Administrator
 *
 */
public class DynaEditFormHandler2 extends EditFormHandlerBase2 implements IDynaCtrlHandler {

	private IPSControl iPSControl  = null;
	private IDynaCtrlModel iDynaCtrlModel = null;
	@Override
	public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
		this.iPSControl = iPSControl;
		iDynaCtrlModel = (IDynaCtrlModel)iDynaViewModel.getCtrlModel(iPSControl.getName(), false);
		this.init(iDynaViewModel);
	}

	@Override
	public IPSControl getPSControl() {
		return this.iPSControl;
	}

	@Override
	protected IEditFormModel getEditFormModel() {
		return (IEditFormModel)iDynaCtrlModel;
	}
}
