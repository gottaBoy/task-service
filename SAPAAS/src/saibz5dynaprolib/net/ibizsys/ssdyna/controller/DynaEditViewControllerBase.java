package net.ibizsys.ssdyna.controller;

import net.ibizsys.ssdyna.view.IDynaViewInstModel;

public abstract class DynaEditViewControllerBase extends DynaViewControllerBase {

	public DynaEditViewControllerBase() throws Exception {
		super();
	}
	
	@Override
	protected IDynaViewInstModel createDynaViewInstModel() throws Exception {
		return new DynaEditViewControllerInst();
	}

}
