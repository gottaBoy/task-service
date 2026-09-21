/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data.PP;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PPTreePanel
extends BaseDataEntity {
    public static final String PARAMTYPE = "PP_TREEPANEL";
    public static final String TAG_PPTREEPANELID = "PPTREEPANELID";
    public static final String TAG_PPTREEPANELNAME = "PPTREEPANELNAME";
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
    public static final String TAG_ROOTVISIBLE = "ROOTVISIBLE";
    public static final String TAG_ROOTTEXT = "ROOTTEXT";
    public static final String TAG_ACTIONHELPER = "ACTIONHELPER";
    public static final String TAG_MULTISELECT = "MULTISELECT";
    public static final String TAG_CODELISTID = "CODELISTID";
    public static final String TAG_CODELISTNAME = "CODELISTNAME";
    public static final String TAG_USERDP = "USERDP";
    public static final String TAG_QUERYMODELID = "QUERYMODELID";
    public static final String TAG_QUERYMODELNAME = "QUERYMODELNAME";
    public static final String TAG_NODEIDFIELD = "NODEIDFIELD";
    public static final String TAG_PNODEIDFIELD = "PNODEIDFIELD";
    public static final String TAG_MAJORSORTDIR = "MAJORSORTDIR";
    public static final String TAG_MAJORSORTFIELD = "MAJORSORTFIELD";
    public static final String TAG_NODETEXTFIELD = "NODETEXTFIELD";
    public static final String TAG_NODESELVALUEFIELD = "NODESELVALUEFIELD";
    public static final String TAG_NODESELTEXTFIELD = "NODESELTEXTFIELD";
    public static final String TAG_NODETEXTFMT = "NODETEXTFMT";
    public static final String TAG_NODEICONFIELD = "NODEICONFIELD";
    public static final String TAG_NODELEAFFIELD = "NODELEAFFIELD";
    public static final String TAG_NODECLICKCODE = "NODECLICKCODE";
    public static final String TAG_NODEFILTER = "NODEFILTER";
    public static final String TAG_NODELINK = "NODELINK";
    public static final String TAG_NODEDEFLINK = "NODEDEFLINK";
    public static final String TAG_TREEVIEWID = "TREEVIEWID";
    public static final String TAG_TREEVIEWNAME = "TREEVIEWNAME";

    public boolean isPPTREEPANELIDNull() {
        return this.IsParamNull(TAG_PPTREEPANELID);
    }

    public String getPPTREEPANELID() {
        return this.GetParamStringValue(TAG_PPTREEPANELID, "");
    }

    public void setPPTREEPANELID(String strValue) {
        this.SetParamValue(TAG_PPTREEPANELID, strValue);
    }

    public boolean isPPTREEPANELNAMENull() {
        return this.IsParamNull(TAG_PPTREEPANELNAME);
    }

    public String getPPTREEPANELNAME() {
        return this.GetParamStringValue(TAG_PPTREEPANELNAME, "");
    }

    public void setPPTREEPANELNAME(String strValue) {
        this.SetParamValue(TAG_PPTREEPANELNAME, strValue);
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

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isPAGETYPENull() {
        return this.IsParamNull(TAG_PAGETYPE);
    }

    public String getPAGETYPE() {
        return this.GetParamStringValue(TAG_PAGETYPE, "");
    }

    public void setPAGETYPE(String strValue) {
        this.SetParamValue(TAG_PAGETYPE, strValue);
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

    public boolean isPAGEPARAMTYPEIDNull() {
        return this.IsParamNull(TAG_PAGEPARAMTYPEID);
    }

    public String getPAGEPARAMTYPEID() {
        return this.GetParamStringValue(TAG_PAGEPARAMTYPEID, "");
    }

    public void setPAGEPARAMTYPEID(String strValue) {
        this.SetParamValue(TAG_PAGEPARAMTYPEID, strValue);
    }

    public boolean isPAGEPARAMTYPENAMENull() {
        return this.IsParamNull(TAG_PAGEPARAMTYPENAME);
    }

    public String getPAGEPARAMTYPENAME() {
        return this.GetParamStringValue(TAG_PAGEPARAMTYPENAME, "");
    }

    public void setPAGEPARAMTYPENAME(String strValue) {
        this.SetParamValue(TAG_PAGEPARAMTYPENAME, strValue);
    }

    public boolean isCTRLIDNull() {
        return this.IsParamNull(TAG_CTRLID);
    }

    public String getCTRLID() {
        return this.GetParamStringValue(TAG_CTRLID, "");
    }

    public void setCTRLID(String strValue) {
        this.SetParamValue(TAG_CTRLID, strValue);
    }

    public boolean isPPTYPEDESCNull() {
        return this.IsParamNull(TAG_PPTYPEDESC);
    }

    public String getPPTYPEDESC() {
        return this.GetParamStringValue(TAG_PPTYPEDESC, "");
    }

    public void setPPTYPEDESC(String strValue) {
        this.SetParamValue(TAG_PPTYPEDESC, strValue);
    }

    public boolean isROOTVISIBLENull() {
        return this.IsParamNull(TAG_ROOTVISIBLE);
    }

    public boolean getROOTVISIBLE() {
        return this.GetParamIntValue(TAG_ROOTVISIBLE, 0) == 1;
    }

    public void setROOTVISIBLE(boolean bValue) {
        this.SetParamValue(TAG_ROOTVISIBLE, bValue ? 1 : 0);
    }

    public boolean isROOTTEXTNull() {
        return this.IsParamNull(TAG_ROOTTEXT);
    }

    public String getROOTTEXT() {
        return this.GetParamStringValue(TAG_ROOTTEXT, "");
    }

    public void setROOTTEXT(String strValue) {
        this.SetParamValue(TAG_ROOTTEXT, strValue);
    }

    public boolean isACTIONHELPERNull() {
        return this.IsParamNull(TAG_ACTIONHELPER);
    }

    public String getACTIONHELPER() {
        return this.GetParamStringValue(TAG_ACTIONHELPER, "");
    }

    public void setACTIONHELPER(String strValue) {
        this.SetParamValue(TAG_ACTIONHELPER, strValue);
    }

    public boolean isMULTISELECTNull() {
        return this.IsParamNull(TAG_MULTISELECT);
    }

    public boolean getMULTISELECT() {
        return this.GetParamIntValue(TAG_MULTISELECT, 0) == 1;
    }

    public void setMULTISELECT(boolean bValue) {
        this.SetParamValue(TAG_MULTISELECT, bValue ? 1 : 0);
    }

    public boolean isCODELISTIDNull() {
        return this.IsParamNull(TAG_CODELISTID);
    }

    public String getCODELISTID() {
        return this.GetParamStringValue(TAG_CODELISTID, "");
    }

    public void setCODELISTID(String strValue) {
        this.SetParamValue(TAG_CODELISTID, strValue);
    }

    public boolean isCODELISTNAMENull() {
        return this.IsParamNull(TAG_CODELISTNAME);
    }

    public String getCODELISTNAME() {
        return this.GetParamStringValue(TAG_CODELISTNAME, "");
    }

    public void setCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_CODELISTNAME, strValue);
    }

    public boolean isUSERDPNull() {
        return this.IsParamNull(TAG_USERDP);
    }

    public boolean getUSERDP() {
        return this.GetParamIntValue(TAG_USERDP, 0) == 1;
    }

    public void setUSERDP(boolean bValue) {
        this.SetParamValue(TAG_USERDP, bValue ? 1 : 0);
    }

    public boolean isQUERYMODELIDNull() {
        return this.IsParamNull(TAG_QUERYMODELID);
    }

    public String getQUERYMODELID() {
        return this.GetParamStringValue(TAG_QUERYMODELID, "");
    }

    public void setQUERYMODELID(String strValue) {
        this.SetParamValue(TAG_QUERYMODELID, strValue);
    }

    public boolean isQUERYMODELNAMENull() {
        return this.IsParamNull(TAG_QUERYMODELNAME);
    }

    public String getQUERYMODELNAME() {
        return this.GetParamStringValue(TAG_QUERYMODELNAME, "");
    }

    public void setQUERYMODELNAME(String strValue) {
        this.SetParamValue(TAG_QUERYMODELNAME, strValue);
    }

    public boolean isNODEIDFIELDNull() {
        return this.IsParamNull(TAG_NODEIDFIELD);
    }

    public String getNODEIDFIELD() {
        return this.GetParamStringValue(TAG_NODEIDFIELD, "");
    }

    public void setNODEIDFIELD(String strValue) {
        this.SetParamValue(TAG_NODEIDFIELD, strValue);
    }

    public boolean isPNODEIDFIELDNull() {
        return this.IsParamNull(TAG_PNODEIDFIELD);
    }

    public String getPNODEIDFIELD() {
        return this.GetParamStringValue(TAG_PNODEIDFIELD, "");
    }

    public void setPNODEIDFIELD(String strValue) {
        this.SetParamValue(TAG_PNODEIDFIELD, strValue);
    }

    public boolean isMAJORSORTDIRNull() {
        return this.IsParamNull(TAG_MAJORSORTDIR);
    }

    public String getMAJORSORTDIR() {
        return this.GetParamStringValue(TAG_MAJORSORTDIR, "");
    }

    public void setMAJORSORTDIR(String strValue) {
        this.SetParamValue(TAG_MAJORSORTDIR, strValue);
    }

    public boolean isMAJORSORTFIELDNull() {
        return this.IsParamNull(TAG_MAJORSORTFIELD);
    }

    public String getMAJORSORTFIELD() {
        return this.GetParamStringValue(TAG_MAJORSORTFIELD, "");
    }

    public void setMAJORSORTFIELD(String strValue) {
        this.SetParamValue(TAG_MAJORSORTFIELD, strValue);
    }

    public boolean isNODETEXTFIELDNull() {
        return this.IsParamNull(TAG_NODETEXTFIELD);
    }

    public String getNODETEXTFIELD() {
        return this.GetParamStringValue(TAG_NODETEXTFIELD, "");
    }

    public void setNODETEXTFIELD(String strValue) {
        this.SetParamValue(TAG_NODETEXTFIELD, strValue);
    }

    public boolean isNODESELVALUEFIELDNull() {
        return this.IsParamNull(TAG_NODESELVALUEFIELD);
    }

    public String getNODESELVALUEFIELD() {
        return this.GetParamStringValue(TAG_NODESELVALUEFIELD, "");
    }

    public void setNODESELVALUEFIELD(String strValue) {
        this.SetParamValue(TAG_NODESELVALUEFIELD, strValue);
    }

    public boolean isNODESELTEXTFIELDNull() {
        return this.IsParamNull(TAG_NODESELTEXTFIELD);
    }

    public String getNODESELTEXTFIELD() {
        return this.GetParamStringValue(TAG_NODESELTEXTFIELD, "");
    }

    public void setNODESELTEXTFIELD(String strValue) {
        this.SetParamValue(TAG_NODESELTEXTFIELD, strValue);
    }

    public boolean isNODETEXTFMTNull() {
        return this.IsParamNull(TAG_NODETEXTFMT);
    }

    public String getNODETEXTFMT() {
        return this.GetParamStringValue(TAG_NODETEXTFMT, "");
    }

    public void setNODETEXTFMT(String strValue) {
        this.SetParamValue(TAG_NODETEXTFMT, strValue);
    }

    public boolean isNODEICONFIELDNull() {
        return this.IsParamNull(TAG_NODEICONFIELD);
    }

    public String getNODEICONFIELD() {
        return this.GetParamStringValue(TAG_NODEICONFIELD, "");
    }

    public void setNODEICONFIELD(String strValue) {
        this.SetParamValue(TAG_NODEICONFIELD, strValue);
    }

    public boolean isNODELEAFFIELDNull() {
        return this.IsParamNull(TAG_NODELEAFFIELD);
    }

    public String getNODELEAFFIELD() {
        return this.GetParamStringValue(TAG_NODELEAFFIELD, "");
    }

    public void setNODELEAFFIELD(String strValue) {
        this.SetParamValue(TAG_NODELEAFFIELD, strValue);
    }

    public boolean isNODECLICKCODENull() {
        return this.IsParamNull(TAG_NODECLICKCODE);
    }

    public String getNODECLICKCODE() {
        return this.GetParamStringValue(TAG_NODECLICKCODE, "");
    }

    public void setNODECLICKCODE(String strValue) {
        this.SetParamValue(TAG_NODECLICKCODE, strValue);
    }

    public boolean isNODEFILTERNull() {
        return this.IsParamNull(TAG_NODEFILTER);
    }

    public String getNODEFILTER() {
        return this.GetParamStringValue(TAG_NODEFILTER, "");
    }

    public void setNODEFILTER(String strValue) {
        this.SetParamValue(TAG_NODEFILTER, strValue);
    }

    public boolean isNODELINKNull() {
        return this.IsParamNull(TAG_NODELINK);
    }

    public String getNODELINK() {
        return this.GetParamStringValue(TAG_NODELINK, "");
    }

    public void setNODELINK(String strValue) {
        this.SetParamValue(TAG_NODELINK, strValue);
    }

    public boolean isNODEDEFLINKNull() {
        return this.IsParamNull(TAG_NODEDEFLINK);
    }

    public String getNODEDEFLINK() {
        return this.GetParamStringValue(TAG_NODEDEFLINK, "");
    }

    public void setNODEDEFLINK(String strValue) {
        this.SetParamValue(TAG_NODEDEFLINK, strValue);
    }

    public boolean isTREEVIEWIDNull() {
        return this.IsParamNull(TAG_TREEVIEWID);
    }

    public String getTREEVIEWID() {
        return this.GetParamStringValue(TAG_TREEVIEWID, "");
    }

    public void setTREEVIEWID(String strValue) {
        this.SetParamValue(TAG_TREEVIEWID, strValue);
    }

    public boolean isTREEVIEWNAMENull() {
        return this.IsParamNull(TAG_TREEVIEWNAME);
    }

    public String getTREEVIEWNAME() {
        return this.GetParamStringValue(TAG_TREEVIEWNAME, "");
    }

    public void setTREEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_TREEVIEWNAME, strValue);
    }
}

