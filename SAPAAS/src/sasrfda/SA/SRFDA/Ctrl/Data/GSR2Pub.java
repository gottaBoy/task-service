/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class GSR2Pub
extends BaseDataEntity {
    public static final String TAG_GSR2PUBID = "GSR2PUBID";
    public static final String TAG_GSR2PUBNAME = "GSR2PUBNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_GSR2ID = "GSR2ID";
    public static final String TAG_GSR2NAME = "GSR2NAME";
    public static final String TAG_GSR2SUMTABLEID = "GSR2SUMTABLEID";
    public static final String TAG_GSR2SUMTABLENAME = "GSR2SUMTABLENAME";
    public static final String TAG_GSR2DIMENSIONID = "GSR2DIMENSIONID";
    public static final String TAG_GSR2DIMENSIONNAME = "GSR2DIMENSIONNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_QUERYCOND = "QUERYCOND";
    public static final String TAG_FILENAME = "FILENAME";
    public static final String TAG_PUBGROUPID = "PUBGROUPID";
    public static final String TAG_PUBGROUPNAME = "PUBGROUPNAME";
    public static final String TAG_TD = "TD";

    public String getGSR2PUBID() {
        return this.GetParamStringValue(TAG_GSR2PUBID, "");
    }

    public void setGSR2PUBID(String strValue) {
        this.SetParamValue(TAG_GSR2PUBID, strValue);
    }

    public String getGSR2PUBNAME() {
        return this.GetParamStringValue(TAG_GSR2PUBNAME, "");
    }

    public void setGSR2PUBNAME(String strValue) {
        this.SetParamValue(TAG_GSR2PUBNAME, strValue);
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

    public String getGSR2ID() {
        return this.GetParamStringValue(TAG_GSR2ID, "");
    }

    public void setGSR2ID(String strValue) {
        this.SetParamValue(TAG_GSR2ID, strValue);
    }

    public String getGSR2NAME() {
        return this.GetParamStringValue(TAG_GSR2NAME, "");
    }

    public void setGSR2NAME(String strValue) {
        this.SetParamValue(TAG_GSR2NAME, strValue);
    }

    public String getGSR2SUMTABLEID() {
        return this.GetParamStringValue(TAG_GSR2SUMTABLEID, "");
    }

    public void setGSR2SUMTABLEID(String strValue) {
        this.SetParamValue(TAG_GSR2SUMTABLEID, strValue);
    }

    public String getGSR2SUMTABLENAME() {
        return this.GetParamStringValue(TAG_GSR2SUMTABLENAME, "");
    }

    public void setGSR2SUMTABLENAME(String strValue) {
        this.SetParamValue(TAG_GSR2SUMTABLENAME, strValue);
    }

    public String getGSR2DIMENSIONID() {
        return this.GetParamStringValue(TAG_GSR2DIMENSIONID, "");
    }

    public void setGSR2DIMENSIONID(String strValue) {
        this.SetParamValue(TAG_GSR2DIMENSIONID, strValue);
    }

    public String getGSR2DIMENSIONNAME() {
        return this.GetParamStringValue(TAG_GSR2DIMENSIONNAME, "");
    }

    public void setGSR2DIMENSIONNAME(String strValue) {
        this.SetParamValue(TAG_GSR2DIMENSIONNAME, strValue);
    }

    public boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public String getQUERYCOND() {
        return this.GetParamStringValue(TAG_QUERYCOND, "");
    }

    public void setQUERYCOND(String strValue) {
        this.SetParamValue(TAG_QUERYCOND, strValue);
    }

    public String getFILENAME() {
        return this.GetParamStringValue(TAG_FILENAME, "");
    }

    public void setFILENAME(String strValue) {
        this.SetParamValue(TAG_FILENAME, strValue);
    }

    public String getPUBGROUPID() {
        return this.GetParamStringValue(TAG_PUBGROUPID, "");
    }

    public void setPUBGROUPID(String strValue) {
        this.SetParamValue(TAG_PUBGROUPID, strValue);
    }

    public String getPUBGROUPNAME() {
        return this.GetParamStringValue(TAG_PUBGROUPNAME, "");
    }

    public void setPUBGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PUBGROUPNAME, strValue);
    }

    public String getTD() {
        return this.GetParamStringValue(TAG_TD, "");
    }

    public void setTD(String strValue) {
        this.SetParamValue(TAG_TD, strValue);
    }
}

