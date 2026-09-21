/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

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

    public final boolean isPSDERIDNull() {
        return this.isParamNull(TAG_PSDERID);
    }

    public final String getPSDERID() {
        return this.getParamStringValue(TAG_PSDERID, "");
    }

    public final void setPSDERID(String strValue) {
        this.setParamValue(TAG_PSDERID, strValue);
    }

    public final boolean isPSDERNAMENull() {
        return this.isParamNull(TAG_PSDERNAME);
    }

    public final String getPSDERNAME() {
        return this.getParamStringValue(TAG_PSDERNAME, "");
    }

    public final void setPSDERNAME(String strValue) {
        this.setParamValue(TAG_PSDERNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isDERTYPENull() {
        return this.isParamNull(TAG_DERTYPE);
    }

    public final String getDERTYPE() {
        return this.getParamStringValue(TAG_DERTYPE, "");
    }

    public final void setDERTYPE(String strValue) {
        this.setParamValue(TAG_DERTYPE, strValue);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isMAJORPSDEIDNull() {
        return this.isParamNull(TAG_MAJORPSDEID);
    }

    public final String getMAJORPSDEID() {
        return this.getParamStringValue(TAG_MAJORPSDEID, "");
    }

    public final void setMAJORPSDEID(String strValue) {
        this.setParamValue(TAG_MAJORPSDEID, strValue);
    }

    public final boolean isMAJORPSDENAMENull() {
        return this.isParamNull(TAG_MAJORPSDENAME);
    }

    public final String getMAJORPSDENAME() {
        return this.getParamStringValue(TAG_MAJORPSDENAME, "");
    }

    public final void setMAJORPSDENAME(String strValue) {
        this.setParamValue(TAG_MAJORPSDENAME, strValue);
    }

    public final boolean isMINORPSDEIDNull() {
        return this.isParamNull(TAG_MINORPSDEID);
    }

    public final String getMINORPSDEID() {
        return this.getParamStringValue(TAG_MINORPSDEID, "");
    }

    public final void setMINORPSDEID(String strValue) {
        this.setParamValue(TAG_MINORPSDEID, strValue);
    }

    public final boolean isMINORPSDENAMENull() {
        return this.isParamNull(TAG_MINORPSDENAME);
    }

    public final String getMINORPSDENAME() {
        return this.getParamStringValue(TAG_MINORPSDENAME, "");
    }

    public final void setMINORPSDENAME(String strValue) {
        this.setParamValue(TAG_MINORPSDENAME, strValue);
    }

    public final boolean isDERFIELDNAMENull() {
        return this.isParamNull(TAG_DERFIELDNAME);
    }

    public final String getDERFIELDNAME() {
        return this.getParamStringValue(TAG_DERFIELDNAME, "");
    }

    public final void setDERFIELDNAME(String strValue) {
        this.setParamValue(TAG_DERFIELDNAME, strValue);
    }

    public final boolean isDERFIELDLNAMENull() {
        return this.isParamNull(TAG_DERFIELDLNAME);
    }

    public final String getDERFIELDLNAME() {
        return this.getParamStringValue(TAG_DERFIELDLNAME, "");
    }

    public final void setDERFIELDLNAME(String strValue) {
        this.setParamValue(TAG_DERFIELDLNAME, strValue);
    }

    public final boolean isREMOVEACTIONTYPENull() {
        return this.isParamNull(TAG_REMOVEACTIONTYPE);
    }

    public final int getREMOVEACTIONTYPE() {
        return this.getParamIntValue(TAG_REMOVEACTIONTYPE, 0);
    }

    public final void setREMOVEACTIONTYPE(int nValue) {
        this.setParamValue(TAG_REMOVEACTIONTYPE, nValue);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.isParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.getParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.isParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.getParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.setParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isREMOVEORDERNull() {
        return this.isParamNull(TAG_REMOVEORDER);
    }

    public final int getREMOVEORDER() {
        return this.getParamIntValue(TAG_REMOVEORDER, 0);
    }

    public final void setREMOVEORDER(int nValue) {
        this.setParamValue(TAG_REMOVEORDER, nValue);
    }

    public final boolean isPSDEDATASETIDNull() {
        return this.isParamNull(TAG_PSDEDATASETID);
    }

    public final String getPSDEDATASETID() {
        return this.getParamStringValue(TAG_PSDEDATASETID, "");
    }

    public final void setPSDEDATASETID(String strValue) {
        this.setParamValue(TAG_PSDEDATASETID, strValue);
    }

    public final boolean isPSDEDATASETNAMENull() {
        return this.isParamNull(TAG_PSDEDATASETNAME);
    }

    public final String getPSDEDATASETNAME() {
        return this.getParamStringValue(TAG_PSDEDATASETNAME, "");
    }

    public final void setPSDEDATASETNAME(String strValue) {
        this.setParamValue(TAG_PSDEDATASETNAME, strValue);
    }

    public final boolean isMASTERRSNull() {
        return this.isParamNull(TAG_MASTERRS);
    }

    public final int getMASTERRS() {
        return this.getParamIntValue(TAG_MASTERRS, 0);
    }

    public final void setMASTERRS(boolean bValue) {
        this.setParamValue(TAG_MASTERRS, bValue ? 1 : 0);
    }

    public final boolean isPSDEACMODEIDNull() {
        return this.isParamNull(TAG_PSDEACMODEID);
    }

    public final String getPSDEACMODEID() {
        return this.getParamStringValue(TAG_PSDEACMODEID, "");
    }

    public final void setPSDEACMODEID(String strValue) {
        this.setParamValue(TAG_PSDEACMODEID, strValue);
    }

    public final boolean isPSDEACMODENAMENull() {
        return this.isParamNull(TAG_PSDEACMODENAME);
    }

    public final String getPSDEACMODENAME() {
        return this.getParamStringValue(TAG_PSDEACMODENAME, "");
    }

    public final void setPSDEACMODENAME(String strValue) {
        this.setParamValue(TAG_PSDEACMODENAME, strValue);
    }

    public final boolean isSDPSDEVIEWIDNull() {
        return this.isParamNull(TAG_SDPSDEVIEWID);
    }

    public final String getSDPSDEVIEWID() {
        return this.getParamStringValue(TAG_SDPSDEVIEWID, "");
    }

    public final void setSDPSDEVIEWID(String strValue) {
        this.setParamValue(TAG_SDPSDEVIEWID, strValue);
    }

    public final boolean isSDPSDEVIEWNAMENull() {
        return this.isParamNull(TAG_SDPSDEVIEWNAME);
    }

    public final String getSDPSDEVIEWNAME() {
        return this.getParamStringValue(TAG_SDPSDEVIEWNAME, "");
    }

    public final void setSDPSDEVIEWNAME(String strValue) {
        this.setParamValue(TAG_SDPSDEVIEWNAME, strValue);
    }

    public final boolean isMDPSDEVIEWIDNull() {
        return this.isParamNull(TAG_MDPSDEVIEWID);
    }

    public final String getMDPSDEVIEWID() {
        return this.getParamStringValue(TAG_MDPSDEVIEWID, "");
    }

    public final void setMDPSDEVIEWID(String strValue) {
        this.setParamValue(TAG_MDPSDEVIEWID, strValue);
    }

    public final boolean isMDPSDEVIEWNAMENull() {
        return this.isParamNull(TAG_MDPSDEVIEWNAME);
    }

    public final String getMDPSDEVIEWNAME() {
        return this.getParamStringValue(TAG_MDPSDEVIEWNAME, "");
    }

    public final void setMDPSDEVIEWNAME(String strValue) {
        this.setParamValue(TAG_MDPSDEVIEWNAME, strValue);
    }

    public final boolean isRSPSDEVIEWIDNull() {
        return this.isParamNull(TAG_RSPSDEVIEWID);
    }

    public final String getRSPSDEVIEWID() {
        return this.getParamStringValue(TAG_RSPSDEVIEWID, "");
    }

    public final void setRSPSDEVIEWID(String strValue) {
        this.setParamValue(TAG_RSPSDEVIEWID, strValue);
    }

    public final boolean isRSPSDEVIEWNAMENull() {
        return this.isParamNull(TAG_RSPSDEVIEWNAME);
    }

    public final String getRSPSDEVIEWNAME() {
        return this.getParamStringValue(TAG_RSPSDEVIEWNAME, "");
    }

    public final void setRSPSDEVIEWNAME(String strValue) {
        this.setParamValue(TAG_RSPSDEVIEWNAME, strValue);
    }

    public final boolean isLOGICNAMENull() {
        return this.isParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.getParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.setParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isENABLECLONENull() {
        return this.isParamNull(TAG_ENABLECLONE);
    }

    public final boolean getENABLECLONE() {
        return this.getParamIntValue(TAG_ENABLECLONE, 0) == 1;
    }

    public final void setENABLECLONE(boolean bValue) {
        this.setParamValue(TAG_ENABLECLONE, bValue ? 1 : 0);
    }

    public final boolean isENAEXTRANGENull() {
        return this.isParamNull(TAG_ENAEXTRANGE);
    }

    public final boolean getENAEXTRANGE() {
        return this.getParamIntValue(TAG_ENAEXTRANGE, 0) == 1;
    }

    public final void setENAEXTRANGE(boolean bValue) {
        this.setParamValue(TAG_ENAEXTRANGE, bValue ? 1 : 0);
    }

    public final boolean isEXTMAJORPSDEFIDNull() {
        return this.isParamNull(TAG_EXTMAJORPSDEFID);
    }

    public final String getEXTMAJORPSDEFID() {
        return this.getParamStringValue(TAG_EXTMAJORPSDEFID, "");
    }

    public final void setEXTMAJORPSDEFID(String strValue) {
        this.setParamValue(TAG_EXTMAJORPSDEFID, strValue);
    }

    public final boolean isEXTMAJORPSDEFNAMENull() {
        return this.isParamNull(TAG_EXTMAJORPSDEFNAME);
    }

    public final String getEXTMAJORPSDEFNAME() {
        return this.getParamStringValue(TAG_EXTMAJORPSDEFNAME, "");
    }

    public final void setEXTMAJORPSDEFNAME(String strValue) {
        this.setParamValue(TAG_EXTMAJORPSDEFNAME, strValue);
    }

    public final boolean isEXTMINORPSDEFIDNull() {
        return this.isParamNull(TAG_EXTMINORPSDEFID);
    }

    public final String getEXTMINORPSDEFID() {
        return this.getParamStringValue(TAG_EXTMINORPSDEFID, "");
    }

    public final void setEXTMINORPSDEFID(String strValue) {
        this.setParamValue(TAG_EXTMINORPSDEFID, strValue);
    }

    public final boolean isEXTMINORPSDEFNAMENull() {
        return this.isParamNull(TAG_EXTMINORPSDEFNAME);
    }

    public final String getEXTMINORPSDEFNAME() {
        return this.getParamStringValue(TAG_EXTMINORPSDEFNAME, "");
    }

    public final void setEXTMINORPSDEFNAME(String strValue) {
        this.setParamValue(TAG_EXTMINORPSDEFNAME, strValue);
    }

    public final boolean isINDEXVALUENull() {
        return this.isParamNull(TAG_INDEXVALUE);
    }

    public final String getINDEXVALUE() {
        return this.getParamStringValue(TAG_INDEXVALUE, "");
    }

    public final void setINDEXVALUE(String strValue) {
        this.setParamValue(TAG_INDEXVALUE, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.isParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.getParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.setParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isFOREIGNKEYNull() {
        return this.isParamNull(TAG_FOREIGNKEY);
    }

    public final boolean getFOREIGNKEY() {
        return this.getParamIntValue(TAG_FOREIGNKEY, 0) == 1;
    }

    public final void setFOREIGNKEY(boolean bValue) {
        this.setParamValue(TAG_FOREIGNKEY, bValue ? 1 : 0);
    }

    public final boolean isCLONEORDERVALUENull() {
        return this.isParamNull(TAG_CLONEORDERVALUE);
    }

    public final int getCLONEORDERVALUE() {
        return this.getParamIntValue(TAG_CLONEORDERVALUE, 0);
    }

    public final void setCLONEORDERVALUE(int nValue) {
        this.setParamValue(TAG_CLONEORDERVALUE, nValue);
    }

    public final boolean isTEMPORDERVALUENull() {
        return this.isParamNull(TAG_TEMPORDERVALUE);
    }

    public final int getTEMPORDERVALUE() {
        return this.getParamIntValue(TAG_TEMPORDERVALUE, 0);
    }

    public final void setTEMPORDERVALUE(int nValue) {
        this.setParamValue(TAG_TEMPORDERVALUE, nValue);
    }

    public final boolean isCLONERSFIELDSNull() {
        return this.isParamNull(TAG_CLONERSFIELDS);
    }

    public final String getCLONERSFIELDS() {
        return this.getParamStringValue(TAG_CLONERSFIELDS, "");
    }

    public final void setCLONERSFIELDS(String strValue) {
        this.setParamValue(TAG_CLONERSFIELDS, strValue);
    }

    public final void setMASTERRS(int nValue) {
        this.setParamValue(TAG_MASTERRS, nValue);
    }

    public final boolean isMINORCODENAMENull() {
        return this.isParamNull(TAG_MINORCODENAME);
    }

    public final String getMINORCODENAME() {
        return this.getParamStringValue(TAG_MINORCODENAME, "");
    }

    public final void setMINORCODENAME(String strValue) {
        this.setParamValue(TAG_MINORCODENAME, strValue);
    }

    public final boolean isENAPDEREQNull() {
        return this.isParamNull(TAG_ENAPDEREQ);
    }

    public final boolean getENAPDEREQ() {
        return this.getParamIntValue(TAG_ENAPDEREQ, 0) == 1;
    }

    public final void setENAPDEREQ(boolean bValue) {
        this.setParamValue(TAG_ENAPDEREQ, bValue ? 1 : 0);
    }

    public final boolean isMAJORPSDERIDNull() {
        return this.isParamNull(TAG_MAJORPSDERID);
    }

    public final String getMAJORPSDERID() {
        return this.getParamStringValue(TAG_MAJORPSDERID, "");
    }

    public final void setMAJORPSDERID(String strValue) {
        this.setParamValue(TAG_MAJORPSDERID, strValue);
    }

    public final boolean isMAJORPSDERNAMENull() {
        return this.isParamNull(TAG_MAJORPSDERNAME);
    }

    public final String getMAJORPSDERNAME() {
        return this.getParamStringValue(TAG_MAJORPSDERNAME, "");
    }

    public final void setMAJORPSDERNAME(String strValue) {
        this.setParamValue(TAG_MAJORPSDERNAME, strValue);
    }

    public final boolean isMINORPSDERIDNull() {
        return this.isParamNull(TAG_MINORPSDERID);
    }

    public final String getMINORPSDERID() {
        return this.getParamStringValue(TAG_MINORPSDERID, "");
    }

    public final void setMINORPSDERID(String strValue) {
        this.setParamValue(TAG_MINORPSDERID, strValue);
    }

    public final boolean isMINORPSDERNAMENull() {
        return this.isParamNull(TAG_MINORPSDERNAME);
    }

    public final String getMINORPSDERNAME() {
        return this.getParamStringValue(TAG_MINORPSDERNAME, "");
    }

    public final void setMINORPSDERNAME(String strValue) {
        this.setParamValue(TAG_MINORPSDERNAME, strValue);
    }

    public final boolean isEXPORTMODELNull() {
        return this.isParamNull(TAG_EXPORTMODEL);
    }

    public final int getEXPORTMODEL() {
        return this.getParamIntValue(TAG_EXPORTMODEL, 0);
    }

    public final void setEXPORTMODEL(int nValue) {
        this.setParamValue(TAG_EXPORTMODEL, nValue);
    }

    public final boolean isSYNCEXPORTMODELNull() {
        return this.isParamNull(TAG_SYNCEXPORTMODEL);
    }

    public final int getSYNCEXPORTMODEL() {
        return this.getParamIntValue(TAG_SYNCEXPORTMODEL, 0);
    }

    public final void setSYNCEXPORTMODEL(int nValue) {
        this.setParamValue(TAG_SYNCEXPORTMODEL, nValue);
    }

    public final boolean isFKEYNAMENull() {
        return this.isParamNull(TAG_FKEYNAME);
    }

    public final String getFKEYNAME() {
        return this.getParamStringValue(TAG_FKEYNAME, "");
    }

    public final void setFKEYNAME(String strValue) {
        this.setParamValue(TAG_FKEYNAME, strValue);
    }

    public final boolean isPROPERTYMAPNull() {
        return this.isParamNull(TAG_PROPERTYMAP);
    }

    public final String getPROPERTYMAP() {
        return this.getParamStringValue(TAG_PROPERTYMAP, "");
    }

    public final void setPROPERTYMAP(String strValue) {
        this.setParamValue(TAG_PROPERTYMAP, strValue);
    }

    public final boolean isIGNOREDEFIELDSNull() {
        return this.isParamNull(TAG_IGNOREDEFIELDS);
    }

    public final String getIGNOREDEFIELDS() {
        return this.getParamStringValue(TAG_IGNOREDEFIELDS, "");
    }

    public final void setIGNOREDEFIELDS(String strValue) {
        this.setParamValue(TAG_IGNOREDEFIELDS, strValue);
    }

    public final boolean isLINKPSDEVIEWIDNull() {
        return this.isParamNull(TAG_LINKPSDEVIEWID);
    }

    public final String getLINKPSDEVIEWID() {
        return this.getParamStringValue(TAG_LINKPSDEVIEWID, "");
    }

    public final void setLINKPSDEVIEWID(String strValue) {
        this.setParamValue(TAG_LINKPSDEVIEWID, strValue);
    }

    public final boolean isLINKPSDEVIEWNAMENull() {
        return this.isParamNull(TAG_LINKPSDEVIEWNAME);
    }

    public final String getLINKPSDEVIEWNAME() {
        return this.getParamStringValue(TAG_LINKPSDEVIEWNAME, "");
    }

    public final void setLINKPSDEVIEWNAME(String strValue) {
        this.setParamValue(TAG_LINKPSDEVIEWNAME, strValue);
    }

    public final boolean isUSERPARAMSNull() {
        return this.isParamNull(TAG_USERPARAMS);
    }

    public final String getUSERPARAMS() {
        return this.getParamStringValue(TAG_USERPARAMS, "");
    }

    public final void setUSERPARAMS(String strValue) {
        this.setParamValue(TAG_USERPARAMS, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.isParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.getParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.setParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isCNTPSDEFIDNull() {
        return this.isParamNull(TAG_CNTPSDEFID);
    }

    public final String getCNTPSDEFID() {
        return this.getParamStringValue(TAG_CNTPSDEFID, "");
    }

    public final void setCNTPSDEFID(String strValue) {
        this.setParamValue(TAG_CNTPSDEFID, strValue);
    }

    public final boolean isCNTPSDEFNAMENull() {
        return this.isParamNull(TAG_CNTPSDEFNAME);
    }

    public final String getCNTPSDEFNAME() {
        return this.getParamStringValue(TAG_CNTPSDEFNAME, "");
    }

    public final void setCNTPSDEFNAME(String strValue) {
        this.setParamValue(TAG_CNTPSDEFNAME, strValue);
    }

    public final boolean isEXPORTMAJORMODELNull() {
        return this.isParamNull(TAG_EXPORTMAJORMODEL);
    }

    public final int getEXPORTMAJORMODEL() {
        return this.getParamIntValue(TAG_EXPORTMAJORMODEL, 0);
    }

    public final void setEXPORTMAJORMODEL(int nValue) {
        this.setParamValue(TAG_EXPORTMAJORMODEL, nValue);
    }
}

