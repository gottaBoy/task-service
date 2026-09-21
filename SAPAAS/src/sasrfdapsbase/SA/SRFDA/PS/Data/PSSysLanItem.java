/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysLanItem
extends BaseDataEntity {
    public static final String TAG_PSSYSLANITEMID = "PSSYSLANITEMID";
    public static final String TAG_PSSYSLANITEMNAME = "PSSYSLANITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSLANGUAGEID = "PSLANGUAGEID";
    public static final String TAG_PSLANGUAGENAME = "PSLANGUAGENAME";
    public static final String TAG_PSSYSLANRESID = "PSSYSLANRESID";
    public static final String TAG_PSSYSLANRESNAME = "PSSYSLANRESNAME";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_CONTENT2 = "CONTENT2";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSSYSLANITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSLANITEMID);
    }

    public final String getPSSYSLANITEMID() {
        return this.GetParamStringValue(TAG_PSSYSLANITEMID, "");
    }

    public final void setPSSYSLANITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSLANITEMID, strValue);
    }

    public final boolean isPSSYSLANITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSLANITEMNAME);
    }

    public final String getPSSYSLANITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSLANITEMNAME, "");
    }

    public final void setPSSYSLANITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSLANITEMNAME, strValue);
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

    public final boolean isPSSYSLANRESIDNull() {
        return this.IsParamNull(TAG_PSSYSLANRESID);
    }

    public final String getPSSYSLANRESID() {
        return this.GetParamStringValue(TAG_PSSYSLANRESID, "");
    }

    public final void setPSSYSLANRESID(String strValue) {
        this.SetParamValue(TAG_PSSYSLANRESID, strValue);
    }

    public final boolean isPSSYSLANRESNAMENull() {
        return this.IsParamNull(TAG_PSSYSLANRESNAME);
    }

    public final String getPSSYSLANRESNAME() {
        return this.GetParamStringValue(TAG_PSSYSLANRESNAME, "");
    }

    public final void setPSSYSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSLANRESNAME, strValue);
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
}

