/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEMainState
extends BaseDataEntity {
    public static final String ALLOWMODE_ALLOW = "ALLOW";
    public static final String ALLOWMODE_DENY = "DENY";
    public static final String ENTERSTATEMODE_ANY = "ANY";
    public static final String ENTERSTATEMODE_SOME = "SOME";
    public static final String TAG_PSDEMAINSTATEID = "PSDEMAINSTATEID";
    public static final String TAG_PSDEMAINSTATENAME = "PSDEMAINSTATENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEDQID = "PSDEDQID";
    public static final String TAG_PSDEDQNAME = "PSDEDQNAME";
    public static final String TAG_ALLOWMODE = "ALLOWMODE";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_DEFAULTMODE = "DEFAULTMODE";
    public static final String TAG_MSTAG = "MSTAG";
    public static final String TAG_MSVALUE = "MSVALUE";
    public static final String TAG_MSVALUE2 = "MSVALUE2";
    public static final String TAG_MSVALUE3 = "MSVALUE3";
    public static final String TAG_EDITPSDEVIEWID = "EDITPSDEVIEWID";
    public static final String TAG_EDITPSDEVIEWNAME = "EDITPSDEVIEWNAME";
    public static final String TAG_INFOPSDEVIEWID = "INFOPSDEVIEWID";
    public static final String TAG_INFOPSDEVIEWNAME = "INFOPSDEVIEWNAME";
    public static final String TAG_MDPSDEVIEWID = "MDPSDEVIEWID";
    public static final String TAG_MDPSDEVIEWNAME = "MDPSDEVIEWNAME";
    public static final String TAG_WFSTATEMODE = "WFSTATEMODE";
    public static final String TAG_ENABLEVIEWACTIONS = "ENABLEVIEWACTIONS";
    public static final String TAG_VIEWACTIONS = "VIEWACTIONS";
    public static final String TAG_PSDEFORMID = "PSDEFORMID";
    public static final String TAG_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String TAG_OPPRIVALLOWMODE = "OPPRIVALLOWMODE";
    public static final String TAG_DEACTIONDENYMSG = "DEACTIONDENYMSG";
    public static final String TAG_DEOPPRIVDENYMSG = "DEOPPRIVDENYMSG";
    public static final String TAG_DEACTIONDMPSLANRESID = "DEACTIONDMPSLANRESID";
    public static final String TAG_DEACTIONDMPSLANRESNAME = "DEACTIONDMPSLANRESNAME";
    public static final String TAG_DEOPPRIVDMPSLANRESID = "DEOPPRIVDMPSLANRESID";
    public static final String TAG_DEOPPRIVDMPSLANRESNAME = "DEOPPRIVDMPSLANRESNAME";
    public static final String TAG_ENTERPSDEACTIONID = "ENTERPSDEACTIONID";
    public static final String TAG_ENTERPSDEACTIONNAME = "ENTERPSDEACTIONNAME";
    public static final String TAG_LOCKFLAG = "LOCKFLAG";
    public static final String TAG_SDPSDEVIEWID = "SDPSDEVIEWID";
    public static final String TAG_SDPSDEVIEWNAME = "SDPSDEVIEWNAME";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_ENTERSTATEMODE = "ENTERSTATEMODE";
    public static final String TAG_FIELDALLOWMODE = "FIELDALLOWMODE";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MOBPSDEFORMID = "MOBPSDEFORMID";
    public static final String TAG_MOBPSDEFORMNAME = "MOBPSDEFORMNAME";
    public static final String TAG_FORMCODENAME = "FORMCODENAME";
    public static final String TAG_MOBFORMCODENAME = "MOBFORMCODENAME";
    public static final String TAG_TEXTPSLANRESID = "TEXTPSLANRESID";
    public static final String TAG_TEXTPSLANRESNAME = "TEXTPSLANRESNAME";
    public static final String TAG_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String TAG_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String TAG_COLOR = "COLOR";
    public static final String TAG_MOBEDITVIEWTYPE = "MOBEDITVIEWTYPE";
    public static final String TAG_UTILPSDEFORMID = "UTILPSDEFORMID";
    public static final String TAG_UTILPSDEFORMNAME = "UTILPSDEFORMNAME";
    public static final String TAG_MOBUTILPSDEFORMID = "MOBUTILPSDEFORMID";
    public static final String TAG_MOBUTILPSDEFORMNAME = "MOBUTILPSDEFORMNAME";
    public static final String TAG_UTILFORMCODENAME = "UTILFORMCODENAME";
    public static final String TAG_MOBUTILFORMCODENAME = "MOBUTILFORMCODENAME";
    public static final String TAG_QUICKPSDEFORMID = "QUICKPSDEFORMID";
    public static final String TAG_QUICKPSDEFORMNAME = "QUICKPSDEFORMNAME";
    public static final String TAG_MOBQUICKPSDEFORMID = "MOBQUICKPSDEFORMID";
    public static final String TAG_MOBQUICKPSDEFORMNAME = "MOBQUICKPSDEFORMNAME";
    public static final String TAG_MOBQUICKFORMCODENAME = "MOBQUICKFORMCODENAME";
    public static final String TAG_QUICKFORMCODENAME = "QUICKFORMCODENAME";

    public final boolean isPSDEMAINSTATEIDNull() {
        return this.IsParamNull(TAG_PSDEMAINSTATEID);
    }

    public final String getPSDEMAINSTATEID() {
        return this.GetParamStringValue(TAG_PSDEMAINSTATEID, "");
    }

    public final void setPSDEMAINSTATEID(String strValue) {
        this.SetParamValue(TAG_PSDEMAINSTATEID, strValue);
    }

    public final boolean isPSDEMAINSTATENAMENull() {
        return this.IsParamNull(TAG_PSDEMAINSTATENAME);
    }

    public final String getPSDEMAINSTATENAME() {
        return this.GetParamStringValue(TAG_PSDEMAINSTATENAME, "");
    }

    public final void setPSDEMAINSTATENAME(String strValue) {
        this.SetParamValue(TAG_PSDEMAINSTATENAME, strValue);
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

    public final boolean isPSDEDQIDNull() {
        return this.IsParamNull(TAG_PSDEDQID);
    }

    public final String getPSDEDQID() {
        return this.GetParamStringValue(TAG_PSDEDQID, "");
    }

    public final void setPSDEDQID(String strValue) {
        this.SetParamValue(TAG_PSDEDQID, strValue);
    }

    public final boolean isPSDEDQNAMENull() {
        return this.IsParamNull(TAG_PSDEDQNAME);
    }

    public final String getPSDEDQNAME() {
        return this.GetParamStringValue(TAG_PSDEDQNAME, "");
    }

    public final void setPSDEDQNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDQNAME, strValue);
    }

    public final boolean isALLOWMODENull() {
        return this.IsParamNull(TAG_ALLOWMODE);
    }

    public final String getALLOWMODE() {
        return this.GetParamStringValue(TAG_ALLOWMODE, "");
    }

    public final void setALLOWMODE(String strValue) {
        this.SetParamValue(TAG_ALLOWMODE, strValue);
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

    public final boolean isDEFAULTMODENull() {
        return this.IsParamNull(TAG_DEFAULTMODE);
    }

    public final int getDEFAULTMODE() {
        return this.GetParamIntValue(TAG_DEFAULTMODE, 0);
    }

    public final void setDEFAULTMODE(int bValue) {
        this.SetParamValue(TAG_DEFAULTMODE, bValue);
    }

    public final boolean isMSTAGNull() {
        return this.IsParamNull(TAG_MSTAG);
    }

    public final String getMSTAG() {
        return this.GetParamStringValue(TAG_MSTAG, "");
    }

    public final void setMSTAG(String strValue) {
        this.SetParamValue(TAG_MSTAG, strValue);
    }

    public final boolean isMSVALUENull() {
        return this.IsParamNull(TAG_MSVALUE);
    }

    public final String getMSVALUE() {
        return this.GetParamStringValue(TAG_MSVALUE, "");
    }

    public final void setMSVALUE(String strValue) {
        this.SetParamValue(TAG_MSVALUE, strValue);
    }

    public final boolean isMSVALUE2Null() {
        return this.IsParamNull(TAG_MSVALUE2);
    }

    public final String getMSVALUE2() {
        return this.GetParamStringValue(TAG_MSVALUE2, "");
    }

    public final void setMSVALUE2(String strValue) {
        this.SetParamValue(TAG_MSVALUE2, strValue);
    }

    public final boolean isMSVALUE3Null() {
        return this.IsParamNull(TAG_MSVALUE3);
    }

    public final String getMSVALUE3() {
        return this.GetParamStringValue(TAG_MSVALUE3, "");
    }

    public final void setMSVALUE3(String strValue) {
        this.SetParamValue(TAG_MSVALUE3, strValue);
    }

    public final void setWFSTATEMODE(boolean bValue) {
        this.SetParamValue(TAG_WFSTATEMODE, bValue ? 1 : 0);
    }

    public final boolean isENABLEVIEWACTIONSNull() {
        return this.IsParamNull(TAG_ENABLEVIEWACTIONS);
    }

    public final boolean getENABLEVIEWACTIONS() {
        return this.GetParamIntValue(TAG_ENABLEVIEWACTIONS, 0) == 1;
    }

    public final void setENABLEVIEWACTIONS(boolean bValue) {
        this.SetParamValue(TAG_ENABLEVIEWACTIONS, bValue ? 1 : 0);
    }

    public final boolean isVIEWACTIONSNull() {
        return this.IsParamNull(TAG_VIEWACTIONS);
    }

    public final int getVIEWACTIONS() {
        return this.GetParamIntValue(TAG_VIEWACTIONS, 0);
    }

    public final void setVIEWACTIONS(int nValue) {
        this.SetParamValue(TAG_VIEWACTIONS, nValue);
    }

    public final boolean isPSDEFORMIDNull() {
        return this.IsParamNull(TAG_PSDEFORMID);
    }

    public final String getPSDEFORMID() {
        return this.GetParamStringValue(TAG_PSDEFORMID, "");
    }

    public final void setPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_PSDEFORMID, strValue);
    }

    public final boolean isPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_PSDEFORMNAME);
    }

    public final String getPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_PSDEFORMNAME, "");
    }

    public final void setPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFORMNAME, strValue);
    }

    public final boolean isOPPRIVALLOWMODENull() {
        return this.IsParamNull(TAG_OPPRIVALLOWMODE);
    }

    public final String getOPPRIVALLOWMODE() {
        return this.GetParamStringValue(TAG_OPPRIVALLOWMODE, "");
    }

    public final void setOPPRIVALLOWMODE(String strValue) {
        this.SetParamValue(TAG_OPPRIVALLOWMODE, strValue);
    }

    public final boolean isWFSTATEMODENull() {
        return this.IsParamNull(TAG_WFSTATEMODE);
    }

    public final int getWFSTATEMODE() {
        return this.GetParamIntValue(TAG_WFSTATEMODE, 0);
    }

    public final void setWFSTATEMODE(int nValue) {
        this.SetParamValue(TAG_WFSTATEMODE, nValue);
    }

    public final boolean isDEACTIONDENYMSGNull() {
        return this.IsParamNull(TAG_DEACTIONDENYMSG);
    }

    public final String getDEACTIONDENYMSG() {
        return this.GetParamStringValue(TAG_DEACTIONDENYMSG, "");
    }

    public final void setDEACTIONDENYMSG(String strValue) {
        this.SetParamValue(TAG_DEACTIONDENYMSG, strValue);
    }

    public final boolean isDEOPPRIVDENYMSGNull() {
        return this.IsParamNull(TAG_DEOPPRIVDENYMSG);
    }

    public final String getDEOPPRIVDENYMSG() {
        return this.GetParamStringValue(TAG_DEOPPRIVDENYMSG, "");
    }

    public final void setDEOPPRIVDENYMSG(String strValue) {
        this.SetParamValue(TAG_DEOPPRIVDENYMSG, strValue);
    }

    public final boolean isDEACTIONDMPSLANRESIDNull() {
        return this.IsParamNull(TAG_DEACTIONDMPSLANRESID);
    }

    public final String getDEACTIONDMPSLANRESID() {
        return this.GetParamStringValue(TAG_DEACTIONDMPSLANRESID, "");
    }

    public final void setDEACTIONDMPSLANRESID(String strValue) {
        this.SetParamValue(TAG_DEACTIONDMPSLANRESID, strValue);
    }

    public final boolean isDEACTIONDMPSLANRESNAMENull() {
        return this.IsParamNull(TAG_DEACTIONDMPSLANRESNAME);
    }

    public final String getDEACTIONDMPSLANRESNAME() {
        return this.GetParamStringValue(TAG_DEACTIONDMPSLANRESNAME, "");
    }

    public final void setDEACTIONDMPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_DEACTIONDMPSLANRESNAME, strValue);
    }

    public final boolean isDEOPPRIVDMPSLANRESIDNull() {
        return this.IsParamNull(TAG_DEOPPRIVDMPSLANRESID);
    }

    public final String getDEOPPRIVDMPSLANRESID() {
        return this.GetParamStringValue(TAG_DEOPPRIVDMPSLANRESID, "");
    }

    public final void setDEOPPRIVDMPSLANRESID(String strValue) {
        this.SetParamValue(TAG_DEOPPRIVDMPSLANRESID, strValue);
    }

    public final boolean isDEOPPRIVDMPSLANRESNAMENull() {
        return this.IsParamNull(TAG_DEOPPRIVDMPSLANRESNAME);
    }

    public final String getDEOPPRIVDMPSLANRESNAME() {
        return this.GetParamStringValue(TAG_DEOPPRIVDMPSLANRESNAME, "");
    }

    public final void setDEOPPRIVDMPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_DEOPPRIVDMPSLANRESNAME, strValue);
    }

    public final boolean isENTERPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_ENTERPSDEACTIONID);
    }

    public final String getENTERPSDEACTIONID() {
        return this.GetParamStringValue(TAG_ENTERPSDEACTIONID, "");
    }

    public final void setENTERPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_ENTERPSDEACTIONID, strValue);
    }

    public final boolean isENTERPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_ENTERPSDEACTIONNAME);
    }

    public final String getENTERPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_ENTERPSDEACTIONNAME, "");
    }

    public final void setENTERPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_ENTERPSDEACTIONNAME, strValue);
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

    public final boolean isSDPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_SDPSDEVIEWID);
    }

    public final String getSDPSDEVIEWID() {
        return this.GetParamStringValue(TAG_SDPSDEVIEWID, "");
    }

    public final void setSDPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_SDPSDEVIEWID, strValue);
    }

    public final boolean isSDPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_SDPSDEVIEWNAME);
    }

    public final String getSDPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_SDPSDEVIEWNAME, "");
    }

    public final void setSDPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_SDPSDEVIEWNAME, strValue);
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

    public final boolean isENTERSTATEMODENull() {
        return this.IsParamNull(TAG_ENTERSTATEMODE);
    }

    public final String getENTERSTATEMODE() {
        return this.GetParamStringValue(TAG_ENTERSTATEMODE, "");
    }

    public final void setENTERSTATEMODE(String strValue) {
        this.SetParamValue(TAG_ENTERSTATEMODE, strValue);
    }

    public final boolean isFIELDALLOWMODENull() {
        return this.IsParamNull(TAG_FIELDALLOWMODE);
    }

    public final String getFIELDALLOWMODE() {
        return this.GetParamStringValue(TAG_FIELDALLOWMODE, "");
    }

    public final void setFIELDALLOWMODE(String strValue) {
        this.SetParamValue(TAG_FIELDALLOWMODE, strValue);
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

    public final boolean isMOBPSDEFORMIDNull() {
        return this.IsParamNull(TAG_MOBPSDEFORMID);
    }

    public final String getMOBPSDEFORMID() {
        return this.GetParamStringValue(TAG_MOBPSDEFORMID, "");
    }

    public final void setMOBPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_MOBPSDEFORMID, strValue);
    }

    public final boolean isMOBPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_MOBPSDEFORMNAME);
    }

    public final String getMOBPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_MOBPSDEFORMNAME, "");
    }

    public final void setMOBPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_MOBPSDEFORMNAME, strValue);
    }

    public final boolean isFORMCODENAMENull() {
        return this.IsParamNull(TAG_FORMCODENAME);
    }

    public final String getFORMCODENAME() {
        return this.GetParamStringValue(TAG_FORMCODENAME, "");
    }

    public final void setFORMCODENAME(String strValue) {
        this.SetParamValue(TAG_FORMCODENAME, strValue);
    }

    public final boolean isMOBFORMCODENAMENull() {
        return this.IsParamNull(TAG_MOBFORMCODENAME);
    }

    public final String getMOBFORMCODENAME() {
        return this.GetParamStringValue(TAG_MOBFORMCODENAME, "");
    }

    public final void setMOBFORMCODENAME(String strValue) {
        this.SetParamValue(TAG_MOBFORMCODENAME, strValue);
    }

    public final boolean isTEXTPSLANRESIDNull() {
        return this.IsParamNull(TAG_TEXTPSLANRESID);
    }

    public final String getTEXTPSLANRESID() {
        return this.GetParamStringValue(TAG_TEXTPSLANRESID, "");
    }

    public final void setTEXTPSLANRESID(String strValue) {
        this.SetParamValue(TAG_TEXTPSLANRESID, strValue);
    }

    public final boolean isTEXTPSLANRESNAMENull() {
        return this.IsParamNull(TAG_TEXTPSLANRESNAME);
    }

    public final String getTEXTPSLANRESNAME() {
        return this.GetParamStringValue(TAG_TEXTPSLANRESNAME, "");
    }

    public final void setTEXTPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_TEXTPSLANRESNAME, strValue);
    }

    public final boolean isTIPPSLANRESIDNull() {
        return this.IsParamNull(TAG_TIPPSLANRESID);
    }

    public final String getTIPPSLANRESID() {
        return this.GetParamStringValue(TAG_TIPPSLANRESID, "");
    }

    public final void setTIPPSLANRESID(String strValue) {
        this.SetParamValue(TAG_TIPPSLANRESID, strValue);
    }

    public final boolean isTIPPSLANRESNAMENull() {
        return this.IsParamNull(TAG_TIPPSLANRESNAME);
    }

    public final String getTIPPSLANRESNAME() {
        return this.GetParamStringValue(TAG_TIPPSLANRESNAME, "");
    }

    public final void setTIPPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_TIPPSLANRESNAME, strValue);
    }

    public final boolean isPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_PSSYSCSSID);
    }

    public final String getPSSYSCSSID() {
        return this.GetParamStringValue(TAG_PSSYSCSSID, "");
    }

    public final void setPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSID, strValue);
    }

    public final boolean isPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_PSSYSCSSNAME);
    }

    public final String getPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_PSSYSCSSNAME, "");
    }

    public final void setPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSNAME, strValue);
    }

    public final boolean isPSSYSIMAGEIDNull() {
        return this.IsParamNull(TAG_PSSYSIMAGEID);
    }

    public final String getPSSYSIMAGEID() {
        return this.GetParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.IsParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.GetParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGENAME, strValue);
    }

    public final boolean isTOOLTIPINFONull() {
        return this.IsParamNull(TAG_TOOLTIPINFO);
    }

    public final String getTOOLTIPINFO() {
        return this.GetParamStringValue(TAG_TOOLTIPINFO, "");
    }

    public final void setTOOLTIPINFO(String strValue) {
        this.SetParamValue(TAG_TOOLTIPINFO, strValue);
    }

    public final boolean isCOLORNull() {
        return this.IsParamNull(TAG_COLOR);
    }

    public final String getCOLOR() {
        return this.GetParamStringValue(TAG_COLOR, "");
    }

    public final void setCOLOR(String strValue) {
        this.SetParamValue(TAG_COLOR, strValue);
    }

    public final boolean isMOBEDITVIEWTYPENull() {
        return this.IsParamNull(TAG_MOBEDITVIEWTYPE);
    }

    public final String getMOBEDITVIEWTYPE() {
        return this.GetParamStringValue(TAG_MOBEDITVIEWTYPE, "");
    }

    public final void setMOBEDITVIEWTYPE(String strValue) {
        this.SetParamValue(TAG_MOBEDITVIEWTYPE, strValue);
    }

    public final boolean isUTILPSDEFORMIDNull() {
        return this.IsParamNull(TAG_UTILPSDEFORMID);
    }

    public final String getUTILPSDEFORMID() {
        return this.GetParamStringValue(TAG_UTILPSDEFORMID, "");
    }

    public final void setUTILPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_UTILPSDEFORMID, strValue);
    }

    public final boolean isUTILPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_UTILPSDEFORMNAME);
    }

    public final String getUTILPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_UTILPSDEFORMNAME, "");
    }

    public final void setUTILPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_UTILPSDEFORMNAME, strValue);
    }

    public final boolean isMOBUTILPSDEFORMIDNull() {
        return this.IsParamNull(TAG_MOBUTILPSDEFORMID);
    }

    public final String getMOBUTILPSDEFORMID() {
        return this.GetParamStringValue(TAG_MOBUTILPSDEFORMID, "");
    }

    public final void setMOBUTILPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_MOBUTILPSDEFORMID, strValue);
    }

    public final boolean isMOBUTILPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_MOBUTILPSDEFORMNAME);
    }

    public final String getMOBUTILPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_MOBUTILPSDEFORMNAME, "");
    }

    public final void setMOBUTILPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_MOBUTILPSDEFORMNAME, strValue);
    }

    public final boolean isUTILFORMCODENAMENull() {
        return this.IsParamNull(TAG_UTILFORMCODENAME);
    }

    public final String getUTILFORMCODENAME() {
        return this.GetParamStringValue(TAG_UTILFORMCODENAME, "");
    }

    public final void setUTILFORMCODENAME(String strValue) {
        this.SetParamValue(TAG_UTILFORMCODENAME, strValue);
    }

    public final boolean isMOBUTILFORMCODENAMENull() {
        return this.IsParamNull(TAG_MOBUTILFORMCODENAME);
    }

    public final String getMOBUTILFORMCODENAME() {
        return this.GetParamStringValue(TAG_MOBUTILFORMCODENAME, "");
    }

    public final void setMOBUTILFORMCODENAME(String strValue) {
        this.SetParamValue(TAG_MOBUTILFORMCODENAME, strValue);
    }

    public final boolean isQUICKPSDEFORMIDNull() {
        return this.IsParamNull(TAG_QUICKPSDEFORMID);
    }

    public final String getQUICKPSDEFORMID() {
        return this.GetParamStringValue(TAG_QUICKPSDEFORMID, "");
    }

    public final void setQUICKPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_QUICKPSDEFORMID, strValue);
    }

    public final boolean isQUICKPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_QUICKPSDEFORMNAME);
    }

    public final String getQUICKPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_QUICKPSDEFORMNAME, "");
    }

    public final void setQUICKPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_QUICKPSDEFORMNAME, strValue);
    }

    public final boolean isMOBQUICKPSDEFORMIDNull() {
        return this.IsParamNull(TAG_MOBQUICKPSDEFORMID);
    }

    public final String getMOBQUICKPSDEFORMID() {
        return this.GetParamStringValue(TAG_MOBQUICKPSDEFORMID, "");
    }

    public final void setMOBQUICKPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_MOBQUICKPSDEFORMID, strValue);
    }

    public final boolean isMOBQUICKPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_MOBQUICKPSDEFORMNAME);
    }

    public final String getMOBQUICKPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_MOBQUICKPSDEFORMNAME, "");
    }

    public final void setMOBQUICKPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_MOBQUICKPSDEFORMNAME, strValue);
    }

    public final boolean isMOBQUICKFORMCODENAMENull() {
        return this.IsParamNull(TAG_MOBQUICKFORMCODENAME);
    }

    public final String getMOBQUICKFORMCODENAME() {
        return this.GetParamStringValue(TAG_MOBQUICKFORMCODENAME, "");
    }

    public final void setMOBQUICKFORMCODENAME(String strValue) {
        this.SetParamValue(TAG_MOBQUICKFORMCODENAME, strValue);
    }

    public final boolean isQUICKFORMCODENAMENull() {
        return this.IsParamNull(TAG_QUICKFORMCODENAME);
    }

    public final String getQUICKFORMCODENAME() {
        return this.GetParamStringValue(TAG_QUICKFORMCODENAME, "");
    }

    public final void setQUICKFORMCODENAME(String strValue) {
        this.SetParamValue(TAG_QUICKFORMCODENAME, strValue);
    }
}

