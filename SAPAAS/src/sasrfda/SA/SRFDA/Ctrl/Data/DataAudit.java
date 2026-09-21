/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class DataAudit
extends BaseDataEntity {
    public static final String TAG_DATAAUDITID = "DATAAUDITID";
    public static final String TAG_DATAAUDITNAME = "DATAAUDITNAME";
    public static final String TAG_AUDITTYPE = "AUDITTYPE";
    public static final String TAG_AUDITINFO = "AUDITINFO";
    public static final String TAG_IPADDRESS = "IPADDRESS";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SESSIONID = "SESSIONID";
    public static final String TAG_OBJECTID = "OBJECTID";
    public static final String TAG_OBJECTTYPE = "OBJECTTYPE";
    public static final String TAG_OPPERSONID = "OPPERSONID";

    public String getDATAAUDITID() {
        return this.GetParamStringValue(TAG_DATAAUDITID, "").trim();
    }

    public String getDATAAUDITNAME() {
        return this.GetParamStringValue(TAG_DATAAUDITNAME, "");
    }

    public String getAUDITINFO() {
        return this.GetParamStringValue(TAG_AUDITINFO, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getSESSIONID() {
        return this.GetParamStringValue(TAG_SESSIONID, "");
    }

    public void setSESSIONID(String strValue) {
        this.SetParamValue(TAG_SESSIONID, strValue);
    }

    public void setDATAAUDITID(String strValue) {
        this.SetParamValue(TAG_DATAAUDITID, strValue);
    }

    public void setDATAAUDITNAME(String strValue) {
        this.SetParamValue(TAG_DATAAUDITNAME, strValue);
    }

    public void setAUDITINFO(String strValue) {
        this.SetParamValue(TAG_AUDITINFO, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public String getAUDITTYPE() {
        return this.GetParamStringValue(TAG_AUDITTYPE, "");
    }

    public String getIPADDRESS() {
        return this.GetParamStringValue(TAG_IPADDRESS, "");
    }

    public void setAUDITTYPE(String strValue) {
        this.SetParamValue(TAG_AUDITTYPE, strValue);
    }

    public void setIPADDRESS(String strValue) {
        this.SetParamValue(TAG_IPADDRESS, strValue);
    }

    public String getOPPERSONID() {
        return this.GetParamStringValue(TAG_OPPERSONID, "");
    }

    public void setOPPERSONID(String strValue) {
        this.SetParamValue(TAG_OPPERSONID, strValue);
    }

    public String getOBJECTID() {
        return this.GetParamStringValue(TAG_OBJECTID, "");
    }

    public void setOBJECTID(String strValue) {
        this.SetParamValue(TAG_OBJECTID, strValue);
    }

    public String getOBJECTTYPE() {
        return this.GetParamStringValue(TAG_OBJECTTYPE, "");
    }

    public void setOBJECTTYPE(String strValue) {
        this.SetParamValue(TAG_OBJECTTYPE, strValue);
    }
}

