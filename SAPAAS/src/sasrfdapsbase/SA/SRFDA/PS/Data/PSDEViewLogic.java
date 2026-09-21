/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEViewLogic
extends BaseDataEntity {
    public static final String PSDEVIEWLOGICTYPE_TIMER = "TIMER";
    public static final String PSDEVIEWLOGICTYPE_VIEWEVENT = "VIEWEVENT";
    public static final String PSDEVIEWLOGICTYPE_CTRLEVENT = "CTRLEVENT";
    public static final String PSDEVIEWLOGICTYPE_CUSTOM = "CUSTOM";
    public static final String DSTLOGICTYPE_DELOGIC = "DELOGIC";
    public static final String DSTLOGICTYPE_DEUILOGIC = "DEUILOGIC";
    public static final String DSTLOGICTYPE_DEUIACTION = "DEUIACTION";
    public static final String DSTLOGICTYPE_SYSVIEWLOGIC = "SYSVIEWLOGIC";
    public static final String DSTLOGICTYPE_APPVIEWLOGIC = "APPVIEWLOGIC";
    public static final String DSTLOGICTYPE_APPVIEWENGINE = "APPVIEWENGINE";
    public static final String DSTLOGICTYPE_APPVIEWUIACTION = "APPVIEWUIACTION";
    public static final String DSTLOGICTYPE_CUSTOM = "CUSTOM";
    public static final String DSTLOGICTYPE_SCRIPT = "SCRIPT";
    public static final String DSTLOGICTYPE_PFPLUGIN = "PFPLUGIN";
    public static final String TAG_PSDEVIEWLOGICID = "PSDEVIEWLOGICID";
    public static final String TAG_PSDEVIEWLOGICNAME = "PSDEVIEWLOGICNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String TAG_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String TAG_PSVIEWLOGICTYPEID = "PSVIEWLOGICTYPEID";
    public static final String TAG_PSVIEWLOGICTYPENAME = "PSVIEWLOGICTYPENAME";
    public static final String TAG_PSDEVIEWLOGICTYPE = "PSDEVIEWLOGICTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_TIMER = "TIMER";
    public static final String TAG_PSDEVIEWCTRLID = "PSDEVIEWCTRLID";
    public static final String TAG_PSDEVIEWCTRLNAME = "PSDEVIEWCTRLNAME";
    public static final String TAG_EVENTNAMES = "EVENTNAMES";
    public static final String TAG_LOGICPARAM = "LOGICPARAM";
    public static final String TAG_LOGICPARAM2 = "LOGICPARAM2";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_PSSYSVIEWLOGICID = "PSSYSVIEWLOGICID";
    public static final String TAG_PSSYSVIEWLOGICNAME = "PSSYSVIEWLOGICNAME";
    public static final String TAG_DSTLOGICTYPE = "DSTLOGICTYPE";
    public static final String TAG_PSCTRLTYPEEVENTID = "PSCTRLTYPEEVENTID";
    public static final String TAG_PSCTRLTYPEEVENTNAME = "PSCTRLTYPEEVENTNAME";
    public static final String TAG_REFPSDEVIEWLOGICID = "REFPSDEVIEWLOGICID";
    public static final String TAG_REFPSDEVIEWLOGICNAME = "REFPSDEVIEWLOGICNAME";
    public static final String TAG_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String TAG_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String TAG_PARAMPSDEVIEWCTRLID = "PARAMPSDEVIEWCTRLID";
    public static final String TAG_PARAMPSDEVIEWCTRLNAME = "PARAMPSDEVIEWCTRLNAME";
    public static final String TAG_EVENTARG = "EVENTARG";
    public static final String TAG_EVENTARG2 = "EVENTARG2";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_ATTRNAME = "ATTRNAME";
    public static final String TAG_ITEMNAME = "ITEMNAME";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";

    public final boolean isPSDEVIEWLOGICIDNull() {
        return this.IsParamNull(TAG_PSDEVIEWLOGICID);
    }

    public final String getPSDEVIEWLOGICID() {
        return this.GetParamStringValue(TAG_PSDEVIEWLOGICID, "");
    }

    public final void setPSDEVIEWLOGICID(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWLOGICID, strValue);
    }

    public final boolean isPSDEVIEWLOGICNAMENull() {
        return this.IsParamNull(TAG_PSDEVIEWLOGICNAME);
    }

    public final String getPSDEVIEWLOGICNAME() {
        return this.GetParamStringValue(TAG_PSDEVIEWLOGICNAME, "");
    }

    public final void setPSDEVIEWLOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWLOGICNAME, strValue);
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

    public final boolean isPSDEVIEWBASEIDNull() {
        return this.IsParamNull(TAG_PSDEVIEWBASEID);
    }

    public final String getPSDEVIEWBASEID() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASEID, "");
    }

    public final void setPSDEVIEWBASEID(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASEID, strValue);
    }

    public final boolean isPSDEVIEWBASENAMENull() {
        return this.IsParamNull(TAG_PSDEVIEWBASENAME);
    }

    public final String getPSDEVIEWBASENAME() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASENAME, "");
    }

    public final void setPSDEVIEWBASENAME(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASENAME, strValue);
    }

    public final boolean isPSVIEWLOGICTYPEIDNull() {
        return this.IsParamNull(TAG_PSVIEWLOGICTYPEID);
    }

    public final String getPSVIEWLOGICTYPEID() {
        return this.GetParamStringValue(TAG_PSVIEWLOGICTYPEID, "");
    }

    public final void setPSVIEWLOGICTYPEID(String strValue) {
        this.SetParamValue(TAG_PSVIEWLOGICTYPEID, strValue);
    }

    public final boolean isPSVIEWLOGICTYPENAMENull() {
        return this.IsParamNull(TAG_PSVIEWLOGICTYPENAME);
    }

    public final String getPSVIEWLOGICTYPENAME() {
        return this.GetParamStringValue(TAG_PSVIEWLOGICTYPENAME, "");
    }

    public final void setPSVIEWLOGICTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSVIEWLOGICTYPENAME, strValue);
    }

    public final boolean isPSDEVIEWLOGICTYPENull() {
        return this.IsParamNull(TAG_PSDEVIEWLOGICTYPE);
    }

    public final String getPSDEVIEWLOGICTYPE() {
        return this.GetParamStringValue(TAG_PSDEVIEWLOGICTYPE, "");
    }

    public final void setPSDEVIEWLOGICTYPE(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWLOGICTYPE, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isTIMERNull() {
        return this.IsParamNull("TIMER");
    }

    public final int getTIMER() {
        return this.GetParamIntValue("TIMER", 0);
    }

    public final void setTIMER(int nValue) {
        this.SetParamValue("TIMER", nValue);
    }

    public final boolean isPSDEVIEWCTRLIDNull() {
        return this.IsParamNull(TAG_PSDEVIEWCTRLID);
    }

    public final String getPSDEVIEWCTRLID() {
        return this.GetParamStringValue(TAG_PSDEVIEWCTRLID, "");
    }

    public final void setPSDEVIEWCTRLID(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWCTRLID, strValue);
    }

    public final boolean isPSDEVIEWCTRLNAMENull() {
        return this.IsParamNull(TAG_PSDEVIEWCTRLNAME);
    }

    public final String getPSDEVIEWCTRLNAME() {
        return this.GetParamStringValue(TAG_PSDEVIEWCTRLNAME, "");
    }

    public final void setPSDEVIEWCTRLNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWCTRLNAME, strValue);
    }

    public final boolean isEVENTNAMESNull() {
        return this.IsParamNull(TAG_EVENTNAMES);
    }

    public final String getEVENTNAMES() {
        return this.GetParamStringValue(TAG_EVENTNAMES, "");
    }

    public final void setEVENTNAMES(String strValue) {
        this.SetParamValue(TAG_EVENTNAMES, strValue);
    }

    public final boolean isLOGICPARAMNull() {
        return this.IsParamNull(TAG_LOGICPARAM);
    }

    public final String getLOGICPARAM() {
        return this.GetParamStringValue(TAG_LOGICPARAM, "");
    }

    public final void setLOGICPARAM(String strValue) {
        this.SetParamValue(TAG_LOGICPARAM, strValue);
    }

    public final boolean isLOGICPARAM2Null() {
        return this.IsParamNull(TAG_LOGICPARAM2);
    }

    public final String getLOGICPARAM2() {
        return this.GetParamStringValue(TAG_LOGICPARAM2, "");
    }

    public final void setLOGICPARAM2(String strValue) {
        this.SetParamValue(TAG_LOGICPARAM2, strValue);
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

    public final boolean isPSSYSVIEWLOGICIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWLOGICID);
    }

    public final String getPSSYSVIEWLOGICID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWLOGICID, "");
    }

    public final void setPSSYSVIEWLOGICID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWLOGICID, strValue);
    }

    public final boolean isPSSYSVIEWLOGICNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWLOGICNAME);
    }

    public final String getPSSYSVIEWLOGICNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWLOGICNAME, "");
    }

    public final void setPSSYSVIEWLOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWLOGICNAME, strValue);
    }

    public final boolean isDSTLOGICTYPENull() {
        return this.IsParamNull(TAG_DSTLOGICTYPE);
    }

    public final String getDSTLOGICTYPE() {
        return this.GetParamStringValue(TAG_DSTLOGICTYPE, "");
    }

    public final void setDSTLOGICTYPE(String strValue) {
        this.SetParamValue(TAG_DSTLOGICTYPE, strValue);
    }

    public final boolean isPSCTRLTYPEEVENTIDNull() {
        return this.IsParamNull(TAG_PSCTRLTYPEEVENTID);
    }

    public final String getPSCTRLTYPEEVENTID() {
        return this.GetParamStringValue(TAG_PSCTRLTYPEEVENTID, "");
    }

    public final void setPSCTRLTYPEEVENTID(String strValue) {
        this.SetParamValue(TAG_PSCTRLTYPEEVENTID, strValue);
    }

    public final boolean isPSCTRLTYPEEVENTNAMENull() {
        return this.IsParamNull(TAG_PSCTRLTYPEEVENTNAME);
    }

    public final String getPSCTRLTYPEEVENTNAME() {
        return this.GetParamStringValue(TAG_PSCTRLTYPEEVENTNAME, "");
    }

    public final void setPSCTRLTYPEEVENTNAME(String strValue) {
        this.SetParamValue(TAG_PSCTRLTYPEEVENTNAME, strValue);
    }

    public final boolean isREFPSDEVIEWLOGICNAMENull() {
        return this.IsParamNull(TAG_REFPSDEVIEWLOGICNAME);
    }

    public final String getREFPSDEVIEWLOGICNAME() {
        return this.GetParamStringValue(TAG_REFPSDEVIEWLOGICNAME, "");
    }

    public final void setREFPSDEVIEWLOGICNAME(String strValue) {
        this.SetParamValue(TAG_REFPSDEVIEWLOGICNAME, strValue);
    }

    public final boolean isREFPSDEVIEWLOGICIDNull() {
        return this.IsParamNull(TAG_REFPSDEVIEWLOGICID);
    }

    public final String getREFPSDEVIEWLOGICID() {
        return this.GetParamStringValue(TAG_REFPSDEVIEWLOGICID, "");
    }

    public final void setREFPSDEVIEWLOGICID(String strValue) {
        this.SetParamValue(TAG_REFPSDEVIEWLOGICID, strValue);
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

    public final boolean isPARAMPSDEVIEWCTRLIDNull() {
        return this.IsParamNull(TAG_PARAMPSDEVIEWCTRLID);
    }

    public final String getPARAMPSDEVIEWCTRLID() {
        return this.GetParamStringValue(TAG_PARAMPSDEVIEWCTRLID, "");
    }

    public final void setPARAMPSDEVIEWCTRLID(String strValue) {
        this.SetParamValue(TAG_PARAMPSDEVIEWCTRLID, strValue);
    }

    public final boolean isPARAMPSDEVIEWCTRLNAMENull() {
        return this.IsParamNull(TAG_PARAMPSDEVIEWCTRLNAME);
    }

    public final String getPARAMPSDEVIEWCTRLNAME() {
        return this.GetParamStringValue(TAG_PARAMPSDEVIEWCTRLNAME, "");
    }

    public final void setPARAMPSDEVIEWCTRLNAME(String strValue) {
        this.SetParamValue(TAG_PARAMPSDEVIEWCTRLNAME, strValue);
    }

    public final boolean isEVENTARGNull() {
        return this.IsParamNull(TAG_EVENTARG);
    }

    public final String getEVENTARG() {
        return this.GetParamStringValue(TAG_EVENTARG, "");
    }

    public final void setEVENTARG(String strValue) {
        this.SetParamValue(TAG_EVENTARG, strValue);
    }

    public final boolean isEVENTARG2Null() {
        return this.IsParamNull(TAG_EVENTARG2);
    }

    public final String getEVENTARG2() {
        return this.GetParamStringValue(TAG_EVENTARG2, "");
    }

    public final void setEVENTARG2(String strValue) {
        this.SetParamValue(TAG_EVENTARG2, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isCUSTOMCODENull() {
        return this.IsParamNull(TAG_CUSTOMCODE);
    }

    public final String getCUSTOMCODE() {
        return this.GetParamStringValue(TAG_CUSTOMCODE, "");
    }

    public final void setCUSTOMCODE(String strValue) {
        this.SetParamValue(TAG_CUSTOMCODE, strValue);
    }

    public final boolean isATTRNAMENull() {
        return this.IsParamNull(TAG_ATTRNAME);
    }

    public final String getATTRNAME() {
        return this.GetParamStringValue(TAG_ATTRNAME, "");
    }

    public final void setATTRNAME(String strValue) {
        this.SetParamValue(TAG_ATTRNAME, strValue);
    }

    public final boolean isITEMNAMENull() {
        return this.IsParamNull(TAG_ITEMNAME);
    }

    public final String getITEMNAME() {
        return this.GetParamStringValue(TAG_ITEMNAME, "");
    }

    public final void setITEMNAME(String strValue) {
        this.SetParamValue(TAG_ITEMNAME, strValue);
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
}

