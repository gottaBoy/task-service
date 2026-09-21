/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysViewLogicParam
extends BaseDataEntity {
    public static final String TAG_PSSYSVIEWLOGICPARAMID = "PSSYSVIEWLOGICPARAMID";
    public static final String TAG_PSSYSVIEWLOGICPARAMNAME = "PSSYSVIEWLOGICPARAMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSVIEWLOGICID = "PSSYSVIEWLOGICID";
    public static final String TAG_PSSYSVIEWLOGICNAME = "PSSYSVIEWLOGICNAME";
    public static final String TAG_PARAMTYPE = "PARAMTYPE";
    public static final String TAG_PARAMDESC = "PARAMDESC";
    public static final String TAG_PARAMVALUE = "PARAMVALUE";
    public static final String TAG_PARAMVALUE2 = "PARAMVALUE2";
    public static final String TAG_PARAMSTATE = "PARAMSTATE";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_PARAMVALUE3 = "PARAMVALUE3";
    public static final String TAG_PARAMVALUE4 = "PARAMVALUE4";
    public static final String TAG_PARAMVALUE5 = "PARAMVALUE5";
    public static final String TAG_PARAMVALUE6 = "PARAMVALUE6";
    public static final String TAG_PARAMVALUE7 = "PARAMVALUE7";
    public static final String TAG_PARAMVALUE8 = "PARAMVALUE8";
    public static final String TAG_PARAMVALUE9 = "PARAMVALUE9";
    public static final String TAG_PARAMVALUE10 = "PARAMVALUE10";
    public static final String TAG_REFOBJTYPE = "REFOBJTYPE";
    public static final String TAG_REFOBJID = "REFOBJID";
    public static final String TAG_REFOBJNAME = "REFOBJNAME";
    public static final String TAG_PARAMCAT = "PARAMCAT";
    public static final String TAG_PARAMSUBKEY = "PARAMSUBKEY";
    public static final String TAG_PARAMKEY = "PARAMKEY";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSSYSVIEWLOGICPARAMIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWLOGICPARAMID);
    }

    public final String getPSSYSVIEWLOGICPARAMID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWLOGICPARAMID, "");
    }

    public final void setPSSYSVIEWLOGICPARAMID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWLOGICPARAMID, strValue);
    }

    public final boolean isPSSYSVIEWLOGICPARAMNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWLOGICPARAMNAME);
    }

    public final String getPSSYSVIEWLOGICPARAMNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWLOGICPARAMNAME, "");
    }

    public final void setPSSYSVIEWLOGICPARAMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWLOGICPARAMNAME, strValue);
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

    public final boolean isPSSYSVIEWLOGICIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWLOGICID);
    }

    public final String getPSSYSVIEWLOGICID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWLOGICID, "");
    }

    public final void setPSSYSVIEWLOGICID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWLOGICID, strValue);
    }

    public final boolean isPSSYSVIEWLOGICNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWLOGICNAME);
    }

    public final String getPSSYSVIEWLOGICNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWLOGICNAME, "");
    }

    public final void setPSSYSVIEWLOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWLOGICNAME, strValue);
    }

    public final boolean isPARAMTYPENull() {
        return this.IsParamNull(TAG_PARAMTYPE);
    }

    public final String getPARAMTYPE() {
        return this.GetParamStringValue(TAG_PARAMTYPE, "");
    }

    public final void setPARAMTYPE(String strValue) {
        this.SetParamValue(TAG_PARAMTYPE, strValue);
    }

    public final boolean isPARAMDESCNull() {
        return this.IsParamNull(TAG_PARAMDESC);
    }

    public final String getPARAMDESC() {
        return this.GetParamStringValue(TAG_PARAMDESC, "");
    }

    public final void setPARAMDESC(String strValue) {
        this.SetParamValue(TAG_PARAMDESC, strValue);
    }

    public final boolean isPARAMVALUENull() {
        return this.IsParamNull(TAG_PARAMVALUE);
    }

    public final String getPARAMVALUE() {
        return this.GetParamStringValue(TAG_PARAMVALUE, "");
    }

    public final void setPARAMVALUE(String strValue) {
        this.SetParamValue(TAG_PARAMVALUE, strValue);
    }

    public final boolean isPARAMVALUE2Null() {
        return this.IsParamNull(TAG_PARAMVALUE2);
    }

    public final String getPARAMVALUE2() {
        return this.GetParamStringValue(TAG_PARAMVALUE2, "");
    }

    public final void setPARAMVALUE2(String strValue) {
        this.SetParamValue(TAG_PARAMVALUE2, strValue);
    }

    public final boolean isPARAMSTATENull() {
        return this.IsParamNull(TAG_PARAMSTATE);
    }

    public final int getPARAMSTATE() {
        return this.GetParamIntValue(TAG_PARAMSTATE, 0);
    }

    public final void setPARAMSTATE(int nValue) {
        this.SetParamValue(TAG_PARAMSTATE, nValue);
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

    public final boolean isPARAMVALUE3Null() {
        return this.IsParamNull(TAG_PARAMVALUE3);
    }

    public final String getPARAMVALUE3() {
        return this.GetParamStringValue(TAG_PARAMVALUE3, "");
    }

    public final void setPARAMVALUE3(String strValue) {
        this.SetParamValue(TAG_PARAMVALUE3, strValue);
    }

    public final boolean isPARAMVALUE4Null() {
        return this.IsParamNull(TAG_PARAMVALUE4);
    }

    public final String getPARAMVALUE4() {
        return this.GetParamStringValue(TAG_PARAMVALUE4, "");
    }

    public final void setPARAMVALUE4(String strValue) {
        this.SetParamValue(TAG_PARAMVALUE4, strValue);
    }

    public final boolean isPARAMVALUE5Null() {
        return this.IsParamNull(TAG_PARAMVALUE5);
    }

    public final int getPARAMVALUE5() {
        return this.GetParamIntValue(TAG_PARAMVALUE5, 0);
    }

    public final void setPARAMVALUE5(int nValue) {
        this.SetParamValue(TAG_PARAMVALUE5, nValue);
    }

    public final boolean isPARAMVALUE6Null() {
        return this.IsParamNull(TAG_PARAMVALUE6);
    }

    public final int getPARAMVALUE6() {
        return this.GetParamIntValue(TAG_PARAMVALUE6, 0);
    }

    public final void setPARAMVALUE6(int nValue) {
        this.SetParamValue(TAG_PARAMVALUE6, nValue);
    }

    public final boolean isPARAMVALUE7Null() {
        return this.IsParamNull(TAG_PARAMVALUE7);
    }

    public final String getPARAMVALUE7() {
        return this.GetParamStringValue(TAG_PARAMVALUE7, "");
    }

    public final void setPARAMVALUE7(String strValue) {
        this.SetParamValue(TAG_PARAMVALUE7, strValue);
    }

    public final boolean isPARAMVALUE8Null() {
        return this.IsParamNull(TAG_PARAMVALUE8);
    }

    public final String getPARAMVALUE8() {
        return this.GetParamStringValue(TAG_PARAMVALUE8, "");
    }

    public final void setPARAMVALUE8(String strValue) {
        this.SetParamValue(TAG_PARAMVALUE8, strValue);
    }

    public final boolean isPARAMVALUE9Null() {
        return this.IsParamNull(TAG_PARAMVALUE9);
    }

    public final boolean getPARAMVALUE9() {
        return this.GetParamIntValue(TAG_PARAMVALUE9, 0) == 1;
    }

    public final void setPARAMVALUE9(boolean bValue) {
        this.SetParamValue(TAG_PARAMVALUE9, bValue ? 1 : 0);
    }

    public final boolean isPARAMVALUE10Null() {
        return this.IsParamNull(TAG_PARAMVALUE10);
    }

    public final boolean getPARAMVALUE10() {
        return this.GetParamIntValue(TAG_PARAMVALUE10, 0) == 1;
    }

    public final void setPARAMVALUE10(boolean bValue) {
        this.SetParamValue(TAG_PARAMVALUE10, bValue ? 1 : 0);
    }

    public final boolean isREFOBJTYPENull() {
        return this.IsParamNull(TAG_REFOBJTYPE);
    }

    public final String getREFOBJTYPE() {
        return this.GetParamStringValue(TAG_REFOBJTYPE, "");
    }

    public final void setREFOBJTYPE(String strValue) {
        this.SetParamValue(TAG_REFOBJTYPE, strValue);
    }

    public final boolean isREFOBJIDNull() {
        return this.IsParamNull(TAG_REFOBJID);
    }

    public final String getREFOBJID() {
        return this.GetParamStringValue(TAG_REFOBJID, "");
    }

    public final void setREFOBJID(String strValue) {
        this.SetParamValue(TAG_REFOBJID, strValue);
    }

    public final boolean isREFOBJNAMENull() {
        return this.IsParamNull(TAG_REFOBJNAME);
    }

    public final String getREFOBJNAME() {
        return this.GetParamStringValue(TAG_REFOBJNAME, "");
    }

    public final void setREFOBJNAME(String strValue) {
        this.SetParamValue(TAG_REFOBJNAME, strValue);
    }

    public final boolean isPARAMCATNull() {
        return this.IsParamNull(TAG_PARAMCAT);
    }

    public final String getPARAMCAT() {
        return this.GetParamStringValue(TAG_PARAMCAT, "");
    }

    public final void setPARAMCAT(String strValue) {
        this.SetParamValue(TAG_PARAMCAT, strValue);
    }

    public final boolean isPARAMSUBKEYNull() {
        return this.IsParamNull(TAG_PARAMSUBKEY);
    }

    public final String getPARAMSUBKEY() {
        return this.GetParamStringValue(TAG_PARAMSUBKEY, "");
    }

    public final void setPARAMSUBKEY(String strValue) {
        this.SetParamValue(TAG_PARAMSUBKEY, strValue);
    }

    public final boolean isPARAMKEYNull() {
        return this.IsParamNull(TAG_PARAMKEY);
    }

    public final String getPARAMKEY() {
        return this.GetParamStringValue(TAG_PARAMKEY, "");
    }

    public final void setPARAMKEY(String strValue) {
        this.SetParamValue(TAG_PARAMKEY, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }
}

