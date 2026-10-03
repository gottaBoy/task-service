package net.ibizsys.ssdyna.ctrlhandler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.drctrl.IPSDEDRBar;
import net.ibizsys.paas.ctrlhandler.DRBarHandlerBase;
import net.ibizsys.paas.ctrlmodel.IDRBarModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;

public class DynaDRBarHandler extends DRBarHandlerBase   implements IDynaCtrlHandler  {
	private static final Log log = LogFactory.getLog(DynaDRBarHandler.class);
	private IPSControl iPSControl = null;
	private IDRBarModel iDRBarModel = null;

	@Override
	public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
		this.iPSControl = iPSControl;
		iDRBarModel = (IDRBarModel)iDynaViewModel.getCtrlModel(iPSControl.getName(), false);
		this.init(iDynaViewModel);
	}

	@Override
	public IPSControl getPSControl() {
		return this.iPSControl;
	}

	/**
	 * @return
	 */
	public IPSDEDRBar getPSDEDRBar() {
		return (IPSDEDRBar) getPSControl();
	}



	/**
	 * 获取当前的关系栏
	 * 
	 * @return
	 */
	protected IDRBarModel getDRBarModel() {
		return iDRBarModel;
	}



}
