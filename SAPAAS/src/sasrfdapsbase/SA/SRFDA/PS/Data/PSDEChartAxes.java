/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEChartAxes
extends BaseDataEntity {
    public static final String AXESPOS_left = "left";
    public static final String AXESPOS_bottom = "bottom";
    public static final String AXESPOS_right = "right";
    public static final String AXESPOS_top = "top";
    public static final String AXESPOS_radial = "radial";
    public static final String AXESPOS_angular = "angular";
    public static final String AXESTYPE_numeric = "numeric";
    public static final String AXESTYPE_time = "time";
    public static final String AXESTYPE_category = "category";
    public static final String TAG_PSDECHARTAXESID = "PSDECHARTAXESID";
    public static final String TAG_PSDECHARTAXESNAME = "PSDECHARTAXESNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDECHARTID = "PSDECHARTID";
    public static final String TAG_PSDECHARTNAME = "PSDECHARTNAME";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_AXESPOS = "AXESPOS";
    public static final String TAG_AXESTYPE = "AXESTYPE";
    public static final String TAG_AXESMAXVALUE = "AXESMAXVALUE";
    public static final String TAG_AXESMINVALUE = "AXESMINVALUE";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_FIELDS = "FIELDS";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String TAG_DATASHOWMODE = "DATASHOWMODE";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_COORDINATESYSTEMID = "COORDINATESYSTEMID";

    public final boolean isPSDECHARTAXESIDNull() {
        return this.IsParamNull(TAG_PSDECHARTAXESID);
    }

    public final String getPSDECHARTAXESID() {
        return this.GetParamStringValue(TAG_PSDECHARTAXESID, "");
    }

    public final void setPSDECHARTAXESID(String strValue) {
        this.SetParamValue(TAG_PSDECHARTAXESID, strValue);
    }

    public final boolean isPSDECHARTAXESNAMENull() {
        return this.IsParamNull(TAG_PSDECHARTAXESNAME);
    }

    public final String getPSDECHARTAXESNAME() {
        return this.GetParamStringValue(TAG_PSDECHARTAXESNAME, "");
    }

    public final void setPSDECHARTAXESNAME(String strValue) {
        this.SetParamValue(TAG_PSDECHARTAXESNAME, strValue);
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

    public final boolean isPSDECHARTIDNull() {
        return this.IsParamNull(TAG_PSDECHARTID);
    }

    public final String getPSDECHARTID() {
        return this.GetParamStringValue(TAG_PSDECHARTID, "");
    }

    public final void setPSDECHARTID(String strValue) {
        this.SetParamValue(TAG_PSDECHARTID, strValue);
    }

    public final boolean isPSDECHARTNAMENull() {
        return this.IsParamNull(TAG_PSDECHARTNAME);
    }

    public final String getPSDECHARTNAME() {
        return this.GetParamStringValue(TAG_PSDECHARTNAME, "");
    }

    public final void setPSDECHARTNAME(String strValue) {
        this.SetParamValue(TAG_PSDECHARTNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isAXESPOSNull() {
        return this.IsParamNull(TAG_AXESPOS);
    }

    public final String getAXESPOS() {
        return this.GetParamStringValue(TAG_AXESPOS, "");
    }

    public final void setAXESPOS(String strValue) {
        this.SetParamValue(TAG_AXESPOS, strValue);
    }

    public final boolean isAXESTYPENull() {
        return this.IsParamNull(TAG_AXESTYPE);
    }

    public final String getAXESTYPE() {
        return this.GetParamStringValue(TAG_AXESTYPE, "");
    }

    public final void setAXESTYPE(String strValue) {
        this.SetParamValue(TAG_AXESTYPE, strValue);
    }

    public final boolean isAXESMAXVALUENull() {
        return this.IsParamNull(TAG_AXESMAXVALUE);
    }

    public final String getAXESMAXVALUE() {
        return this.GetParamStringValue(TAG_AXESMAXVALUE, "");
    }

    public final void setAXESMAXVALUE(String strValue) {
        this.SetParamValue(TAG_AXESMAXVALUE, strValue);
    }

    public final boolean isAXESMINVALUENull() {
        return this.IsParamNull(TAG_AXESMINVALUE);
    }

    public final String getAXESMINVALUE() {
        return this.GetParamStringValue(TAG_AXESMINVALUE, "");
    }

    public final void setAXESMINVALUE(String strValue) {
        this.SetParamValue(TAG_AXESMINVALUE, strValue);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isFIELDSNull() {
        return this.IsParamNull(TAG_FIELDS);
    }

    public final String getFIELDS() {
        return this.GetParamStringValue(TAG_FIELDS, "");
    }

    public final void setFIELDS(String strValue) {
        this.SetParamValue(TAG_FIELDS, strValue);
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

    public final boolean isDATASHOWMODENull() {
        return this.IsParamNull(TAG_DATASHOWMODE);
    }

    public final int getDATASHOWMODE() {
        return this.GetParamIntValue(TAG_DATASHOWMODE, 0);
    }

    public final void setDATASHOWMODE(int nValue) {
        this.SetParamValue(TAG_DATASHOWMODE, nValue);
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

    public final boolean isUSERPARAMSNull() {
        return this.IsParamNull(TAG_USERPARAMS);
    }

    public final String getUSERPARAMS() {
        return this.GetParamStringValue(TAG_USERPARAMS, "");
    }

    public final void setUSERPARAMS(String strValue) {
        this.SetParamValue(TAG_USERPARAMS, strValue);
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

    public final boolean isCOORDINATESYSTEMIDNull() {
        return this.IsParamNull(TAG_COORDINATESYSTEMID);
    }

    public final int getCOORDINATESYSTEMID() {
        return this.GetParamIntValue(TAG_COORDINATESYSTEMID, 0);
    }

    public final void setCOORDINATESYSTEMID(int nValue) {
        this.SetParamValue(TAG_COORDINATESYSTEMID, nValue);
    }
}

