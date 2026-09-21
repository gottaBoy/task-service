/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSCtrlLogicGroupDetail
extends BaseDataEntity {
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String DSTLOGICTYPE_DELOGIC = "DELOGIC";
    public static final String DSTLOGICTYPE_SYSVIEWLOGIC = "SYSVIEWLOGIC";
    public static final String DSTLOGICTYPE_APPVIEWLOGIC = "APPVIEWLOGIC";
    public static final String TAG_PSCTRLLOGICGRPDETAILID = "PSCTRLLOGICGRPDETAILID";
    public static final String TAG_PSCTRLLOGICGRPDETAILNAME = "PSCTRLLOGICGRPDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String TAG_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_DSTLOGICTYPE = "DSTLOGICTYPE";
    public static final String TAG_EVENTNAMES = "EVENTNAMES";
    public static final String TAG_LOGICPARAM = "LOGICPARAM";
    public static final String TAG_LOGICPARAM2 = "LOGICPARAM2";
    public static final String TAG_EVENTARG = "EVENTARG";
    public static final String TAG_EVENTARG2 = "EVENTARG2";
    public static final String TAG_TIMER = "TIMER";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_PSSYSVIEWLOGICID = "PSSYSVIEWLOGICID";
    public static final String TAG_PSSYSVIEWLOGICNAME = "PSSYSVIEWLOGICNAME";
    public static final String TAG_CTRLNAME = "CTRLNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_TRIGGERTYPE = "TRIGGERTYPE";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String TAG_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String TAG_ITEMNAME = "ITEMNAME";
    public static final String TAG_ATTRNAME = "ATTRNAME";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";

    public final boolean isPSCTRLLOGICGRPDETAILIDNull() {
        return this.IsParamNull(TAG_PSCTRLLOGICGRPDETAILID);
    }

    public final String getPSCTRLLOGICGRPDETAILID() {
        return this.GetParamStringValue(TAG_PSCTRLLOGICGRPDETAILID, "");
    }

    public final void setPSCTRLLOGICGRPDETAILID(String strValue) {
        this.SetParamValue(TAG_PSCTRLLOGICGRPDETAILID, strValue);
    }

    public final boolean isPSCTRLLOGICGRPDETAILNAMENull() {
        return this.IsParamNull(TAG_PSCTRLLOGICGRPDETAILNAME);
    }

    public final String getPSCTRLLOGICGRPDETAILNAME() {
        return this.GetParamStringValue(TAG_PSCTRLLOGICGRPDETAILNAME, "");
    }

    public final void setPSCTRLLOGICGRPDETAILNAME(String strValue) {
        this.SetParamValue(TAG_PSCTRLLOGICGRPDETAILNAME, strValue);
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

    public final boolean isPSCTRLLOGICGROUPIDNull() {
        return this.IsParamNull(TAG_PSCTRLLOGICGROUPID);
    }

    public final String getPSCTRLLOGICGROUPID() {
        return this.GetParamStringValue(TAG_PSCTRLLOGICGROUPID, "");
    }

    public final void setPSCTRLLOGICGROUPID(String strValue) {
        this.SetParamValue(TAG_PSCTRLLOGICGROUPID, strValue);
    }

    public final boolean isPSCTRLLOGICGROUPNAMENull() {
        return this.IsParamNull(TAG_PSCTRLLOGICGROUPNAME);
    }

    public final String getPSCTRLLOGICGROUPNAME() {
        return this.GetParamStringValue(TAG_PSCTRLLOGICGROUPNAME, "");
    }

    public final void setPSCTRLLOGICGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSCTRLLOGICGROUPNAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
    }

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
    }

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
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

    public final boolean isTIMERNull() {
        return this.IsParamNull(TAG_TIMER);
    }

    public final int getTIMER() {
        return this.GetParamIntValue(TAG_TIMER, 0);
    }

    public final void setTIMER(int nValue) {
        this.SetParamValue(TAG_TIMER, nValue);
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

    public final boolean isCTRLNAMENull() {
        return this.IsParamNull(TAG_CTRLNAME);
    }

    public final String getCTRLNAME() {
        return this.GetParamStringValue(TAG_CTRLNAME, "");
    }

    public final void setCTRLNAME(String strValue) {
        this.SetParamValue(TAG_CTRLNAME, strValue);
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

    public final boolean isTRIGGERTYPENull() {
        return this.IsParamNull(TAG_TRIGGERTYPE);
    }

    public final String getTRIGGERTYPE() {
        return this.GetParamStringValue(TAG_TRIGGERTYPE, "");
    }

    public final void setTRIGGERTYPE(String strValue) {
        this.SetParamValue(TAG_TRIGGERTYPE, strValue);
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

    public final boolean isITEMNAMENull() {
        return this.IsParamNull(TAG_ITEMNAME);
    }

    public final String getITEMNAME() {
        return this.GetParamStringValue(TAG_ITEMNAME, "");
    }

    public final void setITEMNAME(String strValue) {
        this.SetParamValue(TAG_ITEMNAME, strValue);
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
}

