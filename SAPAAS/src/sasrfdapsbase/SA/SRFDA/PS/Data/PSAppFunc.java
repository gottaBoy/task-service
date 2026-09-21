/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppFunc
extends BaseDataEntity {
    public static final String APPFUNCTYPE_APPVIEW = "APPVIEW";
    public static final String APPFUNCTYPE_SUBAPPVIEW = "SUBAPPVIEW";
    public static final String APPFUNCTYPE_OPENHTMLPAGE = "OPENHTMLPAGE";
    public static final String APPFUNCTYPE_UIACTION = "UIACTION";
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
    public static final String TAG_DYNAINSTTAG = "DYNAINSTTAG";
    public static final String TAG_DYNAINSTTAG2 = "DYNAINSTTAG2";
    public static final String TAG_SYSTEMFLAG = "SYSTEMFLAG";
    public static final String TAG_PSAPPLOCALDEID = "PSAPPLOCALDEID";
    public static final String TAG_PSAPPLOCALDENAME = "PSAPPLOCALDENAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String TAG_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String TAG_PREDEFINEDTYPEPARAM = "PREDEFINEDTYPEPARAM";
    public static final String TAG_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String TAG_PSDEACMODEID = "PSDEACMODEID";
    public static final String TAG_PSDEACMODENAME = "PSDEACMODENAME";

    public final boolean isPSAPPFUNCIDNull() {
        return this.IsParamNull(TAG_PSAPPFUNCID);
    }

    public final String getPSAPPFUNCID() {
        return this.GetParamStringValue(TAG_PSAPPFUNCID, "");
    }

    public final void setPSAPPFUNCID(String strValue) {
        this.SetParamValue(TAG_PSAPPFUNCID, strValue);
    }

    public final boolean isPSAPPFUNCNAMENull() {
        return this.IsParamNull(TAG_PSAPPFUNCNAME);
    }

    public final String getPSAPPFUNCNAME() {
        return this.GetParamStringValue(TAG_PSAPPFUNCNAME, "");
    }

    public final void setPSAPPFUNCNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPFUNCNAME, strValue);
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

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME, strValue);
    }

    public final boolean isAPPFUNCTYPENull() {
        return this.IsParamNull(TAG_APPFUNCTYPE);
    }

    public final String getAPPFUNCTYPE() {
        return this.GetParamStringValue(TAG_APPFUNCTYPE, "");
    }

    public final void setAPPFUNCTYPE(String strValue) {
        this.SetParamValue(TAG_APPFUNCTYPE, strValue);
    }

    public final boolean isPSAPPVIEWIDNull() {
        return this.IsParamNull(TAG_PSAPPVIEWID);
    }

    public final String getPSAPPVIEWID() {
        return this.GetParamStringValue(TAG_PSAPPVIEWID, "");
    }

    public final void setPSAPPVIEWID(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWID, strValue);
    }

    public final boolean isPSAPPVIEWNAMENull() {
        return this.IsParamNull(TAG_PSAPPVIEWNAME);
    }

    public final String getPSAPPVIEWNAME() {
        return this.GetParamStringValue(TAG_PSAPPVIEWNAME, "");
    }

    public final void setPSAPPVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWNAME, strValue);
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

    public final boolean isOPENMODENull() {
        return this.IsParamNull(TAG_OPENMODE);
    }

    public final String getOPENMODE() {
        return this.GetParamStringValue(TAG_OPENMODE, "");
    }

    public final void setOPENMODE(String strValue) {
        this.SetParamValue(TAG_OPENMODE, strValue);
    }

    public final boolean isFUNCSNNull() {
        return this.IsParamNull(TAG_FUNCSN);
    }

    public final String getFUNCSN() {
        return this.GetParamStringValue(TAG_FUNCSN, "");
    }

    public final void setFUNCSN(String strValue) {
        this.SetParamValue(TAG_FUNCSN, strValue);
    }

    public final boolean isPSAPPSUBAPPIDNull() {
        return this.IsParamNull(TAG_PSAPPSUBAPPID);
    }

    public final String getPSAPPSUBAPPID() {
        return this.GetParamStringValue(TAG_PSAPPSUBAPPID, "");
    }

    public final void setPSAPPSUBAPPID(String strValue) {
        this.SetParamValue(TAG_PSAPPSUBAPPID, strValue);
    }

    public final boolean isPSAPPSUBAPPNAMENull() {
        return this.IsParamNull(TAG_PSAPPSUBAPPNAME);
    }

    public final String getPSAPPSUBAPPNAME() {
        return this.GetParamStringValue(TAG_PSAPPSUBAPPNAME, "");
    }

    public final void setPSAPPSUBAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPSUBAPPNAME, strValue);
    }

    public final boolean isPSSUBAPPVIEWIDNull() {
        return this.IsParamNull(TAG_PSSUBAPPVIEWID);
    }

    public final String getPSSUBAPPVIEWID() {
        return this.GetParamStringValue(TAG_PSSUBAPPVIEWID, "");
    }

    public final void setPSSUBAPPVIEWID(String strValue) {
        this.SetParamValue(TAG_PSSUBAPPVIEWID, strValue);
    }

    public final boolean isPSSUBAPPVIEWNAMENull() {
        return this.IsParamNull(TAG_PSSUBAPPVIEWNAME);
    }

    public final String getPSSUBAPPVIEWNAME() {
        return this.GetParamStringValue(TAG_PSSUBAPPVIEWNAME, "");
    }

    public final void setPSSUBAPPVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSSUBAPPVIEWNAME, strValue);
    }

    public final boolean isPSSUBAPPIDNull() {
        return this.IsParamNull(TAG_PSSUBAPPID);
    }

    public final String getPSSUBAPPID() {
        return this.GetParamStringValue(TAG_PSSUBAPPID, "");
    }

    public final void setPSSUBAPPID(String strValue) {
        this.SetParamValue(TAG_PSSUBAPPID, strValue);
    }

    public final boolean isPSSUBAPPNAMENull() {
        return this.IsParamNull(TAG_PSSUBAPPNAME);
    }

    public final String getPSSUBAPPNAME() {
        return this.GetParamStringValue(TAG_PSSUBAPPNAME, "");
    }

    public final void setPSSUBAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSUBAPPNAME, strValue);
    }

    public final boolean isUSERDATANull() {
        return this.IsParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.GetParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.SetParamValue(TAG_USERDATA, strValue);
    }

    public final boolean isUSERDATA2Null() {
        return this.IsParamNull(TAG_USERDATA2);
    }

    public final String getUSERDATA2() {
        return this.GetParamStringValue(TAG_USERDATA2, "");
    }

    public final void setUSERDATA2(String strValue) {
        this.SetParamValue(TAG_USERDATA2, strValue);
    }

    public final boolean isOPENVIEWPARAMNull() {
        return this.IsParamNull(TAG_OPENVIEWPARAM);
    }

    public final String getOPENVIEWPARAM() {
        return this.GetParamStringValue(TAG_OPENVIEWPARAM, "");
    }

    public final void setOPENVIEWPARAM(String strValue) {
        this.SetParamValue(TAG_OPENVIEWPARAM, strValue);
    }

    public final boolean isFROMOBJIDNull() {
        return this.IsParamNull(TAG_FROMOBJID);
    }

    public final String getFROMOBJID() {
        return this.GetParamStringValue(TAG_FROMOBJID, "");
    }

    public final void setFROMOBJID(String strValue) {
        this.SetParamValue(TAG_FROMOBJID, strValue);
    }

    public final boolean isUSERPARAMSNull() {
        return this.IsParamNull(TAG_USERPARAMS);
    }

    public final String getUSERPARAMS() {
        return this.GetParamStringValue(TAG_USERPARAMS, "");
    }

    public final void setUSERPARAMS(String strValue) {
        this.SetParamValue(TAG_USERPARAMS, strValue);
    }

    public final boolean isPSPDTAPPFUNCIDNull() {
        return this.IsParamNull(TAG_PSPDTAPPFUNCID);
    }

    public final String getPSPDTAPPFUNCID() {
        return this.GetParamStringValue(TAG_PSPDTAPPFUNCID, "");
    }

    public final void setPSPDTAPPFUNCID(String strValue) {
        this.SetParamValue(TAG_PSPDTAPPFUNCID, strValue);
    }

    public final boolean isPSPDTAPPFUNCNAMENull() {
        return this.IsParamNull(TAG_PSPDTAPPFUNCNAME);
    }

    public final String getPSPDTAPPFUNCNAME() {
        return this.GetParamStringValue(TAG_PSPDTAPPFUNCNAME, "");
    }

    public final void setPSPDTAPPFUNCNAME(String strValue) {
        this.SetParamValue(TAG_PSPDTAPPFUNCNAME, strValue);
    }

    public final boolean isPAGEURLNull() {
        return this.IsParamNull(TAG_PAGEURL);
    }

    public final String getPAGEURL() {
        return this.GetParamStringValue(TAG_PAGEURL, "");
    }

    public final void setPAGEURL(String strValue) {
        this.SetParamValue(TAG_PAGEURL, strValue);
    }

    public final boolean isJSCODENull() {
        return this.IsParamNull(TAG_JSCODE);
    }

    public final String getJSCODE() {
        return this.GetParamStringValue(TAG_JSCODE, "");
    }

    public final void setJSCODE(String strValue) {
        this.SetParamValue(TAG_JSCODE, strValue);
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

    public final boolean isNAMEPSLANRESIDNull() {
        return this.IsParamNull(TAG_NAMEPSLANRESID);
    }

    public final String getNAMEPSLANRESID() {
        return this.GetParamStringValue(TAG_NAMEPSLANRESID, "");
    }

    public final void setNAMEPSLANRESID(String strValue) {
        this.SetParamValue(TAG_NAMEPSLANRESID, strValue);
    }

    public final boolean isNAMEPSLANRESNAMENull() {
        return this.IsParamNull(TAG_NAMEPSLANRESNAME);
    }

    public final String getNAMEPSLANRESNAME() {
        return this.GetParamStringValue(TAG_NAMEPSLANRESNAME, "");
    }

    public final void setNAMEPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_NAMEPSLANRESNAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isDYNAINSTTAGNull() {
        return this.IsParamNull(TAG_DYNAINSTTAG);
    }

    public final String getDYNAINSTTAG() {
        return this.GetParamStringValue(TAG_DYNAINSTTAG, "");
    }

    public final void setDYNAINSTTAG(String strValue) {
        this.SetParamValue(TAG_DYNAINSTTAG, strValue);
    }

    public final boolean isDYNAINSTTAG2Null() {
        return this.IsParamNull(TAG_DYNAINSTTAG2);
    }

    public final String getDYNAINSTTAG2() {
        return this.GetParamStringValue(TAG_DYNAINSTTAG2, "");
    }

    public final void setDYNAINSTTAG2(String strValue) {
        this.SetParamValue(TAG_DYNAINSTTAG2, strValue);
    }

    public final boolean isSYSTEMFLAGNull() {
        return this.IsParamNull(TAG_SYSTEMFLAG);
    }

    public final boolean getSYSTEMFLAG() {
        return this.GetParamIntValue(TAG_SYSTEMFLAG, 0) == 1;
    }

    public final void setSYSTEMFLAG(boolean bValue) {
        this.SetParamValue(TAG_SYSTEMFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSAPPLOCALDEIDNull() {
        return this.IsParamNull(TAG_PSAPPLOCALDEID);
    }

    public final String getPSAPPLOCALDEID() {
        return this.GetParamStringValue(TAG_PSAPPLOCALDEID, "");
    }

    public final void setPSAPPLOCALDEID(String strValue) {
        this.SetParamValue(TAG_PSAPPLOCALDEID, strValue);
    }

    public final boolean isPSAPPLOCALDENAMENull() {
        return this.IsParamNull(TAG_PSAPPLOCALDENAME);
    }

    public final String getPSAPPLOCALDENAME() {
        return this.GetParamStringValue(TAG_PSAPPLOCALDENAME, "");
    }

    public final void setPSAPPLOCALDENAME(String strValue) {
        this.SetParamValue(TAG_PSAPPLOCALDENAME, strValue);
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

    public final boolean isPREDEFINEDTYPEPARAMNull() {
        return this.IsParamNull(TAG_PREDEFINEDTYPEPARAM);
    }

    public final String getPREDEFINEDTYPEPARAM() {
        return this.GetParamStringValue(TAG_PREDEFINEDTYPEPARAM, "");
    }

    public final void setPREDEFINEDTYPEPARAM(String strValue) {
        this.SetParamValue(TAG_PREDEFINEDTYPEPARAM, strValue);
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

    public final boolean isPSDEACMODEIDNull() {
        return this.IsParamNull(TAG_PSDEACMODEID);
    }

    public final String getPSDEACMODEID() {
        return this.GetParamStringValue(TAG_PSDEACMODEID, "");
    }

    public final void setPSDEACMODEID(String strValue) {
        this.SetParamValue(TAG_PSDEACMODEID, strValue);
    }

    public final boolean isPSDEACMODENAMENull() {
        return this.IsParamNull(TAG_PSDEACMODENAME);
    }

    public final String getPSDEACMODENAME() {
        return this.GetParamStringValue(TAG_PSDEACMODENAME, "");
    }

    public final void setPSDEACMODENAME(String strValue) {
        this.SetParamValue(TAG_PSDEACMODENAME, strValue);
    }
}

