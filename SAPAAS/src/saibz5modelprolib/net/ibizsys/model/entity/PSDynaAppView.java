/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDynaAppView
extends BaseDataEntity {
    public static final String VIEWTYPE_APPDEVIEW = "APPDEVIEW";
    public static final String VIEWTYPE_APPINDEXVIEW = "APPINDEXVIEW";
    public static final String VIEWTYPE_APPPORTALVIEW = "APPPORTALVIEW";
    public static final int VIEWACTIONS_1 = 1;
    public static final int VIEWACTIONS_2 = 2;
    public static final int VIEWACTIONS_4 = 4;
    public static final int VIEWACTIONS_8 = 8;
    public static final int VIEWACTIONS_16 = 16;
    public static final int VIEWACTIONS_32 = 32;
    public static final int VIEWACTIONS_64 = 64;
    public static final int VIEWACTIONS_1024 = 1024;
    public static final int VIEWACTIONS_128 = 128;
    public static final int VIEWACTIONS_256 = 256;
    public static final int VIEWACTIONS_512 = 512;
    public static final int VIEWACTIONS_2048 = 2048;
    public static final String PREDEFINEDVIEWTYPE_PICKUPVIEW = "PICKUPVIEW";
    public static final String PREDEFINEDVIEWTYPE_EDITVIEW = "EDITVIEW";
    public static final String PREDEFINEDVIEWTYPE_INDEXDEPICKUPVIEW = "INDEXDEPICKUPVIEW";
    public static final String PREDEFINEDVIEWTYPE_FORMPICKUPVIEW = "FORMPICKUPVIEW";
    public static final String PREDEFINEDVIEWTYPE_MPICKUPVIEW = "MPICKUPVIEW";
    public static final String PREDEFINEDVIEWTYPE_MDATAVIEW = "MDATAVIEW";
    public static final String PREDEFINEDVIEWTYPE_WFEDITVIEW = "WFEDITVIEW";
    public static final String PREDEFINEDVIEWTYPE_WFMDATAVIEW = "WFMDATAVIEW";
    public static final String PREDEFINEDVIEWTYPE_REDIRECTVIEW = "REDIRECTVIEW";
    public static final String PREDEFINEDVIEWTYPE_MOBPICKUPVIEW = "MOBPICKUPVIEW";
    public static final String PREDEFINEDVIEWTYPE_MOBEDITVIEW = "MOBEDITVIEW";
    public static final String PREDEFINEDVIEWTYPE_MOBINDEXDEPICKUPVIEW = "MOBINDEXDEPICKUPVIEW";
    public static final String PREDEFINEDVIEWTYPE_MOBFORMPICKUPVIEW = "MOBFORMPICKUPVIEW";
    public static final String PREDEFINEDVIEWTYPE_MOBMPICKUPVIEW = "MOBMPICKUPVIEW";
    public static final String PREDEFINEDVIEWTYPE_MOBMDATAVIEW = "MOBMDATAVIEW";
    public static final String PREDEFINEDVIEWTYPE_MOBWFEDITVIEW = "MOBWFEDITVIEW";
    public static final String PREDEFINEDVIEWTYPE_MOBWFMDATAVIEW = "MOBWFMDATAVIEW";
    public static final String TAG_PSDYNAAPPVIEWID = "PSDYNAAPPVIEWID";
    public static final String TAG_PSDYNAAPPVIEWNAME = "PSDYNAAPPVIEWNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDYNAAPPID = "PSDYNAAPPID";
    public static final String TAG_PSDYNAAPPNAME = "PSDYNAAPPNAME";
    public static final String TAG_TITLE = "TITLE";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_VIEWTYPE = "VIEWTYPE";
    public static final String TAG_PSDYNADEID = "PSDYNADEID";
    public static final String TAG_PSDYNADENAME = "PSDYNADENAME";
    public static final String TAG_MOBVIEWFLAG = "MOBVIEWFLAG";
    public static final String TAG_ENABLEVIEWACTIONS = "ENABLEVIEWACTIONS";
    public static final String TAG_VIEWACTIONS = "VIEWACTIONS";
    public static final String TAG_PSWFDEID = "PSWFDEID";
    public static final String TAG_PSWFDENAME = "PSWFDENAME";
    public static final String TAG_PDVTPARAM = "PDVTPARAM";
    public static final String TAG_PREDEFINEDVIEWTYPE = "PREDEFINEDVIEWTYPE";
    public static final String TAG_PSAPPMENUID = "PSAPPMENUID";
    public static final String TAG_PSAPPMENUNAME = "PSAPPMENUNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";

    public final boolean isPSDYNAAPPVIEWIDNull() {
        return this.isParamNull(TAG_PSDYNAAPPVIEWID);
    }

    public final String getPSDYNAAPPVIEWID() {
        return this.getParamStringValue(TAG_PSDYNAAPPVIEWID, "");
    }

    public final void setPSDYNAAPPVIEWID(String strValue) {
        this.setParamValue(TAG_PSDYNAAPPVIEWID, strValue);
    }

    public final boolean isPSDYNAAPPVIEWNAMENull() {
        return this.isParamNull(TAG_PSDYNAAPPVIEWNAME);
    }

    public final String getPSDYNAAPPVIEWNAME() {
        return this.getParamStringValue(TAG_PSDYNAAPPVIEWNAME, "");
    }

    public final void setPSDYNAAPPVIEWNAME(String strValue) {
        this.setParamValue(TAG_PSDYNAAPPVIEWNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPSDYNAAPPIDNull() {
        return this.isParamNull(TAG_PSDYNAAPPID);
    }

    public final String getPSDYNAAPPID() {
        return this.getParamStringValue(TAG_PSDYNAAPPID, "");
    }

    public final void setPSDYNAAPPID(String strValue) {
        this.setParamValue(TAG_PSDYNAAPPID, strValue);
    }

    public final boolean isPSDYNAAPPNAMENull() {
        return this.isParamNull(TAG_PSDYNAAPPNAME);
    }

    public final String getPSDYNAAPPNAME() {
        return this.getParamStringValue(TAG_PSDYNAAPPNAME, "");
    }

    public final void setPSDYNAAPPNAME(String strValue) {
        this.setParamValue(TAG_PSDYNAAPPNAME, strValue);
    }

    public final boolean isTITLENull() {
        return this.isParamNull(TAG_TITLE);
    }

    public final String getTITLE() {
        return this.getParamStringValue(TAG_TITLE, "");
    }

    public final void setTITLE(String strValue) {
        this.setParamValue(TAG_TITLE, strValue);
    }

    public final boolean isCAPTIONNull() {
        return this.isParamNull(TAG_CAPTION);
    }

    public final String getCAPTION() {
        return this.getParamStringValue(TAG_CAPTION, "");
    }

    public final void setCAPTION(String strValue) {
        this.setParamValue(TAG_CAPTION, strValue);
    }

    public final boolean isVIEWTYPENull() {
        return this.isParamNull(TAG_VIEWTYPE);
    }

    public final String getVIEWTYPE() {
        return this.getParamStringValue(TAG_VIEWTYPE, "");
    }

    public final void setVIEWTYPE(String strValue) {
        this.setParamValue(TAG_VIEWTYPE, strValue);
    }

    public final boolean isPSDYNADEIDNull() {
        return this.isParamNull(TAG_PSDYNADEID);
    }

    public final String getPSDYNADEID() {
        return this.getParamStringValue(TAG_PSDYNADEID, "");
    }

    public final void setPSDYNADEID(String strValue) {
        this.setParamValue(TAG_PSDYNADEID, strValue);
    }

    public final boolean isPSDYNADENAMENull() {
        return this.isParamNull(TAG_PSDYNADENAME);
    }

    public final String getPSDYNADENAME() {
        return this.getParamStringValue(TAG_PSDYNADENAME, "");
    }

    public final void setPSDYNADENAME(String strValue) {
        this.setParamValue(TAG_PSDYNADENAME, strValue);
    }

    public final boolean isMOBVIEWFLAGNull() {
        return this.isParamNull(TAG_MOBVIEWFLAG);
    }

    public final boolean getMOBVIEWFLAG() {
        return this.getParamIntValue(TAG_MOBVIEWFLAG, 0) == 1;
    }

    public final void setMOBVIEWFLAG(boolean bValue) {
        this.setParamValue(TAG_MOBVIEWFLAG, bValue ? 1 : 0);
    }

    public final boolean isENABLEVIEWACTIONSNull() {
        return this.isParamNull(TAG_ENABLEVIEWACTIONS);
    }

    public final boolean getENABLEVIEWACTIONS() {
        return this.getParamIntValue(TAG_ENABLEVIEWACTIONS, 0) == 1;
    }

    public final void setENABLEVIEWACTIONS(boolean bValue) {
        this.setParamValue(TAG_ENABLEVIEWACTIONS, bValue ? 1 : 0);
    }

    public final boolean isVIEWACTIONSNull() {
        return this.isParamNull(TAG_VIEWACTIONS);
    }

    public final int getVIEWACTIONS() {
        return this.getParamIntValue(TAG_VIEWACTIONS, 0);
    }

    public final void setVIEWACTIONS(int nValue) {
        this.setParamValue(TAG_VIEWACTIONS, nValue);
    }

    public final boolean isPSWFDEIDNull() {
        return this.isParamNull(TAG_PSWFDEID);
    }

    public final String getPSWFDEID() {
        return this.getParamStringValue(TAG_PSWFDEID, "");
    }

    public final void setPSWFDEID(String strValue) {
        this.setParamValue(TAG_PSWFDEID, strValue);
    }

    public final boolean isPSWFDENAMENull() {
        return this.isParamNull(TAG_PSWFDENAME);
    }

    public final String getPSWFDENAME() {
        return this.getParamStringValue(TAG_PSWFDENAME, "");
    }

    public final void setPSWFDENAME(String strValue) {
        this.setParamValue(TAG_PSWFDENAME, strValue);
    }

    public final boolean isPDVTPARAMNull() {
        return this.isParamNull(TAG_PDVTPARAM);
    }

    public final String getPDVTPARAM() {
        return this.getParamStringValue(TAG_PDVTPARAM, "");
    }

    public final void setPDVTPARAM(String strValue) {
        this.setParamValue(TAG_PDVTPARAM, strValue);
    }

    public final boolean isPREDEFINEDVIEWTYPENull() {
        return this.isParamNull(TAG_PREDEFINEDVIEWTYPE);
    }

    public final String getPREDEFINEDVIEWTYPE() {
        return this.getParamStringValue(TAG_PREDEFINEDVIEWTYPE, "");
    }

    public final void setPREDEFINEDVIEWTYPE(String strValue) {
        this.setParamValue(TAG_PREDEFINEDVIEWTYPE, strValue);
    }

    public final boolean isPSAPPMENUIDNull() {
        return this.isParamNull(TAG_PSAPPMENUID);
    }

    public final String getPSAPPMENUID() {
        return this.getParamStringValue(TAG_PSAPPMENUID, "");
    }

    public final void setPSAPPMENUID(String strValue) {
        this.setParamValue(TAG_PSAPPMENUID, strValue);
    }

    public final boolean isPSAPPMENUNAMENull() {
        return this.isParamNull(TAG_PSAPPMENUNAME);
    }

    public final String getPSAPPMENUNAME() {
        return this.getParamStringValue(TAG_PSAPPMENUNAME, "");
    }

    public final void setPSAPPMENUNAME(String strValue) {
        this.setParamValue(TAG_PSAPPMENUNAME, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.isParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.getParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.setParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }
}

