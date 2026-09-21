/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSubSysSADE
extends BaseDataEntity {
    public static final String TAG_PSSUBSYSSADEID = "PSSUBSYSSADEID";
    public static final String TAG_PSSUBSYSSADENAME = "PSSUBSYSSADENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String TAG_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_MAJORFLAG = "MAJORFLAG";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_CODENAME2 = "CODENAME2";
    public static final String TAG_DETAG = "DETAG";
    public static final String TAG_DETAG2 = "DETAG2";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_METHODCODE = "METHODCODE";
    public static final String TAG_SERVICEPARAM = "SERVICEPARAM";
    public static final String TAG_SERVICEPARAM2 = "SERVICEPARAM2";
    public static final String TAG_SERVICEPARAMS = "SERVICEPARAMS";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";

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

    public final boolean isMAJORFLAGNull() {
        return this.IsParamNull(TAG_MAJORFLAG);
    }

    public final int getMAJORFLAG() {
        return this.GetParamIntValue(TAG_MAJORFLAG, 0);
    }

    public final void setMAJORFLAG(int nValue) {
        this.SetParamValue(TAG_MAJORFLAG, nValue);
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

    public final boolean isCODENAME2Null() {
        return this.IsParamNull(TAG_CODENAME2);
    }

    public final String getCODENAME2() {
        return this.GetParamStringValue(TAG_CODENAME2, "");
    }

    public final void setCODENAME2(String strValue) {
        this.SetParamValue(TAG_CODENAME2, strValue);
    }

    public final boolean isDETAGNull() {
        return this.IsParamNull(TAG_DETAG);
    }

    public final String getDETAG() {
        return this.GetParamStringValue(TAG_DETAG, "");
    }

    public final void setDETAG(String strValue) {
        this.SetParamValue(TAG_DETAG, strValue);
    }

    public final boolean isDETAG2Null() {
        return this.IsParamNull(TAG_DETAG2);
    }

    public final String getDETAG2() {
        return this.GetParamStringValue(TAG_DETAG2, "");
    }

    public final void setDETAG2(String strValue) {
        this.SetParamValue(TAG_DETAG2, strValue);
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

    public final boolean isMETHODCODENull() {
        return this.IsParamNull(TAG_METHODCODE);
    }

    public final String getMETHODCODE() {
        return this.GetParamStringValue(TAG_METHODCODE, "");
    }

    public final void setMETHODCODE(String strValue) {
        this.SetParamValue(TAG_METHODCODE, strValue);
    }

    public final boolean isSERVICEPARAMNull() {
        return this.IsParamNull(TAG_SERVICEPARAM);
    }

    public final String getSERVICEPARAM() {
        return this.GetParamStringValue(TAG_SERVICEPARAM, "");
    }

    public final void setSERVICEPARAM(String strValue) {
        this.SetParamValue(TAG_SERVICEPARAM, strValue);
    }

    public final boolean isSERVICEPARAM2Null() {
        return this.IsParamNull(TAG_SERVICEPARAM2);
    }

    public final String getSERVICEPARAM2() {
        return this.GetParamStringValue(TAG_SERVICEPARAM2, "");
    }

    public final void setSERVICEPARAM2(String strValue) {
        this.SetParamValue(TAG_SERVICEPARAM2, strValue);
    }

    public final boolean isSERVICEPARAMSNull() {
        return this.IsParamNull(TAG_SERVICEPARAMS);
    }

    public final String getSERVICEPARAMS() {
        return this.GetParamStringValue(TAG_SERVICEPARAMS, "");
    }

    public final void setSERVICEPARAMS(String strValue) {
        this.SetParamValue(TAG_SERVICEPARAMS, strValue);
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
}

