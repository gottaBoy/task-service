/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIReport
extends BaseDataEntity {
    public static final String TAG_BIREPORTID = "BIREPORTID";
    public static final String TAG_BIREPORTNAME = "BIREPORTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_REPORTMODEL = "REPORTMODEL";
    public static final String TAG_BICATALOGID = "BICATALOGID";
    public static final String TAG_BICATALOGNAME = "BICATALOGNAME";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_BICUBEID = "BICUBEID";
    public static final String TAG_BICUBENAME = "BICUBENAME";
    public static final String TAG_CLVERSION = "CLVERSION";

    public String getBIREPORTID() {
        return this.GetParamStringValue(TAG_BIREPORTID, "");
    }

    public void setBIREPORTID(String strValue) {
        this.SetParamValue(TAG_BIREPORTID, strValue);
    }

    public String getBIREPORTNAME() {
        return this.GetParamStringValue(TAG_BIREPORTNAME, "");
    }

    public void setBIREPORTNAME(String strValue) {
        this.SetParamValue(TAG_BIREPORTNAME, strValue);
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

    public String getREPORTMODEL() {
        return this.GetParamStringValue(TAG_REPORTMODEL, "");
    }

    public void setREPORTMODEL(String strValue) {
        this.SetParamValue(TAG_REPORTMODEL, strValue);
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

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

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

    public int getCLVERSION() {
        return this.GetParamIntValue(TAG_CLVERSION, 0);
    }

    public void setCLVERSION(int strValue) {
        this.SetParamValue(TAG_CLVERSION, strValue);
    }
}

