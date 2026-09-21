/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
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
import net.ibizsys.paas.security.IUserRoleMgr;
import net.ibizsys.paas.security.IUserRoleMgr2;
import net.ibizsys.paas.security.OrgGlobal;
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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UserRoleMgr
implements IUserRoleMgr,
Serializable,
IUserRoleMgr2 {
    private String strCurPersonId = "";
    private String strCurOrgId = "";
    private String strCurOrgSectorId = "";
    private String strCurOrgSectorBC = "";
    private HashMap<String, ArrayList<UserRoleData>> deUserDataMap = new HashMap();
    private HashMap<String, HashMap<String, Integer>> deFieldPrivMap = new HashMap();
    private static final Log log = LogFactory.getLog(UserRoleMgr.class);
    private boolean bAdvUserGroupMode = true;
    private ArrayList<String> allUserObjects = new ArrayList();
    private HashMap<String, String> allUserObjectMap = new HashMap();
    private HashMap<String, UserGroup> allUserGroupMap = new HashMap();
    private ArrayList<UserRole> allUserRoles = new ArrayList();
    protected boolean bEnableOU = false;
    protected boolean bOrgAdmin = false;
    protected boolean bTestCreateAdvanceMode = false;
    private HashMap<String, ISystemUserRoleModel> sysUserRoleMap = new HashMap();
    private boolean bEnableSysUserRole = false;

    @Override
    public void init(IWebContext iWebContext) throws Exception {
        this.strCurPersonId = iWebContext.getCurUserId();
        this.strCurOrgId = iWebContext.getCurOrgId();
        this.strCurOrgSectorId = iWebContext.getCurOrgSectorId();
        this.strCurOrgSectorBC = iWebContext.getCurOrgSectorBC();
        this.bOrgAdmin = iWebContext.isOrgAdmin();
        this.allUserObjects.clear();
        this.allUserObjectMap.clear();
        this.listUserGroups();
        this.listUserRoles();
        this.onInit();
    }

    protected void onInit() throws Exception {
    }

    protected void listUserGroups() throws Exception {
        this.allUserObjectMap.put(this.strCurPersonId, "");
        this.allUserObjects.add(this.strCurPersonId);
        ArrayList<String> userObjects = new ArrayList<String>();
        userObjects.add(this.strCurPersonId);
        UserGroupDetailService userGroupDetailService = (UserGroupDetailService)ServiceGlobal.getService(UserGroupDetailService.class);
        while (userObjects.size() > 0) {
            String strUserObjectId = (String)userObjects.remove(0);
            UserObject userObject = new UserObject();
            userObject.setUserObjectId(strUserObjectId);
            ArrayList<UserGroupDetail> userGroupDetailList = userGroupDetailService.selectByUserObject(userObject);
            for (UserGroupDetail userGroupDetail : userGroupDetailList) {
                String strUserGroupId = userGroupDetail.getUserGroupId();
                if (this.allUserObjectMap.containsKey(strUserGroupId)) continue;
                this.allUserObjectMap.put(strUserGroupId, "");
                this.allUserObjects.add(strUserGroupId);
                this.allUserGroupMap.put(strUserGroupId, userGroupDetail.getUserGroup());
                userObjects.add(strUserGroupId);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public ArrayList<UserRoleData> getUserRoleDatas(String strDEId, String strAction) throws Exception {
        ArrayList<UserRoleData> retUserRoleDataList = new ArrayList<UserRoleData>();
        ArrayList<UserRoleData> deUserRoleDatas = null;
        HashMap<String, ArrayList<UserRoleData>> hashMap = this.deUserDataMap;
        synchronized (hashMap) {
            if (this.deUserDataMap.containsKey(strDEId)) {
                deUserRoleDatas = this.deUserDataMap.get(strDEId);
            }
        }
        if (deUserRoleDatas == null) {
            ArrayList<UserRoleData> deUserRoleDatas2 = this.getUserRoleDatas(strDEId);
            deUserRoleDatas = new ArrayList();
            TreeMap loadedMap = new TreeMap();
            for (UserRoleData userRoleData : deUserRoleDatas2) {
                if (loadedMap.containsKey(userRoleData.getUserRoleDataId())) continue;
                userRoleData.addAction("READ", true);
                UserRoleDataActionService userRoleDataActionService = (UserRoleDataActionService)ServiceGlobal.getService(UserRoleDataActionService.class);
                ArrayList<UserRoleDataAction> deUserRoleDataActions = userRoleDataActionService.selectByUserRoleData(userRoleData);
                for (UserRoleDataAction action : deUserRoleDataActions) {
                    userRoleData.addAction(action.getUserRoleDataActionName(), DataObject.getBoolValue(action, "ISALLOW", true));
                }
                if (!DataObject.getBoolValue(userRoleData.getIsAllData(), false)) {
                    UserRoleDataDetailService userRoleDataDetailService = (UserRoleDataDetailService)ServiceGlobal.getService(UserRoleDataDetailService.class);
                    ArrayList<UserRoleDataDetail> deUserRoleDataDetails = userRoleDataDetailService.selectByUserRoleData(userRoleData);
                    userRoleData.getDetailList().addAll(deUserRoleDataDetails);
                }
                deUserRoleDatas.add(userRoleData);
            }
            HashMap<String, ArrayList<UserRoleData>> hashMap2 = this.deUserDataMap;
            synchronized (hashMap2) {
                this.deUserDataMap.put(strDEId, deUserRoleDatas);
            }
        }
        if (deUserRoleDatas != null) {
            for (UserRoleData userRoleData : deUserRoleDatas) {
                if (!userRoleData.containsAction(strAction)) continue;
                retUserRoleDataList.add(userRoleData);
            }
            return retUserRoleDataList;
        }
        return null;
    }

    @Override
    public boolean testUserRoleUniRes(String strResType, String strResId) throws Exception {
        boolean bRet = false;
        if (this.isEnableSysUserRole()) {
            for (Map.Entry<String, ISystemUserRoleModel> sysUserRoleModel : this.sysUserRoleMap.entrySet()) {
                if (!sysUserRoleModel.getValue().testUniResTag(strResId)) continue;
                return true;
            }
        } else {
            ArrayList<UserRoleRes> userRoleReses = this.getUserRoleReses(strResType, strResId);
            for (UserRoleRes userRoleRes : userRoleReses) {
                if (!DataObject.getBoolValue(userRoleRes.getIsAllow(), true)) {
                    return false;
                }
                bRet = true;
            }
        }
        return bRet;
    }

    @Override
    public boolean testUserRoleDataAction(String strDEId, IEntity dataEntity, String strAction) throws Exception {
        IDataEntityModel iDEModel = DEModelGlobal.getDEModel(strDEId);
        return this.testUserRoleDataAction(iDEModel, dataEntity, strAction);
    }

    @Override
    public boolean testUserRoleDataAction(IDataEntityModel iDEModel, IEntity dataEntity, String strAction) throws Exception {
        if (iDEModel.getDataAccCtrlMode() == 2 || iDEModel.getDataAccCtrlMode() == 3) {
            IDER1N iDER1N = iDEModel.getAccMasterDER(dataEntity);
            if (iDER1N == null) {
                throw new Exception(StringHelper.format("\u65e0\u6cd5\u627e\u5230\u6743\u9650\u4e3b\u5b9e\u4f53"));
            }
            IDataEntityModel majorDEModel = ((IDER1NModel)iDER1N).getMajorDEModel();
            Object objValue = dataEntity.get(iDER1N.getPickupDEFName());
            String strMajorAction = "UPDATE";
            Object parentEntity = majorDEModel.createEntity();
            parentEntity.set(majorDEModel.getKeyDEField().getName(), objValue);
            return this.testUserRoleDataAction(majorDEModel, (IEntity)parentEntity, strMajorAction);
        }
        ArrayList<UserRoleData> userRoleDatas = this.getUserRoleDatas(iDEModel.getId(), strAction);
        if (StringHelper.compare(strAction, "CREATE", false) == 0 && this.isTestCreateAdvanceMode()) {
            return this.testCreateAdvanceMode(iDEModel, dataEntity, userRoleDatas);
        }
        return userRoleDatas.size() > 0;
    }

    protected boolean testCreateAdvanceMode(IDataEntityModel iDEModel, IEntity dataEntity, ArrayList<UserRoleData> userRoleDatas) throws Exception {
        IDEField orgIdDEField = iDEModel.getDEFieldByPDT("ORGID", true);
        IDEField secIdDEField = iDEModel.getDEFieldByPDT("ORGSECTORID", true);
        if (orgIdDEField == null && secIdDEField == null) {
            return true;
        }
        for (UserRoleData userRoleData : userRoleDatas) {
            if (DataObject.getBoolValue(userRoleData.getIsAllData(), false)) {
                return true;
            }
            if (userRoleData.getDetailList().size() <= 0) continue;
            return true;
        }
        return true;
    }

    protected void listUserRoles() throws Exception {
        String strCondition;
        ArrayList<UserRole> list = new ArrayList<UserRole>();
        String strSQL = "";
        if (WebConfig.getCurrent().isLowCaseSql()) {
            strSQL = "select t2.createdate,t2.createman,t2.issystem,t2.memo,t2.menumode,t2.reserver,t2.reserver2,t2.reserver3,t2.reserver4,t2.updatedate,t2.updateman,t2.userdata,t2.userdata2,t2.userroleid,t2.userrolename,t2.userroletype from  t_srfuserrole t2 inner join t_srfuserroledetail t3 on t2.userroleid=t3.userroleid ";
            strSQL = String.valueOf(strSQL) + "where  (";
            strCondition = "";
            for (String strUserObjectId : this.allUserObjects) {
                if (!StringHelper.isNullOrEmpty(strCondition)) {
                    strCondition = String.valueOf(strCondition) + " or ";
                }
                strCondition = String.valueOf(strCondition) + StringHelper.format("t3.userobjectid='%1$s'", strUserObjectId);
            }
            strSQL = String.valueOf(strSQL) + strCondition;
            strSQL = String.valueOf(strSQL) + ")";
        } else {
            strSQL = "SELECT t2.* from  T_SRFUSERROLE t2 INNER JOIN T_SRFUSERROLEDETAIL t3 ON t2.USERROLEID=t3.USERROLEID ";
            strSQL = String.valueOf(strSQL) + "where  (";
            strCondition = "";
            for (String strUserObjectId : this.allUserObjects) {
                if (!StringHelper.isNullOrEmpty(strCondition)) {
                    strCondition = String.valueOf(strCondition) + " OR ";
                }
                strCondition = String.valueOf(strCondition) + StringHelper.format("t3.USEROBJECTID='%1$s'", strUserObjectId);
            }
            strSQL = String.valueOf(strSQL) + strCondition;
            strSQL = String.valueOf(strSQL) + ")";
        }
        UserRoleService userRoleService = (UserRoleService)ServiceGlobal.getService(UserRoleService.class);
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int testUserRoleDEField(String strDEName, String strField) throws Exception {
        CallResult callResult = new CallResult();
        HashMap<String, Integer> deFields = null;
        HashMap<String, HashMap<String, Integer>> hashMap = this.deFieldPrivMap;
        synchronized (hashMap) {
            deFields = this.deFieldPrivMap.get(strDEName);
        }
        if (deFields == null) {
            ArrayList<UserRoleDEField> deUserRoleDEFields = this.getUserRoleDEFields(strDEName);
            deFields = new HashMap();
            for (UserRoleDEField userRoleDEField : deUserRoleDEFields) {
                String[] defields;
                int nAction = 0;
                if (StringHelper.compare(userRoleDEField.getDEFAction(), "UPDATE", true) == 0) {
                    nAction = 3;
                }
                if (StringHelper.compare(userRoleDEField.getDEFAction(), "READ", true) == 0) {
                    nAction = 1;
                }
                String[] stringArray = defields = userRoleDEField.getRelatedDEField().toUpperCase().split("[;]");
                int n = defields.length;
                int n2 = 0;
                while (n2 < n) {
                    String strDEField = stringArray[n2];
                    if (deFields.containsKey(strDEField)) {
                        if (deFields.get(strDEField) < nAction) {
                            deFields.put(strDEField, nAction);
                        }
                    } else {
                        deFields.put(strDEField, nAction);
                    }
                    ++n2;
                }
            }
            HashMap<String, HashMap<String, Integer>> hashMap2 = this.deFieldPrivMap;
            synchronized (hashMap2) {
                this.deFieldPrivMap.put(strDEName, deFields);
            }
        }
        int nRet = 0;
        if (deFields != null && deFields.containsKey(strField)) {
            nRet = deFields.get(strField);
        }
        return nRet;
    }

    protected ArrayList<UserRoleData> getUserRoleDatas(String strDataEntityId) throws Exception {
        String strCondition;
        ArrayList<UserRoleData> list = new ArrayList<UserRoleData>();
        if (this.allUserObjects.size() == 0) {
            return list;
        }
        String strSQL = "";
        if (WebConfig.getCurrent().isLowCaseSql()) {
            strSQL = StringHelper.format("select t1.bcdr,t1.createdate,t1.createman,t1.deid,t1.dstorgid,t1.dstorgsectorid,t1.dstsecbc,t1.isalldata,t1.memo,t1.orgdr,t1.reserver,t1.reserver2,t1.reserver3,t1.reserver4,t1.secdr,t1.srfsyspub,t1.srfuserpub,t1.udversion,t1.updatedate,t1.updateman,t1.userdr,t1.userroledataid,t1.userroledataname from t_srfuserroledata t1 INNER JOIN T_SRFUSERROLEDATAS t6 ON t1.USERROLEDATAID = t6.USERROLEDATAID INNER JOIN T_SRFUSERROLE t2 on t6.USERROLEID=t2.USERROLEID INNER JOIN T_SRFUSERROLEDETAIL t3 ON t2.USERROLEID=t3.USERROLEID where t1.DEID='%1$s' AND ", strDataEntityId);
            strSQL = String.valueOf(strSQL) + "  (";
            strCondition = "";
            for (String strUserObjectId : this.allUserObjects) {
                if (!StringHelper.isNullOrEmpty(strCondition)) {
                    strCondition = String.valueOf(strCondition) + " or ";
                }
                strCondition = String.valueOf(strCondition) + StringHelper.format("t3.userobjectid='%1$s'", strUserObjectId);
            }
            strSQL = String.valueOf(strSQL) + strCondition;
            strSQL = String.valueOf(strSQL) + ")";
        } else {
            strSQL = StringHelper.format("select t1.* from T_SRFUSERROLEDATA t1 INNER JOIN T_SRFUSERROLEDATAS t6 ON t1.USERROLEDATAID = t6.USERROLEDATAID INNER JOIN T_SRFUSERROLE t2 on t6.USERROLEID=t2.USERROLEID INNER JOIN T_SRFUSERROLEDETAIL t3 ON t2.USERROLEID=t3.USERROLEID where t1.DEID='%1$s' AND ", strDataEntityId);
            strSQL = String.valueOf(strSQL) + "  (";
            strCondition = "";
            for (String strUserObjectId : this.allUserObjects) {
                if (!StringHelper.isNullOrEmpty(strCondition)) {
                    strCondition = String.valueOf(strCondition) + " OR ";
                }
                strCondition = String.valueOf(strCondition) + StringHelper.format("t3.USEROBJECTID='%1$s'", strUserObjectId);
            }
            strSQL = String.valueOf(strSQL) + strCondition;
            strSQL = String.valueOf(strSQL) + ")";
        }
        UserRoleDataService userRoleDataService = (UserRoleDataService)ServiceGlobal.getService(UserRoleDataService.class);
        ArrayList<IEntity> list2 = userRoleDataService.selectRaw(strSQL, null);
        for (IEntity iEntity : list2) {
            UserRoleData userRoleData = new UserRoleData();
            iEntity.copyTo(userRoleData, false);
            list.add(userRoleData);
        }
        return list;
    }

    protected ArrayList<UserRoleDEField> getUserRoleDEFields(String strDEName) throws Exception {
        String strCondition;
        ArrayList<UserRoleDEField> list = new ArrayList<UserRoleDEField>();
        if (this.allUserObjects.size() == 0) {
            return list;
        }
        String strSQL = "";
        if (WebConfig.getCurrent().isLowCaseSql()) {
            strSQL = StringHelper.format("select t1.createdate,t1.createman,t1.defaction,t1.deid,t1.dename,t1.relateddefield,t1.reserver,t1.reserver2,t1.reserver3,t1.reserver4,t1.srfsyspub,t1.srfuserpub,t1.updatedate,t1.updateman,t1.userroledefieldid,t1.userroledefieldname from t_srfuserroledefield t1 inner join t_srfuserroledefields t6 on t1.userroledefieldid = t6.userroledefieldid inner join t_srfuserrole t2 on t6.userroleid=t2.userroleid inner join t_srfuserroledetail t3 on t2.userroleid=t3.userroleid where t1.dename='%1$s' and ", strDEName);
            strSQL = String.valueOf(strSQL) + "  (";
            strCondition = "";
            for (String strUserObjectId : this.allUserObjects) {
                if (!StringHelper.isNullOrEmpty(strCondition)) {
                    strCondition = String.valueOf(strCondition) + " or ";
                }
                strCondition = String.valueOf(strCondition) + StringHelper.format("t3.userobjectid='%1$s'", strUserObjectId);
            }
            strSQL = String.valueOf(strSQL) + strCondition;
            strSQL = String.valueOf(strSQL) + ")";
        } else {
            strSQL = StringHelper.format("select t1.* from T_SRFUSERROLEDEFIELD t1 INNER JOIN T_SRFUSERROLEDEFIELDS t6 ON t1.USERROLEDEFIELDID = t6.USERROLEDEFIELDID INNER JOIN T_SRFUSERROLE t2 on t6.USERROLEID=t2.USERROLEID INNER JOIN T_SRFUSERROLEDETAIL t3 ON t2.USERROLEID=t3.USERROLEID where t1.DENAME='%1$s' AND ", strDEName);
            strSQL = String.valueOf(strSQL) + "  (";
            strCondition = "";
            for (String strUserObjectId : this.allUserObjects) {
                if (!StringHelper.isNullOrEmpty(strCondition)) {
                    strCondition = String.valueOf(strCondition) + " OR ";
                }
                strCondition = String.valueOf(strCondition) + StringHelper.format("t3.USEROBJECTID='%1$s'", strUserObjectId);
            }
            strSQL = String.valueOf(strSQL) + strCondition;
            strSQL = String.valueOf(strSQL) + ")";
        }
        UserRoleDEFieldService userRoleDEFieldService = (UserRoleDEFieldService)ServiceGlobal.getService(UserRoleDEFieldService.class);
        ArrayList<IEntity> list2 = userRoleDEFieldService.selectRaw(strSQL, null);
        for (IEntity iEntity : list2) {
            UserRoleDEField userRoleData = new UserRoleDEField();
            iEntity.copyTo(userRoleData, false);
            list.add(userRoleData);
        }
        return list;
    }

    @Override
    public String getUserId() {
        return this.strCurPersonId;
    }

    public String getCurOrgId() {
        return this.strCurOrgId;
    }

    public String getCurOrgSectorId() {
        return this.strCurOrgSectorId;
    }

    public String getCurOrgSectorBC() {
        return this.strCurOrgSectorBC;
    }

    @Override
    public Org getOrg() throws Exception {
        return OrgGlobal.getOrg(this.strCurOrgId);
    }

    @Override
    public OrgSector getOrgSector() throws Exception {
        return OrgGlobal.getOrgSector(this.strCurOrgSectorId);
    }

    @Override
    public String getUserRoleDataCond(IService iService, UserRoleData userRoleData) throws Exception {
        return this.getUserRoleDataCond(iService, userRoleData, null);
    }

    @Override
    public String getUserRoleDataCond(IService iService, UserRoleData userRoleData, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        IDataEntityModel iDEModel = iService.getDEModel();
        ArrayList<String> userRoleDataCondList = new ArrayList<String>();
        if (!DataObject.getBoolValue(userRoleData.getIsAllData(), false)) {
            String strCond;
            IDEField orgIdDEField = iDEModel.getDEFieldByPDT("ORGID", true);
            IDEField secIdDEField = iDEModel.getDEFieldByPDT("ORGSECTORID", true);
            IDEField createManDEField = iDEModel.getDEFieldByPDT("CREATEMAN", true);
            IDEField updateManDEField = iDEModel.getDEFieldByPDT("UPDATEMAN", true);
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
                    if (!StringHelper.isNullOrEmpty(strOrgCond)) {
                        userRoleDataCondList.add(strOrgCond);
                    }
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
                    if (!StringHelper.isNullOrEmpty(strOrgSectorCond)) {
                        userRoleDataCondList.add(strOrgSectorCond);
                    }
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
                    int i = 0;
                    while (i < arrBC.length) {
                        if (i > 0) {
                            sBuilderEx.append(",");
                        }
                        sBuilderEx.append(StringHelper.format("'%1$s'", arrBC[i]));
                        ++i;
                    }
                    String strCon = StringHelper.format("%1$s.bizcode in (%2$s)", strOrgSectorAlias, sBuilderEx.toString());
                    userRoleDataCondList.add(strCon);
                }
            }
            String strUserDR = "";
            if (createManDEField != null && userRoleData.getUserDR() != null && (userRoleData.getUserDR() & URDUserDRCodeListModel.CREATEMAN) > 0) {
                strCond = StringHelper.format("${srfdefieldexp('%1$s')} = '%2$s'", createManDEField.getName(), this.getUserId());
                strUserDR = String.valueOf(strUserDR) + strCond;
            }
            if (updateManDEField != null && userRoleData.getUserDR() != null && (userRoleData.getUserDR() & URDUserDRCodeListModel.UPDATEMAN) > 0) {
                if (!StringHelper.isNullOrEmpty(strUserDR)) {
                    strUserDR = String.valueOf(strUserDR) + " OR ";
                }
                strCond = StringHelper.format("${srfdefieldexp('%1$s')} = '%2$s'", updateManDEField.getName(), this.getUserId());
                strUserDR = String.valueOf(strUserDR) + strCond;
            }
            if (!StringHelper.isNullOrEmpty(strUserDR)) {
                userRoleDataCondList.add(strUserDR);
            }
            for (UserRoleDataDetail userRoleDataDetail : userRoleData.getDetailList()) {
                IDEDataQuery iDEDataQuery = iDEModel.getDEDataQuery(userRoleDataDetail.getQueryModelId());
                IDEDataQueryCode iDEDataQueryCode = iDEDataQuery.getDEDataQueryCode(iService.getDAO().getRealDBDialect().getDBType());
                Iterator<IDEDataQueryCodeCond> deDataQueryCodeConds = iDEDataQueryCode.getDEDataQueryCodeConds();
                while (deDataQueryCodeConds.hasNext()) {
                    IDEDataQueryCodeCond iDEDataQueryCodeCond = deDataQueryCodeConds.next();
                    if (StringHelper.compare(iDEDataQueryCodeCond.getCondType(), "CUSTOM", true) != 0) continue;
                    userRoleDataCondList.add(iDEDataQueryCodeCond.getCustomCond());
                }
            }
        } else {
            userRoleDataCondList.add(" 1=1 ");
        }
        if (userRoleDataCondList.size() == 0) {
            return null;
        }
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        int i = 0;
        while (i < userRoleDataCondList.size()) {
            if (i > 0) {
                sBuilderEx.append(" AND ");
            }
            sBuilderEx.append(StringHelper.format("(%1$s)", userRoleDataCondList.get(i)));
            ++i;
        }
        return sBuilderEx.toString();
    }

    @Override
    public String getDEDataRangeCond(IService iService, IDEDataRange iDEDataRange) throws Exception {
        return this.getDEDataRangeCond(iService, iDEDataRange, null);
    }

    @Override
    public String getDEDataRangeCond(IService iService, IDEDataRange iDEDataRange, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        String strCurOrgSectorId;
        String strCurOrgId;
        IDataEntityModel iDEModel = iService.getDEModel();
        IDEField orgIdDEField = iDEModel.getDEFieldByPDT("ORGID", true);
        IDEField secIdDEField = iDEModel.getDEFieldByPDT("ORGSECTORID", true);
        String strOrgAlias = "o1";
        String strOrgSectorAlias = "o2";
        ArrayList<String> userRoleDataCondList = new ArrayList<String>();
        if (orgIdDEField != null && iDEDataRange.isEnableOrgDR() && !StringHelper.isNullOrEmpty(strCurOrgId = this.strCurOrgId)) {
            Org curOrg = OrgGlobal.getOrg(strCurOrgId);
            String strOrgCond = iService.getDAO().getRealDBDialect().getOrgDRCond(iDEDataRange, curOrg, strOrgAlias);
            if (!StringHelper.isNullOrEmpty(strOrgCond)) {
                userRoleDataCondList.add(strOrgCond);
            }
        }
        if (secIdDEField != null && iDEDataRange.isEnableSecDR() && !StringHelper.isNullOrEmpty(strCurOrgSectorId = this.strCurOrgSectorId)) {
            OrgSector curOrgSector = OrgGlobal.getOrgSector(strCurOrgSectorId);
            String strOrgSectorCond = iService.getDAO().getRealDBDialect().getOrgSecDRCond(iDEDataRange, curOrgSector, strOrgSectorAlias);
            if (!StringHelper.isNullOrEmpty(strOrgSectorCond)) {
                userRoleDataCondList.add(strOrgSectorCond);
            }
        }
        if (userRoleDataCondList.size() == 0) {
            return null;
        }
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        int i = 0;
        while (i < userRoleDataCondList.size()) {
            if (i > 0) {
                sBuilderEx.append(" AND ");
            }
            sBuilderEx.append(StringHelper.format("(%1$s)", userRoleDataCondList.get(i)));
            ++i;
        }
        return sBuilderEx.toString();
    }

    protected ArrayList<UserRoleRes> getUserRoleReses(String strResType, String strRealResId) throws Exception {
        String strCondition;
        ArrayList<UserRoleRes> list = new ArrayList<UserRoleRes>();
        if (this.allUserObjects.size() == 0) {
            return list;
        }
        String strSQL = "";
        if (WebConfig.getCurrent().isLowCaseSql()) {
            strSQL = StringHelper.format("select t1.createdate,t1.createman,t1.isallow,t1.reserver,t1.reserver2,t1.reserver3,t1.reserver4,t1.uniresid,t1.updatedate,t1.updateman,t1.userroleid,t1.userroleresid,t1.userroleresname from t_srfuserroleres t1  inner join t_srfunires t6 on t1.uniresid = t6.uniresid  inner join t_srfuserrole t2 on t1.userroleid = t2.userroleid  inner join t_srfuserroledetail t3 on t2.userroleid=t3.userroleid  where ((t6.unirestype='%1$s' and upper(t6.resourceid)='%3$s') )   and ", strResType, strRealResId.toUpperCase(), strRealResId.toUpperCase());
            strSQL = String.valueOf(strSQL) + "  (";
            strCondition = "";
            for (String strUserObjectId : this.allUserObjects) {
                if (!StringHelper.isNullOrEmpty(strCondition)) {
                    strCondition = String.valueOf(strCondition) + " OR ";
                }
                strCondition = String.valueOf(strCondition) + StringHelper.format("t3.USEROBJECTID='%1$s'", strUserObjectId);
            }
            strSQL = String.valueOf(strSQL) + strCondition;
            strSQL = String.valueOf(strSQL) + ")";
        } else {
            strSQL = StringHelper.format("select t1.* from t_SRFUSERROLERES t1  INNER JOIN T_SRFUNIRES t6 ON t1.UNIRESID = t6.UNIRESID  INNER JOIN T_SRFUSERROLE t2 ON t1.USERROLEID = t2.USERROLEID  INNER JOIN T_SRFUSERROLEDETAIL t3 ON t2.USERROLEID=t3.USERROLEID  where ((t6.UNIRESTYPE='%1$s' AND UPPER(t6.RESOURCEID)='%3$s') )   AND ", strResType, strRealResId.toUpperCase(), strRealResId.toUpperCase());
            strSQL = String.valueOf(strSQL) + "  (";
            strCondition = "";
            for (String strUserObjectId : this.allUserObjects) {
                if (!StringHelper.isNullOrEmpty(strCondition)) {
                    strCondition = String.valueOf(strCondition) + " OR ";
                }
                strCondition = String.valueOf(strCondition) + StringHelper.format("t3.USEROBJECTID='%1$s'", strUserObjectId);
            }
            strSQL = String.valueOf(strSQL) + strCondition;
            strSQL = String.valueOf(strSQL) + ")";
        }
        UserRoleResService userRoleResService = (UserRoleResService)ServiceGlobal.getService(UserRoleResService.class);
        ArrayList<IEntity> list2 = userRoleResService.selectRaw(strSQL, null);
        for (IEntity iEntity : list2) {
            UserRoleRes userRoleData = new UserRoleRes();
            iEntity.copyTo(userRoleData, false);
            list.add(userRoleData);
        }
        return list;
    }

    protected boolean isOrgAdmin() {
        return this.bOrgAdmin;
    }

    public void setTestCreateAdvanceMode(boolean bTestCreateAdvanceMode) {
        this.bTestCreateAdvanceMode = bTestCreateAdvanceMode;
    }

    public boolean isTestCreateAdvanceMode() {
        return this.bTestCreateAdvanceMode;
    }

    @Override
    public String getDEOPPrivRoleCond(IService iService, String strDataAccAction, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        Iterator<IDEOPPrivRole> deOPPrivRoles = iService.getDEModel().getDEOPPrivRoles(strDataAccAction);
        if (deOPPrivRoles == null) {
            return null;
        }
        ArrayList<String> condList = new ArrayList<String>();
        while (deOPPrivRoles.hasNext()) {
            IDEOPPrivRole iDEOPPrivRole = deOPPrivRoles.next();
            if (StringHelper.isNullOrEmpty(iDEOPPrivRole.getDEDataQueryId())) continue;
            ArrayList<String> userRoleDataCondList2 = new ArrayList<String>();
            IDEDataQuery iDEDataQuery = iService.getDEModel().getDEDataQuery(iDEOPPrivRole.getDEDataQueryId());
            IDEDataQueryCode iDEDataQueryCode = iDEDataQuery.getDEDataQueryCode(iService.getDAO().getRealDBDialect().getDBType());
            Iterator<IDEDataQueryCodeCond> deDataQueryCodeConds = iDEDataQueryCode.getDEDataQueryCodeConds();
            while (deDataQueryCodeConds.hasNext()) {
                IDEDataQueryCodeCond iDEDataQueryCodeCond = deDataQueryCodeConds.next();
                if (StringHelper.compare(iDEDataQueryCodeCond.getCondType(), "CUSTOM", true) != 0) continue;
                userRoleDataCondList2.add(iDEDataQueryCodeCond.getCustomCond());
            }
            if (userRoleDataCondList2.size() <= 0) continue;
            StringBuilderEx sBuilderEx = new StringBuilderEx();
            int i = 0;
            while (i < userRoleDataCondList2.size()) {
                if (i > 0) {
                    sBuilderEx.append(" AND ");
                }
                sBuilderEx.append(StringHelper.format("(%1$s)", userRoleDataCondList2.get(i)));
                ++i;
            }
            condList.add(sBuilderEx.toString());
        }
        if (condList.size() == 0) {
            return null;
        }
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        int i = 0;
        while (i < condList.size()) {
            if (i > 0) {
                sBuilderEx.append(" OR ");
            }
            sBuilderEx.append(StringHelper.format("(%1$s)", condList.get(i)));
            ++i;
        }
        return sBuilderEx.toString();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public boolean testDEOPPrivRoleAction(IWebContext iWebContext, IDataEntityModel iDEModel, IEntity dataEntity, String strDataAccAction) throws Exception {
        deOPPrivRoles = iDEModel.getDEOPPrivRoles(strDataAccAction);
        if (deOPPrivRoles != null) ** GOTO lbl7
        return false;
lbl-1000:
        // 1 sources

        {
            iDEOPPrivRole = deOPPrivRoles.next();
            if (StringHelper.isNullOrEmpty(iDEOPPrivRole.getSysUserRoleId()) || !(iSystemUserRoleModel = iDEModel.getSystemModel().getSystemUserRoleModel(iDEOPPrivRole.getSysUserRoleId())).testCurUser(iWebContext)) continue;
            return true;
lbl7:
            // 2 sources

            ** while (deOPPrivRoles.hasNext())
        }
lbl8:
        // 1 sources

        return false;
    }

    @Override
    public boolean testSysUserRole(String strSysUserRoleTag) throws Exception {
        return this.sysUserRoleMap.containsKey(strSysUserRoleTag);
    }

    @Override
    public void registerSysUserRole(ISystemUserRoleModel iSystemUserRoleModel) {
        this.sysUserRoleMap.put(iSystemUserRoleModel.getRoleTag(), iSystemUserRoleModel);
    }

    @Override
    public Iterator<ISystemUserRoleModel> getSysUserRoles() {
        return this.sysUserRoleMap.values().iterator();
    }

    @Override
    public void setEnableSysUserRole(boolean bEnableSysUserRole) {
        this.bEnableSysUserRole = bEnableSysUserRole;
    }

    @Override
    public boolean isEnableSysUserRole() {
        return this.bEnableSysUserRole;
    }
}

