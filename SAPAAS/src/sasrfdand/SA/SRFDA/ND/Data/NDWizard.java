/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.ND.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class NDWizard
extends BaseDataEntity {
    public static final String WIZARDMODE_CREATEFOLDER = "CREATEFOLDER";
    public static final String WIZARDMODE_RENAME = "RENAME";
    public static final String WIZARDMODE_COPY = "COPY";
    public static final String WIZARDMODE_MOVE = "MOVE";
    public static final String WIZARDMODE_CREATESHARE = "CREATESHARE";
    public static final String TAG_NDWIZARDID = "NDWIZARDID";
    public static final String TAG_NDWIZARDNAME = "NDWIZARDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_WIZARDMODE = "WIZARDMODE";
    public static final String TAG_ROOTNDFSOID = "ROOTNDFSOID";
    public static final String TAG_CURPATH = "CURPATH";
    public static final String TAG_ROOTNDFSONAME = "ROOTNDFSONAME";
    public static final String TAG_USERDATA = "USERDATA";
    public static final String TAG_USERDATA2 = "USERDATA2";
    public static final String TAG_USERDATA3 = "USERDATA3";
    public static final String TAG_USERDATA4 = "USERDATA4";
    public static final String TAG_NDFSOBJECTID = "NDFSOBJECTID";
    public static final String TAG_NDFSOBJECTNAME = "NDFSOBJECTNAME";
    public static final String TAG_DSTNDFSOBJECTID = "DSTNDFSOBJECTID";
    public static final String TAG_DSTNDFSOBJECTNAME = "DSTNDFSOBJECTNAME";

    public final boolean isNDWIZARDIDNull() {
        return this.IsParamNull(TAG_NDWIZARDID);
    }

    public final String getNDWIZARDID() {
        return this.GetParamStringValue(TAG_NDWIZARDID, "");
    }

    public final void setNDWIZARDID(String strValue) {
        this.SetParamValue(TAG_NDWIZARDID, strValue);
    }

    public final boolean isNDWIZARDNAMENull() {
        return this.IsParamNull(TAG_NDWIZARDNAME);
    }

    public final String getNDWIZARDNAME() {
        return this.GetParamStringValue(TAG_NDWIZARDNAME, "");
    }

    public final void setNDWIZARDNAME(String strValue) {
        this.SetParamValue(TAG_NDWIZARDNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isWIZARDMODENull() {
        return this.IsParamNull(TAG_WIZARDMODE);
    }

    public final String getWIZARDMODE() {
        return this.GetParamStringValue(TAG_WIZARDMODE, "");
    }

    public final void setWIZARDMODE(String strValue) {
        this.SetParamValue(TAG_WIZARDMODE, strValue);
    }

    public final boolean isROOTNDFSOIDNull() {
        return this.IsParamNull(TAG_ROOTNDFSOID);
    }

    public final String getROOTNDFSOID() {
        return this.GetParamStringValue(TAG_ROOTNDFSOID, "");
    }

    public final void setROOTNDFSOID(String strValue) {
        this.SetParamValue(TAG_ROOTNDFSOID, strValue);
    }

    public final boolean isCURPATHNull() {
        return this.IsParamNull(TAG_CURPATH);
    }

    public final String getCURPATH() {
        return this.GetParamStringValue(TAG_CURPATH, "");
    }

    public final void setCURPATH(String strValue) {
        this.SetParamValue(TAG_CURPATH, strValue);
    }

    public final boolean isROOTNDFSONAMENull() {
        return this.IsParamNull(TAG_ROOTNDFSONAME);
    }

    public final String getROOTNDFSONAME() {
        return this.GetParamStringValue(TAG_ROOTNDFSONAME, "");
    }

    public final void setROOTNDFSONAME(String strValue) {
        this.SetParamValue(TAG_ROOTNDFSONAME, strValue);
    }

    public final boolean isUSERDATANull() {
        return this.IsParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.GetParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.SetParamValue(TAG_USERDATA, strValue);
    }

    public final boolean isUSERDATA2Null() {
        return this.IsParamNull(TAG_USERDATA2);
    }

    public final String getUSERDATA2() {
        return this.GetParamStringValue(TAG_USERDATA2, "");
    }

    public final void setUSERDATA2(String strValue) {
        this.SetParamValue(TAG_USERDATA2, strValue);
    }

    public final boolean isUSERDATA3Null() {
        return this.IsParamNull(TAG_USERDATA3);
    }

    public final String getUSERDATA3() {
        return this.GetParamStringValue(TAG_USERDATA3, "");
    }

    public final void setUSERDATA3(String strValue) {
        this.SetParamValue(TAG_USERDATA3, strValue);
    }

    public final boolean isUSERDATA4Null() {
        return this.IsParamNull(TAG_USERDATA4);
    }

    public final String getUSERDATA4() {
        return this.GetParamStringValue(TAG_USERDATA4, "");
    }

    public final void setUSERDATA4(String strValue) {
        this.SetParamValue(TAG_USERDATA4, strValue);
    }

    public final boolean isNDFSOBJECTIDNull() {
        return this.IsParamNull(TAG_NDFSOBJECTID);
    }

    public final String getNDFSOBJECTID() {
        return this.GetParamStringValue(TAG_NDFSOBJECTID, "");
    }

    public final void setNDFSOBJECTID(String strValue) {
        this.SetParamValue(TAG_NDFSOBJECTID, strValue);
    }

    public final boolean isNDFSOBJECTNAMENull() {
        return this.IsParamNull(TAG_NDFSOBJECTNAME);
    }

    public final String getNDFSOBJECTNAME() {
        return this.GetParamStringValue(TAG_NDFSOBJECTNAME, "");
    }

    public final void setNDFSOBJECTNAME(String strValue) {
        this.SetParamValue(TAG_NDFSOBJECTNAME, strValue);
    }

    public final boolean isDSTNDFSOBJECTIDNull() {
        return this.IsParamNull(TAG_DSTNDFSOBJECTID);
    }

    public final String getDSTNDFSOBJECTID() {
        return this.GetParamStringValue(TAG_DSTNDFSOBJECTID, "");
    }

    public final void setDSTNDFSOBJECTID(String strValue) {
        this.SetParamValue(TAG_DSTNDFSOBJECTID, strValue);
    }

    public final boolean isDSTNDFSOBJECTNAMENull() {
        return this.IsParamNull(TAG_DSTNDFSOBJECTNAME);
    }

    public final String getDSTNDFSOBJECTNAME() {
        return this.GetParamStringValue(TAG_DSTNDFSOBJECTNAME, "");
    }

    public final void setDSTNDFSOBJECTNAME(String strValue) {
        this.SetParamValue(TAG_DSTNDFSOBJECTNAME, strValue);
    }
}

