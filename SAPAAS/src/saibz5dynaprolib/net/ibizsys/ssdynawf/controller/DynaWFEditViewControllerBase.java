package net.ibizsys.ssdynawf.controller;

import net.ibizsys.ssdyna.controller.DynaEditViewControllerBase;
import net.ibizsys.ssdyna.view.IDynaViewInstModel;

public abstract class DynaWFEditViewControllerBase extends DynaEditViewControllerBase {

	public DynaWFEditViewControllerBase() throws Exception {
		super();
	}

	@Override
	protected IDynaViewInstModel createDynaViewInstModel() throws Exception {
		return new DynaWFEditViewControllerInst();
	}

	
}
