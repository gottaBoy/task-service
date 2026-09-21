/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysFile
extends BaseDataEntity {
    public static final String TAG_PSSYSFILEID = "PSSYSFILEID";
    public static final String TAG_PSSYSFILENAME = "PSSYSFILENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_OWNERID = "OWNERID";
    public static final String TAG_OWNERNAME = "OWNERNAME";
    public static final String TAG_FILEOBJSIZE = "FILEOBJSIZE";
    public static final String TAG_OWNERTYPE = "OWNERTYPE";
    public static final String TAG_PSNDFILEID = "PSNDFILEID";

    public final boolean isPSSYSFILEIDNull() {
        return this.IsParamNull(TAG_PSSYSFILEID);
    }

    public final String getPSSYSFILEID() {
        return this.GetParamStringValue(TAG_PSSYSFILEID, "");
    }

    public final void setPSSYSFILEID(String strValue) {
        this.SetParamValue(TAG_PSSYSFILEID, strValue);
    }

    public final boolean isPSSYSFILENAMENull() {
        return this.IsParamNull(TAG_PSSYSFILENAME);
    }

    public final String getPSSYSFILENAME() {
        return this.GetParamStringValue(TAG_PSSYSFILENAME, "");
    }

    public final void setPSSYSFILENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSFILENAME, strValue);
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

    public final boolean isOWNERIDNull() {
        return this.IsParamNull(TAG_OWNERID);
    }

    public final String getOWNERID() {
        return this.GetParamStringValue(TAG_OWNERID, "");
    }

    public final void setOWNERID(String strValue) {
        this.SetParamValue(TAG_OWNERID, strValue);
    }

    public final boolean isOWNERNAMENull() {
        return this.IsParamNull(TAG_OWNERNAME);
    }

    public final String getOWNERNAME() {
        return this.GetParamStringValue(TAG_OWNERNAME, "");
    }

    public final void setOWNERNAME(String strValue) {
        this.SetParamValue(TAG_OWNERNAME, strValue);
    }

    public final boolean isFILEOBJSIZENull() {
        return this.IsParamNull(TAG_FILEOBJSIZE);
    }

    public final String getFILEOBJSIZE() {
        return this.GetParamStringValue(TAG_FILEOBJSIZE, "");
    }

    public final void setFILEOBJSIZE(String strValue) {
        this.SetParamValue(TAG_FILEOBJSIZE, strValue);
    }

    public final boolean isOWNERTYPENull() {
        return this.IsParamNull(TAG_OWNERTYPE);
    }

    public final String getOWNERTYPE() {
        return this.GetParamStringValue(TAG_OWNERTYPE, "");
    }

    public final void setOWNERTYPE(String strValue) {
        this.SetParamValue(TAG_OWNERTYPE, strValue);
    }

    public final boolean isPSNDFILEIDNull() {
        return this.IsParamNull(TAG_PSNDFILEID);
    }

    public final String getPSNDFILEID() {
        return this.GetParamStringValue(TAG_PSNDFILEID, "");
    }

    public final void setPSNDFILEID(String strValue) {
        this.SetParamValue(TAG_PSNDFILEID, strValue);
    }
}

