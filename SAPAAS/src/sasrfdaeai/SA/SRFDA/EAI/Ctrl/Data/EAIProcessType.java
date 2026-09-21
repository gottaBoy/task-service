/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class EAIProcessType
extends BaseDataEntity {
    public static final String TAG_EAIPROCESSTYPEID = "EAIPROCESSTYPEID";
    public static final String TAG_EAIPROCESSTYPENAME = "EAIPROCESSTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SHOWORDER = "SHOWORDER";
    public static final String TAG_PROCESSOBJECT = "PROCESSOBJECT";
    public static final String TAG_ICONPATH = "ICONPATH";
    public static final String TAG_EDITPATH = "EDITPATH";
    public static final String TAG_EXTPARAM = "EXTPARAM";

    public String getEAIPROCESSTYPEID() {
        return this.GetParamStringValue(TAG_EAIPROCESSTYPEID, "");
    }

    public void setEAIPROCESSTYPEID(String strValue) {
        this.SetParamValue(TAG_EAIPROCESSTYPEID, strValue);
    }

    public String getEAIPROCESSTYPENAME() {
        return this.GetParamStringValue(TAG_EAIPROCESSTYPENAME, "");
    }

    public void setEAIPROCESSTYPENAME(String strValue) {
        this.SetParamValue(TAG_EAIPROCESSTYPENAME, strValue);
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

    public int getSHOWORDER() {
        return this.GetParamIntValue(TAG_SHOWORDER, 0);
    }

    public void setSHOWORDER(int strValue) {
        this.SetParamValue(TAG_SHOWORDER, strValue);
    }

    public String getPROCESSOBJECT() {
        return this.GetParamStringValue(TAG_PROCESSOBJECT, "");
    }

    public void setPROCESSOBJECT(String strValue) {
        this.SetParamValue(TAG_PROCESSOBJECT, strValue);
    }

    public String getICONPATH() {
        return this.GetParamStringValue(TAG_ICONPATH, "");
    }

    public void setICONPATH(String strValue) {
        this.SetParamValue(TAG_ICONPATH, strValue);
    }

    public String getEDITPATH() {
        return this.GetParamStringValue(TAG_EDITPATH, "");
    }

    public void setEDITPATH(String strValue) {
        this.SetParamValue(TAG_EDITPATH, strValue);
    }

    public String getEXTPARAM() {
        return this.GetParamStringValue(TAG_EXTPARAM, "");
    }

    public void setEXTPARAM(String strValue) {
        this.SetParamValue(TAG_EXTPARAM, strValue);
    }
}

