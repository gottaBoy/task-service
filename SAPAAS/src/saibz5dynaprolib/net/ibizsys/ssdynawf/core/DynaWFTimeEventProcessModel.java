package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFDEActionProcess;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.pswf.core.WFTimerEventProcessModelBase;

/**
 * JIT流程时间事件触发处理模型对象
 * @author Administrator
 *
 */
public class DynaWFTimeEventProcessModel extends WFTimerEventProcessModelBase{
	private IDynaWFVersionModel iDynaWFVersionModel = null;
	private IPSWFDEActionProcess iPSWFProcess = null;
	
	public void init(IDynaWFVersionModel iDynaWFVersionModel,IPSWFProcess iPSWFProcess)throws Exception{
		
		this.iDynaWFVersionModel = iDynaWFVersionModel;
		this.iPSWFProcess = (IPSWFDEActionProcess)iPSWFProcess;
		this.setId(iPSWFProcess.getId());
        this.setName(iPSWFProcess.getName());
        this.setLeftPos(iPSWFProcess.getLeftPos());
        this.setTopPos(iPSWFProcess.getTopPos());

        this.setBPMNModelId( iPSWFProcess.getBPMNModelId());

		this.init(iDynaWFVersionModel);
	}
	
	
}
