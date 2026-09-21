/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEFGroup
extends BaseDataEntity {
    public static final String LOGICMODE_SORT = "SORT";
    public static final String TAG_PSDEFGROUPID = "PSDEFGROUPID";
    public static final String TAG_PSDEFGROUPNAME = "PSDEFGROUPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_CODENAME2 = "CODENAME2";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_INITPSSYSDYNAMODELID = "INITPSSYSDYNAMODELID";
    public static final String TAG_INITPSSYSDYNAMODELNAME = "INITPSSYSDYNAMODELNAME";
    public static final String TAG_PSDEFORMID = "PSDEFORMID";
    public static final String TAG_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String TAG_GROUPTYPE = "GROUPTYPE";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_LOGICMODE = "LOGICMODE";
    public static final String TAG_LOGICPARAM = "LOGICPARAM";
    public static final String TAG_LOGICPARAM2 = "LOGICPARAM2";
    public static final String TAG_GROUPTAG2 = "GROUPTAG2";
    public static final String TAG_GROUPTAG = "GROUPTAG";
    public static final String TAG_PSDEVRGROUPID = "PSDEVRGROUPID";
    public static final String TAG_PSDEVRGROUPNAME = "PSDEVRGROUPNAME";
    public static final String TAG_DTOCODENAME = "DTOCODENAME";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_PSDEGRIDID = "PSDEGRIDID";
    public static final String TAG_PSDEGRIDNAME = "PSDEGRIDNAME";
    public static final String TAG_PSDEUSERROLEID = "PSDEUSERROLEID";
    public static final String TAG_PSDEUSERROLENAME = "PSDEUSERROLENAME";

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

    public final boolean isCODENAME2Null() {
        return this.IsParamNull(TAG_CODENAME2);
    }

    public final String getCODENAME2() {
        return this.GetParamStringValue(TAG_CODENAME2, "");
    }

    public final void setCODENAME2(String strValue) {
        this.SetParamValue(TAG_CODENAME2, strValue);
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

    public final boolean isPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELID);
    }

    public final String getPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELID, "");
    }

    public final void setPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELID, strValue);
    }

    public final boolean isPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELNAME);
    }

    public final String getPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELNAME, "");
    }

    public final void setPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELNAME, strValue);
    }

    public final boolean isINITPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_INITPSSYSDYNAMODELID);
    }

    public final String getINITPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_INITPSSYSDYNAMODELID, "");
    }

    public final void setINITPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_INITPSSYSDYNAMODELID, strValue);
    }

    public final boolean isINITPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_INITPSSYSDYNAMODELNAME);
    }

    public final String getINITPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_INITPSSYSDYNAMODELNAME, "");
    }

    public final void setINITPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_INITPSSYSDYNAMODELNAME, strValue);
    }

    public final boolean isPSDEFORMIDNull() {
        return this.IsParamNull(TAG_PSDEFORMID);
    }

    public final String getPSDEFORMID() {
        return this.GetParamStringValue(TAG_PSDEFORMID, "");
    }

    public final void setPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_PSDEFORMID, strValue);
    }

    public final boolean isPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_PSDEFORMNAME);
    }

    public final String getPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_PSDEFORMNAME, "");
    }

    public final void setPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFORMNAME, strValue);
    }

    public final boolean isGROUPTYPENull() {
        return this.IsParamNull(TAG_GROUPTYPE);
    }

    public final String getGROUPTYPE() {
        return this.GetParamStringValue(TAG_GROUPTYPE, "");
    }

    public final void setGROUPTYPE(String strValue) {
        this.SetParamValue(TAG_GROUPTYPE, strValue);
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

    public final boolean isLOGICMODENull() {
        return this.IsParamNull(TAG_LOGICMODE);
    }

    public final String getLOGICMODE() {
        return this.GetParamStringValue(TAG_LOGICMODE, "");
    }

    public final void setLOGICMODE(String strValue) {
        this.SetParamValue(TAG_LOGICMODE, strValue);
    }

    public final boolean isLOGICPARAMNull() {
        return this.IsParamNull(TAG_LOGICPARAM);
    }

    public final String getLOGICPARAM() {
        return this.GetParamStringValue(TAG_LOGICPARAM, "");
    }

    public final void setLOGICPARAM(String strValue) {
        this.SetParamValue(TAG_LOGICPARAM, strValue);
    }

    public final boolean isLOGICPARAM2Null() {
        return this.IsParamNull(TAG_LOGICPARAM2);
    }

    public final String getLOGICPARAM2() {
        return this.GetParamStringValue(TAG_LOGICPARAM2, "");
    }

    public final void setLOGICPARAM2(String strValue) {
        this.SetParamValue(TAG_LOGICPARAM2, strValue);
    }

    public final boolean isGROUPTAG2Null() {
        return this.IsParamNull(TAG_GROUPTAG2);
    }

    public final String getGROUPTAG2() {
        return this.GetParamStringValue(TAG_GROUPTAG2, "");
    }

    public final void setGROUPTAG2(String strValue) {
        this.SetParamValue(TAG_GROUPTAG2, strValue);
    }

    public final boolean isGROUPTAGNull() {
        return this.IsParamNull(TAG_GROUPTAG);
    }

    public final String getGROUPTAG() {
        return this.GetParamStringValue(TAG_GROUPTAG, "");
    }

    public final void setGROUPTAG(String strValue) {
        this.SetParamValue(TAG_GROUPTAG, strValue);
    }

    public final boolean isPSDEVRGROUPIDNull() {
        return this.IsParamNull(TAG_PSDEVRGROUPID);
    }

    public final String getPSDEVRGROUPID() {
        return this.GetParamStringValue(TAG_PSDEVRGROUPID, "");
    }

    public final void setPSDEVRGROUPID(String strValue) {
        this.SetParamValue(TAG_PSDEVRGROUPID, strValue);
    }

    public final boolean isPSDEVRGROUPNAMENull() {
        return this.IsParamNull(TAG_PSDEVRGROUPNAME);
    }

    public final String getPSDEVRGROUPNAME() {
        return this.GetParamStringValue(TAG_PSDEVRGROUPNAME, "");
    }

    public final void setPSDEVRGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVRGROUPNAME, strValue);
    }

    public final boolean isDTOCODENAMENull() {
        return this.IsParamNull(TAG_DTOCODENAME);
    }

    public final String getDTOCODENAME() {
        return this.GetParamStringValue(TAG_DTOCODENAME, "");
    }

    public final void setDTOCODENAME(String strValue) {
        this.SetParamValue(TAG_DTOCODENAME, strValue);
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

    public final boolean isPSDEGRIDIDNull() {
        return this.IsParamNull(TAG_PSDEGRIDID);
    }

    public final String getPSDEGRIDID() {
        return this.GetParamStringValue(TAG_PSDEGRIDID, "");
    }

    public final void setPSDEGRIDID(String strValue) {
        this.SetParamValue(TAG_PSDEGRIDID, strValue);
    }

    public final boolean isPSDEGRIDNAMENull() {
        return this.IsParamNull(TAG_PSDEGRIDNAME);
    }

    public final String getPSDEGRIDNAME() {
        return this.GetParamStringValue(TAG_PSDEGRIDNAME, "");
    }

    public final void setPSDEGRIDNAME(String strValue) {
        this.SetParamValue(TAG_PSDEGRIDNAME, strValue);
    }

    public final boolean isPSDEUSERROLEIDNull() {
        return this.IsParamNull(TAG_PSDEUSERROLEID);
    }

    public final String getPSDEUSERROLEID() {
        return this.GetParamStringValue(TAG_PSDEUSERROLEID, "");
    }

    public final void setPSDEUSERROLEID(String strValue) {
        this.SetParamValue(TAG_PSDEUSERROLEID, strValue);
    }

    public final boolean isPSDEUSERROLENAMENull() {
        return this.IsParamNull(TAG_PSDEUSERROLENAME);
    }

    public final String getPSDEUSERROLENAME() {
        return this.GetParamStringValue(TAG_PSDEUSERROLENAME, "");
    }

    public final void setPSDEUSERROLENAME(String strValue) {
        this.SetParamValue(TAG_PSDEUSERROLENAME, strValue);
    }
}

