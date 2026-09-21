/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEDRItem
extends BaseDataEntity {
    public static final String DRITEMTYPE_DER1N = "DER1N";
    public static final String DRITEMTYPE_SYSDER1N = "SYSDER1N";
    public static final String DRITEMTYPE_DER11 = "DER11";
    public static final String DRITEMTYPE_SYSDER11 = "SYSDER11";
    public static final String ENABLEMODE_ALL = "ALL";
    public static final String ENABLEMODE_INWF = "INWF";
    public static final String ENABLEMODE_ALLWF = "ALLWF";
    public static final String ENABLEMODE_CUSTOM = "CUSTOM";
    public static final String ENABLEMODE_DEOPPRIV = "DEOPPRIV";
    public static final String TAG_PSDEDRITEMID = "PSDEDRITEMID";
    public static final String TAG_PSDEDRITEMNAME = "PSDEDRITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DRITEMTYPE = "DRITEMTYPE";
    public static final String TAG_PSDEDRID = "PSDEDRID";
    public static final String TAG_PSDEDRNAME = "PSDEDRNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDEDRGROUPID = "PSDEDRGROUPID";
    public static final String TAG_PSDEDRGROUPNAME = "PSDEDRGROUPNAME";
    public static final String TAG_PSDERID = "PSDERID";
    public static final String TAG_PSDERNAME = "PSDERNAME";
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String TAG_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String TAG_VIEWPSDEID = "VIEWPSDEID";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_TESTPSDEACTIONID = "TESTPSDEACTIONID";
    public static final String TAG_TESTPSDEACTIONNAME = "TESTPSDEACTIONNAME";
    public static final String TAG_COUNTERID = "COUNTERID";
    public static final String TAG_COUNTERMODE = "COUNTERMODE";
    public static final String TAG_ENABLEMODE = "ENABLEMODE";
    public static final String TAG_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String TAG_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String TAG_VIEWPARAMS = "VIEWPARAMS";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String TAG_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String TAG_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_TESTCUSTOMCODE = "TESTCUSTOMCODE";
    public static final String TAG_TESTCUSTOMMODE = "TESTCUSTOMMODE";
    public static final String TAG_VIEWCODENAME = "VIEWCODENAME";
    public static final String TAG_TESTPSDELOGICID = "TESTPSDELOGICID";
    public static final String TAG_TESTPSDELOGICNAME = "TESTPSDELOGICNAME";
    public static final String TAG_HEADERPSSYSPFPLUGINID = "HEADERPSSYSPFPLUGINID";
    public static final String TAG_HEADERPSSYSPFPLUGINNAME = "HEADERPSSYSPFPLUGINNAME";
    public static final String TAG_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String TAG_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String TAG_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String TAG_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";

    public final boolean isPSDEDRITEMIDNull() {
        return this.IsParamNull(TAG_PSDEDRITEMID);
    }

    public final String getPSDEDRITEMID() {
        return this.GetParamStringValue(TAG_PSDEDRITEMID, "");
    }

    public final void setPSDEDRITEMID(String strValue) {
        this.SetParamValue(TAG_PSDEDRITEMID, strValue);
    }

    public final boolean isPSDEDRITEMNAMENull() {
        return this.IsParamNull(TAG_PSDEDRITEMNAME);
    }

    public final String getPSDEDRITEMNAME() {
        return this.GetParamStringValue(TAG_PSDEDRITEMNAME, "");
    }

    public final void setPSDEDRITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDRITEMNAME, strValue);
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

    public final boolean isDRITEMTYPENull() {
        return this.IsParamNull(TAG_DRITEMTYPE);
    }

    public final String getDRITEMTYPE() {
        return this.GetParamStringValue(TAG_DRITEMTYPE, "");
    }

    public final void setDRITEMTYPE(String strValue) {
        this.SetParamValue(TAG_DRITEMTYPE, strValue);
    }

    public final boolean isPSDEDRIDNull() {
        return this.IsParamNull(TAG_PSDEDRID);
    }

    public final String getPSDEDRID() {
        return this.GetParamStringValue(TAG_PSDEDRID, "");
    }

    public final void setPSDEDRID(String strValue) {
        this.SetParamValue(TAG_PSDEDRID, strValue);
    }

    public final boolean isPSDEDRNAMENull() {
        return this.IsParamNull(TAG_PSDEDRNAME);
    }

    public final String getPSDEDRNAME() {
        return this.GetParamStringValue(TAG_PSDEDRNAME, "");
    }

    public final void setPSDEDRNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDRNAME, strValue);
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

    public final boolean isPSDEDRGROUPIDNull() {
        return this.IsParamNull(TAG_PSDEDRGROUPID);
    }

    public final String getPSDEDRGROUPID() {
        return this.GetParamStringValue(TAG_PSDEDRGROUPID, "");
    }

    public final void setPSDEDRGROUPID(String strValue) {
        this.SetParamValue(TAG_PSDEDRGROUPID, strValue);
    }

    public final boolean isPSDEDRGROUPNAMENull() {
        return this.IsParamNull(TAG_PSDEDRGROUPNAME);
    }

    public final String getPSDEDRGROUPNAME() {
        return this.GetParamStringValue(TAG_PSDEDRGROUPNAME, "");
    }

    public final void setPSDEDRGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDRGROUPNAME, strValue);
    }

    public final boolean isPSDERIDNull() {
        return this.IsParamNull(TAG_PSDERID);
    }

    public final String getPSDERID() {
        return this.GetParamStringValue(TAG_PSDERID, "");
    }

    public final void setPSDERID(String strValue) {
        this.SetParamValue(TAG_PSDERID, strValue);
    }

    public final boolean isPSDERNAMENull() {
        return this.IsParamNull(TAG_PSDERNAME);
    }

    public final String getPSDERNAME() {
        return this.GetParamStringValue(TAG_PSDERNAME, "");
    }

    public final void setPSDERNAME(String strValue) {
        this.SetParamValue(TAG_PSDERNAME, strValue);
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

    public final boolean isVIEWPSDEIDNull() {
        return this.IsParamNull(TAG_VIEWPSDEID);
    }

    public final String getVIEWPSDEID() {
        return this.GetParamStringValue(TAG_VIEWPSDEID, "");
    }

    public final void setVIEWPSDEID(String strValue) {
        this.SetParamValue(TAG_VIEWPSDEID, strValue);
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

    public final boolean isTESTPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_TESTPSDEACTIONID);
    }

    public final String getTESTPSDEACTIONID() {
        return this.GetParamStringValue(TAG_TESTPSDEACTIONID, "");
    }

    public final void setTESTPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_TESTPSDEACTIONID, strValue);
    }

    public final boolean isTESTPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_TESTPSDEACTIONNAME);
    }

    public final String getTESTPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_TESTPSDEACTIONNAME, "");
    }

    public final void setTESTPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_TESTPSDEACTIONNAME, strValue);
    }

    public final boolean isCOUNTERIDNull() {
        return this.IsParamNull(TAG_COUNTERID);
    }

    public final String getCOUNTERID() {
        return this.GetParamStringValue(TAG_COUNTERID, "");
    }

    public final void setCOUNTERID(String strValue) {
        this.SetParamValue(TAG_COUNTERID, strValue);
    }

    public final boolean isCOUNTERMODENull() {
        return this.IsParamNull(TAG_COUNTERMODE);
    }

    public final int getCOUNTERMODE() {
        return this.GetParamIntValue(TAG_COUNTERMODE, 0);
    }

    public final void setCOUNTERMODE(int nValue) {
        this.SetParamValue(TAG_COUNTERMODE, nValue);
    }

    public final boolean isENABLEMODENull() {
        return this.IsParamNull(TAG_ENABLEMODE);
    }

    public final String getENABLEMODE() {
        return this.GetParamStringValue(TAG_ENABLEMODE, "");
    }

    public final void setENABLEMODE(String strValue) {
        this.SetParamValue(TAG_ENABLEMODE, strValue);
    }

    public final boolean isPSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_PSDEOPPRIVID);
    }

    public final String getPSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_PSDEOPPRIVID, "");
    }

    public final void setPSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_PSDEOPPRIVID, strValue);
    }

    public final boolean isPSDEOPPRIVNAMENull() {
        return this.IsParamNull(TAG_PSDEOPPRIVNAME);
    }

    public final String getPSDEOPPRIVNAME() {
        return this.GetParamStringValue(TAG_PSDEOPPRIVNAME, "");
    }

    public final void setPSDEOPPRIVNAME(String strValue) {
        this.SetParamValue(TAG_PSDEOPPRIVNAME, strValue);
    }

    public final boolean isVIEWPARAMSNull() {
        return this.IsParamNull(TAG_VIEWPARAMS);
    }

    public final String getVIEWPARAMS() {
        return this.GetParamStringValue(TAG_VIEWPARAMS, "");
    }

    public final void setVIEWPARAMS(String strValue) {
        this.SetParamValue(TAG_VIEWPARAMS, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
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

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
    }

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
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

    public final boolean isTIPPSLANRESIDNull() {
        return this.IsParamNull(TAG_TIPPSLANRESID);
    }

    public final String getTIPPSLANRESID() {
        return this.GetParamStringValue(TAG_TIPPSLANRESID, "");
    }

    public final void setTIPPSLANRESID(String strValue) {
        this.SetParamValue(TAG_TIPPSLANRESID, strValue);
    }

    public final boolean isTIPPSLANRESNAMENull() {
        return this.IsParamNull(TAG_TIPPSLANRESNAME);
    }

    public final String getTIPPSLANRESNAME() {
        return this.GetParamStringValue(TAG_TIPPSLANRESNAME, "");
    }

    public final void setTIPPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_TIPPSLANRESNAME, strValue);
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

    public final boolean isTESTCUSTOMCODENull() {
        return this.IsParamNull(TAG_TESTCUSTOMCODE);
    }

    public final String getTESTCUSTOMCODE() {
        return this.GetParamStringValue(TAG_TESTCUSTOMCODE, "");
    }

    public final void setTESTCUSTOMCODE(String strValue) {
        this.SetParamValue(TAG_TESTCUSTOMCODE, strValue);
    }

    public final boolean isTESTCUSTOMMODENull() {
        return this.IsParamNull(TAG_TESTCUSTOMMODE);
    }

    public final boolean getTESTCUSTOMMODE() {
        return this.GetParamIntValue(TAG_TESTCUSTOMMODE, 0) == 1;
    }

    public final void setTESTCUSTOMMODE(boolean bValue) {
        this.SetParamValue(TAG_TESTCUSTOMMODE, bValue ? 1 : 0);
    }

    public final boolean isVIEWCODENAMENull() {
        return this.IsParamNull(TAG_VIEWCODENAME);
    }

    public final String getVIEWCODENAME() {
        return this.GetParamStringValue(TAG_VIEWCODENAME, "");
    }

    public final void setVIEWCODENAME(String strValue) {
        this.SetParamValue(TAG_VIEWCODENAME, strValue);
    }

    public final boolean isTESTPSDELOGICIDNull() {
        return this.IsParamNull(TAG_TESTPSDELOGICID);
    }

    public final String getTESTPSDELOGICID() {
        return this.GetParamStringValue(TAG_TESTPSDELOGICID, "");
    }

    public final void setTESTPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_TESTPSDELOGICID, strValue);
    }

    public final boolean isTESTPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_TESTPSDELOGICNAME);
    }

    public final String getTESTPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_TESTPSDELOGICNAME, "");
    }

    public final void setTESTPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_TESTPSDELOGICNAME, strValue);
    }

    public final boolean isHEADERPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_HEADERPSSYSPFPLUGINID);
    }

    public final String getHEADERPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_HEADERPSSYSPFPLUGINID, "");
    }

    public final void setHEADERPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_HEADERPSSYSPFPLUGINID, strValue);
    }

    public final boolean isHEADERPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_HEADERPSSYSPFPLUGINNAME);
    }

    public final String getHEADERPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_HEADERPSSYSPFPLUGINNAME, "");
    }

    public final void setHEADERPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_HEADERPSSYSPFPLUGINNAME, strValue);
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
}

