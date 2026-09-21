/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysTranslator
extends BaseDataEntity {
    public static final String TRANSLATORTYPE_DESTORAGE = "DESTORAGE";
    public static final String TRANSLATORTYPE_USER = "USER";
    public static final String TRANSLATORTYPE_USER2 = "USER2";
    public static final String TRANSLATORTYPE_USER3 = "USER3";
    public static final String TRANSLATORTYPE_USER4 = "USER4";
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSSYSTRANSLATORID = "PSSYSTRANSLATORID";
    public static final String TAG_PSSYSTRANSLATORNAME = "PSSYSTRANSLATORNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_VALUEPSDEFID = "VALUEPSDEFID";
    public static final String TAG_VALUEPSDEFNAME = "VALUEPSDEFNAME";
    public static final String TAG_KEYPSDEFID = "KEYPSDEFID";
    public static final String TAG_KEYPSDEFNAME = "KEYPSDEFNAME";
    public static final String TAG_TRANSLATORTYPE = "TRANSLATORTYPE";
    public static final String TAG_TRANSLATORTAG = "TRANSLATORTAG";
    public static final String TAG_TRANSLATORTAG2 = "TRANSLATORTAG2";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_USERPSDEFID = "USERPSDEFID";
    public static final String TAG_USERPSDEFNAME = "USERPSDEFNAME";
    public static final String TAG_USER2PSDEFID = "USER2PSDEFID";
    public static final String TAG_USER2PSDEFNAME = "USER2PSDEFNAME";
    public static final String TAG_TRANSLATORPARAMS = "TRANSLATORPARAMS";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";

    public final boolean isPSSYSTRANSLATORIDNull() {
        return this.IsParamNull(TAG_PSSYSTRANSLATORID);
    }

    public final String getPSSYSTRANSLATORID() {
        return this.GetParamStringValue(TAG_PSSYSTRANSLATORID, "");
    }

    public final void setPSSYSTRANSLATORID(String strValue) {
        this.SetParamValue(TAG_PSSYSTRANSLATORID, strValue);
    }

    public final boolean isPSSYSTRANSLATORNAMENull() {
        return this.IsParamNull(TAG_PSSYSTRANSLATORNAME);
    }

    public final String getPSSYSTRANSLATORNAME() {
        return this.GetParamStringValue(TAG_PSSYSTRANSLATORNAME, "");
    }

    public final void setPSSYSTRANSLATORNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTRANSLATORNAME, strValue);
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

    public final boolean isPSSYSSFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINID);
    }

    public final String getPSSYSSFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINID, "");
    }

    public final void setPSSYSSFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINID, strValue);
    }

    public final boolean isPSSYSSFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINNAME);
    }

    public final String getPSSYSSFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINNAME, "");
    }

    public final void setPSSYSSFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINNAME, strValue);
    }

    public final boolean isPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELID);
    }

    public final String getPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELID, "");
    }

    public final void setPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELID, strValue);
    }

    public final boolean isPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELNAME);
    }

    public final String getPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELNAME, "");
    }

    public final void setPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELNAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isVALUEPSDEFIDNull() {
        return this.IsParamNull(TAG_VALUEPSDEFID);
    }

    public final String getVALUEPSDEFID() {
        return this.GetParamStringValue(TAG_VALUEPSDEFID, "");
    }

    public final void setVALUEPSDEFID(String strValue) {
        this.SetParamValue(TAG_VALUEPSDEFID, strValue);
    }

    public final boolean isVALUEPSDEFNAMENull() {
        return this.IsParamNull(TAG_VALUEPSDEFNAME);
    }

    public final String getVALUEPSDEFNAME() {
        return this.GetParamStringValue(TAG_VALUEPSDEFNAME, "");
    }

    public final void setVALUEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_VALUEPSDEFNAME, strValue);
    }

    public final boolean isKEYPSDEFIDNull() {
        return this.IsParamNull(TAG_KEYPSDEFID);
    }

    public final String getKEYPSDEFID() {
        return this.GetParamStringValue(TAG_KEYPSDEFID, "");
    }

    public final void setKEYPSDEFID(String strValue) {
        this.SetParamValue(TAG_KEYPSDEFID, strValue);
    }

    public final boolean isKEYPSDEFNAMENull() {
        return this.IsParamNull(TAG_KEYPSDEFNAME);
    }

    public final String getKEYPSDEFNAME() {
        return this.GetParamStringValue(TAG_KEYPSDEFNAME, "");
    }

    public final void setKEYPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_KEYPSDEFNAME, strValue);
    }

    public final boolean isTRANSLATORTYPENull() {
        return this.IsParamNull(TAG_TRANSLATORTYPE);
    }

    public final String getTRANSLATORTYPE() {
        return this.GetParamStringValue(TAG_TRANSLATORTYPE, "");
    }

    public final void setTRANSLATORTYPE(String strValue) {
        this.SetParamValue(TAG_TRANSLATORTYPE, strValue);
    }

    public final boolean isTRANSLATORTAGNull() {
        return this.IsParamNull(TAG_TRANSLATORTAG);
    }

    public final String getTRANSLATORTAG() {
        return this.GetParamStringValue(TAG_TRANSLATORTAG, "");
    }

    public final void setTRANSLATORTAG(String strValue) {
        this.SetParamValue(TAG_TRANSLATORTAG, strValue);
    }

    public final boolean isTRANSLATORTAG2Null() {
        return this.IsParamNull(TAG_TRANSLATORTAG2);
    }

    public final String getTRANSLATORTAG2() {
        return this.GetParamStringValue(TAG_TRANSLATORTAG2, "");
    }

    public final void setTRANSLATORTAG2(String strValue) {
        this.SetParamValue(TAG_TRANSLATORTAG2, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
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

    public final boolean isCUSTOMCODENull() {
        return this.IsParamNull(TAG_CUSTOMCODE);
    }

    public final String getCUSTOMCODE() {
        return this.GetParamStringValue(TAG_CUSTOMCODE, "");
    }

    public final void setCUSTOMCODE(String strValue) {
        this.SetParamValue(TAG_CUSTOMCODE, strValue);
    }

    public final boolean isCUSTOMMODENull() {
        return this.IsParamNull(TAG_CUSTOMMODE);
    }

    public final boolean getCUSTOMMODE() {
        return this.GetParamIntValue(TAG_CUSTOMMODE, 0) == 1;
    }

    public final void setCUSTOMMODE(boolean bValue) {
        this.SetParamValue(TAG_CUSTOMMODE, bValue ? 1 : 0);
    }

    public final boolean isUSERPSDEFIDNull() {
        return this.IsParamNull(TAG_USERPSDEFID);
    }

    public final String getUSERPSDEFID() {
        return this.GetParamStringValue(TAG_USERPSDEFID, "");
    }

    public final void setUSERPSDEFID(String strValue) {
        this.SetParamValue(TAG_USERPSDEFID, strValue);
    }

    public final boolean isUSERPSDEFNAMENull() {
        return this.IsParamNull(TAG_USERPSDEFNAME);
    }

    public final String getUSERPSDEFNAME() {
        return this.GetParamStringValue(TAG_USERPSDEFNAME, "");
    }

    public final void setUSERPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_USERPSDEFNAME, strValue);
    }

    public final boolean isUSER2PSDEFIDNull() {
        return this.IsParamNull(TAG_USER2PSDEFID);
    }

    public final String getUSER2PSDEFID() {
        return this.GetParamStringValue(TAG_USER2PSDEFID, "");
    }

    public final void setUSER2PSDEFID(String strValue) {
        this.SetParamValue(TAG_USER2PSDEFID, strValue);
    }

    public final boolean isUSER2PSDEFNAMENull() {
        return this.IsParamNull(TAG_USER2PSDEFNAME);
    }

    public final String getUSER2PSDEFNAME() {
        return this.GetParamStringValue(TAG_USER2PSDEFNAME, "");
    }

    public final void setUSER2PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_USER2PSDEFNAME, strValue);
    }

    public final boolean isTRANSLATORPARAMSNull() {
        return this.IsParamNull(TAG_TRANSLATORPARAMS);
    }

    public final String getTRANSLATORPARAMS() {
        return this.GetParamStringValue(TAG_TRANSLATORPARAMS, "");
    }

    public final void setTRANSLATORPARAMS(String strValue) {
        this.SetParamValue(TAG_TRANSLATORPARAMS, strValue);
    }

    public final boolean isPSCODELISTIDNull() {
        return this.IsParamNull(TAG_PSCODELISTID);
    }

    public final String getPSCODELISTID() {
        return this.GetParamStringValue(TAG_PSCODELISTID, "");
    }

    public final void setPSCODELISTID(String strValue) {
        this.SetParamValue(TAG_PSCODELISTID, strValue);
    }

    public final boolean isPSCODELISTNAMENull() {
        return this.IsParamNull(TAG_PSCODELISTNAME);
    }

    public final String getPSCODELISTNAME() {
        return this.GetParamStringValue(TAG_PSCODELISTNAME, "");
    }

    public final void setPSCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_PSCODELISTNAME, strValue);
    }
}

