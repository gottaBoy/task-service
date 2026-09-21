/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDBModelHelper
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper
 *  SA.SRFDA.Ctrl.Data.DEField
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDBModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MySQLDBModelHelper
extends BaseDBModelHelper {
    private static final Log log = LogFactory.getLog(MySQLDBModelHelper.class);

    protected void AppendSql_CreateTable(StringBuilderEx stringBuilder, boolean bMain, IDEHelper relatedDEHelper) {
        String strDEName = this.dataEntity.getDENAME().toUpperCase();
        String strTableName = this.GetTableName(bMain);
        IDEFHelper keyDEFHelper = null;
        if (relatedDEHelper != null) {
            keyDEFHelper = relatedDEHelper.GetKeyDEFHelper();
        }
        if (bMain) {
            this.dataEntity.setTABLENAME(strTableName);
        } else {
            this.dataEntity.setEXTABLENAME(strTableName);
        }
        stringBuilder.Append("CREATE TABLE %1$s(\n", (Object)strTableName);
        if (keyDEFHelper != null) {
            stringBuilder.Append("%1$s VARCHAR(100) NOT NULL,\n", (Object)keyDEFHelper.getName());
        } else {
            stringBuilder.Append("%1$sID VARCHAR(100) NOT NULL,\n", (Object)strDEName);
        }
        if (bMain) {
            if (keyDEFHelper == null) {
                stringBuilder.Append("%1$sNAME VARCHAR(200) NULL,\n", (Object)strDEName);
            }
            if (this.dataEntity.isLOGICVALID()) {
                stringBuilder.Append("ENABLE INT  NOT NULL,\n");
            }
            if (this.dataEntity.isINDEXDE()) {
                stringBuilder.Append("%1$sTYPE VARCHAR(100) NOT NULL,\n", (Object)strDEName);
                if (this.dataEntity.getINDEXMODE() == 1) {
                    stringBuilder.Append("%1$sID2 VARCHAR(100) NOT NULL,\n", (Object)strDEName);
                }
            }
        }
        stringBuilder.Append("CREATEMAN\tVARCHAR(60)\tNOT NULL,\n");
        stringBuilder.Append("CREATEDATE DATETIME\tNOT NULL,\n");
        stringBuilder.Append("UPDATEMAN\tVARCHAR(60)\tNOT NULL,\n");
        stringBuilder.Append("UPDATEDATE DATETIME\tNOT NULL\n");
        stringBuilder.Append(") ");
        stringBuilder.Append(";\n");
        if (keyDEFHelper != null) {
            stringBuilder.Append("ALTER TABLE %1$s\n", (Object)strTableName);
            stringBuilder.Append("ADD PRIMARY KEY (%1$s);\n", (Object)keyDEFHelper.getName());
        } else {
            stringBuilder.Append("ALTER TABLE %1$s\n", (Object)strTableName);
            stringBuilder.Append("ADD PRIMARY KEY (%1$sID);\n", (Object)strDEName);
        }
        if (!bMain) {
            String strMainTableName = this.dataEntity.getTABLENAME();
            if (keyDEFHelper != null) {
                stringBuilder.Append("ALTER TABLE %1$s\n", (Object)strTableName);
                stringBuilder.Append("ADD FOREIGN KEY (%1$s) REFERENCES %2$s (%1$s);\n", (Object)keyDEFHelper.getName(), (Object)strMainTableName);
            } else {
                stringBuilder.Append("ALTER TABLE %1$s\n", (Object)strTableName);
                stringBuilder.Append("ADD FOREIGN KEY (%1$sID) REFERENCES %2$s (%1$sID);\n", (Object)strDEName, (Object)strMainTableName);
            }
        } else if (keyDEFHelper != null) {
            String strMainTableName = this.dataEntity.getTABLENAME();
            stringBuilder.Append("ALTER TABLE %1$s\n", (Object)strTableName);
            stringBuilder.Append("ADD FOREIGN KEY (%1$s) REFERENCES %2$s (%1$s);\n", (Object)keyDEFHelper.getName(), (Object)strMainTableName);
        }
    }

    protected void AppendSql_AddColumn(StringBuilderEx stringBuilder, IDEFHelper iDEFHelper) {
        String strDataType = iDEFHelper.GetDTColumn().GetDBDataType(false, false, false, "");
        if (StringHelper.IsNullOrEmpty((String)strDataType)) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u6570\u636e\u5e93\u7c7b\u578b\u5931\u8d25", (Object)iDEFHelper.GetFullName()));
            return;
        }
        stringBuilder.Append("ALTER TABLE `%1$s`\n", (Object)iDEFHelper.GetDTColumn().GetTableName().toUpperCase());
        stringBuilder.Append("ADD  `%1$s` %2$s;\n", (Object)iDEFHelper.GetDTColumn().GetColumnName(), (Object)strDataType);
    }

    protected void AppendSql_AddPickupColumn(StringBuilderEx stringBuilder, IDEFHelper iDEFHelper) {
        String strDataType = iDEFHelper.GetDTColumn().GetDBDataType(false, false, false, "");
        if (StringHelper.IsNullOrEmpty((String)strDataType)) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u6570\u636e\u5e93\u7c7b\u578b\u5931\u8d25", (Object)iDEFHelper.GetFullName()));
            return;
        }
        stringBuilder.Append("ALTER TABLE  %1$s \n", (Object)iDEFHelper.GetDTColumn().GetTableName().toUpperCase());
        stringBuilder.Append("ADD %1$s %2$s;\n", (Object)iDEFHelper.GetDTColumn().GetColumnName(), (Object)strDataType);
        if (iDEFHelper instanceof IPickupDEFHelper) {
            DER1N der1n;
            IPickupDEFHelper pickupDEFHelper = (IPickupDEFHelper)iDEFHelper;
            boolean bAddForeignKey = true;
            if (StringHelper.Compare((String)pickupDEFHelper.getDEHelper().GetDBStorage(), (String)iDEFHelper.getDEHelper().GetDBStorage(), (boolean)true) != 0) {
                bAddForeignKey = false;
            }
            if (bAddForeignKey && (der1n = this.iDEHelper.FindDER1N(pickupDEFHelper.GetDERId())) != null) {
                bAddForeignKey = der1n.getFOREIGNKEY();
            }
            if (bAddForeignKey) {
                String strTableName = pickupDEFHelper.GetDTColumn().GetTableName();
                String strRealTableName = pickupDEFHelper.GetRealDEFHelper().GetDTColumn().GetTableName();
                String strRealColumnName = pickupDEFHelper.GetRealDEFHelper().GetDTColumn().GetColumnName();
                stringBuilder.Append("ALTER TABLE %1$s\n", (Object)strTableName);
                stringBuilder.Append("ADD FOREIGN KEY (%1$s) REFERENCES %2$s (%3$s);\n", (Object)pickupDEFHelper.getName(), (Object)strRealTableName, (Object)strRealColumnName.toUpperCase());
            }
        }
    }

    protected CallResult CallCreateDBModelSql(String arg0) {
        String[] arrSqls = arg0.split(";");
        CallResult callResult = new CallResult();
        int i = 0;
        while (i < arrSqls.length) {
            if (StringHelper.Length((String)arrSqls[i]) > 5) {
                try {
                    SelectResult selectResult = this.globalHelperEx.getDBCaller(this.getDEHelper().GetDBStorage()).CallRaw2(arrSqls[i]);
                    callResult.From((DBResult)selectResult);
                    if (callResult.getRetCode() != 0) {
                        log.error((Object)StringHelper.Format((String)"\u6267\u884c\u6570\u636e\u5e93\u6a21\u578b\u8bed\u53e5\u53d1\u751f\u9519\u8bef:\r\n%1$s", (Object)arrSqls[i]));
                        return callResult;
                    }
                }
                catch (Exception ex) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(ex.getMessage());
                    log.error((Object)StringHelper.Format((String)"\u6267\u884c\u6570\u636e\u5e93\u6a21\u578b\u8bed\u53e5\u53d1\u751f\u9519\u8bef:\r\n%1$s", (Object)arrSqls[i]), (Throwable)ex);
                    return callResult;
                }
            }
            ++i;
        }
        return callResult;
    }

    protected boolean GetTableColumnRealDataType(DEField field, BaseDataEntity dataType) {
        String strSQL = this.GetDEDataCtrlHelper().GetSQL_GetTableColumnDataType(field.getTABLENAME(), field.getDEFNAME());
        CallResult callResult = BaseDEDataCtrl.SelectSingleEx((ISRFDAGlobalHelper)this.globalHelperEx, (String)this.dataEntity.getDBSTORAGE(), (String)strSQL, (BaseDataEntity)dataType);
        if (callResult.getRetCode() != 0) {
            return false;
        }
        String strDataType = dataType.GetParamStringValue("TYPENAME", "");
        String strDataLength = dataType.GetParamStringValue("LENGTH", "");
        String strDataScale = dataType.GetParamStringValue("SCALE", "");
        return true;
    }

    public String GetDBType() {
        return "MYSQL";
    }

    protected CallResult AppendSql_CreateViewEx(StringBuilderEx script, String strViewName) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(1);
        if (StringHelper.IsNullOrEmpty((String)strViewName)) {
            log.error((Object)"\u89c6\u56fe\u540d\u79f0\u65e0\u6548\uff0c\u65e0\u6cd5\u5efa\u7acb");
            callResult.setErrorInfo("\u89c6\u56fe\u540d\u79f0\u65e0\u6548\uff0c\u65e0\u6cd5\u5efa\u7acb");
            return callResult;
        }
        script.Append("create  view %1$s as \n", (Object)strViewName);
        script.Append("SELECT\n");
        Vector<String> derList = new Vector<String>();
        TreeMap<String, Integer> derAliasMap = new TreeMap<String, Integer>();
        boolean bFirst = true;
        IDEFHelper keyDEFHelper = this.getDEHelper().GetKeyDEFHelper();
        if (keyDEFHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u7684\u4e3b\u952e\u5c5e\u6027 ", (Object)this.getDEHelper().GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
            if (!iDEFHelper.GetDTColumn().isViewColumn()) continue;
            callResult = this.GetDEFieldExp(iDEFHelper, "", derAliasMap, derList, "t");
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5c5e\u6027[%1$s]\u8868\u8fbe\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)iDEFHelper.getName(), (Object)callResult.getErrorInfo()));
                return callResult;
            }
            if (bFirst) {
                bFirst = false;
            } else {
                script.Append(",\n");
            }
            script.Append("%1$s AS `%2$s`", callResult.getUserObject(), (Object)iDEFHelper.GetDTColumn().GetFormalColumnName());
        }
        String strMainTable = this.iDEHelper.getDataEntity().getTABLENAME();
        String strUserTable = this.iDEHelper.getDataEntity().getEXTABLENAME();
        script.Append("\nFROM %1$s t1 \n", (Object)strMainTable);
        if (!StringHelper.IsNullOrEmpty((String)strUserTable)) {
            script.Append("INNER JOIN %1$s t2 ON t1.%2$s = t2.%2$s\n", (Object)strUserTable, (Object)keyDEFHelper.GetDTColumn().GetFormalColumnName());
        }
        TreeMap joinMap = new TreeMap();
        for (String strDERs : derList) {
            callResult = this.GetJoin(script, this.iDEHelper, "", strDERs, derAliasMap, joinMap, "t");
            if (callResult.getRetCode() == 0) continue;
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5173\u7cfb\u8fde\u63a5[%1$s]\u8868\u8fbe\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strDERs, (Object)callResult.getErrorInfo()));
            return callResult;
        }
        callResult.setRetCode(0);
        return callResult;
    }

    protected CallResult GetDEFieldExp(IDEFHelper iDEFHelper, String strParentDER, TreeMap<String, Integer> derAliasMap, Vector<String> derList, String strPreFix) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(1);
        IDEHelper iDEHelper = iDEFHelper.getDEHelper();
        if (iDEFHelper.IsFormulaDEField()) {
            String strFormulaFields = iDEFHelper.GetDTColumn().GetFormulaColumns();
            if (!StringHelper.IsNullOrEmpty((String)strFormulaFields)) {
                Object[] params = null;
                String[] strFields = strFormulaFields.split("[;]");
                params = new Object[strFields.length];
                int i = 0;
                while (i < strFields.length) {
                    String strDEFName = strFields[i].toUpperCase();
                    IDEFHelper argvField = iDEHelper.GetDEFHelper(strDEFName);
                    if (argvField == null) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u903b\u8f91\u5c5e\u6027\u53c2\u6570[%1$s]\u65e0\u6548", (Object)strDEFName));
                        log.error((Object)callResult.getErrorInfo());
                        return callResult;
                    }
                    callResult = this.GetDEFieldExp(argvField, strParentDER, derAliasMap, derList, strPreFix);
                    if (callResult.getRetCode() != 0) {
                        return callResult;
                    }
                    params[i] = callResult.getUserObject();
                    ++i;
                }
                String strExp = StringHelper.Format((String)iDEFHelper.GetDTColumn().GetFormulaFormat(), (Object[])params);
                callResult.setRetCode(0);
                callResult.setUserObject((Object)strExp);
                return callResult;
            }
            String strExp = StringHelper.Format((String)iDEFHelper.GetDTColumn().GetFormulaFormat());
            callResult.setRetCode(0);
            callResult.setUserObject((Object)strExp);
            return callResult;
        }
        String strDERID = "";
        ILinkDEFHelper linkDEFHelper = null;
        if (iDEFHelper instanceof ILinkDEFHelper) {
            linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
            strDERID = linkDEFHelper.GetDERId();
            if (StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUP", (boolean)true) == 0) {
                strDERID = "";
            } else if (StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) == 0 && iDEFHelper.getDEField().getDEFTYPE() == 1) {
                strDERID = "";
            }
        }
        if (StringHelper.IsNullOrEmpty((String)strDERID)) {
            String strMainTable = iDEHelper.GetMainTable();
            String strUserTable = iDEHelper.GetUserTable();
            String strMTAlias = "";
            String strUTAlias = "";
            if (StringHelper.IsNullOrEmpty((String)strParentDER)) {
                strMTAlias = String.valueOf(strPreFix) + "1";
                strUTAlias = String.valueOf(strPreFix) + "2";
            } else {
                if (!derAliasMap.containsKey(strParentDER)) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDER));
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                Integer nAlias = derAliasMap.get(strParentDER);
                strMTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 1));
                strUTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 2));
            }
            String strDEFTableName = iDEFHelper.GetDTColumn().GetTableName();
            if (StringHelper.Compare((String)strMainTable, (String)strDEFTableName, (boolean)true) == 0) {
                String strExp = StringHelper.Format((String)"%1$s.`%2$s`", (Object)strMTAlias, (Object)iDEFHelper.GetDTColumn().GetFormalColumnName());
                callResult.setRetCode(0);
                callResult.setUserObject((Object)strExp);
                return callResult;
            }
            if (StringHelper.Compare((String)strUserTable, (String)strDEFTableName, (boolean)true) == 0) {
                String strExp = StringHelper.Format((String)"%1$s.`%2$s`", (Object)strUTAlias, (Object)iDEFHelper.GetDTColumn().GetFormalColumnName());
                callResult.setRetCode(0);
                callResult.setUserObject((Object)strExp);
                return callResult;
            }
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5c5e\u6027[%1$s]\u8868\u540d[%2$s]", (Object)iDEFHelper.GetFullName(), (Object)strDEFTableName));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strNewDER = strParentDER;
        if (!StringHelper.IsNullOrEmpty((String)strNewDER)) {
            strNewDER = String.valueOf(strNewDER) + "|";
        }
        strNewDER = String.valueOf(strNewDER) + strDERID;
        IDEFHelper relatedDEFHelper = linkDEFHelper.GetRelatedDEFHelper();
        if (relatedDEFHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u7684\u5173\u7cfb\u5c5e\u6027", (Object)linkDEFHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        if (!derAliasMap.containsKey(strNewDER)) {
            Integer nCurIndex = derAliasMap.get("%CURVALUE%");
            if (nCurIndex == null) {
                nCurIndex = 0;
            }
            nCurIndex = nCurIndex + 10;
            derAliasMap.put(strNewDER, nCurIndex);
            derAliasMap.put("%CURVALUE%", nCurIndex);
            String strLastDERID = "";
            if (derList.size() > 0) {
                strLastDERID = derList.get(derList.size() - 1);
            }
            if (!(strNewDER.indexOf(strLastDERID) != 0 || strNewDER.length() != strLastDERID.length() && strNewDER.charAt(strLastDERID.length()) != '|' || StringHelper.IsNullOrEmpty((String)strLastDERID))) {
                derList.set(derList.size() - 1, strNewDER);
            } else {
                derList.add(strNewDER);
            }
        }
        return this.GetDEFieldExp(relatedDEFHelper, strNewDER, derAliasMap, derList, strPreFix);
    }
}

