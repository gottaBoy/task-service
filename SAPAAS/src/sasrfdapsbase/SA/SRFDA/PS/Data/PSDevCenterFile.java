/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevCenterFile
extends BaseDataEntity {
    public static final int FILETYPE_10 = 10;
    public static final int FILETYPE_20 = 20;
    public static final int FILETYPE_30 = 30;
    public static final String BIZTAG_DEVSLNSYS_WORKSHOP = "DEVSLNSYS_WORKSHOP";
    public static final String TAG_PSDEVCENTERFILEID = "PSDEVCENTERFILEID";
    public static final String TAG_PSDEVCENTERFILENAME = "PSDEVCENTERFILENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_FILETYPE = "FILETYPE";
    public static final String TAG_ROOTPSDEVCENTERFILEID = "ROOTPSDEVCENTERFILEID";
    public static final String TAG_ROOTPSDEVCENTERFILENAME = "ROOTPSDEVCENTERFILENAME";
    public static final String TAG_PPSDEVCENTERFILEID = "PPSDEVCENTERFILEID";
    public static final String TAG_PPSDEVCENTERFILENAME = "PPSDEVCENTERFILENAME";
    public static final String TAG_PSNDFILEID = "PSNDFILEID";
    public static final String TAG_PSNDFILENAME = "PSNDFILENAME";
    public static final String TAG_FILEOBJSIZE = "FILEOBJSIZE";
    public static final String TAG_TOTALFILESIZE = "TOTALFILESIZE";
    public static final String TAG_MAXFILESIZE = "MAXFILESIZE";
    public static final String TAG_OWNERTYPE = "OWNERTYPE";
    public static final String TAG_OWNERTYPENAME = "OWNERTYPENAME";
    public static final String TAG_OWNERID = "OWNERID";
    public static final String TAG_OWNERNAME = "OWNERNAME";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String TAG_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String TAG_BIZTAG = "BIZTAG";
    public static final String TAG_FILETAG = "FILETAG";
    public static final String TAG_FILETAG2 = "FILETAG2";
    public static final String TAG_FILEPATH = "FILEPATH";
    public static final String TAG_LASTCALCTIME = "LASTCALCTIME";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSDEVCENTERFILEIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERFILEID);
    }

    public final String getPSDEVCENTERFILEID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERFILEID, "");
    }

    public final void setPSDEVCENTERFILEID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERFILEID, strValue);
    }

    public final boolean isPSDEVCENTERFILENAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERFILENAME);
    }

    public final String getPSDEVCENTERFILENAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERFILENAME, "");
    }

    public final void setPSDEVCENTERFILENAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERFILENAME, strValue);
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

    public final boolean isFILETYPENull() {
        return this.IsParamNull(TAG_FILETYPE);
    }

    public final int getFILETYPE() {
        return this.GetParamIntValue(TAG_FILETYPE, 0);
    }

    public final void setFILETYPE(int nValue) {
        this.SetParamValue(TAG_FILETYPE, nValue);
    }

    public final boolean isROOTPSDEVCENTERFILEIDNull() {
        return this.IsParamNull(TAG_ROOTPSDEVCENTERFILEID);
    }

    public final String getROOTPSDEVCENTERFILEID() {
        return this.GetParamStringValue(TAG_ROOTPSDEVCENTERFILEID, "");
    }

    public final void setROOTPSDEVCENTERFILEID(String strValue) {
        this.SetParamValue(TAG_ROOTPSDEVCENTERFILEID, strValue);
    }

    public final boolean isROOTPSDEVCENTERFILENAMENull() {
        return this.IsParamNull(TAG_ROOTPSDEVCENTERFILENAME);
    }

    public final String getROOTPSDEVCENTERFILENAME() {
        return this.GetParamStringValue(TAG_ROOTPSDEVCENTERFILENAME, "");
    }

    public final void setROOTPSDEVCENTERFILENAME(String strValue) {
        this.SetParamValue(TAG_ROOTPSDEVCENTERFILENAME, strValue);
    }

    public final boolean isPPSDEVCENTERFILEIDNull() {
        return this.IsParamNull(TAG_PPSDEVCENTERFILEID);
    }

    public final String getPPSDEVCENTERFILEID() {
        return this.GetParamStringValue(TAG_PPSDEVCENTERFILEID, "");
    }

    public final void setPPSDEVCENTERFILEID(String strValue) {
        this.SetParamValue(TAG_PPSDEVCENTERFILEID, strValue);
    }

    public final boolean isPPSDEVCENTERFILENAMENull() {
        return this.IsParamNull(TAG_PPSDEVCENTERFILENAME);
    }

    public final String getPPSDEVCENTERFILENAME() {
        return this.GetParamStringValue(TAG_PPSDEVCENTERFILENAME, "");
    }

    public final void setPPSDEVCENTERFILENAME(String strValue) {
        this.SetParamValue(TAG_PPSDEVCENTERFILENAME, strValue);
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

    public final boolean isPSNDFILENAMENull() {
        return this.IsParamNull(TAG_PSNDFILENAME);
    }

    public final String getPSNDFILENAME() {
        return this.GetParamStringValue(TAG_PSNDFILENAME, "");
    }

    public final void setPSNDFILENAME(String strValue) {
        this.SetParamValue(TAG_PSNDFILENAME, strValue);
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

    public final boolean isTOTALFILESIZENull() {
        return this.IsParamNull(TAG_TOTALFILESIZE);
    }

    public final String getTOTALFILESIZE() {
        return this.GetParamStringValue(TAG_TOTALFILESIZE, "");
    }

    public final void setTOTALFILESIZE(String strValue) {
        this.SetParamValue(TAG_TOTALFILESIZE, strValue);
    }

    public final boolean isMAXFILESIZENull() {
        return this.IsParamNull(TAG_MAXFILESIZE);
    }

    public final String getMAXFILESIZE() {
        return this.GetParamStringValue(TAG_MAXFILESIZE, "");
    }

    public final void setMAXFILESIZE(String strValue) {
        this.SetParamValue(TAG_MAXFILESIZE, strValue);
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

    public final boolean isOWNERTYPENAMENull() {
        return this.IsParamNull(TAG_OWNERTYPENAME);
    }

    public final String getOWNERTYPENAME() {
        return this.GetParamStringValue(TAG_OWNERTYPENAME, "");
    }

    public final void setOWNERTYPENAME(String strValue) {
        this.SetParamValue(TAG_OWNERTYPENAME, strValue);
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

    public final boolean isPSDEVCENTERIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERID);
    }

    public final String getPSDEVCENTERID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERID, "");
    }

    public final void setPSDEVCENTERID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERID, strValue);
    }

    public final boolean isPSDEVCENTERNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERNAME);
    }

    public final String getPSDEVCENTERNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERNAME, "");
    }

    public final void setPSDEVCENTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERNAME, strValue);
    }

    public final boolean isPSTASKSERVERIDNull() {
        return this.IsParamNull(TAG_PSTASKSERVERID);
    }

    public final String getPSTASKSERVERID() {
        return this.GetParamStringValue(TAG_PSTASKSERVERID, "");
    }

    public final void setPSTASKSERVERID(String strValue) {
        this.SetParamValue(TAG_PSTASKSERVERID, strValue);
    }

    public final boolean isPSTASKSERVERNAMENull() {
        return this.IsParamNull(TAG_PSTASKSERVERNAME);
    }

    public final String getPSTASKSERVERNAME() {
        return this.GetParamStringValue(TAG_PSTASKSERVERNAME, "");
    }

    public final void setPSTASKSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSTASKSERVERNAME, strValue);
    }

    public final boolean isBIZTAGNull() {
        return this.IsParamNull(TAG_BIZTAG);
    }

    public final String getBIZTAG() {
        return this.GetParamStringValue(TAG_BIZTAG, "");
    }

    public final void setBIZTAG(String strValue) {
        this.SetParamValue(TAG_BIZTAG, strValue);
    }

    public final boolean isFILETAGNull() {
        return this.IsParamNull(TAG_FILETAG);
    }

    public final String getFILETAG() {
        return this.GetParamStringValue(TAG_FILETAG, "");
    }

    public final void setFILETAG(String strValue) {
        this.SetParamValue(TAG_FILETAG, strValue);
    }

    public final boolean isFILETAG2Null() {
        return this.IsParamNull(TAG_FILETAG2);
    }

    public final String getFILETAG2() {
        return this.GetParamStringValue(TAG_FILETAG2, "");
    }

    public final void setFILETAG2(String strValue) {
        this.SetParamValue(TAG_FILETAG2, strValue);
    }

    public final boolean isFILEPATHNull() {
        return this.IsParamNull(TAG_FILEPATH);
    }

    public final String getFILEPATH() {
        return this.GetParamStringValue(TAG_FILEPATH, "");
    }

    public final void setFILEPATH(String strValue) {
        this.SetParamValue(TAG_FILEPATH, strValue);
    }

    public final boolean isLASTCALCTIMENull() {
        return this.IsParamNull(TAG_LASTCALCTIME);
    }

    public final Date getLASTCALCTIME() {
        return this.GetParamDateValue(TAG_LASTCALCTIME, null);
    }

    public final void setLASTCALCTIME(Date dtValue) {
        this.SetParamValue(TAG_LASTCALCTIME, dtValue);
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

