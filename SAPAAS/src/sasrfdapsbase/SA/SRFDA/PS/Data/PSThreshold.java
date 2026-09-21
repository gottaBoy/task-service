/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSThreshold
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
    public static final String TAG_PSTHRESHOLDID = "PSTHRESHOLDID";
    public static final String TAG_PSTHRESHOLDNAME = "PSTHRESHOLDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSTHRESHOLDGROUPID = "PSTHRESHOLDGROUPID";
    public static final String TAG_PSTHRESHOLDGROUPNAME = "PSTHRESHOLDGROUPNAME";
    public static final String TAG_ENDVALUE = "ENDVALUE";
    public static final String TAG_BEGINVALUE = "BEGINVALUE";
    public static final String TAG_INCBEGINVALUE = "INCBEGINVALUE";
    public static final String TAG_INCENDVALUE = "INCENDVALUE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_COLOR = "COLOR";
    public static final String TAG_BKCOLOR = "BKCOLOR";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_THRESHOLDTAG = "THRESHOLDTAG";
    public static final String TAG_THRESHOLDTAG2 = "THRESHOLDTAG2";
    public static final String TAG_TEXTPSLANRESID = "TEXTPSLANRESID";
    public static final String TAG_TEXTPSLANRESNAME = "TEXTPSLANRESNAME";
    public static final String TAG_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String TAG_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String TAG_DATA = "DATA";
    public static final String TAG_TOOLTIPINFO = "TOOLTIPINFO";

    public final boolean isPSTHRESHOLDIDNull() {
        return this.IsParamNull(TAG_PSTHRESHOLDID);
    }

    public final String getPSTHRESHOLDID() {
        return this.GetParamStringValue(TAG_PSTHRESHOLDID, "");
    }

    public final void setPSTHRESHOLDID(String strValue) {
        this.SetParamValue(TAG_PSTHRESHOLDID, strValue);
    }

    public final boolean isPSTHRESHOLDNAMENull() {
        return this.IsParamNull(TAG_PSTHRESHOLDNAME);
    }

    public final String getPSTHRESHOLDNAME() {
        return this.GetParamStringValue(TAG_PSTHRESHOLDNAME, "");
    }

    public final void setPSTHRESHOLDNAME(String strValue) {
        this.SetParamValue(TAG_PSTHRESHOLDNAME, strValue);
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

    public final boolean isPSTHRESHOLDGROUPIDNull() {
        return this.IsParamNull(TAG_PSTHRESHOLDGROUPID);
    }

    public final String getPSTHRESHOLDGROUPID() {
        return this.GetParamStringValue(TAG_PSTHRESHOLDGROUPID, "");
    }

    public final void setPSTHRESHOLDGROUPID(String strValue) {
        this.SetParamValue(TAG_PSTHRESHOLDGROUPID, strValue);
    }

    public final boolean isPSTHRESHOLDGROUPNAMENull() {
        return this.IsParamNull(TAG_PSTHRESHOLDGROUPNAME);
    }

    public final String getPSTHRESHOLDGROUPNAME() {
        return this.GetParamStringValue(TAG_PSTHRESHOLDGROUPNAME, "");
    }

    public final void setPSTHRESHOLDGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSTHRESHOLDGROUPNAME, strValue);
    }

    public final boolean isENDVALUENull() {
        return this.IsParamNull(TAG_ENDVALUE);
    }

    public final double getENDVALUE() {
        return this.GetParamDoubleValue(TAG_ENDVALUE, 0.0);
    }

    public final void setENDVALUE(double strValue) {
        this.SetParamValue(TAG_ENDVALUE, strValue);
    }

    public final boolean isBEGINVALUENull() {
        return this.IsParamNull(TAG_BEGINVALUE);
    }

    public final double getBEGINVALUE() {
        return this.GetParamDoubleValue(TAG_BEGINVALUE, 0.0);
    }

    public final void setBEGINVALUE(double strValue) {
        this.SetParamValue(TAG_BEGINVALUE, strValue);
    }

    public final boolean isINCBEGINVALUENull() {
        return this.IsParamNull(TAG_INCBEGINVALUE);
    }

    public final boolean getINCBEGINVALUE() {
        return this.GetParamIntValue(TAG_INCBEGINVALUE, 0) == 1;
    }

    public final void setINCBEGINVALUE(boolean bValue) {
        this.SetParamValue(TAG_INCBEGINVALUE, bValue ? 1 : 0);
    }

    public final boolean isINCENDVALUENull() {
        return this.IsParamNull(TAG_INCENDVALUE);
    }

    public final boolean getINCENDVALUE() {
        return this.GetParamIntValue(TAG_INCENDVALUE, 0) == 1;
    }

    public final void setINCENDVALUE(boolean bValue) {
        this.SetParamValue(TAG_INCENDVALUE, bValue ? 1 : 0);
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

    public final boolean isCOLORNull() {
        return this.IsParamNull(TAG_COLOR);
    }

    public final String getCOLOR() {
        return this.GetParamStringValue(TAG_COLOR, "");
    }

    public final void setCOLOR(String strValue) {
        this.SetParamValue(TAG_COLOR, strValue);
    }

    public final boolean isBKCOLORNull() {
        return this.IsParamNull(TAG_BKCOLOR);
    }

    public final String getBKCOLOR() {
        return this.GetParamStringValue(TAG_BKCOLOR, "");
    }

    public final void setBKCOLOR(String strValue) {
        this.SetParamValue(TAG_BKCOLOR, strValue);
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

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
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

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
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

    public final boolean isPSSYSIMAGEIDNull() {
        return this.IsParamNull(TAG_PSSYSIMAGEID);
    }

    public final String getPSSYSIMAGEID() {
        return this.GetParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.IsParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.GetParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGENAME, strValue);
    }

    public final boolean isPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_PSSYSCSSID);
    }

    public final String getPSSYSCSSID() {
        return this.GetParamStringValue(TAG_PSSYSCSSID, "");
    }

    public final void setPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSID, strValue);
    }

    public final boolean isPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_PSSYSCSSNAME);
    }

    public final String getPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_PSSYSCSSNAME, "");
    }

    public final void setPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSNAME, strValue);
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

    public final boolean isTHRESHOLDTAGNull() {
        return this.IsParamNull(TAG_THRESHOLDTAG);
    }

    public final String getTHRESHOLDTAG() {
        return this.GetParamStringValue(TAG_THRESHOLDTAG, "");
    }

    public final void setTHRESHOLDTAG(String strValue) {
        this.SetParamValue(TAG_THRESHOLDTAG, strValue);
    }

    public final boolean isTHRESHOLDTAG2Null() {
        return this.IsParamNull(TAG_THRESHOLDTAG2);
    }

    public final String getTHRESHOLDTAG2() {
        return this.GetParamStringValue(TAG_THRESHOLDTAG2, "");
    }

    public final void setTHRESHOLDTAG2(String strValue) {
        this.SetParamValue(TAG_THRESHOLDTAG2, strValue);
    }

    public final boolean isTEXTPSLANRESIDNull() {
        return this.IsParamNull(TAG_TEXTPSLANRESID);
    }

    public final String getTEXTPSLANRESID() {
        return this.GetParamStringValue(TAG_TEXTPSLANRESID, "");
    }

    public final void setTEXTPSLANRESID(String strValue) {
        this.SetParamValue(TAG_TEXTPSLANRESID, strValue);
    }

    public final boolean isTEXTPSLANRESNAMENull() {
        return this.IsParamNull(TAG_TEXTPSLANRESNAME);
    }

    public final String getTEXTPSLANRESNAME() {
        return this.GetParamStringValue(TAG_TEXTPSLANRESNAME, "");
    }

    public final void setTEXTPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_TEXTPSLANRESNAME, strValue);
    }

    public final boolean isTIPPSLANRESIDNull() {
        return this.IsParamNull(TAG_TIPPSLANRESID);
    }

    public final String getTIPPSLANRESID() {
        return this.GetParamStringValue(TAG_TIPPSLANRESID, "");
    }

    public final void setTIPPSLANRESID(String strValue) {
        this.SetParamValue(TAG_TIPPSLANRESID, strValue);
    }

    public final boolean isTIPPSLANRESNAMENull() {
        return this.IsParamNull(TAG_TIPPSLANRESNAME);
    }

    public final String getTIPPSLANRESNAME() {
        return this.GetParamStringValue(TAG_TIPPSLANRESNAME, "");
    }

    public final void setTIPPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_TIPPSLANRESNAME, strValue);
    }

    public final boolean isDATANull() {
        return this.IsParamNull(TAG_DATA);
    }

    public final String getDATA() {
        return this.GetParamStringValue(TAG_DATA, "");
    }

    public final void setDATA(String strValue) {
        this.SetParamValue(TAG_DATA, strValue);
    }

    public final boolean isTOOLTIPINFONull() {
        return this.IsParamNull(TAG_TOOLTIPINFO);
    }

    public final String getTOOLTIPINFO() {
        return this.GetParamStringValue(TAG_TOOLTIPINFO, "");
    }

    public final void setTOOLTIPINFO(String strValue) {
        this.SetParamValue(TAG_TOOLTIPINFO, strValue);
    }
}

