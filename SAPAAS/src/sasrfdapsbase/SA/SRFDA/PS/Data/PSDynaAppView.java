/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDynaAppView
extends BaseDataEntity {
    public static final String VIEWTYPE_APPDEVIEW = "APPDEVIEW";
    public static final String VIEWTYPE_APPINDEXVIEW = "APPINDEXVIEW";
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
        return this.IsParamNull(TAG_PSDYNAAPPVIEWID);
    }

    public final String getPSDYNAAPPVIEWID() {
        return this.GetParamStringValue(TAG_PSDYNAAPPVIEWID, "");
    }

    public final void setPSDYNAAPPVIEWID(String strValue) {
        this.SetParamValue(TAG_PSDYNAAPPVIEWID, strValue);
    }

    public final boolean isPSDYNAAPPVIEWNAMENull() {
        return this.IsParamNull(TAG_PSDYNAAPPVIEWNAME);
    }

    public final String getPSDYNAAPPVIEWNAME() {
        return this.GetParamStringValue(TAG_PSDYNAAPPVIEWNAME, "");
    }

    public final void setPSDYNAAPPVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSDYNAAPPVIEWNAME, strValue);
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

    public final boolean isPSDYNAAPPIDNull() {
        return this.IsParamNull(TAG_PSDYNAAPPID);
    }

    public final String getPSDYNAAPPID() {
        return this.GetParamStringValue(TAG_PSDYNAAPPID, "");
    }

    public final void setPSDYNAAPPID(String strValue) {
        this.SetParamValue(TAG_PSDYNAAPPID, strValue);
    }

    public final boolean isPSDYNAAPPNAMENull() {
        return this.IsParamNull(TAG_PSDYNAAPPNAME);
    }

    public final String getPSDYNAAPPNAME() {
        return this.GetParamStringValue(TAG_PSDYNAAPPNAME, "");
    }

    public final void setPSDYNAAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSDYNAAPPNAME, strValue);
    }

    public final boolean isTITLENull() {
        return this.IsParamNull(TAG_TITLE);
    }

    public final String getTITLE() {
        return this.GetParamStringValue(TAG_TITLE, "");
    }

    public final void setTITLE(String strValue) {
        this.SetParamValue(TAG_TITLE, strValue);
    }

    public final boolean isCAPTIONNull() {
        return this.IsParamNull(TAG_CAPTION);
    }

    public final String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public final void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
    }

    public final boolean isVIEWTYPENull() {
        return this.IsParamNull(TAG_VIEWTYPE);
    }

    public final String getVIEWTYPE() {
        return this.GetParamStringValue(TAG_VIEWTYPE, "");
    }

    public final void setVIEWTYPE(String strValue) {
        this.SetParamValue(TAG_VIEWTYPE, strValue);
    }

    public final boolean isPSDYNADEIDNull() {
        return this.IsParamNull(TAG_PSDYNADEID);
    }

    public final String getPSDYNADEID() {
        return this.GetParamStringValue(TAG_PSDYNADEID, "");
    }

    public final void setPSDYNADEID(String strValue) {
        this.SetParamValue(TAG_PSDYNADEID, strValue);
    }

    public final boolean isPSDYNADENAMENull() {
        return this.IsParamNull(TAG_PSDYNADENAME);
    }

    public final String getPSDYNADENAME() {
        return this.GetParamStringValue(TAG_PSDYNADENAME, "");
    }

    public final void setPSDYNADENAME(String strValue) {
        this.SetParamValue(TAG_PSDYNADENAME, strValue);
    }

    public final boolean isMOBVIEWFLAGNull() {
        return this.IsParamNull(TAG_MOBVIEWFLAG);
    }

    public final boolean getMOBVIEWFLAG() {
        return this.GetParamIntValue(TAG_MOBVIEWFLAG, 0) == 1;
    }

    public final void setMOBVIEWFLAG(boolean bValue) {
        this.SetParamValue(TAG_MOBVIEWFLAG, bValue ? 1 : 0);
    }

    public final boolean isENABLEVIEWACTIONSNull() {
        return this.IsParamNull(TAG_ENABLEVIEWACTIONS);
    }

    public final boolean getENABLEVIEWACTIONS() {
        return this.GetParamIntValue(TAG_ENABLEVIEWACTIONS, 0) == 1;
    }

    public final void setENABLEVIEWACTIONS(boolean bValue) {
        this.SetParamValue(TAG_ENABLEVIEWACTIONS, bValue ? 1 : 0);
    }

    public final boolean isVIEWACTIONSNull() {
        return this.IsParamNull(TAG_VIEWACTIONS);
    }

    public final int getVIEWACTIONS() {
        return this.GetParamIntValue(TAG_VIEWACTIONS, 0);
    }

    public final void setVIEWACTIONS(int nValue) {
        this.SetParamValue(TAG_VIEWACTIONS, nValue);
    }

    public final boolean isPSWFDEIDNull() {
        return this.IsParamNull(TAG_PSWFDEID);
    }

    public final String getPSWFDEID() {
        return this.GetParamStringValue(TAG_PSWFDEID, "");
    }

    public final void setPSWFDEID(String strValue) {
        this.SetParamValue(TAG_PSWFDEID, strValue);
    }

    public final boolean isPSWFDENAMENull() {
        return this.IsParamNull(TAG_PSWFDENAME);
    }

    public final String getPSWFDENAME() {
        return this.GetParamStringValue(TAG_PSWFDENAME, "");
    }

    public final void setPSWFDENAME(String strValue) {
        this.SetParamValue(TAG_PSWFDENAME, strValue);
    }

    public final boolean isPDVTPARAMNull() {
        return this.IsParamNull(TAG_PDVTPARAM);
    }

    public final String getPDVTPARAM() {
        return this.GetParamStringValue(TAG_PDVTPARAM, "");
    }

    public final void setPDVTPARAM(String strValue) {
        this.SetParamValue(TAG_PDVTPARAM, strValue);
    }

    public final boolean isPREDEFINEDVIEWTYPENull() {
        return this.IsParamNull(TAG_PREDEFINEDVIEWTYPE);
    }

    public final String getPREDEFINEDVIEWTYPE() {
        return this.GetParamStringValue(TAG_PREDEFINEDVIEWTYPE, "");
    }

    public final void setPREDEFINEDVIEWTYPE(String strValue) {
        this.SetParamValue(TAG_PREDEFINEDVIEWTYPE, strValue);
    }

    public final boolean isPSAPPMENUIDNull() {
        return this.IsParamNull(TAG_PSAPPMENUID);
    }

    public final String getPSAPPMENUID() {
        return this.GetParamStringValue(TAG_PSAPPMENUID, "");
    }

    public final void setPSAPPMENUID(String strValue) {
        this.SetParamValue(TAG_PSAPPMENUID, strValue);
    }

    public final boolean isPSAPPMENUNAMENull() {
        return this.IsParamNull(TAG_PSAPPMENUNAME);
    }

    public final String getPSAPPMENUNAME() {
        return this.GetParamStringValue(TAG_PSAPPMENUNAME, "");
    }

    public final void setPSAPPMENUNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPMENUNAME, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }
}

