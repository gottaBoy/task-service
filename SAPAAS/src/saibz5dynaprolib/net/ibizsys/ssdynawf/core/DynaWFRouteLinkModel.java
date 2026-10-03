package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFLink;
import net.ibizsys.model.wf.IPSWFRouteLink;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFLinkCondModel;
import net.ibizsys.pswf.core.IWFLinkGroupCondModel;
import net.ibizsys.pswf.core.IWFLinkSingleCondModel;
import net.ibizsys.pswf.core.WFLinkGroupCondModel;
import net.ibizsys.pswf.core.WFLinkSingleCondModel;
import net.ibizsys.pswf.core.WFRouteLinkModelBase;

/**
 * JIT流程路由连接模型对象
 * @author Administrator
 *
 */
public class DynaWFRouteLinkModel extends WFRouteLinkModelBase {
	
	private IDynaWFVersionModel iDynaWFVersionModel = null;
	private IPSWFRouteLink iPSWFLink = null;
	public void init(IDynaWFVersionModel iDynaWFVersionModel,IPSWFLink iPSWFLink)throws Exception{
		
		this.iDynaWFVersionModel = iDynaWFVersionModel;
		this.iPSWFLink = (IPSWFRouteLink) iPSWFLink;
        this.setId(this.iPSWFLink.getId());
        this.setName(this.iPSWFLink.getName());
        this.setSrcEndPoint(this.iPSWFLink.getSrcEndPoint());
        this.setDstEndPoint(this.iPSWFLink.getDstEndPoint());
        //${this.iPSWFLink.getToPSWFProcess().name}
        this.setNext(this.iPSWFLink.getToPSWFProcess().getId());
        //${this.iPSWFLink.getFromPSWFProcess().name}
        this.setFrom(this.iPSWFLink.getFromPSWFProcess().getId());
        this.setLogicName(this.iPSWFLink.getLogicName());
        if(this.iPSWFLink.isDefault()){
        	 this.setDefault(true);
        }
        this.setBPMNModelId( iPSWFLink.getBPMNModelId());
        this.init(iDynaWFVersionModel);
	}

	@Override
    protected void onInit() throws Exception
    {
        super.onInit();
        if(this.iPSWFLink.isDefault()){
        	
        	java.util.ArrayList<IWFLinkCondModel> wfLinkCondModels =  this.iPSWFLink.getRootWFLinkGroupCondModel().getAllWFLinkCondModels();
        	for(IWFLinkCondModel iWFLinkCondModel:wfLinkCondModels){
        		if(StringHelper.compare(iWFLinkCondModel.getCondType(), "GROUP", true)==0){
        			IWFLinkGroupCondModel  iWFLinkGroupCondModel  = (IWFLinkGroupCondModel )iWFLinkCondModel;
        			WFLinkGroupCondModel wfLinkGroupCondModel = getRootWFLinkGroupCondModel().addGroupCond(iWFLinkCondModel.getId(), iWFLinkGroupCondModel.getPId());
        			wfLinkGroupCondModel.setGroupOP(iWFLinkGroupCondModel.getGroupOP());
        			wfLinkGroupCondModel.setNotMode(iWFLinkGroupCondModel.isNotMode());
        			continue;
        		}
        		
        		if(StringHelper.compare(iWFLinkCondModel.getCondType(), "SINGLE", true)==0){
        			IWFLinkSingleCondModel  iWFLinkSingleCondModel  = (IWFLinkSingleCondModel )iWFLinkCondModel;
        			WFLinkSingleCondModel wfLinkSingleCondModel = getRootWFLinkGroupCondModel().addSingleCond(iWFLinkCondModel.getId(), iWFLinkSingleCondModel.getPId());
        			wfLinkSingleCondModel.setCondOP(iWFLinkSingleCondModel.getCondOP());
        			wfLinkSingleCondModel.setFieldName(iWFLinkSingleCondModel.getFieldName());
    				if(iWFLinkSingleCondModel.getParamType()!=null){
    					wfLinkSingleCondModel.setParamType(iWFLinkSingleCondModel.getParamType());
    				}
    				if(iWFLinkSingleCondModel.getParamValue()!=null){
    					wfLinkSingleCondModel.setParamValue(iWFLinkSingleCondModel.getParamValue());
    				}
        			continue;
        		}
        	}
        }
    }
}
