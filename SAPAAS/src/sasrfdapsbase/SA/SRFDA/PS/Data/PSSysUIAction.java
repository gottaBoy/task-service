/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysUIAction
extends BaseDataEntity {
    public static final String TAG_PSSYSUIACTIONID = "PSSYSUIACTIONID";
    public static final String TAG_PSSYSUIACTIONNAME = "PSSYSUIACTIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_PSIMAGETEMPLID = "PSIMAGETEMPLID";
    public static final String TAG_PSIMAGETEMPLNAME = "PSIMAGETEMPLNAME";
    public static final String TAG_CAPPSSYSLANRESID = "CAPPSSYSLANRESID";
    public static final String TAG_CAPPSSYSLANRESNAME = "CAPPSSYSLANRESNAME";
    public static final String TAG_TIPPSSYSLANRESID = "TIPPSSYSLANRESID";
    public static final String TAG_TIPPSSYSLANRESNAME = "TIPPSSYSLANRESNAME";
    public static final String TAG_ACTIONTARGET = "ACTIONTARGET";
    public static final String TAG_ITEMOBJ = "ITEMOBJ";
    public static final String TAG_DEOPPRIV = "DEOPPRIV";
    public static final String TAG_TOGGLEMODE = "TOGGLEMODE";

    public final boolean isPSSYSUIACTIONIDNull() {
        return this.IsParamNull(TAG_PSSYSUIACTIONID);
    }

    public final String getPSSYSUIACTIONID() {
        return this.GetParamStringValue(TAG_PSSYSUIACTIONID, "");
    }

    public final void setPSSYSUIACTIONID(String strValue) {
        this.SetParamValue(TAG_PSSYSUIACTIONID, strValue);
    }

    public final boolean isPSSYSUIACTIONNAMENull() {
        return this.IsParamNull(TAG_PSSYSUIACTIONNAME);
    }

    public final String getPSSYSUIACTIONNAME() {
        return this.GetParamStringValue(TAG_PSSYSUIACTIONNAME, "");
    }

    public final void setPSSYSUIACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUIACTIONNAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isCAPTIONNull() {
        return this.IsParamNull(TAG_CAPTION);
    }

    public final String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public final void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
    }

    public final boolean isPSIMAGETEMPLIDNull() {
        return this.IsParamNull(TAG_PSIMAGETEMPLID);
    }

    public final String getPSIMAGETEMPLID() {
        return this.GetParamStringValue(TAG_PSIMAGETEMPLID, "");
    }

    public final void setPSIMAGETEMPLID(String strValue) {
        this.SetParamValue(TAG_PSIMAGETEMPLID, strValue);
    }

    public final boolean isPSIMAGETEMPLNAMENull() {
        return this.IsParamNull(TAG_PSIMAGETEMPLNAME);
    }

    public final String getPSIMAGETEMPLNAME() {
        return this.GetParamStringValue(TAG_PSIMAGETEMPLNAME, "");
    }

    public final void setPSIMAGETEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSIMAGETEMPLNAME, strValue);
    }

    public final boolean isCAPPSSYSLANRESIDNull() {
        return this.IsParamNull(TAG_CAPPSSYSLANRESID);
    }

    public final String getCAPPSSYSLANRESID() {
        return this.GetParamStringValue(TAG_CAPPSSYSLANRESID, "");
    }

    public final void setCAPPSSYSLANRESID(String strValue) {
        this.SetParamValue(TAG_CAPPSSYSLANRESID, strValue);
    }

    public final boolean isCAPPSSYSLANRESNAMENull() {
        return this.IsParamNull(TAG_CAPPSSYSLANRESNAME);
    }

    public final String getCAPPSSYSLANRESNAME() {
        return this.GetParamStringValue(TAG_CAPPSSYSLANRESNAME, "");
    }

    public final void setCAPPSSYSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_CAPPSSYSLANRESNAME, strValue);
    }

    public final boolean isTIPPSSYSLANRESIDNull() {
        return this.IsParamNull(TAG_TIPPSSYSLANRESID);
    }

    public final String getTIPPSSYSLANRESID() {
        return this.GetParamStringValue(TAG_TIPPSSYSLANRESID, "");
    }

    public final void setTIPPSSYSLANRESID(String strValue) {
        this.SetParamValue(TAG_TIPPSSYSLANRESID, strValue);
    }

    public final boolean isTIPPSSYSLANRESNAMENull() {
        return this.IsParamNull(TAG_TIPPSSYSLANRESNAME);
    }

    public final String getTIPPSSYSLANRESNAME() {
        return this.GetParamStringValue(TAG_TIPPSSYSLANRESNAME, "");
    }

    public final void setTIPPSSYSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_TIPPSSYSLANRESNAME, strValue);
    }

    public final boolean isACTIONTARGETNull() {
        return this.IsParamNull(TAG_ACTIONTARGET);
    }

    public final String getACTIONTARGET() {
        return this.GetParamStringValue(TAG_ACTIONTARGET, "");
    }

    public final void setACTIONTARGET(String strValue) {
        this.SetParamValue(TAG_ACTIONTARGET, strValue);
    }

    public final boolean isITEMOBJNull() {
        return this.IsParamNull(TAG_ITEMOBJ);
    }

    public final String getITEMOBJ() {
        return this.GetParamStringValue(TAG_ITEMOBJ, "");
    }

    public final void setITEMOBJ(String strValue) {
        this.SetParamValue(TAG_ITEMOBJ, strValue);
    }

    public final boolean isDEOPPRIVNull() {
        return this.IsParamNull(TAG_DEOPPRIV);
    }

    public final String getDEOPPRIV() {
        return this.GetParamStringValue(TAG_DEOPPRIV, "");
    }

    public final void setDEOPPRIV(String strValue) {
        this.SetParamValue(TAG_DEOPPRIV, strValue);
    }

    public final boolean isTOGGLEMODENull() {
        return this.IsParamNull(TAG_TOGGLEMODE);
    }

    public final boolean getTOGGLEMODE() {
        return this.GetParamIntValue(TAG_TOGGLEMODE, 0) == 1;
    }

    public final void setTOGGLEMODE(boolean bValue) {
        this.SetParamValue(TAG_TOGGLEMODE, bValue ? 1 : 0);
    }
}

