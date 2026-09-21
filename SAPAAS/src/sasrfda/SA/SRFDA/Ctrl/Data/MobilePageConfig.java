/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class MobilePageConfig
extends BaseDataEntity {
    public static final String CONFIGTYPE_TOOLBAR = "TOOLBAR";
    public static final String CONFIGTYPE_TABVIEW = "TABVIEW";
    public static final String CONFIGTYPE_DPEX = "DPEX";
    public static final String CONFIGTYPE_SPEX = "SPEX";
    public static final String CONFIGTYPE_DATAGRID = "DATAGRID";
    public static final String CONFIGTYPE_MAINMENU = "MAINMENU";
    public static final String CONFIGTYPE_CODELIST = "CODELIST";
    public static final String TAG_MOBPAGECFGID = "MOBPAGECFGID";
    public static final String TAG_MOBPAGECFGNAME = "MOBPAGECFGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MOBILEPAGEID = "MOBILEPAGEID";
    public static final String TAG_MOBILEPAGENAME = "MOBILEPAGENAME";
    public static final String TAG_CONFIGTYPE = "CONFIGTYPE";
    public static final String TAG_CONFIGMODEL = "CONFIGMODEL";
    public static final String TAG_CONFIGID = "CONFIGID";

    public final boolean isMOBPAGECFGIDNull() {
        return this.IsParamNull(TAG_MOBPAGECFGID);
    }

    public final String getMOBPAGECFGID() {
        return this.GetParamStringValue(TAG_MOBPAGECFGID, "");
    }

    public final void setMOBPAGECFGID(String strValue) {
        this.SetParamValue(TAG_MOBPAGECFGID, strValue);
    }

    public final boolean isMOBPAGECFGNAMENull() {
        return this.IsParamNull(TAG_MOBPAGECFGNAME);
    }

    public final String getMOBPAGECFGNAME() {
        return this.GetParamStringValue(TAG_MOBPAGECFGNAME, "");
    }

    public final void setMOBPAGECFGNAME(String strValue) {
        this.SetParamValue(TAG_MOBPAGECFGNAME, strValue);
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

    public final boolean isMOBILEPAGEIDNull() {
        return this.IsParamNull(TAG_MOBILEPAGEID);
    }

    public final String getMOBILEPAGEID() {
        return this.GetParamStringValue(TAG_MOBILEPAGEID, "");
    }

    public final void setMOBILEPAGEID(String strValue) {
        this.SetParamValue(TAG_MOBILEPAGEID, strValue);
    }

    public final boolean isMOBILEPAGENAMENull() {
        return this.IsParamNull(TAG_MOBILEPAGENAME);
    }

    public final String getMOBILEPAGENAME() {
        return this.GetParamStringValue(TAG_MOBILEPAGENAME, "");
    }

    public final void setMOBILEPAGENAME(String strValue) {
        this.SetParamValue(TAG_MOBILEPAGENAME, strValue);
    }

    public final boolean isCONFIGTYPENull() {
        return this.IsParamNull(TAG_CONFIGTYPE);
    }

    public final String getCONFIGTYPE() {
        return this.GetParamStringValue(TAG_CONFIGTYPE, "");
    }

    public final void setCONFIGTYPE(String strValue) {
        this.SetParamValue(TAG_CONFIGTYPE, strValue);
    }

    public final boolean isCONFIGMODELNull() {
        return this.IsParamNull(TAG_CONFIGMODEL);
    }

    public final String getCONFIGMODEL() {
        return this.GetParamStringValue(TAG_CONFIGMODEL, "");
    }

    public final void setCONFIGMODEL(String strValue) {
        this.SetParamValue(TAG_CONFIGMODEL, strValue);
    }

    public final boolean isCONFIGIDNull() {
        return this.IsParamNull(TAG_CONFIGID);
    }

    public final String getCONFIGID() {
        return this.GetParamStringValue(TAG_CONFIGID, "");
    }

    public final void setCONFIGID(String strValue) {
        this.SetParamValue(TAG_CONFIGID, strValue);
    }
}

