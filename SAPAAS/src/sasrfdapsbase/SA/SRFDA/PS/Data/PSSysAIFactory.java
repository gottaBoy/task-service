/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysAIFactory
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
    public static final String AUTHMODE_NONE = "NONE";
    public static final String AUTHMODE_AUTHORIZATION_CODE = "AUTHORIZATION_CODE";
    public static final String AUTHMODE_PASSWORD = "PASSWORD";
    public static final String AUTHMODE_CLIENT_CREDENTIALS = "CLIENT_CREDENTIALS";
    public static final String AUTHMODE_IMPLICIT = "IMPLICIT";
    public static final String TAG_PSSYSAIFACTORYID = "PSSYSAIFACTORYID";
    public static final String TAG_PSSYSAIFACTORYNAME = "PSSYSAIFACTORYNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_AIFACTORYTAG2 = "AIFACTORYTAG2";
    public static final String TAG_AIFACTORYTAG = "AIFACTORYTAG";
    public static final String TAG_AIFACTORYTYPE = "AIFACTORYTYPE";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_AUTHMODE = "AUTHMODE";
    public static final String TAG_AUTHCLIENTID = "AUTHCLIENTID";
    public static final String TAG_AUTHCLIENTSECRET = "AUTHCLIENTSECRET";
    public static final String TAG_AUTHPARAM = "AUTHPARAM";
    public static final String TAG_AUTHPARAM2 = "AUTHPARAM2";
    public static final String TAG_SERVICEPATH = "SERVICEPATH";
    public static final String TAG_AIFACTORYPARAMS = "AIFACTORYPARAMS";
    public static final String TAG_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String TAG_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String TAG_SERVICEPARAM = "SERVICEPARAM";
    public static final String TAG_SERVICEPARAM2 = "SERVICEPARAM2";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_AIPLATFORMTYPE = "AIPLATFORMTYPE";

    public final boolean isPSSYSAIFACTORYIDNull() {
        return this.IsParamNull(TAG_PSSYSAIFACTORYID);
    }

    public final String getPSSYSAIFACTORYID() {
        return this.GetParamStringValue(TAG_PSSYSAIFACTORYID, "");
    }

    public final void setPSSYSAIFACTORYID(String strValue) {
        this.SetParamValue(TAG_PSSYSAIFACTORYID, strValue);
    }

    public final boolean isPSSYSAIFACTORYNAMENull() {
        return this.IsParamNull(TAG_PSSYSAIFACTORYNAME);
    }

    public final String getPSSYSAIFACTORYNAME() {
        return this.GetParamStringValue(TAG_PSSYSAIFACTORYNAME, "");
    }

    public final void setPSSYSAIFACTORYNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAIFACTORYNAME, strValue);
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

    public final boolean isAIFACTORYTAG2Null() {
        return this.IsParamNull(TAG_AIFACTORYTAG2);
    }

    public final String getAIFACTORYTAG2() {
        return this.GetParamStringValue(TAG_AIFACTORYTAG2, "");
    }

    public final void setAIFACTORYTAG2(String strValue) {
        this.SetParamValue(TAG_AIFACTORYTAG2, strValue);
    }

    public final boolean isAIFACTORYTAGNull() {
        return this.IsParamNull(TAG_AIFACTORYTAG);
    }

    public final String getAIFACTORYTAG() {
        return this.GetParamStringValue(TAG_AIFACTORYTAG, "");
    }

    public final void setAIFACTORYTAG(String strValue) {
        this.SetParamValue(TAG_AIFACTORYTAG, strValue);
    }

    public final boolean isAIFACTORYTYPENull() {
        return this.IsParamNull(TAG_AIFACTORYTYPE);
    }

    public final String getAIFACTORYTYPE() {
        return this.GetParamStringValue(TAG_AIFACTORYTYPE, "");
    }

    public final void setAIFACTORYTYPE(String strValue) {
        this.SetParamValue(TAG_AIFACTORYTYPE, strValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
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

    public final boolean isAUTHMODENull() {
        return this.IsParamNull(TAG_AUTHMODE);
    }

    public final String getAUTHMODE() {
        return this.GetParamStringValue(TAG_AUTHMODE, "");
    }

    public final void setAUTHMODE(String strValue) {
        this.SetParamValue(TAG_AUTHMODE, strValue);
    }

    public final boolean isAUTHCLIENTIDNull() {
        return this.IsParamNull(TAG_AUTHCLIENTID);
    }

    public final String getAUTHCLIENTID() {
        return this.GetParamStringValue(TAG_AUTHCLIENTID, "");
    }

    public final void setAUTHCLIENTID(String strValue) {
        this.SetParamValue(TAG_AUTHCLIENTID, strValue);
    }

    public final boolean isAUTHCLIENTSECRETNull() {
        return this.IsParamNull(TAG_AUTHCLIENTSECRET);
    }

    public final String getAUTHCLIENTSECRET() {
        return this.GetParamStringValue(TAG_AUTHCLIENTSECRET, "");
    }

    public final void setAUTHCLIENTSECRET(String strValue) {
        this.SetParamValue(TAG_AUTHCLIENTSECRET, strValue);
    }

    public final boolean isAUTHPARAMNull() {
        return this.IsParamNull(TAG_AUTHPARAM);
    }

    public final String getAUTHPARAM() {
        return this.GetParamStringValue(TAG_AUTHPARAM, "");
    }

    public final void setAUTHPARAM(String strValue) {
        this.SetParamValue(TAG_AUTHPARAM, strValue);
    }

    public final boolean isAUTHPARAM2Null() {
        return this.IsParamNull(TAG_AUTHPARAM2);
    }

    public final String getAUTHPARAM2() {
        return this.GetParamStringValue(TAG_AUTHPARAM2, "");
    }

    public final void setAUTHPARAM2(String strValue) {
        this.SetParamValue(TAG_AUTHPARAM2, strValue);
    }

    public final boolean isSERVICEPATHNull() {
        return this.IsParamNull(TAG_SERVICEPATH);
    }

    public final String getSERVICEPATH() {
        return this.GetParamStringValue(TAG_SERVICEPATH, "");
    }

    public final void setSERVICEPATH(String strValue) {
        this.SetParamValue(TAG_SERVICEPATH, strValue);
    }

    public final boolean isAIFACTORYPARAMSNull() {
        return this.IsParamNull(TAG_AIFACTORYPARAMS);
    }

    public final String getAIFACTORYPARAMS() {
        return this.GetParamStringValue(TAG_AIFACTORYPARAMS, "");
    }

    public final void setAIFACTORYPARAMS(String strValue) {
        this.SetParamValue(TAG_AIFACTORYPARAMS, strValue);
    }

    public final boolean isPSSYSRESOURCEIDNull() {
        return this.IsParamNull(TAG_PSSYSRESOURCEID);
    }

    public final String getPSSYSRESOURCEID() {
        return this.GetParamStringValue(TAG_PSSYSRESOURCEID, "");
    }

    public final void setPSSYSRESOURCEID(String strValue) {
        this.SetParamValue(TAG_PSSYSRESOURCEID, strValue);
    }

    public final boolean isPSSYSRESOURCENAMENull() {
        return this.IsParamNull(TAG_PSSYSRESOURCENAME);
    }

    public final String getPSSYSRESOURCENAME() {
        return this.GetParamStringValue(TAG_PSSYSRESOURCENAME, "");
    }

    public final void setPSSYSRESOURCENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSRESOURCENAME, strValue);
    }

    public final boolean isSERVICEPARAMNull() {
        return this.IsParamNull(TAG_SERVICEPARAM);
    }

    public final String getSERVICEPARAM() {
        return this.GetParamStringValue(TAG_SERVICEPARAM, "");
    }

    public final void setSERVICEPARAM(String strValue) {
        this.SetParamValue(TAG_SERVICEPARAM, strValue);
    }

    public final boolean isSERVICEPARAM2Null() {
        return this.IsParamNull(TAG_SERVICEPARAM2);
    }

    public final String getSERVICEPARAM2() {
        return this.GetParamStringValue(TAG_SERVICEPARAM2, "");
    }

    public final void setSERVICEPARAM2(String strValue) {
        this.SetParamValue(TAG_SERVICEPARAM2, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isAIPLATFORMTYPENull() {
        return this.IsParamNull(TAG_AIPLATFORMTYPE);
    }

    public final String getAIPLATFORMTYPE() {
        return this.GetParamStringValue(TAG_AIPLATFORMTYPE, "");
    }

    public final void setAIPLATFORMTYPE(String strValue) {
        this.SetParamValue(TAG_AIPLATFORMTYPE, strValue);
    }
}

