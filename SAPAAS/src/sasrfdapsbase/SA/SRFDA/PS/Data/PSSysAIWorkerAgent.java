/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysAIWorkerAgent
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
    public static final String TAG_PSSYSAIWORKERAGENTID = "PSSYSAIWORKERAGENTID";
    public static final String TAG_PSSYSAIWORKERAGENTNAME = "PSSYSAIWORKERAGENTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAIFACTORYID = "PSSYSAIFACTORYID";
    public static final String TAG_PSSYSAIFACTORYNAME = "PSSYSAIFACTORYNAME";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_AIWORKERAGENTTAG2 = "AIWORKERAGENTTAG2";
    public static final String TAG_AIWORKERAGENTTAG = "AIWORKERAGENTTAG";
    public static final String TAG_AIWORKERAGENTTYPE = "AIWORKERAGENTTYPE";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_AIWORKERAGENTPARAMS = "AIWORKERAGENTPARAMS";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_AIPLATFORMTYPE = "AIPLATFORMTYPE";

    public final boolean isPSSYSAIWORKERAGENTIDNull() {
        return this.IsParamNull(TAG_PSSYSAIWORKERAGENTID);
    }

    public final String getPSSYSAIWORKERAGENTID() {
        return this.GetParamStringValue(TAG_PSSYSAIWORKERAGENTID, "");
    }

    public final void setPSSYSAIWORKERAGENTID(String strValue) {
        this.SetParamValue(TAG_PSSYSAIWORKERAGENTID, strValue);
    }

    public final boolean isPSSYSAIWORKERAGENTNAMENull() {
        return this.IsParamNull(TAG_PSSYSAIWORKERAGENTNAME);
    }

    public final String getPSSYSAIWORKERAGENTNAME() {
        return this.GetParamStringValue(TAG_PSSYSAIWORKERAGENTNAME, "");
    }

    public final void setPSSYSAIWORKERAGENTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAIWORKERAGENTNAME, strValue);
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

    public final boolean isAIWORKERAGENTTAG2Null() {
        return this.IsParamNull(TAG_AIWORKERAGENTTAG2);
    }

    public final String getAIWORKERAGENTTAG2() {
        return this.GetParamStringValue(TAG_AIWORKERAGENTTAG2, "");
    }

    public final void setAIWORKERAGENTTAG2(String strValue) {
        this.SetParamValue(TAG_AIWORKERAGENTTAG2, strValue);
    }

    public final boolean isAIWORKERAGENTTAGNull() {
        return this.IsParamNull(TAG_AIWORKERAGENTTAG);
    }

    public final String getAIWORKERAGENTTAG() {
        return this.GetParamStringValue(TAG_AIWORKERAGENTTAG, "");
    }

    public final void setAIWORKERAGENTTAG(String strValue) {
        this.SetParamValue(TAG_AIWORKERAGENTTAG, strValue);
    }

    public final boolean isAIWORKERAGENTTYPENull() {
        return this.IsParamNull(TAG_AIWORKERAGENTTYPE);
    }

    public final String getAIWORKERAGENTTYPE() {
        return this.GetParamStringValue(TAG_AIWORKERAGENTTYPE, "");
    }

    public final void setAIWORKERAGENTTYPE(String strValue) {
        this.SetParamValue(TAG_AIWORKERAGENTTYPE, strValue);
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

    public final boolean isAIWORKERAGENTPARAMSNull() {
        return this.IsParamNull(TAG_AIWORKERAGENTPARAMS);
    }

    public final String getAIWORKERAGENTPARAMS() {
        return this.GetParamStringValue(TAG_AIWORKERAGENTPARAMS, "");
    }

    public final void setAIWORKERAGENTPARAMS(String strValue) {
        this.SetParamValue(TAG_AIWORKERAGENTPARAMS, strValue);
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

    public final boolean isPSDELOGICIDNull() {
        return this.IsParamNull(TAG_PSDELOGICID);
    }

    public final String getPSDELOGICID() {
        return this.GetParamStringValue(TAG_PSDELOGICID, "");
    }

    public final void setPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_PSDELOGICID, strValue);
    }

    public final boolean isPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_PSDELOGICNAME);
    }

    public final String getPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_PSDELOGICNAME, "");
    }

    public final void setPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSDELOGICNAME, strValue);
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

