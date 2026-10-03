package net.ibizsys.paas.security;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.ActionContext;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDEMainState;
import net.ibizsys.paas.core.IDER1N;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDEFieldDiffItem;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDER1NModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.entity.IEntityActionSupporter;
import net.ibizsys.paas.logic.ICondition;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DEModelUtil;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.DataAudit;
import net.ibizsys.psrt.srv.common.entity.DataAuditDetail;
import net.ibizsys.psrt.srv.common.entity.UserRoleData;
import net.ibizsys.psrt.srv.common.service.DataAuditDetailService;
import net.ibizsys.psrt.srv.common.service.DataAuditService;

/**
 * 数据访问权限检查对象
 * 
 * @author Administrator
 * 
 */
public class DEDataAccMgr implements IDEDataAccMgr {
	
	private static final Log log = LogFactory.getLog(DEDataAccMgr.class);

	public final static String SYSUNIRES_PREFIX = "SRFUR__";

	public final static int LEN_SYSUNIRES_PREFIX = 7;

	protected abstract class getFullEntityActionHelper implements IEntityActionHelper {

		@Override
		public void create(IEntity iEntity) throws Exception {
			throw new Exception("没有实现");
		}

		@Override
		public void update(IEntity iEntity) throws Exception {
			throw new Exception("没有实现");
		}

		@Override
		public void save(IEntity iEntity) throws Exception {
			throw new Exception("没有实现");
		}

		@Override
		public void remove(IEntity iEntity) throws Exception {
			throw new Exception("没有实现");
		}

		@Override
		public boolean select(IEntity iEntity, boolean bTryMode) throws Exception {
			throw new Exception("没有实现");
		}

	}

	private IDataEntityModel iDEModel = null;

	/**
	 * 数据操作集合
	 */
	protected String strDataActions = "";
	
	
	 

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IDEDataAccMgr#init(net.ibizsys.paas.demodel.IDataEntityModel)
	 */
	@Override
	public void init(IDataEntityModel iDEModel) throws Exception {
		this.iDEModel = iDEModel;

		onInit();
	}

	/**
	 * 初始化
	 */
	protected void onInit() throws Exception {

	}

