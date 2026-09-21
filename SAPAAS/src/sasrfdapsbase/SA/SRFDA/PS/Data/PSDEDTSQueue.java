/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEDTSQueue
extends BaseDataEntity {
    public static final String TAG_PSDEDTSQUEUEID = "PSDEDTSQUEUEID";
    public static final String TAG_PSDEDTSQUEUENAME = "PSDEDTSQUEUENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_HISTORYPSDEID = "HISTORYPSDEID";
    public static final String TAG_HISTORYPSDENAME = "HISTORYPSDENAME";
    public static final String TAG_CANCELPSDEACTIONID = "CANCELPSDEACTIONID";
    public static final String TAG_CANCELPSDEACTIONNAME = "CANCELPSDEACTIONNAME";
    public static final String TAG_STATEPSDEFID = "STATEPSDEFID";
    public static final String TAG_STATEPSDEFNAME = "STATEPSDEFNAME";
    public static final String TAG_TIMEPSDEFID = "TIMEPSDEFID";
    public static final String TAG_TIMEPSDEFNAME = "TIMEPSDEFNAME";
    public static final String TAG_ERRORPSDEFID = "ERRORPSDEFID";
    public static final String TAG_ERRORPSDEFNAME = "ERRORPSDEFNAME";
    public static final String TAG_FINISHPSDEACTIONID = "FINISHPSDEACTIONID";
    public static final String TAG_FINISHPSDEACTIONNAME = "FINISHPSDEACTIONNAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_PUSHPSDEACTIONID = "PUSHPSDEACTIONID";
    public static final String TAG_PUSHPSDEACTIONNAME = "PUSHPSDEACTIONNAME";
    public static final String TAG_REFRESHPSDEACTIONID = "REFRESHPSDEACTIONID";
    public static final String TAG_REFRESHPSDEACTIONNAME = "REFRESHPSDEACTIONNAME";
    public static final String TAG_CANCELTIMEOUT = "CANCELTIMEOUT";
    public static final String TAG_REFRESHTIMER = "REFRESHTIMER";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_QUEUEPARAMS = "QUEUEPARAMS";

    public final boolean isPSDEDTSQUEUEIDNull() {
        return this.IsParamNull(TAG_PSDEDTSQUEUEID);
    }

    public final String getPSDEDTSQUEUEID() {
        return this.GetParamStringValue(TAG_PSDEDTSQUEUEID, "");
    }

    public final void setPSDEDTSQUEUEID(String strValue) {
        this.SetParamValue(TAG_PSDEDTSQUEUEID, strValue);
    }

    public final boolean isPSDEDTSQUEUENAMENull() {
        return this.IsParamNull(TAG_PSDEDTSQUEUENAME);
    }

    public final String getPSDEDTSQUEUENAME() {
        return this.GetParamStringValue(TAG_PSDEDTSQUEUENAME, "");
    }

    public final void setPSDEDTSQUEUENAME(String strValue) {
        this.SetParamValue(TAG_PSDEDTSQUEUENAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isHISTORYPSDEIDNull() {
        return this.IsParamNull(TAG_HISTORYPSDEID);
    }

    public final String getHISTORYPSDEID() {
        return this.GetParamStringValue(TAG_HISTORYPSDEID, "");
    }

    public final void setHISTORYPSDEID(String strValue) {
        this.SetParamValue(TAG_HISTORYPSDEID, strValue);
    }

    public final boolean isHISTORYPSDENAMENull() {
        return this.IsParamNull(TAG_HISTORYPSDENAME);
    }

    public final String getHISTORYPSDENAME() {
        return this.GetParamStringValue(TAG_HISTORYPSDENAME, "");
    }

    public final void setHISTORYPSDENAME(String strValue) {
        this.SetParamValue(TAG_HISTORYPSDENAME, strValue);
    }

    public final boolean isCANCELPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_CANCELPSDEACTIONID);
    }

    public final String getCANCELPSDEACTIONID() {
        return this.GetParamStringValue(TAG_CANCELPSDEACTIONID, "");
    }

    public final void setCANCELPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_CANCELPSDEACTIONID, strValue);
    }

    public final boolean isCANCELPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_CANCELPSDEACTIONNAME);
    }

    public final String getCANCELPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_CANCELPSDEACTIONNAME, "");
    }

    public final void setCANCELPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_CANCELPSDEACTIONNAME, strValue);
    }

    public final boolean isSTATEPSDEFIDNull() {
        return this.IsParamNull(TAG_STATEPSDEFID);
    }

    public final String getSTATEPSDEFID() {
        return this.GetParamStringValue(TAG_STATEPSDEFID, "");
    }

    public final void setSTATEPSDEFID(String strValue) {
        this.SetParamValue(TAG_STATEPSDEFID, strValue);
    }

    public final boolean isSTATEPSDEFNAMENull() {
        return this.IsParamNull(TAG_STATEPSDEFNAME);
    }

    public final String getSTATEPSDEFNAME() {
        return this.GetParamStringValue(TAG_STATEPSDEFNAME, "");
    }

    public final void setSTATEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_STATEPSDEFNAME, strValue);
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

    public final boolean isERRORPSDEFIDNull() {
        return this.IsParamNull(TAG_ERRORPSDEFID);
    }

    public final String getERRORPSDEFID() {
        return this.GetParamStringValue(TAG_ERRORPSDEFID, "");
    }

    public final void setERRORPSDEFID(String strValue) {
        this.SetParamValue(TAG_ERRORPSDEFID, strValue);
    }

    public final boolean isERRORPSDEFNAMENull() {
        return this.IsParamNull(TAG_ERRORPSDEFNAME);
    }

    public final String getERRORPSDEFNAME() {
        return this.GetParamStringValue(TAG_ERRORPSDEFNAME, "");
    }

    public final void setERRORPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_ERRORPSDEFNAME, strValue);
    }

    public final boolean isFINISHPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_FINISHPSDEACTIONID);
    }

    public final String getFINISHPSDEACTIONID() {
        return this.GetParamStringValue(TAG_FINISHPSDEACTIONID, "");
    }

    public final void setFINISHPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_FINISHPSDEACTIONID, strValue);
    }

    public final boolean isFINISHPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_FINISHPSDEACTIONNAME);
    }

    public final String getFINISHPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_FINISHPSDEACTIONNAME, "");
    }

    public final void setFINISHPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_FINISHPSDEACTIONNAME, strValue);
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

    public final boolean isPUSHPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_PUSHPSDEACTIONID);
    }

    public final String getPUSHPSDEACTIONID() {
        return this.GetParamStringValue(TAG_PUSHPSDEACTIONID, "");
    }

    public final void setPUSHPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_PUSHPSDEACTIONID, strValue);
    }

    public final boolean isPUSHPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_PUSHPSDEACTIONNAME);
    }

    public final String getPUSHPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_PUSHPSDEACTIONNAME, "");
    }

    public final void setPUSHPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PUSHPSDEACTIONNAME, strValue);
    }

    public final boolean isREFRESHPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_REFRESHPSDEACTIONID);
    }

    public final String getREFRESHPSDEACTIONID() {
        return this.GetParamStringValue(TAG_REFRESHPSDEACTIONID, "");
    }

    public final void setREFRESHPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_REFRESHPSDEACTIONID, strValue);
    }

    public final boolean isREFRESHPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_REFRESHPSDEACTIONNAME);
    }

    public final String getREFRESHPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_REFRESHPSDEACTIONNAME, "");
    }

    public final void setREFRESHPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_REFRESHPSDEACTIONNAME, strValue);
    }

    public final boolean isCANCELTIMEOUTNull() {
        return this.IsParamNull(TAG_CANCELTIMEOUT);
    }

    public final int getCANCELTIMEOUT() {
        return this.GetParamIntValue(TAG_CANCELTIMEOUT, 0);
    }

    public final void setCANCELTIMEOUT(int nValue) {
        this.SetParamValue(TAG_CANCELTIMEOUT, nValue);
    }

    public final boolean isREFRESHTIMERNull() {
        return this.IsParamNull(TAG_REFRESHTIMER);
    }

    public final int getREFRESHTIMER() {
        return this.GetParamIntValue(TAG_REFRESHTIMER, 0);
    }

    public final void setREFRESHTIMER(int nValue) {
        this.SetParamValue(TAG_REFRESHTIMER, nValue);
    }

    public final boolean isDEFAULTFLAGNull() {
        return this.IsParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
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

    public final boolean isQUEUEPARAMSNull() {
        return this.IsParamNull(TAG_QUEUEPARAMS);
    }

    public final String getQUEUEPARAMS() {
        return this.GetParamStringValue(TAG_QUEUEPARAMS, "");
    }

    public final void setQUEUEPARAMS(String strValue) {
        this.SetParamValue(TAG_QUEUEPARAMS, strValue);
    }
}

