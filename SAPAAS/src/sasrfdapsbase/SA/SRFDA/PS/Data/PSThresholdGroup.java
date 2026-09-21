/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSThresholdGroup
extends BaseDataEntity {
    public static final String THRESHOLDGROUPTYPE_STATIC = "STATIC";
    public static final String THRESHOLDGROUPTYPE_DYNAMIC = "DYNAMIC";
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSTHRESHOLDGROUPID = "PSTHRESHOLDGROUPID";
    public static final String TAG_PSTHRESHOLDGROUPNAME = "PSTHRESHOLDGROUPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_THRESHOLDGROUPTYPE = "THRESHOLDGROUPTYPE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDEDSID = "PSDEDSID";
    public static final String TAG_PSDEDSNAME = "PSDEDSNAME";
    public static final String TAG_BKCOLORPSDEFID = "BKCOLORPSDEFID";
    public static final String TAG_BKCOLORPSDEFNAME = "BKCOLORPSDEFNAME";
    public static final String TAG_COLORPSDEFID = "COLORPSDEFID";
    public static final String TAG_COLORPSDEFNAME = "COLORPSDEFNAME";
    public static final String TAG_BEGINVALUEPSDEFID = "BEGINVALUEPSDEFID";
    public static final String TAG_BEGINVALUEPSDEFNAME = "BEGINVALUEPSDEFNAME";
    public static final String TAG_ENDVALUEPSDEFID = "ENDVALUEPSDEFID";
    public static final String TAG_ENDVALUEPSDEFNAME = "ENDVALUEPSDEFNAME";
    public static final String TAG_ICONCLSPSDEFID = "ICONCLSPSDEFID";
    public static final String TAG_ICONCLSPSDEFNAME = "ICONCLSPSDEFNAME";
    public static final String TAG_TEXTPSDEFID = "TEXTPSDEFID";
    public static final String TAG_TEXTPSDEFNAME = "TEXTPSDEFNAME";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_THRESHOLDGROUPTAG = "THRESHOLDGROUPTAG";
    public static final String TAG_THRESHOLDGROUPTAG2 = "THRESHOLDGROUPTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_INCBEGINVALUE = "INCBEGINVALUE";
    public static final String TAG_INCENDVALUE = "INCENDVALUE";
    public static final String TAG_DATAPSDEFID = "DATAPSDEFID";
    public static final String TAG_DATAPSDEFNAME = "DATAPSDEFNAME";
    public static final String TAG_CUSTOMCOND = "CUSTOMCOND";

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

    public final boolean isTHRESHOLDGROUPTYPENull() {
        return this.IsParamNull(TAG_THRESHOLDGROUPTYPE);
    }

    public final String getTHRESHOLDGROUPTYPE() {
        return this.GetParamStringValue(TAG_THRESHOLDGROUPTYPE, "");
    }

    public final void setTHRESHOLDGROUPTYPE(String strValue) {
        this.SetParamValue(TAG_THRESHOLDGROUPTYPE, strValue);
    }

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isPSDEDSIDNull() {
        return this.IsParamNull(TAG_PSDEDSID);
    }

    public final String getPSDEDSID() {
        return this.GetParamStringValue(TAG_PSDEDSID, "");
    }

    public final void setPSDEDSID(String strValue) {
        this.SetParamValue(TAG_PSDEDSID, strValue);
    }

    public final boolean isPSDEDSNAMENull() {
        return this.IsParamNull(TAG_PSDEDSNAME);
    }

    public final String getPSDEDSNAME() {
        return this.GetParamStringValue(TAG_PSDEDSNAME, "");
    }

    public final void setPSDEDSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDSNAME, strValue);
    }

    public final boolean isBKCOLORPSDEFIDNull() {
        return this.IsParamNull(TAG_BKCOLORPSDEFID);
    }

    public final String getBKCOLORPSDEFID() {
        return this.GetParamStringValue(TAG_BKCOLORPSDEFID, "");
    }

    public final void setBKCOLORPSDEFID(String strValue) {
        this.SetParamValue(TAG_BKCOLORPSDEFID, strValue);
    }

    public final boolean isBKCOLORPSDEFNAMENull() {
        return this.IsParamNull(TAG_BKCOLORPSDEFNAME);
    }

    public final String getBKCOLORPSDEFNAME() {
        return this.GetParamStringValue(TAG_BKCOLORPSDEFNAME, "");
    }

    public final void setBKCOLORPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_BKCOLORPSDEFNAME, strValue);
    }

    public final boolean isCOLORPSDEFIDNull() {
        return this.IsParamNull(TAG_COLORPSDEFID);
    }

    public final String getCOLORPSDEFID() {
        return this.GetParamStringValue(TAG_COLORPSDEFID, "");
    }

    public final void setCOLORPSDEFID(String strValue) {
        this.SetParamValue(TAG_COLORPSDEFID, strValue);
    }

    public final boolean isCOLORPSDEFNAMENull() {
        return this.IsParamNull(TAG_COLORPSDEFNAME);
    }

    public final String getCOLORPSDEFNAME() {
        return this.GetParamStringValue(TAG_COLORPSDEFNAME, "");
    }

    public final void setCOLORPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_COLORPSDEFNAME, strValue);
    }

    public final boolean isBEGINVALUEPSDEFIDNull() {
        return this.IsParamNull(TAG_BEGINVALUEPSDEFID);
    }

    public final String getBEGINVALUEPSDEFID() {
        return this.GetParamStringValue(TAG_BEGINVALUEPSDEFID, "");
    }

    public final void setBEGINVALUEPSDEFID(String strValue) {
        this.SetParamValue(TAG_BEGINVALUEPSDEFID, strValue);
    }

    public final boolean isBEGINVALUEPSDEFNAMENull() {
        return this.IsParamNull(TAG_BEGINVALUEPSDEFNAME);
    }

    public final String getBEGINVALUEPSDEFNAME() {
        return this.GetParamStringValue(TAG_BEGINVALUEPSDEFNAME, "");
    }

    public final void setBEGINVALUEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_BEGINVALUEPSDEFNAME, strValue);
    }

    public final boolean isENDVALUEPSDEFIDNull() {
        return this.IsParamNull(TAG_ENDVALUEPSDEFID);
    }

    public final String getENDVALUEPSDEFID() {
        return this.GetParamStringValue(TAG_ENDVALUEPSDEFID, "");
    }

    public final void setENDVALUEPSDEFID(String strValue) {
        this.SetParamValue(TAG_ENDVALUEPSDEFID, strValue);
    }

    public final boolean isENDVALUEPSDEFNAMENull() {
        return this.IsParamNull(TAG_ENDVALUEPSDEFNAME);
    }

    public final String getENDVALUEPSDEFNAME() {
        return this.GetParamStringValue(TAG_ENDVALUEPSDEFNAME, "");
    }

    public final void setENDVALUEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_ENDVALUEPSDEFNAME, strValue);
    }

    public final boolean isICONCLSPSDEFIDNull() {
        return this.IsParamNull(TAG_ICONCLSPSDEFID);
    }

    public final String getICONCLSPSDEFID() {
        return this.GetParamStringValue(TAG_ICONCLSPSDEFID, "");
    }

    public final void setICONCLSPSDEFID(String strValue) {
        this.SetParamValue(TAG_ICONCLSPSDEFID, strValue);
    }

    public final boolean isICONCLSPSDEFNAMENull() {
        return this.IsParamNull(TAG_ICONCLSPSDEFNAME);
    }

    public final String getICONCLSPSDEFNAME() {
        return this.GetParamStringValue(TAG_ICONCLSPSDEFNAME, "");
    }

    public final void setICONCLSPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_ICONCLSPSDEFNAME, strValue);
    }

    public final boolean isTEXTPSDEFIDNull() {
        return this.IsParamNull(TAG_TEXTPSDEFID);
    }

    public final String getTEXTPSDEFID() {
        return this.GetParamStringValue(TAG_TEXTPSDEFID, "");
    }

    public final void setTEXTPSDEFID(String strValue) {
        this.SetParamValue(TAG_TEXTPSDEFID, strValue);
    }

    public final boolean isTEXTPSDEFNAMENull() {
        return this.IsParamNull(TAG_TEXTPSDEFNAME);
    }

    public final String getTEXTPSDEFNAME() {
        return this.GetParamStringValue(TAG_TEXTPSDEFNAME, "");
    }

    public final void setTEXTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TEXTPSDEFNAME, strValue);
    }

    public final boolean isPSMODULEIDNull() {
        return this.IsParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.GetParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.SetParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.IsParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.GetParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSMODULENAME, strValue);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMNAME, strValue);
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

    public final boolean isTHRESHOLDGROUPTAGNull() {
        return this.IsParamNull(TAG_THRESHOLDGROUPTAG);
    }

    public final String getTHRESHOLDGROUPTAG() {
        return this.GetParamStringValue(TAG_THRESHOLDGROUPTAG, "");
    }

    public final void setTHRESHOLDGROUPTAG(String strValue) {
        this.SetParamValue(TAG_THRESHOLDGROUPTAG, strValue);
    }

    public final boolean isTHRESHOLDGROUPTAG2Null() {
        return this.IsParamNull(TAG_THRESHOLDGROUPTAG2);
    }

    public final String getTHRESHOLDGROUPTAG2() {
        return this.GetParamStringValue(TAG_THRESHOLDGROUPTAG2, "");
    }

    public final void setTHRESHOLDGROUPTAG2(String strValue) {
        this.SetParamValue(TAG_THRESHOLDGROUPTAG2, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELID);
    }

    public final String getPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELID, "");
    }

    public final void setPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELID, strValue);
    }

    public final boolean isPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELNAME);
    }

    public final String getPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELNAME, "");
    }

    public final void setPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELNAME, strValue);
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

    public final boolean isDATAPSDEFIDNull() {
        return this.IsParamNull(TAG_DATAPSDEFID);
    }

    public final String getDATAPSDEFID() {
        return this.GetParamStringValue(TAG_DATAPSDEFID, "");
    }

    public final void setDATAPSDEFID(String strValue) {
        this.SetParamValue(TAG_DATAPSDEFID, strValue);
    }

    public final boolean isDATAPSDEFNAMENull() {
        return this.IsParamNull(TAG_DATAPSDEFNAME);
    }

    public final String getDATAPSDEFNAME() {
        return this.GetParamStringValue(TAG_DATAPSDEFNAME, "");
    }

    public final void setDATAPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_DATAPSDEFNAME, strValue);
    }

    public final boolean isCUSTOMCONDNull() {
        return this.IsParamNull(TAG_CUSTOMCOND);
    }

    public final String getCUSTOMCOND() {
        return this.GetParamStringValue(TAG_CUSTOMCOND, "");
    }

    public final void setCUSTOMCOND(String strValue) {
        this.SetParamValue(TAG_CUSTOMCOND, strValue);
    }
}

