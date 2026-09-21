/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysContent
extends BaseDataEntity {
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSSYSCONTENTID = "PSSYSCONTENTID";
    public static final String TAG_PSSYSCONTENTNAME = "PSSYSCONTENTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_CONTENTTYPE = "CONTENTTYPE";
    public static final String TAG_RAWCONTENT = "RAWCONTENT";
    public static final String TAG_HTMLCONTENT = "HTMLCONTENT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_LOCKFLAG = "LOCKFLAG";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_CONTENTTAG = "CONTENTTAG";
    public static final String TAG_CONTENTTAG2 = "CONTENTTAG2";
    public static final String TAG_CONTENTTAG3 = "CONTENTTAG3";
    public static final String TAG_CONTENTTAG4 = "CONTENTTAG4";
    public static final String TAG_PSSYSCONTENTCATID = "PSSYSCONTENTCATID";
    public static final String TAG_PSSYSCONTENTCATNAME = "PSSYSCONTENTCATNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_TAGS = "TAGS";
    public static final String TAG_SUBJECT = "SUBJECT";
    public static final String TAG_CONTENTPATH = "CONTENTPATH";

    public final boolean isPSSYSCONTENTIDNull() {
        return this.IsParamNull(TAG_PSSYSCONTENTID);
    }

    public final String getPSSYSCONTENTID() {
        return this.GetParamStringValue(TAG_PSSYSCONTENTID, "");
    }

    public final void setPSSYSCONTENTID(String strValue) {
        this.SetParamValue(TAG_PSSYSCONTENTID, strValue);
    }

    public final boolean isPSSYSCONTENTNAMENull() {
        return this.IsParamNull(TAG_PSSYSCONTENTNAME);
    }

    public final String getPSSYSCONTENTNAME() {
        return this.GetParamStringValue(TAG_PSSYSCONTENTNAME, "");
    }

    public final void setPSSYSCONTENTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCONTENTNAME, strValue);
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

    public final boolean isCONTENTTYPENull() {
        return this.IsParamNull(TAG_CONTENTTYPE);
    }

    public final String getCONTENTTYPE() {
        return this.GetParamStringValue(TAG_CONTENTTYPE, "");
    }

    public final void setCONTENTTYPE(String strValue) {
        this.SetParamValue(TAG_CONTENTTYPE, strValue);
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

    public final boolean isHTMLCONTENTNull() {
        return this.IsParamNull(TAG_HTMLCONTENT);
    }

    public final String getHTMLCONTENT() {
        return this.GetParamStringValue(TAG_HTMLCONTENT, "");
    }

    public final void setHTMLCONTENT(String strValue) {
        this.SetParamValue(TAG_HTMLCONTENT, strValue);
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

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isCONTENTTAGNull() {
        return this.IsParamNull(TAG_CONTENTTAG);
    }

    public final String getCONTENTTAG() {
        return this.GetParamStringValue(TAG_CONTENTTAG, "");
    }

    public final void setCONTENTTAG(String strValue) {
        this.SetParamValue(TAG_CONTENTTAG, strValue);
    }

    public final boolean isCONTENTTAG2Null() {
        return this.IsParamNull(TAG_CONTENTTAG2);
    }

    public final String getCONTENTTAG2() {
        return this.GetParamStringValue(TAG_CONTENTTAG2, "");
    }

    public final void setCONTENTTAG2(String strValue) {
        this.SetParamValue(TAG_CONTENTTAG2, strValue);
    }

    public final boolean isCONTENTTAG3Null() {
        return this.IsParamNull(TAG_CONTENTTAG3);
    }

    public final String getCONTENTTAG3() {
        return this.GetParamStringValue(TAG_CONTENTTAG3, "");
    }

    public final void setCONTENTTAG3(String strValue) {
        this.SetParamValue(TAG_CONTENTTAG3, strValue);
    }

    public final boolean isCONTENTTAG4Null() {
        return this.IsParamNull(TAG_CONTENTTAG4);
    }

    public final String getCONTENTTAG4() {
        return this.GetParamStringValue(TAG_CONTENTTAG4, "");
    }

    public final void setCONTENTTAG4(String strValue) {
        this.SetParamValue(TAG_CONTENTTAG4, strValue);
    }

    public final boolean isPSSYSCONTENTCATIDNull() {
        return this.IsParamNull(TAG_PSSYSCONTENTCATID);
    }

    public final String getPSSYSCONTENTCATID() {
        return this.GetParamStringValue(TAG_PSSYSCONTENTCATID, "");
    }

    public final void setPSSYSCONTENTCATID(String strValue) {
        this.SetParamValue(TAG_PSSYSCONTENTCATID, strValue);
    }

    public final boolean isPSSYSCONTENTCATNAMENull() {
        return this.IsParamNull(TAG_PSSYSCONTENTCATNAME);
    }

    public final String getPSSYSCONTENTCATNAME() {
        return this.GetParamStringValue(TAG_PSSYSCONTENTCATNAME, "");
    }

    public final void setPSSYSCONTENTCATNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCONTENTCATNAME, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final boolean isTAGSNull() {
        return this.IsParamNull(TAG_TAGS);
    }

    public final String getTAGS() {
        return this.GetParamStringValue(TAG_TAGS, "");
    }

    public final void setTAGS(String strValue) {
        this.SetParamValue(TAG_TAGS, strValue);
    }

    public final boolean isSUBJECTNull() {
        return this.IsParamNull(TAG_SUBJECT);
    }

    public final String getSUBJECT() {
        return this.GetParamStringValue(TAG_SUBJECT, "");
    }

    public final void setSUBJECT(String strValue) {
        this.SetParamValue(TAG_SUBJECT, strValue);
    }

    public final boolean isCONTENTPATHNull() {
        return this.IsParamNull(TAG_CONTENTPATH);
    }

    public final String getCONTENTPATH() {
        return this.GetParamStringValue(TAG_CONTENTPATH, "");
    }

    public final void setCONTENTPATH(String strValue) {
        this.SetParamValue(TAG_CONTENTPATH, strValue);
    }
}

