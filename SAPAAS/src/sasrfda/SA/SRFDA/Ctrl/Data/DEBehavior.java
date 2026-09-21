/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Date;
import java.util.Properties;

public class DEBehavior
extends BaseDataEntity {
    public static final String IMPORTANCE_HIGH = "HIGH";
    public static final String IMPORTANCE_NORMAL = "NORMAL";
    public static final String IMPORTANCE_LOW = "LOW";
    public static final String EXTPARAM_HANDLERPARAM = "HANDLERPARAM.";
    public static final String EXTPARAM_HANDLER = "HANDLER";
    public static final String ACTIONTARGET_SINGLE = "SINGLE";
    public static final String ACTIONTARGET_SINGLEKEY = "SINGLEKEY";
    public static final String ACTIONTARGET_MULTI = "MULTI";
    public static final String ACTIONTARGET_ALL = "ALL";
    public static final String ACTIONTARGET_NONE = "NONE";
    public static final String PROCESSTYPE_FRONT = "FRONT";
    public static final String PROCESSTYPE_BACKEND = "BACKEND";
    public static final String FRONTPROTYPE_WIZARD = "WIZARD";
    public static final String FRONTPROTYPE_SHOWPAGE = "SHOWPAGE";
    public static final String FRONTPROTYPE_OTHER = "OTHER";
    public static final String TAG_DEBEHAVIORID = "DEBEHAVIORID";
    public static final String TAG_DEBEHAVIORNAME = "DEBEHAVIORNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_ACTIONTARGET = "ACTIONTARGET";
    public static final String TAG_BHCODE = "BHCODE";
    public static final String TAG_IMPORTANCE = "IMPORTANCE";
    public static final String TAG_PROCESSTYPE = "PROCESSTYPE";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_DEVIMAGEID = "DEVIMAGEID";
    public static final String TAG_DEVIMAGENAME = "DEVIMAGENAME";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_TOOLTIP = "TOOLTIP";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CAPLANRESID = "CAPLANRESID";
    public static final String TAG_CAPLANRESNAME = "CAPLANRESNAME";
    public static final String TAG_TIPLANRESID = "TIPLANRESID";
    public static final String TAG_TIPLANRESNAME = "TIPLANRESNAME";
    public static final String TAG_RESOURCEID = "RESOURCEID";
    public static final String TAG_DEACTIONID = "DEACTIONID";
    public static final String TAG_DEACTIONNAME = "DEACTIONNAME";
    public static final String TAG_TIMEOUT = "TIMEOUT";
    public static final String TAG_CONFIRMINFO = "CONFIRMINFO";
    public static final String TAG_RELOADDATA = "RELOADDATA";
    public static final String TAG_DATAACTION = "DATAACTION";
    public static final String TAG_SUCCESSINFO = "SUCCESSINFO";
    public static final String TAG_BEFORECODE = "BEFORECODE";
    public static final String TAG_SUCCESSCODE = "SUCCESSCODE";
    public static final String TAG_DEWIZARDID = "DEWIZARDID";
    public static final String TAG_DEWIZARDNAME = "DEWIZARDNAME";
    public static final String TAG_EXTPARAMS = "EXTPARAMS";
    public static final String TAG_FRONTPROTYPE = "FRONTPROTYPE";
    public static final String TAG_PAGEID = "PAGEID";
    public static final String TAG_PAGENAME = "PAGENAME";
    public static final String TAG_URLAPPENDPARAM = "URLAPPENDPARAM";
    public static final String TAG_HTMLMODE = "HTMLMODE";
    public static final String TAG_USERCONFIRM = "USERCONFIRM";
    public static final String TAG_CLOSEEDITVIEW = "CLOSEEDITVIEW";
    private Properties extParams = null;

    public void InitExtParams() {
        try {
            if (this.extParams != null) {
                return;
            }
            String strExtParams = this.getEXTPARAMS();
            if (!StringHelper.IsNullOrEmpty((String)strExtParams)) {
                this.extParams = new Properties();
                this.extParams = PropertiesHelper.Load((Properties)this.extParams, (String)strExtParams);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public Properties getExtParams() {
        return this.extParams;
    }

    public String GetExtParam(String strName, String strDefault) {
        if (this.extParams == null) {
            return strDefault;
        }
        return PropertiesHelper.GetProperty((Properties)this.extParams, (String)strName, (String)strDefault);
    }

    public boolean isDEBEHAVIORIDNull() {
        return this.IsParamNull(TAG_DEBEHAVIORID);
    }

    public String getDEBEHAVIORID() {
        return this.GetParamStringValue(TAG_DEBEHAVIORID, "");
    }

    public void setDEBEHAVIORID(String strValue) {
        this.SetParamValue(TAG_DEBEHAVIORID, strValue);
    }

    public boolean isDEBEHAVIORNAMENull() {
        return this.IsParamNull(TAG_DEBEHAVIORNAME);
    }

    public String getDEBEHAVIORNAME() {
        return this.GetParamStringValue(TAG_DEBEHAVIORNAME, "");
    }

    public void setDEBEHAVIORNAME(String strValue) {
        this.SetParamValue(TAG_DEBEHAVIORNAME, strValue);
    }

    public boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public boolean isACTIONTARGETNull() {
        return this.IsParamNull(TAG_ACTIONTARGET);
    }

    public String getACTIONTARGET() {
        return this.GetParamStringValue(TAG_ACTIONTARGET, "");
    }

    public void setACTIONTARGET(String strValue) {
        this.SetParamValue(TAG_ACTIONTARGET, strValue);
    }

    public boolean isBHCODENull() {
        return this.IsParamNull(TAG_BHCODE);
    }

    public String getBHCODE() {
        return this.GetParamStringValue(TAG_BHCODE, "");
    }

    public void setBHCODE(String strValue) {
        this.SetParamValue(TAG_BHCODE, strValue);
    }

    public boolean isIMPORTANCENull() {
        return this.IsParamNull(TAG_IMPORTANCE);
    }

    public String getIMPORTANCE() {
        return this.GetParamStringValue(TAG_IMPORTANCE, "");
    }

    public void setIMPORTANCE(String strValue) {
        this.SetParamValue(TAG_IMPORTANCE, strValue);
    }

    public boolean isPROCESSTYPENull() {
        return this.IsParamNull(TAG_PROCESSTYPE);
    }

    public String getPROCESSTYPE() {
        return this.GetParamStringValue(TAG_PROCESSTYPE, "");
    }

    public void setPROCESSTYPE(String strValue) {
        this.SetParamValue(TAG_PROCESSTYPE, strValue);
    }

    public boolean isORDERFLAGNull() {
        return this.IsParamNull(TAG_ORDERFLAG);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int nValue) {
        this.SetParamValue(TAG_ORDERFLAG, nValue);
    }

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int nValue) {
        this.SetParamValue(TAG_VERSION, nValue);
    }

    public boolean isTOOLTIPNull() {
        return this.IsParamNull(TAG_TOOLTIP);
    }

    public String getTOOLTIP() {
        return this.GetParamStringValue(TAG_TOOLTIP, "");
    }

    public void setTOOLTIP(String strValue) {
        this.SetParamValue(TAG_TOOLTIP, strValue);
    }

    public boolean isDENAMENull() {
        return this.IsParamNull(TAG_DENAME);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public boolean isDEVIMAGENAMENull() {
        return this.IsParamNull(TAG_DEVIMAGENAME);
    }

    public String getDEVIMAGENAME() {
        return this.GetParamStringValue(TAG_DEVIMAGENAME, "");
    }

    public void setDEVIMAGENAME(String strValue) {
        this.SetParamValue(TAG_DEVIMAGENAME, strValue);
    }

    public boolean isCAPTIONNull() {
        return this.IsParamNull(TAG_CAPTION);
    }

    public String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
    }

    public boolean isDEIDNull() {
        return this.IsParamNull(TAG_DEID);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public boolean isDEVIMAGEIDNull() {
        return this.IsParamNull(TAG_DEVIMAGEID);
    }

    public String getDEVIMAGEID() {
        return this.GetParamStringValue(TAG_DEVIMAGEID, "");
    }

    public void setDEVIMAGEID(String strValue) {
        this.SetParamValue(TAG_DEVIMAGEID, strValue);
    }

    public boolean isCAPLANRESIDNull() {
        return this.IsParamNull(TAG_CAPLANRESID);
    }

    public String getCAPLANRESID() {
        return this.GetParamStringValue(TAG_CAPLANRESID, "");
    }

    public void setCAPLANRESID(String strValue) {
        this.SetParamValue(TAG_CAPLANRESID, strValue);
    }

    public boolean isCAPLANRESNAMENull() {
        return this.IsParamNull(TAG_CAPLANRESNAME);
    }

    public String getCAPLANRESNAME() {
        return this.GetParamStringValue(TAG_CAPLANRESNAME, "");
    }

    public void setCAPLANRESNAME(String strValue) {
        this.SetParamValue(TAG_CAPLANRESNAME, strValue);
    }

    public boolean isTIPLANRESIDNull() {
        return this.IsParamNull(TAG_TIPLANRESID);
    }

    public String getTIPLANRESID() {
        return this.GetParamStringValue(TAG_TIPLANRESID, "");
    }

    public void setTIPLANRESID(String strValue) {
        this.SetParamValue(TAG_TIPLANRESID, strValue);
    }

    public boolean isTIPLANRESNAMENull() {
        return this.IsParamNull(TAG_TIPLANRESNAME);
    }

    public String getTIPLANRESNAME() {
        return this.GetParamStringValue(TAG_TIPLANRESNAME, "");
    }

    public void setTIPLANRESNAME(String strValue) {
        this.SetParamValue(TAG_TIPLANRESNAME, strValue);
    }

    public boolean isRESOURCEIDNull() {
        return this.IsParamNull(TAG_RESOURCEID);
    }

    public String getRESOURCEID() {
        return this.GetParamStringValue(TAG_RESOURCEID, "");
    }

    public void setRESOURCEID(String strValue) {
        this.SetParamValue(TAG_RESOURCEID, strValue);
    }

    public boolean isDEACTIONIDNull() {
        return this.IsParamNull(TAG_DEACTIONID);
    }

    public String getDEACTIONID() {
        return this.GetParamStringValue(TAG_DEACTIONID, "");
    }

    public void setDEACTIONID(String strValue) {
        this.SetParamValue(TAG_DEACTIONID, strValue);
    }

    public boolean isDEACTIONNAMENull() {
        return this.IsParamNull(TAG_DEACTIONNAME);
    }

    public String getDEACTIONNAME() {
        return this.GetParamStringValue(TAG_DEACTIONNAME, "");
    }

    public void setDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_DEACTIONNAME, strValue);
    }

    public boolean isTIMEOUTNull() {
        return this.IsParamNull(TAG_TIMEOUT);
    }

    public int getTIMEOUT() {
        return this.GetParamIntValue(TAG_TIMEOUT, 0);
    }

    public void setTIMEOUT(int nValue) {
        this.SetParamValue(TAG_TIMEOUT, nValue);
    }

    public boolean isCONFIRMINFONull() {
        return this.IsParamNull(TAG_CONFIRMINFO);
    }

    public String getCONFIRMINFO() {
        return this.GetParamStringValue(TAG_CONFIRMINFO, "");
    }

    public void setCONFIRMINFO(String strValue) {
        this.SetParamValue(TAG_CONFIRMINFO, strValue);
    }

    public boolean isRELOADDATANull() {
        return this.IsParamNull(TAG_RELOADDATA);
    }

    public boolean getRELOADDATA() {
        return this.GetParamIntValue(TAG_RELOADDATA, 0) == 1;
    }

    public void setRELOADDATA(boolean bValue) {
        this.SetParamValue(TAG_RELOADDATA, bValue ? 1 : 0);
    }

    public boolean isDATAACTIONNull() {
        return this.IsParamNull(TAG_DATAACTION);
    }

    public String getDATAACTION() {
        return this.GetParamStringValue(TAG_DATAACTION, "");
    }

    public void setDATAACTION(String strValue) {
        this.SetParamValue(TAG_DATAACTION, strValue);
    }

    public boolean isSUCCESSINFONull() {
        return this.IsParamNull(TAG_SUCCESSINFO);
    }

    public String getSUCCESSINFO() {
        return this.GetParamStringValue(TAG_SUCCESSINFO, "");
    }

    public void setSUCCESSINFO(String strValue) {
        this.SetParamValue(TAG_SUCCESSINFO, strValue);
    }

    public boolean isBEFORECODENull() {
        return this.IsParamNull(TAG_BEFORECODE);
    }

    public String getBEFORECODE() {
        return this.GetParamStringValue(TAG_BEFORECODE, "");
    }

    public void setBEFORECODE(String strValue) {
        this.SetParamValue(TAG_BEFORECODE, strValue);
    }

    public boolean isSUCCESSCODENull() {
        return this.IsParamNull(TAG_SUCCESSCODE);
    }

    public String getSUCCESSCODE() {
        return this.GetParamStringValue(TAG_SUCCESSCODE, "");
    }

    public void setSUCCESSCODE(String strValue) {
        this.SetParamValue(TAG_SUCCESSCODE, strValue);
    }

    public boolean isDEWIZARDIDNull() {
        return this.IsParamNull(TAG_DEWIZARDID);
    }

    public String getDEWIZARDID() {
        return this.GetParamStringValue(TAG_DEWIZARDID, "");
    }

    public void setDEWIZARDID(String strValue) {
        this.SetParamValue(TAG_DEWIZARDID, strValue);
    }

    public boolean isDEWIZARDNAMENull() {
        return this.IsParamNull(TAG_DEWIZARDNAME);
    }

    public String getDEWIZARDNAME() {
        return this.GetParamStringValue(TAG_DEWIZARDNAME, "");
    }

    public void setDEWIZARDNAME(String strValue) {
        this.SetParamValue(TAG_DEWIZARDNAME, strValue);
    }

    public boolean isEXTPARAMSNull() {
        return this.IsParamNull(TAG_EXTPARAMS);
    }

    public String getEXTPARAMS() {
        return this.GetParamStringValue(TAG_EXTPARAMS, "");
    }

    public void setEXTPARAMS(String strValue) {
        this.SetParamValue(TAG_EXTPARAMS, strValue);
    }

    public boolean isFRONTPROTYPENull() {
        return this.IsParamNull(TAG_FRONTPROTYPE);
    }

    public String getFRONTPROTYPE() {
        return this.GetParamStringValue(TAG_FRONTPROTYPE, "");
    }

    public void setFRONTPROTYPE(String strValue) {
        this.SetParamValue(TAG_FRONTPROTYPE, strValue);
    }

    public boolean isPAGEIDNull() {
        return this.IsParamNull(TAG_PAGEID);
    }

    public String getPAGEID() {
        return this.GetParamStringValue(TAG_PAGEID, "");
    }

    public void setPAGEID(String strValue) {
        this.SetParamValue(TAG_PAGEID, strValue);
    }

    public boolean isPAGENAMENull() {
        return this.IsParamNull(TAG_PAGENAME);
    }

    public String getPAGENAME() {
        return this.GetParamStringValue(TAG_PAGENAME, "");
    }

    public void setPAGENAME(String strValue) {
        this.SetParamValue(TAG_PAGENAME, strValue);
    }

    public boolean isURLAPPENDPARAMNull() {
        return this.IsParamNull(TAG_URLAPPENDPARAM);
    }

    public String getURLAPPENDPARAM() {
        return this.GetParamStringValue(TAG_URLAPPENDPARAM, "");
    }

    public void setURLAPPENDPARAM(String strValue) {
        this.SetParamValue(TAG_URLAPPENDPARAM, strValue);
    }

    public boolean isHTMLMODENull() {
        return this.IsParamNull(TAG_HTMLMODE);
    }

    public boolean getHTMLMODE() {
        return this.GetParamIntValue(TAG_HTMLMODE, 0) == 1;
    }

    public void setHTMLMODE(boolean bValue) {
        this.SetParamValue(TAG_HTMLMODE, bValue ? 1 : 0);
    }

    public boolean isUSERCONFIRMNull() {
        return this.IsParamNull(TAG_USERCONFIRM);
    }

    public boolean getUSERCONFIRM() {
        return this.GetParamIntValue(TAG_USERCONFIRM, 0) == 1;
    }

    public void setUSERCONFIRM(boolean bValue) {
        this.SetParamValue(TAG_USERCONFIRM, bValue ? 1 : 0);
    }

    public final boolean isCLOSEEDITVIEWNull() {
        return this.IsParamNull(TAG_CLOSEEDITVIEW);
    }

    public final boolean getCLOSEEDITVIEW() {
        return this.GetParamIntValue(TAG_CLOSEEDITVIEW, 0) == 1;
    }

    public final void setCLOSEEDITVIEW(boolean bValue) {
        this.SetParamValue(TAG_CLOSEEDITVIEW, bValue ? 1 : 0);
    }
}

