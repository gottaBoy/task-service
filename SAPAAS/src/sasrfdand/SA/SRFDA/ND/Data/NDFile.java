/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.ND.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class NDFile
extends BaseDataEntity {
    public static final String NDFSOBJECTTYPE_DISK = "DISK";
    public static final String NDFSOBJECTTYPE_FOLDER = "FOLDER";
    public static final String NDFSOBJECTTYPE_FILE = "FILE";
    public static final String TAG_NDFILEID = "NDFILEID";
    public static final String TAG_NDFILENAME = "NDFILENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_NDFSOBJECTTYPE = "NDFSOBJECTTYPE";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_FILEID = "FILEID";
    public static final String TAG_ROOTNDFSOBJECTID = "ROOTNDFSOBJECTID";
    public static final String TAG_FILENAME = "FILENAME";
    public static final String TAG_FILEVERSION = "FILEVERSION";
    public static final String TAG_ROOTNDFSOBJECTNAME = "ROOTNDFSOBJECTNAME";
    public static final String TAG_FILESIZE = "FILESIZE";
    public static final String TAG_PNDFSOBJECTID = "PNDFSOBJECTID";
    public static final String TAG_PNDFSOBJECTNAME = "PNDFSOBJECTNAME";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isNDFILEIDNull() {
        return this.IsParamNull(TAG_NDFILEID);
    }

    public final String getNDFILEID() {
        return this.GetParamStringValue(TAG_NDFILEID, "");
    }

    public final void setNDFILEID(String strValue) {
        this.SetParamValue(TAG_NDFILEID, strValue);
    }

    public final boolean isNDFILENAMENull() {
        return this.IsParamNull(TAG_NDFILENAME);
    }

    public final String getNDFILENAME() {
        return this.GetParamStringValue(TAG_NDFILENAME, "");
    }

    public final void setNDFILENAME(String strValue) {
        this.SetParamValue(TAG_NDFILENAME, strValue);
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

    public final boolean isNDFSOBJECTTYPENull() {
        return this.IsParamNull(TAG_NDFSOBJECTTYPE);
    }

    public final String getNDFSOBJECTTYPE() {
        return this.GetParamStringValue(TAG_NDFSOBJECTTYPE, "");
    }

    public final void setNDFSOBJECTTYPE(String strValue) {
        this.SetParamValue(TAG_NDFSOBJECTTYPE, strValue);
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

    public final boolean isROOTNDFSOBJECTIDNull() {
        return this.IsParamNull(TAG_ROOTNDFSOBJECTID);
    }

    public final String getROOTNDFSOBJECTID() {
        return this.GetParamStringValue(TAG_ROOTNDFSOBJECTID, "");
    }

    public final void setROOTNDFSOBJECTID(String strValue) {
        this.SetParamValue(TAG_ROOTNDFSOBJECTID, strValue);
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

    public final boolean isFILEVERSIONNull() {
        return this.IsParamNull(TAG_FILEVERSION);
    }

    public final int getFILEVERSION() {
        return this.GetParamIntValue(TAG_FILEVERSION, 0);
    }

    public final void setFILEVERSION(int nValue) {
        this.SetParamValue(TAG_FILEVERSION, nValue);
    }

    public final boolean isROOTNDFSOBJECTNAMENull() {
        return this.IsParamNull(TAG_ROOTNDFSOBJECTNAME);
    }

    public final String getROOTNDFSOBJECTNAME() {
        return this.GetParamStringValue(TAG_ROOTNDFSOBJECTNAME, "");
    }

    public final void setROOTNDFSOBJECTNAME(String strValue) {
        this.SetParamValue(TAG_ROOTNDFSOBJECTNAME, strValue);
    }

    public final boolean isPNDFSOBJECTIDNull() {
        return this.IsParamNull(TAG_PNDFSOBJECTID);
    }

    public final String getPNDFSOBJECTID() {
        return this.GetParamStringValue(TAG_PNDFSOBJECTID, "");
    }

    public final void setPNDFSOBJECTID(String strValue) {
        this.SetParamValue(TAG_PNDFSOBJECTID, strValue);
    }

    public final boolean isPNDFSOBJECTNAMENull() {
        return this.IsParamNull(TAG_PNDFSOBJECTNAME);
    }

    public final String getPNDFSOBJECTNAME() {
        return this.GetParamStringValue(TAG_PNDFSOBJECTNAME, "");
    }

    public final void setPNDFSOBJECTNAME(String strValue) {
        this.SetParamValue(TAG_PNDFSOBJECTNAME, strValue);
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

    public final boolean isFILESIZENull() {
        return this.IsParamNull(TAG_FILESIZE);
    }

    public final long getFILESIZE() {
        return this.GetParamLongValue(TAG_FILESIZE, 0L);
    }

    public final void setFILESIZE(long nValue) {
        this.SetParamValue(TAG_FILESIZE, nValue);
    }
}

