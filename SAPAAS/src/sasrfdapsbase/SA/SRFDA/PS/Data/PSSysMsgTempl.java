/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysMsgTempl
extends BaseDataEntity {
    public static final String CONTENTTYPE_TEXT = "TEXT";
    public static final String CONTENTTYPE_HTML = "HTML";
    public static final String TAG_PSSYSMSGTEMPLID = "PSSYSMSGTEMPLID";
    public static final String TAG_PSSYSMSGTEMPLNAME = "PSSYSMSGTEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_CONTENTTYPE = "CONTENTTYPE";
    public static final String TAG_IMCONTENT = "IMCONTENT";
    public static final String TAG_MAILGROUPSEND = "MAILGROUPSEND";
    public static final String TAG_SMSCONTENT = "SMSCONTENT";
    public static final String TAG_SUBJECT = "SUBJECT";
    public static final String TAG_WCCONTENT = "WCCONTENT";
    public static final String TAG_CONTENTPSLANRESID = "CONTENTPSLANRESID";
    public static final String TAG_CONTENTPSLANRESNAME = "CONTENTPSLANRESNAME";
    public static final String TAG_SMSPSLANRESID = "SMSPSLANRESID";
    public static final String TAG_SMSPSLANRESNAME = "SMSPSLANRESNAME";
    public static final String TAG_IMPSLANRESID = "IMPSLANRESID";
    public static final String TAG_IMPSLANRESNAME = "IMPSLANRESNAME";
    public static final String TAG_SUBPSLANRESID = "SUBPSLANRESID";
    public static final String TAG_SUBPSLANRESNAME = "SUBPSLANRESNAME";
    public static final String TAG_WXPSLANRESID = "WXPSLANRESID";
    public static final String TAG_WXPSLANRESNAME = "WXPSLANRESNAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_LOCKFLAG = "LOCKFLAG";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_DDCONTENT = "DDCONTENT";
    public static final String TAG_DDPSLANRESID = "DDPSLANRESID";
    public static final String TAG_DDPSLANRESNAME = "DDPSLANRESNAME";
    public static final String TAG_TASKURL = "TASKURL";
    public static final String TAG_MOBTASKURL = "MOBTASKURL";
    public static final String TAG_TEMPLENGINE = "TEMPLENGINE";
    public static final String TAG_MSGTEMPLTYPE = "MSGTEMPLTYPE";
    public static final String TAG_MSGTEMPLTAG = "MSGTEMPLTAG";
    public static final String TAG_MSGTEMPLTAG2 = "MSGTEMPLTAG2";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDEDSID = "PSDEDSID";
    public static final String TAG_PSDEDSNAME = "PSDEDSNAME";
    public static final String TAG_SUBJECTPSDEFID = "SUBJECTPSDEFID";
    public static final String TAG_SUBJECTPSDEFNAME = "SUBJECTPSDEFNAME";
    public static final String TAG_CONTENTPSDEFID = "CONTENTPSDEFID";
    public static final String TAG_CONTENTPSDEFNAME = "CONTENTPSDEFNAME";
    public static final String TAG_TEMPLTAGPSDEFID = "TEMPLTAGPSDEFID";
    public static final String TAG_TEMPLTAGPSDEFNAME = "TEMPLTAGPSDEFNAME";
    public static final String TAG_USERPSDEFID = "USERPSDEFID";
    public static final String TAG_USERPSDEFNAME = "USERPSDEFNAME";
    public static final String TAG_USER2PSDEFID = "USER2PSDEFID";
    public static final String TAG_USER2PSDEFNAME = "USER2PSDEFNAME";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_MSGTEMPLPARAMS = "MSGTEMPLPARAMS";
    public static final String TAG_CONTENTTYPEPSDEFID = "CONTENTTYPEPSDEFID";
    public static final String TAG_CONTENTTYPEPSDEFNAME = "CONTENTTYPEPSDEFNAME";
    public static final String TAG_TASKURLPSDEFID = "TASKURLPSDEFID";
    public static final String TAG_TASKURLPSDEFNAME = "TASKURLPSDEFNAME";
    public static final String TAG_MOBTASKURLPSDEFID = "MOBTASKURLPSDEFID";
    public static final String TAG_MOBTASKURLPSDEFNAME = "MOBTASKURLPSDEFNAME";
    public static final String TAG_LANPSDEFID = "LANPSDEFID";
    public static final String TAG_LANPSDEFNAME = "LANPSDEFNAME";
    public static final String TAG_SMSCONTENTPSDEFID = "SMSCONTENTPSDEFID";
    public static final String TAG_SMSCONTENTPSDEFNAME = "SMSCONTENTPSDEFNAME";
    public static final String TAG_IMCONTENTPSDEFID = "IMCONTENTPSDEFID";
    public static final String TAG_IMCONTENTPSDEFNAME = "IMCONTENTPSDEFNAME";
    public static final String TAG_WCCONTENTPSDEFID = "WCCONTENTPSDEFID";
    public static final String TAG_WCCONTENTPSDEFNAME = "WCCONTENTPSDEFNAME";
    public static final String TAG_DDCONTENTPSDEFID = "DDCONTENTPSDEFID";
    public static final String TAG_DDCONTENTPSDEFNAME = "DDCONTENTPSDEFNAME";

    public final boolean isPSSYSMSGTEMPLIDNull() {
        return this.IsParamNull(TAG_PSSYSMSGTEMPLID);
    }

    public final String getPSSYSMSGTEMPLID() {
        return this.GetParamStringValue(TAG_PSSYSMSGTEMPLID, "");
    }

    public final void setPSSYSMSGTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSSYSMSGTEMPLID, strValue);
    }

    public final boolean isPSSYSMSGTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSSYSMSGTEMPLNAME);
    }

    public final String getPSSYSMSGTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSSYSMSGTEMPLNAME, "");
    }

    public final void setPSSYSMSGTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMSGTEMPLNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
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

    public final boolean isCONTENTTYPENull() {
        return this.IsParamNull(TAG_CONTENTTYPE);
    }

    public final String getCONTENTTYPE() {
        return this.GetParamStringValue(TAG_CONTENTTYPE, "");
    }

    public final void setCONTENTTYPE(String strValue) {
        this.SetParamValue(TAG_CONTENTTYPE, strValue);
    }

    public final boolean isIMCONTENTNull() {
        return this.IsParamNull(TAG_IMCONTENT);
    }

    public final String getIMCONTENT() {
        return this.GetParamStringValue(TAG_IMCONTENT, "");
    }

    public final void setIMCONTENT(String strValue) {
        this.SetParamValue(TAG_IMCONTENT, strValue);
    }

    public final boolean isMAILGROUPSENDNull() {
        return this.IsParamNull(TAG_MAILGROUPSEND);
    }

    public final boolean getMAILGROUPSEND() {
        return this.GetParamIntValue(TAG_MAILGROUPSEND, 0) == 1;
    }

    public final void setMAILGROUPSEND(boolean bValue) {
        this.SetParamValue(TAG_MAILGROUPSEND, bValue ? 1 : 0);
    }

    public final boolean isSMSCONTENTNull() {
        return this.IsParamNull(TAG_SMSCONTENT);
    }

    public final String getSMSCONTENT() {
        return this.GetParamStringValue(TAG_SMSCONTENT, "");
    }

    public final void setSMSCONTENT(String strValue) {
        this.SetParamValue(TAG_SMSCONTENT, strValue);
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

    public final boolean isWCCONTENTNull() {
        return this.IsParamNull(TAG_WCCONTENT);
    }

    public final String getWCCONTENT() {
        return this.GetParamStringValue(TAG_WCCONTENT, "");
    }

    public final void setWCCONTENT(String strValue) {
        this.SetParamValue(TAG_WCCONTENT, strValue);
    }

    public final boolean isCONTENTPSLANRESIDNull() {
        return this.IsParamNull(TAG_CONTENTPSLANRESID);
    }

    public final String getCONTENTPSLANRESID() {
        return this.GetParamStringValue(TAG_CONTENTPSLANRESID, "");
    }

    public final void setCONTENTPSLANRESID(String strValue) {
        this.SetParamValue(TAG_CONTENTPSLANRESID, strValue);
    }

    public final boolean isCONTENTPSLANRESNAMENull() {
        return this.IsParamNull(TAG_CONTENTPSLANRESNAME);
    }

    public final String getCONTENTPSLANRESNAME() {
        return this.GetParamStringValue(TAG_CONTENTPSLANRESNAME, "");
    }

    public final void setCONTENTPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_CONTENTPSLANRESNAME, strValue);
    }

    public final boolean isSMSPSLANRESIDNull() {
        return this.IsParamNull(TAG_SMSPSLANRESID);
    }

    public final String getSMSPSLANRESID() {
        return this.GetParamStringValue(TAG_SMSPSLANRESID, "");
    }

    public final void setSMSPSLANRESID(String strValue) {
        this.SetParamValue(TAG_SMSPSLANRESID, strValue);
    }

    public final boolean isSMSPSLANRESNAMENull() {
        return this.IsParamNull(TAG_SMSPSLANRESNAME);
    }

    public final String getSMSPSLANRESNAME() {
        return this.GetParamStringValue(TAG_SMSPSLANRESNAME, "");
    }

    public final void setSMSPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_SMSPSLANRESNAME, strValue);
    }

    public final boolean isIMPSLANRESIDNull() {
        return this.IsParamNull(TAG_IMPSLANRESID);
    }

    public final String getIMPSLANRESID() {
        return this.GetParamStringValue(TAG_IMPSLANRESID, "");
    }

    public final void setIMPSLANRESID(String strValue) {
        this.SetParamValue(TAG_IMPSLANRESID, strValue);
    }

    public final boolean isIMPSLANRESNAMENull() {
        return this.IsParamNull(TAG_IMPSLANRESNAME);
    }

    public final String getIMPSLANRESNAME() {
        return this.GetParamStringValue(TAG_IMPSLANRESNAME, "");
    }

    public final void setIMPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_IMPSLANRESNAME, strValue);
    }

    public final boolean isSUBPSLANRESIDNull() {
        return this.IsParamNull(TAG_SUBPSLANRESID);
    }

    public final String getSUBPSLANRESID() {
        return this.GetParamStringValue(TAG_SUBPSLANRESID, "");
    }

    public final void setSUBPSLANRESID(String strValue) {
        this.SetParamValue(TAG_SUBPSLANRESID, strValue);
    }

    public final boolean isSUBPSLANRESNAMENull() {
        return this.IsParamNull(TAG_SUBPSLANRESNAME);
    }

    public final String getSUBPSLANRESNAME() {
        return this.GetParamStringValue(TAG_SUBPSLANRESNAME, "");
    }

    public final void setSUBPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_SUBPSLANRESNAME, strValue);
    }

    public final boolean isWXPSLANRESIDNull() {
        return this.IsParamNull(TAG_WXPSLANRESID);
    }

    public final String getWXPSLANRESID() {
        return this.GetParamStringValue(TAG_WXPSLANRESID, "");
    }

    public final void setWXPSLANRESID(String strValue) {
        this.SetParamValue(TAG_WXPSLANRESID, strValue);
    }

    public final boolean isWXPSLANRESNAMENull() {
        return this.IsParamNull(TAG_WXPSLANRESNAME);
    }

    public final String getWXPSLANRESNAME() {
        return this.GetParamStringValue(TAG_WXPSLANRESNAME, "");
    }

    public final void setWXPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_WXPSLANRESNAME, strValue);
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

    public final boolean isDDCONTENTNull() {
        return this.IsParamNull(TAG_DDCONTENT);
    }

    public final String getDDCONTENT() {
        return this.GetParamStringValue(TAG_DDCONTENT, "");
    }

    public final void setDDCONTENT(String strValue) {
        this.SetParamValue(TAG_DDCONTENT, strValue);
    }

    public final boolean isDDPSLANRESIDNull() {
        return this.IsParamNull(TAG_DDPSLANRESID);
    }

    public final String getDDPSLANRESID() {
        return this.GetParamStringValue(TAG_DDPSLANRESID, "");
    }

    public final void setDDPSLANRESID(String strValue) {
        this.SetParamValue(TAG_DDPSLANRESID, strValue);
    }

    public final boolean isDDPSLANRESNAMENull() {
        return this.IsParamNull(TAG_DDPSLANRESNAME);
    }

    public final String getDDPSLANRESNAME() {
        return this.GetParamStringValue(TAG_DDPSLANRESNAME, "");
    }

    public final void setDDPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_DDPSLANRESNAME, strValue);
    }

    public final boolean isTASKURLNull() {
        return this.IsParamNull(TAG_TASKURL);
    }

    public final String getTASKURL() {
        return this.GetParamStringValue(TAG_TASKURL, "");
    }

    public final void setTASKURL(String strValue) {
        this.SetParamValue(TAG_TASKURL, strValue);
    }

    public final boolean isMOBTASKURLNull() {
        return this.IsParamNull(TAG_MOBTASKURL);
    }

    public final String getMOBTASKURL() {
        return this.GetParamStringValue(TAG_MOBTASKURL, "");
    }

    public final void setMOBTASKURL(String strValue) {
        this.SetParamValue(TAG_MOBTASKURL, strValue);
    }

    public final boolean isTEMPLENGINENull() {
        return this.IsParamNull(TAG_TEMPLENGINE);
    }

    public final String getTEMPLENGINE() {
        return this.GetParamStringValue(TAG_TEMPLENGINE, "");
    }

    public final void setTEMPLENGINE(String strValue) {
        this.SetParamValue(TAG_TEMPLENGINE, strValue);
    }

    public final boolean isMSGTEMPLTYPENull() {
        return this.IsParamNull(TAG_MSGTEMPLTYPE);
    }

    public final String getMSGTEMPLTYPE() {
        return this.GetParamStringValue(TAG_MSGTEMPLTYPE, "");
    }

    public final void setMSGTEMPLTYPE(String strValue) {
        this.SetParamValue(TAG_MSGTEMPLTYPE, strValue);
    }

    public final boolean isMSGTEMPLTAGNull() {
        return this.IsParamNull(TAG_MSGTEMPLTAG);
    }

    public final String getMSGTEMPLTAG() {
        return this.GetParamStringValue(TAG_MSGTEMPLTAG, "");
    }

    public final void setMSGTEMPLTAG(String strValue) {
        this.SetParamValue(TAG_MSGTEMPLTAG, strValue);
    }

    public final boolean isMSGTEMPLTAG2Null() {
        return this.IsParamNull(TAG_MSGTEMPLTAG2);
    }

    public final String getMSGTEMPLTAG2() {
        return this.GetParamStringValue(TAG_MSGTEMPLTAG2, "");
    }

    public final void setMSGTEMPLTAG2(String strValue) {
        this.SetParamValue(TAG_MSGTEMPLTAG2, strValue);
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

    public final boolean isPSDEDSIDNull() {
        return this.IsParamNull(TAG_PSDEDSID);
    }

    public final String getPSDEDSID() {
        return this.GetParamStringValue(TAG_PSDEDSID, "");
    }

    public final void setPSDEDSID(String strValue) {
        this.SetParamValue(TAG_PSDEDSID, strValue);
    }

    public final boolean isPSDEDSNAMENull() {
        return this.IsParamNull(TAG_PSDEDSNAME);
    }

    public final String getPSDEDSNAME() {
        return this.GetParamStringValue(TAG_PSDEDSNAME, "");
    }

    public final void setPSDEDSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDSNAME, strValue);
    }

    public final boolean isSUBJECTPSDEFIDNull() {
        return this.IsParamNull(TAG_SUBJECTPSDEFID);
    }

    public final String getSUBJECTPSDEFID() {
        return this.GetParamStringValue(TAG_SUBJECTPSDEFID, "");
    }

    public final void setSUBJECTPSDEFID(String strValue) {
        this.SetParamValue(TAG_SUBJECTPSDEFID, strValue);
    }

    public final boolean isSUBJECTPSDEFNAMENull() {
        return this.IsParamNull(TAG_SUBJECTPSDEFNAME);
    }

    public final String getSUBJECTPSDEFNAME() {
        return this.GetParamStringValue(TAG_SUBJECTPSDEFNAME, "");
    }

    public final void setSUBJECTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_SUBJECTPSDEFNAME, strValue);
    }

    public final boolean isCONTENTPSDEFIDNull() {
        return this.IsParamNull(TAG_CONTENTPSDEFID);
    }

    public final String getCONTENTPSDEFID() {
        return this.GetParamStringValue(TAG_CONTENTPSDEFID, "");
    }

    public final void setCONTENTPSDEFID(String strValue) {
        this.SetParamValue(TAG_CONTENTPSDEFID, strValue);
    }

    public final boolean isCONTENTPSDEFNAMENull() {
        return this.IsParamNull(TAG_CONTENTPSDEFNAME);
    }

    public final String getCONTENTPSDEFNAME() {
        return this.GetParamStringValue(TAG_CONTENTPSDEFNAME, "");
    }

    public final void setCONTENTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_CONTENTPSDEFNAME, strValue);
    }

    public final boolean isTEMPLTAGPSDEFIDNull() {
        return this.IsParamNull(TAG_TEMPLTAGPSDEFID);
    }

    public final String getTEMPLTAGPSDEFID() {
        return this.GetParamStringValue(TAG_TEMPLTAGPSDEFID, "");
    }

    public final void setTEMPLTAGPSDEFID(String strValue) {
        this.SetParamValue(TAG_TEMPLTAGPSDEFID, strValue);
    }

    public final boolean isTEMPLTAGPSDEFNAMENull() {
        return this.IsParamNull(TAG_TEMPLTAGPSDEFNAME);
    }

    public final String getTEMPLTAGPSDEFNAME() {
        return this.GetParamStringValue(TAG_TEMPLTAGPSDEFNAME, "");
    }

    public final void setTEMPLTAGPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TEMPLTAGPSDEFNAME, strValue);
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

    public final int getCUSTOMMODE() {
        return this.GetParamIntValue(TAG_CUSTOMMODE, 0);
    }

    public final void setCUSTOMMODE(int bValue) {
        this.SetParamValue(TAG_CUSTOMMODE, bValue);
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

    public final boolean isMSGTEMPLPARAMSNull() {
        return this.IsParamNull(TAG_MSGTEMPLPARAMS);
    }

    public final String getMSGTEMPLPARAMS() {
        return this.GetParamStringValue(TAG_MSGTEMPLPARAMS, "");
    }

    public final void setMSGTEMPLPARAMS(String strValue) {
        this.SetParamValue(TAG_MSGTEMPLPARAMS, strValue);
    }

    public final boolean isCONTENTTYPEPSDEFIDNull() {
        return this.IsParamNull(TAG_CONTENTTYPEPSDEFID);
    }

    public final String getCONTENTTYPEPSDEFID() {
        return this.GetParamStringValue(TAG_CONTENTTYPEPSDEFID, "");
    }

    public final void setCONTENTTYPEPSDEFID(String strValue) {
        this.SetParamValue(TAG_CONTENTTYPEPSDEFID, strValue);
    }

    public final boolean isCONTENTTYPEPSDEFNAMENull() {
        return this.IsParamNull(TAG_CONTENTTYPEPSDEFNAME);
    }

    public final String getCONTENTTYPEPSDEFNAME() {
        return this.GetParamStringValue(TAG_CONTENTTYPEPSDEFNAME, "");
    }

    public final void setCONTENTTYPEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_CONTENTTYPEPSDEFNAME, strValue);
    }

    public final boolean isTASKURLPSDEFIDNull() {
        return this.IsParamNull(TAG_TASKURLPSDEFID);
    }

    public final String getTASKURLPSDEFID() {
        return this.GetParamStringValue(TAG_TASKURLPSDEFID, "");
    }

    public final void setTASKURLPSDEFID(String strValue) {
        this.SetParamValue(TAG_TASKURLPSDEFID, strValue);
    }

    public final boolean isTASKURLPSDEFNAMENull() {
        return this.IsParamNull(TAG_TASKURLPSDEFNAME);
    }

    public final String getTASKURLPSDEFNAME() {
        return this.GetParamStringValue(TAG_TASKURLPSDEFNAME, "");
    }

    public final void setTASKURLPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TASKURLPSDEFNAME, strValue);
    }

    public final boolean isMOBTASKURLPSDEFIDNull() {
        return this.IsParamNull(TAG_MOBTASKURLPSDEFID);
    }

    public final String getMOBTASKURLPSDEFID() {
        return this.GetParamStringValue(TAG_MOBTASKURLPSDEFID, "");
    }

    public final void setMOBTASKURLPSDEFID(String strValue) {
        this.SetParamValue(TAG_MOBTASKURLPSDEFID, strValue);
    }

    public final boolean isMOBTASKURLPSDEFNAMENull() {
        return this.IsParamNull(TAG_MOBTASKURLPSDEFNAME);
    }

    public final String getMOBTASKURLPSDEFNAME() {
        return this.GetParamStringValue(TAG_MOBTASKURLPSDEFNAME, "");
    }

    public final void setMOBTASKURLPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_MOBTASKURLPSDEFNAME, strValue);
    }

    public final boolean isLANPSDEFIDNull() {
        return this.IsParamNull(TAG_LANPSDEFID);
    }

    public final String getLANPSDEFID() {
        return this.GetParamStringValue(TAG_LANPSDEFID, "");
    }

    public final void setLANPSDEFID(String strValue) {
        this.SetParamValue(TAG_LANPSDEFID, strValue);
    }

    public final boolean isLANPSDEFNAMENull() {
        return this.IsParamNull(TAG_LANPSDEFNAME);
    }

    public final String getLANPSDEFNAME() {
        return this.GetParamStringValue(TAG_LANPSDEFNAME, "");
    }

    public final void setLANPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_LANPSDEFNAME, strValue);
    }

    public final boolean isSMSCONTENTPSDEFIDNull() {
        return this.IsParamNull(TAG_SMSCONTENTPSDEFID);
    }

    public final String getSMSCONTENTPSDEFID() {
        return this.GetParamStringValue(TAG_SMSCONTENTPSDEFID, "");
    }

    public final void setSMSCONTENTPSDEFID(String strValue) {
        this.SetParamValue(TAG_SMSCONTENTPSDEFID, strValue);
    }

    public final boolean isSMSCONTENTPSDEFNAMENull() {
        return this.IsParamNull(TAG_SMSCONTENTPSDEFNAME);
    }

    public final String getSMSCONTENTPSDEFNAME() {
        return this.GetParamStringValue(TAG_SMSCONTENTPSDEFNAME, "");
    }

    public final void setSMSCONTENTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_SMSCONTENTPSDEFNAME, strValue);
    }

    public final boolean isIMCONTENTPSDEFIDNull() {
        return this.IsParamNull(TAG_IMCONTENTPSDEFID);
    }

    public final String getIMCONTENTPSDEFID() {
        return this.GetParamStringValue(TAG_IMCONTENTPSDEFID, "");
    }

    public final void setIMCONTENTPSDEFID(String strValue) {
        this.SetParamValue(TAG_IMCONTENTPSDEFID, strValue);
    }

    public final boolean isIMCONTENTPSDEFNAMENull() {
        return this.IsParamNull(TAG_IMCONTENTPSDEFNAME);
    }

    public final String getIMCONTENTPSDEFNAME() {
        return this.GetParamStringValue(TAG_IMCONTENTPSDEFNAME, "");
    }

    public final void setIMCONTENTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_IMCONTENTPSDEFNAME, strValue);
    }

    public final boolean isWCCONTENTPSDEFIDNull() {
        return this.IsParamNull(TAG_WCCONTENTPSDEFID);
    }

    public final String getWCCONTENTPSDEFID() {
        return this.GetParamStringValue(TAG_WCCONTENTPSDEFID, "");
    }

    public final void setWCCONTENTPSDEFID(String strValue) {
        this.SetParamValue(TAG_WCCONTENTPSDEFID, strValue);
    }

    public final boolean isWCCONTENTPSDEFNAMENull() {
        return this.IsParamNull(TAG_WCCONTENTPSDEFNAME);
    }

    public final String getWCCONTENTPSDEFNAME() {
        return this.GetParamStringValue(TAG_WCCONTENTPSDEFNAME, "");
    }

    public final void setWCCONTENTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_WCCONTENTPSDEFNAME, strValue);
    }

    public final boolean isDDCONTENTPSDEFIDNull() {
        return this.IsParamNull(TAG_DDCONTENTPSDEFID);
    }

    public final String getDDCONTENTPSDEFID() {
        return this.GetParamStringValue(TAG_DDCONTENTPSDEFID, "");
    }

    public final void setDDCONTENTPSDEFID(String strValue) {
        this.SetParamValue(TAG_DDCONTENTPSDEFID, strValue);
    }

    public final boolean isDDCONTENTPSDEFNAMENull() {
        return this.IsParamNull(TAG_DDCONTENTPSDEFNAME);
    }

    public final String getDDCONTENTPSDEFNAME() {
        return this.GetParamStringValue(TAG_DDCONTENTPSDEFNAME, "");
    }

    public final void setDDCONTENTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_DDCONTENTPSDEFNAME, strValue);
    }
}

