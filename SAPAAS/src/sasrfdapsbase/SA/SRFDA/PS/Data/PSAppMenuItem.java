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

public class PSAppMenuItem
extends BaseDataEntity {
    public static final String LAYOUTMODE_AUTOTABLE = "AUTOTABLE";
    public static final String LAYOUTMODE_TABLE = "TABLE";
    public static final String LAYOUTMODE_TABLE_12COL = "TABLE_12COL";
    public static final String LAYOUTMODE_TABLE_24COL = "TABLE_24COL";
    public static final String LAYOUTMODE_BORDER = "BORDER";
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
    public static final String TAG_EXPAND = "EXPAND";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String TAG_PREVIEWHTML = "PREVIEWHTML";
    public static final String TAG_CSSID = "CSSID";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_BL_POS = "BL_POS";
    public static final String TAG_FLEXDIR = "FLEXDIR";
    public static final String TAG_FLEXALIGN = "FLEXALIGN";
    public static final String TAG_FLEXVALIGN = "FLEXVALIGN";
    public static final String TAG_FLEXGROW = "FLEXGROW";
    public static final String TAG_LAYOUTMODE = "LAYOUTMODE";
    public static final String TAG_COL_XS = "COL_XS";
    public static final String TAG_COL_XS_OS = "COL_XS_OS";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_COL_MD_OS = "COL_MD_OS";
    public static final String TAG_COL_SM = "COL_SM";
    public static final String TAG_COL_SM_OS = "COL_SM_OS";
    public static final String TAG_COL_LG = "COL_LG";
    public static final String TAG_COL_LG_OS = "COL_LG_OS";
    public static final String TAG_COL_MD = "COL_MD";
    public static final String TAG_TITLEBARCLOSEMODE = "TITLEBARCLOSEMODE";
    public static final String TAG_INFORMTAG = "INFORMTAG";
    public static final String TAG_INFORMTAG2 = "INFORMTAG2";
    public static final String TAG_CONTENTTYPE = "CONTENTTYPE";
    public static final String TAG_HTMLCONTENT = "HTMLCONTENT";
    public static final String TAG_RAWCONTENT = "RAWCONTENT";
    public static final String TAG_DATA = "DATA";
    public static final String TAG_ACTIONLEVEL = "ACTIONLEVEL";
    public static final String TAG_MOBFLAG = "MOBFLAG";
    public static final String TAG_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String TAG_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String TAG_PSAPPLOCALDEID = "PSAPPLOCALDEID";
    public static final String TAG_PSAPPLOCALDENAME = "PSAPPLOCALDENAME";
    public static final String TAG_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String TAG_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_BTNACTIONTYPE = "BTNACTIONTYPE";
    public static final String TAG_BORDERSTYLE = "BORDERSTYLE";
    public static final String TAG_TOGGLEMODE = "TOGGLEMODE";
    public static final String TAG_ITEMSTYLE = "ITEMSTYLE";
    public static final String TAG_ITEMSTYLETEXT = "ITEMSTYLETEXT";
    public static final String TAG_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String TAG_PREDEFINEDTYPETEXT = "PREDEFINEDTYPETEXT";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_OPENPSAPPVIEWID = "OPENPSAPPVIEWID";
    public static final String TAG_OPENPSAPPVIEWNAME = "OPENPSAPPVIEWNAME";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_HTMLPAGEURL = "HTMLPAGEURL";
    public static final String TAG_RAWCSSSTYLE = "RAWCSSSTYLE";
    public static final String TAG_DYNACLASS = "DYNACLASS";
    public static final String TAG_TEMPLATEMODE = "TEMPLATEMODE";
    public static final String TAG_PREDEFINEDTYPEPARAM = "PREDEFINEDTYPEPARAM";
    public static final String TAG_SPANFLAG = "SPANFLAG";
    private ArrayList<PSAppMenuItem> childPSAppMenuItemList = null;

    public final boolean isPSAPPMENUITEMIDNull() {
        return this.IsParamNull(TAG_PSAPPMENUITEMID);
    }

    public final String getPSAPPMENUITEMID() {
        return this.GetParamStringValue(TAG_PSAPPMENUITEMID, "");
    }

    public final void setPSAPPMENUITEMID(String strValue) {
        this.SetParamValue(TAG_PSAPPMENUITEMID, strValue);
    }

    public final boolean isPSAPPMENUITEMNAMENull() {
        return this.IsParamNull(TAG_PSAPPMENUITEMNAME);
    }

    public final String getPSAPPMENUITEMNAME() {
        return this.GetParamStringValue(TAG_PSAPPMENUITEMNAME, "");
    }

    public final void setPSAPPMENUITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPMENUITEMNAME, strValue);
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

    public final boolean isPSAPPMENUIDNull() {
        return this.IsParamNull(TAG_PSAPPMENUID);
    }

    public final String getPSAPPMENUID() {
        return this.GetParamStringValue(TAG_PSAPPMENUID, "");
    }

    public final void setPSAPPMENUID(String strValue) {
        this.SetParamValue(TAG_PSAPPMENUID, strValue);
    }

    public final boolean isPSAPPMENUNAMENull() {
        return this.IsParamNull(TAG_PSAPPMENUNAME);
    }

    public final String getPSAPPMENUNAME() {
        return this.GetParamStringValue(TAG_PSAPPMENUNAME, "");
    }

    public final void setPSAPPMENUNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPMENUNAME, strValue);
    }

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

    public final boolean isPPSAPPMENUITEMIDNull() {
        return this.IsParamNull(TAG_PPSAPPMENUITEMID);
    }

    public final String getPPSAPPMENUITEMID() {
        return this.GetParamStringValue(TAG_PPSAPPMENUITEMID, "");
    }

    public final void setPPSAPPMENUITEMID(String strValue) {
        this.SetParamValue(TAG_PPSAPPMENUITEMID, strValue);
    }

    public final boolean isPPSAPPMENUITEMNAMENull() {
        return this.IsParamNull(TAG_PPSAPPMENUITEMNAME);
    }

    public final String getPPSAPPMENUITEMNAME() {
        return this.GetParamStringValue(TAG_PPSAPPMENUITEMNAME, "");
    }

    public final void setPPSAPPMENUITEMNAME(String strValue) {
        this.SetParamValue(TAG_PPSAPPMENUITEMNAME, strValue);
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

    public final boolean isLEVELTAGNull() {
        return this.IsParamNull(TAG_LEVELTAG);
    }

    public final String getLEVELTAG() {
        return this.GetParamStringValue(TAG_LEVELTAG, "");
    }

    public final void setLEVELTAG(String strValue) {
        this.SetParamValue(TAG_LEVELTAG, strValue);
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

    public final boolean isAMITEMTYPENull() {
        return this.IsParamNull(TAG_AMITEMTYPE);
    }

    public final String getAMITEMTYPE() {
        return this.GetParamStringValue(TAG_AMITEMTYPE, "");
    }

    public final void setAMITEMTYPE(String strValue) {
        this.SetParamValue(TAG_AMITEMTYPE, strValue);
    }

    public final boolean isOPENDEFAULTNull() {
        return this.IsParamNull(TAG_OPENDEFAULT);
    }

    public final boolean getOPENDEFAULT() {
        return this.GetParamIntValue(TAG_OPENDEFAULT, 0) == 1;
    }

    public final void setOPENDEFAULT(boolean bValue) {
        this.SetParamValue(TAG_OPENDEFAULT, bValue ? 1 : 0);
    }

    public final boolean isDISABLECLOSENull() {
        return this.IsParamNull(TAG_DISABLECLOSE);
    }

    public final boolean getDISABLECLOSE() {
        return this.GetParamIntValue(TAG_DISABLECLOSE, 0) == 1;
    }

    public final void setDISABLECLOSE(boolean bValue) {
        this.SetParamValue(TAG_DISABLECLOSE, bValue ? 1 : 0);
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

    public final boolean isHIDESIDEBARNull() {
        return this.IsParamNull(TAG_HIDESIDEBAR);
    }

    public final boolean getHIDESIDEBAR() {
        return this.GetParamIntValue(TAG_HIDESIDEBAR, 0) == 1;
    }

    public final void setHIDESIDEBAR(boolean bValue) {
        this.SetParamValue(TAG_HIDESIDEBAR, bValue ? 1 : 0);
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

    public final boolean isENABLEMODENull() {
        return this.IsParamNull(TAG_ENABLEMODE);
    }

    public final boolean getENABLEMODE() {
        return this.GetParamIntValue(TAG_ENABLEMODE, 0) == 1;
    }

    public final void setENABLEMODE(boolean bValue) {
        this.SetParamValue(TAG_ENABLEMODE, bValue ? 1 : 0);
    }

    public final boolean isREFPSAPPMENUIDNull() {
        return this.IsParamNull(TAG_REFPSAPPMENUID);
    }

    public final String getREFPSAPPMENUID() {
        return this.GetParamStringValue(TAG_REFPSAPPMENUID, "");
    }

    public final void setREFPSAPPMENUID(String strValue) {
        this.SetParamValue(TAG_REFPSAPPMENUID, strValue);
    }

    public final boolean isREFPSAPPMENUNAMENull() {
        return this.IsParamNull(TAG_REFPSAPPMENUNAME);
    }

    public final String getREFPSAPPMENUNAME() {
        return this.GetParamStringValue(TAG_REFPSAPPMENUNAME, "");
    }

    public final void setREFPSAPPMENUNAME(String strValue) {
        this.SetParamValue(TAG_REFPSAPPMENUNAME, strValue);
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

    public final boolean isCOUNTERIDNull() {
        return this.IsParamNull(TAG_COUNTERID);
    }

    public final String getCOUNTERID() {
        return this.GetParamStringValue(TAG_COUNTERID, "");
    }

    public final void setCOUNTERID(String strValue) {
        this.SetParamValue(TAG_COUNTERID, strValue);
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

    public final boolean isMENUITEMSTATENull() {
        return this.IsParamNull(TAG_MENUITEMSTATE);
    }

    public final int getMENUITEMSTATE() {
        return this.GetParamIntValue(TAG_MENUITEMSTATE, 0);
    }

    public final void setMENUITEMSTATE(int nValue) {
        this.SetParamValue(TAG_MENUITEMSTATE, nValue);
    }

    public final boolean isFILLEROBJNull() {
        return this.IsParamNull(TAG_FILLEROBJ);
    }

    public final String getFILLEROBJ() {
        return this.GetParamStringValue(TAG_FILLEROBJ, "");
    }

    public final void setFILLEROBJ(String strValue) {
        this.SetParamValue(TAG_FILLEROBJ, strValue);
    }

    public final boolean isEXPANDNull() {
        return this.IsParamNull(TAG_EXPAND);
    }

    public final boolean getEXPAND() {
        return this.GetParamIntValue(TAG_EXPAND, 0) == 1;
    }

    public final void setEXPAND(boolean bValue) {
        this.SetParamValue(TAG_EXPAND, bValue ? 1 : 0);
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

    public final boolean isDYNAMODELFLAGNull() {
        return this.IsParamNull(TAG_DYNAMODELFLAG);
    }

    public final int getDYNAMODELFLAG() {
        return this.GetParamIntValue(TAG_DYNAMODELFLAG, 0);
    }

    public final void setDYNAMODELFLAG(int nValue) {
        this.SetParamValue(TAG_DYNAMODELFLAG, nValue);
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

    public final boolean isCSSIDNull() {
        return this.IsParamNull(TAG_CSSID);
    }

    public final String getCSSID() {
        return this.GetParamStringValue(TAG_CSSID, "");
    }

    public final void setCSSID(String strValue) {
        this.SetParamValue(TAG_CSSID, strValue);
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

    public final boolean isWIDTHNull() {
        return this.IsParamNull(TAG_WIDTH);
    }

    public final int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public final void setWIDTH(int nValue) {
        this.SetParamValue(TAG_WIDTH, nValue);
    }

    public final boolean isBL_POSNull() {
        return this.IsParamNull(TAG_BL_POS);
    }

    public final String getBL_POS() {
        return this.GetParamStringValue(TAG_BL_POS, "");
    }

    public final void setBL_POS(String strValue) {
        this.SetParamValue(TAG_BL_POS, strValue);
    }

    public final boolean isFLEXDIRNull() {
        return this.IsParamNull(TAG_FLEXDIR);
    }

    public final String getFLEXDIR() {
        return this.GetParamStringValue(TAG_FLEXDIR, "");
    }

    public final void setFLEXDIR(String strValue) {
        this.SetParamValue(TAG_FLEXDIR, strValue);
    }

    public final boolean isFLEXALIGNNull() {
        return this.IsParamNull(TAG_FLEXALIGN);
    }

    public final String getFLEXALIGN() {
        return this.GetParamStringValue(TAG_FLEXALIGN, "");
    }

    public final void setFLEXALIGN(String strValue) {
        this.SetParamValue(TAG_FLEXALIGN, strValue);
    }

    public final boolean isFLEXVALIGNNull() {
        return this.IsParamNull(TAG_FLEXVALIGN);
    }

    public final String getFLEXVALIGN() {
        return this.GetParamStringValue(TAG_FLEXVALIGN, "");
    }

    public final void setFLEXVALIGN(String strValue) {
        this.SetParamValue(TAG_FLEXVALIGN, strValue);
    }

    public final boolean isFLEXGROWNull() {
        return this.IsParamNull(TAG_FLEXGROW);
    }

    public final int getFLEXGROW() {
        return this.GetParamIntValue(TAG_FLEXGROW, 0);
    }

    public final void setFLEXGROW(int nValue) {
        this.SetParamValue(TAG_FLEXGROW, nValue);
    }

    public final boolean isLAYOUTMODENull() {
        return this.IsParamNull(TAG_LAYOUTMODE);
    }

    public final String getLAYOUTMODE() {
        return this.GetParamStringValue(TAG_LAYOUTMODE, "");
    }

    public final void setLAYOUTMODE(String strValue) {
        this.SetParamValue(TAG_LAYOUTMODE, strValue);
    }

    public final boolean isCOL_XSNull() {
        return this.IsParamNull(TAG_COL_XS);
    }

    public final int getCOL_XS() {
        return this.GetParamIntValue(TAG_COL_XS, 0);
    }

    public final void setCOL_XS(int nValue) {
        this.SetParamValue(TAG_COL_XS, nValue);
    }

    public final boolean isCOL_XS_OSNull() {
        return this.IsParamNull(TAG_COL_XS_OS);
    }

    public final int getCOL_XS_OS() {
        return this.GetParamIntValue(TAG_COL_XS_OS, 0);
    }

    public final void setCOL_XS_OS(int nValue) {
        this.SetParamValue(TAG_COL_XS_OS, nValue);
    }

    public final boolean isHEIGHTNull() {
        return this.IsParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.SetParamValue(TAG_HEIGHT, nValue);
    }

    public final boolean isCOL_MD_OSNull() {
        return this.IsParamNull(TAG_COL_MD_OS);
    }

    public final int getCOL_MD_OS() {
        return this.GetParamIntValue(TAG_COL_MD_OS, 0);
    }

    public final void setCOL_MD_OS(int nValue) {
        this.SetParamValue(TAG_COL_MD_OS, nValue);
    }

    public final boolean isCOL_SMNull() {
        return this.IsParamNull(TAG_COL_SM);
    }

    public final int getCOL_SM() {
        return this.GetParamIntValue(TAG_COL_SM, 0);
    }

    public final void setCOL_SM(int nValue) {
        this.SetParamValue(TAG_COL_SM, nValue);
    }

    public final boolean isCOL_SM_OSNull() {
        return this.IsParamNull(TAG_COL_SM_OS);
    }

    public final int getCOL_SM_OS() {
        return this.GetParamIntValue(TAG_COL_SM_OS, 0);
    }

    public final void setCOL_SM_OS(int nValue) {
        this.SetParamValue(TAG_COL_SM_OS, nValue);
    }

    public final boolean isCOL_LGNull() {
        return this.IsParamNull(TAG_COL_LG);
    }

    public final int getCOL_LG() {
        return this.GetParamIntValue(TAG_COL_LG, 0);
    }

    public final void setCOL_LG(int nValue) {
        this.SetParamValue(TAG_COL_LG, nValue);
    }

    public final boolean isCOL_LG_OSNull() {
        return this.IsParamNull(TAG_COL_LG_OS);
    }

    public final int getCOL_LG_OS() {
        return this.GetParamIntValue(TAG_COL_LG_OS, 0);
    }

    public final void setCOL_LG_OS(int nValue) {
        this.SetParamValue(TAG_COL_LG_OS, nValue);
    }

    public final boolean isCOL_MDNull() {
        return this.IsParamNull(TAG_COL_MD);
    }

    public final int getCOL_MD() {
        return this.GetParamIntValue(TAG_COL_MD, 0);
    }

    public final void setCOL_MD(int nValue) {
        this.SetParamValue(TAG_COL_MD, nValue);
    }

    public final boolean isTITLEBARCLOSEMODENull() {
        return this.IsParamNull(TAG_TITLEBARCLOSEMODE);
    }

    public final int getTITLEBARCLOSEMODE() {
        return this.GetParamIntValue(TAG_TITLEBARCLOSEMODE, 0);
    }

    public final void setTITLEBARCLOSEMODE(int nValue) {
        this.SetParamValue(TAG_TITLEBARCLOSEMODE, nValue);
    }

    public final boolean isINFORMTAGNull() {
        return this.IsParamNull(TAG_INFORMTAG);
    }

    public final String getINFORMTAG() {
        return this.GetParamStringValue(TAG_INFORMTAG, "");
    }

    public final void setINFORMTAG(String strValue) {
        this.SetParamValue(TAG_INFORMTAG, strValue);
    }

    public final boolean isINFORMTAG2Null() {
        return this.IsParamNull(TAG_INFORMTAG2);
    }

    public final String getINFORMTAG2() {
        return this.GetParamStringValue(TAG_INFORMTAG2, "");
    }

    public final void setINFORMTAG2(String strValue) {
        this.SetParamValue(TAG_INFORMTAG2, strValue);
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

    public final boolean isRAWCONTENTNull() {
        return this.IsParamNull(TAG_RAWCONTENT);
    }

    public final String getRAWCONTENT() {
        return this.GetParamStringValue(TAG_RAWCONTENT, "");
    }

    public final void setRAWCONTENT(String strValue) {
        this.SetParamValue(TAG_RAWCONTENT, strValue);
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

    public final boolean isACTIONLEVELNull() {
        return this.IsParamNull(TAG_ACTIONLEVEL);
    }

    public final int getACTIONLEVEL() {
        return this.GetParamIntValue(TAG_ACTIONLEVEL, 0);
    }

    public final void setACTIONLEVEL(int nValue) {
        this.SetParamValue(TAG_ACTIONLEVEL, nValue);
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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
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

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
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

    public final boolean isPREDEFINEDTYPEPARAMNull() {
        return this.IsParamNull(TAG_PREDEFINEDTYPEPARAM);
    }

    public final String getPREDEFINEDTYPEPARAM() {
        return this.GetParamStringValue(TAG_PREDEFINEDTYPEPARAM, "");
    }

    public final void setPREDEFINEDTYPEPARAM(String strValue) {
        this.SetParamValue(TAG_PREDEFINEDTYPEPARAM, strValue);
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

