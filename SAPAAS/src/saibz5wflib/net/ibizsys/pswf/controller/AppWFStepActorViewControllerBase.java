package net.ibizsys.pswf.controller;

import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pswf.ctrlhandler.AppWFStepActorGridHandler;
import net.ibizsys.pswf.ctrlmodel.AppWFStepActorGridModel;

/**
 * 应用流程跟踪视图控制器基类
 * 
 * @author Administrator
 *
 */
public abstract class AppWFStepActorViewControllerBase extends WFViewControllerBase {

	public AppWFStepActorViewControllerBase() throws Exception {
		super();

	}

	private net.ibizsys.psrt.srv.wf.demodel.WFStepActorDEModel wFStepActorDEModel;

	public net.ibizsys.psrt.srv.wf.demodel.WFStepActorDEModel getWFStepActorDEModel() {
		if (this.wFStepActorDEModel == null) {
			try {
				this.wFStepActorDEModel = (net.ibizsys.psrt.srv.wf.demodel.WFStepActorDEModel) DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.wf.demodel.WFStepActorDEModel");
			} catch (Exception ex) {
			}
		}
		return this.wFStepActorDEModel;
	}

	public IDataEntityModel getDEModel() {
		return this.getWFStepActorDEModel();
	}

	public net.ibizsys.psrt.srv.wf.service.WFStepActorService getWFStepActorService() {
		try {
			return (net.ibizsys.psrt.srv.wf.service.WFStepActorService) ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFStepActorService", this.getSessionFactory());
		} catch (Exception ex) {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.controller.IViewController#getService()
	 */
	@Override
	public IService getService() {
		return getWFStepActorService();
	}

	/**
	 * 准备部件模型
	 * 
	 * @throws Exception
	 */
	@Override
	protected void prepareCtrlModels() throws Exception {
		// 注册 grid
		AppWFStepActorGridModel grid = new AppWFStepActorGridModel();
		grid.init(this);
		this.registerCtrlModel("grid", grid);
	}

	/**
	 * 准备部件处理对象
	 * 
	 * @throws Exception
	 */
	@Override
	protected void prepareCtrlHandlers() throws Exception {
		// 注册 grid
		AppWFStepActorGridHandler grid = new AppWFStepActorGridHandler();
		grid.init(this);
		this.registerCtrlHandler("grid", grid);
	}

}
