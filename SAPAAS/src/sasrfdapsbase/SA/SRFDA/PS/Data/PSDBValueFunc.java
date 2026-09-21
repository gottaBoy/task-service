/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDBValueFunc
extends BaseDataEntity {
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
    public static final String TAG_PSDBVALUEFUNCID = "PSDBVALUEFUNCID";
    public static final String TAG_PSDBVALUEFUNCNAME = "PSDBVALUEFUNCNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_INPUTSTDDATATYPE = "INPUTSTDDATATYPE";
    public static final String TAG_OUTPUTSTDDATATYPE = "OUTPUTSTDDATATYPE";
    public static final String TAG_FUNCSN = "FUNCSN";

    public final boolean isPSDBVALUEFUNCIDNull() {
        return this.IsParamNull(TAG_PSDBVALUEFUNCID);
    }

    public final String getPSDBVALUEFUNCID() {
        return this.GetParamStringValue(TAG_PSDBVALUEFUNCID, "");
    }

    public final void setPSDBVALUEFUNCID(String strValue) {
        this.SetParamValue(TAG_PSDBVALUEFUNCID, strValue);
    }

    public final boolean isPSDBVALUEFUNCNAMENull() {
        return this.IsParamNull(TAG_PSDBVALUEFUNCNAME);
    }

    public final String getPSDBVALUEFUNCNAME() {
        return this.GetParamStringValue(TAG_PSDBVALUEFUNCNAME, "");
    }

    public final void setPSDBVALUEFUNCNAME(String strValue) {
        this.SetParamValue(TAG_PSDBVALUEFUNCNAME, strValue);
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

    public final boolean isFUNCSNNull() {
        return this.IsParamNull(TAG_FUNCSN);
    }

    public final String getFUNCSN() {
        return this.GetParamStringValue(TAG_FUNCSN, "");
    }

    public final void setFUNCSN(String strValue) {
        this.SetParamValue(TAG_FUNCSN, strValue);
    }
}

