/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysDBValueFunc
extends BaseDataEntity {
    public static final String VFTYPE_PS = "PS";
    public static final String VFTYPE_UX = "UX";
    public static final int INPUTSTDDATATYPE_0 = 0;
    public static final int INPUTSTDDATATYPE_1 = 1;
    public static final int INPUTSTDDATATYPE_2 = 2;
    public static final int INPUTSTDDATATYPE_3 = 3;
    public static final int INPUTSTDDATATYPE_4 = 4;
    public static final int INPUTSTDDATATYPE_5 = 5;
    public static final int INPUTSTDDATATYPE_6 = 6;
    public static final int INPUTSTDDATATYPE_7 = 7;
    public static final int INPUTSTDDATATYPE_8 = 8;
    public static final int INPUTSTDDATATYPE_9 = 9;
    public static final int INPUTSTDDATATYPE_10 = 10;
    public static final int INPUTSTDDATATYPE_11 = 11;
    public static final int INPUTSTDDATATYPE_12 = 12;
    public static final int INPUTSTDDATATYPE_13 = 13;
    public static final int INPUTSTDDATATYPE_14 = 14;
    public static final int INPUTSTDDATATYPE_15 = 15;
    public static final int INPUTSTDDATATYPE_16 = 16;
    public static final int INPUTSTDDATATYPE_17 = 17;
    public static final int INPUTSTDDATATYPE_18 = 18;
    public static final int INPUTSTDDATATYPE_19 = 19;
    public static final int INPUTSTDDATATYPE_20 = 20;
    public static final int INPUTSTDDATATYPE_21 = 21;
    public static final int INPUTSTDDATATYPE_22 = 22;
    public static final int INPUTSTDDATATYPE_23 = 23;
    public static final int INPUTSTDDATATYPE_24 = 24;
    public static final int INPUTSTDDATATYPE_25 = 25;
    public static final int INPUTSTDDATATYPE_26 = 26;
    public static final int INPUTSTDDATATYPE_27 = 27;
    public static final int INPUTSTDDATATYPE_28 = 28;
    public static final int OUTPUTSTDDATATYPE_0 = 0;
    public static final int OUTPUTSTDDATATYPE_1 = 1;
    public static final int OUTPUTSTDDATATYPE_2 = 2;
    public static final int OUTPUTSTDDATATYPE_3 = 3;
    public static final int OUTPUTSTDDATATYPE_4 = 4;
    public static final int OUTPUTSTDDATATYPE_5 = 5;
    public static final int OUTPUTSTDDATATYPE_6 = 6;
    public static final int OUTPUTSTDDATATYPE_7 = 7;
    public static final int OUTPUTSTDDATATYPE_8 = 8;
    public static final int OUTPUTSTDDATATYPE_9 = 9;
    public static final int OUTPUTSTDDATATYPE_10 = 10;
    public static final int OUTPUTSTDDATATYPE_11 = 11;
    public static final int OUTPUTSTDDATATYPE_12 = 12;
    public static final int OUTPUTSTDDATATYPE_13 = 13;
    public static final int OUTPUTSTDDATATYPE_14 = 14;
    public static final int OUTPUTSTDDATATYPE_15 = 15;
    public static final int OUTPUTSTDDATATYPE_16 = 16;
    public static final int OUTPUTSTDDATATYPE_17 = 17;
    public static final int OUTPUTSTDDATATYPE_18 = 18;
    public static final int OUTPUTSTDDATATYPE_19 = 19;
    public static final int OUTPUTSTDDATATYPE_20 = 20;
    public static final int OUTPUTSTDDATATYPE_21 = 21;
    public static final int OUTPUTSTDDATATYPE_22 = 22;
    public static final int OUTPUTSTDDATATYPE_23 = 23;
    public static final int OUTPUTSTDDATATYPE_24 = 24;
    public static final int OUTPUTSTDDATATYPE_25 = 25;
    public static final int OUTPUTSTDDATATYPE_26 = 26;
    public static final int OUTPUTSTDDATATYPE_27 = 27;
    public static final int OUTPUTSTDDATATYPE_28 = 28;
    public static final String TAG_PSSYSDBVFID = "PSSYSDBVFID";
    public static final String TAG_PSSYSDBVFNAME = "PSSYSDBVFNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VFTYPE = "VFTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDBVFID = "PSDBVFID";
    public static final String TAG_PSDBVFNAME = "PSDBVFNAME";
    public static final String TAG_INPUTSTDDATATYPE = "INPUTSTDDATATYPE";
    public static final String TAG_OUTPUTSTDDATATYPE = "OUTPUTSTDDATATYPE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_OUTPUTVALUEFORMAT = "OUTPUTVALUEFORMAT";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_VFTAG = "VFTAG";
    public static final String TAG_VFTAG2 = "VFTAG2";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";

    public final boolean isPSSYSDBVFIDNull() {
        return this.IsParamNull(TAG_PSSYSDBVFID);
    }

    public final String getPSSYSDBVFID() {
        return this.GetParamStringValue(TAG_PSSYSDBVFID, "");
    }

    public final void setPSSYSDBVFID(String strValue) {
        this.SetParamValue(TAG_PSSYSDBVFID, strValue);
    }

    public final boolean isPSSYSDBVFNAMENull() {
        return this.IsParamNull(TAG_PSSYSDBVFNAME);
    }

    public final String getPSSYSDBVFNAME() {
        return this.GetParamStringValue(TAG_PSSYSDBVFNAME, "");
    }

    public final void setPSSYSDBVFNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDBVFNAME, strValue);
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

    public final boolean isVFTYPENull() {
        return this.IsParamNull(TAG_VFTYPE);
    }

    public final String getVFTYPE() {
        return this.GetParamStringValue(TAG_VFTYPE, "");
    }

    public final void setVFTYPE(String strValue) {
        this.SetParamValue(TAG_VFTYPE, strValue);
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

    public final boolean isPSDBVFIDNull() {
        return this.IsParamNull(TAG_PSDBVFID);
    }

    public final String getPSDBVFID() {
        return this.GetParamStringValue(TAG_PSDBVFID, "");
    }

    public final void setPSDBVFID(String strValue) {
        this.SetParamValue(TAG_PSDBVFID, strValue);
    }

    public final boolean isPSDBVFNAMENull() {
        return this.IsParamNull(TAG_PSDBVFNAME);
    }

    public final String getPSDBVFNAME() {
        return this.GetParamStringValue(TAG_PSDBVFNAME, "");
    }

    public final void setPSDBVFNAME(String strValue) {
        this.SetParamValue(TAG_PSDBVFNAME, strValue);
    }

    public final boolean isINPUTSTDDATATYPENull() {
        return this.IsParamNull(TAG_INPUTSTDDATATYPE);
    }

    public final int getINPUTSTDDATATYPE() {
        return this.GetParamIntValue(TAG_INPUTSTDDATATYPE, 0);
    }

    public final void setINPUTSTDDATATYPE(int nValue) {
        this.SetParamValue(TAG_INPUTSTDDATATYPE, nValue);
    }

    public final boolean isOUTPUTSTDDATATYPENull() {
        return this.IsParamNull(TAG_OUTPUTSTDDATATYPE);
    }

    public final int getOUTPUTSTDDATATYPE() {
        return this.GetParamIntValue(TAG_OUTPUTSTDDATATYPE, 0);
    }

    public final void setOUTPUTSTDDATATYPE(int nValue) {
        this.SetParamValue(TAG_OUTPUTSTDDATATYPE, nValue);
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

    public final boolean isOUTPUTVALUEFORMATNull() {
        return this.IsParamNull(TAG_OUTPUTVALUEFORMAT);
    }

    public final String getOUTPUTVALUEFORMAT() {
        return this.GetParamStringValue(TAG_OUTPUTVALUEFORMAT, "");
    }

    public final void setOUTPUTVALUEFORMAT(String strValue) {
        this.SetParamValue(TAG_OUTPUTVALUEFORMAT, strValue);
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

    public final boolean isVFTAGNull() {
        return this.IsParamNull(TAG_VFTAG);
    }

    public final String getVFTAG() {
        return this.GetParamStringValue(TAG_VFTAG, "");
    }

    public final void setVFTAG(String strValue) {
        this.SetParamValue(TAG_VFTAG, strValue);
    }

    public final boolean isVFTAG2Null() {
        return this.IsParamNull(TAG_VFTAG2);
    }

    public final String getVFTAG2() {
        return this.GetParamStringValue(TAG_VFTAG2, "");
    }

    public final void setVFTAG2(String strValue) {
        this.SetParamValue(TAG_VFTAG2, strValue);
    }
}

