/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEDataSync
extends BaseDataEntity {
    public static final String SYNCDIR_IN = "IN";
    public static final String SYNCDIR_OUT = "OUT";
    public static final int EVENTTYPE_CREATE = 1;
    public static final int EVENTTYPE_UPDATE = 2;
    public static final int EVENTTYPE_DELETE = 4;
    public static final String TAG_PSDEDATASYNCID = "PSDEDATASYNCID";
    public static final String TAG_PSDEDATASYNCNAME = "PSDEDATASYNCNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_SYNCDIR = "SYNCDIR";
    public static final String TAG_SYNCEXPORT = "SYNCEXPORT";
    public static final String TAG_EXPORTFULL = "EXPORTFULL";
    public static final String TAG_EVENTTYPE = "EVENTTYPE";
    public static final String TAG_INPSSYSDATASYNCAGENTID = "INPSSYSDATASYNCAGENTID";
    public static final String TAG_INPSSYSDATASYNCAGENTNAME = "INPSSYSDATASYNCAGENTNAME";
    public static final String TAG_OUTPSSYSDATASYNCAGENTID = "OUTPSSYSDATASYNCAGENTID";
    public static final String TAG_OUTPSSYSDATASYNCAGENTNAME = "OUTPSSYSDATASYNCAGENTNAME";
    public static final String TAG_OUTPSDEACTIONID = "OUTPSDEACTIONID";
    public static final String TAG_OUTPSDEACTIONNAME = "OUTPSDEACTIONNAME";
    public static final String TAG_INPSDEACTIONID = "INPSDEACTIONID";
    public static final String TAG_INPSDEACTIONNAME = "INPSDEACTIONNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_DENAMES = "DENAMES";
    public static final String TAG_IMPORTPSDEACTIONID = "IMPORTPSDEACTIONID";
    public static final String TAG_IMPORTPSDEACTIONNAME = "IMPORTPSDEACTIONNAME";
    public static final String TAG_INCUSTOMCODE = "INCUSTOMCODE";
    public static final String TAG_OUTCUSTOMCODE = "OUTCUSTOMCODE";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_OUTPSDEDATASETID = "OUTPSDEDATASETID";
    public static final String TAG_OUTPSDEDATASETNAME = "OUTPSDEDATASETNAME";
    public static final String TAG_OUTMODE = "OUTMODE";
    public static final String TAG_TIMERMODE = "TIMERMODE";
    public static final String TAG_INPSDEDATASETID = "INPSDEDATASETID";
    public static final String TAG_INPSDEDATASETNAME = "INPSDEDATASETNAME";
    public static final String TAG_INCUSTOMMODE = "INCUSTOMMODE";
    public static final String TAG_OUTCUSTOMMODE = "OUTCUSTOMMODE";

    public final boolean isPSDEDATASYNCIDNull() {
        return this.IsParamNull(TAG_PSDEDATASYNCID);
    }

    public final String getPSDEDATASYNCID() {
        return this.GetParamStringValue(TAG_PSDEDATASYNCID, "");
    }

    public final void setPSDEDATASYNCID(String strValue) {
        this.SetParamValue(TAG_PSDEDATASYNCID, strValue);
    }

    public final boolean isPSDEDATASYNCNAMENull() {
        return this.IsParamNull(TAG_PSDEDATASYNCNAME);
    }

    public final String getPSDEDATASYNCNAME() {
        return this.GetParamStringValue(TAG_PSDEDATASYNCNAME, "");
    }

    public final void setPSDEDATASYNCNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDATASYNCNAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isSYNCDIRNull() {
        return this.IsParamNull(TAG_SYNCDIR);
    }

    public final String getSYNCDIR() {
        return this.GetParamStringValue(TAG_SYNCDIR, "");
    }

    public final void setSYNCDIR(String strValue) {
        this.SetParamValue(TAG_SYNCDIR, strValue);
    }

    public final boolean isSYNCEXPORTNull() {
        return this.IsParamNull(TAG_SYNCEXPORT);
    }

    public final boolean getSYNCEXPORT() {
        return this.GetParamIntValue(TAG_SYNCEXPORT, 0) == 1;
    }

    public final void setSYNCEXPORT(boolean bValue) {
        this.SetParamValue(TAG_SYNCEXPORT, bValue ? 1 : 0);
    }

    public final boolean isEXPORTFULLNull() {
        return this.IsParamNull(TAG_EXPORTFULL);
    }

    public final boolean getEXPORTFULL() {
        return this.GetParamIntValue(TAG_EXPORTFULL, 0) == 1;
    }

    public final void setEXPORTFULL(boolean bValue) {
        this.SetParamValue(TAG_EXPORTFULL, bValue ? 1 : 0);
    }

    public final boolean isEVENTTYPENull() {
        return this.IsParamNull(TAG_EVENTTYPE);
    }

    public final int getEVENTTYPE() {
        return this.GetParamIntValue(TAG_EVENTTYPE, 0);
    }

    public final void setEVENTTYPE(int nValue) {
        this.SetParamValue(TAG_EVENTTYPE, nValue);
    }

    public final boolean isINPSSYSDATASYNCAGENTIDNull() {
        return this.IsParamNull(TAG_INPSSYSDATASYNCAGENTID);
    }

    public final String getINPSSYSDATASYNCAGENTID() {
        return this.GetParamStringValue(TAG_INPSSYSDATASYNCAGENTID, "");
    }

    public final void setINPSSYSDATASYNCAGENTID(String strValue) {
        this.SetParamValue(TAG_INPSSYSDATASYNCAGENTID, strValue);
    }

    public final boolean isINPSSYSDATASYNCAGENTNAMENull() {
        return this.IsParamNull(TAG_INPSSYSDATASYNCAGENTNAME);
    }

    public final String getINPSSYSDATASYNCAGENTNAME() {
        return this.GetParamStringValue(TAG_INPSSYSDATASYNCAGENTNAME, "");
    }

    public final void setINPSSYSDATASYNCAGENTNAME(String strValue) {
        this.SetParamValue(TAG_INPSSYSDATASYNCAGENTNAME, strValue);
    }

    public final boolean isOUTPSSYSDATASYNCAGENTIDNull() {
        return this.IsParamNull(TAG_OUTPSSYSDATASYNCAGENTID);
    }

    public final String getOUTPSSYSDATASYNCAGENTID() {
        return this.GetParamStringValue(TAG_OUTPSSYSDATASYNCAGENTID, "");
    }

    public final void setOUTPSSYSDATASYNCAGENTID(String strValue) {
        this.SetParamValue(TAG_OUTPSSYSDATASYNCAGENTID, strValue);
    }

    public final boolean isOUTPSSYSDATASYNCAGENTNAMENull() {
        return this.IsParamNull(TAG_OUTPSSYSDATASYNCAGENTNAME);
    }

    public final String getOUTPSSYSDATASYNCAGENTNAME() {
        return this.GetParamStringValue(TAG_OUTPSSYSDATASYNCAGENTNAME, "");
    }

    public final void setOUTPSSYSDATASYNCAGENTNAME(String strValue) {
        this.SetParamValue(TAG_OUTPSSYSDATASYNCAGENTNAME, strValue);
    }

    public final boolean isOUTPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_OUTPSDEACTIONID);
    }

    public final String getOUTPSDEACTIONID() {
        return this.GetParamStringValue(TAG_OUTPSDEACTIONID, "");
    }

    public final void setOUTPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_OUTPSDEACTIONID, strValue);
    }

    public final boolean isOUTPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_OUTPSDEACTIONNAME);
    }

    public final String getOUTPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_OUTPSDEACTIONNAME, "");
    }

    public final void setOUTPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_OUTPSDEACTIONNAME, strValue);
    }

    public final boolean isINPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_INPSDEACTIONID);
    }

    public final String getINPSDEACTIONID() {
        return this.GetParamStringValue(TAG_INPSDEACTIONID, "");
    }

    public final void setINPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_INPSDEACTIONID, strValue);
    }

    public final boolean isINPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_INPSDEACTIONNAME);
    }

    public final String getINPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_INPSDEACTIONNAME, "");
    }

    public final void setINPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_INPSDEACTIONNAME, strValue);
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

    public final boolean isDENAMESNull() {
        return this.IsParamNull(TAG_DENAMES);
    }

    public final String getDENAMES() {
        return this.GetParamStringValue(TAG_DENAMES, "");
    }

    public final void setDENAMES(String strValue) {
        this.SetParamValue(TAG_DENAMES, strValue);
    }

    public final boolean isIMPORTPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_IMPORTPSDEACTIONID);
    }

    public final String getIMPORTPSDEACTIONID() {
        return this.GetParamStringValue(TAG_IMPORTPSDEACTIONID, "");
    }

    public final void setIMPORTPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_IMPORTPSDEACTIONID, strValue);
    }

    public final boolean isIMPORTPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_IMPORTPSDEACTIONNAME);
    }

    public final String getIMPORTPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_IMPORTPSDEACTIONNAME, "");
    }

    public final void setIMPORTPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_IMPORTPSDEACTIONNAME, strValue);
    }

    public final boolean isINCUSTOMCODENull() {
        return this.IsParamNull(TAG_INCUSTOMCODE);
    }

    public final String getINCUSTOMCODE() {
        return this.GetParamStringValue(TAG_INCUSTOMCODE, "");
    }

    public final void setINCUSTOMCODE(String strValue) {
        this.SetParamValue(TAG_INCUSTOMCODE, strValue);
    }

    public final boolean isOUTCUSTOMCODENull() {
        return this.IsParamNull(TAG_OUTCUSTOMCODE);
    }

    public final String getOUTCUSTOMCODE() {
        return this.GetParamStringValue(TAG_OUTCUSTOMCODE, "");
    }

    public final void setOUTCUSTOMCODE(String strValue) {
        this.SetParamValue(TAG_OUTCUSTOMCODE, strValue);
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

    public final boolean isOUTPSDEDATASETIDNull() {
        return this.IsParamNull(TAG_OUTPSDEDATASETID);
    }

    public final String getOUTPSDEDATASETID() {
        return this.GetParamStringValue(TAG_OUTPSDEDATASETID, "");
    }

    public final void setOUTPSDEDATASETID(String strValue) {
        this.SetParamValue(TAG_OUTPSDEDATASETID, strValue);
    }

    public final boolean isOUTPSDEDATASETNAMENull() {
        return this.IsParamNull(TAG_OUTPSDEDATASETNAME);
    }

    public final String getOUTPSDEDATASETNAME() {
        return this.GetParamStringValue(TAG_OUTPSDEDATASETNAME, "");
    }

    public final void setOUTPSDEDATASETNAME(String strValue) {
        this.SetParamValue(TAG_OUTPSDEDATASETNAME, strValue);
    }

    public final boolean isOUTMODENull() {
        return this.IsParamNull(TAG_OUTMODE);
    }

    public final int getOUTMODE() {
        return this.GetParamIntValue(TAG_OUTMODE, 0);
    }

    public final void setOUTMODE(int nValue) {
        this.SetParamValue(TAG_OUTMODE, nValue);
    }

    public final boolean isTIMERMODENull() {
        return this.IsParamNull(TAG_TIMERMODE);
    }

    public final boolean getTIMERMODE() {
        return this.GetParamIntValue(TAG_TIMERMODE, 0) == 1;
    }

    public final void setTIMERMODE(boolean bValue) {
        this.SetParamValue(TAG_TIMERMODE, bValue ? 1 : 0);
    }

    public final boolean isINPSDEDATASETIDNull() {
        return this.IsParamNull(TAG_INPSDEDATASETID);
    }

    public final String getINPSDEDATASETID() {
        return this.GetParamStringValue(TAG_INPSDEDATASETID, "");
    }

    public final void setINPSDEDATASETID(String strValue) {
        this.SetParamValue(TAG_INPSDEDATASETID, strValue);
    }

    public final boolean isINPSDEDATASETNAMENull() {
        return this.IsParamNull(TAG_INPSDEDATASETNAME);
    }

    public final String getINPSDEDATASETNAME() {
        return this.GetParamStringValue(TAG_INPSDEDATASETNAME, "");
    }

    public final void setINPSDEDATASETNAME(String strValue) {
        this.SetParamValue(TAG_INPSDEDATASETNAME, strValue);
    }

    public final boolean isINCUSTOMMODENull() {
        return this.IsParamNull(TAG_INCUSTOMMODE);
    }

    public final boolean getINCUSTOMMODE() {
        return this.GetParamIntValue(TAG_INCUSTOMMODE, 0) == 1;
    }

    public final void setINCUSTOMMODE(boolean bValue) {
        this.SetParamValue(TAG_INCUSTOMMODE, bValue ? 1 : 0);
    }

    public final boolean isOUTCUSTOMMODENull() {
        return this.IsParamNull(TAG_OUTCUSTOMMODE);
    }

    public final boolean getOUTCUSTOMMODE() {
        return this.GetParamIntValue(TAG_OUTCUSTOMMODE, 0) == 1;
    }

    public final void setOUTCUSTOMMODE(boolean bValue) {
        this.SetParamValue(TAG_OUTCUSTOMMODE, bValue ? 1 : 0);
    }
}

