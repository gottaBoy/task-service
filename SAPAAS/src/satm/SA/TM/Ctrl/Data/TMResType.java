/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TMResType
extends BaseDataEntity {
    public static final String RESCATALOG_STANDARD = "STANDARD";
    public static final String RESCATALOG_COMPLEX = "COMPLEX";
    public static final String TAG_TMRESTYPEID = "TMRESTYPEID";
    public static final String TAG_TMRESTYPENAME = "TMRESTYPENAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESCATALOG = "RESCATALOG";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_HELPEROBJECT = "HELPEROBJECT";
    public static final String TAG_RESOBJECT = "RESOBJECT";
    public static final String TAG_TMTIMERULEID = "TMTIMERULEID";
    public static final String TAG_TMTIMERULENAME = "TMTIMERULENAME";

    public boolean isTMRESTYPEIDNull() {
        return this.IsParamNull(TAG_TMRESTYPEID);
    }

    public String getTMRESTYPEID() {
        return this.GetParamStringValue(TAG_TMRESTYPEID, "");
    }

    public void setTMRESTYPEID(String strValue) {
        this.SetParamValue(TAG_TMRESTYPEID, strValue);
    }

    public boolean isTMRESTYPENAMENull() {
        return this.IsParamNull(TAG_TMRESTYPENAME);
    }

    public String getTMRESTYPENAME() {
        return this.GetParamStringValue(TAG_TMRESTYPENAME, "");
    }

    public void setTMRESTYPENAME(String strValue) {
        this.SetParamValue(TAG_TMRESTYPENAME, strValue);
    }

    public boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public boolean isRESCATALOGNull() {
        return this.IsParamNull(TAG_RESCATALOG);
    }

    public String getRESCATALOG() {
        return this.GetParamStringValue(TAG_RESCATALOG, "");
    }

    public void setRESCATALOG(String strValue) {
        this.SetParamValue(TAG_RESCATALOG, strValue);
    }

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isHELPEROBJECTNull() {
        return this.IsParamNull(TAG_HELPEROBJECT);
    }

    public String getHELPEROBJECT() {
        return this.GetParamStringValue(TAG_HELPEROBJECT, "");
    }

    public void setHELPEROBJECT(String strValue) {
        this.SetParamValue(TAG_HELPEROBJECT, strValue);
    }

    public boolean isRESOBJECTNull() {
        return this.IsParamNull(TAG_RESOBJECT);
    }

    public String getRESOBJECT() {
        return this.GetParamStringValue(TAG_RESOBJECT, "");
    }

    public void setRESOBJECT(String strValue) {
        this.SetParamValue(TAG_RESOBJECT, strValue);
    }

    public boolean isTMTIMERULEIDNull() {
        return this.IsParamNull(TAG_TMTIMERULEID);
    }

    public String getTMTIMERULEID() {
        return this.GetParamStringValue(TAG_TMTIMERULEID, "");
    }

    public void setTMTIMERULEID(String strValue) {
        this.SetParamValue(TAG_TMTIMERULEID, strValue);
    }

    public boolean isTMTIMERULENAMENull() {
        return this.IsParamNull(TAG_TMTIMERULENAME);
    }

    public String getTMTIMERULENAME() {
        return this.GetParamStringValue(TAG_TMTIMERULENAME, "");
    }

    public void setTMTIMERULENAME(String strValue) {
        this.SetParamValue(TAG_TMTIMERULENAME, strValue);
    }
}

