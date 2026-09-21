/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class FileOwner
extends BaseDataEntity {
    public static final String TAG_FILEOWNERID = "FILEOWNERID";
    public static final String TAG_FILEOWNERNAME = "FILEOWNERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_FILEID = "FILEID";
    public static final String TAG_FILENAME = "FILENAME";
    public static final String TAG_OWNERTYPE = "OWNERTYPE";
    public static final String TAG_OWNERID = "OWNERID";

    public final boolean isFILEOWNERIDNull() {
        return this.IsParamNull(TAG_FILEOWNERID);
    }

    public final String getFILEOWNERID() {
        return this.GetParamStringValue(TAG_FILEOWNERID, "");
    }

    public final void setFILEOWNERID(String strValue) {
        this.SetParamValue(TAG_FILEOWNERID, strValue);
    }

    public final boolean isFILEOWNERNAMENull() {
        return this.IsParamNull(TAG_FILEOWNERNAME);
    }

    public final String getFILEOWNERNAME() {
        return this.GetParamStringValue(TAG_FILEOWNERNAME, "");
    }

    public final void setFILEOWNERNAME(String strValue) {
        this.SetParamValue(TAG_FILEOWNERNAME, strValue);
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

    public final boolean isFILEIDNull() {
        return this.IsParamNull(TAG_FILEID);
    }

    public final String getFILEID() {
        return this.GetParamStringValue(TAG_FILEID, "");
    }

    public final void setFILEID(String strValue) {
        this.SetParamValue(TAG_FILEID, strValue);
    }

    public final boolean isFILENAMENull() {
        return this.IsParamNull(TAG_FILENAME);
    }

    public final String getFILENAME() {
        return this.GetParamStringValue(TAG_FILENAME, "");
    }

    public final void setFILENAME(String strValue) {
        this.SetParamValue(TAG_FILENAME, strValue);
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

    public final boolean isOWNERIDNull() {
        return this.IsParamNull(TAG_OWNERID);
    }

    public final String getOWNERID() {
        return this.GetParamStringValue(TAG_OWNERID, "");
    }

    public final void setOWNERID(String strValue) {
        this.SetParamValue(TAG_OWNERID, strValue);
    }
}

