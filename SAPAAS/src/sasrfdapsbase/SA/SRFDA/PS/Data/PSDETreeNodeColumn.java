/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDETreeNodeColumn
extends BaseDataEntity {
    public static final String UPDATEDVT_SESSION = "SESSION";
    public static final String UPDATEDVT_APPLICATION = "APPLICATION";
    public static final String UPDATEDVT_UNIQUEID = "UNIQUEID";
    public static final String UPDATEDVT_CONTEXT = "CONTEXT";
    public static final String UPDATEDVT_PARAM = "PARAM";
    public static final String UPDATEDVT_OPERATOR = "OPERATOR";
    public static final String UPDATEDVT_OPERATORNAME = "OPERATORNAME";
    public static final String UPDATEDVT_CURTIME = "CURTIME";
    public static final int IGNOREINPUT_0 = 0;
    public static final int IGNOREINPUT_1 = 1;
    public static final int IGNOREINPUT_2 = 2;
    public static final int IGNOREINPUT_3 = 3;
    public static final String GROUPITEM_GROUP1 = "GROUP1";
    public static final String GROUPITEM_GROUP2 = "GROUP2";
    public static final String GROUPITEM_GROUP3 = "GROUP3";
    public static final String GROUPITEM_GROUP4 = "GROUP4";
    public static final int ENABLECOND_0 = 0;
    public static final int ENABLECOND_1 = 1;
    public static final int ENABLECOND_2 = 2;
    public static final int ENABLECOND_3 = 3;
    public static final String EDITORTYPE_AC = "AC";
    public static final String EDITORTYPE_AC_FS = "AC_FS";
    public static final String EDITORTYPE_AC_FS_NOBUTTON = "AC_FS_NOBUTTON";
    public static final String EDITORTYPE_AC_NOBUTTON = "AC_NOBUTTON";
    public static final String EDITORTYPE_CHECKBOX = "CHECKBOX";
    public static final String EDITORTYPE_DATEPICKER = "DATEPICKER";
    public static final String EDITORTYPE_DATEPICKEREX = "DATEPICKEREX";
    public static final String EDITORTYPE_DATEPICKEREX_HOUR = "DATEPICKEREX_HOUR";
    public static final String EDITORTYPE_DATEPICKEREX_MINUTE = "DATEPICKEREX_MINUTE";
    public static final String EDITORTYPE_DATEPICKEREX_NODAY = "DATEPICKEREX_NODAY";
    public static final String EDITORTYPE_DATEPICKEREX_NODAY_NOSECOND = "DATEPICKEREX_NODAY_NOSECOND";
    public static final String EDITORTYPE_DATEPICKEREX_NOTIME = "DATEPICKEREX_NOTIME";
    public static final String EDITORTYPE_DATEPICKEREX_SECOND = "DATEPICKEREX_SECOND";
    public static final String EDITORTYPE_DROPDOWNLIST = "DROPDOWNLIST";
    public static final String EDITORTYPE_DROPDOWNLIST_100 = "DROPDOWNLIST_100";
    public static final String EDITORTYPE_MOBMPICKER = "MOBMPICKER";
    public static final String EDITORTYPE_MOBPICKER = "MOBPICKER";
    public static final String EDITORTYPE_PICKER = "PICKER";
    public static final String EDITORTYPE_PICKEREX_LINK = "PICKEREX_LINK";
    public static final String EDITORTYPE_PICKEREX_NOAC = "PICKEREX_NOAC";
    public static final String EDITORTYPE_PICKEREX_NOAC_LINK = "PICKEREX_NOAC_LINK";
    public static final String EDITORTYPE_PICKEREX_NOBUTTON = "PICKEREX_NOBUTTON";
    public static final String EDITORTYPE_PICKEREX_TRIGGER = "PICKEREX_TRIGGER";
    public static final String EDITORTYPE_PICKEREX_TRIGGER_LINK = "PICKEREX_TRIGGER_LINK";
    public static final String EDITORTYPE_TEXTBOX = "TEXTBOX";
    public static final String EDITORTYPE_USERCONTROL = "USERCONTROL";
    public static final String CREATEDVT_SESSION = "SESSION";
    public static final String CREATEDVT_APPLICATION = "APPLICATION";
    public static final String CREATEDVT_UNIQUEID = "UNIQUEID";
    public static final String CREATEDVT_CONTEXT = "CONTEXT";
    public static final String CREATEDVT_PARAM = "PARAM";
    public static final String CREATEDVT_OPERATOR = "OPERATOR";
    public static final String CREATEDVT_OPERATORNAME = "OPERATORNAME";
    public static final String CREATEDVT_CURTIME = "CURTIME";
    public static final int CODELISTCONFIGMODE_0 = 0;
    public static final int CODELISTCONFIGMODE_1 = 1;
    public static final int CODELISTCONFIGMODE_2 = 2;
    public static final String CLCONVERTMODE_FRONT = "FRONT";
    public static final String CLCONVERTMODE_BACKEND = "BACKEND";
    public static final String TAG_PSDETREENODECOLID = "PSDETREENODECOLID";
    public static final String TAG_PSDETREENODECOLNAME = "PSDETREENODECOLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDETREENODEID = "PSDETREENODEID";
    public static final String TAG_PSDETREENODENAME = "PSDETREENODENAME";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_VALUEITEMNAME = "VALUEITEMNAME";
    public static final String TAG_VALUEFORMAT = "VALUEFORMAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_UPDATEDVT = "UPDATEDVT";
    public static final String TAG_UPDATEDV = "UPDATEDV";
    public static final String TAG_RESETITEMNAME = "RESETITEMNAME";
    public static final String TAG_PLACEHOLDER = "PLACEHOLDER";
    public static final String TAG_NEEDCODELISTCONFIG = "NEEDCODELISTCONFIG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_IGNOREINPUT = "IGNOREINPUT";
    public static final String TAG_HIDDENDATAITEM = "HIDDENDATAITEM";
    public static final String TAG_GROUPITEM = "GROUPITEM";
    public static final String TAG_ENABLEROWEDIT = "ENABLEROWEDIT";
    public static final String TAG_ENABLEITEMPRIV = "ENABLEITEMPRIV";
    public static final String TAG_ENABLECOND = "ENABLECOND";
    public static final String TAG_EDITORTYPE = "EDITORTYPE";
    public static final String TAG_EDITORPARAMS = "EDITORPARAMS";
    public static final String TAG_CREATEDVT = "CREATEDVT";
    public static final String TAG_CREATEDV = "CREATEDV";
    public static final String TAG_CODELISTCONFIGMODE = "CODELISTCONFIGMODE";
    public static final String TAG_CLCONVERTMODE = "CLCONVERTMODE";
    public static final String TAG_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String TAG_PSSYSEDITORSTYLEID = "PSSYSEDITORSTYLEID";
    public static final String TAG_PSSYSEDITORSTYLENAME = "PSSYSEDITORSTYLENAME";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_PSSYSDICTCATID = "PSSYSDICTCATID";
    public static final String TAG_PSSYSDICTCATNAME = "PSSYSDICTCATNAME";
    public static final String TAG_PICKUPPSDEVIEWID = "PICKUPPSDEVIEWID";
    public static final String TAG_PICKUPPSDEVIEWNAME = "PICKUPPSDEVIEWNAME";
    public static final String TAG_LINKPSDEVIEWID = "LINKPSDEVIEWID";
    public static final String TAG_LINKPSDEVIEWNAME = "LINKPSDEVIEWNAME";
    public static final String TAG_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String TAG_PSDETREEVIEWNAME = "PSDETREEVIEWNAME";
    public static final String TAG_PSDETREECOLID = "PSDETREECOLID";
    public static final String TAG_PSDETREECOLNAME = "PSDETREECOLNAME";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_PSDETEIUPDATEID = "PSDETEIUPDATEID";
    public static final String TAG_PSDETEIUPDATENAME = "PSDETEIUPDATENAME";
    public static final String TAG_PSDEFUIMODEID = "PSDEFUIMODEID";
    public static final String TAG_PSDEFUIMODENAME = "PSDEFUIMODENAME";
    public static final String TAG_REFPSDEID = "REFPSDEID";
    public static final String TAG_REFPSDENAME = "REFPSDENAME";
    public static final String TAG_REFPSDEDATASETID = "REFPSDEDATASETID";
    public static final String TAG_REFPSDEDATASETNAME = "REFPSDEDATASETNAME";
    public static final String TAG_REFPSDEACMODEID = "REFPSDEACMODEID";
    public static final String TAG_REFPSDEACMODENAME = "REFPSDEACMODENAME";
    public static final String TAG_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String TAG_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String TAG_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String TAG_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String TAG_NOPRIVDM = "NOPRIVDM";
    public static final String TAG_GCRPSSYSPFPLUGINID = "GCRPSSYSPFPLUGINID";
    public static final String TAG_GCRPSSYSPFPLUGINNAME = "GCRPSSYSPFPLUGINNAME";
    public static final String TAG_CELLPSSYSCSSID = "CELLPSSYSCSSID";
    public static final String TAG_CELLPSSYSCSSNAME = "CELLPSSYSCSSNAME";
    public static final String TAG_GRIDCOLSTYLE = "GRIDCOLSTYLE";
    public static final String TAG_ENABLELINK = "ENABLELINK";
    public static final String TAG_GRIDCOLTYPE = "GRIDCOLTYPE";

    public final boolean isPSDETREENODECOLIDNull() {
        return this.IsParamNull(TAG_PSDETREENODECOLID);
    }

    public final String getPSDETREENODECOLID() {
        return this.GetParamStringValue(TAG_PSDETREENODECOLID, "");
    }

    public final void setPSDETREENODECOLID(String strValue) {
        this.SetParamValue(TAG_PSDETREENODECOLID, strValue);
    }

    public final boolean isPSDETREENODECOLNAMENull() {
        return this.IsParamNull(TAG_PSDETREENODECOLNAME);
    }

    public final String getPSDETREENODECOLNAME() {
        return this.GetParamStringValue(TAG_PSDETREENODECOLNAME, "");
    }

    public final void setPSDETREENODECOLNAME(String strValue) {
        this.SetParamValue(TAG_PSDETREENODECOLNAME, strValue);
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

    public final boolean isPSDETREENODEIDNull() {
        return this.IsParamNull(TAG_PSDETREENODEID);
    }

    public final String getPSDETREENODEID() {
        return this.GetParamStringValue(TAG_PSDETREENODEID, "");
    }

    public final void setPSDETREENODEID(String strValue) {
        this.SetParamValue(TAG_PSDETREENODEID, strValue);
    }

    public final boolean isPSDETREENODENAMENull() {
        return this.IsParamNull(TAG_PSDETREENODENAME);
    }

    public final String getPSDETREENODENAME() {
        return this.GetParamStringValue(TAG_PSDETREENODENAME, "");
    }

    public final void setPSDETREENODENAME(String strValue) {
        this.SetParamValue(TAG_PSDETREENODENAME, strValue);
    }

    public final boolean isPSDEFIDNull() {
        return this.IsParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.GetParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.SetParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.IsParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.GetParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFNAME, strValue);
    }

    public final boolean isVALUEITEMNAMENull() {
        return this.IsParamNull(TAG_VALUEITEMNAME);
    }

    public final String getVALUEITEMNAME() {
        return this.GetParamStringValue(TAG_VALUEITEMNAME, "");
    }

    public final void setVALUEITEMNAME(String strValue) {
        this.SetParamValue(TAG_VALUEITEMNAME, strValue);
    }

    public final boolean isVALUEFORMATNull() {
        return this.IsParamNull(TAG_VALUEFORMAT);
    }

    public final String getVALUEFORMAT() {
        return this.GetParamStringValue(TAG_VALUEFORMAT, "");
    }

    public final void setVALUEFORMAT(String strValue) {
        this.SetParamValue(TAG_VALUEFORMAT, strValue);
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

    public final boolean isUPDATEDVTNull() {
        return this.IsParamNull(TAG_UPDATEDVT);
    }

    public final String getUPDATEDVT() {
        return this.GetParamStringValue(TAG_UPDATEDVT, "");
    }

    public final void setUPDATEDVT(String strValue) {
        this.SetParamValue(TAG_UPDATEDVT, strValue);
    }

    public final boolean isUPDATEDVNull() {
        return this.IsParamNull(TAG_UPDATEDV);
    }

    public final String getUPDATEDV() {
        return this.GetParamStringValue(TAG_UPDATEDV, "");
    }

    public final void setUPDATEDV(String strValue) {
        this.SetParamValue(TAG_UPDATEDV, strValue);
    }

    public final boolean isRESETITEMNAMENull() {
        return this.IsParamNull(TAG_RESETITEMNAME);
    }

    public final String getRESETITEMNAME() {
        return this.GetParamStringValue(TAG_RESETITEMNAME, "");
    }

    public final void setRESETITEMNAME(String strValue) {
        this.SetParamValue(TAG_RESETITEMNAME, strValue);
    }

    public final boolean isPLACEHOLDERNull() {
        return this.IsParamNull(TAG_PLACEHOLDER);
    }

    public final String getPLACEHOLDER() {
        return this.GetParamStringValue(TAG_PLACEHOLDER, "");
    }

    public final void setPLACEHOLDER(String strValue) {
        this.SetParamValue(TAG_PLACEHOLDER, strValue);
    }

    public final boolean isNEEDCODELISTCONFIGNull() {
        return this.IsParamNull(TAG_NEEDCODELISTCONFIG);
    }

    public final boolean getNEEDCODELISTCONFIG() {
        return this.GetParamIntValue(TAG_NEEDCODELISTCONFIG, 0) == 1;
    }

    public final void setNEEDCODELISTCONFIG(boolean bValue) {
        this.SetParamValue(TAG_NEEDCODELISTCONFIG, bValue ? 1 : 0);
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

    public final boolean isIGNOREINPUTNull() {
        return this.IsParamNull(TAG_IGNOREINPUT);
    }

    public final int getIGNOREINPUT() {
        return this.GetParamIntValue(TAG_IGNOREINPUT, 0);
    }

    public final void setIGNOREINPUT(int nValue) {
        this.SetParamValue(TAG_IGNOREINPUT, nValue);
    }

    public final boolean isHIDDENDATAITEMNull() {
        return this.IsParamNull(TAG_HIDDENDATAITEM);
    }

    public final boolean getHIDDENDATAITEM() {
        return this.GetParamIntValue(TAG_HIDDENDATAITEM, 0) == 1;
    }

    public final void setHIDDENDATAITEM(boolean bValue) {
        this.SetParamValue(TAG_HIDDENDATAITEM, bValue ? 1 : 0);
    }

    public final boolean isGROUPITEMNull() {
        return this.IsParamNull(TAG_GROUPITEM);
    }

    public final String getGROUPITEM() {
        return this.GetParamStringValue(TAG_GROUPITEM, "");
    }

    public final void setGROUPITEM(String strValue) {
        this.SetParamValue(TAG_GROUPITEM, strValue);
    }

    public final boolean isENABLEROWEDITNull() {
        return this.IsParamNull(TAG_ENABLEROWEDIT);
    }

    public final int getENABLEROWEDIT() {
        return this.GetParamIntValue(TAG_ENABLEROWEDIT, 0);
    }

    public final void setENABLEROWEDIT(int bValue) {
        this.SetParamValue(TAG_ENABLEROWEDIT, bValue);
    }

    public final boolean isENABLEITEMPRIVNull() {
        return this.IsParamNull(TAG_ENABLEITEMPRIV);
    }

    public final boolean getENABLEITEMPRIV() {
        return this.GetParamIntValue(TAG_ENABLEITEMPRIV, 0) == 1;
    }

    public final void setENABLEITEMPRIV(boolean bValue) {
        this.SetParamValue(TAG_ENABLEITEMPRIV, bValue ? 1 : 0);
    }

    public final boolean isENABLECONDNull() {
        return this.IsParamNull(TAG_ENABLECOND);
    }

    public final int getENABLECOND() {
        return this.GetParamIntValue(TAG_ENABLECOND, 0);
    }

    public final void setENABLECOND(int nValue) {
        this.SetParamValue(TAG_ENABLECOND, nValue);
    }

    public final boolean isEDITORTYPENull() {
        return this.IsParamNull(TAG_EDITORTYPE);
    }

    public final String getEDITORTYPE() {
        return this.GetParamStringValue(TAG_EDITORTYPE, "");
    }

    public final void setEDITORTYPE(String strValue) {
        this.SetParamValue(TAG_EDITORTYPE, strValue);
    }

    public final boolean isEDITORPARAMSNull() {
        return this.IsParamNull(TAG_EDITORPARAMS);
    }

    public final String getEDITORPARAMS() {
        return this.GetParamStringValue(TAG_EDITORPARAMS, "");
    }

    public final void setEDITORPARAMS(String strValue) {
        this.SetParamValue(TAG_EDITORPARAMS, strValue);
    }

    public final boolean isCREATEDVTNull() {
        return this.IsParamNull(TAG_CREATEDVT);
    }

    public final String getCREATEDVT() {
        return this.GetParamStringValue(TAG_CREATEDVT, "");
    }

    public final void setCREATEDVT(String strValue) {
        this.SetParamValue(TAG_CREATEDVT, strValue);
    }

    public final boolean isCREATEDVNull() {
        return this.IsParamNull(TAG_CREATEDV);
    }

    public final String getCREATEDV() {
        return this.GetParamStringValue(TAG_CREATEDV, "");
    }

    public final void setCREATEDV(String strValue) {
        this.SetParamValue(TAG_CREATEDV, strValue);
    }

    public final boolean isCODELISTCONFIGMODENull() {
        return this.IsParamNull(TAG_CODELISTCONFIGMODE);
    }

    public final int getCODELISTCONFIGMODE() {
        return this.GetParamIntValue(TAG_CODELISTCONFIGMODE, 0);
    }

    public final void setCODELISTCONFIGMODE(int nValue) {
        this.SetParamValue(TAG_CODELISTCONFIGMODE, nValue);
    }

    public final boolean isCLCONVERTMODENull() {
        return this.IsParamNull(TAG_CLCONVERTMODE);
    }

    public final String getCLCONVERTMODE() {
        return this.GetParamStringValue(TAG_CLCONVERTMODE, "");
    }

    public final void setCLCONVERTMODE(String strValue) {
        this.SetParamValue(TAG_CLCONVERTMODE, strValue);
    }

    public final boolean isALLOWEMPTYNull() {
        return this.IsParamNull(TAG_ALLOWEMPTY);
    }

    public final boolean getALLOWEMPTY() {
        return this.GetParamIntValue(TAG_ALLOWEMPTY, 0) == 1;
    }

    public final void setALLOWEMPTY(boolean bValue) {
        this.SetParamValue(TAG_ALLOWEMPTY, bValue ? 1 : 0);
    }

    public final boolean isPSSYSEDITORSTYLEIDNull() {
        return this.IsParamNull(TAG_PSSYSEDITORSTYLEID);
    }

    public final String getPSSYSEDITORSTYLEID() {
        return this.GetParamStringValue(TAG_PSSYSEDITORSTYLEID, "");
    }

    public final void setPSSYSEDITORSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSSYSEDITORSTYLEID, strValue);
    }

    public final boolean isPSSYSEDITORSTYLENAMENull() {
        return this.IsParamNull(TAG_PSSYSEDITORSTYLENAME);
    }

    public final String getPSSYSEDITORSTYLENAME() {
        return this.GetParamStringValue(TAG_PSSYSEDITORSTYLENAME, "");
    }

    public final void setPSSYSEDITORSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSEDITORSTYLENAME, strValue);
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

    public final boolean isPSSYSDICTCATIDNull() {
        return this.IsParamNull(TAG_PSSYSDICTCATID);
    }

    public final String getPSSYSDICTCATID() {
        return this.GetParamStringValue(TAG_PSSYSDICTCATID, "");
    }

    public final void setPSSYSDICTCATID(String strValue) {
        this.SetParamValue(TAG_PSSYSDICTCATID, strValue);
    }

    public final boolean isPSSYSDICTCATNAMENull() {
        return this.IsParamNull(TAG_PSSYSDICTCATNAME);
    }

    public final String getPSSYSDICTCATNAME() {
        return this.GetParamStringValue(TAG_PSSYSDICTCATNAME, "");
    }

    public final void setPSSYSDICTCATNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDICTCATNAME, strValue);
    }

    public final boolean isPICKUPPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_PICKUPPSDEVIEWID);
    }

    public final String getPICKUPPSDEVIEWID() {
        return this.GetParamStringValue(TAG_PICKUPPSDEVIEWID, "");
    }

    public final void setPICKUPPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_PICKUPPSDEVIEWID, strValue);
    }

    public final boolean isPICKUPPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_PICKUPPSDEVIEWNAME);
    }

    public final String getPICKUPPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_PICKUPPSDEVIEWNAME, "");
    }

    public final void setPICKUPPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PICKUPPSDEVIEWNAME, strValue);
    }

    public final boolean isLINKPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_LINKPSDEVIEWID);
    }

    public final String getLINKPSDEVIEWID() {
        return this.GetParamStringValue(TAG_LINKPSDEVIEWID, "");
    }

    public final void setLINKPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_LINKPSDEVIEWID, strValue);
    }

    public final boolean isLINKPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_LINKPSDEVIEWNAME);
    }

    public final String getLINKPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_LINKPSDEVIEWNAME, "");
    }

    public final void setLINKPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_LINKPSDEVIEWNAME, strValue);
    }

    public final boolean isPSDETREEVIEWIDNull() {
        return this.IsParamNull(TAG_PSDETREEVIEWID);
    }

    public final String getPSDETREEVIEWID() {
        return this.GetParamStringValue(TAG_PSDETREEVIEWID, "");
    }

    public final void setPSDETREEVIEWID(String strValue) {
        this.SetParamValue(TAG_PSDETREEVIEWID, strValue);
    }

    public final boolean isPSDETREEVIEWNAMENull() {
        return this.IsParamNull(TAG_PSDETREEVIEWNAME);
    }

    public final String getPSDETREEVIEWNAME() {
        return this.GetParamStringValue(TAG_PSDETREEVIEWNAME, "");
    }

    public final void setPSDETREEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSDETREEVIEWNAME, strValue);
    }

    public final boolean isPSDETREECOLIDNull() {
        return this.IsParamNull(TAG_PSDETREECOLID);
    }

    public final String getPSDETREECOLID() {
        return this.GetParamStringValue(TAG_PSDETREECOLID, "");
    }

    public final void setPSDETREECOLID(String strValue) {
        this.SetParamValue(TAG_PSDETREECOLID, strValue);
    }

    public final boolean isPSDETREECOLNAMENull() {
        return this.IsParamNull(TAG_PSDETREECOLNAME);
    }

    public final String getPSDETREECOLNAME() {
        return this.GetParamStringValue(TAG_PSDETREECOLNAME, "");
    }

    public final void setPSDETREECOLNAME(String strValue) {
        this.SetParamValue(TAG_PSDETREECOLNAME, strValue);
    }

    public final boolean isPSCODELISTIDNull() {
        return this.IsParamNull(TAG_PSCODELISTID);
    }

    public final String getPSCODELISTID() {
        return this.GetParamStringValue(TAG_PSCODELISTID, "");
    }

    public final void setPSCODELISTID(String strValue) {
        this.SetParamValue(TAG_PSCODELISTID, strValue);
    }

    public final boolean isPSCODELISTNAMENull() {
        return this.IsParamNull(TAG_PSCODELISTNAME);
    }

    public final String getPSCODELISTNAME() {
        return this.GetParamStringValue(TAG_PSCODELISTNAME, "");
    }

    public final void setPSCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_PSCODELISTNAME, strValue);
    }

    public final boolean isDEFAULTVALUENull() {
        return this.IsParamNull(TAG_DEFAULTVALUE);
    }

    public final String getDEFAULTVALUE() {
        return this.GetParamStringValue(TAG_DEFAULTVALUE, "");
    }

    public final void setDEFAULTVALUE(String strValue) {
        this.SetParamValue(TAG_DEFAULTVALUE, strValue);
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

    public final boolean isCUSTOMMODENull() {
        return this.IsParamNull(TAG_CUSTOMMODE);
    }

    public final boolean getCUSTOMMODE() {
        return this.GetParamIntValue(TAG_CUSTOMMODE, 0) == 1;
    }

    public final void setCUSTOMMODE(boolean bValue) {
        this.SetParamValue(TAG_CUSTOMMODE, bValue ? 1 : 0);
    }

    public final boolean isPSDETEIUPDATEIDNull() {
        return this.IsParamNull(TAG_PSDETEIUPDATEID);
    }

    public final String getPSDETEIUPDATEID() {
        return this.GetParamStringValue(TAG_PSDETEIUPDATEID, "");
    }

    public final void setPSDETEIUPDATEID(String strValue) {
        this.SetParamValue(TAG_PSDETEIUPDATEID, strValue);
    }

    public final boolean isPSDETEIUPDATENAMENull() {
        return this.IsParamNull(TAG_PSDETEIUPDATENAME);
    }

    public final String getPSDETEIUPDATENAME() {
        return this.GetParamStringValue(TAG_PSDETEIUPDATENAME, "");
    }

    public final void setPSDETEIUPDATENAME(String strValue) {
        this.SetParamValue(TAG_PSDETEIUPDATENAME, strValue);
    }

    public final boolean isPSDEFUIMODEIDNull() {
        return this.IsParamNull(TAG_PSDEFUIMODEID);
    }

    public final String getPSDEFUIMODEID() {
        return this.GetParamStringValue(TAG_PSDEFUIMODEID, "");
    }

    public final void setPSDEFUIMODEID(String strValue) {
        this.SetParamValue(TAG_PSDEFUIMODEID, strValue);
    }

    public final boolean isPSDEFUIMODENAMENull() {
        return this.IsParamNull(TAG_PSDEFUIMODENAME);
    }

    public final String getPSDEFUIMODENAME() {
        return this.GetParamStringValue(TAG_PSDEFUIMODENAME, "");
    }

    public final void setPSDEFUIMODENAME(String strValue) {
        this.SetParamValue(TAG_PSDEFUIMODENAME, strValue);
    }

    public final boolean isREFPSDEIDNull() {
        return this.IsParamNull(TAG_REFPSDEID);
    }

    public final String getREFPSDEID() {
        return this.GetParamStringValue(TAG_REFPSDEID, "");
    }

    public final void setREFPSDEID(String strValue) {
        this.SetParamValue(TAG_REFPSDEID, strValue);
    }

    public final boolean isREFPSDENAMENull() {
        return this.IsParamNull(TAG_REFPSDENAME);
    }

    public final String getREFPSDENAME() {
        return this.GetParamStringValue(TAG_REFPSDENAME, "");
    }

    public final void setREFPSDENAME(String strValue) {
        this.SetParamValue(TAG_REFPSDENAME, strValue);
    }

    public final boolean isREFPSDEDATASETIDNull() {
        return this.IsParamNull(TAG_REFPSDEDATASETID);
    }

    public final String getREFPSDEDATASETID() {
        return this.GetParamStringValue(TAG_REFPSDEDATASETID, "");
    }

    public final void setREFPSDEDATASETID(String strValue) {
        this.SetParamValue(TAG_REFPSDEDATASETID, strValue);
    }

    public final boolean isREFPSDEDATASETNAMENull() {
        return this.IsParamNull(TAG_REFPSDEDATASETNAME);
    }

    public final String getREFPSDEDATASETNAME() {
        return this.GetParamStringValue(TAG_REFPSDEDATASETNAME, "");
    }

    public final void setREFPSDEDATASETNAME(String strValue) {
        this.SetParamValue(TAG_REFPSDEDATASETNAME, strValue);
    }

    public final boolean isREFPSDEACMODEIDNull() {
        return this.IsParamNull(TAG_REFPSDEACMODEID);
    }

    public final String getREFPSDEACMODEID() {
        return this.GetParamStringValue(TAG_REFPSDEACMODEID, "");
    }

    public final void setREFPSDEACMODEID(String strValue) {
        this.SetParamValue(TAG_REFPSDEACMODEID, strValue);
    }

    public final boolean isREFPSDEACMODENAMENull() {
        return this.IsParamNull(TAG_REFPSDEACMODENAME);
    }

    public final String getREFPSDEACMODENAME() {
        return this.GetParamStringValue(TAG_REFPSDEACMODENAME, "");
    }

    public final void setREFPSDEACMODENAME(String strValue) {
        this.SetParamValue(TAG_REFPSDEACMODENAME, strValue);
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

    public final boolean isNOPRIVDMNull() {
        return this.IsParamNull(TAG_NOPRIVDM);
    }

    public final int getNOPRIVDM() {
        return this.GetParamIntValue(TAG_NOPRIVDM, 0);
    }

    public final void setNOPRIVDM(int nValue) {
        this.SetParamValue(TAG_NOPRIVDM, nValue);
    }

    public final boolean isGCRPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_GCRPSSYSPFPLUGINID);
    }

    public final String getGCRPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_GCRPSSYSPFPLUGINID, "");
    }

    public final void setGCRPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_GCRPSSYSPFPLUGINID, strValue);
    }

    public final boolean isGCRPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_GCRPSSYSPFPLUGINNAME);
    }

    public final String getGCRPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_GCRPSSYSPFPLUGINNAME, "");
    }

    public final void setGCRPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_GCRPSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isCELLPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_CELLPSSYSCSSID);
    }

    public final String getCELLPSSYSCSSID() {
        return this.GetParamStringValue(TAG_CELLPSSYSCSSID, "");
    }

    public final void setCELLPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_CELLPSSYSCSSID, strValue);
    }

    public final boolean isCELLPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_CELLPSSYSCSSNAME);
    }

    public final String getCELLPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_CELLPSSYSCSSNAME, "");
    }

    public final void setCELLPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_CELLPSSYSCSSNAME, strValue);
    }

    public final boolean isGRIDCOLSTYLENull() {
        return this.IsParamNull(TAG_GRIDCOLSTYLE);
    }

    public final String getGRIDCOLSTYLE() {
        return this.GetParamStringValue(TAG_GRIDCOLSTYLE, "");
    }

    public final void setGRIDCOLSTYLE(String strValue) {
        this.SetParamValue(TAG_GRIDCOLSTYLE, strValue);
    }

    public final boolean isENABLELINKNull() {
        return this.IsParamNull(TAG_ENABLELINK);
    }

    public final int getENABLELINK() {
        return this.GetParamIntValue(TAG_ENABLELINK, 0);
    }

    public final void setENABLELINK(int nValue) {
        this.SetParamValue(TAG_ENABLELINK, nValue);
    }

    public final boolean isGRIDCOLTYPENull() {
        return this.IsParamNull(TAG_GRIDCOLTYPE);
    }

    public final String getGRIDCOLTYPE() {
        return this.GetParamStringValue(TAG_GRIDCOLTYPE, "");
    }

    public final void setGRIDCOLTYPE(String strValue) {
        this.SetParamValue(TAG_GRIDCOLTYPE, strValue);
    }
}

