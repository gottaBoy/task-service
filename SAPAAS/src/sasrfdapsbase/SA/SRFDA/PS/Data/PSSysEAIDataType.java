/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysEAIDataType
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
    public static final int STDDATATYPE_0 = 0;
    public static final int STDDATATYPE_1 = 1;
    public static final int STDDATATYPE_2 = 2;
    public static final int STDDATATYPE_3 = 3;
    public static final int STDDATATYPE_4 = 4;
    public static final int STDDATATYPE_5 = 5;
    public static final int STDDATATYPE_6 = 6;
    public static final int STDDATATYPE_7 = 7;
    public static final int STDDATATYPE_8 = 8;
    public static final int STDDATATYPE_9 = 9;
    public static final int STDDATATYPE_10 = 10;
    public static final int STDDATATYPE_11 = 11;
    public static final int STDDATATYPE_12 = 12;
    public static final int STDDATATYPE_13 = 13;
    public static final int STDDATATYPE_14 = 14;
    public static final int STDDATATYPE_15 = 15;
    public static final int STDDATATYPE_16 = 16;
    public static final int STDDATATYPE_17 = 17;
    public static final int STDDATATYPE_18 = 18;
    public static final int STDDATATYPE_19 = 19;
    public static final int STDDATATYPE_20 = 20;
    public static final int STDDATATYPE_21 = 21;
    public static final int STDDATATYPE_22 = 22;
    public static final int STDDATATYPE_23 = 23;
    public static final int STDDATATYPE_24 = 24;
    public static final int STDDATATYPE_25 = 25;
    public static final int STDDATATYPE_26 = 26;
    public static final int STDDATATYPE_27 = 27;
    public static final int STDDATATYPE_28 = 28;
    public static final int STDDATATYPE_29 = 29;
    public static final String TAG_PSSYSEAIDATATYPEID = "PSSYSEAIDATATYPEID";
    public static final String TAG_PSSYSEAIDATATYPENAME = "PSSYSEAIDATATYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSEAISCHEMEID = "PSSYSEAISCHEMEID";
    public static final String TAG_PSSYSEAISCHEMENAME = "PSSYSEAISCHEMENAME";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_EAIDATATYPETAG = "EAIDATATYPETAG";
    public static final String TAG_EAIDATATYPETAG2 = "EAIDATATYPETAG2";
    public static final String TAG_STDDATATYPE = "STDDATATYPE";
    public static final String TAG_MINSTRLENGTH = "MINSTRLENGTH";
    public static final String TAG_MAXSTRLENGTH = "MAXSTRLENGTH";
    public static final String TAG_MINVALUE = "MINVALUE";
    public static final String TAG_MAXVALUE = "MAXVALUE";
    public static final String TAG_PRECISION2 = "PRECISION2";
    public static final String TAG_REGEXPCODE = "REGEXPCODE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_INCMINVALUE = "INCMINVALUE";
    public static final String TAG_INCMAXVALUE = "INCMAXVALUE";
    public static final String TAG_ENABLEENUM = "ENABLEENUM";

    public final boolean isPSSYSEAIDATATYPEIDNull() {
        return this.IsParamNull(TAG_PSSYSEAIDATATYPEID);
    }

    public final String getPSSYSEAIDATATYPEID() {
        return this.GetParamStringValue(TAG_PSSYSEAIDATATYPEID, "");
    }

    public final void setPSSYSEAIDATATYPEID(String strValue) {
        this.SetParamValue(TAG_PSSYSEAIDATATYPEID, strValue);
    }

    public final boolean isPSSYSEAIDATATYPENAMENull() {
        return this.IsParamNull(TAG_PSSYSEAIDATATYPENAME);
    }

    public final String getPSSYSEAIDATATYPENAME() {
        return this.GetParamStringValue(TAG_PSSYSEAIDATATYPENAME, "");
    }

    public final void setPSSYSEAIDATATYPENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSEAIDATATYPENAME, strValue);
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

    public final boolean isPSSYSEAISCHEMEIDNull() {
        return this.IsParamNull(TAG_PSSYSEAISCHEMEID);
    }

    public final String getPSSYSEAISCHEMEID() {
        return this.GetParamStringValue(TAG_PSSYSEAISCHEMEID, "");
    }

    public final void setPSSYSEAISCHEMEID(String strValue) {
        this.SetParamValue(TAG_PSSYSEAISCHEMEID, strValue);
    }

    public final boolean isPSSYSEAISCHEMENAMENull() {
        return this.IsParamNull(TAG_PSSYSEAISCHEMENAME);
    }

    public final String getPSSYSEAISCHEMENAME() {
        return this.GetParamStringValue(TAG_PSSYSEAISCHEMENAME, "");
    }

    public final void setPSSYSEAISCHEMENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSEAISCHEMENAME, strValue);
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

    public final boolean isEAIDATATYPETAGNull() {
        return this.IsParamNull(TAG_EAIDATATYPETAG);
    }

    public final String getEAIDATATYPETAG() {
        return this.GetParamStringValue(TAG_EAIDATATYPETAG, "");
    }

    public final void setEAIDATATYPETAG(String strValue) {
        this.SetParamValue(TAG_EAIDATATYPETAG, strValue);
    }

    public final boolean isEAIDATATYPETAG2Null() {
        return this.IsParamNull(TAG_EAIDATATYPETAG2);
    }

    public final String getEAIDATATYPETAG2() {
        return this.GetParamStringValue(TAG_EAIDATATYPETAG2, "");
    }

    public final void setEAIDATATYPETAG2(String strValue) {
        this.SetParamValue(TAG_EAIDATATYPETAG2, strValue);
    }

    public final boolean isSTDDATATYPENull() {
        return this.IsParamNull(TAG_STDDATATYPE);
    }

    public final int getSTDDATATYPE() {
        return this.GetParamIntValue(TAG_STDDATATYPE, 0);
    }

    public final void setSTDDATATYPE(int nValue) {
        this.SetParamValue(TAG_STDDATATYPE, nValue);
    }

    public final boolean isMINSTRLENGTHNull() {
        return this.IsParamNull(TAG_MINSTRLENGTH);
    }

    public final int getMINSTRLENGTH() {
        return this.GetParamIntValue(TAG_MINSTRLENGTH, 0);
    }

    public final void setMINSTRLENGTH(int nValue) {
        this.SetParamValue(TAG_MINSTRLENGTH, nValue);
    }

    public final boolean isMAXSTRLENGTHNull() {
        return this.IsParamNull(TAG_MAXSTRLENGTH);
    }

    public final int getMAXSTRLENGTH() {
        return this.GetParamIntValue(TAG_MAXSTRLENGTH, 0);
    }

    public final void setMAXSTRLENGTH(int nValue) {
        this.SetParamValue(TAG_MAXSTRLENGTH, nValue);
    }

    public final boolean isMINVALUENull() {
        return this.IsParamNull(TAG_MINVALUE);
    }

    public final String getMINVALUE() {
        return this.GetParamStringValue(TAG_MINVALUE, "");
    }

    public final void setMINVALUE(String strValue) {
        this.SetParamValue(TAG_MINVALUE, strValue);
    }

    public final boolean isMAXVALUENull() {
        return this.IsParamNull(TAG_MAXVALUE);
    }

    public final String getMAXVALUE() {
        return this.GetParamStringValue(TAG_MAXVALUE, "");
    }

    public final void setMAXVALUE(String strValue) {
        this.SetParamValue(TAG_MAXVALUE, strValue);
    }

    public final boolean isPRECISION2Null() {
        return this.IsParamNull(TAG_PRECISION2);
    }

    public final int getPRECISION2() {
        return this.GetParamIntValue(TAG_PRECISION2, 0);
    }

    public final void setPRECISION2(int nValue) {
        this.SetParamValue(TAG_PRECISION2, nValue);
    }

    public final boolean isREGEXPCODENull() {
        return this.IsParamNull(TAG_REGEXPCODE);
    }

    public final String getREGEXPCODE() {
        return this.GetParamStringValue(TAG_REGEXPCODE, "");
    }

    public final void setREGEXPCODE(String strValue) {
        this.SetParamValue(TAG_REGEXPCODE, strValue);
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

    public final boolean isINCMINVALUENull() {
        return this.IsParamNull(TAG_INCMINVALUE);
    }

    public final boolean getINCMINVALUE() {
        return this.GetParamIntValue(TAG_INCMINVALUE, 0) == 1;
    }

    public final void setINCMINVALUE(boolean bValue) {
        this.SetParamValue(TAG_INCMINVALUE, bValue ? 1 : 0);
    }

    public final boolean isINCMAXVALUENull() {
        return this.IsParamNull(TAG_INCMAXVALUE);
    }

    public final boolean getINCMAXVALUE() {
        return this.GetParamIntValue(TAG_INCMAXVALUE, 0) == 1;
    }

    public final void setINCMAXVALUE(boolean bValue) {
        this.SetParamValue(TAG_INCMAXVALUE, bValue ? 1 : 0);
    }

    public final boolean isENABLEENUMNull() {
        return this.IsParamNull(TAG_ENABLEENUM);
    }

    public final boolean getENABLEENUM() {
        return this.GetParamIntValue(TAG_ENABLEENUM, 0) == 1;
    }

    public final void setENABLEENUM(boolean bValue) {
        this.SetParamValue(TAG_ENABLEENUM, bValue ? 1 : 0);
    }
}

