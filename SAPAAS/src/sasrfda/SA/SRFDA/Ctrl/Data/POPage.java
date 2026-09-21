/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class POPage
extends BaseDataEntity {
    public static final String TAG_POPAGEID = "POPAGEID";
    public static final String TAG_POPAGENAME = "POPAGENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_HOSTID = "HOSTID";
    public static final String TAG_PAGEURL = "PAGEURL";
    public static final String TAG_QUERYPARAM = "QUERYPARAM";
    public static final String TAG_PROCESSTIME = "PROCESSTIME";
    public static final String TAG_SESSIONID = "SESSIONID";
    public static final String TAG_ISBACKEND = "ISBACKEND";
    public static final String TAG_BACKENDACTION = "BACKENDACTION";
    public static final String TAG_ACCSEQ = "ACCSEQ";
    public static final String TAG_PROCESSDATE = "PROCESSDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_PAGEFUNC = "PAGEFUNC";

    public String getPOPAGEID() {
        return this.GetParamStringValue(TAG_POPAGEID, "");
    }

    public void setPOPAGEID(String strValue) {
        this.SetParamValue(TAG_POPAGEID, strValue);
    }

    public String getPOPAGENAME() {
        return this.GetParamStringValue(TAG_POPAGENAME, "");
    }

    public void setPOPAGENAME(String strValue) {
        this.SetParamValue(TAG_POPAGENAME, strValue);
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

    public String getHOSTID() {
        return this.GetParamStringValue(TAG_HOSTID, "");
    }

    public void setHOSTID(String strValue) {
        this.SetParamValue(TAG_HOSTID, strValue);
    }

    public String getPAGEURL() {
        return this.GetParamStringValue(TAG_PAGEURL, "");
    }

    public void setPAGEURL(String strValue) {
        this.SetParamValue(TAG_PAGEURL, strValue);
    }

    public String getQUERYPARAM() {
        return this.GetParamStringValue(TAG_QUERYPARAM, "");
    }

    public void setQUERYPARAM(String strValue) {
        this.SetParamValue(TAG_QUERYPARAM, strValue);
    }

    public int getPROCESSTIME() {
        return this.GetParamIntValue(TAG_PROCESSTIME, 0);
    }

    public void setPROCESSTIME(int strValue) {
        this.SetParamValue(TAG_PROCESSTIME, strValue);
    }

    public String getSESSIONID() {
        return this.GetParamStringValue(TAG_SESSIONID, "");
    }

    public void setSESSIONID(String strValue) {
        this.SetParamValue(TAG_SESSIONID, strValue);
    }

    public boolean getISBACKEND() {
        return this.GetParamIntValue(TAG_ISBACKEND, 0) == 1;
    }

    public void setISBACKEND(boolean bValue) {
        this.SetParamValue(TAG_ISBACKEND, bValue ? 1 : 0);
    }

    public String getBACKENDACTION() {
        return this.GetParamStringValue(TAG_BACKENDACTION, "");
    }

    public void setBACKENDACTION(String strValue) {
        this.SetParamValue(TAG_BACKENDACTION, strValue);
    }

    public String getACCSEQ() {
        return this.GetParamStringValue(TAG_ACCSEQ, "");
    }

    public void setACCSEQ(String strValue) {
        this.SetParamValue(TAG_ACCSEQ, strValue);
    }

    public Date getPROCESSDATE() {
        return this.GetParamDateValue(TAG_PROCESSDATE, null);
    }

    public void setPROCESSDATE(Date strValue) {
        this.SetParamValue(TAG_PROCESSDATE, strValue);
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

    public String getPAGEFUNC() {
        return this.GetParamStringValue(TAG_PAGEFUNC, "");
    }

    public void setPAGEFUNC(String strValue) {
        this.SetParamValue(TAG_PAGEFUNC, strValue);
    }
}

