/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysPanelLogic
extends BaseDataEntity {
    public static final String LOGICTYPE_CTRLEVENT = "CTRLEVENT";
    public static final String LOGICTYPE_MODELCHANGE = "MODELCHANGE";
    public static final String LOGICTYPE_NORMAL = "NORMAL";
    public static final String TAG_PSSYSVIEWPANELLOGICID = "PSSYSVIEWPANELLOGICID";
    public static final String TAG_PSSYSVIEWPANELLOGICNAME = "PSSYSVIEWPANELLOGICNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_LOGICMODEL = "LOGICMODEL";
    public static final String TAG_PSSYSVIEWPANELITEMID = "PSSYSVIEWPANELITEMID";
    public static final String TAG_PSSYSVIEWPANELITEMNAME = "PSSYSVIEWPANELITEMNAME";
    public static final String TAG_CTRLEVENT = "CTRLEVENT";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_CTRLEVENTNAME = "CTRLEVENTNAME";
    public static final String TAG_PSSYSVIEWPANELMODELID = "PSSYSVIEWPANELMODELID";
    public static final String TAG_PSSYSVIEWPANELMODELNAME = "PSSYSVIEWPANELMODELNAME";
    public static final String TAG_LOGICTYPE = "LOGICTYPE";
    public static final String TAG_PARAMPSPANELITEMID = "PARAMPSPANELITEMID";
    public static final String TAG_PARAMPSPANELITEMNAME = "PARAMPSPANELITEMNAME";
    public static final String TAG_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String TAG_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String TAG_CTRLEVENTARG = "CTRLEVENTARG";
    public static final String TAG_CTRLEVENTARG2 = "CTRLEVENTARG2";
    public static final String TAG_DSTLOGICTYPE = "DSTLOGICTYPE";
    public static final String TAG_PSAPPFUNCID = "PSAPPFUNCID";
    public static final String TAG_PSAPPFUNCNAME = "PSAPPFUNCNAME";
    public static final String TAG_PSSYSVIEWLOGICID = "PSSYSVIEWLOGICID";
    public static final String TAG_PSSYSVIEWLOGICNAME = "PSSYSVIEWLOGICNAME";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_LOGICPARAM = "LOGICPARAM";
    public static final String TAG_LOGICPARAM2 = "LOGICPARAM2";
    public static final String TAG_TIMER = "TIMER";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_ATTRNAME = "ATTRNAME";
    public static final String TAG_ITEMNAME = "ITEMNAME";
    public static final String TAG_LAYOUTPSSYSVIEWPANELID = "LAYOUTPSSYSVIEWPANELID";
    public static final String TAG_LAYOUTPSSYSVIEWPANELNAME = "LAYOUTPSSYSVIEWPANELNAME";

    public final boolean isPSSYSVIEWPANELLOGICIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELLOGICID);
    }

    public final String getPSSYSVIEWPANELLOGICID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELLOGICID, "");
    }

    public final void setPSSYSVIEWPANELLOGICID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELLOGICID, strValue);
    }

    public final boolean isPSSYSVIEWPANELLOGICNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELLOGICNAME);
    }

    public final String getPSSYSVIEWPANELLOGICNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELLOGICNAME, "");
    }

    public final void setPSSYSVIEWPANELLOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELLOGICNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isLOGICMODELNull() {
        return this.IsParamNull(TAG_LOGICMODEL);
    }

    public final String getLOGICMODEL() {
        return this.GetParamStringValue(TAG_LOGICMODEL, "");
    }

    public final void setLOGICMODEL(String strValue) {
        this.SetParamValue(TAG_LOGICMODEL, strValue);
    }

    public final boolean isPSSYSVIEWPANELITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELITEMID);
    }

    public final String getPSSYSVIEWPANELITEMID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELITEMID, "");
    }

    public final void setPSSYSVIEWPANELITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELITEMID, strValue);
    }

    public final boolean isPSSYSVIEWPANELITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELITEMNAME);
    }

    public final String getPSSYSVIEWPANELITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELITEMNAME, "");
    }

    public final void setPSSYSVIEWPANELITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELITEMNAME, strValue);
    }

    public final boolean isCTRLEVENTNull() {
        return this.IsParamNull("CTRLEVENT");
    }

    public final String getCTRLEVENT() {
        return this.GetParamStringValue("CTRLEVENT", "");
    }

    public final void setCTRLEVENT(String strValue) {
        this.SetParamValue("CTRLEVENT", strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isCTRLEVENTNAMENull() {
        return this.IsParamNull(TAG_CTRLEVENTNAME);
    }

    public final String getCTRLEVENTNAME() {
        return this.GetParamStringValue(TAG_CTRLEVENTNAME, "");
    }

    public final void setCTRLEVENTNAME(String strValue) {
        this.SetParamValue(TAG_CTRLEVENTNAME, strValue);
    }

    public final boolean isPSSYSVIEWPANELMODELIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELMODELID);
    }

    public final String getPSSYSVIEWPANELMODELID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELMODELID, "");
    }

    public final void setPSSYSVIEWPANELMODELID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELMODELID, strValue);
    }

    public final boolean isPSSYSVIEWPANELMODELNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELMODELNAME);
    }

    public final String getPSSYSVIEWPANELMODELNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELMODELNAME, "");
    }

    public final void setPSSYSVIEWPANELMODELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELMODELNAME, strValue);
    }

    public final boolean isLOGICTYPENull() {
        return this.IsParamNull(TAG_LOGICTYPE);
    }

    public final String getLOGICTYPE() {
        return this.GetParamStringValue(TAG_LOGICTYPE, "");
    }

    public final void setLOGICTYPE(String strValue) {
        this.SetParamValue(TAG_LOGICTYPE, strValue);
    }

    public final boolean isPARAMPSPANELITEMIDNull() {
        return this.IsParamNull(TAG_PARAMPSPANELITEMID);
    }

    public final String getPARAMPSPANELITEMID() {
        return this.GetParamStringValue(TAG_PARAMPSPANELITEMID, "");
    }

    public final void setPARAMPSPANELITEMID(String strValue) {
        this.SetParamValue(TAG_PARAMPSPANELITEMID, strValue);
    }

    public final boolean isPARAMPSPANELITEMNAMENull() {
        return this.IsParamNull(TAG_PARAMPSPANELITEMNAME);
    }

    public final String getPARAMPSPANELITEMNAME() {
        return this.GetParamStringValue(TAG_PARAMPSPANELITEMNAME, "");
    }

    public final void setPARAMPSPANELITEMNAME(String strValue) {
        this.SetParamValue(TAG_PARAMPSPANELITEMNAME, strValue);
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

    public final boolean isCTRLEVENTARGNull() {
        return this.IsParamNull(TAG_CTRLEVENTARG);
    }

    public final String getCTRLEVENTARG() {
        return this.GetParamStringValue(TAG_CTRLEVENTARG, "");
    }

    public final void setCTRLEVENTARG(String strValue) {
        this.SetParamValue(TAG_CTRLEVENTARG, strValue);
    }

    public final boolean isCTRLEVENTARG2Null() {
        return this.IsParamNull(TAG_CTRLEVENTARG2);
    }

    public final String getCTRLEVENTARG2() {
        return this.GetParamStringValue(TAG_CTRLEVENTARG2, "");
    }

    public final void setCTRLEVENTARG2(String strValue) {
        this.SetParamValue(TAG_CTRLEVENTARG2, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
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

    public final boolean isTIMERNull() {
        return this.IsParamNull(TAG_TIMER);
    }

    public final int getTIMER() {
        return this.GetParamIntValue(TAG_TIMER, 0);
    }

    public final void setTIMER(int nValue) {
        this.SetParamValue(TAG_TIMER, nValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
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

    public final boolean isLAYOUTPSSYSVIEWPANELIDNull() {
        return this.IsParamNull(TAG_LAYOUTPSSYSVIEWPANELID);
    }

    public final String getLAYOUTPSSYSVIEWPANELID() {
        return this.GetParamStringValue(TAG_LAYOUTPSSYSVIEWPANELID, "");
    }

    public final void setLAYOUTPSSYSVIEWPANELID(String strValue) {
        this.SetParamValue(TAG_LAYOUTPSSYSVIEWPANELID, strValue);
    }

    public final boolean isLAYOUTPSSYSVIEWPANELNAMENull() {
        return this.IsParamNull(TAG_LAYOUTPSSYSVIEWPANELNAME);
    }

    public final String getLAYOUTPSSYSVIEWPANELNAME() {
        return this.GetParamStringValue(TAG_LAYOUTPSSYSVIEWPANELNAME, "");
    }

    public final void setLAYOUTPSSYSVIEWPANELNAME(String strValue) {
        this.SetParamValue(TAG_LAYOUTPSSYSVIEWPANELNAME, strValue);
    }
}

