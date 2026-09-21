/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.ArrayList;
import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSAppMenuItem
extends BaseDataEntity {
    public static final String AMITEMTYPE_SEPERATOR = "SEPERATOR";
    public static final String AMITEMTYPE_MENUITEM = "MENUITEM";
    public static final String AMITEMTYPE_USERITEM = "USERITEM";
    public static final String AMITEMTYPE_AMREF = "APPMENUREF";
    public static final String TAG_HIDESIDEBAR = "HIDESIDEBAR";
    public static final String TAG_PSAPPMENUITEMID = "PSAPPMENUITEMID";
    public static final String TAG_PSAPPMENUITEMNAME = "PSAPPMENUITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSAPPMENUID = "PSAPPMENUID";
    public static final String TAG_PSAPPMENUNAME = "PSAPPMENUNAME";
    public static final String TAG_PSAPPFUNCID = "PSAPPFUNCID";
    public static final String TAG_PSAPPFUNCNAME = "PSAPPFUNCNAME";
    public static final String TAG_PPSAPPMENUITEMID = "PPSAPPMENUITEMID";
    public static final String TAG_PPSAPPMENUITEMNAME = "PPSAPPMENUITEMNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_LEVELTAG = "LEVELTAG";
    public static final String TAG_LEVELVALUE = "LEVELVALUE";
    public static final String TAG_AMITEMTYPE = "AMITEMTYPE";
    public static final String TAG_OPENDEFAULT = "OPENDEFAULT";
    public static final String TAG_DISABLECLOSE = "DISABLECLOSE";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_HIDDENITEM = "HIDDENITEM";
    public static final String TAG_ENABLEMODE = "ENABLEMODE";
    public static final String TAG_REFPSAPPMENUID = "REFPSAPPMENUID";
    public static final String TAG_REFPSAPPMENUNAME = "REFPSAPPMENUNAME";
    public static final String TAG_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String TAG_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String TAG_COUNTERID = "COUNTERID";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String TAG_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String TAG_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String TAG_MENUITEMSTATE = "MENUITEMSTATE";
    public static final String TAG_FILLEROBJ = "FILLEROBJ";
    private ArrayList<PSAppMenuItem> childPSAppMenuItemList = null;

    public final boolean isPSAPPMENUITEMIDNull() {
        return this.isParamNull(TAG_PSAPPMENUITEMID);
    }

    public final String getPSAPPMENUITEMID() {
        return this.getParamStringValue(TAG_PSAPPMENUITEMID, "");
    }

    public final void setPSAPPMENUITEMID(String strValue) {
        this.setParamValue(TAG_PSAPPMENUITEMID, strValue);
    }

    public final boolean isPSAPPMENUITEMNAMENull() {
        return this.isParamNull(TAG_PSAPPMENUITEMNAME);
    }

    public final String getPSAPPMENUITEMNAME() {
        return this.getParamStringValue(TAG_PSAPPMENUITEMNAME, "");
    }

    public final void setPSAPPMENUITEMNAME(String strValue) {
        this.setParamValue(TAG_PSAPPMENUITEMNAME, strValue);
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

    public final boolean isPSAPPMENUIDNull() {
        return this.isParamNull(TAG_PSAPPMENUID);
    }

    public final String getPSAPPMENUID() {
        return this.getParamStringValue(TAG_PSAPPMENUID, "");
    }

    public final void setPSAPPMENUID(String strValue) {
        this.setParamValue(TAG_PSAPPMENUID, strValue);
    }

    public final boolean isPSAPPMENUNAMENull() {
        return this.isParamNull(TAG_PSAPPMENUNAME);
    }

    public final String getPSAPPMENUNAME() {
        return this.getParamStringValue(TAG_PSAPPMENUNAME, "");
    }

    public final void setPSAPPMENUNAME(String strValue) {
        this.setParamValue(TAG_PSAPPMENUNAME, strValue);
    }

    public final boolean isPSAPPFUNCIDNull() {
        return this.isParamNull(TAG_PSAPPFUNCID);
    }

    public final String getPSAPPFUNCID() {
        return this.getParamStringValue(TAG_PSAPPFUNCID, "");
    }

    public final void setPSAPPFUNCID(String strValue) {
        this.setParamValue(TAG_PSAPPFUNCID, strValue);
    }

    public final boolean isPSAPPFUNCNAMENull() {
        return this.isParamNull(TAG_PSAPPFUNCNAME);
    }

    public final String getPSAPPFUNCNAME() {
        return this.getParamStringValue(TAG_PSAPPFUNCNAME, "");
    }

    public final void setPSAPPFUNCNAME(String strValue) {
        this.setParamValue(TAG_PSAPPFUNCNAME, strValue);
    }

    public final boolean isPPSAPPMENUITEMIDNull() {
        return this.isParamNull(TAG_PPSAPPMENUITEMID);
    }

    public final String getPPSAPPMENUITEMID() {
        return this.getParamStringValue(TAG_PPSAPPMENUITEMID, "");
    }

    public final void setPPSAPPMENUITEMID(String strValue) {
        this.setParamValue(TAG_PPSAPPMENUITEMID, strValue);
    }

    public final boolean isPPSAPPMENUITEMNAMENull() {
        return this.isParamNull(TAG_PPSAPPMENUITEMNAME);
    }

    public final String getPPSAPPMENUITEMNAME() {
        return this.getParamStringValue(TAG_PPSAPPMENUITEMNAME, "");
    }

    public final void setPPSAPPMENUITEMNAME(String strValue) {
        this.setParamValue(TAG_PPSAPPMENUITEMNAME, strValue);
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

    public final boolean isLEVELTAGNull() {
        return this.isParamNull(TAG_LEVELTAG);
    }

    public final String getLEVELTAG() {
        return this.getParamStringValue(TAG_LEVELTAG, "");
    }

    public final void setLEVELTAG(String strValue) {
        this.setParamValue(TAG_LEVELTAG, strValue);
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

    public final boolean isAMITEMTYPENull() {
        return this.isParamNull(TAG_AMITEMTYPE);
    }

    public final String getAMITEMTYPE() {
        return this.getParamStringValue(TAG_AMITEMTYPE, "");
    }

    public final void setAMITEMTYPE(String strValue) {
        this.setParamValue(TAG_AMITEMTYPE, strValue);
    }

    public final boolean isOPENDEFAULTNull() {
        return this.isParamNull(TAG_OPENDEFAULT);
    }

    public final boolean getOPENDEFAULT() {
        return this.getParamIntValue(TAG_OPENDEFAULT, 0) == 1;
    }

    public final void setOPENDEFAULT(boolean bValue) {
        this.setParamValue(TAG_OPENDEFAULT, bValue ? 1 : 0);
    }

    public final boolean isDISABLECLOSENull() {
        return this.isParamNull(TAG_DISABLECLOSE);
    }

    public final boolean getDISABLECLOSE() {
        return this.getParamIntValue(TAG_DISABLECLOSE, 0) == 1;
    }

    public final void setDISABLECLOSE(boolean bValue) {
        this.setParamValue(TAG_DISABLECLOSE, bValue ? 1 : 0);
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

    public final boolean isHIDESIDEBARNull() {
        return this.isParamNull(TAG_HIDESIDEBAR);
    }

    public final boolean getHIDESIDEBAR() {
        return this.getParamIntValue(TAG_HIDESIDEBAR, 0) == 1;
    }

    public final void setHIDESIDEBAR(boolean bValue) {
        this.setParamValue(TAG_HIDESIDEBAR, bValue ? 1 : 0);
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

    public final boolean isENABLEMODENull() {
        return this.isParamNull(TAG_ENABLEMODE);
    }

    public final boolean getENABLEMODE() {
        return this.getParamIntValue(TAG_ENABLEMODE, 0) == 1;
    }

    public final void setENABLEMODE(boolean bValue) {
        this.setParamValue(TAG_ENABLEMODE, bValue ? 1 : 0);
    }

    public final boolean isREFPSAPPMENUIDNull() {
        return this.isParamNull(TAG_REFPSAPPMENUID);
    }

    public final String getREFPSAPPMENUID() {
        return this.getParamStringValue(TAG_REFPSAPPMENUID, "");
    }

    public final void setREFPSAPPMENUID(String strValue) {
        this.setParamValue(TAG_REFPSAPPMENUID, strValue);
    }

    public final boolean isREFPSAPPMENUNAMENull() {
        return this.isParamNull(TAG_REFPSAPPMENUNAME);
    }

    public final String getREFPSAPPMENUNAME() {
        return this.getParamStringValue(TAG_REFPSAPPMENUNAME, "");
    }

    public final void setREFPSAPPMENUNAME(String strValue) {
        this.setParamValue(TAG_REFPSAPPMENUNAME, strValue);
    }

    public final boolean isPSSYSUNIRESIDNull() {
        return this.isParamNull(TAG_PSSYSUNIRESID);
    }

    public final String getPSSYSUNIRESID() {
        return this.getParamStringValue(TAG_PSSYSUNIRESID, "");
    }

    public final void setPSSYSUNIRESID(String strValue) {
        this.setParamValue(TAG_PSSYSUNIRESID, strValue);
    }

    public final boolean isPSSYSUNIRESNAMENull() {
        return this.isParamNull(TAG_PSSYSUNIRESNAME);
    }

    public final String getPSSYSUNIRESNAME() {
        return this.getParamStringValue(TAG_PSSYSUNIRESNAME, "");
    }

    public final void setPSSYSUNIRESNAME(String strValue) {
        this.setParamValue(TAG_PSSYSUNIRESNAME, strValue);
    }

    public final boolean isCOUNTERIDNull() {
        return this.isParamNull(TAG_COUNTERID);
    }

    public final String getCOUNTERID() {
        return this.getParamStringValue(TAG_COUNTERID, "");
    }

    public final void setCOUNTERID(String strValue) {
        this.setParamValue(TAG_COUNTERID, strValue);
    }

    public final boolean isUSERPARAMSNull() {
        return this.isParamNull(TAG_USERPARAMS);
    }

    public final String getUSERPARAMS() {
        return this.getParamStringValue(TAG_USERPARAMS, "");
    }

    public final void setUSERPARAMS(String strValue) {
        this.setParamValue(TAG_USERPARAMS, strValue);
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

    public final boolean isMENUITEMSTATENull() {
        return this.isParamNull(TAG_MENUITEMSTATE);
    }

    public final int getMENUITEMSTATE() {
        return this.getParamIntValue(TAG_MENUITEMSTATE, 0);
    }

    public final void setMENUITEMSTATE(int nValue) {
        this.setParamValue(TAG_MENUITEMSTATE, nValue);
    }

    public final boolean isFILLEROBJNull() {
        return this.isParamNull(TAG_FILLEROBJ);
    }

    public final String getFILLEROBJ() {
        return this.getParamStringValue(TAG_FILLEROBJ, "");
    }

    public final void setFILLEROBJ(String strValue) {
        this.setParamValue(TAG_FILLEROBJ, strValue);
    }

    public ArrayList<PSAppMenuItem> getChildPSAppMenuItems(boolean bCreated) {
        if (this.childPSAppMenuItemList != null) {
            return this.childPSAppMenuItemList;
        }
        if (bCreated) {
            this.childPSAppMenuItemList = new ArrayList();
        }
        return this.childPSAppMenuItemList;
    }

    public void resetChildDatas() {
        if (this.childPSAppMenuItemList != null) {
            this.childPSAppMenuItemList.clear();
            this.childPSAppMenuItemList = null;
        }
    }
}

