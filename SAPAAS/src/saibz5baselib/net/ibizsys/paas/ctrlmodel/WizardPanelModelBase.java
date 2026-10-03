package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.ControlTypes;

/**
 * 向导部件模型基类
 * 
 * @author lionlau
 *
 */
public abstract class WizardPanelModelBase extends CtrlModelBase implements IWizardPanelModel {

	@Override
	protected void onInit() throws Exception {
		super.onInit();
	}

	@Override
	public String getControlType() {
		return ControlTypes.WizardPanel;
	}

}
