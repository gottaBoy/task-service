/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Ctrl.ToolbarWriter.ToolbarConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.Date;

public class Toolbar
extends BaseDataEntity {
    public static final String TAG_TOOLBARID = "TOOLBARID";
    public static final String TAG_TOOLBARNAME = "TOOLBARNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_NODEFAULT = "NODEFAULT";
    public static final String TAG_NEWACTION = "NEWACTION";
    public static final String TAG_SAVEACTION = "SAVEACTION";
    public static final String TAG_SAVEANDEXITACTION = "SAVEANDEXITACTION";
    public static final String TAG_REMOVEANDEXITACTION = "REMOVEANDEXITACTION";
    public static final String TAG_SAVEANDSTARTWFACTION = "SAVEANDSTARTWFACTION";
    public static final String TAG_COPYACTION = "COPYACTION";
    public static final String TAG_OTHERACTION = "OTHERACTION";
    public static final String TAG_PRINTACTION = "PRINTACTION";
    public static final String TAG_SAVEANDNEWACTION = "SAVEANDNEWACTION";
    public static final String TAG_HELPACTION = "HELPACTION";
    public static final String TAG_NEWROWACTION = "NEWROWACTION";
    public static final String TAG_EDITROWACTION = "EDITROWACTION";
    public static final String TAG_EDITACTION = "EDITACTION";
    public static final String TAG_VIEWACTION = "VIEWACTION";
    public static final String TAG_REMOVEACTION = "REMOVEACTION";
    public static final String TAG_EXPORTACTION = "EXPORTACTION";
    public static final String TAG_SEARCHBARACTION = "SEARCHBARACTION";
    public static final String TAG_DATANAVBAR = "DATANAVBAR";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_TBMODEL = "TBMODEL";
    public static final String TAG_TBTEMPLID = "TBTEMPLID";
    public static final String TAG_TBTEMPLNAME = "TBTEMPLNAME";
    public static final String TAG_CANCELWFACTION = "CANCELWFACTION";
    public static final String TAG_RESTARTWFACTION = "RESTARTWFACTION";
    public static final String TAG_DEBHGROUPID = "DEBHGROUPID";
    public static final String TAG_DEBHGROUPNAME = "DEBHGROUPNAME";
    public static final String TAG_DEBHGROUP2ID = "DEBHGROUP2ID";
    public static final String TAG_DEBHGROUP2NAME = "DEBHGROUP2NAME";
    public static final String TAG_DEBHGROUP3ID = "DEBHGROUP3ID";
    public static final String TAG_DEBHGROUP3NAME = "DEBHGROUP3NAME";
    public static final String TAG_DEBHGROUP4ID = "DEBHGROUP4ID";
    public static final String TAG_DEBHGROUP4NAME = "DEBHGROUP4NAME";
    public static final String TAG_DEBHGROUP5ID = "DEBHGROUP5ID";
    public static final String TAG_DEBHGROUP5NAME = "DEBHGROUP5NAME";
    public static final String TAG_DEBHGROUP6ID = "DEBHGROUP6ID";
    public static final String TAG_DEBHGROUP6NAME = "DEBHGROUP6NAME";
    public static final String TAG_VIEWWFSTEPACTOR = "VIEWWFSTEPACTOR";
    public static final String TAG_EXPORTXMLACTION = "EXPORTXMLACTION";
    public static final String TAG_IMPORTDATAACTION = "IMPORTDATAACTION";
    public static final String TAG_INFOMODE = "INFOMODE";
    public static final String TAG_NODEFDEBHGROUP = "NODEFDEBHGROUP";
    protected ToolbarConfig toolbarConfig = null;

    public boolean isTOOLBARIDNull() {
        return this.IsParamNull(TAG_TOOLBARID);
    }

    public String getTOOLBARID() {
        return this.GetParamStringValue(TAG_TOOLBARID, "");
    }

    public void setTOOLBARID(String strValue) {
        this.SetParamValue(TAG_TOOLBARID, strValue);
    }

    public boolean isTOOLBARNAMENull() {
        return this.IsParamNull(TAG_TOOLBARNAME);
    }

    public String getTOOLBARNAME() {
        return this.GetParamStringValue(TAG_TOOLBARNAME, "");
    }

    public void setTOOLBARNAME(String strValue) {
        this.SetParamValue(TAG_TOOLBARNAME, strValue);
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

    public boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public boolean isNODEFAULTNull() {
        return this.IsParamNull(TAG_NODEFAULT);
    }

    public boolean getNODEFAULT() {
        return this.GetParamIntValue(TAG_NODEFAULT, 0) == 1;
    }

    public void setNODEFAULT(boolean bValue) {
        this.SetParamValue(TAG_NODEFAULT, bValue ? 1 : 0);
    }

    public boolean isNEWACTIONNull() {
        return this.IsParamNull(TAG_NEWACTION);
    }

    public boolean getNEWACTION() {
        return this.GetParamIntValue(TAG_NEWACTION, 0) == 1;
    }

    public void setNEWACTION(boolean bValue) {
        this.SetParamValue(TAG_NEWACTION, bValue ? 1 : 0);
    }

    public boolean isSAVEACTIONNull() {
        return this.IsParamNull(TAG_SAVEACTION);
    }

    public boolean getSAVEACTION() {
        return this.GetParamIntValue(TAG_SAVEACTION, 0) == 1;
    }

    public void setSAVEACTION(boolean bValue) {
        this.SetParamValue(TAG_SAVEACTION, bValue ? 1 : 0);
    }

    public boolean isSAVEANDEXITACTIONNull() {
        return this.IsParamNull(TAG_SAVEANDEXITACTION);
    }

    public boolean getSAVEANDEXITACTION() {
        return this.GetParamIntValue(TAG_SAVEANDEXITACTION, 0) == 1;
    }

    public void setSAVEANDEXITACTION(boolean bValue) {
        this.SetParamValue(TAG_SAVEANDEXITACTION, bValue ? 1 : 0);
    }

    public boolean isREMOVEANDEXITACTIONNull() {
        return this.IsParamNull(TAG_REMOVEANDEXITACTION);
    }

    public boolean getREMOVEANDEXITACTION() {
        return this.GetParamIntValue(TAG_REMOVEANDEXITACTION, 0) == 1;
    }

    public void setREMOVEANDEXITACTION(boolean bValue) {
        this.SetParamValue(TAG_REMOVEANDEXITACTION, bValue ? 1 : 0);
    }

    public boolean isSAVEANDSTARTWFACTIONNull() {
        return this.IsParamNull(TAG_SAVEANDSTARTWFACTION);
    }

    public boolean getSAVEANDSTARTWFACTION() {
        return this.GetParamIntValue(TAG_SAVEANDSTARTWFACTION, 0) == 1;
    }

    public void setSAVEANDSTARTWFACTION(boolean bValue) {
        this.SetParamValue(TAG_SAVEANDSTARTWFACTION, bValue ? 1 : 0);
    }

    public boolean isCOPYACTIONNull() {
        return this.IsParamNull(TAG_COPYACTION);
    }

    public boolean getCOPYACTION() {
        return this.GetParamIntValue(TAG_COPYACTION, 0) == 1;
    }

    public void setCOPYACTION(boolean bValue) {
        this.SetParamValue(TAG_COPYACTION, bValue ? 1 : 0);
    }

    public boolean isOTHERACTIONNull() {
        return this.IsParamNull(TAG_OTHERACTION);
    }

    public boolean getOTHERACTION() {
        return this.GetParamIntValue(TAG_OTHERACTION, 0) == 1;
    }

    public void setOTHERACTION(boolean bValue) {
        this.SetParamValue(TAG_OTHERACTION, bValue ? 1 : 0);
    }

    public boolean isPRINTACTIONNull() {
        return this.IsParamNull(TAG_PRINTACTION);
    }

    public boolean getPRINTACTION() {
        return this.GetParamIntValue(TAG_PRINTACTION, 0) == 1;
    }

    public void setPRINTACTION(boolean bValue) {
        this.SetParamValue(TAG_PRINTACTION, bValue ? 1 : 0);
    }

    public boolean isSAVEANDNEWACTIONNull() {
        return this.IsParamNull(TAG_SAVEANDNEWACTION);
    }

    public boolean getSAVEANDNEWACTION() {
        return this.GetParamIntValue(TAG_SAVEANDNEWACTION, 0) == 1;
    }

    public void setSAVEANDNEWACTION(boolean bValue) {
        this.SetParamValue(TAG_SAVEANDNEWACTION, bValue ? 1 : 0);
    }

    public boolean isHELPACTIONNull() {
        return this.IsParamNull(TAG_HELPACTION);
    }

    public boolean getHELPACTION() {
        return this.GetParamIntValue(TAG_HELPACTION, 0) == 1;
    }

    public void setHELPACTION(boolean bValue) {
        this.SetParamValue(TAG_HELPACTION, bValue ? 1 : 0);
    }

    public boolean isNEWROWACTIONNull() {
        return this.IsParamNull(TAG_NEWROWACTION);
    }

    public boolean getNEWROWACTION() {
        return this.GetParamIntValue(TAG_NEWROWACTION, 0) == 1;
    }

    public void setNEWROWACTION(boolean bValue) {
        this.SetParamValue(TAG_NEWROWACTION, bValue ? 1 : 0);
    }

    public boolean isEDITROWACTIONNull() {
        return this.IsParamNull(TAG_EDITROWACTION);
    }

    public boolean getEDITROWACTION() {
        return this.GetParamIntValue(TAG_EDITROWACTION, 0) == 1;
    }

    public void setEDITROWACTION(boolean bValue) {
        this.SetParamValue(TAG_EDITROWACTION, bValue ? 1 : 0);
    }

    public boolean isEDITACTIONNull() {
        return this.IsParamNull(TAG_EDITACTION);
    }

    public boolean getEDITACTION() {
        return this.GetParamIntValue(TAG_EDITACTION, 0) == 1;
    }

    public void setEDITACTION(boolean bValue) {
        this.SetParamValue(TAG_EDITACTION, bValue ? 1 : 0);
    }

    public boolean isVIEWACTIONNull() {
        return this.IsParamNull(TAG_VIEWACTION);
    }

    public boolean getVIEWACTION() {
        return this.GetParamIntValue(TAG_VIEWACTION, 0) == 1;
    }

    public void setVIEWACTION(boolean bValue) {
        this.SetParamValue(TAG_VIEWACTION, bValue ? 1 : 0);
    }

    public boolean isREMOVEACTIONNull() {
        return this.IsParamNull(TAG_REMOVEACTION);
    }

    public boolean getREMOVEACTION() {
        return this.GetParamIntValue(TAG_REMOVEACTION, 0) == 1;
    }

    public void setREMOVEACTION(boolean bValue) {
        this.SetParamValue(TAG_REMOVEACTION, bValue ? 1 : 0);
    }

    public boolean isEXPORTACTIONNull() {
        return this.IsParamNull(TAG_EXPORTACTION);
    }

    public boolean getEXPORTACTION() {
        return this.GetParamIntValue(TAG_EXPORTACTION, 0) == 1;
    }

    public void setEXPORTACTION(boolean bValue) {
        this.SetParamValue(TAG_EXPORTACTION, bValue ? 1 : 0);
    }

    public boolean isSEARCHBARACTIONNull() {
        return this.IsParamNull(TAG_SEARCHBARACTION);
    }

    public boolean getSEARCHBARACTION() {
        return this.GetParamIntValue(TAG_SEARCHBARACTION, 0) == 1;
    }

    public void setSEARCHBARACTION(boolean bValue) {
        this.SetParamValue(TAG_SEARCHBARACTION, bValue ? 1 : 0);
    }

    public boolean isDATANAVBARNull() {
        return this.IsParamNull(TAG_DATANAVBAR);
    }

    public boolean getDATANAVBAR() {
        return this.GetParamIntValue(TAG_DATANAVBAR, 0) == 1;
    }

    public void setDATANAVBAR(boolean bValue) {
        this.SetParamValue(TAG_DATANAVBAR, bValue ? 1 : 0);
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

    public boolean isTBMODELNull() {
        return this.IsParamNull(TAG_TBMODEL);
    }

    public String getTBMODEL() {
        return this.GetParamStringValue(TAG_TBMODEL, "");
    }

    public void setTBMODEL(String strValue) {
        this.SetParamValue(TAG_TBMODEL, strValue);
    }

    public boolean isTBTEMPLIDNull() {
        return this.IsParamNull(TAG_TBTEMPLID);
    }

    public String getTBTEMPLID() {
        return this.GetParamStringValue(TAG_TBTEMPLID, "");
    }

    public void setTBTEMPLID(String strValue) {
        this.SetParamValue(TAG_TBTEMPLID, strValue);
    }

    public boolean isTBTEMPLNAMENull() {
        return this.IsParamNull(TAG_TBTEMPLNAME);
    }

    public String getTBTEMPLNAME() {
        return this.GetParamStringValue(TAG_TBTEMPLNAME, "");
    }

    public void setTBTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_TBTEMPLNAME, strValue);
    }

    public boolean isCANCELWFACTIONNull() {
        return this.IsParamNull(TAG_CANCELWFACTION);
    }

    public boolean getCANCELWFACTION() {
        return this.GetParamIntValue(TAG_CANCELWFACTION, 0) == 1;
    }

    public void setCANCELWFACTION(boolean bValue) {
        this.SetParamValue(TAG_CANCELWFACTION, bValue ? 1 : 0);
    }

    public boolean isRESTARTWFACTIONNull() {
        return this.IsParamNull(TAG_RESTARTWFACTION);
    }

    public boolean getRESTARTWFACTION() {
        return this.GetParamIntValue(TAG_RESTARTWFACTION, 0) == 1;
    }

    public void setRESTARTWFACTION(boolean bValue) {
        this.SetParamValue(TAG_RESTARTWFACTION, bValue ? 1 : 0);
    }

    public boolean isDEBHGROUPIDNull() {
        return this.IsParamNull(TAG_DEBHGROUPID);
    }

    public String getDEBHGROUPID() {
        return this.GetParamStringValue(TAG_DEBHGROUPID, "");
    }

    public void setDEBHGROUPID(String strValue) {
        this.SetParamValue(TAG_DEBHGROUPID, strValue);
    }

    public boolean isDEBHGROUPNAMENull() {
        return this.IsParamNull(TAG_DEBHGROUPNAME);
    }

    public String getDEBHGROUPNAME() {
        return this.GetParamStringValue(TAG_DEBHGROUPNAME, "");
    }

    public void setDEBHGROUPNAME(String strValue) {
        this.SetParamValue(TAG_DEBHGROUPNAME, strValue);
    }

    public boolean isDEBHGROUP2IDNull() {
        return this.IsParamNull(TAG_DEBHGROUP2ID);
    }

    public String getDEBHGROUP2ID() {
        return this.GetParamStringValue(TAG_DEBHGROUP2ID, "");
    }

    public void setDEBHGROUP2ID(String strValue) {
        this.SetParamValue(TAG_DEBHGROUP2ID, strValue);
    }

    public boolean isDEBHGROUP2NAMENull() {
        return this.IsParamNull(TAG_DEBHGROUP2NAME);
    }

    public String getDEBHGROUP2NAME() {
        return this.GetParamStringValue(TAG_DEBHGROUP2NAME, "");
    }

    public void setDEBHGROUP2NAME(String strValue) {
        this.SetParamValue(TAG_DEBHGROUP2NAME, strValue);
    }

    public boolean isDEBHGROUP3IDNull() {
        return this.IsParamNull(TAG_DEBHGROUP3ID);
    }

    public String getDEBHGROUP3ID() {
        return this.GetParamStringValue(TAG_DEBHGROUP3ID, "");
    }

    public void setDEBHGROUP3ID(String strValue) {
        this.SetParamValue(TAG_DEBHGROUP3ID, strValue);
    }

    public boolean isDEBHGROUP3NAMENull() {
        return this.IsParamNull(TAG_DEBHGROUP3NAME);
    }

    public String getDEBHGROUP3NAME() {
        return this.GetParamStringValue(TAG_DEBHGROUP3NAME, "");
    }

    public void setDEBHGROUP3NAME(String strValue) {
        this.SetParamValue(TAG_DEBHGROUP3NAME, strValue);
    }

    public boolean isDEBHGROUP4IDNull() {
        return this.IsParamNull(TAG_DEBHGROUP4ID);
    }

    public String getDEBHGROUP4ID() {
        return this.GetParamStringValue(TAG_DEBHGROUP4ID, "");
    }

    public void setDEBHGROUP4ID(String strValue) {
        this.SetParamValue(TAG_DEBHGROUP4ID, strValue);
    }

    public boolean isDEBHGROUP4NAMENull() {
        return this.IsParamNull(TAG_DEBHGROUP4NAME);
    }

    public String getDEBHGROUP4NAME() {
        return this.GetParamStringValue(TAG_DEBHGROUP4NAME, "");
    }

    public void setDEBHGROUP4NAME(String strValue) {
        this.SetParamValue(TAG_DEBHGROUP4NAME, strValue);
    }

    public boolean isDEBHGROUP5IDNull() {
        return this.IsParamNull(TAG_DEBHGROUP5ID);
    }

    public String getDEBHGROUP5ID() {
        return this.GetParamStringValue(TAG_DEBHGROUP5ID, "");
    }

    public void setDEBHGROUP5ID(String strValue) {
        this.SetParamValue(TAG_DEBHGROUP5ID, strValue);
    }

    public boolean isDEBHGROUP5NAMENull() {
        return this.IsParamNull(TAG_DEBHGROUP5NAME);
    }

    public String getDEBHGROUP5NAME() {
        return this.GetParamStringValue(TAG_DEBHGROUP5NAME, "");
    }

    public void setDEBHGROUP5NAME(String strValue) {
        this.SetParamValue(TAG_DEBHGROUP5NAME, strValue);
    }

    public boolean isDEBHGROUP6IDNull() {
        return this.IsParamNull(TAG_DEBHGROUP6ID);
    }

    public String getDEBHGROUP6ID() {
        return this.GetParamStringValue(TAG_DEBHGROUP6ID, "");
    }

    public void setDEBHGROUP6ID(String strValue) {
        this.SetParamValue(TAG_DEBHGROUP6ID, strValue);
    }

    public boolean isDEBHGROUP6NAMENull() {
        return this.IsParamNull(TAG_DEBHGROUP6NAME);
    }

    public String getDEBHGROUP6NAME() {
        return this.GetParamStringValue(TAG_DEBHGROUP6NAME, "");
    }

    public void setDEBHGROUP6NAME(String strValue) {
        this.SetParamValue(TAG_DEBHGROUP6NAME, strValue);
    }

    public boolean isVIEWWFSTEPACTORNull() {
        return this.IsParamNull(TAG_VIEWWFSTEPACTOR);
    }

    public boolean getVIEWWFSTEPACTOR() {
        return this.GetParamIntValue(TAG_VIEWWFSTEPACTOR, 0) == 1;
    }

    public void setVIEWWFSTEPACTOR(boolean bValue) {
        this.SetParamValue(TAG_VIEWWFSTEPACTOR, bValue ? 1 : 0);
    }

    public boolean isEXPORTXMLACTIONNull() {
        return this.IsParamNull(TAG_EXPORTXMLACTION);
    }

    public boolean getEXPORTXMLACTION() {
        return this.GetParamIntValue(TAG_EXPORTXMLACTION, 0) == 1;
    }

    public void setEXPORTXMLACTION(boolean bValue) {
        this.SetParamValue(TAG_EXPORTXMLACTION, bValue ? 1 : 0);
    }

    public boolean isIMPORTDATAACTIONNull() {
        return this.IsParamNull(TAG_IMPORTDATAACTION);
    }

    public boolean getIMPORTDATAACTION() {
        return this.GetParamIntValue(TAG_IMPORTDATAACTION, 0) == 1;
    }

    public void setIMPORTDATAACTION(boolean bValue) {
        this.SetParamValue(TAG_IMPORTDATAACTION, bValue ? 1 : 0);
    }

    public boolean isINFOMODENull() {
        return this.IsParamNull(TAG_INFOMODE);
    }

    public boolean getINFOMODE() {
        return this.GetParamIntValue(TAG_INFOMODE, 0) == 1;
    }

    public void setINFOMODE(boolean bValue) {
        this.SetParamValue(TAG_INFOMODE, bValue ? 1 : 0);
    }

    public boolean isNODEFDEBHGROUPNull() {
        return this.IsParamNull(TAG_NODEFDEBHGROUP);
    }

    public boolean getNODEFDEBHGROUP() {
        return this.GetParamIntValue(TAG_NODEFDEBHGROUP, 0) == 1;
    }

    public void setNODEFDEBHGROUP(boolean bValue) {
        this.SetParamValue(TAG_NODEFDEBHGROUP, bValue ? 1 : 0);
    }

    public ToolbarConfig getToolbarConfig() {
        if (this.toolbarConfig == null) {
            this.toolbarConfig = new ToolbarConfig();
            if (!StringHelper.IsNullOrEmpty((String)this.getTBMODEL())) {
                this.toolbarConfig.LoadXML(this.getTBMODEL());
            }
        }
        return this.toolbarConfig;
    }
}

