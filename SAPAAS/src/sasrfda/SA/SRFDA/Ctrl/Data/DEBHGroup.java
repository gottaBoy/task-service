/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;
import java.util.Vector;

public class DEBHGroup
extends BaseDataEntity {
    protected Vector<DEBehavior> deBehaviors = null;
    public static final String TAG_DEBHGROUPID = "DEBHGROUPID";
    public static final String TAG_DEBHGROUPNAME = "DEBHGROUPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_GROUPID = "GROUPID";
    public static final String TAG_VIEWTYPE = "VIEWTYPE";

    public Vector<DEBehavior> getDEBehaviors() {
        return this.deBehaviors;
    }

    public void setDEBehaviors(Vector<DEBehavior> deBehaviors) {
        this.deBehaviors = deBehaviors;
    }

    public String getDEBHGROUPID() {
        return this.GetParamStringValue(TAG_DEBHGROUPID, "");
    }

    public void setDEBHGROUPID(String strValue) {
        this.SetParamValue(TAG_DEBHGROUPID, strValue);
    }

    public String getDEBHGROUPNAME() {
        return this.GetParamStringValue(TAG_DEBHGROUPNAME, "");
    }

    public void setDEBHGROUPNAME(String strValue) {
        this.SetParamValue(TAG_DEBHGROUPNAME, strValue);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public String getGROUPID() {
        return this.GetParamStringValue(TAG_GROUPID, "");
    }

    public void setGROUPID(String strValue) {
        this.SetParamValue(TAG_GROUPID, strValue);
    }

    public String getVIEWTYPE() {
        return this.GetParamStringValue(TAG_VIEWTYPE, "");
    }

    public void setVIEWTYPE(String strValue) {
        this.SetParamValue(TAG_VIEWTYPE, strValue);
    }
}

