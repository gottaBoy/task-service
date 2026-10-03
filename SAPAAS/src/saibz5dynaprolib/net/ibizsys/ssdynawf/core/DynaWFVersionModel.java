package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFLink;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWFStartProcess;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFModel;

/**
 * JIT 流程版本模型对象
 * @author Administrator
 *
 */
public class DynaWFVersionModel extends WFVersionModelBase implements IDynaWFVersionRuntime  {
	
	private IDynaWFModel iDynaWFModel = null;

	/**
	 * 初始化
	 * @param iDynaWFModel
	 * @param iPSWFVersion
	 * @throws Exception
	 */
	public void init(IDynaWFModel iDynaWFModel, IPSWFVersion iPSWFVersion) throws Exception {
		this.iDynaWFModel = iDynaWFModel;
		this.setPSWFVersion(iPSWFVersion);
        this.setId(iPSWFVersion.getId());
        this.setWFVersion(iPSWFVersion.getWFVersion());
        if(iPSWFVersion.getWFMode()!=null){
        	//设置流程模式 
        	this.setWFMode(iPSWFVersion.getWFMode());
        }

        if(iPSWFVersion.getStartPSWFProcess()!=null) {
        	IPSWFStartProcess iPSWFStartProcess = (IPSWFStartProcess)iPSWFVersion.getStartPSWFProcess();
        	this.setStartDEViewId(iPSWFStartProcess.getStartPSDEViewId());
        	this.setMobStartDEViewId(iPSWFStartProcess.getMobStartPSDEViewId());
        	this.setStartDEViewUserData(iPSWFStartProcess.getStartPSDEViewUserData());
        	this.setMobStartDEViewUserData(iPSWFStartProcess.getMobStartPSDEViewUserData());
        }
        
        
        
		this.init(iDynaWFModel);
		
	}
	
	@Override
	public IWFModel getWFModel() {
		return this.iDynaWFModel;
	}

    @Override
	public IDynaWFModel getDynaWFModel() {
		return this.iDynaWFModel;
	}




