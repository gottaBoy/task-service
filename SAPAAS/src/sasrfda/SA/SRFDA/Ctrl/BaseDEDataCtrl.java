/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.Data.SelectResult2
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.ProcParam
 *  SA.SRFramework.DataEx.ValueError
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.XML.XMLNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDEHelper;
import SA.SRFDA.Ctrl.DEDataCtrl.DataLockDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.DBAction;
import SA.SRFDA.Ctrl.Data.DEAction;
import SA.SRFDA.Ctrl.Data.DEDataChg;
import SA.SRFDA.Ctrl.Data.DEDataCtrl;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DataLock;
import SA.SRFDA.Ctrl.Data.DataNotify;
import SA.SRFDA.Ctrl.Data.IgnorePatch;
import SA.SRFDA.Ctrl.Data.TempData;
import SA.SRFDA.Ctrl.Data.VCLog;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrlEngine;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFDA.Ctrl.IDEMainActionHelper;
import SA.SRFDA.Ctrl.ISRFDAExtTransaction;
import SA.SRFDA.Ctrl.ISRFDATransactionManager;
import SA.SRFDA.Ctrl.SRFDAExtTransaction;
import SA.SRFDA.Ctrl.Utility.EncryptHelper;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.Security.IPasswordStorage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Data.SelectResult2;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.ProcParam;
import SA.SRFramework.DataEx.ValueError;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.XML.XMLNode;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseDEDataCtrl
implements IDEDataCtrl {
    protected IDEHelper iDEHelper = null;
    private ISRFDAWebContext webContext = null;
    protected ISRFDAGlobalHelper globalHelperEx = null;
    protected String strCurOpPersonId = "";
    protected String strCurOrgUnitId = "";
    protected String strCurOrgUnitName = "";
    private static final Log log = LogFactory.getLog(BaseDEDataCtrl.class);
    protected String strSQL_GET = "";
    protected String strSQL_CHECKKEY = "";
    protected String strProcPreFix = "sp_";
    protected Vector<ProcParam> getParams = new Vector();
    protected Vector<ProcParam> checkkeyParams = new Vector();
    protected String strDataLockKey;
    protected DataLockDataCtrl dataLockDataCtrl = null;
    protected static final HashMap<String, String> ignoreChangeFieldMap = new HashMap();
    public static final String TAG_PASSWORDSTORAGE = "__SRF_PASSWORD__";
    public static final String TAG_PERSONID = "SRF_PERSONID";
    public static final String TAG_ORGUNITID = "SRF_ORGUNITID";
    public static final String TAG_ORGUNITNAME = "SRF_ORGUNITNAME";
    public static final String TAG_CHECKKEY = "SRF_CHECKKEY";
    public static final String TAG_DALOG = "SRF_DALOG";
    public static final String TAG_RETDATA = "SRF_RETDATA";
    public static final String TAG_RETCODE = "SRF_RETCODE";
    public static final String TAG_RETINFO = "SRF_RETINFO";
    public static final String TAG_RETINFORES = "SRF_RETINFORES";
    public static final String TAG_RETINFORESARG = "SRF_RETINFORESARG";
    public static final String TAG_TAG = "SRF_TAG";
    public static final String TAG_ACTIONMODE = "SRF_ACTIONMODE";
    public static final String TAG_ACTIONARG = "SRF_ACTIONARG";
    public static final String TAG_RD = "SRF_RD";
    public static final String TAG_FULLINFO = "SRF_FULLINFO";
    public static final String TAG_CHILDDATATAG = "SRF_CHILDDATATAG";
    public static final String TAG_DATALOCKKEY = "SRF_DATALOCKKEY";
    public static final String TAG_EXTARG = "SRF_EXTARG";
    public static final String ACTIONMODE_DEFAULT = "DEFAULT";
    public static final String ACTIONMODE_VCLOG = "VCLOG";
    public static final String ACTION_CHECKKEYSTATE = "CHECKKEYSTATE";
    public static final String ACTION_INSERT = "INSERT";
    public static final String ACTION_UPDATE = "UPDATE";
    public static final String ACTION_GET = "GET";
    public static final String ACTION_SELECT = "SELECT";
    public static final String ACTION_REMOVE = "REMOVE";
    public static final String ACTION_CUSTOMCALL = "CUSTOMCALL";
    public static final String ACTION_CUSTOMSAVECALL = "CUSTOMSAVECALL";
    public static final String ACTION_CUSTOMPROCCALL = "CUSTOMPROCCALL";
    public static final String ACTION_CUSTOMRAWPROCCALL = "CUSTOMRAWPROCCALL";
    public static final String TAG_VAR = "VAR_";
    public static final String TAG_VF = "VF_";
    public static final int CHECKKEYSTATE_OK = 0;
    public static final int CHECKKEYSTATE_NOTEXIST = 0;
    public static final int CHECKKEYSTATE_EXIST = 1;
    public static final int CHECKKEYSTATE_DELETE = 2;
    protected ISRFDATransactionManager iTransactionManager;
    protected int nTransactionMode = 0;
    protected Hashtable<String, IDEDataCtrlEngine> deDataCtrlEngineMap = null;
    protected boolean bTempDataMode = false;
    protected String strLanguage = "";
    private ThreadLocal<Hashtable<String, Object>> attributeMap = new ThreadLocal();
    protected boolean bImportMode = false;
    protected Hashtable<String, IDEDataCtrl> relatedDataCtrlMap = new Hashtable();
    protected boolean bSaveAndGetMode = false;
    private IDEDataCtrl referDEDataCtrl = null;
    private HashMap<String, BaseDataEntity> relatedDataMap = null;

    static {
        ignoreChangeFieldMap.put("CREATEDATE", "");
        ignoreChangeFieldMap.put("CREATEMAN", "");
        ignoreChangeFieldMap.put("UPDATEMAN", "");
        ignoreChangeFieldMap.put("UPDATEDATE", "");
        ignoreChangeFieldMap.put("VERSION", "");
    }

    @Override
    public void Init(IDEHelper iDEHelper, ISRFDAGlobalHelper globalHelperEx, String strCurPersonId, ISRFDAWebContext webContext) {
        this.webContext = webContext;
        this.iDEHelper = iDEHelper;
        this.globalHelperEx = globalHelperEx;
        this.strCurOpPersonId = strCurPersonId;
        if (webContext != null) {
            this.strLanguage = webContext.getLocalization();
            this.strCurOrgUnitId = webContext.getCurOrgUnitId();
            this.strCurOrgUnitName = webContext.getCurOrgUnitName();
        }
        this.bTempDataMode = StringHelper.Compare((String)this.iDEHelper.GetProperty("TEMPDATA", "FALSE"), (String)"TRUE", (boolean)true) == 0;
        this.bSaveAndGetMode = StringHelper.Compare((String)this.iDEHelper.GetDBType(), (String)"INFORMIX", (boolean)true) == 0;
    }

    protected Connection getConnection(String strAction, String strActionMode) {
        if (this.iTransactionManager == null) {
            return null;
        }
        String strProperty = StringHelper.Format((String)"TRANSACTION.%1$s.%2$s", (Object)strAction, (Object)strActionMode);
        String strValue = this.GetDEHelper().GetProperty(strProperty, "");
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            strValue = this.GetDEHelper().GetProperty("TRANSACTION", "TRUE");
        }
        if (StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) == 0) {
            return this.iTransactionManager.GetConnection(this.GetDEHelper().GetDBStorage());
        }
        return null;
    }

    protected Connection getConnection() {
        if (this.iTransactionManager == null) {
            return null;
        }
        String strValue = this.GetDEHelper().GetProperty("TRANSACTION", "TRUE");
        if (StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) == 0) {
            return this.iTransactionManager.GetConnection(this.GetDEHelper().GetDBStorage());
        }
        return null;
    }

    @Override
    public String getOPPersonId() {
        return this.strCurOpPersonId;
    }

    @Override
    public String getOrgUnitId() {
        return this.strCurOrgUnitId;
    }

    @Override
    public String getOrgUnitName() {
        return this.strCurOrgUnitName;
    }

    @Override
    public String getLanguage() {
        return this.strLanguage;
    }

    @Override
    public void setLanguage(String strLanguage) {
        this.strLanguage = strLanguage;
    }

    @Override
    public void setTransactionManager(ISRFDATransactionManager iTransactionManager) {
        this.iTransactionManager = iTransactionManager;
    }

    @Override
    public ISRFDATransactionManager getTransactionManager() {
        return this.iTransactionManager;
    }

    @Override
    public final ISRFDAWebContext getWebContext() {
        return this.webContext;
    }

    @Override
    public final IDEHelper GetDEHelper() {
        return this.iDEHelper;
    }

    @Override
    public final ISRFDAGlobalHelper getGlobalHelper() {
        return this.globalHelperEx;
    }

    @Override
    public CallResult Get(BaseDataEntity dataEntity) {
        return this.Get(ACTIONMODE_DEFAULT, dataEntity);
    }

    @Override
    public CallResult Get(String strActionMode, BaseDataEntity dataEntity) {
        Object objKeyData;
        String strChildDataTag = dataEntity.GetParamStringValue(TAG_CHILDDATATAG, "");
        CallResult callResult = this.InternalGet(dataEntity, true);
        if (callResult.IsError()) {
            objKeyData = dataEntity.GetParamValue(this.GetDEHelper().GetKeyDEFHelper().getName());
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s][%2$s]\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)this.GetDEHelper().getId(), (Object)objKeyData, (Object)callResult.getErrorInfo()));
        }
        if (callResult.IsOk() && !StringHelper.IsNullOrEmpty((String)strChildDataTag) && (callResult = this.InternalGetChildDatas(strChildDataTag, dataEntity)).IsError()) {
            objKeyData = dataEntity.GetParamValue(this.GetDEHelper().GetKeyDEFHelper().getName());
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s][%2$s]\u5b50\u6570\u636e\u6807\u8bb0[%4$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)this.GetDEHelper().getId(), (Object)objKeyData, (Object)callResult.getErrorInfo(), (Object)strChildDataTag));
        }
        if (callResult.IsError()) {
            return callResult;
        }
        return this.OnAfterGet(strActionMode, dataEntity);
    }

    protected CallResult OnAfterGet(String strActionMode, BaseDataEntity dataEntity) {
        return new CallResult();
    }

    protected CallResult InternalGetChildDatas(String strChildDataTag, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            Properties properties = PropertiesHelper.Load((String)strChildDataTag);
            for (Object objKey : properties.keySet()) {
                String strDERId = PropertiesHelper.GetProperty((Properties)properties, (String)objKey.toString(), (String)"");
                if (StringHelper.IsNullOrEmpty((String)strDERId)) continue;
                String strSortInfo = "";
                String[] parts = strDERId.split("[|]");
                if (parts.length >= 2) {
                    strDERId = parts[0];
                    strSortInfo = parts[1];
                }
                DER1N der1N = null;
                if (this.GetDEHelper().IsInheritMode()) {
                    der1N = this.GetDEHelper().GetInheritDEHelper().FindDER1N(strDERId);
                }
                if (der1N == null) {
                    der1N = this.GetDEHelper().FindDER1N(strDERId);
                }
                if (der1N == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]1N\u5173\u7cfb[%2$s]", (Object)this.GetDEHelper().getId(), (Object)strDERId));
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]1N\u5173\u7cfb[%2$s]", (Object)this.GetDEHelper().getId(), (Object)strDERId));
                    return callResult;
                }
                callResult = this.InternalGetChildData(objKey.toString(), der1N, strSortInfo, dataEntity);
            }
            return callResult;
        }
        catch (Exception e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b50\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()), (Throwable)e);
            return callResult;
        }
    }

    protected CallResult InternalGetChildData(String strChildDataTag, DER1N der1N, String strSortInfo, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            IDEHelper childDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper2(der1N.getMINORDEID());
            IDEDataCtrl childDEDataCtrl = this.GetRelatedDataCtrl(der1N.getMINORDEID());
            int i = 0;
            while (i <= 30) {
                String strHeader = StringHelper.Format((String)"%1$s%2$03d", (Object)strChildDataTag, (Object)(i + 1));
                Hashtable paramList = dataEntity.getTotalParamList();
                for (Object objKey : paramList.keySet()) {
                    String strKey = objKey.toString();
                    if (strKey.indexOf(strHeader) != 0) continue;
                    dataEntity.RemoveParam(strKey);
                }
                ++i;
            }
            Vector<BaseDataEntity> childDataList = new Vector<BaseDataEntity>();
            BaseDataEntity cond = new BaseDataEntity();
            cond.SetParamValue(der1N.getMAJORKEYDEFNAME(), dataEntity.GetParamValue(this.GetDEHelper().GetKeyDEFHelper().getName()));
            callResult = StringHelper.IsNullOrEmpty((String)strSortInfo) ? childDEDataCtrl.Select(cond, childDataList) : childDEDataCtrl.Select(cond, childDataList, "", strSortInfo);
            if (callResult.IsError()) {
                return callResult;
            }
            int nIndex = 0;
            for (BaseDataEntity childData : childDataList) {
                ++nIndex;
                Hashtable paramList = childData.getTotalParamList();
                for (Object objKey : paramList.keySet()) {
                    String strKey = objKey.toString();
                    String strNewKey = StringHelper.Format((String)"%1$s%2$03d%3$s", (Object)strChildDataTag, (Object)nIndex, (Object)strKey);
                    dataEntity.SetParamValue(strNewKey, childData.GetParamValue(strKey));
                }
                String strNewKey = StringHelper.Format((String)"%1$s%2$03d%3$s", (Object)strChildDataTag, (Object)nIndex, (Object)"ID");
                dataEntity.SetParamValue(strNewKey, childData.GetParamValue(childDEDataCtrl.GetDEHelper().GetKeyDEFHelper().getName()));
                strNewKey = StringHelper.Format((String)"%1$s%2$03d%3$s", (Object)strChildDataTag, (Object)nIndex, (Object)"NAME");
                dataEntity.SetParamValue(strNewKey, childData.GetParamValue(childDEDataCtrl.GetDEHelper().GetMajorDEFHelper().getName()));
                strNewKey = StringHelper.Format((String)"%1$s%2$03d%3$s", (Object)strChildDataTag, (Object)nIndex, (Object)"ENABLE");
                dataEntity.SetParamValue(strNewKey, (Object)1);
                strNewKey = StringHelper.Format((String)"%1$s%2$03d%3$s", (Object)strChildDataTag, (Object)nIndex, (Object)ACTION_UPDATE);
                dataEntity.SetParamValue(strNewKey, (Object)1);
            }
            return callResult;
        }
        catch (Exception e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
            return callResult;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected CallResult InternalGet(BaseDataEntity dataEntity, boolean bTransaction) {
        CallResult callResult = new CallResult();
        Vector<ProcParam> vector = this.getParams;
        synchronized (vector) {
            if (StringHelper.IsNullOrEmpty((String)this.strSQL_GET)) {
                this.getParams.clear();
                this.strSQL_GET = this.iDEHelper.GetSelectCode(this.getParams);
            }
        }
        if (StringHelper.IsNullOrEmpty((String)this.strSQL_GET)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u67e5\u8be2\u8bed\u53e5\u65e0\u6548");
            return callResult;
        }
        Vector<CallParam> params = new Vector<CallParam>();
        for (ProcParam procParam : this.getParams) {
            Object objValue = dataEntity.GetParamValue(procParam.getParamName());
            if (objValue == null) {
                callResult.setRetCode(4);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u952e\u503c[%1$s]", (Object)procParam.getParamName()));
                return callResult;
            }
            params.add(new CallParam(objValue));
        }
        callResult = BaseDEDataCtrl.SelectSingleEx(this.globalHelperEx, this.getConnection(ACTION_GET, ACTIONMODE_DEFAULT), this.GetDEHelper().GetDBStorage(), this.strSQL_GET, params, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        if (this.GetDEHelper().IsEnableEncryptStorage()) {
            BaseDEDataCtrl.DecryptDataEntity(this.GetDEHelper(), dataEntity);
        }
        dataEntity.SetParamValue(TAG_FULLINFO, (Object)1);
        return callResult;
    }

    @Override
    public int CheckKeyState2(BaseDataEntity dataEntity) throws Exception {
        CallResult callResult = this.CheckKeyState(dataEntity);
        if (callResult.IsError() || callResult.getUserObject() == null) {
            throw new Exception(StringHelper.Format((String)"\u68c0\u67e5\u6570\u636e\u662f\u5426\u5b58\u5728\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return (Integer)callResult.getUserObject();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public CallResult CheckKeyState(BaseDataEntity dataEntity) {
        Object objValue;
        CallResult callResult = new CallResult();
        if (dataEntity.getParamValue(this.GetDEHelper().GetKeyDEFHelper().getName()) == null && (objValue = this.GetDEHelper().getKeyValue(dataEntity)) != null) {
            dataEntity.setParamValue(this.GetDEHelper().GetKeyDEFHelper().getName(), objValue);
        }
        objValue = this.checkkeyParams;
        synchronized (objValue) {
            if (StringHelper.IsNullOrEmpty((String)this.strSQL_CHECKKEY)) {
                this.checkkeyParams.clear();
                this.strSQL_CHECKKEY = this.iDEHelper.GetCheckKeyCode(this.checkkeyParams);
            }
        }
        if (StringHelper.IsNullOrEmpty((String)this.strSQL_CHECKKEY)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u4e3b\u952e\u68c0\u67e5\u8bed\u53e5\u65e0\u6548");
            return callResult;
        }
        Vector<CallParam> params = new Vector<CallParam>();
        for (ProcParam procParam : this.checkkeyParams) {
            Object objValue2 = dataEntity.GetParamValue(procParam.getParamName());
            if (objValue2 == null) {
                callResult.setRetCode(4);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u952e\u503c[%1$s]", (Object)procParam.getParamName()));
                return callResult;
            }
            params.add(new CallParam(objValue2));
        }
        try {
            SelectResult selectResult = this.globalHelperEx.getDBCaller(this.GetDEHelper().GetDBStorage()).CallRaw3(this.getConnection(ACTION_CHECKKEYSTATE, ACTIONMODE_DEFAULT), this.strSQL_CHECKKEY, params);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            callResult.setRetCode(0);
            if (selectResult.getMainTable().GetRowCount() == 0) {
                callResult.setUserObject((Object)0);
                return callResult;
            }
            if (this.GetDEHelper().IsLogicValid()) {
                IDEFHelper logicDEFHelper = this.GetDEHelper().GetDEFHelperByPreDefineType("LOGICVALID");
                BaseDataEntity tempDataEntity = new BaseDataEntity();
                tempDataEntity.FromDataRow(selectResult.getMainTable().GetRow(0));
                if (tempDataEntity.GetParamIntValue(logicDEFHelper.getName(), 1) == 1) {
                    callResult.setUserObject((Object)1);
                } else {
                    callResult.setUserObject((Object)2);
                }
            } else {
                callResult.setUserObject((Object)1);
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    @Override
    public CallResult Select(BaseDataEntity dataEntity) {
        return this.Select(dataEntity, "", "");
    }

    @Override
    public CallResult Select(BaseDataEntity dataEntity, String strExtCondition, String strOrderInfo) {
        CallResult callResult = new CallResult();
        Vector<ProcParam> selectParams = new Vector<ProcParam>();
        String strSQL_SELECT = this.iDEHelper.GetSelectCode(dataEntity, selectParams);
        if (StringHelper.IsNullOrEmpty((String)strSQL_SELECT)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u591a\u884c\u67e5\u8be2\u8bed\u53e5\u65e0\u6548");
            return callResult;
        }
        if (!StringHelper.IsNullOrEmpty((String)strExtCondition)) {
            strSQL_SELECT = String.valueOf(strSQL_SELECT) + " AND " + strExtCondition;
        }
        if (!StringHelper.IsNullOrEmpty((String)strOrderInfo)) {
            strSQL_SELECT = String.valueOf(strSQL_SELECT) + " " + strOrderInfo;
        }
        Vector<CallParam> params = new Vector<CallParam>();
        for (ProcParam procParam : selectParams) {
            Object objValue = dataEntity.GetParamValue(procParam.getParamName());
            if (objValue == null) {
                callResult.setRetCode(4);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u952e\u503c[%1$s]", (Object)procParam.getParamName()));
                return callResult;
            }
            params.add(new CallParam(objValue));
        }
        return BaseDEDataCtrl.SelectSingleEx(this.globalHelperEx, this.getConnection(ACTION_SELECT, ACTIONMODE_DEFAULT), this.GetDEHelper().GetDBStorage(), strSQL_SELECT, params, dataEntity);
    }

    @Override
    public CallResult Select(BaseDataEntity dataEntity, Vector list, String strObject) {
        return this.Select(dataEntity, list, strObject, "");
    }

    @Override
    public CallResult Select(BaseDataEntity dataEntity, Vector list, String strObject, String strOrderInfo) {
        return this.Select(dataEntity, list, strObject, "", strOrderInfo);
    }

    @Override
    public CallResult Select(BaseDataEntity dataEntity, Vector list, String strObject, String strExtCondition, String strOrderInfo) {
        CallResult callResult = new CallResult();
        Vector<ProcParam> selectParams = new Vector<ProcParam>();
        String strSQL_SELECT = this.iDEHelper.GetSelectCode(dataEntity, selectParams);
        if (StringHelper.IsNullOrEmpty((String)strSQL_SELECT)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u591a\u884c\u67e5\u8be2\u8bed\u53e5\u65e0\u6548");
            return callResult;
        }
        if (!StringHelper.IsNullOrEmpty((String)strExtCondition)) {
            strSQL_SELECT = strSQL_SELECT.indexOf(" WHERE ") == -1 ? String.valueOf(strSQL_SELECT) + " WHERE " + strExtCondition : String.valueOf(strSQL_SELECT) + " AND " + strExtCondition;
        }
        if (!StringHelper.IsNullOrEmpty((String)strOrderInfo)) {
            strSQL_SELECT = String.valueOf(strSQL_SELECT) + " " + strOrderInfo;
        }
        Vector<CallParam> params = new Vector<CallParam>();
        for (ProcParam procParam : selectParams) {
            Object objValue = dataEntity.GetParamValue(procParam.getParamName());
            if (objValue == null) {
                callResult.setRetCode(4);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u952e\u503c[%1$s]", (Object)procParam.getParamName()));
                return callResult;
            }
            params.add(new CallParam(objValue));
        }
        return BaseDEDataCtrl.SelectMultiEx(this.globalHelperEx, this.getConnection(ACTION_SELECT, ACTIONMODE_DEFAULT), this.GetDEHelper().GetDBStorage(), strSQL_SELECT, params, list, strObject);
    }

    @Override
    public CallResult Select(BaseDataEntity dataEntity, Vector<BaseDataEntity> list) {
        return this.Select(dataEntity, list, "");
    }

    @Override
    public CallResult Select(String strActionMode, BaseDataEntity dataEntity, Vector list, String strObject) {
        if (StringHelper.IsNullOrEmpty((String)strActionMode)) {
            return this.Select(dataEntity, list, strObject);
        }
        CallResult callResult = new CallResult();
        Vector<CallParam> params = new Vector<CallParam>();
        String strSQL_SELECT = this.iDEHelper.GetSelectCode(strActionMode, this.getWebContext(), dataEntity, params);
        if (StringHelper.IsNullOrEmpty((String)strSQL_SELECT)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u591a\u884c\u67e5\u8be2\u8bed\u53e5\u65e0\u6548");
            return callResult;
        }
        return BaseDEDataCtrl.SelectMultiEx(this.globalHelperEx, this.getConnection(ACTION_SELECT, ACTIONMODE_DEFAULT), this.GetDEHelper().GetDBStorage(), strSQL_SELECT, params, list, strObject);
    }

    @Override
    public CallResult Select(String strActionMode, BaseDataEntity dataEntity, Vector<BaseDataEntity> list) {
        return this.Select(strActionMode, dataEntity, list, "");
    }

    @Override
    public CallResult GetDefault(String strActionMode, ISRFDAWebContext webContext, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        Vector<DEDataCtrl> dedcs = this.GetDEHelper().GetDEDC("GETDEFAULT", strActionMode);
        if (dedcs != null) {
            for (DEDataCtrl dedc : dedcs) {
                IDEDataCtrlEngine iDEDCEngine = this.GetDEDataCtrlEngine(dedc.getDEDCOBJECT());
                if (iDEDCEngine == null) {
                    callResult.setRetCode(1);
                    return callResult;
                }
                callResult = iDEDCEngine.GetDefault(dedc, dataEntity, strActionMode);
                this.ReleaseDEDataCtrlEngine(dedc.getDEDCOBJECT(), iDEDCEngine);
                if (!callResult.IsError()) continue;
                return callResult;
            }
        }
        return callResult;
    }

    @Override
    public CallResult GetDefault(ISRFDAWebContext webContext, BaseDataEntity dataEntity) {
        return this.GetDefault(ACTIONMODE_DEFAULT, webContext, dataEntity);
    }

    @Override
    public CallResult FillDetails(BaseDataEntity dataEntity) {
        return this.FillDetails(ACTIONMODE_DEFAULT, dataEntity);
    }

    @Override
    public CallResult FillDetails(String strActionMode, BaseDataEntity dataEntity) {
        return this.OnFillDetails(strActionMode, dataEntity);
    }

    protected CallResult OnFillDetails(String strActionMode, BaseDataEntity dataEntity) {
        return new CallResult();
    }

    @Override
    public CallResult Remove(BaseDataEntity dataEntity, TreeMap<String, Boolean> deleteMap) {
        return this.Remove(ACTIONMODE_DEFAULT, dataEntity, deleteMap);
    }

    @Override
    public CallResult Remove(String strActionMode, BaseDataEntity dataEntity, TreeMap<String, Boolean> deleteMap) {
        TreeMap<String, Boolean> deleteMap2;
        String strNewActionMode;
        IDEDataCtrlEngine iDEDCEngine;
        Vector<DEDataCtrl> dedcs;
        TreeMap<String, Boolean> deleteMap22;
        String strNewActionMode2;
        CallResult callResult = new CallResult();
        if (!dataEntity.ContainesParam(this.iDEHelper.GetKeyDEFHelper().getName())) {
            callResult.setRetCode(3);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5220\u9664\u5b9e\u4f53[%1$s]\u6570\u636e\uff0c\u952e\u503c[%2$s]\u65e0\u6548", (Object)this.iDEHelper.GetFullName(), (Object)this.iDEHelper.GetKeyDEFHelper().getName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IDEDataCtrl inheritDataCtrl = null;
        BaseDataEntity dataEntity2 = null;
        boolean bPartExecute = false;
        boolean bBeforeRemove = false;
        boolean bAfterRemove = false;
        if (this.GetDEHelper().IsIndexDE()) {
            String[] items = strActionMode.split("[:]");
            if (items.length == 2) {
                if (StringHelper.Compare((String)items[1], (String)"SRFBEFOREREMOVE", (boolean)true) == 0) {
                    bBeforeRemove = true;
                    bPartExecute = true;
                    strActionMode = items[0];
                } else if (StringHelper.Compare((String)items[1], (String)"SRFAFTERREMOVE", (boolean)true) == 0) {
                    bAfterRemove = true;
                    bPartExecute = true;
                    strActionMode = items[0];
                }
            }
        } else if (this.GetDEHelper().IsInheritMode() && this.GetDEHelper().GetInheritDEHelper() != null) {
            inheritDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrlEx(this.GetDEHelper().GetInheritDEHelper().getId(), this);
            dataEntity2 = new BaseDataEntity();
            dataEntity.CopyTo(dataEntity2, true);
            dataEntity2.SetParamValue(inheritDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), dataEntity.GetParamValue(this.GetDEHelper().GetKeyDEFHelper().getName()));
        }
        if (inheritDataCtrl != null && (callResult = inheritDataCtrl.Remove(strNewActionMode2 = StringHelper.Format((String)"%1$s:SRFBEFOREREMOVE", (Object)strActionMode), dataEntity2, deleteMap22 = new TreeMap<String, Boolean>())).IsError()) {
            return callResult;
        }
        String strDeleteKey = StringHelper.Format((String)"%1$s_%2$s", (Object)this.iDEHelper.getId(), (Object)dataEntity.GetParamValue(this.iDEHelper.GetKeyDEFHelper().getName()));
        if (deleteMap.containsKey(strDeleteKey)) {
            callResult.setRetCode(0);
            return callResult;
        }
        deleteMap.put(strDeleteKey, true);
        if (!bPartExecute || bBeforeRemove) {
            callResult = this.InternalGet(dataEntity, false);
            if (callResult.getRetCode() != 0) {
                return callResult;
            }
            dedcs = this.GetDEHelper().GetDEDC("BEFOREREMOVE", strActionMode);
            if (dedcs != null) {
                for (DEDataCtrl dedc : dedcs) {
                    iDEDCEngine = this.GetDEDataCtrlEngine(dedc.getDEDCOBJECT());
                    if (iDEDCEngine == null) {
                        callResult.setRetCode(1);
                        return callResult;
                    }
                    callResult = iDEDCEngine.BeforeRemove(dedc, dataEntity, strActionMode);
                    this.ReleaseDEDataCtrlEngine(dedc.getDEDCOBJECT(), iDEDCEngine);
                    if (!callResult.IsError()) continue;
                    return callResult;
                }
            }
            if ((callResult = this.OnBeforeRemove(strActionMode, dataEntity)).IsError()) {
                log.error((Object)StringHelper.Format((String)"\u5220\u9664\u4e4b\u524d\u8c03\u7528[%1$s:%2$s]\u5931\u8d25\uff0c%3$s", (Object)"DELETE", (Object)strActionMode, (Object)callResult.getErrorInfo()));
                return callResult;
            }
            if (!this.iDEHelper.IsLogicValid()) {
                Vector<DER1N> der1Ns = new Vector<DER1N>();
                callResult = this.globalHelperEx.getDAModelHelper().GetDER1Ns(this.iDEHelper.getId(), der1Ns);
                if (callResult == null || callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5173\u7cfb\u5931\u8d25\uff0c\u539f\u56e0\uff1a%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                    return callResult;
                }
                block6: for (DER1N der1N : der1Ns) {
                    IDEHelper iMinorDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(der1N.getMINORDEID());
                    if (iMinorDEHelper == null) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)der1N.getMINORDEID()));
                        return callResult;
                    }
                    IPickupDEFHelper pickupDEFHelper = iMinorDEHelper.FindPickupDEFHelper(der1N.getDERID());
                    if (pickupDEFHelper == null) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u7684\u5173\u7cfb\u5c5e\u6027[%2$s]", (Object)iMinorDEHelper.GetFullName(), (Object)der1N.getDERID()));
                        return callResult;
                    }
                    switch (der1N.getREMOVEACTIONTYPE()) {
                        case 1: 
                        case 2: {
                            IDEDataCtrl minorDEDataCtrl;
                            BaseDataEntity param = new BaseDataEntity();
                            Object objValue = dataEntity.GetParamValue(pickupDEFHelper.GetRelatedDEFHelper().getName());
                            if (objValue == null) {
                                callResult.setRetCode(1);
                                callResult.setErrorInfo(StringHelper.Format((String)"\u53c2\u6570\u4e2d\u4e0d\u5305\u542b\u7cfb\u5c5e\u6027[%1$s]", (Object)pickupDEFHelper.GetRelatedDEFHelper().getName()));
                                return callResult;
                            }
                            param.SetParamValue(pickupDEFHelper.getName(), objValue);
                            Vector<BaseDataEntity> list = new Vector<BaseDataEntity>();
                            try {
                                minorDEDataCtrl = this.GetRelatedDataCtrl(iMinorDEHelper.getId());
                            }
                            catch (Exception e) {
                                callResult.setRetCode(1);
                                callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)iMinorDEHelper.getId(), (Object)e.getMessage()));
                                log.error((Object)callResult.getErrorInfo());
                                return callResult;
                            }
                            callResult = minorDEDataCtrl.Select(param, list);
                            if (callResult.getRetCode() != 0) {
                                return callResult;
                            }
                            log.debug((Object)StringHelper.Format((String)"\u5f00\u59cb\u5220\u9664\u5b9e\u4f53[%1$s]\u76f8\u5173\u6570\u636e", (Object)iMinorDEHelper.getId()));
                            if (der1N.getREMOVEACTIONTYPE() == 1) {
                                for (BaseDataEntity item : list) {
                                    callResult = minorDEDataCtrl.Remove(strActionMode, item, deleteMap);
                                    if (callResult.getRetCode() == 0) continue;
                                    log.error((Object)StringHelper.Format((String)"\u5220\u9664\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c\u539f\u56e0\uff1a%1$s", (Object)callResult.getErrorInfo()));
                                    return callResult;
                                }
                                continue block6;
                            }
                            BaseDataEntity newItem = new BaseDataEntity();
                            String strKeyName = iMinorDEHelper.GetKeyDEFHelper().getName();
                            for (BaseDataEntity item : list) {
                                newItem.Reset();
                                newItem.SetParamValue(pickupDEFHelper.getName(), null);
                                newItem.SetParamValue(strKeyName, item.GetParamValue(strKeyName));
                                BaseDEDataCtrl.SetCallParamCheckKey(newItem, false);
                                BaseDEDataCtrl.SetCallParamRetData(newItem, false);
                                callResult = minorDEDataCtrl.Save(false, newItem);
                                if (callResult.getRetCode() == 0 || callResult.getRetCode() == 3) continue;
                                log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c\u539f\u56e0\uff1a%1$s", (Object)callResult.getErrorInfo()));
                                return callResult;
                            }
                            continue block6;
                        }
                    }
                }
            }
            if (bBeforeRemove) {
                return callResult;
            }
        }
        if (!bPartExecute) {
            callResult = this.InternalRemoveData(strActionMode, dataEntity);
            if (callResult.IsError()) {
                return callResult;
            }
            this.DataNotify(4, null, dataEntity);
            if (this.getWebContext() != null) {
                this.GetDEHelper().GetDataAccHelper().Audit(null, this.iTransactionManager, this.getWebContext(), dataEntity, null, "DELETE");
            } else {
                this.GetDEHelper().GetDataAccHelper().Audit(null, this.iTransactionManager, this.strCurOpPersonId, "", dataEntity, null, "DELETE");
            }
            this.OnRemoveIndex(dataEntity);
        }
        if (inheritDataCtrl != null && (callResult = inheritDataCtrl.Remove(strNewActionMode = StringHelper.Format((String)"%1$s:SRFAFTERREMOVE", (Object)strActionMode), dataEntity2, deleteMap2 = new TreeMap<String, Boolean>())).IsError()) {
            return callResult;
        }
        if (!bPartExecute || bAfterRemove) {
            dedcs = this.GetDEHelper().GetDEDC("AFTERREMOVE", strActionMode);
            if (dedcs != null) {
                for (DEDataCtrl dedc : dedcs) {
                    iDEDCEngine = this.GetDEDataCtrlEngine(dedc.getDEDCOBJECT());
                    if (iDEDCEngine == null) {
                        callResult.setRetCode(1);
                        return callResult;
                    }
                    callResult = iDEDCEngine.AfterRemove(dedc, dataEntity, strActionMode);
                    this.ReleaseDEDataCtrlEngine(dedc.getDEDCOBJECT(), iDEDCEngine);
                    if (!callResult.IsError()) continue;
                    return callResult;
                }
            }
            return this.OnAfterRemoveOK(strActionMode, dataEntity);
        }
        return callResult;
    }

    protected CallResult InternalRemoveData(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        String strProcName = this.iDEHelper.GetDeleteProcName();
        if (StringHelper.IsNullOrEmpty((String)strProcName)) {
            String strError = StringHelper.Format((String)"\u6ca1\u6709\u5b9a\u4e49[DELETE]\u8fc7\u7a0b\u7684\u540d\u79f0");
            log.error((Object)strError);
            callResult.setRetCode(1);
            callResult.setErrorInfo(strError);
            return callResult;
        }
        callResult = this.GetDEHelper().PrepareDBProc("DELETE", strActionMode);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u6570\u636e\u5e93\u8fc7\u7a0b\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        callResult = BaseDEDataCtrl.FillDBActionParam(this, "DELETE", strActionMode, dataEntity);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u586b\u5145\u64cd\u4f5c[%1$s:%2$s]\u53c2\u6570\u9519\u8bef\uff0c%3$s", (Object)"DELETE", (Object)strActionMode, (Object)callResult.getErrorInfo()));
            return callResult;
        }
        Vector<ProcParam> params = new Vector<ProcParam>();
        callResult = this.GetProcParams(strProcName, params);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8fc7\u7a0b[%1$s]\u53c2\u6570\u9519\u8bef", (Object)strProcName));
            return callResult;
        }
        Vector<CallParam> callParams = new Vector<CallParam>();
        this.FillProcCallParams(strActionMode, dataEntity, params, callParams);
        try {
            SelectResult result = this.globalHelperEx.getDBCaller(this.GetDEHelper().GetDBStorage()).CallRaw4(this.getConnection(ACTION_REMOVE, strActionMode), strProcName, callParams);
            callResult.From((DBResult)result);
            callResult.setUserObject((Object)result);
            if (callResult.getRetCode() == 0) {
                BaseDEDataCtrl.FillCallResult(callResult, (DBResult)result);
            }
            if (callResult.getRetCode() != 0) {
                this.FillCallResultEx(callResult);
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult OnBeforeRemove(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        return callResult;
    }

    protected CallResult OnAfterRemoveOK(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        return callResult;
    }

    protected CallResult OnRemoveIndex(BaseDataEntity dataEntity) {
        return BaseDEDataCtrl.RemoveIndex(this, dataEntity);
    }

    protected static CallResult RemoveIndex(IDEDataCtrl iDEDataCtrl, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        Vector<DERINDEX> derIndexs = iDEDataCtrl.GetDEHelper().GetDERINDEXs(false);
        Object objIdValue = dataEntity.GetParamValue(iDEDataCtrl.GetDEHelper().GetKeyDEFHelper().getName());
        for (DERINDEX derIndex : derIndexs) {
            if (derIndex.isINHERITMODE()) continue;
            IDEDataCtrl indexDEDataCtrl = iDEDataCtrl.getGlobalHelper().getDAModelStorage().FindDEDataCtrlEx(derIndex.getINDEXDEID(), iDEDataCtrl);
            if (indexDEDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u5904\u7406\u5bf9\u8c61", (Object)derIndex.getINDEXDEID()));
                return callResult;
            }
            BaseDataEntity indexDataEntity = new BaseDataEntity();
            indexDataEntity.SetParamValue(indexDEDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), objIdValue);
            callResult = indexDEDataCtrl.Remove(indexDataEntity);
            if (callResult.getRetCode() == 0) continue;
            callResult.setErrorInfo(StringHelper.Format((String)"\u5220\u9664\u7d22\u5f15\u5b9e\u4f53[%1$s]\u6570\u636e\u5931\u8d25\uff0c%2$s", (Object)indexDEDataCtrl.GetDEHelper().getId(), (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            callResult.setRetCode(1);
        }
        callResult.setRetCode(0);
        return callResult;
    }

    @Override
    public CallResult RemoveMulti(String strActionMode, BaseDataEntity cond) {
        Vector<BaseDataEntity> list = new Vector<BaseDataEntity>();
        CallResult callResult = this.Select(cond, list);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5220\u9664\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        for (BaseDataEntity item : list) {
            callResult = this.Remove(strActionMode, item);
            if (!callResult.IsError()) continue;
            log.error((Object)StringHelper.Format((String)"\u5220\u9664\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        return callResult;
    }

    @Override
    public CallResult RemoveMulti(BaseDataEntity cond) {
        return this.RemoveMulti(ACTIONMODE_DEFAULT, cond);
    }

    @Override
    public CallResult CopyDetail(BaseDataEntity dataEntity, Object srcKey) {
        return BaseDEDataCtrl.CopyDetail(this, dataEntity, srcKey);
    }

    protected static CallResult CopyDetail(IDEDataCtrl iDEDataCtrl, BaseDataEntity dataEntity, Object srcKey) {
        CallResult callResult = new CallResult();
        Object newKey = dataEntity.GetParamValue(iDEDataCtrl.GetDEHelper().GetKeyDEFHelper().getName());
        Object newText = dataEntity.GetParamValue(iDEDataCtrl.GetDEHelper().GetMajorDEFHelper().getName());
        Vector<DER1N> derList = iDEDataCtrl.GetDEHelper().GetDER1Ns(true);
        for (DER1N der1n : derList) {
            IDEDataCtrl relatedDataCtrl;
            if ((der1n.getDERSUBTYPE() & 4) == 0) continue;
            try {
                relatedDataCtrl = iDEDataCtrl.GetRelatedDataCtrl(der1n.getMINORDEID());
            }
            catch (Exception e) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)der1n.getMINORDEID()));
                return callResult;
            }
            Vector<BaseDataEntity> details = new Vector<BaseDataEntity>();
            BaseDataEntity condition = new BaseDataEntity();
            condition.SetParamValue(der1n.getMAJORKEYDEFNAME(), srcKey);
            callResult = relatedDataCtrl.Select(condition, details);
            if (callResult == null || callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5173\u7cfb\u6570\u636e\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                return callResult;
            }
            for (BaseDataEntity detail : details) {
                Object objOriginKey = detail.GetParamValue(relatedDataCtrl.GetDEHelper().GetKeyDEFHelper().getName());
                relatedDataCtrl.RemoveUncopyValue(detail);
                detail.SetParamValue(der1n.getMAJORKEYDEFNAME(), newKey);
                detail.SetParamValue(der1n.getMAJORTEXTDEFNAME(), newText);
                String strSrcCopyField = relatedDataCtrl.GetDEHelper().GetProperty("COPYSRCFIELD", "SRFCOPYID");
                detail.SetParamValue(strSrcCopyField, objOriginKey);
                callResult = relatedDataCtrl.Save(true, detail);
                if (callResult == null || callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u660e\u7ec6\u6570\u636e\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                    return callResult;
                }
                callResult = relatedDataCtrl.CopyDetail(detail, objOriginKey);
                if (callResult != null && callResult.getRetCode() == 0) continue;
                log.error((Object)StringHelper.Format((String)"\u62f7\u8d1d\u660e\u7ec6\u6570\u636e\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
                return callResult;
            }
        }
        return callResult;
    }

    @Override
    public CallResult Remove(BaseDataEntity dataEntity) {
        return this.Remove(ACTIONMODE_DEFAULT, dataEntity);
    }

    @Override
    public CallResult Remove(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = this.TestRemove(strActionMode, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        TreeMap<String, Boolean> deleteMap = new TreeMap<String, Boolean>();
        return this.Remove(strActionMode, dataEntity, deleteMap);
    }

    @Override
    public CallResult TestRemove(BaseDataEntity dataEntity) {
        return this.TestRemove(ACTIONMODE_DEFAULT, dataEntity);
    }

    @Override
    public CallResult TestRemove(String strActionMode, BaseDataEntity dataEntity) {
        TreeMap<String, Boolean> deleteMap = new TreeMap<String, Boolean>();
        return this.TestRemove(strActionMode, dataEntity, deleteMap);
    }

    @Override
    public CallResult TestRemove(BaseDataEntity dataEntity, TreeMap<String, Boolean> deleteMap) {
        return this.TestRemove(ACTIONMODE_DEFAULT, dataEntity, deleteMap);
    }

    @Override
    public CallResult TestRemove(String strActionMode, BaseDataEntity dataEntity, TreeMap<String, Boolean> deleteMap) {
        CallResult callResult = new CallResult();
        if (this.GetDEHelper().IsInheritMode() && this.GetDEHelper().GetInheritDEHelper() != null) {
            IDEDataCtrl inheritDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrlEx(this.GetDEHelper().GetInheritDEHelper().getId(), this);
            BaseDataEntity dataEntity2 = new BaseDataEntity();
            dataEntity2.SetParamValue(this.GetDEHelper().GetInheritDEHelper().GetKeyDEFHelper().getName(), dataEntity.GetParamValue(this.GetDEHelper().GetKeyDEFHelper().getName()));
            callResult = inheritDataCtrl.TestRemove(strActionMode, dataEntity2);
            if (callResult.IsError()) {
                return callResult;
            }
        }
        if (!dataEntity.ContainesParam(this.iDEHelper.GetKeyDEFHelper().getName())) {
            callResult.setRetCode(6);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u6d4b\u8bd5\u5220\u9664\u5b9e\u4f53[%1$s]\u6570\u636e\uff0c\u952e\u503c[%2$s]\u65e0\u6548", (Object)this.iDEHelper.getId(), (Object)this.iDEHelper.GetKeyDEFHelper().getName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strDeleteKey = StringHelper.Format((String)"%1$s_%2$s", (Object)this.iDEHelper.getId(), (Object)dataEntity.GetParamValue(this.iDEHelper.GetKeyDEFHelper().getName()));
        if (deleteMap.containsKey(strDeleteKey)) {
            callResult.setRetCode(0);
            return callResult;
        }
        deleteMap.put(strDeleteKey, true);
        if (!this.iDEHelper.IsLogicValid()) {
            Vector<DER1N> der1Ns = this.iDEHelper.GetDER1Ns(true);
            for (DER1N der1N : der1Ns) {
                IDEHelper iMinorDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(der1N.getMINORDEID());
                if (iMinorDEHelper == null) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)der1N.getMINORDEID()));
                    return callResult;
                }
                IPickupDEFHelper pickupDEFHelper = iMinorDEHelper.FindPickupDEFHelper(der1N.getDERID());
                if (pickupDEFHelper == null) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u7684\u5173\u7cfb\u5c5e\u6027[%2$s]", (Object)iMinorDEHelper.GetFullName(), (Object)der1N.getDERID()));
                    return callResult;
                }
                switch (der1N.getREMOVEACTIONTYPE()) {
                    case 0: 
                    case 2: {
                        callResult.setRetCode(0);
                        return callResult;
                    }
                    case 1: 
                    case 3: {
                        IDEDataCtrl minorDEDataCtrl;
                        BaseDataEntity param = new BaseDataEntity();
                        Object objValue = dataEntity.GetParamValue(pickupDEFHelper.GetRelatedDEFHelper().getName());
                        if (objValue == null) {
                            callResult.setRetCode(1);
                            callResult.setErrorInfo(StringHelper.Format((String)"\u53c2\u6570\u4e2d\u4e0d\u5305\u542b\u7cfb\u5c5e\u6027[%1$s]", (Object)pickupDEFHelper.GetRelatedDEFHelper().getName()));
                            return callResult;
                        }
                        param.SetParamValue(pickupDEFHelper.getName(), objValue);
                        Vector<BaseDataEntity> list = new Vector<BaseDataEntity>();
                        try {
                            minorDEDataCtrl = this.GetRelatedDataCtrl(iMinorDEHelper.getId());
                        }
                        catch (Exception e) {
                            callResult.setRetCode(1);
                            callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)iMinorDEHelper.getId(), (Object)e.getMessage()));
                            log.error((Object)callResult.getErrorInfo());
                            return callResult;
                        }
                        callResult = minorDEDataCtrl.Select(param, list);
                        if (callResult.getRetCode() != 0) {
                            return callResult;
                        }
                        if (list.size() == 0) {
                            return callResult;
                        }
                        if (der1N.getREMOVEACTIONTYPE() == 3) {
                            callResult.setRetCode(8);
                            callResult.setErrorInfo(StringHelper.Format((String)"\u5b9e\u4f53\u5173\u7cfb[%1$s]\u5b58\u5728\u5220\u9664\u9650\u5236", (Object)der1N.getDERLOGICNAME()));
                        } else {
                            for (BaseDataEntity item : list) {
                                callResult = minorDEDataCtrl.TestRemove(strActionMode, item, deleteMap);
                                if (callResult.getRetCode() == 0) continue;
                                return callResult;
                            }
                        }
                        callResult.setRetCode(0);
                        return callResult;
                    }
                }
            }
        }
        callResult.setRetCode(0);
        return callResult;
    }

    @Override
    public CallResult TestSave(boolean insert, String strActionMode, BaseDataEntity dataEntity, Vector<ValueError> errors) {
        Vector<DEDataCtrl> dedcs = this.GetDEHelper().GetDEDC("TESTSAVE", strActionMode);
        if (dedcs != null) {
            for (DEDataCtrl dedc : dedcs) {
                CallResult callResult = new CallResult();
                IDEDataCtrlEngine iDEDCEngine = this.GetDEDataCtrlEngine(dedc.getDEDCOBJECT());
                if (iDEDCEngine == null) {
                    callResult.setRetCode(1);
                    return callResult;
                }
                callResult = iDEDCEngine.TestSave(dedc, dataEntity, insert, strActionMode, errors);
                this.ReleaseDEDataCtrlEngine(dedc.getDEDCOBJECT(), iDEDCEngine);
                if (!callResult.IsError()) continue;
                return callResult;
            }
        }
        return this.OnTestSave(insert, strActionMode, dataEntity, errors);
    }

    @Override
    public CallResult TestSave(boolean insert, BaseDataEntity dataEntity, Vector<ValueError> errors) {
        return this.TestSave(insert, ACTIONMODE_DEFAULT, dataEntity, errors);
    }

    protected CallResult OnTestSave(boolean insert, String strActionMode, BaseDataEntity dataEntity, Vector<ValueError> errors) {
        return new CallResult();
    }

    @Override
    public CallResult CustomSaveCall(String strCallName, BaseDataEntity dataEntity) {
        Vector<ProcParam> params;
        CallResult callResult = new CallResult();
        String strProcName = StringHelper.Format((String)"%1$s%2$s_%3$s", (Object)this.strProcPreFix, (Object)this.iDEHelper.getName(), (Object)strCallName);
        callResult = this.GetProcParams(strProcName = strProcName.toUpperCase(), params = new Vector<ProcParam>());
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8fc7\u7a0b[%1$s]\u53c2\u6570\u9519\u8bef", (Object)strProcName));
            return callResult;
        }
        Vector<CallParam> callParams = new Vector<CallParam>();
        this.FillProcCallParams("", dataEntity, params, callParams);
        String strKey = this.iDEHelper.GetKeyDEFHelper().GetDTColumn().GetColumnName().toUpperCase();
        boolean bInsert = dataEntity.IsParamNull(strKey);
        if (this.bSaveAndGetMode && bInsert) {
            for (CallParam callParam : callParams) {
                if (StringHelper.Compare((String)strKey, (String)callParam.getOutputParamName(), (boolean)true) != 0) continue;
                callParam.setDirection(3);
                break;
            }
        }
        try {
            Object objRetCode;
            SelectResult result = this.globalHelperEx.getDBCaller(this.GetDEHelper().GetDBStorage()).CallRaw4(this.getConnection(ACTION_CUSTOMSAVECALL, strCallName), strProcName, callParams);
            callResult.From((DBResult)result);
            callResult.setUserObject((Object)result);
            if (callResult.getRetCode() == 0 && (objRetCode = result.getOutValues().get(TAG_RETCODE)) != null) {
                callResult.setRetCode(Integer.parseInt(objRetCode.toString()));
                Object objRetInfo = result.getOutValues().get(TAG_RETINFO);
                if (objRetInfo != null) {
                    callResult.setErrorInfo(objRetInfo.toString());
                }
            }
            if (callResult.getRetCode() == 0) {
                if (this.bSaveAndGetMode) {
                    Object objKeyValue;
                    if (bInsert && (objKeyValue = result.getOutValues().get(strKey)) != null) {
                        dataEntity.SetParamValue(strKey, (Object)objKeyValue.toString());
                    }
                    if ((callResult = this.InternalGet(dataEntity, true)).IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u91cd\u65b0\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        return callResult;
                    }
                } else {
                    if (result.getSelectData().getTableCount() == 0) {
                        callResult.setRetCode(3);
                        return callResult;
                    }
                    if (result.getSelectData().getTable(0).GetRowCount() == 0) {
                        callResult.setRetCode(3);
                        return callResult;
                    }
                    dataEntity.FromDataRow(result.getSelectData().getTable(0).GetRow(0));
                }
                return callResult;
            }
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult CustomRawProcCall(String strProcName, BaseDataEntity dataEntity) {
        Vector<ProcParam> params;
        CallResult callResult = new CallResult();
        callResult = this.GetProcParams(strProcName = strProcName.toUpperCase(), params = new Vector<ProcParam>());
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8fc7\u7a0b[%1$s]\u53c2\u6570\u9519\u8bef", (Object)strProcName));
            return callResult;
        }
        Vector<CallParam> callParams = new Vector<CallParam>();
        this.FillProcCallParams("", dataEntity, params, callParams);
        try {
            Object objRetCode;
            SelectResult result = this.globalHelperEx.getDBCaller(this.GetDEHelper().GetDBStorage()).CallRaw4(this.getConnection(ACTION_CUSTOMRAWPROCCALL, strProcName), strProcName, callParams);
            callResult.From((DBResult)result);
            callResult.setUserObject((Object)result);
            if (callResult.getRetCode() == 0 && (objRetCode = result.getOutValues().get(TAG_RETCODE)) != null) {
                callResult.setRetCode(Integer.parseInt(objRetCode.toString()));
                Object objRetInfo = result.getOutValues().get(TAG_RETINFO);
                if (objRetInfo != null) {
                    callResult.setErrorInfo(objRetInfo.toString());
                }
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    @Override
    public CallResult CustomProcCall(String strCallName, BaseDataEntity dataEntity) {
        Vector<ProcParam> params;
        CallResult callResult = new CallResult();
        String strProcName = StringHelper.Format((String)"%1$s%2$s_%3$s", (Object)this.strProcPreFix, (Object)this.iDEHelper.getName(), (Object)strCallName);
        callResult = this.GetProcParams(strProcName = strProcName.toUpperCase(), params = new Vector<ProcParam>());
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8fc7\u7a0b[%1$s]\u53c2\u6570\u9519\u8bef", (Object)strProcName));
            return callResult;
        }
        Vector<CallParam> callParams = new Vector<CallParam>();
        this.FillProcCallParams("", dataEntity, params, callParams);
        try {
            Object objRetCode;
            SelectResult result = this.globalHelperEx.getDBCaller(this.GetDEHelper().GetDBStorage()).CallRaw4(this.getConnection(ACTION_CUSTOMPROCCALL, strCallName), strProcName, callParams);
            callResult.From((DBResult)result);
            callResult.setUserObject((Object)result);
            if (callResult.getRetCode() == 0 && (objRetCode = result.getOutValues().get(TAG_RETCODE)) != null) {
                callResult.setRetCode(Integer.parseInt(objRetCode.toString()));
                Object objRetInfo = result.getOutValues().get(TAG_RETINFO);
                if (objRetInfo != null) {
                    callResult.setErrorInfo(objRetInfo.toString());
                }
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult OnBeforeSaveTempData(TempData tempData, BaseDataEntity dataEntity) {
        BaseDataEntity temp;
        ILinkDEFHelper linkDEFHelper;
        Hashtable<String, BaseDataEntity> der1NDataMap = new Hashtable<String, BaseDataEntity>();
        for (IDEFHelper iDEFHelper : this.GetDEHelper().GetDEFHelpers()) {
            if (!iDEFHelper.IsLinkDEField() || !dataEntity.ContainesParam(iDEFHelper.getName())) continue;
            IPickupDEFHelper iPickupDEFHelper = null;
            if (iDEFHelper instanceof IPickupDEFHelper) {
                iPickupDEFHelper = (IPickupDEFHelper)iDEFHelper;
            } else if (StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"INHERIT", (boolean)true) == 0 && (linkDEFHelper = (ILinkDEFHelper)iDEFHelper).GetRelatedDEFHelper() instanceof IPickupDEFHelper) {
                iPickupDEFHelper = (IPickupDEFHelper)linkDEFHelper.GetRelatedDEFHelper();
            }
            if (iPickupDEFHelper == null) continue;
            IDEHelper iPickupDEHelper = iPickupDEFHelper.GetRelatedDEFHelper().getDEHelper();
            temp = new BaseDataEntity();
            temp.SetParamValue(iPickupDEHelper.GetKeyDEFHelper().getName(), dataEntity.GetParamValue(iDEFHelper.getName()));
            try {
                IDEDataCtrl iDEDataCtrl = this.GetRelatedDataCtrl(iPickupDEHelper.getId());
                CallResult callResult = iDEDataCtrl.Get(temp);
                if (callResult.IsError()) continue;
                der1NDataMap.put(iPickupDEFHelper.GetDERId(), temp);
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        for (IDEFHelper iDEFHelper : this.GetDEHelper().GetDEFHelpers()) {
            IDEFHelper inheritDEFHelper;
            if (!iDEFHelper.IsLinkDEField()) continue;
            if (StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) == 0 || StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUPDATA", (boolean)true) == 0) {
                ILinkDEFHelper linkDEFHelper2 = (ILinkDEFHelper)iDEFHelper;
                if (!der1NDataMap.containsKey(linkDEFHelper2.GetDERId())) continue;
                BaseDataEntity temp2 = (BaseDataEntity)der1NDataMap.get(linkDEFHelper2.GetDERId());
                Object objValue = temp2.GetParamValue(linkDEFHelper2.GetRelatedDEFHelper().getName());
                dataEntity.SetParamValue(iDEFHelper.getName(), objValue);
                continue;
            }
            if (StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"INHERIT", (boolean)true) != 0 || StringHelper.Compare((String)(inheritDEFHelper = ((ILinkDEFHelper)iDEFHelper).GetRelatedDEFHelper()).GetDataType(), (String)"PICKUPTEXT", (boolean)true) != 0 && StringHelper.Compare((String)inheritDEFHelper.GetDataType(), (String)"PICKUPDATA", (boolean)true) != 0 || !der1NDataMap.containsKey((linkDEFHelper = (ILinkDEFHelper)inheritDEFHelper).GetDERId())) continue;
            temp = (BaseDataEntity)der1NDataMap.get(linkDEFHelper.GetDERId());
            Object objValue = temp.GetParamValue(linkDEFHelper.GetRelatedDEFHelper().getName());
            dataEntity.SetParamValue(iDEFHelper.getName(), objValue);
        }
        return new CallResult();
    }

    protected CallResult OnAfterSaveTempData(TempData tempData, BaseDataEntity dataEntity) {
        return new CallResult();
    }

    @Override
    public CallResult SaveTempData(TempData tempData, BaseDataEntity dataEntity) {
        CallResult callResult = this.OnBeforeSaveTempData(tempData, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        IDEDataCtrl iTempDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrlEx("DE0112", this);
        if (iTempDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0112"));
            callResult.setRetCode(1);
            return callResult;
        }
        tempData.setTEMPDATANAME(this.GetDEHelper().getId());
        tempData.setDEDATA(BaseDataEntity.ToString((BaseDataEntity)dataEntity));
        BaseDataEntity checkkeyparam = new BaseDataEntity();
        tempData.CopyTo(checkkeyparam, true);
        callResult = iTempDataCtrl.CheckKeyState(checkkeyparam);
        if (callResult.getRetCode() != 0 || callResult.getUserObject() == null) {
            return callResult;
        }
        boolean bTempDataInsert = false;
        int nState = (Integer)callResult.getUserObject();
        if (nState == 0) {
            bTempDataInsert = true;
        } else if (nState == 1) {
            bTempDataInsert = false;
        } else {
            callResult.setRetCode(5);
            callResult.setErrorInfo("\u4e34\u65f6\u6570\u636e\u5df2\u7ecf\u88ab\u5220\u9664!\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58!");
            return callResult;
        }
        callResult = iTempDataCtrl.Save(bTempDataInsert, tempData);
        if (callResult.IsError()) {
            return callResult;
        }
        callResult = this.OnSaveTempDataIndex(iTempDataCtrl, tempData, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        callResult = this.OnAfterSaveTempData(tempData, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }

    protected CallResult OnSaveTempDataIndex(IDEDataCtrl iTempDataCtrl, TempData tempData, BaseDataEntity dataEntity) {
        return BaseDEDataCtrl.SaveTempDataIndex(this, iTempDataCtrl, tempData, dataEntity);
    }

    protected static CallResult SaveTempDataIndex(IDEDataCtrl iDEDataCtrl, IDEDataCtrl iTempDataCtrl, TempData tempData, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        Vector<DERINDEX> derIndexs = iDEDataCtrl.GetDEHelper().GetDERINDEXs(false);
        if (derIndexs.size() == 0) {
            callResult.setRetCode(0);
            return callResult;
        }
        Object objNameValue = dataEntity.GetParamValue(iDEDataCtrl.GetDEHelper().GetMajorDEFHelper().getName());
        for (DERINDEX derIndex : derIndexs) {
            IDEHelper indexDEHelper = iDEDataCtrl.getGlobalHelper().getDAModelStorage().FindDEHelper(derIndex.getINDEXDEID());
            if (indexDEHelper == null) {
                callResult.setErrorInfo(StringHelper.Format((String)iDEDataCtrl.getGlobalHelper().getLocalizationHelper().GetLocalization(iDEDataCtrl.getLanguage(), "ERROR.STD.SRFDA.CANNOTFINDDEHELPER", "\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61"), (Object)derIndex.getINDEXDEID()));
                log.error((Object)callResult.getErrorInfo());
                callResult.setRetCode(1);
                continue;
            }
            if (indexDEHelper.GetIndexTypeDEFHelper() == null) {
                callResult.setErrorInfo(StringHelper.Format((String)iDEDataCtrl.getGlobalHelper().getLocalizationHelper().GetLocalization(iDEDataCtrl.getLanguage(), "ERROR.STD.SRFDA.CANNOTFINDINDEXDEF", "\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u7d22\u5f15\u5206\u7ec4\u5c5e\u6027"), (Object)derIndex.getINDEXDEID()));
                log.error((Object)callResult.getErrorInfo());
                callResult.setRetCode(1);
                continue;
            }
            String strDataType = indexDEHelper.GetIndexTypeDEFHelper().GetStdDataType();
            Object objTypeValue = DataTypeParse.Parse((String)strDataType, (String)derIndex.getTYPEVALUE());
            if (objTypeValue == null) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u7d22\u5f15\u5206\u7ec4\u503c[%1$s]\u65e0\u6548", (Object)derIndex.getTYPEVALUE()));
                log.error((Object)callResult.getErrorInfo());
                callResult.setRetCode(1);
                continue;
            }
            BaseDataEntity indexDataEntity = new BaseDataEntity();
            dataEntity.CopyTo(indexDataEntity, true);
            indexDataEntity.SetParamValue(indexDEHelper.GetMajorDEFHelper().getName(), objNameValue);
            indexDataEntity.SetParamValue(indexDEHelper.GetIndexTypeDEFHelper().getName(), objTypeValue);
            String strDEFMap = derIndex.getDEFIELDMAP();
            if (!StringHelper.IsNullOrEmpty((String)strDEFMap)) {
                try {
                    Properties properties = PropertiesHelper.Load((String)strDEFMap);
                    Enumeration<Object> en = properties.keys();
                    while (en.hasMoreElements()) {
                        String strKey = (String)en.nextElement();
                        String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                        if (StringHelper.IsNullOrEmpty((String)strValue)) continue;
                        if (strValue.indexOf("#") == 0) {
                            strValue = strValue.substring(1);
                            IDEFHelper tempDEF = indexDEHelper.GetDEFHelper(strKey);
                            if (tempDEF != null) {
                                indexDataEntity.SetParamValue(strKey, DataTypeParse.Parse((String)tempDEF.GetStdDataType(), (String)strValue));
                                continue;
                            }
                            indexDataEntity.SetParamValue(strKey, (Object)strValue);
                            continue;
                        }
                        indexDataEntity.SetParamValue(strKey, dataEntity.GetParamValue(strValue));
                    }
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
            }
            TempData tempData2 = new TempData();
            tempData2.setTEMPDATAID(String.valueOf(tempData.getTEMPDATAID()) + ":" + indexDEHelper.getId());
            BaseDataEntity checkkeyparam = new BaseDataEntity();
            tempData2.CopyTo(checkkeyparam, true);
            callResult = iTempDataCtrl.CheckKeyState(checkkeyparam);
            if (callResult.getRetCode() != 0 || callResult.getUserObject() == null) {
                return callResult;
            }
            boolean bTempDataInsert = false;
            int nState = (Integer)callResult.getUserObject();
            if (nState == 0) {
                bTempDataInsert = true;
            } else if (nState == 1) {
                bTempDataInsert = false;
            } else {
                callResult.setRetCode(5);
                callResult.setErrorInfo("\u4e34\u65f6\u6570\u636e\u5df2\u7ecf\u88ab\u5220\u9664!\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58!");
                return callResult;
            }
            tempData.CopyTo(tempData2, false);
            tempData2.setTEMPDATAID(String.valueOf(tempData.getTEMPDATAID()) + ":" + indexDEHelper.getId());
            tempData2.RemoveParam("SAVEMODE");
            tempData2.setTEMPDATANAME(indexDEHelper.getId());
            tempData2.setDEDATA(BaseDataEntity.ToString((BaseDataEntity)indexDataEntity));
            tempData2.setNOSAVE(true);
            callResult = iTempDataCtrl.Save(bTempDataInsert, tempData2);
            if (!callResult.IsError()) continue;
            return callResult;
        }
        callResult.setRetCode(0);
        return callResult;
    }

    @Override
    public CallResult RemoveTempData(TempData tempData) {
        CallResult callResult = this.OnBeforeRemoveTempData(tempData);
        if (callResult.IsError()) {
            return callResult;
        }
        IDEDataCtrl iTempDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrlEx("DE0112", this);
        if (iTempDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0112"));
            callResult.setRetCode(1);
            return callResult;
        }
        callResult = iTempDataCtrl.Remove(tempData);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        callResult = this.OnRemoveTempDataIndex(iTempDataCtrl, tempData);
        if (callResult.IsError()) {
            return callResult;
        }
        callResult = this.OnAfterRemoveTempData(tempData);
        return callResult;
    }

    protected CallResult OnBeforeRemoveTempData(TempData tempData) {
        return new CallResult();
    }

    protected CallResult OnAfterRemoveTempData(TempData tempData) {
        return new CallResult();
    }

    protected CallResult OnRemoveTempDataIndex(IDEDataCtrl iTempDataCtrl, TempData tempData) {
        CallResult callResult = new CallResult();
        Vector<DERINDEX> derIndexs = this.iDEHelper.GetDERINDEXs(false);
        if (derIndexs.size() == 0) {
            callResult.setRetCode(0);
            return callResult;
        }
        for (DERINDEX derIndex : derIndexs) {
            TempData tempData2 = new TempData();
            tempData2.setTEMPDATAID(String.valueOf(tempData.getTEMPDATAID()) + ":" + derIndex.getINDEXDEID());
            callResult = iTempDataCtrl.Remove(tempData2);
        }
        callResult.setRetCode(0);
        return callResult;
    }

    @Override
    public CallResult Save(boolean bInsert, BaseDataEntity dataEntity) {
        return this.Save(bInsert, ACTIONMODE_DEFAULT, dataEntity);
    }

    protected boolean isLogPODBAction() {
        return this.GetDEHelper().GetProperty("LOGPODBACTION", true);
    }

    @Override
    public CallResult Save(boolean bInsert, String strActionMode, BaseDataEntity dataEntity) {
        Object objKeyData;
        String strChildDataTag = dataEntity.GetParamStringValue(TAG_CHILDDATATAG, "");
        BaseDataEntity srcDataEntity = null;
        if (!StringHelper.IsNullOrEmpty((String)strChildDataTag)) {
            srcDataEntity = new BaseDataEntity();
            dataEntity.CopyTo(srcDataEntity, false);
        }
        long nStartProcessTime = new java.util.Date().getTime();
        CallResult callResult = this.InternalSave(bInsert, strActionMode, dataEntity);
        if (callResult.IsError()) {
            objKeyData = dataEntity.GetParamValue(this.GetDEHelper().GetKeyDEFHelper().getName());
            if (bInsert && objKeyData == null) {
                objKeyData = "\u65b0\u5efa";
            }
            log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53[%1$s][%2$s]\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)this.GetDEHelper().getId(), (Object)objKeyData, (Object)callResult.getErrorInfo()));
        }
        if (callResult.IsOk() && !StringHelper.IsNullOrEmpty((String)strChildDataTag) && (callResult = this.InternalSaveChildDatas(strChildDataTag, bInsert, strActionMode, srcDataEntity, dataEntity)).IsError()) {
            objKeyData = dataEntity.GetParamValue(this.GetDEHelper().GetKeyDEFHelper().getName());
            log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53[%1$s][%2$s]\u5b50\u6570\u636e\u6807\u8bb0[%4$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)this.GetDEHelper().getId(), (Object)objKeyData, (Object)callResult.getErrorInfo(), (Object)strChildDataTag));
        }
        if (callResult.IsOk() && this.isLogPODBAction()) {
            long nProcessTime = new java.util.Date().getTime() - nStartProcessTime;
            if (this.globalHelperEx.getPOLoggerEx() != null) {
                this.globalHelperEx.getPOLoggerEx().LogDBAction(this.GetDEHelper().getId(), bInsert ? ACTION_INSERT : ACTION_UPDATE, "", this.iTransactionManager != null, this.iTransactionManager == null ? "" : this.iTransactionManager.getTransactionId(), (int)nProcessTime);
            }
        }
        return callResult;
    }

    @Override
    public CallResult AutoSave(BaseDataEntity dataEntity) {
        return this.AutoSave(ACTIONMODE_DEFAULT, dataEntity);
    }

    @Override
    public CallResult AutoSave(String strActionMode, BaseDataEntity dataEntity) {
        Object objValue;
        boolean bInsert = true;
        if (dataEntity.getParamValue(this.GetDEHelper().GetKeyDEFHelper().getName()) == null && (objValue = this.GetDEHelper().getKeyValue(dataEntity)) != null) {
            dataEntity.setParamValue(this.GetDEHelper().GetKeyDEFHelper().getName(), objValue);
        }
        if (dataEntity.ContainesParam(this.GetDEHelper().GetKeyDEFHelper().getName())) {
            CallResult callResult = this.CheckKeyState(dataEntity);
            if (callResult.IsError()) {
                return callResult;
            }
            int nRetCode = (Integer)callResult.getUserObject();
            switch (nRetCode) {
                case 0: {
                    bInsert = true;
                    break;
                }
                case 1: {
                    bInsert = false;
                    break;
                }
                case 2: {
                    callResult.setRetCode(5);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u6570\u636e\u5df2\u7ecf\u88ab\u5220\u9664\uff0c\u65e0\u6cd5\u8fdb\u884c\u4fdd\u5b58"));
                    return callResult;
                }
            }
        }
        return this.Save(bInsert, strActionMode, dataEntity);
    }

    protected CallResult InternalSaveChildDatas(String strChildDataTag, boolean bInsert, String strActionMode, BaseDataEntity srcDataEntity, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            Properties properties = PropertiesHelper.Load((String)strChildDataTag);
            for (Object objKey : properties.keySet()) {
                String strDERId = PropertiesHelper.GetProperty((Properties)properties, (String)objKey.toString(), (String)"");
                if (StringHelper.IsNullOrEmpty((String)strDERId)) continue;
                String strSortInfo = "";
                String[] parts = strDERId.split("[|]");
                if (parts.length >= 2) {
                    strDERId = parts[0];
                    strSortInfo = parts[1];
                }
                DER1N der1N = null;
                if (this.GetDEHelper().IsInheritMode()) {
                    der1N = this.GetDEHelper().GetInheritDEHelper().FindDER1N(strDERId);
                }
                if (der1N == null) {
                    der1N = this.GetDEHelper().FindDER1N(strDERId);
                }
                if (der1N == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]1N\u5173\u7cfb[%2$s]", (Object)this.GetDEHelper().getId(), (Object)strDERId));
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]1N\u5173\u7cfb[%2$s]", (Object)this.GetDEHelper().getId(), (Object)strDERId));
                    return callResult;
                }
                callResult = this.InternalSaveChildData(objKey.toString(), der1N, strSortInfo, bInsert, strActionMode, srcDataEntity, dataEntity);
                if (!callResult.IsError()) continue;
                return callResult;
            }
            return callResult;
        }
        catch (Exception e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
            return callResult;
        }
    }

    protected CallResult InternalSaveChildData(String strChildDataTag, DER1N der1N, String strSortInfo, boolean bInsert, String strActionMode, BaseDataEntity srcDataEntity, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            IDEHelper childDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper2(der1N.getMINORDEID());
            IDEDataCtrl childDEDataCtrl = this.GetRelatedDataCtrl(der1N.getMINORDEID());
            ArrayList<BaseDataEntity> childDataList = new ArrayList<BaseDataEntity>();
            int i = 0;
            while (i <= 30) {
                String strHeader = StringHelper.Format((String)"%1$s%2$03d", (Object)strChildDataTag, (Object)(i + 1));
                BaseDataEntity childData = childDEDataCtrl.GetDEHelper().CreateDEObject();
                Hashtable paramList = srcDataEntity.getTotalParamList();
                boolean bHasValue = false;
                for (Object objKey : paramList.keySet()) {
                    String strKey = objKey.toString();
                    if (strKey.indexOf(strHeader) != 0) continue;
                    String strRealParamName = strKey.replace(strHeader, "");
                    Object objValue = srcDataEntity.GetParamValue(strKey);
                    childData.SetParamValue(strRealParamName, objValue);
                    bHasValue = true;
                }
                if (bHasValue) {
                    Object objKeyValue = childData.GetParamValue("ID");
                    if (objKeyValue != null && !bInsert) {
                        childData.SetParamValue(childDEDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), objKeyValue);
                    }
                    if (childData.ContainesParam("NAME")) {
                        childData.SetParamValue(childDEDataCtrl.GetDEHelper().GetMajorDEFHelper().getName(), childData.GetParamValue("NAME"));
                    }
                    childDataList.add(childData);
                }
                ++i;
            }
            for (BaseDataEntity childData : childDataList) {
                Object objKeyValue;
                int nEnable = childData.GetParamIntValue("ENABLE", 1);
                if (nEnable == 1) {
                    boolean bInsertMode;
                    objKeyValue = childData.GetParamValue(childDEDataCtrl.GetDEHelper().GetKeyDEFHelper().getName());
                    boolean bl = bInsertMode = objKeyValue == null;
                    if (bInsertMode) {
                        childData.SetParamValue(der1N.getMAJORKEYDEFNAME(), dataEntity.GetParamValue(this.GetDEHelper().GetKeyDEFHelper().getName()));
                        childData.SetParamValue(der1N.getMAJORTEXTDEFNAME(), dataEntity.GetParamValue(this.GetDEHelper().GetMajorDEFHelper().getName()));
                    }
                    if (!(callResult = childDEDataCtrl.Save(bInsertMode, strActionMode, childData)).IsError()) continue;
                    return callResult;
                }
                objKeyValue = childData.GetParamValue(childDEDataCtrl.GetDEHelper().GetKeyDEFHelper().getName());
                if (objKeyValue == null) {
                    log.error((Object)StringHelper.Format((String)"\u5220\u9664\u5b50\u6570\u636e[%1$s]\u6ca1\u6709\u6307\u5b9a\u4e3b\u952e", (Object)childDEDataCtrl.GetDEHelper().getId()));
                    continue;
                }
                callResult = childDEDataCtrl.Remove(childData);
                if (!callResult.IsError()) continue;
                return callResult;
            }
            callResult = this.InternalGetChildData(strChildDataTag, der1N, strSortInfo, dataEntity);
            return callResult;
        }
        catch (Exception e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
            return callResult;
        }
    }

    protected CallResult InternalSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity) {
        IDEDataCtrlEngine iDEDCEngine;
        Vector<DEDataCtrl> dedcs;
        Object objValue;
        CallResult callResult = new CallResult();
        if (bInsert && dataEntity.getParamValue(this.GetDEHelper().GetKeyDEFHelper().getName()) == null && (objValue = this.GetDEHelper().getKeyValue(dataEntity)) != null) {
            dataEntity.setParamValue(this.GetDEHelper().GetKeyDEFHelper().getName(), objValue);
        }
        if ((callResult = this.GetDEHelper().PrepareDBProc(bInsert ? ACTION_INSERT : ACTION_UPDATE, strActionMode)).getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u6570\u636e\u5e93\u8fc7\u7a0b[%1$s][%2$s]\u5931\u8d25\uff0c%3$s", (Object)this.GetDEHelper().getId(), (Object)(bInsert ? ACTION_INSERT : ACTION_UPDATE), (Object)callResult.getErrorInfo()));
            return callResult;
        }
        BaseDataEntity lastDataEntity = null;
        if (!bInsert) {
            lastDataEntity = new BaseDataEntity();
            dataEntity.CopyTo(lastDataEntity, true);
            callResult = this.Get(lastDataEntity);
            if (callResult.getRetCode() != 0) {
                Object objKeyData = dataEntity.GetParamValue(this.GetDEHelper().GetKeyDEFHelper().getName());
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u66f4\u65b0\u524d\u6570\u636e[%1$s][%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)this.GetDEHelper().getId(), (Object)objKeyData, (Object)callResult.getErrorInfo()));
                return callResult;
            }
            IDEMainActionHelper iDEMainActionHelper = null;
            try {
                String strDEMainActionName = StringHelper.Format((String)"%1$s_%2$s", (Object)(bInsert ? ACTION_INSERT : ACTION_UPDATE), (Object)strActionMode);
                if (this.GetDEHelper().HasDEMainAction(strDEMainActionName)) {
                    iDEMainActionHelper = this.GetDEHelper().FindDEMainAction(strDEMainActionName);
                }
            }
            catch (Exception ex) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u4e3b\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
                return callResult;
            }
            for (IDEFHelper iDEFHelper : this.GetDEHelper().GetDEFHelpers()) {
                String strUpdateOVMode;
                if (iDEMainActionHelper != null) {
                    IDEMAFieldHelper iDEMAFieldHelper = iDEMainActionHelper.FindDEMAField(iDEFHelper.getId());
                    if (iDEMAFieldHelper == null) {
                        if (iDEMainActionHelper.isUpdateMAFOnly() && !iDEFHelper.IsKeyDEField()) {
                            dataEntity.RemoveParam(iDEFHelper.getName());
                        }
                    } else {
                        String strUpdateMode = iDEMAFieldHelper.getUpdateMode();
                        if (StringHelper.IsNullOrEmpty((String)strUpdateMode)) {
                            String strUpdateValue = iDEMAFieldHelper.getUpdateValue();
                            if (!StringHelper.IsNullOrEmpty((String)strUpdateValue)) {
                                callResult = BaseDEDataCtrl.FillDataEntityParam(this, dataEntity, iDEFHelper.getName(), strUpdateValue);
                                if (!callResult.IsError()) continue;
                                return callResult;
                            }
                        } else {
                            if (StringHelper.Compare((String)strUpdateMode, (String)"NOTUPDATE", (boolean)true) == 0) {
                                dataEntity.RemoveParam(iDEFHelper.getName());
                                continue;
                            }
                            if (StringHelper.Compare((String)strUpdateMode, (String)"UPDATENULL", (boolean)true) == 0) {
                                dataEntity.SetParamValue(iDEFHelper.getName(), null);
                                continue;
                            }
                            if (StringHelper.Compare((String)strUpdateMode, (String)"UPDATEOV", (boolean)true) == 0) {
                                dataEntity.SetParamValue(iDEFHelper.getName(), lastDataEntity.GetParamValue(iDEFHelper.getName()));
                                continue;
                            }
                            if (StringHelper.Compare((String)strUpdateMode, (String)"UPDATEOVWHENNULL", (boolean)true) != 0 || dataEntity.ContainesParam(iDEFHelper.getName())) continue;
                            dataEntity.SetParamValue(iDEFHelper.getName(), lastDataEntity.GetParamValue(iDEFHelper.getName()));
                            continue;
                        }
                    }
                }
                if (StringHelper.IsNullOrEmpty((String)(strUpdateOVMode = iDEFHelper.getUpdateOVMode()))) continue;
                if (StringHelper.Compare((String)strUpdateOVMode, (String)"ALWAYS", (boolean)true) == 0) {
                    dataEntity.SetParamValue(iDEFHelper.getName(), lastDataEntity.GetParamValue(iDEFHelper.getName()));
                    continue;
                }
                if (StringHelper.Compare((String)strUpdateOVMode, (String)"NOTEXISTS", (boolean)true) != 0 || dataEntity.ContainesParam(iDEFHelper.getName())) continue;
                dataEntity.SetParamValue(iDEFHelper.getName(), lastDataEntity.GetParamValue(iDEFHelper.getName()));
            }
            callResult = this.InternalSaveTestNewOldData(dataEntity, lastDataEntity);
            if (callResult.IsError()) {
                return callResult;
            }
        }
        if ((dedcs = this.GetDEHelper().GetDEDC("BEFORESAVE", strActionMode)) != null) {
            for (DEDataCtrl dedc : dedcs) {
                iDEDCEngine = this.GetDEDataCtrlEngine(dedc.getDEDCOBJECT());
                if (iDEDCEngine == null) {
                    callResult.setRetCode(1);
                    return callResult;
                }
                callResult = iDEDCEngine.BeforeSave(dedc, dataEntity, lastDataEntity, bInsert, strActionMode);
                this.ReleaseDEDataCtrlEngine(dedc.getDEDCOBJECT(), iDEDCEngine);
                if (!callResult.IsError()) continue;
                return callResult;
            }
        }
        if ((callResult = this.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity)).IsError()) {
            log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u4e4b\u524d\u8c03\u7528[%1$s:%2$s]\u5931\u8d25\uff0c%3$s", (Object)ACTION_INSERT, (Object)strActionMode, (Object)callResult.getErrorInfo()));
            return callResult;
        }
        callResult = this.InternalSaveData(bInsert, strActionMode, dataEntity);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4fdd\u5b58\u6570\u636e\u5931\u8d25,%2$s", (Object)this.GetDEHelper().getId(), (Object)callResult.getErrorInfo()));
            return callResult;
        }
        dedcs = this.GetDEHelper().GetDEDC("AFTERSAVE", strActionMode);
        if (dedcs != null) {
            for (DEDataCtrl dedc : dedcs) {
                iDEDCEngine = this.GetDEDataCtrlEngine(dedc.getDEDCOBJECT());
                if (iDEDCEngine == null) {
                    callResult.setRetCode(1);
                    return callResult;
                }
                callResult = iDEDCEngine.AfterSave(dedc, dataEntity, lastDataEntity, bInsert, strActionMode);
                this.ReleaseDEDataCtrlEngine(dedc.getDEDCOBJECT(), iDEDCEngine);
                if (!callResult.IsError()) continue;
                return callResult;
            }
        }
        this.GetDEHelper().LogFieldCaretTempl(dataEntity, this.strCurOpPersonId);
        this.DataNotify(bInsert ? 1 : 2, lastDataEntity, dataEntity);
        if (this.getWebContext() != null) {
            this.GetDEHelper().GetDataAccHelper().Audit(null, this.iTransactionManager, this.getWebContext(), dataEntity, lastDataEntity, bInsert ? "CREATE" : ACTION_UPDATE);
        } else {
            this.GetDEHelper().GetDataAccHelper().Audit(null, this.iTransactionManager, this.strCurOpPersonId, "", dataEntity, lastDataEntity, bInsert ? "CREATE" : ACTION_UPDATE);
        }
        return this.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
    }

    protected CallResult InternalSaveTestNewOldData(BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = new CallResult();
        if (!dataEntity.IsParamNull("SRFDAUPDATEDATE")) {
            String strFieldName;
            IDEFHelper updateDateDEFHelper = this.GetDEHelper().GetUpdateDateDEFHelper();
            if (updateDateDEFHelper != null && lastDataEntity.ContainesParam(strFieldName = updateDateDEFHelper.getName())) {
                String strLastDateStr;
                String strCurDateStr;
                Date curDate = dataEntity.GetParamDateValue("SRFDAUPDATEDATE", null);
                Date lastDate = lastDataEntity.GetParamDateValue(strFieldName, null);
                if (curDate != null && lastDate != null && StringHelper.Compare((String)(strCurDateStr = StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)curDate)), (String)(strLastDateStr = StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)lastDate)), (boolean)true) != 0) {
                    callResult.setRetCode(10);
                    return callResult;
                }
            }
            dataEntity.RemoveParam("SRFDAUPDATEDATE");
        }
        return callResult;
    }

    protected CallResult InternalSaveData(boolean bInsert, String strActionMode, BaseDataEntity dataEntity) {
        Vector<ProcParam> params;
        CallResult callResult = new CallResult();
        Hashtable<String, String> pwdStorageMap = null;
        if (this.GetDEHelper().IsEnablePwdStorage()) {
            for (IDEFHelper iDEFHelper : this.GetDEHelper().GetPwdStorageFields()) {
                String strValue = dataEntity.GetParamStringValue(iDEFHelper.getName(), null);
                if (strValue == null || StringHelper.Compare((String)strValue, (String)TAG_PASSWORDSTORAGE, (boolean)false) == 0) continue;
                if (pwdStorageMap == null) {
                    pwdStorageMap = new Hashtable<String, String>();
                }
                pwdStorageMap.put(iDEFHelper.getName(), strValue);
                dataEntity.SetParamValue(iDEFHelper.getName(), (Object)TAG_PASSWORDSTORAGE);
            }
        }
        if (this.GetDEHelper().IsEnableEncryptStorage()) {
            BaseDEDataCtrl.EncryptDataEntity(this.GetDEHelper(), dataEntity);
        }
        String strTempDataId = "";
        if (bInsert) {
            strTempDataId = dataEntity.GetParamStringValue("SRFDATEMPKEYID", "");
        }
        String strProcName = "";
        strProcName = bInsert ? this.iDEHelper.GetInsertProcName() : this.iDEHelper.GetUpdateProcName();
        if (StringHelper.IsNullOrEmpty((String)strProcName)) {
            String strError = StringHelper.Format((String)"\u6ca1\u6709\u5b9a\u4e49[%1$s]\u8fc7\u7a0b\u7684\u540d\u79f0", (Object)(bInsert ? ACTION_INSERT : ACTION_UPDATE));
            log.error((Object)strError);
            callResult.setRetCode(1);
            callResult.setErrorInfo(strError);
            return callResult;
        }
        if (bInsert) {
            callResult = BaseDEDataCtrl.FillDBActionParam(this, ACTION_INSERT, strActionMode, dataEntity);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u586b\u5145\u64cd\u4f5c[%1$s:%2$s]\u53c2\u6570\u9519\u8bef\uff0c%3$s", (Object)ACTION_INSERT, (Object)strActionMode, (Object)callResult.getErrorInfo()));
                return callResult;
            }
        } else {
            callResult = BaseDEDataCtrl.FillDBActionParam(this, ACTION_UPDATE, strActionMode, dataEntity);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u586b\u5145\u64cd\u4f5c[%1$s:%2$s]\u53c2\u6570\u9519\u8bef\uff0c%3$s", (Object)ACTION_UPDATE, (Object)strActionMode, (Object)callResult.getErrorInfo()));
                return callResult;
            }
        }
        if ((callResult = this.GetProcParams(strProcName, params = new Vector<ProcParam>())).getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8fc7\u7a0b[%1$s]\u53c2\u6570\u9519\u8bef", (Object)strProcName));
            return callResult;
        }
        Vector<CallParam> callParams = new Vector<CallParam>();
        this.FillProcCallParams(strActionMode, dataEntity, params, callParams);
        String strKey = this.iDEHelper.GetKeyDEFHelper().GetDTColumn().GetColumnName().toUpperCase();
        if (this.bSaveAndGetMode && bInsert) {
            for (CallParam callParam : callParams) {
                if (StringHelper.Compare((String)strKey, (String)callParam.getOutputParamName(), (boolean)true) != 0) continue;
                callParam.setDirection(3);
                break;
            }
        }
        try {
            SelectResult result = this.globalHelperEx.getDBCaller(this.GetDEHelper().GetDBStorage()).CallRaw4(this.getConnection(bInsert ? ACTION_INSERT : ACTION_UPDATE, strActionMode), strProcName, callParams);
            callResult.From((DBResult)result);
            callResult.setUserObject((Object)result);
            if (callResult.getRetCode() == 0) {
                BaseDEDataCtrl.FillCallResult(callResult, (DBResult)result);
            }
            if (callResult.getRetCode() == 0) {
                if (result.getSelectData().getTableCount() == 0) {
                    callResult.setRetCode(3);
                    return callResult;
                }
                if (dataEntity.GetParamIntValue(TAG_RETDATA, 1) == 1) {
                    Object objKeyValue;
                    if (this.bSaveAndGetMode) {
                        if (bInsert && (objKeyValue = result.getOutValues().get(strKey)) != null) {
                            dataEntity.SetParamValue(strKey, (Object)objKeyValue.toString());
                        }
                        if ((callResult = this.InternalGet(dataEntity, true)).IsError()) {
                            log.error((Object)StringHelper.Format((String)"\u91cd\u65b0\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                            return callResult;
                        }
                    } else {
                        if (result.getSelectData().getTable(0).GetRowCount() == 0) {
                            callResult.setRetCode(3);
                            return callResult;
                        }
                        dataEntity.FromDataRow(result.getSelectData().getTable(0).GetRow(0));
                        if (this.GetDEHelper().IsEnableEncryptStorage()) {
                            BaseDEDataCtrl.DecryptDataEntity(this.GetDEHelper(), dataEntity);
                        }
                    }
                    if (pwdStorageMap != null) {
                        objKeyValue = dataEntity.GetParamValue(strKey);
                        if (objKeyValue == null) {
                            callResult.setRetCode(1);
                            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u8fd4\u56de\u4e3b\u952e\u6570\u636e\uff0c\u65e0\u6cd5\u8fdb\u884c\u5bc6\u7801\u5b58\u50a8"));
                            return callResult;
                        }
                        IPasswordStorage iPasswordStorage = this.getGlobalHelper().getPasswordStorage();
                        for (String strFieldName : pwdStorageMap.keySet()) {
                            String strValue = (String)pwdStorageMap.get(strFieldName);
                            if (this.getTransactionManager() == null) {
                                iPasswordStorage.Storage(null, this.GetDEHelper().getId(), objKeyValue, strFieldName, strValue, this.GetDEHelper().GetDEFHelper(strFieldName).getPwdStorage() == 2);
                                continue;
                            }
                            iPasswordStorage.Storage(this, this.GetDEHelper().getId(), objKeyValue, strFieldName, strValue, this.GetDEHelper().GetDEFHelper(strFieldName).getPwdStorage() == 2);
                        }
                    }
                    dataEntity.SetParamValue(TAG_FULLINFO, (Object)1);
                } else {
                    dataEntity.SetParamValue(TAG_FULLINFO, (Object)0);
                }
                if (this.GetDEHelper().GetProperty("IGNORESAVEINDEXERROR", true)) {
                    CallResult tempResult = this.OnSaveIndex(strActionMode, dataEntity, true);
                    if (tempResult.IsError()) {
                        log.warn((Object)StringHelper.Format((String)"\u4fdd\u5b58\u7d22\u5f15\u6570\u636e\u53d1\u751f\u9519\u8bef,\u9519\u8bef\u88ab\u5ffd\u7565\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                } else {
                    callResult = this.OnSaveIndex(strActionMode, dataEntity, false);
                    if (callResult.IsError()) {
                        return callResult;
                    }
                }
                if (bInsert && !StringHelper.IsNullOrEmpty((String)strTempDataId) && (callResult = this.OnSaveTempData(dataEntity, strTempDataId)).IsError()) {
                    return callResult;
                }
            } else {
                this.FillCallResultEx(callResult);
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void DataNotify(int nEventType, BaseDataEntity lastDataEntity, BaseDataEntity dataEntity) {
        if (this.GetDEHelper().HasDataNotify(nEventType, false)) {
            Vector<DataNotify> list = new Vector<DataNotify>();
            this.GetDEHelper().ListDataNotifies(nEventType, false, list);
            for (DataNotify dataNotify : list) {
                this.GetDEHelper().GetDataNotifyHelper(dataNotify).Notify(this, dataNotify, lastDataEntity, dataEntity);
            }
        }
        if (this.GetDEHelper().HasDataNotify()) {
            this.GetDEHelper().GetDataNotifyHelper(null).QueueNotify(this, nEventType, lastDataEntity, dataEntity);
        }
        if (this.GetDEHelper().GetDataChangeLogMode() == 2 || this.GetDEHelper().GetDataChangeLogMode() == 3 || this.GetDEHelper().GetDataChangeLogMode() != 0 && nEventType == 4) {
            IDEDataCtrl iDEDataCtrl;
            try {
                iDEDataCtrl = this.GetRelatedDataCtrl("DE0223");
            }
            catch (Exception e) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)"DE0223", (Object)e.getMessage()), (Throwable)e);
                return;
            }
            DEDataChg deDataChg = new DEDataChg();
            BaseDEDataCtrl.SetCallParamCheckKey(deDataChg, false);
            BaseDEDataCtrl.SetCallParamDALog(deDataChg, false);
            BaseDEDataCtrl.SetCallParamRetData(deDataChg, false);
            deDataChg.setDEID(this.GetDEHelper().getId());
            deDataChg.setEVENTTYPE(nEventType);
            deDataChg.setDATAKEY(dataEntity.GetParamStringValue(this.GetDEHelper().GetKeyDEFHelper().getName(), ""));
            if (nEventType != 4) {
                deDataChg.setLOGICDATA(BaseDataEntity.ToString((BaseDataEntity)dataEntity));
                XMLNode rootNode = new XMLNode();
                rootNode.setNodeName("SRFDAXMLEXPORTS");
                if (this.GetDEHelper().GetDataChangeLogMode() == 3) {
                    Vector<XMLNode> exportXMLNodes = new Vector<XMLNode>();
                    CallResult callResult = this.Export(dataEntity, exportXMLNodes, false, false);
                    if (callResult.IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u5bfc\u51fa\u5b9e\u4f53[%1$s]\u6570\u636e\u6a21\u578b\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.GetDEHelper().getId(), (Object)callResult.getErrorInfo()));
                        return;
                    }
                    for (XMLNode xmlNode : exportXMLNodes) {
                        xmlNode.setNodeName("SRFDAXMLEXPORT");
                        rootNode.AddNode(xmlNode);
                    }
                } else {
                    XMLNode xmlNode = new XMLNode();
                    xmlNode.setNodeName("SRFDAXMLEXPORT");
                    xmlNode.SetValue("SRFDEID", this.GetDEHelper().getId());
                    xmlNode.SetValue("SRFVALUE", BaseDataEntity.ToString((BaseDataEntity)dataEntity, (boolean)this.GetDEHelper().IsExportIncEmpty()));
                    rootNode.AddNode(xmlNode);
                }
                deDataChg.setDATA(XMLNode.Export((XMLNode)rootNode));
            } else {
                deDataChg.setLOGICDATA(BaseDataEntity.ToString((BaseDataEntity)dataEntity));
            }
            CallResult callResult = iDEDataCtrl.Save(true, deDataChg);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53\u6570\u636e\u53d8\u66f4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return;
            }
        }
    }

    protected CallResult OnSaveTempData(BaseDataEntity dataEntity, String strTempDataId) {
        return BaseDEDataCtrl.SaveTempData(this, dataEntity, strTempDataId);
    }

    protected static CallResult SaveTempData(IDEDataCtrl iDEDataCtrl, BaseDataEntity dataEntity, String strTempDataId) {
        IDEDataCtrl iTempDataCtrl;
        CallResult callResult = new CallResult();
        try {
            iTempDataCtrl = iDEDataCtrl.GetRelatedDataCtrl("DE0112");
        }
        catch (Exception e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)iDEDataCtrl.getGlobalHelper().getLocalizationHelper().GetLocalization(iDEDataCtrl.getLanguage(), "ERROR.STD.SRFDA.CANNOTFINDDEDATACTRL", "\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61"), (Object)"DE0112"));
            return callResult;
        }
        String strNewKey = dataEntity.GetParamStringValue(iDEDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), "");
        Vector<BaseDataEntity> list = new Vector<BaseDataEntity>();
        BaseDataEntity cond = new BaseDataEntity();
        cond.SetParamValue("PDEID", (Object)iDEDataCtrl.GetDEHelper().getId());
        cond.SetParamValue("PTEMPKEYVALUE", (Object)strTempDataId);
        callResult = iTempDataCtrl.Select(cond, list);
        if (callResult.IsError()) {
            return callResult;
        }
        TreeMap<String, IDEDataCtrl> realDataCtrlMap = new TreeMap<String, IDEDataCtrl>();
        TempData td = new TempData();
        for (BaseDataEntity de : list) {
            td.Proxy(de);
            if (!td.getNOSAVE()) {
                BaseDataEntity realDataEntity = BaseDataEntity.FromString((String)td.getDEDATA());
                realDataEntity.SetParamValue(td.getPTEMPKEYNAME(), (Object)strNewKey);
                IDEDataCtrl iRealDataCtrl = null;
                if (realDataCtrlMap.containsKey(td.getTEMPDATANAME())) {
                    iRealDataCtrl = (IDEDataCtrl)realDataCtrlMap.get(td.getTEMPDATANAME());
                } else {
                    iRealDataCtrl = iDEDataCtrl.getGlobalHelper().getDAModelStorage().FindDEDataCtrlEx(td.getTEMPDATANAME(), iDEDataCtrl);
                    if (iRealDataCtrl == null) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)iDEDataCtrl.getGlobalHelper().getLocalizationHelper().GetLocalization(iDEDataCtrl.getLanguage(), "ERROR.STD.SRFDA.CANNOTFINDDEDATACTRL", "\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61"), (Object)td.getTEMPDATANAME()));
                        return callResult;
                    }
                    realDataCtrlMap.put(td.getTEMPDATANAME(), iRealDataCtrl);
                }
                callResult = iRealDataCtrl.Save(true, realDataEntity);
                if (callResult.IsError()) {
                    return callResult;
                }
            }
            if (!(callResult = iTempDataCtrl.Remove(de)).IsError()) continue;
            return callResult;
        }
        Vector<DERINDEX> derIndexs = iDEDataCtrl.GetDEHelper().GetDERINDEXs(false);
        if (derIndexs.size() == 0) {
            callResult.setRetCode(0);
            return callResult;
        }
        for (DERINDEX derIndex : derIndexs) {
            IDEHelper indexDEHelper = iDEDataCtrl.getGlobalHelper().getDAModelStorage().FindDEHelper(derIndex.getINDEXDEID());
            if (indexDEHelper == null) {
                callResult.setErrorInfo(StringHelper.Format((String)iDEDataCtrl.getGlobalHelper().getLocalizationHelper().GetLocalization(iDEDataCtrl.getLanguage(), "ERROR.STD.SRFDA.CANNOTFINDDEHELPER", "\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61"), (Object)derIndex.getINDEXDEID()));
                log.error((Object)callResult.getErrorInfo());
                callResult.setRetCode(1);
                continue;
            }
            String strIndexTempDataId = String.valueOf(strTempDataId) + ":" + indexDEHelper.getId();
            list.clear();
            cond.Reset();
            cond.SetParamValue("PDEID", (Object)indexDEHelper.getId());
            cond.SetParamValue("PTEMPKEYVALUE", (Object)strIndexTempDataId);
            callResult = iTempDataCtrl.Select(cond, list);
            if (callResult.IsError()) {
                return callResult;
            }
            cond.SetParamValue("PTEMPKEYVALUE", (Object)strTempDataId);
            callResult = iTempDataCtrl.Select(cond, list);
            if (callResult.IsError()) {
                return callResult;
            }
            for (BaseDataEntity de : list) {
                td.Proxy(de);
                if (!td.getNOSAVE()) {
                    BaseDataEntity realDataEntity = BaseDataEntity.FromString((String)td.getDEDATA());
                    if (indexDEHelper.GetIndexMode() == 1) {
                        realDataEntity.SetParamValue(td.getPTEMPKEYNAME(), (Object)StringHelper.Format((String)"%1$s|%2$s", (Object)derIndex.getTYPEVALUE(), (Object)strNewKey));
                    } else {
                        realDataEntity.SetParamValue(td.getPTEMPKEYNAME(), (Object)strNewKey);
                    }
                    IDEDataCtrl iRealDataCtrl = null;
                    if (realDataCtrlMap.containsKey(td.getTEMPDATANAME())) {
                        iRealDataCtrl = (IDEDataCtrl)realDataCtrlMap.get(td.getTEMPDATANAME());
                    } else {
                        iRealDataCtrl = iDEDataCtrl.getGlobalHelper().getDAModelStorage().FindDEDataCtrlEx(td.getTEMPDATANAME(), iDEDataCtrl);
                        if (iRealDataCtrl == null) {
                            callResult.setRetCode(1);
                            callResult.setErrorInfo(StringHelper.Format((String)iDEDataCtrl.getGlobalHelper().getLocalizationHelper().GetLocalization(iDEDataCtrl.getLanguage(), "ERROR.STD.SRFDA.CANNOTFINDDEDATACTRL", "\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61"), (Object)td.getTEMPDATANAME()));
                            return callResult;
                        }
                        realDataCtrlMap.put(td.getTEMPDATANAME(), iRealDataCtrl);
                    }
                    callResult = iRealDataCtrl.Save(true, realDataEntity);
                    if (callResult.IsError()) {
                        return callResult;
                    }
                }
                if (!(callResult = iTempDataCtrl.Remove(de)).IsError()) continue;
                return callResult;
            }
        }
        return callResult;
    }

    protected CallResult OnSaveIndex(String strActionMode, BaseDataEntity dataEntity, boolean bIgnoreError) {
        return BaseDEDataCtrl.SaveIndex(this, strActionMode, dataEntity, bIgnoreError);
    }

    protected static CallResult SaveIndex(IDEDataCtrl iDEDataCtrl, String strActionMode, BaseDataEntity dataEntity, boolean bIgnoreError) {
        CallResult callResult = new CallResult();
        Vector<DERINDEX> derIndexs = iDEDataCtrl.GetDEHelper().GetDERINDEXs(false);
        if (derIndexs.size() == 0) {
            callResult.setRetCode(0);
            return callResult;
        }
        Object objIdValue = dataEntity.GetParamValue(iDEDataCtrl.GetDEHelper().GetKeyDEFHelper().getName());
        Object objNameValue = dataEntity.GetParamValue(iDEDataCtrl.GetDEHelper().GetMajorDEFHelper().getName());
        for (DERINDEX derIndex : derIndexs) {
            IDEHelper indexDEHelper;
            if (derIndex.isINHERITMODE()) {
                indexDEHelper = iDEDataCtrl.getGlobalHelper().getDAModelStorage().FindDEHelper(derIndex.getINDEXDEID());
                if (indexDEHelper == null) {
                    callResult.setErrorInfo(StringHelper.Format((String)iDEDataCtrl.getGlobalHelper().getLocalizationHelper().GetLocalization(iDEDataCtrl.getLanguage(), "ERROR.STD.SRFDA.CANNOTFINDDEHELPER", "\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61"), (Object)derIndex.getINDEXDEID()));
                    log.error((Object)callResult.getErrorInfo());
                    callResult.setRetCode(1);
                    if (bIgnoreError) continue;
                    return callResult;
                }
                try {
                    String strDEFMap = derIndex.getDEFIELDMAP();
                    IDEDataCtrl indexDEDataCtrl = iDEDataCtrl.GetRelatedDataCtrl(indexDEHelper.getId());
                    BaseDataEntity indexDataEntity = new BaseDataEntity();
                    indexDataEntity.SetParamValue(indexDEHelper.GetKeyDEFHelper().getName(), objIdValue);
                    if (!StringHelper.IsNullOrEmpty((String)strDEFMap)) {
                        Properties properties = PropertiesHelper.Load((String)strDEFMap);
                        Enumeration<Object> en = properties.keys();
                        while (en.hasMoreElements()) {
                            String strKey = (String)en.nextElement();
                            String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                            if (StringHelper.IsNullOrEmpty((String)strValue)) continue;
                            if (strValue.indexOf("#") == 0) {
                                strValue = strValue.substring(1);
                                IDEFHelper tempDEF = indexDEHelper.GetDEFHelper(strKey);
                                if (tempDEF != null) {
                                    indexDataEntity.SetParamValue(strKey, DataTypeParse.Parse((String)tempDEF.GetStdDataType(), (String)strValue));
                                    continue;
                                }
                                indexDataEntity.SetParamValue(strKey, (Object)strValue);
                                continue;
                            }
                            indexDataEntity.SetParamValue(strKey, dataEntity.GetParamValue(strValue));
                        }
                    }
                    if ((callResult = indexDEDataCtrl.Save(false, strActionMode, indexDataEntity)).getRetCode() == 0) continue;
                    callResult.setErrorInfo(StringHelper.Format((String)"\u4fdd\u5b58\u7d22\u5f15\u5b9e\u4f53[%1$s]\u6570\u636e\u5931\u8d25\uff0c%2$s", (Object)indexDEHelper.getId(), (Object)callResult.getErrorInfo()));
                    log.error((Object)callResult.getErrorInfo());
                    callResult.setRetCode(1);
                    if (bIgnoreError) continue;
                    return callResult;
                }
                catch (Exception ex) {
                    callResult.setErrorInfo(StringHelper.Format((String)"\u4fdd\u5b58\u7d22\u5f15\u5b9e\u4f53[%1$s]\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)indexDEHelper.getId(), (Object)ex.getMessage()));
                    log.error((Object)callResult.getErrorInfo());
                    callResult.setRetCode(1);
                    if (bIgnoreError) continue;
                    return callResult;
                }
            }
            try {
                indexDEHelper = iDEDataCtrl.getGlobalHelper().getDAModelStorage().FindDEHelper(derIndex.getINDEXDEID());
                if (indexDEHelper == null) {
                    callResult.setErrorInfo(StringHelper.Format((String)iDEDataCtrl.getGlobalHelper().getLocalizationHelper().GetLocalization(iDEDataCtrl.getLanguage(), "ERROR.STD.SRFDA.CANNOTFINDDEHELPER", "\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61"), (Object)derIndex.getINDEXDEID()));
                    log.error((Object)callResult.getErrorInfo());
                    callResult.setRetCode(1);
                    if (bIgnoreError) continue;
                    return callResult;
                }
                if (indexDEHelper.GetIndexTypeDEFHelper() == null) {
                    callResult.setErrorInfo(StringHelper.Format((String)iDEDataCtrl.getGlobalHelper().getLocalizationHelper().GetLocalization(iDEDataCtrl.getLanguage(), "ERROR.STD.SRFDA.CANNOTFINDINDEXDEF", "\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u7d22\u5f15\u5206\u7ec4\u5c5e\u6027"), (Object)derIndex.getINDEXDEID()));
                    log.error((Object)callResult.getErrorInfo());
                    callResult.setRetCode(1);
                    if (bIgnoreError) continue;
                    return callResult;
                }
                String strDataType = indexDEHelper.GetIndexTypeDEFHelper().GetStdDataType();
                Object objTypeValue = DataTypeParse.Parse((String)strDataType, (String)derIndex.getTYPEVALUE());
                if (objTypeValue == null) {
                    callResult.setErrorInfo(StringHelper.Format((String)"\u7d22\u5f15\u5206\u7ec4\u503c[%1$s]\u65e0\u6548", (Object)derIndex.getTYPEVALUE()));
                    log.error((Object)callResult.getErrorInfo());
                    callResult.setRetCode(1);
                    if (bIgnoreError) continue;
                    return callResult;
                }
                IDEDataCtrl indexDEDataCtrl = indexDEHelper.GetDEDataCtrl(iDEDataCtrl.getOPPersonId(), iDEDataCtrl.getWebContext());
                if (iDEDataCtrl.getTransactionManager() != null) {
                    iDEDataCtrl.getTransactionManager().Register(indexDEDataCtrl);
                }
                String strNewKey = StringHelper.Format((String)"%1$s|%2$s", (Object)derIndex.getTYPEVALUE(), (Object)objIdValue);
                BaseDataEntity indexDataEntity = new BaseDataEntity();
                if (indexDEHelper.GetIndexMode() == 1) {
                    indexDataEntity.SetParamValue(indexDEHelper.GetKeyDEFHelper().getName(), (Object)strNewKey);
                } else {
                    indexDataEntity.SetParamValue(indexDEHelper.GetKeyDEFHelper().getName(), objIdValue);
                }
                callResult = indexDEDataCtrl.CheckKeyState(indexDataEntity);
                if (callResult.getRetCode() != 0) {
                    callResult.setErrorInfo(StringHelper.Format((String)"\u68c0\u67e5\u7d22\u5f15\u5b9e\u4f53[%1$s]\u4e3b\u952e\u5931\u8d25\uff0c%2$s", (Object)indexDEHelper.GetFullName(), (Object)callResult.getErrorInfo()));
                    log.error((Object)callResult.getErrorInfo());
                    callResult.setRetCode(1);
                    if (bIgnoreError) continue;
                    return callResult;
                }
                Integer nValue = (Integer)callResult.getUserObject();
                if (nValue == 2) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"[%1$s]\u6570\u636e[%2$s]\u5df2\u7ecf\u88ab\u5220\u9664\uff0c\u65e0\u6cd5\u66f4\u65b0\u7d22\u5f15", (Object)indexDEHelper.getName(), (Object)indexDataEntity.get(indexDEHelper.GetMajorDEFHelper().getName())));
                    log.error((Object)callResult.getErrorInfo());
                    if (bIgnoreError) continue;
                    return callResult;
                }
                dataEntity.CopyTo(indexDataEntity, true);
                if (indexDEHelper.GetIndexMode() == 1) {
                    indexDataEntity.SetParamValue(indexDEHelper.GetKeyDEFHelper().getName(), (Object)strNewKey);
                    IDEFHelper realKeyFieldHelper = BaseDEHelper.GetIndexDERealKeyField(indexDEHelper);
                    indexDataEntity.SetParamValue(realKeyFieldHelper.getName(), objIdValue);
                } else {
                    indexDataEntity.SetParamValue(indexDEHelper.GetKeyDEFHelper().getName(), objIdValue);
                }
                indexDataEntity.SetParamValue(indexDEHelper.GetMajorDEFHelper().getName(), objNameValue);
                indexDataEntity.SetParamValue(indexDEHelper.GetIndexTypeDEFHelper().getName(), objTypeValue);
                String strDEFMap = derIndex.getDEFIELDMAP();
                if (!StringHelper.IsNullOrEmpty((String)strDEFMap)) {
                    try {
                        Properties properties = PropertiesHelper.Load((String)strDEFMap);
                        Enumeration<Object> en = properties.keys();
                        while (en.hasMoreElements()) {
                            String strKey = (String)en.nextElement();
                            String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                            if (StringHelper.IsNullOrEmpty((String)strValue)) continue;
                            if (strValue.indexOf("#") == 0) {
                                strValue = strValue.substring(1);
                                IDEFHelper tempDEF = indexDEHelper.GetDEFHelper(strKey);
                                if (tempDEF != null) {
                                    indexDataEntity.SetParamValue(strKey, DataTypeParse.Parse((String)tempDEF.GetStdDataType(), (String)strValue));
                                    continue;
                                }
                                indexDataEntity.SetParamValue(strKey, (Object)strValue);
                                continue;
                            }
                            indexDataEntity.SetParamValue(strKey, dataEntity.GetParamValue(strValue));
                        }
                    }
                    catch (Exception ex) {
                        log.error((Object)ex);
                    }
                }
                if ((callResult = indexDEDataCtrl.Save(nValue == 0, indexDataEntity)).getRetCode() == 0) continue;
                callResult.setErrorInfo(StringHelper.Format((String)"\u4fdd\u5b58\u7d22\u5f15\u5b9e\u4f53[%1$s]\u6570\u636e\u5931\u8d25\uff0c%2$s", (Object)indexDEHelper.getId(), (Object)callResult.getErrorInfo()));
                log.error((Object)callResult.getErrorInfo());
                callResult.setRetCode(1);
                if (bIgnoreError) continue;
                return callResult;
            }
            catch (Exception ex) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u4fdd\u5b58\u7d22\u5f15\u5b9e\u4f53[%1$s]\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)derIndex.getINDEXDEID(), (Object)ex.getMessage()));
                log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
                callResult.setRetCode(1);
                if (bIgnoreError) continue;
                return callResult;
            }
        }
        callResult.setRetCode(0);
        return callResult;
    }

    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = new CallResult();
        return callResult;
    }

    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = new CallResult();
        return callResult;
    }

    @Override
    public CallResult TestDataLock(BaseDataEntity dataEntity, String strKey) {
        DataLock dataLock = new DataLock();
        CallResult callResult = this.GetDataLock(dataEntity, dataLock);
        if (callResult.getRetCode() == 3) {
            callResult.setRetCode(0);
            return callResult;
        }
        if (callResult.getRetCode() == 0) {
            if (StringHelper.IsNullOrEmpty((String)strKey)) {
                strKey = this.GetDataLockKey(dataEntity);
            }
            if (StringHelper.Compare((String)dataLock.getKEY(), (String)strKey, (boolean)true) == 0) {
                return callResult;
            }
            callResult.setRetCode(2);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6570\u636e\u88ab\u9501\u5b9a,%1$s", (Object)dataLock.getDATALOCKNAME()));
            return callResult;
        }
        return callResult;
    }

    @Override
    public CallResult GetDataLock(BaseDataEntity dataEntity, DataLock dataLock) {
        Object objKey;
        CallResult callResult = new CallResult();
        callResult.setRetCode(3);
        IDEHelper iMajorDEHelper = null;
        String strMajorDEPickupField = "";
        BaseDataEntity temp = null;
        if (this.GetDEHelper().IsMultiMajorDE()) {
            if (temp == null) {
                temp = new BaseDataEntity();
                dataEntity.CopyTo(temp, false);
                objKey = dataEntity.GetParamValue(this.iDEHelper.GetKeyDEFHelper().getName());
                if (objKey != null && (callResult = this.Get(temp)).getRetCode() != 0 && callResult.getRetCode() != 3) {
                    return callResult;
                }
            }
            strMajorDEPickupField = this.GetDEHelper().CalcMajorDEPickupField(temp);
            iMajorDEHelper = this.GetDEHelper().GetMajorDEHelper(strMajorDEPickupField);
            if (StringHelper.IsNullOrEmpty((String)strMajorDEPickupField)) {
                return callResult;
            }
        } else {
            iMajorDEHelper = this.GetDEHelper().GetMajorDEHelper();
            strMajorDEPickupField = this.iDEHelper.GetMajorDEPickupField();
        }
        if (iMajorDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u4e3b\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61", (Object)this.iDEHelper.getId()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        if (StringHelper.Compare((String)iMajorDEHelper.getId(), (String)this.iDEHelper.getId(), (boolean)true) == 0) {
            objKey = dataEntity.GetParamValue(strMajorDEPickupField);
            if (objKey != null) {
                dataLock.setOBJECTTYPE(iMajorDEHelper.getId());
                dataLock.setOBJECTID(objKey.toString());
                return this.GetDataLockDataCtrl().GetDataLock(dataLock);
            }
            return callResult;
        }
        if (temp == null) {
            temp = new BaseDataEntity();
            dataEntity.CopyTo(temp, true);
            objKey = dataEntity.GetParamValue(this.iDEHelper.GetKeyDEFHelper().getName());
            if (objKey != null && (callResult = this.Get(temp)).getRetCode() != 0 && callResult.getRetCode() != 3) {
                return callResult;
            }
        }
        if (temp != null && (objKey = temp.GetParamValue(strMajorDEPickupField)) != null) {
            dataLock.setOBJECTTYPE(iMajorDEHelper.getId());
            dataLock.setOBJECTID(objKey.toString());
            return this.GetDataLockDataCtrl().GetDataLock(dataLock);
        }
        callResult.setRetCode(1);
        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u952e\u503c", (Object)iMajorDEHelper.getId(), (Object)this.iDEHelper.GetMajorDEPickupField()));
        log.error((Object)callResult.getErrorInfo());
        return callResult;
    }

    protected void FillProcCallParams(String strActionMode, BaseDataEntity dataEntity, Vector<ProcParam> procParams, Vector<CallParam> callPrams) {
        for (ProcParam procParam : procParams) {
            CallParam callParam = BaseDEDataCtrl.GetProcCallParam(this, strActionMode, dataEntity, procParam);
            if (callParam == null) {
                callParam = new CallParam();
            }
            callPrams.add(callParam);
        }
    }

    protected static CallParam GetProcCallParam(IDEDataCtrl iDEDataCtrl, String strActionMode, BaseDataEntity dataEntity, ProcParam procParam) {
        CallParam callParam = new CallParam();
        String strParamName = procParam.getParamName().toUpperCase();
        if (strParamName.indexOf(TAG_VAR) == 0) {
            Object objValue;
            strParamName = strParamName.substring(4);
            IDEFHelper iDEFHelper = iDEDataCtrl.GetDEHelper().GetDEFHelper(strParamName);
            if (iDEFHelper != null) {
                callParam.setDataType(DataTypeHelper.FromString((String)iDEFHelper.GetStdDataType()));
            }
            Object object = objValue = dataEntity == null ? null : dataEntity.GetParamValue(strParamName);
            if (objValue != null && objValue instanceof String && StringHelper.IsNullOrEmpty((String)((String)objValue))) {
                objValue = null;
            }
            callParam.setValue(objValue);
            callParam.setDirection(procParam.getDirection());
            callParam.setOutputParamName(strParamName);
            return callParam;
        }
        if (strParamName.indexOf(TAG_VF) == 0) {
            strParamName = strParamName.substring(3);
            if (dataEntity != null && dataEntity.ContainesParam(strParamName)) {
                callParam.setValue((Object)1);
            } else {
                callParam.setValue((Object)0);
            }
            callParam.setDataType(9);
            return callParam;
        }
        if (StringHelper.Compare((String)procParam.getParamName(), (String)TAG_PERSONID, (boolean)true) == 0) {
            if (dataEntity != null) {
                String strTempOpPersonId = dataEntity.GetParamStringValue(TAG_PERSONID, iDEDataCtrl.getOPPersonId());
                callParam.setValue((Object)strTempOpPersonId);
            } else {
                callParam.setValue((Object)iDEDataCtrl.getOPPersonId());
            }
            callParam.setDataType(25);
            return callParam;
        }
        if (StringHelper.Compare((String)procParam.getParamName(), (String)TAG_ORGUNITID, (boolean)true) == 0) {
            if (dataEntity != null) {
                String strTempOrgUnitId = dataEntity.GetParamStringValue(TAG_ORGUNITID, iDEDataCtrl.getOrgUnitId());
                callParam.setValue((Object)strTempOrgUnitId);
            } else {
                callParam.setValue((Object)iDEDataCtrl.getOrgUnitId());
            }
            callParam.setDataType(25);
            return callParam;
        }
        if (StringHelper.Compare((String)procParam.getParamName(), (String)TAG_ORGUNITNAME, (boolean)true) == 0) {
            if (dataEntity != null) {
                String strTempOrgUnitId = dataEntity.GetParamStringValue(TAG_ORGUNITNAME, iDEDataCtrl.getOrgUnitName());
                callParam.setValue((Object)strTempOrgUnitId);
            } else {
                callParam.setValue((Object)iDEDataCtrl.getOrgUnitName());
            }
            callParam.setDataType(25);
            return callParam;
        }
        if (StringHelper.Compare((String)procParam.getParamName(), (String)TAG_ACTIONMODE, (boolean)true) == 0) {
            callParam.setValue((Object)strActionMode);
            callParam.setDataType(25);
            return callParam;
        }
        if (StringHelper.Compare((String)procParam.getParamName(), (String)TAG_ACTIONARG, (boolean)true) == 0) {
            callParam.setValue((Object)dataEntity.GetParamStringValue(TAG_ACTIONARG, ""));
            callParam.setDataType(25);
            return callParam;
        }
        if (StringHelper.Compare((String)procParam.getParamName(), (String)TAG_RD, (boolean)true) == 0) {
            callParam.setDirection(2);
            callParam.setOutputParamName(TAG_RD);
            return callParam;
        }
        if (StringHelper.Compare((String)procParam.getParamName(), (String)TAG_RETCODE, (boolean)true) == 0) {
            callParam.setDirection(2);
            callParam.setDataType(9);
            callParam.setOutputParamName(TAG_RETCODE);
            return callParam;
        }
        if (StringHelper.Compare((String)procParam.getParamName(), (String)TAG_RETINFO, (boolean)true) == 0) {
            callParam.setDirection(2);
            callParam.setDataType(25);
            callParam.setOutputParamName(TAG_RETINFO);
            return callParam;
        }
        if (StringHelper.Compare((String)procParam.getParamName(), (String)TAG_RETINFORES, (boolean)true) == 0) {
            callParam.setDirection(2);
            callParam.setDataType(25);
            callParam.setOutputParamName(TAG_RETINFORES);
            return callParam;
        }
        if (StringHelper.Compare((String)procParam.getParamName(), (String)TAG_RETINFORESARG, (boolean)true) == 0) {
            callParam.setDirection(2);
            callParam.setDataType(25);
            callParam.setOutputParamName(TAG_RETINFORESARG);
            return callParam;
        }
        if (StringHelper.Compare((String)procParam.getParamName(), (String)TAG_DALOG, (boolean)true) == 0) {
            callParam.setDirection(1);
            callParam.setDataType(9);
            if (dataEntity != null) {
                callParam.setValue((Object)dataEntity.GetParamIntValue(TAG_DALOG, 1));
            } else {
                callParam.setValue((Object)1);
            }
            return callParam;
        }
        if (StringHelper.Compare((String)procParam.getParamName(), (String)TAG_CHECKKEY, (boolean)true) == 0) {
            callParam.setDirection(1);
            callParam.setDataType(9);
            if (dataEntity != null) {
                callParam.setValue((Object)dataEntity.GetParamIntValue(TAG_CHECKKEY, 1));
            } else {
                callParam.setValue((Object)1);
            }
            return callParam;
        }
        if (StringHelper.Compare((String)procParam.getParamName(), (String)TAG_RETDATA, (boolean)true) == 0) {
            callParam.setDirection(1);
            callParam.setDataType(9);
            if (dataEntity != null) {
                callParam.setValue((Object)dataEntity.GetParamIntValue(TAG_RETDATA, 1));
            } else {
                callParam.setValue((Object)1);
            }
            return callParam;
        }
        if (StringHelper.Compare((String)procParam.getParamName(), (String)TAG_TAG, (boolean)true) == 0) {
            callParam.setDirection(2);
            callParam.setDataType(25);
            callParam.setOutputParamName(TAG_TAG);
            return callParam;
        }
        return callParam;
    }

    @Override
    public CallResult CustomCall(String strCallName, BaseDataEntity dataEntity) {
        return this.OnCustomCall(strCallName, dataEntity);
    }

    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        Iterator<DEDataCtrl> iterator;
        CallResult callResult = new CallResult();
        callResult.setRetCode(20);
        Vector<DEDataCtrl> dedcs = this.GetDEHelper().GetDEDC(ACTION_CUSTOMCALL, strCallName);
        if (dedcs != null && (iterator = dedcs.iterator()).hasNext()) {
            DEDataCtrl dedc = iterator.next();
            IDEDataCtrlEngine iDEDCEngine = this.GetDEDataCtrlEngine(dedc.getDEDCOBJECT());
            if (iDEDCEngine == null) {
                callResult.setRetCode(1);
                return callResult;
            }
            callResult = iDEDCEngine.CustomCall(dedc, dataEntity, strCallName);
            this.ReleaseDEDataCtrlEngine(dedc.getDEDCOBJECT(), iDEDCEngine);
            return callResult;
        }
        return callResult;
    }

    public static CallResult SelectSingle(ISRFDAGlobalHelper globalHelperEx, String strSQL, BaseDataEntity dataEntity) {
        return BaseDEDataCtrl.SelectSingle(globalHelperEx, strSQL, null, dataEntity);
    }

    public static CallResult SelectSingle(ISRFDAGlobalHelper globalHelperEx, String strSQL, Vector<CallParam> params, BaseDataEntity dataEntity) {
        return BaseDEDataCtrl.SelectSingleEx(globalHelperEx, "", strSQL, params, dataEntity);
    }

    public static CallResult SelectSingleEx(ISRFDAGlobalHelper globalHelperEx, String strDBStorage, String strSQL, BaseDataEntity dataEntity) {
        return BaseDEDataCtrl.SelectSingleEx(globalHelperEx, strDBStorage, strSQL, null, dataEntity);
    }

    public static CallResult SelectSingleEx(ISRFDAGlobalHelper globalHelperEx, String strDBStorage, String strSQL, Vector<CallParam> params, BaseDataEntity dataEntity) {
        return BaseDEDataCtrl.SelectSingleEx(globalHelperEx, null, strDBStorage, strSQL, params, dataEntity);
    }

    public static CallResult SelectSingleEx(ISRFDAGlobalHelper globalHelperEx, Connection connection, String strDBStorage, String strSQL, Vector<CallParam> params, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            SelectResult2 selectResult = BaseDEDataCtrl.SelectMultiExReturnRS(globalHelperEx, connection, strDBStorage, strSQL, params);
            if (selectResult == null || selectResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s\r\n%2$s", (Object)(selectResult == null ? "\u672a\u77e5\u9519\u8bef" : selectResult.getErrorInfo()), (Object)strSQL));
                if (selectResult != null) {
                    callResult.From((DBResult)selectResult);
                } else {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                }
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                selectResult.Close();
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            selectResult.getMainTable().ReadRows(1);
            if (selectResult.getMainTable().GetRowCount() == 0) {
                selectResult.Close();
                callResult.setRetCode(3);
                return callResult;
            }
            dataEntity.FromDataRow(selectResult.getMainTable().GetRow(0));
            callResult.setRetCode(0);
            selectResult.Close();
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u6267\u884c[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strSQL, (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public static CallResult ExecuteWithoutResultEx(ISRFDAGlobalHelper globalHelperEx, String strDBStorage, String strSQL, Vector<CallParam> params) {
        return BaseDEDataCtrl.ExecuteWithoutResultEx(globalHelperEx, null, strDBStorage, strSQL, params);
    }

    public static CallResult ExecuteWithoutResultEx(ISRFDAGlobalHelper globalHelperEx, Connection connection, String strDBStorage, String strSQL, Vector<CallParam> params) {
        CallResult callResult = new CallResult();
        try {
            if (globalHelperEx == null) {
                throw new Exception("\u5168\u5c40\u5bf9\u8c61\u4e3a\u7a7a");
            }
            DBResult dbResult = globalHelperEx.getDBCaller(strDBStorage).CallRaw3WithoutReturn(connection, strSQL, params);
            if (dbResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            callResult.From(dbResult);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u6267\u884c[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strSQL, (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public static CallResult ExecuteWithoutResult(ISRFDAGlobalHelper globalHelperEx, String strSQL, Vector<CallParam> params) {
        return BaseDEDataCtrl.ExecuteWithoutResultEx(globalHelperEx, "", strSQL, params);
    }

    public static SelectResult SelectMulti(ISRFDAGlobalHelper globalHelperEx, String strSQL, Vector<CallParam> params) {
        return BaseDEDataCtrl.SelectMultiEx(globalHelperEx, "", strSQL, params);
    }

    public static SelectResult SelectMultiEx(ISRFDAGlobalHelper globalHelperEx, String strDBStorage, String strSQL, Vector<CallParam> params) {
        try {
            if (globalHelperEx == null) {
                throw new Exception("\u5168\u5c40\u5bf9\u8c61\u4e3a\u7a7a");
            }
            SelectResult selectResult = globalHelperEx.getDBCaller(strDBStorage).CallRaw3(strSQL, params);
            if (selectResult == null) {
                selectResult = new SelectResult();
                selectResult.setRetCode(1);
                selectResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return selectResult;
            }
            return selectResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u6267\u884c[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strSQL, (Object)ex.getMessage()), (Throwable)ex);
            SelectResult selectResult = new SelectResult();
            selectResult.setRetCode(1);
            selectResult.setErrorInfo(ex.getMessage());
            return selectResult;
        }
    }

    public static CallResult SelectMulti(ISRFDAGlobalHelper globalHelperEx, String strSQL, Vector<CallParam> params, Vector list, String strObjectName) {
        return BaseDEDataCtrl.SelectMultiEx(globalHelperEx, "", strSQL, params, list, strObjectName);
    }

    public static CallResult SelectMultiEx(ISRFDAGlobalHelper globalHelperEx, String strDBStorage, String strSQL, Vector<CallParam> params, Vector list, String strObjectName) {
        return BaseDEDataCtrl.SelectMultiEx(globalHelperEx, null, strDBStorage, strSQL, params, list, strObjectName);
    }

    public static CallResult SelectMultiEx(ISRFDAGlobalHelper globalHelperEx, Connection connection, String strDBStorage, String strSQL, Vector<CallParam> params, Vector list, String strObjectName) {
        CallResult callResult = new CallResult();
        try {
            if (globalHelperEx == null) {
                throw new Exception("\u5168\u5c40\u5bf9\u8c61\u4e3a\u7a7a");
            }
            SelectResult selectResult = globalHelperEx.getDBCaller(strDBStorage).CallRaw3(connection, strSQL, params);
            if (selectResult == null) {
                log.error((Object)strSQL);
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                log.error((Object)strSQL);
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            int nRowCount = selectResult.getMainTable().GetRowCount();
            int i = 0;
            while (i < nRowCount) {
                Object obj;
                BaseDataEntity dataEntity = null;
                if (!StringHelper.IsNullOrEmpty((String)strObjectName) && (obj = ObjectHelper.Create((String)strObjectName)) != null && obj instanceof BaseDataEntity) {
                    dataEntity = (BaseDataEntity)obj;
                }
                if (dataEntity == null) {
                    dataEntity = new BaseDataEntity();
                }
                dataEntity.FromDataRow(selectResult.getMainTable().GetRow(i));
                list.add(dataEntity);
                ++i;
            }
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u6267\u884c[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strSQL, (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public static SelectResult2 SelectMultiExReturnRS(ISRFDAGlobalHelper globalHelperEx, Connection connection, String strDBStorage, String strSQL, Vector<CallParam> params) {
        try {
            if (globalHelperEx == null) {
                throw new Exception("\u5168\u5c40\u5bf9\u8c61\u4e3a\u7a7a");
            }
            SelectResult2 selectResult = globalHelperEx.getDBCaller(strDBStorage).CallRaw3ReturnRS(connection, strSQL, params);
            return selectResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u6267\u884c[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strSQL, (Object)ex.getMessage()), (Throwable)ex);
            return null;
        }
    }

    public static CallResult SelectMulti(ISRFDAGlobalHelper globalHelperEx, String strSQL, Vector list, String strObjectName) {
        return BaseDEDataCtrl.SelectMultiEx(globalHelperEx, "", strSQL, list, strObjectName);
    }

    public static CallResult SelectMultiEx(ISRFDAGlobalHelper globalHelperEx, String strDBStorage, String strSQL, Vector list, String strObjectName) {
        CallResult callResult = new CallResult();
        try {
            if (globalHelperEx == null) {
                throw new Exception("\u5168\u5c40\u5bf9\u8c61\u4e3a\u7a7a");
            }
            SelectResult selectResult = globalHelperEx.getDBCaller(strDBStorage).CallRaw2(strSQL);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            int nRowCount = selectResult.getMainTable().GetRowCount();
            int i = 0;
            while (i < nRowCount) {
                Object obj;
                BaseDataEntity dataEntity = null;
                if (!StringHelper.IsNullOrEmpty((String)strObjectName) && (obj = ObjectHelper.Create((String)strObjectName)) != null && obj instanceof BaseDataEntity) {
                    dataEntity = (BaseDataEntity)obj;
                }
                if (dataEntity == null) {
                    dataEntity = new BaseDataEntity();
                }
                dataEntity.FromDataRow(selectResult.getMainTable().GetRow(i));
                list.add(dataEntity);
                ++i;
            }
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u6267\u884c[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strSQL, (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult GetProcParams(String strProcName, Vector<ProcParam> params) {
        return this.GetDEHelper().GetProcParams(strProcName, params);
    }

    @Override
    public CallResult Export(BaseDataEntity baseDataEntity, Vector<XMLNode> list, boolean bGetData, boolean bFrameOnly) {
        CallResult callResult;
        if (bGetData && (callResult = this.Get(baseDataEntity)).getRetCode() != 0) {
            return callResult;
        }
        return this.OnExport(baseDataEntity, list, bFrameOnly);
    }

    protected CallResult OnExport(BaseDataEntity baseDataEntity, Vector<XMLNode> list, boolean bFrameOnly) {
        if (this.GetDEHelper().IsIndexDE()) {
            IDEDataCtrl minorDEDataCtrl;
            CallResult callResult = new CallResult();
            String strTypeValue = baseDataEntity.GetParamStringValue(this.GetDEHelper().GetIndexTypeDEFHelper().getName(), "");
            DERINDEX derIndex = this.GetDEHelper().FindDERINDEX(strTypeValue);
            if (derIndex == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7d22\u5f15\u5b9e\u4f53[%1$s]\u5bf9\u5e94\u7684\u7d22\u5f15\u7c7b\u578b[%2$s]", (Object)this.GetDEHelper().getId(), (Object)strTypeValue));
                return callResult;
            }
            try {
                minorDEDataCtrl = this.GetRelatedDataCtrl(derIndex.getDEID());
            }
            catch (Exception e) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)derIndex.getDEID()));
                return callResult;
            }
            BaseDataEntity realDataEntity = new BaseDataEntity();
            realDataEntity.SetParamValue(minorDEDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), baseDataEntity.GetParamValue(this.GetDEHelper().GetKeyDEFHelper().getName()));
            return minorDEDataCtrl.Export(realDataEntity, list, true, bFrameOnly);
        }
        return BaseDEDataCtrl.Export(this, baseDataEntity, list, bFrameOnly);
    }

    protected static CallResult Export(IDEDataCtrl iDEDataCtrl, BaseDataEntity baseDataEntity, Vector<XMLNode> list, boolean bFrameOnly) {
        CallResult callResult = new CallResult();
        String strValue = BaseDataEntity.ToString((BaseDataEntity)baseDataEntity, (boolean)iDEDataCtrl.GetDEHelper().IsExportIncEmpty());
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            return callResult;
        }
        XMLNode xmlNode = new XMLNode();
        xmlNode.SetValue("SRFDEID", iDEDataCtrl.GetDEHelper().getId());
        xmlNode.SetValue("SRFVALUE", strValue);
        list.add(xmlNode);
        Vector<DER1N> der1Ns = iDEDataCtrl.GetDEHelper().GetDER1Ns(true);
        if (der1Ns.size() > 0) {
            Vector<DER1N> exportDER1Ns = new Vector<DER1N>();
            for (DER1N der1n : der1Ns) {
                if (der1n.getEXPORTORDER() < 0) continue;
                boolean bAdd = false;
                int i = 0;
                while (i < exportDER1Ns.size()) {
                    DER1N exportDER1N = (DER1N)((Object)exportDER1Ns.get(i));
                    if (exportDER1N.getEXPORTORDER() > der1n.getEXPORTORDER()) {
                        exportDER1Ns.add(i, der1n);
                        bAdd = true;
                        break;
                    }
                    ++i;
                }
                if (bAdd) continue;
                exportDER1Ns.add(der1n);
            }
            for (DER1N der1n : exportDER1Ns) {
                IDEDataCtrl minorDEDataCtrl;
                IDEHelper minorDEHelper = iDEDataCtrl.getGlobalHelper().getDAModelStorage().FindDEHelper(der1n.getMINORDEID());
                if (minorDEHelper == null) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)der1n.getMINORDEID()));
                    return callResult;
                }
                BaseDataEntity cond = new BaseDataEntity();
                cond.SetParamValue(der1n.getMAJORKEYDEFNAME(), baseDataEntity.GetParamValue(iDEDataCtrl.GetDEHelper().GetKeyDEFHelper().getName()));
                try {
                    minorDEDataCtrl = iDEDataCtrl.GetRelatedDataCtrl(minorDEHelper.getId());
                }
                catch (Exception e) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8f85\u52a9\u5bf9\u8c61", (Object)der1n.getMINORDEID()));
                    return callResult;
                }
                Vector<BaseDataEntity> dataEntities = new Vector<BaseDataEntity>();
                String strExtCondition = "((SRFUSERPUB IS NOT NULL AND SRFUSERPUB=1) OR ((SRFSYSPUB IS NULL OR SRFSYSPUB=1) AND (SRFUSERPUB IS NULL OR SRFUSERPUB<>0)))";
                callResult = minorDEDataCtrl.GetDEHelper().GetDEFHelper("SRFUSERPUB") == null ? minorDEDataCtrl.Select(cond, dataEntities) : minorDEDataCtrl.Select(cond, dataEntities, "", strExtCondition, "");
                if (callResult.IsError()) {
                    return callResult;
                }
                if (der1n.getSYNCMODEL()) {
                    String strMinorKeyField = minorDEDataCtrl.GetDEHelper().GetKeyDEFHelper().getName();
                    String strMinorKeys = "";
                    for (BaseDataEntity dataEntity : dataEntities) {
                        if (!StringHelper.IsNullOrEmpty((String)strMinorKeys)) {
                            strMinorKeys = String.valueOf(strMinorKeys) + ";";
                        }
                        strMinorKeys = String.valueOf(strMinorKeys) + dataEntity.GetParamStringValue(strMinorKeyField, "");
                    }
                    XMLNode xmlNode2 = new XMLNode();
                    xmlNode2.SetValue("SRFDEID", iDEDataCtrl.GetDEHelper().getId());
                    xmlNode2.SetValue("SRFDER1NSYNC", "TRUE");
                    xmlNode2.SetValue("SRFDER1NID", der1n.getDERID());
                    xmlNode2.SetValue("SRFARG", baseDataEntity.GetParamStringValue(iDEDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), ""));
                    xmlNode2.SetValue("SRFARG2", strMinorKeys);
                    list.add(xmlNode2);
                }
                for (BaseDataEntity dataEntity : dataEntities) {
                    minorDEDataCtrl.Export(dataEntity, list, false, bFrameOnly);
                }
            }
        }
        return callResult;
    }

    @Override
    public CallResult Import(XMLNode xmlNode) {
        String strActionMode;
        BaseDataEntity importDataEntity2;
        this.bImportMode = true;
        String strValue = xmlNode.GetExtValue("SRFVALUE", "");
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            String strDBType;
            String strCustomCall = xmlNode.GetExtValue("SRFCUSTOMCALL", "");
            if (!StringHelper.IsNullOrEmpty((String)strCustomCall)) {
                strValue = xmlNode.GetExtValue("SRFARG", "");
                if (StringHelper.IsNullOrEmpty((String)strValue)) {
                    return this.CustomCall(strCustomCall, new BaseDataEntity());
                }
                return this.CustomCall(strCustomCall, BaseDataEntity.FromString((String)strValue));
            }
            String strRemoveCall = xmlNode.GetExtValue("SRFREMOVE", "");
            if (StringHelper.Compare((String)strRemoveCall, (String)"TRUE", (boolean)true) == 0) {
                strValue = xmlNode.GetExtValue("SRFARG", "");
                BaseDataEntity dataEntity = new BaseDataEntity();
                dataEntity.SetParamValue(this.GetDEHelper().GetKeyDEFHelper().getName(), (Object)strValue);
                return this.Remove(dataEntity);
            }
            String strDER1NSync = xmlNode.GetExtValue("SRFDER1NSYNC", "");
            if (StringHelper.Compare((String)strDER1NSync, (String)"TRUE", (boolean)true) == 0) {
                return this.OnSyncDER1NData(xmlNode.GetExtValue("SRFDER1NID", ""), xmlNode.GetExtValue("SRFARG", ""), xmlNode.GetExtValue("SRFARG2", ""));
            }
            String strSQLPatch = xmlNode.GetExtValue("SRFSQLPATCH", "");
            if (StringHelper.Compare((String)strSQLPatch, (String)"TRUE", (boolean)true) == 0 && (StringHelper.IsNullOrEmpty((String)(strDBType = xmlNode.GetExtValue("DBTYPE", ""))) || StringHelper.Compare((String)strDBType, (String)this.GetDEHelper().GetDBType(), (boolean)true) == 0)) {
                CallResult callResult = new CallResult();
                String strCheckCode = xmlNode.GetExtValue("CHECKCODE", "");
                String strSQLCode = xmlNode.GetExtValue("SQLCODE", "");
                String strSQLCode2 = xmlNode.GetExtValue("SQLCODE2", "");
                try {
                    if (!StringHelper.IsNullOrEmpty((String)strCheckCode)) {
                        BaseDataEntity rowCount = new BaseDataEntity();
                        callResult = BaseDEDataCtrl.SelectSingleEx(this.globalHelperEx, this.GetDEHelper().GetDBStorage(), strCheckCode, rowCount);
                        if (callResult.getRetCode() != 0) {
                            log.error((Object)callResult.getErrorInfo());
                            log.debug((Object)strCheckCode);
                            return callResult;
                        }
                        int nRowCnt = rowCount.GetParamIntValue("ROWCOUNT", 0);
                        if (nRowCnt != 0) {
                            return callResult;
                        }
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strSQLCode) && (callResult = BaseDEDataCtrl.ExecuteWithoutResultEx(this.globalHelperEx, this.GetDEHelper().GetDBStorage(), strSQLCode, null)).getRetCode() != 0) {
                        log.error((Object)callResult.getErrorInfo());
                        log.debug((Object)strSQLCode);
                        return callResult;
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strSQLCode2) && (callResult = BaseDEDataCtrl.ExecuteWithoutResultEx(this.globalHelperEx, this.GetDEHelper().GetDBStorage(), strSQLCode2, null)).getRetCode() != 0) {
                        log.error((Object)callResult.getErrorInfo());
                        log.debug((Object)strSQLCode2);
                        return callResult;
                    }
                }
                catch (Exception ex) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884c\u6570\u636e\u5e93\u8865\u4e01\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                    log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
                    return callResult;
                }
            }
            return new CallResult();
        }
        String strValueEx = xmlNode.GetExtValue("SRFVALUEEX", "");
        BaseDataEntity importDataEntity = BaseDataEntity.FromString((String)strValue);
        if (!StringHelper.IsNullOrEmpty((String)strValueEx) && (importDataEntity2 = BaseDataEntity.FromJSONString((String)strValueEx)) != null) {
            importDataEntity2.CopyTo(importDataEntity, false);
        }
        if (StringHelper.IsNullOrEmpty((String)(strActionMode = xmlNode.GetExtValue("SRFACTIONMODE", "")))) {
            return this.OnImport(importDataEntity);
        }
        return this.OnImport(importDataEntity, strActionMode);
    }

    protected CallResult OnSyncDER1NData(String strDER1NId, String strKey, String strDatas) {
        return BaseDEDataCtrl.SyncDER1NData(this, strDER1NId, strKey, strDatas);
    }

    protected static CallResult SyncDER1NData(IDEDataCtrl iDataCtrl, String strDER1NId, String strKey, String strDatas) {
        CallResult callResult = new CallResult();
        Hashtable<String, String> syncDataMap = new Hashtable<String, String>();
        String[] datas = StringHelper.SplitEx((String)strDatas);
        if (datas != null) {
            int i = 0;
            while (i < datas.length) {
                if (!StringHelper.IsNullOrEmpty((String)datas[i])) {
                    syncDataMap.put(datas[i], "");
                }
                ++i;
            }
        }
        DER1N der1N = new DER1N();
        callResult = iDataCtrl.getGlobalHelper().getDAModelHelper().GetDER1N(strDER1NId, der1N);
        if (callResult.IsError()) {
            return callResult;
        }
        IDEDataCtrl minorDataCtrl = iDataCtrl.getGlobalHelper().getDAModelStorage().FindDEDataCtrlEx(der1N.getMINORDEID(), iDataCtrl);
        if (minorDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)der1N.getMINORDEID()));
            return callResult;
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.SetParamValue(der1N.getMAJORKEYDEFNAME(), minorDataCtrl.GetDEHelper().GetDEFHelper(der1N.getMAJORKEYDEFNAME()).GetDEFValue(strKey));
        Vector<BaseDataEntity> der1nDatas = new Vector<BaseDataEntity>();
        callResult = minorDataCtrl.Select(cond, der1nDatas);
        if (callResult.IsError()) {
            return callResult;
        }
        Vector<BaseDataEntity> removeDatas = new Vector<BaseDataEntity>();
        String strMinorKeyField = minorDataCtrl.GetDEHelper().GetKeyDEFHelper().getName();
        for (BaseDataEntity item : der1nDatas) {
            String strItemKey = item.GetParamStringValue(strMinorKeyField, "");
            if (syncDataMap.containsKey(strItemKey)) continue;
            removeDatas.add(item);
        }
        if (removeDatas.size() == 0) {
            return callResult;
        }
        if (minorDataCtrl.GetDEHelper().IsIndexDE()) {
            Vector<DERINDEX> derIndexList = null;
            TreeMap<String, DERINDEX> derIndexMap = null;
            TreeMap<String, IDEDataCtrl> deDataCtrlMap = null;
            derIndexList = minorDataCtrl.GetDEHelper().GetDERINDEXs(true);
            derIndexMap = new TreeMap<String, DERINDEX>();
            deDataCtrlMap = new TreeMap<String, IDEDataCtrl>();
            for (DERINDEX derIndex : derIndexList) {
                derIndexMap.put(derIndex.getTYPEVALUE(), derIndex);
            }
            for (BaseDataEntity item : removeDatas) {
                String strType = item.GetParamStringValue(minorDataCtrl.GetDEHelper().GetIndexTypeDEFHelper().getName(), "");
                if (!derIndexMap.containsKey(strType)) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7d22\u5f15\u5b9e\u4f53[%1$s]\u7c7b\u578b\u503c[%2$s]", (Object)minorDataCtrl.GetDEHelper().getId(), (Object)strType));
                    return callResult;
                }
                IDEDataCtrl iRealDataCtrl = null;
                DERINDEX derIndex = (DERINDEX)((Object)derIndexMap.get(strType));
                if (deDataCtrlMap.containsKey(derIndex.getDEID())) {
                    iRealDataCtrl = (IDEDataCtrl)deDataCtrlMap.get(derIndex.getDEID());
                } else {
                    iRealDataCtrl = minorDataCtrl.getGlobalHelper().getDAModelStorage().FindDEDataCtrlEx(derIndex.getDEID(), minorDataCtrl);
                    deDataCtrlMap.put(derIndex.getDEID(), iRealDataCtrl);
                }
                Object objKey = item.GetParamValue(strMinorKeyField);
                item.SetParamValue(iRealDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), objKey);
                callResult = iRealDataCtrl.Remove(item);
                if (!callResult.IsError()) continue;
                return callResult;
            }
        } else {
            for (BaseDataEntity item : removeDatas) {
                callResult = minorDataCtrl.Remove(item);
                if (!callResult.IsError()) continue;
                return callResult;
            }
        }
        return callResult;
    }

    protected CallResult OnImport(BaseDataEntity baseDataEntity) {
        return this.OnImport(baseDataEntity, ACTIONMODE_DEFAULT);
    }

    protected CallResult OnImport(BaseDataEntity baseDataEntity, String strActionMode) {
        CallResult callResult = this.CheckKeyState(baseDataEntity);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        Integer nValue = (Integer)callResult.getUserObject();
        if (nValue == 2) {
            callResult.setUserObject((Object)baseDataEntity);
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"[%1$s]\u6570\u636e[%2$s]\u5df2\u7ecf\u88ab\u5220\u9664\uff0c\u65e0\u6cd5\u5bfc\u5165", (Object)this.iDEHelper.getName(), (Object)baseDataEntity.get(this.iDEHelper.GetMajorDEFHelper().getName())));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        if (!this.OnTestImport(nValue == 0, baseDataEntity)) {
            callResult.setUserObject((Object)baseDataEntity);
            return callResult;
        }
        Vector<ValueError> err = new Vector<ValueError>();
        callResult = this.TestSave(nValue == 0, baseDataEntity, err);
        if (callResult.getRetCode() != 0) {
            callResult.setUserObject((Object)baseDataEntity);
            callResult.setErrorInfo(StringHelper.Format((String)"[%1$s]\u6570\u636e[%2$s]\u65e0\u6cd5\u5bfc\u5165\uff0c\u4fdd\u5b58\u68c0\u67e5\u5931\u8d25\uff0c%3$s", (Object)this.iDEHelper.getName(), (Object)baseDataEntity.get(this.iDEHelper.GetMajorDEFHelper().getName()), (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        if (nValue == 1) {
            Object objIgnorePatchs = this.GetDEHelper().GetAttribute("SRFIGNOREPATCHS");
            Vector<IgnorePatch> ignorePatchs = null;
            if (objIgnorePatchs != null) {
                ignorePatchs = (Vector<IgnorePatch>)objIgnorePatchs;
            } else {
                String strDataKey = baseDataEntity.GetParamStringValue(this.GetDEHelper().GetKeyDEFHelper().getName(), "");
                ignorePatchs = new Vector<IgnorePatch>();
                callResult = this.globalHelperEx.getDAModelHelper().GetIgnorePatchs(this.GetDEHelper().getId(), strDataKey, ignorePatchs);
                if (callResult.IsError()) {
                    callResult.setUserObject((Object)baseDataEntity);
                    callResult.setErrorInfo(StringHelper.Format((String)"[%1$s]\u6570\u636e[%2$s]\u65e0\u6cd5\u5bfc\u5165\uff0c\u83b7\u53d6\u5ffd\u7565\u5bfc\u5165\u8865\u4e01\u5931\u8d25\uff0c%3$s", (Object)this.iDEHelper.getName(), (Object)baseDataEntity.get(this.iDEHelper.GetMajorDEFHelper().getName()), (Object)callResult.getErrorInfo()));
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                this.GetDEHelper().SetAttribute("SRFIGNOREPATCHS", ignorePatchs);
            }
            for (IgnorePatch ignorePatch : ignorePatchs) {
                String strIgnoreFields = ignorePatch.getIGNOREFIELDS();
                if (StringHelper.Compare((String)strIgnoreFields, (String)"*", (boolean)true) == 0) {
                    callResult.setUserObject((Object)baseDataEntity);
                    return callResult;
                }
                baseDataEntity.RemoveParams(strIgnoreFields);
            }
        }
        if ((callResult = this.Save(nValue == 0, strActionMode, baseDataEntity)).getRetCode() != 0) {
            callResult.setUserObject((Object)baseDataEntity);
            callResult.setErrorInfo(StringHelper.Format((String)"[%1$s]\u6570\u636e[%2$s]\u65e0\u6cd5\u5bfc\u5165\uff0c\u4fdd\u5b58\u5931\u8d25\uff0c%3$s", (Object)this.iDEHelper.getName(), (Object)baseDataEntity.get(this.iDEHelper.GetMajorDEFHelper().getName()), (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult.setUserObject((Object)baseDataEntity);
        return callResult;
    }

    protected boolean OnTestImport(boolean bInsert, BaseDataEntity baseDataEntity) {
        return true;
    }

    @Override
    public void SetDataLockKey(String strDataLockKey) {
        this.strDataLockKey = strDataLockKey;
    }

    @Override
    public String GetDataLockKey() {
        return this.GetDataLockKey(null);
    }

    @Override
    public String GetDataLockKey(BaseDataEntity dataEntity) {
        if (dataEntity != null && dataEntity.ContainesParam(TAG_DATALOCKKEY)) {
            return dataEntity.GetParamStringValue(TAG_DATALOCKKEY, "");
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strDataLockKey)) {
            return this.strDataLockKey;
        }
        return StringHelper.Format((String)"UID:%1$s", (Object)this.strCurOpPersonId);
    }

    protected DataLockDataCtrl GetDataLockDataCtrl() {
        if (this.dataLockDataCtrl != null) {
            return this.dataLockDataCtrl;
        }
        this.dataLockDataCtrl = this.globalHelperEx.getDAModelStorage().GetDataLockDataCtrl();
        return this.dataLockDataCtrl;
    }

    protected static CallResult FillDBActionParam(IDEDataCtrl iDEDataCtrl, String strAction, String strActionMode, BaseDataEntity baseDataEntity) {
        DBAction dbAction;
        CallResult callResult = iDEDataCtrl.GetDEHelper().GetDBAction(strAction, strActionMode);
        if (callResult.getRetCode() == 3) {
            callResult.setRetCode(0);
            return callResult;
        }
        if (callResult.getRetCode() == 0 && (dbAction = (DBAction)((Object)callResult.getUserObject())).getActionParams() != null) {
            return BaseDEDataCtrl.FillDataEntityParams(iDEDataCtrl, dbAction.getActionParams(), baseDataEntity);
        }
        return callResult;
    }

    protected static CallResult FillDataEntityParams(IDEDataCtrl iDEDataCtrl, Properties properties, BaseDataEntity baseDataEntity) {
        CallResult callResult = new CallResult();
        if (properties != null) {
            for (Object objKey : properties.keySet()) {
                String strValue;
                String strKey = objKey.toString();
                callResult = BaseDEDataCtrl.FillDataEntityParam(iDEDataCtrl, baseDataEntity, strKey, strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey));
                if (callResult.getRetCode() == 0) continue;
                return callResult;
            }
        }
        return callResult;
    }

    protected static CallResult FillDataEntityParam(IDEDataCtrl iDEDataCtrl, BaseDataEntity baseDataEntity, String strKey, String strValue) {
        CallResult callResult = MacroHelper.GetValue(strValue, iDEDataCtrl.getWebContext(), iDEDataCtrl.getGlobalHelper(), iDEDataCtrl.getOPPersonId(), baseDataEntity);
        if (callResult.getRetCode() != 0) {
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6307\u5b9a\u503c[%1$s],%2$s", (Object)strValue, (Object)callResult.getErrorInfo()));
            callResult.setRetCode(1);
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        Object obj = callResult.getUserObject();
        if (obj == null) {
            baseDataEntity.SetParamValue(strKey, obj);
        } else if (obj instanceof String) {
            strValue = obj.toString();
            if (MacroHelper.isRemoveFunc(strValue)) {
                baseDataEntity.RemoveParam(strKey);
            } else if (StringHelper.IsNullOrEmpty((String)strValue)) {
                baseDataEntity.SetParamValue(strKey, null);
            } else {
                IDEFHelper iDEFHelper = iDEDataCtrl.GetDEHelper().GetDEFHelper(strKey);
                if (iDEFHelper != null && (obj = DataTypeParse.Parse((String)iDEFHelper.GetStdDataType(), (String)strValue)) == null) {
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8f6c\u6362\u6307\u5b9a\u503c[%1$s]\u81f3\u7c7b\u578b[%2$s]", (Object)strValue, (Object)iDEFHelper.GetStdDataType()));
                    callResult.setRetCode(1);
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                baseDataEntity.SetParamValue(strKey, obj);
            }
        } else {
            baseDataEntity.SetParamValue(strKey, obj);
        }
        return callResult;
    }

    @Override
    public void RemoveUncopyValue(BaseDataEntity dataEntity) {
        this.GetDEHelper().RemoveUncopyValue(dataEntity);
    }

    @Override
    public CallResult PrepareMethod(boolean bReCreate) {
        return this.OnPrepareMethod(bReCreate);
    }

    protected CallResult OnPrepareMethod(boolean bReCreate) {
        return this.GetDEHelper().PrepareDBProc(bReCreate);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IDEDataCtrlEngine GetDEDataCtrlEngine(String strObject) {
        if (StringHelper.IsNullOrEmpty((String)strObject)) {
            strObject = this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "DEDCENGINE", "SA.SRFDA.DEDC.Ctrl.DefaultDEDCEngine");
        }
        if (this.deDataCtrlEngineMap != null) {
            Hashtable<String, IDEDataCtrlEngine> hashtable = this.deDataCtrlEngineMap;
            synchronized (hashtable) {
                if (this.deDataCtrlEngineMap.containsKey(strObject)) {
                    return this.deDataCtrlEngineMap.remove(strObject);
                }
                if (this.deDataCtrlEngineMap.containsKey("_1_" + strObject)) {
                    return this.deDataCtrlEngineMap.remove("_1_" + strObject);
                }
            }
        }
        IDEDataCtrlEngine iDEDataCtrlEngine = null;
        Object objDEDataCtrlEngine = ObjectHelper.Create((String)strObject);
        if (objDEDataCtrlEngine == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5bf9\u8c61[%1$s]", (Object)strObject));
            return null;
        }
        if (!(objDEDataCtrlEngine instanceof IDEDataCtrlEngine)) {
            log.error((Object)StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strObject));
            return null;
        }
        iDEDataCtrlEngine = (IDEDataCtrlEngine)objDEDataCtrlEngine;
        iDEDataCtrlEngine.Init(this, this.globalHelperEx);
        return iDEDataCtrlEngine;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void ReleaseDEDataCtrlEngine(String strObject, IDEDataCtrlEngine iDEDataCtrlEngine) {
        if (StringHelper.IsNullOrEmpty((String)strObject)) {
            strObject = this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "DEDCENGINE", "SA.SRFDA.DEDC.Ctrl.DefaultDEDCEngine");
        }
        if (this.deDataCtrlEngineMap == null) {
            this.deDataCtrlEngineMap = new Hashtable();
        }
        Hashtable<String, IDEDataCtrlEngine> hashtable = this.deDataCtrlEngineMap;
        synchronized (hashtable) {
            if (!this.deDataCtrlEngineMap.containsKey(strObject)) {
                this.deDataCtrlEngineMap.put(strObject, iDEDataCtrlEngine);
                return;
            }
            if (!this.deDataCtrlEngineMap.containsKey("_1_" + strObject)) {
                this.deDataCtrlEngineMap.put("_1_" + strObject, iDEDataCtrlEngine);
                return;
            }
        }
    }

    protected static void FillCallResult(CallResult callResult, DBResult result) {
        Object objRetCode = result.getOutValues().get(TAG_RETCODE);
        Object objRetInfo = result.getOutValues().get(TAG_RETINFO);
        Object objRetInfoRes = result.getOutValues().get(TAG_RETINFORES);
        Object objRetInfoResArg = result.getOutValues().get(TAG_RETINFORESARG);
        if (objRetCode != null) {
            callResult.setRetCode(Integer.parseInt(objRetCode.toString()));
        }
        if (objRetInfo != null) {
            callResult.setErrorInfo(objRetInfo.toString());
        }
        if (objRetInfoRes != null) {
            callResult.setErrorInfoRes(objRetInfoRes.toString());
        }
        if (objRetInfoResArg != null) {
            callResult.setErrorInfoResArg(objRetInfoResArg.toString());
        }
    }

    protected void FillCallResultEx(CallResult callResult) {
        if (StringHelper.IsNullOrEmpty((String)callResult.getErrorInfoRes())) {
            return;
        }
        try {
            String strErrorInfoFormat = this.globalHelperEx.getLocalizationHelper().GetLocalization(this.strLanguage, callResult.getErrorInfoRes(), "");
            if (StringHelper.IsNullOrEmpty((String)strErrorInfoFormat)) {
                return;
            }
            String strErrorInfoResArg = callResult.getErrorInfoResArg();
            if (!StringHelper.IsNullOrEmpty((String)strErrorInfoResArg)) {
                String[] ResArgs = strErrorInfoResArg.split("[|]");
                Object[] args = new Object[ResArgs.length];
                int i = 0;
                while (i < ResArgs.length) {
                    args[i] = this.GetLanguageResArg(ResArgs[i]);
                    ++i;
                }
                callResult.setErrorInfo(StringHelper.Format((String)strErrorInfoFormat, (Object[])args));
                return;
            }
            callResult.setErrorInfo(strErrorInfoFormat);
            return;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return;
        }
    }

    protected Object GetLanguageResArg(String strResArg) {
        if (StringHelper.IsNullOrEmpty((String)strResArg)) {
            return strResArg;
        }
        IDEFHelper iDEFHelper = this.GetDEHelper().GetDEFHelper(strResArg);
        if (iDEFHelper != null) {
            return iDEFHelper.getLogicName(this.strLanguage);
        }
        return strResArg;
    }

    public static void SetCallParamDALog(BaseDataEntity dataEntity, boolean bDALog) {
        dataEntity.SetParamValue(TAG_DALOG, (Object)(bDALog ? 1 : 0));
    }

    public static void SetCallParamCheckKey(BaseDataEntity dataEntity, boolean bCheck) {
        dataEntity.SetParamValue(TAG_CHECKKEY, (Object)(bCheck ? 1 : 0));
    }

    public static void SetCallParamRetData(BaseDataEntity dataEntity, boolean bRetData) {
        dataEntity.SetParamValue(TAG_RETDATA, (Object)(bRetData ? 1 : 0));
    }

    private Hashtable<String, Object> GetAttributeMap() {
        Hashtable<String, Object> attributeMap = this.attributeMap.get();
        if (attributeMap != null) {
            return attributeMap;
        }
        attributeMap = new Hashtable();
        this.attributeMap.set(attributeMap);
        return attributeMap;
    }

    @Override
    public Object GetAttribute(String strKey) {
        return this.GetAttributeMap().get(strKey.toUpperCase());
    }

    @Override
    public void SetAttribute(String strKey, Object obj) {
        strKey = strKey.toUpperCase();
        if (obj == null) {
            this.GetAttributeMap().remove(strKey);
        } else {
            this.GetAttributeMap().put(strKey, obj);
        }
    }

    @Override
    public void ResetAttributes() {
        this.GetAttributeMap().clear();
    }

    @Override
    public CallResult Execute(String strDEActionId, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        DEAction deAction = this.GetDEHelper().GetDEAction(strDEActionId);
        if (deAction == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u64cd\u4f5c\u884c\u4e3a[%1$s]", (Object)strDEActionId));
            return callResult;
        }
        return this.Execute(deAction, dataEntity);
    }

    protected CallResult OnTestDataAction(BaseDataEntity dataEntity, String strAction, boolean bDataLock) {
        CallResult callResult;
        if (this.getWebContext() != null && (callResult = this.GetDEHelper().GetDataAccHelper().Test(this.getWebContext(), dataEntity, strAction)).getRetCode() != 0) {
            return callResult;
        }
        if (bDataLock) {
            return this.TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
        }
        return new CallResult();
    }

    protected static String GetDEActionDataAction(DEAction deAction, String strDefault) {
        if (StringHelper.IsNullOrEmpty((String)deAction.getTESTDATAACTION())) {
            return "";
        }
        if (StringHelper.Compare((String)deAction.getTESTDATAACTION(), (String)"NONE", (boolean)true) == 0) {
            return "";
        }
        if (StringHelper.Compare((String)deAction.getTESTDATAACTION(), (String)ACTIONMODE_DEFAULT, (boolean)true) == 0) {
            return strDefault;
        }
        return deAction.getCUSTOMDATAACTION();
    }

    protected static String GetUpdateDataAction(String strAction) {
        if (StringHelper.IsNullOrEmpty((String)strAction) || StringHelper.Compare((String)strAction, (String)ACTIONMODE_DEFAULT, (boolean)true) == 0 || StringHelper.Compare((String)strAction, (String)"WFACTION", (boolean)true) == 0) {
            strAction = ACTION_UPDATE;
        }
        return strAction;
    }

    @Override
    public CallResult Execute(DEAction deAction, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        if (deAction.getActionParams() != null && (callResult = BaseDEDataCtrl.FillDataEntityParams(this, deAction.getActionParams(), dataEntity)).IsError()) {
            return callResult;
        }
        if (StringHelper.Compare((String)deAction.getACTIONTYPE(), (String)ACTION_CUSTOMCALL, (boolean)true) == 0) {
            String strDataAction = BaseDEDataCtrl.GetDEActionDataAction(deAction, "");
            if (!StringHelper.IsNullOrEmpty((String)strDataAction) && (callResult = this.OnTestDataAction(dataEntity, strDataAction, true)).IsError()) {
                return callResult;
            }
            return this.CustomCall(deAction.getACTIONMODE(), dataEntity);
        }
        if (StringHelper.Compare((String)deAction.getACTIONTYPE(), (String)ACTION_INSERT, (boolean)true) == 0) {
            String strDataAction = BaseDEDataCtrl.GetDEActionDataAction(deAction, "CREATE");
            if (!StringHelper.IsNullOrEmpty((String)strDataAction) && (callResult = this.OnTestDataAction(dataEntity, strDataAction, false)).IsError()) {
                return callResult;
            }
            return this.Save(true, deAction.getACTIONMODE(), dataEntity);
        }
        if (StringHelper.Compare((String)deAction.getACTIONTYPE(), (String)ACTION_UPDATE, (boolean)true) == 0) {
            String strDataAction = BaseDEDataCtrl.GetDEActionDataAction(deAction, BaseDEDataCtrl.GetUpdateDataAction(deAction.getACTIONMODE()));
            if (!StringHelper.IsNullOrEmpty((String)strDataAction) && (callResult = this.OnTestDataAction(dataEntity, strDataAction, true)).IsError()) {
                return callResult;
            }
            return this.Save(false, deAction.getACTIONMODE(), dataEntity);
        }
        if (StringHelper.Compare((String)deAction.getACTIONTYPE(), (String)"SAVE", (boolean)true) == 0) {
            String strDataAction;
            String strKeyValue = dataEntity.GetParamStringValue(this.GetDEHelper().GetKeyDEFHelper().getName(), "");
            boolean bInsert = StringHelper.IsNullOrEmpty((String)strKeyValue);
            if (!bInsert) {
                BaseDataEntity checkkeyparam = new BaseDataEntity();
                dataEntity.CopyTo(checkkeyparam, true);
                callResult = this.CheckKeyState(checkkeyparam);
                if (callResult.getRetCode() != 0 || callResult.getUserObject() == null) {
                    callResult.setRetCode(1);
                    return callResult;
                }
                int nState = (Integer)callResult.getUserObject();
                if (nState == 0) {
                    bInsert = true;
                } else if (nState == 1) {
                    bInsert = false;
                } else {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u8981\u4fdd\u5b58\u7684\u6570\u636e[%1$s]\u5df2\u7ecf\u88ab\u5220\u9664", (Object)strKeyValue));
                    return callResult;
                }
            }
            if (bInsert) {
                strDataAction = BaseDEDataCtrl.GetDEActionDataAction(deAction, "CREATE");
                if (!StringHelper.IsNullOrEmpty((String)strDataAction) && (callResult = this.OnTestDataAction(dataEntity, strDataAction, false)).IsError()) {
                    return callResult;
                }
                return this.Save(true, deAction.getACTIONMODE(), dataEntity);
            }
            strDataAction = BaseDEDataCtrl.GetDEActionDataAction(deAction, BaseDEDataCtrl.GetUpdateDataAction(deAction.getACTIONMODE()));
            if (!StringHelper.IsNullOrEmpty((String)strDataAction) && (callResult = this.OnTestDataAction(dataEntity, strDataAction, true)).IsError()) {
                return callResult;
            }
            return this.Save(false, deAction.getACTIONMODE(), dataEntity);
        }
        if (StringHelper.Compare((String)deAction.getACTIONTYPE(), (String)"DELETE", (boolean)true) == 0) {
            String strDataAction = BaseDEDataCtrl.GetDEActionDataAction(deAction, "DELETE");
            if (!StringHelper.IsNullOrEmpty((String)strDataAction) && (callResult = this.OnTestDataAction(dataEntity, strDataAction, true)).IsError()) {
                return callResult;
            }
            return this.Remove(deAction.getACTIONMODE(), dataEntity);
        }
        if (StringHelper.Compare((String)deAction.getACTIONTYPE(), (String)ACTION_CUSTOMPROCCALL, (boolean)true) == 0) {
            String strDataAction = BaseDEDataCtrl.GetDEActionDataAction(deAction, "");
            if (!StringHelper.IsNullOrEmpty((String)strDataAction) && (callResult = this.OnTestDataAction(dataEntity, strDataAction, false)).IsError()) {
                return callResult;
            }
            return this.CustomProcCall(deAction.getACTIONMODE(), dataEntity);
        }
        if (StringHelper.Compare((String)deAction.getACTIONTYPE(), (String)ACTION_CUSTOMRAWPROCCALL, (boolean)true) == 0) {
            String strDataAction = BaseDEDataCtrl.GetDEActionDataAction(deAction, "");
            if (!StringHelper.IsNullOrEmpty((String)strDataAction) && (callResult = this.OnTestDataAction(dataEntity, strDataAction, false)).IsError()) {
                return callResult;
            }
            return this.CustomRawProcCall(deAction.getACTIONMODE(), dataEntity);
        }
        if (StringHelper.Compare((String)deAction.getACTIONTYPE(), (String)ACTION_GET, (boolean)true) == 0) {
            String strDataAction = BaseDEDataCtrl.GetDEActionDataAction(deAction, "READ");
            if (!StringHelper.IsNullOrEmpty((String)strDataAction) && (callResult = this.OnTestDataAction(dataEntity, strDataAction, false)).IsError()) {
                return callResult;
            }
            return this.Get(dataEntity);
        }
        callResult.setRetCode(20);
        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5b9e\u4f53\u64cd\u4f5c\u7c7b\u578b[%1$s]", (Object)deAction.getACTIONTYPE()));
        return callResult;
    }

    @Override
    public IDEDataCtrl GetRelatedDataCtrl(String strDEId) throws Exception {
        if (StringHelper.Compare((String)strDEId, (String)this.GetDEHelper().getId(), (boolean)true) == 0) {
            return this;
        }
        if (this.getReferDataCtrl() != null) {
            return this.getReferDataCtrl().GetRelatedDataCtrl(strDEId);
        }
        if (this.relatedDataCtrlMap.containsKey(strDEId)) {
            IDEDataCtrl iDEDataCtrl = this.relatedDataCtrlMap.get(strDEId);
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Register(iDEDataCtrl);
            }
            return iDEDataCtrl;
        }
        IDEDataCtrl iDEDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrlEx(strDEId, this);
        if (iDEDataCtrl == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)strDEId));
        }
        this.relatedDataCtrlMap.put(strDEId, iDEDataCtrl);
        return iDEDataCtrl;
    }

    protected static void EncryptDataEntity(IDEHelper iDEHelper, BaseDataEntity dataEntity) {
        if (!iDEHelper.IsEnableEncryptStorage()) {
            return;
        }
        for (IDEFHelper iDEFHelper : iDEHelper.GetEncryptStorageFields()) {
            String strValue;
            if (iDEFHelper.getEncryptStorage() != 1 || dataEntity.IsParamNull(iDEFHelper.getName()) || StringHelper.IsNullOrEmpty((String)(strValue = dataEntity.GetParamStringValue(iDEFHelper.getName(), null)))) continue;
            strValue = EncryptHelper.encode2(strValue);
            dataEntity.SetParamValue(iDEFHelper.getName(), (Object)strValue);
        }
    }

    protected static void DecryptDataEntity(IDEHelper iDEHelper, BaseDataEntity dataEntity) {
        if (!iDEHelper.IsEnableEncryptStorage()) {
            return;
        }
        for (IDEFHelper iDEFHelper : iDEHelper.GetEncryptStorageFields()) {
            String strValue;
            if (iDEFHelper.getEncryptStorage() != 1 || dataEntity.IsParamNull(iDEFHelper.getName()) || StringHelper.IsNullOrEmpty((String)(strValue = dataEntity.GetParamStringValue(iDEFHelper.getName(), null)))) continue;
            strValue = EncryptHelper.decode2(strValue);
            dataEntity.SetParamValue(iDEFHelper.getName(), (Object)strValue);
        }
    }

    @Override
    public IDEDataCtrl getReferDataCtrl() {
        return this.referDEDataCtrl;
    }

    @Override
    public void setReferDataCtrl(IDEDataCtrl referDEDataCtrl) {
        this.referDEDataCtrl = referDEDataCtrl;
    }

    @Override
    public void CommitExtTransaction(ISRFDAExtTransaction iSRFDATransaction) {
        this.OnCommitExtTransaction(iSRFDATransaction);
    }

    protected void OnCommitExtTransaction(ISRFDAExtTransaction iSRFDATransaction) {
    }

    @Override
    public void RollbackExtTransaction(ISRFDAExtTransaction iSRFDATransaction) {
        this.OnRollbackExtTransaction(iSRFDATransaction);
    }

    protected void OnRollbackExtTransaction(ISRFDAExtTransaction iSRFDATransaction) {
    }

    protected void RegisterExtTransaction(String strType, BaseDataEntity dataEntity, Object objUserTag, Object objUserTag2) {
        SRFDAExtTransaction srfdaTransaction = new SRFDAExtTransaction();
        srfdaTransaction.setType(strType);
        srfdaTransaction.setDataEntity(dataEntity);
        srfdaTransaction.setDEDataCtrl(this);
        srfdaTransaction.setUserTag(objUserTag);
        srfdaTransaction.setUserTag2(objUserTag2);
        if (this.getTransactionManager() != null) {
            this.getTransactionManager().AddExtTransaction(srfdaTransaction);
        } else {
            this.CommitExtTransaction(srfdaTransaction);
        }
    }

    @Override
    public void ResetRelatedData(String strDEId, Object objKey) throws Exception {
        if (this.getReferDataCtrl() != null) {
            this.getReferDataCtrl().ResetRelatedData(strDEId, objKey);
            return;
        }
        if (this.relatedDataMap == null) {
            return;
        }
        String strKey = StringHelper.Format((String)"%1$s|%2$s", (Object)strDEId, (Object)objKey);
        this.relatedDataMap.remove(strKey);
    }

    @Override
    public BaseDataEntity GetRelatedData(String strDEId, Object objKey, boolean bReload) throws Exception {
        if (this.getReferDataCtrl() != null) {
            return this.getReferDataCtrl().GetRelatedData(strDEId, objKey, bReload);
        }
        if (this.relatedDataMap == null) {
            this.relatedDataMap = new HashMap();
        }
        BaseDataEntity baseDataEntity = null;
        String strKey = StringHelper.Format((String)"%1$s|%2$s", (Object)strDEId, (Object)objKey);
        if (!bReload) {
            baseDataEntity = this.relatedDataMap.get(strKey);
        }
        if (baseDataEntity != null) {
            return baseDataEntity;
        }
        IDEDataCtrl relatedDataCtrl = this.GetRelatedDataCtrl(strDEId);
        baseDataEntity = relatedDataCtrl.GetDEHelper().CreateDEObject();
        baseDataEntity.SetParamValue(relatedDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), objKey);
        CallResult callResult = relatedDataCtrl.Get(baseDataEntity);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5173\u8054\u6570\u636e[%1$s][%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)strDEId, (Object)objKey, (Object)callResult.getErrorInfo()));
        }
        this.relatedDataMap.put(strKey, baseDataEntity);
        return baseDataEntity;
    }

    protected static boolean TestImport(IDEDataCtrl iDEDataCtrl, BaseDataEntity baseDataEntity, HashMap<String, String> ignoreChangeFieldMap) {
        BaseDataEntity lastDataEntity = new BaseDataEntity();
        baseDataEntity.CopyTo(lastDataEntity, false);
        CallResult callResult = iDEDataCtrl.Get(lastDataEntity);
        if (callResult.IsError()) {
            return true;
        }
        Hashtable paramList = baseDataEntity.getTotalParamList();
        Hashtable paramList2 = lastDataEntity.getTotalParamList();
        for (Object objKey : paramList.keySet()) {
            Object objValue2 = paramList2.remove(objKey);
            if (ignoreChangeFieldMap.containsKey(objKey)) continue;
            if (objValue2 == null) {
                return true;
            }
            Object objValue1 = paramList.get(objKey);
            try {
                if (objValue1.equals(objValue2) || StringHelper.Compare((String)objValue1.toString(), (String)objValue2.toString(), (boolean)false) == 0) continue;
                return true;
            }
            catch (Exception ex) {
                return true;
            }
        }
        return false;
    }

    @Override
    public CallResult GetDataLastVersion(BaseDataEntity dataEntity, ArrayList<JSONObject> jsonObjectList, HashMap<String, BaseDataEntity> dataMap, boolean bCheckoutMode) {
        CallResult callResult = new CallResult();
        String strKeyFieldName = this.GetDEHelper().GetKeyDEFHelper().getName();
        Object objKeyValue = dataEntity.GetParamValue(strKeyFieldName);
        try {
            String strUniqueKey = StringHelper.Format((String)"%1$s|%2$s", (Object)this.GetDEHelper().getId(), (Object)objKeyValue);
            if (dataMap.containsKey(strUniqueKey)) {
                return callResult;
            }
            this.OnGetDataLastVersion(dataEntity, jsonObjectList, dataMap, bCheckoutMode);
            dataMap.put(strUniqueKey, dataEntity);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s][%2$s]\u6700\u65b0\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)this.GetDEHelper().getId(), (Object)objKeyValue, (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void OnGetDataLastVersion(BaseDataEntity dataEntity, ArrayList<JSONObject> jsonObjectList, HashMap<String, BaseDataEntity> dataMap, boolean bCheckoutMode) throws Exception {
        CallResult callResult;
        String strKeyFieldName = this.GetDEHelper().GetKeyDEFHelper().getName();
        Object objKeyValue = dataEntity.GetParamValue(strKeyFieldName);
        if (dataEntity.GetParamIntValue(TAG_FULLINFO, 0) != 1 && (callResult = this.Get(dataEntity)).IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6700\u65b0\u6570\u636e[%1$s][%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)this.GetDEHelper().getId(), (Object)objKeyValue, (Object)callResult.getErrorInfo()));
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("srfdeid", (Object)this.GetDEHelper().getId());
        jsonObject.put("srfaction", (Object)"save");
        JSONObject dataJsonObject = BaseDataEntity.ToJSONObject((BaseDataEntity)dataEntity, (boolean)false);
        jsonObject.put("srfdata", (Object)dataJsonObject);
        jsonObjectList.add(jsonObject);
    }

    protected void GetChildDataLastVersion(String strDEId, BaseDataEntity cond, ArrayList<JSONObject> jsonObjectList, HashMap<String, BaseDataEntity> dataMap, boolean bCheckoutMode) throws Exception {
        IDEDataCtrl childDEDataCtrl = this.GetRelatedDataCtrl(strDEId);
        IDEHelper iDEHelper = childDEDataCtrl.GetDEHelper();
        Vector<BaseDataEntity> list = new Vector<BaseDataEntity>();
        CallResult callResult = childDEDataCtrl.Select(cond, list);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b50\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        String strKeyFieldName = iDEHelper.GetKeyDEFHelper().getName();
        StringBuilderEx sb = new StringBuilderEx();
        boolean bFirst = true;
        for (BaseDataEntity item : list) {
            String strKey = item.GetParamStringValue(strKeyFieldName, "");
            if (StringHelper.IsNullOrEmpty((String)strKey)) continue;
            if (bFirst) {
                bFirst = false;
            } else {
                sb.Append(";");
            }
            sb.Append(strKey);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("srfdeid", (Object)iDEHelper.getId());
        jsonObject.put("srfaction", (Object)"sync");
        jsonObject.put("srfkeys", (Object)sb.toString());
        JSONObject condJson = BaseDataEntity.ToJSONObject((BaseDataEntity)cond, (boolean)false);
        jsonObject.put("srfcond", (Object)condJson);
        jsonObjectList.add(jsonObject);
        for (BaseDataEntity item : list) {
            callResult = childDEDataCtrl.GetDataLastVersion(item, jsonObjectList, dataMap, bCheckoutMode);
            if (!callResult.IsError()) continue;
            throw new Exception(StringHelper.Format((String)"\u83b7\u65b0\u5b50\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected void CheckoutChildData(String strDEId, BaseDataEntity cond, ArrayList<JSONObject> jsonObjectList, HashMap<String, BaseDataEntity> dataMap) throws Exception {
        IDEDataCtrl childDEDataCtrl = this.GetRelatedDataCtrl(strDEId);
        IDEHelper iDEHelper = childDEDataCtrl.GetDEHelper();
        Vector<BaseDataEntity> list = new Vector<BaseDataEntity>();
        CallResult callResult = childDEDataCtrl.Select(cond, list);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b50\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        String strKeyFieldName = iDEHelper.GetKeyDEFHelper().getName();
        StringBuilderEx sb = new StringBuilderEx();
        boolean bFirst = true;
        for (BaseDataEntity item : list) {
            String strKey = item.GetParamStringValue(strKeyFieldName, "");
            if (StringHelper.IsNullOrEmpty((String)strKey)) continue;
            if (bFirst) {
                bFirst = false;
            } else {
                sb.Append(";");
            }
            sb.Append(strKey);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("srfdeid", (Object)iDEHelper.getId());
        jsonObject.put("srfaction", (Object)"sync");
        jsonObject.put("srfkeys", (Object)sb.toString());
        JSONObject condJson = BaseDataEntity.ToJSONObject((BaseDataEntity)cond, (boolean)false);
        jsonObject.put("srfcond", (Object)condJson);
        jsonObjectList.add(jsonObject);
        for (BaseDataEntity item : list) {
            callResult = childDEDataCtrl.CheckoutData(item, jsonObjectList, dataMap);
            if (!callResult.IsError()) continue;
            throw new Exception(StringHelper.Format((String)"\u7b7e\u51fa\u5b50\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected void UndoCheckoutChildData(String strDEId, BaseDataEntity cond, HashMap<String, BaseDataEntity> dataMap) throws Exception {
        Vector<BaseDataEntity> list;
        IDEDataCtrl childDEDataCtrl = this.GetRelatedDataCtrl(strDEId);
        CallResult callResult = childDEDataCtrl.Select(cond, list = new Vector<BaseDataEntity>());
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b50\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (BaseDataEntity item : list) {
            callResult = childDEDataCtrl.UndoCheckoutData(item, dataMap);
            if (!callResult.IsError()) continue;
            throw new Exception(StringHelper.Format((String)"\u64a4\u6d88\u7b7e\u51fa\u5b50\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    @Override
    public CallResult AutoCheckoutData(BaseDataEntity dataEntity, ArrayList<JSONObject> jsonObjectList, HashMap<String, BaseDataEntity> dataMap) {
        CallResult callResult = new CallResult();
        try {
            if (this.GetDEHelper().IsEnableVersionControl() && this.OnTestCheckoutData(dataEntity)) {
                return this.CheckoutData(dataEntity, jsonObjectList, dataMap);
            }
            return this.GetDataLastVersion(dataEntity, jsonObjectList, dataMap, true);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected boolean OnTestCheckoutData(BaseDataEntity dataEntity) throws Exception {
        return true;
    }

    @Override
    public CallResult CheckoutData(BaseDataEntity dataEntity, ArrayList<JSONObject> jsonObjectList, HashMap<String, BaseDataEntity> dataMap) {
        CallResult callResult = new CallResult();
        try {
            if (this.GetDEHelper().IsEnableVersionControl()) {
                this.OnCheckoutData(dataEntity, jsonObjectList, dataMap);
            }
            return this.GetDataLastVersion(dataEntity, jsonObjectList, dataMap, true);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void OnCheckoutData(BaseDataEntity dataEntity, ArrayList<JSONObject> jsonObjectList, HashMap<String, BaseDataEntity> dataMap) throws Exception {
        CallResult callResult;
        String strKeyFieldName = this.GetDEHelper().GetKeyDEFHelper().getName();
        Object objKeyValue = dataEntity.GetParamValue(strKeyFieldName);
        if (dataEntity.GetParamIntValue(TAG_FULLINFO, 0) != 1 && (callResult = this.Get(dataEntity)).IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u7b7e\u51fa\u6570\u636e[%1$s][%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)this.GetDEHelper().getId(), (Object)objKeyValue, (Object)callResult.getErrorInfo()));
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        String strVCState = dataEntity.GetParamStringValue("SRFVCSTATE", "");
        String strVCMan = dataEntity.GetParamStringValue("SRFVCMAN", "");
        if (StringHelper.Compare((String)strVCState, (String)"CHECKOUT", (boolean)true) == 0) {
            if (StringHelper.Compare((String)strVCMan, (String)this.getOPPersonId(), (boolean)true) != 0) {
                log.error((Object)StringHelper.Format((String)"\u6570\u636e[%1$s][%2$s]\u5df2\u7ecf\u88ab\u5176\u5b83\u7528\u6237\u7b7e\u51fa", (Object)this.GetDEHelper().getId(), (Object)objKeyValue));
                throw new Exception(StringHelper.Format((String)"\u6570\u636e\u5df2\u7ecf\u88ab\u5176\u5b83\u7528\u6237\u7b7e\u51fa\uff0c\u65e0\u6cd5\u518d\u6b21\u7b7e\u51fa"));
            }
        } else {
            int nVCVer = dataEntity.GetParamIntValue("SRFVCVER", 1);
            VCLog vcLog = new VCLog();
            vcLog.setVCLOGNAME("CHECKOUT");
            vcLog.setDATAVERSION(nVCVer);
            vcLog.setDATATYPE(this.GetDEHelper().getId());
            vcLog.setDATAID(objKeyValue.toString());
            BaseDEDataCtrl.SetCallParamCheckKey(vcLog, false);
            BaseDEDataCtrl.SetCallParamDALog(vcLog, false);
            IDEDataCtrl vcLogDataCtrl = this.GetRelatedDataCtrl("DE0289");
            CallResult callResult2 = vcLogDataCtrl.Save(true, vcLog);
            if (callResult2.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u65e5\u5fd7\u7248\u672c\u63a7\u5236[%1$s][%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)this.GetDEHelper().getId(), (Object)objKeyValue, (Object)callResult2.getErrorInfo()));
                throw new Exception(StringHelper.Format((String)"\u65e5\u5fd7\u7248\u672c\u63a7\u5236\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult2.getErrorInfo()));
            }
            dataEntity.Reset();
            dataEntity.SetParamValue(strKeyFieldName, objKeyValue);
            dataEntity.SetParamValue("SRFVCSTATE", (Object)"CHECKOUT");
            dataEntity.SetParamValue("SRFVCMAN", (Object)this.getOPPersonId());
            dataEntity.SetParamValue("SRFVCVER", (Object)nVCVer);
            dataEntity.SetParamValue("SRFVCDATE", vcLog.GetParamValue("UPDATEDATE"));
            callResult2 = this.Save(false, ACTIONMODE_VCLOG, dataEntity);
            if (callResult2.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u6807\u8bb0\u7b7e\u51fa\u6570\u636e[%1$s][%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)this.GetDEHelper().getId(), (Object)objKeyValue, (Object)callResult2.getErrorInfo()));
                throw new Exception(StringHelper.Format((String)"\u6807\u8bb0\u7b7e\u51fa\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult2.getErrorInfo()));
            }
        }
    }

    @Override
    public CallResult CheckinData(JSONObject jsonData) {
        CallResult callResult = new CallResult();
        try {
            if (!this.GetDEHelper().IsEnableVersionControl() && !this.GetDEHelper().GetMajorDEHelper().IsEnableVersionControl()) {
                return callResult;
            }
            this.OnCheckinData(jsonData);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void OnCheckinData(JSONObject jsonData) throws Exception {
        String strKeyFieldName = this.GetDEHelper().GetKeyDEFHelper().getName();
        String strAction = jsonData.getString("srfaction");
        if (StringHelper.Compare((String)strAction, (String)"save", (boolean)true) == 0) {
            JSONObject dataItem = jsonData.getJSONObject("srfdata");
            BaseDataEntity dataEntity = BaseDataEntity.FromJSONObject((JSONObject)dataItem);
            Object objKeyValue = dataEntity.GetParamValue(strKeyFieldName);
            BaseDataEntity lastDataEntity = new BaseDataEntity();
            lastDataEntity.SetParamValue(strKeyFieldName, objKeyValue);
            int nCheckKeyState = this.CheckKeyState2(lastDataEntity);
            if (nCheckKeyState == 0) {
                CallResult callResult = this.Save(true, dataEntity);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u7b7e\u5165\u6570\u636e[%1$s][%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)this.GetDEHelper().getId(), (Object)objKeyValue, (Object)callResult.getErrorInfo()));
                    throw new Exception(StringHelper.Format((String)"\u7b7e\u5165\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                return;
            }
            if (nCheckKeyState == 1) {
                CallResult callResult;
                if (this.GetDEHelper().IsEnableVersionControl()) {
                    callResult = this.Get(lastDataEntity);
                    if (callResult.IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u7b7e\u5165\u6570\u636e[%1$s][%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)this.GetDEHelper().getId(), (Object)objKeyValue, (Object)callResult.getErrorInfo()));
                        throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    String strVCStateLast = lastDataEntity.GetParamStringValue("SRFVCSTATE", "");
                    String strVCManLast = lastDataEntity.GetParamStringValue("SRFVCMAN", "");
                    if (StringHelper.Compare((String)strVCStateLast, (String)"CHECKOUT", (boolean)true) != 0) {
                        log.error((Object)StringHelper.Format((String)"\u6570\u636e[%1$s][%2$s]\u6ca1\u6709\u88ab\u7b7e\u51fa\uff0c\u65e0\u6cd5\u7b7e\u5165", (Object)this.GetDEHelper().getId(), (Object)objKeyValue));
                        throw new Exception(StringHelper.Format((String)"\u6570\u636e\u6ca1\u6709\u88ab\u5176\u5b83\u7528\u6237\u7b7e\u51fa\uff0c\u65e0\u6cd5\u7b7e\u5165"));
                    }
                    if (StringHelper.Compare((String)strVCManLast, (String)this.getOPPersonId(), (boolean)true) != 0) {
                        log.error((Object)StringHelper.Format((String)"\u6570\u636e[%1$s][%2$s]\u88ab\u5176\u5b83\u7528\u6237\u7b7e\u51fa\uff0c\u65e0\u6cd5\u7b7e\u5165", (Object)this.GetDEHelper().getId(), (Object)objKeyValue));
                        throw new Exception(StringHelper.Format((String)"\u6570\u636e\u88ab\u5176\u5b83\u7528\u6237\u7b7e\u51fa\uff0c\u65e0\u6cd5\u7b7e\u5165"));
                    }
                    int nVCVer = lastDataEntity.GetParamIntValue("SRFVCVER", 1);
                    VCLog vcLog = new VCLog();
                    vcLog.setVCLOGNAME("CHECKIN");
                    vcLog.setDATAVERSION(++nVCVer);
                    vcLog.setDATATYPE(this.GetDEHelper().getId());
                    vcLog.setDATAID(objKeyValue.toString());
                    BaseDEDataCtrl.SetCallParamCheckKey(vcLog, false);
                    BaseDEDataCtrl.SetCallParamDALog(vcLog, false);
                    IDEDataCtrl vcLogDataCtrl = this.GetRelatedDataCtrl("DE0289");
                    callResult = vcLogDataCtrl.Save(true, vcLog);
                    if (callResult.IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u65e5\u5fd7\u7248\u672c\u63a7\u5236[%1$s][%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)this.GetDEHelper().getId(), (Object)objKeyValue, (Object)callResult.getErrorInfo()));
                        throw new Exception(StringHelper.Format((String)"\u65e5\u5fd7\u7248\u672c\u63a7\u5236\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    dataEntity.SetParamValue("SRFVCSTATE", (Object)"CHECKIN");
                    dataEntity.SetParamValue("SRFVCMAN", (Object)this.getOPPersonId());
                    dataEntity.SetParamValue("SRFVCVER", (Object)nVCVer);
                    dataEntity.SetParamValue("SRFVCDATE", vcLog.GetParamValue("UPDATEDATE"));
                }
                dataEntity.SetParamValue(strKeyFieldName, objKeyValue);
                callResult = this.Save(false, dataEntity);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u7b7e\u5165\u6570\u636e[%1$s][%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)this.GetDEHelper().getId(), (Object)objKeyValue, (Object)callResult.getErrorInfo()));
                    throw new Exception(StringHelper.Format((String)"\u7b7e\u5165\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                return;
            }
            log.error((Object)StringHelper.Format((String)"\u7b7e\u5165\u6570\u636e[%1$s][%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)this.GetDEHelper().getId(), (Object)objKeyValue, (Object)"\u6570\u636e\u5df2\u7ecf\u5220\u9664"));
            throw new Exception(StringHelper.Format((String)"\u7b7e\u5165\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)"\u6570\u636e\u5df2\u7ecf\u5220\u9664"));
        }
        if (StringHelper.Compare((String)strAction, (String)"sync", (boolean)true) == 0) {
            JSONObject dataItem = jsonData.getJSONObject("srfcond");
            BaseDataEntity cond = BaseDataEntity.FromJSONObject((JSONObject)dataItem);
            String strKeys = jsonData.getString("srfkeys");
            Vector<BaseDataEntity> list = new Vector<BaseDataEntity>();
            CallResult callResult = this.Select(cond, list);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u540c\u6b65\u7b7e\u5165\u6570\u636e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.GetDEHelper().getId(), (Object)callResult.getErrorInfo()));
                throw new Exception(StringHelper.Format((String)"\u7b7e\u5165\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            String[] keys = strKeys.split("[;]");
            HashMap<String, String> keyMap = new HashMap<String, String>();
            String[] vcLogDataCtrl = keys;
            int vcLog = keys.length;
            int n = 0;
            while (n < vcLog) {
                String strKey = vcLogDataCtrl[n];
                keyMap.put(strKey, "");
                ++n;
            }
            for (BaseDataEntity lastDataEntity : list) {
                String strKeyValue = lastDataEntity.GetParamStringValue(strKeyFieldName, "");
                if (keyMap.containsKey(strKeyValue)) continue;
                String strVCStateLast = lastDataEntity.GetParamStringValue("SRFVCSTATE", "");
                String strVCManLast = lastDataEntity.GetParamStringValue("SRFVCMAN", "");
                if (StringHelper.Compare((String)strVCStateLast, (String)"CHECKOUT", (boolean)true) != 0) {
                    log.error((Object)StringHelper.Format((String)"\u6570\u636e[%1$s][%2$s]\u6ca1\u6709\u88ab\u7b7e\u51fa\uff0c\u65e0\u6cd5\u7b7e\u5165", (Object)this.GetDEHelper().getId(), (Object)strKeyValue));
                    throw new Exception(StringHelper.Format((String)"\u6570\u636e\u6ca1\u6709\u88ab\u5176\u5b83\u7528\u6237\u7b7e\u51fa\uff0c\u65e0\u6cd5\u7b7e\u5165"));
                }
                if (StringHelper.Compare((String)strVCManLast, (String)this.getOPPersonId(), (boolean)true) != 0) {
                    log.error((Object)StringHelper.Format((String)"\u6570\u636e[%1$s][%2$s]\u88ab\u5176\u5b83\u7528\u6237\u7b7e\u51fa\uff0c\u65e0\u6cd5\u7b7e\u5165", (Object)this.GetDEHelper().getId(), (Object)strKeyValue));
                    throw new Exception(StringHelper.Format((String)"\u6570\u636e\u88ab\u5176\u5b83\u7528\u6237\u7b7e\u51fa\uff0c\u65e0\u6cd5\u7b7e\u5165"));
                }
                int nVCVer = lastDataEntity.GetParamIntValue("SRFVCVER", 1);
                VCLog vcLog2 = new VCLog();
                vcLog2.setVCLOGNAME("DELETE");
                vcLog2.setDATAVERSION(++nVCVer);
                vcLog2.setDATATYPE(this.GetDEHelper().getId());
                vcLog2.setDATAID(strKeyValue);
                BaseDEDataCtrl.SetCallParamCheckKey(vcLog2, false);
                BaseDEDataCtrl.SetCallParamDALog(vcLog2, false);
                IDEDataCtrl vcLogDataCtrl2 = this.GetRelatedDataCtrl("DE0289");
                callResult = vcLogDataCtrl2.Save(true, vcLog2);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u65e5\u5fd7\u7248\u672c\u63a7\u5236[%1$s][%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)this.GetDEHelper().getId(), (Object)strKeyValue, (Object)callResult.getErrorInfo()));
                    throw new Exception(StringHelper.Format((String)"\u65e5\u5fd7\u7248\u672c\u63a7\u5236\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                callResult = this.Remove(lastDataEntity);
                if (!callResult.IsError()) continue;
                log.error((Object)StringHelper.Format((String)"\u7b7e\u5165\u6570\u636e[%1$s][%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)this.GetDEHelper().getId(), (Object)strKeyValue, (Object)callResult.getErrorInfo()));
                throw new Exception(StringHelper.Format((String)"\u7b7e\u5165\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            return;
        }
    }

    @Override
    public CallResult UndoCheckoutData(BaseDataEntity dataEntity, HashMap<String, BaseDataEntity> dataMap) {
        CallResult callResult = new CallResult();
        try {
            if (this.GetDEHelper().IsEnableVersionControl()) {
                this.OnUndoCheckoutData(dataEntity, dataMap);
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void OnUndoCheckoutData(BaseDataEntity dataEntity, HashMap<String, BaseDataEntity> dataMap) throws Exception {
        CallResult callResult;
        String strKeyFieldName = this.GetDEHelper().GetKeyDEFHelper().getName();
        Object objKeyValue = dataEntity.GetParamValue(strKeyFieldName);
        if (dataEntity.GetParamIntValue(TAG_FULLINFO, 0) != 1 && (callResult = this.Get(dataEntity)).IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u7b7e\u51fa\u6570\u636e[%1$s][%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)this.GetDEHelper().getId(), (Object)objKeyValue, (Object)callResult.getErrorInfo()));
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        String strVCState = dataEntity.GetParamStringValue("SRFVCSTATE", "");
        String strVCMan = dataEntity.GetParamStringValue("SRFVCMAN", "");
        if (StringHelper.Compare((String)strVCState, (String)"CHECKOUT", (boolean)true) == 0) {
            int nVCVer = dataEntity.GetParamIntValue("SRFVCVER", 1);
            VCLog vcLog = new VCLog();
            vcLog.setVCLOGNAME("UNDOCHECKOUT");
            vcLog.setDATAVERSION(nVCVer);
            vcLog.setDATATYPE(this.GetDEHelper().getId());
            vcLog.setDATAID(objKeyValue.toString());
            BaseDEDataCtrl.SetCallParamCheckKey(vcLog, false);
            BaseDEDataCtrl.SetCallParamDALog(vcLog, false);
            IDEDataCtrl vcLogDataCtrl = this.GetRelatedDataCtrl("DE0289");
            CallResult callResult2 = vcLogDataCtrl.Save(true, vcLog);
            if (callResult2.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u65e5\u5fd7\u7248\u672c\u63a7\u5236[%1$s][%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)this.GetDEHelper().getId(), (Object)objKeyValue, (Object)callResult2.getErrorInfo()));
                throw new Exception(StringHelper.Format((String)"\u65e5\u5fd7\u7248\u672c\u63a7\u5236\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult2.getErrorInfo()));
            }
            dataEntity.Reset();
            dataEntity.SetParamValue(strKeyFieldName, objKeyValue);
            dataEntity.SetParamValue("SRFVCSTATE", null);
            dataEntity.SetParamValue("SRFVCMAN", null);
            dataEntity.SetParamValue("SRFVCVER", (Object)nVCVer);
            dataEntity.SetParamValue("SRFVCDATE", vcLog.GetParamValue("UPDATEDATE"));
            callResult2 = this.Save(false, ACTIONMODE_VCLOG, dataEntity);
            if (callResult2.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u64a4\u6d88\u7b7e\u51fa\u6570\u636e[%1$s][%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)this.GetDEHelper().getId(), (Object)objKeyValue, (Object)callResult2.getErrorInfo()));
                throw new Exception(StringHelper.Format((String)"\u64a4\u6d88\u7b7e\u51fa\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult2.getErrorInfo()));
            }
        }
    }

    void RemoveUnsafeContent(BaseDataEntity baseDataEntity) throws Exception {
    }
}
