/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.Data.DEACMode
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Model.SearchItemConfig
 *  SA.SRFDA.Model.SearchModelConfig
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.ISRFExWebContext
 *  SA.SRFramework.WebEx.SRFExAjaxListResult
 *  SA.SRFramework.WebEx.SRFExAutoCompleteActionHelper
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.UI.AutoCompleteConfig
 *  SA.SRFramework.WebEx.Utility.ACFetchResultHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.AC;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.DEACMode;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Model.SearchItemConfig;
import SA.SRFDA.Model.SearchModelConfig;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.ISRFExWebContext;
import SA.SRFramework.WebEx.SRFExAjaxListResult;
import SA.SRFramework.WebEx.SRFExAutoCompleteActionHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.AutoCompleteConfig;
import SA.SRFramework.WebEx.Utility.ACFetchResultHelper;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseDAACActionHelper
extends SRFExAutoCompleteActionHelper {
    protected AutoCompleteConfig autoCompleteConfig = null;
    private static final Log log = LogFactory.getLog(BaseDAACActionHelper.class);

    protected boolean OnFetchAction() {
        SelectResult selectResult;
        DEACMode deACMode;
        IDEFHelper majorDEFHelper;
        IDEHelper iDEHelper;
        SRFExAjaxListResult fetchResult;
        block44: {
            block43: {
                block42: {
                    fetchResult = new SRFExAjaxListResult();
                    String strDEId = this.getWebContext().getSRFDEID();
                    iDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper(strDEId);
                    if (iDEHelper == null) {
                        fetchResult.setRetCode(1);
                        fetchResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId));
                        log.error((Object)fetchResult.getErrorInfo());
                        this.getPage().Output(fetchResult.ToJSONString());
                        return true;
                    }
                    majorDEFHelper = iDEHelper.GetMajorDEFHelper();
                    if (majorDEFHelper == null) {
                        fetchResult.setRetCode(1);
                        fetchResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u4e3b\u4fe1\u606f\u5c5e\u6027", (Object)strDEId));
                        log.error((Object)fetchResult.getErrorInfo());
                        this.getPage().Output(fetchResult.ToJSONString());
                        return true;
                    }
                    String strACQueryModelId = iDEHelper.getDataEntity().getACQUERYMODELID();
                    DER1N der1N = null;
                    String strDER1NID = SRFDAWebCTXHelper.GetDER1NId((ISRFDAWebContext)this.getWebContext());
                    if (!StringHelper.IsNullOrEmpty((String)strDER1NID) && (der1N = iDEHelper.FindDER1N(strDER1NID)) != null && !der1N.isQUERYMODELIDNull()) {
                        strACQueryModelId = der1N.getQUERYMODELID();
                    }
                    int nMaxCnt = 50;
                    boolean bEnableDP = iDEHelper.getDataEntity().isACENABLEDP();
                    deACMode = null;
                    String strACUserMode = this.getACUserMode();
                    String strSortField = iDEHelper.getDataEntity().getACSORTFIELD();
                    String strSortDir = iDEHelper.getDataEntity().getACSORTDIR();
                    if (!iDEHelper.getDataEntity().isACMAXCNTNull()) {
                        nMaxCnt = iDEHelper.getDataEntity().getACMAXCNT();
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strACUserMode)) {
                        deACMode = iDEHelper.GetACMode(strACUserMode);
                        if (deACMode == null) {
                            fetchResult.setRetCode(3);
                            fetchResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f[%1$s]\u914d\u7f6e\u4fe1\u606f", (Object)strACUserMode));
                            log.error((Object)fetchResult.getErrorInfo());
                            this.getPage().Output(fetchResult.ToJSONString());
                            return true;
                        }
                        bEnableDP = deACMode.isENABLEDP();
                        if (!StringHelper.IsNullOrEmpty((String)deACMode.getQUERYMODELID())) {
                            strACQueryModelId = deACMode.getQUERYMODELID();
                        }
                        strSortField = deACMode.getACSORTFIELD();
                        strSortDir = deACMode.getACSORTDIR();
                        if (!deACMode.isACMAXCNTNull()) {
                            nMaxCnt = deACMode.getACMAXCNT();
                        }
                    }
                    if (StringHelper.Compare((String)this.getWebContext().getCurUserId(), (String)"SYSTEM", (boolean)true) == 0) {
                        bEnableDP = false;
                    }
                    BaseDAQueryModelHelper daQueryModelHelper = null;
                    daQueryModelHelper = !StringHelper.IsNullOrEmpty((String)strACQueryModelId) ? (bEnableDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(strACQueryModelId) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(strACQueryModelId)) : (bEnableDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(iDEHelper) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(iDEHelper));
                    if (daQueryModelHelper == null) {
                        fetchResult.setRetCode(1);
                        fetchResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u67e5\u8be2\u8f85\u52a9\u7c7b", (Object)strDEId));
                        log.error((Object)fetchResult.getErrorInfo());
                        this.getPage().Output(fetchResult.ToJSONString());
                        return true;
                    }
                    boolean bGetFullWords = false;
                    Vector<String> fullwords = new Vector<String>();
                    StringBuilderEx script = new StringBuilderEx();
                    script.Append(this.GetDAModelQueryScript(daQueryModelHelper));
                    Vector<String> userConditions = new Vector<String>();
                    daQueryModelHelper.FillMajorConditions(userConditions);
                    this.FillURLCondition(iDEHelper, userConditions, daQueryModelHelper);
                    Vector<String> acConditions = new Vector<String>();
                    for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
                        if (!iDEFHelper.getDEField().isACSEARCH(iDEFHelper.IsMajorDEField())) continue;
                        acConditions.add(daQueryModelHelper.GetConditionSQL(iDEFHelper, "", "LIKE", this.getWebContext().getACQuery()));
                        if (!iDEFHelper.getDEField().isSHORTWORDSEARCH()) continue;
                        if (!bGetFullWords) {
                            this.GetFullWords(this.getWebContext().getACQuery(), fullwords);
                            bGetFullWords = true;
                        }
                        for (String string : fullwords) {
                            acConditions.add(daQueryModelHelper.GetConditionSQL(iDEFHelper, "", "LIKE", string));
                        }
                    }
                    if (acConditions.size() != 0) {
                        String strACCondtion = "";
                        boolean bFirst = true;
                        for (String string : acConditions) {
                            if (bFirst) {
                                bFirst = false;
                            } else {
                                strACCondtion = String.valueOf(strACCondtion) + " OR ";
                            }
                            strACCondtion = String.valueOf(strACCondtion) + StringHelper.Format((String)"(%1$s)", (Object)string);
                        }
                        userConditions.add(strACCondtion);
                    }
                    this.FillDAQueryModelHelperCondition(userConditions, daQueryModelHelper);
                    if (userConditions.size() != 0) {
                        script.Append(" WHERE ");
                        boolean bFirst = true;
                        for (String strCondition : userConditions) {
                            if (bFirst) {
                                bFirst = false;
                            } else {
                                script.Append(" AND ");
                            }
                            script.Append("(%1$s)", (Object)strCondition);
                        }
                    }
                    String strSortFieldName = majorDEFHelper.getName();
                    if (!StringHelper.IsNullOrEmpty((String)strSortField)) {
                        IDEFHelper iDEFHelper = iDEHelper.GetDEFHelper(strSortField);
                        if (iDEFHelper == null) {
                            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\uff0c\u6392\u5e8f\u5b57\u6bb5\u65e0\u6548", (Object)strSortField));
                        } else {
                            strSortFieldName = iDEFHelper.getName();
                        }
                    }
                    String strPagingSQL = daQueryModelHelper.GetPagingSQL(script.toString(), 0, nMaxCnt, strSortFieldName, strSortDir, "", "");
                    strPagingSQL = daQueryModelHelper.ReplaceURLParamMacro(strPagingSQL, (ISRFExWebContext)this.getWebContext(), true);
                    log.info((Object)("AC PAGING SQL\r\n" + strPagingSQL));
                    Vector vector = new Vector();
                    daQueryModelHelper.FillCallParams(vector, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
                    if (vector != null) {
                        StringBuilderEx info = new StringBuilderEx();
                        int i = 0;
                        while (i < vector.size()) {
                            CallParam callParam = (CallParam)vector.get(i);
                            info.Append("\u53c2\u6570[%1$s][%2$s][%3$s]\r\n", (Object)(i + 1), (Object)callParam.getParamName(), callParam.getValue());
                            ++i;
                        }
                        log.info((Object)info.toString());
                    }
                    try {
                        if ((selectResult = this.getWebContext().getDBCaller(iDEHelper.GetDBStorage()).CallRaw3(strPagingSQL, vector)) != null) break block42;
                    }
                    catch (Exception ex) {
                        log.error((Object)ex);
                        fetchResult.setRetCode(1);
                        fetchResult.setErrorInfo(ex.getMessage());
                        log.error((Object)fetchResult.getErrorInfo());
                        this.getPage().Output(fetchResult.ToJSONString());
                        return true;
                    }
                    fetchResult.setRetCode(1);
                    fetchResult.setErrorInfo(StringHelper.Format((String)"\u4e0d\u660e\u9519\u8bef"));
                    log.error((Object)fetchResult.getErrorInfo());
                    this.getPage().Output(fetchResult.ToJSONString());
                    return true;
                }
                if (selectResult.getRetCode() == 0) break block43;
                fetchResult.From((DBResult)selectResult);
                log.error((Object)fetchResult.getErrorInfo());
                this.getPage().Output(fetchResult.ToJSONString());
                return true;
            }
            if (selectResult.getSelectData().getTableCount() == 1) break block44;
            fetchResult.setRetCode(1);
            fetchResult.setErrorInfo("\u8fd4\u56de\u7ed3\u679c\u96c6\u6709\u8bef");
            log.error((Object)fetchResult.getErrorInfo());
            this.getPage().Output(fetchResult.ToJSONString());
            return true;
        }
        try {
            Object objKeyValue;
            String strTextParam = iDEHelper.getDataEntity().getACINFOPARAM();
            if (deACMode != null) {
                strTextParam = deACMode.getACINFOPARAM();
            }
            String strTextFormat = iDEHelper.getDataEntity().getACINFOFORMAT();
            if (deACMode != null) {
                strTextFormat = deACMode.getACINFOFORMAT();
            }
            if (StringHelper.IsNullOrEmpty((String)strTextParam)) {
                strTextParam = majorDEFHelper.getName();
            }
            String strRealTextFormat = "";
            if (deACMode != null && !StringHelper.IsNullOrEmpty((String)deACMode.getACREALTEXTFORMAT())) {
                strRealTextFormat = deACMode.getACREALTEXTFORMAT();
            }
            String strRealTextParam = iDEHelper.GetMajorDEFHelper().getName();
            if (deACMode != null && !StringHelper.IsNullOrEmpty((String)deACMode.getACREALTEXTPARAM())) {
                strRealTextParam = deACMode.getACREALTEXTPARAM();
            }
            Hashtable<String, String> hashTable = new Hashtable<String, String>();
            Properties properties = iDEHelper.getDataEntity().getACExtInfo();
            if (properties != null) {
                for (Object objKey : properties.keySet()) {
                    objKeyValue = properties.get(objKey);
                    if (objKeyValue == null) {
                        objKeyValue = objKey;
                    }
                    hashTable.put(objKey.toString(), objKeyValue.toString());
                }
            }
            if (deACMode != null && (properties = deACMode.getACExtInfo()) != null) {
                for (Object objKey : properties.keySet()) {
                    objKeyValue = properties.get(objKey);
                    if (objKeyValue == null) {
                        objKeyValue = objKey;
                    }
                    hashTable.put(objKey.toString(), objKeyValue.toString());
                }
            }
            ACFetchResultHelper.FillEx((SRFExWebContext)this.getWebContext(), (Vector)fetchResult.getItems(), (DataTable)selectResult.getMainTable(), (String)strTextFormat, (String)strTextParam, (String)strRealTextFormat, (String)strRealTextParam, (String)"", (String)iDEHelper.GetKeyDEFHelper().getName(), hashTable);
            this.OnAfterFillACFetchResult(fetchResult.getItems(), selectResult.getMainTable(), strTextFormat, strTextParam, strRealTextFormat, strRealTextParam, "", iDEHelper.GetKeyDEFHelper().getName(), hashTable);
        }
        catch (Exception ex) {
            fetchResult.setRetCode(1);
            fetchResult.setErrorInfo(ex.getMessage());
            log.error((Object)fetchResult.getErrorInfo());
            this.getPage().Output(fetchResult.ToJSONString());
            return true;
        }
        this.getPage().Output(fetchResult.ToJSONString());
        return true;
    }

    protected void OnAfterFillACFetchResult(Vector items, DataTable dataTable, String strTextFormat, String strTextParams, String strRealTextFormat, String strRealTextParams, String strValueFormat, String strValueParams, Hashtable extParam) {
    }

    protected void FillURLCondition(IDEHelper iDEHelper, Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            SearchModelConfig searchModelConfig = iDEFHelper.GetSearchModel();
            if (searchModelConfig == null) continue;
            for (SearchItemConfig searchItemConfig : searchModelConfig) {
                String strCondition;
                if (!iDEFHelper.IsSupportSearchAction(searchItemConfig)) continue;
                String strFormItemId = this.getWebContext().getGlobalHelper().getDAFormItemHelper().GetSearchFormItemId(iDEFHelper, searchItemConfig);
                String strValue = this.getPage().getRequest().getParameter(strFormItemId.toLowerCase());
                if (strValue == null && (strValue = this.getWebContext().GetParamValue(strFormItemId.toUpperCase())) == null || StringHelper.IsNullOrEmpty((String)(strValue = strValue.trim())) || StringHelper.IsNullOrEmpty((String)(strCondition = daQueryModelHelper.GetConditionSQL(iDEFHelper, searchItemConfig, strValue = strValue.replace("\\'", "'"))))) continue;
                userConditions.add(strCondition);
            }
        }
        String strDERID = this.getWebContext().getSRFDERID();
        if (!StringHelper.IsNullOrEmpty((String)strDERID)) {
            String strCondition;
            ILinkDEFHelper pickupDEFHelper = null;
            for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
                ILinkDEFHelper linkDEFHelper;
                if (!iDEFHelper.IsLinkDEField() || StringHelper.Compare((String)(linkDEFHelper = (ILinkDEFHelper)iDEFHelper).GetDERId(), (String)strDERID, (boolean)true) != 0 || StringHelper.Compare((String)linkDEFHelper.GetDataType(), (String)"PICKUP", (boolean)true) != 0) continue;
                pickupDEFHelper = linkDEFHelper;
                break;
            }
            if (pickupDEFHelper == null) {
                return;
            }
            String strValue = "";
            String strParamName = "";
            String strDERIndexId = this.getWebContext().getSRFDERINDEXID();
            if (!StringHelper.IsNullOrEmpty((String)strDERIndexId)) {
                DERINDEX derIndex = new DERINDEX();
                CallResult callResult = this.getPage().getDAModelHelper().GetDERINDEX(strDERIndexId, derIndex);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u7d22\u5f15\u5173\u7cfb[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDERIndexId, (Object)callResult.getErrorInfo()));
                } else {
                    IDEHelper iDEHelper2 = this.getPage().getDAModelStorage().FindDEHelper(derIndex.getDEID());
                    if (iDEHelper2 == null) {
                        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)derIndex.getDEID()));
                    } else {
                        strParamName = iDEHelper2.GetKeyDEFHelper().getName();
                    }
                }
            } else {
                strParamName = pickupDEFHelper.GetRelatedDEFHelper().getName();
            }
            strValue = this.getWebContext().GetPostValue(strParamName);
            if (StringHelper.IsNullOrEmpty((String)strValue)) {
                strValue = this.getWebContext().GetParamValue(strParamName);
            }
            if (strValue != null) {
                strValue = strValue.trim();
            }
            if (StringHelper.IsNullOrEmpty((String)strValue)) {
                strValue = "NA";
            }
            if (!StringHelper.IsNullOrEmpty((String)(strCondition = daQueryModelHelper.GetConditionSQL((IDEFHelper)pickupDEFHelper, "", "=", strValue)))) {
                userConditions.add(strCondition);
            }
        }
    }

    protected void GetFullWords(String strShortWord, Vector<String> fullwords) {
        if (StringHelper.IsNullOrEmpty((String)strShortWord)) {
            return;
        }
        strShortWord = strShortWord.toUpperCase();
        IDEDataCtrl shortWordDataCtrl = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0046", (ISRFDAWebContext)this.getWebContext());
        if (shortWordDataCtrl != null) {
            BaseDataEntity conds = new BaseDataEntity();
            conds.SetParamValue("SHORTWORDNAME", (Object)strShortWord);
            Vector<BaseDataEntity> list = new Vector<BaseDataEntity>();
            CallResult callResult = shortWordDataCtrl.Select(conds, list);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u77ed\u8bcd[%1$s]\u5bf9\u5e94\u7684\u5b8c\u6574\u8bcd\u53e5\u5931\u8d25\uff0c%2$s", (Object)strShortWord, (Object)callResult.getErrorInfo()));
                return;
            }
            for (BaseDataEntity baseDataEntity : list) {
                String strFullWord = baseDataEntity.GetParamStringValue("FULLWORD", "");
                if (StringHelper.IsNullOrEmpty((String)(strFullWord = strFullWord.trim()))) continue;
                fullwords.add(strFullWord);
            }
        }
    }

    protected String GetDAModelQueryScript(BaseDAQueryModelHelper daQueryModelHelper) {
        return daQueryModelHelper.GetQueryModelScript();
    }

    protected void FillDAQueryModelHelperCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
    }

    public void setACConfig(AutoCompleteConfig autoCompleteConfig) {
        this.autoCompleteConfig = autoCompleteConfig;
    }

    public AutoCompleteConfig getACConfig() {
        return this.autoCompleteConfig;
    }

    protected SRFDAPage getPage() {
        return (SRFDAPage)this.page;
    }

    protected SRFDAWebContext getWebContext() {
        return (SRFDAWebContext)super.getWebContext();
    }

    protected String getACUserMode() {
        return this.OnGetACUserMode();
    }

    protected String OnGetACUserMode() {
        String strACUserMode = this.getWebContext().GetPostValue("acusermode");
        return strACUserMode;
    }
}
