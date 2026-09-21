/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DEDCProcType
extends BaseDataEntity {
    public static final String TAG_DEDCPROCTYPEID = "DEDCPROCTYPEID";
    public static final String TAG_DEDCPROCTYPENAME = "DEDCPROCTYPENAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_EDITPATH = "EDITPATH";
    public static final String TAG_SHOWORDER = "SHOWORDER";
    public static final String TAG_ICONPATH = "ICONPATH";
    public static final String TAG_PROCESSTYPE = "PROCESSTYPE";
    public static final String TAG_PROCESSOBJECT = "PROCESSOBJECT";

    public String getDEDCPROCTYPEID() {
        return this.GetParamStringValue(TAG_DEDCPROCTYPEID, "");
    }

    public void setDEDCPROCTYPEID(String strValue) {
        this.SetParamValue(TAG_DEDCPROCTYPEID, strValue);
    }

    public String getDEDCPROCTYPENAME() {
        return this.GetParamStringValue(TAG_DEDCPROCTYPENAME, "");
    }

    public void setDEDCPROCTYPENAME(String strValue) {
        this.SetParamValue(TAG_DEDCPROCTYPENAME, strValue);
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

    public String getEDITPATH() {
        return this.GetParamStringValue(TAG_EDITPATH, "");
    }

    public void setEDITPATH(String strValue) {
        this.SetParamValue(TAG_EDITPATH, strValue);
    }

    public String getSHOWORDER() {
        return this.GetParamStringValue(TAG_SHOWORDER, "");
    }

    public void setSHOWORDER(String strValue) {
        this.SetParamValue(TAG_SHOWORDER, strValue);
    }

    public String getICONPATH() {
        return this.GetParamStringValue(TAG_ICONPATH, "");
    }

    public void setICONPATH(String strValue) {
        this.SetParamValue(TAG_ICONPATH, strValue);
    }

    public String getPROCESSTYPE() {
        return this.GetParamStringValue(TAG_PROCESSTYPE, "");
    }

    public void setPROCESSTYPE(String strValue) {
        this.SetParamValue(TAG_PROCESSTYPE, strValue);
    }

    public String getPROCESSOBJECT() {
        return this.GetParamStringValue(TAG_PROCESSOBJECT, "");
    }

    public void setPROCESSOBJECT(String strValue) {
        this.SetParamValue(TAG_PROCESSOBJECT, strValue);
    }
}

