package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.pswf.core.WFStartProcessModelBase;

/**
 * JIT工作流启动处理
 * @author Administrator
 *
 */
public class DynaWFStartProcessModel extends WFStartProcessModelBase {

	private IDynaWFVersionModel iDynaWFVersionModel = null;
	private IPSWFProcess iPSWFProcess = null;
	public void init(IDynaWFVersionModel iDynaWFVersionModel,IPSWFProcess iPSWFProcess)throws Exception{
		
		this.iDynaWFVersionModel = iDynaWFVersionModel;
		this.iPSWFProcess = iPSWFProcess;
		this.setId(iPSWFProcess.getId());
        this.setName(iPSWFProcess.getName());
        this.setLeftPos(iPSWFProcess.getLeftPos());
        this.setTopPos(iPSWFProcess.getTopPos());
        this.setBPMNModelId( iPSWFProcess.getBPMNModelId());
        this.init(iDynaWFVersionModel);
	}
}
