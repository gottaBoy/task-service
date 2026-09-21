/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DataSyncAgent
extends BaseDataEntity {
    public static final String AGENTTYPE_ACTIVEMQ = "ACTIVEMQ";
    public static final String SYNCDIR_IN = "IN";
    public static final String SYNCDIR_OUT = "OUT";
    public static final String TAG_DATASYNCAGENTID = "DATASYNCAGENTID";
    public static final String TAG_DATASYNCAGENTNAME = "DATASYNCAGENTNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_AGENTTYPE = "AGENTTYPE";
    public static final String TAG_SYNCDIR = "SYNCDIR";
    public static final String TAG_SERVERPATH = "SERVERPATH";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_PWD = "PWD";
    public static final String TAG_AGENTPARAM = "AGENTPARAM";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_SERVICENAME = "SERVICENAME";
    public static final String TAG_CLIENTID = "CLIENTID";

    public boolean isDATASYNCAGENTIDNull() {
        return this.IsParamNull(TAG_DATASYNCAGENTID);
    }

    public String getDATASYNCAGENTID() {
        return this.GetParamStringValue(TAG_DATASYNCAGENTID, "");
    }

    public void setDATASYNCAGENTID(String strValue) {
        this.SetParamValue(TAG_DATASYNCAGENTID, strValue);
    }

    public boolean isDATASYNCAGENTNAMENull() {
        return this.IsParamNull(TAG_DATASYNCAGENTNAME);
    }

    public String getDATASYNCAGENTNAME() {
        return this.GetParamStringValue(TAG_DATASYNCAGENTNAME, "");
    }

    public void setDATASYNCAGENTNAME(String strValue) {
        this.SetParamValue(TAG_DATASYNCAGENTNAME, strValue);
    }

    public boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
    }

    public boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public boolean isAGENTTYPENull() {
        return this.IsParamNull(TAG_AGENTTYPE);
    }

    public String getAGENTTYPE() {
        return this.GetParamStringValue(TAG_AGENTTYPE, "");
    }

    public void setAGENTTYPE(String strValue) {
        this.SetParamValue(TAG_AGENTTYPE, strValue);
    }

    public boolean isSYNCDIRNull() {
        return this.IsParamNull(TAG_SYNCDIR);
    }

    public String getSYNCDIR() {
        return this.GetParamStringValue(TAG_SYNCDIR, "");
    }

    public void setSYNCDIR(String strValue) {
        this.SetParamValue(TAG_SYNCDIR, strValue);
    }

    public boolean isSERVERPATHNull() {
        return this.IsParamNull(TAG_SERVERPATH);
    }

    public String getSERVERPATH() {
        return this.GetParamStringValue(TAG_SERVERPATH, "");
    }

    public void setSERVERPATH(String strValue) {
        this.SetParamValue(TAG_SERVERPATH, strValue);
    }

    public boolean isUSERNAMENull() {
        return this.IsParamNull(TAG_USERNAME);
    }

    public String getUSERNAME() {
        return this.GetParamStringValue(TAG_USERNAME, "");
    }

    public void setUSERNAME(String strValue) {
        this.SetParamValue(TAG_USERNAME, strValue);
    }

    public boolean isPWDNull() {
        return this.IsParamNull(TAG_PWD);
    }

    public String getPWD() {
        return this.GetParamStringValue(TAG_PWD, "");
    }

    public void setPWD(String strValue) {
        this.SetParamValue(TAG_PWD, strValue);
    }

    public boolean isAGENTPARAMNull() {
        return this.IsParamNull(TAG_AGENTPARAM);
    }

    public String getAGENTPARAM() {
        return this.GetParamStringValue(TAG_AGENTPARAM, "");
    }

    public void setAGENTPARAM(String strValue) {
        this.SetParamValue(TAG_AGENTPARAM, strValue);
    }

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isSERVICENAMENull() {
        return this.IsParamNull(TAG_SERVICENAME);
    }

    public String getSERVICENAME() {
        return this.GetParamStringValue(TAG_SERVICENAME, "");
    }

    public void setSERVICENAME(String strValue) {
        this.SetParamValue(TAG_SERVICENAME, strValue);
    }

    public boolean isCLIENTIDNull() {
        return this.IsParamNull(TAG_CLIENTID);
    }

    public String getCLIENTID() {
        return this.GetParamStringValue(TAG_CLIENTID, "");
    }

    public void setCLIENTID(String strValue) {
        this.SetParamValue(TAG_CLIENTID, strValue);
    }
}

