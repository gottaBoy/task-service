/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSPanelLogicNodeParam
extends BaseDataEntity {
    public static final String PARAMTYPE_SETMODEL = "SETMODEL";
    public static final String PARAMTYPE_RESETMODEL = "RESETMODEL";
    public static final String PARAMTYPE_COPYMODEL = "COPYMODEL";
    public static final String PARAMTYPE_PUSHARRAY = "PUSHARRAY";
    public static final String SRCVALUETYPE_SRCMODEL = "SRCMODEL";
    public static final String SRCVALUETYPE_WEBCONTEXT = "WEBCONTEXT";
    public static final String SRCVALUETYPE_NONEVALUE = "NONEVALUE";
    public static final String SRCVALUETYPE_NULLVALUE = "NULLVALUE";
    public static final String TAG_PSPANELLNPARAMID = "PSPANELLNPARAMID";
    public static final String TAG_PSPANELLNPARAMNAME = "PSPANELLNPARAMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSPANELLOGICNODEID = "PSPANELLOGICNODEID";
    public static final String TAG_PSPANELLOGICNODENAME = "PSPANELLOGICNODENAME";
    public static final String TAG_SRCPSPANELLPID = "SRCPSPANELLPID";
    public static final String TAG_SRCPSPANELLPNAME = "SRCPSPANELLPNAME";
    public static final String TAG_DSTPSPANELLPID = "DSTPSPANELLPID";
    public static final String TAG_DSTPSPANELLPNAME = "DSTPSPANELLPNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_PARAMTYPE = "PARAMTYPE";
    public static final String TAG_SRCVALUE = "SRCVALUE";
    public static final String TAG_SRCVALUETYPE = "SRCVALUETYPE";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_SRCFIELDNAME = "SRCFIELDNAME";
    public static final String TAG_DSTFIELDNAME = "DSTFIELDNAME";
    public static final String TAG_PSSYSVIEWPANELLOGICID = "PSSYSVIEWPANELLOGICID";

    public final boolean isPSPANELLNPARAMIDNull() {
        return this.IsParamNull(TAG_PSPANELLNPARAMID);
    }

    public final String getPSPANELLNPARAMID() {
        return this.GetParamStringValue(TAG_PSPANELLNPARAMID, "");
    }

    public final void setPSPANELLNPARAMID(String strValue) {
        this.SetParamValue(TAG_PSPANELLNPARAMID, strValue);
    }

    public final boolean isPSPANELLNPARAMNAMENull() {
        return this.IsParamNull(TAG_PSPANELLNPARAMNAME);
    }

    public final String getPSPANELLNPARAMNAME() {
        return this.GetParamStringValue(TAG_PSPANELLNPARAMNAME, "");
    }

    public final void setPSPANELLNPARAMNAME(String strValue) {
        this.SetParamValue(TAG_PSPANELLNPARAMNAME, strValue);
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

    public final boolean isPSPANELLOGICNODEIDNull() {
        return this.IsParamNull(TAG_PSPANELLOGICNODEID);
    }

    public final String getPSPANELLOGICNODEID() {
        return this.GetParamStringValue(TAG_PSPANELLOGICNODEID, "");
    }

    public final void setPSPANELLOGICNODEID(String strValue) {
        this.SetParamValue(TAG_PSPANELLOGICNODEID, strValue);
    }

    public final boolean isPSPANELLOGICNODENAMENull() {
        return this.IsParamNull(TAG_PSPANELLOGICNODENAME);
    }

    public final String getPSPANELLOGICNODENAME() {
        return this.GetParamStringValue(TAG_PSPANELLOGICNODENAME, "");
    }

    public final void setPSPANELLOGICNODENAME(String strValue) {
        this.SetParamValue(TAG_PSPANELLOGICNODENAME, strValue);
    }

    public final boolean isSRCPSPANELLPIDNull() {
        return this.IsParamNull(TAG_SRCPSPANELLPID);
    }

    public final String getSRCPSPANELLPID() {
        return this.GetParamStringValue(TAG_SRCPSPANELLPID, "");
    }

    public final void setSRCPSPANELLPID(String strValue) {
        this.SetParamValue(TAG_SRCPSPANELLPID, strValue);
    }

    public final boolean isSRCPSPANELLPNAMENull() {
        return this.IsParamNull(TAG_SRCPSPANELLPNAME);
    }

    public final String getSRCPSPANELLPNAME() {
        return this.GetParamStringValue(TAG_SRCPSPANELLPNAME, "");
    }

    public final void setSRCPSPANELLPNAME(String strValue) {
        this.SetParamValue(TAG_SRCPSPANELLPNAME, strValue);
    }

    public final boolean isDSTPSPANELLPIDNull() {
        return this.IsParamNull(TAG_DSTPSPANELLPID);
    }

    public final String getDSTPSPANELLPID() {
        return this.GetParamStringValue(TAG_DSTPSPANELLPID, "");
    }

    public final void setDSTPSPANELLPID(String strValue) {
        this.SetParamValue(TAG_DSTPSPANELLPID, strValue);
    }

    public final boolean isDSTPSPANELLPNAMENull() {
        return this.IsParamNull(TAG_DSTPSPANELLPNAME);
    }

    public final String getDSTPSPANELLPNAME() {
        return this.GetParamStringValue(TAG_DSTPSPANELLPNAME, "");
    }

    public final void setDSTPSPANELLPNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSPANELLPNAME, strValue);
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

    public final boolean isPARAMTYPENull() {
        return this.IsParamNull(TAG_PARAMTYPE);
    }

    public final String getPARAMTYPE() {
        return this.GetParamStringValue(TAG_PARAMTYPE, "");
    }

    public final void setPARAMTYPE(String strValue) {
        this.SetParamValue(TAG_PARAMTYPE, strValue);
    }

    public final boolean isSRCVALUENull() {
        return this.IsParamNull(TAG_SRCVALUE);
    }

    public final String getSRCVALUE() {
        return this.GetParamStringValue(TAG_SRCVALUE, "");
    }

    public final void setSRCVALUE(String strValue) {
        this.SetParamValue(TAG_SRCVALUE, strValue);
    }

    public final boolean isSRCVALUETYPENull() {
        return this.IsParamNull(TAG_SRCVALUETYPE);
    }

    public final String getSRCVALUETYPE() {
        return this.GetParamStringValue(TAG_SRCVALUETYPE, "");
    }

    public final void setSRCVALUETYPE(String strValue) {
        this.SetParamValue(TAG_SRCVALUETYPE, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isSRCFIELDNAMENull() {
        return this.IsParamNull(TAG_SRCFIELDNAME);
    }

    public final String getSRCFIELDNAME() {
        return this.GetParamStringValue(TAG_SRCFIELDNAME, "");
    }

    public final void setSRCFIELDNAME(String strValue) {
        this.SetParamValue(TAG_SRCFIELDNAME, strValue);
    }

    public final boolean isDSTFIELDNAMENull() {
        return this.IsParamNull(TAG_DSTFIELDNAME);
    }

    public final String getDSTFIELDNAME() {
        return this.GetParamStringValue(TAG_DSTFIELDNAME, "");
    }

    public final void setDSTFIELDNAME(String strValue) {
        this.SetParamValue(TAG_DSTFIELDNAME, strValue);
    }

    public final boolean isPSSYSVIEWPANELLOGICIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELLOGICID);
    }

    public final String getPSSYSVIEWPANELLOGICID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELLOGICID, "");
    }

    public final void setPSSYSVIEWPANELLOGICID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELLOGICID, strValue);
    }
}

