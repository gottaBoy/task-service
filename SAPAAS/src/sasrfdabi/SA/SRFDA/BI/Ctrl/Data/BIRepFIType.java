/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIRepFIType
extends BaseDataEntity {
    public static final String TAG_BIREPFITYPEID = "BIREPFITYPEID";
    public static final String TAG_BIREPFITYPENAME = "BIREPFITYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_FIHELPOBJECT = "FIHELPOBJECT";
    public static final String TAG_NAMESPACE = "NAMESPACE";
    public static final String TAG_CTRLOBJECT = "CTRLOBJECT";

    public boolean isBIREPFITYPEIDNull() {
        return this.IsParamNull(TAG_BIREPFITYPEID);
    }

    public String getBIREPFITYPEID() {
        return this.GetParamStringValue(TAG_BIREPFITYPEID, "");
    }

    public void setBIREPFITYPEID(String strValue) {
        this.SetParamValue(TAG_BIREPFITYPEID, strValue);
    }

    public boolean isBIREPFITYPENAMENull() {
        return this.IsParamNull(TAG_BIREPFITYPENAME);
    }

    public String getBIREPFITYPENAME() {
        return this.GetParamStringValue(TAG_BIREPFITYPENAME, "");
    }

    public void setBIREPFITYPENAME(String strValue) {
        this.SetParamValue(TAG_BIREPFITYPENAME, strValue);
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

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isFIHELPOBJECTNull() {
        return this.IsParamNull(TAG_FIHELPOBJECT);
    }

    public String getFIHELPOBJECT() {
        return this.GetParamStringValue(TAG_FIHELPOBJECT, "");
    }

    public void setFIHELPOBJECT(String strValue) {
        this.SetParamValue(TAG_FIHELPOBJECT, strValue);
    }

    public boolean isNAMESPACENull() {
        return this.IsParamNull(TAG_NAMESPACE);
    }

    public String getNAMESPACE() {
        return this.GetParamStringValue(TAG_NAMESPACE, "");
    }

    public void setNAMESPACE(String strValue) {
        this.SetParamValue(TAG_NAMESPACE, strValue);
    }

    public boolean isCTRLOBJECTNull() {
        return this.IsParamNull(TAG_CTRLOBJECT);
    }

    public String getCTRLOBJECT() {
        return this.GetParamStringValue(TAG_CTRLOBJECT, "");
    }

    public void setCTRLOBJECT(String strValue) {
        this.SetParamValue(TAG_CTRLOBJECT, strValue);
    }
}

