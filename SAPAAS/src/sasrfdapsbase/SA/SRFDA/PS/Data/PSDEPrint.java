/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEPrint
extends BaseDataEntity {
    public static final String REPORTTYPE_JR = "JR";
    public static final String TAG_PSDEPRINTID = "PSDEPRINTID";
    public static final String TAG_PSDEPRINTNAME = "PSDEPRINTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_ENABLECOLPRIV = "ENABLECOLPRIV";
    public static final String TAG_ENABLELOG = "ENABLELOG";
    public static final String TAG_ENABLEMP = "ENABLEMP";
    public static final String TAG_GETDATAPSDEACTIONID = "GETDATAPSDEACTIONID";
    public static final String TAG_GETDATAPSDEACTIONNAME = "GETDATAPSDEACTIONNAME";
    public static final String TAG_PSDEDATASETID = "PSDEDATASETID";
    public static final String TAG_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String TAG_REPORTTYPE = "REPORTTYPE";
    public static final String TAG_REPORTFILE = "REPORTFILE";
    public static final String TAG_DEFAULTMODE = "DEFAULTMODE";
    public static final String TAG_REFPSDEID = "REFPSDEID";
    public static final String TAG_REFPSDENAME = "REFPSDENAME";
    public static final String TAG_ADPSDELOGICID = "ADPSDELOGICID";
    public static final String TAG_ADPSDELOGICNAME = "ADPSDELOGICNAME";
    public static final String TAG_EXTENDMODE = "EXTENDMODE";
    public static final String TAG_READPSDEOPPRIVID = "READPSDEOPPRIVID";
    public static final String TAG_READPSDEOPPRIVNAME = "READPSDEOPPRIVNAME";
    public static final String TAG_PRINTMODEL = "PRINTMODEL";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_POTIME = "POTIME";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_PRINTTAG = "PRINTTAG";
    public static final String TAG_PRINTTAG2 = "PRINTTAG2";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PRINTPARAMS = "PRINTPARAMS";
    public static final String TAG_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String TAG_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String TAG_CONTENTTYPE = "CONTENTTYPE";
    public static final String TAG_PRINTUIMODEL = "PRINTUIMODEL";
    public static final String TAG_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String TAG_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";

    public final boolean isPSDEPRINTIDNull() {
        return this.IsParamNull(TAG_PSDEPRINTID);
    }

    public final String getPSDEPRINTID() {
        return this.GetParamStringValue(TAG_PSDEPRINTID, "");
    }

    public final void setPSDEPRINTID(String strValue) {
        this.SetParamValue(TAG_PSDEPRINTID, strValue);
    }

    public final boolean isPSDEPRINTNAMENull() {
        return this.IsParamNull(TAG_PSDEPRINTNAME);
    }

    public final String getPSDEPRINTNAME() {
        return this.GetParamStringValue(TAG_PSDEPRINTNAME, "");
    }

    public final void setPSDEPRINTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPRINTNAME, strValue);
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

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
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

    public final boolean isENABLECOLPRIVNull() {
        return this.IsParamNull(TAG_ENABLECOLPRIV);
    }

    public final boolean getENABLECOLPRIV() {
        return this.GetParamIntValue(TAG_ENABLECOLPRIV, 0) == 1;
    }

    public final void setENABLECOLPRIV(boolean bValue) {
        this.SetParamValue(TAG_ENABLECOLPRIV, bValue ? 1 : 0);
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

    public final boolean isENABLEMPNull() {
        return this.IsParamNull(TAG_ENABLEMP);
    }

    public final boolean getENABLEMP() {
        return this.GetParamIntValue(TAG_ENABLEMP, 0) == 1;
    }

    public final void setENABLEMP(boolean bValue) {
        this.SetParamValue(TAG_ENABLEMP, bValue ? 1 : 0);
    }

    public final boolean isGETDATAPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_GETDATAPSDEACTIONID);
    }

    public final String getGETDATAPSDEACTIONID() {
        return this.GetParamStringValue(TAG_GETDATAPSDEACTIONID, "");
    }

    public final void setGETDATAPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_GETDATAPSDEACTIONID, strValue);
    }

    public final boolean isGETDATAPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_GETDATAPSDEACTIONNAME);
    }

    public final String getGETDATAPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_GETDATAPSDEACTIONNAME, "");
    }

    public final void setGETDATAPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_GETDATAPSDEACTIONNAME, strValue);
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

    public final boolean isDEFAULTMODENull() {
        return this.IsParamNull(TAG_DEFAULTMODE);
    }

    public final boolean getDEFAULTMODE() {
        return this.GetParamIntValue(TAG_DEFAULTMODE, 0) == 1;
    }

    public final void setDEFAULTMODE(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTMODE, bValue ? 1 : 0);
    }

    public final boolean isREFPSDEIDNull() {
        return this.IsParamNull(TAG_REFPSDEID);
    }

    public final String getREFPSDEID() {
        return this.GetParamStringValue(TAG_REFPSDEID, "");
    }

    public final void setREFPSDEID(String strValue) {
        this.SetParamValue(TAG_REFPSDEID, strValue);
    }

    public final boolean isREFPSDENAMENull() {
        return this.IsParamNull(TAG_REFPSDENAME);
    }

    public final String getREFPSDENAME() {
        return this.GetParamStringValue(TAG_REFPSDENAME, "");
    }

    public final void setREFPSDENAME(String strValue) {
        this.SetParamValue(TAG_REFPSDENAME, strValue);
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

    public final boolean isPRINTMODELNull() {
        return this.IsParamNull(TAG_PRINTMODEL);
    }

    public final String getPRINTMODEL() {
        return this.GetParamStringValue(TAG_PRINTMODEL, "");
    }

    public final void setPRINTMODEL(String strValue) {
        this.SetParamValue(TAG_PRINTMODEL, strValue);
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

    public final boolean isPRINTTAGNull() {
        return this.IsParamNull(TAG_PRINTTAG);
    }

    public final String getPRINTTAG() {
        return this.GetParamStringValue(TAG_PRINTTAG, "");
    }

    public final void setPRINTTAG(String strValue) {
        this.SetParamValue(TAG_PRINTTAG, strValue);
    }

    public final boolean isPRINTTAG2Null() {
        return this.IsParamNull(TAG_PRINTTAG2);
    }

    public final String getPRINTTAG2() {
        return this.GetParamStringValue(TAG_PRINTTAG2, "");
    }

    public final void setPRINTTAG2(String strValue) {
        this.SetParamValue(TAG_PRINTTAG2, strValue);
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

    public final boolean isPRINTPARAMSNull() {
        return this.IsParamNull(TAG_PRINTPARAMS);
    }

    public final String getPRINTPARAMS() {
        return this.GetParamStringValue(TAG_PRINTPARAMS, "");
    }

    public final void setPRINTPARAMS(String strValue) {
        this.SetParamValue(TAG_PRINTPARAMS, strValue);
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

    public final boolean isPRINTUIMODELNull() {
        return this.IsParamNull(TAG_PRINTUIMODEL);
    }

    public final String getPRINTUIMODEL() {
        return this.GetParamStringValue(TAG_PRINTUIMODEL, "");
    }

    public final void setPRINTUIMODEL(String strValue) {
        this.SetParamValue(TAG_PRINTUIMODEL, strValue);
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
}

