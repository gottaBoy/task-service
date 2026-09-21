/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysImage
extends BaseDataEntity {
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSIMAGETEMPLID = "PSIMAGETEMPLID";
    public static final String TAG_PSIMAGETEMPLNAME = "PSIMAGETEMPLNAME";
    public static final String TAG_IMAGEPATH = "IMAGEPATH";
    public static final String TAG_CSSCLASS = "CSSCLASS";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_GLYPH = "GLYPH";
    public static final String TAG_CSSCLASSX = "CSSCLASSX";
    public static final String TAG_IMAGEPATHX = "IMAGEPATHX";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_LOCKFLAG = "LOCKFLAG";
    public static final String TAG_IMAGETYPE = "IMAGETYPE";
    public static final String TAG_IMAGESRC = "IMAGESRC";
    public static final String TAG_PSSYSFILEID = "PSSYSFILEID";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_RAWCONTENT = "RAWCONTENT";

    public final boolean isPSSYSIMAGEIDNull() {
        return this.IsParamNull(TAG_PSSYSIMAGEID);
    }

    public final String getPSSYSIMAGEID() {
        return this.GetParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.IsParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.GetParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGENAME, strValue);
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

    public final boolean isPSIMAGETEMPLIDNull() {
        return this.IsParamNull(TAG_PSIMAGETEMPLID);
    }

    public final String getPSIMAGETEMPLID() {
        return this.GetParamStringValue(TAG_PSIMAGETEMPLID, "");
    }

    public final void setPSIMAGETEMPLID(String strValue) {
        this.SetParamValue(TAG_PSIMAGETEMPLID, strValue);
    }

    public final boolean isPSIMAGETEMPLNAMENull() {
        return this.IsParamNull(TAG_PSIMAGETEMPLNAME);
    }

    public final String getPSIMAGETEMPLNAME() {
        return this.GetParamStringValue(TAG_PSIMAGETEMPLNAME, "");
    }

    public final void setPSIMAGETEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSIMAGETEMPLNAME, strValue);
    }

    public final boolean isIMAGEPATHNull() {
        return this.IsParamNull(TAG_IMAGEPATH);
    }

    public final String getIMAGEPATH() {
        return this.GetParamStringValue(TAG_IMAGEPATH, "");
    }

    public final void setIMAGEPATH(String strValue) {
        this.SetParamValue(TAG_IMAGEPATH, strValue);
    }

    public final boolean isCSSCLASSNull() {
        return this.IsParamNull(TAG_CSSCLASS);
    }

    public final String getCSSCLASS() {
        return this.GetParamStringValue(TAG_CSSCLASS, "");
    }

    public final void setCSSCLASS(String strValue) {
        this.SetParamValue(TAG_CSSCLASS, strValue);
    }

    public final boolean isWIDTHNull() {
        return this.IsParamNull(TAG_WIDTH);
    }

    public final int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public final void setWIDTH(int nValue) {
        this.SetParamValue(TAG_WIDTH, nValue);
    }

    public final boolean isHEIGHTNull() {
        return this.IsParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.SetParamValue(TAG_HEIGHT, nValue);
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

    public final boolean isGLYPHNull() {
        return this.IsParamNull(TAG_GLYPH);
    }

    public final String getGLYPH() {
        return this.GetParamStringValue(TAG_GLYPH, "");
    }

    public final void setGLYPH(String strValue) {
        this.SetParamValue(TAG_GLYPH, strValue);
    }

    public final boolean isCSSCLASSXNull() {
        return this.IsParamNull(TAG_CSSCLASSX);
    }

    public final String getCSSCLASSX() {
        return this.GetParamStringValue(TAG_CSSCLASSX, "");
    }

    public final void setCSSCLASSX(String strValue) {
        this.SetParamValue(TAG_CSSCLASSX, strValue);
    }

    public final boolean isIMAGEPATHXNull() {
        return this.IsParamNull(TAG_IMAGEPATHX);
    }

    public final String getIMAGEPATHX() {
        return this.GetParamStringValue(TAG_IMAGEPATHX, "");
    }

    public final void setIMAGEPATHX(String strValue) {
        this.SetParamValue(TAG_IMAGEPATHX, strValue);
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

    public final boolean isIMAGETYPENull() {
        return this.IsParamNull(TAG_IMAGETYPE);
    }

    public final String getIMAGETYPE() {
        return this.GetParamStringValue(TAG_IMAGETYPE, "");
    }

    public final void setIMAGETYPE(String strValue) {
        this.SetParamValue(TAG_IMAGETYPE, strValue);
    }

    public final boolean isIMAGESRCNull() {
        return this.IsParamNull(TAG_IMAGESRC);
    }

    public final String getIMAGESRC() {
        return this.GetParamStringValue(TAG_IMAGESRC, "");
    }

    public final void setIMAGESRC(String strValue) {
        this.SetParamValue(TAG_IMAGESRC, strValue);
    }

    public final boolean isPSSYSFILEIDNull() {
        return this.IsParamNull(TAG_PSSYSFILEID);
    }

    public final String getPSSYSFILEID() {
        return this.GetParamStringValue(TAG_PSSYSFILEID, "");
    }

    public final void setPSSYSFILEID(String strValue) {
        this.SetParamValue(TAG_PSSYSFILEID, strValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
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

    public final boolean isRAWCONTENTNull() {
        return this.IsParamNull(TAG_RAWCONTENT);
    }

    public final String getRAWCONTENT() {
        return this.GetParamStringValue(TAG_RAWCONTENT, "");
    }

    public final void setRAWCONTENT(String strValue) {
        this.SetParamValue(TAG_RAWCONTENT, strValue);
    }
}

