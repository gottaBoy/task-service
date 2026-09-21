/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDESARS
extends BaseDataEntity {
    public static final String TAG_PSDESARSID = "PSDESARSID";
    public static final String TAG_PSDESARSNAME = "PSDESARSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String TAG_PSSYSSERVICEAPINAME = "PSSYSSERVICEAPINAME";
    public static final String TAG_PPSDESERVICEAPIID = "PPSDESERVICEAPIID";
    public static final String TAG_PPSDESERVICEAPINAME = "PPSDESERVICEAPINAME";
    public static final String TAG_CPSDESERVICEAPIID = "CPSDESERVICEAPIID";
    public static final String TAG_CPSDESERVICEAPINAME = "CPSDESERVICEAPINAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_PSDERID = "PSDERID";
    public static final String TAG_PSDERNAME = "PSDERNAME";
    public static final String TAG_CHILDFILTER = "CHILDFILTER";
    public static final String TAG_CODENAME2 = "CODENAME2";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_ENABLESELECT = "ENABLESELECT";
    public static final String TAG_ENABLEDEACTION = "ENABLEDEACTION";
    public static final String TAG_ENABLEDEDATASET = "ENABLEDEDATASET";
    public static final String TAG_ACTIONRSMODE = "ACTIONRSMODE";
    public static final String TAG_DATARSMODE = "DATARSMODE";
    public static final String TAG_DATAACCMODE = "DATAACCMODE";
    public static final String TAG_TYPEFILTER = "TYPEFILTER";
    public static final String TAG_ARRAYFLAG = "ARRAYFLAG";
    public static final String TAG_ENABLEDATAIMPORT = "ENABLEDATAIMPORT";
    public static final String TAG_ENABLEDATAEXPORT = "ENABLEDATAEXPORT";

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

    public final boolean isPSSYSSERVICEAPIIDNull() {
        return this.IsParamNull(TAG_PSSYSSERVICEAPIID);
    }

    public final String getPSSYSSERVICEAPIID() {
        return this.GetParamStringValue(TAG_PSSYSSERVICEAPIID, "");
    }

    public final void setPSSYSSERVICEAPIID(String strValue) {
        this.SetParamValue(TAG_PSSYSSERVICEAPIID, strValue);
    }

    public final boolean isPSSYSSERVICEAPINAMENull() {
        return this.IsParamNull(TAG_PSSYSSERVICEAPINAME);
    }

    public final String getPSSYSSERVICEAPINAME() {
        return this.GetParamStringValue(TAG_PSSYSSERVICEAPINAME, "");
    }

    public final void setPSSYSSERVICEAPINAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSERVICEAPINAME, strValue);
    }

    public final boolean isPPSDESERVICEAPIIDNull() {
        return this.IsParamNull(TAG_PPSDESERVICEAPIID);
    }

    public final String getPPSDESERVICEAPIID() {
        return this.GetParamStringValue(TAG_PPSDESERVICEAPIID, "");
    }

    public final void setPPSDESERVICEAPIID(String strValue) {
        this.SetParamValue(TAG_PPSDESERVICEAPIID, strValue);
    }

    public final boolean isPPSDESERVICEAPINAMENull() {
        return this.IsParamNull(TAG_PPSDESERVICEAPINAME);
    }

    public final String getPPSDESERVICEAPINAME() {
        return this.GetParamStringValue(TAG_PPSDESERVICEAPINAME, "");
    }

    public final void setPPSDESERVICEAPINAME(String strValue) {
        this.SetParamValue(TAG_PPSDESERVICEAPINAME, strValue);
    }

    public final boolean isCPSDESERVICEAPIIDNull() {
        return this.IsParamNull(TAG_CPSDESERVICEAPIID);
    }

    public final String getCPSDESERVICEAPIID() {
        return this.GetParamStringValue(TAG_CPSDESERVICEAPIID, "");
    }

    public final void setCPSDESERVICEAPIID(String strValue) {
        this.SetParamValue(TAG_CPSDESERVICEAPIID, strValue);
    }

    public final boolean isCPSDESERVICEAPINAMENull() {
        return this.IsParamNull(TAG_CPSDESERVICEAPINAME);
    }

    public final String getCPSDESERVICEAPINAME() {
        return this.GetParamStringValue(TAG_CPSDESERVICEAPINAME, "");
    }

    public final void setCPSDESERVICEAPINAME(String strValue) {
        this.SetParamValue(TAG_CPSDESERVICEAPINAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
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

    public final boolean isCHILDFILTERNull() {
        return this.IsParamNull(TAG_CHILDFILTER);
    }

    public final String getCHILDFILTER() {
        return this.GetParamStringValue(TAG_CHILDFILTER, "");
    }

    public final void setCHILDFILTER(String strValue) {
        this.SetParamValue(TAG_CHILDFILTER, strValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
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

    public final boolean isENABLESELECTNull() {
        return this.IsParamNull(TAG_ENABLESELECT);
    }

    public final boolean getENABLESELECT() {
        return this.GetParamIntValue(TAG_ENABLESELECT, 0) == 1;
    }

    public final void setENABLESELECT(boolean bValue) {
        this.SetParamValue(TAG_ENABLESELECT, bValue ? 1 : 0);
    }

    public final boolean isENABLEDEACTIONNull() {
        return this.IsParamNull(TAG_ENABLEDEACTION);
    }

    public final boolean getENABLEDEACTION() {
        return this.GetParamIntValue(TAG_ENABLEDEACTION, 0) == 1;
    }

    public final void setENABLEDEACTION(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDEACTION, bValue ? 1 : 0);
    }

    public final boolean isENABLEDEDATASETNull() {
        return this.IsParamNull(TAG_ENABLEDEDATASET);
    }

    public final boolean getENABLEDEDATASET() {
        return this.GetParamIntValue(TAG_ENABLEDEDATASET, 0) == 1;
    }

    public final void setENABLEDEDATASET(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDEDATASET, bValue ? 1 : 0);
    }

    public final boolean isACTIONRSMODENull() {
        return this.IsParamNull(TAG_ACTIONRSMODE);
    }

    public final int getACTIONRSMODE() {
        return this.GetParamIntValue(TAG_ACTIONRSMODE, 0);
    }

    public final void setACTIONRSMODE(int nValue) {
        this.SetParamValue(TAG_ACTIONRSMODE, nValue);
    }

    public final boolean isDATARSMODENull() {
        return this.IsParamNull(TAG_DATARSMODE);
    }

    public final int getDATARSMODE() {
        return this.GetParamIntValue(TAG_DATARSMODE, 0);
    }

    public final void setDATARSMODE(int nValue) {
        this.SetParamValue(TAG_DATARSMODE, nValue);
    }

    public final boolean isDATAACCMODENull() {
        return this.IsParamNull(TAG_DATAACCMODE);
    }

    public final int getDATAACCMODE() {
        return this.GetParamIntValue(TAG_DATAACCMODE, 0);
    }

    public final void setDATAACCMODE(int nValue) {
        this.SetParamValue(TAG_DATAACCMODE, nValue);
    }

    public final boolean isTYPEFILTERNull() {
        return this.IsParamNull(TAG_TYPEFILTER);
    }

    public final String getTYPEFILTER() {
        return this.GetParamStringValue(TAG_TYPEFILTER, "");
    }

    public final void setTYPEFILTER(String strValue) {
        this.SetParamValue(TAG_TYPEFILTER, strValue);
    }

    public final boolean isARRAYFLAGNull() {
        return this.IsParamNull(TAG_ARRAYFLAG);
    }

    public final boolean getARRAYFLAG() {
        return this.GetParamIntValue(TAG_ARRAYFLAG, 0) == 1;
    }

    public final void setARRAYFLAG(boolean bValue) {
        this.SetParamValue(TAG_ARRAYFLAG, bValue ? 1 : 0);
    }

    public final boolean isENABLEDATAIMPORTNull() {
        return this.IsParamNull(TAG_ENABLEDATAIMPORT);
    }

    public final boolean getENABLEDATAIMPORT() {
        return this.GetParamIntValue(TAG_ENABLEDATAIMPORT, 0) == 1;
    }

    public final void setENABLEDATAIMPORT(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDATAIMPORT, bValue ? 1 : 0);
    }

    public final boolean isENABLEDATAEXPORTNull() {
        return this.IsParamNull(TAG_ENABLEDATAEXPORT);
    }

    public final boolean getENABLEDATAEXPORT() {
        return this.GetParamIntValue(TAG_ENABLEDATAEXPORT, 0) == 1;
    }

    public final void setENABLEDATAEXPORT(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDATAEXPORT, bValue ? 1 : 0);
    }
}

