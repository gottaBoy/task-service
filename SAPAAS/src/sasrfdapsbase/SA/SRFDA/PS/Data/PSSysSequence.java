/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysSequence
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
    public static final String SEQUENCETYPE_DB = "DB";
    public static final String SEQUENCETYPE_DE = "DE";
    public static final String SEQUENCETYPE_USER = "USER";
    public static final String SEQUENCETYPE_USER2 = "USER2";
    public static final String SEQUENCETYPE_USER3 = "USER3";
    public static final String SEQUENCETYPE_USER4 = "USER4";
    public static final String TAG_PSSYSSEQUENCEID = "PSSYSSEQUENCEID";
    public static final String TAG_PSSYSSEQUENCENAME = "PSSYSSEQUENCENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_SEQUENCETAG2 = "SEQUENCETAG2";
    public static final String TAG_SEQUENCETAG = "SEQUENCETAG";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_KEYPSDEFID = "KEYPSDEFID";
    public static final String TAG_KEYPSDEFNAME = "KEYPSDEFNAME";
    public static final String TAG_VALUEPSDEFID = "VALUEPSDEFID";
    public static final String TAG_VALUEPSDEFNAME = "VALUEPSDEFNAME";
    public static final String TAG_MAXVALUE = "MAXVALUE";
    public static final String TAG_MINVALUE = "MINVALUE";
    public static final String TAG_SEQUENCEFORMAT = "SEQUENCEFORMAT";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_SEQUENCETYPE = "SEQUENCETYPE";
    public static final String TAG_EXTFORMATPARAMS = "EXTFORMATPARAMS";
    public static final String TAG_TIMEPSDEFID = "TIMEPSDEFID";
    public static final String TAG_TIMEPSDEFNAME = "TIMEPSDEFNAME";
    public static final String TAG_TIMEFORMAT = "TIMEFORMAT";
    public static final String TAG_TYPEPSDEFID = "TYPEPSDEFID";
    public static final String TAG_TYPEPSDEFNAME = "TYPEPSDEFNAME";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_USERPSDEFID = "USERPSDEFID";
    public static final String TAG_USERPSDEFNAME = "USERPSDEFNAME";
    public static final String TAG_USER2PSDEFID = "USER2PSDEFID";
    public static final String TAG_USER2PSDEFNAME = "USER2PSDEFNAME";
    public static final String TAG_SEQUENCEPARAMS = "SEQUENCEPARAMS";

    public final boolean isPSSYSSEQUENCEIDNull() {
        return this.IsParamNull(TAG_PSSYSSEQUENCEID);
    }

    public final String getPSSYSSEQUENCEID() {
        return this.GetParamStringValue(TAG_PSSYSSEQUENCEID, "");
    }

    public final void setPSSYSSEQUENCEID(String strValue) {
        this.SetParamValue(TAG_PSSYSSEQUENCEID, strValue);
    }

    public final boolean isPSSYSSEQUENCENAMENull() {
        return this.IsParamNull(TAG_PSSYSSEQUENCENAME);
    }

    public final String getPSSYSSEQUENCENAME() {
        return this.GetParamStringValue(TAG_PSSYSSEQUENCENAME, "");
    }

    public final void setPSSYSSEQUENCENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSEQUENCENAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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

    public final boolean isSEQUENCETAG2Null() {
        return this.IsParamNull(TAG_SEQUENCETAG2);
    }

    public final String getSEQUENCETAG2() {
        return this.GetParamStringValue(TAG_SEQUENCETAG2, "");
    }

    public final void setSEQUENCETAG2(String strValue) {
        this.SetParamValue(TAG_SEQUENCETAG2, strValue);
    }

    public final boolean isSEQUENCETAGNull() {
        return this.IsParamNull(TAG_SEQUENCETAG);
    }

    public final String getSEQUENCETAG() {
        return this.GetParamStringValue(TAG_SEQUENCETAG, "");
    }

    public final void setSEQUENCETAG(String strValue) {
        this.SetParamValue(TAG_SEQUENCETAG, strValue);
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

    public final boolean isMAXVALUENull() {
        return this.IsParamNull(TAG_MAXVALUE);
    }

    public final int getMAXVALUE() {
        return this.GetParamIntValue(TAG_MAXVALUE, 0);
    }

    public final void setMAXVALUE(int nValue) {
        this.SetParamValue(TAG_MAXVALUE, nValue);
    }

    public final boolean isMINVALUENull() {
        return this.IsParamNull(TAG_MINVALUE);
    }

    public final int getMINVALUE() {
        return this.GetParamIntValue(TAG_MINVALUE, 0);
    }

    public final void setMINVALUE(int nValue) {
        this.SetParamValue(TAG_MINVALUE, nValue);
    }

    public final boolean isSEQUENCEFORMATNull() {
        return this.IsParamNull(TAG_SEQUENCEFORMAT);
    }

    public final String getSEQUENCEFORMAT() {
        return this.GetParamStringValue(TAG_SEQUENCEFORMAT, "");
    }

    public final void setSEQUENCEFORMAT(String strValue) {
        this.SetParamValue(TAG_SEQUENCEFORMAT, strValue);
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

    public final boolean isSEQUENCETYPENull() {
        return this.IsParamNull(TAG_SEQUENCETYPE);
    }

    public final String getSEQUENCETYPE() {
        return this.GetParamStringValue(TAG_SEQUENCETYPE, "");
    }

    public final void setSEQUENCETYPE(String strValue) {
        this.SetParamValue(TAG_SEQUENCETYPE, strValue);
    }

    public final boolean isEXTFORMATPARAMSNull() {
        return this.IsParamNull(TAG_EXTFORMATPARAMS);
    }

    public final String getEXTFORMATPARAMS() {
        return this.GetParamStringValue(TAG_EXTFORMATPARAMS, "");
    }

    public final void setEXTFORMATPARAMS(String strValue) {
        this.SetParamValue(TAG_EXTFORMATPARAMS, strValue);
    }

    public final boolean isTIMEPSDEFIDNull() {
        return this.IsParamNull(TAG_TIMEPSDEFID);
    }

    public final String getTIMEPSDEFID() {
        return this.GetParamStringValue(TAG_TIMEPSDEFID, "");
    }

    public final void setTIMEPSDEFID(String strValue) {
        this.SetParamValue(TAG_TIMEPSDEFID, strValue);
    }

    public final boolean isTIMEPSDEFNAMENull() {
        return this.IsParamNull(TAG_TIMEPSDEFNAME);
    }

    public final String getTIMEPSDEFNAME() {
        return this.GetParamStringValue(TAG_TIMEPSDEFNAME, "");
    }

    public final void setTIMEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TIMEPSDEFNAME, strValue);
    }

    public final boolean isTIMEFORMATNull() {
        return this.IsParamNull(TAG_TIMEFORMAT);
    }

    public final String getTIMEFORMAT() {
        return this.GetParamStringValue(TAG_TIMEFORMAT, "");
    }

    public final void setTIMEFORMAT(String strValue) {
        this.SetParamValue(TAG_TIMEFORMAT, strValue);
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

    public final boolean isSEQUENCEPARAMSNull() {
        return this.IsParamNull(TAG_SEQUENCEPARAMS);
    }

    public final String getSEQUENCEPARAMS() {
        return this.GetParamStringValue(TAG_SEQUENCEPARAMS, "");
    }

    public final void setSEQUENCEPARAMS(String strValue) {
        this.SetParamValue(TAG_SEQUENCEPARAMS, strValue);
    }

    public final boolean isTYPEPSDEFIDNull() {
        return this.IsParamNull(TAG_TYPEPSDEFID);
    }

    public final String getTYPEPSDEFID() {
        return this.GetParamStringValue(TAG_TYPEPSDEFID, "");
    }

    public final void setTYPEPSDEFID(String strValue) {
        this.SetParamValue(TAG_TYPEPSDEFID, strValue);
    }

    public final boolean isTYPEPSDEFNAMENull() {
        return this.IsParamNull(TAG_TYPEPSDEFNAME);
    }

    public final String getTYPEPSDEFNAME() {
        return this.GetParamStringValue(TAG_TYPEPSDEFNAME, "");
    }

    public final void setTYPEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TYPEPSDEFNAME, strValue);
    }
}

