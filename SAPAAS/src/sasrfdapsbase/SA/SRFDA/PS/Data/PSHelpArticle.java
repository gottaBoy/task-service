/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFDA.PS.Data.PSHelpSection;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

public class PSHelpArticle
extends BaseDataEntity {
    public static final String ARTICLETYPE_DEMODEL = "DEMODEL";
    public static final String ARTICLETYPE_DEVIEW = "DEVIEW";
    public static final String ARTICLETYPE_APPVIEW = "APPVIEW";
    public static final String ARTICLETYPE_MANUAL = "MANUAL";
    public static final String TAG_PSHELPARTICLEID = "PSHELPARTICLEID";
    public static final String TAG_PSHELPARTICLENAME = "PSHELPARTICLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_ARTICLETYPE = "ARTICLETYPE";
    public static final String TAG_SUBCAPTION = "SUBCAPTION";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_ARTICLEPARAM = "ARTICLEPARAM";
    public static final String TAG_ARTICLEPARAM2 = "ARTICLEPARAM2";
    public static final String TAG_ARTICLEPARAM3 = "ARTICLEPARAM3";
    public static final String TAG_ARTICLEPARAM4 = "ARTICLEPARAM4";
    public static final String TAG_ARTICLEPARAM5 = "ARTICLEPARAM5";
    public static final String TAG_ARTICLEPARAM6 = "ARTICLEPARAM6";
    public static final String TAG_ARTICLEPARAM7 = "ARTICLEPARAM7";
    public static final String TAG_ARTICLEPARAM8 = "ARTICLEPARAM8";
    public static final String TAG_KEYWORDS = "KEYWORDS";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_HEADERCONTENT = "HEADERCONTENT";
    public static final String TAG_BOTTOMCONTENT = "BOTTOMCONTENT";
    public static final String TAG_PSHELPARTICLECATID = "PSHELPARTICLECATID";
    public static final String TAG_PSHELPARTICLECATNAME = "PSHELPARTICLECATNAME";
    public static final String TAG_ARTICLESN = "ARTICLESN";
    public static final String TAG_TITLE = "TITLE";
    public static final String TAG_ARTICLEVER = "ARTICLEVER";
    public static final String TAG_PSHELPARTICLETEMPLID = "PSHELPARTICLETEMPLID";
    public static final String TAG_PSHELPARTICLETEMPLNAME = "PSHELPARTICLETEMPLNAME";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSSYSUSERCASEID = "PSSYSUSERCASEID";
    public static final String TAG_PSSYSUSERCASENAME = "PSSYSUSERCASENAME";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    private ArrayList<PSHelpSection> rootPSHelpSectionList = null;

    public final boolean isPSHELPARTICLEIDNull() {
        return this.IsParamNull(TAG_PSHELPARTICLEID);
    }

    public final String getPSHELPARTICLEID() {
        return this.GetParamStringValue(TAG_PSHELPARTICLEID, "");
    }

    public final void setPSHELPARTICLEID(String strValue) {
        this.SetParamValue(TAG_PSHELPARTICLEID, strValue);
    }

    public final boolean isPSHELPARTICLENAMENull() {
        return this.IsParamNull(TAG_PSHELPARTICLENAME);
    }

    public final String getPSHELPARTICLENAME() {
        return this.GetParamStringValue(TAG_PSHELPARTICLENAME, "");
    }

    public final void setPSHELPARTICLENAME(String strValue) {
        this.SetParamValue(TAG_PSHELPARTICLENAME, strValue);
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

    public final boolean isARTICLETYPENull() {
        return this.IsParamNull(TAG_ARTICLETYPE);
    }

    public final String getARTICLETYPE() {
        return this.GetParamStringValue(TAG_ARTICLETYPE, "");
    }

    public final void setARTICLETYPE(String strValue) {
        this.SetParamValue(TAG_ARTICLETYPE, strValue);
    }

    public final boolean isSUBCAPTIONNull() {
        return this.IsParamNull(TAG_SUBCAPTION);
    }

    public final String getSUBCAPTION() {
        return this.GetParamStringValue(TAG_SUBCAPTION, "");
    }

    public final void setSUBCAPTION(String strValue) {
        this.SetParamValue(TAG_SUBCAPTION, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isARTICLEPARAMNull() {
        return this.IsParamNull(TAG_ARTICLEPARAM);
    }

    public final String getARTICLEPARAM() {
        return this.GetParamStringValue(TAG_ARTICLEPARAM, "");
    }

    public final void setARTICLEPARAM(String strValue) {
        this.SetParamValue(TAG_ARTICLEPARAM, strValue);
    }

    public final boolean isARTICLEPARAM2Null() {
        return this.IsParamNull(TAG_ARTICLEPARAM2);
    }

    public final String getARTICLEPARAM2() {
        return this.GetParamStringValue(TAG_ARTICLEPARAM2, "");
    }

    public final void setARTICLEPARAM2(String strValue) {
        this.SetParamValue(TAG_ARTICLEPARAM2, strValue);
    }

    public final boolean isARTICLEPARAM3Null() {
        return this.IsParamNull(TAG_ARTICLEPARAM3);
    }

    public final String getARTICLEPARAM3() {
        return this.GetParamStringValue(TAG_ARTICLEPARAM3, "");
    }

    public final void setARTICLEPARAM3(String strValue) {
        this.SetParamValue(TAG_ARTICLEPARAM3, strValue);
    }

    public final boolean isARTICLEPARAM4Null() {
        return this.IsParamNull(TAG_ARTICLEPARAM4);
    }

    public final String getARTICLEPARAM4() {
        return this.GetParamStringValue(TAG_ARTICLEPARAM4, "");
    }

    public final void setARTICLEPARAM4(String strValue) {
        this.SetParamValue(TAG_ARTICLEPARAM4, strValue);
    }

    public final boolean isARTICLEPARAM5Null() {
        return this.IsParamNull(TAG_ARTICLEPARAM5);
    }

    public final boolean getARTICLEPARAM5() {
        return this.GetParamIntValue(TAG_ARTICLEPARAM5, 0) == 1;
    }

    public final void setARTICLEPARAM5(boolean bValue) {
        this.SetParamValue(TAG_ARTICLEPARAM5, bValue ? 1 : 0);
    }

    public final boolean isARTICLEPARAM6Null() {
        return this.IsParamNull(TAG_ARTICLEPARAM6);
    }

    public final boolean getARTICLEPARAM6() {
        return this.GetParamIntValue(TAG_ARTICLEPARAM6, 0) == 1;
    }

    public final void setARTICLEPARAM6(boolean bValue) {
        this.SetParamValue(TAG_ARTICLEPARAM6, bValue ? 1 : 0);
    }

    public final boolean isARTICLEPARAM7Null() {
        return this.IsParamNull(TAG_ARTICLEPARAM7);
    }

    public final boolean getARTICLEPARAM7() {
        return this.GetParamIntValue(TAG_ARTICLEPARAM7, 0) == 1;
    }

    public final void setARTICLEPARAM7(boolean bValue) {
        this.SetParamValue(TAG_ARTICLEPARAM7, bValue ? 1 : 0);
    }

    public final boolean isARTICLEPARAM8Null() {
        return this.IsParamNull(TAG_ARTICLEPARAM8);
    }

    public final boolean getARTICLEPARAM8() {
        return this.GetParamIntValue(TAG_ARTICLEPARAM8, 0) == 1;
    }

    public final void setARTICLEPARAM8(boolean bValue) {
        this.SetParamValue(TAG_ARTICLEPARAM8, bValue ? 1 : 0);
    }

    public final boolean isKEYWORDSNull() {
        return this.IsParamNull(TAG_KEYWORDS);
    }

    public final String getKEYWORDS() {
        return this.GetParamStringValue(TAG_KEYWORDS, "");
    }

    public final void setKEYWORDS(String strValue) {
        this.SetParamValue(TAG_KEYWORDS, strValue);
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

    public final boolean isCONTENTNull() {
        return this.IsParamNull(TAG_CONTENT);
    }

    public final String getCONTENT() {
        return this.GetParamStringValue(TAG_CONTENT, "");
    }

    public final void setCONTENT(String strValue) {
        this.SetParamValue(TAG_CONTENT, strValue);
    }

    public final boolean isHEADERCONTENTNull() {
        return this.IsParamNull(TAG_HEADERCONTENT);
    }

    public final String getHEADERCONTENT() {
        return this.GetParamStringValue(TAG_HEADERCONTENT, "");
    }

    public final void setHEADERCONTENT(String strValue) {
        this.SetParamValue(TAG_HEADERCONTENT, strValue);
    }

    public final boolean isBOTTOMCONTENTNull() {
        return this.IsParamNull(TAG_BOTTOMCONTENT);
    }

    public final String getBOTTOMCONTENT() {
        return this.GetParamStringValue(TAG_BOTTOMCONTENT, "");
    }

    public final void setBOTTOMCONTENT(String strValue) {
        this.SetParamValue(TAG_BOTTOMCONTENT, strValue);
    }

    public final boolean isPSHELPARTICLECATIDNull() {
        return this.IsParamNull(TAG_PSHELPARTICLECATID);
    }

    public final String getPSHELPARTICLECATID() {
        return this.GetParamStringValue(TAG_PSHELPARTICLECATID, "");
    }

    public final void setPSHELPARTICLECATID(String strValue) {
        this.SetParamValue(TAG_PSHELPARTICLECATID, strValue);
    }

    public final boolean isPSHELPARTICLECATNAMENull() {
        return this.IsParamNull(TAG_PSHELPARTICLECATNAME);
    }

    public final String getPSHELPARTICLECATNAME() {
        return this.GetParamStringValue(TAG_PSHELPARTICLECATNAME, "");
    }

    public final void setPSHELPARTICLECATNAME(String strValue) {
        this.SetParamValue(TAG_PSHELPARTICLECATNAME, strValue);
    }

    public final boolean isARTICLESNNull() {
        return this.IsParamNull(TAG_ARTICLESN);
    }

    public final String getARTICLESN() {
        return this.GetParamStringValue(TAG_ARTICLESN, "");
    }

    public final void setARTICLESN(String strValue) {
        this.SetParamValue(TAG_ARTICLESN, strValue);
    }

    public final boolean isTITLENull() {
        return this.IsParamNull(TAG_TITLE);
    }

    public final String getTITLE() {
        return this.GetParamStringValue(TAG_TITLE, "");
    }

    public final void setTITLE(String strValue) {
        this.SetParamValue(TAG_TITLE, strValue);
    }

    public final boolean isARTICLEVERNull() {
        return this.IsParamNull(TAG_ARTICLEVER);
    }

    public final String getARTICLEVER() {
        return this.GetParamStringValue(TAG_ARTICLEVER, "");
    }

    public final void setARTICLEVER(String strValue) {
        this.SetParamValue(TAG_ARTICLEVER, strValue);
    }

    public final boolean isPSHELPARTICLETEMPLIDNull() {
        return this.IsParamNull(TAG_PSHELPARTICLETEMPLID);
    }

    public final String getPSHELPARTICLETEMPLID() {
        return this.GetParamStringValue(TAG_PSHELPARTICLETEMPLID, "");
    }

    public final void setPSHELPARTICLETEMPLID(String strValue) {
        this.SetParamValue(TAG_PSHELPARTICLETEMPLID, strValue);
    }

    public final boolean isPSHELPARTICLETEMPLNAMENull() {
        return this.IsParamNull(TAG_PSHELPARTICLETEMPLNAME);
    }

    public final String getPSHELPARTICLETEMPLNAME() {
        return this.GetParamStringValue(TAG_PSHELPARTICLETEMPLNAME, "");
    }

    public final void setPSHELPARTICLETEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSHELPARTICLETEMPLNAME, strValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
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

    public final boolean isPSSYSUSERCASEIDNull() {
        return this.IsParamNull(TAG_PSSYSUSERCASEID);
    }

    public final String getPSSYSUSERCASEID() {
        return this.GetParamStringValue(TAG_PSSYSUSERCASEID, "");
    }

    public final void setPSSYSUSERCASEID(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERCASEID, strValue);
    }

    public final boolean isPSSYSUSERCASENAMENull() {
        return this.IsParamNull(TAG_PSSYSUSERCASENAME);
    }

    public final String getPSSYSUSERCASENAME() {
        return this.GetParamStringValue(TAG_PSSYSUSERCASENAME, "");
    }

    public final void setPSSYSUSERCASENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERCASENAME, strValue);
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

    public ArrayList<PSHelpSection> getRootPSHelpSections(boolean bCreated) {
        if (this.rootPSHelpSectionList != null) {
            return this.rootPSHelpSectionList;
        }
        if (bCreated) {
            this.rootPSHelpSectionList = new ArrayList();
        }
        return this.rootPSHelpSectionList;
    }

    public void resetChildDatas() {
        if (this.rootPSHelpSectionList != null) {
            this.rootPSHelpSectionList.clear();
            this.rootPSHelpSectionList = null;
        }
    }
}

