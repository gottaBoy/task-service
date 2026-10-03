package net.ibizsys.ssdynawf.core;

import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.pswf.core.IWFDataCtrl;
import net.ibizsys.pswf.core.WFServiceBase;

/**
 * JIT 流程服务基类
 * @author Administrator
 *
 */
public class DynaWFService extends WFServiceBase {

	private IDynaSysModel iDynaSysModel = null;
	private IDynaWFModel iDynaWFModel = null;
	
	public void init(IDynaSysModel iDynaSysModel,IDynaWFModel iDynaWFModel)throws Exception{
		this.iDynaSysModel = iDynaSysModel;
		this.iDynaWFModel = iDynaWFModel;
		this.init(iDynaWFModel);
	}
	
	@Override
	protected IWFDataCtrl createWFDataCtrl() throws Exception {
		DynaWFDataCtrl psJITWFDataCtrl = new DynaWFDataCtrl();
		psJITWFDataCtrl.init(iDynaSysModel, iDynaWFModel);
		return psJITWFDataCtrl;
	}
}
