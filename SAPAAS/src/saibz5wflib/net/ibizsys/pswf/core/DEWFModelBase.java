package net.ibizsys.pswf.core;

import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.IDEWFModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IView;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;

import org.hibernate.SessionFactory;

/**
 * 实体工作流模型基类
 * 
 * @author lionlau
 *
 */
public abstract class DEWFModelBase extends WFDEModelBase implements IDEWFModel {
	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DEWFModelBase.class);
	private IDataEntity iDataEntity = null;
	private IWFModel iWFModel = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEWF#init(net.ibizsys.paas.core.IDataEntity)
	 */
	public void init(IDataEntity iDataEntity) throws Exception {
		this.setDataEntity(iDataEntity);
		this.onInit();
	}

	/**
	 * 设置实体模型对象
	 * 
	 * @param iDataEntity
	 */
	protected void setDataEntity(IDataEntity iDataEntity) {
		this.iDataEntity = iDataEntity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntityObject#getDataEntity()
	 */
	@Override
	public IDataEntity getDataEntity() {
		return this.iDataEntity;
	}

	/**
	 * 获取实体模型对象
	 * 
	 * @return
	 */
	public IDataEntityModel getDEModel() {
		return (IDataEntityModel) getDataEntity();
	}

	/**
	 * 初始化触发
	 * 
	 * @throws Exception
	 */
	protected void onInit() throws Exception {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.pswf.core.WFDEModelBase#getWFModel()
	 */
	@Override
	public IWFModel getWFModel() {
		if (iWFModel == null) {
			try {
				ISystemModel iSystemModel = (ISystemModel) this.getDataEntity().getSystem();
				iWFModel = iSystemModel.getWFModel(this.getWorkflowId());
				this.setWFModel(iWFModel);
			} catch (Exception e) {
				log.error(e);
			}
		}
		return super.getWFModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.ibizsys.pswf.core.IWFDEModel#getWFEditViewPDTParam(net.ibizsys.paas
	 * .entity.IEntity, boolean)
	 */
	@Override
	public String getWFEditViewPDTParam(IEntity iEntity, boolean bWorkMode) throws Exception {
		return getWFEditViewPDTParam(iEntity, bWorkMode, IApplication.APPTYPE_UNKNOWN);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEWF#getWFEditViewPDTParam(net.ibizsys.paas.entity.IEntity, boolean, int)
	 */
	@Override
	public String getWFEditViewPDTParam(IEntity iEntity, boolean bWorkMode, int nAppType) throws Exception {
		// 判断数据是否在流程中
		boolean bWorkFlow = this.testDataInWF(iEntity);
		if (bWorkFlow) {
			boolean bMultiForm = getDEModel().isEnableMultiForm();
			Object multiFormValue = null;
			if (bMultiForm) {
				multiFormValue = iEntity.get(getDEModel().getMultiFormDEField().getName());
				if (multiFormValue == null) {
					throw new Exception(StringHelper.format("无法获取多表单识别数据"));
				}
			}
			Object wfStepValue = iEntity.get(this.getWFStepField());
			int nVer = 1;
			if (!StringHelper.isNullOrEmpty(this.getWFVerField())) {
				nVer = DataObject.getIntegerValue(iEntity, this.getWFVerField(), nVer);
			}
			if(nAppType == IApplication.APPTYPE_MOBILE){
				if (multiFormValue == null) {
					if (bWorkMode) {
						return IView.PREDEFINEDVIEWTYPE_MOBWFEDITVIEW + ":" + StringHelper.format("%1$s:%3$sW:%2$s", this.getName(), wfStepValue, ((nVer == 1) ? "" : nVer));
					} else {
						return IView.PREDEFINEDVIEWTYPE_MOBWFEDITVIEW + ":" + StringHelper.format("%1$s:D", this.getName());
					}
				} else {
					if (bWorkMode) {
						return IView.PREDEFINEDVIEWTYPE_MOBWFEDITVIEW + ":" + StringHelper.format("%3$s:%1$s:%4$sW:%2$s", this.getName(), wfStepValue, multiFormValue, ((nVer == 1) ? "" : nVer));
					} else {
						return IView.PREDEFINEDVIEWTYPE_MOBWFEDITVIEW + ":" + StringHelper.format("%2$s:%1$s:D", this.getName(), multiFormValue);
					}
				}
			}
			else{
				if (multiFormValue == null) {
					if (bWorkMode) {
						return IView.PREDEFINEDVIEWTYPE_WFEDITVIEW + ":" + StringHelper.format("%1$s:%3$sW:%2$s", this.getName(), wfStepValue, ((nVer == 1) ? "" : nVer));
					} else {
						return IView.PREDEFINEDVIEWTYPE_WFEDITVIEW + ":" + StringHelper.format("%1$s:D", this.getName());
					}
				} else {
					if (bWorkMode) {
						return IView.PREDEFINEDVIEWTYPE_WFEDITVIEW + ":" + StringHelper.format("%3$s:%1$s:%4$sW:%2$s", this.getName(), wfStepValue, multiFormValue, ((nVer == 1) ? "" : nVer));
					} else {
						return IView.PREDEFINEDVIEWTYPE_WFEDITVIEW + ":" + StringHelper.format("%2$s:%1$s:D", this.getName(), multiFormValue);
					}
				}
			}
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.ibizsys.pswf.core.IWFDEModel#testUserWFSubmit(net.ibizsys.paas.entity
	 * .IEntity, java.lang.String, org.hibernate.SessionFactory)
	 */
	@Override
	public boolean testUserWFSubmit(IEntity iEntity, String strCurUserId, SessionFactory sessionFactory) throws Exception {
		String strWFInstId = DataObject.getStringValue(iEntity, this.getWFInstField(), null);
		if (StringHelper.isNullOrEmpty(strWFInstId)) {
			throw new Exception(StringHelper.format("当前数据没有流程实例标示"));
		}
		WFInstanceService wfInstanceService = (WFInstanceService) ServiceGlobal.getService(WFInstanceService.class, sessionFactory);
		WFInstance wfInstance = new WFInstance();
		wfInstance.setWFInstanceId(strWFInstId);
		wfInstanceService.get(wfInstance);

		String strStepId = wfInstance.getActiveStepName();

		IWFService iWFService = this.getWFModel().getWFService();
		// 判断是否允许编辑
		WFActionParam wfActionParam = new WFActionParam();
		wfActionParam.setUserData((String) iEntity.get(this.getDEModel().getKeyDEField().getName()));
		wfActionParam.setUserData4(this.getDEModel().getId());
		wfActionParam.setOpPersonId(strCurUserId);
		wfActionParam.setStepId(strStepId);
		wfActionParam.setTestMode(true);
		WFActionResult wfActionResult = iWFService.submit(wfActionParam);
		if (wfActionResult.isError()) {
			return false;
		}
		return true;
	}

}
