package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFInteractiveProcess;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWFProcessRole;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.WFInteractiveProcessModelBase;
import net.ibizsys.pswf.core.WFProcRoleModel;
import net.ibizsys.pswf.core.WFProcRoleModelBase;
import net.ibizsys.pswf.core.WFProcSysActorRoleModel;
import net.ibizsys.pswf.core.WFProcUDActorRoleModel;

/**
 * JIT流程交互处理模型对象
 * @author Administrator
 *
 */
public class DynaWFInteractiveProcessModel extends WFInteractiveProcessModelBase implements IDynaWFProcessModel {
	private IDynaWFVersionModel iDynaWFVersionModel = null;
	private IPSWFInteractiveProcess iPSWFProcess = null;
	
	public void init(IDynaWFVersionModel iDynaWFVersionModel,IPSWFProcess iPSWFProcess)throws Exception{
		
		this.iDynaWFVersionModel = iDynaWFVersionModel;
		this.iPSWFProcess = (IPSWFInteractiveProcess)iPSWFProcess;
		this.setId(iPSWFProcess.getId());
        this.setName(iPSWFProcess.getName());
        this.setLeftPos(iPSWFProcess.getLeftPos());
        this.setTopPos(iPSWFProcess.getTopPos());
       
        this.setWFStepValue(iPSWFProcess.getWFStepValue());
        this.setBPMNModelId( iPSWFProcess.getBPMNModelId());
        if(this.iPSWFProcess.isEditable()){
        	 this.setEditable(true);
        }
        
        if(!StringHelper.isNullOrEmpty(this.iPSWFProcess.getMemoField())){
        	 this.setMemoField(this.iPSWFProcess.getMemoField());
        }
        if(!StringHelper.isNullOrEmpty(this.iPSWFProcess.getUserData())){
       	 this.setUserData(this.iPSWFProcess.getUserData());
       }
        if(!StringHelper.isNullOrEmpty(this.iPSWFProcess.getUserData2())){
          	 this.setUserData2(this.iPSWFProcess.getUserData2());
          }

        if(this.iPSWFProcess.isSendInform()){
        	this.setSendInform(true);
    		this.setMsgTemplateId(this.iPSWFProcess.getMsgTemplateId());
    		this.setMsgType(this.iPSWFProcess.getMsgType());
        }


		this.init(iDynaWFVersionModel);
	}
	
	
	  @Override
      protected void onInit() throws Exception
      {
          super.onInit();
      	
      	 //注册处理角色
          java.util.Iterator<IPSWFProcessRole> procroles = this.iPSWFProcess.getPSWFProcessRoles();
          while(procroles.hasNext()){
        	  IPSWFProcessRole iWFProcRoleModel = procroles.next();
        	  WFProcRoleModelBase procRole = null;
        	  if(StringHelper.compare(iWFProcRoleModel.getWFProcRoleType(), "WFROLE", false)==0){
        		  procRole =  new WFProcRoleModel();
        		  procRole.setWFRoleId(iWFProcRoleModel.getWFRoleId());
        	  }
        	  else
        		  if(StringHelper.compare(iWFProcRoleModel.getWFProcRoleType(), "UDACTOR", false)==0){
        			  WFProcUDActorRoleModel procRole2 = new DynaWFProcUDActorRoleModel();
        			  procRole2.setUDField(iWFProcRoleModel.getUDField());
        			  procRole = procRole2;
        		  }
        		  else{
        			  WFProcSysActorRoleModel procRole2 = new DynaWFProcSysActorRoleModel();
        			  procRole = procRole2;
        		  }

              procRole.setId(iWFProcRoleModel.getId());
              procRole.setName(iWFProcRoleModel.getName());
              procRole.setWFProcRoleType(iWFProcRoleModel.getWFProcessRoleType());
              procRole.init(this);
              this.registerWFProcRoleModel(procRole);

          }

      }


	@Override
	public IDynaWFVersionModel getDynaWFVersionModel() {
		return this.iDynaWFVersionModel;
	}
	  
	  
}
