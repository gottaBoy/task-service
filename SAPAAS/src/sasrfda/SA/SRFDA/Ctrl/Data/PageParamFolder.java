/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PageParamFolder
extends BaseDataEntity {
    public static final String TAG_PAGEPARAMFOLDERID = "PAGEPARAMFOLDERID";
    public static final String TAG_PAGEPARAMFOLDERNAME = "PAGEPARAMFOLDERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PAGEPARAMTYPEID = "PAGEPARAMTYPEID";
    public static final String TAG_PAGEPARAMTYPENAME = "PAGEPARAMTYPENAME";
    public static final String TAG_PAGETEMPLID = "PAGETEMPLID";
    public static final String TAG_PAGETEMPLNAME = "PAGETEMPLNAME";
    public static final String TAG_PPAGEPARAMFOLDERID = "PPAGEPARAMFOLDERID";
    public static final String TAG_PPAGEPARAMFOLDERNAME = "PPAGEPARAMFOLDERNAME";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_CTRLID = "CTRLID";
    public static final String TAG_PARAMOBJECT = "PARAMOBJECT";

    public String getPAGEPARAMFOLDERID() {
        return this.GetParamStringValue(TAG_PAGEPARAMFOLDERID, "");
    }

    public void setPAGEPARAMFOLDERID(String strValue) {
        this.SetParamValue(TAG_PAGEPARAMFOLDERID, strValue);
    }

    public String getPAGEPARAMFOLDERNAME() {
        return this.GetParamStringValue(TAG_PAGEPARAMFOLDERNAME, "");
    }

    public void setPAGEPARAMFOLDERNAME(String strValue) {
        this.SetParamValue(TAG_PAGEPARAMFOLDERNAME, strValue);
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

    public String getPAGEPARAMTYPEID() {
        return this.GetParamStringValue(TAG_PAGEPARAMTYPEID, "");
    }

    public void setPAGEPARAMTYPEID(String strValue) {
        this.SetParamValue(TAG_PAGEPARAMTYPEID, strValue);
    }

    public String getPAGEPARAMTYPENAME() {
        return this.GetParamStringValue(TAG_PAGEPARAMTYPENAME, "");
    }

    public void setPAGEPARAMTYPENAME(String strValue) {
        this.SetParamValue(TAG_PAGEPARAMTYPENAME, strValue);
    }

    public String getPAGETEMPLID() {
        return this.GetParamStringValue(TAG_PAGETEMPLID, "");
    }

    public void setPAGETEMPLID(String strValue) {
        this.SetParamValue(TAG_PAGETEMPLID, strValue);
    }

    public String getPAGETEMPLNAME() {
        return this.GetParamStringValue(TAG_PAGETEMPLNAME, "");
    }

    public void setPAGETEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PAGETEMPLNAME, strValue);
    }

    public String getPPAGEPARAMFOLDERID() {
        return this.GetParamStringValue(TAG_PPAGEPARAMFOLDERID, "");
    }

    public void setPPAGEPARAMFOLDERID(String strValue) {
        this.SetParamValue(TAG_PPAGEPARAMFOLDERID, strValue);
    }

    public String getPPAGEPARAMFOLDERNAME() {
        return this.GetParamStringValue(TAG_PPAGEPARAMFOLDERNAME, "");
    }

    public void setPPAGEPARAMFOLDERNAME(String strValue) {
        this.SetParamValue(TAG_PPAGEPARAMFOLDERNAME, strValue);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int strValue) {
        this.SetParamValue(TAG_ORDERFLAG, strValue);
    }

    public String getCTRLID() {
        return this.GetParamStringValue(TAG_CTRLID, "");
    }

    public void setCTRLID(String strValue) {
        this.SetParamValue(TAG_CTRLID, strValue);
    }

    public String getPARAMOBJECT() {
        return this.GetParamStringValue(TAG_PARAMOBJECT, "");
    }

    public void setPARAMOBJECT(String strValue) {
        this.SetParamValue(TAG_PARAMOBJECT, strValue);
    }
}

