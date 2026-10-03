package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFEmbedWFProcess;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWFProcessSubWF;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.WFEmbedWFProcessModelBase;
import net.ibizsys.pswf.core.WFProcSubWFModel;

/**
 * JIT流程嵌入处理模型对象
 * @author Administrator
 *
 */
public class DynaWFEmbedWFProcessModel extends WFEmbedWFProcessModelBase {
	private IDynaWFVersionModel iDynaWFVersionModel = null;
	private IPSWFEmbedWFProcess iPSWFProcess = null;
	
	public void init(IDynaWFVersionModel iDynaWFVersionModel,IPSWFProcess iPSWFProcess)throws Exception{
		
		this.iDynaWFVersionModel = iDynaWFVersionModel;
		this.iPSWFProcess = (IPSWFEmbedWFProcess)iPSWFProcess;
		this.setId(iPSWFProcess.getId());
        this.setName(iPSWFProcess.getName());
        this.setLeftPos(iPSWFProcess.getLeftPos());
        this.setTopPos(iPSWFProcess.getTopPos());

        this.setWFStepValue(iPSWFProcess.getWFStepValue());
        this.setBPMNModelId( iPSWFProcess.getBPMNModelId());
        if(!StringHelper.isNullOrEmpty(this.iPSWFProcess.getUserData())){
       	 this.setUserData(this.iPSWFProcess.getUserData());
       }
        if(!StringHelper.isNullOrEmpty(this.iPSWFProcess.getUserData2())){
          	 this.setUserData2(this.iPSWFProcess.getUserData2());
          }

       

		this.init(iDynaWFVersionModel);
	}
	
	
	  @Override
      protected void onInit() throws Exception
      {
          super.onInit();
      	
          //注册子流程
          java.util.Iterator<IPSWFProcessSubWF> psWFProcessSubWFs = this.iPSWFProcess.getPSWFProcessSubWFs();
          if(psWFProcessSubWFs!=null){
        	  while(psWFProcessSubWFs.hasNext()){
        		  IPSWFProcessSubWF iPSWFProcessSubWF = psWFProcessSubWFs.next();
        		  WFProcSubWFModel procParam = new WFProcSubWFModel();
                  procParam.setId(iPSWFProcessSubWF.getId());
                  procParam.setName(iPSWFProcessSubWF.getName());
                  procParam.setWFId(iPSWFProcessSubWF.getWFId());
                  procParam.setDEName(iPSWFProcessSubWF.getDEName());
                  procParam.setDEDSName(iPSWFProcessSubWF.getDEDSName());
                   procParam.init(this);
                  this.registerWFProcSubWFModel(procParam);
        	  }
          }



      }
}
