/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Model.DataGridModelConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;

public class DataGrid
extends BaseDataEntity {
    public static final String MINORSORTMODE_DISABLE = "DISABLE";
    public static final String MINORSORTMODE_ENABLE_AUTO = "ENABLE_AUTO";
    public static final String MINORSORTMODE_ENABLE_LOCKED = "ENABLE_LOCKED";
    public static final String CELLSELMODE_DISABLE = "DISABLE";
    public static final String CELLSELMODE_SINGLE = "SINGLE";
    public static final String CELLSELMODE_MULTI = "MULTI";
    public static final String CELLSELSTYLE_NONE = "NONE";
    public static final String CELLSELSTYLE_BK = "BK";
    public static final String CELLSELSTYLE_CHECK = "CHECK";
    public static final String TAG_DATAGRIDID = "DATAGRIDID";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DATAGRIDNAME = "DATAGRIDNAME";
    public static final String TAG_OWNERID = "OWNERID";
    public static final String TAG_CONFIGID = "CONFIGID";
    public static final String TAG_ISMAJOR = "ISMAJOR";
    public static final String TAG_CONFIGPATH = "CONFIGPATH";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_SEARCHMODELPATH = "SEARCHMODELPATH";
    public static final String TAG_SEARCHPROC = "SEARCHPROC";
    public static final String TAG_DGVERSION = "DGVERSION";
    public static final String TAG_BACKENDCTRL = "BACKENDCTRL";
    public static final String TAG_BACKENDCONFIG = "BACKENDCONFIG";
    public static final String TAG_CTRLOBJECT = "CTRLOBJECT";
    public static final String TAG_CTRLID = "CTRLID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DELOGICNAME = "DELOGICNAME";
    public static final String TAG_DETYPE = "DETYPE";
    public static final String TAG_TABLENAME = "TABLENAME";
    public static final String TAG_MINORFIELDNAME = "MINORFIELDNAME";
    public static final String TAG_MINORFIELDVALUE = "MINORFIELDVALUE";
    public static final String TAG_MINORTABLENAME = "MINORTABLENAME";
    public static final String TAG_EXTABLENAME = "EXTABLENAME";
    public static final String TAG_ISLOGICVALID = "ISLOGICVALID";
    public static final String TAG_DEVERSION = "DEVERSION";
    public static final String TAG_SMALLICON = "SMALLICON";
    public static final String TAG_BIGICON = "BIGICON";
    public static final String TAG_DGMODEL = "DGMODEL";
    public static final String TAG_DGGEARS = "DGGEARS";
    public static final String TAG_DGTOOLBAR = "DGTOOLBAR";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_PAGESIZE = "PAGESIZE";
    public static final String TAG_AUTOEXPANDCOLUMN = "AUTOEXPANDCOLUMN";
    public static final String TAG_ISENABLEGROUP = "ISENABLEGROUP";
    public static final String TAG_GROUPCOLUMN = "GROUPCOLUMN";
    public static final String TAG_GROUPDIR = "GROUPDIR";
    public static final String TAG_FORCEFIT = "FORCEFIT";
    public static final String TAG_NOSORT = "NOSORT";
    public static final String TAG_FETCHTIMEOUT = "FETCHTIMEOUT";
    public static final String TAG_ROWBODYFIELD = "ROWBODYFIELD";
    public static final String TAG_ROWCLASSHELPER = "ROWCLASSHELPER";
    public static final String TAG_NODEFSORT = "NODEFSORT";
    public static final String TAG_DGCOLUMNWIDTH = "DGCOLUMNWIDTH";
    public static final String TAG_EXTDSITEM = "EXTDSITEM";
    public static final String TAG_ROWEXPANDER = "ROWEXPANDER";
    public static final String TAG_ROWEXPANDERPARAM = "ROWEXPANDERPARAM";
    public static final String TAG_DISTINCTMODE = "DISTINCTMODE";
    public static final String TAG_RENDERMODE = "RENDERMODE";
    public static final String TAG_MINORSORTFIELD = "MINORSORTFIELD";
    public static final String TAG_MINORSORTDIR = "MINORSORTDIR";
    public static final String TAG_LVSTYLE = "LVSTYLE";
    public static final String TAG_LVIDT = "LVIDT";
    public static final String TAG_MINORSORTMODE = "MINORSORTMODE";
    public static final String TAG_OPTIMIZEQUERY = "OPTIMIZEQUERY";
    public static final String TAG_OPTIMIZECOUNT = "OPTIMIZECOUNT";
    public static final String TAG_REALCNTRANGE = "REALCNTRANGE";
    public static final String TAG_MAXRECORD = "MAXRECORD";
    public static final String TAG_HIDEGROUPPANEL = "HIDEGROUPPANEL";
    public static final String TAG_HIDEGROUPCOLUMN = "HIDEGROUPCOLUMN";
    public static final String TAG_HIDEHEADER = "HIDEHEADER";
    public static final String TAG_ENABLEPAGING = "ENABLEPAGING";
    public static final String TAG_HIERARCHYDATA = "HIERARCHYDATA";
    public static final String TAG_CELLPANELID = "CELLPANELID";
    public static final String TAG_CELLPANELNAME = "CELLPANELNAME";
    public static final String TAG_CELLPANELPARAM = "CELLPANELPARAM";
    public static final String TAG_CELLPANELHEIGHT = "CELLPANELHEIGHT";
    public static final String TAG_CELLLONGPRESSEDIT = "CELLLONGPRESSEDIT";
    public static final String TAG_CELLSELMODE = "CELLSELMODE";
    public static final String TAG_CELLSELSTYLE = "CELLSELSTYLE";
    private DataGridModelConfig dataGridModelConfig = null;
    private ThreadLocal<Boolean> optimizeQueryMode = new ThreadLocal();

    public String getDATAGRIDID() {
        return this.GetParamStringValue(TAG_DATAGRIDID, "").trim();
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "").trim();
    }

    public String getDATAGRIDNAME() {
        return this.GetParamStringValue(TAG_DATAGRIDNAME, "");
    }

    public String getOWNERID() {
        return this.GetParamStringValue(TAG_OWNERID, "");
    }

    public String getCONFIGID() {
        return this.GetParamStringValue(TAG_CONFIGID, "");
    }

    public String getCONFIGPATH() {
        return this.GetParamStringValue(TAG_CONFIGPATH, "");
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getRESERVER() {
        return this.GetParamStringValue(TAG_RESERVER, "");
    }

    public String getDGMODE() {
        return this.GetParamStringValue(TAG_RESERVER, "");
    }

    public String getRESERVER2() {
        return this.GetParamStringValue(TAG_RESERVER2, "");
    }

    public String getSEARCHMODELPATH() {
        return this.GetParamStringValue(TAG_SEARCHMODELPATH, "");
    }

    public String getSEARCHPROC() {
        return this.GetParamStringValue(TAG_SEARCHPROC, "");
    }

    public String getBACKENDCTRL() {
        return this.GetParamStringValue(TAG_BACKENDCTRL, "");
    }

    public String getBACKENDCONFIG() {
        return this.GetParamStringValue(TAG_BACKENDCONFIG, "");
    }

    public String getCTRLOBJECT() {
        return this.GetParamStringValue(TAG_CTRLOBJECT, "");
    }

    public String getCTRLID() {
        return this.GetParamStringValue(TAG_CTRLID, "");
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public String getDELOGICNAME() {
        return this.GetParamStringValue(TAG_DELOGICNAME, "");
    }

    public String getTABLENAME() {
        return this.GetParamStringValue(TAG_TABLENAME, "");
    }

    public String getMINORFIELDNAME() {
        return this.GetParamStringValue(TAG_MINORFIELDNAME, "");
    }

    public String getMINORFIELDVALUE() {
        return this.GetParamStringValue(TAG_MINORFIELDVALUE, "");
    }

    public String getMINORTABLENAME() {
        return this.GetParamStringValue(TAG_MINORTABLENAME, "");
    }

    public String getEXTABLENAME() {
        return this.GetParamStringValue(TAG_EXTABLENAME, "");
    }

    public String getSMALLICON() {
        return this.GetParamStringValue(TAG_SMALLICON, "");
    }

    public String getBIGICON() {
        return this.GetParamStringValue(TAG_BIGICON, "");
    }

    public String getDGMODEL() {
        return this.GetParamStringValue(TAG_DGMODEL, "");
    }

    public String getDGGEARS() {
        return this.GetParamStringValue(TAG_DGGEARS, "");
    }

    public String getDGTOOLBAR() {
        return this.GetParamStringValue(TAG_DGTOOLBAR, "");
    }

    public String getAUTOEXPANDCOLUMN() {
        return this.GetParamStringValue(TAG_AUTOEXPANDCOLUMN, "");
    }

    public String getGROUPCOLUMN() {
        return this.GetParamStringValue(TAG_GROUPCOLUMN, "");
    }

    public String getGROUPDIR() {
        return this.GetParamStringValue(TAG_GROUPDIR, "");
    }

    public void setDATAGRIDID(String strValue) {
        this.SetParamValue(TAG_DATAGRIDID, strValue);
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public void setDATAGRIDNAME(String strValue) {
        this.SetParamValue(TAG_DATAGRIDNAME, strValue);
    }

    public void setOWNERID(String strValue) {
        this.SetParamValue(TAG_OWNERID, strValue);
    }

    public void setCONFIGID(String strValue) {
        this.SetParamValue(TAG_CONFIGID, strValue);
    }

    public void setCONFIGPATH(String strValue) {
        this.SetParamValue(TAG_CONFIGPATH, strValue);
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public void setRESERVER(String strValue) {
        this.SetParamValue(TAG_RESERVER, strValue);
    }

    public void setRESERVER2(String strValue) {
        this.SetParamValue(TAG_RESERVER2, strValue);
    }

    public void setSEARCHMODELPATH(String strValue) {
        this.SetParamValue(TAG_SEARCHMODELPATH, strValue);
    }

    public void setSEARCHPROC(String strValue) {
        this.SetParamValue(TAG_SEARCHPROC, strValue);
    }

    public void setBACKENDCTRL(String strValue) {
        this.SetParamValue(TAG_BACKENDCTRL, strValue);
    }

    public void setBACKENDCONFIG(String strValue) {
        this.SetParamValue(TAG_BACKENDCONFIG, strValue);
    }

    public void setCTRLOBJECT(String strValue) {
        this.SetParamValue(TAG_CTRLOBJECT, strValue);
    }

    public void setCTRLID(String strValue) {
        this.SetParamValue(TAG_CTRLID, strValue);
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public void setDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_DELOGICNAME, strValue);
    }

    public void setTABLENAME(String strValue) {
        this.SetParamValue(TAG_TABLENAME, strValue);
    }

    public void setMINORFIELDNAME(String strValue) {
        this.SetParamValue(TAG_MINORFIELDNAME, strValue);
    }

    public void setMINORFIELDVALUE(String strValue) {
        this.SetParamValue(TAG_MINORFIELDVALUE, strValue);
    }

    public void setMINORTABLENAME(String strValue) {
        this.SetParamValue(TAG_MINORTABLENAME, strValue);
    }

    public void setEXTABLENAME(String strValue) {
        this.SetParamValue(TAG_EXTABLENAME, strValue);
    }

    public void setSMALLICON(String strValue) {
        this.SetParamValue(TAG_SMALLICON, strValue);
    }

    public void setBIGICON(String strValue) {
        this.SetParamValue(TAG_BIGICON, strValue);
    }

    public void setDGMODEL(String strValue) {
        this.SetParamValue(TAG_DGMODEL, strValue);
    }

    public void setDGGEARS(String strValue) {
        this.SetParamValue(TAG_DGGEARS, strValue);
    }

    public void setDGTOOLBAR(String strValue) {
        this.SetParamValue(TAG_DGTOOLBAR, strValue);
    }

    public int getDGVERSION() {
        return this.GetParamIntValue(TAG_DGVERSION, 0);
    }

    public int getPAGESIZE() {
        return this.GetParamIntValue(TAG_PAGESIZE, 20);
    }

    public void setDGVERSION(int nValue) {
        this.SetParamValue(TAG_DGVERSION, nValue);
    }

    public boolean isISMAJOR() {
        return this.GetParamIntValue(TAG_ISMAJOR, 0) == 1;
    }

    public boolean isISLOGICVALID() {
        return this.GetParamIntValue(TAG_ISLOGICVALID, 0) == 1;
    }

    public boolean isENABLEGROUP() {
        return this.GetParamIntValue(TAG_ISENABLEGROUP, 0) == 1;
    }

    public boolean isFORCEFIT() {
        return this.GetParamIntValue(TAG_FORCEFIT, 0) == 1;
    }

    public void setISMAJOR(boolean bValue) {
        this.SetParamValue(TAG_ISMAJOR, bValue ? 1 : 0);
    }

    public int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 100);
    }

    public boolean getNOSORT() {
        return this.GetParamIntValue(TAG_NOSORT, 0) == 1;
    }

    public void setNOSORT(boolean bValue) {
        this.SetParamValue(TAG_NOSORT, bValue ? 1 : 0);
    }

    public int getFETCHTIMEOUT() {
        return this.GetParamIntValue(TAG_FETCHTIMEOUT, 0);
    }

    public void setFETCHTIMEOUT(int strValue) {
        this.SetParamValue(TAG_FETCHTIMEOUT, strValue);
    }

    public String getROWBODYFIELD() {
        return this.GetParamStringValue(TAG_ROWBODYFIELD, "");
    }

    public void setROWBODYFIELD(String strValue) {
        this.SetParamValue(TAG_ROWBODYFIELD, strValue);
    }

    public String getROWCLASSHELPER() {
        return this.GetParamStringValue(TAG_ROWCLASSHELPER, "");
    }

    public void setROWCLASSHELPER(String strValue) {
        this.SetParamValue(TAG_ROWCLASSHELPER, strValue);
    }

    public boolean getNODEFSORT() {
        return this.GetParamIntValue(TAG_NODEFSORT, 0) == 1;
    }

    public void setNODEFSORT(boolean bValue) {
        this.SetParamValue(TAG_NODEFSORT, bValue ? 1 : 0);
    }

    public int getDGCOLUMNWIDTH() {
        return this.GetParamIntValue(TAG_DGCOLUMNWIDTH, 0);
    }

    public void setDGCOLUMNWIDTH(int strValue) {
        this.SetParamValue(TAG_DGCOLUMNWIDTH, strValue);
    }

    public String getEXTDSITEM() {
        return this.GetParamStringValue(TAG_EXTDSITEM, "");
    }

    public void setEXTDSITEM(String strValue) {
        this.SetParamValue(TAG_EXTDSITEM, strValue);
    }

    public boolean getROWEXPANDER() {
        return this.GetParamIntValue(TAG_ROWEXPANDER, 0) == 1;
    }

    public void setROWEXPANDER(boolean bValue) {
        this.SetParamValue(TAG_ROWEXPANDER, bValue ? 1 : 0);
    }

    public String getROWEXPANDERPARAM() {
        return this.GetParamStringValue(TAG_ROWEXPANDERPARAM, "");
    }

    public void setROWEXPANDERPARAM(String strValue) {
        this.SetParamValue(TAG_ROWEXPANDERPARAM, strValue);
    }

    public boolean getDISTINCTMODE() {
        return this.GetParamIntValue(TAG_DISTINCTMODE, 0) == 1;
    }

    public void setDISTINCTMODE(boolean bValue) {
        this.SetParamValue(TAG_DISTINCTMODE, bValue ? 1 : 0);
    }

    public boolean isRENDERMODENull() {
        return this.IsParamNull(TAG_RENDERMODE);
    }

    public String getRENDERMODE() {
        return this.GetParamStringValue(TAG_RENDERMODE, "");
    }

    public void setRENDERMODE(String strValue) {
        this.SetParamValue(TAG_RENDERMODE, strValue);
    }

    public final boolean isMINORSORTFIELDNull() {
        return this.IsParamNull(TAG_MINORSORTFIELD);
    }

    public final String getMINORSORTFIELD() {
        return this.GetParamStringValue(TAG_MINORSORTFIELD, "");
    }

    public final void setMINORSORTFIELD(String strValue) {
        this.SetParamValue(TAG_MINORSORTFIELD, strValue);
    }

    public final boolean isMINORSORTDIRNull() {
        return this.IsParamNull(TAG_MINORSORTDIR);
    }

    public final String getMINORSORTDIR() {
        return this.GetParamStringValue(TAG_MINORSORTDIR, "");
    }

    public final void setMINORSORTDIR(String strValue) {
        this.SetParamValue(TAG_MINORSORTDIR, strValue);
    }

    public final boolean isLVSTYLENull() {
        return this.IsParamNull(TAG_LVSTYLE);
    }

    public final String getLVSTYLE() {
        return this.GetParamStringValue(TAG_LVSTYLE, "");
    }

    public final void setLVSTYLE(String strValue) {
        this.SetParamValue(TAG_LVSTYLE, strValue);
    }

    public final boolean isLVIDTNull() {
        return this.IsParamNull(TAG_LVIDT);
    }

    public final String getLVIDT() {
        return this.GetParamStringValue(TAG_LVIDT, "");
    }

    public final void setLVIDT(String strValue) {
        this.SetParamValue(TAG_LVIDT, strValue);
    }

    public final boolean isMINORSORTMODENull() {
        return this.IsParamNull(TAG_MINORSORTMODE);
    }

    public final String getMINORSORTMODE() {
        return this.GetParamStringValue(TAG_MINORSORTMODE, "");
    }

    public final void setMINORSORTMODE(String strValue) {
        this.SetParamValue(TAG_MINORSORTMODE, strValue);
    }

    public final boolean isOPTIMIZEQUERYNull() {
        return this.IsParamNull(TAG_OPTIMIZEQUERY);
    }

    public final boolean getOPTIMIZEQUERY() {
        return this.GetParamIntValue(TAG_OPTIMIZEQUERY, 0) == 1;
    }

    public final void setOPTIMIZEQUERY(boolean bValue) {
        this.SetParamValue(TAG_OPTIMIZEQUERY, bValue ? 1 : 0);
    }

    public final boolean isOPTIMIZECOUNTNull() {
        return this.IsParamNull(TAG_OPTIMIZECOUNT);
    }

    public final boolean getOPTIMIZECOUNT() {
        return this.GetParamIntValue(TAG_OPTIMIZECOUNT, 0) == 1;
    }

    public final void setOPTIMIZECOUNT(boolean bValue) {
        this.SetParamValue(TAG_OPTIMIZECOUNT, bValue ? 1 : 0);
    }

    public final boolean isREALCNTRANGENull() {
        return this.IsParamNull(TAG_REALCNTRANGE);
    }

    public final int getREALCNTRANGE() {
        return this.GetParamIntValue(TAG_REALCNTRANGE, 0);
    }

    public final void setREALCNTRANGE(int nValue) {
        this.SetParamValue(TAG_REALCNTRANGE, nValue);
    }

    public final boolean isMAXRECORDNull() {
        return this.IsParamNull(TAG_MAXRECORD);
    }

    public final int getMAXRECORD() {
        return this.GetParamIntValue(TAG_MAXRECORD, 0);
    }

    public final void setMAXRECORD(int nValue) {
        this.SetParamValue(TAG_MAXRECORD, nValue);
    }

    public final boolean isHIDEGROUPPANELNull() {
        return this.IsParamNull(TAG_HIDEGROUPPANEL);
    }

    public final boolean getHIDEGROUPPANEL() {
        return this.GetParamIntValue(TAG_HIDEGROUPPANEL, 0) == 1;
    }

    public final void setHIDEGROUPPANEL(boolean bValue) {
        this.SetParamValue(TAG_HIDEGROUPPANEL, bValue ? 1 : 0);
    }

    public final boolean isHIDEGROUPCOLUMNNull() {
        return this.IsParamNull(TAG_HIDEGROUPCOLUMN);
    }

    public final boolean getHIDEGROUPCOLUMN() {
        return this.GetParamIntValue(TAG_HIDEGROUPCOLUMN, 0) == 1;
    }

    public final void setHIDEGROUPCOLUMN(boolean bValue) {
        this.SetParamValue(TAG_HIDEGROUPCOLUMN, bValue ? 1 : 0);
    }

    public final boolean isHIDEHEADERNull() {
        return this.IsParamNull(TAG_HIDEHEADER);
    }

    public final boolean getHIDEHEADER() {
        return this.GetParamIntValue(TAG_HIDEHEADER, 0) == 1;
    }

    public final void setHIDEHEADER(boolean bValue) {
        this.SetParamValue(TAG_HIDEHEADER, bValue ? 1 : 0);
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

    public final boolean isHIERARCHYDATANull() {
        return this.IsParamNull(TAG_HIERARCHYDATA);
    }

    public final String getHIERARCHYDATA() {
        return this.GetParamStringValue(TAG_HIERARCHYDATA, "");
    }

    public final void setHIERARCHYDATA(String strValue) {
        this.SetParamValue(TAG_HIERARCHYDATA, strValue);
    }

    public final boolean isCELLPANELIDNull() {
        return this.IsParamNull(TAG_CELLPANELID);
    }

    public final String getCELLPANELID() {
        return this.GetParamStringValue(TAG_CELLPANELID, "");
    }

    public final void setCELLPANELID(String strValue) {
        this.SetParamValue(TAG_CELLPANELID, strValue);
    }

    public final boolean isCELLPANELNAMENull() {
        return this.IsParamNull(TAG_CELLPANELNAME);
    }

    public final String getCELLPANELNAME() {
        return this.GetParamStringValue(TAG_CELLPANELNAME, "");
    }

    public final void setCELLPANELNAME(String strValue) {
        this.SetParamValue(TAG_CELLPANELNAME, strValue);
    }

    public final boolean isCELLPANELPARAMNull() {
        return this.IsParamNull(TAG_CELLPANELPARAM);
    }

    public final String getCELLPANELPARAM() {
        return this.GetParamStringValue(TAG_CELLPANELPARAM, "");
    }

    public final void setCELLPANELPARAM(String strValue) {
        this.SetParamValue(TAG_CELLPANELPARAM, strValue);
    }

    public final boolean isCELLPANELHEIGHTNull() {
        return this.IsParamNull(TAG_CELLPANELHEIGHT);
    }

    public final int getCELLPANELHEIGHT() {
        return this.GetParamIntValue(TAG_CELLPANELHEIGHT, 0);
    }

    public final void setCELLPANELHEIGHT(int nValue) {
        this.SetParamValue(TAG_CELLPANELHEIGHT, nValue);
    }

    public final boolean isCELLLONGPRESSEDITNull() {
        return this.IsParamNull(TAG_CELLLONGPRESSEDIT);
    }

    public final boolean getCELLLONGPRESSEDIT() {
        return this.GetParamIntValue(TAG_CELLLONGPRESSEDIT, 0) == 1;
    }

    public final void setCELLLONGPRESSEDIT(boolean bValue) {
        this.SetParamValue(TAG_CELLLONGPRESSEDIT, bValue ? 1 : 0);
    }

    public final boolean isCELLSELMODENull() {
        return this.IsParamNull(TAG_CELLSELMODE);
    }

    public final String getCELLSELMODE() {
        return this.GetParamStringValue(TAG_CELLSELMODE, "");
    }

    public final void setCELLSELMODE(String strValue) {
        this.SetParamValue(TAG_CELLSELMODE, strValue);
    }

    public final boolean isCELLSELSTYLENull() {
        return this.IsParamNull(TAG_CELLSELSTYLE);
    }

    public final String getCELLSELSTYLE() {
        return this.GetParamStringValue(TAG_CELLSELSTYLE, "");
    }

    public final void setCELLSELSTYLE(String strValue) {
        this.SetParamValue(TAG_CELLSELSTYLE, strValue);
    }

    public DataGridModelConfig getDataGridModelConfig() {
        if (this.dataGridModelConfig != null) {
            return this.dataGridModelConfig;
        }
        String strDGModelXML = this.getDGMODEL();
        if (StringHelper.Length((String)strDGModelXML) > 0) {
            this.dataGridModelConfig = new DataGridModelConfig();
            if (!XMLConfig.LoadFromXML((String)strDGModelXML, (XMLConfig)this.dataGridModelConfig)) {
                this.dataGridModelConfig = new DataGridModelConfig();
            }
        } else {
            this.dataGridModelConfig = new DataGridModelConfig();
        }
        this.dataGridModelConfig.setPageSize(this.getPAGESIZE());
        return this.dataGridModelConfig;
    }

    public void setOptimizeQueryMode(boolean bOptimizeQueryMode) {
        this.optimizeQueryMode.set(bOptimizeQueryMode);
    }

    public boolean getOptimizeQueryMode() {
        if (this.optimizeQueryMode.get() == null) {
            return false;
        }
        return this.optimizeQueryMode.get();
    }
}

