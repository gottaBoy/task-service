/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

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

    public final boolean isPSSYSDBVFIDNull() {
        return this.isParamNull(TAG_PSSYSDBVFID);
    }

    public final String getPSSYSDBVFID() {
        return this.getParamStringValue(TAG_PSSYSDBVFID, "");
    }

    public final void setPSSYSDBVFID(String strValue) {
        this.setParamValue(TAG_PSSYSDBVFID, strValue);
    }

    public final boolean isPSSYSDBVFNAMENull() {
        return this.isParamNull(TAG_PSSYSDBVFNAME);
    }

    public final String getPSSYSDBVFNAME() {
        return this.getParamStringValue(TAG_PSSYSDBVFNAME, "");
    }

    public final void setPSSYSDBVFNAME(String strValue) {
        this.setParamValue(TAG_PSSYSDBVFNAME, strValue);
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

    public final boolean isVFTYPENull() {
        return this.isParamNull(TAG_VFTYPE);
    }

    public final String getVFTYPE() {
        return this.getParamStringValue(TAG_VFTYPE, "");
    }

    public final void setVFTYPE(String strValue) {
        this.setParamValue(TAG_VFTYPE, strValue);
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

    public final boolean isPSDBVFIDNull() {
        return this.isParamNull(TAG_PSDBVFID);
    }

    public final String getPSDBVFID() {
        return this.getParamStringValue(TAG_PSDBVFID, "");
    }

    public final void setPSDBVFID(String strValue) {
        this.setParamValue(TAG_PSDBVFID, strValue);
    }

    public final boolean isPSDBVFNAMENull() {
        return this.isParamNull(TAG_PSDBVFNAME);
    }

    public final String getPSDBVFNAME() {
        return this.getParamStringValue(TAG_PSDBVFNAME, "");
    }

    public final void setPSDBVFNAME(String strValue) {
        this.setParamValue(TAG_PSDBVFNAME, strValue);
    }

    public final boolean isINPUTSTDDATATYPENull() {
        return this.isParamNull(TAG_INPUTSTDDATATYPE);
    }

    public final int getINPUTSTDDATATYPE() {
        return this.getParamIntValue(TAG_INPUTSTDDATATYPE, 0);
    }

    public final void setINPUTSTDDATATYPE(int nValue) {
        this.setParamValue(TAG_INPUTSTDDATATYPE, nValue);
    }

    public final boolean isOUTPUTSTDDATATYPENull() {
        return this.isParamNull(TAG_OUTPUTSTDDATATYPE);
    }

    public final int getOUTPUTSTDDATATYPE() {
        return this.getParamIntValue(TAG_OUTPUTSTDDATATYPE, 0);
    }

    public final void setOUTPUTSTDDATATYPE(int nValue) {
        this.setParamValue(TAG_OUTPUTSTDDATATYPE, nValue);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.isParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.getParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.isParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.getParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.setParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isOUTPUTVALUEFORMATNull() {
        return this.isParamNull(TAG_OUTPUTVALUEFORMAT);
    }

    public final String getOUTPUTVALUEFORMAT() {
        return this.getParamStringValue(TAG_OUTPUTVALUEFORMAT, "");
    }

    public final void setOUTPUTVALUEFORMAT(String strValue) {
        this.setParamValue(TAG_OUTPUTVALUEFORMAT, strValue);
    }
}

