/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Security;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.QueryModel;
import SA.SRFDA.Ctrl.Data.UserRoleData;
import SA.SRFDA.Ctrl.Data.UserRoleDataDetail;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Model.DGModelCustomLogicConfig;
import SA.SRFDA.Model.DGModelJoinQueryConfig;
import SA.SRFDA.Model.DGModelMainQueryConfig;
import SA.SRFDA.Security.IUserRoleHelper;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UserQueryModelStorage
implements Serializable {
    private static final long serialVersionUID = 9186667293158438022L;
    private GlobalHelperEx globalHelperEx = null;
    private IUserRoleHelper userRoleHelper = null;
    private String strCurPersonId = "";
    protected Hashtable<String, BaseDAQueryModelHelper> daQueryModelHelperMap = new Hashtable();
    private static final Log log = LogFactory.getLog(UserQueryModelStorage.class);
    protected HashMap<String, String> sessionValueMap = new HashMap();

    public UserQueryModelStorage(IUserRoleHelper userRoleHelper, GlobalHelperEx globalHelperEx, String strCurPersonId) {
        this.userRoleHelper = userRoleHelper;
        this.globalHelperEx = globalHelperEx;
        this.strCurPersonId = strCurPersonId;
        this.userRoleHelper.setUserQueryModelStorage(this);
    }

    public void RegisterSessionValue(String strSessionKey, String strValue) {
        this.sessionValueMap.put(strSessionKey, strValue);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public BaseDAQueryModelHelper FindDAQueryModelHelper(IDEHelper iDEHelper, String strAction, boolean bSelectOnlyKey) {
        String strDAQueryModeHelperId = StringHelper.Format((String)"%1$s_%2$s_%3$s_%4$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion(), (Object)strAction, (Object)bSelectOnlyKey);
        String strGridViewId = StringHelper.Format((String)"DE_%1$s_%2$s", (Object)iDEHelper.getId(), (Object)strAction);
        BaseDAQueryModelHelper daQueryModelHelper = null;
        Hashtable<String, BaseDAQueryModelHelper> hashtable = this.daQueryModelHelperMap;
        synchronized (hashtable) {
            daQueryModelHelper = this.daQueryModelHelperMap.get(strGridViewId);
        }
        if (daQueryModelHelper != null && StringHelper.Compare((String)daQueryModelHelper.getDAQueryModelHelperId(), (String)strDAQueryModeHelperId, (boolean)true) == 0) {
            return daQueryModelHelper;
        }
        DGModelMainQueryConfig mainQueryConfig = new DGModelMainQueryConfig();
        if (bSelectOnlyKey) {
            mainQueryConfig.setExtSelect(iDEHelper.GetKeyDEFHelper().getName());
        }
        if ((daQueryModelHelper = this.GetDAQueryModelHelper(iDEHelper, mainQueryConfig, null, "", strAction, false)) != null) {
            daQueryModelHelper.setDAQueryModelHelperId(strDAQueryModeHelperId);
            Hashtable<String, BaseDAQueryModelHelper> hashtable2 = this.daQueryModelHelperMap;
            synchronized (hashtable2) {
                this.daQueryModelHelperMap.put(strGridViewId, daQueryModelHelper);
            }
        }
        return daQueryModelHelper;
    }

    public BaseDAQueryModelHelper FindDAQueryModelHelper(IDEHelper iDEHelper) {
        return this.FindDAQueryModelHelper(iDEHelper, "", false);
    }

    public BaseDAQueryModelHelper FindDAQueryModelHelper(IDEHelper iDEHelper, String strAction) {
        return this.FindDAQueryModelHelper(iDEHelper, strAction, true);
    }

    public BaseDAQueryModelHelper FindDAQueryModelHelper(String strQueryModelId, DataGrid gridView) {
        return this.FindDAQueryModelHelperEx(strQueryModelId, gridView, false);
    }

    public BaseDAQueryModelHelper FindDAQueryModelHelperEx(String strQueryModelId, DataGrid gridView, boolean bDeleteMode) {
        return this.FindDAQueryModelHelperEx(strQueryModelId, gridView, "", bDeleteMode);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public BaseDAQueryModelHelper FindDAQueryModelHelperEx(String strQueryModelId, DataGrid gridView, String strDPDataAction, boolean bDeleteMode) {
        IDEHelper iDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(gridView.getDEID());
        if (iDEHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)gridView.getDEID()));
            return null;
        }
        QueryModel queryModel = new QueryModel();
        CallResult callResult = this.globalHelperEx.getDAModelStorage().GetQueryModel(strQueryModelId, queryModel, true);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u67e5\u8be2\u6a21\u578b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strQueryModelId, (Object)callResult.getErrorInfo()));
            return null;
        }
        if (StringHelper.Compare((String)queryModel.getDEID(), (String)iDEHelper.getId(), (boolean)true) != 0) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6a21\u578b\u6570\u636e\u5bf9\u8c61\u8c61[%1$s]\u4e0e\u8868\u683c\u6a21\u578b\u6570\u636e\u5bf9\u8c61[%2$s]\u4e00\u81f4", (Object)queryModel.getDEID(), (Object)iDEHelper.getId()));
            return null;
        }
        boolean bOptimize = false;
        if (!bDeleteMode && gridView.getOptimizeQueryMode()) {
            bOptimize = true;
        }
        String strDAQueryModeHelperId = StringHelper.Format((String)"%1$s_%2$s_%3$s_%4$s_%5$s%6$s", (Object)gridView.getDATAGRIDID(), (Object)gridView.getDGVERSION(), (Object)iDEHelper.getDataEntity().getDEVERSION(), (Object)strQueryModelId, (Object)queryModel.getQMVERSION(), (Object)(bDeleteMode ? "_DELETE" : ""));
        if (!StringHelper.IsNullOrEmpty((String)strDPDataAction)) {
            strDAQueryModeHelperId = String.valueOf(strDAQueryModeHelperId) + "_" + strDPDataAction;
        }
        if (bOptimize) {
            strDAQueryModeHelperId = String.valueOf(strDAQueryModeHelperId) + "_O";
        }
        String strGridViewId = StringHelper.Format((String)"DG_%1$s_%2$s%3$s", (Object)gridView.getDATAGRIDID(), (Object)strQueryModelId, (Object)(bDeleteMode ? "_DELETE" : ""));
        if (!StringHelper.IsNullOrEmpty((String)strDPDataAction)) {
            strGridViewId = String.valueOf(strGridViewId) + "_" + strDPDataAction;
        }
        if (bOptimize) {
            strGridViewId = String.valueOf(strGridViewId) + "_O";
        }
        BaseDAQueryModelHelper daQueryModelHelper = null;
        Hashtable<String, BaseDAQueryModelHelper> hashtable = this.daQueryModelHelperMap;
        synchronized (hashtable) {
            daQueryModelHelper = this.daQueryModelHelperMap.get(strGridViewId);
        }
        if (daQueryModelHelper != null && StringHelper.Compare((String)daQueryModelHelper.getDAQueryModelHelperId(), (String)strDAQueryModeHelperId, (boolean)true) == 0) {
            return daQueryModelHelper;
        }
        DGModelMainQueryConfig mainQueryConfig = null;
        if (gridView.getDataGridModelConfig() != null) {
            mainQueryConfig = gridView.getDataGridModelConfig().getMainQueryConfig();
        }
        if ((daQueryModelHelper = this.GetDAQueryModelHelper(iDEHelper, queryModel.getQueryModelConfig(), mainQueryConfig, queryModel.getQUERYOBJECT(), strDPDataAction, bDeleteMode)) != null) {
            daQueryModelHelper.setDAQueryModelHelperId(strDAQueryModeHelperId);
            Hashtable<String, BaseDAQueryModelHelper> hashtable2 = this.daQueryModelHelperMap;
            synchronized (hashtable2) {
                this.daQueryModelHelperMap.put(strGridViewId, daQueryModelHelper);
            }
        }
        return daQueryModelHelper;
    }

    public BaseDAQueryModelHelper FindDAQueryModelHelper(String strQueryModelId) {
        return this.FindDAQueryModelHelperEx(strQueryModelId, false);
    }

    public BaseDAQueryModelHelper FindDAQueryModelHelperEx(String strQueryModelId, boolean bDeleteMode) {
        return this.FindDAQueryModelHelperEx(strQueryModelId, "", bDeleteMode);
    }

    public BaseDAQueryModelHelper FindDAQueryModelHelperEx(String strQueryModelId, String strDPDataAction, boolean bDeleteMode) {
        QueryModel queryModel = new QueryModel();
        CallResult callResult = this.globalHelperEx.getDAModelStorage().GetQueryModel(strQueryModelId, queryModel, true);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u67e5\u8be2\u6a21\u578b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strQueryModelId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return this.FindDAQueryModelHelperEx(queryModel, strDPDataAction, bDeleteMode);
    }

    public BaseDAQueryModelHelper FindDAQueryModelHelper(QueryModel queryModel) {
        return this.FindDAQueryModelHelperEx(queryModel, false);
    }

    public BaseDAQueryModelHelper FindDAQueryModelHelperEx(QueryModel queryModel, boolean bDeleteMode) {
        return this.FindDAQueryModelHelperEx(queryModel, "", bDeleteMode);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public BaseDAQueryModelHelper FindDAQueryModelHelperEx(QueryModel queryModel, String strDPDataAction, boolean bDeleteMode) {
        IDEHelper iDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(queryModel.getDEID());
        if (iDEHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)queryModel.getDEID()));
            return null;
        }
        String strDAQueryModeHelperId = StringHelper.Format((String)"%1$s_%2$s_%3$s%4$s", (Object)iDEHelper.getDataEntity().getDEVERSION(), (Object)queryModel.getQUERYMODELID(), (Object)queryModel.getQMVERSION(), (Object)(bDeleteMode ? "_DELETE" : ""));
        if (!StringHelper.IsNullOrEmpty((String)strDPDataAction)) {
            strDAQueryModeHelperId = String.valueOf(strDAQueryModeHelperId) + "_" + strDPDataAction;
        }
        String strGridViewId = StringHelper.Format((String)"QM_%1$s_%2$s%3$s", (Object)queryModel.getQUERYMODELID(), (Object)queryModel.getQMVERSION(), (Object)(bDeleteMode ? "_DELETE" : ""));
        if (!StringHelper.IsNullOrEmpty((String)strDPDataAction)) {
            strGridViewId = String.valueOf(strGridViewId) + "_" + strDPDataAction;
        }
        BaseDAQueryModelHelper daQueryModelHelper = null;
        Hashtable<String, BaseDAQueryModelHelper> hashtable = this.daQueryModelHelperMap;
        synchronized (hashtable) {
            daQueryModelHelper = this.daQueryModelHelperMap.get(strGridViewId);
        }
        if (daQueryModelHelper != null && StringHelper.Compare((String)daQueryModelHelper.getDAQueryModelHelperId(), (String)strDAQueryModeHelperId, (boolean)true) == 0) {
            return daQueryModelHelper;
        }
        daQueryModelHelper = this.GetDAQueryModelHelper(iDEHelper, queryModel.getQueryModelConfig(), null, queryModel.getQUERYOBJECT(), strDPDataAction, bDeleteMode);
        if (daQueryModelHelper != null) {
            daQueryModelHelper.setDAQueryModelHelperId(strDAQueryModeHelperId);
            hashtable = this.daQueryModelHelperMap;
            synchronized (hashtable) {
                this.daQueryModelHelperMap.put(strGridViewId, daQueryModelHelper);
            }
        }
        return daQueryModelHelper;
    }

    public BaseDAQueryModelHelper FindDAQueryModelHelper(DataGrid gridView) {
        return this.FindDAQueryModelHelperEx(gridView, false);
    }

    public BaseDAQueryModelHelper FindDAQueryModelHelperEx(DataGrid gridView, boolean bDeleteMode) {
        return this.FindDAQueryModelHelperEx(gridView, "", bDeleteMode);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public BaseDAQueryModelHelper FindDAQueryModelHelperEx(DataGrid gridView, String strDPDataAction, boolean bDeleteMode) {
        IDEHelper iDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(gridView.getDEID());
        if (iDEHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)gridView.getDEID()));
            return null;
        }
        boolean bOptimize = false;
        if (!bDeleteMode && gridView.getOptimizeQueryMode()) {
            bOptimize = true;
        }
        String strDAQueryModeHelperId = StringHelper.Format((String)"%1$s_%2$s_%3$s%4$s", (Object)gridView.getDATAGRIDID(), (Object)gridView.getDGVERSION(), (Object)iDEHelper.getDataEntity().getDEVERSION(), (Object)(bDeleteMode ? "_DELETE" : ""));
        if (!StringHelper.IsNullOrEmpty((String)strDPDataAction)) {
            strDAQueryModeHelperId = String.valueOf(strDAQueryModeHelperId) + "_" + strDPDataAction;
        }
        if (bOptimize) {
            strDAQueryModeHelperId = String.valueOf(strDAQueryModeHelperId) + "_O";
        }
        String strGridViewId = StringHelper.Format((String)"DG_%1$s%2$s", (Object)gridView.getDATAGRIDID(), (Object)(bDeleteMode ? "_DELETE" : ""));
        if (!StringHelper.IsNullOrEmpty((String)strDPDataAction)) {
            strGridViewId = String.valueOf(strGridViewId) + "_" + strDPDataAction;
        }
        if (bOptimize) {
            strGridViewId = String.valueOf(strGridViewId) + "_O";
        }
        BaseDAQueryModelHelper daQueryModelHelper = null;
        Hashtable<String, BaseDAQueryModelHelper> hashtable = this.daQueryModelHelperMap;
        synchronized (hashtable) {
            daQueryModelHelper = this.daQueryModelHelperMap.get(strGridViewId);
        }
        if (daQueryModelHelper != null && StringHelper.Compare((String)daQueryModelHelper.getDAQueryModelHelperId(), (String)strDAQueryModeHelperId, (boolean)true) == 0) {
            return daQueryModelHelper;
        }
        DGModelMainQueryConfig mainQueryConfig = null;
        if (gridView.getDataGridModelConfig() != null) {
            mainQueryConfig = gridView.getDataGridModelConfig().getMainQueryConfig();
        }
        if ((daQueryModelHelper = this.GetDAQueryModelHelper(iDEHelper, mainQueryConfig, null, "", strDPDataAction, bDeleteMode)) != null) {
            daQueryModelHelper.setDAQueryModelHelperId(strDAQueryModeHelperId);
            Hashtable<String, BaseDAQueryModelHelper> hashtable2 = this.daQueryModelHelperMap;
            synchronized (hashtable2) {
                this.daQueryModelHelperMap.put(strGridViewId, daQueryModelHelper);
            }
        }
        return daQueryModelHelper;
    }

    private BaseDAQueryModelHelper GetDAQueryModelHelper(IDEHelper iDEHelper, DGModelMainQueryConfig mainQueryConfig, DGModelMainQueryConfig mainQueryConfig2, String strDEHelperObject, String strDPDataAction, boolean bDeleteMode) {
        BaseDAQueryModelHelper daQueryModelHelper;
        CallResult callResult;
        if (mainQueryConfig == null) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u67e5\u8be2\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25\uff0c\u65e0\u6cd5\u83b7\u53d6\u914d\u7f6e"));
            return null;
        }
        if (StringHelper.IsNullOrEmpty((String)strDEHelperObject)) {
            if (!StringHelper.IsNullOrEmpty((String)iDEHelper.GetDBStorage())) {
                strDEHelperObject = this.globalHelperEx.getDAModelStorage().FindDBStorage(iDEHelper.GetDBStorage()).GetProperty("DAQUERYMODELHELPER");
            }
            if (StringHelper.IsNullOrEmpty((String)strDEHelperObject)) {
                strDEHelperObject = this.globalHelperEx.getGlobalConfigMgr().GetWebExConfig().GetValue("SRFDA", "DAQUERYMODELHELPER", "");
            }
        }
        if ((callResult = (daQueryModelHelper = (BaseDAQueryModelHelper)ObjectHelper.Create((String)strDEHelperObject)).Init(iDEHelper, this.globalHelperEx)).getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u67e5\u8be2\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25"));
            return null;
        }
        daQueryModelHelper.RegisterStaticParamValue("%%SRFOPPERSON()%%", this.strCurPersonId);
        daQueryModelHelper.RegisterStaticParamValue("%%SRFOPPERSON%%", this.strCurPersonId);
        for (String strKey : this.sessionValueMap.keySet()) {
            String strMacroParam = "%%SRFSV(" + strKey + ")%%";
            daQueryModelHelper.RegisterStaticParamValue(strMacroParam, this.sessionValueMap.get(strKey));
        }
        boolean bDPEnable = false;
        Vector<Vector<DGModelMainQueryConfig>> notQueryConfigs = new Vector<Vector<DGModelMainQueryConfig>>();
        Vector<Vector<DGModelMainQueryConfig>> orQueryConfigs = new Vector<Vector<DGModelMainQueryConfig>>();
        if (StringHelper.IsNullOrEmpty((String)strDPDataAction)) {
            strDPDataAction = "READ";
        }
        bDPEnable = true;
        Vector<UserRoleData> userRoleDatas = new Vector<UserRoleData>();
        callResult = this.userRoleHelper.GetUserRoleData(iDEHelper.getId(), strDPDataAction, userRoleDatas);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u6570\u636e\u6743\u9650\u5931\u8d25,%1$s", (Object)callResult.getErrorInfo()));
            return null;
        }
        boolean bOrQueryAllData = false;
        boolean bNotQueryAllData = false;
        HashMap<String, String> orQueryConfigsMap = new HashMap<String, String>();
        for (UserRoleData userRoleData : userRoleDatas) {
            boolean bOrQuery = userRoleData.GetAction(strDPDataAction);
            boolean bAllDataMode = false;
            String strDetailsTag = "";
            Vector<DGModelMainQueryConfig> details = new Vector<DGModelMainQueryConfig>();
            if (userRoleData.isALLDATA()) {
                bAllDataMode = true;
                DGModelMainQueryConfig queryConfig = new DGModelMainQueryConfig();
                queryConfig.InitLogicConfig();
                queryConfig.getLogicConfig().InitLogicsConfig();
                DGModelCustomLogicConfig customLogicConfig = new DGModelCustomLogicConfig();
                customLogicConfig.setCondition("\"1=1\"");
                queryConfig.getLogicConfig().getLogicsConfig().add(customLogicConfig);
                details.add(queryConfig);
                strDetailsTag = "ALLDATA";
            } else {
                if (userRoleData.GetDataDetails().size() == 0) continue;
                for (UserRoleDataDetail userRoleDataDetail : userRoleData.GetDataDetails()) {
                    QueryModel queryModel = new QueryModel();
                    callResult = this.globalHelperEx.getDAModelStorage().GetQueryModel(userRoleDataDetail.getQUERYMODELID(), queryModel, true);
                    if (callResult.getRetCode() != 0) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u67e5\u8be2\u6a21\u578b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)userRoleDataDetail.getQUERYMODELID(), (Object)callResult.getErrorInfo()));
                        return null;
                    }
                    DGModelMainQueryConfig queryConfig = queryModel.getQueryModelConfig();
                    if (userRoleDataDetail.isEXCLUDE()) {
                        queryConfig.setExclude(true);
                    }
                    details.add(queryConfig);
                    if (!StringHelper.IsNullOrEmpty((String)strDetailsTag)) {
                        strDetailsTag = String.valueOf(strDetailsTag) + "|";
                    }
                    strDetailsTag = String.valueOf(strDetailsTag) + StringHelper.Format((String)"%1$s_%2$s", (Object)userRoleDataDetail.getQUERYMODELID(), (Object)userRoleDataDetail.isEXCLUDE());
                }
                if (details.size() == 0) continue;
            }
            if (bOrQuery) {
                if (bOrQueryAllData || orQueryConfigsMap.containsKey(strDetailsTag)) continue;
                orQueryConfigsMap.put(strDetailsTag, "");
                if (bAllDataMode) {
                    orQueryConfigs.clear();
                    bOrQueryAllData = true;
                }
                orQueryConfigs.add(details);
                continue;
            }
            notQueryConfigs.add(details);
        }
        if (StringHelper.Compare((String)iDEHelper.GetMajorDEId(), (String)iDEHelper.getId(), (boolean)true) != 0) {
            userRoleDatas = new Vector();
            callResult = this.userRoleHelper.GetUserRoleData(iDEHelper.GetMajorDEId(), strDPDataAction, userRoleDatas);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u6570\u636e\u6743\u9650\u5931\u8d25,%1$s", (Object)callResult.getErrorInfo()));
                return null;
            }
            for (UserRoleData userRoleData : userRoleDatas) {
                Vector<DGModelMainQueryConfig> details = new Vector<DGModelMainQueryConfig>();
                if (userRoleData.isALLDATA()) {
                    DGModelMainQueryConfig queryConfig = new DGModelMainQueryConfig();
                    queryConfig.InitLogicConfig();
                    queryConfig.getLogicConfig().InitLogicsConfig();
                    DGModelCustomLogicConfig customLogicConfig = new DGModelCustomLogicConfig();
                    customLogicConfig.setCondition("\"1=1\"");
                    queryConfig.getLogicConfig().getLogicsConfig().add(customLogicConfig);
                    details.add(queryConfig);
                } else {
                    if (userRoleData.GetDataDetails().size() == 0) continue;
                    for (UserRoleDataDetail userRoleDataDetail : userRoleData.GetDataDetails()) {
                        QueryModel queryModel = new QueryModel();
                        callResult = this.globalHelperEx.getDAModelStorage().GetQueryModel(userRoleDataDetail.getQUERYMODELID(), queryModel, true);
                        if (callResult.getRetCode() != 0) {
                            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u67e5\u8be2\u6a21\u578b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)userRoleDataDetail.getQUERYMODELID(), (Object)callResult.getErrorInfo()));
                            return null;
                        }
                        DGModelMainQueryConfig queryConfig = queryModel.getQueryModelConfig();
                        DGModelMainQueryConfig realQueryConfig = new DGModelMainQueryConfig();
                        realQueryConfig.InitJoinQueriesConfig();
                        if (userRoleDataDetail.isEXCLUDE()) {
                            realQueryConfig.setExclude(true);
                        }
                        DGModelJoinQueryConfig joinQueryConfig = new DGModelJoinQueryConfig();
                        joinQueryConfig.setDERID(iDEHelper.GetMajorDERId());
                        joinQueryConfig.setDERType(iDEHelper.GetMajorDERType());
                        joinQueryConfig.SetLogicConfig(queryConfig.getLogicConfig());
                        joinQueryConfig.SetJoinQueriesConfig(queryConfig.getJoinQueriesConfig());
                        realQueryConfig.getJoinQueriesConfig().add(joinQueryConfig);
                        details.add(realQueryConfig);
                    }
                    if (details.size() == 0) continue;
                }
                if (userRoleData.GetAction(strDPDataAction)) {
                    orQueryConfigs.add(details);
                    continue;
                }
                notQueryConfigs.add(details);
            }
        }
        if ((callResult = daQueryModelHelper.CompileEx(mainQueryConfig, mainQueryConfig2, bDPEnable, notQueryConfigs, orQueryConfigs, bDeleteMode)).getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u7f16\u8bd1\u67e5\u8be2\u6a21\u578b\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return null;
        }
        return daQueryModelHelper;
    }
}
