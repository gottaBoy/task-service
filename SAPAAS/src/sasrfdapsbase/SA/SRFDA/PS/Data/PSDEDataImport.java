/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEDataImport
extends BaseDataEntity {
    public static final String TAG_PSDEDATAIMPID = "PSDEDATAIMPID";
    public static final String TAG_PSDEDATAIMPNAME = "PSDEDATAIMPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_CREATEPSDEACTIONID = "CREATEPSDEACTIONID";
    public static final String TAG_CREATEPSDEACTIONNAME = "CREATEPSDEACTIONNAME";
    public static final String TAG_UPDATEPSDEACTIONID = "UPDATEPSDEACTIONID";
    public static final String TAG_UPDATEPSDEACTIONNAME = "UPDATEPSDEACTIONNAME";
    public static final String TAG_STOPWHENERROR = "STOPWHENERROR";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_CREATEPSDEOPPRIVID = "CREATEPSDEOPPRIVID";
    public static final String TAG_CREATEPSDEOPPRIVINAME = "CREATEPSDEOPPRIVINAME";
    public static final String TAG_UPDATEPSDEOPPRIVID = "UPDATEPSDEOPPRIVID";
    public static final String TAG_UPDATEPSDEOPPRIVNAME = "UPDATEPSDEOPPRIVNAME";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_BATCHSIZE = "BATCHSIZE";
    public static final String TAG_ACTIONHOLDER = "ACTIONHOLDER";
    public static final String TAG_POTIME = "POTIME";
    public static final String TAG_DATAIMPTYPE = "DATAIMPTYPE";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_ENABLECUSTOMIZED = "ENABLECUSTOMIZED";
    public static final String TAG_IMPPARAMS = "IMPPARAMS";
    public static final String TAG_IMPTAG = "IMPTAG";
    public static final String TAG_IMPTAG2 = "IMPTAG2";

    public final boolean isPSDEDATAIMPIDNull() {
        return this.IsParamNull(TAG_PSDEDATAIMPID);
    }

    public final String getPSDEDATAIMPID() {
        return this.GetParamStringValue(TAG_PSDEDATAIMPID, "");
    }

    public final void setPSDEDATAIMPID(String strValue) {
        this.SetParamValue(TAG_PSDEDATAIMPID, strValue);
    }

    public final boolean isPSDEDATAIMPNAMENull() {
        return this.IsParamNull(TAG_PSDEDATAIMPNAME);
    }

    public final String getPSDEDATAIMPNAME() {
        return this.GetParamStringValue(TAG_PSDEDATAIMPNAME, "");
    }

    public final void setPSDEDATAIMPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDATAIMPNAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isDEFAULTFLAGNull() {
        return this.IsParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
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

    public final boolean isSTOPWHENERRORNull() {
        return this.IsParamNull(TAG_STOPWHENERROR);
    }

    public final boolean getSTOPWHENERROR() {
        return this.GetParamIntValue(TAG_STOPWHENERROR, 0) == 1;
    }

    public final void setSTOPWHENERROR(boolean bValue) {
        this.SetParamValue(TAG_STOPWHENERROR, bValue ? 1 : 0);
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

    public final boolean isCREATEPSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_CREATEPSDEOPPRIVID);
    }

    public final String getCREATEPSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_CREATEPSDEOPPRIVID, "");
    }

    public final void setCREATEPSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_CREATEPSDEOPPRIVID, strValue);
    }

    public final boolean isCREATEPSDEOPPRIVINAMENull() {
        return this.IsParamNull(TAG_CREATEPSDEOPPRIVINAME);
    }

    public final String getCREATEPSDEOPPRIVINAME() {
        return this.GetParamStringValue(TAG_CREATEPSDEOPPRIVINAME, "");
    }

    public final void setCREATEPSDEOPPRIVINAME(String strValue) {
        this.SetParamValue(TAG_CREATEPSDEOPPRIVINAME, strValue);
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

    public final boolean isBATCHSIZENull() {
        return this.IsParamNull(TAG_BATCHSIZE);
    }

    public final int getBATCHSIZE() {
        return this.GetParamIntValue(TAG_BATCHSIZE, 0);
    }

    public final void setBATCHSIZE(int nValue) {
        this.SetParamValue(TAG_BATCHSIZE, nValue);
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

    public final boolean isPOTIMENull() {
        return this.IsParamNull(TAG_POTIME);
    }

    public final int getPOTIME() {
        return this.GetParamIntValue(TAG_POTIME, 0);
    }

    public final void setPOTIME(int nValue) {
        this.SetParamValue(TAG_POTIME, nValue);
    }

    public final boolean isDATAIMPTYPENull() {
        return this.IsParamNull(TAG_DATAIMPTYPE);
    }

    public final String getDATAIMPTYPE() {
        return this.GetParamStringValue(TAG_DATAIMPTYPE, "");
    }

    public final void setDATAIMPTYPE(String strValue) {
        this.SetParamValue(TAG_DATAIMPTYPE, strValue);
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

    public final boolean isENABLECUSTOMIZEDNull() {
        return this.IsParamNull(TAG_ENABLECUSTOMIZED);
    }

    public final boolean getENABLECUSTOMIZED() {
        return this.GetParamIntValue(TAG_ENABLECUSTOMIZED, 0) == 1;
    }

    public final void setENABLECUSTOMIZED(boolean bValue) {
        this.SetParamValue(TAG_ENABLECUSTOMIZED, bValue ? 1 : 0);
    }

    public final boolean isIMPPARAMSNull() {
        return this.IsParamNull(TAG_IMPPARAMS);
    }

    public final String getIMPPARAMS() {
        return this.GetParamStringValue(TAG_IMPPARAMS, "");
    }

    public final void setIMPPARAMS(String strValue) {
        this.SetParamValue(TAG_IMPPARAMS, strValue);
    }

    public final boolean isIMPTAGNull() {
        return this.IsParamNull(TAG_IMPTAG);
    }

    public final String getIMPTAG() {
        return this.GetParamStringValue(TAG_IMPTAG, "");
    }

    public final void setIMPTAG(String strValue) {
        this.SetParamValue(TAG_IMPTAG, strValue);
    }

    public final boolean isIMPTAG2Null() {
        return this.IsParamNull(TAG_IMPTAG2);
    }

    public final String getIMPTAG2() {
        return this.GetParamStringValue(TAG_IMPTAG2, "");
    }

    public final void setIMPTAG2(String strValue) {
        this.SetParamValue(TAG_IMPTAG2, strValue);
    }
}

