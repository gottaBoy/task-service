/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysBIReport
extends BaseDataEntity {
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSSYSBIREPORTID = "PSSYSBIREPORTID";
    public static final String TAG_PSSYSBIREPORTNAME = "PSSYSBIREPORTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSBISCHEMEID = "PSSYSBISCHEMEID";
    public static final String TAG_PSSYSBISCHEMENAME = "PSSYSBISCHEMENAME";
    public static final String TAG_PSSYSBICUBEID = "PSSYSBICUBEID";
    public static final String TAG_PSSYSBICUBENAME = "PSSYSBICUBENAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_BIREPORTTAG2 = "BIREPORTTAG2";
    public static final String TAG_BIREPORTTAG = "BIREPORTTAG";
    public static final String TAG_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String TAG_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String TAG_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String TAG_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_BIREPORTMODEL = "BIREPORTMODEL";
    public static final String TAG_BIREPORTUIMODEL = "BIREPORTUIMODEL";
    public static final String TAG_BIREPORTPARAMS = "BIREPORTPARAMS";
    public static final String TAG_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String TAG_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String TAG_ENABLECUSTOMIZED = "ENABLECUSTOMIZED";

    public final boolean isPSSYSBIREPORTIDNull() {
        return this.IsParamNull(TAG_PSSYSBIREPORTID);
    }

    public final String getPSSYSBIREPORTID() {
        return this.GetParamStringValue(TAG_PSSYSBIREPORTID, "");
    }

    public final void setPSSYSBIREPORTID(String strValue) {
        this.SetParamValue(TAG_PSSYSBIREPORTID, strValue);
    }

    public final boolean isPSSYSBIREPORTNAMENull() {
        return this.IsParamNull(TAG_PSSYSBIREPORTNAME);
    }

    public final String getPSSYSBIREPORTNAME() {
        return this.GetParamStringValue(TAG_PSSYSBIREPORTNAME, "");
    }

    public final void setPSSYSBIREPORTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBIREPORTNAME, strValue);
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

    public final boolean isPSSYSBISCHEMEIDNull() {
        return this.IsParamNull(TAG_PSSYSBISCHEMEID);
    }

    public final String getPSSYSBISCHEMEID() {
        return this.GetParamStringValue(TAG_PSSYSBISCHEMEID, "");
    }

    public final void setPSSYSBISCHEMEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBISCHEMEID, strValue);
    }

    public final boolean isPSSYSBISCHEMENAMENull() {
        return this.IsParamNull(TAG_PSSYSBISCHEMENAME);
    }

    public final String getPSSYSBISCHEMENAME() {
        return this.GetParamStringValue(TAG_PSSYSBISCHEMENAME, "");
    }

    public final void setPSSYSBISCHEMENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBISCHEMENAME, strValue);
    }

    public final boolean isPSSYSBICUBEIDNull() {
        return this.IsParamNull(TAG_PSSYSBICUBEID);
    }

    public final String getPSSYSBICUBEID() {
        return this.GetParamStringValue(TAG_PSSYSBICUBEID, "");
    }

    public final void setPSSYSBICUBEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBICUBEID, strValue);
    }

    public final boolean isPSSYSBICUBENAMENull() {
        return this.IsParamNull(TAG_PSSYSBICUBENAME);
    }

    public final String getPSSYSBICUBENAME() {
        return this.GetParamStringValue(TAG_PSSYSBICUBENAME, "");
    }

    public final void setPSSYSBICUBENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBICUBENAME, strValue);
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

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
    }

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
    }

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isBIREPORTTAG2Null() {
        return this.IsParamNull(TAG_BIREPORTTAG2);
    }

    public final String getBIREPORTTAG2() {
        return this.GetParamStringValue(TAG_BIREPORTTAG2, "");
    }

    public final void setBIREPORTTAG2(String strValue) {
        this.SetParamValue(TAG_BIREPORTTAG2, strValue);
    }

    public final boolean isBIREPORTTAGNull() {
        return this.IsParamNull(TAG_BIREPORTTAG);
    }

    public final String getBIREPORTTAG() {
        return this.GetParamStringValue(TAG_BIREPORTTAG, "");
    }

    public final void setBIREPORTTAG(String strValue) {
        this.SetParamValue(TAG_BIREPORTTAG, strValue);
    }

    public final boolean isPSVIEWMSGGROUPIDNull() {
        return this.IsParamNull(TAG_PSVIEWMSGGROUPID);
    }

    public final String getPSVIEWMSGGROUPID() {
        return this.GetParamStringValue(TAG_PSVIEWMSGGROUPID, "");
    }

    public final void setPSVIEWMSGGROUPID(String strValue) {
        this.SetParamValue(TAG_PSVIEWMSGGROUPID, strValue);
    }

    public final boolean isPSVIEWMSGGROUPNAMENull() {
        return this.IsParamNull(TAG_PSVIEWMSGGROUPNAME);
    }

    public final String getPSVIEWMSGGROUPNAME() {
        return this.GetParamStringValue(TAG_PSVIEWMSGGROUPNAME, "");
    }

    public final void setPSVIEWMSGGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSVIEWMSGGROUPNAME, strValue);
    }

    public final boolean isPSSYSRESOURCEIDNull() {
        return this.IsParamNull(TAG_PSSYSRESOURCEID);
    }

    public final String getPSSYSRESOURCEID() {
        return this.GetParamStringValue(TAG_PSSYSRESOURCEID, "");
    }

    public final void setPSSYSRESOURCEID(String strValue) {
        this.SetParamValue(TAG_PSSYSRESOURCEID, strValue);
    }

    public final boolean isPSSYSRESOURCENAMENull() {
        return this.IsParamNull(TAG_PSSYSRESOURCENAME);
    }

    public final String getPSSYSRESOURCENAME() {
        return this.GetParamStringValue(TAG_PSSYSRESOURCENAME, "");
    }

    public final void setPSSYSRESOURCENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSRESOURCENAME, strValue);
    }

    public final boolean isPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINID);
    }

    public final String getPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINID, "");
    }

    public final void setPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINID, strValue);
    }

    public final boolean isPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINNAME);
    }

    public final String getPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINNAME, "");
    }

    public final void setPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isPSSYSVIEWPANELIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELID);
    }

    public final String getPSSYSVIEWPANELID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELID, "");
    }

    public final void setPSSYSVIEWPANELID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELID, strValue);
    }

    public final boolean isPSSYSVIEWPANELNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELNAME);
    }

    public final String getPSSYSVIEWPANELNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELNAME, "");
    }

    public final void setPSSYSVIEWPANELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELNAME, strValue);
    }

    public final boolean isPSSYSSFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINID);
    }

    public final String getPSSYSSFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINID, "");
    }

    public final void setPSSYSSFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINID, strValue);
    }

    public final boolean isPSSYSSFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINNAME);
    }

    public final String getPSSYSSFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINNAME, "");
    }

    public final void setPSSYSSFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINNAME, strValue);
    }

    public final boolean isBIREPORTMODELNull() {
        return this.IsParamNull(TAG_BIREPORTMODEL);
    }

    public final String getBIREPORTMODEL() {
        return this.GetParamStringValue(TAG_BIREPORTMODEL, "");
    }

    public final void setBIREPORTMODEL(String strValue) {
        this.SetParamValue(TAG_BIREPORTMODEL, strValue);
    }

    public final boolean isBIREPORTUIMODELNull() {
        return this.IsParamNull(TAG_BIREPORTUIMODEL);
    }

    public final String getBIREPORTUIMODEL() {
        return this.GetParamStringValue(TAG_BIREPORTUIMODEL, "");
    }

    public final void setBIREPORTUIMODEL(String strValue) {
        this.SetParamValue(TAG_BIREPORTUIMODEL, strValue);
    }

    public final boolean isBIREPORTPARAMSNull() {
        return this.IsParamNull(TAG_BIREPORTPARAMS);
    }

    public final String getBIREPORTPARAMS() {
        return this.GetParamStringValue(TAG_BIREPORTPARAMS, "");
    }

    public final void setBIREPORTPARAMS(String strValue) {
        this.SetParamValue(TAG_BIREPORTPARAMS, strValue);
    }

    public final boolean isPSSYSUNIRESIDNull() {
        return this.IsParamNull(TAG_PSSYSUNIRESID);
    }

    public final String getPSSYSUNIRESID() {
        return this.GetParamStringValue(TAG_PSSYSUNIRESID, "");
    }

    public final void setPSSYSUNIRESID(String strValue) {
        this.SetParamValue(TAG_PSSYSUNIRESID, strValue);
    }

    public final boolean isPSSYSUNIRESNAMENull() {
        return this.IsParamNull(TAG_PSSYSUNIRESNAME);
    }

    public final String getPSSYSUNIRESNAME() {
        return this.GetParamStringValue(TAG_PSSYSUNIRESNAME, "");
    }

    public final void setPSSYSUNIRESNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUNIRESNAME, strValue);
    }

    public final boolean isENABLECUSTOMIZEDNull() {
        return this.IsParamNull(TAG_ENABLECUSTOMIZED);
    }

    public final boolean getENABLECUSTOMIZED() {
        return this.GetParamIntValue(TAG_ENABLECUSTOMIZED, 0) == 1;
    }

    public final void setENABLECUSTOMIZED(boolean bValue) {
        this.SetParamValue(TAG_ENABLECUSTOMIZED, bValue ? 1 : 0);
    }
}

