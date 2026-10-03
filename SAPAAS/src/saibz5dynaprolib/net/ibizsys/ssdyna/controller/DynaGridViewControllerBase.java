package net.ibizsys.ssdyna.controller;

import net.ibizsys.ssdyna.view.IDynaViewInstModel;

public abstract class DynaGridViewControllerBase extends DynaViewControllerBase {

	public DynaGridViewControllerBase() throws Exception {
		super();
	}

	@Override
	protected IDynaViewInstModel createDynaViewInstModel() throws Exception {
		return new DynaGridViewControllerInst();
	}
	
}
