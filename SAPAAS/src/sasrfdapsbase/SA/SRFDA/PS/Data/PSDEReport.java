/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEReport
extends BaseDataEntity {
    public static final String REPORTTYPE_JR = "JR";
    public static final String TAG_PSDEREPORTID = "PSDEREPORTID";
    public static final String TAG_PSDEREPORTNAME = "PSDEREPORTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MULTIPAGE = "MULTIPAGE";
    public static final String TAG_PSDEDSID = "PSDEDSID";
    public static final String TAG_PSDEDSNAME = "PSDEDSNAME";
    public static final String TAG_REPORTMODEL = "REPORTMODEL";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_REPORTTYPE = "REPORTTYPE";
    public static final String TAG_REPORTFILE = "REPORTFILE";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String TAG_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String TAG_ENABLELOG = "ENABLELOG";
    public static final String TAG_PSDEDSID2 = "PSDEDSID2";
    public static final String TAG_PSDEDSNAME2 = "PSDEDSNAME2";
    public static final String TAG_PSDEDSID3 = "PSDEDSID3";
    public static final String TAG_PSDEDSNAME3 = "PSDEDSNAME3";
    public static final String TAG_PSDEDSID4 = "PSDEDSID4";
    public static final String TAG_PSDEDSNAME4 = "PSDEDSNAME4";
    public static final String TAG_ADPSDELOGICID = "ADPSDELOGICID";
    public static final String TAG_ADPSDELOGICNAME = "ADPSDELOGICNAME";
    public static final String TAG_EXTENDMODE = "EXTENDMODE";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_POTIME = "POTIME";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_REPORTTAG2 = "REPORTTAG2";
    public static final String TAG_REPORTTAG = "REPORTTAG";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_REPORTPARAMS = "REPORTPARAMS";
    public static final String TAG_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String TAG_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String TAG_CONTENTTYPE = "CONTENTTYPE";
    public static final String TAG_REPORTUIMODEL = "REPORTUIMODEL";
    public static final String TAG_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String TAG_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String TAG_PSSYSBISCHEMEID = "PSSYSBISCHEMEID";
    public static final String TAG_PSSYSBISCHEMENAME = "PSSYSBISCHEMENAME";
    public static final String TAG_PSSYSBIREPORTID = "PSSYSBIREPORTID";
    public static final String TAG_PSSYSBIREPORTNAME = "PSSYSBIREPORTNAME";
    public static final String TAG_PSSYSBICUBEID = "PSSYSBICUBEID";
    public static final String TAG_PSSYSBICUBENAME = "PSSYSBICUBENAME";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_LAYOUTPANELMODE = "LAYOUTPANELMODE";

    public final boolean isPSDEREPORTIDNull() {
        return this.IsParamNull(TAG_PSDEREPORTID);
    }

    public final String getPSDEREPORTID() {
        return this.GetParamStringValue(TAG_PSDEREPORTID, "");
    }

    public final void setPSDEREPORTID(String strValue) {
        this.SetParamValue(TAG_PSDEREPORTID, strValue);
    }

    public final boolean isPSDEREPORTNAMENull() {
        return this.IsParamNull(TAG_PSDEREPORTNAME);
    }

    public final String getPSDEREPORTNAME() {
        return this.GetParamStringValue(TAG_PSDEREPORTNAME, "");
    }

    public final void setPSDEREPORTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEREPORTNAME, strValue);
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

    public final boolean isMULTIPAGENull() {
        return this.IsParamNull(TAG_MULTIPAGE);
    }

    public final boolean getMULTIPAGE() {
        return this.GetParamIntValue(TAG_MULTIPAGE, 0) == 1;
    }

    public final void setMULTIPAGE(boolean bValue) {
        this.SetParamValue(TAG_MULTIPAGE, bValue ? 1 : 0);
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

    public final boolean isREPORTMODELNull() {
        return this.IsParamNull(TAG_REPORTMODEL);
    }

    public final String getREPORTMODEL() {
        return this.GetParamStringValue(TAG_REPORTMODEL, "");
    }

    public final void setREPORTMODEL(String strValue) {
        this.SetParamValue(TAG_REPORTMODEL, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isREPORTTYPENull() {
        return this.IsParamNull(TAG_REPORTTYPE);
    }

    public final String getREPORTTYPE() {
        return this.GetParamStringValue(TAG_REPORTTYPE, "");
    }

    public final void setREPORTTYPE(String strValue) {
        this.SetParamValue(TAG_REPORTTYPE, strValue);
    }

    public final boolean isREPORTFILENull() {
        return this.IsParamNull(TAG_REPORTFILE);
    }

    public final String getREPORTFILE() {
        return this.GetParamStringValue(TAG_REPORTFILE, "");
    }

    public final void setREPORTFILE(String strValue) {
        this.SetParamValue(TAG_REPORTFILE, strValue);
    }

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
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

    public final boolean isENABLELOGNull() {
        return this.IsParamNull(TAG_ENABLELOG);
    }

    public final boolean getENABLELOG() {
        return this.GetParamIntValue(TAG_ENABLELOG, 0) == 1;
    }

    public final void setENABLELOG(boolean bValue) {
        this.SetParamValue(TAG_ENABLELOG, bValue ? 1 : 0);
    }

    public final boolean isPSDEDSID2Null() {
        return this.IsParamNull(TAG_PSDEDSID2);
    }

    public final String getPSDEDSID2() {
        return this.GetParamStringValue(TAG_PSDEDSID2, "");
    }

    public final void setPSDEDSID2(String strValue) {
        this.SetParamValue(TAG_PSDEDSID2, strValue);
    }

    public final boolean isPSDEDSNAME2Null() {
        return this.IsParamNull(TAG_PSDEDSNAME2);
    }

    public final String getPSDEDSNAME2() {
        return this.GetParamStringValue(TAG_PSDEDSNAME2, "");
    }

    public final void setPSDEDSNAME2(String strValue) {
        this.SetParamValue(TAG_PSDEDSNAME2, strValue);
    }

    public final boolean isPSDEDSID3Null() {
        return this.IsParamNull(TAG_PSDEDSID3);
    }

    public final String getPSDEDSID3() {
        return this.GetParamStringValue(TAG_PSDEDSID3, "");
    }

    public final void setPSDEDSID3(String strValue) {
        this.SetParamValue(TAG_PSDEDSID3, strValue);
    }

    public final boolean isPSDEDSNAME3Null() {
        return this.IsParamNull(TAG_PSDEDSNAME3);
    }

    public final String getPSDEDSNAME3() {
        return this.GetParamStringValue(TAG_PSDEDSNAME3, "");
    }

    public final void setPSDEDSNAME3(String strValue) {
        this.SetParamValue(TAG_PSDEDSNAME3, strValue);
    }

    public final boolean isPSDEDSID4Null() {
        return this.IsParamNull(TAG_PSDEDSID4);
    }

    public final String getPSDEDSID4() {
        return this.GetParamStringValue(TAG_PSDEDSID4, "");
    }

    public final void setPSDEDSID4(String strValue) {
        this.SetParamValue(TAG_PSDEDSID4, strValue);
    }

    public final boolean isPSDEDSNAME4Null() {
        return this.IsParamNull(TAG_PSDEDSNAME4);
    }

    public final String getPSDEDSNAME4() {
        return this.GetParamStringValue(TAG_PSDEDSNAME4, "");
    }

    public final void setPSDEDSNAME4(String strValue) {
        this.SetParamValue(TAG_PSDEDSNAME4, strValue);
    }

    public final boolean isADPSDELOGICIDNull() {
        return this.IsParamNull(TAG_ADPSDELOGICID);
    }

    public final String getADPSDELOGICID() {
        return this.GetParamStringValue(TAG_ADPSDELOGICID, "");
    }

    public final void setADPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_ADPSDELOGICID, strValue);
    }

    public final boolean isADPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_ADPSDELOGICNAME);
    }

    public final String getADPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_ADPSDELOGICNAME, "");
    }

    public final void setADPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_ADPSDELOGICNAME, strValue);
    }

    public final boolean isEXTENDMODENull() {
        return this.IsParamNull(TAG_EXTENDMODE);
    }

    public final int getEXTENDMODE() {
        return this.GetParamIntValue(TAG_EXTENDMODE, 0);
    }

    public final void setEXTENDMODE(int nValue) {
        this.SetParamValue(TAG_EXTENDMODE, nValue);
    }

    public final boolean isPSSYSSFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINID);
    }

    public final String getPSSYSSFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINID, "");
    }

    public final void setPSSYSSFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINID, strValue);
    }

    public final boolean isPSSYSSFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINNAME);
    }

    public final String getPSSYSSFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINNAME, "");
    }

    public final void setPSSYSSFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINNAME, strValue);
    }

    public final boolean isPOTIMENull() {
        return this.IsParamNull(TAG_POTIME);
    }

    public final int getPOTIME() {
        return this.GetParamIntValue(TAG_POTIME, 0);
    }

    public final void setPOTIME(int nValue) {
        this.SetParamValue(TAG_POTIME, nValue);
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

    public final boolean isCUSTOMCODENull() {
        return this.IsParamNull(TAG_CUSTOMCODE);
    }

    public final String getCUSTOMCODE() {
        return this.GetParamStringValue(TAG_CUSTOMCODE, "");
    }

    public final void setCUSTOMCODE(String strValue) {
        this.SetParamValue(TAG_CUSTOMCODE, strValue);
    }

    public final boolean isREPORTTAG2Null() {
        return this.IsParamNull(TAG_REPORTTAG2);
    }

    public final String getREPORTTAG2() {
        return this.GetParamStringValue(TAG_REPORTTAG2, "");
    }

    public final void setREPORTTAG2(String strValue) {
        this.SetParamValue(TAG_REPORTTAG2, strValue);
    }

    public final boolean isREPORTTAGNull() {
        return this.IsParamNull(TAG_REPORTTAG);
    }

    public final String getREPORTTAG() {
        return this.GetParamStringValue(TAG_REPORTTAG, "");
    }

    public final void setREPORTTAG(String strValue) {
        this.SetParamValue(TAG_REPORTTAG, strValue);
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

    public final boolean isREPORTPARAMSNull() {
        return this.IsParamNull(TAG_REPORTPARAMS);
    }

    public final String getREPORTPARAMS() {
        return this.GetParamStringValue(TAG_REPORTPARAMS, "");
    }

    public final void setREPORTPARAMS(String strValue) {
        this.SetParamValue(TAG_REPORTPARAMS, strValue);
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

    public final boolean isCONTENTTYPENull() {
        return this.IsParamNull(TAG_CONTENTTYPE);
    }

    public final String getCONTENTTYPE() {
        return this.GetParamStringValue(TAG_CONTENTTYPE, "");
    }

    public final void setCONTENTTYPE(String strValue) {
        this.SetParamValue(TAG_CONTENTTYPE, strValue);
    }

    public final boolean isREPORTUIMODELNull() {
        return this.IsParamNull(TAG_REPORTUIMODEL);
    }

    public final String getREPORTUIMODEL() {
        return this.GetParamStringValue(TAG_REPORTUIMODEL, "");
    }

    public final void setREPORTUIMODEL(String strValue) {
        this.SetParamValue(TAG_REPORTUIMODEL, strValue);
    }

    public final boolean isPSSYSBISCHEMEIDNull() {
        return this.IsParamNull(TAG_PSSYSBISCHEMEID);
    }

    public final String getPSSYSBISCHEMEID() {
        return this.GetParamStringValue(TAG_PSSYSBISCHEMEID, "");
    }

    public final void setPSSYSBISCHEMEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBISCHEMEID, strValue);
    }

    public final boolean isPSSYSBISCHEMENAMENull() {
        return this.IsParamNull(TAG_PSSYSBISCHEMENAME);
    }

    public final String getPSSYSBISCHEMENAME() {
        return this.GetParamStringValue(TAG_PSSYSBISCHEMENAME, "");
    }

    public final void setPSSYSBISCHEMENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBISCHEMENAME, strValue);
    }

    public final boolean isPSSYSBIREPORTIDNull() {
        return this.IsParamNull(TAG_PSSYSBIREPORTID);
    }

    public final String getPSSYSBIREPORTID() {
        return this.GetParamStringValue(TAG_PSSYSBIREPORTID, "");
    }

    public final void setPSSYSBIREPORTID(String strValue) {
        this.SetParamValue(TAG_PSSYSBIREPORTID, strValue);
    }

    public final boolean isPSSYSBIREPORTNAMENull() {
        return this.IsParamNull(TAG_PSSYSBIREPORTNAME);
    }

    public final String getPSSYSBIREPORTNAME() {
        return this.GetParamStringValue(TAG_PSSYSBIREPORTNAME, "");
    }

    public final void setPSSYSBIREPORTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBIREPORTNAME, strValue);
    }

    public final boolean isPSSYSBICUBEIDNull() {
        return this.IsParamNull(TAG_PSSYSBICUBEID);
    }

    public final String getPSSYSBICUBEID() {
        return this.GetParamStringValue(TAG_PSSYSBICUBEID, "");
    }

    public final void setPSSYSBICUBEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBICUBEID, strValue);
    }

    public final boolean isPSSYSBICUBENAMENull() {
        return this.IsParamNull(TAG_PSSYSBICUBENAME);
    }

    public final String getPSSYSBICUBENAME() {
        return this.GetParamStringValue(TAG_PSSYSBICUBENAME, "");
    }

    public final void setPSSYSBICUBENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBICUBENAME, strValue);
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

    public final boolean isLAYOUTPANELMODENull() {
        return this.IsParamNull(TAG_LAYOUTPANELMODE);
    }

    public final int getLAYOUTPANELMODE() {
        return this.GetParamIntValue(TAG_LAYOUTPANELMODE, 0);
    }

    public final void setLAYOUTPANELMODE(int nValue) {
        this.SetParamValue(TAG_LAYOUTPANELMODE, nValue);
    }
}

