/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.ND.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class NDShare
extends BaseDataEntity {
    public static final String TAG_NDSHAREID = "NDSHAREID";
    public static final String TAG_NDSHARENAME = "NDSHARENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_NDFSOBJECTTYPE = "NDFSOBJECTTYPE";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ROOTNDFSOBJECTID = "ROOTNDFSOBJECTID";
    public static final String TAG_ROOTNDFSOBJECTNAME = "ROOTNDFSOBJECTNAME";
    public static final String TAG_NDFSOBJECTID = "NDFSOBJECTID";
    public static final String TAG_PNDFSOBJECTID = "PNDFSOBJECTID";
    public static final String TAG_NDFSOBJECTNAME = "NDFSOBJECTNAME";
    public static final String TAG_PNDFSOBJECTNAME = "PNDFSOBJECTNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_FILESIZE = "FILESIZE";
    public static final String TAG_REMOVEFLAG = "REMOVEFLAG";
    public static final String TAG_SHARENDFSOTYPE = "SHARENDFSOTYPE";
    public static final String TAG_SHARENDFSOREMOVEFLAG = "SHARENDFSOREMOVEFLAG";
    public static final String TAG_FSOTAG2 = "FSOTAG2";
    public static final String TAG_FULLPATH = "FULLPATH";

    public final boolean isNDSHAREIDNull() {
        return this.IsParamNull(TAG_NDSHAREID);
    }

    public final String getNDSHAREID() {
        return this.GetParamStringValue(TAG_NDSHAREID, "");
    }

    public final void setNDSHAREID(String strValue) {
        this.SetParamValue(TAG_NDSHAREID, strValue);
    }

    public final boolean isNDSHARENAMENull() {
        return this.IsParamNull(TAG_NDSHARENAME);
    }

    public final String getNDSHARENAME() {
        return this.GetParamStringValue(TAG_NDSHARENAME, "");
    }

    public final void setNDSHARENAME(String strValue) {
        this.SetParamValue(TAG_NDSHARENAME, strValue);
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

    public final boolean isROOTNDFSOBJECTIDNull() {
        return this.IsParamNull(TAG_ROOTNDFSOBJECTID);
    }

    public final String getROOTNDFSOBJECTID() {
        return this.GetParamStringValue(TAG_ROOTNDFSOBJECTID, "");
    }

    public final void setROOTNDFSOBJECTID(String strValue) {
        this.SetParamValue(TAG_ROOTNDFSOBJECTID, strValue);
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

    public final boolean isNDFSOBJECTIDNull() {
        return this.IsParamNull(TAG_NDFSOBJECTID);
    }

    public final String getNDFSOBJECTID() {
        return this.GetParamStringValue(TAG_NDFSOBJECTID, "");
    }

    public final void setNDFSOBJECTID(String strValue) {
        this.SetParamValue(TAG_NDFSOBJECTID, strValue);
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

    public final boolean isNDFSOBJECTNAMENull() {
        return this.IsParamNull(TAG_NDFSOBJECTNAME);
    }

    public final String getNDFSOBJECTNAME() {
        return this.GetParamStringValue(TAG_NDFSOBJECTNAME, "");
    }

    public final void setNDFSOBJECTNAME(String strValue) {
        this.SetParamValue(TAG_NDFSOBJECTNAME, strValue);
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

    public final String getFILESIZE() {
        return this.GetParamStringValue(TAG_FILESIZE, "");
    }

    public final void setFILESIZE(String strValue) {
        this.SetParamValue(TAG_FILESIZE, strValue);
    }

    public final boolean isREMOVEFLAGNull() {
        return this.IsParamNull(TAG_REMOVEFLAG);
    }

    public final boolean getREMOVEFLAG() {
        return this.GetParamIntValue(TAG_REMOVEFLAG, 0) == 1;
    }

    public final void setREMOVEFLAG(boolean bValue) {
        this.SetParamValue(TAG_REMOVEFLAG, bValue ? 1 : 0);
    }

    public final boolean isSHARENDFSOTYPENull() {
        return this.IsParamNull(TAG_SHARENDFSOTYPE);
    }

    public final String getSHARENDFSOTYPE() {
        return this.GetParamStringValue(TAG_SHARENDFSOTYPE, "");
    }

    public final void setSHARENDFSOTYPE(String strValue) {
        this.SetParamValue(TAG_SHARENDFSOTYPE, strValue);
    }

    public final boolean isSHARENDFSOREMOVEFLAGNull() {
        return this.IsParamNull(TAG_SHARENDFSOREMOVEFLAG);
    }

    public final boolean getSHARENDFSOREMOVEFLAG() {
        return this.GetParamIntValue(TAG_SHARENDFSOREMOVEFLAG, 0) == 1;
    }

    public final void setSHARENDFSOREMOVEFLAG(boolean bValue) {
        this.SetParamValue(TAG_SHARENDFSOREMOVEFLAG, bValue ? 1 : 0);
    }

    public final boolean isFSOTAG2Null() {
        return this.IsParamNull(TAG_FSOTAG2);
    }

    public final String getFSOTAG2() {
        return this.GetParamStringValue(TAG_FSOTAG2, "");
    }

    public final void setFSOTAG2(String strValue) {
        this.SetParamValue(TAG_FSOTAG2, strValue);
    }

    public final boolean isFULLPATHNull() {
        return this.IsParamNull(TAG_FULLPATH);
    }

    public final String getFULLPATH() {
        return this.GetParamStringValue(TAG_FULLPATH, "");
    }

    public final void setFULLPATH(String strValue) {
        this.SetParamValue(TAG_FULLPATH, strValue);
    }
}

