/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DBOPSetting
extends BaseDataEntity {
    public static final String TAG_EAIDBOPSETTINGID = "EAIDBOPSETTINGID";
    public static final String TAG_EAIDBOPSETTINGNAME = "EAIDBOPSETTINGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DBTYPE = "DBTYPE";
    public static final String TAG_PKGOBJECT = "PKGOBJECT";
    public static final String TAG_INITCODE = "INITCODE";
    public static final String TAG_LOGDETAILBEGINCODE = "LOGDETAILBEGINCODE";
    public static final String TAG_LOGDETAILENDCODE = "LOGDETAILENDCODE";
    public static final String TAG_LINECOMMENT = "LINECOMMENT";

    public boolean isEAIDBOPSETTINGIDNull() {
        return this.IsParamNull(TAG_EAIDBOPSETTINGID);
    }

    public String getEAIDBOPSETTINGID() {
        return this.GetParamStringValue(TAG_EAIDBOPSETTINGID, "");
    }

    public void setEAIDBOPSETTINGID(String strValue) {
        this.SetParamValue(TAG_EAIDBOPSETTINGID, strValue);
    }

    public boolean isEAIDBOPSETTINGNAMENull() {
        return this.IsParamNull(TAG_EAIDBOPSETTINGNAME);
    }

    public String getEAIDBOPSETTINGNAME() {
        return this.GetParamStringValue(TAG_EAIDBOPSETTINGNAME, "");
    }

    public void setEAIDBOPSETTINGNAME(String strValue) {
        this.SetParamValue(TAG_EAIDBOPSETTINGNAME, strValue);
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

    public boolean isDBTYPENull() {
        return this.IsParamNull(TAG_DBTYPE);
    }

    public String getDBTYPE() {
        return this.GetParamStringValue(TAG_DBTYPE, "");
    }

    public void setDBTYPE(String strValue) {
        this.SetParamValue(TAG_DBTYPE, strValue);
    }

    public boolean isPKGOBJECTNull() {
        return this.IsParamNull(TAG_PKGOBJECT);
    }

    public String getPKGOBJECT() {
        return this.GetParamStringValue(TAG_PKGOBJECT, "");
    }

    public void setPKGOBJECT(String strValue) {
        this.SetParamValue(TAG_PKGOBJECT, strValue);
    }

    public boolean isINITCODENull() {
        return this.IsParamNull(TAG_INITCODE);
    }

    public String getINITCODE() {
        return this.GetParamStringValue(TAG_INITCODE, "");
    }

    public void setINITCODE(String strValue) {
        this.SetParamValue(TAG_INITCODE, strValue);
    }

    public boolean isLOGDETAILBEGINCODENull() {
        return this.IsParamNull(TAG_LOGDETAILBEGINCODE);
    }

    public String getLOGDETAILBEGINCODE() {
        return this.GetParamStringValue(TAG_LOGDETAILBEGINCODE, "");
    }

    public void setLOGDETAILBEGINCODE(String strValue) {
        this.SetParamValue(TAG_LOGDETAILBEGINCODE, strValue);
    }

    public boolean isLOGDETAILENDCODENull() {
        return this.IsParamNull(TAG_LOGDETAILENDCODE);
    }

    public String getLOGDETAILENDCODE() {
        return this.GetParamStringValue(TAG_LOGDETAILENDCODE, "");
    }

    public void setLOGDETAILENDCODE(String strValue) {
        this.SetParamValue(TAG_LOGDETAILENDCODE, strValue);
    }

    public boolean isLINECOMMENTNull() {
        return this.IsParamNull(TAG_LINECOMMENT);
    }

    public String getLINECOMMENT() {
        return this.GetParamStringValue(TAG_LINECOMMENT, "");
    }

    public void setLINECOMMENT(String strValue) {
        this.SetParamValue(TAG_LINECOMMENT, strValue);
    }
}

