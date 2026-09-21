/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

public class PSSysDashboardPart
extends BaseDataEntity {
    public static final String DBPARTTYPE_SYSPORTLET = "SYSPORTLET";
    public static final String DBPARTTYPE_APPMENU = "APPMENU";
    public static final String DBPARTTYPE_CONTAINER = "CONTAINER";
    public static final String TAG_PSSYSDBPARTID = "PSSYSDBPARTID";
    public static final String TAG_PSSYSDBPARTNAME = "PSSYSDBPARTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSDASHBOARDID = "PSSYSDASHBOARDID";
    public static final String TAG_PSSYSDASHBOARDNAME = "PSSYSDASHBOARDNAME";
    public static final String TAG_PSSYSPORTLETID = "PSSYSPORTLETID";
    public static final String TAG_PSSYSPORTLETNAME = "PSSYSPORTLETNAME";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_TITLEPSLANRESID = "TITLEPSLANRESID";
    public static final String TAG_TITLEPSLANRESNAME = "TITLEPSLANRESNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_POSINFO = "POSINFO";
    public static final String TAG_SHOWTITLEBAR = "SHOWTITLEBAR";
    public static final String TAG_TITLE = "TITLE";
    public static final String TAG_DBPARTTYPE = "DBPARTTYPE";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_NEWROWMODE = "NEWROWMODE";
    public static final String TAG_COL_XS_OS = "COL_XS_OS";
    public static final String TAG_COL_XS = "COL_XS";
    public static final String TAG_COL_SM_OS = "COL_SM_OS";
    public static final String TAG_COL_SM = "COL_SM";
    public static final String TAG_COL_MD_OS = "COL_MD_OS";
    public static final String TAG_COL_MD = "COL_MD";
    public static final String TAG_COL_LG_OS = "COL_LG_OS";
    public static final String TAG_COL_LG = "COL_LG";
    public static final String TAG_COLSPAN = "COLSPAN";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_COLID = "COLID";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PORTLETTYPE = "PORTLETTYPE";
    public static final String TAG_PPSSYSDBPARTID = "PPSSYSDBPARTID";
    public static final String TAG_PPSSYSDBPARTNAME = "PPSSYSDBPARTNAME";
    public static final String TAG_LAYOUTMODE = "LAYOUTMODE";
    public static final String TAG_FLEXGROW = "FLEXGROW";
    public static final String TAG_FLEXVALIGN = "FLEXVALIGN";
    public static final String TAG_FLEXALIGN = "FLEXALIGN";
    public static final String TAG_FLEXDIR = "FLEXDIR";
    public static final String TAG_BL_POS = "BL_POS";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_TITLEBARCLOSEMODE = "TITLEBARCLOSEMODE";
    public static final String TAG_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String TAG_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_HTMLCONTENT = "HTMLCONTENT";
    public static final String TAG_RAWCONTENT = "RAWCONTENT";
    public static final String TAG_CONTENTTYPE = "CONTENTTYPE";
    public static final String TAG_MOBFLAG = "MOBFLAG";
    public static final String TAG_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String TAG_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String TAG_SWAPMODE = "SWAPMODE";
    public static final String TAG_PARTPARAMS = "PARTPARAMS";
    public static final String TAG_RAWCSSSTYLE = "RAWCSSSTYLE";
    public static final String TAG_DYNACLASS = "DYNACLASS";
    public static final String TAG_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String TAG_TEMPLATEMODE = "TEMPLATEMODE";
    public static final String TAG_ENABLEANCHOR = "ENABLEANCHOR";
    private ArrayList<PSSysDashboardPart> childPSSysDashboardPartList = null;

    public final boolean isPSSYSDBPARTIDNull() {
        return this.IsParamNull(TAG_PSSYSDBPARTID);
    }

    public final String getPSSYSDBPARTID() {
        return this.GetParamStringValue(TAG_PSSYSDBPARTID, "");
    }

    public final void setPSSYSDBPARTID(String strValue) {
        this.SetParamValue(TAG_PSSYSDBPARTID, strValue);
    }

    public final boolean isPSSYSDBPARTNAMENull() {
        return this.IsParamNull(TAG_PSSYSDBPARTNAME);
    }

    public final String getPSSYSDBPARTNAME() {
        return this.GetParamStringValue(TAG_PSSYSDBPARTNAME, "");
    }

    public final void setPSSYSDBPARTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDBPARTNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSSYSDASHBOARDIDNull() {
        return this.IsParamNull(TAG_PSSYSDASHBOARDID);
    }

    public final String getPSSYSDASHBOARDID() {
        return this.GetParamStringValue(TAG_PSSYSDASHBOARDID, "");
    }

    public final void setPSSYSDASHBOARDID(String strValue) {
        this.SetParamValue(TAG_PSSYSDASHBOARDID, strValue);
    }

    public final boolean isPSSYSDASHBOARDNAMENull() {
        return this.IsParamNull(TAG_PSSYSDASHBOARDNAME);
    }

    public final String getPSSYSDASHBOARDNAME() {
        return this.GetParamStringValue(TAG_PSSYSDASHBOARDNAME, "");
    }

    public final void setPSSYSDASHBOARDNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDASHBOARDNAME, strValue);
    }

    public final boolean isPSSYSPORTLETIDNull() {
        return this.IsParamNull(TAG_PSSYSPORTLETID);
    }

    public final String getPSSYSPORTLETID() {
        return this.GetParamStringValue(TAG_PSSYSPORTLETID, "");
    }

    public final void setPSSYSPORTLETID(String strValue) {
        this.SetParamValue(TAG_PSSYSPORTLETID, strValue);
    }

    public final boolean isPSSYSPORTLETNAMENull() {
        return this.IsParamNull(TAG_PSSYSPORTLETNAME);
    }

    public final String getPSSYSPORTLETNAME() {
        return this.GetParamStringValue(TAG_PSSYSPORTLETNAME, "");
    }

    public final void setPSSYSPORTLETNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSPORTLETNAME, strValue);
    }

    public final boolean isPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINID);
    }

    public final String getPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINID, "");
    }

    public final void setPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINID, strValue);
    }

    public final boolean isPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINNAME);
    }

    public final String getPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINNAME, "");
    }

    public final void setPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isTITLEPSLANRESIDNull() {
        return this.IsParamNull(TAG_TITLEPSLANRESID);
    }

    public final String getTITLEPSLANRESID() {
        return this.GetParamStringValue(TAG_TITLEPSLANRESID, "");
    }

    public final void setTITLEPSLANRESID(String strValue) {
        this.SetParamValue(TAG_TITLEPSLANRESID, strValue);
    }

    public final boolean isTITLEPSLANRESNAMENull() {
        return this.IsParamNull(TAG_TITLEPSLANRESNAME);
    }

    public final String getTITLEPSLANRESNAME() {
        return this.GetParamStringValue(TAG_TITLEPSLANRESNAME, "");
    }

    public final void setTITLEPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_TITLEPSLANRESNAME, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isPOSINFONull() {
        return this.IsParamNull(TAG_POSINFO);
    }

    public final String getPOSINFO() {
        return this.GetParamStringValue(TAG_POSINFO, "");
    }

    public final void setPOSINFO(String strValue) {
        this.SetParamValue(TAG_POSINFO, strValue);
    }

    public final boolean isSHOWTITLEBARNull() {
        return this.IsParamNull(TAG_SHOWTITLEBAR);
    }

    public final boolean getSHOWTITLEBAR() {
        return this.GetParamIntValue(TAG_SHOWTITLEBAR, 0) == 1;
    }

    public final void setSHOWTITLEBAR(boolean bValue) {
        this.SetParamValue(TAG_SHOWTITLEBAR, bValue ? 1 : 0);
    }

    public final boolean isTITLENull() {
        return this.IsParamNull(TAG_TITLE);
    }

    public final String getTITLE() {
        return this.GetParamStringValue(TAG_TITLE, "");
    }

    public final void setTITLE(String strValue) {
        this.SetParamValue(TAG_TITLE, strValue);
    }

    public final boolean isDBPARTTYPENull() {
        return this.IsParamNull(TAG_DBPARTTYPE);
    }

    public final String getDBPARTTYPE() {
        return this.GetParamStringValue(TAG_DBPARTTYPE, "");
    }

    public final void setDBPARTTYPE(String strValue) {
        this.SetParamValue(TAG_DBPARTTYPE, strValue);
    }

    public final boolean isHEIGHTNull() {
        return this.IsParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.SetParamValue(TAG_HEIGHT, nValue);
    }

    public final boolean isNEWROWMODENull() {
        return this.IsParamNull(TAG_NEWROWMODE);
    }

    public final boolean getNEWROWMODE() {
        return this.GetParamIntValue(TAG_NEWROWMODE, 0) == 1;
    }

    public final void setNEWROWMODE(boolean bValue) {
        this.SetParamValue(TAG_NEWROWMODE, bValue ? 1 : 0);
    }

    public final boolean isCOL_XS_OSNull() {
        return this.IsParamNull(TAG_COL_XS_OS);
    }

    public final int getCOL_XS_OS() {
        return this.GetParamIntValue(TAG_COL_XS_OS, 0);
    }

    public final void setCOL_XS_OS(int nValue) {
        this.SetParamValue(TAG_COL_XS_OS, nValue);
    }

    public final boolean isCOL_XSNull() {
        return this.IsParamNull(TAG_COL_XS);
    }

    public final int getCOL_XS() {
        return this.GetParamIntValue(TAG_COL_XS, 0);
    }

    public final void setCOL_XS(int nValue) {
        this.SetParamValue(TAG_COL_XS, nValue);
    }

    public final boolean isCOL_SM_OSNull() {
        return this.IsParamNull(TAG_COL_SM_OS);
    }

    public final int getCOL_SM_OS() {
        return this.GetParamIntValue(TAG_COL_SM_OS, 0);
    }

    public final void setCOL_SM_OS(int nValue) {
        this.SetParamValue(TAG_COL_SM_OS, nValue);
    }

    public final boolean isCOL_SMNull() {
        return this.IsParamNull(TAG_COL_SM);
    }

    public final int getCOL_SM() {
        return this.GetParamIntValue(TAG_COL_SM, 0);
    }

    public final void setCOL_SM(int nValue) {
        this.SetParamValue(TAG_COL_SM, nValue);
    }

    public final boolean isCOL_MD_OSNull() {
        return this.IsParamNull(TAG_COL_MD_OS);
    }

    public final int getCOL_MD_OS() {
        return this.GetParamIntValue(TAG_COL_MD_OS, 0);
    }

    public final void setCOL_MD_OS(int nValue) {
        this.SetParamValue(TAG_COL_MD_OS, nValue);
    }

    public final boolean isCOL_MDNull() {
        return this.IsParamNull(TAG_COL_MD);
    }

    public final int getCOL_MD() {
        return this.GetParamIntValue(TAG_COL_MD, 0);
    }

    public final void setCOL_MD(int nValue) {
        this.SetParamValue(TAG_COL_MD, nValue);
    }

    public final boolean isCOL_LG_OSNull() {
        return this.IsParamNull(TAG_COL_LG_OS);
    }

    public final int getCOL_LG_OS() {
        return this.GetParamIntValue(TAG_COL_LG_OS, 0);
    }

    public final void setCOL_LG_OS(int nValue) {
        this.SetParamValue(TAG_COL_LG_OS, nValue);
    }

    public final boolean isCOL_LGNull() {
        return this.IsParamNull(TAG_COL_LG);
    }

    public final int getCOL_LG() {
        return this.GetParamIntValue(TAG_COL_LG, 0);
    }

    public final void setCOL_LG(int nValue) {
        this.SetParamValue(TAG_COL_LG, nValue);
    }

    public final boolean isCOLSPANNull() {
        return this.IsParamNull(TAG_COLSPAN);
    }

    public final int getCOLSPAN() {
        return this.GetParamIntValue(TAG_COLSPAN, 0);
    }

    public final void setCOLSPAN(int nValue) {
        this.SetParamValue(TAG_COLSPAN, nValue);
    }

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isCOLIDNull() {
        return this.IsParamNull(TAG_COLID);
    }

    public final int getCOLID() {
        return this.GetParamIntValue(TAG_COLID, 0);
    }

    public final void setCOLID(int nValue) {
        this.SetParamValue(TAG_COLID, nValue);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPORTLETTYPENull() {
        return this.IsParamNull(TAG_PORTLETTYPE);
    }

    public final String getPORTLETTYPE() {
        return this.GetParamStringValue(TAG_PORTLETTYPE, "");
    }

    public final void setPORTLETTYPE(String strValue) {
        this.SetParamValue(TAG_PORTLETTYPE, strValue);
    }

    public final boolean isPPSSYSDBPARTIDNull() {
        return this.IsParamNull(TAG_PPSSYSDBPARTID);
    }

    public final String getPPSSYSDBPARTID() {
        return this.GetParamStringValue(TAG_PPSSYSDBPARTID, "");
    }

    public final void setPPSSYSDBPARTID(String strValue) {
        this.SetParamValue(TAG_PPSSYSDBPARTID, strValue);
    }

    public final boolean isPPSSYSDBPARTNAMENull() {
        return this.IsParamNull(TAG_PPSSYSDBPARTNAME);
    }

    public final String getPPSSYSDBPARTNAME() {
        return this.GetParamStringValue(TAG_PPSSYSDBPARTNAME, "");
    }

    public final void setPPSSYSDBPARTNAME(String strValue) {
        this.SetParamValue(TAG_PPSSYSDBPARTNAME, strValue);
    }

    public final boolean isLAYOUTMODENull() {
        return this.IsParamNull(TAG_LAYOUTMODE);
    }

    public final String getLAYOUTMODE() {
        return this.GetParamStringValue(TAG_LAYOUTMODE, "");
    }

    public final void setLAYOUTMODE(String strValue) {
        this.SetParamValue(TAG_LAYOUTMODE, strValue);
    }

    public final boolean isFLEXGROWNull() {
        return this.IsParamNull(TAG_FLEXGROW);
    }

    public final int getFLEXGROW() {
        return this.GetParamIntValue(TAG_FLEXGROW, 0);
    }

    public final void setFLEXGROW(int nValue) {
        this.SetParamValue(TAG_FLEXGROW, nValue);
    }

    public final boolean isFLEXVALIGNNull() {
        return this.IsParamNull(TAG_FLEXVALIGN);
    }

    public final String getFLEXVALIGN() {
        return this.GetParamStringValue(TAG_FLEXVALIGN, "");
    }

    public final void setFLEXVALIGN(String strValue) {
        this.SetParamValue(TAG_FLEXVALIGN, strValue);
    }

    public final boolean isFLEXALIGNNull() {
        return this.IsParamNull(TAG_FLEXALIGN);
    }

    public final String getFLEXALIGN() {
        return this.GetParamStringValue(TAG_FLEXALIGN, "");
    }

    public final void setFLEXALIGN(String strValue) {
        this.SetParamValue(TAG_FLEXALIGN, strValue);
    }

    public final boolean isFLEXDIRNull() {
        return this.IsParamNull(TAG_FLEXDIR);
    }

    public final String getFLEXDIR() {
        return this.GetParamStringValue(TAG_FLEXDIR, "");
    }

    public final void setFLEXDIR(String strValue) {
        this.SetParamValue(TAG_FLEXDIR, strValue);
    }

    public final boolean isBL_POSNull() {
        return this.IsParamNull(TAG_BL_POS);
    }

    public final String getBL_POS() {
        return this.GetParamStringValue(TAG_BL_POS, "");
    }

    public final void setBL_POS(String strValue) {
        this.SetParamValue(TAG_BL_POS, strValue);
    }

    public final boolean isWIDTHNull() {
        return this.IsParamNull(TAG_WIDTH);
    }

    public final int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public final void setWIDTH(int nValue) {
        this.SetParamValue(TAG_WIDTH, nValue);
    }

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
    }

    public final boolean isTITLEBARCLOSEMODENull() {
        return this.IsParamNull(TAG_TITLEBARCLOSEMODE);
    }

    public final int getTITLEBARCLOSEMODE() {
        return this.GetParamIntValue(TAG_TITLEBARCLOSEMODE, 0);
    }

    public final void setTITLEBARCLOSEMODE(int nValue) {
        this.SetParamValue(TAG_TITLEBARCLOSEMODE, nValue);
    }

    public final boolean isPSSYSUNIRESIDNull() {
        return this.IsParamNull(TAG_PSSYSUNIRESID);
    }

    public final String getPSSYSUNIRESID() {
        return this.GetParamStringValue(TAG_PSSYSUNIRESID, "");
    }

    public final void setPSSYSUNIRESID(String strValue) {
        this.SetParamValue(TAG_PSSYSUNIRESID, strValue);
    }

    public final boolean isPSSYSUNIRESNAMENull() {
        return this.IsParamNull(TAG_PSSYSUNIRESNAME);
    }

    public final String getPSSYSUNIRESNAME() {
        return this.GetParamStringValue(TAG_PSSYSUNIRESNAME, "");
    }

    public final void setPSSYSUNIRESNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUNIRESNAME, strValue);
    }

    public final String getPSSYSIMAGEID() {
        return this.GetParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.IsParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.GetParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGENAME, strValue);
    }

    public final boolean isPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_PSSYSCSSID);
    }

    public final String getPSSYSCSSID() {
        return this.GetParamStringValue(TAG_PSSYSCSSID, "");
    }

    public final void setPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSID, strValue);
    }

    public final boolean isPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_PSSYSCSSNAME);
    }

    public final String getPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_PSSYSCSSNAME, "");
    }

    public final void setPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSNAME, strValue);
    }

    public final boolean isHTMLCONTENTNull() {
        return this.IsParamNull(TAG_HTMLCONTENT);
    }

    public final String getHTMLCONTENT() {
        return this.GetParamStringValue(TAG_HTMLCONTENT, "");
    }

    public final void setHTMLCONTENT(String strValue) {
        this.SetParamValue(TAG_HTMLCONTENT, strValue);
    }

    public final boolean isRAWCONTENTNull() {
        return this.IsParamNull(TAG_RAWCONTENT);
    }

    public final String getRAWCONTENT() {
        return this.GetParamStringValue(TAG_RAWCONTENT, "");
    }

    public final void setRAWCONTENT(String strValue) {
        this.SetParamValue(TAG_RAWCONTENT, strValue);
    }

    public final boolean isCONTENTTYPENull() {
        return this.IsParamNull(TAG_CONTENTTYPE);
    }

    public final String getCONTENTTYPE() {
        return this.GetParamStringValue(TAG_CONTENTTYPE, "");
    }

    public final void setCONTENTTYPE(String strValue) {
        this.SetParamValue(TAG_CONTENTTYPE, strValue);
    }

    public final boolean isMOBFLAGNull() {
        return this.IsParamNull(TAG_MOBFLAG);
    }

    public final boolean getMOBFLAG() {
        return this.GetParamIntValue(TAG_MOBFLAG, 0) == 1;
    }

    public final void setMOBFLAG(boolean bValue) {
        this.SetParamValue(TAG_MOBFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSSYSRESOURCEIDNull() {
        return this.IsParamNull(TAG_PSSYSRESOURCEID);
    }

    public final String getPSSYSRESOURCEID() {
        return this.GetParamStringValue(TAG_PSSYSRESOURCEID, "");
    }

    public final void setPSSYSRESOURCEID(String strValue) {
        this.SetParamValue(TAG_PSSYSRESOURCEID, strValue);
    }

    public final boolean isPSSYSRESOURCENAMENull() {
        return this.IsParamNull(TAG_PSSYSRESOURCENAME);
    }

    public final String getPSSYSRESOURCENAME() {
        return this.GetParamStringValue(TAG_PSSYSRESOURCENAME, "");
    }

    public final void setPSSYSRESOURCENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSRESOURCENAME, strValue);
    }

    public final boolean isSWAPMODENull() {
        return this.IsParamNull(TAG_SWAPMODE);
    }

    public final String getSWAPMODE() {
        return this.GetParamStringValue(TAG_SWAPMODE, "");
    }

    public final void setSWAPMODE(String strValue) {
        this.SetParamValue(TAG_SWAPMODE, strValue);
    }

    public final boolean isPARTPARAMSNull() {
        return this.IsParamNull(TAG_PARTPARAMS);
    }

    public final String getPARTPARAMS() {
        return this.GetParamStringValue(TAG_PARTPARAMS, "");
    }

    public final void setPARTPARAMS(String strValue) {
        this.SetParamValue(TAG_PARTPARAMS, strValue);
    }

    public final boolean isRAWCSSSTYLENull() {
        return this.IsParamNull(TAG_RAWCSSSTYLE);
    }

    public final String getRAWCSSSTYLE() {
        return this.GetParamStringValue(TAG_RAWCSSSTYLE, "");
    }

    public final void setRAWCSSSTYLE(String strValue) {
        this.SetParamValue(TAG_RAWCSSSTYLE, strValue);
    }

    public final boolean isDYNACLASSNull() {
        return this.IsParamNull(TAG_DYNACLASS);
    }

    public final String getDYNACLASS() {
        return this.GetParamStringValue(TAG_DYNACLASS, "");
    }

    public final void setDYNACLASS(String strValue) {
        this.SetParamValue(TAG_DYNACLASS, strValue);
    }

    public final boolean isTOOLTIPINFONull() {
        return this.IsParamNull(TAG_TOOLTIPINFO);
    }

    public final String getTOOLTIPINFO() {
        return this.GetParamStringValue(TAG_TOOLTIPINFO, "");
    }

    public final void setTOOLTIPINFO(String strValue) {
        this.SetParamValue(TAG_TOOLTIPINFO, strValue);
    }

    public final boolean isTEMPLATEMODENull() {
        return this.IsParamNull(TAG_TEMPLATEMODE);
    }

    public final int getTEMPLATEMODE() {
        return this.GetParamIntValue(TAG_TEMPLATEMODE, 0);
    }

    public final void setTEMPLATEMODE(int nValue) {
        this.SetParamValue(TAG_TEMPLATEMODE, nValue);
    }

    public final boolean isENABLEANCHORNull() {
        return this.IsParamNull(TAG_ENABLEANCHOR);
    }

    public final boolean getENABLEANCHOR() {
        return this.GetParamIntValue(TAG_ENABLEANCHOR, 0) == 1;
    }

    public final void setENABLEANCHOR(boolean bValue) {
        this.SetParamValue(TAG_ENABLEANCHOR, bValue ? 1 : 0);
    }

    public ArrayList<PSSysDashboardPart> getChildPSSysDashboardParts(boolean bCreated) {
        if (this.childPSSysDashboardPartList != null) {
            return this.childPSSysDashboardPartList;
        }
        if (bCreated) {
            this.childPSSysDashboardPartList = new ArrayList();
        }
        return this.childPSSysDashboardPartList;
    }

    public void resetChildDatas() {
        if (this.childPSSysDashboardPartList != null) {
            this.childPSSysDashboardPartList.clear();
            this.childPSSysDashboardPartList = null;
        }
    }
}

