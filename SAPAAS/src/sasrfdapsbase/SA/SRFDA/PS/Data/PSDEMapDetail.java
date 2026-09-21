/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEMapDetail
extends BaseDataEntity {
    public static final String SRCTYPE_FIELD = "FIELD";
    public static final String SRCTYPE_VALUE = "VALUE";
    public static final String TAG_PSDEMAPDETAILID = "PSDEMAPDETAILID";
    public static final String TAG_PSDEMAPDETAILNAME = "PSDEMAPDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEMAPID = "PSDEMAPID";
    public static final String TAG_PSDEMAPNAME = "PSDEMAPNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DSTFIELDNAME = "DSTFIELDNAME";
    public static final String TAG_SRCVALUE = "SRCVALUE";
    public static final String TAG_SRCPSDEFID = "SRCPSDEFID";
    public static final String TAG_SRCPSDEFNAME = "SRCPSDEFNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_SRCTYPE = "SRCTYPE";
    public static final String TAG_PSSYSTRANSLATORID = "PSSYSTRANSLATORID";
    public static final String TAG_PSSYSTRANSLATORNAME = "PSSYSTRANSLATORNAME";

    public final boolean isPSDEMAPDETAILIDNull() {
        return this.IsParamNull(TAG_PSDEMAPDETAILID);
    }

    public final String getPSDEMAPDETAILID() {
        return this.GetParamStringValue(TAG_PSDEMAPDETAILID, "");
    }

    public final void setPSDEMAPDETAILID(String strValue) {
        this.SetParamValue(TAG_PSDEMAPDETAILID, strValue);
    }

    public final boolean isPSDEMAPDETAILNAMENull() {
        return this.IsParamNull(TAG_PSDEMAPDETAILNAME);
    }

    public final String getPSDEMAPDETAILNAME() {
        return this.GetParamStringValue(TAG_PSDEMAPDETAILNAME, "");
    }

    public final void setPSDEMAPDETAILNAME(String strValue) {
        this.SetParamValue(TAG_PSDEMAPDETAILNAME, strValue);
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

    public final boolean isPSDEMAPIDNull() {
        return this.IsParamNull(TAG_PSDEMAPID);
    }

    public final String getPSDEMAPID() {
        return this.GetParamStringValue(TAG_PSDEMAPID, "");
    }

    public final void setPSDEMAPID(String strValue) {
        this.SetParamValue(TAG_PSDEMAPID, strValue);
    }

    public final boolean isPSDEMAPNAMENull() {
        return this.IsParamNull(TAG_PSDEMAPNAME);
    }

    public final String getPSDEMAPNAME() {
        return this.GetParamStringValue(TAG_PSDEMAPNAME, "");
    }

    public final void setPSDEMAPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEMAPNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isDSTFIELDNAMENull() {
        return this.IsParamNull(TAG_DSTFIELDNAME);
    }

    public final String getDSTFIELDNAME() {
        return this.GetParamStringValue(TAG_DSTFIELDNAME, "");
    }

    public final void setDSTFIELDNAME(String strValue) {
        this.SetParamValue(TAG_DSTFIELDNAME, strValue);
    }

    public final boolean isSRCVALUENull() {
        return this.IsParamNull(TAG_SRCVALUE);
    }

    public final String getSRCVALUE() {
        return this.GetParamStringValue(TAG_SRCVALUE, "");
    }

    public final void setSRCVALUE(String strValue) {
        this.SetParamValue(TAG_SRCVALUE, strValue);
    }

    public final boolean isSRCPSDEFIDNull() {
        return this.IsParamNull(TAG_SRCPSDEFID);
    }

    public final String getSRCPSDEFID() {
        return this.GetParamStringValue(TAG_SRCPSDEFID, "");
    }

    public final void setSRCPSDEFID(String strValue) {
        this.SetParamValue(TAG_SRCPSDEFID, strValue);
    }

    public final boolean isSRCPSDEFNAMENull() {
        return this.IsParamNull(TAG_SRCPSDEFNAME);
    }

    public final String getSRCPSDEFNAME() {
        return this.GetParamStringValue(TAG_SRCPSDEFNAME, "");
    }

    public final void setSRCPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_SRCPSDEFNAME, strValue);
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

    public final boolean isSRCTYPENull() {
        return this.IsParamNull(TAG_SRCTYPE);
    }

    public final String getSRCTYPE() {
        return this.GetParamStringValue(TAG_SRCTYPE, "");
    }

    public final void setSRCTYPE(String strValue) {
        this.SetParamValue(TAG_SRCTYPE, strValue);
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
}

