package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.ControlTypes;

/**
 * 数据关系栏部件模型
 * 
 * @author lionlau
 *
 */
public abstract class DRTabModelBase extends DRCtrlModelBase implements IDRTabModel {
	@Override
	public String getControlType() {
		return ControlTypes.DRTab;
	}

}
