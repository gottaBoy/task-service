/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSLanguageItemV3
extends BaseDataEntity {
    public static final String TAG_PSLANGUAGEITEMID = "PSLANGUAGEITEMID";
    public static final String TAG_PSLANGUAGEITEMNAME = "PSLANGUAGEITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSLANGUAGERESID = "PSLANGUAGERESID";
    public static final String TAG_PSLANGUAGERESNAME = "PSLANGUAGERESNAME";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_CONTENT2 = "CONTENT2";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSLANGUAGEID = "PSLANGUAGEID";
    public static final String TAG_PSLANGUAGENAME = "PSLANGUAGENAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";

    public final boolean isPSLANGUAGEITEMIDNull() {
        return this.IsParamNull(TAG_PSLANGUAGEITEMID);
    }

    public final String getPSLANGUAGEITEMID() {
        return this.GetParamStringValue(TAG_PSLANGUAGEITEMID, "");
    }

    public final void setPSLANGUAGEITEMID(String strValue) {
        this.SetParamValue(TAG_PSLANGUAGEITEMID, strValue);
    }

    public final boolean isPSLANGUAGEITEMNAMENull() {
        return this.IsParamNull(TAG_PSLANGUAGEITEMNAME);
    }

    public final String getPSLANGUAGEITEMNAME() {
        return this.GetParamStringValue(TAG_PSLANGUAGEITEMNAME, "");
    }

    public final void setPSLANGUAGEITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSLANGUAGEITEMNAME, strValue);
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

    public final boolean isPSLANGUAGERESIDNull() {
        return this.IsParamNull(TAG_PSLANGUAGERESID);
    }

    public final String getPSLANGUAGERESID() {
        return this.GetParamStringValue(TAG_PSLANGUAGERESID, "");
    }

    public final void setPSLANGUAGERESID(String strValue) {
        this.SetParamValue(TAG_PSLANGUAGERESID, strValue);
    }

    public final boolean isPSLANGUAGERESNAMENull() {
        return this.IsParamNull(TAG_PSLANGUAGERESNAME);
    }

    public final String getPSLANGUAGERESNAME() {
        return this.GetParamStringValue(TAG_PSLANGUAGERESNAME, "");
    }

    public final void setPSLANGUAGERESNAME(String strValue) {
        this.SetParamValue(TAG_PSLANGUAGERESNAME, strValue);
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

    public final boolean isCONTENT2Null() {
        return this.IsParamNull(TAG_CONTENT2);
    }

    public final String getCONTENT2() {
        return this.GetParamStringValue(TAG_CONTENT2, "");
    }

    public final void setCONTENT2(String strValue) {
        this.SetParamValue(TAG_CONTENT2, strValue);
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

    public final boolean isPSLANGUAGEIDNull() {
        return this.IsParamNull(TAG_PSLANGUAGEID);
    }

    public final String getPSLANGUAGEID() {
        return this.GetParamStringValue(TAG_PSLANGUAGEID, "");
    }

    public final void setPSLANGUAGEID(String strValue) {
        this.SetParamValue(TAG_PSLANGUAGEID, strValue);
    }

    public final boolean isPSLANGUAGENAMENull() {
        return this.IsParamNull(TAG_PSLANGUAGENAME);
    }

    public final String getPSLANGUAGENAME() {
        return this.GetParamStringValue(TAG_PSLANGUAGENAME, "");
    }

    public final void setPSLANGUAGENAME(String strValue) {
        this.SetParamValue(TAG_PSLANGUAGENAME, strValue);
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
}

