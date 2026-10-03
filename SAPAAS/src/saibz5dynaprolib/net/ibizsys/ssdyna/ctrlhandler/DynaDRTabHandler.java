package net.ibizsys.ssdyna.ctrlhandler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.drctrl.IPSDEDRTab;
import net.ibizsys.paas.ctrlhandler.DRTabHandlerBase;
import net.ibizsys.paas.ctrlmodel.IDRTabModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;

public class DynaDRTabHandler extends DRTabHandlerBase   implements IDynaCtrlHandler  {
	private static final Log log = LogFactory.getLog(DynaDRTabHandler.class);
	private IPSControl iPSControl = null;
	private IDRTabModel iDRTabModel = null;

	@Override
	public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
		this.iPSControl = iPSControl;
		iDRTabModel = (IDRTabModel)iDynaViewModel.getCtrlModel(iPSControl.getName(), false);
		this.init(iDynaViewModel);
	}

	@Override
	public IPSControl getPSControl() {
		return this.iPSControl;
	}

	/**
	 * @return
	 */
	public IPSDEDRTab getPSDEDRTab() {
		return (IPSDEDRTab) getPSControl();
	}



	/**
	 * 获取当前的关系栏
	 * 
	 * @return
	 */
	protected IDRTabModel getDRTabModel() {
		return iDRTabModel;
	}



}
