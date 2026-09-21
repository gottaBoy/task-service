/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSFDBTemplDetail
extends BaseDataEntity {
    public static final String TAG_PSSFDBDETAILID = "PSSFDBDETAILID";
    public static final String TAG_PSSFDBDETAILNAME = "PSSFDBDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSPFCTRLTEMPLID = "PSPFCTRLTEMPLID";
    public static final String TAG_PSPFCTRLTEMPLNAME = "PSPFCTRLTEMPLNAME";
    public static final String TAG_TEMPLCODE = "TEMPLCODE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PUBOBJ = "PUBOBJ";
    public static final String TAG_TEMPLCODE2 = "TEMPLCODE2";
    public static final String TAG_TEMPLCODE3 = "TEMPLCODE3";
    public static final String TAG_TEMPLCODE4 = "TEMPLCODE4";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_TEMPLDESC = "TEMPLDESC";
    public static final String TAG_DBNAME = "DBNAME";

    public final boolean isPSSFDBDETAILIDNull() {
        return this.IsParamNull(TAG_PSSFDBDETAILID);
    }

    public final String getPSSFDBDETAILID() {
        return this.GetParamStringValue(TAG_PSSFDBDETAILID, "");
    }

    public final void setPSSFDBDETAILID(String strValue) {
        this.SetParamValue(TAG_PSSFDBDETAILID, strValue);
    }

    public final boolean isPSSFDBDETAILNAMENull() {
        return this.IsParamNull(TAG_PSSFDBDETAILNAME);
    }

    public final String getPSSFDBDETAILNAME() {
        return this.GetParamStringValue(TAG_PSSFDBDETAILNAME, "");
    }

    public final void setPSSFDBDETAILNAME(String strValue) {
        this.SetParamValue(TAG_PSSFDBDETAILNAME, strValue);
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

    public final boolean isPSPFCTRLTEMPLIDNull() {
        return this.IsParamNull(TAG_PSPFCTRLTEMPLID);
    }

    public final String getPSPFCTRLTEMPLID() {
        return this.GetParamStringValue(TAG_PSPFCTRLTEMPLID, "");
    }

    public final void setPSPFCTRLTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSPFCTRLTEMPLID, strValue);
    }

    public final boolean isPSPFCTRLTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSPFCTRLTEMPLNAME);
    }

    public final String getPSPFCTRLTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSPFCTRLTEMPLNAME, "");
    }

    public final void setPSPFCTRLTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSPFCTRLTEMPLNAME, strValue);
    }

    public final boolean isTEMPLCODENull() {
        return this.IsParamNull(TAG_TEMPLCODE);
    }

    public final String getTEMPLCODE() {
        return this.GetParamStringValue(TAG_TEMPLCODE, "");
    }

    public final void setTEMPLCODE(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE, strValue);
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

    public final boolean isPUBOBJNull() {
        return this.IsParamNull(TAG_PUBOBJ);
    }

    public final String getPUBOBJ() {
        return this.GetParamStringValue(TAG_PUBOBJ, "");
    }

    public final void setPUBOBJ(String strValue) {
        this.SetParamValue(TAG_PUBOBJ, strValue);
    }

    public final boolean isTEMPLCODE2Null() {
        return this.IsParamNull(TAG_TEMPLCODE2);
    }

    public final String getTEMPLCODE2() {
        return this.GetParamStringValue(TAG_TEMPLCODE2, "");
    }

    public final void setTEMPLCODE2(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE2, strValue);
    }

    public final boolean isTEMPLCODE3Null() {
        return this.IsParamNull(TAG_TEMPLCODE3);
    }

    public final String getTEMPLCODE3() {
        return this.GetParamStringValue(TAG_TEMPLCODE3, "");
    }

    public final void setTEMPLCODE3(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE3, strValue);
    }

    public final boolean isTEMPLCODE4Null() {
        return this.IsParamNull(TAG_TEMPLCODE4);
    }

    public final String getTEMPLCODE4() {
        return this.GetParamStringValue(TAG_TEMPLCODE4, "");
    }

    public final void setTEMPLCODE4(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE4, strValue);
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

    public final boolean isTEMPLDESCNull() {
        return this.IsParamNull(TAG_TEMPLDESC);
    }

    public final String getTEMPLDESC() {
        return this.GetParamStringValue(TAG_TEMPLDESC, "");
    }

    public final void setTEMPLDESC(String strValue) {
        this.SetParamValue(TAG_TEMPLDESC, strValue);
    }

    public final boolean isDBNAMENull() {
        return this.IsParamNull(TAG_DBNAME);
    }

    public final String getDBNAME() {
        return this.GetParamStringValue(TAG_DBNAME, "");
    }

    public final void setDBNAME(String strValue) {
        this.SetParamValue(TAG_DBNAME, strValue);
    }
}

