/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysPFPlugin
extends BaseDataEntity {
    public static final String PLUGINTYPE_GRID_COLRENDER = "GRID_COLRENDER";
    public static final String PLUGINTYPE_FORM_USERCONTROL = "FORM_USERCONTROL";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSPFPLUGINID = "PSPFPLUGINID";
    public static final String TAG_PSPFPLUGINNAME = "PSPFPLUGINNAME";
    public static final String TAG_PLUGINTYPE = "PLUGINTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_PLUGINTAG = "PLUGINTAG";
    public static final String TAG_PSSYSFILEID = "PSSYSFILEID";
    public static final String TAG_PREVIEWPSNDFILEID = "PREVIEWPSNDFILEID";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_REPDEFAULT = "REPDEFAULT";
    public static final String TAG_EXTENDSTYLEONLY = "EXTENDSTYLEONLY";
    public static final String TAG_PLUGINMODEL = "PLUGINMODEL";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_PLUGINPARAMS = "PLUGINPARAMS";
    public static final String TAG_RTOBJECTMODE = "RTOBJECTMODE";
    public static final String TAG_RTOBJECTNAME = "RTOBJECTNAME";
    public static final String TAG_RTOBJECTREPO = "RTOBJECTREPO";
    public static final String TAG_STUDIOICON = "STUDIOICON";
    public static final String TAG_PREVIEWHTML = "PREVIEWHTML";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_TEMPLATEMODE = "TEMPLATEMODE";
    public static final String TAG_TEMPLATEFUNC = "TEMPLATEFUNC";

    public final boolean isPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINID);
    }

    public final String getPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINID, "");
    }

    public final void setPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINID, strValue);
    }

    public final boolean isPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINNAME);
    }

    public final String getPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINNAME, "");
    }

    public final void setPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINNAME, strValue);
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

    public final boolean isPSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSPFPLUGINID);
    }

    public final String getPSPFPLUGINID() {
        return this.GetParamStringValue(TAG_PSPFPLUGINID, "");
    }

    public final void setPSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSPFPLUGINID, strValue);
    }

    public final boolean isPSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSPFPLUGINNAME);
    }

    public final String getPSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSPFPLUGINNAME, "");
    }

    public final void setPSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSPFPLUGINNAME, strValue);
    }

    public final boolean isPLUGINTYPENull() {
        return this.IsParamNull(TAG_PLUGINTYPE);
    }

    public final String getPLUGINTYPE() {
        return this.GetParamStringValue(TAG_PLUGINTYPE, "");
    }

    public final void setPLUGINTYPE(String strValue) {
        this.SetParamValue(TAG_PLUGINTYPE, strValue);
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

    public final boolean isPLUGINTAGNull() {
        return this.IsParamNull(TAG_PLUGINTAG);
    }

    public final String getPLUGINTAG() {
        return this.GetParamStringValue(TAG_PLUGINTAG, "");
    }

    public final void setPLUGINTAG(String strValue) {
        this.SetParamValue(TAG_PLUGINTAG, strValue);
    }

    public final boolean isPSSYSFILEIDNull() {
        return this.IsParamNull(TAG_PSSYSFILEID);
    }

    public final String getPSSYSFILEID() {
        return this.GetParamStringValue(TAG_PSSYSFILEID, "");
    }

    public final void setPSSYSFILEID(String strValue) {
        this.SetParamValue(TAG_PSSYSFILEID, strValue);
    }

    public final boolean isPREVIEWPSNDFILEIDNull() {
        return this.IsParamNull(TAG_PREVIEWPSNDFILEID);
    }

    public final String getPREVIEWPSNDFILEID() {
        return this.GetParamStringValue(TAG_PREVIEWPSNDFILEID, "");
    }

    public final void setPREVIEWPSNDFILEID(String strValue) {
        this.SetParamValue(TAG_PREVIEWPSNDFILEID, strValue);
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

    public final boolean isREPDEFAULTNull() {
        return this.IsParamNull(TAG_REPDEFAULT);
    }

    public final boolean getREPDEFAULT() {
        return this.GetParamIntValue(TAG_REPDEFAULT, 0) == 1;
    }

    public final void setREPDEFAULT(boolean bValue) {
        this.SetParamValue(TAG_REPDEFAULT, bValue ? 1 : 0);
    }

    public final boolean isEXTENDSTYLEONLYNull() {
        return this.IsParamNull(TAG_EXTENDSTYLEONLY);
    }

    public final boolean getEXTENDSTYLEONLY() {
        return this.GetParamIntValue(TAG_EXTENDSTYLEONLY, 0) == 1;
    }

    public final void setEXTENDSTYLEONLY(boolean bValue) {
        this.SetParamValue(TAG_EXTENDSTYLEONLY, bValue ? 1 : 0);
    }

    public final boolean isPLUGINMODELNull() {
        return this.IsParamNull(TAG_PLUGINMODEL);
    }

    public final String getPLUGINMODEL() {
        return this.GetParamStringValue(TAG_PLUGINMODEL, "");
    }

    public final void setPLUGINMODEL(String strValue) {
        this.SetParamValue(TAG_PLUGINMODEL, strValue);
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

    public final boolean isPLUGINPARAMSNull() {
        return this.IsParamNull(TAG_PLUGINPARAMS);
    }

    public final String getPLUGINPARAMS() {
        return this.GetParamStringValue(TAG_PLUGINPARAMS, "");
    }

    public final void setPLUGINPARAMS(String strValue) {
        this.SetParamValue(TAG_PLUGINPARAMS, strValue);
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

    public final boolean isRTOBJECTMODENull() {
        return this.IsParamNull(TAG_RTOBJECTMODE);
    }

    public final int getRTOBJECTMODE() {
        return this.GetParamIntValue(TAG_RTOBJECTMODE, 0);
    }

    public final void setRTOBJECTMODE(int nValue) {
        this.SetParamValue(TAG_RTOBJECTMODE, nValue);
    }

    public final boolean isRTOBJECTNAMENull() {
        return this.IsParamNull(TAG_RTOBJECTNAME);
    }

    public final String getRTOBJECTNAME() {
        return this.GetParamStringValue(TAG_RTOBJECTNAME, "");
    }

    public final void setRTOBJECTNAME(String strValue) {
        this.SetParamValue(TAG_RTOBJECTNAME, strValue);
    }

    public final boolean isRTOBJECTREPONull() {
        return this.IsParamNull(TAG_RTOBJECTREPO);
    }

    public final String getRTOBJECTREPO() {
        return this.GetParamStringValue(TAG_RTOBJECTREPO, "");
    }

    public final void setRTOBJECTREPO(String strValue) {
        this.SetParamValue(TAG_RTOBJECTREPO, strValue);
    }

    public final boolean isSTUDIOICONNull() {
        return this.IsParamNull(TAG_STUDIOICON);
    }

    public final String getSTUDIOICON() {
        return this.GetParamStringValue(TAG_STUDIOICON, "");
    }

    public final void setSTUDIOICON(String strValue) {
        this.SetParamValue(TAG_STUDIOICON, strValue);
    }

    public final boolean isPREVIEWHTMLNull() {
        return this.IsParamNull(TAG_PREVIEWHTML);
    }

    public final String getPREVIEWHTML() {
        return this.GetParamStringValue(TAG_PREVIEWHTML, "");
    }

    public final void setPREVIEWHTML(String strValue) {
        this.SetParamValue(TAG_PREVIEWHTML, strValue);
    }

    public final boolean isPSSYSVIEWPANELIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELID);
    }

    public final String getPSSYSVIEWPANELID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELID, "");
    }

    public final void setPSSYSVIEWPANELID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELID, strValue);
    }

    public final boolean isPSSYSVIEWPANELNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELNAME);
    }

    public final String getPSSYSVIEWPANELNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELNAME, "");
    }

    public final void setPSSYSVIEWPANELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELNAME, strValue);
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

    public final boolean isTEMPLATEMODENull() {
        return this.IsParamNull(TAG_TEMPLATEMODE);
    }

    public final int getTEMPLATEMODE() {
        return this.GetParamIntValue(TAG_TEMPLATEMODE, 0);
    }

    public final void setTEMPLATEMODE(int nValue) {
        this.SetParamValue(TAG_TEMPLATEMODE, nValue);
    }

    public final boolean isTEMPLATEFUNCNull() {
        return this.IsParamNull(TAG_TEMPLATEFUNC);
    }

    public final String getTEMPLATEFUNC() {
        return this.GetParamStringValue(TAG_TEMPLATEFUNC, "");
    }

    public final void setTEMPLATEFUNC(String strValue) {
        this.SetParamValue(TAG_TEMPLATEFUNC, strValue);
    }
}

