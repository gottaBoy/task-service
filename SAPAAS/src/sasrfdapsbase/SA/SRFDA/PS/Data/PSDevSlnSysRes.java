/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevSlnSysRes
extends BaseDataEntity {
    public static final int RESPOS_1 = 1;
    public static final int RESPOS_2 = 2;
    public static final int RESPOS_5 = 5;
    public static final String TAG_PSDEVSLNSYSRESID = "PSDEVSLNSYSRESID";
    public static final String TAG_PSDEVSLNSYSRESNAME = "PSDEVSLNSYSRESNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_RESINFO = "RESINFO";
    public static final String TAG_PSDEVSLNID = "PSDEVSLNID";
    public static final String TAG_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String TAG_MYSQLPSDCDBINSTID = "MYSQLPSDCDBINSTID";
    public static final String TAG_MYSQLPSDCDBINSTNAME = "MYSQLPSDCDBINSTNAME";
    public static final String TAG_UMYSQLPSDCDBINSTID = "UMYSQLPSDCDBINSTID";
    public static final String TAG_UMYSQLPSDCDBINSTNAME = "UMYSQLPSDCDBINSTNAME";
    public static final String TAG_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String TAG_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String TAG_ROPSDEVCENTERSVNID = "ROPSDEVCENTERSVNID";
    public static final String TAG_ROPSDEVCENTERSVNNAME = "ROPSDEVCENTERSVNNAME";
    public static final String TAG_DB2PSDCDBINSTID = "DB2PSDCDBINSTID";
    public static final String TAG_DB2PSDCDBINSTNAME = "DB2PSDCDBINSTNAME";
    public static final String TAG_UDB2PSDCDBINSTID = "UDB2PSDCDBINSTID";
    public static final String TAG_UDB2PSDCDBINSTNAME = "UDB2PSDCDBINSTNAME";
    public static final String TAG_MSSQLPSDCDBINSTID = "MSSQLPSDCDBINSTID";
    public static final String TAG_MSSQLPSDCDBINSTNAME = "MSSQLPSDCDBINSTNAME";
    public static final String TAG_UMSSQLPSDCDBINSTID = "UMSSQLPSDCDBINSTID";
    public static final String TAG_UMSSQLPSDCDBINSTNAME = "UMSSQLPSDCDBINSTNAME";
    public static final String TAG_ORAPSDCDBINSTID = "ORAPSDCDBINSTID";
    public static final String TAG_ORAPSDCDBINSTNAME = "ORAPSDCDBINSTNAME";
    public static final String TAG_UORAPSDCDBINSTID = "UORAPSDCDBINSTID";
    public static final String TAG_UORAPSDCDBINSTNAME = "UORAPSDCDBINSTNAME";
    public static final String TAG_PGSQLPSDCDBINSTID = "PGSQLPSDCDBINSTID";
    public static final String TAG_PGSQLPSDCDBINSTNAME = "PGSQLPSDCDBINSTNAME";
    public static final String TAG_UPGSQLPSDCDBINSTID = "UPGSQLPSDCDBINSTID";
    public static final String TAG_UPGSQLPSDCDBINSTNAME = "UPGSQLPSDCDBINSTNAME";
    public static final String TAG_PPASPSDCDBINSTID = "PPASPSDCDBINSTID";
    public static final String TAG_PPASPSDCDBINSTNAME = "PPASPSDCDBINSTNAME";
    public static final String TAG_UPPASPSDCDBINSTID = "UPPASPSDCDBINSTID";
    public static final String TAG_UPPASPSDCDBINSTNAME = "UPPASPSDCDBINSTNAME";
    public static final String TAG_PSDEVCENTERASID = "PSDEVCENTERASID";
    public static final String TAG_PSDEVCENTERASNAME = "PSDEVCENTERASNAME";
    public static final String TAG_UPSDEVCENTERASID = "UPSDEVCENTERASID";
    public static final String TAG_UPSDEVCENTERASNAME = "UPSDEVCENTERASNAME";
    public static final String TAG_PSDEVCENTERASID2 = "PSDEVCENTERASID2";
    public static final String TAG_PSDEVCENTERASNAME2 = "PSDEVCENTERASNAME2";
    public static final String TAG_UPSDEVCENTERASID2 = "UPSDEVCENTERASID2";
    public static final String TAG_UPSDEVCENTERASNAME2 = "UPSDEVCENTERASNAME2";
    public static final String TAG_HBASEPSDCBDINSTID = "HBASEPSDCBDINSTID";
    public static final String TAG_HBASEPSDCBDINSTNAME = "HBASEPSDCBDINSTNAME";
    public static final String TAG_UHBASEPSDCBDINSTID = "UHBASEPSDCBDINSTID";
    public static final String TAG_UHBASEPSDCBDINSTNAME = "UHBASEPSDCBDINSTNAME";
    public static final String TAG_RESPOS = "RESPOS";
    public static final String TAG_PSDCDEPLOYSERVERID = "PSDCDEPLOYSERVERID";
    public static final String TAG_PSDCDEPLOYSERVERNAME = "PSDCDEPLOYSERVERNAME";

    public final boolean isPSDEVSLNSYSRESIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSRESID);
    }

    public final String getPSDEVSLNSYSRESID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSRESID, "");
    }

    public final void setPSDEVSLNSYSRESID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSRESID, strValue);
    }

    public final boolean isPSDEVSLNSYSRESNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSRESNAME);
    }

    public final String getPSDEVSLNSYSRESNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSRESNAME, "");
    }

    public final void setPSDEVSLNSYSRESNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSRESNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isRESINFONull() {
        return this.IsParamNull(TAG_RESINFO);
    }

    public final String getRESINFO() {
        return this.GetParamStringValue(TAG_RESINFO, "");
    }

    public final void setRESINFO(String strValue) {
        this.SetParamValue(TAG_RESINFO, strValue);
    }

    public final boolean isPSDEVSLNIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNID);
    }

    public final String getPSDEVSLNID() {
        return this.GetParamStringValue(TAG_PSDEVSLNID, "");
    }

    public final void setPSDEVSLNID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNID, strValue);
    }

    public final boolean isPSDEVSLNNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNNAME);
    }

    public final String getPSDEVSLNNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNNAME, "");
    }

    public final void setPSDEVSLNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNNAME, strValue);
    }

    public final boolean isMYSQLPSDCDBINSTIDNull() {
        return this.IsParamNull(TAG_MYSQLPSDCDBINSTID);
    }

    public final String getMYSQLPSDCDBINSTID() {
        return this.GetParamStringValue(TAG_MYSQLPSDCDBINSTID, "");
    }

    public final void setMYSQLPSDCDBINSTID(String strValue) {
        this.SetParamValue(TAG_MYSQLPSDCDBINSTID, strValue);
    }

    public final boolean isMYSQLPSDCDBINSTNAMENull() {
        return this.IsParamNull(TAG_MYSQLPSDCDBINSTNAME);
    }

    public final String getMYSQLPSDCDBINSTNAME() {
        return this.GetParamStringValue(TAG_MYSQLPSDCDBINSTNAME, "");
    }

    public final void setMYSQLPSDCDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_MYSQLPSDCDBINSTNAME, strValue);
    }

    public final boolean isUMYSQLPSDCDBINSTIDNull() {
        return this.IsParamNull(TAG_UMYSQLPSDCDBINSTID);
    }

    public final String getUMYSQLPSDCDBINSTID() {
        return this.GetParamStringValue(TAG_UMYSQLPSDCDBINSTID, "");
    }

    public final void setUMYSQLPSDCDBINSTID(String strValue) {
        this.SetParamValue(TAG_UMYSQLPSDCDBINSTID, strValue);
    }

    public final boolean isUMYSQLPSDCDBINSTNAMENull() {
        return this.IsParamNull(TAG_UMYSQLPSDCDBINSTNAME);
    }

    public final String getUMYSQLPSDCDBINSTNAME() {
        return this.GetParamStringValue(TAG_UMYSQLPSDCDBINSTNAME, "");
    }

    public final void setUMYSQLPSDCDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_UMYSQLPSDCDBINSTNAME, strValue);
    }

    public final boolean isPSDEVCENTERSVNIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERSVNID);
    }

    public final String getPSDEVCENTERSVNID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERSVNID, "");
    }

    public final void setPSDEVCENTERSVNID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERSVNID, strValue);
    }

    public final boolean isPSDEVCENTERSVNNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERSVNNAME);
    }

    public final String getPSDEVCENTERSVNNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERSVNNAME, "");
    }

    public final void setPSDEVCENTERSVNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERSVNNAME, strValue);
    }

    public final boolean isROPSDEVCENTERSVNIDNull() {
        return this.IsParamNull(TAG_ROPSDEVCENTERSVNID);
    }

    public final String getROPSDEVCENTERSVNID() {
        return this.GetParamStringValue(TAG_ROPSDEVCENTERSVNID, "");
    }

    public final void setROPSDEVCENTERSVNID(String strValue) {
        this.SetParamValue(TAG_ROPSDEVCENTERSVNID, strValue);
    }

    public final boolean isROPSDEVCENTERSVNNAMENull() {
        return this.IsParamNull(TAG_ROPSDEVCENTERSVNNAME);
    }

    public final String getROPSDEVCENTERSVNNAME() {
        return this.GetParamStringValue(TAG_ROPSDEVCENTERSVNNAME, "");
    }

    public final void setROPSDEVCENTERSVNNAME(String strValue) {
        this.SetParamValue(TAG_ROPSDEVCENTERSVNNAME, strValue);
    }

    public final boolean isDB2PSDCDBINSTIDNull() {
        return this.IsParamNull(TAG_DB2PSDCDBINSTID);
    }

    public final String getDB2PSDCDBINSTID() {
        return this.GetParamStringValue(TAG_DB2PSDCDBINSTID, "");
    }

    public final void setDB2PSDCDBINSTID(String strValue) {
        this.SetParamValue(TAG_DB2PSDCDBINSTID, strValue);
    }

    public final boolean isDB2PSDCDBINSTNAMENull() {
        return this.IsParamNull(TAG_DB2PSDCDBINSTNAME);
    }

    public final String getDB2PSDCDBINSTNAME() {
        return this.GetParamStringValue(TAG_DB2PSDCDBINSTNAME, "");
    }

    public final void setDB2PSDCDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_DB2PSDCDBINSTNAME, strValue);
    }

    public final boolean isUDB2PSDCDBINSTIDNull() {
        return this.IsParamNull(TAG_UDB2PSDCDBINSTID);
    }

    public final String getUDB2PSDCDBINSTID() {
        return this.GetParamStringValue(TAG_UDB2PSDCDBINSTID, "");
    }

    public final void setUDB2PSDCDBINSTID(String strValue) {
        this.SetParamValue(TAG_UDB2PSDCDBINSTID, strValue);
    }

    public final boolean isUDB2PSDCDBINSTNAMENull() {
        return this.IsParamNull(TAG_UDB2PSDCDBINSTNAME);
    }

    public final String getUDB2PSDCDBINSTNAME() {
        return this.GetParamStringValue(TAG_UDB2PSDCDBINSTNAME, "");
    }

    public final void setUDB2PSDCDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_UDB2PSDCDBINSTNAME, strValue);
    }

    public final boolean isMSSQLPSDCDBINSTIDNull() {
        return this.IsParamNull(TAG_MSSQLPSDCDBINSTID);
    }

    public final String getMSSQLPSDCDBINSTID() {
        return this.GetParamStringValue(TAG_MSSQLPSDCDBINSTID, "");
    }

    public final void setMSSQLPSDCDBINSTID(String strValue) {
        this.SetParamValue(TAG_MSSQLPSDCDBINSTID, strValue);
    }

    public final boolean isMSSQLPSDCDBINSTNAMENull() {
        return this.IsParamNull(TAG_MSSQLPSDCDBINSTNAME);
    }

    public final String getMSSQLPSDCDBINSTNAME() {
        return this.GetParamStringValue(TAG_MSSQLPSDCDBINSTNAME, "");
    }

    public final void setMSSQLPSDCDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_MSSQLPSDCDBINSTNAME, strValue);
    }

    public final boolean isUMSSQLPSDCDBINSTIDNull() {
        return this.IsParamNull(TAG_UMSSQLPSDCDBINSTID);
    }

    public final String getUMSSQLPSDCDBINSTID() {
        return this.GetParamStringValue(TAG_UMSSQLPSDCDBINSTID, "");
    }

    public final void setUMSSQLPSDCDBINSTID(String strValue) {
        this.SetParamValue(TAG_UMSSQLPSDCDBINSTID, strValue);
    }

    public final boolean isUMSSQLPSDCDBINSTNAMENull() {
        return this.IsParamNull(TAG_UMSSQLPSDCDBINSTNAME);
    }

    public final String getUMSSQLPSDCDBINSTNAME() {
        return this.GetParamStringValue(TAG_UMSSQLPSDCDBINSTNAME, "");
    }

    public final void setUMSSQLPSDCDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_UMSSQLPSDCDBINSTNAME, strValue);
    }

    public final boolean isORAPSDCDBINSTIDNull() {
        return this.IsParamNull(TAG_ORAPSDCDBINSTID);
    }

    public final String getORAPSDCDBINSTID() {
        return this.GetParamStringValue(TAG_ORAPSDCDBINSTID, "");
    }

    public final void setORAPSDCDBINSTID(String strValue) {
        this.SetParamValue(TAG_ORAPSDCDBINSTID, strValue);
    }

    public final boolean isORAPSDCDBINSTNAMENull() {
        return this.IsParamNull(TAG_ORAPSDCDBINSTNAME);
    }

    public final String getORAPSDCDBINSTNAME() {
        return this.GetParamStringValue(TAG_ORAPSDCDBINSTNAME, "");
    }

    public final void setORAPSDCDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_ORAPSDCDBINSTNAME, strValue);
    }

    public final boolean isUORAPSDCDBINSTIDNull() {
        return this.IsParamNull(TAG_UORAPSDCDBINSTID);
    }

    public final String getUORAPSDCDBINSTID() {
        return this.GetParamStringValue(TAG_UORAPSDCDBINSTID, "");
    }

    public final void setUORAPSDCDBINSTID(String strValue) {
        this.SetParamValue(TAG_UORAPSDCDBINSTID, strValue);
    }

    public final boolean isUORAPSDCDBINSTNAMENull() {
        return this.IsParamNull(TAG_UORAPSDCDBINSTNAME);
    }

    public final String getUORAPSDCDBINSTNAME() {
        return this.GetParamStringValue(TAG_UORAPSDCDBINSTNAME, "");
    }

    public final void setUORAPSDCDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_UORAPSDCDBINSTNAME, strValue);
    }

    public final boolean isPGSQLPSDCDBINSTIDNull() {
        return this.IsParamNull(TAG_PGSQLPSDCDBINSTID);
    }

    public final String getPGSQLPSDCDBINSTID() {
        return this.GetParamStringValue(TAG_PGSQLPSDCDBINSTID, "");
    }

    public final void setPGSQLPSDCDBINSTID(String strValue) {
        this.SetParamValue(TAG_PGSQLPSDCDBINSTID, strValue);
    }

    public final boolean isPGSQLPSDCDBINSTNAMENull() {
        return this.IsParamNull(TAG_PGSQLPSDCDBINSTNAME);
    }

    public final String getPGSQLPSDCDBINSTNAME() {
        return this.GetParamStringValue(TAG_PGSQLPSDCDBINSTNAME, "");
    }

    public final void setPGSQLPSDCDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_PGSQLPSDCDBINSTNAME, strValue);
    }

    public final boolean isUPGSQLPSDCDBINSTIDNull() {
        return this.IsParamNull(TAG_UPGSQLPSDCDBINSTID);
    }

    public final String getUPGSQLPSDCDBINSTID() {
        return this.GetParamStringValue(TAG_UPGSQLPSDCDBINSTID, "");
    }

    public final void setUPGSQLPSDCDBINSTID(String strValue) {
        this.SetParamValue(TAG_UPGSQLPSDCDBINSTID, strValue);
    }

    public final boolean isUPGSQLPSDCDBINSTNAMENull() {
        return this.IsParamNull(TAG_UPGSQLPSDCDBINSTNAME);
    }

    public final String getUPGSQLPSDCDBINSTNAME() {
        return this.GetParamStringValue(TAG_UPGSQLPSDCDBINSTNAME, "");
    }

    public final void setUPGSQLPSDCDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_UPGSQLPSDCDBINSTNAME, strValue);
    }

    public final boolean isPPASPSDCDBINSTIDNull() {
        return this.IsParamNull(TAG_PPASPSDCDBINSTID);
    }

    public final String getPPASPSDCDBINSTID() {
        return this.GetParamStringValue(TAG_PPASPSDCDBINSTID, "");
    }

    public final void setPPASPSDCDBINSTID(String strValue) {
        this.SetParamValue(TAG_PPASPSDCDBINSTID, strValue);
    }

    public final boolean isPPASPSDCDBINSTNAMENull() {
        return this.IsParamNull(TAG_PPASPSDCDBINSTNAME);
    }

    public final String getPPASPSDCDBINSTNAME() {
        return this.GetParamStringValue(TAG_PPASPSDCDBINSTNAME, "");
    }

    public final void setPPASPSDCDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_PPASPSDCDBINSTNAME, strValue);
    }

    public final boolean isUPPASPSDCDBINSTIDNull() {
        return this.IsParamNull(TAG_UPPASPSDCDBINSTID);
    }

    public final String getUPPASPSDCDBINSTID() {
        return this.GetParamStringValue(TAG_UPPASPSDCDBINSTID, "");
    }

    public final void setUPPASPSDCDBINSTID(String strValue) {
        this.SetParamValue(TAG_UPPASPSDCDBINSTID, strValue);
    }

    public final boolean isUPPASPSDCDBINSTNAMENull() {
        return this.IsParamNull(TAG_UPPASPSDCDBINSTNAME);
    }

    public final String getUPPASPSDCDBINSTNAME() {
        return this.GetParamStringValue(TAG_UPPASPSDCDBINSTNAME, "");
    }

    public final void setUPPASPSDCDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_UPPASPSDCDBINSTNAME, strValue);
    }

    public final boolean isPSDEVCENTERASIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERASID);
    }

    public final String getPSDEVCENTERASID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERASID, "");
    }

    public final void setPSDEVCENTERASID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERASID, strValue);
    }

    public final boolean isPSDEVCENTERASNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERASNAME);
    }

    public final String getPSDEVCENTERASNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERASNAME, "");
    }

    public final void setPSDEVCENTERASNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERASNAME, strValue);
    }

    public final boolean isUPSDEVCENTERASIDNull() {
        return this.IsParamNull(TAG_UPSDEVCENTERASID);
    }

    public final String getUPSDEVCENTERASID() {
        return this.GetParamStringValue(TAG_UPSDEVCENTERASID, "");
    }

    public final void setUPSDEVCENTERASID(String strValue) {
        this.SetParamValue(TAG_UPSDEVCENTERASID, strValue);
    }

    public final boolean isUPSDEVCENTERASNAMENull() {
        return this.IsParamNull(TAG_UPSDEVCENTERASNAME);
    }

    public final String getUPSDEVCENTERASNAME() {
        return this.GetParamStringValue(TAG_UPSDEVCENTERASNAME, "");
    }

    public final void setUPSDEVCENTERASNAME(String strValue) {
        this.SetParamValue(TAG_UPSDEVCENTERASNAME, strValue);
    }

    public final boolean isPSDEVCENTERASID2Null() {
        return this.IsParamNull(TAG_PSDEVCENTERASID2);
    }

    public final String getPSDEVCENTERASID2() {
        return this.GetParamStringValue(TAG_PSDEVCENTERASID2, "");
    }

    public final void setPSDEVCENTERASID2(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERASID2, strValue);
    }

    public final boolean isPSDEVCENTERASNAME2Null() {
        return this.IsParamNull(TAG_PSDEVCENTERASNAME2);
    }

    public final String getPSDEVCENTERASNAME2() {
        return this.GetParamStringValue(TAG_PSDEVCENTERASNAME2, "");
    }

    public final void setPSDEVCENTERASNAME2(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERASNAME2, strValue);
    }

    public final boolean isUPSDEVCENTERASID2Null() {
        return this.IsParamNull(TAG_UPSDEVCENTERASID2);
    }

    public final String getUPSDEVCENTERASID2() {
        return this.GetParamStringValue(TAG_UPSDEVCENTERASID2, "");
    }

    public final void setUPSDEVCENTERASID2(String strValue) {
        this.SetParamValue(TAG_UPSDEVCENTERASID2, strValue);
    }

    public final boolean isUPSDEVCENTERASNAME2Null() {
        return this.IsParamNull(TAG_UPSDEVCENTERASNAME2);
    }

    public final String getUPSDEVCENTERASNAME2() {
        return this.GetParamStringValue(TAG_UPSDEVCENTERASNAME2, "");
    }

    public final void setUPSDEVCENTERASNAME2(String strValue) {
        this.SetParamValue(TAG_UPSDEVCENTERASNAME2, strValue);
    }

    public final boolean isHBASEPSDCBDINSTIDNull() {
        return this.IsParamNull(TAG_HBASEPSDCBDINSTID);
    }

    public final String getHBASEPSDCBDINSTID() {
        return this.GetParamStringValue(TAG_HBASEPSDCBDINSTID, "");
    }

    public final void setHBASEPSDCBDINSTID(String strValue) {
        this.SetParamValue(TAG_HBASEPSDCBDINSTID, strValue);
    }

    public final boolean isHBASEPSDCBDINSTNAMENull() {
        return this.IsParamNull(TAG_HBASEPSDCBDINSTNAME);
    }

    public final String getHBASEPSDCBDINSTNAME() {
        return this.GetParamStringValue(TAG_HBASEPSDCBDINSTNAME, "");
    }

    public final void setHBASEPSDCBDINSTNAME(String strValue) {
        this.SetParamValue(TAG_HBASEPSDCBDINSTNAME, strValue);
    }

    public final boolean isUHBASEPSDCBDINSTIDNull() {
        return this.IsParamNull(TAG_UHBASEPSDCBDINSTID);
    }

    public final String getUHBASEPSDCBDINSTID() {
        return this.GetParamStringValue(TAG_UHBASEPSDCBDINSTID, "");
    }

    public final void setUHBASEPSDCBDINSTID(String strValue) {
        this.SetParamValue(TAG_UHBASEPSDCBDINSTID, strValue);
    }

    public final boolean isUHBASEPSDCBDINSTNAMENull() {
        return this.IsParamNull(TAG_UHBASEPSDCBDINSTNAME);
    }

    public final String getUHBASEPSDCBDINSTNAME() {
        return this.GetParamStringValue(TAG_UHBASEPSDCBDINSTNAME, "");
    }

    public final void setUHBASEPSDCBDINSTNAME(String strValue) {
        this.SetParamValue(TAG_UHBASEPSDCBDINSTNAME, strValue);
    }

    public final boolean isRESPOSNull() {
        return this.IsParamNull(TAG_RESPOS);
    }

    public final int getRESPOS() {
        return this.GetParamIntValue(TAG_RESPOS, 0);
    }

    public final void setRESPOS(int nValue) {
        this.SetParamValue(TAG_RESPOS, nValue);
    }

    public final boolean isPSDCDEPLOYSERVERIDNull() {
        return this.IsParamNull(TAG_PSDCDEPLOYSERVERID);
    }

    public final String getPSDCDEPLOYSERVERID() {
        return this.GetParamStringValue(TAG_PSDCDEPLOYSERVERID, "");
    }

    public final void setPSDCDEPLOYSERVERID(String strValue) {
        this.SetParamValue(TAG_PSDCDEPLOYSERVERID, strValue);
    }

    public final boolean isPSDCDEPLOYSERVERNAMENull() {
        return this.IsParamNull(TAG_PSDCDEPLOYSERVERNAME);
    }

    public final String getPSDCDEPLOYSERVERNAME() {
        return this.GetParamStringValue(TAG_PSDCDEPLOYSERVERNAME, "");
    }

    public final void setPSDCDEPLOYSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSDCDEPLOYSERVERNAME, strValue);
    }
}

