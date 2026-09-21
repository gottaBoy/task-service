/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Ctrl.BaseDEDCEngine;
import SA.SRFDA.Ctrl.Data.DEDataCtrl;
import SA.SRFDA.Ctrl.Data.PageLogic;
import SA.SRFDA.Security.UniResHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

public class Page
extends BaseDataEntity {
    public static final String PAGETYPE_EDITVIEW = "EDITVIEW";
    public static final String PAGETYPE_GRIDVIEW = "GRIDVIEW";
    public static final String PAGETYPE_TREEVIEW = "TREEVIEW";
    public static final int TAG_PAGETYPE_EDIT = 1;
    public static final int TAG_PAGETYPE_GRID = 2;
    public static final int TAG_PAGETYPE_PICKUP = 3;
    public static final int TAG_PAGETYPE_WFINFO = 4;
    public static final int TAG_PAGETYPE_WFGRID = 5;
    public static final int TAG_PAGETYPE_WFMGRGRID = 6;
    public static final String PAGEFUNC_INHERIT = "INHERIT";
    public static final String PAGEFUNC_DEFAULT = "DEFAULT";
    public static final String PAGEFUNC_CUSTOM = "CUSTOM";
    public static final String TAG_PAGEID = "PAGEID";
    public static final String TAG_PAGENAME = "PAGENAME";
    public static final String TAG_PAGETYPE = "PAGETYPE";
    public static final String TAG_PAGEPATH = "PAGEPATH";
    public static final String TAG_PAGEHEADER = "PAGEHEADER";
    public static final String TAG_PAGESCRIPT = "PAGESCRIPT";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_ISMODELSTYLE = "ISMODELSTYLE";
    public static final String TAG_WINDOWSTYLE = "WINDOWSTYLE";
    public static final String TAG_WTPARAM = "WTPARAM";
    public static final String TAG_PAGEPARAM = "PAGEPARAM";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_PTPAGEPATH = "PTPAGEPATH";
    public static final String TAG_PTPAGEPARAM = "PTPAGEPARAM";
    public static final String TAG_PTVERSION = "PTVERSION";
    public static final String TAG_PTTOOLBAR = "PTTOOLBAR";
    public static final String TAG_PTPAGEFUNC = "PTPAGEFUNC";
    public static final String TAG_PAGEFUNC = "PAGEFUNC";
    public static final String TAG_TOOLBAR = "TOOLBAR";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_PAGEOBJECT = "PAGEOBJECT";
    public static final String TAG_USERMODE = "USERMODE";
    public static final String TAG_RESOURCEID = "RESOURCEID";
    public static final String TAG_RESTYPE = "RESTYPE";
    public static final String TAG_RESDATAACTION = "RESDATAACTION";
    public static final String TAG_RESTYPE_NONE = "NONE";
    public static final String TAG_RESTYPE_DEDATA = "DEDATA";
    public static final String TAG_RESTYPE_PAGE = "PAGE";
    public static final String TAG_RESTYPE_CUSTOM = "CUSTOM";
    public static final String TAG_PAGEFUNCTYPE = "PAGEFUNCTYPE";
    public static final String TAG_PAGEFUNC2 = "PAGEFUNC2";
    public static final String TAG_ENABLEADVPAGEPARAM = "ENABLEADVPAGEPARAM";
    public static final String TAG_PAGETEMPLID = "PAGETEMPLID";
    public static final String TAG_PAGETEMPLNAME = "PAGETEMPLNAME";
    public static final String TAG_TOOLBARID = "TOOLBARID";
    public static final String TAG_TOOLBARNAME = "TOOLBARNAME";
    public static final String TAG_SLUIPART = "SLUIPART";
    public static final String TAG_PAGEHELPER = "PAGEHELPER";
    public static final String TAG_APPENDPARAM = "APPENDPARAM";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_SRFSYSPUB = "SRFSYSPUB";
    public static final String TAG_SRFUSERPUB = "SRFUSERPUB";
    public static final String TAG_SEARCHFORMID = "SEARCHFORMID";
    public static final String TAG_SEARCHFORMNAME = "SEARCHFORMNAME";
    public static final String TAG_FORMID = "FORMID";
    public static final String TAG_FORMNAME = "FORMNAME";
    public static final String TAG_DATAGRIDID = "DATAGRIDID";
    public static final String TAG_DATAGRIDNAME = "DATAGRIDNAME";
    public static final String TAG_TREEVIEWID = "TREEVIEWID";
    public static final String TAG_TREEVIEWNAME = "TREEVIEWNAME";
    public static final String TAG_QUERYMODELID = "QUERYMODELID";
    public static final String TAG_QUERYMODELNAME = "QUERYMODELNAME";
    public static final String TAG_PAGETITLE = "PAGETITLE";
    public static final String TAG_TITLELANRESID = "TITLELANRESID";
    public static final String TAG_TITLELANRESNAME = "TITLELANRESNAME";
    private Hashtable<String, BaseDataEntity> pageParamMap = null;
    private Properties wtProperties = null;
    private Properties pageProperties = null;
    private Hashtable<String, DEDataCtrl> pageLogicMap = null;
    private Hashtable<String, String> userModeMap = null;

    public static int ParsePageType(String strPageType) {
        if (StringHelper.Compare((String)strPageType, (String)PAGETYPE_EDITVIEW, (boolean)true) == 0) {
            return 1;
        }
        if (StringHelper.Compare((String)strPageType, (String)PAGETYPE_GRIDVIEW, (boolean)true) == 0) {
            return 2;
        }
        if (StringHelper.Compare((String)strPageType, (String)"PICKUPVIEW", (boolean)true) == 0) {
            return 3;
        }
        if (StringHelper.Compare((String)strPageType, (String)"WFINFOVIEW", (boolean)true) == 0) {
            return 4;
        }
        if (StringHelper.Compare((String)strPageType, (String)"WFGRIDVIEW", (boolean)true) == 0) {
            return 5;
        }
        if (StringHelper.Compare((String)strPageType, (String)"WFMGRGRIDVIEW", (boolean)true) == 0) {
            return 6;
        }
        return 1;
    }

    public String getPAGEID() {
        return this.GetParamStringValue(TAG_PAGEID, "").trim();
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "").trim();
    }

    public String getPAGENAME() {
        return this.GetParamStringValue(TAG_PAGENAME, "");
    }

    public String getPAGEPATH() {
        String strPTPagePath = this.getPTPAGEPATH();
        if (!StringHelper.IsNullOrEmpty((String)strPTPagePath)) {
            return strPTPagePath;
        }
        return this.GetParamStringValue(TAG_PAGEPATH, "");
    }

    public String GetTotalPagePath() {
        String strPagePath = this.getPAGEPATH();
        if (StringHelper.IsNullOrEmpty((String)strPagePath)) {
            return strPagePath;
        }
        strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
        strPagePath = String.valueOf(strPagePath) + "SRFPAGEID=";
        strPagePath = String.valueOf(strPagePath) + this.getPAGEID();
        return strPagePath;
    }

    public String getRESTYPE() {
        return this.GetParamStringValue(TAG_RESTYPE, "");
    }

    public String getRESDATAACTION() {
        return this.GetParamStringValue(TAG_RESDATAACTION, "READ");
    }

    public String getRESOURCEID(String strOutsideDEId) {
        return Page.getRESOURCEID(this, strOutsideDEId);
    }

    private static String getRESOURCEID(Page page, String strOutsideDEId) {
        String strResType = page.getRESTYPE();
        if (StringHelper.Compare((String)strResType, (String)TAG_RESTYPE_DEDATA, (boolean)true) == 0) {
            String strDEId = page.getDEID();
            if (StringHelper.IsNullOrEmpty((String)strDEId)) {
                strDEId = strOutsideDEId;
            }
            if (!StringHelper.IsNullOrEmpty((String)strDEId)) {
                return UniResHelper.GetDEDataResId(strDEId, page.getRESDATAACTION());
            }
            return "";
        }
        if (StringHelper.Compare((String)strResType, (String)TAG_RESTYPE_PAGE, (boolean)true) == 0) {
            return UniResHelper.GetPageResId(page.getPAGEID());
        }
        if (StringHelper.Compare((String)strResType, (String)"CUSTOM", (boolean)true) == 0) {
            return page.GetParamStringValue(TAG_RESOURCEID, "");
        }
        return TAG_RESTYPE_NONE;
    }

    public String getPTPAGEPATH() {
        return this.GetParamStringValue(TAG_PTPAGEPATH, "");
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

    public String getRESERVER2() {
        return this.GetParamStringValue(TAG_RESERVER2, "");
    }

    public String getWINDOWSTYLE() {
        return this.GetParamStringValue(TAG_WINDOWSTYLE, "");
    }

    public String getWTPARAM() {
        return this.GetParamStringValue(TAG_WTPARAM, "");
    }

    public String getPAGEPARAM() {
        return this.GetParamStringValue(TAG_PAGEPARAM, "");
    }

    public String getPTPAGEPARAM() {
        return this.GetParamStringValue(TAG_PTPAGEPARAM, "");
    }

    public String getPTTOOLBAR() {
        return this.GetParamStringValue(TAG_PTTOOLBAR, "");
    }

    public String getTOOLBAR() {
        return this.GetParamStringValue(TAG_TOOLBAR, "");
    }

    public String getPAGEOBJECT() {
        return this.GetParamStringValue(TAG_PAGEOBJECT, "");
    }

    public String getUSERMODE() {
        return this.GetParamStringValue(TAG_USERMODE, "");
    }

    public String getPAGEHEADER() {
        return this.GetParamStringValue(TAG_PAGEHEADER, "");
    }

    public String getPAGESCRIPT() {
        return this.GetParamStringValue(TAG_PAGESCRIPT, "");
    }

    public void setPAGEID(String strValue) {
        this.SetParamValue(TAG_PAGEID, strValue);
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public void setPAGENAME(String strValue) {
        this.SetParamValue(TAG_PAGENAME, strValue);
    }

    public void setPAGEPATH(String strValue) {
        this.SetParamValue(TAG_PAGEPATH, strValue);
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

    public void setWINDOWSTYLE(String strValue) {
        this.SetParamValue(TAG_WINDOWSTYLE, strValue);
    }

    public void setPTTOOLBAR(String strValue) {
        this.SetParamValue(TAG_PTTOOLBAR, strValue);
    }

    public boolean isSYSTEM() {
        return this.GetParamIntValue(TAG_ISSYSTEM, 0) == 1;
    }

    public boolean isMODALSTYLE() {
        return this.GetParamIntValue(TAG_ISMODELSTYLE, 0) == 1;
    }

    public void setMODELSTYLE(boolean value) {
        this.SetParamValue(TAG_ISMODELSTYLE, value ? 1 : 0);
    }

    public int getPAGETYPE() {
        return this.GetParamIntValue(TAG_PAGETYPE, 0);
    }

    public int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public void setPAGETYPE(int nValue) {
        this.SetParamValue(TAG_PAGETYPE, nValue);
    }

    public void setWIDTH(int nValue) {
        this.SetParamValue(TAG_WIDTH, nValue);
    }

    public void setHEIGHT(int nValue) {
        this.SetParamValue(TAG_HEIGHT, nValue);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 1);
    }

    public void setVERSION(int nValue) {
        this.SetParamValue(TAG_VERSION, nValue);
    }

    public int getPTVERSION() {
        return this.GetParamIntValue(TAG_PTVERSION, 1);
    }

    public void setPTVERSION(int nValue) {
        this.SetParamValue(TAG_PTVERSION, nValue);
    }

    public int getPTPAGEFUNC() {
        return this.GetParamIntValue(TAG_PTPAGEFUNC, 0);
    }

    public int getPAGEFUNC() {
        return this.GetParamIntValue(TAG_PAGEFUNC, 0);
    }

    public boolean getENABLEADVPAGEPARAM() {
        return this.GetParamIntValue(TAG_ENABLEADVPAGEPARAM, 0) == 1;
    }

    public void setENABLEADVPAGEPARAM(boolean bValue) {
        this.SetParamValue(TAG_ENABLEADVPAGEPARAM, bValue ? 1 : 0);
    }

    public String getPAGEFUNCTYPE() {
        return this.GetParamStringValue(TAG_PAGEFUNCTYPE, "");
    }

    public void setPAGEFUNCTYPE(String strValue) {
        this.SetParamValue(TAG_PAGEFUNCTYPE, strValue);
    }

    public String getPAGEFUNC2() {
        return this.GetParamStringValue(TAG_PAGEFUNC2, "");
    }

    public void setPAGEFUNC2(String strValue) {
        this.SetParamValue(TAG_PAGEFUNC2, strValue);
    }

    public boolean isISMODELSTYLENull() {
        return this.IsParamNull(TAG_ISMODELSTYLE);
    }

    public boolean getISMODELSTYLE() {
        return this.GetParamIntValue(TAG_ISMODELSTYLE, 0) == 1;
    }

    public void setISMODELSTYLE(boolean bValue) {
        this.SetParamValue(TAG_ISMODELSTYLE, bValue ? 1 : 0);
    }

    public boolean isAPPENDPARAMNull() {
        return this.IsParamNull(TAG_APPENDPARAM);
    }

    public String getAPPENDPARAM() {
        return this.GetParamStringValue(TAG_APPENDPARAM, "");
    }

    public void setAPPENDPARAM(String strValue) {
        this.SetParamValue(TAG_APPENDPARAM, strValue);
    }

    public boolean isRESOURCEIDNull() {
        return this.IsParamNull(TAG_RESOURCEID);
    }

    public String getRESOURCEID() {
        return this.GetParamStringValue(TAG_RESOURCEID, "");
    }

    public void setRESOURCEID(String strValue) {
        this.SetParamValue(TAG_RESOURCEID, strValue);
    }

    public String getPAGETEMPLID() {
        return this.GetParamStringValue(TAG_PAGETEMPLID, "");
    }

    public void setPAGETEMPLID(String strValue) {
        this.SetParamValue(TAG_PAGETEMPLID, strValue);
    }

    public String getPAGETEMPLNAME() {
        return this.GetParamStringValue(TAG_PAGETEMPLNAME, "");
    }

    public void setPAGETEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PAGETEMPLNAME, strValue);
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

    public int getRealPageFunc() {
        int nTotal = this.getPTPAGEFUNC() | this.getPAGEFUNC();
        if (nTotal == 0) {
            return Integer.MAX_VALUE;
        }
        return nTotal | 1;
    }

    public String getTOOLBARID() {
        return this.GetParamStringValue(TAG_TOOLBARID, "");
    }

    public void setTOOLBARID(String strValue) {
        this.SetParamValue(TAG_TOOLBARID, strValue);
    }

    public String getTOOLBARNAME() {
        return this.GetParamStringValue(TAG_TOOLBARNAME, "");
    }

    public void setTOOLBARNAME(String strValue) {
        this.SetParamValue(TAG_TOOLBARNAME, strValue);
    }

    public String getSLUIPART() {
        return this.GetParamStringValue(TAG_SLUIPART, "");
    }

    public void setSLUIPART(String strValue) {
        this.SetParamValue(TAG_SLUIPART, strValue);
    }

    public boolean isPAGEHELPERNull() {
        return this.IsParamNull(TAG_PAGEHELPER);
    }

    public String getPAGEHELPER() {
        return this.GetParamStringValue(TAG_PAGEHELPER, "");
    }

    public void setPAGEHELPER(String strValue) {
        this.SetParamValue(TAG_PAGEHELPER, strValue);
    }

    public final boolean isSRFSYSPUBNull() {
        return this.IsParamNull(TAG_SRFSYSPUB);
    }

    public final boolean getSRFSYSPUB() {
        return this.GetParamIntValue(TAG_SRFSYSPUB, 0) == 1;
    }

    public final void setSRFSYSPUB(boolean bValue) {
        this.SetParamValue(TAG_SRFSYSPUB, bValue ? 1 : 0);
    }

    public final boolean isSRFUSERPUBNull() {
        return this.IsParamNull(TAG_SRFUSERPUB);
    }

    public final boolean getSRFUSERPUB() {
        return this.GetParamIntValue(TAG_SRFUSERPUB, 0) == 1;
    }

    public final void setSRFUSERPUB(boolean bValue) {
        this.SetParamValue(TAG_SRFUSERPUB, bValue ? 1 : 0);
    }

    public final boolean isSEARCHFORMIDNull() {
        return this.IsParamNull(TAG_SEARCHFORMID);
    }

    public final String getSEARCHFORMID() {
        return this.GetParamStringValue(TAG_SEARCHFORMID, "");
    }

    public final void setSEARCHFORMID(String strValue) {
        this.SetParamValue(TAG_SEARCHFORMID, strValue);
    }

    public final boolean isSEARCHFORMNAMENull() {
        return this.IsParamNull(TAG_SEARCHFORMNAME);
    }

    public final String getSEARCHFORMNAME() {
        return this.GetParamStringValue(TAG_SEARCHFORMNAME, "");
    }

    public final void setSEARCHFORMNAME(String strValue) {
        this.SetParamValue(TAG_SEARCHFORMNAME, strValue);
    }

    public final boolean isFORMIDNull() {
        return this.IsParamNull(TAG_FORMID);
    }

    public final String getFORMID() {
        return this.GetParamStringValue(TAG_FORMID, "");
    }

    public final void setFORMID(String strValue) {
        this.SetParamValue(TAG_FORMID, strValue);
    }

    public final boolean isFORMNAMENull() {
        return this.IsParamNull(TAG_FORMNAME);
    }

    public final String getFORMNAME() {
        return this.GetParamStringValue(TAG_FORMNAME, "");
    }

    public final void setFORMNAME(String strValue) {
        this.SetParamValue(TAG_FORMNAME, strValue);
    }

    public final boolean isDATAGRIDIDNull() {
        return this.IsParamNull(TAG_DATAGRIDID);
    }

    public final String getDATAGRIDID() {
        return this.GetParamStringValue(TAG_DATAGRIDID, "");
    }

    public final void setDATAGRIDID(String strValue) {
        this.SetParamValue(TAG_DATAGRIDID, strValue);
    }

    public final boolean isDATAGRIDNAMENull() {
        return this.IsParamNull(TAG_DATAGRIDNAME);
    }

    public final String getDATAGRIDNAME() {
        return this.GetParamStringValue(TAG_DATAGRIDNAME, "");
    }

    public final void setDATAGRIDNAME(String strValue) {
        this.SetParamValue(TAG_DATAGRIDNAME, strValue);
    }

    public final boolean isTREEVIEWIDNull() {
        return this.IsParamNull(TAG_TREEVIEWID);
    }

    public final String getTREEVIEWID() {
        return this.GetParamStringValue(TAG_TREEVIEWID, "");
    }

    public final void setTREEVIEWID(String strValue) {
        this.SetParamValue(TAG_TREEVIEWID, strValue);
    }

    public final boolean isTREEVIEWNAMENull() {
        return this.IsParamNull(TAG_TREEVIEWNAME);
    }

    public final String getTREEVIEWNAME() {
        return this.GetParamStringValue(TAG_TREEVIEWNAME, "");
    }

    public final void setTREEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_TREEVIEWNAME, strValue);
    }

    public final boolean isQUERYMODELIDNull() {
        return this.IsParamNull(TAG_QUERYMODELID);
    }

    public final String getQUERYMODELID() {
        return this.GetParamStringValue(TAG_QUERYMODELID, "");
    }

    public final void setQUERYMODELID(String strValue) {
        this.SetParamValue(TAG_QUERYMODELID, strValue);
    }

    public final boolean isQUERYMODELNAMENull() {
        return this.IsParamNull(TAG_QUERYMODELNAME);
    }

    public final String getQUERYMODELNAME() {
        return this.GetParamStringValue(TAG_QUERYMODELNAME, "");
    }

    public final void setQUERYMODELNAME(String strValue) {
        this.SetParamValue(TAG_QUERYMODELNAME, strValue);
    }

    public final boolean isPAGETITLENull() {
        return this.IsParamNull(TAG_PAGETITLE);
    }

    public final String getPAGETITLE() {
        return this.GetParamStringValue(TAG_PAGETITLE, "");
    }

    public final void setPAGETITLE(String strValue) {
        this.SetParamValue(TAG_PAGETITLE, strValue);
    }

    public final boolean isTITLELANRESIDNull() {
        return this.IsParamNull(TAG_TITLELANRESID);
    }

    public final String getTITLELANRESID() {
        return this.GetParamStringValue(TAG_TITLELANRESID, "");
    }

    public final void setTITLELANRESID(String strValue) {
        this.SetParamValue(TAG_TITLELANRESID, strValue);
    }

    public final boolean isTITLELANRESNAMENull() {
        return this.IsParamNull(TAG_TITLELANRESNAME);
    }

    public final String getTITLELANRESNAME() {
        return this.GetParamStringValue(TAG_TITLELANRESNAME, "");
    }

    public final void setTITLELANRESNAME(String strValue) {
        this.SetParamValue(TAG_TITLELANRESNAME, strValue);
    }

    public void BuildProperties() {
        try {
            String strPageUserMode = this.getUSERMODE();
            strPageUserMode = strPageUserMode.trim();
            if (!StringHelper.IsNullOrEmpty((String)strPageUserMode)) {
                this.userModeMap = new Hashtable();
                strPageUserMode = strPageUserMode.replace(";", "|");
                String[] usermodes = strPageUserMode.split("[|]");
                int i = 0;
                while (i < usermodes.length) {
                    this.userModeMap.put(usermodes[i].toUpperCase(), "");
                    ++i;
                }
            }
            String strWTParam = this.getWTPARAM();
            String strPageParam = "";
            if (!StringHelper.IsNullOrEmpty((String)this.getPTPAGEPARAM())) {
                strPageParam = this.getPTPAGEPARAM();
            }
            if (!StringHelper.IsNullOrEmpty((String)this.getPAGEPARAM())) {
                if (!StringHelper.IsNullOrEmpty((String)strPageParam)) {
                    strPageParam = String.valueOf(strPageParam) + "\r\n";
                }
                strPageParam = String.valueOf(strPageParam) + this.getPAGEPARAM();
            }
            if (!StringHelper.IsNullOrEmpty((String)strWTParam)) {
                this.wtProperties = new Properties();
                this.wtProperties = PropertiesHelper.Load((Properties)this.wtProperties, (String)strWTParam);
            }
            if (!StringHelper.IsNullOrEmpty((String)strPageParam)) {
                this.pageProperties = new Properties();
                this.pageProperties = PropertiesHelper.Load((Properties)this.pageProperties, (String)strPageParam);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Properties getWTProperties() {
        return this.wtProperties;
    }

    public Properties getPAGEProperties() {
        return this.pageProperties;
    }

    public String GetPageProperty(String strName, String strDefault) {
        if (this.getPAGEProperties() == null) {
            return strDefault;
        }
        String strValue = PropertiesHelper.GetProperty((Properties)this.getPAGEProperties(), (String)strName);
        if (strValue == null) {
            return strDefault;
        }
        return strValue;
    }

    public boolean GetPageProperty(String strName, boolean bDefault) {
        if (this.getPAGEProperties() == null) {
            return bDefault;
        }
        String strValue = PropertiesHelper.GetProperty((Properties)this.getPAGEProperties(), (String)strName);
        if (strValue == null) {
            return bDefault;
        }
        return StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) == 0;
    }

    public int GetPageProperty(String strName, int nDefault) {
        if (this.getPAGEProperties() == null) {
            return nDefault;
        }
        String strValue = PropertiesHelper.GetProperty((Properties)this.getPAGEProperties(), (String)strName);
        if (strValue == null) {
            return nDefault;
        }
        try {
            return Integer.parseInt(strValue);
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    public void BuildPageLogics(ISRFDAGlobalHelper iDAGlobalHelper, Vector<PageLogic> pageLogics) {
        if (pageLogics.size() == 0) {
            return;
        }
        if (this.pageLogicMap == null) {
            this.pageLogicMap = new Hashtable();
        }
        for (PageLogic pageLogic : pageLogics) {
            DEDataCtrl deDataCtrl = new DEDataCtrl();
            deDataCtrl.setDEDATACTRLID(pageLogic.getPAGELOGICID());
            deDataCtrl.setDEDATACTRLNAME(pageLogic.getLOGICTYPE());
            deDataCtrl.setPROCESSMODEL(pageLogic.getPROCESSMODEL());
            deDataCtrl.setDEBUGOUTPUT(pageLogic.getDEBUGOUTPUT());
            BaseDEDCEngine.FillDEDCProcesses(iDAGlobalHelper, deDataCtrl);
            this.pageLogicMap.put(pageLogic.getLOGICTYPE(), deDataCtrl);
        }
    }

    public DEDataCtrl GetPageLogicAction(String strPageLogic) {
        if (this.pageLogicMap == null) {
            return null;
        }
        if (this.pageLogicMap.containsKey(strPageLogic)) {
            return this.pageLogicMap.get(strPageLogic);
        }
        return null;
    }

    public boolean CheckUserMode(String strUserMode) {
        if (this.userModeMap == null) {
            return true;
        }
        return this.userModeMap.containsKey(strUserMode.toUpperCase());
    }

    public BaseDataEntity getAdvPageParam(String strCtrlId, String strParamType) {
        if (this.pageParamMap == null) {
            return null;
        }
        if (StringHelper.IsNullOrEmpty((String)strParamType)) {
            return this.pageParamMap.get(strCtrlId);
        }
        BaseDataEntity pageParam = this.pageParamMap.get(String.valueOf(strCtrlId) + ":" + strParamType);
        if (pageParam != null) {
            return pageParam;
        }
        return this.pageParamMap.get(strCtrlId);
    }

    public void setAdvPageParams(Vector<BaseDataEntity> pageParams) {
        if (this.pageParamMap != null) {
            this.pageParamMap.clear();
        }
        if (pageParams != null && pageParams.size() > 0) {
            if (this.pageParamMap == null) {
                this.pageParamMap = new Hashtable();
            }
            for (BaseDataEntity pageParam : pageParams) {
                String strCtrlId = pageParam.GetParamStringValue("CTRLID", "");
                this.pageParamMap.put(strCtrlId, pageParam);
                String strParamType = pageParam.GetParamStringValue(TAG_PAGETYPE, "");
                this.pageParamMap.put(String.valueOf(strCtrlId) + ":" + strParamType, pageParam);
            }
        }
    }
}

