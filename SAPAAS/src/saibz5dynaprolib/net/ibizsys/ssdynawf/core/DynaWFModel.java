package net.ibizsys.ssdynawf.core;


import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;

/**
 * JIT 流程模型
 * @author Administrator
 *
 */
public class DynaWFModel extends WFModelBase implements IDynaWFModel,IDynaWFRuntime{

	private IDynaSysModel iDynaSysModel = null;

	/**
	 * 初始化
	 * @param iDynaSysModel
	 * @param iPSWorkflow
	 * @throws Exception
	 */
	@Override
	public void init(IDynaSysModel iDynaSysModel, IPSWorkflow iPSWorkflow) throws Exception {
		this.iDynaSysModel = iDynaSysModel;
		this.setPSWorkflow(iPSWorkflow);
		this.setId(iPSWorkflow.getId());
		this.setName(iPSWorkflow.getName());
		
		if(!StringHelper.isNullOrEmpty(iPSWorkflow.getRemindMsgTemplId())){
			 this.setRemindMsgTemplId(iPSWorkflow.getRemindMsgTemplId());
		}

		java.util.Iterator<IPSDEWF> psDEWFs = iPSWorkflow.getPSWFDEs();
		String strDefaultDEName = null;
		if(psDEWFs!=null) {
			while(psDEWFs.hasNext()) {
				strDefaultDEName = psDEWFs.next().getPSDataEntity().getId();
				break;
			}
		}
		if(StringHelper.isNullOrEmpty(strDefaultDEName))
			strDefaultDEName = iPSWorkflow.getId();
		this.setDefaultDEName(strDefaultDEName);
		
		
		//注册流程
		//this.iDynaSysModel.registerWFModel(this);
      
        //设置相关代码表
        this.setWFStepCodeList(iDynaSysModel.getCodeList(iPSWorkflow.getWFStepCodeList().getId()));
        this.setEntityStateCodeList(iDynaSysModel.getCodeList(iPSWorkflow.getEntityStatePSCodeList().getId()));
        this.setWFProxyMode(iPSWorkflow.getWFProxyMode());
 
        //设置业务状态中的流程状态
        java.util.Iterator<String> entityWFStates = iPSWorkflow.getEntityWFStates();
        if(entityWFStates!=null){
        	while(entityWFStates.hasNext()){
        		this.registerEntityWFState(entityWFStates.next());
        	}
        }
      
         //注册流程版本
        prepareWFVersionModels();

        //准备流程服务
        prepareWFService();
     }

     /**
      * 准备流程版本
      * @throws Exception
      */
	protected void prepareWFVersionModels() throws Exception
	{
		java.util.Iterator<IPSWFVersion> psWFVersions = this.getPSWorkflow().getPSWFVersions();
		if(psWFVersions!=null){
			while(psWFVersions.hasNext()){
				IPSWFVersion iPSWFVersion = psWFVersions.next();
				IDynaWFVersionModel iDynaWFVersionModel = createDynaWFVersionModel(iPSWFVersion);
				((IDynaWFVersionRuntime)iDynaWFVersionModel).init(this,iPSWFVersion);
				this.registerWFVersionModel(iDynaWFVersionModel);
			}
		}

	}
	
	protected IDynaWFVersionModel createDynaWFVersionModel(IPSWFVersion iPSWFVersion)throws Exception{
		return new DynaWFVersionModel();
	}
 
       /**
	 * 准备流程服务
	 * @throws Exception
	 */
	protected void prepareWFService() throws Exception
	{
		DynaWFService iWFService = new DynaWFService();
		iWFService.init(this.iDynaSysModel,this);
		this.setWFService(iWFService);
	}



	
	
	@Override
	public String getId() {
		return this.getPSWorkflow().getId();
	}

	@Override
	public String getName() {
		return this.getPSWorkflow().getName();
	}
	
	@Override
	protected void onInit() throws Exception {
		

		super.onInit();
	}
	
	@Override
	public ISystemModel getSystemModel() {
		return this.iDynaSysModel;
	}

	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.JIT.WF.IDynaWFModel#getDynaSysModel()
	 */
	@Override
	public IDynaSysModel getDynaSysModel() {
		return this.iDynaSysModel;
	}

	
	

}
