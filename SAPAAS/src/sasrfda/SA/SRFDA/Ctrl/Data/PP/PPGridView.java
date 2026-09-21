/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data.PP;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PPGridView
extends BaseDataEntity {
    public static final String PARAMTYPE = "PPGRIDVIEW";
    public static final String TAG_PPGRIDVIEWID = "PPGRIDVIEWID";
    public static final String TAG_PPGRIDVIEWNAME = "PPGRIDVIEWNAME";
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
    public static final String TAG_CTRLID = "CTRLID";
    public static final String TAG_PPTYPEDESC = "PPTYPEDESC";
    public static final String TAG_DGMODE = "DGMODE";
    public static final String TAG_ENABLEROWEDIT = "ENABLEROWEDIT";
    public static final String TAG_CUSTOMTHEME = "CUSTOMTHEME";
    public static final String TAG_RENDERSP = "RENDERSP";
    public static final String TAG_CUSTOMSUMMARYAREA = "CUSTOMSUMMARYAREA";
    public static final String TAG_SUMMARYAREA = "SUMMARYAREA";
    public static final String TAG_INFOMODE = "INFOMODE";
    public static final String TAG_DGTHEME = "DGTHEME";
    public static final String TAG_DERGROUPID = "DERGROUPID";
    public static final String TAG_DERGROUPNAME = "DERGROUPNAME";
    public static final String TAG_ACTIVEDERGROUPITEM = "ACTIVEDERGROUPITEM";
    public static final String TAG_SUMMARYPAGEID = "SUMMARYPAGEID";
    public static final String TAG_SUMMARYPAGENAME = "SUMMARYPAGENAME";
    public static final String TAG_SUMMARYHEIGHT = "SUMMARYHEIGHT";
    public static final String TAG_SUMMARYWIDTH = "SUMMARYWIDTH";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CAPTIONWIDTH = "CAPTIONWIDTH";
    public static final String TAG_SUMMARYLIST = "SUMMARYLIST";
    public static final String TAG_SPAUTOEXPAND = "SPAUTOEXPAND";
    public static final String TAG_REFRESHPTREE = "REFRESHPTREE";

    public String getPPGRIDVIEWID() {
        return this.GetParamStringValue(TAG_PPGRIDVIEWID, "");
    }

    public void setPPGRIDVIEWID(String strValue) {
        this.SetParamValue(TAG_PPGRIDVIEWID, strValue);
    }

    public String getPPGRIDVIEWNAME() {
        return this.GetParamStringValue(TAG_PPGRIDVIEWNAME, "");
    }

    public void setPPGRIDVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PPGRIDVIEWNAME, strValue);
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

    public String getCTRLID() {
        return this.GetParamStringValue(TAG_CTRLID, "");
    }

    public void setCTRLID(String strValue) {
        this.SetParamValue(TAG_CTRLID, strValue);
    }

    public String getPPTYPEDESC() {
        return this.GetParamStringValue(TAG_PPTYPEDESC, "");
    }

    public void setPPTYPEDESC(String strValue) {
        this.SetParamValue(TAG_PPTYPEDESC, strValue);
    }

    public String getDGMODE() {
        return this.GetParamStringValue(TAG_DGMODE, "");
    }

    public void setDGMODE(String strValue) {
        this.SetParamValue(TAG_DGMODE, strValue);
    }

    public boolean getENABLEROWEDIT() {
        return this.GetParamIntValue(TAG_ENABLEROWEDIT, 0) == 1;
    }

    public void setENABLEROWEDIT(boolean bValue) {
        this.SetParamValue(TAG_ENABLEROWEDIT, bValue ? 1 : 0);
    }

    public boolean getCUSTOMTHEME() {
        return this.GetParamIntValue(TAG_CUSTOMTHEME, 0) == 1;
    }

    public void setCUSTOMTHEME(boolean bValue) {
        this.SetParamValue(TAG_CUSTOMTHEME, bValue ? 1 : 0);
    }

    public boolean getRENDERSP() {
        return this.GetParamIntValue(TAG_RENDERSP, 0) == 1;
    }

    public void setRENDERSP(boolean bValue) {
        this.SetParamValue(TAG_RENDERSP, bValue ? 1 : 0);
    }

    public boolean getCUSTOMSUMMARYAREA() {
        return this.GetParamIntValue(TAG_CUSTOMSUMMARYAREA, 0) == 1;
    }

    public void setCUSTOMSUMMARYAREA(boolean bValue) {
        this.SetParamValue(TAG_CUSTOMSUMMARYAREA, bValue ? 1 : 0);
    }

    public String getSUMMARYAREA() {
        return this.GetParamStringValue(TAG_SUMMARYAREA, "");
    }

    public void setSUMMARYAREA(String strValue) {
        this.SetParamValue(TAG_SUMMARYAREA, strValue);
    }

    public boolean getINFOMODE() {
        return this.GetParamIntValue(TAG_INFOMODE, 0) == 1;
    }

    public void setINFOMODE(boolean bValue) {
        this.SetParamValue(TAG_INFOMODE, bValue ? 1 : 0);
    }

    public boolean getDGTHEME() {
        return this.GetParamIntValue(TAG_DGTHEME, 0) == 1;
    }

    public void setDGTHEME(boolean bValue) {
        this.SetParamValue(TAG_DGTHEME, bValue ? 1 : 0);
    }

    public String getDERGROUPID() {
        return this.GetParamStringValue(TAG_DERGROUPID, "");
    }

    public void setDERGROUPID(String strValue) {
        this.SetParamValue(TAG_DERGROUPID, strValue);
    }

    public String getDERGROUPNAME() {
        return this.GetParamStringValue(TAG_DERGROUPNAME, "");
    }

    public void setDERGROUPNAME(String strValue) {
        this.SetParamValue(TAG_DERGROUPNAME, strValue);
    }

    public int getACTIVEDERGROUPITEM() {
        return this.GetParamIntValue(TAG_ACTIVEDERGROUPITEM, 0);
    }

    public void setACTIVEDERGROUPITEM(int strValue) {
        this.SetParamValue(TAG_ACTIVEDERGROUPITEM, strValue);
    }

    public String getSUMMARYPAGEID() {
        return this.GetParamStringValue(TAG_SUMMARYPAGEID, "");
    }

    public void setSUMMARYPAGEID(String strValue) {
        this.SetParamValue(TAG_SUMMARYPAGEID, strValue);
    }

    public String getSUMMARYPAGENAME() {
        return this.GetParamStringValue(TAG_SUMMARYPAGENAME, "");
    }

    public void setSUMMARYPAGENAME(String strValue) {
        this.SetParamValue(TAG_SUMMARYPAGENAME, strValue);
    }

    public int getSUMMARYHEIGHT() {
        return this.GetParamIntValue(TAG_SUMMARYHEIGHT, 0);
    }

    public void setSUMMARYHEIGHT(int strValue) {
        this.SetParamValue(TAG_SUMMARYHEIGHT, strValue);
    }

    public int getSUMMARYWIDTH() {
        return this.GetParamIntValue(TAG_SUMMARYWIDTH, 0);
    }

    public void setSUMMARYWIDTH(int strValue) {
        this.SetParamValue(TAG_SUMMARYWIDTH, strValue);
    }

    public String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
    }

    public int getCAPTIONWIDTH() {
        return this.GetParamIntValue(TAG_CAPTIONWIDTH, 0);
    }

    public void setCAPTIONWIDTH(int strValue) {
        this.SetParamValue(TAG_CAPTIONWIDTH, strValue);
    }

    public boolean getSUMMARYLIST() {
        return this.GetParamIntValue(TAG_SUMMARYLIST, 0) == 1;
    }

    public void setSUMMARYLIST(boolean bValue) {
        this.SetParamValue(TAG_SUMMARYLIST, bValue ? 1 : 0);
    }

    public boolean getSPAUTOEXPAND() {
        return this.GetParamIntValue(TAG_SPAUTOEXPAND, 0) == 1;
    }

    public void setSPAUTOEXPAND(boolean bValue) {
        this.SetParamValue(TAG_SPAUTOEXPAND, bValue ? 1 : 0);
    }

    public void setREFRESHPTREE(boolean bValue) {
        this.SetParamValue(TAG_REFRESHPTREE, bValue ? 1 : 0);
    }

    public boolean getREFRESHPTREE() {
        return this.GetParamIntValue(TAG_REFRESHPTREE, 0) == 1;
    }
}

