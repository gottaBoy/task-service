/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public abstract class AbstractDevCodeEngine
extends BaseDataEntity {
    public static final String TAG_DEVCODEENGINEID = "DEVCODEENGINEID";
    public static final String TAG_DEVCODEENGINENAME = "DEVCODEENGINENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_CODEENGINEOBJECT = "CODEENGINEOBJECT";
    public static final String TAG_CODEENGINEPARAM = "CODEENGINEPARAM";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DEID = "DEID";

    public String getDEVCODEENGINEID() {
        return this.GetParamStringValue(TAG_DEVCODEENGINEID, "");
    }

    public void setDEVCODEENGINEID(String strValue) {
        this.SetParamValue(TAG_DEVCODEENGINEID, strValue);
    }

    public String getDEVCODEENGINENAME() {
        return this.GetParamStringValue(TAG_DEVCODEENGINENAME, "");
    }

    public void setDEVCODEENGINENAME(String strValue) {
        this.SetParamValue(TAG_DEVCODEENGINENAME, strValue);
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

    public String getCODEENGINEOBJECT() {
        return this.GetParamStringValue(TAG_CODEENGINEOBJECT, "");
    }

    public void setCODEENGINEOBJECT(String strValue) {
        this.SetParamValue(TAG_CODEENGINEOBJECT, strValue);
    }

    public String getCODEENGINEPARAM() {
        return this.GetParamStringValue(TAG_CODEENGINEPARAM, "");
    }

    public void setCODEENGINEPARAM(String strValue) {
        this.SetParamValue(TAG_CODEENGINEPARAM, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }
}

