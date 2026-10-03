package net.ibizsys.ssdyna.sysmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import net.ibizsys.model.IPSModelStorage;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dynasys.IPSDynaInst;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.paas.db.IProcParam;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.wf.entity.WFWorkflow;
import net.ibizsys.psrt.srv.wf.service.WFWorkflowService;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.saas.sysmodel.util.SaaSSystemUtils;
import net.ibizsys.ssdyna.core.IDynaDETemplModel;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;
import net.ibizsys.ssdyna.service.IDynaService;
import net.ibizsys.ssdyna.web.WebContext;
import net.ibizsys.ssdynawf.core.IDynaWFModel;
import net.ibizsys.ssdynawf.core.IDynaWFRuntime;
import net.ibizsys.ssdynawf.sysmodel.DefaultDynaWFUtil;

/**
 * 动态系统模型基类对象
 * 
 * @author Administrator
 *
 */
public abstract class SystemModelBase extends net.ibizsys.saas.sysmodel.SystemModelBase implements IDynaSysModel {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(SystemModelBase.class);

	// private IPSSystem iPSSystem = null;
	// private HashMap<String,IDynaDEModel> dynaDEModelMap = new
	// HashMap<String,IDynaDEModel>();
	private HashMap<String, IDynaDETemplModel> dynaDETemplModelMap = new HashMap<String, IDynaDETemplModel>();
	private ArrayList<IDynaDETemplModel> dynaDETemplModelList = new ArrayList<IDynaDETemplModel>();
	private HashMap<String, IDynaInstModel> dynaInstMap = new HashMap<String, IDynaInstModel>();

	public SystemModelBase() {
		super();
	}

	@Autowired(required = false)
	@Qualifier("dynaModelStorage")
	private IPSModelStorage dynaModelStorage;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getSessionFactory12()
	 */
	@Override
	public IPSModelStorage getDynaModelStorage() {
		return dynaModelStorage;
	}

	@Override
	public void postConstruct() throws Exception {
		super.postConstruct();
		this.registerSystemUtilObj(SaaSSystemUtils.SaaSWF, DefaultDynaWFUtil.class.getCanonicalName());

		// if(getDynaModelStorage()!=null){
		// this.iPSSystem = this.getDynaModelStorage().getPSSystem();
		// }
	}

	@Override
	public IPSSystem getPSSystem() throws Exception {
		return getPSSystem(true);
	}

	public IPSSystem getPSSystem(boolean bDynaInst) throws Exception {

		if (bDynaInst) {
			String strDynaInstId = WebContext.getDynaSysInstId(true);
			if (StringHelper.isNullOrEmpty(strDynaInstId)) {
				return getPSSystem(false);
			}
			return getPSSystem(false).getPSDynaInst(strDynaInstId);
		} else {
			if (getDynaModelStorage() != null) {
				return this.getDynaModelStorage().getPSSystem();
			}
			throw new Exception(StringHelper.format("无法获取动态系统模型"));
		}
	}

	/**
	 * 获取当前系统动态实例
	 * 
	 * @return
	 * @throws Exception
	 */
	public IPSDynaInst getPSDynaInst() throws Exception {
		String strDynaInstId = WebContext.getDynaSysInstId(false);
		return getPSSystem(false).getPSDynaInst(strDynaInstId);
	}

	@Override
	public IDynaService getDynaService(String strDEId, SessionFactory sessionFactory) throws Exception {
		IDynaDEModel iDynaDEModel = this.getDynaDEModel(strDEId);
		return (IDynaService) iDynaDEModel.getService(sessionFactory);
	}

	@Override
	public IDynaDEModel getDynaDEModel(String strDEId) throws Exception {

		String strDynaInstId = WebContext.getDynaSysInstId(false);

		// 有动态实例
		IDynaInstModel iDynaInstModel = this.getDynaInstModel(strDynaInstId);
		
		IDynaDEModel iDynaDEModel = iDynaInstModel.getDynaDEModel(strDEId,true);
		if(iDynaDEModel!=null) {
			return iDynaDEModel;
		}
		try {

			IPSDataEntity iPSDataEntity = this.getPSDynaInst().getPSDataEntity(strDEId);
			iDynaDEModel = this.createDynaDEModel(iPSDataEntity);
			iDynaDEModel.init(this, iPSDataEntity);
			iDynaInstModel.registerDynaDEModel(iDynaDEModel);
			return iDynaDEModel;
		} catch (Exception ex) {
			throw ex;
		}

		// IDynaDEModel iDynaDEModel =
		// dynaDEModelMap.get(iPSDataEntity.getId());
		// if(iDynaDEModel==null){
		// iDynaDEModel = this.createDynaDEModel(iPSDataEntity);
		// iDynaDEModel.init(this, iPSDataEntity);
		// dynaDEModelMap.put(iPSDataEntity.getId(), iDynaDEModel);
		// }
		// return iDynaDEModel;
	}

