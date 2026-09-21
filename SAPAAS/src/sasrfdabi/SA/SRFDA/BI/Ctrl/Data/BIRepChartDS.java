/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIRepChartDS
extends BaseDataEntity {
    public static final String TAG_BIREPCHARTDSID = "BIREPCHARTDSID";
    public static final String TAG_BIREPCHARTDSNAME = "BIREPCHARTDSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BIREPCHARTNAME = "BIREPCHARTNAME";
    public static final String TAG_BICUBEID = "BICUBEID";
    public static final String TAG_CATALOGDMNAME = "CATALOGDMNAME";
    public static final String TAG_BIREPCHARTID = "BIREPCHARTID";
    public static final String TAG_CATALOGDMID = "CATALOGDMID";
    public static final String TAG_AXISXDMID = "AXISXDMID";
    public static final String TAG_AXISXDMNAME = "AXISXDMNAME";
    public static final String TAG_VALUEMSID = "VALUEMSID";
    public static final String TAG_VALUEMSNAME = "VALUEMSNAME";
    public static final String TAG_VALUE2MSID = "VALUE2MSID";
    public static final String TAG_VALUE2MSNAME = "VALUE2MSNAME";
    public static final String TAG_VALUE3MSID = "VALUE3MSID";
    public static final String TAG_VALUE3MSNAME = "VALUE3MSNAME";
    public static final String TAG_VALUE4MSID = "VALUE4MSID";
    public static final String TAG_VALUE4MSNAME = "VALUE4MSNAME";
    public static final String TAG_VALUEDMTEXT = "VALUEDMTEXT";
    public static final String TAG_VALUE2DMTEXT = "VALUE2DMTEXT";
    public static final String TAG_VALUE3DMTEXT = "VALUE3DMTEXT";
    public static final String TAG_VALUE4DMTEXT = "VALUE4DMTEXT";
    public static final String TAG_VALUECAPTION = "VALUECAPTION";
    public static final String TAG_VALUE2CAPTION = "VALUE2CAPTION";
    public static final String TAG_VALUE3CAPTION = "VALUE3CAPTION";
    public static final String TAG_VALUE4CAPTION = "VALUE4CAPTION";
    public static final String TAG_CHARTTYPE = "CHARTTYPE";

    public boolean isBIREPCHARTDSIDNull() {
        return this.IsParamNull(TAG_BIREPCHARTDSID);
    }

    public String getBIREPCHARTDSID() {
        return this.GetParamStringValue(TAG_BIREPCHARTDSID, "");
    }

    public void setBIREPCHARTDSID(String strValue) {
        this.SetParamValue(TAG_BIREPCHARTDSID, strValue);
    }

    public boolean isBIREPCHARTDSNAMENull() {
        return this.IsParamNull(TAG_BIREPCHARTDSNAME);
    }

    public String getBIREPCHARTDSNAME() {
        return this.GetParamStringValue(TAG_BIREPCHARTDSNAME, "");
    }

    public void setBIREPCHARTDSNAME(String strValue) {
        this.SetParamValue(TAG_BIREPCHARTDSNAME, strValue);
    }

    public boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public boolean isBIREPCHARTNAMENull() {
        return this.IsParamNull(TAG_BIREPCHARTNAME);
    }

    public String getBIREPCHARTNAME() {
        return this.GetParamStringValue(TAG_BIREPCHARTNAME, "");
    }

    public void setBIREPCHARTNAME(String strValue) {
        this.SetParamValue(TAG_BIREPCHARTNAME, strValue);
    }

    public boolean isBICUBEIDNull() {
        return this.IsParamNull(TAG_BICUBEID);
    }

    public String getBICUBEID() {
        return this.GetParamStringValue(TAG_BICUBEID, "");
    }

    public void setBICUBEID(String strValue) {
        this.SetParamValue(TAG_BICUBEID, strValue);
    }

    public boolean isCATALOGDMNAMENull() {
        return this.IsParamNull(TAG_CATALOGDMNAME);
    }

    public String getCATALOGDMNAME() {
        return this.GetParamStringValue(TAG_CATALOGDMNAME, "");
    }

    public void setCATALOGDMNAME(String strValue) {
        this.SetParamValue(TAG_CATALOGDMNAME, strValue);
    }

    public boolean isBIREPCHARTIDNull() {
        return this.IsParamNull(TAG_BIREPCHARTID);
    }

    public String getBIREPCHARTID() {
        return this.GetParamStringValue(TAG_BIREPCHARTID, "");
    }

    public void setBIREPCHARTID(String strValue) {
        this.SetParamValue(TAG_BIREPCHARTID, strValue);
    }

    public boolean isCATALOGDMIDNull() {
        return this.IsParamNull(TAG_CATALOGDMID);
    }

    public String getCATALOGDMID() {
        return this.GetParamStringValue(TAG_CATALOGDMID, "");
    }

    public void setCATALOGDMID(String strValue) {
        this.SetParamValue(TAG_CATALOGDMID, strValue);
    }

    public boolean isAXISXDMIDNull() {
        return this.IsParamNull(TAG_AXISXDMID);
    }

    public String getAXISXDMID() {
        return this.GetParamStringValue(TAG_AXISXDMID, "");
    }

    public void setAXISXDMID(String strValue) {
        this.SetParamValue(TAG_AXISXDMID, strValue);
    }

    public boolean isAXISXDMNAMENull() {
        return this.IsParamNull(TAG_AXISXDMNAME);
    }

    public String getAXISXDMNAME() {
        return this.GetParamStringValue(TAG_AXISXDMNAME, "");
    }

    public void setAXISXDMNAME(String strValue) {
        this.SetParamValue(TAG_AXISXDMNAME, strValue);
    }

    public boolean isVALUEMSIDNull() {
        return this.IsParamNull(TAG_VALUEMSID);
    }

    public String getVALUEMSID() {
        return this.GetParamStringValue(TAG_VALUEMSID, "");
    }

    public void setVALUEMSID(String strValue) {
        this.SetParamValue(TAG_VALUEMSID, strValue);
    }

    public boolean isVALUEMSNAMENull() {
        return this.IsParamNull(TAG_VALUEMSNAME);
    }

    public String getVALUEMSNAME() {
        return this.GetParamStringValue(TAG_VALUEMSNAME, "");
    }

    public void setVALUEMSNAME(String strValue) {
        this.SetParamValue(TAG_VALUEMSNAME, strValue);
    }

    public boolean isVALUE2MSIDNull() {
        return this.IsParamNull(TAG_VALUE2MSID);
    }

    public String getVALUE2MSID() {
        return this.GetParamStringValue(TAG_VALUE2MSID, "");
    }

    public void setVALUE2MSID(String strValue) {
        this.SetParamValue(TAG_VALUE2MSID, strValue);
    }

    public boolean isVALUE2MSNAMENull() {
        return this.IsParamNull(TAG_VALUE2MSNAME);
    }

    public String getVALUE2MSNAME() {
        return this.GetParamStringValue(TAG_VALUE2MSNAME, "");
    }

    public void setVALUE2MSNAME(String strValue) {
        this.SetParamValue(TAG_VALUE2MSNAME, strValue);
    }

    public boolean isVALUE3MSIDNull() {
        return this.IsParamNull(TAG_VALUE3MSID);
    }

    public String getVALUE3MSID() {
        return this.GetParamStringValue(TAG_VALUE3MSID, "");
    }

    public void setVALUE3MSID(String strValue) {
        this.SetParamValue(TAG_VALUE3MSID, strValue);
    }

    public boolean isVALUE3MSNAMENull() {
        return this.IsParamNull(TAG_VALUE3MSNAME);
    }

    public String getVALUE3MSNAME() {
        return this.GetParamStringValue(TAG_VALUE3MSNAME, "");
    }

    public void setVALUE3MSNAME(String strValue) {
        this.SetParamValue(TAG_VALUE3MSNAME, strValue);
    }

    public boolean isVALUE4MSIDNull() {
        return this.IsParamNull(TAG_VALUE4MSID);
    }

    public String getVALUE4MSID() {
        return this.GetParamStringValue(TAG_VALUE4MSID, "");
    }

    public void setVALUE4MSID(String strValue) {
        this.SetParamValue(TAG_VALUE4MSID, strValue);
    }

    public boolean isVALUE4MSNAMENull() {
        return this.IsParamNull(TAG_VALUE4MSNAME);
    }

    public String getVALUE4MSNAME() {
        return this.GetParamStringValue(TAG_VALUE4MSNAME, "");
    }

    public void setVALUE4MSNAME(String strValue) {
        this.SetParamValue(TAG_VALUE4MSNAME, strValue);
    }

    public boolean isVALUEDMTEXTNull() {
        return this.IsParamNull(TAG_VALUEDMTEXT);
    }

    public String getVALUEDMTEXT() {
        return this.GetParamStringValue(TAG_VALUEDMTEXT, "");
    }

    public void setVALUEDMTEXT(String strValue) {
        this.SetParamValue(TAG_VALUEDMTEXT, strValue);
    }

    public boolean isVALUE2DMTEXTNull() {
        return this.IsParamNull(TAG_VALUE2DMTEXT);
    }

    public String getVALUE2DMTEXT() {
        return this.GetParamStringValue(TAG_VALUE2DMTEXT, "");
    }

    public void setVALUE2DMTEXT(String strValue) {
        this.SetParamValue(TAG_VALUE2DMTEXT, strValue);
    }

    public boolean isVALUE3DMTEXTNull() {
        return this.IsParamNull(TAG_VALUE3DMTEXT);
    }

    public String getVALUE3DMTEXT() {
        return this.GetParamStringValue(TAG_VALUE3DMTEXT, "");
    }

    public void setVALUE3DMTEXT(String strValue) {
        this.SetParamValue(TAG_VALUE3DMTEXT, strValue);
    }

    public boolean isVALUE4DMTEXTNull() {
        return this.IsParamNull(TAG_VALUE4DMTEXT);
    }

    public String getVALUE4DMTEXT() {
        return this.GetParamStringValue(TAG_VALUE4DMTEXT, "");
    }

    public void setVALUE4DMTEXT(String strValue) {
        this.SetParamValue(TAG_VALUE4DMTEXT, strValue);
    }

    public boolean isVALUECAPTIONNull() {
        return this.IsParamNull(TAG_VALUECAPTION);
    }

    public String getVALUECAPTION() {
        return this.GetParamStringValue(TAG_VALUECAPTION, "");
    }

    public void setVALUECAPTION(String strValue) {
        this.SetParamValue(TAG_VALUECAPTION, strValue);
    }

    public boolean isVALUE2CAPTIONNull() {
        return this.IsParamNull(TAG_VALUE2CAPTION);
    }

    public String getVALUE2CAPTION() {
        return this.GetParamStringValue(TAG_VALUE2CAPTION, "");
    }

    public void setVALUE2CAPTION(String strValue) {
        this.SetParamValue(TAG_VALUE2CAPTION, strValue);
    }

    public boolean isVALUE3CAPTIONNull() {
        return this.IsParamNull(TAG_VALUE3CAPTION);
    }

    public String getVALUE3CAPTION() {
        return this.GetParamStringValue(TAG_VALUE3CAPTION, "");
    }

    public void setVALUE3CAPTION(String strValue) {
        this.SetParamValue(TAG_VALUE3CAPTION, strValue);
    }

    public boolean isVALUE4CAPTIONNull() {
        return this.IsParamNull(TAG_VALUE4CAPTION);
    }

    public String getVALUE4CAPTION() {
        return this.GetParamStringValue(TAG_VALUE4CAPTION, "");
    }

    public void setVALUE4CAPTION(String strValue) {
        this.SetParamValue(TAG_VALUE4CAPTION, strValue);
    }

    public boolean isCHARTTYPENull() {
        return this.IsParamNull(TAG_CHARTTYPE);
    }

    public String getCHARTTYPE() {
        return this.GetParamStringValue(TAG_CHARTTYPE, "");
    }

    public void setCHARTTYPE(String strValue) {
        this.SetParamValue(TAG_CHARTTYPE, strValue);
    }
}

