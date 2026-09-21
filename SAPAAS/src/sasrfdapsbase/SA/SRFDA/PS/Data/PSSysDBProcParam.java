/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysDBProcParam
extends BaseDataEntity {
    public static final int PARAMDIR_1 = 1;
    public static final int PARAMDIR_2 = 2;
    public static final int PARAMDIR_3 = 3;
    public static final int PARAMDIR_4 = 4;
    public static final int PARAMDIR_5 = 5;
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
    public static final String TAG_PSSYSDBPROCPARAMID = "PSSYSDBPROCPARAMID";
    public static final String TAG_PSSYSDBPROCPARAMNAME = "PSSYSDBPROCPARAMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSDBPROCID = "PSSYSDBPROCID";
    public static final String TAG_PSSYSDBPROCNAME = "PSSYSDBPROCNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_PARAMDIR = "PARAMDIR";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_STDDATATYPE = "STDDATATYPE";
    public static final String TAG_PRECISION2 = "PRECISION2";
    public static final String TAG_LENGTH = "LENGTH";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_DEFAULTVALUE = "DEFAULTVALUE";

    public final boolean isPSSYSDBPROCPARAMIDNull() {
        return this.IsParamNull(TAG_PSSYSDBPROCPARAMID);
    }

    public final String getPSSYSDBPROCPARAMID() {
        return this.GetParamStringValue(TAG_PSSYSDBPROCPARAMID, "");
    }

    public final void setPSSYSDBPROCPARAMID(String strValue) {
        this.SetParamValue(TAG_PSSYSDBPROCPARAMID, strValue);
    }

    public final boolean isPSSYSDBPROCPARAMNAMENull() {
        return this.IsParamNull(TAG_PSSYSDBPROCPARAMNAME);
    }

    public final String getPSSYSDBPROCPARAMNAME() {
        return this.GetParamStringValue(TAG_PSSYSDBPROCPARAMNAME, "");
    }

    public final void setPSSYSDBPROCPARAMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDBPROCPARAMNAME, strValue);
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

    public final boolean isPSSYSDBPROCIDNull() {
        return this.IsParamNull(TAG_PSSYSDBPROCID);
    }

    public final String getPSSYSDBPROCID() {
        return this.GetParamStringValue(TAG_PSSYSDBPROCID, "");
    }

    public final void setPSSYSDBPROCID(String strValue) {
        this.SetParamValue(TAG_PSSYSDBPROCID, strValue);
    }

    public final boolean isPSSYSDBPROCNAMENull() {
        return this.IsParamNull(TAG_PSSYSDBPROCNAME);
    }

    public final String getPSSYSDBPROCNAME() {
        return this.GetParamStringValue(TAG_PSSYSDBPROCNAME, "");
    }

    public final void setPSSYSDBPROCNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDBPROCNAME, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isPARAMDIRNull() {
        return this.IsParamNull(TAG_PARAMDIR);
    }

    public final int getPARAMDIR() {
        return this.GetParamIntValue(TAG_PARAMDIR, 0);
    }

    public final void setPARAMDIR(int nValue) {
        this.SetParamValue(TAG_PARAMDIR, nValue);
    }

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
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

    public final boolean isPRECISION2Null() {
        return this.IsParamNull(TAG_PRECISION2);
    }

    public final int getPRECISION2() {
        return this.GetParamIntValue(TAG_PRECISION2, 0);
    }

    public final void setPRECISION2(int nValue) {
        this.SetParamValue(TAG_PRECISION2, nValue);
    }

    public final boolean isLENGTHNull() {
        return this.IsParamNull(TAG_LENGTH);
    }

    public final int getLENGTH() {
        return this.GetParamIntValue(TAG_LENGTH, 0);
    }

    public final void setLENGTH(int nValue) {
        this.SetParamValue(TAG_LENGTH, nValue);
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

    public final boolean isDEFAULTVALUENull() {
        return this.IsParamNull(TAG_DEFAULTVALUE);
    }

    public final String getDEFAULTVALUE() {
        return this.GetParamStringValue(TAG_DEFAULTVALUE, "");
    }

    public final void setDEFAULTVALUE(String strValue) {
        this.SetParamValue(TAG_DEFAULTVALUE, strValue);
    }
}

