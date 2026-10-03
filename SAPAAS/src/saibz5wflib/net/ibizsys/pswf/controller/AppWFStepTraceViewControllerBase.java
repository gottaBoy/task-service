package net.ibizsys.pswf.controller;

import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pswf.ctrlhandler.ActiveWFStepDataGridHandler;
import net.ibizsys.pswf.ctrlmodel.AppWFStepDataGridModel;

/**
 * 应用流程处理跟踪视图控制器基类
 * @author Administrator
 *
 */
public abstract class AppWFStepTraceViewControllerBase extends AppWFStepDataViewControllerBase{

	public AppWFStepTraceViewControllerBase() throws Exception {
		super();
	
	}
	
	



    private net.ibizsys.psrt.srv.wf.demodel.WFStepDataDEModel wFStepDataDEModel;

    public  net.ibizsys.psrt.srv.wf.demodel.WFStepDataDEModel getWFStepDataDEModel() {
        if(this.wFStepDataDEModel==null) {
            try {
                this.wFStepDataDEModel = (net.ibizsys.psrt.srv.wf.demodel.WFStepDataDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFStepDataDEModel");
            } catch(Exception ex) {
            }
        }
        return this.wFStepDataDEModel;
    }

    public  IDataEntityModel getDEModel() {
        return this.getWFStepDataDEModel();
    }

    public  net.ibizsys.psrt.srv.wf.service.WFStepDataService getWFStepDataService() {
        try {
            return (net.ibizsys.psrt.srv.wf.service.WFStepDataService)ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFStepDataService",this.getSessionFactory());
        } catch(Exception ex) {
            return null;
        }
    }

    /* (non-Javadoc)
    * @see net.ibizsys.paas.controller.IViewController#getService()
    */
    @Override
    public IService getService() {
        return getWFStepDataService();
    }





    /**
      * 准备部件模型
      * @throws Exception
      */
    @Override
    protected void prepareCtrlModels()throws Exception {
        //注册 grid
        AppWFStepDataGridModel grid = new AppWFStepDataGridModel();
        grid.init(this);
        this.registerCtrlModel("grid",grid);
    }

    /**
     * 准备部件处理对象
     * @throws Exception
     */
    @Override
    protected void prepareCtrlHandlers()throws Exception {
        //注册 grid
        ActiveWFStepDataGridHandler grid = new ActiveWFStepDataGridHandler();
        grid.init(this);
        this.registerCtrlHandler("grid",grid);
    }

}
