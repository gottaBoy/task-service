/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSPFCtrlTemplDetail
extends BaseDataEntity {
    public static final String TAG_PSPFCTDETAILID = "PSPFCTDETAILID";
    public static final String TAG_PSPFCTDETAILNAME = "PSPFCTDETAILNAME";
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
    public static final String TAG_LOGICNAME = "LOGICNAME";

    public final boolean isPSPFCTDETAILIDNull() {
        return this.isParamNull(TAG_PSPFCTDETAILID);
    }

    public final String getPSPFCTDETAILID() {
        return this.getParamStringValue(TAG_PSPFCTDETAILID, "");
    }

    public final void setPSPFCTDETAILID(String strValue) {
        this.setParamValue(TAG_PSPFCTDETAILID, strValue);
    }

    public final boolean isPSPFCTDETAILNAMENull() {
        return this.isParamNull(TAG_PSPFCTDETAILNAME);
    }

    public final String getPSPFCTDETAILNAME() {
        return this.getParamStringValue(TAG_PSPFCTDETAILNAME, "");
    }

    public final void setPSPFCTDETAILNAME(String strValue) {
        this.setParamValue(TAG_PSPFCTDETAILNAME, strValue);
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

    public final boolean isPSPFCTRLTEMPLIDNull() {
        return this.isParamNull(TAG_PSPFCTRLTEMPLID);
    }

    public final String getPSPFCTRLTEMPLID() {
        return this.getParamStringValue(TAG_PSPFCTRLTEMPLID, "");
    }

    public final void setPSPFCTRLTEMPLID(String strValue) {
        this.setParamValue(TAG_PSPFCTRLTEMPLID, strValue);
    }

    public final boolean isPSPFCTRLTEMPLNAMENull() {
        return this.isParamNull(TAG_PSPFCTRLTEMPLNAME);
    }

    public final String getPSPFCTRLTEMPLNAME() {
        return this.getParamStringValue(TAG_PSPFCTRLTEMPLNAME, "");
    }

    public final void setPSPFCTRLTEMPLNAME(String strValue) {
        this.setParamValue(TAG_PSPFCTRLTEMPLNAME, strValue);
    }

    public final boolean isTEMPLCODENull() {
        return this.isParamNull(TAG_TEMPLCODE);
    }

    public final String getTEMPLCODE() {
        return this.getParamStringValue(TAG_TEMPLCODE, "");
    }

    public final void setTEMPLCODE(String strValue) {
        this.setParamValue(TAG_TEMPLCODE, strValue);
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

    public final boolean isPUBOBJNull() {
        return this.isParamNull(TAG_PUBOBJ);
    }

    public final String getPUBOBJ() {
        return this.getParamStringValue(TAG_PUBOBJ, "");
    }

    public final void setPUBOBJ(String strValue) {
        this.setParamValue(TAG_PUBOBJ, strValue);
    }

    public final boolean isTEMPLCODE2Null() {
        return this.isParamNull(TAG_TEMPLCODE2);
    }

    public final String getTEMPLCODE2() {
        return this.getParamStringValue(TAG_TEMPLCODE2, "");
    }

    public final void setTEMPLCODE2(String strValue) {
        this.setParamValue(TAG_TEMPLCODE2, strValue);
    }

    public final boolean isTEMPLCODE3Null() {
        return this.isParamNull(TAG_TEMPLCODE3);
    }

    public final String getTEMPLCODE3() {
        return this.getParamStringValue(TAG_TEMPLCODE3, "");
    }

    public final void setTEMPLCODE3(String strValue) {
        this.setParamValue(TAG_TEMPLCODE3, strValue);
    }

    public final boolean isTEMPLCODE4Null() {
        return this.isParamNull(TAG_TEMPLCODE4);
    }

    public final String getTEMPLCODE4() {
        return this.getParamStringValue(TAG_TEMPLCODE4, "");
    }

    public final void setTEMPLCODE4(String strValue) {
        this.setParamValue(TAG_TEMPLCODE4, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.isParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.getParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.setParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isTEMPLDESCNull() {
        return this.isParamNull(TAG_TEMPLDESC);
    }

    public final String getTEMPLDESC() {
        return this.getParamStringValue(TAG_TEMPLDESC, "");
    }

    public final void setTEMPLDESC(String strValue) {
        this.setParamValue(TAG_TEMPLDESC, strValue);
    }

    public final boolean isLOGICNAMENull() {
        return this.isParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.getParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.setParamValue(TAG_LOGICNAME, strValue);
    }
}

