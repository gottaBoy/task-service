/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDESADetail
extends BaseDataEntity {
    public static final String DETAILTYPE_DEACTION = "DEACTION";
    public static final String DETAILTYPE_DEDATAQUERY = "DEDATAQUERY";
    public static final String DETAILTYPE_DEDATASET = "DEDATASET";
    public static final String DETAILTYPE_SELECT = "SELECT";
    public static final String TAG_PSDESADETAILID = "PSDESADETAILID";
    public static final String TAG_PSDESADETAILNAME = "PSDESADETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDESERVICEAPIID = "PSDESERVICEAPIID";
    public static final String TAG_PSDESERVICEAPINAME = "PSDESERVICEAPINAME";
    public static final String TAG_DETAILTYPE = "DETAILTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";
    public static final String TAG_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String TAG_PSDEDQID = "PSDEDQID";
    public static final String TAG_PSDEDQNAME = "PSDEDQNAME";
    public static final String TAG_PSDEDSID = "PSDEDSID";
    public static final String TAG_PSDEDSNAME = "PSDEDSNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_REQUESTMETHOD = "REQUESTMETHOD";
    public static final String TAG_UNIQUETAG = "UNIQUETAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_METHODTAG = "METHODTAG";
    public static final String TAG_REQUESTPARAMTYPE = "REQUESTPARAMTYPE";
    public static final String TAG_REQUESTFIELD = "REQUESTFIELD";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_RETVALTYPE = "RETVALTYPE";
    public static final String TAG_DETAILPARAM2 = "DETAILPARAM2";
    public static final String TAG_DETAILPARAM = "DETAILPARAM";
    public static final String TAG_CODENAME2 = "CODENAME2";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_TEMPMODE = "TEMPMODE";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String TAG_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String TAG_PSDESARSID = "PSDESARSID";
    public static final String TAG_PSDESARSNAME = "PSDESARSNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PARENTKEYMODE = "PARENTKEYMODE";
    public static final String TAG_INPSDESERVICEAPINAME = "INPSDESERVICEAPINAME";
    public static final String TAG_OUTPSDESERVICEAPIID = "OUTPSDESERVICEAPIID";
    public static final String TAG_OUTPSDESERVICEAPINAME = "OUTPSDESERVICEAPINAME";
    public static final String TAG_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String TAG_INPSDESERVICEAPIID = "INPSDESERVICEAPIID";
    public static final String TAG_NOSERVICECODENAME = "NOSERVICECODENAME";
    public static final String TAG_NEEDRESOURCEKEY = "NEEDRESOURCEKEY";
    public static final String TAG_SERVICEURL = "SERVICEURL";

    public final boolean isPSDESADETAILIDNull() {
        return this.IsParamNull(TAG_PSDESADETAILID);
    }

    public final String getPSDESADETAILID() {
        return this.GetParamStringValue(TAG_PSDESADETAILID, "");
    }

    public final void setPSDESADETAILID(String strValue) {
        this.SetParamValue(TAG_PSDESADETAILID, strValue);
    }

    public final boolean isPSDESADETAILNAMENull() {
        return this.IsParamNull(TAG_PSDESADETAILNAME);
    }

    public final String getPSDESADETAILNAME() {
        return this.GetParamStringValue(TAG_PSDESADETAILNAME, "");
    }

    public final void setPSDESADETAILNAME(String strValue) {
        this.SetParamValue(TAG_PSDESADETAILNAME, strValue);
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

    public final boolean isPSDESERVICEAPIIDNull() {
        return this.IsParamNull(TAG_PSDESERVICEAPIID);
    }

    public final String getPSDESERVICEAPIID() {
        return this.GetParamStringValue(TAG_PSDESERVICEAPIID, "");
    }

    public final void setPSDESERVICEAPIID(String strValue) {
        this.SetParamValue(TAG_PSDESERVICEAPIID, strValue);
    }

    public final boolean isPSDESERVICEAPINAMENull() {
        return this.IsParamNull(TAG_PSDESERVICEAPINAME);
    }

    public final String getPSDESERVICEAPINAME() {
        return this.GetParamStringValue(TAG_PSDESERVICEAPINAME, "");
    }

    public final void setPSDESERVICEAPINAME(String strValue) {
        this.SetParamValue(TAG_PSDESERVICEAPINAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
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

    public final boolean isMETHODTAGNull() {
        return this.IsParamNull(TAG_METHODTAG);
    }

    public final String getMETHODTAG() {
        return this.GetParamStringValue(TAG_METHODTAG, "");
    }

    public final void setMETHODTAG(String strValue) {
        this.SetParamValue(TAG_METHODTAG, strValue);
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

    public final boolean isREQUESTFIELDNull() {
        return this.IsParamNull(TAG_REQUESTFIELD);
    }

    public final String getREQUESTFIELD() {
        return this.GetParamStringValue(TAG_REQUESTFIELD, "");
    }

    public final void setREQUESTFIELD(String strValue) {
        this.SetParamValue(TAG_REQUESTFIELD, strValue);
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

    public final boolean isRETVALTYPENull() {
        return this.IsParamNull(TAG_RETVALTYPE);
    }

    public final String getRETVALTYPE() {
        return this.GetParamStringValue(TAG_RETVALTYPE, "");
    }

    public final void setRETVALTYPE(String strValue) {
        this.SetParamValue(TAG_RETVALTYPE, strValue);
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

    public final boolean isDETAILPARAMNull() {
        return this.IsParamNull(TAG_DETAILPARAM);
    }

    public final String getDETAILPARAM() {
        return this.GetParamStringValue(TAG_DETAILPARAM, "");
    }

    public final void setDETAILPARAM(String strValue) {
        this.SetParamValue(TAG_DETAILPARAM, strValue);
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

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
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

    public final boolean isTEMPMODENull() {
        return this.IsParamNull(TAG_TEMPMODE);
    }

    public final int getTEMPMODE() {
        return this.GetParamIntValue(TAG_TEMPMODE, 0);
    }

    public final void setTEMPMODE(int nValue) {
        this.SetParamValue(TAG_TEMPMODE, nValue);
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

    public final boolean isPSDESARSIDNull() {
        return this.IsParamNull(TAG_PSDESARSID);
    }

    public final String getPSDESARSID() {
        return this.GetParamStringValue(TAG_PSDESARSID, "");
    }

    public final void setPSDESARSID(String strValue) {
        this.SetParamValue(TAG_PSDESARSID, strValue);
    }

    public final boolean isPSDESARSNAMENull() {
        return this.IsParamNull(TAG_PSDESARSNAME);
    }

    public final String getPSDESARSNAME() {
        return this.GetParamStringValue(TAG_PSDESARSNAME, "");
    }

    public final void setPSDESARSNAME(String strValue) {
        this.SetParamValue(TAG_PSDESARSNAME, strValue);
    }

    public final boolean isPARENTKEYMODENull() {
        return this.IsParamNull(TAG_PARENTKEYMODE);
    }

    public final String getPARENTKEYMODE() {
        return this.GetParamStringValue(TAG_PARENTKEYMODE, "");
    }

    public final void setPARENTKEYMODE(String strValue) {
        this.SetParamValue(TAG_PARENTKEYMODE, strValue);
    }

    public final boolean isINPSDESERVICEAPIIDNull() {
        return this.IsParamNull(TAG_INPSDESERVICEAPIID);
    }

    public final String getINPSDESERVICEAPIID() {
        return this.GetParamStringValue(TAG_INPSDESERVICEAPIID, "");
    }

    public final void setINPSDESERVICEAPIID(String strValue) {
        this.SetParamValue(TAG_INPSDESERVICEAPIID, strValue);
    }

    public final boolean isINPSDESERVICEAPINAMENull() {
        return this.IsParamNull(TAG_INPSDESERVICEAPINAME);
    }

    public final String getINPSDESERVICEAPINAME() {
        return this.GetParamStringValue(TAG_INPSDESERVICEAPINAME, "");
    }

    public final void setINPSDESERVICEAPINAME(String strValue) {
        this.SetParamValue(TAG_INPSDESERVICEAPINAME, strValue);
    }

    public final boolean isOUTPSDESERVICEAPIIDNull() {
        return this.IsParamNull(TAG_OUTPSDESERVICEAPIID);
    }

    public final String getOUTPSDESERVICEAPIID() {
        return this.GetParamStringValue(TAG_OUTPSDESERVICEAPIID, "");
    }

    public final void setOUTPSDESERVICEAPIID(String strValue) {
        this.SetParamValue(TAG_OUTPSDESERVICEAPIID, strValue);
    }

    public final boolean isOUTPSDESERVICEAPINAMENull() {
        return this.IsParamNull(TAG_OUTPSDESERVICEAPINAME);
    }

    public final String getOUTPSDESERVICEAPINAME() {
        return this.GetParamStringValue(TAG_OUTPSDESERVICEAPINAME, "");
    }

    public final void setOUTPSDESERVICEAPINAME(String strValue) {
        this.SetParamValue(TAG_OUTPSDESERVICEAPINAME, strValue);
    }

    public final boolean isPSSYSSERVICEAPIIDNull() {
        return this.IsParamNull(TAG_PSSYSSERVICEAPIID);
    }

    public final String getPSSYSSERVICEAPIID() {
        return this.GetParamStringValue(TAG_PSSYSSERVICEAPIID, "");
    }

    public final void setPSSYSSERVICEAPIID(String strValue) {
        this.SetParamValue(TAG_PSSYSSERVICEAPIID, strValue);
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

    public final boolean isNEEDRESOURCEKEYNull() {
        return this.IsParamNull(TAG_NEEDRESOURCEKEY);
    }

    public final boolean getNEEDRESOURCEKEY() {
        return this.GetParamIntValue(TAG_NEEDRESOURCEKEY, 0) == 1;
    }

    public final void setNEEDRESOURCEKEY(boolean bValue) {
        this.SetParamValue(TAG_NEEDRESOURCEKEY, bValue ? 1 : 0);
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
}

