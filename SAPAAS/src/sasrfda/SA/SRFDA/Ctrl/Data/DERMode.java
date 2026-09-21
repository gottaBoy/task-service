/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DERMode
extends BaseDataEntity {
    public static final String TAG_DERMODEID = "DERMODEID";
    public static final String TAG_DERMODENAME = "DERMODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_HELPEROBJECT = "HELPEROBJECT";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_HELPERPARAM = "HELPERPARAM";
    public static final String TAG_TVPPUBLISHER = "TVPPUBLISHER";
    public static final String TAG_TVPPUBLISHERPARAM = "TVPPUBLISHERPARAM";

    public boolean isDERMODEIDNull() {
        return this.IsParamNull(TAG_DERMODEID);
    }

    public String getDERMODEID() {
        return this.GetParamStringValue(TAG_DERMODEID, "");
    }

    public void setDERMODEID(String strValue) {
        this.SetParamValue(TAG_DERMODEID, strValue);
    }

    public boolean isDERMODENAMENull() {
        return this.IsParamNull(TAG_DERMODENAME);
    }

    public String getDERMODENAME() {
        return this.GetParamStringValue(TAG_DERMODENAME, "");
    }

    public void setDERMODENAME(String strValue) {
        this.SetParamValue(TAG_DERMODENAME, strValue);
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

    public void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
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

    public void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int nValue) {
        this.SetParamValue(TAG_VERSION, nValue);
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

    public boolean isORDERFLAGNull() {
        return this.IsParamNull(TAG_ORDERFLAG);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int nValue) {
        this.SetParamValue(TAG_ORDERFLAG, nValue);
    }

    public boolean isHELPERPARAMNull() {
        return this.IsParamNull(TAG_HELPERPARAM);
    }

    public String getHELPERPARAM() {
        return this.GetParamStringValue(TAG_HELPERPARAM, "");
    }

    public void setHELPERPARAM(String strValue) {
        this.SetParamValue(TAG_HELPERPARAM, strValue);
    }

    public boolean isTVPPUBLISHERNull() {
        return this.IsParamNull(TAG_TVPPUBLISHER);
    }

    public String getTVPPUBLISHER() {
        return this.GetParamStringValue(TAG_TVPPUBLISHER, "");
    }

    public void setTVPPUBLISHER(String strValue) {
        this.SetParamValue(TAG_TVPPUBLISHER, strValue);
    }

    public boolean isTVPPUBLISHERPARAMNull() {
        return this.IsParamNull(TAG_TVPPUBLISHERPARAM);
    }

    public String getTVPPUBLISHERPARAM() {
        return this.GetParamStringValue(TAG_TVPPUBLISHERPARAM, "");
    }

    public void setTVPPUBLISHERPARAM(String strValue) {
        this.SetParamValue(TAG_TVPPUBLISHERPARAM, strValue);
    }
}

