package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFEmbedWFReturnLink;
import net.ibizsys.model.wf.IPSWFLink;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.WFEmbedWFReturnModelBase;

/**
 * JIT流程嵌入流程返回连接对象
 * @author Administrator
 *
 */
public class DynaWFEmbedWFReturnModel extends WFEmbedWFReturnModelBase {
	
	private IDynaWFVersionModel iDynaWFVersionModel = null;
	private IPSWFEmbedWFReturnLink iPSWFLink = null;
	public void init(IDynaWFVersionModel iDynaWFVersionModel,IPSWFLink iPSWFLink)throws Exception{
		
		this.iDynaWFVersionModel = iDynaWFVersionModel;
		this.iPSWFLink = (IPSWFEmbedWFReturnLink) iPSWFLink;
        this.setId(this.iPSWFLink.getId());
        this.setName(this.iPSWFLink.getName());
        this.setSrcEndPoint(this.iPSWFLink.getSrcEndPoint());
        this.setDstEndPoint(this.iPSWFLink.getDstEndPoint());
        //${this.iPSWFLink.getToPSWFProcess().name}
        this.setNext(this.iPSWFLink.getToPSWFProcess().getId());
        //${this.iPSWFLink.getFromPSWFProcess().name}
        this.setFrom(this.iPSWFLink.getFromPSWFProcess().getId());
        this.setLogicName(this.iPSWFLink.getLogicName());
        this.setReturnValue(this.iPSWFLink.getReturnValue());
        this.setBPMNModelId( iPSWFLink.getBPMNModelId());
        if(!StringHelper.isNullOrEmpty(this.iPSWFLink.getUserData())){
        	this.setUserData(this.iPSWFLink.getUserData());
        }
        
        if(!StringHelper.isNullOrEmpty(this.iPSWFLink.getUserData2())){
        	this.setUserData2(this.iPSWFLink.getUserData2());
        }
        
        
        if(!StringHelper.isNullOrEmpty(this.iPSWFLink.getNextCondition())){
        	this.setNextCondition(this.iPSWFLink.getNextCondition());
        }


        this.init(iDynaWFVersionModel);
	}

	
}
