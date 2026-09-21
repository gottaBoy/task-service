/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BILevel
extends BaseDataEntity {
    public static final String TAG_BILEVELID = "BILEVELID";
    public static final String TAG_BILEVELNAME = "BILEVELNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BIHIERARCHYID = "BIHIERARCHYID";
    public static final String TAG_BIHIERARCHYNAME = "BIHIERARCHYNAME";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_LEVELTYPE = "LEVELTYPE";
    public static final String TAG_UNIQUEMEMBERS = "UNIQUEMEMBERS";
    public static final String TAG_DEFID = "DEFID";
    public static final String TAG_DEFNAME = "DEFNAME";
    public static final String TAG_CAPDEFID = "CAPDEFID";
    public static final String TAG_CAPDEFNAME = "CAPDEFNAME";
    public static final String TAG_AGGCAPTION = "AGGCAPTION";

    public String getBILEVELID() {
        return this.GetParamStringValue(TAG_BILEVELID, "");
    }

    public void setBILEVELID(String strValue) {
        this.SetParamValue(TAG_BILEVELID, strValue);
    }

    public String getBILEVELNAME() {
        return this.GetParamStringValue(TAG_BILEVELNAME, "");
    }

    public void setBILEVELNAME(String strValue) {
        this.SetParamValue(TAG_BILEVELNAME, strValue);
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

    public String getBIHIERARCHYID() {
        return this.GetParamStringValue(TAG_BIHIERARCHYID, "");
    }

    public void setBIHIERARCHYID(String strValue) {
        this.SetParamValue(TAG_BIHIERARCHYID, strValue);
    }

    public String getBIHIERARCHYNAME() {
        return this.GetParamStringValue(TAG_BIHIERARCHYNAME, "");
    }

    public void setBIHIERARCHYNAME(String strValue) {
        this.SetParamValue(TAG_BIHIERARCHYNAME, strValue);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int strValue) {
        this.SetParamValue(TAG_ORDERFLAG, strValue);
    }

    public String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public String getLEVELTYPE() {
        return this.GetParamStringValue(TAG_LEVELTYPE, "");
    }

    public void setLEVELTYPE(String strValue) {
        this.SetParamValue(TAG_LEVELTYPE, strValue);
    }

    public boolean getUNIQUEMEMBERS() {
        return this.GetParamIntValue(TAG_UNIQUEMEMBERS, 0) == 1;
    }

    public void setUNIQUEMEMBERS(boolean bValue) {
        this.SetParamValue(TAG_UNIQUEMEMBERS, bValue ? 1 : 0);
    }

    public String getDEFID() {
        return this.GetParamStringValue(TAG_DEFID, "");
    }

    public void setDEFID(String strValue) {
        this.SetParamValue(TAG_DEFID, strValue);
    }

    public String getDEFNAME() {
        return this.GetParamStringValue(TAG_DEFNAME, "");
    }

    public void setDEFNAME(String strValue) {
        this.SetParamValue(TAG_DEFNAME, strValue);
    }

    public String getCAPDEFID() {
        return this.GetParamStringValue(TAG_CAPDEFID, "");
    }

    public void setCAPDEFID(String strValue) {
        this.SetParamValue(TAG_CAPDEFID, strValue);
    }

    public String getCAPDEFNAME() {
        return this.GetParamStringValue(TAG_CAPDEFNAME, "");
    }

    public void setCAPDEFNAME(String strValue) {
        this.SetParamValue(TAG_CAPDEFNAME, strValue);
    }

    public boolean isAGGCAPTIONNull() {
        return this.IsParamNull(TAG_AGGCAPTION);
    }

    public String getAGGCAPTION() {
        return this.GetParamStringValue(TAG_AGGCAPTION, "");
    }

    public void setAGGCAPTION(String strValue) {
        this.SetParamValue(TAG_AGGCAPTION, strValue);
    }
}

