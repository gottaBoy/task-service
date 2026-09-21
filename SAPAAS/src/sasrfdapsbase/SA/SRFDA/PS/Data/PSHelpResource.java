/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSHelpResource
extends BaseDataEntity {
    public static final String RESOURCETYPE_IMAGE = "IMAGE";
    public static final String RESOURCETYPE_LINK = "LINK";
    public static final String TAG_PSHELPRESOURCEID = "PSHELPRESOURCEID";
    public static final String TAG_PSHELPRESOURCENAME = "PSHELPRESOURCENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_RESOURCETYPE = "RESOURCETYPE";
    public static final String TAG_RESOURCESN = "RESOURCESN";
    public static final String TAG_KEYWORDS = "KEYWORDS";
    public static final String TAG_RESPARAM = "RESPARAM";
    public static final String TAG_RESPARAM2 = "RESPARAM2";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";

    public final boolean isPSHELPRESOURCEIDNull() {
        return this.IsParamNull(TAG_PSHELPRESOURCEID);
    }

    public final String getPSHELPRESOURCEID() {
        return this.GetParamStringValue(TAG_PSHELPRESOURCEID, "");
    }

    public final void setPSHELPRESOURCEID(String strValue) {
        this.SetParamValue(TAG_PSHELPRESOURCEID, strValue);
    }

    public final boolean isPSHELPRESOURCENAMENull() {
        return this.IsParamNull(TAG_PSHELPRESOURCENAME);
    }

    public final String getPSHELPRESOURCENAME() {
        return this.GetParamStringValue(TAG_PSHELPRESOURCENAME, "");
    }

    public final void setPSHELPRESOURCENAME(String strValue) {
        this.SetParamValue(TAG_PSHELPRESOURCENAME, strValue);
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

    public final boolean isCONTENTNull() {
        return this.IsParamNull(TAG_CONTENT);
    }

    public final String getCONTENT() {
        return this.GetParamStringValue(TAG_CONTENT, "");
    }

    public final void setCONTENT(String strValue) {
        this.SetParamValue(TAG_CONTENT, strValue);
    }

    public final boolean isRESOURCETYPENull() {
        return this.IsParamNull(TAG_RESOURCETYPE);
    }

    public final String getRESOURCETYPE() {
        return this.GetParamStringValue(TAG_RESOURCETYPE, "");
    }

    public final void setRESOURCETYPE(String strValue) {
        this.SetParamValue(TAG_RESOURCETYPE, strValue);
    }

    public final boolean isRESOURCESNNull() {
        return this.IsParamNull(TAG_RESOURCESN);
    }

    public final String getRESOURCESN() {
        return this.GetParamStringValue(TAG_RESOURCESN, "");
    }

    public final void setRESOURCESN(String strValue) {
        this.SetParamValue(TAG_RESOURCESN, strValue);
    }

    public final boolean isKEYWORDSNull() {
        return this.IsParamNull(TAG_KEYWORDS);
    }

    public final String getKEYWORDS() {
        return this.GetParamStringValue(TAG_KEYWORDS, "");
    }

    public final void setKEYWORDS(String strValue) {
        this.SetParamValue(TAG_KEYWORDS, strValue);
    }

    public final boolean isRESPARAMNull() {
        return this.IsParamNull(TAG_RESPARAM);
    }

    public final String getRESPARAM() {
        return this.GetParamStringValue(TAG_RESPARAM, "");
    }

    public final void setRESPARAM(String strValue) {
        this.SetParamValue(TAG_RESPARAM, strValue);
    }

    public final boolean isRESPARAM2Null() {
        return this.IsParamNull(TAG_RESPARAM2);
    }

    public final String getRESPARAM2() {
        return this.GetParamStringValue(TAG_RESPARAM2, "");
    }

    public final void setRESPARAM2(String strValue) {
        this.SetParamValue(TAG_RESPARAM2, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
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
}

