/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class MsgTemplate
extends BaseDataEntity {
    public static final String CONTENTTYPE_TEXT = "TEXT";
    public static final String CONTENTTYPE_HTML = "HTML";
    public static final String TAG_MSGTEMPLATEID = "MSGTEMPLATEID";
    public static final String TAG_MSGTEMPLATENAME = "MSGTEMPLATENAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SUBJECT = "SUBJECT";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_CONTENTTYPE = "CONTENTTYPE";
    public static final String TAG_SMSCONTENT = "SMSCONTENT";
    public static final String TAG_IMCONTENT = "IMCONTENT";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_MAILGROUPSEND = "MAILGROUPSEND";
    public static final String TAG_WCCONTENT = "WCCONTENT";

    public String getMSGTEMPLATEID() {
        return this.GetParamStringValue(TAG_MSGTEMPLATEID, "");
    }

    public void setMSGTEMPLATEID(String strValue) {
        this.SetParamValue(TAG_MSGTEMPLATEID, strValue);
    }

    public String getMSGTEMPLATENAME() {
        return this.GetParamStringValue(TAG_MSGTEMPLATENAME, "");
    }

    public void setMSGTEMPLATENAME(String strValue) {
        this.SetParamValue(TAG_MSGTEMPLATENAME, strValue);
    }

    public boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public String getSUBJECT() {
        return this.GetParamStringValue(TAG_SUBJECT, "");
    }

    public void setSUBJECT(String strValue) {
        this.SetParamValue(TAG_SUBJECT, strValue);
    }

    public String getCONTENT() {
        return this.GetParamStringValue(TAG_CONTENT, "");
    }

    public void setCONTENT(String strValue) {
        this.SetParamValue(TAG_CONTENT, strValue);
    }

    public String getCONTENTTYPE() {
        return this.GetParamStringValue(TAG_CONTENTTYPE, "");
    }

    public void setCONTENTTYPE(String strValue) {
        this.SetParamValue(TAG_CONTENTTYPE, strValue);
    }

    public String getSMSCONTENT() {
        return this.GetParamStringValue(TAG_SMSCONTENT, "");
    }

    public void setSMSCONTENT(String strValue) {
        this.SetParamValue(TAG_SMSCONTENT, strValue);
    }

    public String getIMCONTENT() {
        return this.GetParamStringValue(TAG_IMCONTENT, "");
    }

    public void setIMCONTENT(String strValue) {
        this.SetParamValue(TAG_IMCONTENT, strValue);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public boolean getMAILGROUPSEND() {
        return this.GetParamIntValue(TAG_MAILGROUPSEND, 0) == 1;
    }

    public void setMAILGROUPSEND(boolean bValue) {
        this.SetParamValue(TAG_MAILGROUPSEND, bValue ? 1 : 0);
    }

    public final boolean isWCCONTENTNull() {
        return this.IsParamNull(TAG_WCCONTENT);
    }

    public final String getWCCONTENT() {
        return this.GetParamStringValue(TAG_WCCONTENT, "");
    }

    public final void setWCCONTENT(String strValue) {
        this.SetParamValue(TAG_WCCONTENT, strValue);
    }
}

