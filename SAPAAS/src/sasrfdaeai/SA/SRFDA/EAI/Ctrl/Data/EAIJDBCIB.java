/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.EAI.Ctrl.Data;

import SA.SRFDA.EAI.Ctrl.Data.JDBCConnector;
import java.util.Date;

public class EAIJDBCIB
extends JDBCConnector {
    public static final String TAG_EAIJDBCIBID = "EAIJDBCIBID";
    public static final String TAG_EAIJDBCIBNAME = "EAIJDBCIBNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_FREQUENCY = "FREQUENCY";
    public static final String TAG_SQLCMD = "SQLCMD";
    public static final String TAG_EAIDATASOURCENAME = "EAIDATASOURCENAME";
    public static final String TAG_EAIPROCESSNAME = "EAIPROCESSNAME";
    public static final String TAG_EAIDATASOURCEID = "EAIDATASOURCEID";
    public static final String TAG_EAIPROCESSID = "EAIPROCESSID";

    public String getEAIJDBCIBID() {
        return this.GetParamStringValue(TAG_EAIJDBCIBID, "");
    }

    public void setEAIJDBCIBID(String strValue) {
        this.SetParamValue(TAG_EAIJDBCIBID, strValue);
    }

    public String getEAIJDBCIBNAME() {
        return this.GetParamStringValue(TAG_EAIJDBCIBNAME, "");
    }

    public void setEAIJDBCIBNAME(String strValue) {
        this.SetParamValue(TAG_EAIJDBCIBNAME, strValue);
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

    public String getFREQUENCY() {
        return this.GetParamStringValue(TAG_FREQUENCY, "");
    }

    public void setFREQUENCY(String strValue) {
        this.SetParamValue(TAG_FREQUENCY, strValue);
    }

    public String getSQLCMD() {
        return this.GetParamStringValue(TAG_SQLCMD, "");
    }

    public void setSQLCMD(String strValue) {
        this.SetParamValue(TAG_SQLCMD, strValue);
    }

    public String getEAIDATASOURCENAME() {
        return this.GetParamStringValue(TAG_EAIDATASOURCENAME, "");
    }

    public void setEAIDATASOURCENAME(String strValue) {
        this.SetParamValue(TAG_EAIDATASOURCENAME, strValue);
    }

    public String getEAIPROCESSNAME() {
        return this.GetParamStringValue(TAG_EAIPROCESSNAME, "");
    }

    public void setEAIPROCESSNAME(String strValue) {
        this.SetParamValue(TAG_EAIPROCESSNAME, strValue);
    }

    public String getEAIDATASOURCEID() {
        return this.GetParamStringValue(TAG_EAIDATASOURCEID, "");
    }

    public void setEAIDATASOURCEID(String strValue) {
        this.SetParamValue(TAG_EAIDATASOURCEID, strValue);
    }

    public String getEAIPROCESSID() {
        return this.GetParamStringValue(TAG_EAIPROCESSID, "");
    }

    public void setEAIPROCESSID(String strValue) {
        this.SetParamValue(TAG_EAIPROCESSID, strValue);
    }
}

