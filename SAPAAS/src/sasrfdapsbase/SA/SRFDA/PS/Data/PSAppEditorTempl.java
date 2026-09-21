/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppEditorTempl
extends BaseDataEntity {
    public static final String CONTAINERTYPE_FORMITEM = "FORMITEM";
    public static final String CONTAINERTYPE_GRIDCOLUMN = "GRIDCOLUMN";
    public static final String TAG_PSAPPEDITORTEMPLID = "PSAPPEDITORTEMPLID";
    public static final String TAG_PSAPPEDITORTEMPLNAME = "PSAPPEDITORTEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSPFPUBCODEID = "PSPFPUBCODEID";
    public static final String TAG_PSPFPUBCODENAME = "PSPFPUBCODENAME";
    public static final String TAG_TEMPLCODE = "TEMPLCODE";
    public static final String TAG_TEMPLCODE2 = "TEMPLCODE2";
    public static final String TAG_TEMPLCODE3 = "TEMPLCODE3";
    public static final String TAG_TEMPLCODE4 = "TEMPLCODE4";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PUBOBJ = "PUBOBJ";
    public static final String TAG_PSEDITORTYPEID = "PSEDITORTYPEID";
    public static final String TAG_PSEDITORTYPENAME = "PSEDITORTYPENAME";
    public static final String TAG_PSSYSEDITORSTYLEID = "PSSYSEDITORSTYLEID";
    public static final String TAG_PSSYSEDITORSTYLENAME = "PSSYSEDITORSTYLENAME";
    public static final String TAG_CONTAINERTYPE = "CONTAINERTYPE";
    public static final String TAG_REQCODE = "REQCODE";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";

    public final boolean isPSAPPEDITORTEMPLIDNull() {
        return this.IsParamNull(TAG_PSAPPEDITORTEMPLID);
    }

    public final String getPSAPPEDITORTEMPLID() {
        return this.GetParamStringValue(TAG_PSAPPEDITORTEMPLID, "");
    }

    public final void setPSAPPEDITORTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSAPPEDITORTEMPLID, strValue);
    }

    public final boolean isPSAPPEDITORTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSAPPEDITORTEMPLNAME);
    }

    public final String getPSAPPEDITORTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSAPPEDITORTEMPLNAME, "");
    }

    public final void setPSAPPEDITORTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPEDITORTEMPLNAME, strValue);
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

    public final boolean isPSPFPUBCODEIDNull() {
        return this.IsParamNull(TAG_PSPFPUBCODEID);
    }

    public final String getPSPFPUBCODEID() {
        return this.GetParamStringValue(TAG_PSPFPUBCODEID, "");
    }

    public final void setPSPFPUBCODEID(String strValue) {
        this.SetParamValue(TAG_PSPFPUBCODEID, strValue);
    }

    public final boolean isPSPFPUBCODENAMENull() {
        return this.IsParamNull(TAG_PSPFPUBCODENAME);
    }

    public final String getPSPFPUBCODENAME() {
        return this.GetParamStringValue(TAG_PSPFPUBCODENAME, "");
    }

    public final void setPSPFPUBCODENAME(String strValue) {
        this.SetParamValue(TAG_PSPFPUBCODENAME, strValue);
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

    public final boolean isPSEDITORTYPEIDNull() {
        return this.IsParamNull(TAG_PSEDITORTYPEID);
    }

    public final String getPSEDITORTYPEID() {
        return this.GetParamStringValue(TAG_PSEDITORTYPEID, "");
    }

    public final void setPSEDITORTYPEID(String strValue) {
        this.SetParamValue(TAG_PSEDITORTYPEID, strValue);
    }

    public final boolean isPSEDITORTYPENAMENull() {
        return this.IsParamNull(TAG_PSEDITORTYPENAME);
    }

    public final String getPSEDITORTYPENAME() {
        return this.GetParamStringValue(TAG_PSEDITORTYPENAME, "");
    }

    public final void setPSEDITORTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSEDITORTYPENAME, strValue);
    }

    public final boolean isPSSYSEDITORSTYLEIDNull() {
        return this.IsParamNull(TAG_PSSYSEDITORSTYLEID);
    }

    public final String getPSSYSEDITORSTYLEID() {
        return this.GetParamStringValue(TAG_PSSYSEDITORSTYLEID, "");
    }

    public final void setPSSYSEDITORSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSSYSEDITORSTYLEID, strValue);
    }

    public final boolean isPSSYSEDITORSTYLENAMENull() {
        return this.IsParamNull(TAG_PSSYSEDITORSTYLENAME);
    }

    public final String getPSSYSEDITORSTYLENAME() {
        return this.GetParamStringValue(TAG_PSSYSEDITORSTYLENAME, "");
    }

    public final void setPSSYSEDITORSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSEDITORSTYLENAME, strValue);
    }

    public final boolean isCONTAINERTYPENull() {
        return this.IsParamNull(TAG_CONTAINERTYPE);
    }

    public final String getCONTAINERTYPE() {
        return this.GetParamStringValue(TAG_CONTAINERTYPE, "");
    }

    public final void setCONTAINERTYPE(String strValue) {
        this.SetParamValue(TAG_CONTAINERTYPE, strValue);
    }

    public final boolean isREQCODENull() {
        return this.IsParamNull(TAG_REQCODE);
    }

    public final String getREQCODE() {
        return this.GetParamStringValue(TAG_REQCODE, "");
    }

    public final void setREQCODE(String strValue) {
        this.SetParamValue(TAG_REQCODE, strValue);
    }

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME, strValue);
    }

    public final boolean isPSPFIDNull() {
        return this.IsParamNull(TAG_PSPFID);
    }

    public final String getPSPFID() {
        return this.GetParamStringValue(TAG_PSPFID, "");
    }

    public final void setPSPFID(String strValue) {
        this.SetParamValue(TAG_PSPFID, strValue);
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
}

