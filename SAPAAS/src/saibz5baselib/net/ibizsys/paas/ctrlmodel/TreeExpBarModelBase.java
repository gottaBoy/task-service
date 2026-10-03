package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.ControlTypes;

/**
 * 树导航栏部件模型
 * 
 * @author Administrator
 *
 */
public abstract class TreeExpBarModelBase extends ExpBarModelBase implements ITreeExpBarModel {
	
	@Override
	public String getControlType() {
		return ControlTypes.TreeExpBar;
	}

}
