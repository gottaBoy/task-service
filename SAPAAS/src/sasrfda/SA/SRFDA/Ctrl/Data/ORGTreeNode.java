/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class ORGTreeNode
extends BaseDataEntity {
    public static final String TAG_ORGTREENODEID = "ORGTREENODEID";
    public static final String TAG_ORGTREENODENAME = "ORGTREENODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ORGTREEID = "ORGTREEID";
    public static final String TAG_ORGTREENAME = "ORGTREENAME";
    public static final String TAG_PORGTREENODEID = "PORGTREENODEID";
    public static final String TAG_PORGTREENODENAME = "PORGTREENODENAME";
    public static final String TAG_ORGUNITID = "ORGUNITID";
    public static final String TAG_ORGUNITNAME = "ORGUNITNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_REFORGTREENODEID = "REFORGTREENODEID";
    public static final String TAG_REFORGTREENODENAME = "REFORGTREENODENAME";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_ORGTREENODETYPE = "ORGTREENODETYPE";

    public final boolean isORGTREENODEIDNull() {
        return this.IsParamNull(TAG_ORGTREENODEID);
    }

    public final String getORGTREENODEID() {
        return this.GetParamStringValue(TAG_ORGTREENODEID, "");
    }

    public final void setORGTREENODEID(String strValue) {
        this.SetParamValue(TAG_ORGTREENODEID, strValue);
    }

    public final boolean isORGTREENODENAMENull() {
        return this.IsParamNull(TAG_ORGTREENODENAME);
    }

    public final String getORGTREENODENAME() {
        return this.GetParamStringValue(TAG_ORGTREENODENAME, "");
    }

    public final void setORGTREENODENAME(String strValue) {
        this.SetParamValue(TAG_ORGTREENODENAME, strValue);
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

    public final boolean isORGTREEIDNull() {
        return this.IsParamNull(TAG_ORGTREEID);
    }

    public final String getORGTREEID() {
        return this.GetParamStringValue(TAG_ORGTREEID, "");
    }

    public final void setORGTREEID(String strValue) {
        this.SetParamValue(TAG_ORGTREEID, strValue);
    }

    public final boolean isORGTREENAMENull() {
        return this.IsParamNull(TAG_ORGTREENAME);
    }

    public final String getORGTREENAME() {
        return this.GetParamStringValue(TAG_ORGTREENAME, "");
    }

    public final void setORGTREENAME(String strValue) {
        this.SetParamValue(TAG_ORGTREENAME, strValue);
    }

    public final boolean isPORGTREENODEIDNull() {
        return this.IsParamNull(TAG_PORGTREENODEID);
    }

    public final String getPORGTREENODEID() {
        return this.GetParamStringValue(TAG_PORGTREENODEID, "");
    }

    public final void setPORGTREENODEID(String strValue) {
        this.SetParamValue(TAG_PORGTREENODEID, strValue);
    }

    public final boolean isPORGTREENODENAMENull() {
        return this.IsParamNull(TAG_PORGTREENODENAME);
    }

    public final String getPORGTREENODENAME() {
        return this.GetParamStringValue(TAG_PORGTREENODENAME, "");
    }

    public final void setPORGTREENODENAME(String strValue) {
        this.SetParamValue(TAG_PORGTREENODENAME, strValue);
    }

    public final boolean isORGUNITIDNull() {
        return this.IsParamNull(TAG_ORGUNITID);
    }

    public final String getORGUNITID() {
        return this.GetParamStringValue(TAG_ORGUNITID, "");
    }

    public final void setORGUNITID(String strValue) {
        this.SetParamValue(TAG_ORGUNITID, strValue);
    }

    public final boolean isORGUNITNAMENull() {
        return this.IsParamNull(TAG_ORGUNITNAME);
    }

    public final String getORGUNITNAME() {
        return this.GetParamStringValue(TAG_ORGUNITNAME, "");
    }

    public final void setORGUNITNAME(String strValue) {
        this.SetParamValue(TAG_ORGUNITNAME, strValue);
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

    public final boolean isREFORGTREENODEIDNull() {
        return this.IsParamNull(TAG_REFORGTREENODEID);
    }

    public final String getREFORGTREENODEID() {
        return this.GetParamStringValue(TAG_REFORGTREENODEID, "");
    }

    public final void setREFORGTREENODEID(String strValue) {
        this.SetParamValue(TAG_REFORGTREENODEID, strValue);
    }

    public final boolean isREFORGTREENODENAMENull() {
        return this.IsParamNull(TAG_REFORGTREENODENAME);
    }

    public final String getREFORGTREENODENAME() {
        return this.GetParamStringValue(TAG_REFORGTREENODENAME, "");
    }

    public final void setREFORGTREENODENAME(String strValue) {
        this.SetParamValue(TAG_REFORGTREENODENAME, strValue);
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

    public final boolean isORGTREENODETYPENull() {
        return this.IsParamNull(TAG_ORGTREENODETYPE);
    }

    public final String getORGTREENODETYPE() {
        return this.GetParamStringValue(TAG_ORGTREENODETYPE, "");
    }

    public final void setORGTREENODETYPE(String strValue) {
        this.SetParamValue(TAG_ORGTREENODETYPE, strValue);
    }
}