	/**
	 * 创建动态实体模型对象
	 * 
	 * @param iPSDataEntity
	 * @return
	 * @throws Exception
	 */
	protected IDynaDEModel createDynaDEModel(IPSDataEntity iPSDataEntity) throws Exception {
		throw new Exception(StringHelper.format("无法创建实体[%1$s]动态实体模型对象", iPSDataEntity.getName()));
	}

	@Override
	public void registerDynaDETemplModel(IDynaDETemplModel iDynaDETemplModel) throws Exception {
		this.dynaDETemplModelMap.put(iDynaDETemplModel.getId(), iDynaDETemplModel);
		this.dynaDETemplModelMap.put(iDynaDETemplModel.getTemplDEName(), iDynaDETemplModel);
		this.dynaDETemplModelList.add(iDynaDETemplModel);
	}

	@Override
	public IDynaDETemplModel getDynaDETemplModel(String strDynaDETemplModelId) throws Exception {
		IDynaDETemplModel iDynaDETemplModel = this.dynaDETemplModelMap.get(strDynaDETemplModelId);
		if (iDynaDETemplModel == null) {
			throw new Exception(StringHelper.format("无法获取指定动态实体模板对象[%1$s]", strDynaDETemplModelId));
		}
		return iDynaDETemplModel;
	}

	@Override
	public Iterator<IDynaDETemplModel> getDynaDETemplModels() {
		return this.dynaDETemplModelList.iterator();
	}

	@Override
	public IWFModel getWFModel(String strWFModelId, boolean bTryMode) throws Exception {

		String strDynaInstId = WebContext.getDynaSysInstId(true);
		if (!StringHelper.isNullOrEmpty(strDynaInstId)) {
			IWFModel iWFModel = super.getWFModel(strWFModelId, true);
			if (iWFModel != null) {
				return iWFModel;
			}

			IDynaInstModel iDynaInstModel = this.getDynaInstModel(strDynaInstId);
			if (iDynaInstModel.containsDynaWFModel(strWFModelId)) {
				return iDynaInstModel.getDynaWFModel(strWFModelId);
			}

			IPSWorkflow iPSWorkflow = null;
			try {
				iPSWorkflow = this.getPSDynaInst().getPSWorkflow(strWFModelId);
			} catch (Exception ex) {
				log.error(ex);
			}

			if (iPSWorkflow == null) {
				if (bTryMode) {
					return null;
				}
				throw new Exception(StringHelper.format("无法获取指定流程，流程标识[%1$s]", strWFModelId));
			}

			IDynaWFRuntime iDynaWFRuntime = (IDynaWFRuntime) ObjectHelper.create("net.ibizsys.ssdynawf.core.DynaActivitiWFModel");
			iDynaWFRuntime.init(this, iPSWorkflow);

			// 注册到系统
			iDynaInstModel.registerDynaWFModel((IDynaWFModel) iDynaWFRuntime);

			final IWFModel iWFModel2 = (IWFModel) iDynaWFRuntime;

			ServiceWorkHelper.getInstance().execute(new IServiceWork() {
				@Override
				public void execute(ITransaction iTransaction) throws Exception {
					WFWorkflowService wfWorkflowService = (WFWorkflowService) ServiceGlobal.getService(WFWorkflowService.class);
					WFWorkflow wfWorkflow = new WFWorkflow();
					wfWorkflow.setWFWorkflowId(iWFModel2.getId());
					if (wfWorkflowService.checkKey(wfWorkflow) == IService.CHECKKEYSTATE_OK) {
						// 新建数据
						wfWorkflow.setWFWorkflowName(iWFModel2.getName());
						wfWorkflow.setWFState(1);
						if (!StringHelper.isNullOrEmpty(iWFModel2.getRemindMsgTemplId()))
							wfWorkflow.setRemindMsgTemplId(iWFModel2.getRemindMsgTemplId());
						wfWorkflow.setWFLogicName(iWFModel2.getName());
						wfWorkflow.setWFVersion(1);
						wfWorkflow.setWFModel("<?xml version=\"1.0\" encoding=\"utf-8\" ?><SRFEXWFWORKFLOW></SRFEXWFWORKFLOW>");
						wfWorkflow.set(IProcParam.TAG_PERSONID, "SYSTEM");
						wfWorkflow.set(IProcParam.TAG_PERSONNAME, "系统内建用户");
						wfWorkflowService.create(wfWorkflow);

						ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n", getName(), wfWorkflowService.getDEModel().getLogicName(), wfWorkflowService.getDEModel().getDataInfo(wfWorkflow)));
					}
				}
			});
			return iWFModel2;
		} else {
			return super.getWFModel(strWFModelId, bTryMode);
		}
	}

