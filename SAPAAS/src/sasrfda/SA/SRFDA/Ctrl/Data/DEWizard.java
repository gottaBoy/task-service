/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DEWizard
extends BaseDataEntity {
    public static final String WIZARDMODE_WIZARDSESSION = "WIZARDSESSION";
    public static final int WZWIDTH_DEFAULT = 800;
    public static final int WZHEIGHT_DEFAULT = 600;
    public static final String TAG_DEWIZARDID = "DEWIZARDID";
    public static final String TAG_DEWIZARDNAME = "DEWIZARDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_WZDEID = "WZDEID";
    public static final String TAG_WZDENAME = "WZDENAME";
    public static final String TAG_INITDEACTIONID = "INITDEACTIONID";
    public static final String TAG_INITDEACTIONNAME = "INITDEACTIONNAME";
    public static final String TAG_FINISHDEACTIONID = "FINISHDEACTIONID";
    public static final String TAG_FINISHDEACTIONNAME = "FINISHDEACTIONNAME";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEDEFAULT = "CREATEDEFAULT";
    public static final String TAG_CREATEORDER = "CREATEORDER";
    public static final String TAG_CREATEWZ = "CREATEWZ";
    public static final String TAG_SHOWDATAAFTERWZ = "SHOWDATAAFTERWZ";
    public static final String TAG_WZWIDTH = "WZWIDTH";
    public static final String TAG_WZHEIGHT = "WZHEIGHT";
    public static final String TAG_ACTIONTARGET = "ACTIONTARGET";
    public static final String TAG_PAGEID = "PAGEID";
    public static final String TAG_PAGENAME = "PAGENAME";
    public static final String TAG_WIZARDMODE = "WIZARDMODE";
    public static final String TAG_APPENDURLPARAMS = "APPENDURLPARAMS";

    public int getWZWIDTH() {
        return this.GetParamIntValue(TAG_WZWIDTH, 800);
    }

    public int getWZHEIGHT() {
        return this.GetParamIntValue(TAG_WZHEIGHT, 600);
    }

    public boolean isDEWIZARDIDNull() {
        return this.IsParamNull(TAG_DEWIZARDID);
    }

    public String getDEWIZARDID() {
        return this.GetParamStringValue(TAG_DEWIZARDID, "");
    }

    public void setDEWIZARDID(String strValue) {
        this.SetParamValue(TAG_DEWIZARDID, strValue);
    }

    public boolean isDEWIZARDNAMENull() {
        return this.IsParamNull(TAG_DEWIZARDNAME);
    }

    public String getDEWIZARDNAME() {
        return this.GetParamStringValue(TAG_DEWIZARDNAME, "");
    }

    public void setDEWIZARDNAME(String strValue) {
        this.SetParamValue(TAG_DEWIZARDNAME, strValue);
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

    public boolean isDEIDNull() {
        return this.IsParamNull(TAG_DEID);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public boolean isDENAMENull() {
        return this.IsParamNull(TAG_DENAME);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public boolean isWZDEIDNull() {
        return this.IsParamNull(TAG_WZDEID);
    }

    public String getWZDEID() {
        return this.GetParamStringValue(TAG_WZDEID, "");
    }

    public void setWZDEID(String strValue) {
        this.SetParamValue(TAG_WZDEID, strValue);
    }

    public boolean isWZDENAMENull() {
        return this.IsParamNull(TAG_WZDENAME);
    }

    public String getWZDENAME() {
        return this.GetParamStringValue(TAG_WZDENAME, "");
    }

    public void setWZDENAME(String strValue) {
        this.SetParamValue(TAG_WZDENAME, strValue);
    }

    public boolean isINITDEACTIONIDNull() {
        return this.IsParamNull(TAG_INITDEACTIONID);
    }

    public String getINITDEACTIONID() {
        return this.GetParamStringValue(TAG_INITDEACTIONID, "");
    }

    public void setINITDEACTIONID(String strValue) {
        this.SetParamValue(TAG_INITDEACTIONID, strValue);
    }

    public boolean isINITDEACTIONNAMENull() {
        return this.IsParamNull(TAG_INITDEACTIONNAME);
    }

    public String getINITDEACTIONNAME() {
        return this.GetParamStringValue(TAG_INITDEACTIONNAME, "");
    }

    public void setINITDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_INITDEACTIONNAME, strValue);
    }

    public boolean isFINISHDEACTIONIDNull() {
        return this.IsParamNull(TAG_FINISHDEACTIONID);
    }

    public String getFINISHDEACTIONID() {
        return this.GetParamStringValue(TAG_FINISHDEACTIONID, "");
    }

    public void setFINISHDEACTIONID(String strValue) {
        this.SetParamValue(TAG_FINISHDEACTIONID, strValue);
    }

    public boolean isFINISHDEACTIONNAMENull() {
        return this.IsParamNull(TAG_FINISHDEACTIONNAME);
    }

    public String getFINISHDEACTIONNAME() {
        return this.GetParamStringValue(TAG_FINISHDEACTIONNAME, "");
    }

    public void setFINISHDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_FINISHDEACTIONNAME, strValue);
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

    public boolean isCREATEDEFAULTNull() {
        return this.IsParamNull(TAG_CREATEDEFAULT);
    }

    public boolean getCREATEDEFAULT() {
        return this.GetParamIntValue(TAG_CREATEDEFAULT, 0) == 1;
    }

    public void setCREATEDEFAULT(boolean bValue) {
        this.SetParamValue(TAG_CREATEDEFAULT, bValue ? 1 : 0);
    }

    public boolean isCREATEORDERNull() {
        return this.IsParamNull(TAG_CREATEORDER);
    }

    public int getCREATEORDER() {
        return this.GetParamIntValue(TAG_CREATEORDER, 0);
    }

    public void setCREATEORDER(int strValue) {
        this.SetParamValue(TAG_CREATEORDER, strValue);
    }

    public boolean isCREATEWZNull() {
        return this.IsParamNull(TAG_CREATEWZ);
    }

    public boolean getCREATEWZ() {
        return this.GetParamIntValue(TAG_CREATEWZ, 0) == 1;
    }

    public void setCREATEWZ(boolean bValue) {
        this.SetParamValue(TAG_CREATEWZ, bValue ? 1 : 0);
    }

    public boolean isSHOWDATAAFTERWZNull() {
        return this.IsParamNull(TAG_SHOWDATAAFTERWZ);
    }

    public boolean getSHOWDATAAFTERWZ() {
        return this.GetParamIntValue(TAG_SHOWDATAAFTERWZ, 0) == 1;
    }

    public void setSHOWDATAAFTERWZ(boolean bValue) {
        this.SetParamValue(TAG_SHOWDATAAFTERWZ, bValue ? 1 : 0);
    }

    public boolean isWZWIDTHNull() {
        return this.IsParamNull(TAG_WZWIDTH);
    }

    public void setWZWIDTH(int strValue) {
        this.SetParamValue(TAG_WZWIDTH, strValue);
    }

    public boolean isWZHEIGHTNull() {
        return this.IsParamNull(TAG_WZHEIGHT);
    }

    public void setWZHEIGHT(int strValue) {
        this.SetParamValue(TAG_WZHEIGHT, strValue);
    }

    public boolean isACTIONTARGETNull() {
        return this.IsParamNull(TAG_ACTIONTARGET);
    }

    public String getACTIONTARGET() {
        return this.GetParamStringValue(TAG_ACTIONTARGET, "");
    }

    public void setACTIONTARGET(String strValue) {
        this.SetParamValue(TAG_ACTIONTARGET, strValue);
    }

    public boolean isPAGEIDNull() {
        return this.IsParamNull(TAG_PAGEID);
    }

    public String getPAGEID() {
        return this.GetParamStringValue(TAG_PAGEID, "");
    }

    public void setPAGEID(String strValue) {
        this.SetParamValue(TAG_PAGEID, strValue);
    }

    public boolean isPAGENAMENull() {
        return this.IsParamNull(TAG_PAGENAME);
    }

    public String getPAGENAME() {
        return this.GetParamStringValue(TAG_PAGENAME, "");
    }

    public void setPAGENAME(String strValue) {
        this.SetParamValue(TAG_PAGENAME, strValue);
    }

    public final boolean isWIZARDMODENull() {
        return this.IsParamNull(TAG_WIZARDMODE);
    }

    public final String getWIZARDMODE() {
        return this.GetParamStringValue(TAG_WIZARDMODE, "");
    }

    public final void setWIZARDMODE(String strValue) {
        this.SetParamValue(TAG_WIZARDMODE, strValue);
    }

    public final boolean isAPPENDURLPARAMSNull() {
        return this.IsParamNull(TAG_APPENDURLPARAMS);
    }

    public final String getAPPENDURLPARAMS() {
        return this.GetParamStringValue(TAG_APPENDURLPARAMS, "");
    }

    public final void setAPPENDURLPARAMS(String strValue) {
        this.SetParamValue(TAG_APPENDURLPARAMS, strValue);
    }
}

