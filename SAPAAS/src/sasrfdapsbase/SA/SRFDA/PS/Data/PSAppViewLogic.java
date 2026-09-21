/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppViewLogic
extends BaseDataEntity {
    public static final String PSAPPVIEWLOGICTYPE_TIMER = "TIMER";
    public static final String PSAPPVIEWLOGICTYPE_VIEWEVENT = "VIEWEVENT";
    public static final String PSAPPVIEWLOGICTYPE_CTRLEVENT = "CTRLEVENT";
    public static final String PSAPPVIEWLOGICTYPE_CUSTOM = "CUSTOM";
    public static final String TAG_PSAPPVIEWLOGICID = "PSAPPVIEWLOGICID";
    public static final String TAG_PSAPPVIEWLOGICNAME = "PSAPPVIEWLOGICNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String TAG_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PUBCODE = "PUBCODE";
    public static final String TAG_USERCODE = "USERCODE";
    public static final String TAG_INITLOGICMODE = "INITLOGICMODE";
    public static final String TAG_INITORDERVALUE = "INITORDERVALUE";
    public static final String TAG_REFPSAPPVIEWLOGICID = "REFPSAPPVIEWLOGICID";
    public static final String TAG_REFPSAPPVIEWLOGICNAME = "REFPSAPPVIEWLOGICNAME";
    public static final String TAG_EVENTARG = "EVENTARG";
    public static final String TAG_EVENTARG2 = "EVENTARG2";
    public static final String TAG_PSAPPVIEWCTRLID = "PSAPPVIEWCTRLID";
    public static final String TAG_PSAPPVIEWCTRLNAME = "PSAPPVIEWCTRLNAME";
    public static final String TAG_EVENTNAMES = "EVENTNAMES";
    public static final String TAG_DSTLOGICTYPE = "DSTLOGICTYPE";
    public static final String TAG_PSAPPVIEWLOGICTYPE = "PSAPPVIEWLOGICTYPE";
    public static final String TAG_PSSYSVIEWLOGICID = "PSSYSVIEWLOGICID";
    public static final String TAG_PSSYSVIEWLOGICNAME = "PSSYSVIEWLOGICNAME";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";

    public final boolean isPSAPPVIEWLOGICIDNull() {
        return this.IsParamNull(TAG_PSAPPVIEWLOGICID);
    }

    public final String getPSAPPVIEWLOGICID() {
        return this.GetParamStringValue(TAG_PSAPPVIEWLOGICID, "");
    }

    public final void setPSAPPVIEWLOGICID(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWLOGICID, strValue);
    }

    public final boolean isPSAPPVIEWLOGICNAMENull() {
        return this.IsParamNull(TAG_PSAPPVIEWLOGICNAME);
    }

    public final String getPSAPPVIEWLOGICNAME() {
        return this.GetParamStringValue(TAG_PSAPPVIEWLOGICNAME, "");
    }

    public final void setPSAPPVIEWLOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWLOGICNAME, strValue);
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

    public final boolean isPUBCODENull() {
        return this.IsParamNull(TAG_PUBCODE);
    }

    public final String getPUBCODE() {
        return this.GetParamStringValue(TAG_PUBCODE, "");
    }

    public final void setPUBCODE(String strValue) {
        this.SetParamValue(TAG_PUBCODE, strValue);
    }

    public final boolean isUSERCODENull() {
        return this.IsParamNull(TAG_USERCODE);
    }

    public final String getUSERCODE() {
        return this.GetParamStringValue(TAG_USERCODE, "");
    }

    public final void setUSERCODE(String strValue) {
        this.SetParamValue(TAG_USERCODE, strValue);
    }

    public final boolean isINITLOGICMODENull() {
        return this.IsParamNull(TAG_INITLOGICMODE);
    }

    public final boolean getINITLOGICMODE() {
        return this.GetParamIntValue(TAG_INITLOGICMODE, 0) == 1;
    }

    public final void setINITLOGICMODE(boolean bValue) {
        this.SetParamValue(TAG_INITLOGICMODE, bValue ? 1 : 0);
    }

    public final boolean isINITORDERVALUENull() {
        return this.IsParamNull(TAG_INITORDERVALUE);
    }

    public final int getINITORDERVALUE() {
        return this.GetParamIntValue(TAG_INITORDERVALUE, 0);
    }

    public final void setINITORDERVALUE(int nValue) {
        this.SetParamValue(TAG_INITORDERVALUE, nValue);
    }

    public final boolean isREFPSAPPVIEWLOGICIDNull() {
        return this.IsParamNull(TAG_REFPSAPPVIEWLOGICID);
    }

    public final String getREFPSAPPVIEWLOGICID() {
        return this.GetParamStringValue(TAG_REFPSAPPVIEWLOGICID, "");
    }

    public final void setREFPSAPPVIEWLOGICID(String strValue) {
        this.SetParamValue(TAG_REFPSAPPVIEWLOGICID, strValue);
    }

    public final boolean isREFPSAPPVIEWLOGICNAMENull() {
        return this.IsParamNull(TAG_REFPSAPPVIEWLOGICNAME);
    }

    public final String getREFPSAPPVIEWLOGICNAME() {
        return this.GetParamStringValue(TAG_REFPSAPPVIEWLOGICNAME, "");
    }

    public final void setREFPSAPPVIEWLOGICNAME(String strValue) {
        this.SetParamValue(TAG_REFPSAPPVIEWLOGICNAME, strValue);
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

    public final boolean isDSTLOGICTYPENull() {
        return this.IsParamNull(TAG_DSTLOGICTYPE);
    }

    public final String getDSTLOGICTYPE() {
        return this.GetParamStringValue(TAG_DSTLOGICTYPE, "");
    }

    public final void setDSTLOGICTYPE(String strValue) {
        this.SetParamValue(TAG_DSTLOGICTYPE, strValue);
    }

    public final boolean isPSAPPVIEWCTRLIDNull() {
        return this.IsParamNull(TAG_PSAPPVIEWCTRLID);
    }

    public final String getPSAPPVIEWCTRLID() {
        return this.GetParamStringValue(TAG_PSAPPVIEWCTRLID, "");
    }

    public final void setPSAPPVIEWCTRLID(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWCTRLID, strValue);
    }

    public final boolean isPSAPPVIEWCTRLNAMENull() {
        return this.IsParamNull(TAG_PSAPPVIEWCTRLNAME);
    }

    public final String getPSAPPVIEWCTRLNAME() {
        return this.GetParamStringValue(TAG_PSAPPVIEWCTRLNAME, "");
    }

    public final void setPSAPPVIEWCTRLNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWCTRLNAME, strValue);
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

    public final boolean isPSAPPVIEWLOGICTYPENull() {
        return this.IsParamNull(TAG_PSAPPVIEWLOGICTYPE);
    }

    public final String getPSAPPVIEWLOGICTYPE() {
        return this.GetParamStringValue(TAG_PSAPPVIEWLOGICTYPE, "");
    }

    public final void setPSAPPVIEWLOGICTYPE(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWLOGICTYPE, strValue);
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

    public final boolean isCUSTOMCODENull() {
        return this.IsParamNull(TAG_CUSTOMCODE);
    }

    public final String getCUSTOMCODE() {
        return this.GetParamStringValue(TAG_CUSTOMCODE, "");
    }

    public final void setCUSTOMCODE(String strValue) {
        this.SetParamValue(TAG_CUSTOMCODE, strValue);
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

