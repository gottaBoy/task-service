/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.CodeList.ICodeListFiller
 *  SA.SRFramework.CodeList.ICodeListFiller2
 *  SA.SRFramework.CodeList.ICodeListQuery
 *  SA.SRFramework.Data.BaseDBCallerHelper
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.CodeList;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.CodeList.ICodeListFiller;
import SA.SRFramework.CodeList.ICodeListFiller2;
import SA.SRFramework.CodeList.ICodeListQuery;
import SA.SRFramework.Data.BaseDBCallerHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DACodeListHelper
implements ICodeListFiller,
ICodeListQuery,
ICodeListFiller2 {
    private ISRFDAGlobalHelper iDAGlobalHelper = null;
    private static final Log log = LogFactory.getLog(DACodeListHelper.class);
    private String strTotalSQL = "";
    private String strQuerySQL = "";
    private String strDBStorage = "";

    protected boolean InitSQL(CodeListConfig codeListConfig) {
        String strKeyField;
        if (this.iDAGlobalHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5168\u5c40\u8f85\u52a9\u5bf9\u8c61"));
            return false;
        }
        String strDEId = codeListConfig.GetExtValue("DEID", "");
        if (StringHelper.IsNullOrEmpty((String)strDEId)) {
            log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53\u4ee3\u7801\u8868[%1$s]\u6ca1\u6709\u5b9a\u4e49\u5b9e\u4f53\u7f16\u53f7", (Object)codeListConfig.getID()));
            return false;
        }
        IDEHelper iDEHelper = this.iDAGlobalHelper.getDAModelStorage().FindDEHelper(strDEId);
        if (iDEHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53\u4ee3\u7801\u8868[%1$s]\u6ca1\u6709\u5b9a\u4e49\u5b9e\u4f53\u7f16\u53f7", (Object)codeListConfig.getID()));
            return false;
        }
        this.strDBStorage = iDEHelper.GetDBStorage();
        String strLanguage = codeListConfig.GetExtValue("LANGUAGE", "");
        String strTextField = codeListConfig.GetExtValue("TEXTFIELD", "");
        if (!StringHelper.IsNullOrEmpty((String)strLanguage)) {
            strTextField = codeListConfig.GetExtValue("TEXTFIELD." + strLanguage, "");
        }
        if (StringHelper.IsNullOrEmpty((String)strTextField)) {
            strTextField = iDEHelper.GetMajorDEFHelper().GetDTColumn().GetColumnName();
        }
        if (StringHelper.IsNullOrEmpty((String)(strKeyField = codeListConfig.GetExtValue("KEYFIELD", "")))) {
            strKeyField = iDEHelper.GetKeyDEFHelper().GetDTColumn().GetColumnName();
        }
        String strSQL = StringHelper.Format((String)"SELECT %1$s AS CODEITEMID ,%2$s AS CODEITEMTEXT FROM %3$s ", (Object)strKeyField, (Object)strTextField, (Object)iDEHelper.GetDEViewName());
        String strCondition = codeListConfig.GetExtValue("EXCONDITIION", "");
        if (StringHelper.IsNullOrEmpty((String)strCondition)) {
            strCondition = codeListConfig.GetExtValue("EXCONDITION", "");
        }
        if (iDEHelper.IsLogicValid()) {
            IDEFHelper iDEFHelper = iDEHelper.GetDEFHelperByPreDefineType("LOGICVALID");
            if (iDEFHelper != null) {
                if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                    strCondition = String.valueOf(strCondition) + " AND ";
                }
                strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"(%1$s = %2$s)", (Object)iDEFHelper.GetDTColumn().GetFormalColumnName(), (Object)iDEHelper.GetProperty("VALIDVALUE"));
            } else {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u7684\u903b\u8f91\u6709\u6548\u5c5e\u6027", (Object)iDEHelper.GetFullName()));
                return false;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
            strSQL = String.valueOf(strSQL) + " WHERE ";
            strSQL = String.valueOf(strSQL) + strCondition;
        }
        this.strTotalSQL = strSQL;
        this.strQuerySQL = strSQL;
        String strOrderInfo = codeListConfig.GetExtValue("ORDERINFO", "");
        if (!StringHelper.IsNullOrEmpty((String)strOrderInfo)) {
            this.strTotalSQL = String.valueOf(this.strTotalSQL) + "  ";
            this.strTotalSQL = String.valueOf(this.strTotalSQL) + strOrderInfo;
        }
        this.strQuerySQL = StringHelper.IsNullOrEmpty((String)strCondition) ? String.valueOf(this.strQuerySQL) + " WHERE " : String.valueOf(this.strQuerySQL) + " AND  ";
        this.strQuerySQL = String.valueOf(this.strQuerySQL) + StringHelper.Format((String)"%1$s='%%1$s'", (Object)strKeyField);
        return true;
    }

    public boolean Fill(BaseDBCallerHelper dbCallerHelper, CodeListConfig codeListConfig) {
        SelectResult selectResult;
        block11: {
            block10: {
                block9: {
                    block8: {
                        if (this.InitSQL(codeListConfig)) break block8;
                        return false;
                    }
                    selectResult = this.iDAGlobalHelper.getDBCaller(this.strDBStorage).CallRaw3(this.GetQueryTotalSQL(), null);
                    if (selectResult != null) break block9;
                    log.error((Object)StringHelper.Format((String)"\u6570\u636e\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c\u8fd4\u56de\u7a7a\u5bf9\u8c61"));
                    return false;
                }
                if (selectResult.getRetCode() == 0) break block10;
                log.error((Object)StringHelper.Format((String)"\u6570\u636e\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)selectResult.getErrorInfo()));
                return false;
            }
            if (selectResult.getMainTable() != null) break block11;
            log.error((Object)StringHelper.Format((String)"\u6570\u636e\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868"));
            return false;
        }
        try {
            int nRowCount = selectResult.getMainTable().GetRowCount();
            int i = 0;
            while (i < nRowCount) {
                CodeItemConfig codeItemConfig = this.GetCodeItemConfigFromDataRow(selectResult.getMainTable().GetRow(i));
                if (codeItemConfig != null) {
                    codeListConfig.AddCodeItemConfig(codeItemConfig);
                }
                ++i;
            }
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public CodeItemConfig Query(BaseDBCallerHelper dbCallerHelper, String strValue) {
        SelectResult selectResult;
        block9: {
            block8: {
                block7: {
                    block6: {
                        try {
                            selectResult = dbCallerHelper.CallRaw3(this.GetQueryValueSQL(strValue), null);
                            if (selectResult != null) break block6;
                            return null;
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                            return null;
                        }
                    }
                    if (selectResult.getRetCode() == 0) break block7;
                    return null;
                }
                if (selectResult.getMainTable() != null) break block8;
                return null;
            }
            int nRowCount = selectResult.getMainTable().GetRowCount();
            if (nRowCount != 0) break block9;
            return null;
        }
        return this.GetCodeItemConfigFromDataRow(selectResult.getMainTable().GetRow(0));
    }

    protected String GetQueryValueSQL(String strValue) {
        return StringHelper.Format((String)this.strQuerySQL, (Object)strValue);
    }

    protected String GetQueryTotalSQL() {
        return this.strTotalSQL;
    }

    protected CodeItemConfig GetCodeItemConfigFromDataRow(DataRow dr) throws Exception {
        try {
            CodeItemConfig codeItemConfig = new CodeItemConfig();
            codeItemConfig.setValue(dr.Get("CODEITEMID").toString());
            codeItemConfig.setText(dr.Get("CODEITEMTEXT").toString());
            return codeItemConfig;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void setGlobalHelper(ISRFExGlobalHelper iGlobalHelper) {
        this.iDAGlobalHelper = (ISRFDAGlobalHelper)iGlobalHelper;
    }
}

