/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEUIActionGroupDetail
extends BaseDataEntity {
    public static final String DETAILTYPE_DEUIACTION = "DEUIACTION";
    public static final String DETAILTYPE_SEPERATOR = "SEPERATOR";
    public static final String TAG_PSDEUAGRPDETAILID = "PSDEUAGRPDETAILID";
    public static final String TAG_PSDEUAGRPDETAILNAME = "PSDEUAGRPDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String TAG_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String TAG_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String TAG_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_UIACTIONPARAMS = "UIACTIONPARAMS";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_DETAILTYPE = "DETAILTYPE";
    public static final String TAG_ADDSEPARATOR = "ADDSEPARATOR";
    public static final String TAG_SHOWMODE = "SHOWMODE";
    public static final String TAG_DETAILTAG = "DETAILTAG";
    public static final String TAG_DETAILTAG2 = "DETAILTAG2";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_ACTIONLEVEL = "ACTIONLEVEL";
    public static final String TAG_BEFOREITEMTYPE = "BEFOREITEMTYPE";
    public static final String TAG_AFTERITEMTYPE = "AFTERITEMTYPE";
    public static final String TAG_BEFOREPSSYSCSSID = "BEFOREPSSYSCSSID";
    public static final String TAG_BEFOREPSSYSCSSNAME = "BEFOREPSSYSCSSNAME";
    public static final String TAG_AFTERPSSYSCSSID = "AFTERPSSYSCSSID";
    public static final String TAG_AFTERPSSYSCSSNAME = "AFTERPSSYSCSSNAME";
    public static final String TAG_BEFOREPSSYSRESOURCEID = "BEFOREPSSYSRESOURCEID";
    public static final String TAG_BEFOREPSSYSRESOURCENAME = "BEFOREPSSYSRESOURCENAME";
    public static final String TAG_AFTERPSSYSRESOURCEID = "AFTERPSSYSRESOURCEID";
    public static final String TAG_AFTERPSSYSRESOURCENAME = "AFTERPSSYSRESOURCENAME";
    public static final String TAG_BEFORECONTENT = "BEFORECONTENT";
    public static final String TAG_AFTERCONTENT = "AFTERCONTENT";
    public static final String TAG_ENABLELOGIC = "ENABLELOGIC";
    public static final String TAG_VISIBLELOGIC = "VISIBLELOGIC";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_BUTTONSTYLE = "BUTTONSTYLE";
    public static final String TAG_REFPSDEUAGROUPID = "REFPSDEUAGROUPID";
    public static final String TAG_REFPSDEUAGROUPNAME = "REFPSDEUAGROUPNAME";

    public final boolean isPSDEUAGRPDETAILIDNull() {
        return this.IsParamNull(TAG_PSDEUAGRPDETAILID);
    }

    public final String getPSDEUAGRPDETAILID() {
        return this.GetParamStringValue(TAG_PSDEUAGRPDETAILID, "");
    }

    public final void setPSDEUAGRPDETAILID(String strValue) {
        this.SetParamValue(TAG_PSDEUAGRPDETAILID, strValue);
    }

    public final boolean isPSDEUAGRPDETAILNAMENull() {
        return this.IsParamNull(TAG_PSDEUAGRPDETAILNAME);
    }

    public final String getPSDEUAGRPDETAILNAME() {
        return this.GetParamStringValue(TAG_PSDEUAGRPDETAILNAME, "");
    }

    public final void setPSDEUAGRPDETAILNAME(String strValue) {
        this.SetParamValue(TAG_PSDEUAGRPDETAILNAME, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
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

    public final boolean isUIACTIONPARAMSNull() {
        return this.IsParamNull(TAG_UIACTIONPARAMS);
    }

    public final String getUIACTIONPARAMS() {
        return this.GetParamStringValue(TAG_UIACTIONPARAMS, "");
    }

    public final void setUIACTIONPARAMS(String strValue) {
        this.SetParamValue(TAG_UIACTIONPARAMS, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isDETAILTYPENull() {
        return this.IsParamNull(TAG_DETAILTYPE);
    }

    public final String getDETAILTYPE() {
        return this.GetParamStringValue(TAG_DETAILTYPE, "");
    }

    public final void setDETAILTYPE(String strValue) {
        this.SetParamValue(TAG_DETAILTYPE, strValue);
    }

    public final boolean isADDSEPARATORNull() {
        return this.IsParamNull(TAG_ADDSEPARATOR);
    }

    public final boolean getADDSEPARATOR() {
        return this.GetParamIntValue(TAG_ADDSEPARATOR, 0) == 1;
    }

    public final void setADDSEPARATOR(boolean bValue) {
        this.SetParamValue(TAG_ADDSEPARATOR, bValue ? 1 : 0);
    }

    public final boolean isSHOWMODENull() {
        return this.IsParamNull(TAG_SHOWMODE);
    }

    public final String getSHOWMODE() {
        return this.GetParamStringValue(TAG_SHOWMODE, "");
    }

    public final void setSHOWMODE(String strValue) {
        this.SetParamValue(TAG_SHOWMODE, strValue);
    }

    public final boolean isDETAILTAGNull() {
        return this.IsParamNull(TAG_DETAILTAG);
    }

    public final String getDETAILTAG() {
        return this.GetParamStringValue(TAG_DETAILTAG, "");
    }

    public final void setDETAILTAG(String strValue) {
        this.SetParamValue(TAG_DETAILTAG, strValue);
    }

    public final boolean isDETAILTAG2Null() {
        return this.IsParamNull(TAG_DETAILTAG2);
    }

    public final String getDETAILTAG2() {
        return this.GetParamStringValue(TAG_DETAILTAG2, "");
    }

    public final void setDETAILTAG2(String strValue) {
        this.SetParamValue(TAG_DETAILTAG2, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isACTIONLEVELNull() {
        return this.IsParamNull(TAG_ACTIONLEVEL);
    }

    public final int getACTIONLEVEL() {
        return this.GetParamIntValue(TAG_ACTIONLEVEL, 0);
    }

    public final void setACTIONLEVEL(int nValue) {
        this.SetParamValue(TAG_ACTIONLEVEL, nValue);
    }

    public final boolean isBEFOREITEMTYPENull() {
        return this.IsParamNull(TAG_BEFOREITEMTYPE);
    }

    public final String getBEFOREITEMTYPE() {
        return this.GetParamStringValue(TAG_BEFOREITEMTYPE, "");
    }

    public final void setBEFOREITEMTYPE(String strValue) {
        this.SetParamValue(TAG_BEFOREITEMTYPE, strValue);
    }

    public final boolean isAFTERITEMTYPENull() {
        return this.IsParamNull(TAG_AFTERITEMTYPE);
    }

    public final String getAFTERITEMTYPE() {
        return this.GetParamStringValue(TAG_AFTERITEMTYPE, "");
    }

    public final void setAFTERITEMTYPE(String strValue) {
        this.SetParamValue(TAG_AFTERITEMTYPE, strValue);
    }

    public final boolean isBEFOREPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_BEFOREPSSYSCSSID);
    }

    public final String getBEFOREPSSYSCSSID() {
        return this.GetParamStringValue(TAG_BEFOREPSSYSCSSID, "");
    }

    public final void setBEFOREPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_BEFOREPSSYSCSSID, strValue);
    }

    public final boolean isBEFOREPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_BEFOREPSSYSCSSNAME);
    }

    public final String getBEFOREPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_BEFOREPSSYSCSSNAME, "");
    }

    public final void setBEFOREPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_BEFOREPSSYSCSSNAME, strValue);
    }

    public final boolean isAFTERPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_AFTERPSSYSCSSID);
    }

    public final String getAFTERPSSYSCSSID() {
        return this.GetParamStringValue(TAG_AFTERPSSYSCSSID, "");
    }

    public final void setAFTERPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_AFTERPSSYSCSSID, strValue);
    }

    public final boolean isAFTERPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_AFTERPSSYSCSSNAME);
    }

    public final String getAFTERPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_AFTERPSSYSCSSNAME, "");
    }

    public final void setAFTERPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_AFTERPSSYSCSSNAME, strValue);
    }

    public final boolean isBEFOREPSSYSRESOURCEIDNull() {
        return this.IsParamNull(TAG_BEFOREPSSYSRESOURCEID);
    }

    public final String getBEFOREPSSYSRESOURCEID() {
        return this.GetParamStringValue(TAG_BEFOREPSSYSRESOURCEID, "");
    }

    public final void setBEFOREPSSYSRESOURCEID(String strValue) {
        this.SetParamValue(TAG_BEFOREPSSYSRESOURCEID, strValue);
    }

    public final boolean isBEFOREPSSYSRESOURCENAMENull() {
        return this.IsParamNull(TAG_BEFOREPSSYSRESOURCENAME);
    }

    public final String getBEFOREPSSYSRESOURCENAME() {
        return this.GetParamStringValue(TAG_BEFOREPSSYSRESOURCENAME, "");
    }

    public final void setBEFOREPSSYSRESOURCENAME(String strValue) {
        this.SetParamValue(TAG_BEFOREPSSYSRESOURCENAME, strValue);
    }

    public final boolean isAFTERPSSYSRESOURCEIDNull() {
        return this.IsParamNull(TAG_AFTERPSSYSRESOURCEID);
    }

    public final String getAFTERPSSYSRESOURCEID() {
        return this.GetParamStringValue(TAG_AFTERPSSYSRESOURCEID, "");
    }

    public final void setAFTERPSSYSRESOURCEID(String strValue) {
        this.SetParamValue(TAG_AFTERPSSYSRESOURCEID, strValue);
    }

    public final boolean isAFTERPSSYSRESOURCENAMENull() {
        return this.IsParamNull(TAG_AFTERPSSYSRESOURCENAME);
    }

    public final String getAFTERPSSYSRESOURCENAME() {
        return this.GetParamStringValue(TAG_AFTERPSSYSRESOURCENAME, "");
    }

    public final void setAFTERPSSYSRESOURCENAME(String strValue) {
        this.SetParamValue(TAG_AFTERPSSYSRESOURCENAME, strValue);
    }

    public final boolean isBEFORECONTENTNull() {
        return this.IsParamNull(TAG_BEFORECONTENT);
    }

    public final String getBEFORECONTENT() {
        return this.GetParamStringValue(TAG_BEFORECONTENT, "");
    }

    public final void setBEFORECONTENT(String strValue) {
        this.SetParamValue(TAG_BEFORECONTENT, strValue);
    }

    public final boolean isAFTERCONTENTNull() {
        return this.IsParamNull(TAG_AFTERCONTENT);
    }

    public final String getAFTERCONTENT() {
        return this.GetParamStringValue(TAG_AFTERCONTENT, "");
    }

    public final void setAFTERCONTENT(String strValue) {
        this.SetParamValue(TAG_AFTERCONTENT, strValue);
    }

    public final boolean isENABLELOGICNull() {
        return this.IsParamNull(TAG_ENABLELOGIC);
    }

    public final String getENABLELOGIC() {
        return this.GetParamStringValue(TAG_ENABLELOGIC, "");
    }

    public final void setENABLELOGIC(String strValue) {
        this.SetParamValue(TAG_ENABLELOGIC, strValue);
    }

    public final boolean isVISIBLELOGICNull() {
        return this.IsParamNull(TAG_VISIBLELOGIC);
    }

    public final String getVISIBLELOGIC() {
        return this.GetParamStringValue(TAG_VISIBLELOGIC, "");
    }

    public final void setVISIBLELOGIC(String strValue) {
        this.SetParamValue(TAG_VISIBLELOGIC, strValue);
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

    public final boolean isBUTTONSTYLENull() {
        return this.IsParamNull(TAG_BUTTONSTYLE);
    }

    public final String getBUTTONSTYLE() {
        return this.GetParamStringValue(TAG_BUTTONSTYLE, "");
    }

    public final void setBUTTONSTYLE(String strValue) {
        this.SetParamValue(TAG_BUTTONSTYLE, strValue);
    }

    public final boolean isREFPSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_REFPSDEUAGROUPID);
    }

    public final String getREFPSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_REFPSDEUAGROUPID, "");
    }

    public final void setREFPSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_REFPSDEUAGROUPID, strValue);
    }

    public final boolean isREFPSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_REFPSDEUAGROUPNAME);
    }

    public final String getREFPSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_REFPSDEUAGROUPNAME, "");
    }

    public final void setREFPSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_REFPSDEUAGROUPNAME, strValue);
    }
}

