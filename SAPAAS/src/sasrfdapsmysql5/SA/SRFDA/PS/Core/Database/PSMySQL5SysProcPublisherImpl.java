/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper
 *  SA.SRFDA.PS.Core.DEField.IPSDEField
 *  SA.SRFDA.PS.Core.DEField.IPSInheritDEField
 *  SA.SRFDA.PS.Core.Database.IPSDEFDTColumn
 *  SA.SRFDA.PS.Core.Database.PSDBSysProcPublisherImpl
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSInheritDEField;
import SA.SRFDA.PS.Core.Database.IPSDEFDTColumn;
import SA.SRFDA.PS.Core.Database.PSDBSysProcPublisherImpl;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSMySQL5SysProcPublisherImpl
extends PSDBSysProcPublisherImpl {
    private static final Log log = LogFactory.getLog(PSMySQL5SysProcPublisherImpl.class);
    public static final String TAG_VAR = "VAR_";
    public static final String TAG_VAREX = "VAREX_";
    public static final String TAG_VF = "VF_";

    protected void onPreparePublish() throws Exception {
        super.onPreparePublish();
    }

    protected String getCode_SystemParam(boolean bDelete) throws Exception {
        String strSystemParams = "";
        strSystemParams = String.valueOf(strSystemParams) + "IN SRF_PERSONID VARCHAR(60),\n";
        strSystemParams = String.valueOf(strSystemParams) + "IN SRF_ORGUNITID VARCHAR(60),\n";
        strSystemParams = String.valueOf(strSystemParams) + "IN SRF_ORGUNITNAME VARCHAR(60),\n";
        strSystemParams = String.valueOf(strSystemParams) + "OUT SRF_RETCODE INT,\n";
        strSystemParams = String.valueOf(strSystemParams) + "OUT SRF_RETINFO VARCHAR(1000),\n";
        strSystemParams = String.valueOf(strSystemParams) + "OUT SRF_RETINFORES VARCHAR(200),\n";
        strSystemParams = String.valueOf(strSystemParams) + "OUT SRF_RETINFORESARG VARCHAR(1000),\n";
        strSystemParams = String.valueOf(strSystemParams) + "OUT SRF_TAG VARCHAR(1000),\n";
        strSystemParams = String.valueOf(strSystemParams) + "IN SRF_ACTIONMODE VARCHAR(100),\n";
        strSystemParams = String.valueOf(strSystemParams) + "IN SRF_ACTIONARG VARCHAR(100),\n";
        if (this.bDALog) {
            strSystemParams = String.valueOf(strSystemParams) + "IN SRF_DALOG INT,\n";
        }
        strSystemParams = String.valueOf(strSystemParams) + "IN SRF_CHECKKEY INT";
        if (!bDelete) {
            strSystemParams = String.valueOf(strSystemParams) + ",IN SRF_RETDATA INT";
        }
        return strSystemParams;
    }

    protected abstract String getCode_SystemParam() throws Exception;

    protected String getCode_UserParam() throws Exception {
        if (StringHelper.Compare((String)this.getProcType(), (String)"GET", (boolean)true) == 0 || StringHelper.Compare((String)this.getProcType(), (String)"DELETE", (boolean)true) == 0) {
            return this.getCode_UserParam(true);
        }
        return this.getCode_UserParam(false);
    }

    protected String getCode_UserParam(boolean bKeyOnly) throws Exception {
        String strSQL = "";
        Iterator psDEFields = this.getPSDataEntity().getPSDEFields();
        while (psDEFields.hasNext()) {
            String strSQLParam;
            IPSDEField iPSDEField = (IPSDEField)psDEFields.next();
            if (bKeyOnly && !iPSDEField.isKeyDEField() || StringHelper.IsNullOrEmpty((String)(strSQLParam = this.getCode_UserParamItem(iPSDEField)))) continue;
            if (!StringHelper.IsNullOrEmpty((String)strSQL)) {
                strSQL = String.valueOf(strSQL) + ",\n";
            }
            if (StringHelper.IsNullOrEmpty((String)strSQLParam)) continue;
            strSQL = String.valueOf(strSQL) + strSQLParam;
        }
        return strSQL;
    }

    protected abstract String getCode_UserParamItem(IPSDEField var1) throws Exception;

    protected void onPublish() throws Exception {
        StringBuilderEx sb = new StringBuilderEx();
        sb.Append("DELIMITER $$\n\n");
        this.appendProcHeader(sb);
        this.appendProcBody(sb);
        sb.Append("\nDELIMITER ;\n");
        this.psDESysProcCode.setCOMPILEFLAG(99);
        this.psDESysProcCode.setFULLCODE(sb.toString());
    }

    protected void appendProcHeader(StringBuilderEx sb) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.strDBSCHEMA)) {
            sb.Append("CREATE PROCEDURE %1$s (\n", (Object)this.strProcName);
        } else {
            sb.Append("CREATE PROCEDURE %1$s.%2$s (\n", (Object)this.strDBSCHEMA, (Object)this.strProcName);
        }
        String strSystemParam = this.getCode_SystemParam();
        String strUserParam = this.getCode_UserParam();
        if (!StringHelper.IsNullOrEmpty((String)strSystemParam)) {
            sb.Append(strSystemParam);
        }
        if (!StringHelper.IsNullOrEmpty((String)strUserParam)) {
            if (!StringHelper.IsNullOrEmpty((String)strSystemParam)) {
                sb.Append(",\n");
            }
            sb.Append(strUserParam);
        }
        sb.Append("\n)\n");
    }

    protected void appendProcBody(StringBuilderEx sb) throws Exception {
        sb.Append("BEGIN\n");
        sb.Append(this.getCode_SystemDeclare());
        sb.Append("\n");
        sb.Append(this.getCode_UserDeclare());
        sb.Append("\n");
        sb.Append("BODY: LOOP\n");
        sb.Append(this.getCode_SystemInit());
        sb.Append("\n");
        sb.Append(this.getCode_UserInit());
        sb.Append("\n");
        sb.Append(this.getCode_Check());
        sb.Append("\n");
        sb.Append(this.getCode_BeforeAction());
        sb.Append("\n");
        sb.Append(this.getCode_Action());
        sb.Append("\n");
        sb.Append(this.getCode_AfterAction());
        sb.Append("\n");
        sb.Append("SET SRF_RETCODE= 0;\n");
        sb.Append("SET SRF_RETINFO='';\n");
        sb.Append("SET SRF_RETINFORES='';\n");
        sb.Append("LEAVE BODY;\n");
        sb.Append("END LOOP;\n");
        sb.Append("END$$\n");
    }

    protected String getCode_SystemDeclare() throws Exception {
        String strSystemDeclare = "declare nTemp INTEGER;\n";
        strSystemDeclare = String.valueOf(strSystemDeclare) + "declare SRF_CURTIME timestamp;";
        return strSystemDeclare;
    }

    protected String getCode_UserDeclare() throws Exception {
        String strSQL = "";
        Iterator it = this.getPSDataEntity().getPSDEFields();
        while (it.hasNext()) {
            IPSDEFDTColumn iPSDEFDTColumn;
            IPSDEField iPSDEField = (IPSDEField)it.next();
            if (!this.isUserDeclareItem(iPSDEField, iPSDEFDTColumn = iPSDEField.getPSDTColumn(this.getDBType()))) continue;
            if (!StringHelper.IsNullOrEmpty((String)strSQL)) {
                strSQL = String.valueOf(strSQL) + "\n";
            }
            strSQL = String.valueOf(strSQL) + this.getCode_UserDeclareItem(iPSDEField, iPSDEFDTColumn);
        }
        return strSQL;
    }

    protected abstract boolean isUserDeclareItem(IPSDEField var1, IPSDEFDTColumn var2) throws Exception;

    protected String getCode_UserDeclareItem(IPSDEField iPSDEField, IPSDEFDTColumn iPSDEFDTColumn) throws Exception {
        if (iPSDEField.isInheritDEField()) {
            IPSInheritDEField inheritDEFHelper = (IPSInheritDEField)iPSDEField;
            IPSDEFDTColumn iPSDEFDTColumn2 = inheritDEFHelper.getRelatedPSDEField().getPSDTColumn(this.getDBType());
            String strDBType = iPSDEFDTColumn2.getDBDataType(false, false, false, "");
            String strSQL = StringHelper.Format((String)"DECLARE %1$s%2$s %3$s;", (Object)TAG_VAREX, (Object)iPSDEFDTColumn2.getColumnName(), (Object)strDBType);
            return strSQL;
        }
        String strDBType = iPSDEFDTColumn.getDBDataType(false, false, false, "");
        String strSQL = StringHelper.Format((String)"DECLARE %1$s%2$s %3$s;", (Object)TAG_VAREX, (Object)iPSDEFDTColumn.getColumnName(), (Object)strDBType);
        return strSQL;
    }

    protected String getCode_SystemInit() throws Exception {
        String strSQL = "";
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"SELECT CURRENT timestamp INTO SRF_CURTIME FROM SYSIBM.SYSDUMMY1;\n");
        return strSQL;
    }

    protected String getCode_UserInit() throws Exception {
        String strSQL = "";
        Iterator it = this.getPSDataEntity().getPSDEFields();
        while (it.hasNext()) {
            IPSDEFDTColumn iPSDEFDTColumn;
            IPSDEField iPSDEField = (IPSDEField)it.next();
            if (!this.isUserDeclareItem(iPSDEField, iPSDEFDTColumn = iPSDEField.getPSDTColumn(this.getDBType()))) continue;
            if (!StringHelper.IsNullOrEmpty((String)strSQL)) {
                strSQL = String.valueOf(strSQL) + "\n";
            }
            strSQL = String.valueOf(strSQL) + this.getCode_UserInitItem(iPSDEField, iPSDEFDTColumn);
        }
        return strSQL;
    }

    protected abstract String getCode_UserInitItem(IPSDEField var1, IPSDEFDTColumn var2) throws Exception;

    protected abstract String getCode_Check() throws Exception;

    protected abstract String getCode_BeforeAction() throws Exception;

    protected abstract String getCode_Action() throws Exception;

    protected abstract String getCode_AfterAction() throws Exception;

    protected String getCode_Select(boolean bInsert) throws Exception {
        String strSQL = StringHelper.Format((String)"select m1.* from %1$s m1 ", (Object)this.getPSDataEntity().getViewName());
        String strCondition = this.getCode_PKeyCondition(bInsert, "m1");
        if (this.getPSDataEntity().isLogicValid()) {
            IPSDEField iValidDEFHelper;
            if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                strCondition = String.valueOf(strCondition) + " AND ";
            }
            if ((iValidDEFHelper = this.getPSDataEntity().getLogicValidPSDEField()) != null) {
                strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"(m1.%1$s = %2$s) ", (Object)iValidDEFHelper.getPSDTColumn(this.getDBType()).getColumnName(), (Object)this.iPSDEDBConfig.getLogicValidSQLCode(true));
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
            strSQL = String.valueOf(strSQL) + " WHERE ";
            strSQL = String.valueOf(strSQL) + strCondition;
        }
        return strSQL;
    }

    protected String getCode_PKeyCondition(boolean bInsert, String strAlias) throws Exception {
        String strCondition = "";
        Iterator it = this.getPSDataEntity().getPSDEFields();
        while (it.hasNext()) {
            IPSDEField iPSDEField = (IPSDEField)it.next();
            IPSDEFDTColumn iPSDEFDTColumn = iPSDEField.getPSDTColumn(this.getDBType());
            if (!iPSDEFDTColumn.isPKey()) continue;
            if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                strCondition = String.valueOf(strCondition) + " AND ";
            }
            strCondition = StringHelper.IsNullOrEmpty((String)strAlias) ? String.valueOf(strCondition) + StringHelper.Format((String)"(%1$s=%2$s)", (Object)iPSDEFDTColumn.getColumnName(), (Object)this.getCode_PKeyFieldValue(iPSDEField, iPSDEFDTColumn)) : String.valueOf(strCondition) + StringHelper.Format((String)"(%3$s.%1$s=%2$s)", (Object)iPSDEFDTColumn.getColumnName(), (Object)this.getCode_PKeyFieldValue(iPSDEField, iPSDEFDTColumn), (Object)strAlias);
        }
        return strCondition;
    }

    protected abstract String getCode_PKeyFieldValue(IPSDEField var1, IPSDEFDTColumn var2) throws Exception;

    protected String getFieldParamName(boolean bInsert, IPSDEField iPSDEField, IPSDEFDTColumn iPSDEFDTColumn) throws Exception {
        if (bInsert) {
            IInheritDEFHelper iInheritDEFHelper;
            IDEFHelper relatedDEFHelper;
            if (iPSDEFDTColumn.isValueAutoGen()) {
                return StringHelper.Format((String)"%1$s%2$s", (Object)TAG_VAREX, (Object)iPSDEFDTColumn.getColumnName());
            }
            if (iPSDEField != null && iPSDEField.isPhisicalDEField() && StringHelper.Compare((String)iPSDEField.getDataType(), (String)"PICKUPTEXT", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s%2$s", (Object)TAG_VAREX, (Object)iPSDEFDTColumn.getColumnName());
            }
            if (iPSDEField != null && iPSDEField.isInheritDEField() && (relatedDEFHelper = (iInheritDEFHelper = (IInheritDEFHelper)iPSDEField).GetRelatedDEFHelper()) != null && relatedDEFHelper.IsPhisicalDEField() && StringHelper.Compare((String)relatedDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s%2$s", (Object)TAG_VAREX, (Object)iPSDEFDTColumn.getColumnName());
            }
        }
        return StringHelper.Format((String)"%1$s%2$s", (Object)TAG_VAR, (Object)iPSDEFDTColumn.getColumnName());
    }
}

