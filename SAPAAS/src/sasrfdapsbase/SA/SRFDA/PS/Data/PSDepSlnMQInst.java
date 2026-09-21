/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDepSlnMQInst
extends BaseDataEntity {
    public static final String TAG_PSDEPSLNMQINSTID = "PSDEPSLNMQINSTID";
    public static final String TAG_PSDEPSLNMQINSTNAME = "PSDEPSLNMQINSTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVCENTERMQID = "PSDEVCENTERMQID";
    public static final String TAG_PSDEVCENTERMQNAME = "PSDEVCENTERMQNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEPSLNID = "PSDEPSLNID";
    public static final String TAG_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String TAG_PSDEPSLNHOSTID = "PSDEPSLNHOSTID";
    public static final String TAG_PSDEPSLNHOSTNAME = "PSDEPSLNHOSTNAME";
    public static final String TAG_ENABLELOCALMODE = "ENABLELOCALMODE";
    public static final String TAG_ENABLEREMOTEMODE = "ENABLEREMOTEMODE";
    public static final String TAG_MQTYPE = "MQTYPE";
    public static final String TAG_CONNSTR = "CONNSTR";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_PASSWD = "PASSWD";

    public final boolean isPSDEPSLNMQINSTIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNMQINSTID);
    }

    public final String getPSDEPSLNMQINSTID() {
        return this.GetParamStringValue(TAG_PSDEPSLNMQINSTID, "");
    }

    public final void setPSDEPSLNMQINSTID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNMQINSTID, strValue);
    }

    public final boolean isPSDEPSLNMQINSTNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNMQINSTNAME);
    }

    public final String getPSDEPSLNMQINSTNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNMQINSTNAME, "");
    }

    public final void setPSDEPSLNMQINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNMQINSTNAME, strValue);
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

    public final boolean isPSDEVCENTERMQIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERMQID);
    }

    public final String getPSDEVCENTERMQID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERMQID, "");
    }

    public final void setPSDEVCENTERMQID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERMQID, strValue);
    }

    public final boolean isPSDEVCENTERMQNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERMQNAME);
    }

    public final String getPSDEVCENTERMQNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERMQNAME, "");
    }

    public final void setPSDEVCENTERMQNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERMQNAME, strValue);
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

    public final boolean isPSDEPSLNIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNID);
    }

    public final String getPSDEPSLNID() {
        return this.GetParamStringValue(TAG_PSDEPSLNID, "");
    }

    public final void setPSDEPSLNID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNID, strValue);
    }

    public final boolean isPSDEPSLNNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNNAME);
    }

    public final String getPSDEPSLNNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNNAME, "");
    }

    public final void setPSDEPSLNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNNAME, strValue);
    }

    public final boolean isPSDEPSLNHOSTIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNHOSTID);
    }

    public final String getPSDEPSLNHOSTID() {
        return this.GetParamStringValue(TAG_PSDEPSLNHOSTID, "");
    }

    public final void setPSDEPSLNHOSTID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNHOSTID, strValue);
    }

    public final boolean isPSDEPSLNHOSTNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNHOSTNAME);
    }

    public final String getPSDEPSLNHOSTNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNHOSTNAME, "");
    }

    public final void setPSDEPSLNHOSTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNHOSTNAME, strValue);
    }

    public final boolean isENABLELOCALMODENull() {
        return this.IsParamNull(TAG_ENABLELOCALMODE);
    }

    public final boolean getENABLELOCALMODE() {
        return this.GetParamIntValue(TAG_ENABLELOCALMODE, 0) == 1;
    }

    public final void setENABLELOCALMODE(boolean bValue) {
        this.SetParamValue(TAG_ENABLELOCALMODE, bValue ? 1 : 0);
    }

    public final boolean isENABLEREMOTEMODENull() {
        return this.IsParamNull(TAG_ENABLEREMOTEMODE);
    }

    public final boolean getENABLEREMOTEMODE() {
        return this.GetParamIntValue(TAG_ENABLEREMOTEMODE, 0) == 1;
    }

    public final void setENABLEREMOTEMODE(boolean bValue) {
        this.SetParamValue(TAG_ENABLEREMOTEMODE, bValue ? 1 : 0);
    }

    public final boolean isMQTYPENull() {
        return this.IsParamNull(TAG_MQTYPE);
    }

    public final String getMQTYPE() {
        return this.GetParamStringValue(TAG_MQTYPE, "");
    }

    public final void setMQTYPE(String strValue) {
        this.SetParamValue(TAG_MQTYPE, strValue);
    }

    public final boolean isCONNSTRNull() {
        return this.IsParamNull(TAG_CONNSTR);
    }

    public final String getCONNSTR() {
        return this.GetParamStringValue(TAG_CONNSTR, "");
    }

    public final void setCONNSTR(String strValue) {
        this.SetParamValue(TAG_CONNSTR, strValue);
    }

    public final boolean isUSERNAMENull() {
        return this.IsParamNull(TAG_USERNAME);
    }

    public final String getUSERNAME() {
        return this.GetParamStringValue(TAG_USERNAME, "");
    }

    public final void setUSERNAME(String strValue) {
        this.SetParamValue(TAG_USERNAME, strValue);
    }

    public final boolean isPASSWDNull() {
        return this.IsParamNull(TAG_PASSWD);
    }

    public final String getPASSWD() {
        return this.GetParamStringValue(TAG_PASSWD, "");
    }

    public final void setPASSWD(String strValue) {
        this.SetParamValue(TAG_PASSWD, strValue);
    }
}

