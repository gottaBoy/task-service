/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

public class PSDEToolbarItem
extends BaseDataEntity {
    public static final String TBITEMTYPE_DEUIACTION = "DEUIACTION";
    public static final String TBITEMTYPE_SEPERATOR = "SEPERATOR";
    public static final String TBITEMTYPE_ITEMS = "ITEMS";
    public static final String TBITEMTYPE_RAWITEM = "RAWITEM";
    public static final String SHOWMODE_ICONANDSHORTWORD = "ICONANDSHORTWORD";
    public static final String SHOWMODE_ICON = "ICON";
    public static final String SHOWMODE_SHORTWORD = "SHORTWORD";
    public static final String GROUPEXTRACTMODE_ITEM = "ITEM";
    public static final String GROUPEXTRACTMODE_ITEMS = "ITEMS";
    public static final String TAG_PSDETBITEMID = "PSDETBITEMID";
    public static final String TAG_PSDETBITEMNAME = "PSDETBITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TBITEMTYPE = "TBITEMTYPE";
    public static final String TAG_PSDETOOLBARID = "PSDETOOLBARID";
    public static final String TAG_PSDETOOLBARNAME = "PSDETOOLBARNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_PPSDETBITEMID = "PPSDETBITEMID";
    public static final String TAG_PPSDETBITEMNAME = "PPSDETBITEMNAME";
    public static final String TAG_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String TAG_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String TAG_LEVELVALUE = "LEVELVALUE";
    public static final String TAG_LEVELTAG = "LEVELTAG";
    public static final String TAG_SHOWMODE = "SHOWMODE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_DEUACAP = "DEUACAP";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_UIACTIONPARAMS = "UIACTIONPARAMS";
    public static final String TAG_SPANFLAG = "SPANFLAG";
    public static final String TAG_RAWCONTENT = "RAWCONTENT";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String TAG_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String TAG_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String TAG_HIDDENITEM = "HIDDENITEM";
    public static final String TAG_NOPRIVDM = "NOPRIVDM";
    public static final String TAG_GROUPEXTRACTMODE = "GROUPEXTRACTMODE";
    public static final String TAG_ACTIONLEVEL = "ACTIONLEVEL";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_DATA = "DATA";
    public static final String TAG_CONTENTTYPE = "CONTENTTYPE";
    public static final String TAG_HTMLCONTENT = "HTMLCONTENT";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String TAG_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String TAG_MOBFLAG = "MOBFLAG";
    public static final String TAG_BTNACTIONTYPE = "BTNACTIONTYPE";
    public static final String TAG_BORDERSTYLE = "BORDERSTYLE";
    public static final String TAG_TOGGLEMODE = "TOGGLEMODE";
    public static final String TAG_ITEMSTYLE = "ITEMSTYLE";
    public static final String TAG_ITEMSTYLETEXT = "ITEMSTYLETEXT";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String TAG_PREDEFINEDTYPETEXT = "PREDEFINEDTYPETEXT";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_HTMLPAGEURL = "HTMLPAGEURL";
    public static final String TAG_RAWCSSSTYLE = "RAWCSSSTYLE";
    public static final String TAG_OPENPSSYSPDTVIEWID = "OPENPSSYSPDTVIEWID";
    public static final String TAG_OPENPSSYSPDTVIEWNAME = "OPENPSSYSPDTVIEWNAME";
    public static final String TAG_OPENPSAPPVIEWID = "OPENPSAPPVIEWID";
    public static final String TAG_OPENPSAPPVIEWNAME = "OPENPSAPPVIEWNAME";
    public static final String TAG_OPENPSDEVIEWID = "OPENPSDEVIEWID";
    public static final String TAG_OPENPSDEVIEWNAME = "OPENPSDEVIEWNAME";
    public static final String TAG_DYNACLASS = "DYNACLASS";
    public static final String TAG_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String TAG_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String TAG_TEMPLATEMODE = "TEMPLATEMODE";
    public static final String TAG_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String TAG_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String TAG_COUNTERMODE = "COUNTERMODE";
    public static final String TAG_COUNTERID = "COUNTERID";
    private ArrayList<PSDEToolbarItem> childPSDEToolbarItemList = null;

    public final boolean isPSDETBITEMIDNull() {
        return this.IsParamNull(TAG_PSDETBITEMID);
    }

    public final String getPSDETBITEMID() {
        return this.GetParamStringValue(TAG_PSDETBITEMID, "");
    }

    public final void setPSDETBITEMID(String strValue) {
        this.SetParamValue(TAG_PSDETBITEMID, strValue);
    }

    public final boolean isPSDETBITEMNAMENull() {
        return this.IsParamNull(TAG_PSDETBITEMNAME);
    }

    public final String getPSDETBITEMNAME() {
        return this.GetParamStringValue(TAG_PSDETBITEMNAME, "");
    }

    public final void setPSDETBITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSDETBITEMNAME, strValue);
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

    public final boolean isTBITEMTYPENull() {
        return this.IsParamNull(TAG_TBITEMTYPE);
    }

    public final String getTBITEMTYPE() {
        return this.GetParamStringValue(TAG_TBITEMTYPE, "");
    }

    public final void setTBITEMTYPE(String strValue) {
        this.SetParamValue(TAG_TBITEMTYPE, strValue);
    }

    public final boolean isPSDETOOLBARIDNull() {
        return this.IsParamNull(TAG_PSDETOOLBARID);
    }

    public final String getPSDETOOLBARID() {
        return this.GetParamStringValue(TAG_PSDETOOLBARID, "");
    }

    public final void setPSDETOOLBARID(String strValue) {
        this.SetParamValue(TAG_PSDETOOLBARID, strValue);
    }

    public final boolean isPSDETOOLBARNAMENull() {
        return this.IsParamNull(TAG_PSDETOOLBARNAME);
    }

    public final String getPSDETOOLBARNAME() {
        return this.GetParamStringValue(TAG_PSDETOOLBARNAME, "");
    }

    public final void setPSDETOOLBARNAME(String strValue) {
        this.SetParamValue(TAG_PSDETOOLBARNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isCAPTIONNull() {
        return this.IsParamNull(TAG_CAPTION);
    }

    public final String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public final void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
    }

    public final boolean isPPSDETBITEMIDNull() {
        return this.IsParamNull(TAG_PPSDETBITEMID);
    }

    public final String getPPSDETBITEMID() {
        return this.GetParamStringValue(TAG_PPSDETBITEMID, "");
    }

    public final void setPPSDETBITEMID(String strValue) {
        this.SetParamValue(TAG_PPSDETBITEMID, strValue);
    }

    public final boolean isPPSDETBITEMNAMENull() {
        return this.IsParamNull(TAG_PPSDETBITEMNAME);
    }

    public final String getPPSDETBITEMNAME() {
        return this.GetParamStringValue(TAG_PPSDETBITEMNAME, "");
    }

    public final void setPPSDETBITEMNAME(String strValue) {
        this.SetParamValue(TAG_PPSDETBITEMNAME, strValue);
    }

    public final boolean isPSDEUIACTIONIDNull() {
        return this.IsParamNull(TAG_PSDEUIACTIONID);
    }

    public final String getPSDEUIACTIONID() {
        return this.GetParamStringValue(TAG_PSDEUIACTIONID, "");
    }

    public final void setPSDEUIACTIONID(String strValue) {
        this.SetParamValue(TAG_PSDEUIACTIONID, strValue);
    }

    public final boolean isPSDEUIACTIONNAMENull() {
        return this.IsParamNull(TAG_PSDEUIACTIONNAME);
    }

    public final String getPSDEUIACTIONNAME() {
        return this.GetParamStringValue(TAG_PSDEUIACTIONNAME, "");
    }

    public final void setPSDEUIACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDEUIACTIONNAME, strValue);
    }

    public final boolean isLEVELVALUENull() {
        return this.IsParamNull(TAG_LEVELVALUE);
    }

    public final int getLEVELVALUE() {
        return this.GetParamIntValue(TAG_LEVELVALUE, 0);
    }

    public final void setLEVELVALUE(int nValue) {
        this.SetParamValue(TAG_LEVELVALUE, nValue);
    }

    public final boolean isLEVELTAGNull() {
        return this.IsParamNull(TAG_LEVELTAG);
    }

    public final String getLEVELTAG() {
        return this.GetParamStringValue(TAG_LEVELTAG, "");
    }

    public final void setLEVELTAG(String strValue) {
        this.SetParamValue(TAG_LEVELTAG, strValue);
    }

    public final boolean isSHOWMODENull() {
        return this.IsParamNull(TAG_SHOWMODE);
    }

    public final String getSHOWMODE() {
        return this.GetParamStringValue(TAG_SHOWMODE, "");
    }

    public final void setSHOWMODE(String strValue) {
        this.SetParamValue(TAG_SHOWMODE, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
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

    public final boolean isDEUACAPNull() {
        return this.IsParamNull(TAG_DEUACAP);
    }

    public final String getDEUACAP() {
        return this.GetParamStringValue(TAG_DEUACAP, "");
    }

    public final void setDEUACAP(String strValue) {
        this.SetParamValue(TAG_DEUACAP, strValue);
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

    public final boolean isUIACTIONPARAMSNull() {
        return this.IsParamNull(TAG_UIACTIONPARAMS);
    }

    public final String getUIACTIONPARAMS() {
        return this.GetParamStringValue(TAG_UIACTIONPARAMS, "");
    }

    public final void setUIACTIONPARAMS(String strValue) {
        this.SetParamValue(TAG_UIACTIONPARAMS, strValue);
    }

    public final boolean isSPANFLAGNull() {
        return this.IsParamNull(TAG_SPANFLAG);
    }

    public final boolean getSPANFLAG() {
        return this.GetParamIntValue(TAG_SPANFLAG, 0) == 1;
    }

    public final void setSPANFLAG(boolean bValue) {
        this.SetParamValue(TAG_SPANFLAG, bValue ? 1 : 0);
    }

    public final boolean isRAWCONTENTNull() {
        return this.IsParamNull(TAG_RAWCONTENT);
    }

    public final String getRAWCONTENT() {
        return this.GetParamStringValue(TAG_RAWCONTENT, "");
    }

    public final void setRAWCONTENT(String strValue) {
        this.SetParamValue(TAG_RAWCONTENT, strValue);
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

    public final boolean isCAPPSLANRESIDNull() {
        return this.IsParamNull(TAG_CAPPSLANRESID);
    }

    public final String getCAPPSLANRESID() {
        return this.GetParamStringValue(TAG_CAPPSLANRESID, "");
    }

    public final void setCAPPSLANRESID(String strValue) {
        this.SetParamValue(TAG_CAPPSLANRESID, strValue);
    }

    public final boolean isCAPPSLANRESNAMENull() {
        return this.IsParamNull(TAG_CAPPSLANRESNAME);
    }

    public final String getCAPPSLANRESNAME() {
        return this.GetParamStringValue(TAG_CAPPSLANRESNAME, "");
    }

    public final void setCAPPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_CAPPSLANRESNAME, strValue);
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

    public final boolean isHIDDENITEMNull() {
        return this.IsParamNull(TAG_HIDDENITEM);
    }

    public final boolean getHIDDENITEM() {
        return this.GetParamIntValue(TAG_HIDDENITEM, 0) == 1;
    }

    public final void setHIDDENITEM(boolean bValue) {
        this.SetParamValue(TAG_HIDDENITEM, bValue ? 1 : 0);
    }

    public final boolean isNOPRIVDMNull() {
        return this.IsParamNull(TAG_NOPRIVDM);
    }

    public final int getNOPRIVDM() {
        return this.GetParamIntValue(TAG_NOPRIVDM, 0);
    }

    public final void setNOPRIVDM(int nValue) {
        this.SetParamValue(TAG_NOPRIVDM, nValue);
    }

    public final boolean isGROUPEXTRACTMODENull() {
        return this.IsParamNull(TAG_GROUPEXTRACTMODE);
    }

    public final String getGROUPEXTRACTMODE() {
        return this.GetParamStringValue(TAG_GROUPEXTRACTMODE, "");
    }

    public final void setGROUPEXTRACTMODE(String strValue) {
        this.SetParamValue(TAG_GROUPEXTRACTMODE, strValue);
    }

    public final boolean isACTIONLEVELNull() {
        return this.IsParamNull(TAG_ACTIONLEVEL);
    }

    public final int getACTIONLEVEL() {
        return this.GetParamIntValue(TAG_ACTIONLEVEL, 0);
    }

    public final void setACTIONLEVEL(int nValue) {
        this.SetParamValue(TAG_ACTIONLEVEL, nValue);
    }

    public final boolean isWIDTHNull() {
        return this.IsParamNull(TAG_WIDTH);
    }

    public final float getWIDTH() {
        return this.GetParamFloatValue(TAG_WIDTH, 0.0f);
    }

    public final void setWIDTH(float fValue) {
        this.SetParamValue(TAG_WIDTH, Float.valueOf(fValue));
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

    public final boolean isDATANull() {
        return this.IsParamNull(TAG_DATA);
    }

    public final String getDATA() {
        return this.GetParamStringValue(TAG_DATA, "");
    }

    public final void setDATA(String strValue) {
        this.SetParamValue(TAG_DATA, strValue);
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

    public final boolean isHTMLCONTENTNull() {
        return this.IsParamNull(TAG_HTMLCONTENT);
    }

    public final String getHTMLCONTENT() {
        return this.GetParamStringValue(TAG_HTMLCONTENT, "");
    }

    public final void setHTMLCONTENT(String strValue) {
        this.SetParamValue(TAG_HTMLCONTENT, strValue);
    }

    public final boolean isHEIGHTNull() {
        return this.IsParamNull(TAG_HEIGHT);
    }

    public final float getHEIGHT() {
        return this.GetParamFloatValue(TAG_HEIGHT, 0.0f);
    }

    public final void setHEIGHT(float fValue) {
        this.SetParamValue(TAG_HEIGHT, Float.valueOf(fValue));
    }

    public final boolean isMOBFLAGNull() {
        return this.IsParamNull(TAG_MOBFLAG);
    }

    public final boolean getMOBFLAG() {
        return this.GetParamIntValue(TAG_MOBFLAG, 0) == 1;
    }

    public final void setMOBFLAG(boolean bValue) {
        this.SetParamValue(TAG_MOBFLAG, bValue ? 1 : 0);
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

    public final boolean isBTNACTIONTYPENull() {
        return this.IsParamNull(TAG_BTNACTIONTYPE);
    }

    public final String getBTNACTIONTYPE() {
        return this.GetParamStringValue(TAG_BTNACTIONTYPE, "");
    }

    public final void setBTNACTIONTYPE(String strValue) {
        this.SetParamValue(TAG_BTNACTIONTYPE, strValue);
    }

    public final boolean isBORDERSTYLENull() {
        return this.IsParamNull(TAG_BORDERSTYLE);
    }

    public final String getBORDERSTYLE() {
        return this.GetParamStringValue(TAG_BORDERSTYLE, "");
    }

    public final void setBORDERSTYLE(String strValue) {
        this.SetParamValue(TAG_BORDERSTYLE, strValue);
    }

    public final boolean isTOGGLEMODENull() {
        return this.IsParamNull(TAG_TOGGLEMODE);
    }

    public final String getTOGGLEMODE() {
        return this.GetParamStringValue(TAG_TOGGLEMODE, "");
    }

    public final void setTOGGLEMODE(String strValue) {
        this.SetParamValue(TAG_TOGGLEMODE, strValue);
    }

    public final boolean isITEMSTYLENull() {
        return this.IsParamNull(TAG_ITEMSTYLE);
    }

    public final String getITEMSTYLE() {
        return this.GetParamStringValue(TAG_ITEMSTYLE, "");
    }

    public final void setITEMSTYLE(String strValue) {
        this.SetParamValue(TAG_ITEMSTYLE, strValue);
    }

    public final boolean isITEMSTYLETEXTNull() {
        return this.IsParamNull(TAG_ITEMSTYLETEXT);
    }

    public final String getITEMSTYLETEXT() {
        return this.GetParamStringValue(TAG_ITEMSTYLETEXT, "");
    }

    public final void setITEMSTYLETEXT(String strValue) {
        this.SetParamValue(TAG_ITEMSTYLETEXT, strValue);
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

    public final boolean isPREDEFINEDTYPENull() {
        return this.IsParamNull(TAG_PREDEFINEDTYPE);
    }

    public final String getPREDEFINEDTYPE() {
        return this.GetParamStringValue(TAG_PREDEFINEDTYPE, "");
    }

    public final void setPREDEFINEDTYPE(String strValue) {
        this.SetParamValue(TAG_PREDEFINEDTYPE, strValue);
    }

    public final boolean isPREDEFINEDTYPETEXTNull() {
        return this.IsParamNull(TAG_PREDEFINEDTYPETEXT);
    }

    public final String getPREDEFINEDTYPETEXT() {
        return this.GetParamStringValue(TAG_PREDEFINEDTYPETEXT, "");
    }

    public final void setPREDEFINEDTYPETEXT(String strValue) {
        this.SetParamValue(TAG_PREDEFINEDTYPETEXT, strValue);
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

    public final boolean isCUSTOMCODENull() {
        return this.IsParamNull(TAG_CUSTOMCODE);
    }

    public final String getCUSTOMCODE() {
        return this.GetParamStringValue(TAG_CUSTOMCODE, "");
    }

    public final void setCUSTOMCODE(String strValue) {
        this.SetParamValue(TAG_CUSTOMCODE, strValue);
    }

    public final boolean isHTMLPAGEURLNull() {
        return this.IsParamNull(TAG_HTMLPAGEURL);
    }

    public final String getHTMLPAGEURL() {
        return this.GetParamStringValue(TAG_HTMLPAGEURL, "");
    }

    public final void setHTMLPAGEURL(String strValue) {
        this.SetParamValue(TAG_HTMLPAGEURL, strValue);
    }

    public final boolean isRAWCSSSTYLENull() {
        return this.IsParamNull(TAG_RAWCSSSTYLE);
    }

    public final String getRAWCSSSTYLE() {
        return this.GetParamStringValue(TAG_RAWCSSSTYLE, "");
    }

    public final void setRAWCSSSTYLE(String strValue) {
        this.SetParamValue(TAG_RAWCSSSTYLE, strValue);
    }

    public final boolean isOPENPSSYSPDTVIEWIDNull() {
        return this.IsParamNull(TAG_OPENPSSYSPDTVIEWID);
    }

    public final String getOPENPSSYSPDTVIEWID() {
        return this.GetParamStringValue(TAG_OPENPSSYSPDTVIEWID, "");
    }

    public final void setOPENPSSYSPDTVIEWID(String strValue) {
        this.SetParamValue(TAG_OPENPSSYSPDTVIEWID, strValue);
    }

    public final boolean isOPENPSSYSPDTVIEWNAMENull() {
        return this.IsParamNull(TAG_OPENPSSYSPDTVIEWNAME);
    }

    public final String getOPENPSSYSPDTVIEWNAME() {
        return this.GetParamStringValue(TAG_OPENPSSYSPDTVIEWNAME, "");
    }

    public final void setOPENPSSYSPDTVIEWNAME(String strValue) {
        this.SetParamValue(TAG_OPENPSSYSPDTVIEWNAME, strValue);
    }

    public final boolean isOPENPSAPPVIEWIDNull() {
        return this.IsParamNull(TAG_OPENPSAPPVIEWID);
    }

    public final String getOPENPSAPPVIEWID() {
        return this.GetParamStringValue(TAG_OPENPSAPPVIEWID, "");
    }

    public final void setOPENPSAPPVIEWID(String strValue) {
        this.SetParamValue(TAG_OPENPSAPPVIEWID, strValue);
    }

    public final boolean isOPENPSAPPVIEWNAMENull() {
        return this.IsParamNull(TAG_OPENPSAPPVIEWNAME);
    }

    public final String getOPENPSAPPVIEWNAME() {
        return this.GetParamStringValue(TAG_OPENPSAPPVIEWNAME, "");
    }

    public final void setOPENPSAPPVIEWNAME(String strValue) {
        this.SetParamValue(TAG_OPENPSAPPVIEWNAME, strValue);
    }

    public final boolean isOPENPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_OPENPSDEVIEWID);
    }

    public final String getOPENPSDEVIEWID() {
        return this.GetParamStringValue(TAG_OPENPSDEVIEWID, "");
    }

    public final void setOPENPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_OPENPSDEVIEWID, strValue);
    }

    public final boolean isOPENPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_OPENPSDEVIEWNAME);
    }

    public final String getOPENPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_OPENPSDEVIEWNAME, "");
    }

    public final void setOPENPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_OPENPSDEVIEWNAME, strValue);
    }

    public final boolean isDYNACLASSNull() {
        return this.IsParamNull(TAG_DYNACLASS);
    }

    public final String getDYNACLASS() {
        return this.GetParamStringValue(TAG_DYNACLASS, "");
    }

    public final void setDYNACLASS(String strValue) {
        this.SetParamValue(TAG_DYNACLASS, strValue);
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

    public final boolean isPSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_PSDEUAGROUPID);
    }

    public final String getPSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_PSDEUAGROUPID, "");
    }

    public final void setPSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_PSDEUAGROUPID, strValue);
    }

    public final boolean isPSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_PSDEUAGROUPNAME);
    }

    public final String getPSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_PSDEUAGROUPNAME, "");
    }

    public final void setPSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEUAGROUPNAME, strValue);
    }

    public final boolean isPSSYSUNIRESIDNull() {
        return this.IsParamNull(TAG_PSSYSUNIRESID);
    }

    public final String getPSSYSUNIRESID() {
        return this.GetParamStringValue(TAG_PSSYSUNIRESID, "");
    }

    public final void setPSSYSUNIRESID(String strValue) {
        this.SetParamValue(TAG_PSSYSUNIRESID, strValue);
    }

    public final boolean isPSSYSUNIRESNAMENull() {
        return this.IsParamNull(TAG_PSSYSUNIRESNAME);
    }

    public final String getPSSYSUNIRESNAME() {
        return this.GetParamStringValue(TAG_PSSYSUNIRESNAME, "");
    }

    public final void setPSSYSUNIRESNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUNIRESNAME, strValue);
    }

    public final boolean isCOUNTERMODENull() {
        return this.IsParamNull(TAG_COUNTERMODE);
    }

    public final int getCOUNTERMODE() {
        return this.GetParamIntValue(TAG_COUNTERMODE, 0);
    }

    public final void setCOUNTERMODE(int nValue) {
        this.SetParamValue(TAG_COUNTERMODE, nValue);
    }

    public final boolean isCOUNTERIDNull() {
        return this.IsParamNull(TAG_COUNTERID);
    }

    public final String getCOUNTERID() {
        return this.GetParamStringValue(TAG_COUNTERID, "");
    }

    public final void setCOUNTERID(String strValue) {
        this.SetParamValue(TAG_COUNTERID, strValue);
    }

    public ArrayList<PSDEToolbarItem> getChildPSDEToolbarItems(boolean bCreated) {
        if (this.childPSDEToolbarItemList != null) {
            return this.childPSDEToolbarItemList;
        }
        if (bCreated) {
            this.childPSDEToolbarItemList = new ArrayList();
        }
        return this.childPSDEToolbarItemList;
    }

    public void resetChildDatas() {
        if (this.childPSDEToolbarItemList != null) {
            this.childPSDEToolbarItemList.clear();
            this.childPSDEToolbarItemList = null;
        }
    }
}

