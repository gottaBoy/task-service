/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Security;

import SA.SRFDA.Ctrl.Data.DEDataAction;
import SA.SRFDA.Ctrl.Data.ORGTreeNode;
import SA.SRFDA.Ctrl.Data.ORGUnit;
import SA.SRFDA.Ctrl.Data.UserGroup;
import SA.SRFDA.Ctrl.Data.UserRole;
import SA.SRFDA.Ctrl.Data.UserRoleDEField;
import SA.SRFDA.Ctrl.Data.UserRoleData;
import SA.SRFDA.Ctrl.Data.UserRoleDataAction;
import SA.SRFDA.Ctrl.Data.UserRoleDataDetail;
import SA.SRFDA.Ctrl.Data.UserRoleRes;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Security.IUserRoleHelper;
import SA.SRFDA.Security.UserQueryModelStorage;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UserRoleHelper
implements Serializable,
IUserRoleHelper {
    private static final long serialVersionUID = -3189449155900178266L;
    private GlobalHelperEx globalHelperEx = null;
    private String strCurPersonId = "";
    private Hashtable<String, Vector<UserRoleData>> deUserDataMap = new Hashtable();
    private Hashtable<String, Hashtable<String, Integer>> deFieldPrivMap = new Hashtable();
    private static final Log log = LogFactory.getLog(UserRoleHelper.class);
    private UserQueryModelStorage userQueryModelStorage = null;
    private boolean bAdvUserGroupMode = false;
    private Vector<String> allUserObjects = new Vector();
    Hashtable<String, String> allUserObjectMap = new Hashtable();
    Hashtable<String, UserGroup> allUserGroupMap = new Hashtable();
    Vector<UserRole> allUserRoles = new Vector();
    protected boolean bEnableOU = false;
    protected ORGUnit orgUnit = null;
    protected ArrayList<ORGTreeNode> orgTreeNodeList = null;
    protected HashMap<String, ORGTreeNode> orgTreeNodeMap = null;
    protected HashMap<String, ArrayList<ORGTreeNode>> parentORGTreeNodesMap = null;

    public UserRoleHelper(GlobalHelperEx globalHelperEx, String strCurPersonId) {
        this.globalHelperEx = globalHelperEx;
        this.strCurPersonId = strCurPersonId;
        this.bAdvUserGroupMode = this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "ADVUSERGROUP", false);
        if (this.bAdvUserGroupMode) {
            log.info((Object)StringHelper.Format((String)"\u7528\u6237\u89d2\u8272\u542f\u7528\u9ad8\u7ea7\u7528\u6237\u7ec4\u6a21\u5f0f\uff0c\u652f\u6301\u7528\u6237\u7ec4\u5305\u542b\u5173\u7cfb"));
        }
        this.allUserObjects.clear();
        this.allUserObjectMap.clear();
        this.ListUserGroups();
        this.ListUserRoles();
        this.bEnableOU = this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "ENABLEOU", false);
        if (this.bEnableOU) {
            try {
                this.InitOU();
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316OU\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
        }
    }

    @Override
    public String getCurUserId() {
        return this.strCurPersonId;
    }

    @Override
    public ORGUnit getCurOU() throws Exception {
        if (!this.isEnableOU()) {
            throw new Exception("\u7cfb\u7edf\u4e0d\u652f\u6301OU");
        }
        return this.orgUnit;
    }

    @Override
    public boolean isEnableOU() {
        return this.bEnableOU;
    }

    protected void InitOU() throws Exception {
        ORGUnit orgUnit = new ORGUnit();
        CallResult callResult = this.globalHelperEx.getDAModelHelper().GetORGUnit(this.strCurPersonId, orgUnit);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7528\u6237[%1$s]\u7ec4\u7ec7\u5355\u5143\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.strCurPersonId, (Object)callResult.getErrorInfo()));
        }
        this.orgUnit = orgUnit;
        Vector<ORGTreeNode> orgTreeNodeList = new Vector<ORGTreeNode>();
        callResult = this.globalHelperEx.getDAModelHelper().GetORGTreeNodes("", this.orgUnit.getORGUNITID(), orgTreeNodeList);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7528\u6237[%1$s]\u7ec4\u7ec7\u6811\u8282\u70b9\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.strCurPersonId, (Object)callResult.getErrorInfo()));
        }
        this.orgTreeNodeList = new ArrayList();
        this.orgTreeNodeList.addAll(orgTreeNodeList);
        this.orgTreeNodeMap = new HashMap();
        for (ORGTreeNode orgTreeNode : this.orgTreeNodeList) {
            this.orgTreeNodeMap.put(orgTreeNode.getORGTREENODEID(), orgTreeNode);
        }
        this.parentORGTreeNodesMap = new HashMap();
    }

    protected void ListUserGroups() {
        this.allUserObjectMap.put(this.strCurPersonId, "");
        this.allUserObjects.add(this.strCurPersonId);
        Vector<String> userObjects = new Vector<String>();
        userObjects.add(this.strCurPersonId);
        while (userObjects.size() > 0) {
            Vector<UserGroup> userGroups = new Vector<UserGroup>();
            CallResult callResult = this.globalHelperEx.getDAModelHelper().GetUserObjectPUserGroups(userObjects, userGroups);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u5bf9\u8c61\u6240\u5c5e\u7528\u6237\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return;
            }
            userObjects.clear();
            for (UserGroup userGroup : userGroups) {
                String strUserGroupId = userGroup.getUSERGROUPID();
                if (this.allUserObjectMap.containsKey(strUserGroupId)) continue;
                this.allUserObjectMap.put(strUserGroupId, "");
                this.allUserObjects.add(strUserGroupId);
                this.allUserGroupMap.put(strUserGroupId, userGroup);
                userObjects.add(strUserGroupId);
            }
        }
    }

    @Override
    public UserQueryModelStorage getUserQueryModelStorage() {
        return this.userQueryModelStorage;
    }

    @Override
    public void setUserQueryModelStorage(UserQueryModelStorage userQueryModelStorage) {
        this.userQueryModelStorage = userQueryModelStorage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public CallResult GetUserRoleData(String strDEId, String strAction, Vector<UserRoleData> userRoleDatas) {
        CallResult callResult = new CallResult();
        Vector<UserRoleData> deUserRoleDatas = null;
        Hashtable<String, Vector<UserRoleData>> hashtable = this.deUserDataMap;
        synchronized (hashtable) {
            if (this.deUserDataMap.containsKey(strDEId)) {
                deUserRoleDatas = this.deUserDataMap.get(strDEId);
            }
        }
        if (deUserRoleDatas == null) {
            Vector<UserRoleData> deUserRoleDatas2 = new Vector<UserRoleData>();
            callResult = this.bAdvUserGroupMode ? this.globalHelperEx.getDAModelHelper().GetUserRoleDatas(strDEId, this.allUserObjects, deUserRoleDatas2) : this.globalHelperEx.getDAModelHelper().GetUserRoleDatas(strDEId, this.strCurPersonId, deUserRoleDatas2);
            if (callResult.getRetCode() != 0) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u7528\u6237[%1$s]\u6570\u636e[%2$s]\u6743\u9650\u63a7\u5236\u4ee3\u7801\u5931\u8d25\uff0c%3$s", (Object)this.strCurPersonId, (Object)strDEId, (Object)callResult.getErrorInfo()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            deUserRoleDatas = new Vector();
            TreeMap loadedMap = new TreeMap();
            for (UserRoleData userRoleData : deUserRoleDatas2) {
                if (loadedMap.containsKey(userRoleData.getUSERROLEDATAID())) continue;
                userRoleData.AddAction("READ", true);
                Vector<UserRoleDataAction> deUserRoleDataActions = new Vector<UserRoleDataAction>();
                callResult = this.globalHelperEx.getDAModelHelper().GetUserRoleDataActions(userRoleData.getUSERROLEDATAID(), deUserRoleDataActions);
                if (callResult.getRetCode() != 0) {
                    callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u7528\u6237\u6570\u636e\u89d2\u8272[%1$s]\u64cd\u4f5c\u660e\u7ec6\u5931\u8d25\uff0c%2$s", (Object)userRoleData.getUSERROLEDATAID(), (Object)callResult.getErrorInfo()));
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                for (UserRoleDataAction action : deUserRoleDataActions) {
                    userRoleData.AddAction(action.getUSERROLEDATAACTIONNAME(), action.isALLOW());
                }
                if (!userRoleData.isALLDATA()) {
                    Vector<UserRoleDataDetail> deUserRoleDataDetails = new Vector<UserRoleDataDetail>();
                    callResult = this.globalHelperEx.getDAModelHelper().GetUserRoleDataDetails(userRoleData.getUSERROLEDATAID(), deUserRoleDataDetails);
                    if (callResult.getRetCode() != 0) {
                        callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u7528\u6237\u6570\u636e\u89d2\u8272[%1$s]\u6570\u636e\u660e\u7ec6\u5931\u8d25\uff0c%2$s", (Object)userRoleData.getUSERROLEDATAID(), (Object)callResult.getErrorInfo()));
                        log.error((Object)callResult.getErrorInfo());
                        return callResult;
                    }
                    for (UserRoleDataDetail detail : deUserRoleDataDetails) {
                        userRoleData.GetDataDetails().add(detail);
                    }
                }
                deUserRoleDatas.add(userRoleData);
            }
            Hashtable<String, Vector<UserRoleData>> hashtable2 = this.deUserDataMap;
            synchronized (hashtable2) {
                this.deUserDataMap.put(strDEId, deUserRoleDatas);
            }
        }
        if (deUserRoleDatas != null) {
            for (UserRoleData userRoleData : deUserRoleDatas) {
                if (!userRoleData.ContainsAction(strAction)) continue;
                userRoleDatas.add(userRoleData);
            }
            return callResult;
        }
        return callResult;
    }

    @Override
    public CallResult GetUserRoleRes(String strResType, String strResId) {
        Vector<UserRoleRes> userRoleReses = new Vector<UserRoleRes>();
        CallResult callResult = null;
        callResult = this.bAdvUserGroupMode ? this.globalHelperEx.getDAModelHelper().GetUserRoleReses(strResType, strResId, this.allUserObjects, userRoleReses) : this.globalHelperEx.getDAModelHelper().GetUserRoleReses(strResType, strResId, this.strCurPersonId, userRoleReses);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        callResult.setUserObject((Object)false);
        for (UserRoleRes userRoleRes : userRoleReses) {
            if (!userRoleRes.isALLOW()) {
                callResult.setUserObject((Object)false);
                return callResult;
            }
            callResult.setUserObject((Object)true);
        }
        return callResult;
    }

    @Override
    public CallResult TestUserRoleDataAction(String strDEId, String strAction) {
        Vector<UserRoleData> userRoleDatas;
        CallResult callResult;
        IDEHelper iDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strDEId);
        if (iDEHelper == null) {
            CallResult callResult2 = new CallResult();
            callResult2.setRetCode(1);
            callResult2.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId));
            return callResult2;
        }
        IDEHelper iMajorDEHelper = iDEHelper.GetMajorDEHelper();
        if (StringHelper.Compare((String)iMajorDEHelper.getId(), (String)iDEHelper.getId(), (boolean)true) != 0) {
            DEDataAction deDataAction = new DEDataAction();
            callResult = iDEHelper.GetDataAccHelper().GetDataActionMap(strAction, this.globalHelperEx, deDataAction);
            if (callResult.getRetCode() != 0) {
                return callResult;
            }
            if (deDataAction.isMAPTOMAJOR()) {
                return this.TestUserRoleDataAction(iMajorDEHelper.getId(), deDataAction.getMAJORDEACTION());
            }
        }
        if ((callResult = this.GetUserRoleData(strDEId, strAction, userRoleDatas = new Vector<UserRoleData>())).getRetCode() != 0) {
            return callResult;
        }
        callResult.setUserObject((Object)(userRoleDatas.size() != 0 ? 1 : 0));
        if (userRoleDatas.size() == 0) {
            callResult.setRetCode(2);
        }
        return callResult;
    }

    protected boolean ListUserRoles() {
        Vector<UserRole> tempuserRoles = new Vector<UserRole>();
        CallResult callResult = null;
        callResult = this.bAdvUserGroupMode ? this.globalHelperEx.getDAModelHelper().GetUserRoles(this.allUserObjects, tempuserRoles) : this.globalHelperEx.getDAModelHelper().GetUserRoles(this.strCurPersonId, tempuserRoles);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u7528\u6237[%1$s]\u89d2\u8272\u5931\u8d25\uff0c%2$s", (Object)this.strCurPersonId, (Object)callResult.getErrorInfo()));
            return false;
        }
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        for (UserRole userRole : tempuserRoles) {
            if (map.containsKey(userRole.getUSERROLEID())) continue;
            this.allUserRoles.add(userRole);
            map.put(userRole.getUSERROLEID(), 1);
        }
        return true;
    }

    @Override
    public boolean GetUserRoles(Vector<UserRole> userRoles) {
        userRoles.addAll(this.allUserRoles);
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public CallResult GetUserRoleDEField(String strDEId, String strField) {
        CallResult callResult = new CallResult();
        Hashtable<String, Integer> deFields = null;
        Hashtable<String, Hashtable<String, Integer>> hashtable = this.deFieldPrivMap;
        synchronized (hashtable) {
            if (this.deFieldPrivMap.containsKey(strDEId)) {
                deFields = this.deFieldPrivMap.get(strDEId);
            }
        }
        if (deFields == null) {
            Vector<UserRoleDEField> deUserRoleDEFields = new Vector<UserRoleDEField>();
            callResult = this.bAdvUserGroupMode ? this.globalHelperEx.getDAModelHelper().GetUserRoleDEFields(strDEId, this.allUserObjects, deUserRoleDEFields) : this.globalHelperEx.getDAModelHelper().GetUserRoleDEFields(strDEId, this.strCurPersonId, deUserRoleDEFields);
            if (callResult.getRetCode() != 0) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u7528\u6237[%1$s]\u5b9e\u4f53[%2$s]\u5c5e\u6027\u6743\u9650\u63a7\u5236\u4ee3\u7801\u5931\u8d25\uff0c%3$s", (Object)this.strCurPersonId, (Object)strDEId, (Object)callResult.getErrorInfo()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            deFields = new Hashtable();
            for (UserRoleDEField userRoleDEField : deUserRoleDEFields) {
                int nAction = 0;
                if (StringHelper.Compare((String)userRoleDEField.getDEFACTION(), (String)"UPDATE", (boolean)true) == 0) {
                    nAction = 3;
                }
                if (StringHelper.Compare((String)userRoleDEField.getDEFACTION(), (String)"READ", (boolean)true) == 0) {
                    nAction = 1;
                }
                CodeListConfig codeListConfig = new CodeListConfig();
                XMLConfig.LoadFromXML((String)userRoleDEField.getRELATEDDEFIELD(), (XMLConfig)codeListConfig);
                int nCount = codeListConfig.getCodeItems().size();
                int i = 0;
                while (i < nCount) {
                    CodeItemConfig codeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(i);
                    String strDEFId = codeItemConfig.getValue().toUpperCase();
                    if (deFields.containsKey(strDEFId)) {
                        if (deFields.get(strDEFId) < nAction) {
                            deFields.put(strDEFId, nAction);
                        }
                    } else {
                        deFields.put(strDEFId, nAction);
                    }
                    ++i;
                }
            }
            Hashtable<String, Hashtable<String, Integer>> hashtable2 = this.deFieldPrivMap;
            synchronized (hashtable2) {
                this.deFieldPrivMap.put(strDEId, deFields);
            }
        }
        int nRet = 0;
        if (deFields != null && deFields.containsKey(strField)) {
            nRet = deFields.get(strField);
        }
        callResult.setUserObject((Object)nRet);
        return callResult;
    }

    @Override
    public Enumeration<String> getAllUserObjects() {
        return this.allUserObjects.elements();
    }

    @Override
    public boolean ContainsUserGroup(String strUserGroupId) {
        return this.allUserGroupMap.containsKey(strUserGroupId);
    }

    @Override
    public Iterator<UserGroup> getAllUserGroups() {
        return this.allUserGroupMap.values().iterator();
    }

    @Override
    public Iterator<ORGTreeNode> getCurORGTreeNodes() throws Exception {
        if (!this.isEnableOU()) {
            throw new Exception("\u7cfb\u7edf\u4e0d\u652f\u6301OU");
        }
        return this.orgTreeNodeList.iterator();
    }

    @Override
    public Iterator<ORGTreeNode> getParentORGTreeNodes(String strORGTreeNodeId) throws Exception {
        if (!this.isEnableOU()) {
            throw new Exception("\u7cfb\u7edf\u4e0d\u652f\u6301OU");
        }
        ArrayList<ORGTreeNode> parentORGTreeNodeList = this.parentORGTreeNodesMap.get(strORGTreeNodeId);
        if (parentORGTreeNodeList != null) {
            return parentORGTreeNodeList.iterator();
        }
        if (!this.orgTreeNodeMap.containsKey(strORGTreeNodeId)) {
            throw new Exception("\u4f20\u5165\u7684\u7ec4\u7ec7\u6811\u8282\u70b9\u65e0\u6548\uff0c\u4e0d\u662f\u5f53\u524dOU\u5173\u8054");
        }
        Vector<ORGTreeNode> orgTreeNodeList = new Vector<ORGTreeNode>();
        CallResult callResult = this.globalHelperEx.getDAModelHelper().GetAllParentORGTreeNodes(strORGTreeNodeId, orgTreeNodeList);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7ec4\u7ec7\u6811\u8282\u70b9[%1$s]\u5168\u90e8\u7236\u8282\u70b9\uff08\u9012\u5f52\uff09\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strORGTreeNodeId, (Object)callResult.getErrorInfo()));
        }
        ArrayList<ORGTreeNode> orgTreeNodeList2 = new ArrayList<ORGTreeNode>();
        orgTreeNodeList2.addAll(orgTreeNodeList);
        this.parentORGTreeNodesMap.put(strORGTreeNodeId, orgTreeNodeList2);
        return orgTreeNodeList2.iterator();
    }
}

