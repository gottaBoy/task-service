package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFDEActionProcess;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWFProcessParam;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.WFDEActionProcessModelBase;
import net.ibizsys.pswf.core.WFDEActionProcessParamModel;

/**
 * JIT流程实体行为处理模型对象
 * @author Administrator
 *
 */
public class DynaWFDEActionProcessModel extends WFDEActionProcessModelBase {
	private IDynaWFVersionModel iDynaWFVersionModel = null;
	private IPSWFDEActionProcess iPSWFProcess = null;
	
	public void init(IDynaWFVersionModel iDynaWFVersionModel,IPSWFProcess iPSWFProcess)throws Exception{
		
		this.iDynaWFVersionModel = iDynaWFVersionModel;
		this.iPSWFProcess = (IPSWFDEActionProcess)iPSWFProcess;
		this.setId(iPSWFProcess.getId());
        this.setName(iPSWFProcess.getName());
        this.setLeftPos(iPSWFProcess.getLeftPos());
        this.setTopPos(iPSWFProcess.getTopPos());
        if(!StringHelper.isNullOrEmpty(this.iPSWFProcess.getDEActionName())){
        	this.setDEActionName(this.iPSWFProcess.getDEActionName());
        }
        this.setBPMNModelId( iPSWFProcess.getBPMNModelId());

		this.init(iDynaWFVersionModel);
	}
	
	
	  @Override
      protected void onInit() throws Exception
      {
          super.onInit();
          //注册处理参数
          java.util.Iterator<IPSWFProcessParam> psWFProcessParams = this.iPSWFProcess.getPSWFProcessParams();
          if(psWFProcessParams!=null){
        	  while(psWFProcessParams.hasNext()){
        		  IPSWFProcessParam iPSWFProcessParam = psWFProcessParams.next();
        		  WFDEActionProcessParamModel procParam = new WFDEActionProcessParamModel();
                  procParam.setDstField(iPSWFProcessParam.getDstField());
                  procParam.setSrcValueType(iPSWFProcessParam.getSrcValueType());
                   procParam.setSrcValue(iPSWFProcessParam.getSrcValue());
                  this.registerWFDEActionProcessParamModel(procParam);
        	  }
          }

      }
}
