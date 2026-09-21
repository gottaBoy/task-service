/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDER
extends BaseDataEntity {
    public static final String DERTYPE_DER1N = "DER1N";
    public static final String DERTYPE_DER11 = "DER11";
    public static final String DERTYPE_DERINDEX = "DERINDEX";
    public static final String DERTYPE_DERINHERIT = "DERINHERIT";
    public static final String DERTYPE_DERCUSTOM = "DERCUSTOM";
    public static final int REMOVEACTIONTYPE_NONE = 0;
    public static final int REMOVEACTIONTYPE_DELETE = 1;
    public static final int REMOVEACTIONTYPE_RESET = 2;
    public static final int REMOVEACTIONTYPE_REJECT = 3;
    public static final int SYNCEXPORTMODEL_SYNC = 1;
    public static final int SYNCEXPORTMODEL_RESET = 2;
    public static final int EXPORTMAJORMODEL_SIMPLE = 1;
    public static final int INHERITMODE_STORAGE = 1;
    public static final int INHERITMODE_LOGIC = 2;
    public static final String DERSUBTYPE_DER1N = "DER1N";
    public static final String DERSUBTYPE_DER11 = "DER11";
    public static final String DERSUBTYPE_USER = "USER";
    public static final String DERSUBTYPE_USER2 = "USER2";
    public static final String DERSUBTYPE_USER3 = "USER3";
    public static final String DERSUBTYPE_USER4 = "USER4";
    public static final String TAG_PSDERID = "PSDERID";
    public static final String TAG_PSDERNAME = "PSDERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DERTYPE = "DERTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_MAJORPSDEID = "MAJORPSDEID";
    public static final String TAG_MAJORPSDENAME = "MAJORPSDENAME";
    public static final String TAG_MINORPSDEID = "MINORPSDEID";
    public static final String TAG_MINORPSDENAME = "MINORPSDENAME";
    public static final String TAG_DERFIELDNAME = "DERFIELDNAME";
    public static final String TAG_DERFIELDLNAME = "DERFIELDLNAME";
    public static final String TAG_REMOVEACTIONTYPE = "REMOVEACTIONTYPE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_REMOVEORDER = "REMOVEORDER";
    public static final String TAG_PSDEDATASETID = "PSDEDATASETID";
    public static final String TAG_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String TAG_MASTERRS = "MASTERRS";
    public static final String TAG_PSDEACMODEID = "PSDEACMODEID";
    public static final String TAG_PSDEACMODENAME = "PSDEACMODENAME";
    public static final String TAG_SDPSDEVIEWID = "SDPSDEVIEWID";
    public static final String TAG_SDPSDEVIEWNAME = "SDPSDEVIEWNAME";
    public static final String TAG_MDPSDEVIEWID = "MDPSDEVIEWID";
    public static final String TAG_MDPSDEVIEWNAME = "MDPSDEVIEWNAME";
    public static final String TAG_RSPSDEVIEWID = "RSPSDEVIEWID";
    public static final String TAG_RSPSDEVIEWNAME = "RSPSDEVIEWNAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_ENABLECLONE = "ENABLECLONE";
    public static final String TAG_ENAEXTRANGE = "ENAEXTRANGE";
    public static final String TAG_EXTMAJORPSDEFID = "EXTMAJORPSDEFID";
    public static final String TAG_EXTMAJORPSDEFNAME = "EXTMAJORPSDEFNAME";
    public static final String TAG_EXTMINORPSDEFID = "EXTMINORPSDEFID";
    public static final String TAG_EXTMINORPSDEFNAME = "EXTMINORPSDEFNAME";
    public static final String TAG_INDEXVALUE = "INDEXVALUE";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_FOREIGNKEY = "FOREIGNKEY";
    public static final String TAG_CLONEORDERVALUE = "CLONEORDERVALUE";
    public static final String TAG_TEMPORDERVALUE = "TEMPORDERVALUE";
    public static final String TAG_CLONERSFIELDS = "CLONERSFIELDS";
    public static final String TAG_MINORCODENAME = "MINORCODENAME";
    public static final String TAG_ENAPDEREQ = "ENAPDEREQ";
    public static final String TAG_MAJORPSDERID = "MAJORPSDERID";
    public static final String TAG_MAJORPSDERNAME = "MAJORPSDERNAME";
    public static final String TAG_MINORPSDERID = "MINORPSDERID";
    public static final String TAG_MINORPSDERNAME = "MINORPSDERNAME";
    public static final String TAG_EXPORTMODEL = "EXPORTMODEL";
    public static final String TAG_SYNCEXPORTMODEL = "SYNCEXPORTMODEL";
    public static final String TAG_FKEYNAME = "FKEYNAME";
    public static final String TAG_PROPERTYMAP = "PROPERTYMAP";
    public static final String TAG_IGNOREDEFIELDS = "IGNOREDEFIELDS";
    public static final String TAG_LINKPSDEVIEWID = "LINKPSDEVIEWID";
    public static final String TAG_LINKPSDEVIEWNAME = "LINKPSDEVIEWNAME";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_CNTPSDEFID = "CNTPSDEFID";
    public static final String TAG_CNTPSDEFNAME = "CNTPSDEFNAME";
    public static final String TAG_EXPORTMAJORMODEL = "EXPORTMAJORMODEL";
    public static final String TAG_EXPORTSCOPE = "EXPORTSCOPE";
    public static final String TAG_EXPORTSCOPE2 = "EXPORTSCOPE2";
    public static final String TAG_EXPORTSCOPE3 = "EXPORTSCOPE3";
    public static final String TAG_EXPORTSCOPE4 = "EXPORTSCOPE4";
    public static final String TAG_EXPORTSCOPE5 = "EXPORTSCOPE5";
    public static final String TAG_EXPORTSCOPE6 = "EXPORTSCOPE6";
    public static final String TAG_LOCKFLAG = "LOCKFLAG";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String TAG_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String TAG_INHERITMODE = "INHERITMODE";
    public static final String TAG_MOBLINKPSDEVIEWID = "MOBLINKPSDEVIEWID";
    public static final String TAG_MOBLINKPSDEVIEWNAME = "MOBLINKPSDEVIEWNAME";
    public static final String TAG_MOBMDPSDEVIEWID = "MOBMDPSDEVIEWID";
    public static final String TAG_MOBMDPSDEVIEWNAME = "MOBMDPSDEVIEWNAME";
    public static final String TAG_MOBSDPSDEVIEWID = "MOBSDPSDEVIEWID";
    public static final String TAG_MOBSDPSDEVIEWNAME = "MOBSDPSDEVIEWNAME";
    public static final String TAG_ENADEFIELDWRITEBACK = "ENADEFIELDWRITEBACK";
    public static final String TAG_MASTERORDERVALUE = "MASTERORDERVALUE";
    public static final String TAG_REMOVEREJECTMSG = "REMOVEREJECTMSG";
    public static final String TAG_REMOVEREJECTPSLANRESID = "REMOVEREJECTPSLANRESID";
    public static final String TAG_REMOVEREJECTPSLANRESNAME = "REMOVEREJECTPSLANRESNAME";
    public static final String TAG_DERSUBTYPE = "DERSUBTYPE";
    public static final String TAG_MINORPSDEDSID = "MINORPSDEDSID";
    public static final String TAG_MINORPSDEDSNAME = "MINORPSDEDSNAME";
    public static final String TAG_SERVICECODENAME = "SERVICECODENAME";
    public static final String TAG_MINORSERVICECODENAME = "MINORSERVICECODENAME";
    public static final String TAG_DERTAG = "DERTAG";
    public static final String TAG_DERTAG2 = "DERTAG2";
    public static final String TAG_UPDATEPHYSICALDEFIELD = "UPDATEPHYSICALDEFIELD";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_MINORLOGICNAME = "MINORLOGICNAME";
    public static final String TAG_PSDEFGROUPID = "PSDEFGROUPID";
    public static final String TAG_PSDEFGROUPNAME = "PSDEFGROUPNAME";

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

    public final boolean isDERTYPENull() {
        return this.IsParamNull(TAG_DERTYPE);
    }

    public final String getDERTYPE() {
        return this.GetParamStringValue(TAG_DERTYPE, "");
    }

    public final void setDERTYPE(String strValue) {
        this.SetParamValue(TAG_DERTYPE, strValue);
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

    public final boolean isMAJORPSDEIDNull() {
        return this.IsParamNull(TAG_MAJORPSDEID);
    }

    public final String getMAJORPSDEID() {
        return this.GetParamStringValue(TAG_MAJORPSDEID, "");
    }

    public final void setMAJORPSDEID(String strValue) {
        this.SetParamValue(TAG_MAJORPSDEID, strValue);
    }

    public final boolean isMAJORPSDENAMENull() {
        return this.IsParamNull(TAG_MAJORPSDENAME);
    }

    public final String getMAJORPSDENAME() {
        return this.GetParamStringValue(TAG_MAJORPSDENAME, "");
    }

    public final void setMAJORPSDENAME(String strValue) {
        this.SetParamValue(TAG_MAJORPSDENAME, strValue);
    }

    public final boolean isMINORPSDEIDNull() {
        return this.IsParamNull(TAG_MINORPSDEID);
    }

    public final String getMINORPSDEID() {
        return this.GetParamStringValue(TAG_MINORPSDEID, "");
    }

    public final void setMINORPSDEID(String strValue) {
        this.SetParamValue(TAG_MINORPSDEID, strValue);
    }

    public final boolean isMINORPSDENAMENull() {
        return this.IsParamNull(TAG_MINORPSDENAME);
    }

    public final String getMINORPSDENAME() {
        return this.GetParamStringValue(TAG_MINORPSDENAME, "");
    }

    public final void setMINORPSDENAME(String strValue) {
        this.SetParamValue(TAG_MINORPSDENAME, strValue);
    }

    public final boolean isDERFIELDNAMENull() {
        return this.IsParamNull(TAG_DERFIELDNAME);
    }

    public final String getDERFIELDNAME() {
        return this.GetParamStringValue(TAG_DERFIELDNAME, "");
    }

    public final void setDERFIELDNAME(String strValue) {
        this.SetParamValue(TAG_DERFIELDNAME, strValue);
    }

    public final boolean isDERFIELDLNAMENull() {
        return this.IsParamNull(TAG_DERFIELDLNAME);
    }

    public final String getDERFIELDLNAME() {
        return this.GetParamStringValue(TAG_DERFIELDLNAME, "");
    }

    public final void setDERFIELDLNAME(String strValue) {
        this.SetParamValue(TAG_DERFIELDLNAME, strValue);
    }

    public final boolean isREMOVEACTIONTYPENull() {
        return this.IsParamNull(TAG_REMOVEACTIONTYPE);
    }

    public final int getREMOVEACTIONTYPE() {
        return this.GetParamIntValue(TAG_REMOVEACTIONTYPE, 0);
    }

    public final void setREMOVEACTIONTYPE(int nValue) {
        this.SetParamValue(TAG_REMOVEACTIONTYPE, nValue);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isREMOVEORDERNull() {
        return this.IsParamNull(TAG_REMOVEORDER);
    }

    public final int getREMOVEORDER() {
        return this.GetParamIntValue(TAG_REMOVEORDER, 0);
    }

    public final void setREMOVEORDER(int nValue) {
        this.SetParamValue(TAG_REMOVEORDER, nValue);
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

    public final boolean isMASTERRSNull() {
        return this.IsParamNull(TAG_MASTERRS);
    }

    public final int getMASTERRS() {
        return this.GetParamIntValue(TAG_MASTERRS, 0);
    }

    public final void setMASTERRS(boolean bValue) {
        this.SetParamValue(TAG_MASTERRS, bValue ? 1 : 0);
    }

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

    public final boolean isSDPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_SDPSDEVIEWID);
    }

    public final String getSDPSDEVIEWID() {
        return this.GetParamStringValue(TAG_SDPSDEVIEWID, "");
    }

    public final void setSDPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_SDPSDEVIEWID, strValue);
    }

    public final boolean isSDPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_SDPSDEVIEWNAME);
    }

    public final String getSDPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_SDPSDEVIEWNAME, "");
    }

    public final void setSDPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_SDPSDEVIEWNAME, strValue);
    }

    public final boolean isMDPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_MDPSDEVIEWID);
    }

    public final String getMDPSDEVIEWID() {
        return this.GetParamStringValue(TAG_MDPSDEVIEWID, "");
    }

    public final void setMDPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_MDPSDEVIEWID, strValue);
    }

    public final boolean isMDPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_MDPSDEVIEWNAME);
    }

    public final String getMDPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_MDPSDEVIEWNAME, "");
    }

    public final void setMDPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_MDPSDEVIEWNAME, strValue);
    }

    public final boolean isRSPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_RSPSDEVIEWID);
    }

    public final String getRSPSDEVIEWID() {
        return this.GetParamStringValue(TAG_RSPSDEVIEWID, "");
    }

    public final void setRSPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_RSPSDEVIEWID, strValue);
    }

    public final boolean isRSPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_RSPSDEVIEWNAME);
    }

    public final String getRSPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_RSPSDEVIEWNAME, "");
    }

    public final void setRSPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_RSPSDEVIEWNAME, strValue);
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

    public final boolean isMINORLOGICNAMENull() {
        return this.IsParamNull(TAG_MINORLOGICNAME);
    }

    public final String getMINORLOGICNAME() {
        return this.GetParamStringValue(TAG_MINORLOGICNAME, "");
    }

    public final void setMINORLOGICNAME(String strValue) {
        this.SetParamValue(TAG_MINORLOGICNAME, strValue);
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

    public final boolean isENABLECLONENull() {
        return this.IsParamNull(TAG_ENABLECLONE);
    }

    public final boolean getENABLECLONE() {
        return this.GetParamIntValue(TAG_ENABLECLONE, 0) == 1;
    }

    public final void setENABLECLONE(boolean bValue) {
        this.SetParamValue(TAG_ENABLECLONE, bValue ? 1 : 0);
    }

    public final boolean isENAEXTRANGENull() {
        return this.IsParamNull(TAG_ENAEXTRANGE);
    }

    public final boolean getENAEXTRANGE() {
        return this.GetParamIntValue(TAG_ENAEXTRANGE, 0) == 1;
    }

    public final void setENAEXTRANGE(boolean bValue) {
        this.SetParamValue(TAG_ENAEXTRANGE, bValue ? 1 : 0);
    }

    public final boolean isEXTMAJORPSDEFIDNull() {
        return this.IsParamNull(TAG_EXTMAJORPSDEFID);
    }

    public final String getEXTMAJORPSDEFID() {
        return this.GetParamStringValue(TAG_EXTMAJORPSDEFID, "");
    }

    public final void setEXTMAJORPSDEFID(String strValue) {
        this.SetParamValue(TAG_EXTMAJORPSDEFID, strValue);
    }

    public final boolean isEXTMAJORPSDEFNAMENull() {
        return this.IsParamNull(TAG_EXTMAJORPSDEFNAME);
    }

    public final String getEXTMAJORPSDEFNAME() {
        return this.GetParamStringValue(TAG_EXTMAJORPSDEFNAME, "");
    }

    public final void setEXTMAJORPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_EXTMAJORPSDEFNAME, strValue);
    }

    public final boolean isEXTMINORPSDEFIDNull() {
        return this.IsParamNull(TAG_EXTMINORPSDEFID);
    }

    public final String getEXTMINORPSDEFID() {
        return this.GetParamStringValue(TAG_EXTMINORPSDEFID, "");
    }

    public final void setEXTMINORPSDEFID(String strValue) {
        this.SetParamValue(TAG_EXTMINORPSDEFID, strValue);
    }

    public final boolean isEXTMINORPSDEFNAMENull() {
        return this.IsParamNull(TAG_EXTMINORPSDEFNAME);
    }

    public final String getEXTMINORPSDEFNAME() {
        return this.GetParamStringValue(TAG_EXTMINORPSDEFNAME, "");
    }

    public final void setEXTMINORPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_EXTMINORPSDEFNAME, strValue);
    }

    public final boolean isINDEXVALUENull() {
        return this.IsParamNull(TAG_INDEXVALUE);
    }

    public final String getINDEXVALUE() {
        return this.GetParamStringValue(TAG_INDEXVALUE, "");
    }

    public final void setINDEXVALUE(String strValue) {
        this.SetParamValue(TAG_INDEXVALUE, strValue);
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

    public final boolean isFOREIGNKEYNull() {
        return this.IsParamNull(TAG_FOREIGNKEY);
    }

    public final boolean getFOREIGNKEY() {
        return this.GetParamIntValue(TAG_FOREIGNKEY, 0) == 1;
    }

    public final void setFOREIGNKEY(boolean bValue) {
        this.SetParamValue(TAG_FOREIGNKEY, bValue ? 1 : 0);
    }

    public final boolean isCLONEORDERVALUENull() {
        return this.IsParamNull(TAG_CLONEORDERVALUE);
    }

    public final int getCLONEORDERVALUE() {
        return this.GetParamIntValue(TAG_CLONEORDERVALUE, 0);
    }

    public final void setCLONEORDERVALUE(int nValue) {
        this.SetParamValue(TAG_CLONEORDERVALUE, nValue);
    }

    public final boolean isTEMPORDERVALUENull() {
        return this.IsParamNull(TAG_TEMPORDERVALUE);
    }

    public final int getTEMPORDERVALUE() {
        return this.GetParamIntValue(TAG_TEMPORDERVALUE, 0);
    }

    public final void setTEMPORDERVALUE(int nValue) {
        this.SetParamValue(TAG_TEMPORDERVALUE, nValue);
    }

    public final boolean isCLONERSFIELDSNull() {
        return this.IsParamNull(TAG_CLONERSFIELDS);
    }

    public final String getCLONERSFIELDS() {
        return this.GetParamStringValue(TAG_CLONERSFIELDS, "");
    }

    public final void setCLONERSFIELDS(String strValue) {
        this.SetParamValue(TAG_CLONERSFIELDS, strValue);
    }

    public final void setMASTERRS(int nValue) {
        this.SetParamValue(TAG_MASTERRS, nValue);
    }

    public final boolean isMINORCODENAMENull() {
        return this.IsParamNull(TAG_MINORCODENAME);
    }

    public final String getMINORCODENAME() {
        return this.GetParamStringValue(TAG_MINORCODENAME, "");
    }

    public final void setMINORCODENAME(String strValue) {
        this.SetParamValue(TAG_MINORCODENAME, strValue);
    }

    public final boolean isENAPDEREQNull() {
        return this.IsParamNull(TAG_ENAPDEREQ);
    }

    public final boolean getENAPDEREQ() {
        return this.GetParamIntValue(TAG_ENAPDEREQ, 0) == 1;
    }

    public final void setENAPDEREQ(boolean bValue) {
        this.SetParamValue(TAG_ENAPDEREQ, bValue ? 1 : 0);
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

    public final boolean isEXPORTMODELNull() {
        return this.IsParamNull(TAG_EXPORTMODEL);
    }

    public final int getEXPORTMODEL() {
        return this.GetParamIntValue(TAG_EXPORTMODEL, 0);
    }

    public final void setEXPORTMODEL(int nValue) {
        this.SetParamValue(TAG_EXPORTMODEL, nValue);
    }

    public final boolean isSYNCEXPORTMODELNull() {
        return this.IsParamNull(TAG_SYNCEXPORTMODEL);
    }

    public final int getSYNCEXPORTMODEL() {
        return this.GetParamIntValue(TAG_SYNCEXPORTMODEL, 0);
    }

    public final void setSYNCEXPORTMODEL(int nValue) {
        this.SetParamValue(TAG_SYNCEXPORTMODEL, nValue);
    }

    public final boolean isFKEYNAMENull() {
        return this.IsParamNull(TAG_FKEYNAME);
    }

    public final String getFKEYNAME() {
        return this.GetParamStringValue(TAG_FKEYNAME, "");
    }

    public final void setFKEYNAME(String strValue) {
        this.SetParamValue(TAG_FKEYNAME, strValue);
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

    public final boolean isIGNOREDEFIELDSNull() {
        return this.IsParamNull(TAG_IGNOREDEFIELDS);
    }

    public final String getIGNOREDEFIELDS() {
        return this.GetParamStringValue(TAG_IGNOREDEFIELDS, "");
    }

    public final void setIGNOREDEFIELDS(String strValue) {
        this.SetParamValue(TAG_IGNOREDEFIELDS, strValue);
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

    public final boolean isUSERPARAMSNull() {
        return this.IsParamNull(TAG_USERPARAMS);
    }

    public final String getUSERPARAMS() {
        return this.GetParamStringValue(TAG_USERPARAMS, "");
    }

    public final void setUSERPARAMS(String strValue) {
        this.SetParamValue(TAG_USERPARAMS, strValue);
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

    public final boolean isCNTPSDEFIDNull() {
        return this.IsParamNull(TAG_CNTPSDEFID);
    }

    public final String getCNTPSDEFID() {
        return this.GetParamStringValue(TAG_CNTPSDEFID, "");
    }

    public final void setCNTPSDEFID(String strValue) {
        this.SetParamValue(TAG_CNTPSDEFID, strValue);
    }

    public final boolean isCNTPSDEFNAMENull() {
        return this.IsParamNull(TAG_CNTPSDEFNAME);
    }

    public final String getCNTPSDEFNAME() {
        return this.GetParamStringValue(TAG_CNTPSDEFNAME, "");
    }

    public final void setCNTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_CNTPSDEFNAME, strValue);
    }

    public final boolean isEXPORTMAJORMODELNull() {
        return this.IsParamNull(TAG_EXPORTMAJORMODEL);
    }

    public final int getEXPORTMAJORMODEL() {
        return this.GetParamIntValue(TAG_EXPORTMAJORMODEL, 0);
    }

    public final void setEXPORTMAJORMODEL(int nValue) {
        this.SetParamValue(TAG_EXPORTMAJORMODEL, nValue);
    }

    public final boolean isEXPORTSCOPENull() {
        return this.IsParamNull(TAG_EXPORTSCOPE);
    }

    public final int getEXPORTSCOPE() {
        return this.GetParamIntValue(TAG_EXPORTSCOPE, 0);
    }

    public final void setEXPORTSCOPE(int nValue) {
        this.SetParamValue(TAG_EXPORTSCOPE, nValue);
    }

    public final boolean isEXPORTSCOPE2Null() {
        return this.IsParamNull(TAG_EXPORTSCOPE2);
    }

    public final int getEXPORTSCOPE2() {
        return this.GetParamIntValue(TAG_EXPORTSCOPE2, 0);
    }

    public final void setEXPORTSCOPE2(int nValue) {
        this.SetParamValue(TAG_EXPORTSCOPE2, nValue);
    }

    public final boolean isEXPORTSCOPE3Null() {
        return this.IsParamNull(TAG_EXPORTSCOPE3);
    }

    public final int getEXPORTSCOPE3() {
        return this.GetParamIntValue(TAG_EXPORTSCOPE3, 0);
    }

    public final void setEXPORTSCOPE3(int nValue) {
        this.SetParamValue(TAG_EXPORTSCOPE3, nValue);
    }

    public final boolean isEXPORTSCOPE4Null() {
        return this.IsParamNull(TAG_EXPORTSCOPE4);
    }

    public final int getEXPORTSCOPE4() {
        return this.GetParamIntValue(TAG_EXPORTSCOPE4, 0);
    }

    public final void setEXPORTSCOPE4(int nValue) {
        this.SetParamValue(TAG_EXPORTSCOPE4, nValue);
    }

    public final boolean isEXPORTSCOPE5Null() {
        return this.IsParamNull(TAG_EXPORTSCOPE5);
    }

    public final int getEXPORTSCOPE5() {
        return this.GetParamIntValue(TAG_EXPORTSCOPE5, 0);
    }

    public final void setEXPORTSCOPE5(int nValue) {
        this.SetParamValue(TAG_EXPORTSCOPE5, nValue);
    }

    public final boolean isEXPORTSCOPE6Null() {
        return this.IsParamNull(TAG_EXPORTSCOPE6);
    }

    public final int getEXPORTSCOPE6() {
        return this.GetParamIntValue(TAG_EXPORTSCOPE6, 0);
    }

    public final void setEXPORTSCOPE6(int nValue) {
        this.SetParamValue(TAG_EXPORTSCOPE6, nValue);
    }

    public final boolean isLOCKFLAGNull() {
        return this.IsParamNull(TAG_LOCKFLAG);
    }

    public final boolean getLOCKFLAG() {
        return this.GetParamIntValue(TAG_LOCKFLAG, 0) == 1;
    }

    public final void setLOCKFLAG(boolean bValue) {
        this.SetParamValue(TAG_LOCKFLAG, bValue ? 1 : 0);
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

    public final boolean isDYNAMODELFLAGNull() {
        return this.IsParamNull(TAG_DYNAMODELFLAG);
    }

    public final int getDYNAMODELFLAG() {
        return this.GetParamIntValue(TAG_DYNAMODELFLAG, 0);
    }

    public final void setDYNAMODELFLAG(int nValue) {
        this.SetParamValue(TAG_DYNAMODELFLAG, nValue);
    }

    public final boolean isPSDYNAINSTIDNull() {
        return this.IsParamNull(TAG_PSDYNAINSTID);
    }

    public final String getPSDYNAINSTID() {
        return this.GetParamStringValue(TAG_PSDYNAINSTID, "");
    }

    public final void setPSDYNAINSTID(String strValue) {
        this.SetParamValue(TAG_PSDYNAINSTID, strValue);
    }

    public final boolean isINHERITMODENull() {
        return this.IsParamNull(TAG_INHERITMODE);
    }

    public final int getINHERITMODE() {
        return this.GetParamIntValue(TAG_INHERITMODE, 0);
    }

    public final void setINHERITMODE(int nValue) {
        this.SetParamValue(TAG_INHERITMODE, nValue);
    }

    public final boolean isMOBLINKPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_MOBLINKPSDEVIEWID);
    }

    public final String getMOBLINKPSDEVIEWID() {
        return this.GetParamStringValue(TAG_MOBLINKPSDEVIEWID, "");
    }

    public final void setMOBLINKPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_MOBLINKPSDEVIEWID, strValue);
    }

    public final boolean isMOBLINKPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_MOBLINKPSDEVIEWNAME);
    }

    public final String getMOBLINKPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_MOBLINKPSDEVIEWNAME, "");
    }

    public final void setMOBLINKPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_MOBLINKPSDEVIEWNAME, strValue);
    }

    public final boolean isMOBMDPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_MOBMDPSDEVIEWID);
    }

    public final String getMOBMDPSDEVIEWID() {
        return this.GetParamStringValue(TAG_MOBMDPSDEVIEWID, "");
    }

    public final void setMOBMDPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_MOBMDPSDEVIEWID, strValue);
    }

    public final boolean isMOBMDPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_MOBMDPSDEVIEWNAME);
    }

    public final String getMOBMDPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_MOBMDPSDEVIEWNAME, "");
    }

    public final void setMOBMDPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_MOBMDPSDEVIEWNAME, strValue);
    }

    public final boolean isMOBSDPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_MOBSDPSDEVIEWID);
    }

    public final String getMOBSDPSDEVIEWID() {
        return this.GetParamStringValue(TAG_MOBSDPSDEVIEWID, "");
    }

    public final void setMOBSDPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_MOBSDPSDEVIEWID, strValue);
    }

    public final boolean isMOBSDPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_MOBSDPSDEVIEWNAME);
    }

    public final String getMOBSDPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_MOBSDPSDEVIEWNAME, "");
    }

    public final void setMOBSDPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_MOBSDPSDEVIEWNAME, strValue);
    }

    public final boolean isENADEFIELDWRITEBACKNull() {
        return this.IsParamNull(TAG_ENADEFIELDWRITEBACK);
    }

    public final int getENADEFIELDWRITEBACK() {
        return this.GetParamIntValue(TAG_ENADEFIELDWRITEBACK, 0);
    }

    public final void setENADEFIELDWRITEBACK(int bValue) {
        this.SetParamValue(TAG_ENADEFIELDWRITEBACK, bValue);
    }

    public final boolean isMASTERORDERVALUENull() {
        return this.IsParamNull(TAG_MASTERORDERVALUE);
    }

    public final int getMASTERORDERVALUE() {
        return this.GetParamIntValue(TAG_MASTERORDERVALUE, 0);
    }

    public final void setMASTERORDERVALUE(int nValue) {
        this.SetParamValue(TAG_MASTERORDERVALUE, nValue);
    }

    public final boolean isREMOVEREJECTMSGNull() {
        return this.IsParamNull(TAG_REMOVEREJECTMSG);
    }

    public final String getREMOVEREJECTMSG() {
        return this.GetParamStringValue(TAG_REMOVEREJECTMSG, "");
    }

    public final void setREMOVEREJECTMSG(String strValue) {
        this.SetParamValue(TAG_REMOVEREJECTMSG, strValue);
    }

    public final boolean isREMOVEREJECTPSLANRESIDNull() {
        return this.IsParamNull(TAG_REMOVEREJECTPSLANRESID);
    }

    public final String getREMOVEREJECTPSLANRESID() {
        return this.GetParamStringValue(TAG_REMOVEREJECTPSLANRESID, "");
    }

    public final void setREMOVEREJECTPSLANRESID(String strValue) {
        this.SetParamValue(TAG_REMOVEREJECTPSLANRESID, strValue);
    }

    public final boolean isREMOVEREJECTPSLANRESNAMENull() {
        return this.IsParamNull(TAG_REMOVEREJECTPSLANRESNAME);
    }

    public final String getREMOVEREJECTPSLANRESNAME() {
        return this.GetParamStringValue(TAG_REMOVEREJECTPSLANRESNAME, "");
    }

    public final void setREMOVEREJECTPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_REMOVEREJECTPSLANRESNAME, strValue);
    }

    public final boolean isDERSUBTYPENull() {
        return this.IsParamNull(TAG_DERSUBTYPE);
    }

    public final String getDERSUBTYPE() {
        return this.GetParamStringValue(TAG_DERSUBTYPE, "");
    }

    public final void setDERSUBTYPE(String strValue) {
        this.SetParamValue(TAG_DERSUBTYPE, strValue);
    }

    public final boolean isMINORPSDEDSIDNull() {
        return this.IsParamNull(TAG_MINORPSDEDSID);
    }

    public final String getMINORPSDEDSID() {
        return this.GetParamStringValue(TAG_MINORPSDEDSID, "");
    }

    public final void setMINORPSDEDSID(String strValue) {
        this.SetParamValue(TAG_MINORPSDEDSID, strValue);
    }

    public final boolean isMINORPSDEDSNAMENull() {
        return this.IsParamNull(TAG_MINORPSDEDSNAME);
    }

    public final String getMINORPSDEDSNAME() {
        return this.GetParamStringValue(TAG_MINORPSDEDSNAME, "");
    }

    public final void setMINORPSDEDSNAME(String strValue) {
        this.SetParamValue(TAG_MINORPSDEDSNAME, strValue);
    }

    public final boolean isSERVICECODENAMENull() {
        return this.IsParamNull(TAG_SERVICECODENAME);
    }

    public final String getSERVICECODENAME() {
        return this.GetParamStringValue(TAG_SERVICECODENAME, "");
    }

    public final void setSERVICECODENAME(String strValue) {
        this.SetParamValue(TAG_SERVICECODENAME, strValue);
    }

    public final boolean isMINORSERVICECODENAMENull() {
        return this.IsParamNull(TAG_MINORSERVICECODENAME);
    }

    public final String getMINORSERVICECODENAME() {
        return this.GetParamStringValue(TAG_MINORSERVICECODENAME, "");
    }

    public final void setMINORSERVICECODENAME(String strValue) {
        this.SetParamValue(TAG_MINORSERVICECODENAME, strValue);
    }

    public final boolean isDERTAGNull() {
        return this.IsParamNull(TAG_DERTAG);
    }

    public final String getDERTAG() {
        return this.GetParamStringValue(TAG_DERTAG, "");
    }

    public final void setDERTAG(String strValue) {
        this.SetParamValue(TAG_DERTAG, strValue);
    }

    public final boolean isDERTAG2Null() {
        return this.IsParamNull(TAG_DERTAG2);
    }

    public final String getDERTAG2() {
        return this.GetParamStringValue(TAG_DERTAG2, "");
    }

    public final void setDERTAG2(String strValue) {
        this.SetParamValue(TAG_DERTAG2, strValue);
    }

    public final boolean isUPDATEPHYSICALDEFIELDNull() {
        return this.IsParamNull(TAG_UPDATEPHYSICALDEFIELD);
    }

    public final boolean getUPDATEPHYSICALDEFIELD() {
        return this.GetParamIntValue(TAG_UPDATEPHYSICALDEFIELD, 0) == 1;
    }

    public final void setUPDATEPHYSICALDEFIELD(boolean bValue) {
        this.SetParamValue(TAG_UPDATEPHYSICALDEFIELD, bValue ? 1 : 0);
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

    public final boolean isPSDEFGROUPIDNull() {
        return this.IsParamNull(TAG_PSDEFGROUPID);
    }

    public final String getPSDEFGROUPID() {
        return this.GetParamStringValue(TAG_PSDEFGROUPID, "");
    }

    public final void setPSDEFGROUPID(String strValue) {
        this.SetParamValue(TAG_PSDEFGROUPID, strValue);
    }

    public final boolean isPSDEFGROUPNAMENull() {
        return this.IsParamNull(TAG_PSDEFGROUPNAME);
    }

    public final String getPSDEFGROUPNAME() {
        return this.GetParamStringValue(TAG_PSDEFGROUPNAME, "");
    }

    public final void setPSDEFGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFGROUPNAME, strValue);
    }
}

