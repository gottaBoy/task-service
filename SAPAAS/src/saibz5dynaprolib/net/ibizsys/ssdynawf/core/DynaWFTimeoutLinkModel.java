package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFLink;
import net.ibizsys.model.wf.IPSWFTimeoutLink;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.WFTimeoutLinkModelBase;

/**
 * JIT流程超时连接模型对象
 * @author Administrator
 *
 */
public class DynaWFTimeoutLinkModel extends WFTimeoutLinkModelBase {
	private IDynaWFVersionModel iDynaWFVersionModel = null;
	private IPSWFTimeoutLink iPSWFLink = null;
	public void init(IDynaWFVersionModel iDynaWFVersionModel,IPSWFLink iPSWFLink)throws Exception{
		
		this.iDynaWFVersionModel = iDynaWFVersionModel;
		this.iPSWFLink = (IPSWFTimeoutLink) iPSWFLink;
        this.setId(this.iPSWFLink.getId());
        this.setName(this.iPSWFLink.getName());
        this.setSrcEndPoint(this.iPSWFLink.getSrcEndPoint());
        this.setDstEndPoint(this.iPSWFLink.getDstEndPoint());
        //${this.iPSWFLink.getToPSWFProcess().name}
        this.setNext(this.iPSWFLink.getToPSWFProcess().getId());
        //${this.iPSWFLink.getFromPSWFProcess().name}
        this.setFrom(this.iPSWFLink.getFromPSWFProcess().getId());
        this.setLogicName(this.iPSWFLink.getLogicName());
       
        if(!StringHelper.isNullOrEmpty(this.iPSWFLink.getUserData())){
        	this.setUserData(this.iPSWFLink.getUserData());
        }
        
        if(!StringHelper.isNullOrEmpty(this.iPSWFLink.getUserData2())){
        	this.setUserData2(this.iPSWFLink.getUserData2());
        }
        
        this.setBPMNModelId( iPSWFLink.getBPMNModelId());
        this.init(iDynaWFVersionModel);
	}
}
