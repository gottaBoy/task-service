/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.EAI.Ctrl.Data;

import SA.SRFDA.EAI.Ctrl.Data.JDBCConnector;
import java.util.Date;

public class EAIJDBCOB
extends JDBCConnector {
    public static final String TAG_EAIJDBCOBID = "EAIJDBCOBID";
    public static final String TAG_EAIJDBCOBNAME = "EAIJDBCOBNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_EAIPROCESSNAME = "EAIPROCESSNAME";
    public static final String TAG_EAIDATASOURCENAME = "EAIDATASOURCENAME";
    public static final String TAG_EAIPROCESSID = "EAIPROCESSID";
    public static final String TAG_EAIDATASOURCEID = "EAIDATASOURCEID";
    public static final String TAG_SQLCMD = "SQLCMD";

    public String getEAIJDBCOBID() {
        return this.GetParamStringValue(TAG_EAIJDBCOBID, "");
    }

    public void setEAIJDBCOBID(String strValue) {
        this.SetParamValue(TAG_EAIJDBCOBID, strValue);
    }

    public String getEAIJDBCOBNAME() {
        return this.GetParamStringValue(TAG_EAIJDBCOBNAME, "");
    }

    public void setEAIJDBCOBNAME(String strValue) {
        this.SetParamValue(TAG_EAIJDBCOBNAME, strValue);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public String getEAIPROCESSNAME() {
        return this.GetParamStringValue(TAG_EAIPROCESSNAME, "");
    }

    public void setEAIPROCESSNAME(String strValue) {
        this.SetParamValue(TAG_EAIPROCESSNAME, strValue);
    }

    public String getEAIDATASOURCENAME() {
        return this.GetParamStringValue(TAG_EAIDATASOURCENAME, "");
    }

    public void setEAIDATASOURCENAME(String strValue) {
        this.SetParamValue(TAG_EAIDATASOURCENAME, strValue);
    }

    public String getEAIPROCESSID() {
        return this.GetParamStringValue(TAG_EAIPROCESSID, "");
    }

    public void setEAIPROCESSID(String strValue) {
        this.SetParamValue(TAG_EAIPROCESSID, strValue);
    }

    public String getEAIDATASOURCEID() {
        return this.GetParamStringValue(TAG_EAIDATASOURCEID, "");
    }

    public void setEAIDATASOURCEID(String strValue) {
        this.SetParamValue(TAG_EAIDATASOURCEID, strValue);
    }

    public String getSQLCMD() {
        return this.GetParamStringValue(TAG_SQLCMD, "");
    }

    public void setSQLCMD(String strValue) {
        this.SetParamValue(TAG_SQLCMD, strValue);
    }
}

