/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BICube
extends BaseDataEntity {
    public static final String TAG_BICUBEID = "BICUBEID";
    public static final String TAG_BICUBENAME = "BICUBENAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RELATIONTYPE = "RELATIONTYPE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_BICATALOGID = "BICATALOGID";
    public static final String TAG_BICATALOGNAME = "BICATALOGNAME";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_USEVIEW = "USEVIEW";

    public String getBICUBEID() {
        return this.GetParamStringValue(TAG_BICUBEID, "");
    }

    public void setBICUBEID(String strValue) {
        this.SetParamValue(TAG_BICUBEID, strValue);
    }

    public String getBICUBENAME() {
        return this.GetParamStringValue(TAG_BICUBENAME, "");
    }

    public void setBICUBENAME(String strValue) {
        this.SetParamValue(TAG_BICUBENAME, strValue);
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

    public String getRELATIONTYPE() {
        return this.GetParamStringValue(TAG_RELATIONTYPE, "");
    }

    public void setRELATIONTYPE(String strValue) {
        this.SetParamValue(TAG_RELATIONTYPE, strValue);
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

    public String getBICATALOGID() {
        return this.GetParamStringValue(TAG_BICATALOGID, "");
    }

    public void setBICATALOGID(String strValue) {
        this.SetParamValue(TAG_BICATALOGID, strValue);
    }

    public String getBICATALOGNAME() {
        return this.GetParamStringValue(TAG_BICATALOGNAME, "");
    }

    public void setBICATALOGNAME(String strValue) {
        this.SetParamValue(TAG_BICATALOGNAME, strValue);
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

    public boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public boolean isUSEVIEWNull() {
        return this.IsParamNull(TAG_USEVIEW);
    }

    public boolean getUSEVIEW() {
        return this.GetParamIntValue(TAG_USEVIEW, 0) == 1;
    }

    public void setUSEVIEW(boolean bValue) {
        this.SetParamValue(TAG_USEVIEW, bValue ? 1 : 0);
    }
}

