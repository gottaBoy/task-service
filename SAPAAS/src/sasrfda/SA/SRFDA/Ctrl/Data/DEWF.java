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

public class DEWF
extends BaseDataEntity {
    public static final String SHORTCUTPARAM_TEXT = "TEXT";
    public static final String SHORTCUTPARAM_SRC = "SRC";
    public static final String SHORTCUTPARAM_SRCPARAM = "SRCPARAM";
    public static final String SHORTCUTPARAM_WFNAME = "WFNAME";
    public static final String WFPARAM_WFSTART = "WFSTART";
    public static final String WFPARAM_WFTESTRESTART = "WFTESTRESTART";
    public static final String WFPARAM_WFTESTCANCEL = "WFTESTCANCEL";
    public static final String WFPARAM_WFINIT = "WFINIT";
    public static final String WFPARAM_WFFINISH = "WFFINISH";
    public static final String WFPARAM_WFCANCEL = "WFCANCEL";
    public static final String WFPARAM_WFCANCELSTART = "WFCANCELSTART";
    public static final String WFPARAM_UPDATEACTIONMODE = "UPDATEACTIONMODE";
    public static final String WFPARAM_UPDATEACTIONMODE_WFACTION = "WFACTION";
    public static final String WFPARAM_WFINFOPAGE_WFSTEPACTOR = "WFINFOPAGE.WFSTEPACTOR";
    public static final String WFPARAM_WFINFOPAGE_WFSTEPDATA = "WFINFOPAGE.WFSTEPDATA";
    public static final String WFPARAM_WFINFOPAGE = "WFINFOPAGE";
    public static final String WFPARAM_WFINFOPAGE_SIMPLEMODE = "WFINFOPAGE.SIMPLEMODE";
    public static final String WFPARAM_WFINFOPAGE_SAVEASIAACTION = "WFINFOPAGE.SAVEASIAACTION";
    public static final String WFPARAM_RESETWFSTEP = "RESETWFSTEP";
    public static final String WFPARAM_TBB_FORMSAVEANDSTARTWFHANDLER = "TBB.FORMSAVEANDSTARTWFHANDLER";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ISENABLEWF = "ISENABLEWF";
    public static final String TAG_WFFIRSTACTION = "WFFIRSTACTION";
    public static final String TAG_WFSTATEVALUE = "WFSTATEVALUE";
    public static final String TAG_MYWFWORK = "MYWFWORK";
    public static final String TAG_EDITABLEWFSTEP = "EDITABLEWFSTEP";
    public static final String TAG_INITSET = "INITSET";
    public static final String TAG_CANCELSET = "CANCELSET";
    public static final String TAG_CANCELSTARTSET = "CANCELSTARTSET";
    public static final String TAG_INITOBJECT = "INITOBJECT";
    public static final String TAG_CANCELOBJECT = "CANCELOBJECT";
    public static final String TAG_CANCELSTARTOBJECT = "CANCELSTARTOBJECT";
    public static final String TAG_FINISHOBJECT = "FINISHOBJECT";
    public static final String TAG_FINISHSET = "FINISHSET";
    public static final String TAG_PARAMS = "PARAMS";
    public static final String TAG_SHORTCUTLINK = "SHORTCUTLINK";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_WFNAME = "WFNAME";
    public static final String TAG_WFSTATEDEFNAME = "WFSTATEDEFNAME";
    public static final String TAG_WFSTEPDEFNAME = "WFSTEPDEFNAME";
    public static final String TAG_RDENAME = "RDENAME";
    public static final String TAG_WFINSTDEFNAME = "WFINSTDEFNAME";
    public static final String TAG_WFINFOPAGENAME = "WFINFOPAGENAME";
    public static final String TAG_STATEDEFNAME = "STATEDEFNAME";
    public static final String TAG_QUERYMODELNAME = "QUERYMODELNAME";
    public static final String TAG_WFGRIDPAGENAME = "WFGRIDPAGENAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_WFID = "WFID";
    public static final String TAG_WFSTATEDEFID = "WFSTATEDEFID";
    public static final String TAG_WFSTEPDEFID = "WFSTEPDEFID";
    public static final String TAG_RDEID = "RDEID";
    public static final String TAG_WFINSTDEFID = "WFINSTDEFID";
    public static final String TAG_WFINFOPAGEID = "WFINFOPAGEID";
    public static final String TAG_STATEDEFID = "STATEDEFID";
    public static final String TAG_QUERYMODELID = "QUERYMODELID";
    public static final String TAG_WFGRIDPAGEID = "WFGRIDPAGEID";
    public static final String TAG_WFACTORSDEFID = "WFACTORSDEFID";
    public static final String TAG_WFACTORSDEFNAME = "WFACTORSDEFNAME";
    public static final String TAG_USERSTART = "USERSTART";
    public static final String TAG_MSCLID = "MSCLID";
    public static final String TAG_MSCLNAME = "MSCLNAME";
    public static final String TAG_WFFINISHPAGEID = "WFFINISHPAGEID";
    public static final String TAG_WFFINISHPAGENAME = "WFFINISHPAGENAME";
    public static final String TAG_FINISHPAGEPARAM = "FINISHPAGEPARAM";
    public static final String TAG_EXTCNTSTATES = "EXTCNTSTATES";
    public static final String TAG_OPENPAGESTATES = "OPENPAGESTATES";
    public static final String TAG_STARTACTIONFORMID = "STARTACTIONFORMID";
    public static final String TAG_STARTACTIONFORMNAME = "STARTACTIONFORMNAME";
    public static final String TAG_STARTACTIONPAGEID = "STARTACTIONPAGEID";
    public static final String TAG_STARTACTIONPAGENAME = "STARTACTIONPAGENAME";
    private Properties shortcutLinkParams = null;
    private Properties wfParams = null;

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public boolean getISENABLEWF() {
        return this.GetParamIntValue(TAG_ISENABLEWF, 0) == 1;
    }

    public void setISENABLEWF(boolean bValue) {
        this.SetParamValue(TAG_ISENABLEWF, bValue ? 1 : 0);
    }

    public void setWFFIRSTACTION(String strValue) {
        this.SetParamValue(TAG_WFFIRSTACTION, strValue);
    }

    public void setWFSTATEVALUE(String strValue) {
        this.SetParamValue(TAG_WFSTATEVALUE, strValue);
    }

    public void setMYWFWORK(String strValue) {
        this.SetParamValue(TAG_MYWFWORK, strValue);
    }

    public void setEDITABLEWFSTEP(String strValue) {
        this.SetParamValue(TAG_EDITABLEWFSTEP, strValue);
    }

    public void setINITSET(String strValue) {
        this.SetParamValue(TAG_INITSET, strValue);
    }

    public void setCANCELSET(String strValue) {
        this.SetParamValue(TAG_CANCELSET, strValue);
    }

    public void setCANCELSTARTSET(String strValue) {
        this.SetParamValue(TAG_CANCELSTARTSET, strValue);
    }

    public void setINITOBJECT(String strValue) {
        this.SetParamValue(TAG_INITOBJECT, strValue);
    }

    public void setCANCELOBJECT(String strValue) {
        this.SetParamValue(TAG_CANCELOBJECT, strValue);
    }

    public void setFINISHOBJECT(String strValue) {
        this.SetParamValue(TAG_FINISHOBJECT, strValue);
    }

    public void setFINISHSET(String strValue) {
        this.SetParamValue(TAG_FINISHSET, strValue);
    }

    public String getPARAMS() {
        return this.GetParamStringValue(TAG_PARAMS, "");
    }

    public void setPARAMS(String strValue) {
        this.SetParamValue(TAG_PARAMS, strValue);
    }

    public String getSHORTCUTLINK() {
        return this.GetParamStringValue(TAG_SHORTCUTLINK, "");
    }

    public void setSHORTCUTLINK(String strValue) {
        this.SetParamValue(TAG_SHORTCUTLINK, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public String getWFNAME() {
        return this.GetParamStringValue("WFNAME", "");
    }

    public void setWFNAME(String strValue) {
        this.SetParamValue("WFNAME", strValue);
    }

    public String getWFSTATEDEFNAME() {
        return this.GetParamStringValue(TAG_WFSTATEDEFNAME, "");
    }

    public void setWFSTATEDEFNAME(String strValue) {
        this.SetParamValue(TAG_WFSTATEDEFNAME, strValue);
    }

    public String getWFSTEPDEFNAME() {
        return this.GetParamStringValue(TAG_WFSTEPDEFNAME, "");
    }

    public void setWFSTEPDEFNAME(String strValue) {
        this.SetParamValue(TAG_WFSTEPDEFNAME, strValue);
    }

    public String getRDENAME() {
        return this.GetParamStringValue(TAG_RDENAME, "");
    }

    public void setRDENAME(String strValue) {
        this.SetParamValue(TAG_RDENAME, strValue);
    }

    public String getWFINSTDEFNAME() {
        return this.GetParamStringValue(TAG_WFINSTDEFNAME, "");
    }

    public void setWFINSTDEFNAME(String strValue) {
        this.SetParamValue(TAG_WFINSTDEFNAME, strValue);
    }

    public String getWFINFOPAGENAME() {
        return this.GetParamStringValue(TAG_WFINFOPAGENAME, "");
    }

    public void setWFINFOPAGENAME(String strValue) {
        this.SetParamValue(TAG_WFINFOPAGENAME, strValue);
    }

    public String getSTATEDEFNAME() {
        return this.GetParamStringValue(TAG_STATEDEFNAME, "");
    }

    public void setSTATEDEFNAME(String strValue) {
        this.SetParamValue(TAG_STATEDEFNAME, strValue);
    }

    public String getQUERYMODELNAME() {
        return this.GetParamStringValue(TAG_QUERYMODELNAME, "");
    }

    public void setQUERYMODELNAME(String strValue) {
        this.SetParamValue(TAG_QUERYMODELNAME, strValue);
    }

    public String getWFGRIDPAGENAME() {
        return this.GetParamStringValue(TAG_WFGRIDPAGENAME, "");
    }

    public void setWFGRIDPAGENAME(String strValue) {
        this.SetParamValue(TAG_WFGRIDPAGENAME, strValue);
    }

    public void setWFID(String strValue) {
        this.SetParamValue(TAG_WFID, strValue);
    }

    public void setWFSTATEDEFID(String strValue) {
        this.SetParamValue(TAG_WFSTATEDEFID, strValue);
    }

    public void setWFSTEPDEFID(String strValue) {
        this.SetParamValue(TAG_WFSTEPDEFID, strValue);
    }

    public String getRDEID() {
        return this.GetParamStringValue(TAG_RDEID, "");
    }

    public void setRDEID(String strValue) {
        this.SetParamValue(TAG_RDEID, strValue);
    }

    public void setWFINSTDEFID(String strValue) {
        this.SetParamValue(TAG_WFINSTDEFID, strValue);
    }

    public void setWFINFOPAGEID(String strValue) {
        this.SetParamValue(TAG_WFINFOPAGEID, strValue);
    }

    public void setSTATEDEFID(String strValue) {
        this.SetParamValue(TAG_STATEDEFID, strValue);
    }

    public void setQUERYMODELID(String strValue) {
        this.SetParamValue(TAG_QUERYMODELID, strValue);
    }

    public String getWFGRIDPAGEID() {
        return this.GetParamStringValue(TAG_WFGRIDPAGEID, "");
    }

    public void setWFGRIDPAGEID(String strValue) {
        this.SetParamValue(TAG_WFGRIDPAGEID, strValue);
    }

    public void setDEID(String strDEID) {
        this.SetParamValue(TAG_DEID, strDEID);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "").trim();
    }

    public String getWFSTATEDEFID() {
        return this.GetParamStringValue(TAG_WFSTATEDEFID, "");
    }

    public String getWFSTEPDEFID() {
        return this.GetParamStringValue(TAG_WFSTEPDEFID, "");
    }

    public String getWFFIRSTACTION() {
        return this.GetParamStringValue(TAG_WFFIRSTACTION, "");
    }

    public String getWFID() {
        return this.GetParamStringValue(TAG_WFID, "").trim();
    }

    public String getWFINSTDEFID() {
        return this.GetParamStringValue(TAG_WFINSTDEFID, "");
    }

    public String getWFINFOPAGEID() {
        return this.GetParamStringValue(TAG_WFINFOPAGEID, "");
    }

    public String getMYWFWORK() {
        return this.GetParamStringValue(TAG_MYWFWORK, "");
    }

    public String getSTATEDEFID() {
        return this.GetParamStringValue(TAG_STATEDEFID, "");
    }

    public String getWFSTATEVALUE() {
        return this.GetParamStringValue(TAG_WFSTATEVALUE, "");
    }

    public String getQUERYMODELID() {
        return this.GetParamStringValue(TAG_QUERYMODELID, "");
    }

    public String getEDITABLEWFSTEP() {
        return this.GetParamStringValue(TAG_EDITABLEWFSTEP, "");
    }

    public String getINITSET() {
        return this.GetParamStringValue(TAG_INITSET, "");
    }

    public String getCANCELSET() {
        return this.GetParamStringValue(TAG_CANCELSET, "");
    }

    public String getCANCELSTARTSET() {
        return this.GetParamStringValue(TAG_CANCELSTARTSET, "");
    }

    public String getFINISHSET() {
        return this.GetParamStringValue(TAG_FINISHSET, "");
    }

    public String getINITOBJECT() {
        return this.GetParamStringValue(TAG_INITOBJECT, "");
    }

    public String getCANCELOBJECT() {
        return this.GetParamStringValue(TAG_CANCELOBJECT, "");
    }

    public String getCANCELSTARTOBJECT() {
        return this.GetParamStringValue(TAG_CANCELSTARTOBJECT, "");
    }

    public String getFINISHOBJECT() {
        return this.GetParamStringValue(TAG_FINISHOBJECT, "");
    }

    public String getWFACTORSDEFID() {
        return this.GetParamStringValue(TAG_WFACTORSDEFID, "");
    }

    public void setWFACTORSDEFID(String strValue) {
        this.SetParamValue(TAG_WFACTORSDEFID, strValue);
    }

    public String getWFACTORSDEFNAME() {
        return this.GetParamStringValue(TAG_WFACTORSDEFNAME, "");
    }

    public void setWFACTORSDEFNAME(String strValue) {
        this.SetParamValue(TAG_WFACTORSDEFNAME, strValue);
    }

    public boolean getUSERSTART() {
        return this.GetParamIntValue(TAG_USERSTART, 1) == 1;
    }

    public void setUSERSTART(boolean bValue) {
        this.SetParamValue(TAG_USERSTART, bValue ? 1 : 0);
    }

    public String getMSCLID() {
        return this.GetParamStringValue(TAG_MSCLID, "");
    }

    public void setMSCLID(String strValue) {
        this.SetParamValue(TAG_MSCLID, strValue);
    }

    public String getMSCLNAME() {
        return this.GetParamStringValue(TAG_MSCLNAME, "");
    }

    public void setMSCLNAME(String strValue) {
        this.SetParamValue(TAG_MSCLNAME, strValue);
    }

    public boolean isWFFINISHPAGEIDNull() {
        return this.IsParamNull(TAG_WFFINISHPAGEID);
    }

    public String getWFFINISHPAGEID() {
        return this.GetParamStringValue(TAG_WFFINISHPAGEID, "");
    }

    public void setWFFINISHPAGEID(String strValue) {
        this.SetParamValue(TAG_WFFINISHPAGEID, strValue);
    }

    public boolean isWFFINISHPAGENAMENull() {
        return this.IsParamNull(TAG_WFFINISHPAGENAME);
    }

    public String getWFFINISHPAGENAME() {
        return this.GetParamStringValue(TAG_WFFINISHPAGENAME, "");
    }

    public void setWFFINISHPAGENAME(String strValue) {
        this.SetParamValue(TAG_WFFINISHPAGENAME, strValue);
    }

    public boolean isFINISHPAGEPARAMNull() {
        return this.IsParamNull(TAG_FINISHPAGEPARAM);
    }

    public String getFINISHPAGEPARAM() {
        return this.GetParamStringValue(TAG_FINISHPAGEPARAM, "");
    }

    public void setFINISHPAGEPARAM(String strValue) {
        this.SetParamValue(TAG_FINISHPAGEPARAM, strValue);
    }

    public boolean isEXTCNTSTATESNull() {
        return this.IsParamNull(TAG_EXTCNTSTATES);
    }

    public String getEXTCNTSTATES() {
        return this.GetParamStringValue(TAG_EXTCNTSTATES, "");
    }

    public void setEXTCNTSTATES(String strValue) {
        this.SetParamValue(TAG_EXTCNTSTATES, strValue);
    }

    public String GetMYWFWORK(String strLanguage) {
        if (StringHelper.IsNullOrEmpty((String)strLanguage)) {
            return this.getMYWFWORK();
        }
        String strKey = StringHelper.Format((String)"%1$s.%2$s", (Object)TAG_MYWFWORK, (Object)strLanguage);
        return this.GetWFParam(strKey, this.getMYWFWORK());
    }

    public String GetWFFIRSTACTION(String strLanguage) {
        if (StringHelper.IsNullOrEmpty((String)strLanguage)) {
            return this.getWFFIRSTACTION();
        }
        String strKey = StringHelper.Format((String)"%1$s.%2$s", (Object)TAG_WFFIRSTACTION, (Object)strLanguage);
        return this.GetWFParam(strKey, this.getWFFIRSTACTION());
    }

    public boolean isOPENPAGESTATESNull() {
        return this.IsParamNull(TAG_OPENPAGESTATES);
    }

    public String getOPENPAGESTATES() {
        return this.GetParamStringValue(TAG_OPENPAGESTATES, "");
    }

    public void setOPENPAGESTATES(String strValue) {
        this.SetParamValue(TAG_OPENPAGESTATES, strValue);
    }

    public final boolean isSTARTACTIONFORMIDNull() {
        return this.IsParamNull(TAG_STARTACTIONFORMID);
    }

    public final String getSTARTACTIONFORMID() {
        return this.GetParamStringValue(TAG_STARTACTIONFORMID, "");
    }

    public final void setSTARTACTIONFORMID(String strValue) {
        this.SetParamValue(TAG_STARTACTIONFORMID, strValue);
    }

    public final boolean isSTARTACTIONFORMNAMENull() {
        return this.IsParamNull(TAG_STARTACTIONFORMNAME);
    }

    public final String getSTARTACTIONFORMNAME() {
        return this.GetParamStringValue(TAG_STARTACTIONFORMNAME, "");
    }

    public final void setSTARTACTIONFORMNAME(String strValue) {
        this.SetParamValue(TAG_STARTACTIONFORMNAME, strValue);
    }

    public final boolean isSTARTACTIONPAGEIDNull() {
        return this.IsParamNull(TAG_STARTACTIONPAGEID);
    }

    public final String getSTARTACTIONPAGEID() {
        return this.GetParamStringValue(TAG_STARTACTIONPAGEID, "");
    }

    public final void setSTARTACTIONPAGEID(String strValue) {
        this.SetParamValue(TAG_STARTACTIONPAGEID, strValue);
    }

    public final boolean isSTARTACTIONPAGENAMENull() {
        return this.IsParamNull(TAG_STARTACTIONPAGENAME);
    }

    public final String getSTARTACTIONPAGENAME() {
        return this.GetParamStringValue(TAG_STARTACTIONPAGENAME, "");
    }

    public final void setSTARTACTIONPAGENAME(String strValue) {
        this.SetParamValue(TAG_STARTACTIONPAGENAME, strValue);
    }

    public Properties getShortcutLinkParams() {
        if (this.shortcutLinkParams == null) {
            try {
                this.shortcutLinkParams = PropertiesHelper.Load((String)this.getSHORTCUTLINK());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.shortcutLinkParams;
    }

    public Properties getWFParams() {
        if (this.wfParams == null) {
            try {
                this.wfParams = PropertiesHelper.Load((String)this.getPARAMS());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.wfParams;
    }

    public String GetWFParam(String strPropertyName) {
        this.getWFParams();
        strPropertyName = strPropertyName.toUpperCase();
        String strDefaultValue = "";
        return PropertiesHelper.GetProperty((Properties)this.wfParams, (String)strPropertyName, (String)strDefaultValue);
    }

    public String GetWFParam(String strPropertyName, String strDefaultValue) {
        this.getWFParams();
        strPropertyName = strPropertyName.toUpperCase();
        return PropertiesHelper.GetProperty((Properties)this.wfParams, (String)strPropertyName, (String)strDefaultValue);
    }

    public boolean GetWFParam(String strPropertyName, boolean bDefaultValue) {
        String strValue = this.GetWFParam(strPropertyName);
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            return bDefaultValue;
        }
        return StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) == 0;
    }
}

