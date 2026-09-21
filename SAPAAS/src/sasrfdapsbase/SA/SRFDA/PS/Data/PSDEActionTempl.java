/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEActionTempl
extends BaseDataEntity {
    public static final String PDTTEMPL_CREATE = "CREATE";
    public static final String PDTTEMPL_UPDATE = "UPDATE";
    public static final String PDTTEMPL_REMOVE = "REMOVE";
    public static final String TAG_PSDEACTIONTEMPLID = "PSDEACTIONTEMPLID";
    public static final String TAG_PSDEACTIONTEMPLNAME = "PSDEACTIONTEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDCCODESNIPPETID = "PSDCCODESNIPPETID";
    public static final String TAG_PSDCCODESNIPPETNAME = "PSDCCODESNIPPETNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PDTTEMPL = "PDTTEMPL";
    public static final String TAG_TEMPLCODE = "TEMPLCODE";
    public static final String TAG_TEMPLCODE2 = "TEMPLCODE2";
    public static final String TAG_TEMPLCODEEX = "TEMPLCODEEX";
    public static final String TAG_TEMPLCODE2EX = "TEMPLCODE2EX";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_LOCKFLAG = "LOCKFLAG";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERCAT = "USERCAT";

    public final boolean isPSDEACTIONTEMPLIDNull() {
        return this.IsParamNull(TAG_PSDEACTIONTEMPLID);
    }

    public final String getPSDEACTIONTEMPLID() {
        return this.GetParamStringValue(TAG_PSDEACTIONTEMPLID, "");
    }

    public final void setPSDEACTIONTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONTEMPLID, strValue);
    }

    public final boolean isPSDEACTIONTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSDEACTIONTEMPLNAME);
    }

    public final String getPSDEACTIONTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSDEACTIONTEMPLNAME, "");
    }

    public final void setPSDEACTIONTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONTEMPLNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPSDCCODESNIPPETIDNull() {
        return this.IsParamNull(TAG_PSDCCODESNIPPETID);
    }

    public final String getPSDCCODESNIPPETID() {
        return this.GetParamStringValue(TAG_PSDCCODESNIPPETID, "");
    }

    public final void setPSDCCODESNIPPETID(String strValue) {
        this.SetParamValue(TAG_PSDCCODESNIPPETID, strValue);
    }

    public final boolean isPSDCCODESNIPPETNAMENull() {
        return this.IsParamNull(TAG_PSDCCODESNIPPETNAME);
    }

    public final String getPSDCCODESNIPPETNAME() {
        return this.GetParamStringValue(TAG_PSDCCODESNIPPETNAME, "");
    }

    public final void setPSDCCODESNIPPETNAME(String strValue) {
        this.SetParamValue(TAG_PSDCCODESNIPPETNAME, strValue);
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

    public final boolean isPDTTEMPLNull() {
        return this.IsParamNull(TAG_PDTTEMPL);
    }

    public final String getPDTTEMPL() {
        return this.GetParamStringValue(TAG_PDTTEMPL, "");
    }

    public final void setPDTTEMPL(String strValue) {
        this.SetParamValue(TAG_PDTTEMPL, strValue);
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

    public final boolean isTEMPLCODEEXNull() {
        return this.IsParamNull(TAG_TEMPLCODEEX);
    }

    public final String getTEMPLCODEEX() {
        return this.GetParamStringValue(TAG_TEMPLCODEEX, "");
    }

    public final void setTEMPLCODEEX(String strValue) {
        this.SetParamValue(TAG_TEMPLCODEEX, strValue);
    }

    public final boolean isTEMPLCODE2EXNull() {
        return this.IsParamNull(TAG_TEMPLCODE2EX);
    }

    public final String getTEMPLCODE2EX() {
        return this.GetParamStringValue(TAG_TEMPLCODE2EX, "");
    }

    public final void setTEMPLCODE2EX(String strValue) {
        this.SetParamValue(TAG_TEMPLCODE2EX, strValue);
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

    public final boolean isLOCKFLAGNull() {
        return this.IsParamNull(TAG_LOCKFLAG);
    }

    public final boolean getLOCKFLAG() {
        return this.GetParamIntValue(TAG_LOCKFLAG, 0) == 1;
    }

    public final void setLOCKFLAG(boolean bValue) {
        this.SetParamValue(TAG_LOCKFLAG, bValue ? 1 : 0);
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

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
    }
}

