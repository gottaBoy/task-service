/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDELogic
extends BaseDataEntity {
    public static final String LOGICTYPE_DELOGIC = "DELOGIC";
    public static final String LOGICTYPE_VIEWLOGIC = "VIEWLOGIC";
    public static final String LOGICTYPE_MAINSTATELOGIC = "MAINSTATELOGIC";
    public static final String LOGICTYPE_DATAFLOWLOGIC = "DATAFLOWLOGIC";
    public static final String LOGICSUBTYPE_NONE = "NONE";
    public static final String LOGICSUBTYPE_DEFIELD = "DEFIELD";
    public static final String LOGICSUBTYPE_USER = "USER";
    public static final String LOGICSUBTYPE_USER2 = "USER2";
    public static final String LOGICSUBTYPE_USER3 = "USER3";
    public static final String LOGICSUBTYPE_USER4 = "USER4";
    public static final String DEFLOGICMODE_COMPUTE = "COMPUTE";
    public static final String DEFLOGICMODE_DEFAULT = "DEFAULT";
    public static final String DEFLOGICMODE_ONCHANGE = "ONCHANGE";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_LOGICTYPE = "LOGICTYPE";
    public static final String TAG_EXTENDMODE = "EXTENDMODE";
    public static final String TAG_LOGICSUBTYPE = "LOGICSUBTYPE";
    public static final String TAG_DEFLOGICMODE = "DEFLOGICMODE";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_LOGICHOLDER = "LOGICHOLDER";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_LOGICSN = "LOGICSN";
    public static final String TAG_DEFAULTMSLOGIC = "DEFAULTMSLOGIC";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_DEBUGMODE = "DEBUGMODE";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_SCRIPTENGINE = "SCRIPTENGINE";
    public static final String TAG_LOGICTAG = "LOGICTAG";
    public static final String TAG_LOGICTAG2 = "LOGICTAG2";
    public static final String TAG_LOGICTAG3 = "LOGICTAG3";
    public static final String TAG_LOGICTAG4 = "LOGICTAG4";
    public static final String TAG_EVENTS = "EVENTS";
    public static final String TAG_THREADRUNMODE = "THREADRUNMODE";
    public static final String TAG_TIMERPOLICY = "TIMERPOLICY";
    public static final String TAG_TEMPLFLAG = "TEMPLFLAG";
    public static final String TAG_IGNOREEXCEPTION = "IGNOREEXCEPTION";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_EVENTMODEL = "EVENTMODEL";

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

    public final boolean isLOGICTYPENull() {
        return this.IsParamNull(TAG_LOGICTYPE);
    }

    public final String getLOGICTYPE() {
        return this.GetParamStringValue(TAG_LOGICTYPE, "");
    }

    public final void setLOGICTYPE(String strValue) {
        this.SetParamValue(TAG_LOGICTYPE, strValue);
    }

    public final boolean isEXTENDMODENull() {
        return this.IsParamNull(TAG_EXTENDMODE);
    }

    public final int getEXTENDMODE() {
        return this.GetParamIntValue(TAG_EXTENDMODE, 0);
    }

    public final void setEXTENDMODE(int nValue) {
        this.SetParamValue(TAG_EXTENDMODE, nValue);
    }

    public final boolean isLOGICSUBTYPENull() {
        return this.IsParamNull(TAG_LOGICSUBTYPE);
    }

    public final String getLOGICSUBTYPE() {
        return this.GetParamStringValue(TAG_LOGICSUBTYPE, "");
    }

    public final void setLOGICSUBTYPE(String strValue) {
        this.SetParamValue(TAG_LOGICSUBTYPE, strValue);
    }

    public final boolean isDEFLOGICMODENull() {
        return this.IsParamNull(TAG_DEFLOGICMODE);
    }

    public final String getDEFLOGICMODE() {
        return this.GetParamStringValue(TAG_DEFLOGICMODE, "");
    }

    public final void setDEFLOGICMODE(String strValue) {
        this.SetParamValue(TAG_DEFLOGICMODE, strValue);
    }

    public final boolean isPSDEFIDNull() {
        return this.IsParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.GetParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.SetParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.IsParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.GetParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFNAME, strValue);
    }

    public final boolean isLOGICHOLDERNull() {
        return this.IsParamNull(TAG_LOGICHOLDER);
    }

    public final int getLOGICHOLDER() {
        return this.GetParamIntValue(TAG_LOGICHOLDER, 0);
    }

    public final void setLOGICHOLDER(int nValue) {
        this.SetParamValue(TAG_LOGICHOLDER, nValue);
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

    public final boolean isCUSTOMCODENull() {
        return this.IsParamNull(TAG_CUSTOMCODE);
    }

    public final String getCUSTOMCODE() {
        return this.GetParamStringValue(TAG_CUSTOMCODE, "");
    }

    public final void setCUSTOMCODE(String strValue) {
        this.SetParamValue(TAG_CUSTOMCODE, strValue);
    }

    public final boolean isLOGICSNNull() {
        return this.IsParamNull(TAG_LOGICSN);
    }

    public final String getLOGICSN() {
        return this.GetParamStringValue(TAG_LOGICSN, "");
    }

    public final void setLOGICSN(String strValue) {
        this.SetParamValue(TAG_LOGICSN, strValue);
    }

    public final boolean isDEFAULTMSLOGICNull() {
        return this.IsParamNull(TAG_DEFAULTMSLOGIC);
    }

    public final boolean getDEFAULTMSLOGIC() {
        return this.GetParamIntValue(TAG_DEFAULTMSLOGIC, 0) == 1;
    }

    public final void setDEFAULTMSLOGIC(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTMSLOGIC, bValue ? 1 : 0);
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

    public final boolean isDEBUGMODENull() {
        return this.IsParamNull(TAG_DEBUGMODE);
    }

    public final int getDEBUGMODE() {
        return this.GetParamIntValue(TAG_DEBUGMODE, 0);
    }

    public final void setDEBUGMODE(int nValue) {
        this.SetParamValue(TAG_DEBUGMODE, nValue);
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

    public final boolean isSCRIPTENGINENull() {
        return this.IsParamNull(TAG_SCRIPTENGINE);
    }

    public final String getSCRIPTENGINE() {
        return this.GetParamStringValue(TAG_SCRIPTENGINE, "");
    }

    public final void setSCRIPTENGINE(String strValue) {
        this.SetParamValue(TAG_SCRIPTENGINE, strValue);
    }

    public final boolean isLOGICTAGNull() {
        return this.IsParamNull(TAG_LOGICTAG);
    }

    public final String getLOGICTAG() {
        return this.GetParamStringValue(TAG_LOGICTAG, "");
    }

    public final void setLOGICTAG(String strValue) {
        this.SetParamValue(TAG_LOGICTAG, strValue);
    }

    public final boolean isLOGICTAG2Null() {
        return this.IsParamNull(TAG_LOGICTAG2);
    }

    public final String getLOGICTAG2() {
        return this.GetParamStringValue(TAG_LOGICTAG2, "");
    }

    public final void setLOGICTAG2(String strValue) {
        this.SetParamValue(TAG_LOGICTAG2, strValue);
    }

    public final boolean isLOGICTAG3Null() {
        return this.IsParamNull(TAG_LOGICTAG3);
    }

    public final String getLOGICTAG3() {
        return this.GetParamStringValue(TAG_LOGICTAG3, "");
    }

    public final void setLOGICTAG3(String strValue) {
        this.SetParamValue(TAG_LOGICTAG3, strValue);
    }

    public final boolean isLOGICTAG4Null() {
        return this.IsParamNull(TAG_LOGICTAG4);
    }

    public final String getLOGICTAG4() {
        return this.GetParamStringValue(TAG_LOGICTAG4, "");
    }

    public final void setLOGICTAG4(String strValue) {
        this.SetParamValue(TAG_LOGICTAG4, strValue);
    }

    public final boolean isEVENTSNull() {
        return this.IsParamNull(TAG_EVENTS);
    }

    public final String getEVENTS() {
        return this.GetParamStringValue(TAG_EVENTS, "");
    }

    public final void setEVENTS(String strValue) {
        this.SetParamValue(TAG_EVENTS, strValue);
    }

    public final boolean isTHREADRUNMODENull() {
        return this.IsParamNull(TAG_THREADRUNMODE);
    }

    public final int getTHREADRUNMODE() {
        return this.GetParamIntValue(TAG_THREADRUNMODE, 0);
    }

    public final void setTHREADRUNMODE(int nValue) {
        this.SetParamValue(TAG_THREADRUNMODE, nValue);
    }

    public final boolean isTIMERPOLICYNull() {
        return this.IsParamNull(TAG_TIMERPOLICY);
    }

    public final String getTIMERPOLICY() {
        return this.GetParamStringValue(TAG_TIMERPOLICY, "");
    }

    public final void setTIMERPOLICY(String strValue) {
        this.SetParamValue(TAG_TIMERPOLICY, strValue);
    }

    public final boolean isTEMPLFLAGNull() {
        return this.IsParamNull(TAG_TEMPLFLAG);
    }

    public final boolean getTEMPLFLAG() {
        return this.GetParamIntValue(TAG_TEMPLFLAG, 0) == 1;
    }

    public final void setTEMPLFLAG(boolean bValue) {
        this.SetParamValue(TAG_TEMPLFLAG, bValue ? 1 : 0);
    }

    public final boolean isIGNOREEXCEPTIONNull() {
        return this.IsParamNull(TAG_IGNOREEXCEPTION);
    }

    public final boolean getIGNOREEXCEPTION() {
        return this.GetParamIntValue(TAG_IGNOREEXCEPTION, 0) == 1;
    }

    public final void setIGNOREEXCEPTION(boolean bValue) {
        this.SetParamValue(TAG_IGNOREEXCEPTION, bValue ? 1 : 0);
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

    public final boolean isEVENTMODELNull() {
        return this.IsParamNull(TAG_EVENTMODEL);
    }

    public final String getEVENTMODEL() {
        return this.GetParamStringValue(TAG_EVENTMODEL, "");
    }

    public final void setEVENTMODEL(String strValue) {
        this.SetParamValue(TAG_EVENTMODEL, strValue);
    }
}

