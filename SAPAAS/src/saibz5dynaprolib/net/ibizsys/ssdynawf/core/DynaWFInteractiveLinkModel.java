package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFInteractiveLink;
import net.ibizsys.model.wf.IPSWFLink;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.WFInteractiveLinkModelBase;

/**
 * JIT 流程交互连接模型对象
 * @author Administrator
 *
 */
public class DynaWFInteractiveLinkModel extends WFInteractiveLinkModelBase {
	private IDynaWFVersionModel iDynaWFVersionModel = null;
	private IPSWFInteractiveLink iPSWFLink = null;
	public void init(IDynaWFVersionModel iDynaWFVersionModel,IPSWFLink iPSWFLink)throws Exception{
		
		this.iDynaWFVersionModel = iDynaWFVersionModel;
		this.iPSWFLink = (IPSWFInteractiveLink) iPSWFLink;
        this.setId(this.iPSWFLink.getId());
        this.setName(this.iPSWFLink.getName());
        this.setSrcEndPoint(this.iPSWFLink.getSrcEndPoint());
        this.setDstEndPoint(this.iPSWFLink.getDstEndPoint());
        //${this.iPSWFLink.getToPSWFProcess().name}
        this.setNext(this.iPSWFLink.getToPSWFProcess().getId());
        //${this.iPSWFLink.getFromPSWFProcess().name}
        this.setFrom(this.iPSWFLink.getFromPSWFProcess().getId());
        this.setLogicName(this.iPSWFLink.getLogicName());
        
        this.setBPMNModelId( iPSWFLink.getBPMNModelId());
        if(!StringHelper.isNullOrEmpty(this.iPSWFLink.getMemoField())){
        	this.setMemoField(this.iPSWFLink.getMemoField());
        }
        
        if(!StringHelper.isNullOrEmpty(this.iPSWFLink.getActionField())){
        	this.setActionField(this.iPSWFLink.getActionField());
        }
        
        if(!StringHelper.isNullOrEmpty(this.iPSWFLink.getAddedWFRoleId())){
        	this.setAddedWFRoleId(this.iPSWFLink.getAddedWFRoleId());
        }
        
        if(!StringHelper.isNullOrEmpty(this.iPSWFLink.getUserData())){
        	this.setUserData(this.iPSWFLink.getUserData());
        }
        
        if(!StringHelper.isNullOrEmpty(this.iPSWFLink.getUserData2())){
        	this.setUserData2(this.iPSWFLink.getUserData2());
        }
        
        
        if(!StringHelper.isNullOrEmpty(this.iPSWFLink.getNextCondition())){
        	this.setNextCondition(this.iPSWFLink.getNextCondition());
        }

        
        if(this.iPSWFLink.isActorIAActionControl()){
        	this.setActorIAActionControl(true);
        }


        this.init(iDynaWFVersionModel);
	}

	@Override
    protected void onInit() throws Exception
    {
        super.onInit();
        if(this.iPSWFLink.getActionCodeList()!=null){
        	this.setActionCodeList(this.iDynaWFVersionModel.getDynaWFModel().getDynaSysModel().getCodeList(this.iPSWFLink.getActionCodeList().getId()));
        }
     
    }
}