	@Override
	public IDataEntityModel getDataEntityModel(String strDEName, boolean bIncludeOtherSys) throws Exception {

		String strDynaInstId = WebContext.getDynaSysInstId(true);
		if (!StringHelper.isNullOrEmpty(strDynaInstId)) {
			// 有动态实例
			IDynaInstModel iDynaInstModel = this.getDynaInstModel(strDynaInstId);
			
			IDynaDEModel iDynaDEModel = iDynaInstModel.getDynaDEModel(strDEName,true);
			if(iDynaDEModel != null)
				return iDynaDEModel;

			if (super.containsDataEntityModel(strDEName, bIncludeOtherSys)) {
				return super.getDataEntityModel(strDEName, bIncludeOtherSys);
			}

			// 判断是否属于动态系统
			IPSDataEntity iPSDataEntity = null;
			try {
				iPSDataEntity = this.getPSDynaInst().getPSDataEntity(strDEName);
				if (iPSDataEntity == null) {
					throw new Exception(StringHelper.format("无法获取指定实体[%1$s]", strDEName));
				}

				iDynaDEModel = this.createDynaDEModel(iPSDataEntity);
				iDynaDEModel.init(this, iPSDataEntity);
				iDynaInstModel.registerDynaDEModel(iDynaDEModel);
				return iDynaDEModel;
			} catch (Exception ex) {
				throw ex;
			}
		} else {
			return super.getDataEntityModel(strDEName, bIncludeOtherSys);
		}

		//
		// IDataEntityModel iDataEntityModel = dynaDEModelMap.get(strDEName);
		// if(iDataEntityModel!=null)
		// return iDataEntityModel;
		//
		// if(super.containsDataEntityModel(strDEName, bIncludeOtherSys)) {
		// return super.getDataEntityModel(strDEName, bIncludeOtherSys);
		// }
		//
		// //判断是否属于动态系统
		// IPSDataEntity iPSDataEntity = null;
		// try {
		// iPSDataEntity = this.getPSSystem().getPSDataEntity(strDEName);
		// if(iPSDataEntity==null) {
		// throw new Exception(StringHelper.format("无法获取指定实体[%1$s]",
		// strDEName));
		// }
		// return this.getDynaDEModel(iPSDataEntity);
		// }
		// catch(Exception ex) {
		// throw ex;
		// }
	}

	@Override
	public IDynaInstModel getDynaInstModel(String strDynaInstId) throws Exception {
		
		// 获取指定动态实例
		IPSDynaInst iPSDynaInst = null;
		try {
			iPSDynaInst = this.getPSSystem(false).getPSDynaInst(strDynaInstId);
			if (iPSDynaInst == null) {
				throw new Exception(StringHelper.format("无法指定动态实例[%1$s]", strDynaInstId));
			}
		}
		catch (Exception ex) {
				throw ex;
		}
		IDynaInstModel iDynaInstModel = this.dynaInstMap.get(strDynaInstId);
		if (iDynaInstModel != null)
		{
			if(StringHelper.compare(iDynaInstModel.getDynaTag(),iPSDynaInst.getDynaTag(),true) == 0) {
				return iDynaInstModel;
			}
		}

		// 获取指定动态实例
		try {
			DynaInstModel dynaInstModel = new DynaInstModel();
			dynaInstModel.init(this, iPSDynaInst);
			this.dynaInstMap.put(strDynaInstId, dynaInstModel);
			return dynaInstModel;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public void resetDynaInstModel(String strDynaInstId) {
		try {
			this.getPSSystem(false).resetPSDynaInst(strDynaInstId);
		}
		catch(Exception ex) {
			log.error(ex);
		}
		this.dynaInstMap.remove(strDynaInstId);
	}

}
