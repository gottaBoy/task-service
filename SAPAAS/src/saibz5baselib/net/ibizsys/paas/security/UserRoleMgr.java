package net.ibizsys.paas.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataQueryCode;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataRange;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDEOPPrivRole;
import net.ibizsys.paas.core.IDER1N;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDER1NModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.ISystemUserRoleModel;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.codelist.URDUserDRCodeListModel;
import net.ibizsys.psrt.srv.common.entity.Org;
import net.ibizsys.psrt.srv.common.entity.OrgSector;
import net.ibizsys.psrt.srv.common.entity.UserGroup;
import net.ibizsys.psrt.srv.common.entity.UserGroupDetail;
import net.ibizsys.psrt.srv.common.entity.UserObject;
import net.ibizsys.psrt.srv.common.entity.UserRole;
import net.ibizsys.psrt.srv.common.entity.UserRoleDEField;
import net.ibizsys.psrt.srv.common.entity.UserRoleData;
import net.ibizsys.psrt.srv.common.entity.UserRoleDataAction;
import net.ibizsys.psrt.srv.common.entity.UserRoleDataDetail;
import net.ibizsys.psrt.srv.common.entity.UserRoleRes;
import net.ibizsys.psrt.srv.common.service.UserGroupDetailService;
import net.ibizsys.psrt.srv.common.service.UserRoleDEFieldService;
import net.ibizsys.psrt.srv.common.service.UserRoleDataActionService;
import net.ibizsys.psrt.srv.common.service.UserRoleDataDetailService;
import net.ibizsys.psrt.srv.common.service.UserRoleDataService;
import net.ibizsys.psrt.srv.common.service.UserRoleResService;
import net.ibizsys.psrt.srv.common.service.UserRoleService;

/**
 * 用户角色管理对象类
 * 
 * @author Administrator
 * 
 */
@SuppressWarnings("serial")
public class UserRoleMgr implements IUserRoleMgr, java.io.Serializable,IUserRoleMgr2 {
	
	private String strCurPersonId = "";

	private String strCurOrgId = "";

	private String strCurOrgSectorId = "";

	private String strCurOrgSectorBC = "";

	private HashMap<String, ArrayList<UserRoleData>> deUserDataMap = new HashMap<String, ArrayList<UserRoleData>>();

	private HashMap<String, HashMap<String, Integer>> deFieldPrivMap = new HashMap<String, HashMap<String, Integer>>();

	private static final Log log = LogFactory.getLog(UserRoleMgr.class);

	private boolean bAdvUserGroupMode = true;

	/**
	 * 与该用户相关的所有用户对象，包括当前身份及用户组
	 */
	private ArrayList<String> allUserObjects = new ArrayList<String>();

	private HashMap<String, String> allUserObjectMap = new HashMap<String, String>();

	private HashMap<String, UserGroup> allUserGroupMap = new HashMap<String, UserGroup>();

	/**
	 * 全部用户角色
	 */
	private ArrayList<UserRole> allUserRoles = new ArrayList<UserRole>();

	/**
	 * 是否启用组织单元
	 */
	protected boolean bEnableOU = false;

	protected boolean bOrgAdmin = false;
	
	/**
	 * 是否启用判断建立行为高级模式，使用高级模式，将根据数据能力中定义的机构相关条件做进一步判断
	 */
	protected boolean bTestCreateAdvanceMode = false;
	
	private HashMap<String, ISystemUserRoleModel> sysUserRoleMap = new HashMap<String, ISystemUserRoleModel>();
	
	private boolean bEnableSysUserRole = false;

	public UserRoleMgr() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IUserRoleMgr#init(net.ibizsys.paas.web.IWebContext)
	 */
	@Override
	public void init(IWebContext iWebContext) throws Exception {
		
		this.strCurPersonId = iWebContext.getCurUserId();
		this.strCurOrgId = iWebContext.getCurOrgId();
		this.strCurOrgSectorId = iWebContext.getCurOrgSectorId();
		this.strCurOrgSectorBC = iWebContext.getCurOrgSectorBC();
		this.bOrgAdmin = iWebContext.isOrgAdmin();

		allUserObjects.clear();
		allUserObjectMap.clear();

		// 计算用户的全部用户组
		listUserGroups();

		// 列出当前用户拥有的所有角色
		listUserRoles();

		onInit();
	}

	/**
	 * 初始化触发
	 * 
	 * @throws Exception
	 */
	protected void onInit() throws Exception {

	}

