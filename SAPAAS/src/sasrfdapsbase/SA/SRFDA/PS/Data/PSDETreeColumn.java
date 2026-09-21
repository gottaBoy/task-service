/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDETreeColumn
extends BaseDataEntity {
    public static final String WIDTHUNIT_PX = "PX";
    public static final String WIDTHUNIT_STAR = "STAR";
    public static final String ALIGN_LEFT = "LEFT";
    public static final String ALIGN_CENTER = "CENTER";
    public static final String ALIGN_RIGHT = "RIGHT";
    public static final String GRIDCOLTYPE_DEFGRIDCOLUMN = "DEFGRIDCOLUMN";
    public static final String GRIDCOLTYPE_DEFTREEGRIDCOLUMN = "DEFTREEGRIDCOLUMN";
    public static final String GRIDCOLTYPE_UAGRIDCOLUMN = "UAGRIDCOLUMN";
    public static final String GRIDCOLTYPE_SUMMARYGRIDCOLUMN = "SUMMARYGRIDCOLUMN";
    public static final String GRIDCOLSTYLE_USER = "USER";
    public static final String GRIDCOLSTYLE_USER2 = "USER2";
    public static final String TAG_PSDETREECOLID = "PSDETREECOLID";
    public static final String TAG_PSDETREECOLNAME = "PSDETREECOLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String TAG_PSDETREEVIEWNAME = "PSDETREEVIEWNAME";
    public static final String TAG_WIDTHUNIT = "WIDTHUNIT";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_NOSORT = "NOSORT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_ALIGN = "ALIGN";
    public static final String TAG_GCRPSSYSPFPLUGINID = "GCRPSSYSPFPLUGINID";
    public static final String TAG_GCRPSSYSPFPLUGINNAME = "GCRPSSYSPFPLUGINNAME";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_HIDEDEFAULT = "HIDEDEFAULT";
    public static final String TAG_GRIDCOLTYPE = "GRIDCOLTYPE";
    public static final String TAG_GRIDCOLSTYLE = "GRIDCOLSTYLE";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String TAG_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String TAG_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String TAG_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String TAG_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String TAG_HEADERPSSYSCSSID = "HEADERPSSYSCSSID";
    public static final String TAG_HEADERPSSYSCSSNAME = "HEADERPSSYSCSSNAME";
    public static final String TAG_CELLPSSYSCSSID = "CELLPSSYSCSSID";
    public static final String TAG_CELLPSSYSCSSNAME = "CELLPSSYSCSSNAME";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_NOPRIVDM = "NOPRIVDM";
    public static final String TAG_ENABLELINK = "ENABLELINK";
    public static final String TAG_COLENABLEFILTER = "COLENABLEFILTER";

    public final boolean isPSDETREECOLIDNull() {
        return this.IsParamNull(TAG_PSDETREECOLID);
    }

    public final String getPSDETREECOLID() {
        return this.GetParamStringValue(TAG_PSDETREECOLID, "");
    }

    public final void setPSDETREECOLID(String strValue) {
        this.SetParamValue(TAG_PSDETREECOLID, strValue);
    }

    public final boolean isPSDETREECOLNAMENull() {
        return this.IsParamNull(TAG_PSDETREECOLNAME);
    }

    public final String getPSDETREECOLNAME() {
        return this.GetParamStringValue(TAG_PSDETREECOLNAME, "");
    }

    public final void setPSDETREECOLNAME(String strValue) {
        this.SetParamValue(TAG_PSDETREECOLNAME, strValue);
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

    public final boolean isPSDETREEVIEWIDNull() {
        return this.IsParamNull(TAG_PSDETREEVIEWID);
    }

    public final String getPSDETREEVIEWID() {
        return this.GetParamStringValue(TAG_PSDETREEVIEWID, "");
    }

    public final void setPSDETREEVIEWID(String strValue) {
        this.SetParamValue(TAG_PSDETREEVIEWID, strValue);
    }

    public final boolean isPSDETREEVIEWNAMENull() {
        return this.IsParamNull(TAG_PSDETREEVIEWNAME);
    }

    public final String getPSDETREEVIEWNAME() {
        return this.GetParamStringValue(TAG_PSDETREEVIEWNAME, "");
    }

    public final void setPSDETREEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSDETREEVIEWNAME, strValue);
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

    public final boolean isWIDTHNull() {
        return this.IsParamNull(TAG_WIDTH);
    }

    public final int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public final void setWIDTH(int nValue) {
        this.SetParamValue(TAG_WIDTH, nValue);
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

    public final boolean isNOSORTNull() {
        return this.IsParamNull(TAG_NOSORT);
    }

    public final boolean getNOSORT() {
        return this.GetParamIntValue(TAG_NOSORT, 0) == 1;
    }

    public final void setNOSORT(boolean bValue) {
        this.SetParamValue(TAG_NOSORT, bValue ? 1 : 0);
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

    public final boolean isCAPTIONNull() {
        return this.IsParamNull(TAG_CAPTION);
    }

    public final String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public final void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
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

    public final boolean isALIGNNull() {
        return this.IsParamNull(TAG_ALIGN);
    }

    public final String getALIGN() {
        return this.GetParamStringValue(TAG_ALIGN, "");
    }

    public final void setALIGN(String strValue) {
        this.SetParamValue(TAG_ALIGN, strValue);
    }

    public final boolean isGCRPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_GCRPSSYSPFPLUGINID);
    }

    public final String getGCRPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_GCRPSSYSPFPLUGINID, "");
    }

    public final void setGCRPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_GCRPSSYSPFPLUGINID, strValue);
    }

    public final boolean isGCRPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_GCRPSSYSPFPLUGINNAME);
    }

    public final String getGCRPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_GCRPSSYSPFPLUGINNAME, "");
    }

    public final void setGCRPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_GCRPSSYSPFPLUGINNAME, strValue);
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

    public final boolean isHIDEDEFAULTNull() {
        return this.IsParamNull(TAG_HIDEDEFAULT);
    }

    public final int getHIDEDEFAULT() {
        return this.GetParamIntValue(TAG_HIDEDEFAULT, 0);
    }

    public final void setHIDEDEFAULT(int bValue) {
        this.SetParamValue(TAG_HIDEDEFAULT, bValue);
    }

    public final boolean isGRIDCOLTYPENull() {
        return this.IsParamNull(TAG_GRIDCOLTYPE);
    }

    public final String getGRIDCOLTYPE() {
        return this.GetParamStringValue(TAG_GRIDCOLTYPE, "");
    }

    public final void setGRIDCOLTYPE(String strValue) {
        this.SetParamValue(TAG_GRIDCOLTYPE, strValue);
    }

    public final boolean isGRIDCOLSTYLENull() {
        return this.IsParamNull(TAG_GRIDCOLSTYLE);
    }

    public final String getGRIDCOLSTYLE() {
        return this.GetParamStringValue(TAG_GRIDCOLSTYLE, "");
    }

    public final void setGRIDCOLSTYLE(String strValue) {
        this.SetParamValue(TAG_GRIDCOLSTYLE, strValue);
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

    public final boolean isPSDEUIACTIONIDNull() {
        return this.IsParamNull(TAG_PSDEUIACTIONID);
    }

    public final String getPSDEUIACTIONID() {
        return this.GetParamStringValue(TAG_PSDEUIACTIONID, "");
    }

    public final void setPSDEUIACTIONID(String strValue) {
        this.SetParamValue(TAG_PSDEUIACTIONID, strValue);
    }

    public final boolean isPSDEUIACTIONNAMENull() {
        return this.IsParamNull(TAG_PSDEUIACTIONNAME);
    }

    public final String getPSDEUIACTIONNAME() {
        return this.GetParamStringValue(TAG_PSDEUIACTIONNAME, "");
    }

    public final void setPSDEUIACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDEUIACTIONNAME, strValue);
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

    public final boolean isPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELID);
    }

    public final String getPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELID, "");
    }

    public final void setPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELID, strValue);
    }

    public final boolean isPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELNAME);
    }

    public final String getPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELNAME, "");
    }

    public final void setPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELNAME, strValue);
    }

    public final boolean isDEFAULTVALUENull() {
        return this.IsParamNull(TAG_DEFAULTVALUE);
    }

    public final String getDEFAULTVALUE() {
        return this.GetParamStringValue(TAG_DEFAULTVALUE, "");
    }

    public final void setDEFAULTVALUE(String strValue) {
        this.SetParamValue(TAG_DEFAULTVALUE, strValue);
    }

    public final boolean isHEADERPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_HEADERPSSYSCSSID);
    }

    public final String getHEADERPSSYSCSSID() {
        return this.GetParamStringValue(TAG_HEADERPSSYSCSSID, "");
    }

    public final void setHEADERPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_HEADERPSSYSCSSID, strValue);
    }

    public final boolean isHEADERPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_HEADERPSSYSCSSNAME);
    }

    public final String getHEADERPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_HEADERPSSYSCSSNAME, "");
    }

    public final void setHEADERPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_HEADERPSSYSCSSNAME, strValue);
    }

    public final boolean isCELLPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_CELLPSSYSCSSID);
    }

    public final String getCELLPSSYSCSSID() {
        return this.GetParamStringValue(TAG_CELLPSSYSCSSID, "");
    }

    public final void setCELLPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_CELLPSSYSCSSID, strValue);
    }

    public final boolean isCELLPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_CELLPSSYSCSSNAME);
    }

    public final String getCELLPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_CELLPSSYSCSSNAME, "");
    }

    public final void setCELLPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_CELLPSSYSCSSNAME, strValue);
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

    public final boolean isNOPRIVDMNull() {
        return this.IsParamNull(TAG_NOPRIVDM);
    }

    public final int getNOPRIVDM() {
        return this.GetParamIntValue(TAG_NOPRIVDM, 0);
    }

    public final void setNOPRIVDM(int nValue) {
        this.SetParamValue(TAG_NOPRIVDM, nValue);
    }

    public final boolean isENABLELINKNull() {
        return this.IsParamNull(TAG_ENABLELINK);
    }

    public final int getENABLELINK() {
        return this.GetParamIntValue(TAG_ENABLELINK, 0);
    }

    public final void setENABLELINK(int nValue) {
        this.SetParamValue(TAG_ENABLELINK, nValue);
    }

    public final boolean isCOLENABLEFILTERNull() {
        return this.IsParamNull(TAG_COLENABLEFILTER);
    }

    public final int getCOLENABLEFILTER() {
        return this.GetParamIntValue(TAG_COLENABLEFILTER, 0);
    }

    public final void setCOLENABLEFILTER(int nValue) {
        this.SetParamValue(TAG_COLENABLEFILTER, nValue);
    }
}

