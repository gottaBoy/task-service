/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEActionLogic
extends BaseDataEntity {
    public static final String ATTACHMODE_BEFORE = "BEFORE";
    public static final String ATTACHMODE_AFTER = "AFTER";
    public static final String TAG_PSDEACTIONLOGICID = "PSDEACTIONLOGICID";
    public static final String TAG_PSDEACTIONLOGICNAME = "PSDEACTIONLOGICNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";
    public static final String TAG_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ATTACHMODE = "ATTACHMODE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_INTERNALLOGIC = "INTERNALLOGIC";
    public static final String TAG_DSTPSDEID = "DSTPSDEID";
    public static final String TAG_DSTPSDENAME = "DSTPSDENAME";
    public static final String TAG_DSTPSDEACTIONID = "DSTPSDEACTIONID";
    public static final String TAG_DSTPSDEACTIONNAME = "DSTPSDEACTIONNAME";
    public static final String TAG_CLONEPARAMFLAG = "CLONEPARAMFLAG";
    public static final String TAG_IGNOREEXCEPTION = "IGNOREEXCEPTION";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_PSDENOTIFYID = "PSDENOTIFYID";
    public static final String TAG_PSDENOTIFYNAME = "PSDENOTIFYNAME";
    public static final String TAG_PREPARELAST = "PREPARELAST";
    public static final String TAG_LOGICHOLDER = "LOGICHOLDER";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_DSTPSDEDATASETID = "DSTPSDEDATASETID";
    public static final String TAG_DSTPSDEDATASETNAME = "DSTPSDEDATASETNAME";
    public static final String TAG_DSTPSDEDATAQUERYID = "DSTPSDEDATAQUERYID";
    public static final String TAG_DSTPSDEDATAQUERYNAME = "DSTPSDEDATAQUERYNAME";
    public static final String TAG_PSDEFVALUERULEID = "PSDEFVALUERULEID";
    public static final String TAG_PSDEFVALUERULENAME = "PSDEFVALUERULENAME";
    public static final String TAG_MAJORPSDERID = "MAJORPSDERID";
    public static final String TAG_MAJORPSDERNAME = "MAJORPSDERNAME";
    public static final String TAG_MINORPSDERID = "MINORPSDERID";
    public static final String TAG_MINORPSDERNAME = "MINORPSDERNAME";
    public static final String TAG_PSDEMAINSTATEID = "PSDEMAINSTATEID";
    public static final String TAG_PSDEMAINSTATENAME = "PSDEMAINSTATENAME";
    public static final String TAG_PSDEDATASYNCID = "PSDEDATASYNCID";
    public static final String TAG_PSDEDATASYNCNAME = "PSDEDATASYNCNAME";
    public static final String TAG_PROPERTYMAP = "PROPERTYMAP";
    public static final String TAG_ERRORMSG = "ERRORMSG";
    public static final String TAG_ERRORPSLANRESID = "ERRORPSLANRESID";
    public static final String TAG_ERRORPSLANRESNAME = "ERRORPSLANRESNAME";
    public static final String TAG_ERRORCODE = "ERRORCODE";
    public static final String TAG_EXCEPTIONOBJ = "EXCEPTIONOBJ";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_PSSYSDELOGICNODEID = "PSSYSDELOGICNODEID";
    public static final String TAG_PSSYSDELOGICNODENAME = "PSSYSDELOGICNODENAME";
    public static final String TAG_PSSYSSEQUENCEID = "PSSYSSEQUENCEID";
    public static final String TAG_PSSYSSEQUENCENAME = "PSSYSSEQUENCENAME";
    public static final String TAG_PSSYSTRANSLATORID = "PSSYSTRANSLATORID";
    public static final String TAG_PSSYSTRANSLATORNAME = "PSSYSTRANSLATORNAME";
    public static final String TAG_DATASYNCEVENT = "DATASYNCEVENT";
    public static final String TAG_DSTPSDELOGICID = "DSTPSDELOGICID";
    public static final String TAG_DSTPSDELOGICNAME = "DSTPSDELOGICNAME";

    public final boolean isPSDEACTIONLOGICIDNull() {
        return this.IsParamNull(TAG_PSDEACTIONLOGICID);
    }

    public final String getPSDEACTIONLOGICID() {
        return this.GetParamStringValue(TAG_PSDEACTIONLOGICID, "");
    }

    public final void setPSDEACTIONLOGICID(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONLOGICID, strValue);
    }

    public final boolean isPSDEACTIONLOGICNAMENull() {
        return this.IsParamNull(TAG_PSDEACTIONLOGICNAME);
    }

    public final String getPSDEACTIONLOGICNAME() {
        return this.GetParamStringValue(TAG_PSDEACTIONLOGICNAME, "");
    }

    public final void setPSDEACTIONLOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONLOGICNAME, strValue);
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

    public final boolean isPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_PSDEACTIONID);
    }

    public final String getPSDEACTIONID() {
        return this.GetParamStringValue(TAG_PSDEACTIONID, "");
    }

    public final void setPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONID, strValue);
    }

    public final boolean isPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_PSDEACTIONNAME);
    }

    public final String getPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_PSDEACTIONNAME, "");
    }

    public final void setPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONNAME, strValue);
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

    public final boolean isATTACHMODENull() {
        return this.IsParamNull(TAG_ATTACHMODE);
    }

    public final String getATTACHMODE() {
        return this.GetParamStringValue(TAG_ATTACHMODE, "");
    }

    public final void setATTACHMODE(String strValue) {
        this.SetParamValue(TAG_ATTACHMODE, strValue);
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

    public final boolean isINTERNALLOGICNull() {
        return this.IsParamNull(TAG_INTERNALLOGIC);
    }

    public final int getINTERNALLOGIC() {
        return this.GetParamIntValue(TAG_INTERNALLOGIC, 0);
    }

    public final void setINTERNALLOGIC(int bValue) {
        this.SetParamValue(TAG_INTERNALLOGIC, bValue);
    }

    public final boolean isDSTPSDEIDNull() {
        return this.IsParamNull(TAG_DSTPSDEID);
    }

    public final String getDSTPSDEID() {
        return this.GetParamStringValue(TAG_DSTPSDEID, "");
    }

    public final void setDSTPSDEID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEID, strValue);
    }

    public final boolean isDSTPSDENAMENull() {
        return this.IsParamNull(TAG_DSTPSDENAME);
    }

    public final String getDSTPSDENAME() {
        return this.GetParamStringValue(TAG_DSTPSDENAME, "");
    }

    public final void setDSTPSDENAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDENAME, strValue);
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

    public final boolean isDSTPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_DSTPSDEACTIONID);
    }

    public final String getDSTPSDEACTIONID() {
        return this.GetParamStringValue(TAG_DSTPSDEACTIONID, "");
    }

    public final void setDSTPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEACTIONID, strValue);
    }

    public final boolean isDSTPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEACTIONNAME);
    }

    public final String getDSTPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEACTIONNAME, "");
    }

    public final void setDSTPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEACTIONNAME, strValue);
    }

    public final boolean isCLONEPARAMFLAGNull() {
        return this.IsParamNull(TAG_CLONEPARAMFLAG);
    }

    public final boolean getCLONEPARAMFLAG() {
        return this.GetParamIntValue(TAG_CLONEPARAMFLAG, 0) == 1;
    }

    public final void setCLONEPARAMFLAG(boolean bValue) {
        this.SetParamValue(TAG_CLONEPARAMFLAG, bValue ? 1 : 0);
    }

    public final boolean isIGNOREEXCEPTIONNull() {
        return this.IsParamNull(TAG_IGNOREEXCEPTION);
    }

    public final boolean getIGNOREEXCEPTION() {
        return this.GetParamIntValue(TAG_IGNOREEXCEPTION, 0) == 1;
    }

    public final void setIGNOREEXCEPTION(boolean bValue) {
        this.SetParamValue(TAG_IGNOREEXCEPTION, bValue ? 1 : 0);
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

    public final boolean isPSDENOTIFYIDNull() {
        return this.IsParamNull(TAG_PSDENOTIFYID);
    }

    public final String getPSDENOTIFYID() {
        return this.GetParamStringValue(TAG_PSDENOTIFYID, "");
    }

    public final void setPSDENOTIFYID(String strValue) {
        this.SetParamValue(TAG_PSDENOTIFYID, strValue);
    }

    public final boolean isPSDENOTIFYNAMENull() {
        return this.IsParamNull(TAG_PSDENOTIFYNAME);
    }

    public final String getPSDENOTIFYNAME() {
        return this.GetParamStringValue(TAG_PSDENOTIFYNAME, "");
    }

    public final void setPSDENOTIFYNAME(String strValue) {
        this.SetParamValue(TAG_PSDENOTIFYNAME, strValue);
    }

    public final boolean isPREPARELASTNull() {
        return this.IsParamNull(TAG_PREPARELAST);
    }

    public final int getPREPARELAST() {
        return this.GetParamIntValue(TAG_PREPARELAST, 0);
    }

    public final void setPREPARELAST(int bValue) {
        this.SetParamValue(TAG_PREPARELAST, bValue);
    }

    public final boolean isLOGICHOLDERNull() {
        return this.IsParamNull(TAG_LOGICHOLDER);
    }

    public final int getLOGICHOLDER() {
        return this.GetParamIntValue(TAG_LOGICHOLDER, 0);
    }

    public final void setLOGICHOLDER(int nValue) {
        this.SetParamValue(TAG_LOGICHOLDER, nValue);
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

    public final boolean isDSTPSDEDATASETIDNull() {
        return this.IsParamNull(TAG_DSTPSDEDATASETID);
    }

    public final String getDSTPSDEDATASETID() {
        return this.GetParamStringValue(TAG_DSTPSDEDATASETID, "");
    }

    public final void setDSTPSDEDATASETID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEDATASETID, strValue);
    }

    public final boolean isDSTPSDEDATASETNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEDATASETNAME);
    }

    public final String getDSTPSDEDATASETNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEDATASETNAME, "");
    }

    public final void setDSTPSDEDATASETNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEDATASETNAME, strValue);
    }

    public final boolean isDSTPSDEDATAQUERYIDNull() {
        return this.IsParamNull(TAG_DSTPSDEDATAQUERYID);
    }

    public final String getDSTPSDEDATAQUERYID() {
        return this.GetParamStringValue(TAG_DSTPSDEDATAQUERYID, "");
    }

    public final void setDSTPSDEDATAQUERYID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEDATAQUERYID, strValue);
    }

    public final boolean isDSTPSDEDATAQUERYNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEDATAQUERYNAME);
    }

    public final String getDSTPSDEDATAQUERYNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEDATAQUERYNAME, "");
    }

    public final void setDSTPSDEDATAQUERYNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEDATAQUERYNAME, strValue);
    }

    public final boolean isPSDEFVALUERULEIDNull() {
        return this.IsParamNull(TAG_PSDEFVALUERULEID);
    }

    public final String getPSDEFVALUERULEID() {
        return this.GetParamStringValue(TAG_PSDEFVALUERULEID, "");
    }

    public final void setPSDEFVALUERULEID(String strValue) {
        this.SetParamValue(TAG_PSDEFVALUERULEID, strValue);
    }

    public final boolean isPSDEFVALUERULENAMENull() {
        return this.IsParamNull(TAG_PSDEFVALUERULENAME);
    }

    public final String getPSDEFVALUERULENAME() {
        return this.GetParamStringValue(TAG_PSDEFVALUERULENAME, "");
    }

    public final void setPSDEFVALUERULENAME(String strValue) {
        this.SetParamValue(TAG_PSDEFVALUERULENAME, strValue);
    }

    public final boolean isMAJORPSDERIDNull() {
        return this.IsParamNull(TAG_MAJORPSDERID);
    }

    public final String getMAJORPSDERID() {
        return this.GetParamStringValue(TAG_MAJORPSDERID, "");
    }

    public final void setMAJORPSDERID(String strValue) {
        this.SetParamValue(TAG_MAJORPSDERID, strValue);
    }

    public final boolean isMAJORPSDERNAMENull() {
        return this.IsParamNull(TAG_MAJORPSDERNAME);
    }

    public final String getMAJORPSDERNAME() {
        return this.GetParamStringValue(TAG_MAJORPSDERNAME, "");
    }

    public final void setMAJORPSDERNAME(String strValue) {
        this.SetParamValue(TAG_MAJORPSDERNAME, strValue);
    }

    public final boolean isMINORPSDERIDNull() {
        return this.IsParamNull(TAG_MINORPSDERID);
    }

    public final String getMINORPSDERID() {
        return this.GetParamStringValue(TAG_MINORPSDERID, "");
    }

    public final void setMINORPSDERID(String strValue) {
        this.SetParamValue(TAG_MINORPSDERID, strValue);
    }

    public final boolean isMINORPSDERNAMENull() {
        return this.IsParamNull(TAG_MINORPSDERNAME);
    }

    public final String getMINORPSDERNAME() {
        return this.GetParamStringValue(TAG_MINORPSDERNAME, "");
    }

    public final void setMINORPSDERNAME(String strValue) {
        this.SetParamValue(TAG_MINORPSDERNAME, strValue);
    }

    public final boolean isPSDEMAINSTATEIDNull() {
        return this.IsParamNull(TAG_PSDEMAINSTATEID);
    }

    public final String getPSDEMAINSTATEID() {
        return this.GetParamStringValue(TAG_PSDEMAINSTATEID, "");
    }

    public final void setPSDEMAINSTATEID(String strValue) {
        this.SetParamValue(TAG_PSDEMAINSTATEID, strValue);
    }

    public final boolean isPSDEMAINSTATENAMENull() {
        return this.IsParamNull(TAG_PSDEMAINSTATENAME);
    }

    public final String getPSDEMAINSTATENAME() {
        return this.GetParamStringValue(TAG_PSDEMAINSTATENAME, "");
    }

    public final void setPSDEMAINSTATENAME(String strValue) {
        this.SetParamValue(TAG_PSDEMAINSTATENAME, strValue);
    }

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

    public final boolean isPROPERTYMAPNull() {
        return this.IsParamNull(TAG_PROPERTYMAP);
    }

    public final String getPROPERTYMAP() {
        return this.GetParamStringValue(TAG_PROPERTYMAP, "");
    }

    public final void setPROPERTYMAP(String strValue) {
        this.SetParamValue(TAG_PROPERTYMAP, strValue);
    }

    public final boolean isERRORMSGNull() {
        return this.IsParamNull(TAG_ERRORMSG);
    }

    public final String getERRORMSG() {
        return this.GetParamStringValue(TAG_ERRORMSG, "");
    }

    public final void setERRORMSG(String strValue) {
        this.SetParamValue(TAG_ERRORMSG, strValue);
    }

    public final boolean isERRORPSLANRESIDNull() {
        return this.IsParamNull(TAG_ERRORPSLANRESID);
    }

    public final String getERRORPSLANRESID() {
        return this.GetParamStringValue(TAG_ERRORPSLANRESID, "");
    }

    public final void setERRORPSLANRESID(String strValue) {
        this.SetParamValue(TAG_ERRORPSLANRESID, strValue);
    }

    public final boolean isERRORPSLANRESNAMENull() {
        return this.IsParamNull(TAG_ERRORPSLANRESNAME);
    }

    public final String getERRORPSLANRESNAME() {
        return this.GetParamStringValue(TAG_ERRORPSLANRESNAME, "");
    }

    public final void setERRORPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_ERRORPSLANRESNAME, strValue);
    }

    public final boolean isERRORCODENull() {
        return this.IsParamNull(TAG_ERRORCODE);
    }

    public final int getERRORCODE() {
        return this.GetParamIntValue(TAG_ERRORCODE, 0);
    }

    public final void setERRORCODE(int nValue) {
        this.SetParamValue(TAG_ERRORCODE, nValue);
    }

    public final boolean isEXCEPTIONOBJNull() {
        return this.IsParamNull(TAG_EXCEPTIONOBJ);
    }

    public final String getEXCEPTIONOBJ() {
        return this.GetParamStringValue(TAG_EXCEPTIONOBJ, "");
    }

    public final void setEXCEPTIONOBJ(String strValue) {
        this.SetParamValue(TAG_EXCEPTIONOBJ, strValue);
    }

    public final boolean isPSDEFIDNull() {
        return this.IsParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.GetParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.SetParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.IsParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.GetParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFNAME, strValue);
    }

    public final boolean isPSSYSDELOGICNODEIDNull() {
        return this.IsParamNull(TAG_PSSYSDELOGICNODEID);
    }

    public final String getPSSYSDELOGICNODEID() {
        return this.GetParamStringValue(TAG_PSSYSDELOGICNODEID, "");
    }

    public final void setPSSYSDELOGICNODEID(String strValue) {
        this.SetParamValue(TAG_PSSYSDELOGICNODEID, strValue);
    }

    public final boolean isPSSYSDELOGICNODENAMENull() {
        return this.IsParamNull(TAG_PSSYSDELOGICNODENAME);
    }

    public final String getPSSYSDELOGICNODENAME() {
        return this.GetParamStringValue(TAG_PSSYSDELOGICNODENAME, "");
    }

    public final void setPSSYSDELOGICNODENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDELOGICNODENAME, strValue);
    }

    public final boolean isPSSYSSEQUENCEIDNull() {
        return this.IsParamNull(TAG_PSSYSSEQUENCEID);
    }

    public final String getPSSYSSEQUENCEID() {
        return this.GetParamStringValue(TAG_PSSYSSEQUENCEID, "");
    }

    public final void setPSSYSSEQUENCEID(String strValue) {
        this.SetParamValue(TAG_PSSYSSEQUENCEID, strValue);
    }

    public final boolean isPSSYSSEQUENCENAMENull() {
        return this.IsParamNull(TAG_PSSYSSEQUENCENAME);
    }

    public final String getPSSYSSEQUENCENAME() {
        return this.GetParamStringValue(TAG_PSSYSSEQUENCENAME, "");
    }

    public final void setPSSYSSEQUENCENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSEQUENCENAME, strValue);
    }

    public final boolean isPSSYSTRANSLATORIDNull() {
        return this.IsParamNull(TAG_PSSYSTRANSLATORID);
    }

    public final String getPSSYSTRANSLATORID() {
        return this.GetParamStringValue(TAG_PSSYSTRANSLATORID, "");
    }

    public final void setPSSYSTRANSLATORID(String strValue) {
        this.SetParamValue(TAG_PSSYSTRANSLATORID, strValue);
    }

    public final boolean isPSSYSTRANSLATORNAMENull() {
        return this.IsParamNull(TAG_PSSYSTRANSLATORNAME);
    }

    public final String getPSSYSTRANSLATORNAME() {
        return this.GetParamStringValue(TAG_PSSYSTRANSLATORNAME, "");
    }

    public final void setPSSYSTRANSLATORNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTRANSLATORNAME, strValue);
    }

    public final boolean isDATASYNCEVENTNull() {
        return this.IsParamNull(TAG_DATASYNCEVENT);
    }

    public final int getDATASYNCEVENT() {
        return this.GetParamIntValue(TAG_DATASYNCEVENT, 0);
    }

    public final void setDATASYNCEVENT(int nValue) {
        this.SetParamValue(TAG_DATASYNCEVENT, nValue);
    }

    public final boolean isDSTPSDELOGICIDNull() {
        return this.IsParamNull(TAG_DSTPSDELOGICID);
    }

    public final String getDSTPSDELOGICID() {
        return this.GetParamStringValue(TAG_DSTPSDELOGICID, "");
    }

    public final void setDSTPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_DSTPSDELOGICID, strValue);
    }

    public final boolean isDSTPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_DSTPSDELOGICNAME);
    }

    public final String getDSTPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_DSTPSDELOGICNAME, "");
    }

    public final void setDSTPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDELOGICNAME, strValue);
    }
}