	/**
	 * 列出用户的所有的用户组
	 */
	protected void listUserGroups() throws Exception {
		allUserObjectMap.put(this.strCurPersonId, "");
		allUserObjects.add(this.strCurPersonId);

		ArrayList<String> userObjects = new ArrayList<String>();
		userObjects.add(this.strCurPersonId);

		UserGroupDetailService userGroupDetailService = (UserGroupDetailService) ServiceGlobal.getService(UserGroupDetailService.class);

		while (userObjects.size() > 0) {
			String strUserObjectId = userObjects.remove(0);
			UserObject userObject = new UserObject();
			userObject.setUserObjectId(strUserObjectId);
			ArrayList<UserGroupDetail> userGroupDetailList = userGroupDetailService.selectByUserObject(userObject);
			for (UserGroupDetail userGroupDetail : userGroupDetailList) {
				String strUserGroupId = userGroupDetail.getUserGroupId();
				// 判断该用户组是否已经加载，避免死循环
				if (allUserObjectMap.containsKey(strUserGroupId)) continue;

				allUserObjectMap.put(strUserGroupId, "");
				allUserObjects.add(strUserGroupId);
				allUserGroupMap.put(strUserGroupId, userGroupDetail.getUserGroup());
				userObjects.add(strUserGroupId);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IUserRoleMgr#getUserRoleDatas(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<UserRoleData> getUserRoleDatas(String strDEId, String strAction) throws Exception {
		ArrayList<UserRoleData> retUserRoleDataList = new ArrayList<UserRoleData>();
		ArrayList<UserRoleData> deUserRoleDatas = null;
		// strDEId = strDEId.toUpperCase();
		synchronized (deUserDataMap) {
			if (deUserDataMap.containsKey(strDEId)) deUserRoleDatas = deUserDataMap.get(strDEId);
		}

		if (deUserRoleDatas == null) {
			ArrayList<UserRoleData> deUserRoleDatas2 = this.getUserRoleDatas(strDEId);
			deUserRoleDatas = new ArrayList<UserRoleData>();
			TreeMap<String, Integer> loadedMap = new TreeMap<String, Integer>();
			for (UserRoleData userRoleData : deUserRoleDatas2) {
				if (loadedMap.containsKey(userRoleData.getUserRoleDataId())) continue;

				userRoleData.addAction(DataAccessActions.READ, true);

				// 查出相关明细控制
				UserRoleDataActionService userRoleDataActionService = (UserRoleDataActionService) ServiceGlobal.getService(UserRoleDataActionService.class);
				ArrayList<UserRoleDataAction> deUserRoleDataActions = userRoleDataActionService.selectByUserRoleData(userRoleData);
				for (UserRoleDataAction action : deUserRoleDataActions) {
					userRoleData.addAction(action.getUserRoleDataActionName(), DataObject.getBoolValue(action, UserRoleDataAction.FIELD_ISALLOW, true));
					// userRoleData.AddAction(action.getUSERROLEDATAACTIONNAME(), action.isALLOW());
				}

				if (!DataObject.getBoolValue(userRoleData.getIsAllData(), false)) {
					UserRoleDataDetailService userRoleDataDetailService = (UserRoleDataDetailService) ServiceGlobal.getService(UserRoleDataDetailService.class);
					ArrayList<UserRoleDataDetail> deUserRoleDataDetails = userRoleDataDetailService.selectByUserRoleData(userRoleData);
					userRoleData.getDetailList().addAll(deUserRoleDataDetails);
				}
				deUserRoleDatas.add(userRoleData);
			}

			synchronized (deUserDataMap) {
				deUserDataMap.put(strDEId, deUserRoleDatas);
			}
		}
		if (deUserRoleDatas != null) {
			// 复制缓存数据
			for (UserRoleData userRoleData : deUserRoleDatas) {
				if (userRoleData.containsAction(strAction)) retUserRoleDataList.add(userRoleData);
			}
			return retUserRoleDataList;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IUserRoleMgr#testUserRoleUniRes(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean testUserRoleUniRes(String strResType, String strResId) throws Exception {
		boolean bRet = false;
		if(this.isEnableSysUserRole()){
			for(Entry<String, ISystemUserRoleModel> sysUserRoleModel:this.sysUserRoleMap.entrySet() ){
				if(sysUserRoleModel.getValue().testUniResTag(strResId))
					return true;
			}
		}
		else{
			ArrayList<UserRoleRes> userRoleReses = this.getUserRoleReses(strResType, strResId);
			for (UserRoleRes userRoleRes : userRoleReses) {
				if (!DataObject.getBoolValue(userRoleRes.getIsAllow(), true)) {
					return false;
				} else {
					bRet = true;
				}
			}
		}
		return bRet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IUserRoleMgr#testUserRoleDataAction(java.lang.String, net.ibizsys.paas.entity.IEntity, java.lang.String)
	 */
	@Override
	public boolean testUserRoleDataAction(String strDEId, IEntity dataEntity, String strAction) throws Exception {
		IDataEntityModel iDEModel = DEModelGlobal.getDEModel(strDEId);
		return testUserRoleDataAction(iDEModel, dataEntity, strAction);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IUserRoleMgr#testUserRoleDataAction(net.ibizsys.paas.demodel.IDataEntityModel, net.ibizsys.paas.entity.IEntity, java.lang.String)
	 */
	@Override
	public boolean testUserRoleDataAction(IDataEntityModel iDEModel, IEntity dataEntity, String strAction) throws Exception {
		// 判断实体是否为附属实体
		if (iDEModel.getDataAccCtrlMode() == IDataEntityModel.DATAACCCTRL_MASTER
				||iDEModel.getDataAccCtrlMode() == IDataEntityModel.DATAACCCTRL_MASTER_SELF) {
			// 获取主实体
			IDER1N iDER1N = iDEModel.getAccMasterDER(dataEntity);
			if (iDER1N == null) {
				throw new Exception(StringHelper.format("无法找到权限主实体"));
			}

			IDataEntityModel majorDEModel = ((IDER1NModel) iDER1N).getMajorDEModel();
			Object objValue = dataEntity.get(iDER1N.getPickupDEFName());
			String strMajorAction = DataAccessActions.UPDATE;
			IEntity parentEntity = majorDEModel.createEntity();
			parentEntity.set(majorDEModel.getKeyDEField().getName(), objValue);
			return testUserRoleDataAction(majorDEModel, parentEntity, strMajorAction);
		}

		ArrayList<UserRoleData> userRoleDatas = getUserRoleDatas(iDEModel.getId(), strAction);
		if(StringHelper.compare(strAction,DataAccessActions.CREATE, false) == 0){
			//建立数据，逐项判断
			if(isTestCreateAdvanceMode()){
				return testCreateAdvanceMode(iDEModel,  dataEntity,userRoleDatas);
			}
		}
		if (userRoleDatas.size() > 0) return true;
		return false;
	}
	
	/**
	 * 判断建立行为高级模式
	 * @param iDEModel
	 * @param dataEntity
	 * @param userRoleDatas
	 * @return
	 * @throws Exception
	 */
	protected boolean testCreateAdvanceMode(IDataEntityModel iDEModel, IEntity dataEntity,ArrayList<UserRoleData> userRoleDatas) throws Exception {
		IDEField orgIdDEField = iDEModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGID, true);
		IDEField secIdDEField = iDEModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGSECTORID, true);
		if(orgIdDEField == null && secIdDEField == null)
		{
			//当前实体没有机构或是部门标识
			return true;
		}
		
		for(UserRoleData userRoleData:userRoleDatas){
			if (DataObject.getBoolValue(userRoleData.getIsAllData(), false)){
				//指定全部数据
				return true;
			}
			
			if(userRoleData.getDetailList().size()>0){
				return true;
			}
				
//			String strOrgAlias = "o1";
//			String strOrgSectorAlias = "o2";
//
//			if (orgIdDEField != null && userRoleData.getOrgDR() != null) {
//				String strCurOrgId = userRoleData.getDstOrgId();
//				if (StringHelper.isNullOrEmpty(strCurOrgId)) {
//					strCurOrgId = this.strCurOrgId;
//				}
//				if (!StringHelper.isNullOrEmpty(strCurOrgId)) {
//					Org curOrg = OrgGlobal.getOrg(strCurOrgId);
//					String strOrgCond = iService.getDAO().getRealDBDialect().getOrgDRCond(userRoleData, curOrg, strOrgAlias);
//					if (!StringHelper.isNullOrEmpty(strOrgCond)) userRoleDataCondList.add(strOrgCond);
//				}
//			}
//
//			if (secIdDEField != null && userRoleData.getSecDR() != null) {
//				String strCurOrgSectorId = userRoleData.getDstOrgSectorId();
//				if (StringHelper.isNullOrEmpty(strCurOrgSectorId)) {
//					strCurOrgSectorId = this.strCurOrgSectorId;
//				}
//				if (!StringHelper.isNullOrEmpty(strCurOrgSectorId)) {
//					OrgSector curOrgSector = OrgGlobal.getOrgSector(strCurOrgSectorId);
//					String strOrgSectorCond = iService.getDAO().getRealDBDialect().getOrgSecDRCond(userRoleData, curOrgSector, strOrgSectorAlias);
//					if (!StringHelper.isNullOrEmpty(strOrgSectorCond)) userRoleDataCondList.add(strOrgSectorCond);
//				}
//			}
//
//			if (secIdDEField != null && (userRoleData.getBCDR() != null || userRoleData.getDstSecBC() != null)) {
//				String strCurOrgSectorBC = userRoleData.getDstSecBC();
//				if (StringHelper.isNullOrEmpty(strCurOrgSectorBC)) {
//					strCurOrgSectorBC = this.strCurOrgSectorBC;
//				}
//				if (!StringHelper.isNullOrEmpty(strCurOrgSectorBC)) {
//					String[] arrBC = strCurOrgSectorBC.split("\\|");
//					StringBuilderEx sBuilderEx = new StringBuilderEx();
//					for (int i = 0; i < arrBC.length; i++) {
//						if (i > 0) sBuilderEx.append(",");
//						sBuilderEx.append(StringHelper.format("'%1$s'", arrBC[i]));
//					}
//					String strCon = StringHelper.format("%1$s.bizcode in (%2$s)", strOrgSectorAlias, sBuilderEx.toString());
//					userRoleDataCondList.add(strCon);
//				}
//
//			}
		}
		//TODO 未完成
		return true;
	}

	/**
	 * 列出当前用户拥有的所有角色
	 * 
	 * @throws Exception
	 */
	protected void listUserRoles() throws Exception {
		// 获取用户与该实体相关的数据权限定义
		ArrayList<UserRole> list = new ArrayList<UserRole>();

		String strSQL = "" ;
		if(WebConfig.getCurrent().isLowCaseSql() ) {
			strSQL = "select t2.createdate,t2.createman,t2.issystem,t2.memo,t2.menumode,t2.reserver,t2.reserver2,t2.reserver3,t2.reserver4,t2.updatedate,t2.updateman,t2.userdata,t2.userdata2,t2.userroleid,t2.userrolename,t2.userroletype from  t_srfuserrole t2 inner join t_srfuserroledetail t3 on t2.userroleid=t3.userroleid ";
			strSQL += "where  (";

			String strCondition = "";
			for (String strUserObjectId : allUserObjects) {
				if (!StringHelper.isNullOrEmpty(strCondition)) strCondition += " or ";
				strCondition += StringHelper.format("t3.userobjectid='%1$s'", strUserObjectId);
			}

			strSQL += strCondition;
			strSQL += ")";
		}else {
			strSQL = "SELECT t2.* from  T_SRFUSERROLE t2 INNER JOIN T_SRFUSERROLEDETAIL t3 ON t2.USERROLEID=t3.USERROLEID ";
			strSQL += "where  (";

			String strCondition = "";
			for (String strUserObjectId : allUserObjects) {
				if (!StringHelper.isNullOrEmpty(strCondition)) strCondition += " OR ";
				strCondition += StringHelper.format("t3.USEROBJECTID='%1$s'", strUserObjectId);
			}

			strSQL += strCondition;
			strSQL += ")";
		}
		
	

		UserRoleService userRoleService = (UserRoleService) ServiceGlobal.getService(UserRoleService.class);
		ArrayList<IEntity> list2 = userRoleService.selectRaw(strSQL, null);
		for (IEntity iEntity : list2) {
			UserRole userRoleData = new UserRole();
			iEntity.copyTo(userRoleData, false);
			list.add(userRoleData);
		}

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (UserRole userRole : list) {
			if (map.containsKey(userRole.getUserRoleId())) continue;
			this.allUserRoles.add(userRole);
			map.put(userRole.getUserRoleId(), 1);
		}
	}

	//
	// /* (non-Javadoc)
	// * @see SA.SRFDA.Security.IUserRoleHelper#GetUserRoles(java.util.ArrayList)
	// */
	// @Override
	// public boolean GetUserRoles(ArrayList<UserRole> userRoles)
	// {
	// userRoles.addAll(this.allUserRoles);
	// return true;
	// }
	//

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IUserRoleMgr#testUserRoleDEField(java.lang.String, java.lang.String)
	 */
	@Override
	public int testUserRoleDEField(String strDEName, String strField) throws Exception {
		CallResult callResult = new CallResult();
		HashMap<String, Integer> deFields = null;
		synchronized (deFieldPrivMap) {
			deFields = deFieldPrivMap.get(strDEName);
		}

		if (deFields == null) {
			ArrayList<UserRoleDEField> deUserRoleDEFields = this.getUserRoleDEFields(strDEName);
			deFields = new HashMap<String, Integer>();

			for (UserRoleDEField userRoleDEField : deUserRoleDEFields) {
				int nAction = PrivilegeAbilities.NONE;
				if (StringHelper.compare(userRoleDEField.getDEFAction(), "UPDATE", true) == 0) {
					nAction = PrivilegeAbilities.UPDATE;
				}

				if (StringHelper.compare(userRoleDEField.getDEFAction(), "READ", true) == 0) {
					nAction = PrivilegeAbilities.READ;
				}

				String[] defields = userRoleDEField.getRelatedDEField().toUpperCase().split("[;]");
				for (String strDEField : defields) {
					if (deFields.containsKey(strDEField)) {
						if (deFields.get(strDEField) < nAction) {
							deFields.put(strDEField, nAction);
						}
					} else
						deFields.put(strDEField, nAction);
				}
			}

			synchronized (deFieldPrivMap) {
				deFieldPrivMap.put(strDEName, deFields);
			}
		}

		int nRet = PrivilegeAbilities.NONE;
		if (deFields != null) {
			if (deFields.containsKey(strField)) {
				nRet = deFields.get(strField);
			}
		}
		return nRet;
	}

	/**
	 * 用户用户角色数据权限配置
	 * 
	 * @param strDataEntityId
	 * @return
	 * @throws Exception
	 */
	protected ArrayList<UserRoleData> getUserRoleDatas(String strDataEntityId) throws Exception {
		ArrayList<UserRoleData> list = new ArrayList<UserRoleData>();
		if (this.allUserObjects.size() == 0) return list;

		// 格式化SQL
		String strSQL = "" ;
		if(WebConfig.getCurrent().isLowCaseSql() ) {
			strSQL = StringHelper.format("select t1.bcdr,t1.createdate,t1.createman,t1.deid,t1.dstorgid,t1.dstorgsectorid,t1.dstsecbc,t1.isalldata,t1.memo,t1.orgdr,t1.reserver,t1.reserver2,t1.reserver3,t1.reserver4,t1.secdr,t1.srfsyspub,t1.srfuserpub,t1.udversion,t1.updatedate,t1.updateman,t1.userdr,t1.userroledataid,t1.userroledataname from t_srfuserroledata t1 " + "INNER JOIN T_SRFUSERROLEDATAS t6 ON t1.USERROLEDATAID = t6.USERROLEDATAID " + "INNER JOIN T_SRFUSERROLE t2 on t6.USERROLEID=t2.USERROLEID " + "INNER JOIN T_SRFUSERROLEDETAIL t3 ON t2.USERROLEID=t3.USERROLEID " + "where t1.DEID='%1$s' AND ", strDataEntityId);
			strSQL += "  (";

			String strCondition = "";
			for (String strUserObjectId : this.allUserObjects) {
				if (!StringHelper.isNullOrEmpty(strCondition)) strCondition += " or ";
				strCondition += StringHelper.format("t3.userobjectid='%1$s'", strUserObjectId);
			}

			strSQL += strCondition;
			strSQL += ")";
		}else {
			strSQL = StringHelper.format("select t1.* from T_SRFUSERROLEDATA t1 " + "INNER JOIN T_SRFUSERROLEDATAS t6 ON t1.USERROLEDATAID = t6.USERROLEDATAID " + "INNER JOIN T_SRFUSERROLE t2 on t6.USERROLEID=t2.USERROLEID " + "INNER JOIN T_SRFUSERROLEDETAIL t3 ON t2.USERROLEID=t3.USERROLEID " + "where t1.DEID='%1$s' AND ", strDataEntityId);
			strSQL += "  (";

			String strCondition = "";
			for (String strUserObjectId : this.allUserObjects) {
				if (!StringHelper.isNullOrEmpty(strCondition)) strCondition += " OR ";
				strCondition += StringHelper.format("t3.USEROBJECTID='%1$s'", strUserObjectId);
			}

			strSQL += strCondition;
			strSQL += ")";
		}

		UserRoleDataService userRoleDataService = (UserRoleDataService) ServiceGlobal.getService(UserRoleDataService.class);
		ArrayList<IEntity> list2 = userRoleDataService.selectRaw(strSQL, null);
		for (IEntity iEntity : list2) {
			UserRoleData userRoleData = new UserRoleData();
			iEntity.copyTo(userRoleData, false);
			list.add(userRoleData);
		}
		return list;
	}

	/**
	 * 获取用户角色的属性
	 * 
	 * @param strDEName
	 * @return
	 * @throws Exception
	 */
	protected ArrayList<UserRoleDEField> getUserRoleDEFields(String strDEName) throws Exception {
		ArrayList<UserRoleDEField> list = new ArrayList<UserRoleDEField>();
		if (this.allUserObjects.size() == 0) return list;
		
		String strSQL = "" ;
		if(WebConfig.getCurrent().isLowCaseSql() ) {
			strSQL = StringHelper.format("select t1.createdate,t1.createman,t1.defaction,t1.deid,t1.dename,t1.relateddefield,t1.reserver,t1.reserver2,t1.reserver3,t1.reserver4,t1.srfsyspub,t1.srfuserpub,t1.updatedate,t1.updateman,t1.userroledefieldid,t1.userroledefieldname from t_srfuserroledefield t1 " + "inner join t_srfuserroledefields t6 on t1.userroledefieldid = t6.userroledefieldid " + "inner join t_srfuserrole t2 on t6.userroleid=t2.userroleid " + "inner join t_srfuserroledetail t3 on t2.userroleid=t3.userroleid " + "where t1.dename='%1$s' and ", strDEName);

			strSQL += "  (";

			String strCondition = "";
			for (String strUserObjectId : allUserObjects) {
				if (!StringHelper.isNullOrEmpty(strCondition)) strCondition += " or ";
				strCondition += StringHelper.format("t3.userobjectid='%1$s'", strUserObjectId);
			}

			strSQL += strCondition;
			strSQL += ")";
		}else {
			strSQL = StringHelper.format("select t1.* from T_SRFUSERROLEDEFIELD t1 " + "INNER JOIN T_SRFUSERROLEDEFIELDS t6 ON t1.USERROLEDEFIELDID = t6.USERROLEDEFIELDID " + "INNER JOIN T_SRFUSERROLE t2 on t6.USERROLEID=t2.USERROLEID " + "INNER JOIN T_SRFUSERROLEDETAIL t3 ON t2.USERROLEID=t3.USERROLEID " + "where t1.DENAME='%1$s' AND ", strDEName);

			strSQL += "  (";

			String strCondition = "";
			for (String strUserObjectId : allUserObjects) {
				if (!StringHelper.isNullOrEmpty(strCondition)) strCondition += " OR ";
				strCondition += StringHelper.format("t3.USEROBJECTID='%1$s'", strUserObjectId);
			}

			strSQL += strCondition;
			strSQL += ")";
		}
		

		UserRoleDEFieldService userRoleDEFieldService = (UserRoleDEFieldService) ServiceGlobal.getService(UserRoleDEFieldService.class);
		ArrayList<IEntity> list2 = userRoleDEFieldService.selectRaw(strSQL, null);
		for (IEntity iEntity : list2) {
			UserRoleDEField userRoleData = new UserRoleDEField();
			iEntity.copyTo(userRoleData, false);
			list.add(userRoleData);
		}
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IUserRoleMgr#getUserId()
	 */
	@Override
	public String getUserId() {
		return this.strCurPersonId;
	}

	/**
	 * 获取当前组织标识
	 * 
	 * @return
	 */
	public String getCurOrgId() {
		return this.strCurOrgId;
	}

	/**
	 * 获取当前组织部门标识
	 * 
	 * @return
	 */
	public String getCurOrgSectorId() {
		return this.strCurOrgSectorId;
	}

	/**
	 * 获取当前组织部门业务代码
	 * 
	 * @return
	 */
	public String getCurOrgSectorBC() {
		return this.strCurOrgSectorBC;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IUserRoleMgr#getOrg()
	 */
	@Override
	public Org getOrg() throws Exception {
		return OrgGlobal.getOrg(this.strCurOrgId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IUserRoleMgr#getOrgSector()
	 */
	@Override
	public OrgSector getOrgSector() throws Exception {
		return OrgGlobal.getOrgSector(this.strCurOrgSectorId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IUserRoleMgr#getUserRoleDataCond(net.ibizsys.paas.service.IService, net.ibizsys.psrt.srv.common.entity.UserRoleData)
	 */
	@Override
	public String getUserRoleDataCond(IService iService, UserRoleData userRoleData) throws Exception {
		return getUserRoleDataCond(iService, userRoleData, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IUserRoleMgr#getUserRoleDataCond(net.ibizsys.paas.service.IService, net.ibizsys.psrt.srv.common.entity.UserRoleData, net.ibizsys.paas.core.IDEDataSetFetchContext)
	 */
	public String getUserRoleDataCond(IService iService, UserRoleData userRoleData, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
		IDataEntityModel iDEModel = iService.getDEModel();

		ArrayList<String> userRoleDataCondList = new ArrayList<String>();

		if (!DataObject.getBoolValue(userRoleData.getIsAllData(), false)) {
			// 获取实体的组织维度
			IDEField orgIdDEField = iDEModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGID, true);
			IDEField secIdDEField = iDEModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGSECTORID, true);
			IDEField createManDEField = iDEModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_CREATEMAN, true);
			IDEField updateManDEField = iDEModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_UPDATEMAN, true);

			String strOrgAlias = "o1";
			String strOrgSectorAlias = "o2";

			if (orgIdDEField != null && userRoleData.getOrgDR() != null) {
				String strCurOrgId = userRoleData.getDstOrgId();
				if (StringHelper.isNullOrEmpty(strCurOrgId)) {
					strCurOrgId = this.strCurOrgId;
				}
				if (!StringHelper.isNullOrEmpty(strCurOrgId)) {
					Org curOrg = OrgGlobal.getOrg(strCurOrgId);
					String strOrgCond = iService.getDAO().getRealDBDialect().getOrgDRCond(userRoleData, curOrg, strOrgAlias);
					if (!StringHelper.isNullOrEmpty(strOrgCond)) userRoleDataCondList.add(strOrgCond);
				}
			}

			if (secIdDEField != null && userRoleData.getSecDR() != null) {
				String strCurOrgSectorId = userRoleData.getDstOrgSectorId();
				if (StringHelper.isNullOrEmpty(strCurOrgSectorId)) {
					strCurOrgSectorId = this.strCurOrgSectorId;
				}
				if (!StringHelper.isNullOrEmpty(strCurOrgSectorId)) {
					OrgSector curOrgSector = OrgGlobal.getOrgSector(strCurOrgSectorId);
					String strOrgSectorCond = iService.getDAO().getRealDBDialect().getOrgSecDRCond(userRoleData, curOrgSector, strOrgSectorAlias);
					if (!StringHelper.isNullOrEmpty(strOrgSectorCond)) userRoleDataCondList.add(strOrgSectorCond);
				}
			}

			if (secIdDEField != null && (userRoleData.getBCDR() != null || userRoleData.getDstSecBC() != null)) {
				String strCurOrgSectorBC = userRoleData.getDstSecBC();
				if (StringHelper.isNullOrEmpty(strCurOrgSectorBC)) {
					strCurOrgSectorBC = this.strCurOrgSectorBC;
				}
				if (!StringHelper.isNullOrEmpty(strCurOrgSectorBC)) {
					String[] arrBC = strCurOrgSectorBC.split("\\|");
					StringBuilderEx sBuilderEx = new StringBuilderEx();
					for (int i = 0; i < arrBC.length; i++) {
						if (i > 0) sBuilderEx.append(",");
						sBuilderEx.append(StringHelper.format("'%1$s'", arrBC[i]));
					}
					String strCon = StringHelper.format("%1$s.bizcode in (%2$s)", strOrgSectorAlias, sBuilderEx.toString());
					userRoleDataCondList.add(strCon);
				}

			}

			// 建立者及更新者条件处理
			if (true) {
				String strUserDR = "";
				if (createManDEField != null && userRoleData.getUserDR() != null && ((userRoleData.getUserDR() & URDUserDRCodeListModel.CREATEMAN) > 0)) {
					String strCond = StringHelper.format("${srfdefieldexp('%1$s')} = '%2$s'", createManDEField.getName(), this.getUserId());
					strUserDR += strCond;
				}

				if (updateManDEField != null && userRoleData.getUserDR() != null && ((userRoleData.getUserDR() & URDUserDRCodeListModel.UPDATEMAN) > 0)) {
					if (!StringHelper.isNullOrEmpty(strUserDR)) {
						strUserDR += " OR ";
					}
					String strCond = StringHelper.format("${srfdefieldexp('%1$s')} = '%2$s'", updateManDEField.getName(), this.getUserId());
					strUserDR += strCond;
				}
				if (!StringHelper.isNullOrEmpty(strUserDR)) {
					userRoleDataCondList.add(strUserDR);
				}
			}

			for (UserRoleDataDetail userRoleDataDetail : userRoleData.getDetailList()) {
				IDEDataQuery iDEDataQuery = iDEModel.getDEDataQuery(userRoleDataDetail.getQueryModelId());
				IDEDataQueryCode iDEDataQueryCode = iDEDataQuery.getDEDataQueryCode(iService.getDAO().getRealDBDialect().getDBType());
				java.util.Iterator<IDEDataQueryCodeCond> deDataQueryCodeConds = iDEDataQueryCode.getDEDataQueryCodeConds();
				while (deDataQueryCodeConds.hasNext()) {
					IDEDataQueryCodeCond iDEDataQueryCodeCond = deDataQueryCodeConds.next();
					if (StringHelper.compare(iDEDataQueryCodeCond.getCondType(), IDEDataQueryCodeCond.CONDTYPE_CUSTOM, true) == 0) {
						// 自定义代码，要分析是否有参数
						userRoleDataCondList.add(iDEDataQueryCodeCond.getCustomCond());
					}
				}
			}
		} else {
			userRoleDataCondList.add(" 1=1 ");
		}
		if (userRoleDataCondList.size() == 0) return null;
		StringBuilderEx sBuilderEx = new StringBuilderEx();
		for (int i = 0; i < userRoleDataCondList.size(); i++) {
			if (i > 0) sBuilderEx.append(" AND ");
			sBuilderEx.append(StringHelper.format("(%1$s)", userRoleDataCondList.get(i)));
		}
		return sBuilderEx.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IUserRoleMgr#getDEDataRangeCond(net.ibizsys.paas.service.IService, net.ibizsys.paas.core.IDEDataRange)
	 */
	@Override
	public String getDEDataRangeCond(IService iService, IDEDataRange iDEDataRange) throws Exception {
		return getDEDataRangeCond(iService, iDEDataRange, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.security.IUserRoleMgr#getDEDataRangeCond(net.ibizsys.paas.service.IService, net.ibizsys.paas.core.IDEDataRange, net.ibizsys.paas.core.IDEDataSetFetchContext)
	 */
	@Override
	public String getDEDataRangeCond(IService iService, IDEDataRange iDEDataRange, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {

		IDataEntityModel iDEModel = iService.getDEModel();

		// 获取实体的组织维度
		IDEField orgIdDEField = iDEModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGID, true);
		IDEField secIdDEField = iDEModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGSECTORID, true);

		String strOrgAlias = "o1";
		String strOrgSectorAlias = "o2";

		ArrayList<String> userRoleDataCondList = new ArrayList<String>();
		if (orgIdDEField != null && (iDEDataRange.isEnableOrgDR())) {
			String strCurOrgId = this.strCurOrgId;
			if (!StringHelper.isNullOrEmpty(strCurOrgId)) {
				Org curOrg = OrgGlobal.getOrg(strCurOrgId);
				String strOrgCond = iService.getDAO().getRealDBDialect().getOrgDRCond(iDEDataRange, curOrg, strOrgAlias);
				if (!StringHelper.isNullOrEmpty(strOrgCond)) userRoleDataCondList.add(strOrgCond);
			}
		}

		if (secIdDEField != null && iDEDataRange.isEnableSecDR()) {
			String strCurOrgSectorId = this.strCurOrgSectorId;
			if (!StringHelper.isNullOrEmpty(strCurOrgSectorId)) {
				OrgSector curOrgSector = OrgGlobal.getOrgSector(strCurOrgSectorId);
				String strOrgSectorCond = iService.getDAO().getRealDBDialect().getOrgSecDRCond(iDEDataRange, curOrgSector, strOrgSectorAlias);
				if (!StringHelper.isNullOrEmpty(strOrgSectorCond)) userRoleDataCondList.add(strOrgSectorCond);
			}
		}

		if (userRoleDataCondList.size() == 0) return null;
		StringBuilderEx sBuilderEx = new StringBuilderEx();
		for (int i = 0; i < userRoleDataCondList.size(); i++) {
			if (i > 0) sBuilderEx.append(" AND ");
			sBuilderEx.append(StringHelper.format("(%1$s)", userRoleDataCondList.get(i)));
		}
		return sBuilderEx.toString();
	}

	/**
	 * 获取用户角色相关资源能力定义清单
	 * 
	 * @param strResType
	 * @param strRealResId
	 * @param userObjects
	 * @return
	 * @throws Exception
	 */
	protected ArrayList<UserRoleRes> getUserRoleReses(String strResType, String strRealResId) throws Exception {
		ArrayList<UserRoleRes> list = new ArrayList<UserRoleRes>();
		if (allUserObjects.size() == 0) return list;

		String strSQL = "";
		if(WebConfig.getCurrent().isLowCaseSql()) {
			strSQL = StringHelper.format("select t1.createdate,t1.createman,t1.isallow,t1.reserver,t1.reserver2,t1.reserver3,t1.reserver4,t1.uniresid,t1.updatedate,t1.updateman,t1.userroleid,t1.userroleresid,t1.userroleresname from t_srfuserroleres t1 " + " inner join t_srfunires t6 on t1.uniresid = t6.uniresid " + " inner join t_srfuserrole t2 on t1.userroleid = t2.userroleid " + " inner join t_srfuserroledetail t3 on t2.userroleid=t3.userroleid " + " where " + "((t6.unirestype='%1$s' and upper(t6.resourceid)='%3$s') )   and ", strResType, strRealResId.toUpperCase(), strRealResId.toUpperCase()) ;

			strSQL += "  (";

			String strCondition = "";
			for (String strUserObjectId : this.allUserObjects) {
				if (!StringHelper.isNullOrEmpty(strCondition)) strCondition += " OR ";
				strCondition += StringHelper.format("t3.USEROBJECTID='%1$s'", strUserObjectId);
			}

			strSQL += strCondition;
			strSQL += ")";
		}else {
			strSQL = StringHelper.format("select t1.* from t_SRFUSERROLERES t1 " + " INNER JOIN T_SRFUNIRES t6 ON t1.UNIRESID = t6.UNIRESID " + " INNER JOIN T_SRFUSERROLE t2 ON t1.USERROLEID = t2.USERROLEID " + " INNER JOIN T_SRFUSERROLEDETAIL t3 ON t2.USERROLEID=t3.USERROLEID " + " where " + "((t6.UNIRESTYPE='%1$s' AND UPPER(t6.RESOURCEID)='%3$s') )   AND ", strResType, strRealResId.toUpperCase(), strRealResId.toUpperCase());

			strSQL += "  (";

			String strCondition = "";
			for (String strUserObjectId : this.allUserObjects) {
				if (!StringHelper.isNullOrEmpty(strCondition)) strCondition += " OR ";
				strCondition += StringHelper.format("t3.USEROBJECTID='%1$s'", strUserObjectId);
			}

			strSQL += strCondition;
			strSQL += ")";
		}

		UserRoleResService userRoleResService = (UserRoleResService) ServiceGlobal.getService(UserRoleResService.class);
		ArrayList<IEntity> list2 = userRoleResService.selectRaw(strSQL, null);
		for (IEntity iEntity : list2) {
			UserRoleRes userRoleData = new UserRoleRes();
			iEntity.copyTo(userRoleData, false);
			list.add(userRoleData);
		}
		return list;

	}

	/**
	 * 当前用户是否为组织管理员
	 * 
	 * @return
	 */
	protected boolean isOrgAdmin() {
		return this.bOrgAdmin;
	}

	
	/**
	 * 设置是否启用判断建立行为高级模式
	 * @param bTestCreateAdvanceMode
	 */
	public void setTestCreateAdvanceMode(boolean bTestCreateAdvanceMode){
		this.bTestCreateAdvanceMode = bTestCreateAdvanceMode;
	}
	
	/**
	 * 是否启用判断建立行为高级模式
	 * @return
	 */
	public boolean isTestCreateAdvanceMode(){
		return this.bTestCreateAdvanceMode ;
	}

	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.security.IUserRoleMgr2#getDEOPPrivRoleCond(net.ibizsys.paas.service.IService, java.lang.String, net.ibizsys.paas.core.IDEDataSetFetchContext)
	 */
	@Override
	public String getDEOPPrivRoleCond(IService iService, String strDataAccAction, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
		java.util.Iterator<IDEOPPrivRole> deOPPrivRoles = iService.getDEModel().getDEOPPrivRoles(strDataAccAction);
		if(deOPPrivRoles == null)
			return null;
		ArrayList<String> condList = new ArrayList<String> ();
		while(deOPPrivRoles.hasNext()){
			IDEOPPrivRole iDEOPPrivRole = deOPPrivRoles.next();
			if(StringHelper.isNullOrEmpty(iDEOPPrivRole.getDEDataQueryId())){
				continue;
			}
			ArrayList<String> userRoleDataCondList2 = new ArrayList<String> ();
			IDEDataQuery iDEDataQuery = iService.getDEModel().getDEDataQuery(iDEOPPrivRole.getDEDataQueryId());
			IDEDataQueryCode iDEDataQueryCode = iDEDataQuery.getDEDataQueryCode(iService.getDAO().getRealDBDialect().getDBType());
			java.util.Iterator<IDEDataQueryCodeCond> deDataQueryCodeConds = iDEDataQueryCode.getDEDataQueryCodeConds();
			while (deDataQueryCodeConds.hasNext()) {
				IDEDataQueryCodeCond iDEDataQueryCodeCond = deDataQueryCodeConds.next();
				if (StringHelper.compare(iDEDataQueryCodeCond.getCondType(), IDEDataQueryCodeCond.CONDTYPE_CUSTOM, true) == 0) {
					// 自定义代码，要分析是否有参数
					userRoleDataCondList2.add(iDEDataQueryCodeCond.getCustomCond());
				}
			}
			if(userRoleDataCondList2.size()>0){
				StringBuilderEx sBuilderEx = new StringBuilderEx();
				for (int i = 0; i < userRoleDataCondList2.size(); i++) {
					if (i > 0) sBuilderEx.append(" AND ");
					sBuilderEx.append(StringHelper.format("(%1$s)", userRoleDataCondList2.get(i)));
				}
				condList.add(sBuilderEx.toString());
			}
		}
		if (condList.size() == 0) return null;
		StringBuilderEx sBuilderEx = new StringBuilderEx();
		for (int i = 0; i < condList.size(); i++) {
			if (i > 0) sBuilderEx.append(" OR ");
			sBuilderEx.append(StringHelper.format("(%1$s)", condList.get(i)));
		}
		return sBuilderEx.toString();
	}

	@Override
	public boolean testDEOPPrivRoleAction(IWebContext iWebContext,IDataEntityModel iDEModel, IEntity dataEntity, String strDataAccAction) throws Exception {
		java.util.Iterator<IDEOPPrivRole> deOPPrivRoles = iDEModel.getDEOPPrivRoles(strDataAccAction);
		if(deOPPrivRoles == null)
			return false;
		
		while(deOPPrivRoles.hasNext()){
			IDEOPPrivRole iDEOPPrivRole = deOPPrivRoles.next();
			if(StringHelper.isNullOrEmpty(iDEOPPrivRole.getSysUserRoleId())){
				continue;
			}
			
			ISystemUserRoleModel iSystemUserRoleModel = iDEModel.getSystemModel().getSystemUserRoleModel(iDEOPPrivRole.getSysUserRoleId());
			if(iSystemUserRoleModel.testCurUser(iWebContext))
				return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.security.IUserRoleMgr2#testSysUserRole(java.lang.String)
	 */
	@Override
	public boolean testSysUserRole(String strSysUserRoleTag) throws Exception {
		return this.sysUserRoleMap.containsKey(strSysUserRoleTag);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.security.IUserRoleMgr2#registerSysUserRole(java.lang.String)
	 */
	@Override
	public void registerSysUserRole(ISystemUserRoleModel iSystemUserRoleModel) {
		this.sysUserRoleMap.put(iSystemUserRoleModel.getRoleTag(), iSystemUserRoleModel);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.security.IUserRoleMgr2#getSysUserRoles()
	 */
	@Override
	public Iterator<ISystemUserRoleModel> getSysUserRoles() {
		return this.sysUserRoleMap.values().iterator();
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.security.IUserRoleMgr2#setEnableSysUserRole(boolean)
	 */
	@Override
	public void setEnableSysUserRole(boolean bEnableSysUserRole) {
		this.bEnableSysUserRole = bEnableSysUserRole;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.security.IUserRoleMgr2#isEnableSysUserRole()
	 */
	@Override
	public boolean isEnableSysUserRole() {
		return this.bEnableSysUserRole;
	}

	
	
	
	
	
}
