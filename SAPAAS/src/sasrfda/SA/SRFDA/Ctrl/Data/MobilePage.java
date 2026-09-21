/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class MobilePage
extends BaseDataEntity {
    public static final String TAG_MOBILEPAGEID = "MOBILEPAGEID";
    public static final String TAG_MOBILEPAGENAME = "MOBILEPAGENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_PAGEID = "PAGEID";
    public static final String TAG_PAGENAME = "PAGENAME";
    public static final String TAG_PAGEMODEL = "PAGEMODEL";
    public static final String TAG_PAGEPATH = "PAGEPATH";
    public static final String TAG_PAGEPARAMS = "PAGEPARAMS";
    public static final String TAG_PAGEDEID = "PAGEDEID";

    public final boolean isMOBILEPAGEIDNull() {
        return this.IsParamNull(TAG_MOBILEPAGEID);
    }

    public final String getMOBILEPAGEID() {
        return this.GetParamStringValue(TAG_MOBILEPAGEID, "");
    }

    public final void setMOBILEPAGEID(String strValue) {
        this.SetParamValue(TAG_MOBILEPAGEID, strValue);
    }

    public final boolean isMOBILEPAGENAMENull() {
        return this.IsParamNull(TAG_MOBILEPAGENAME);
    }

    public final String getMOBILEPAGENAME() {
        return this.GetParamStringValue(TAG_MOBILEPAGENAME, "");
    }

    public final void setMOBILEPAGENAME(String strValue) {
        this.SetParamValue(TAG_MOBILEPAGENAME, strValue);
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

    public final boolean isDEIDNull() {
        return this.IsParamNull(TAG_DEID);
    }

    public final String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public final void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public final boolean isDENAMENull() {
        return this.IsParamNull(TAG_DENAME);
    }

    public final String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public final void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public final boolean isPAGEIDNull() {
        return this.IsParamNull(TAG_PAGEID);
    }

    public final String getPAGEID() {
        return this.GetParamStringValue(TAG_PAGEID, "");
    }

    public final void setPAGEID(String strValue) {
        this.SetParamValue(TAG_PAGEID, strValue);
    }

    public final boolean isPAGENAMENull() {
        return this.IsParamNull(TAG_PAGENAME);
    }

    public final String getPAGENAME() {
        return this.GetParamStringValue(TAG_PAGENAME, "");
    }

    public final void setPAGENAME(String strValue) {
        this.SetParamValue(TAG_PAGENAME, strValue);
    }

    public final boolean isPAGEMODELNull() {
        return this.IsParamNull(TAG_PAGEMODEL);
    }

    public final String getPAGEMODEL() {
        return this.GetParamStringValue(TAG_PAGEMODEL, "");
    }

    public final void setPAGEMODEL(String strValue) {
        this.SetParamValue(TAG_PAGEMODEL, strValue);
    }

    public final boolean isPAGEPATHNull() {
        return this.IsParamNull(TAG_PAGEPATH);
    }

    public final String getPAGEPATH() {
        return this.GetParamStringValue(TAG_PAGEPATH, "");
    }

    public final void setPAGEPATH(String strValue) {
        this.SetParamValue(TAG_PAGEPATH, strValue);
    }

    public final boolean isPAGEPARAMSNull() {
        return this.IsParamNull(TAG_PAGEPARAMS);
    }

    public final String getPAGEPARAMS() {
        return this.GetParamStringValue(TAG_PAGEPARAMS, "");
    }

    public final void setPAGEPARAMS(String strValue) {
        this.SetParamValue(TAG_PAGEPARAMS, strValue);
    }

    public final boolean isPAGEDEIDNull() {
        return this.IsParamNull(TAG_PAGEDEID);
    }

    public final String getPAGEDEID() {
        return this.GetParamStringValue(TAG_PAGEDEID, "");
    }

    public final void setPAGEDEID(String strValue) {
        this.SetParamValue(TAG_PAGEDEID, strValue);
    }
}

