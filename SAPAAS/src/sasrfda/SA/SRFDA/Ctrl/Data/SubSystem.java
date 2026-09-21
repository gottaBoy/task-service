/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class SubSystem
extends BaseDataEntity {
    public static final String TAG_SUBSYSTEMID = "SUBSYSTEMID";
    public static final String TAG_SUBSYSTEMNAME = "SUBSYSTEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_LOGOPATH = "LOGOPATH";
    public static final String TAG_DEFAULTPATH = "DEFAULTPATH";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_HELPEROBJECT = "HELPEROBJECT";

    public final boolean isSUBSYSTEMIDNull() {
        return this.IsParamNull(TAG_SUBSYSTEMID);
    }

    public final String getSUBSYSTEMID() {
        return this.GetParamStringValue(TAG_SUBSYSTEMID, "");
    }

    public final void setSUBSYSTEMID(String strValue) {
        this.SetParamValue(TAG_SUBSYSTEMID, strValue);
    }

    public final boolean isSUBSYSTEMNAMENull() {
        return this.IsParamNull(TAG_SUBSYSTEMNAME);
    }

    public final String getSUBSYSTEMNAME() {
        return this.GetParamStringValue(TAG_SUBSYSTEMNAME, "");
    }

    public final void setSUBSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_SUBSYSTEMNAME, strValue);
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

    public final boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public final String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public final void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public final boolean isLOGOPATHNull() {
        return this.IsParamNull(TAG_LOGOPATH);
    }

    public final String getLOGOPATH() {
        return this.GetParamStringValue(TAG_LOGOPATH, "");
    }

    public final void setLOGOPATH(String strValue) {
        this.SetParamValue(TAG_LOGOPATH, strValue);
    }

    public final boolean isDEFAULTPATHNull() {
        return this.IsParamNull(TAG_DEFAULTPATH);
    }

    public final String getDEFAULTPATH() {
        return this.GetParamStringValue(TAG_DEFAULTPATH, "");
    }

    public final void setDEFAULTPATH(String strValue) {
        this.SetParamValue(TAG_DEFAULTPATH, strValue);
    }

    public final boolean isORDERFLAGNull() {
        return this.IsParamNull(TAG_ORDERFLAG);
    }

    public final int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public final void setORDERFLAG(int nValue) {
        this.SetParamValue(TAG_ORDERFLAG, nValue);
    }

    public final boolean isHELPEROBJECTNull() {
        return this.IsParamNull(TAG_HELPEROBJECT);
    }

    public final String getHELPEROBJECT() {
        return this.GetParamStringValue(TAG_HELPEROBJECT, "");
    }

    public final void setHELPEROBJECT(String strValue) {
        this.SetParamValue(TAG_HELPEROBJECT, strValue);
    }
}

