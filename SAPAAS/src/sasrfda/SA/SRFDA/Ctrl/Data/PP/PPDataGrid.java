/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data.PP;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PPDataGrid
extends BaseDataEntity {
    public static final String PARAMTYPE = "PP_DATAGRID";
    public static final String TAG_PPDATAGRIDID = "PPDATAGRIDID";
    public static final String TAG_PPDATAGRIDNAME = "PPDATAGRIDNAME";
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
    public static final String TAG_QUERYMODELID = "QUERYMODELID";
    public static final String TAG_QUERYMODELNAME = "QUERYMODELNAME";
    public static final String TAG_NODEFQUERY = "NODEFQUERY";
    public static final String TAG_DGUSERDP = "DGUSERDP";
    public static final String TAG_UPDATEMODE = "UPDATEMODE";
    public static final String TAG_INSERTEMODE = "INSERTEMODE";
    public static final String TAG_DEDATAIMPORTID = "DEDATAIMPORTID";
    public static final String TAG_DEDATAIMPORTNAME = "DEDATAIMPORTNAME";
    public static final String TAG_DGMODE = "DGMODE";
    public static final String TAG_SAVEATNEW = "SAVEATNEW";
    public static final String TAG_SELECTCOLUMN = "SELECTCOLUMN";
    public static final String TAG_CLICKSTOEDIT = "CLICKSTOEDIT";
    public static final String TAG_HIDEDERCOLUMN = "HIDEDERCOLUMN";
    public static final String TAG_LOADDEFAULT = "LOADDEFAULT";
    public static final String TAG_REFRESHTIMER = "REFRESHTIMER";
    public static final String TAG_BEFORELDCODE = "BEFORELDCODE";
    public static final String TAG_EDITABLEDEFAULT = "EDITABLEDEFAULT";
    public static final String TAG_ITEMPRIVILEGE = "ITEMPRIVILEGE";
    public static final String TAG_DGNEWEDITGEARID = "DGNEWEDITGEARID";
    public static final String TAG_DGNEWEDITGEARNAME = "DGNEWEDITGEARNAME";
    public static final String TAG_EDITPAGEID = "EDITPAGEID";
    public static final String TAG_EDITPAGENAME = "EDITPAGENAME";
    public static final String TAG_EDITPAGEWIDTH = "EDITPAGEWIDTH";
    public static final String TAG_EDITPAGEHEIGHT = "EDITPAGEHEIGHT";
    public static final String TAG_NEWBATCHONLY = "NEWBATCHONLY";
    public static final String TAG_ENABLENEW = "ENABLENEW";
    public static final String TAG_ENABLEEDIT = "ENABLEEDIT";
    public static final String TAG_DGDBCLKEDIT = "DGDBCLKEDIT";
    public static final String TAG_AFTERLDCODE = "AFTERLDCODE";
    public static final String TAG_SUMMARYHEIGHT = "SUMMARYHEIGHT";
    public static final String TAG_DATAGRIDID = "DATAGRIDID";
    public static final String TAG_DATAGRIDNAME = "DATAGRIDNAME";
    public static final String TAG_ENABLEPAGING = "ENABLEPAGING";

    public String getPPDATAGRIDID() {
        return this.GetParamStringValue(TAG_PPDATAGRIDID, "");
    }

    public void setPPDATAGRIDID(String strValue) {
        this.SetParamValue(TAG_PPDATAGRIDID, strValue);
    }

    public String getPPDATAGRIDNAME() {
        return this.GetParamStringValue(TAG_PPDATAGRIDNAME, "");
    }

    public void setPPDATAGRIDNAME(String strValue) {
        this.SetParamValue(TAG_PPDATAGRIDNAME, strValue);
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

    public String getQUERYMODELID() {
        return this.GetParamStringValue(TAG_QUERYMODELID, "");
    }

    public void setQUERYMODELID(String strValue) {
        this.SetParamValue(TAG_QUERYMODELID, strValue);
    }

    public String getQUERYMODELNAME() {
        return this.GetParamStringValue(TAG_QUERYMODELNAME, "");
    }

    public void setQUERYMODELNAME(String strValue) {
        this.SetParamValue(TAG_QUERYMODELNAME, strValue);
    }

    public boolean getNODEFQUERY() {
        return this.GetParamIntValue(TAG_NODEFQUERY, 0) == 1;
    }

    public void setNODEFQUERY(boolean bValue) {
        this.SetParamValue(TAG_NODEFQUERY, bValue ? 1 : 0);
    }

    public boolean getDGUSERDP() {
        return this.GetParamIntValue(TAG_DGUSERDP, 0) == 1;
    }

    public void setDGUSERDP(boolean bValue) {
        this.SetParamValue(TAG_DGUSERDP, bValue ? 1 : 0);
    }

    public String getUPDATEMODE() {
        return this.GetParamStringValue(TAG_UPDATEMODE, "");
    }

    public void setUPDATEMODE(String strValue) {
        this.SetParamValue(TAG_UPDATEMODE, strValue);
    }

    public String getINSERTEMODE() {
        return this.GetParamStringValue(TAG_INSERTEMODE, "");
    }

    public void setINSERTEMODE(String strValue) {
        this.SetParamValue(TAG_INSERTEMODE, strValue);
    }

    public String getDEDATAIMPORTID() {
        return this.GetParamStringValue(TAG_DEDATAIMPORTID, "");
    }

    public void setDEDATAIMPORTID(String strValue) {
        this.SetParamValue(TAG_DEDATAIMPORTID, strValue);
    }

    public String getDEDATAIMPORTNAME() {
        return this.GetParamStringValue(TAG_DEDATAIMPORTNAME, "");
    }

    public void setDEDATAIMPORTNAME(String strValue) {
        this.SetParamValue(TAG_DEDATAIMPORTNAME, strValue);
    }

    public String getDGMODE() {
        return this.GetParamStringValue(TAG_DGMODE, "");
    }

    public void setDGMODE(String strValue) {
        this.SetParamValue(TAG_DGMODE, strValue);
    }

    public boolean getSAVEATNEW() {
        return this.GetParamIntValue(TAG_SAVEATNEW, 0) == 1;
    }

    public void setSAVEATNEW(boolean bValue) {
        this.SetParamValue(TAG_SAVEATNEW, bValue ? 1 : 0);
    }

    public boolean getSELECTCOLUMN() {
        return this.GetParamIntValue(TAG_SELECTCOLUMN, 0) == 1;
    }

    public void setSELECTCOLUMN(boolean bValue) {
        this.SetParamValue(TAG_SELECTCOLUMN, bValue ? 1 : 0);
    }

    public int getCLICKSTOEDIT() {
        return this.GetParamIntValue(TAG_CLICKSTOEDIT, 0);
    }

    public void setCLICKSTOEDIT(int strValue) {
        this.SetParamValue(TAG_CLICKSTOEDIT, strValue);
    }

    public boolean getHIDEDERCOLUMN() {
        return this.GetParamIntValue(TAG_HIDEDERCOLUMN, 0) == 1;
    }

    public void setHIDEDERCOLUMN(boolean bValue) {
        this.SetParamValue(TAG_HIDEDERCOLUMN, bValue ? 1 : 0);
    }

    public boolean getLOADDEFAULT() {
        return this.GetParamIntValue(TAG_LOADDEFAULT, 0) == 1;
    }

    public void setLOADDEFAULT(boolean bValue) {
        this.SetParamValue(TAG_LOADDEFAULT, bValue ? 1 : 0);
    }

    public int getREFRESHTIMER() {
        return this.GetParamIntValue(TAG_REFRESHTIMER, 0);
    }

    public void setREFRESHTIMER(int strValue) {
        this.SetParamValue(TAG_REFRESHTIMER, strValue);
    }

    public String getBEFORELDCODE() {
        return this.GetParamStringValue(TAG_BEFORELDCODE, "");
    }

    public void setBEFORELDCODE(String strValue) {
        this.SetParamValue(TAG_BEFORELDCODE, strValue);
    }

    public boolean getEDITABLEDEFAULT() {
        return this.GetParamIntValue(TAG_EDITABLEDEFAULT, 0) == 1;
    }

    public void setEDITABLEDEFAULT(boolean bValue) {
        this.SetParamValue(TAG_EDITABLEDEFAULT, bValue ? 1 : 0);
    }

    public boolean getITEMPRIVILEGE() {
        return this.GetParamIntValue(TAG_ITEMPRIVILEGE, 0) == 1;
    }

    public void setITEMPRIVILEGE(boolean bValue) {
        this.SetParamValue(TAG_ITEMPRIVILEGE, bValue ? 1 : 0);
    }

    public String getDGNEWEDITGEARID() {
        return this.GetParamStringValue(TAG_DGNEWEDITGEARID, "");
    }

    public void setDGNEWEDITGEARID(String strValue) {
        this.SetParamValue(TAG_DGNEWEDITGEARID, strValue);
    }

    public String getDGNEWEDITGEARNAME() {
        return this.GetParamStringValue(TAG_DGNEWEDITGEARNAME, "");
    }

    public void setDGNEWEDITGEARNAME(String strValue) {
        this.SetParamValue(TAG_DGNEWEDITGEARNAME, strValue);
    }

    public String getEDITPAGEID() {
        return this.GetParamStringValue(TAG_EDITPAGEID, "");
    }

    public void setEDITPAGEID(String strValue) {
        this.SetParamValue(TAG_EDITPAGEID, strValue);
    }

    public String getEDITPAGENAME() {
        return this.GetParamStringValue(TAG_EDITPAGENAME, "");
    }

    public void setEDITPAGENAME(String strValue) {
        this.SetParamValue(TAG_EDITPAGENAME, strValue);
    }

    public int getEDITPAGEWIDTH() {
        return this.GetParamIntValue(TAG_EDITPAGEWIDTH, 0);
    }

    public void setEDITPAGEWIDTH(int strValue) {
        this.SetParamValue(TAG_EDITPAGEWIDTH, strValue);
    }

    public int getEDITPAGEHEIGHT() {
        return this.GetParamIntValue(TAG_EDITPAGEHEIGHT, 0);
    }

    public void setEDITPAGEHEIGHT(int strValue) {
        this.SetParamValue(TAG_EDITPAGEHEIGHT, strValue);
    }

    public boolean getNEWBATCHONLY() {
        return this.GetParamIntValue(TAG_NEWBATCHONLY, 0) == 1;
    }

    public void setNEWBATCHONLY(boolean bValue) {
        this.SetParamValue(TAG_NEWBATCHONLY, bValue ? 1 : 0);
    }

    public boolean getENABLENEW() {
        return this.GetParamIntValue(TAG_ENABLENEW, 0) == 1;
    }

    public void setENABLENEW(boolean bValue) {
        this.SetParamValue(TAG_ENABLENEW, bValue ? 1 : 0);
    }

    public boolean getENABLEEDIT() {
        return this.GetParamIntValue(TAG_ENABLEEDIT, 0) == 1;
    }

    public void setENABLEEDIT(boolean bValue) {
        this.SetParamValue(TAG_ENABLEEDIT, bValue ? 1 : 0);
    }

    public boolean getDGDBCLKEDIT() {
        return this.GetParamIntValue(TAG_DGDBCLKEDIT, 0) == 1;
    }

    public void setDGDBCLKEDIT(boolean bValue) {
        this.SetParamValue(TAG_DGDBCLKEDIT, bValue ? 1 : 0);
    }

    public String getAFTERLDCODE() {
        return this.GetParamStringValue(TAG_AFTERLDCODE, "");
    }

    public void setAFTERLDCODE(String strValue) {
        this.SetParamValue(TAG_AFTERLDCODE, strValue);
    }

    public int getSUMMARYHEIGHT() {
        return this.GetParamIntValue(TAG_SUMMARYHEIGHT, 0);
    }

    public void setSUMMARYHEIGHT(int strValue) {
        this.SetParamValue(TAG_SUMMARYHEIGHT, strValue);
    }

    public String getDATAGRIDID() {
        return this.GetParamStringValue(TAG_DATAGRIDID, "");
    }

    public void setDATAGRIDID(String strValue) {
        this.SetParamValue(TAG_DATAGRIDID, strValue);
    }

    public boolean isDATAGRIDNAMENull() {
        return this.IsParamNull(TAG_DATAGRIDNAME);
    }

    public String getDATAGRIDNAME() {
        return this.GetParamStringValue(TAG_DATAGRIDNAME, "");
    }

    public void setDATAGRIDNAME(String strValue) {
        this.SetParamValue(TAG_DATAGRIDNAME, strValue);
    }

    public boolean isENABLEPAGINGNull() {
        return this.IsParamNull(TAG_ENABLEPAGING);
    }

    public boolean getENABLEPAGING() {
        return this.GetParamIntValue(TAG_ENABLEPAGING, 0) == 1;
    }

    public void setENABLEPAGING(boolean bValue) {
        this.SetParamValue(TAG_ENABLEPAGING, bValue ? 1 : 0);
    }
}

