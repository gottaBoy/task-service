/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.ND.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class NDDisk
extends BaseDataEntity {
    public static final String NDFSOBJECTTYPE_DISK = "DISK";
    public static final String NDFSOBJECTTYPE_FOLDER = "FOLDER";
    public static final String NDFSOBJECTTYPE_FILE = "FILE";
    public static final String OWNERTYPE_PERSON = "PERSON";
    public static final String OWNERTYPE_DEPT = "DEPT";
    public static final String TAG_NDDISKID = "NDDISKID";
    public static final String TAG_NDDISKNAME = "NDDISKNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_NDFSOBJECTTYPE = "NDFSOBJECTTYPE";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ROOTNDFSOBJECTID = "ROOTNDFSOBJECTID";
    public static final String TAG_ROOTNDFSOBJECTNAME = "ROOTNDFSOBJECTNAME";
    public static final String TAG_PNDFSOBJECTID = "PNDFSOBJECTID";
    public static final String TAG_PNDFSOBJECTNAME = "PNDFSOBJECTNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_FILESIZE = "FILESIZE";
    public static final String TAG_DISKSIZE = "DISKSIZE";
    public static final String TAG_REMOVEFLAG = "REMOVEFLAG";
    public static final String TAG_USEDSIZE = "USEDSIZE";
    public static final String TAG_SYSTEMFLAG = "SYSTEMFLAG";
    public static final String TAG_OWNERTYPE = "OWNERTYPE";
    public static final String TAG_FSOTAG = "FSOTAG";
    public static final String TAG_OWNERID = "OWNERID";
    public static final String TAG_FSOTAG2 = "FSOTAG2";
    public static final String TAG_OWNERNAME = "OWNERNAME";

    public final boolean isNDDISKIDNull() {
        return this.IsParamNull(TAG_NDDISKID);
    }

    public final String getNDDISKID() {
        return this.GetParamStringValue(TAG_NDDISKID, "");
    }

    public final void setNDDISKID(String strValue) {
        this.SetParamValue(TAG_NDDISKID, strValue);
    }

    public final boolean isNDDISKNAMENull() {
        return this.IsParamNull(TAG_NDDISKNAME);
    }

    public final String getNDDISKNAME() {
        return this.GetParamStringValue(TAG_NDDISKNAME, "");
    }

    public final void setNDDISKNAME(String strValue) {
        this.SetParamValue(TAG_NDDISKNAME, strValue);
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

    public final String getFILESIZE() {
        return this.GetParamStringValue(TAG_FILESIZE, "");
    }

    public final void setFILESIZE(String strValue) {
        this.SetParamValue(TAG_FILESIZE, strValue);
    }

    public final boolean isDISKSIZENull() {
        return this.IsParamNull(TAG_DISKSIZE);
    }

    public final String getDISKSIZE() {
        return this.GetParamStringValue(TAG_DISKSIZE, "");
    }

    public final void setDISKSIZE(String strValue) {
        this.SetParamValue(TAG_DISKSIZE, strValue);
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

    public final boolean isUSEDSIZENull() {
        return this.IsParamNull(TAG_USEDSIZE);
    }

    public final String getUSEDSIZE() {
        return this.GetParamStringValue(TAG_USEDSIZE, "");
    }

    public final void setUSEDSIZE(String strValue) {
        this.SetParamValue(TAG_USEDSIZE, strValue);
    }

    public final boolean isSYSTEMFLAGNull() {
        return this.IsParamNull(TAG_SYSTEMFLAG);
    }

    public final boolean getSYSTEMFLAG() {
        return this.GetParamIntValue(TAG_SYSTEMFLAG, 0) == 1;
    }

    public final void setSYSTEMFLAG(boolean bValue) {
        this.SetParamValue(TAG_SYSTEMFLAG, bValue ? 1 : 0);
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

    public final boolean isFSOTAGNull() {
        return this.IsParamNull(TAG_FSOTAG);
    }

    public final String getFSOTAG() {
        return this.GetParamStringValue(TAG_FSOTAG, "");
    }

    public final void setFSOTAG(String strValue) {
        this.SetParamValue(TAG_FSOTAG, strValue);
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

    public final boolean isFSOTAG2Null() {
        return this.IsParamNull(TAG_FSOTAG2);
    }

    public final String getFSOTAG2() {
        return this.GetParamStringValue(TAG_FSOTAG2, "");
    }

    public final void setFSOTAG2(String strValue) {
        this.SetParamValue(TAG_FSOTAG2, strValue);
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
}

