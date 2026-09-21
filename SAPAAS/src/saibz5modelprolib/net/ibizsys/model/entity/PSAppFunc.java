/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSAppFunc
extends BaseDataEntity {
    public static final String APPFUNCTYPE_APPVIEW = "APPVIEW";
    public static final String APPFUNCTYPE_SUBAPPVIEW = "SUBAPPVIEW";
    public static final String APPFUNCTYPE_OPENHTMLPAGE = "OPENHTMLPAGE";
    public static final String APPFUNCTYPE_CUSTOM = "CUSTOM";
    public static final String OPENMODE_INDEXVIEWTAB = "INDEXVIEWTAB";
    public static final String OPENMODE_INDEXVIEWPOPUP = "INDEXVIEWPOPUP";
    public static final String OPENMODE_INDEXVIEWPOPUPMODAL = "INDEXVIEWPOPUPMODAL";
    public static final String OPENMODE_HTMLPOPUP = "HTMLPOPUP";
    public static final String TAG_PSAPPFUNCID = "PSAPPFUNCID";
    public static final String TAG_PSAPPFUNCNAME = "PSAPPFUNCNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_APPFUNCTYPE = "APPFUNCTYPE";
    public static final String TAG_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String TAG_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_OPENMODE = "OPENMODE";
    public static final String TAG_FUNCSN = "FUNCSN";
    public static final String TAG_PSAPPSUBAPPID = "PSAPPSUBAPPID";
    public static final String TAG_PSAPPSUBAPPNAME = "PSAPPSUBAPPNAME";
    public static final String TAG_PSSUBAPPVIEWID = "PSSUBAPPVIEWID";
    public static final String TAG_PSSUBAPPVIEWNAME = "PSSUBAPPVIEWNAME";
    public static final String TAG_PSSUBAPPID = "PSSUBAPPID";
    public static final String TAG_PSSUBAPPNAME = "PSSUBAPPNAME";
    public static final String TAG_USERDATA = "USERDATA";
    public static final String TAG_USERDATA2 = "USERDATA2";
    public static final String TAG_OPENVIEWPARAM = "OPENVIEWPARAM";
    public static final String TAG_FROMOBJID = "FROMOBJID";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_PSPDTAPPFUNCID = "PSPDTAPPFUNCID";
    public static final String TAG_PSPDTAPPFUNCNAME = "PSPDTAPPFUNCNAME";
    public static final String TAG_PAGEURL = "PAGEURL";
    public static final String TAG_JSCODE = "JSCODE";
    public static final String TAG_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String TAG_NAMEPSLANRESID = "NAMEPSLANRESID";
    public static final String TAG_NAMEPSLANRESNAME = "NAMEPSLANRESNAME";
    public static final String TAG_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String TAG_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String TAG_CODENAME = "CODENAME";

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

    public final boolean isPSSYSAPPIDNull() {
        return this.isParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.getParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.setParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.isParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.getParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.setParamValue(TAG_PSSYSAPPNAME, strValue);
    }

    public final boolean isAPPFUNCTYPENull() {
        return this.isParamNull(TAG_APPFUNCTYPE);
    }

    public final String getAPPFUNCTYPE() {
        return this.getParamStringValue(TAG_APPFUNCTYPE, "");
    }

    public final void setAPPFUNCTYPE(String strValue) {
        this.setParamValue(TAG_APPFUNCTYPE, strValue);
    }

    public final boolean isPSAPPVIEWIDNull() {
        return this.isParamNull(TAG_PSAPPVIEWID);
    }

    public final String getPSAPPVIEWID() {
        return this.getParamStringValue(TAG_PSAPPVIEWID, "");
    }

    public final void setPSAPPVIEWID(String strValue) {
        this.setParamValue(TAG_PSAPPVIEWID, strValue);
    }

    public final boolean isPSAPPVIEWNAMENull() {
        return this.isParamNull(TAG_PSAPPVIEWNAME);
    }

    public final String getPSAPPVIEWNAME() {
        return this.getParamStringValue(TAG_PSAPPVIEWNAME, "");
    }

    public final void setPSAPPVIEWNAME(String strValue) {
        this.setParamValue(TAG_PSAPPVIEWNAME, strValue);
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

    public final boolean isOPENMODENull() {
        return this.isParamNull(TAG_OPENMODE);
    }

    public final String getOPENMODE() {
        return this.getParamStringValue(TAG_OPENMODE, "");
    }

    public final void setOPENMODE(String strValue) {
        this.setParamValue(TAG_OPENMODE, strValue);
    }

    public final boolean isFUNCSNNull() {
        return this.isParamNull(TAG_FUNCSN);
    }

    public final String getFUNCSN() {
        return this.getParamStringValue(TAG_FUNCSN, "");
    }

    public final void setFUNCSN(String strValue) {
        this.setParamValue(TAG_FUNCSN, strValue);
    }

    public final boolean isPSAPPSUBAPPIDNull() {
        return this.isParamNull(TAG_PSAPPSUBAPPID);
    }

    public final String getPSAPPSUBAPPID() {
        return this.getParamStringValue(TAG_PSAPPSUBAPPID, "");
    }

    public final void setPSAPPSUBAPPID(String strValue) {
        this.setParamValue(TAG_PSAPPSUBAPPID, strValue);
    }

    public final boolean isPSAPPSUBAPPNAMENull() {
        return this.isParamNull(TAG_PSAPPSUBAPPNAME);
    }

    public final String getPSAPPSUBAPPNAME() {
        return this.getParamStringValue(TAG_PSAPPSUBAPPNAME, "");
    }

    public final void setPSAPPSUBAPPNAME(String strValue) {
        this.setParamValue(TAG_PSAPPSUBAPPNAME, strValue);
    }

    public final boolean isPSSUBAPPVIEWIDNull() {
        return this.isParamNull(TAG_PSSUBAPPVIEWID);
    }

    public final String getPSSUBAPPVIEWID() {
        return this.getParamStringValue(TAG_PSSUBAPPVIEWID, "");
    }

    public final void setPSSUBAPPVIEWID(String strValue) {
        this.setParamValue(TAG_PSSUBAPPVIEWID, strValue);
    }

    public final boolean isPSSUBAPPVIEWNAMENull() {
        return this.isParamNull(TAG_PSSUBAPPVIEWNAME);
    }

    public final String getPSSUBAPPVIEWNAME() {
        return this.getParamStringValue(TAG_PSSUBAPPVIEWNAME, "");
    }

    public final void setPSSUBAPPVIEWNAME(String strValue) {
        this.setParamValue(TAG_PSSUBAPPVIEWNAME, strValue);
    }

    public final boolean isPSSUBAPPIDNull() {
        return this.isParamNull(TAG_PSSUBAPPID);
    }

    public final String getPSSUBAPPID() {
        return this.getParamStringValue(TAG_PSSUBAPPID, "");
    }

    public final void setPSSUBAPPID(String strValue) {
        this.setParamValue(TAG_PSSUBAPPID, strValue);
    }

    public final boolean isPSSUBAPPNAMENull() {
        return this.isParamNull(TAG_PSSUBAPPNAME);
    }

    public final String getPSSUBAPPNAME() {
        return this.getParamStringValue(TAG_PSSUBAPPNAME, "");
    }

    public final void setPSSUBAPPNAME(String strValue) {
        this.setParamValue(TAG_PSSUBAPPNAME, strValue);
    }

    public final boolean isUSERDATANull() {
        return this.isParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.getParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.setParamValue(TAG_USERDATA, strValue);
    }

    public final boolean isUSERDATA2Null() {
        return this.isParamNull(TAG_USERDATA2);
    }

    public final String getUSERDATA2() {
        return this.getParamStringValue(TAG_USERDATA2, "");
    }

    public final void setUSERDATA2(String strValue) {
        this.setParamValue(TAG_USERDATA2, strValue);
    }

    public final boolean isOPENVIEWPARAMNull() {
        return this.isParamNull(TAG_OPENVIEWPARAM);
    }

    public final String getOPENVIEWPARAM() {
        return this.getParamStringValue(TAG_OPENVIEWPARAM, "");
    }

    public final void setOPENVIEWPARAM(String strValue) {
        this.setParamValue(TAG_OPENVIEWPARAM, strValue);
    }

    public final boolean isFROMOBJIDNull() {
        return this.isParamNull(TAG_FROMOBJID);
    }

    public final String getFROMOBJID() {
        return this.getParamStringValue(TAG_FROMOBJID, "");
    }

    public final void setFROMOBJID(String strValue) {
        this.setParamValue(TAG_FROMOBJID, strValue);
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

    public final boolean isPSPDTAPPFUNCIDNull() {
        return this.isParamNull(TAG_PSPDTAPPFUNCID);
    }

    public final String getPSPDTAPPFUNCID() {
        return this.getParamStringValue(TAG_PSPDTAPPFUNCID, "");
    }

    public final void setPSPDTAPPFUNCID(String strValue) {
        this.setParamValue(TAG_PSPDTAPPFUNCID, strValue);
    }

    public final boolean isPSPDTAPPFUNCNAMENull() {
        return this.isParamNull(TAG_PSPDTAPPFUNCNAME);
    }

    public final String getPSPDTAPPFUNCNAME() {
        return this.getParamStringValue(TAG_PSPDTAPPFUNCNAME, "");
    }

    public final void setPSPDTAPPFUNCNAME(String strValue) {
        this.setParamValue(TAG_PSPDTAPPFUNCNAME, strValue);
    }

    public final boolean isPAGEURLNull() {
        return this.isParamNull(TAG_PAGEURL);
    }

    public final String getPAGEURL() {
        return this.getParamStringValue(TAG_PAGEURL, "");
    }

    public final void setPAGEURL(String strValue) {
        this.setParamValue(TAG_PAGEURL, strValue);
    }

    public final boolean isJSCODENull() {
        return this.isParamNull(TAG_JSCODE);
    }

    public final String getJSCODE() {
        return this.getParamStringValue(TAG_JSCODE, "");
    }

    public final void setJSCODE(String strValue) {
        this.setParamValue(TAG_JSCODE, strValue);
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

    public final boolean isNAMEPSLANRESIDNull() {
        return this.isParamNull(TAG_NAMEPSLANRESID);
    }

    public final String getNAMEPSLANRESID() {
        return this.getParamStringValue(TAG_NAMEPSLANRESID, "");
    }

    public final void setNAMEPSLANRESID(String strValue) {
        this.setParamValue(TAG_NAMEPSLANRESID, strValue);
    }

    public final boolean isNAMEPSLANRESNAMENull() {
        return this.isParamNull(TAG_NAMEPSLANRESNAME);
    }

    public final String getNAMEPSLANRESNAME() {
        return this.getParamStringValue(TAG_NAMEPSLANRESNAME, "");
    }

    public final void setNAMEPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_NAMEPSLANRESNAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
    }
}

