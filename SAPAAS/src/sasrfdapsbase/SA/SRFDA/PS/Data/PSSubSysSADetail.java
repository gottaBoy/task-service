/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSubSysSADetail
extends BaseDataEntity {
    public static final String DETAILTYPE_DEACTION = "DEACTION";
    public static final String DETAILTYPE_DEDATAQUERY = "DEDATAQUERY";
    public static final String DETAILTYPE_DEDATASET = "DEDATASET";
    public static final String DETAILTYPE_SELECT = "SELECT";
    public static final String REQUESTMETHOD_GET = "GET";
    public static final String REQUESTMETHOD_HEAD = "HEAD";
    public static final String REQUESTMETHOD_POST = "POST";
    public static final String REQUESTMETHOD_PUT = "PUT";
    public static final String REQUESTMETHOD_PATCH = "PATCH";
    public static final String REQUESTMETHOD_DELETE = "DELETE";
    public static final String REQUESTMETHOD_OPTIONS = "OPTIONS";
    public static final String REQUESTMETHOD_TRACE = "TRACE";
    public static final String TAG_PSSUBSYSSADETAILID = "PSSUBSYSSADETAILID";
    public static final String TAG_PSSUBSYSSADETAILNAME = "PSSUBSYSSADETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String TAG_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String TAG_DETAILTYPE = "DETAILTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_DETAILID = "DETAILID";
    public static final String TAG_SERVICEURL = "SERVICEURL";
    public static final String TAG_REQUESTMETHOD = "REQUESTMETHOD";
    public static final String TAG_UNIQUETAG = "UNIQUETAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_KEYFIELDNAME = "KEYFIELDNAME";
    public static final String TAG_REQUESTPARAMTYPE = "REQUESTPARAMTYPE";
    public static final String TAG_CODENAME2 = "CODENAME2";
    public static final String TAG_DETAILPARAM = "DETAILPARAM";
    public static final String TAG_DETAILPARAM2 = "DETAILPARAM2";
    public static final String TAG_PSSUBSYSSADEID = "PSSUBSYSSADEID";
    public static final String TAG_PSSUBSYSSADENAME = "PSSUBSYSSADENAME";
    public static final String TAG_DETAILTAG = "DETAILTAG";
    public static final String TAG_DETAILTAG2 = "DETAILTAG2";
    public static final String TAG_RETVALTYPE = "RETVALTYPE";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_INPSSUBSYSSADEID = "INPSSUBSYSSADEID";
    public static final String TAG_INPSSUBSYSSADENAME = "INPSSUBSYSSADENAME";
    public static final String TAG_OUTPSSUBSYSSADEID = "OUTPSSUBSYSSADEID";
    public static final String TAG_OUTPSSUBSYSSADENAME = "OUTPSSUBSYSSADENAME";
    public static final String TAG_RETSTDDATATYPE = "RETSTDDATATYPE";
    public static final String TAG_INPSSYSDYNAMODELID = "INPSSYSDYNAMODELID";
    public static final String TAG_INPSSYSDYNAMODELNAME = "INPSSYSDYNAMODELNAME";
    public static final String TAG_OUTPSSYSDYNAMODELID = "OUTPSSYSDYNAMODELID";
    public static final String TAG_OUTPSSYSDYNAMODELNAME = "OUTPSSYSDYNAMODELNAME";
    public static final String TAG_NOSERVICECODENAME = "NOSERVICECODENAME";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";
    public static final String TAG_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String TAG_PSDEDQID = "PSDEDQID";
    public static final String TAG_PSDEDQNAME = "PSDEDQNAME";
    public static final String TAG_PSDEDSID = "PSDEDSID";
    public static final String TAG_PSDEDSNAME = "PSDEDSNAME";
    public static final String TAG_NEEDRESOURCEKEY = "NEEDRESOURCEKEY";
    public static final String TAG_RETPSSUBSYSSADEID = "RETPSSUBSYSSADEID";
    public static final String TAG_RETPSSUBSYSSADENAME = "RETPSSUBSYSSADENAME";
    public static final String TAG_DETAILPARAMS = "DETAILPARAMS";
    public static final String TAG_AFTERCODE = "AFTERCODE";
    public static final String TAG_BEFORECODE = "BEFORECODE";
    public static final String TAG_METHODCODE = "METHODCODE";
    public static final String TAG_REQUESTCONTENTTYPE = "REQUESTCONTENTTYPE";

    public final boolean isPSSUBSYSSADETAILIDNull() {
        return this.IsParamNull(TAG_PSSUBSYSSADETAILID);
    }

    public final String getPSSUBSYSSADETAILID() {
        return this.GetParamStringValue(TAG_PSSUBSYSSADETAILID, "");
    }

    public final void setPSSUBSYSSADETAILID(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSADETAILID, strValue);
    }

    public final boolean isPSSUBSYSSADETAILNAMENull() {
        return this.IsParamNull(TAG_PSSUBSYSSADETAILNAME);
    }

    public final String getPSSUBSYSSADETAILNAME() {
        return this.GetParamStringValue(TAG_PSSUBSYSSADETAILNAME, "");
    }

    public final void setPSSUBSYSSADETAILNAME(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSADETAILNAME, strValue);
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

    public final boolean isPSSUBSYSSERVICEAPIIDNull() {
        return this.IsParamNull(TAG_PSSUBSYSSERVICEAPIID);
    }

    public final String getPSSUBSYSSERVICEAPIID() {
        return this.GetParamStringValue(TAG_PSSUBSYSSERVICEAPIID, "");
    }

    public final void setPSSUBSYSSERVICEAPIID(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSERVICEAPIID, strValue);
    }

    public final boolean isPSSUBSYSSERVICEAPINAMENull() {
        return this.IsParamNull(TAG_PSSUBSYSSERVICEAPINAME);
    }

    public final String getPSSUBSYSSERVICEAPINAME() {
        return this.GetParamStringValue(TAG_PSSUBSYSSERVICEAPINAME, "");
    }

    public final void setPSSUBSYSSERVICEAPINAME(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSERVICEAPINAME, strValue);
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

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isDETAILIDNull() {
        return this.IsParamNull(TAG_DETAILID);
    }

    public final String getDETAILID() {
        return this.GetParamStringValue(TAG_DETAILID, "");
    }

    public final void setDETAILID(String strValue) {
        this.SetParamValue(TAG_DETAILID, strValue);
    }

    public final boolean isSERVICEURLNull() {
        return this.IsParamNull(TAG_SERVICEURL);
    }

    public final String getSERVICEURL() {
        return this.GetParamStringValue(TAG_SERVICEURL, "");
    }

    public final void setSERVICEURL(String strValue) {
        this.SetParamValue(TAG_SERVICEURL, strValue);
    }

    public final boolean isREQUESTMETHODNull() {
        return this.IsParamNull(TAG_REQUESTMETHOD);
    }

    public final String getREQUESTMETHOD() {
        return this.GetParamStringValue(TAG_REQUESTMETHOD, "");
    }

    public final void setREQUESTMETHOD(String strValue) {
        this.SetParamValue(TAG_REQUESTMETHOD, strValue);
    }

    public final boolean isUNIQUETAGNull() {
        return this.IsParamNull(TAG_UNIQUETAG);
    }

    public final String getUNIQUETAG() {
        return this.GetParamStringValue(TAG_UNIQUETAG, "");
    }

    public final void setUNIQUETAG(String strValue) {
        this.SetParamValue(TAG_UNIQUETAG, strValue);
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

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
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

    public final boolean isKEYFIELDNAMENull() {
        return this.IsParamNull(TAG_KEYFIELDNAME);
    }

    public final String getKEYFIELDNAME() {
        return this.GetParamStringValue(TAG_KEYFIELDNAME, "");
    }

    public final void setKEYFIELDNAME(String strValue) {
        this.SetParamValue(TAG_KEYFIELDNAME, strValue);
    }

    public final boolean isREQUESTPARAMTYPENull() {
        return this.IsParamNull(TAG_REQUESTPARAMTYPE);
    }

    public final String getREQUESTPARAMTYPE() {
        return this.GetParamStringValue(TAG_REQUESTPARAMTYPE, "");
    }

    public final void setREQUESTPARAMTYPE(String strValue) {
        this.SetParamValue(TAG_REQUESTPARAMTYPE, strValue);
    }

    public final boolean isCODENAME2Null() {
        return this.IsParamNull(TAG_CODENAME2);
    }

    public final String getCODENAME2() {
        return this.GetParamStringValue(TAG_CODENAME2, "");
    }

    public final void setCODENAME2(String strValue) {
        this.SetParamValue(TAG_CODENAME2, strValue);
    }

    public final boolean isDETAILPARAMNull() {
        return this.IsParamNull(TAG_DETAILPARAM);
    }

    public final String getDETAILPARAM() {
        return this.GetParamStringValue(TAG_DETAILPARAM, "");
    }

    public final void setDETAILPARAM(String strValue) {
        this.SetParamValue(TAG_DETAILPARAM, strValue);
    }

    public final boolean isDETAILPARAM2Null() {
        return this.IsParamNull(TAG_DETAILPARAM2);
    }

    public final String getDETAILPARAM2() {
        return this.GetParamStringValue(TAG_DETAILPARAM2, "");
    }

    public final void setDETAILPARAM2(String strValue) {
        this.SetParamValue(TAG_DETAILPARAM2, strValue);
    }

    public final boolean isPSSUBSYSSADEIDNull() {
        return this.IsParamNull(TAG_PSSUBSYSSADEID);
    }

    public final String getPSSUBSYSSADEID() {
        return this.GetParamStringValue(TAG_PSSUBSYSSADEID, "");
    }

    public final void setPSSUBSYSSADEID(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSADEID, strValue);
    }

    public final boolean isPSSUBSYSSADENAMENull() {
        return this.IsParamNull(TAG_PSSUBSYSSADENAME);
    }

    public final String getPSSUBSYSSADENAME() {
        return this.GetParamStringValue(TAG_PSSUBSYSSADENAME, "");
    }

    public final void setPSSUBSYSSADENAME(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSADENAME, strValue);
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

    public final boolean isRETVALTYPENull() {
        return this.IsParamNull(TAG_RETVALTYPE);
    }

    public final String getRETVALTYPE() {
        return this.GetParamStringValue(TAG_RETVALTYPE, "");
    }

    public final void setRETVALTYPE(String strValue) {
        this.SetParamValue(TAG_RETVALTYPE, strValue);
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

    public final boolean isINPSSUBSYSSADEIDNull() {
        return this.IsParamNull(TAG_INPSSUBSYSSADEID);
    }

    public final String getINPSSUBSYSSADEID() {
        return this.GetParamStringValue(TAG_INPSSUBSYSSADEID, "");
    }

    public final void setINPSSUBSYSSADEID(String strValue) {
        this.SetParamValue(TAG_INPSSUBSYSSADEID, strValue);
    }

    public final boolean isINPSSUBSYSSADENAMENull() {
        return this.IsParamNull(TAG_INPSSUBSYSSADENAME);
    }

    public final String getINPSSUBSYSSADENAME() {
        return this.GetParamStringValue(TAG_INPSSUBSYSSADENAME, "");
    }

    public final void setINPSSUBSYSSADENAME(String strValue) {
        this.SetParamValue(TAG_INPSSUBSYSSADENAME, strValue);
    }

    public final boolean isOUTPSSUBSYSSADEIDNull() {
        return this.IsParamNull(TAG_OUTPSSUBSYSSADEID);
    }

    public final String getOUTPSSUBSYSSADEID() {
        return this.GetParamStringValue(TAG_OUTPSSUBSYSSADEID, "");
    }

    public final void setOUTPSSUBSYSSADEID(String strValue) {
        this.SetParamValue(TAG_OUTPSSUBSYSSADEID, strValue);
    }

    public final boolean isOUTPSSUBSYSSADENAMENull() {
        return this.IsParamNull(TAG_OUTPSSUBSYSSADENAME);
    }

    public final String getOUTPSSUBSYSSADENAME() {
        return this.GetParamStringValue(TAG_OUTPSSUBSYSSADENAME, "");
    }

    public final void setOUTPSSUBSYSSADENAME(String strValue) {
        this.SetParamValue(TAG_OUTPSSUBSYSSADENAME, strValue);
    }

    public final boolean isRETSTDDATATYPENull() {
        return this.IsParamNull(TAG_RETSTDDATATYPE);
    }

    public final int getRETSTDDATATYPE() {
        return this.GetParamIntValue(TAG_RETSTDDATATYPE, 0);
    }

    public final void setRETSTDDATATYPE(int nValue) {
        this.SetParamValue(TAG_RETSTDDATATYPE, nValue);
    }

    public final boolean isINPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_INPSSYSDYNAMODELID);
    }

    public final String getINPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_INPSSYSDYNAMODELID, "");
    }

    public final void setINPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_INPSSYSDYNAMODELID, strValue);
    }

    public final boolean isINPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_INPSSYSDYNAMODELNAME);
    }

    public final String getINPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_INPSSYSDYNAMODELNAME, "");
    }

    public final void setINPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_INPSSYSDYNAMODELNAME, strValue);
    }

    public final boolean isOUTPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_OUTPSSYSDYNAMODELID);
    }

    public final String getOUTPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_OUTPSSYSDYNAMODELID, "");
    }

    public final void setOUTPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_OUTPSSYSDYNAMODELID, strValue);
    }

    public final boolean isOUTPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_OUTPSSYSDYNAMODELNAME);
    }

    public final String getOUTPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_OUTPSSYSDYNAMODELNAME, "");
    }

    public final void setOUTPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_OUTPSSYSDYNAMODELNAME, strValue);
    }

    public final boolean isNOSERVICECODENAMENull() {
        return this.IsParamNull(TAG_NOSERVICECODENAME);
    }

    public final boolean getNOSERVICECODENAME() {
        return this.GetParamIntValue(TAG_NOSERVICECODENAME, 0) == 1;
    }

    public final void setNOSERVICECODENAME(boolean bValue) {
        this.SetParamValue(TAG_NOSERVICECODENAME, bValue ? 1 : 0);
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

    public final boolean isPSDEDQIDNull() {
        return this.IsParamNull(TAG_PSDEDQID);
    }

    public final String getPSDEDQID() {
        return this.GetParamStringValue(TAG_PSDEDQID, "");
    }

    public final void setPSDEDQID(String strValue) {
        this.SetParamValue(TAG_PSDEDQID, strValue);
    }

    public final boolean isPSDEDQNAMENull() {
        return this.IsParamNull(TAG_PSDEDQNAME);
    }

    public final String getPSDEDQNAME() {
        return this.GetParamStringValue(TAG_PSDEDQNAME, "");
    }

    public final void setPSDEDQNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDQNAME, strValue);
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

    public final boolean isNEEDRESOURCEKEYNull() {
        return this.IsParamNull(TAG_NEEDRESOURCEKEY);
    }

    public final boolean getNEEDRESOURCEKEY() {
        return this.GetParamIntValue(TAG_NEEDRESOURCEKEY, 0) == 1;
    }

    public final void setNEEDRESOURCEKEY(boolean bValue) {
        this.SetParamValue(TAG_NEEDRESOURCEKEY, bValue ? 1 : 0);
    }

    public final boolean isAFTERCODENull() {
        return this.IsParamNull(TAG_AFTERCODE);
    }

    public final String getAFTERCODE() {
        return this.GetParamStringValue(TAG_AFTERCODE, "");
    }

    public final void setAFTERCODE(String strValue) {
        this.SetParamValue(TAG_AFTERCODE, strValue);
    }

    public final boolean isBEFORECODENull() {
        return this.IsParamNull(TAG_BEFORECODE);
    }

    public final String getBEFORECODE() {
        return this.GetParamStringValue(TAG_BEFORECODE, "");
    }

    public final void setBEFORECODE(String strValue) {
        this.SetParamValue(TAG_BEFORECODE, strValue);
    }

    public final boolean isMETHODCODENull() {
        return this.IsParamNull(TAG_METHODCODE);
    }

    public final String getMETHODCODE() {
        return this.GetParamStringValue(TAG_METHODCODE, "");
    }

    public final void setMETHODCODE(String strValue) {
        this.SetParamValue(TAG_METHODCODE, strValue);
    }

    public final boolean isREQUESTCONTENTTYPENull() {
        return this.IsParamNull(TAG_REQUESTCONTENTTYPE);
    }

    public final String getREQUESTCONTENTTYPE() {
        return this.GetParamStringValue(TAG_REQUESTCONTENTTYPE, "");
    }

    public final void setREQUESTCONTENTTYPE(String strValue) {
        this.SetParamValue(TAG_REQUESTCONTENTTYPE, strValue);
    }
}