	@Override
    protected void prepareWFProcessModels() throws Exception
    {
    	java.util.Iterator<IPSWFProcess> psWFProcesses = this.getPSWFVersion().getPSWFProcesses();
    	if(psWFProcesses!=null){
    		while(psWFProcesses.hasNext()){
    			IPSWFProcess iPSWFProcess = psWFProcesses.next();
    			String strProcessType = iPSWFProcess.getWFProcessType();
    			if(StringHelper.compare(strProcessType, "START", false)==0){
    				DynaWFStartProcessModel psJITWFStartProcessModel = new DynaWFStartProcessModel();
    				psJITWFStartProcessModel.init(this, iPSWFProcess);
    				registerWFProcessModel(psJITWFStartProcessModel);
    				continue;
    			}
    			
    			if(StringHelper.compare(strProcessType, "END", false)==0){
    				DynaWFEndProcessModel psJITWFEndProcessModel = new DynaWFEndProcessModel();
    				psJITWFEndProcessModel.init(this, iPSWFProcess);
    				registerWFProcessModel(psJITWFEndProcessModel);
    				continue;
    			}
    			
    			if(StringHelper.compare(strProcessType, "INTERACTIVE", false)==0){
    				DynaWFInteractiveProcessModel psJITWFInteractiveProcessModel = new DynaWFInteractiveProcessModel();
    				psJITWFInteractiveProcessModel.init(this, iPSWFProcess);
    				registerWFProcessModel(psJITWFInteractiveProcessModel);
    				continue;
    			}
    			
    			if(StringHelper.compare(strProcessType, "PROCESS", false)==0){
    				DynaWFDEActionProcessModel psJITWFDEActionProcessModel = new DynaWFDEActionProcessModel();
    				psJITWFDEActionProcessModel.init(this, iPSWFProcess);
    				registerWFProcessModel(psJITWFDEActionProcessModel);
    				continue;
    			}
    			
    			if(StringHelper.compare(strProcessType, "PARALLEL", false)==0){
    				DynaWFParallelSubWFProcessModel psJITWFParallelSubWFProcessModel = new DynaWFParallelSubWFProcessModel();
    				psJITWFParallelSubWFProcessModel.init(this, iPSWFProcess);
    				registerWFProcessModel(psJITWFParallelSubWFProcessModel);
    				continue;
    			}
    			
    			if(StringHelper.compare(strProcessType, "EMBED", false)==0){
    				DynaWFEmbedWFProcessModel psJITWFEmbedWFProcessModel = new DynaWFEmbedWFProcessModel();
    				psJITWFEmbedWFProcessModel.init(this, iPSWFProcess);
    				registerWFProcessModel(psJITWFEmbedWFProcessModel);
    				continue;
    			}
    			
    			
    			if(StringHelper.compare(strProcessType, "EXCLUSIVEGATEWAY", false)==0){
    				DynaWFExclusiveGatewayProcessModel psJITWFExclusiveGatewayProcessModel = new DynaWFExclusiveGatewayProcessModel();
    				psJITWFExclusiveGatewayProcessModel.init(this, iPSWFProcess);
    				registerWFProcessModel(psJITWFExclusiveGatewayProcessModel);
    				continue;
    			}
    			
    			if(StringHelper.compare(strProcessType, "INCLUSIVEGATEWAY", false)==0){
    				DynaWFInclusiveGatewayProcessModel psJITWFInclusiveGatewayProcessModel = new DynaWFInclusiveGatewayProcessModel();
    				psJITWFInclusiveGatewayProcessModel.init(this, iPSWFProcess);
    				registerWFProcessModel(psJITWFInclusiveGatewayProcessModel);
    				continue;
    			}
    			
    			if(StringHelper.compare(strProcessType, "PARALLELGATEWAY", false)==0){
    				DynaWFParallelGatewayProcessModel psJITWFParallelGatewayProcessModel = new DynaWFParallelGatewayProcessModel();
    				psJITWFParallelGatewayProcessModel.init(this, iPSWFProcess);
    				registerWFProcessModel(psJITWFParallelGatewayProcessModel);
    				continue;
    			}

    		} 
    	}

    	super.prepareWFProcessModels();
    }

    
    @Override
    protected void prepareWFLinkModels() throws Exception
    {
    	java.util.Iterator<IPSWFLink> psWFlinks = this.getPSWFVersion().getPSWFLinks();
    	if(psWFlinks!=null){
    		while(psWFlinks.hasNext()){
    			IPSWFLink iPSWFLink = psWFlinks.next();
    			if(StringHelper.compare(iPSWFLink.getWFLinkType(), "ROUTE", true)==0){
    				DynaWFRouteLinkModel psJITWFRouteLinkModel = new DynaWFRouteLinkModel();
    				psJITWFRouteLinkModel.init(this, iPSWFLink);
    				registerWFLinkModel(psJITWFRouteLinkModel);
    				continue;
    			}
    			
    			if(StringHelper.compare(iPSWFLink.getWFLinkType(), "IAACTION", true)==0){
    				DynaWFInteractiveLinkModel psJITWFInteractiveLinkModel = new DynaWFInteractiveLinkModel();
    				psJITWFInteractiveLinkModel.init(this, iPSWFLink);
    				registerWFLinkModel(psJITWFInteractiveLinkModel);
    				continue;
    			}
    			
    			if(StringHelper.compare(iPSWFLink.getWFLinkType(), "WFRETURN", true)==0){
    				DynaWFEmbedWFReturnModel psJITWFEmbedWFReturnModel = new DynaWFEmbedWFReturnModel();
    				psJITWFEmbedWFReturnModel.init(this, iPSWFLink);
    				registerWFLinkModel(psJITWFEmbedWFReturnModel);
    				continue;
    			}
    			
    			if(StringHelper.compare(iPSWFLink.getWFLinkType(), "TIMEOUT", true)==0){
    				DynaWFTimeoutLinkModel psJITWFTimeoutLinkModel = new DynaWFTimeoutLinkModel();
    				psJITWFTimeoutLinkModel.init(this, iPSWFLink);
    				registerWFLinkModel(psJITWFTimeoutLinkModel);
    				continue;
    			}
    			
    		}
    	}

    }

}
