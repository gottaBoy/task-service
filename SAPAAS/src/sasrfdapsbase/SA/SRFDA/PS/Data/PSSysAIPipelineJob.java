/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysAIPipelineJob
extends BaseDataEntity {
    public static final String TAG_PSSYSAIPIPELINEJOBID = "PSSYSAIPIPELINEJOBID";
    public static final String TAG_PSSYSAIPIPELINEJOBNAME = "PSSYSAIPIPELINEJOBNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSSYSAIFACTORYID = "PSSYSAIFACTORYID";
    public static final String TAG_PSSYSAIFACTORYNAME = "PSSYSAIFACTORYNAME";
    public static final String TAG_PSSYSAIPIPELINEAGENTID = "PSSYSAIPIPELINEAGENTID";
    public static final String TAG_PSSYSAIPIPELINEAGENTNAME = "PSSYSAIPIPELINEAGENTNAME";
    public static final String TAG_STEPPSCODELISTID = "STEPPSCODELISTID";
    public static final String TAG_STEPPSCODELISTNAME = "STEPPSCODELISTNAME";
    public static final String TAG_PSSYSAIWORKERAGENTID = "PSSYSAIWORKERAGENTID";
    public static final String TAG_PSSYSAIWORKERAGENTNAME = "PSSYSAIWORKERAGENTNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_JOBPARAMS = "JOBPARAMS";
    public static final String TAG_PSDEDATASETID = "PSDEDATASETID";
    public static final String TAG_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String TAG_JOBTAG = "JOBTAG";

    public final boolean isPSSYSAIPIPELINEJOBIDNull() {
        return this.IsParamNull(TAG_PSSYSAIPIPELINEJOBID);
    }

    public final String getPSSYSAIPIPELINEJOBID() {
        return this.GetParamStringValue(TAG_PSSYSAIPIPELINEJOBID, "");
    }

    public final void setPSSYSAIPIPELINEJOBID(String strValue) {
        this.SetParamValue(TAG_PSSYSAIPIPELINEJOBID, strValue);
    }

    public final boolean isPSSYSAIPIPELINEJOBNAMENull() {
        return this.IsParamNull(TAG_PSSYSAIPIPELINEJOBNAME);
    }

    public final String getPSSYSAIPIPELINEJOBNAME() {
        return this.GetParamStringValue(TAG_PSSYSAIPIPELINEJOBNAME, "");
    }

    public final void setPSSYSAIPIPELINEJOBNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAIPIPELINEJOBNAME, strValue);
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

    public final boolean isPSSYSAIFACTORYIDNull() {
        return this.IsParamNull(TAG_PSSYSAIFACTORYID);
    }

    public final String getPSSYSAIFACTORYID() {
        return this.GetParamStringValue(TAG_PSSYSAIFACTORYID, "");
    }

    public final void setPSSYSAIFACTORYID(String strValue) {
        this.SetParamValue(TAG_PSSYSAIFACTORYID, strValue);
    }

    public final boolean isPSSYSAIFACTORYNAMENull() {
        return this.IsParamNull(TAG_PSSYSAIFACTORYNAME);
    }

    public final String getPSSYSAIFACTORYNAME() {
        return this.GetParamStringValue(TAG_PSSYSAIFACTORYNAME, "");
    }

    public final void setPSSYSAIFACTORYNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAIFACTORYNAME, strValue);
    }

    public final boolean isPSSYSAIPIPELINEAGENTIDNull() {
        return this.IsParamNull(TAG_PSSYSAIPIPELINEAGENTID);
    }

    public final String getPSSYSAIPIPELINEAGENTID() {
        return this.GetParamStringValue(TAG_PSSYSAIPIPELINEAGENTID, "");
    }

    public final void setPSSYSAIPIPELINEAGENTID(String strValue) {
        this.SetParamValue(TAG_PSSYSAIPIPELINEAGENTID, strValue);
    }

    public final boolean isPSSYSAIPIPELINEAGENTNAMENull() {
        return this.IsParamNull(TAG_PSSYSAIPIPELINEAGENTNAME);
    }

    public final String getPSSYSAIPIPELINEAGENTNAME() {
        return this.GetParamStringValue(TAG_PSSYSAIPIPELINEAGENTNAME, "");
    }

    public final void setPSSYSAIPIPELINEAGENTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAIPIPELINEAGENTNAME, strValue);
    }

    public final boolean isSTEPPSCODELISTIDNull() {
        return this.IsParamNull(TAG_STEPPSCODELISTID);
    }

    public final String getSTEPPSCODELISTID() {
        return this.GetParamStringValue(TAG_STEPPSCODELISTID, "");
    }

    public final void setSTEPPSCODELISTID(String strValue) {
        this.SetParamValue(TAG_STEPPSCODELISTID, strValue);
    }

    public final boolean isSTEPPSCODELISTNAMENull() {
        return this.IsParamNull(TAG_STEPPSCODELISTNAME);
    }

    public final String getSTEPPSCODELISTNAME() {
        return this.GetParamStringValue(TAG_STEPPSCODELISTNAME, "");
    }

    public final void setSTEPPSCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_STEPPSCODELISTNAME, strValue);
    }

    public final boolean isPSSYSAIWORKERAGENTIDNull() {
        return this.IsParamNull(TAG_PSSYSAIWORKERAGENTID);
    }

    public final String getPSSYSAIWORKERAGENTID() {
        return this.GetParamStringValue(TAG_PSSYSAIWORKERAGENTID, "");
    }

    public final void setPSSYSAIWORKERAGENTID(String strValue) {
        this.SetParamValue(TAG_PSSYSAIWORKERAGENTID, strValue);
    }

    public final boolean isPSSYSAIWORKERAGENTNAMENull() {
        return this.IsParamNull(TAG_PSSYSAIWORKERAGENTNAME);
    }

    public final String getPSSYSAIWORKERAGENTNAME() {
        return this.GetParamStringValue(TAG_PSSYSAIWORKERAGENTNAME, "");
    }

    public final void setPSSYSAIWORKERAGENTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAIWORKERAGENTNAME, strValue);
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

    public final boolean isJOBPARAMSNull() {
        return this.IsParamNull(TAG_JOBPARAMS);
    }

    public final String getJOBPARAMS() {
        return this.GetParamStringValue(TAG_JOBPARAMS, "");
    }

    public final void setJOBPARAMS(String strValue) {
        this.SetParamValue(TAG_JOBPARAMS, strValue);
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

    public final boolean isJOBTAGNull() {
        return this.IsParamNull(TAG_JOBTAG);
    }

    public final String getJOBTAG() {
        return this.GetParamStringValue(TAG_JOBTAG, "");
    }

    public final void setJOBTAG(String strValue) {
        this.SetParamValue(TAG_JOBTAG, strValue);
    }
}

