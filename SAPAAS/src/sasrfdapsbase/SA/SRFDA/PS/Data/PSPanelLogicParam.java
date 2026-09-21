/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSPanelLogicParam
extends BaseDataEntity {
    public static final String PARAMTYPE_INPUT = "INPUT";
    public static final String PARAMTYPE_TEMP = "TEMP";
    public static final String PARAMTYPE_PANELMODEL = "PANELMODEL";
    public static final String DATATYPE_OBJECT = "OBJECT";
    public static final String DATATYPE_OBJECTARRAY = "OBJECTARRAY";
    public static final String DATATYPE_STRING = "STRING";
    public static final String DATATYPE_STRINGARRAY = "STRINGARRAY";
    public static final String DATATYPE_INT = "INT";
    public static final String DATATYPE_INTARRAY = "INTARRAY";
    public static final String DATATYPE_NUMBER = "NUMBER";
    public static final String DATATYPE_NUMBERARRAY = "NUMBERARRAY";
    public static final String DATATYPE_BOOL = "BOOL";
    public static final String TAG_PSPANELLOGICPARAMID = "PSPANELLOGICPARAMID";
    public static final String TAG_PSPANELLOGICPARAMNAME = "PSPANELLOGICPARAMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_PSSYSVIEWPANELLOGICID = "PSSYSVIEWPANELLOGICID";
    public static final String TAG_PSSYSVIEWPANELLOGICNAME = "PSSYSVIEWPANELLOGICNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PARAMTYPE = "PARAMTYPE";
    public static final String TAG_DATATYPE = "DATATYPE";
    public static final String TAG_PSSYSVIEWPANELMODELID = "PSSYSVIEWPANELMODELID";
    public static final String TAG_PSSYSVIEWPANELMODELNAME = "PSSYSVIEWPANELMODELNAME";

    public final boolean isPSPANELLOGICPARAMIDNull() {
        return this.IsParamNull(TAG_PSPANELLOGICPARAMID);
    }

    public final String getPSPANELLOGICPARAMID() {
        return this.GetParamStringValue(TAG_PSPANELLOGICPARAMID, "");
    }

    public final void setPSPANELLOGICPARAMID(String strValue) {
        this.SetParamValue(TAG_PSPANELLOGICPARAMID, strValue);
    }

    public final boolean isPSPANELLOGICPARAMNAMENull() {
        return this.IsParamNull(TAG_PSPANELLOGICPARAMNAME);
    }

    public final String getPSPANELLOGICPARAMNAME() {
        return this.GetParamStringValue(TAG_PSPANELLOGICPARAMNAME, "");
    }

    public final void setPSPANELLOGICPARAMNAME(String strValue) {
        this.SetParamValue(TAG_PSPANELLOGICPARAMNAME, strValue);
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

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
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

    public final boolean isPSSYSVIEWPANELLOGICNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELLOGICNAME);
    }

    public final String getPSSYSVIEWPANELLOGICNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELLOGICNAME, "");
    }

    public final void setPSSYSVIEWPANELLOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELLOGICNAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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

    public final boolean isDATATYPENull() {
        return this.IsParamNull(TAG_DATATYPE);
    }

    public final String getDATATYPE() {
        return this.GetParamStringValue(TAG_DATATYPE, "");
    }

    public final void setDATATYPE(String strValue) {
        this.SetParamValue(TAG_DATATYPE, strValue);
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
}

