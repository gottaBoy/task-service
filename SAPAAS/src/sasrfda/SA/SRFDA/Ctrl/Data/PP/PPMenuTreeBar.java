/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data.PP;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PPMenuTreeBar
extends BaseDataEntity {
    public static final String PARAMTYPE = "PP_MENUTREEBAR";
    public static final String TAG_PPMENUTREEBARID = "PPMENUTREEBARID";
    public static final String TAG_PPMENUTREEBARNAME = "PPMENUTREEBARNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_PAGETYPE = "PAGETYPE";
    public static final String TAG_PAGEID = "PAGEID";
    public static final String TAG_PAGENAME = "PAGENAME";
    public static final String TAG_PAGEPARAMTYPEID = "PAGEPARAMTYPEID";
    public static final String TAG_PAGEPARAMTYPENAME = "PAGEPARAMTYPENAME";
    public static final String TAG_TREENAME = "TREENAME";
    public static final String TAG_TITLEBARNAME = "TITLEBARNAME";
    public static final String TAG_SHOWTITLEBAR = "SHOWTITLEBAR";
    public static final String TAG_TREEUPDATEPATH = "TREEUPDATEPATH";
    public static final String TAG_ACTIVEFOLDER = "ACTIVEFOLDER";
    public static final String TAG_MENUID = "MENUID";
    public static final String TAG_MENUNAME = "MENUNAME";
    public static final String TAG_MENUMODE = "MENUMODE";

    public String getPPMENUTREEBARID() {
        return this.GetParamStringValue(TAG_PPMENUTREEBARID, "");
    }

    public void setPPMENUTREEBARID(String strValue) {
        this.SetParamValue(TAG_PPMENUTREEBARID, strValue);
    }

    public String getPPMENUTREEBARNAME() {
        return this.GetParamStringValue(TAG_PPMENUTREEBARNAME, "");
    }

    public void setPPMENUTREEBARNAME(String strValue) {
        this.SetParamValue(TAG_PPMENUTREEBARNAME, strValue);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public String getPAGETYPE() {
        return this.GetParamStringValue(TAG_PAGETYPE, "");
    }

    public void setPAGETYPE(String strValue) {
        this.SetParamValue(TAG_PAGETYPE, strValue);
    }

    public String getPAGEID() {
        return this.GetParamStringValue(TAG_PAGEID, "");
    }

    public void setPAGEID(String strValue) {
        this.SetParamValue(TAG_PAGEID, strValue);
    }

    public String getPAGENAME() {
        return this.GetParamStringValue(TAG_PAGENAME, "");
    }

    public void setPAGENAME(String strValue) {
        this.SetParamValue(TAG_PAGENAME, strValue);
    }

    public String getPAGEPARAMTYPEID() {
        return this.GetParamStringValue(TAG_PAGEPARAMTYPEID, "");
    }

    public void setPAGEPARAMTYPEID(String strValue) {
        this.SetParamValue(TAG_PAGEPARAMTYPEID, strValue);
    }

    public String getPAGEPARAMTYPENAME() {
        return this.GetParamStringValue(TAG_PAGEPARAMTYPENAME, "");
    }

    public void setPAGEPARAMTYPENAME(String strValue) {
        this.SetParamValue(TAG_PAGEPARAMTYPENAME, strValue);
    }

    public String getTREENAME() {
        return this.GetParamStringValue(TAG_TREENAME, "");
    }

    public void setTREENAME(String strValue) {
        this.SetParamValue(TAG_TREENAME, strValue);
    }

    public String getTITLEBARNAME() {
        return this.GetParamStringValue(TAG_TITLEBARNAME, "");
    }

    public void setTITLEBARNAME(String strValue) {
        this.SetParamValue(TAG_TITLEBARNAME, strValue);
    }

    public boolean getSHOWTITLEBAR() {
        return this.GetParamIntValue(TAG_SHOWTITLEBAR, 0) == 1;
    }

    public void setSHOWTITLEBAR(boolean bValue) {
        this.SetParamValue(TAG_SHOWTITLEBAR, bValue ? 1 : 0);
    }

    public String getTREEUPDATEPATH() {
        return this.GetParamStringValue(TAG_TREEUPDATEPATH, "");
    }

    public void setTREEUPDATEPATH(String strValue) {
        this.SetParamValue(TAG_TREEUPDATEPATH, strValue);
    }

    public String getACTIVEFOLDER() {
        return this.GetParamStringValue(TAG_ACTIVEFOLDER, "");
    }

    public void setACTIVEFOLDER(String strValue) {
        this.SetParamValue(TAG_ACTIVEFOLDER, strValue);
    }

    public String getMENUID() {
        return this.GetParamStringValue(TAG_MENUID, "");
    }

    public void setMENUID(String strValue) {
        this.SetParamValue(TAG_MENUID, strValue);
    }

    public String getMENUNAME() {
        return this.GetParamStringValue(TAG_MENUNAME, "");
    }

    public void setMENUNAME(String strValue) {
        this.SetParamValue(TAG_MENUNAME, strValue);
    }

    public String getMENUMODE() {
        return this.GetParamStringValue(TAG_MENUMODE, "");
    }

    public void setMENUMODE(String strValue) {
        this.SetParamValue(TAG_MENUMODE, strValue);
    }
}

