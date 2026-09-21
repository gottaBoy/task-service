/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysAIPipelineWorker
extends BaseDataEntity {
    public static final String TAG_PSSYSAIPIPELINEWORKERID = "PSSYSAIPIPELINEWORKERID";
    public static final String TAG_PSSYSAIPIPELINEWORKERNAME = "PSSYSAIPIPELINEWORKERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAIPIPELINEAGENTID = "PSSYSAIPIPELINEAGENTID";
    public static final String TAG_PSSYSAIPIPELINEAGENTNAME = "PSSYSAIPIPELINEAGENTNAME";
    public static final String TAG_PSSYSAIFACTORYID = "PSSYSAIFACTORYID";
    public static final String TAG_PSSYSAIFACTORYNAME = "PSSYSAIFACTORYNAME";
    public static final String TAG_PSSYSAIWORKERAGENTID = "PSSYSAIWORKERAGENTID";
    public static final String TAG_PSSYSAIWORKERAGENTNAME = "PSSYSAIWORKERAGENTNAME";

    public final boolean isPSSYSAIPIPELINEWORKERIDNull() {
        return this.IsParamNull(TAG_PSSYSAIPIPELINEWORKERID);
    }

    public final String getPSSYSAIPIPELINEWORKERID() {
        return this.GetParamStringValue(TAG_PSSYSAIPIPELINEWORKERID, "");
    }

    public final void setPSSYSAIPIPELINEWORKERID(String strValue) {
        this.SetParamValue(TAG_PSSYSAIPIPELINEWORKERID, strValue);
    }

    public final boolean isPSSYSAIPIPELINEWORKERNAMENull() {
        return this.IsParamNull(TAG_PSSYSAIPIPELINEWORKERNAME);
    }

    public final String getPSSYSAIPIPELINEWORKERNAME() {
        return this.GetParamStringValue(TAG_PSSYSAIPIPELINEWORKERNAME, "");
    }

    public final void setPSSYSAIPIPELINEWORKERNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAIPIPELINEWORKERNAME, strValue);
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
}