	/**
	 * 获取实体模型对象
	 * 
	 * @return
	 */
	protected IDataEntityModel getDEModel() {
		return this.iDEModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IDEDataAccMgr#test(net.ibizsys.paas.web.IWebContext, net.ibizsys.paas.entity.IEntity, java.lang.String)
	 */
	@Override
	public CallResult test(IWebContext webContext, IEntity dataEntity, String strAction) throws Exception {
		return test(webContext, dataEntity, strAction, false);
	}

	/**
	 * 判断访问是否允许
	 * 
	 * @param webContext 网络请求上下文对象
	 * @param strCurPersonId 当前用户标识
	 * @param dataEntity 访问数据对象
	 * @param strAction 访问行为
	 * @param bCache 缓存模式
	 * @return
	 * @throws Exception
	 */
	protected CallResult internalTest(IWebContext webContext, String strCurPersonId, IEntity dataEntity, String strAction, boolean bCache) throws Exception {
		CallResult callResult = new CallResult();
		callResult.setRetCode(Errors.OK);

		if (StringHelper.isNullOrEmpty(strAction) || (StringHelper.compare(strAction, DataAccessActions.NONE, true) == 0)) {
			return callResult;
		}

		if (StringHelper.compare(strAction, DataAccessActions.DENY, true) == 0) {
			callResult.setRetCode(Errors.ACCESSDENY);
			return callResult;
		}
		
		/**
		 * 20180204修改，如实体设置为无权限控制，则会立刻返回（有权限）
		 */
		if(this.iDEModel.getDataAccCtrlMode()==IDataEntityModel.DATAACCCTRL_NONE){
			return callResult;
		}

		strAction = strAction.toUpperCase();
		String strValue = "";
		if (dataEntity != null) {
			strValue = DataObject.getStringValue(dataEntity, iDEModel.getKeyDEField().getName(), "");
		}
		if (this.iDEModel.getDataAccCtrlMode() == IDataEntityModel.DATAACCCTRL_MASTER 
				||this.iDEModel.getDataAccCtrlMode() == IDataEntityModel.DATAACCCTRL_MASTER_SELF) {
			// 获取主实体
			IDER1N iDER1N = this.getDEModel().getAccMasterDER(dataEntity);
			if (iDER1N == null) {
				/**
				 * 20180206 解决递归检查权限时不知道父数据的问题
				 */
				if(!StringHelper.isNullOrEmpty(strValue) && !KeyValueHelper.isTempKey(strValue)){
					dataEntity = getFullEntity(webContext, dataEntity, bCache);
					iDER1N = this.getDEModel().getAccMasterDER(dataEntity);
				}
				if (iDER1N == null) {
					throw new Exception(webContext.getLocalization("ERROR.STD.NOMAJORDATAENTITY", "无法找到权限主实体"));
				}
			}

			String strMajorAction = this.getDEModel().getMapDEOPPrivTag(strAction, iDER1N.getName());
			if (StringHelper.isNullOrEmpty(strMajorAction) && this.iDEModel.getDataAccCtrlMode() == IDataEntityModel.DATAACCCTRL_MASTER) {
				if (StringHelper.compare(strAction, DataAccessActions.READ, true) == 0)
					strMajorAction = DataAccessActions.READ;
				else
					strMajorAction = DataAccessActions.UPDATE;
			}

			if(!StringHelper.isNullOrEmpty(strMajorAction)){
				IDataEntityModel majorDEModel = ((IDER1NModel) iDER1N).getMajorDEModel();
				Object objValue = dataEntity.get(iDER1N.getPickupDEFName());
				return webContext.getUserPrivilegeMgr().testDataAccessAction(webContext, majorDEModel, objValue, strMajorAction);
			}
		}

		
		if ((StringHelper.compare(strAction, DataAccessActions.CREATE, true) == 0) || ((StringHelper.compare(strAction, DataAccessActions.UPDATE, true) == 0) && StringHelper.isNullOrEmpty(strValue))) {
			// 超级用户或机构
			if (webContext.isSuperUser() || webContext.isOrgAdmin()) {
				return callResult;
			}

			// callResult.setRetCode(testUserRoleDataAction(webContext, dataEntity, DataAccessActions.CREATE) ? Errors.OK : Errors.ACCESSDENY);
			return testUserRoleDataAction(webContext, dataEntity, strValue, DataAccessActions.CREATE);
		}

		if ((StringHelper.compare(strAction, DataAccessActions.WFSTART, true) == 0) && StringHelper.isNullOrEmpty(strValue)) {
			// 超级用户或机构
			if (webContext.isSuperUser() || webContext.isOrgAdmin()) {
				return callResult;
			}

			return testUserRoleDataAction(webContext, dataEntity, strValue, DataAccessActions.WFSTART);

		}

		if (StringHelper.isNullOrEmpty(strValue)) {
			/**
			 * 20170915 修改，无键值时不再抛出异常，调整为访问拒绝
			 */
			callResult.setRetCode(Errors.ACCESSDENY);
			callResult.setErrorInfo(webContext.getLocalization("ERROR.STD.SYS.ACCESSDENY", "没有指定数据键值"));
			return callResult;
			// throw new ErrorException(Errors.INTERNALERROR, webContext.getLocalization("ERROR.STD.SYS.ACCESSDENY", "没有指定数据键值"));
		}

		// 判断是否为临时数据
		if (KeyValueHelper.isTempKey(strValue)) {
			return callResult;
		}

		// 判断数据的性质
		if (StringHelper.compare(strAction, DataAccessActions.READ, true) != 0) {
			// 判断是否在流程中
			if ((StringHelper.compare(strAction, DataAccessActions.WFSTART,true)==0)||(strAction.indexOf("WF") != 0)) {
				dataEntity = getFullEntity(webContext, dataEntity, bCache);
				if (this.getDEModel().testDataInWF(dataEntity) != null) {
					callResult.setRetCode(Errors.ACCESSDENY);
					callResult.setErrorInfo(webContext.getLocalization("ERROR.STD.WF.DATAINPROCESS", "数据在流程中，无法进行操作"));
					return callResult;
				}
			}

			// 判断主状态
			if (this.getDEModel().hasDEMainState()) {
				dataEntity = getFullEntity(webContext, dataEntity, bCache);
				IDEMainState iDEMainState = this.getDEModel().getDEMainState(dataEntity);
				if (iDEMainState != null) {
					if (!iDEMainState.testDEOPPriv(strAction)) {
						callResult.setRetCode(Errors.ACCESSDENY);
						callResult.setErrorInfo(this.getDEModel().getDEMainStateDenyMsg(iDEMainState, dataEntity, 2, strAction));
						return callResult;
					}
				}
			}
		}

		if (webContext.isSuperUser()) return callResult;
		if (webContext.isOrgAdmin()) {
			dataEntity = getFullEntity(webContext, dataEntity, bCache);
			// 判断数据是当前组织
			Object objOrgId = this.getDEModel().getOrgId(dataEntity);
			if (objOrgId != null) {
				if (StringHelper.compare(objOrgId.toString(), webContext.getCurOrgId(), false) == 0) {
					return callResult;
				}
			}
		}

		return testUserRoleDataAction(webContext, dataEntity, strValue, strAction);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IDEDataAccMgr#audit(java.lang.String, net.ibizsys.paas.web.IWebContext, net.ibizsys.paas.entity.IEntity, net.ibizsys.paas.entity.IEntity, java.lang.String)
	 */
	@Override
	public void audit(String strAuditInfo, IWebContext webContext, IEntity dataEntity, IEntity lastDataEntity, String strAction) throws Exception {
		if (webContext != null) {
			audit(strAuditInfo, webContext.getCurUserId(), webContext.getCurUserName(), webContext.getRemoteAddr(), dataEntity, lastDataEntity, strAction);
			return;
		}
		if (ActionContext.getCurrent() != null) {
			IActionContext iActionContext = ActionContext.getCurrent();
			audit(strAuditInfo, iActionContext.getOperator(), iActionContext.getOperatorName(), iActionContext.getRemoteAddr(), dataEntity, lastDataEntity, strAction);
			return;
		}

		audit(strAuditInfo, "", "", "", dataEntity, lastDataEntity, strAction);
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IDEDataAccMgr#audit(java.lang.String, java.lang.String, java.lang.String, java.lang.String, net.ibizsys.paas.entity.IEntity, net.ibizsys.paas.entity.IEntity, java.lang.String)
	 */
	@Override
	public void audit(String strAuditInfo, String strOpPersonId, String strOpPersonName, String strFromIpAddress, IEntity dataEntity, IEntity lastDataEntity, String strAction) throws Exception {
		IDataEntityModel majorDEModel = null;
		String strMajorDEPickupField = "";
		if (this.iDEModel.getDataAccCtrlMode() == IDataEntityModel.DATAACCCTRL_MASTER
				||this.iDEModel.getDataAccCtrlMode() == IDataEntityModel.DATAACCCTRL_MASTER_SELF) {
			// 获取主实体
			IDER1N iDER1N = this.getDEModel().getAccMasterDER(dataEntity);
			if (iDER1N == null) {
				throw new Exception(WebContext.getCurrent().getLocalization("ERROR.STD.NOMAJORDATAENTITY", "无法找到权限主实体"));
			}
			strMajorDEPickupField = iDER1N.getPickupDEFName();
			majorDEModel = ((IDER1NModel) iDER1N).getMajorDEModel();
		}

		if (!iDEModel.isEnableAudit()) {
			if (majorDEModel == null) {
				return;
			} else if (!majorDEModel.isEnableAudit()) {
				return;
			}
		}

		String strDataInfo = iDEModel.getDataInfo(dataEntity);

		boolean bFirst = true;
		StringBuilderEx info = new StringBuilderEx();
		if (!StringHelper.isNullOrEmpty(strAuditInfo)) {
			info.append(strAuditInfo);
			bFirst = false;
		}

		ArrayList<IDEFieldDiffItem> deFieldDiffItemList = null;
		if (lastDataEntity != null) {
			deFieldDiffItemList = DEModelUtil.getDEDataDiffItems(this.getDEModel(), dataEntity, lastDataEntity, true);
			for (IDEFieldDiffItem iDEFieldDiffItem : deFieldDiffItemList) {
				if (bFirst)
					bFirst = false;
				else {
					info.append("\r\n");
				}
				String strAuditInfoFormat = iDEFieldDiffItem.getDEField().getAuditInfoFormat();
				info.append(strAuditInfoFormat, iDEFieldDiffItem.getDEField().getLogicName(""), iDEFieldDiffItem.getOldText(), iDEFieldDiffItem.getNewText());
			}
		}
		
		if(StringHelper.isNullOrEmpty(this.getDEModel().getAuditDEName())){
			DataAudit dataAudit = new DataAudit();

			dataAudit.setDataAuditId(KeyValueHelper.genGuidEx());
			dataAudit.setOpPersonId(strOpPersonId);
			dataAudit.setOpPersonName(strOpPersonName);
			dataAudit.setIPAddress(strFromIpAddress);
			dataAudit.setObjectType(iDEModel.getId());
			dataAudit.setObjectId(DataObject.getStringValue(dataEntity, iDEModel.getKeyDEField().getName(), ""));
			dataAudit.setAuditInfo(info.toString());
			dataAudit.setAuditType(strAction);
			dataAudit.setDataAuditName(StringHelper.format("[%1$s]%2$s", strAction, strDataInfo));
			EntityBase.setIgnoreCheckKey(dataAudit, false);
			DataAuditService dataAuditService = (DataAuditService) ServiceGlobal.getService(DataAuditService.class);
			dataAuditService.create(dataAudit, false);

			// 判断是否记录明细
			if (this.getDEModel().isLogAuditDetail() && deFieldDiffItemList != null) {
				DataAuditDetailService dataAuditDetailService = (DataAuditDetailService) ServiceGlobal.getService(DataAuditDetailService.class);
				for (IDEFieldDiffItem iDEFieldDiffItem : deFieldDiffItemList) {
					DataAuditDetail dataAuditDetail = new DataAuditDetail();
					dataAuditDetail.setDataAuditDetailName(iDEFieldDiffItem.getDEField().getName());
					if (iDEFieldDiffItem.getOldValue() != null) dataAuditDetail.setOldValue(iDEFieldDiffItem.getOldValue().toString());
					if (iDEFieldDiffItem.getNewValue() != null) dataAuditDetail.setNewValue(iDEFieldDiffItem.getNewValue().toString());
					dataAuditDetail.setOldText(iDEFieldDiffItem.getOldText());
					dataAuditDetail.setNewText(iDEFieldDiffItem.getNewText());
					dataAuditDetail.setDataAuditId(dataAudit.getDataAuditId());
					dataAuditDetailService.create(dataAuditDetail, false);
				}
			}
		}
		else{
			
			IService dataAuditService = DEModelGlobal.getDEModel(this.getDEModel().getAuditDEName()).getService();
			IEntity dataAudit = dataAuditService.getDEModel().createEntity();

			dataAudit.set(dataAuditService.getDEModel().getKeyDEField().getName(),KeyValueHelper.genGuidEx());
			dataAudit.set(DataAudit.FIELD_OPPERSONID,strOpPersonId);
			dataAudit.set(DataAudit.FIELD_OPPERSONNAME,strOpPersonName);
			dataAudit.set(DataAudit.FIELD_IPADDRESS,strFromIpAddress);
			dataAudit.set(DataAudit.FIELD_OBJECTTYPE,iDEModel.getId());
			dataAudit.set(DataAudit.FIELD_OBJECTID,DataObject.getStringValue(dataEntity, iDEModel.getKeyDEField().getName(), ""));
			dataAudit.set(DataAudit.FIELD_AUDITINFO,info.toString());
			dataAudit.set(DataAudit.FIELD_AUDITTYPE,strAction);
			dataAudit.set(dataAuditService.getDEModel().getMajorDEField().getName(),StringHelper.format("[%1$s]%2$s", strAction, strDataInfo));
			EntityBase.setIgnoreCheckKey(dataAudit, false);
			dataAuditService.create(dataAudit, false);

			// 判断是否记录明细
			if (this.getDEModel().isLogAuditDetail() && deFieldDiffItemList != null && (!StringHelper.isNullOrEmpty(this.getDEModel().getAuditDetailDEName()))) {
				IService dataAuditDetailService = DEModelGlobal.getDEModel(this.getDEModel().getAuditDetailDEName()).getService();
				for (IDEFieldDiffItem iDEFieldDiffItem : deFieldDiffItemList) {
					IEntity dataAuditDetail = dataAuditDetailService.getDEModel().createEntity();
					dataAuditDetail.set(dataAuditDetailService.getDEModel().getMajorDEField().getName(),iDEFieldDiffItem.getDEField().getName());
					if (iDEFieldDiffItem.getOldValue() != null) dataAuditDetail.set(DataAuditDetail.FIELD_OLDVALUE,iDEFieldDiffItem.getOldValue().toString());
					if (iDEFieldDiffItem.getNewValue() != null) dataAuditDetail.set(DataAuditDetail.FIELD_NEWVALUE,iDEFieldDiffItem.getNewValue().toString());
					dataAuditDetail.set(DataAuditDetail.FIELD_OLDTEXT,iDEFieldDiffItem.getOldText());
					dataAuditDetail.set(DataAuditDetail.FIELD_NEWTEXT,iDEFieldDiffItem.getNewText());
					dataAuditDetail.set(dataAuditService.getDEModel().getKeyDEField().getName(),dataAudit.get(dataAuditService.getDEModel().getKeyDEField().getName()));
					dataAuditDetailService.create(dataAuditDetail, false);
				}
			}
			
		}

		

		// 当前非主数据，执行父数据更新审计
		if (majorDEModel != null) {
			IEntity temp = majorDEModel.createEntity();
			temp.set(majorDEModel.getKeyDEField().getName(), dataEntity.get(strMajorDEPickupField));
			majorDEModel.getService().get(temp);
			majorDEModel.getDEDataAccMgr().audit(StringHelper.format("[%1$s]%2$s", strAction, strDataInfo), strOpPersonId, strOpPersonName, strFromIpAddress, temp, null, DataAccessActions.UPDATE);
		}

	}

	/**
	 * 获取实体定义的数据操作标识
	 * 
	 * @return
	 */
	public String getDataActions() {
		return this.strDataActions;
	}

	// /**
	// * 计算当前数据实体
	// * @param dataEntity
	// * @param strCurPersonId
	// * @return
	// */
	// protected void getCurEntity (IEntity dataEntity,String
	// strCurPersonId)throws Exception
	// {
	// CallResult callResult = new CallResult();
	// IEntity curDataEntity = this.getDEModel().createEntity();
	// dataEntity.copyTo(curDataEntity, true);
	//
	// String strValue =
	// dataEntity.GetParamStringValue(iDEModel.getKeyDEField().getName(), "");
	// if(StringHelper.isNullOrEmpty(strValue))
	// {
	// strValue = dataEntity.GetParamStringValue("SRFDATEMPKEYID", "");
	// }
	//
	// if(StringHelper.isNullOrEmpty(strValue))
	// {
	// throw new ErrorException(Errors.INTERNALERROR,"没有指定数据键值");
	// }
	//
	// //判断是否为临时数据
	// if(KeyHelper.isTempKey(strValue))
	// {
	// callResult.setUserObject(curDataEntity);
	// return callResult;
	// }
	//
	// callResult =
	// this.iDEModel.GetDEDataCtrl(strCurPersonId,null).Get(curDataEntity);
	// if(callResult.getRetCode()!=Errors.OK)
	// return callResult;
	//
	// callResult.setUserObject(curDataEntity);
	// return callResult;
	// }

	/**
	 * 获取实体服务对象
	 * 
	 * @return
	 * @throws Exception
	 */
	protected IService getService() throws Exception {
		return this.getDEModel().getService();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IDEDataAccMgr#test(net.ibizsys.paas.web.IWebContext, java.lang.Object, java.lang.String)
	 */
	@Override
	public CallResult test(IWebContext webContext, Object objKey, String strAction) throws Exception {
		return this.test(webContext, objKey, strAction, false);
	}

	/**
	 * 获取完整数据对象信息
	 * 
	 * @param webContext
	 * @param iEntity
	 * @param bCache
	 * @return
	 * @throws Exception
	 */
	protected IEntity getFullEntity(IWebContext webContext, IEntity iEntity, boolean bCache) throws Exception {
		if (iEntity.isFullEntity()) {
			return iEntity;
		}

		/**
		 * 20170911 修改
		 */
		if (iEntity instanceof IEntityActionSupporter) {
			if (((IEntityActionSupporter) iEntity).getActionHelper() != null){
				/**
				 * 20180206 修改，修复获取数据
				 */
				((IEntityActionSupporter) iEntity).get();
				return iEntity;
			}
		}

		String strKeyTag = null;
		if (bCache) {
			strKeyTag = StringHelper.format("%1$s_%2$s", this, iEntity.get(this.getDEModel().getKeyDEField().getName()));
			Object objRet = webContext.getAttribute(strKeyTag);
			if (objRet != null) {
				IEntity fullEntity = (IEntity) objRet;
				fullEntity.copyTo(iEntity, true);
				return iEntity;
			}
		}

		getDEModel().getService().executeAction(IService.ACTION_GET, iEntity);
		if (bCache) {
			IEntity fullEntity = this.getDEModel().createEntity();
			iEntity.copyTo(fullEntity, false);
			webContext.setAttribute(strKeyTag, fullEntity);
		}
		return iEntity;
	}

	/**
	 * 获取完整数据对象信息
	 * 
	 * @param webContext
	 * @param iEntity
	 * @param bCache
	 * @return
	 * @throws Exception
	 */
	protected IEntity getFullEntity2(IWebContext webContext, IEntity iEntity, boolean bCache) throws Exception {
		if (iEntity.isFullEntity()) {
			return iEntity;
		}

		String strKeyTag = null;
		if (bCache) {
			strKeyTag = StringHelper.format("%1$s_%2$s", this, iEntity.get(this.getDEModel().getKeyDEField().getName()));
			Object objRet = webContext.getAttribute(strKeyTag);
			if (objRet != null) {
				IEntity fullEntity = (IEntity) objRet;
				fullEntity.copyTo(iEntity, true);
				return iEntity;
			}
		}

		getDEModel().getService().executeAction(IService.ACTION_GET, iEntity);
		if (bCache) {
			IEntity fullEntity = this.getDEModel().createEntity();
			iEntity.copyTo(fullEntity, false);
			webContext.setAttribute(strKeyTag, fullEntity);
		}
		return iEntity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IDEDataAccMgr#test(net.ibizsys.paas.web.IWebContext, java.lang.Object, java.lang.String, boolean)
	 */
	@Override
	public CallResult test(IWebContext webContext, Object objKey, String strAction, boolean bCache) throws Exception {
		if (StringHelper.isNullOrEmpty(strAction) || (StringHelper.compare(strAction, DataAccessActions.NONE, true) == 0)) {
			return new CallResult();
		}

		if (StringHelper.compare(strAction, DataAccessActions.DENY, true) == 0) {
			CallResult callResult = new CallResult();
			callResult.setRetCode(Errors.ACCESSDENY);
			return callResult;
		}

		if (strAction.indexOf(SYSUNIRES_PREFIX) == 0) {
			if (!webContext.getUserPrivilegeMgr().test(webContext, strAction.substring(LEN_SYSUNIRES_PREFIX))) {
				CallResult callResult = new CallResult();
				callResult.setRetCode(Errors.ACCESSDENY);
				return callResult;
			}
		}

		String strKeyTag = null;
		if (bCache) {
			strKeyTag = StringHelper.format("%1$s_%2$s_%3$s", this, objKey, strAction);
			Object objRet = webContext.getAttribute(strKeyTag);
			if (objRet != null && objRet instanceof CallResult) {
				CallResult callResult = new CallResult();
				callResult.from((CallResult) objRet);
				return callResult;
			}
		}

		IEntity iEntity = this.getDEModel().createEntity();
		iEntity.set(this.getDEModel().getKeyDEField().getName(), objKey);
		return this.test(webContext, iEntity, strAction, bCache);
	}

	@Override
	public CallResult test(IWebContext webContext, IEntity dataEntity, String strAction, boolean bCache) throws Exception {

		if (StringHelper.isNullOrEmpty(strAction) || (StringHelper.compare(strAction, DataAccessActions.NONE, true) == 0)) {
			return new CallResult();
		}

		if (StringHelper.compare(strAction, DataAccessActions.DENY, true) == 0) {
			CallResult callResult = new CallResult();
			callResult.setRetCode(Errors.ACCESSDENY);
			return callResult;
		}

		if (strAction.indexOf(SYSUNIRES_PREFIX) == 0) {
			if (!webContext.getUserPrivilegeMgr().test(webContext, strAction.substring(LEN_SYSUNIRES_PREFIX))) {
				CallResult callResult = new CallResult();
				callResult.setRetCode(Errors.ACCESSDENY);
				return callResult;
			} else {
				return new CallResult();
			}
		}

		String strKeyTag = null;
		if (bCache) {
			strKeyTag = StringHelper.format("%1$s_%2$s_%3$s", this, dataEntity.get(this.getDEModel().getKeyDEField().getName()), strAction);
			Object objRet = webContext.getAttribute(strKeyTag);
			if (objRet != null && objRet instanceof CallResult) {
				CallResult callResult = new CallResult();
				callResult.from((CallResult) objRet);
				return callResult;
			}
		}

		CallResult ret = null;
		if (dataEntity != null) {
			if (dataEntity.isFullEntity()) {
				ret = internalTest(webContext, webContext.getCurUserId(), dataEntity, strAction, bCache);
			} else {
				if (dataEntity instanceof IEntityActionSupporter) {
					final IEntityActionSupporter iEntityActionSupporter = (IEntityActionSupporter) dataEntity;
					final IEntityActionHelper lastEntityActionHelper = iEntityActionSupporter.getActionHelper();
					final IWebContext iWebContext = webContext;
					final boolean bCache2 = bCache;
					iEntityActionSupporter.setActionHelper(new getFullEntityActionHelper() {
						@Override
						public boolean get(IEntity iEntity, boolean bTryMode) throws Exception {
							getFullEntity2(iWebContext, iEntity, bCache2);
							return true;
						}

					});
					ret = internalTest(webContext, webContext.getCurUserId(), dataEntity, strAction, bCache);
					iEntityActionSupporter.setActionHelper(lastEntityActionHelper);
				} else {
					ret = internalTest(webContext, webContext.getCurUserId(), dataEntity, strAction, bCache);
				}
			}
		} else {
			ret = internalTest(webContext, webContext.getCurUserId(), dataEntity, strAction, bCache);
		}

		if (bCache) {
			CallResult callResult = new CallResult();
			callResult.from(ret);
			webContext.setAttribute(strKeyTag, callResult);
		}
		return ret;
	}

	/**
	 * 测试用户角色的数据操作能力
	 * 
	 * @param webContext
	 * @param dataEntity
	 * @param strAction
	 * @return
	 * @throws Exception
	 */
	protected CallResult testUserRoleDataAction(IWebContext webContext, IEntity dataEntity, String strKeyValue, String strAction) throws Exception {
		CallResult callResult = new CallResult();
		callResult.setRetCode(Errors.OK);
		
		if(this.getDEModel().getDataAccCtrlArch() == IDataEntity.DATAACCCTRLARCH_RTSYSROLE){
			IUserRoleMgr iUserRoleMgr = webContext.getUserRoleMgr();
			if ((StringHelper.compare(strAction, DataAccessActions.CREATE, true) == 0) || (StringHelper.compare(strAction, DataAccessActions.WFSTART, true) == 0)) {
				callResult.setRetCode(iUserRoleMgr.testUserRoleDataAction(getDEModel(), dataEntity, strAction) ? Errors.OK : Errors.ACCESSDENY);
				return callResult;
			} else {
				ArrayList<UserRoleData> list = iUserRoleMgr.getUserRoleDatas(this.getDEModel().getId(), strAction);
				if (list != null) {
					ArrayList<String> condList = new ArrayList<String>();
					for (UserRoleData userRoleData : list) {
						String strCode = iUserRoleMgr.getUserRoleDataCond(this.getService(), userRoleData);
						if (!StringHelper.isNullOrEmpty(strCode)) {
							condList.add(strCode);
						}
					}

					if (condList.size() == 0) {
						callResult.setRetCode(Errors.ACCESSDENY);
						return callResult;
					}

					boolean bOk = false;
					// 执行查询
					IDEField orgIdDEField = this.getDEModel().getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGID, true);
					IDEField secIdDEField = this.getDEModel().getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGSECTORID, true);

					DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(null);
					deDataSetFetchContextImpl.setStartRow(0);
					deDataSetFetchContextImpl.setPageSize(1);
					DEDataSetFetchContext.enableOrgDRCond(deDataSetFetchContextImpl, orgIdDEField, secIdDEField, condList);
					DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
					deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_DEFIELD);
					deDataSetCondImpl.setCondOp(ICondition.CONDOP_EQ);
					deDataSetCondImpl.setDEFName(this.getDEModel().getKeyDEField().getName());
					deDataSetCondImpl.setCondValue(strKeyValue);
					deDataSetFetchContextImpl.getConditionList().add(deDataSetCondImpl);

					deDataSetFetchContextImpl.setFetchTotalRow(false);
					// deDataSetFetchContextImpl.setStartRow(1
					long nBeginTime = java.lang.System.currentTimeMillis();
					try {
						SessionFactoryManager.addRef();
						DBFetchResult fetchResult = this.getService().getDAO().fetchDEDataQuery(deDataSetFetchContextImpl, "DEFAULT", false);
						if (fetchResult.getDataSet().getDataTable(0).getCachedRowCount() == -1) fetchResult.getDataSet().cacheDataRow();
						if (fetchResult.getDataSet().getDataTable(0).getCachedRowCount() > 0) {
							bOk = true;
						}

						fetchResult.getDataSet().close();
						if (!bOk) {
							callResult.setRetCode(Errors.ACCESSDENY);
						}

						long nTime = java.lang.System.currentTimeMillis() - nBeginTime;
						log.debug(StringHelper.format("查询耗时[%1$s]", nTime));
						SessionFactoryManager.releaseRef(false);

						return callResult;
					} catch (Exception ex) {
						log.error(StringHelper.format("实体[%1$s]权限检查代码发生异常，%2$s", this.getDEModel().getName(), ex.getMessage()), ex);
						SessionFactoryManager.releaseRef(false);
						throw ex;
					}

				} else {
					callResult.setRetCode(Errors.ACCESSDENY);
					return callResult;
				}
			}
		}
		
		if(this.getDEModel().getDataAccCtrlArch() == IDataEntity.DATAACCCTRLARCH_SYSROLE_DEROLE){
			IUserRoleMgr2 iUserRoleMgr2 = WebContext.getUserRoleMgr2(webContext);
			if ((StringHelper.compare(strAction, DataAccessActions.CREATE, true) == 0) || (StringHelper.compare(strAction, DataAccessActions.WFSTART, true) == 0)) {
				callResult.setRetCode(iUserRoleMgr2.testDEOPPrivRoleAction(webContext, this.getDEModel(), dataEntity, strAction)? Errors.OK : Errors.ACCESSDENY);
				return callResult;
			} else {
				DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(null);
				String strCode = iUserRoleMgr2.getDEOPPrivRoleCond(this.getService(), strAction, deDataSetFetchContextImpl);
				ArrayList<String> condList = new ArrayList<String>();
				if(!StringHelper.isNullOrEmpty(strCode)){
					condList.add(strCode);
				}
				if (condList.size() == 0) {
					callResult.setRetCode(Errors.ACCESSDENY);
					return callResult;
				}

				boolean bOk = false;
				// 执行查询
				IDEField orgIdDEField = this.getDEModel().getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGID, true);
				IDEField secIdDEField = this.getDEModel().getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGSECTORID, true);
				
				deDataSetFetchContextImpl.setStartRow(0);
				deDataSetFetchContextImpl.setPageSize(1);
				DEDataSetFetchContext.enableOrgDRCond(deDataSetFetchContextImpl, orgIdDEField, secIdDEField, condList);
				DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
				deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_DEFIELD);
				deDataSetCondImpl.setCondOp(ICondition.CONDOP_EQ);
				deDataSetCondImpl.setDEFName(this.getDEModel().getKeyDEField().getName());
				deDataSetCondImpl.setCondValue(strKeyValue);
				deDataSetFetchContextImpl.getConditionList().add(deDataSetCondImpl);

				deDataSetFetchContextImpl.setFetchTotalRow(false);
				// deDataSetFetchContextImpl.setStartRow(1
				long nBeginTime = java.lang.System.currentTimeMillis();
				try {
					SessionFactoryManager.addRef();
					DBFetchResult fetchResult = this.getService().getDAO().fetchDEDataQuery(deDataSetFetchContextImpl, "DEFAULT", false);
					if (fetchResult.getDataSet().getDataTable(0).getCachedRowCount() == -1) fetchResult.getDataSet().cacheDataRow();
					if (fetchResult.getDataSet().getDataTable(0).getCachedRowCount() > 0) {
						bOk = true;
					}

					fetchResult.getDataSet().close();
					if (!bOk) {
						callResult.setRetCode(Errors.ACCESSDENY);
					}

					long nTime = java.lang.System.currentTimeMillis() - nBeginTime;
					log.debug(StringHelper.format("查询耗时[%1$s]", nTime));
					SessionFactoryManager.releaseRef(false);

					return callResult;
				} catch (Exception ex) {
					log.error(StringHelper.format("实体[%1$s]权限检查代码发生异常，%2$s", this.getDEModel().getName(), ex.getMessage()), ex);
					SessionFactoryManager.releaseRef(false);
					throw ex;
				}
			}
		}
		
		throw new Exception(StringHelper.format("无法识别的数据访问控制体系[%1$s]",this.getDEModel().getDataAccCtrlArch()));
	}

}
