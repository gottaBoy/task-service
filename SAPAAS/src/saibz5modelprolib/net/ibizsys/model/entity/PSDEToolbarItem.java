/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.ArrayList;
import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

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
    private ArrayList<PSDEToolbarItem> childPSDEToolbarItemList = null;

    public final boolean isPSDETBITEMIDNull() {
        return this.isParamNull(TAG_PSDETBITEMID);
    }

    public final String getPSDETBITEMID() {
        return this.getParamStringValue(TAG_PSDETBITEMID, "");
    }

    public final void setPSDETBITEMID(String strValue) {
        this.setParamValue(TAG_PSDETBITEMID, strValue);
    }

    public final boolean isPSDETBITEMNAMENull() {
        return this.isParamNull(TAG_PSDETBITEMNAME);
    }

    public final String getPSDETBITEMNAME() {
        return this.getParamStringValue(TAG_PSDETBITEMNAME, "");
    }

    public final void setPSDETBITEMNAME(String strValue) {
        this.setParamValue(TAG_PSDETBITEMNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isTBITEMTYPENull() {
        return this.isParamNull(TAG_TBITEMTYPE);
    }

    public final String getTBITEMTYPE() {
        return this.getParamStringValue(TAG_TBITEMTYPE, "");
    }

    public final void setTBITEMTYPE(String strValue) {
        this.setParamValue(TAG_TBITEMTYPE, strValue);
    }

    public final boolean isPSDETOOLBARIDNull() {
        return this.isParamNull(TAG_PSDETOOLBARID);
    }

    public final String getPSDETOOLBARID() {
        return this.getParamStringValue(TAG_PSDETOOLBARID, "");
    }

    public final void setPSDETOOLBARID(String strValue) {
        this.setParamValue(TAG_PSDETOOLBARID, strValue);
    }

    public final boolean isPSDETOOLBARNAMENull() {
        return this.isParamNull(TAG_PSDETOOLBARNAME);
    }

    public final String getPSDETOOLBARNAME() {
        return this.getParamStringValue(TAG_PSDETOOLBARNAME, "");
    }

    public final void setPSDETOOLBARNAME(String strValue) {
        this.setParamValue(TAG_PSDETOOLBARNAME, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.isParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.getParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.setParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isCAPTIONNull() {
        return this.isParamNull(TAG_CAPTION);
    }

    public final String getCAPTION() {
        return this.getParamStringValue(TAG_CAPTION, "");
    }

    public final void setCAPTION(String strValue) {
        this.setParamValue(TAG_CAPTION, strValue);
    }

    public final boolean isPPSDETBITEMIDNull() {
        return this.isParamNull(TAG_PPSDETBITEMID);
    }

    public final String getPPSDETBITEMID() {
        return this.getParamStringValue(TAG_PPSDETBITEMID, "");
    }

    public final void setPPSDETBITEMID(String strValue) {
        this.setParamValue(TAG_PPSDETBITEMID, strValue);
    }

    public final boolean isPPSDETBITEMNAMENull() {
        return this.isParamNull(TAG_PPSDETBITEMNAME);
    }

    public final String getPPSDETBITEMNAME() {
        return this.getParamStringValue(TAG_PPSDETBITEMNAME, "");
    }

    public final void setPPSDETBITEMNAME(String strValue) {
        this.setParamValue(TAG_PPSDETBITEMNAME, strValue);
    }

    public final boolean isPSDEUIACTIONIDNull() {
        return this.isParamNull(TAG_PSDEUIACTIONID);
    }

    public final String getPSDEUIACTIONID() {
        return this.getParamStringValue(TAG_PSDEUIACTIONID, "");
    }

    public final void setPSDEUIACTIONID(String strValue) {
        this.setParamValue(TAG_PSDEUIACTIONID, strValue);
    }

    public final boolean isPSDEUIACTIONNAMENull() {
        return this.isParamNull(TAG_PSDEUIACTIONNAME);
    }

    public final String getPSDEUIACTIONNAME() {
        return this.getParamStringValue(TAG_PSDEUIACTIONNAME, "");
    }

    public final void setPSDEUIACTIONNAME(String strValue) {
        this.setParamValue(TAG_PSDEUIACTIONNAME, strValue);
    }

    public final boolean isLEVELVALUENull() {
        return this.isParamNull(TAG_LEVELVALUE);
    }

    public final int getLEVELVALUE() {
        return this.getParamIntValue(TAG_LEVELVALUE, 0);
    }

    public final void setLEVELVALUE(int nValue) {
        this.setParamValue(TAG_LEVELVALUE, nValue);
    }

    public final boolean isLEVELTAGNull() {
        return this.isParamNull(TAG_LEVELTAG);
    }

    public final String getLEVELTAG() {
        return this.getParamStringValue(TAG_LEVELTAG, "");
    }

    public final void setLEVELTAG(String strValue) {
        this.setParamValue(TAG_LEVELTAG, strValue);
    }

    public final boolean isSHOWMODENull() {
        return this.isParamNull(TAG_SHOWMODE);
    }

    public final String getSHOWMODE() {
        return this.getParamStringValue(TAG_SHOWMODE, "");
    }

    public final void setSHOWMODE(String strValue) {
        this.setParamValue(TAG_SHOWMODE, strValue);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.isParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.getParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSDEIDNull() {
        return this.isParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.getParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.setParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isDEUACAPNull() {
        return this.isParamNull(TAG_DEUACAP);
    }

    public final String getDEUACAP() {
        return this.getParamStringValue(TAG_DEUACAP, "");
    }

    public final void setDEUACAP(String strValue) {
        this.setParamValue(TAG_DEUACAP, strValue);
    }

    public final boolean isPSSYSCSSIDNull() {
        return this.isParamNull(TAG_PSSYSCSSID);
    }

    public final String getPSSYSCSSID() {
        return this.getParamStringValue(TAG_PSSYSCSSID, "");
    }

    public final void setPSSYSCSSID(String strValue) {
        this.setParamValue(TAG_PSSYSCSSID, strValue);
    }

    public final boolean isPSSYSCSSNAMENull() {
        return this.isParamNull(TAG_PSSYSCSSNAME);
    }

    public final String getPSSYSCSSNAME() {
        return this.getParamStringValue(TAG_PSSYSCSSNAME, "");
    }

    public final void setPSSYSCSSNAME(String strValue) {
        this.setParamValue(TAG_PSSYSCSSNAME, strValue);
    }

    public final boolean isPSSYSIMAGEIDNull() {
        return this.isParamNull(TAG_PSSYSIMAGEID);
    }

    public final String getPSSYSIMAGEID() {
        return this.getParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.setParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.isParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.getParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.setParamValue(TAG_PSSYSIMAGENAME, strValue);
    }

    public final boolean isPSSYSPFPLUGINIDNull() {
        return this.isParamNull(TAG_PSSYSPFPLUGINID);
    }

    public final String getPSSYSPFPLUGINID() {
        return this.getParamStringValue(TAG_PSSYSPFPLUGINID, "");
    }

    public final void setPSSYSPFPLUGINID(String strValue) {
        this.setParamValue(TAG_PSSYSPFPLUGINID, strValue);
    }

    public final boolean isPSSYSPFPLUGINNAMENull() {
        return this.isParamNull(TAG_PSSYSPFPLUGINNAME);
    }

    public final String getPSSYSPFPLUGINNAME() {
        return this.getParamStringValue(TAG_PSSYSPFPLUGINNAME, "");
    }

    public final void setPSSYSPFPLUGINNAME(String strValue) {
        this.setParamValue(TAG_PSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isUIACTIONPARAMSNull() {
        return this.isParamNull(TAG_UIACTIONPARAMS);
    }

    public final String getUIACTIONPARAMS() {
        return this.getParamStringValue(TAG_UIACTIONPARAMS, "");
    }

    public final void setUIACTIONPARAMS(String strValue) {
        this.setParamValue(TAG_UIACTIONPARAMS, strValue);
    }

    public final boolean isSPANFLAGNull() {
        return this.isParamNull(TAG_SPANFLAG);
    }

    public final boolean getSPANFLAG() {
        return this.getParamIntValue(TAG_SPANFLAG, 0) == 1;
    }

    public final void setSPANFLAG(boolean bValue) {
        this.setParamValue(TAG_SPANFLAG, bValue ? 1 : 0);
    }

    public final boolean isRAWCONTENTNull() {
        return this.isParamNull(TAG_RAWCONTENT);
    }

    public final String getRAWCONTENT() {
        return this.getParamStringValue(TAG_RAWCONTENT, "");
    }

    public final void setRAWCONTENT(String strValue) {
        this.setParamValue(TAG_RAWCONTENT, strValue);
    }

    public final boolean isTOOLTIPINFONull() {
        return this.isParamNull(TAG_TOOLTIPINFO);
    }

    public final String getTOOLTIPINFO() {
        return this.getParamStringValue(TAG_TOOLTIPINFO, "");
    }

    public final void setTOOLTIPINFO(String strValue) {
        this.setParamValue(TAG_TOOLTIPINFO, strValue);
    }

    public final boolean isCAPPSLANRESIDNull() {
        return this.isParamNull(TAG_CAPPSLANRESID);
    }

    public final String getCAPPSLANRESID() {
        return this.getParamStringValue(TAG_CAPPSLANRESID, "");
    }

    public final void setCAPPSLANRESID(String strValue) {
        this.setParamValue(TAG_CAPPSLANRESID, strValue);
    }

    public final boolean isCAPPSLANRESNAMENull() {
        return this.isParamNull(TAG_CAPPSLANRESNAME);
    }

    public final String getCAPPSLANRESNAME() {
        return this.getParamStringValue(TAG_CAPPSLANRESNAME, "");
    }

    public final void setCAPPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_CAPPSLANRESNAME, strValue);
    }

    public final boolean isTIPPSLANRESIDNull() {
        return this.isParamNull(TAG_TIPPSLANRESID);
    }

    public final String getTIPPSLANRESID() {
        return this.getParamStringValue(TAG_TIPPSLANRESID, "");
    }

    public final void setTIPPSLANRESID(String strValue) {
        this.setParamValue(TAG_TIPPSLANRESID, strValue);
    }

    public final boolean isTIPPSLANRESNAMENull() {
        return this.isParamNull(TAG_TIPPSLANRESNAME);
    }

    public final String getTIPPSLANRESNAME() {
        return this.getParamStringValue(TAG_TIPPSLANRESNAME, "");
    }

    public final void setTIPPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_TIPPSLANRESNAME, strValue);
    }

    public final boolean isHIDDENITEMNull() {
        return this.isParamNull(TAG_HIDDENITEM);
    }

    public final boolean getHIDDENITEM() {
        return this.getParamIntValue(TAG_HIDDENITEM, 0) == 1;
    }

    public final void setHIDDENITEM(boolean bValue) {
        this.setParamValue(TAG_HIDDENITEM, bValue ? 1 : 0);
    }

    public final boolean isNOPRIVDMNull() {
        return this.isParamNull(TAG_NOPRIVDM);
    }

    public final int getNOPRIVDM() {
        return this.getParamIntValue(TAG_NOPRIVDM, 0);
    }

    public final void setNOPRIVDM(int nValue) {
        this.setParamValue(TAG_NOPRIVDM, nValue);
    }

    public final boolean isGROUPEXTRACTMODENull() {
        return this.isParamNull(TAG_GROUPEXTRACTMODE);
    }

    public final String getGROUPEXTRACTMODE() {
        return this.getParamStringValue(TAG_GROUPEXTRACTMODE, "");
    }

    public final void setGROUPEXTRACTMODE(String strValue) {
        this.setParamValue(TAG_GROUPEXTRACTMODE, strValue);
    }

    public final boolean isACTIONLEVELNull() {
        return this.isParamNull(TAG_ACTIONLEVEL);
    }

    public final int getACTIONLEVEL() {
        return this.getParamIntValue(TAG_ACTIONLEVEL, 0);
    }

    public final void setACTIONLEVEL(int nValue) {
        this.setParamValue(TAG_ACTIONLEVEL, nValue);
    }

    public final boolean isWIDTHNull() {
        return this.isParamNull(TAG_WIDTH);
    }

    public final float getWIDTH() {
        return this.getParamFloatValue(TAG_WIDTH, 0.0f);
    }

    public final void setWIDTH(float fValue) {
        this.setParamValue(TAG_WIDTH, Float.valueOf(fValue));
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

