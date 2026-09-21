/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.WS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WSWBType
extends BaseDataEntity {
    public static final String TAG_TEMPLATE = "TEMPLATE";
    public static final String TAG_WSWBTYPEID = "WSWBTYPEID";
    public static final String TAG_WSWBTYPENAME = "WSWBTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_HELPEROBJECT = "HELPEROBJECT";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_PARAMS = "PARAMS";

    public boolean isTEMPLATENull() {
        return this.IsParamNull(TAG_TEMPLATE);
    }

    public String getTEMPLATE() {
        return this.GetParamStringValue(TAG_TEMPLATE, "");
    }

    public void setTEMPLATE(String strValue) {
        this.SetParamValue(TAG_TEMPLATE, strValue);
    }

    public boolean isWSWBTYPEIDNull() {
        return this.IsParamNull(TAG_WSWBTYPEID);
    }

    public String getWSWBTYPEID() {
        return this.GetParamStringValue(TAG_WSWBTYPEID, "");
    }

    public void setWSWBTYPEID(String strValue) {
        this.SetParamValue(TAG_WSWBTYPEID, strValue);
    }

    public boolean isWSWBTYPENAMENull() {
        return this.IsParamNull(TAG_WSWBTYPENAME);
    }

    public String getWSWBTYPENAME() {
        return this.GetParamStringValue(TAG_WSWBTYPENAME, "");
    }

    public void setWSWBTYPENAME(String strValue) {
        this.SetParamValue(TAG_WSWBTYPENAME, strValue);
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

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
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

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public boolean isHELPEROBJECTNull() {
        return this.IsParamNull(TAG_HELPEROBJECT);
    }

    public String getHELPEROBJECT() {
        return this.GetParamStringValue(TAG_HELPEROBJECT, "");
    }

    public void setHELPEROBJECT(String strValue) {
        this.SetParamValue(TAG_HELPEROBJECT, strValue);
    }

    public boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public boolean isPARAMSNull() {
        return this.IsParamNull(TAG_PARAMS);
    }

    public String getPARAMS() {
        return this.GetParamStringValue(TAG_PARAMS, "");
    }

    public void setPARAMS(String strValue) {
        this.SetParamValue(TAG_PARAMS, strValue);
    }
}

