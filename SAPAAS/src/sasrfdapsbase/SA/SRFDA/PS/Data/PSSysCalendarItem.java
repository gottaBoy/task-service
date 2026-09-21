/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFDA.PS.Data.PSSysCalendarItemRV;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

public class PSSysCalendarItem
extends BaseDataEntity {
    public static final String TAG_PSSYSCALENDARITEMID = "PSSYSCALENDARITEMID";
    public static final String TAG_PSSYSCALENDARITEMNAME = "PSSYSCALENDARITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSCALENDARID = "PSSYSCALENDARID";
    public static final String TAG_PSSYSCALENDARNAME = "PSSYSCALENDARNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDEDSID = "PSDEDSID";
    public static final String TAG_PSDEDSNAME = "PSDEDSNAME";
    public static final String TAG_REMOVEPSDEOPPRIVID = "REMOVEPSDEOPPRIVID";
    public static final String TAG_REMOVEPSDEOPPRIVNAME = "REMOVEPSDEOPPRIVNAME";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_TEXTPSDEFID = "TEXTPSDEFID";
    public static final String TAG_TEXTPSDEFNAME = "TEXTPSDEFNAME";
    public static final String TAG_KEYPSDEFID = "KEYPSDEFID";
    public static final String TAG_KEYPSDEFNAME = "KEYPSDEFNAME";
    public static final String TAG_ICONPSDEFID = "ICONPSDEFID";
    public static final String TAG_ICONPSDEFNAME = "ICONPSDEFNAME";
    public static final String TAG_TIPSPSDEFID = "TIPSPSDEFID";
    public static final String TAG_TIPSPSDEFNAME = "TIPSPSDEFNAME";
    public static final String TAG_CONTENTPSDEFID = "CONTENTPSDEFID";
    public static final String TAG_CONTENTPSDEFNAME = "CONTENTPSDEFNAME";
    public static final String TAG_COLOR = "COLOR";
    public static final String TAG_BKCOLOR = "BKCOLOR";
    public static final String TAG_ITEMTYPE = "ITEMTYPE";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_COLORPSDEFID = "COLORPSDEFID";
    public static final String TAG_COLORPSDEFNAME = "COLORPSDEFNAME";
    public static final String TAG_BKCOLORPSDEFID = "BKCOLORPSDEFID";
    public static final String TAG_BKCOLORPSDEFNAME = "BKCOLORPSDEFNAME";
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String TAG_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String TAG_BEGINPSDEFID = "BEGINPSDEFID";
    public static final String TAG_BEGINPSDEFNAME = "BEGINPSDEFNAME";
    public static final String TAG_ENDPSDEFID = "ENDPSDEFID";
    public static final String TAG_ENDPSDEFNAME = "ENDPSDEFNAME";
    public static final String TAG_MAXSIZE = "MAXSIZE";
    public static final String TAG_MODELOBJ = "MODELOBJ";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSDETOOLBARID = "PSDETOOLBARID";
    public static final String TAG_PSDETOOLBARNAME = "PSDETOOLBARNAME";
    public static final String TAG_ENABLEVIEWACTIONS = "ENABLEVIEWACTIONS";
    public static final String TAG_VIEWACTIONS = "VIEWACTIONS";
    public static final String TAG_REMOVEPSDEACTIONID = "REMOVEPSDEACTIONID";
    public static final String TAG_REMOVEPSDEACTIONNAME = "REMOVEPSDEACTIONNAME";
    public static final String TAG_CREATEPSDEACTIONID = "CREATEPSDEACTIONID";
    public static final String TAG_CREATEPSDEACTIONNAME = "CREATEPSDEACTIONNAME";
    public static final String TAG_UPDATEPSDEACTIONID = "UPDATEPSDEACTIONID";
    public static final String TAG_UPDATEPSDEACTIONNAME = "UPDATEPSDEACTIONNAME";
    public static final String TAG_CREATEPSDEOPPRIVID = "CREATEPSDEOPPRIVID";
    public static final String TAG_CREATEPSDEOPPRIVNAME = "CREATEPSDEOPPRIVNAME";
    public static final String TAG_UPDATEPSDEOPPRIVID = "UPDATEPSDEOPPRIVID";
    public static final String TAG_UPDATEPSDEOPPRIVNAME = "UPDATEPSDEOPPRIVNAME";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_ITEMSTYLE = "ITEMSTYLE";
    public static final String TAG_ORDERVALUEPSDEFID = "ORDERVALUEPSDEFID";
    public static final String TAG_ORDERVALUEPSDEFNAME = "ORDERVALUEPSDEFNAME";
    public static final String TAG_PKEYPSDEFID = "PKEYPSDEFID";
    public static final String TAG_PKEYPSDEFNAME = "PKEYPSDEFNAME";
    public static final String TAG_TAGPSDEFID = "TAGPSDEFID";
    public static final String TAG_TAGPSDEFNAME = "TAGPSDEFNAME";
    public static final String TAG_TAG2PSDEFID = "TAG2PSDEFID";
    public static final String TAG_TAG2PSDEFNAME = "TAG2PSDEFNAME";
    public static final String TAG_TOTALPSDEFID = "TOTALPSDEFID";
    public static final String TAG_TOTALPSDEFNAME = "TOTALPSDEFNAME";
    public static final String TAG_FINISHPSDEFID = "FINISHPSDEFID";
    public static final String TAG_FINISHPSDEFNAME = "FINISHPSDEFNAME";
    public static final String TAG_LEVELPSDEFID = "LEVELPSDEFID";
    public static final String TAG_LEVELPSDEFNAME = "LEVELPSDEFNAME";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_GANTTPSSYSPFPLUGINID = "GANTTPSSYSPFPLUGINID";
    public static final String TAG_GANTTPSSYSPFPLUGINNAME = "GANTTPSSYSPFPLUGINNAME";
    public static final String TAG_CUSTOMCOND = "CUSTOMCOND";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_NAMEPSLANRESID = "NAMEPSLANRESID";
    public static final String TAG_NAMEPSLANRESNAME = "NAMEPSLANRESNAME";
    public static final String TAG_DATAPSDEFID = "DATAPSDEFID";
    public static final String TAG_DATAPSDEFNAME = "DATAPSDEFNAME";
    public static final String TAG_DATA2PSDEFID = "DATA2PSDEFID";
    public static final String TAG_DATA2PSDEFNAME = "DATA2PSDEFNAME";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_EDITMODE = "EDITMODE";
    public static final String TAG_CLSPSDEFID = "CLSPSDEFID";
    public static final String TAG_CLSPSDEFNAME = "CLSPSDEFNAME";
    public static final String TAG_DYNACLASS = "DYNACLASS";
    public static final String TAG_LINKPSDEFID = "LINKPSDEFID";
    public static final String TAG_LINKPSDEFNAME = "LINKPSDEFNAME";
    private ArrayList<PSSysCalendarItemRV> psSysCalendarItemRVList = null;

    public final boolean isPSSYSCALENDARITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSCALENDARITEMID);
    }

    public final String getPSSYSCALENDARITEMID() {
        return this.GetParamStringValue(TAG_PSSYSCALENDARITEMID, "");
    }

    public final void setPSSYSCALENDARITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSCALENDARITEMID, strValue);
    }

    public final boolean isPSSYSCALENDARITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSCALENDARITEMNAME);
    }

    public final String getPSSYSCALENDARITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSCALENDARITEMNAME, "");
    }

    public final void setPSSYSCALENDARITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCALENDARITEMNAME, strValue);
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

    public final boolean isPSSYSCALENDARIDNull() {
        return this.IsParamNull(TAG_PSSYSCALENDARID);
    }

    public final String getPSSYSCALENDARID() {
        return this.GetParamStringValue(TAG_PSSYSCALENDARID, "");
    }

    public final void setPSSYSCALENDARID(String strValue) {
        this.SetParamValue(TAG_PSSYSCALENDARID, strValue);
    }

    public final boolean isPSSYSCALENDARNAMENull() {
        return this.IsParamNull(TAG_PSSYSCALENDARNAME);
    }

    public final String getPSSYSCALENDARNAME() {
        return this.GetParamStringValue(TAG_PSSYSCALENDARNAME, "");
    }

    public final void setPSSYSCALENDARNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCALENDARNAME, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isPSDEDSIDNull() {
        return this.IsParamNull(TAG_PSDEDSID);
    }

    public final String getPSDEDSID() {
        return this.GetParamStringValue(TAG_PSDEDSID, "");
    }

    public final void setPSDEDSID(String strValue) {
        this.SetParamValue(TAG_PSDEDSID, strValue);
    }

    public final boolean isPSDEDSNAMENull() {
        return this.IsParamNull(TAG_PSDEDSNAME);
    }

    public final String getPSDEDSNAME() {
        return this.GetParamStringValue(TAG_PSDEDSNAME, "");
    }

    public final void setPSDEDSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDSNAME, strValue);
    }

    public final boolean isREMOVEPSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_REMOVEPSDEOPPRIVID);
    }

    public final String getREMOVEPSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_REMOVEPSDEOPPRIVID, "");
    }

    public final void setREMOVEPSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_REMOVEPSDEOPPRIVID, strValue);
    }

    public final boolean isREMOVEPSDEOPPRIVNAMENull() {
        return this.IsParamNull(TAG_REMOVEPSDEOPPRIVNAME);
    }

    public final String getREMOVEPSDEOPPRIVNAME() {
        return this.GetParamStringValue(TAG_REMOVEPSDEOPPRIVNAME, "");
    }

    public final void setREMOVEPSDEOPPRIVNAME(String strValue) {
        this.SetParamValue(TAG_REMOVEPSDEOPPRIVNAME, strValue);
    }

    public final boolean isPSDELOGICIDNull() {
        return this.IsParamNull(TAG_PSDELOGICID);
    }

    public final String getPSDELOGICID() {
        return this.GetParamStringValue(TAG_PSDELOGICID, "");
    }

    public final void setPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_PSDELOGICID, strValue);
    }

    public final boolean isPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_PSDELOGICNAME);
    }

    public final String getPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_PSDELOGICNAME, "");
    }

    public final void setPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSDELOGICNAME, strValue);
    }

    public final boolean isTEXTPSDEFIDNull() {
        return this.IsParamNull(TAG_TEXTPSDEFID);
    }

    public final String getTEXTPSDEFID() {
        return this.GetParamStringValue(TAG_TEXTPSDEFID, "");
    }

    public final void setTEXTPSDEFID(String strValue) {
        this.SetParamValue(TAG_TEXTPSDEFID, strValue);
    }

    public final boolean isTEXTPSDEFNAMENull() {
        return this.IsParamNull(TAG_TEXTPSDEFNAME);
    }

    public final String getTEXTPSDEFNAME() {
        return this.GetParamStringValue(TAG_TEXTPSDEFNAME, "");
    }

    public final void setTEXTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TEXTPSDEFNAME, strValue);
    }

    public final boolean isKEYPSDEFIDNull() {
        return this.IsParamNull(TAG_KEYPSDEFID);
    }

    public final String getKEYPSDEFID() {
        return this.GetParamStringValue(TAG_KEYPSDEFID, "");
    }

    public final void setKEYPSDEFID(String strValue) {
        this.SetParamValue(TAG_KEYPSDEFID, strValue);
    }

    public final boolean isKEYPSDEFNAMENull() {
        return this.IsParamNull(TAG_KEYPSDEFNAME);
    }

    public final String getKEYPSDEFNAME() {
        return this.GetParamStringValue(TAG_KEYPSDEFNAME, "");
    }

    public final void setKEYPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_KEYPSDEFNAME, strValue);
    }

    public final boolean isICONPSDEFIDNull() {
        return this.IsParamNull(TAG_ICONPSDEFID);
    }

    public final String getICONPSDEFID() {
        return this.GetParamStringValue(TAG_ICONPSDEFID, "");
    }

    public final void setICONPSDEFID(String strValue) {
        this.SetParamValue(TAG_ICONPSDEFID, strValue);
    }

    public final boolean isICONPSDEFNAMENull() {
        return this.IsParamNull(TAG_ICONPSDEFNAME);
    }

    public final String getICONPSDEFNAME() {
        return this.GetParamStringValue(TAG_ICONPSDEFNAME, "");
    }

    public final void setICONPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_ICONPSDEFNAME, strValue);
    }

    public final boolean isTIPSPSDEFIDNull() {
        return this.IsParamNull(TAG_TIPSPSDEFID);
    }

    public final String getTIPSPSDEFID() {
        return this.GetParamStringValue(TAG_TIPSPSDEFID, "");
    }

    public final void setTIPSPSDEFID(String strValue) {
        this.SetParamValue(TAG_TIPSPSDEFID, strValue);
    }

    public final boolean isTIPSPSDEFNAMENull() {
        return this.IsParamNull(TAG_TIPSPSDEFNAME);
    }

    public final String getTIPSPSDEFNAME() {
        return this.GetParamStringValue(TAG_TIPSPSDEFNAME, "");
    }

    public final void setTIPSPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TIPSPSDEFNAME, strValue);
    }

    public final boolean isCONTENTPSDEFIDNull() {
        return this.IsParamNull(TAG_CONTENTPSDEFID);
    }

    public final String getCONTENTPSDEFID() {
        return this.GetParamStringValue(TAG_CONTENTPSDEFID, "");
    }

    public final void setCONTENTPSDEFID(String strValue) {
        this.SetParamValue(TAG_CONTENTPSDEFID, strValue);
    }

    public final boolean isCONTENTPSDEFNAMENull() {
        return this.IsParamNull(TAG_CONTENTPSDEFNAME);
    }

    public final String getCONTENTPSDEFNAME() {
        return this.GetParamStringValue(TAG_CONTENTPSDEFNAME, "");
    }

    public final void setCONTENTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_CONTENTPSDEFNAME, strValue);
    }

    public final boolean isCOLORNull() {
        return this.IsParamNull(TAG_COLOR);
    }

    public final String getCOLOR() {
        return this.GetParamStringValue(TAG_COLOR, "");
    }

    public final void setCOLOR(String strValue) {
        this.SetParamValue(TAG_COLOR, strValue);
    }

    public final boolean isBKCOLORNull() {
        return this.IsParamNull(TAG_BKCOLOR);
    }

    public final String getBKCOLOR() {
        return this.GetParamStringValue(TAG_BKCOLOR, "");
    }

    public final void setBKCOLOR(String strValue) {
        this.SetParamValue(TAG_BKCOLOR, strValue);
    }

    public final boolean isITEMTYPENull() {
        return this.IsParamNull(TAG_ITEMTYPE);
    }

    public final String getITEMTYPE() {
        return this.GetParamStringValue(TAG_ITEMTYPE, "");
    }

    public final void setITEMTYPE(String strValue) {
        this.SetParamValue(TAG_ITEMTYPE, strValue);
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

    public final boolean isCOLORPSDEFIDNull() {
        return this.IsParamNull(TAG_COLORPSDEFID);
    }

    public final String getCOLORPSDEFID() {
        return this.GetParamStringValue(TAG_COLORPSDEFID, "");
    }

    public final void setCOLORPSDEFID(String strValue) {
        this.SetParamValue(TAG_COLORPSDEFID, strValue);
    }

    public final boolean isCOLORPSDEFNAMENull() {
        return this.IsParamNull(TAG_COLORPSDEFNAME);
    }

    public final String getCOLORPSDEFNAME() {
        return this.GetParamStringValue(TAG_COLORPSDEFNAME, "");
    }

    public final void setCOLORPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_COLORPSDEFNAME, strValue);
    }

    public final boolean isBKCOLORPSDEFIDNull() {
        return this.IsParamNull(TAG_BKCOLORPSDEFID);
    }

    public final String getBKCOLORPSDEFID() {
        return this.GetParamStringValue(TAG_BKCOLORPSDEFID, "");
    }

    public final void setBKCOLORPSDEFID(String strValue) {
        this.SetParamValue(TAG_BKCOLORPSDEFID, strValue);
    }

    public final boolean isBKCOLORPSDEFNAMENull() {
        return this.IsParamNull(TAG_BKCOLORPSDEFNAME);
    }

    public final String getBKCOLORPSDEFNAME() {
        return this.GetParamStringValue(TAG_BKCOLORPSDEFNAME, "");
    }

    public final void setBKCOLORPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_BKCOLORPSDEFNAME, strValue);
    }

    public final boolean isPSDEVIEWBASEIDNull() {
        return this.IsParamNull(TAG_PSDEVIEWBASEID);
    }

    public final String getPSDEVIEWBASEID() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASEID, "");
    }

    public final void setPSDEVIEWBASEID(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASEID, strValue);
    }

    public final boolean isPSDEVIEWBASENAMENull() {
        return this.IsParamNull(TAG_PSDEVIEWBASENAME);
    }

    public final String getPSDEVIEWBASENAME() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASENAME, "");
    }

    public final void setPSDEVIEWBASENAME(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASENAME, strValue);
    }

    public final boolean isBEGINPSDEFIDNull() {
        return this.IsParamNull(TAG_BEGINPSDEFID);
    }

    public final String getBEGINPSDEFID() {
        return this.GetParamStringValue(TAG_BEGINPSDEFID, "");
    }

    public final void setBEGINPSDEFID(String strValue) {
        this.SetParamValue(TAG_BEGINPSDEFID, strValue);
    }

    public final boolean isBEGINPSDEFNAMENull() {
        return this.IsParamNull(TAG_BEGINPSDEFNAME);
    }

    public final String getBEGINPSDEFNAME() {
        return this.GetParamStringValue(TAG_BEGINPSDEFNAME, "");
    }

    public final void setBEGINPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_BEGINPSDEFNAME, strValue);
    }

    public final boolean isENDPSDEFIDNull() {
        return this.IsParamNull(TAG_ENDPSDEFID);
    }

    public final String getENDPSDEFID() {
        return this.GetParamStringValue(TAG_ENDPSDEFID, "");
    }

    public final void setENDPSDEFID(String strValue) {
        this.SetParamValue(TAG_ENDPSDEFID, strValue);
    }

    public final boolean isENDPSDEFNAMENull() {
        return this.IsParamNull(TAG_ENDPSDEFNAME);
    }

    public final String getENDPSDEFNAME() {
        return this.GetParamStringValue(TAG_ENDPSDEFNAME, "");
    }

    public final void setENDPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_ENDPSDEFNAME, strValue);
    }

    public final boolean isMAXSIZENull() {
        return this.IsParamNull(TAG_MAXSIZE);
    }

    public final int getMAXSIZE() {
        return this.GetParamIntValue(TAG_MAXSIZE, 0);
    }

    public final void setMAXSIZE(int nValue) {
        this.SetParamValue(TAG_MAXSIZE, nValue);
    }

    public final boolean isMODELOBJNull() {
        return this.IsParamNull(TAG_MODELOBJ);
    }

    public final String getMODELOBJ() {
        return this.GetParamStringValue(TAG_MODELOBJ, "");
    }

    public final void setMODELOBJ(String strValue) {
        this.SetParamValue(TAG_MODELOBJ, strValue);
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

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
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

    public final boolean isPSDETOOLBARIDNull() {
        return this.IsParamNull(TAG_PSDETOOLBARID);
    }

    public final String getPSDETOOLBARID() {
        return this.GetParamStringValue(TAG_PSDETOOLBARID, "");
    }

    public final void setPSDETOOLBARID(String strValue) {
        this.SetParamValue(TAG_PSDETOOLBARID, strValue);
    }

    public final boolean isPSDETOOLBARNAMENull() {
        return this.IsParamNull(TAG_PSDETOOLBARNAME);
    }

    public final String getPSDETOOLBARNAME() {
        return this.GetParamStringValue(TAG_PSDETOOLBARNAME, "");
    }

    public final void setPSDETOOLBARNAME(String strValue) {
        this.SetParamValue(TAG_PSDETOOLBARNAME, strValue);
    }

    public final boolean isENABLEVIEWACTIONSNull() {
        return this.IsParamNull(TAG_ENABLEVIEWACTIONS);
    }

    public final boolean getENABLEVIEWACTIONS() {
        return this.GetParamIntValue(TAG_ENABLEVIEWACTIONS, 0) == 1;
    }

    public final void setENABLEVIEWACTIONS(boolean bValue) {
        this.SetParamValue(TAG_ENABLEVIEWACTIONS, bValue ? 1 : 0);
    }

    public final boolean isVIEWACTIONSNull() {
        return this.IsParamNull(TAG_VIEWACTIONS);
    }

    public final int getVIEWACTIONS() {
        return this.GetParamIntValue(TAG_VIEWACTIONS, 0);
    }

    public final void setVIEWACTIONS(int nValue) {
        this.SetParamValue(TAG_VIEWACTIONS, nValue);
    }

    public final boolean isREMOVEPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_REMOVEPSDEACTIONID);
    }

    public final String getREMOVEPSDEACTIONID() {
        return this.GetParamStringValue(TAG_REMOVEPSDEACTIONID, "");
    }

    public final void setREMOVEPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_REMOVEPSDEACTIONID, strValue);
    }

    public final boolean isREMOVEPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_REMOVEPSDEACTIONNAME);
    }

    public final String getREMOVEPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_REMOVEPSDEACTIONNAME, "");
    }

    public final void setREMOVEPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_REMOVEPSDEACTIONNAME, strValue);
    }

    public final boolean isCREATEPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_CREATEPSDEACTIONID);
    }

    public final String getCREATEPSDEACTIONID() {
        return this.GetParamStringValue(TAG_CREATEPSDEACTIONID, "");
    }

    public final void setCREATEPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_CREATEPSDEACTIONID, strValue);
    }

    public final boolean isCREATEPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_CREATEPSDEACTIONNAME);
    }

    public final String getCREATEPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_CREATEPSDEACTIONNAME, "");
    }

    public final void setCREATEPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_CREATEPSDEACTIONNAME, strValue);
    }

    public final boolean isUPDATEPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_UPDATEPSDEACTIONID);
    }

    public final String getUPDATEPSDEACTIONID() {
        return this.GetParamStringValue(TAG_UPDATEPSDEACTIONID, "");
    }

    public final void setUPDATEPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_UPDATEPSDEACTIONID, strValue);
    }

    public final boolean isUPDATEPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_UPDATEPSDEACTIONNAME);
    }

    public final String getUPDATEPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_UPDATEPSDEACTIONNAME, "");
    }

    public final void setUPDATEPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_UPDATEPSDEACTIONNAME, strValue);
    }

    public final boolean isCREATEPSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_CREATEPSDEOPPRIVID);
    }

    public final String getCREATEPSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_CREATEPSDEOPPRIVID, "");
    }

    public final void setCREATEPSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_CREATEPSDEOPPRIVID, strValue);
    }

    public final boolean isCREATEPSDEOPPRIVNAMENull() {
        return this.IsParamNull(TAG_CREATEPSDEOPPRIVNAME);
    }

    public final String getCREATEPSDEOPPRIVNAME() {
        return this.GetParamStringValue(TAG_CREATEPSDEOPPRIVNAME, "");
    }

    public final void setCREATEPSDEOPPRIVNAME(String strValue) {
        this.SetParamValue(TAG_CREATEPSDEOPPRIVNAME, strValue);
    }

    public final boolean isUPDATEPSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_UPDATEPSDEOPPRIVID);
    }

    public final String getUPDATEPSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_UPDATEPSDEOPPRIVID, "");
    }

    public final void setUPDATEPSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_UPDATEPSDEOPPRIVID, strValue);
    }

    public final boolean isUPDATEPSDEOPPRIVNAMENull() {
        return this.IsParamNull(TAG_UPDATEPSDEOPPRIVNAME);
    }

    public final String getUPDATEPSDEOPPRIVNAME() {
        return this.GetParamStringValue(TAG_UPDATEPSDEOPPRIVNAME, "");
    }

    public final void setUPDATEPSDEOPPRIVNAME(String strValue) {
        this.SetParamValue(TAG_UPDATEPSDEOPPRIVNAME, strValue);
    }

    public final boolean isORDERVALUEPSDEFIDNull() {
        return this.IsParamNull(TAG_ORDERVALUEPSDEFID);
    }

    public final String getORDERVALUEPSDEFID() {
        return this.GetParamStringValue(TAG_ORDERVALUEPSDEFID, "");
    }

    public final void setORDERVALUEPSDEFID(String strValue) {
        this.SetParamValue(TAG_ORDERVALUEPSDEFID, strValue);
    }

    public final boolean isORDERVALUEPSDEFNAMENull() {
        return this.IsParamNull(TAG_ORDERVALUEPSDEFNAME);
    }

    public final String getORDERVALUEPSDEFNAME() {
        return this.GetParamStringValue(TAG_ORDERVALUEPSDEFNAME, "");
    }

    public final void setORDERVALUEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_ORDERVALUEPSDEFNAME, strValue);
    }

    public final boolean isPKEYPSDEFIDNull() {
        return this.IsParamNull(TAG_PKEYPSDEFID);
    }

    public final String getPKEYPSDEFID() {
        return this.GetParamStringValue(TAG_PKEYPSDEFID, "");
    }

    public final void setPKEYPSDEFID(String strValue) {
        this.SetParamValue(TAG_PKEYPSDEFID, strValue);
    }

    public final boolean isPKEYPSDEFNAMENull() {
        return this.IsParamNull(TAG_PKEYPSDEFNAME);
    }

    public final String getPKEYPSDEFNAME() {
        return this.GetParamStringValue(TAG_PKEYPSDEFNAME, "");
    }

    public final void setPKEYPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PKEYPSDEFNAME, strValue);
    }

    public final boolean isTAGPSDEFIDNull() {
        return this.IsParamNull(TAG_TAGPSDEFID);
    }

    public final String getTAGPSDEFID() {
        return this.GetParamStringValue(TAG_TAGPSDEFID, "");
    }

    public final void setTAGPSDEFID(String strValue) {
        this.SetParamValue(TAG_TAGPSDEFID, strValue);
    }

    public final boolean isTAGPSDEFNAMENull() {
        return this.IsParamNull(TAG_TAGPSDEFNAME);
    }

    public final String getTAGPSDEFNAME() {
        return this.GetParamStringValue(TAG_TAGPSDEFNAME, "");
    }

    public final void setTAGPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TAGPSDEFNAME, strValue);
    }

    public final boolean isTAG2PSDEFIDNull() {
        return this.IsParamNull(TAG_TAG2PSDEFID);
    }

    public final String getTAG2PSDEFID() {
        return this.GetParamStringValue(TAG_TAG2PSDEFID, "");
    }

    public final void setTAG2PSDEFID(String strValue) {
        this.SetParamValue(TAG_TAG2PSDEFID, strValue);
    }

    public final boolean isTAG2PSDEFNAMENull() {
        return this.IsParamNull(TAG_TAG2PSDEFNAME);
    }

    public final String getTAG2PSDEFNAME() {
        return this.GetParamStringValue(TAG_TAG2PSDEFNAME, "");
    }

    public final void setTAG2PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TAG2PSDEFNAME, strValue);
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

    public final boolean isTOTALPSDEFIDNull() {
        return this.IsParamNull(TAG_TOTALPSDEFID);
    }

    public final String getTOTALPSDEFID() {
        return this.GetParamStringValue(TAG_TOTALPSDEFID, "");
    }

    public final void setTOTALPSDEFID(String strValue) {
        this.SetParamValue(TAG_TOTALPSDEFID, strValue);
    }

    public final boolean isTOTALPSDEFNAMENull() {
        return this.IsParamNull(TAG_TOTALPSDEFNAME);
    }

    public final String getTOTALPSDEFNAME() {
        return this.GetParamStringValue(TAG_TOTALPSDEFNAME, "");
    }

    public final void setTOTALPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TOTALPSDEFNAME, strValue);
    }

    public final boolean isFINISHPSDEFIDNull() {
        return this.IsParamNull(TAG_FINISHPSDEFID);
    }

    public final String getFINISHPSDEFID() {
        return this.GetParamStringValue(TAG_FINISHPSDEFID, "");
    }

    public final void setFINISHPSDEFID(String strValue) {
        this.SetParamValue(TAG_FINISHPSDEFID, strValue);
    }

    public final boolean isFINISHPSDEFNAMENull() {
        return this.IsParamNull(TAG_FINISHPSDEFNAME);
    }

    public final String getFINISHPSDEFNAME() {
        return this.GetParamStringValue(TAG_FINISHPSDEFNAME, "");
    }

    public final void setFINISHPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_FINISHPSDEFNAME, strValue);
    }

    public final boolean isLEVELPSDEFIDNull() {
        return this.IsParamNull(TAG_LEVELPSDEFID);
    }

    public final String getLEVELPSDEFID() {
        return this.GetParamStringValue(TAG_LEVELPSDEFID, "");
    }

    public final void setLEVELPSDEFID(String strValue) {
        this.SetParamValue(TAG_LEVELPSDEFID, strValue);
    }

    public final boolean isLEVELPSDEFNAMENull() {
        return this.IsParamNull(TAG_LEVELPSDEFNAME);
    }

    public final String getLEVELPSDEFNAME() {
        return this.GetParamStringValue(TAG_LEVELPSDEFNAME, "");
    }

    public final void setLEVELPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_LEVELPSDEFNAME, strValue);
    }

    public final boolean isPSSYSVIEWPANELIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELID);
    }

    public final String getPSSYSVIEWPANELID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELID, "");
    }

    public final void setPSSYSVIEWPANELID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELID, strValue);
    }

    public final boolean isPSSYSVIEWPANELNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELNAME);
    }

    public final String getPSSYSVIEWPANELNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELNAME, "");
    }

    public final void setPSSYSVIEWPANELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELNAME, strValue);
    }

    public final boolean isGANTTPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_GANTTPSSYSPFPLUGINID);
    }

    public final String getGANTTPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_GANTTPSSYSPFPLUGINID, "");
    }

    public final void setGANTTPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_GANTTPSSYSPFPLUGINID, strValue);
    }

    public final boolean isGANTTPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_GANTTPSSYSPFPLUGINNAME);
    }

    public final String getGANTTPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_GANTTPSSYSPFPLUGINNAME, "");
    }

    public final void setGANTTPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_GANTTPSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isITEMSTYLENull() {
        return this.IsParamNull(TAG_ITEMSTYLE);
    }

    public final String getITEMSTYLE() {
        return this.GetParamStringValue(TAG_ITEMSTYLE, "");
    }

    public final void setITEMSTYLE(String strValue) {
        this.SetParamValue(TAG_ITEMSTYLE, strValue);
    }

    public final boolean isCUSTOMCONDNull() {
        return this.IsParamNull(TAG_CUSTOMCOND);
    }

    public final String getCUSTOMCOND() {
        return this.GetParamStringValue(TAG_CUSTOMCOND, "");
    }

    public final void setCUSTOMCOND(String strValue) {
        this.SetParamValue(TAG_CUSTOMCOND, strValue);
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

    public final boolean isNAMEPSLANRESIDNull() {
        return this.IsParamNull(TAG_NAMEPSLANRESID);
    }

    public final String getNAMEPSLANRESID() {
        return this.GetParamStringValue(TAG_NAMEPSLANRESID, "");
    }

    public final void setNAMEPSLANRESID(String strValue) {
        this.SetParamValue(TAG_NAMEPSLANRESID, strValue);
    }

    public final boolean isNAMEPSLANRESNAMENull() {
        return this.IsParamNull(TAG_NAMEPSLANRESNAME);
    }

    public final String getNAMEPSLANRESNAME() {
        return this.GetParamStringValue(TAG_NAMEPSLANRESNAME, "");
    }

    public final void setNAMEPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_NAMEPSLANRESNAME, strValue);
    }

    public final boolean isDATAPSDEFIDNull() {
        return this.IsParamNull(TAG_DATAPSDEFID);
    }

    public final String getDATAPSDEFID() {
        return this.GetParamStringValue(TAG_DATAPSDEFID, "");
    }

    public final void setDATAPSDEFID(String strValue) {
        this.SetParamValue(TAG_DATAPSDEFID, strValue);
    }

    public final boolean isDATAPSDEFNAMENull() {
        return this.IsParamNull(TAG_DATAPSDEFNAME);
    }

    public final String getDATAPSDEFNAME() {
        return this.GetParamStringValue(TAG_DATAPSDEFNAME, "");
    }

    public final void setDATAPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_DATAPSDEFNAME, strValue);
    }

    public final boolean isDATA2PSDEFIDNull() {
        return this.IsParamNull(TAG_DATA2PSDEFID);
    }

    public final String getDATA2PSDEFID() {
        return this.GetParamStringValue(TAG_DATA2PSDEFID, "");
    }

    public final void setDATA2PSDEFID(String strValue) {
        this.SetParamValue(TAG_DATA2PSDEFID, strValue);
    }

    public final boolean isDATA2PSDEFNAMENull() {
        return this.IsParamNull(TAG_DATA2PSDEFNAME);
    }

    public final String getDATA2PSDEFNAME() {
        return this.GetParamStringValue(TAG_DATA2PSDEFNAME, "");
    }

    public final void setDATA2PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_DATA2PSDEFNAME, strValue);
    }

    public final boolean isPSSYSIMAGEIDNull() {
        return this.IsParamNull(TAG_PSSYSIMAGEID);
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

    public final boolean isEDITMODENull() {
        return this.IsParamNull(TAG_EDITMODE);
    }

    public final int getEDITMODE() {
        return this.GetParamIntValue(TAG_EDITMODE, 0);
    }

    public final void setEDITMODE(int nValue) {
        this.SetParamValue(TAG_EDITMODE, nValue);
    }

    public final boolean isCLSPSDEFIDNull() {
        return this.IsParamNull(TAG_CLSPSDEFID);
    }

    public final String getCLSPSDEFID() {
        return this.GetParamStringValue(TAG_CLSPSDEFID, "");
    }

    public final void setCLSPSDEFID(String strValue) {
        this.SetParamValue(TAG_CLSPSDEFID, strValue);
    }

    public final boolean isCLSPSDEFNAMENull() {
        return this.IsParamNull(TAG_CLSPSDEFNAME);
    }

    public final String getCLSPSDEFNAME() {
        return this.GetParamStringValue(TAG_CLSPSDEFNAME, "");
    }

    public final void setCLSPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_CLSPSDEFNAME, strValue);
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

    public final boolean isLINKPSDEFIDNull() {
        return this.IsParamNull(TAG_LINKPSDEFID);
    }

    public final String getLINKPSDEFID() {
        return this.GetParamStringValue(TAG_LINKPSDEFID, "");
    }

    public final void setLINKPSDEFID(String strValue) {
        this.SetParamValue(TAG_LINKPSDEFID, strValue);
    }

    public final boolean isLINKPSDEFNAMENull() {
        return this.IsParamNull(TAG_LINKPSDEFNAME);
    }

    public final String getLINKPSDEFNAME() {
        return this.GetParamStringValue(TAG_LINKPSDEFNAME, "");
    }

    public final void setLINKPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_LINKPSDEFNAME, strValue);
    }

    public ArrayList<PSSysCalendarItemRV> getPSSysCalendarItemRVs(boolean bCreated) {
        if (this.psSysCalendarItemRVList != null) {
            return this.psSysCalendarItemRVList;
        }
        if (bCreated) {
            this.psSysCalendarItemRVList = new ArrayList();
        }
        return this.psSysCalendarItemRVList;
    }
}

