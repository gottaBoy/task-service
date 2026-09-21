/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEListItem
extends BaseDataEntity {
    public static final String GROUPITEM_GROUP1 = "GROUP1";
    public static final String GROUPITEM_GROUP2 = "GROUP2";
    public static final String GROUPITEM_GROUP3 = "GROUP3";
    public static final String GROUPITEM_GROUP4 = "GROUP4";
    public static final String WIDTHUNIT_PX = "PX";
    public static final String WIDTHUNIT_STAR = "STAR";
    public static final String CLCONVERTMODE_NONE = "NONE";
    public static final String CLCONVERTMODE_FRONT = "FRONT";
    public static final String CLCONVERTMODE_BACKEND = "BACKEND";
    public static final String ITEMTYPE_TEXTITEM = "TEXTITEM";
    public static final String ITEMTYPE_ACTIONITEM = "ACTIONITEM";
    public static final String ITEMTYPE_DATAITEM = "DATAITEM";
    public static final String ALIGN_LEFT = "LEFT";
    public static final String ALIGN_CENTER = "CENTER";
    public static final String ALIGN_RIGHT = "RIGHT";
    public static final String TAG_CLCONVERTMODE = "CLCONVERTMODE";
    public static final String TAG_PSDELISTITEMID = "PSDELISTITEMID";
    public static final String TAG_PSDELISTITEMNAME = "PSDELISTITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDELISTID = "PSDELISTID";
    public static final String TAG_PSDELISTNAME = "PSDELISTNAME";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_WIDTHUNIT = "WIDTHUNIT";
    public static final String TAG_ITEMTYPE = "ITEMTYPE";
    public static final String TAG_NOSORT = "NOSORT";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_LCRPSSYSPFPLUGINID = "LCRPSSYSPFPLUGINID";
    public static final String TAG_LCRPSSYSPFPLUGINNAME = "LCRPSSYSPFPLUGINNAME";
    public static final String TAG_VALUEFORMAT = "VALUEFORMAT";
    public static final String TAG_ALIGN = "ALIGN";
    public static final String TAG_DATAITEMS = "DATAITEMS";
    public static final String TAG_PSDEDATAVIEWID = "PSDEDATAVIEWID";
    public static final String TAG_PSDEDATAVIEWNAME = "PSDEDATAVIEWNAME";
    public static final String TAG_ENABLEITEMPRIV = "ENABLEITEMPRIV";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String TAG_GROUPITEM = "GROUPITEM";
    public static final String TAG_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String TAG_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";

    public final boolean isPSDELISTITEMIDNull() {
        return this.IsParamNull(TAG_PSDELISTITEMID);
    }

    public final String getPSDELISTITEMID() {
        return this.GetParamStringValue(TAG_PSDELISTITEMID, "");
    }

    public final void setPSDELISTITEMID(String strValue) {
        this.SetParamValue(TAG_PSDELISTITEMID, strValue);
    }

    public final boolean isPSDELISTITEMNAMENull() {
        return this.IsParamNull(TAG_PSDELISTITEMNAME);
    }

    public final String getPSDELISTITEMNAME() {
        return this.GetParamStringValue(TAG_PSDELISTITEMNAME, "");
    }

    public final void setPSDELISTITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSDELISTITEMNAME, strValue);
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

    public final boolean isPSDELISTIDNull() {
        return this.IsParamNull(TAG_PSDELISTID);
    }

    public final String getPSDELISTID() {
        return this.GetParamStringValue(TAG_PSDELISTID, "");
    }

    public final void setPSDELISTID(String strValue) {
        this.SetParamValue(TAG_PSDELISTID, strValue);
    }

    public final boolean isPSDELISTNAMENull() {
        return this.IsParamNull(TAG_PSDELISTNAME);
    }

    public final String getPSDELISTNAME() {
        return this.GetParamStringValue(TAG_PSDELISTNAME, "");
    }

    public final void setPSDELISTNAME(String strValue) {
        this.SetParamValue(TAG_PSDELISTNAME, strValue);
    }

    public final boolean isCAPTIONNull() {
        return this.IsParamNull(TAG_CAPTION);
    }

    public final String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public final void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
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

    public final boolean isWIDTHUNITNull() {
        return this.IsParamNull(TAG_WIDTHUNIT);
    }

    public final String getWIDTHUNIT() {
        return this.GetParamStringValue(TAG_WIDTHUNIT, "");
    }

    public final void setWIDTHUNIT(String strValue) {
        this.SetParamValue(TAG_WIDTHUNIT, strValue);
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

    public final boolean isNOSORTNull() {
        return this.IsParamNull(TAG_NOSORT);
    }

    public final boolean getNOSORT() {
        return this.GetParamIntValue(TAG_NOSORT, 0) == 1;
    }

    public final void setNOSORT(boolean bValue) {
        this.SetParamValue(TAG_NOSORT, bValue ? 1 : 0);
    }

    public final boolean isPSCODELISTIDNull() {
        return this.IsParamNull(TAG_PSCODELISTID);
    }

    public final String getPSCODELISTID() {
        return this.GetParamStringValue(TAG_PSCODELISTID, "");
    }

    public final void setPSCODELISTID(String strValue) {
        this.SetParamValue(TAG_PSCODELISTID, strValue);
    }

    public final boolean isPSCODELISTNAMENull() {
        return this.IsParamNull(TAG_PSCODELISTNAME);
    }

    public final String getPSCODELISTNAME() {
        return this.GetParamStringValue(TAG_PSCODELISTNAME, "");
    }

    public final void setPSCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_PSCODELISTNAME, strValue);
    }

    public final boolean isLCRPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_LCRPSSYSPFPLUGINID);
    }

    public final String getLCRPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_LCRPSSYSPFPLUGINID, "");
    }

    public final void setLCRPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_LCRPSSYSPFPLUGINID, strValue);
    }

    public final boolean isLCRPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_LCRPSSYSPFPLUGINNAME);
    }

    public final String getLCRPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_LCRPSSYSPFPLUGINNAME, "");
    }

    public final void setLCRPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_LCRPSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isVALUEFORMATNull() {
        return this.IsParamNull(TAG_VALUEFORMAT);
    }

    public final String getVALUEFORMAT() {
        return this.GetParamStringValue(TAG_VALUEFORMAT, "");
    }

    public final void setVALUEFORMAT(String strValue) {
        this.SetParamValue(TAG_VALUEFORMAT, strValue);
    }

    public final boolean isALIGNNull() {
        return this.IsParamNull(TAG_ALIGN);
    }

    public final String getALIGN() {
        return this.GetParamStringValue(TAG_ALIGN, "");
    }

    public final void setALIGN(String strValue) {
        this.SetParamValue(TAG_ALIGN, strValue);
    }

    public final boolean isDATAITEMSNull() {
        return this.IsParamNull(TAG_DATAITEMS);
    }

    public final String getDATAITEMS() {
        return this.GetParamStringValue(TAG_DATAITEMS, "");
    }

    public final void setDATAITEMS(String strValue) {
        this.SetParamValue(TAG_DATAITEMS, strValue);
    }

    public final boolean isPSDEDATAVIEWIDNull() {
        return this.IsParamNull(TAG_PSDEDATAVIEWID);
    }

    public final String getPSDEDATAVIEWID() {
        return this.GetParamStringValue(TAG_PSDEDATAVIEWID, "");
    }

    public final void setPSDEDATAVIEWID(String strValue) {
        this.SetParamValue(TAG_PSDEDATAVIEWID, strValue);
    }

    public final boolean isPSDEDATAVIEWNAMENull() {
        return this.IsParamNull(TAG_PSDEDATAVIEWNAME);
    }

    public final String getPSDEDATAVIEWNAME() {
        return this.GetParamStringValue(TAG_PSDEDATAVIEWNAME, "");
    }

    public final void setPSDEDATAVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDATAVIEWNAME, strValue);
    }

    public final boolean isCLCONVERTMODENull() {
        return this.IsParamNull(TAG_CLCONVERTMODE);
    }

    public final String getCLCONVERTMODE() {
        return this.GetParamStringValue(TAG_CLCONVERTMODE, "");
    }

    public final void setCLCONVERTMODE(String strValue) {
        this.SetParamValue(TAG_CLCONVERTMODE, strValue);
    }

    public final boolean isENABLEITEMPRIVNull() {
        return this.IsParamNull(TAG_ENABLEITEMPRIV);
    }

    public final boolean getENABLEITEMPRIV() {
        return this.GetParamIntValue(TAG_ENABLEITEMPRIV, 0) == 1;
    }

    public final void setENABLEITEMPRIV(boolean bValue) {
        this.SetParamValue(TAG_ENABLEITEMPRIV, bValue ? 1 : 0);
    }

    public final boolean isCAPPSLANRESIDNull() {
        return this.IsParamNull(TAG_CAPPSLANRESID);
    }

    public final String getCAPPSLANRESID() {
        return this.GetParamStringValue(TAG_CAPPSLANRESID, "");
    }

    public final void setCAPPSLANRESID(String strValue) {
        this.SetParamValue(TAG_CAPPSLANRESID, strValue);
    }

    public final boolean isCAPPSLANRESNAMENull() {
        return this.IsParamNull(TAG_CAPPSLANRESNAME);
    }

    public final String getCAPPSLANRESNAME() {
        return this.GetParamStringValue(TAG_CAPPSLANRESNAME, "");
    }

    public final void setCAPPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_CAPPSLANRESNAME, strValue);
    }

    public final boolean isGROUPITEMNull() {
        return this.IsParamNull(TAG_GROUPITEM);
    }

    public final String getGROUPITEM() {
        return this.GetParamStringValue(TAG_GROUPITEM, "");
    }

    public final void setGROUPITEM(String strValue) {
        this.SetParamValue(TAG_GROUPITEM, strValue);
    }

    public final boolean isPSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_PSDEUAGROUPID);
    }

    public final String getPSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_PSDEUAGROUPID, "");
    }

    public final void setPSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_PSDEUAGROUPID, strValue);
    }

    public final boolean isPSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_PSDEUAGROUPNAME);
    }

    public final String getPSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_PSDEUAGROUPNAME, "");
    }

    public final void setPSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEUAGROUPNAME, strValue);
    }

    public final boolean isCUSTOMCODENull() {
        return this.IsParamNull(TAG_CUSTOMCODE);
    }

    public final String getCUSTOMCODE() {
        return this.GetParamStringValue(TAG_CUSTOMCODE, "");
    }

    public final void setCUSTOMCODE(String strValue) {
        this.SetParamValue(TAG_CUSTOMCODE, strValue);
    }

    public final boolean isCUSTOMMODENull() {
        return this.IsParamNull(TAG_CUSTOMMODE);
    }

    public final boolean getCUSTOMMODE() {
        return this.GetParamIntValue(TAG_CUSTOMMODE, 0) == 1;
    }

    public final void setCUSTOMMODE(boolean bValue) {
        this.SetParamValue(TAG_CUSTOMMODE, bValue ? 1 : 0);
    }
}

