package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.ControlTypes;

/**
 * 报表部件模型
 * 
 * @author lionlau
 *
 */
public abstract class ReportModelBase extends CtrlModelBase implements IReportModel {

	@Override
	protected void onInit() throws Exception {
		super.onInit();

	}

	@Override
	public String getControlType() {
		return ControlTypes.Report;
	}

}
