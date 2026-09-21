/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEACMode
extends BaseDataEntity {
    public static final String TAG_PSDEACMODEID = "PSDEACMODEID";
    public static final String TAG_PSDEACMODENAME = "PSDEACMODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_DEFAULTMODE = "DEFAULTMODE";
    public static final String TAG_FILLEROBJ = "FILLEROBJ";
    public static final String TAG_MINORSORTDIR = "MINORSORTDIR";
    public static final String TAG_PAGINGSIZE = "PAGINGSIZE";
    public static final String TAG_ENABLEPAGINGBAR = "ENABLEPAGINGBAR";
    public static final String TAG_MINORSORTPSDEFID = "MINORSORTPSDEFID";
    public static final String TAG_MINORSORTPSDEFNAME = "MINORSORTPSDEFNAME";
    public static final String TAG_VALUEPSDEFID = "VALUEPSDEFID";
    public static final String TAG_VALUEPSDEFNAME = "VALUEPSDEFNAME";
    public static final String TAG_TEXTPSDEFID = "TEXTPSDEFID";
    public static final String TAG_TEXTPSDEFNAME = "TEXTPSDEFNAME";
    public static final String TAG_ACIPSSYSPFPLUGINID = "ACIPSSYSPFPLUGINID";
    public static final String TAG_ACIPSSYSPFPLUGINNAME = "ACIPSSYSPFPLUGINNAME";
    public static final String TAG_EMPTYTEXT = "EMPTYTEXT";
    public static final String TAG_EMPTYTEXTPSLANRESID = "EMPTYTEXTPSLANRESID";
    public static final String TAG_EMPTYTEXTPSLANRESNAME = "EMPTYTEXTPSLANRESNAME";
    public static final String TAG_EXTENDMODE = "EXTENDMODE";
    public static final String TAG_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String TAG_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String TAG_PICKUPPSDEVIEWID = "PICKUPPSDEVIEWID";
    public static final String TAG_PICKUPPSDEVIEWNAME = "PICKUPPSDEVIEWNAME";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_ACTIONHOLDER = "ACTIONHOLDER";
    public static final String TAG_PSDEDATASETID = "PSDEDATASETID";
    public static final String TAG_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String TAG_ACTYPE = "ACTYPE";
    public static final String TAG_ACTAG = "ACTAG";
    public static final String TAG_ACTAG2 = "ACTAG2";
    public static final String TAG_ACTAG3 = "ACTAG3";
    public static final String TAG_ACTAG4 = "ACTAG4";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_HISTORYPSSYSMSGTEMPLID = "HISTORYPSSYSMSGTEMPLID";
    public static final String TAG_HISTORYPSSYSMSGTEMPLNAME = "HISTORYPSSYSMSGTEMPLNAME";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_CREATEPSDEOPPRIVID = "CREATEPSDEOPPRIVID";
    public static final String TAG_CREATEPSDEOPPRIVNAME = "CREATEPSDEOPPRIVNAME";
    public static final String TAG_READPSDEOPPRIVID = "READPSDEOPPRIVID";
    public static final String TAG_READPSDEOPPRIVNAME = "READPSDEOPPRIVNAME";
    public static final String TAG_PSSYSAIFACTORYID = "PSSYSAIFACTORYID";
    public static final String TAG_PSSYSAIFACTORYNAME = "PSSYSAIFACTORYNAME";
    public static final String TAG_PSSYSAICHATAGENTID = "PSSYSAICHATAGENTID";
    public static final String TAG_PSSYSAICHATAGENTNAME = "PSSYSAICHATAGENTNAME";
    public static final String TAG_LINKPSDEVIEWID = "LINKPSDEVIEWID";
    public static final String TAG_LINKPSDEVIEWNAME = "LINKPSDEVIEWNAME";
    public static final String TAG_ACPARAMS = "ACPARAMS";

    public final boolean isPSDEACMODEIDNull() {
        return this.IsParamNull(TAG_PSDEACMODEID);
    }

    public final String getPSDEACMODEID() {
        return this.GetParamStringValue(TAG_PSDEACMODEID, "");
    }

    public final void setPSDEACMODEID(String strValue) {
        this.SetParamValue(TAG_PSDEACMODEID, strValue);
    }

    public final boolean isPSDEACMODENAMENull() {
        return this.IsParamNull(TAG_PSDEACMODENAME);
    }

    public final String getPSDEACMODENAME() {
        return this.GetParamStringValue(TAG_PSDEACMODENAME, "");
    }

    public final void setPSDEACMODENAME(String strValue) {
        this.SetParamValue(TAG_PSDEACMODENAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isDEFAULTMODENull() {
        return this.IsParamNull(TAG_DEFAULTMODE);
    }

    public final boolean getDEFAULTMODE() {
        return this.GetParamIntValue(TAG_DEFAULTMODE, 0) == 1;
    }

    public final void setDEFAULTMODE(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTMODE, bValue ? 1 : 0);
    }

    public final boolean isFILLEROBJNull() {
        return this.IsParamNull(TAG_FILLEROBJ);
    }

    public final String getFILLEROBJ() {
        return this.GetParamStringValue(TAG_FILLEROBJ, "");
    }

    public final void setFILLEROBJ(String strValue) {
        this.SetParamValue(TAG_FILLEROBJ, strValue);
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

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
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

    public final boolean isPAGINGSIZENull() {
        return this.IsParamNull(TAG_PAGINGSIZE);
    }

    public final int getPAGINGSIZE() {
        return this.GetParamIntValue(TAG_PAGINGSIZE, 0);
    }

    public final void setPAGINGSIZE(int nValue) {
        this.SetParamValue(TAG_PAGINGSIZE, nValue);
    }

    public final boolean isENABLEPAGINGBARNull() {
        return this.IsParamNull(TAG_ENABLEPAGINGBAR);
    }

    public final int getENABLEPAGINGBAR() {
        return this.GetParamIntValue(TAG_ENABLEPAGINGBAR, 0);
    }

    public final void setENABLEPAGINGBAR(int bValue) {
        this.SetParamValue(TAG_ENABLEPAGINGBAR, bValue);
    }

    public final boolean isMINORSORTPSDEFIDNull() {
        return this.IsParamNull(TAG_MINORSORTPSDEFID);
    }

    public final String getMINORSORTPSDEFID() {
        return this.GetParamStringValue(TAG_MINORSORTPSDEFID, "");
    }

    public final void setMINORSORTPSDEFID(String strValue) {
        this.SetParamValue(TAG_MINORSORTPSDEFID, strValue);
    }

    public final boolean isMINORSORTPSDEFNAMENull() {
        return this.IsParamNull(TAG_MINORSORTPSDEFNAME);
    }

    public final String getMINORSORTPSDEFNAME() {
        return this.GetParamStringValue(TAG_MINORSORTPSDEFNAME, "");
    }

    public final void setMINORSORTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_MINORSORTPSDEFNAME, strValue);
    }

    public final boolean isVALUEPSDEFIDNull() {
        return this.IsParamNull(TAG_VALUEPSDEFID);
    }

    public final String getVALUEPSDEFID() {
        return this.GetParamStringValue(TAG_VALUEPSDEFID, "");
    }

    public final void setVALUEPSDEFID(String strValue) {
        this.SetParamValue(TAG_VALUEPSDEFID, strValue);
    }

    public final boolean isVALUEPSDEFNAMENull() {
        return this.IsParamNull(TAG_VALUEPSDEFNAME);
    }

    public final String getVALUEPSDEFNAME() {
        return this.GetParamStringValue(TAG_VALUEPSDEFNAME, "");
    }

    public final void setVALUEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_VALUEPSDEFNAME, strValue);
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

    public final boolean isACIPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_ACIPSSYSPFPLUGINID);
    }

    public final String getACIPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_ACIPSSYSPFPLUGINID, "");
    }

    public final void setACIPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_ACIPSSYSPFPLUGINID, strValue);
    }

    public final boolean isACIPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_ACIPSSYSPFPLUGINNAME);
    }

    public final String getACIPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_ACIPSSYSPFPLUGINNAME, "");
    }

    public final void setACIPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_ACIPSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isEMPTYTEXTNull() {
        return this.IsParamNull(TAG_EMPTYTEXT);
    }

    public final String getEMPTYTEXT() {
        return this.GetParamStringValue(TAG_EMPTYTEXT, "");
    }

    public final void setEMPTYTEXT(String strValue) {
        this.SetParamValue(TAG_EMPTYTEXT, strValue);
    }

    public final boolean isEMPTYTEXTPSLANRESIDNull() {
        return this.IsParamNull(TAG_EMPTYTEXTPSLANRESID);
    }

    public final String getEMPTYTEXTPSLANRESID() {
        return this.GetParamStringValue(TAG_EMPTYTEXTPSLANRESID, "");
    }

    public final void setEMPTYTEXTPSLANRESID(String strValue) {
        this.SetParamValue(TAG_EMPTYTEXTPSLANRESID, strValue);
    }

    public final boolean isEMPTYTEXTPSLANRESNAMENull() {
        return this.IsParamNull(TAG_EMPTYTEXTPSLANRESNAME);
    }

    public final String getEMPTYTEXTPSLANRESNAME() {
        return this.GetParamStringValue(TAG_EMPTYTEXTPSLANRESNAME, "");
    }

    public final void setEMPTYTEXTPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_EMPTYTEXTPSLANRESNAME, strValue);
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

    public final boolean isPICKUPPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_PICKUPPSDEVIEWID);
    }

    public final String getPICKUPPSDEVIEWID() {
        return this.GetParamStringValue(TAG_PICKUPPSDEVIEWID, "");
    }

    public final void setPICKUPPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_PICKUPPSDEVIEWID, strValue);
    }

    public final boolean isPICKUPPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_PICKUPPSDEVIEWNAME);
    }

    public final String getPICKUPPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_PICKUPPSDEVIEWNAME, "");
    }

    public final void setPICKUPPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PICKUPPSDEVIEWNAME, strValue);
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

    public final boolean isACTIONHOLDERNull() {
        return this.IsParamNull(TAG_ACTIONHOLDER);
    }

    public final int getACTIONHOLDER() {
        return this.GetParamIntValue(TAG_ACTIONHOLDER, 0);
    }

    public final void setACTIONHOLDER(int nValue) {
        this.SetParamValue(TAG_ACTIONHOLDER, nValue);
    }

    public final boolean isPSDEDATASETIDNull() {
        return this.IsParamNull(TAG_PSDEDATASETID);
    }

    public final String getPSDEDATASETID() {
        return this.GetParamStringValue(TAG_PSDEDATASETID, "");
    }

    public final void setPSDEDATASETID(String strValue) {
        this.SetParamValue(TAG_PSDEDATASETID, strValue);
    }

    public final boolean isPSDEDATASETNAMENull() {
        return this.IsParamNull(TAG_PSDEDATASETNAME);
    }

    public final String getPSDEDATASETNAME() {
        return this.GetParamStringValue(TAG_PSDEDATASETNAME, "");
    }

    public final void setPSDEDATASETNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDATASETNAME, strValue);
    }

    public final boolean isACTYPENull() {
        return this.IsParamNull(TAG_ACTYPE);
    }

    public final String getACTYPE() {
        return this.GetParamStringValue(TAG_ACTYPE, "");
    }

    public final void setACTYPE(String strValue) {
        this.SetParamValue(TAG_ACTYPE, strValue);
    }

    public final boolean isACTAGNull() {
        return this.IsParamNull(TAG_ACTAG);
    }

    public final String getACTAG() {
        return this.GetParamStringValue(TAG_ACTAG, "");
    }

    public final void setACTAG(String strValue) {
        this.SetParamValue(TAG_ACTAG, strValue);
    }

    public final boolean isACTAG2Null() {
        return this.IsParamNull(TAG_ACTAG2);
    }

    public final String getACTAG2() {
        return this.GetParamStringValue(TAG_ACTAG2, "");
    }

    public final void setACTAG2(String strValue) {
        this.SetParamValue(TAG_ACTAG2, strValue);
    }

    public final boolean isACTAG3Null() {
        return this.IsParamNull(TAG_ACTAG3);
    }

    public final String getACTAG3() {
        return this.GetParamStringValue(TAG_ACTAG3, "");
    }

    public final void setACTAG3(String strValue) {
        this.SetParamValue(TAG_ACTAG3, strValue);
    }

    public final boolean isACTAG4Null() {
        return this.IsParamNull(TAG_ACTAG4);
    }

    public final String getACTAG4() {
        return this.GetParamStringValue(TAG_ACTAG4, "");
    }

    public final void setACTAG4(String strValue) {
        this.SetParamValue(TAG_ACTAG4, strValue);
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

    public final boolean isHISTORYPSSYSMSGTEMPLIDNull() {
        return this.IsParamNull(TAG_HISTORYPSSYSMSGTEMPLID);
    }

    public final String getHISTORYPSSYSMSGTEMPLID() {
        return this.GetParamStringValue(TAG_HISTORYPSSYSMSGTEMPLID, "");
    }

    public final void setHISTORYPSSYSMSGTEMPLID(String strValue) {
        this.SetParamValue(TAG_HISTORYPSSYSMSGTEMPLID, strValue);
    }

    public final boolean isHISTORYPSSYSMSGTEMPLNAMENull() {
        return this.IsParamNull(TAG_HISTORYPSSYSMSGTEMPLNAME);
    }

    public final String getHISTORYPSSYSMSGTEMPLNAME() {
        return this.GetParamStringValue(TAG_HISTORYPSSYSMSGTEMPLNAME, "");
    }

    public final void setHISTORYPSSYSMSGTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_HISTORYPSSYSMSGTEMPLNAME, strValue);
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

    public final int getCUSTOMMODE() {
        return this.GetParamIntValue(TAG_CUSTOMMODE, 0);
    }

    public final void setCUSTOMMODE(int bValue) {
        this.SetParamValue(TAG_CUSTOMMODE, bValue);
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

    public final boolean isREADPSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_READPSDEOPPRIVID);
    }

    public final String getREADPSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_READPSDEOPPRIVID, "");
    }

    public final void setREADPSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_READPSDEOPPRIVID, strValue);
    }

    public final boolean isREADPSDEOPPRIVNAMENull() {
        return this.IsParamNull(TAG_READPSDEOPPRIVNAME);
    }

    public final String getREADPSDEOPPRIVNAME() {
        return this.GetParamStringValue(TAG_READPSDEOPPRIVNAME, "");
    }

    public final void setREADPSDEOPPRIVNAME(String strValue) {
        this.SetParamValue(TAG_READPSDEOPPRIVNAME, strValue);
    }

    public final boolean isPSSYSAIFACTORYIDNull() {
        return this.IsParamNull(TAG_PSSYSAIFACTORYID);
    }

    public final String getPSSYSAIFACTORYID() {
        return this.GetParamStringValue(TAG_PSSYSAIFACTORYID, "");
    }

    public final void setPSSYSAIFACTORYID(String strValue) {
        this.SetParamValue(TAG_PSSYSAIFACTORYID, strValue);
    }

    public final boolean isPSSYSAIFACTORYNAMENull() {
        return this.IsParamNull(TAG_PSSYSAIFACTORYNAME);
    }

    public final String getPSSYSAIFACTORYNAME() {
        return this.GetParamStringValue(TAG_PSSYSAIFACTORYNAME, "");
    }

    public final void setPSSYSAIFACTORYNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAIFACTORYNAME, strValue);
    }

    public final boolean isPSSYSAICHATAGENTIDNull() {
        return this.IsParamNull(TAG_PSSYSAICHATAGENTID);
    }

    public final String getPSSYSAICHATAGENTID() {
        return this.GetParamStringValue(TAG_PSSYSAICHATAGENTID, "");
    }

    public final void setPSSYSAICHATAGENTID(String strValue) {
        this.SetParamValue(TAG_PSSYSAICHATAGENTID, strValue);
    }

    public final boolean isPSSYSAICHATAGENTNAMENull() {
        return this.IsParamNull(TAG_PSSYSAICHATAGENTNAME);
    }

    public final String getPSSYSAICHATAGENTNAME() {
        return this.GetParamStringValue(TAG_PSSYSAICHATAGENTNAME, "");
    }

    public final void setPSSYSAICHATAGENTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAICHATAGENTNAME, strValue);
    }

    public final boolean isLINKPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_LINKPSDEVIEWID);
    }

    public final String getLINKPSDEVIEWID() {
        return this.GetParamStringValue(TAG_LINKPSDEVIEWID, "");
    }

    public final void setLINKPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_LINKPSDEVIEWID, strValue);
    }

    public final boolean isLINKPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_LINKPSDEVIEWNAME);
    }

    public final String getLINKPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_LINKPSDEVIEWNAME, "");
    }

    public final void setLINKPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_LINKPSDEVIEWNAME, strValue);
    }

    public final boolean isACPARAMSNull() {
        return this.IsParamNull(TAG_ACPARAMS);
    }

    public final String getACPARAMS() {
        return this.GetParamStringValue(TAG_ACPARAMS, "");
    }

    public final void setACPARAMS(String strValue) {
        this.SetParamValue(TAG_ACPARAMS, strValue);
    }
}

