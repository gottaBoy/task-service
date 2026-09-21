/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysUniState
extends BaseDataEntity {
    public static final String UNISTATETYPE_DE = "DE";
    public static final String TAG_PSSYSUNISTATEID = "PSSYSUNISTATEID";
    public static final String TAG_PSSYSUNISTATENAME = "PSSYSUNISTATENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_UNIQUETAG = "UNIQUETAG";
    public static final String TAG_KEYPSDEFID = "KEYPSDEFID";
    public static final String TAG_KEYPSDEFNAME = "KEYPSDEFNAME";
    public static final String TAG_KEY2PSDEFID = "KEY2PSDEFID";
    public static final String TAG_KEY2PSDEFNAME = "KEY2PSDEFNAME";
    public static final String TAG_KEY3PSDEFID = "KEY3PSDEFID";
    public static final String TAG_KEY3PSDEFNAME = "KEY3PSDEFNAME";
    public static final String TAG_STATEPSDEFID = "STATEPSDEFID";
    public static final String TAG_STATEPSDEFNAME = "STATEPSDEFNAME";
    public static final String TAG_STATE2PSDEFID = "STATE2PSDEFID";
    public static final String TAG_STATE2PSDEFNAME = "STATE2PSDEFNAME";
    public static final String TAG_STATE3PSDEFID = "STATE3PSDEFID";
    public static final String TAG_STATE3PSDEFNAME = "STATE3PSDEFNAME";
    public static final String TAG_STATE4PSDEFID = "STATE4PSDEFID";
    public static final String TAG_STATE4PSDEFNAME = "STATE4PSDEFNAME";
    public static final String TAG_STATE5PSDEFID = "STATE5PSDEFID";
    public static final String TAG_STATE5PSDEFNAME = "STATE5PSDEFNAME";
    public static final String TAG_STATE6PSDEFID = "STATE6PSDEFID";
    public static final String TAG_STATE6PSDEFNAME = "STATE6PSDEFNAME";
    public static final String TAG_STATE7PSDEFID = "STATE7PSDEFID";
    public static final String TAG_STATE7PSDEFNAME = "STATE7PSDEFNAME";
    public static final String TAG_STATE8PSDEFID = "STATE8PSDEFID";
    public static final String TAG_STATE8PSDEFNAME = "STATE8PSDEFNAME";
    public static final String TAG_KEY4PSDEFID = "KEY4PSDEFID";
    public static final String TAG_KEY4PSDEFNAME = "KEY4PSDEFNAME";
    public static final String TAG_UNISTATETYPE = "UNISTATETYPE";
    public static final String TAG_DEDEFAULTFLAG = "DEDEFAULTFLAG";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_UNISTATEPARAMS = "UNISTATEPARAMS";
    public static final String TAG_UNISTATETAG = "UNISTATETAG";
    public static final String TAG_UNISTATETAG2 = "UNISTATETAG2";
    public static final String TAG_PSDEDATASETID = "PSDEDATASETID";
    public static final String TAG_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String TAG_INITPSDELOGICID = "INITPSDELOGICID";
    public static final String TAG_INITPSDELOGICNAME = "INITPSDELOGICNAME";
    public static final String TAG_ONCHANGEPSDELOGICID = "ONCHANGEPSDELOGICID";
    public static final String TAG_ONCHANGEPSDELOGICNAME = "ONCHANGEPSDELOGICNAME";
    public static final String TAG_RELOADTIMER = "RELOADTIMER";
    public static final String TAG_UNISTATEMODE = "UNISTATEMODE";
    public static final String TAG_ALLDATAFLAG = "ALLDATAFLAG";
    public static final String TAG_KEY5PSDEFID = "KEY5PSDEFID";
    public static final String TAG_KEY5PSDEFNAME = "KEY5PSDEFNAME";
    public static final String TAG_KEY6PSDEFID = "KEY6PSDEFID";
    public static final String TAG_KEY6PSDEFNAME = "KEY6PSDEFNAME";
    public static final String TAG_KEY7PSDEFID = "KEY7PSDEFID";
    public static final String TAG_KEY7PSDEFNAME = "KEY7PSDEFNAME";
    public static final String TAG_KEY8PSDEFID = "KEY8PSDEFID";
    public static final String TAG_KEY8PSDEFNAME = "KEY8PSDEFNAME";
    public static final String TAG_KEY9PSDEFID = "KEY9PSDEFID";
    public static final String TAG_KEY9PSDEFNAME = "KEY9PSDEFNAME";
    public static final String TAG_KEYFORMAT = "KEYFORMAT";
    public static final String TAG_MONITORFORMAT = "MONITORFORMAT";
    public static final String TAG_CACHECAT = "CACHECAT";
    public static final String TAG_CACHESCOPE = "CACHESCOPE";
    public static final String TAG_CACHETIMEOUT = "CACHETIMEOUT";
    public static final String TAG_ONDELETEPSDELOGICID = "ONDELETEPSDELOGICID";
    public static final String TAG_ONDELETEPSDELOGICNAME = "ONDELETEPSDELOGICNAME";
    public static final String TAG_DELETEASUPDATE = "DELETEASUPDATE";

    public final boolean isPSSYSUNISTATEIDNull() {
        return this.IsParamNull(TAG_PSSYSUNISTATEID);
    }

    public final String getPSSYSUNISTATEID() {
        return this.GetParamStringValue(TAG_PSSYSUNISTATEID, "");
    }

    public final void setPSSYSUNISTATEID(String strValue) {
        this.SetParamValue(TAG_PSSYSUNISTATEID, strValue);
    }

    public final boolean isPSSYSUNISTATENAMENull() {
        return this.IsParamNull(TAG_PSSYSUNISTATENAME);
    }

    public final String getPSSYSUNISTATENAME() {
        return this.GetParamStringValue(TAG_PSSYSUNISTATENAME, "");
    }

    public final void setPSSYSUNISTATENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUNISTATENAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isUNIQUETAGNull() {
        return this.IsParamNull(TAG_UNIQUETAG);
    }

    public final String getUNIQUETAG() {
        return this.GetParamStringValue(TAG_UNIQUETAG, "");
    }

    public final void setUNIQUETAG(String strValue) {
        this.SetParamValue(TAG_UNIQUETAG, strValue);
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

    public final boolean isKEY2PSDEFIDNull() {
        return this.IsParamNull(TAG_KEY2PSDEFID);
    }

    public final String getKEY2PSDEFID() {
        return this.GetParamStringValue(TAG_KEY2PSDEFID, "");
    }

    public final void setKEY2PSDEFID(String strValue) {
        this.SetParamValue(TAG_KEY2PSDEFID, strValue);
    }

    public final boolean isKEY2PSDEFNAMENull() {
        return this.IsParamNull(TAG_KEY2PSDEFNAME);
    }

    public final String getKEY2PSDEFNAME() {
        return this.GetParamStringValue(TAG_KEY2PSDEFNAME, "");
    }

    public final void setKEY2PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_KEY2PSDEFNAME, strValue);
    }

    public final boolean isKEY3PSDEFIDNull() {
        return this.IsParamNull(TAG_KEY3PSDEFID);
    }

    public final String getKEY3PSDEFID() {
        return this.GetParamStringValue(TAG_KEY3PSDEFID, "");
    }

    public final void setKEY3PSDEFID(String strValue) {
        this.SetParamValue(TAG_KEY3PSDEFID, strValue);
    }

    public final boolean isKEY3PSDEFNAMENull() {
        return this.IsParamNull(TAG_KEY3PSDEFNAME);
    }

    public final String getKEY3PSDEFNAME() {
        return this.GetParamStringValue(TAG_KEY3PSDEFNAME, "");
    }

    public final void setKEY3PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_KEY3PSDEFNAME, strValue);
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

    public final boolean isSTATE2PSDEFIDNull() {
        return this.IsParamNull(TAG_STATE2PSDEFID);
    }

    public final String getSTATE2PSDEFID() {
        return this.GetParamStringValue(TAG_STATE2PSDEFID, "");
    }

    public final void setSTATE2PSDEFID(String strValue) {
        this.SetParamValue(TAG_STATE2PSDEFID, strValue);
    }

    public final boolean isSTATE2PSDEFNAMENull() {
        return this.IsParamNull(TAG_STATE2PSDEFNAME);
    }

    public final String getSTATE2PSDEFNAME() {
        return this.GetParamStringValue(TAG_STATE2PSDEFNAME, "");
    }

    public final void setSTATE2PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_STATE2PSDEFNAME, strValue);
    }

    public final boolean isSTATE3PSDEFIDNull() {
        return this.IsParamNull(TAG_STATE3PSDEFID);
    }

    public final String getSTATE3PSDEFID() {
        return this.GetParamStringValue(TAG_STATE3PSDEFID, "");
    }

    public final void setSTATE3PSDEFID(String strValue) {
        this.SetParamValue(TAG_STATE3PSDEFID, strValue);
    }

    public final boolean isSTATE3PSDEFNAMENull() {
        return this.IsParamNull(TAG_STATE3PSDEFNAME);
    }

    public final String getSTATE3PSDEFNAME() {
        return this.GetParamStringValue(TAG_STATE3PSDEFNAME, "");
    }

    public final void setSTATE3PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_STATE3PSDEFNAME, strValue);
    }

    public final boolean isSTATE4PSDEFIDNull() {
        return this.IsParamNull(TAG_STATE4PSDEFID);
    }

    public final String getSTATE4PSDEFID() {
        return this.GetParamStringValue(TAG_STATE4PSDEFID, "");
    }

    public final void setSTATE4PSDEFID(String strValue) {
        this.SetParamValue(TAG_STATE4PSDEFID, strValue);
    }

    public final boolean isSTATE4PSDEFNAMENull() {
        return this.IsParamNull(TAG_STATE4PSDEFNAME);
    }

    public final String getSTATE4PSDEFNAME() {
        return this.GetParamStringValue(TAG_STATE4PSDEFNAME, "");
    }

    public final void setSTATE4PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_STATE4PSDEFNAME, strValue);
    }

    public final boolean isSTATE5PSDEFIDNull() {
        return this.IsParamNull(TAG_STATE5PSDEFID);
    }

    public final String getSTATE5PSDEFID() {
        return this.GetParamStringValue(TAG_STATE5PSDEFID, "");
    }

    public final void setSTATE5PSDEFID(String strValue) {
        this.SetParamValue(TAG_STATE5PSDEFID, strValue);
    }

    public final boolean isSTATE5PSDEFNAMENull() {
        return this.IsParamNull(TAG_STATE5PSDEFNAME);
    }

    public final String getSTATE5PSDEFNAME() {
        return this.GetParamStringValue(TAG_STATE5PSDEFNAME, "");
    }

    public final void setSTATE5PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_STATE5PSDEFNAME, strValue);
    }

    public final boolean isSTATE6PSDEFIDNull() {
        return this.IsParamNull(TAG_STATE6PSDEFID);
    }

    public final String getSTATE6PSDEFID() {
        return this.GetParamStringValue(TAG_STATE6PSDEFID, "");
    }

    public final void setSTATE6PSDEFID(String strValue) {
        this.SetParamValue(TAG_STATE6PSDEFID, strValue);
    }

    public final boolean isSTATE6PSDEFNAMENull() {
        return this.IsParamNull(TAG_STATE6PSDEFNAME);
    }

    public final String getSTATE6PSDEFNAME() {
        return this.GetParamStringValue(TAG_STATE6PSDEFNAME, "");
    }

    public final void setSTATE6PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_STATE6PSDEFNAME, strValue);
    }

    public final boolean isSTATE7PSDEFIDNull() {
        return this.IsParamNull(TAG_STATE7PSDEFID);
    }

    public final String getSTATE7PSDEFID() {
        return this.GetParamStringValue(TAG_STATE7PSDEFID, "");
    }

    public final void setSTATE7PSDEFID(String strValue) {
        this.SetParamValue(TAG_STATE7PSDEFID, strValue);
    }

    public final boolean isSTATE7PSDEFNAMENull() {
        return this.IsParamNull(TAG_STATE7PSDEFNAME);
    }

    public final String getSTATE7PSDEFNAME() {
        return this.GetParamStringValue(TAG_STATE7PSDEFNAME, "");
    }

    public final void setSTATE7PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_STATE7PSDEFNAME, strValue);
    }

    public final boolean isSTATE8PSDEFIDNull() {
        return this.IsParamNull(TAG_STATE8PSDEFID);
    }

    public final String getSTATE8PSDEFID() {
        return this.GetParamStringValue(TAG_STATE8PSDEFID, "");
    }

    public final void setSTATE8PSDEFID(String strValue) {
        this.SetParamValue(TAG_STATE8PSDEFID, strValue);
    }

    public final boolean isSTATE8PSDEFNAMENull() {
        return this.IsParamNull(TAG_STATE8PSDEFNAME);
    }

    public final String getSTATE8PSDEFNAME() {
        return this.GetParamStringValue(TAG_STATE8PSDEFNAME, "");
    }

    public final void setSTATE8PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_STATE8PSDEFNAME, strValue);
    }

    public final boolean isKEY4PSDEFIDNull() {
        return this.IsParamNull(TAG_KEY4PSDEFID);
    }

    public final String getKEY4PSDEFID() {
        return this.GetParamStringValue(TAG_KEY4PSDEFID, "");
    }

    public final void setKEY4PSDEFID(String strValue) {
        this.SetParamValue(TAG_KEY4PSDEFID, strValue);
    }

    public final boolean isKEY4PSDEFNAMENull() {
        return this.IsParamNull(TAG_KEY4PSDEFNAME);
    }

    public final String getKEY4PSDEFNAME() {
        return this.GetParamStringValue(TAG_KEY4PSDEFNAME, "");
    }

    public final void setKEY4PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_KEY4PSDEFNAME, strValue);
    }

    public final boolean isUNISTATETYPENull() {
        return this.IsParamNull(TAG_UNISTATETYPE);
    }

    public final String getUNISTATETYPE() {
        return this.GetParamStringValue(TAG_UNISTATETYPE, "");
    }

    public final void setUNISTATETYPE(String strValue) {
        this.SetParamValue(TAG_UNISTATETYPE, strValue);
    }

    public final boolean isDEDEFAULTFLAGNull() {
        return this.IsParamNull(TAG_DEDEFAULTFLAG);
    }

    public final boolean getDEDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEDEFAULTFLAG, 0) == 1;
    }

    public final void setDEDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEDEFAULTFLAG, bValue ? 1 : 0);
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

    public final boolean isUNISTATEPARAMSNull() {
        return this.IsParamNull(TAG_UNISTATEPARAMS);
    }

    public final String getUNISTATEPARAMS() {
        return this.GetParamStringValue(TAG_UNISTATEPARAMS, "");
    }

    public final void setUNISTATEPARAMS(String strValue) {
        this.SetParamValue(TAG_UNISTATEPARAMS, strValue);
    }

    public final boolean isUNISTATETAGNull() {
        return this.IsParamNull(TAG_UNISTATETAG);
    }

    public final String getUNISTATETAG() {
        return this.GetParamStringValue(TAG_UNISTATETAG, "");
    }

    public final void setUNISTATETAG(String strValue) {
        this.SetParamValue(TAG_UNISTATETAG, strValue);
    }

    public final boolean isUNISTATETAG2Null() {
        return this.IsParamNull(TAG_UNISTATETAG2);
    }

    public final String getUNISTATETAG2() {
        return this.GetParamStringValue(TAG_UNISTATETAG2, "");
    }

    public final void setUNISTATETAG2(String strValue) {
        this.SetParamValue(TAG_UNISTATETAG2, strValue);
    }

    public final boolean isPSDEDATASETIDNull() {
        return this.IsParamNull(TAG_PSDEDATASETID);
    }

    public final String getPSDEDATASETID() {
        return this.GetParamStringValue(TAG_PSDEDATASETID, "");
    }

    public final void setPSDEDATASETID(String strValue) {
        this.SetParamValue(TAG_PSDEDATASETID, strValue);
    }

    public final boolean isPSDEDATASETNAMENull() {
        return this.IsParamNull(TAG_PSDEDATASETNAME);
    }

    public final String getPSDEDATASETNAME() {
        return this.GetParamStringValue(TAG_PSDEDATASETNAME, "");
    }

    public final void setPSDEDATASETNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDATASETNAME, strValue);
    }

    public final boolean isINITPSDELOGICIDNull() {
        return this.IsParamNull(TAG_INITPSDELOGICID);
    }

    public final String getINITPSDELOGICID() {
        return this.GetParamStringValue(TAG_INITPSDELOGICID, "");
    }

    public final void setINITPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_INITPSDELOGICID, strValue);
    }

    public final boolean isINITPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_INITPSDELOGICNAME);
    }

    public final String getINITPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_INITPSDELOGICNAME, "");
    }

    public final void setINITPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_INITPSDELOGICNAME, strValue);
    }

    public final boolean isONCHANGEPSDELOGICIDNull() {
        return this.IsParamNull(TAG_ONCHANGEPSDELOGICID);
    }

    public final String getONCHANGEPSDELOGICID() {
        return this.GetParamStringValue(TAG_ONCHANGEPSDELOGICID, "");
    }

    public final void setONCHANGEPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_ONCHANGEPSDELOGICID, strValue);
    }

    public final boolean isONCHANGEPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_ONCHANGEPSDELOGICNAME);
    }

    public final String getONCHANGEPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_ONCHANGEPSDELOGICNAME, "");
    }

    public final void setONCHANGEPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_ONCHANGEPSDELOGICNAME, strValue);
    }

    public final boolean isRELOADTIMERNull() {
        return this.IsParamNull(TAG_RELOADTIMER);
    }

    public final int getRELOADTIMER() {
        return this.GetParamIntValue(TAG_RELOADTIMER, 0);
    }

    public final void setRELOADTIMER(int nValue) {
        this.SetParamValue(TAG_RELOADTIMER, nValue);
    }

    public final boolean isUNISTATEMODENull() {
        return this.IsParamNull(TAG_UNISTATEMODE);
    }

    public final String getUNISTATEMODE() {
        return this.GetParamStringValue(TAG_UNISTATEMODE, "");
    }

    public final void setUNISTATEMODE(String strValue) {
        this.SetParamValue(TAG_UNISTATEMODE, strValue);
    }

    public final boolean isALLDATAFLAGNull() {
        return this.IsParamNull(TAG_ALLDATAFLAG);
    }

    public final boolean getALLDATAFLAG() {
        return this.GetParamIntValue(TAG_ALLDATAFLAG, 0) == 1;
    }

    public final void setALLDATAFLAG(boolean bValue) {
        this.SetParamValue(TAG_ALLDATAFLAG, bValue ? 1 : 0);
    }

    public final boolean isKEY5PSDEFIDNull() {
        return this.IsParamNull(TAG_KEY5PSDEFID);
    }

    public final String getKEY5PSDEFID() {
        return this.GetParamStringValue(TAG_KEY5PSDEFID, "");
    }

    public final void setKEY5PSDEFID(String strValue) {
        this.SetParamValue(TAG_KEY5PSDEFID, strValue);
    }

    public final boolean isKEY5PSDEFNAMENull() {
        return this.IsParamNull(TAG_KEY5PSDEFNAME);
    }

    public final String getKEY5PSDEFNAME() {
        return this.GetParamStringValue(TAG_KEY5PSDEFNAME, "");
    }

    public final void setKEY5PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_KEY5PSDEFNAME, strValue);
    }

    public final boolean isKEY6PSDEFIDNull() {
        return this.IsParamNull(TAG_KEY6PSDEFID);
    }

    public final String getKEY6PSDEFID() {
        return this.GetParamStringValue(TAG_KEY6PSDEFID, "");
    }

    public final void setKEY6PSDEFID(String strValue) {
        this.SetParamValue(TAG_KEY6PSDEFID, strValue);
    }

    public final boolean isKEY6PSDEFNAMENull() {
        return this.IsParamNull(TAG_KEY6PSDEFNAME);
    }

    public final String getKEY6PSDEFNAME() {
        return this.GetParamStringValue(TAG_KEY6PSDEFNAME, "");
    }

    public final void setKEY6PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_KEY6PSDEFNAME, strValue);
    }

    public final boolean isKEY7PSDEFIDNull() {
        return this.IsParamNull(TAG_KEY7PSDEFID);
    }

    public final String getKEY7PSDEFID() {
        return this.GetParamStringValue(TAG_KEY7PSDEFID, "");
    }

    public final void setKEY7PSDEFID(String strValue) {
        this.SetParamValue(TAG_KEY7PSDEFID, strValue);
    }

    public final boolean isKEY7PSDEFNAMENull() {
        return this.IsParamNull(TAG_KEY7PSDEFNAME);
    }

    public final String getKEY7PSDEFNAME() {
        return this.GetParamStringValue(TAG_KEY7PSDEFNAME, "");
    }

    public final void setKEY7PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_KEY7PSDEFNAME, strValue);
    }

    public final boolean isKEY8PSDEFIDNull() {
        return this.IsParamNull(TAG_KEY8PSDEFID);
    }

    public final String getKEY8PSDEFID() {
        return this.GetParamStringValue(TAG_KEY8PSDEFID, "");
    }

    public final void setKEY8PSDEFID(String strValue) {
        this.SetParamValue(TAG_KEY8PSDEFID, strValue);
    }

    public final boolean isKEY8PSDEFNAMENull() {
        return this.IsParamNull(TAG_KEY8PSDEFNAME);
    }

    public final String getKEY8PSDEFNAME() {
        return this.GetParamStringValue(TAG_KEY8PSDEFNAME, "");
    }

    public final void setKEY8PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_KEY8PSDEFNAME, strValue);
    }

    public final boolean isKEY9PSDEFIDNull() {
        return this.IsParamNull(TAG_KEY9PSDEFID);
    }

    public final String getKEY9PSDEFID() {
        return this.GetParamStringValue(TAG_KEY9PSDEFID, "");
    }

    public final void setKEY9PSDEFID(String strValue) {
        this.SetParamValue(TAG_KEY9PSDEFID, strValue);
    }

    public final boolean isKEY9PSDEFNAMENull() {
        return this.IsParamNull(TAG_KEY9PSDEFNAME);
    }

    public final String getKEY9PSDEFNAME() {
        return this.GetParamStringValue(TAG_KEY9PSDEFNAME, "");
    }

    public final void setKEY9PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_KEY9PSDEFNAME, strValue);
    }

    public final boolean isKEYFORMATNull() {
        return this.IsParamNull(TAG_KEYFORMAT);
    }

    public final String getKEYFORMAT() {
        return this.GetParamStringValue(TAG_KEYFORMAT, "");
    }

    public final void setKEYFORMAT(String strValue) {
        this.SetParamValue(TAG_KEYFORMAT, strValue);
    }

    public final boolean isMONITORFORMATNull() {
        return this.IsParamNull(TAG_MONITORFORMAT);
    }

    public final String getMONITORFORMAT() {
        return this.GetParamStringValue(TAG_MONITORFORMAT, "");
    }

    public final void setMONITORFORMAT(String strValue) {
        this.SetParamValue(TAG_MONITORFORMAT, strValue);
    }

    public final boolean isCACHECATNull() {
        return this.IsParamNull(TAG_CACHECAT);
    }

    public final String getCACHECAT() {
        return this.GetParamStringValue(TAG_CACHECAT, "");
    }

    public final void setCACHECAT(String strValue) {
        this.SetParamValue(TAG_CACHECAT, strValue);
    }

    public final boolean isCACHESCOPENull() {
        return this.IsParamNull(TAG_CACHESCOPE);
    }

    public final String getCACHESCOPE() {
        return this.GetParamStringValue(TAG_CACHESCOPE, "");
    }

    public final void setCACHESCOPE(String strValue) {
        this.SetParamValue(TAG_CACHESCOPE, strValue);
    }

    public final boolean isCACHETIMEOUTNull() {
        return this.IsParamNull(TAG_CACHETIMEOUT);
    }

    public final int getCACHETIMEOUT() {
        return this.GetParamIntValue(TAG_CACHETIMEOUT, 0);
    }

    public final void setCACHETIMEOUT(int nValue) {
        this.SetParamValue(TAG_CACHETIMEOUT, nValue);
    }

    public final boolean isONDELETEPSDELOGICIDNull() {
        return this.IsParamNull(TAG_ONDELETEPSDELOGICID);
    }

    public final String getONDELETEPSDELOGICID() {
        return this.GetParamStringValue(TAG_ONDELETEPSDELOGICID, "");
    }

    public final void setONDELETEPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_ONDELETEPSDELOGICID, strValue);
    }

    public final boolean isONDELETEPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_ONDELETEPSDELOGICNAME);
    }

    public final String getONDELETEPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_ONDELETEPSDELOGICNAME, "");
    }

    public final void setONDELETEPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_ONDELETEPSDELOGICNAME, strValue);
    }

    public final boolean isDELETEASUPDATENull() {
        return this.IsParamNull(TAG_DELETEASUPDATE);
    }

    public final boolean getDELETEASUPDATE() {
        return this.GetParamIntValue(TAG_DELETEASUPDATE, 0) == 1;
    }

    public final void setDELETEASUPDATE(boolean bValue) {
        this.SetParamValue(TAG_DELETEASUPDATE, bValue ? 1 : 0);
    }
}

