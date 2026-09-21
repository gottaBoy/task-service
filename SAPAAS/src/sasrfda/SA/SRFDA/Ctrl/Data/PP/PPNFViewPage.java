/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data.PP;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PPNFViewPage
extends BaseDataEntity {
    public static final String TAG_PPNFVIEWPAGEID = "PPNFVIEWPAGEID";
    public static final String TAG_PPNFVIEWPAGENAME = "PPNFVIEWPAGENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PPNFVIEWID = "PPNFVIEWID";
    public static final String TAG_PPNFVIEWNAME = "PPNFVIEWNAME";
    public static final String TAG_TITLELANRESID = "TITLELANRESID";
    public static final String TAG_TITLELANRESNAME = "TITLELANRESNAME";
    public static final String TAG_PAGEID = "PAGEID";
    public static final String TAG_PAGENAME = "PAGENAME";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";

    public boolean isPPNFVIEWPAGEIDNull() {
        return this.IsParamNull(TAG_PPNFVIEWPAGEID);
    }

    public String getPPNFVIEWPAGEID() {
        return this.GetParamStringValue(TAG_PPNFVIEWPAGEID, "");
    }

    public void setPPNFVIEWPAGEID(String strValue) {
        this.SetParamValue(TAG_PPNFVIEWPAGEID, strValue);
    }

    public boolean isPPNFVIEWPAGENAMENull() {
        return this.IsParamNull(TAG_PPNFVIEWPAGENAME);
    }

    public String getPPNFVIEWPAGENAME() {
        return this.GetParamStringValue(TAG_PPNFVIEWPAGENAME, "");
    }

    public void setPPNFVIEWPAGENAME(String strValue) {
        this.SetParamValue(TAG_PPNFVIEWPAGENAME, strValue);
    }

    public boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public boolean isPPNFVIEWIDNull() {
        return this.IsParamNull(TAG_PPNFVIEWID);
    }

    public String getPPNFVIEWID() {
        return this.GetParamStringValue(TAG_PPNFVIEWID, "");
    }

    public void setPPNFVIEWID(String strValue) {
        this.SetParamValue(TAG_PPNFVIEWID, strValue);
    }

    public boolean isPPNFVIEWNAMENull() {
        return this.IsParamNull(TAG_PPNFVIEWNAME);
    }

    public String getPPNFVIEWNAME() {
        return this.GetParamStringValue(TAG_PPNFVIEWNAME, "");
    }

    public void setPPNFVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PPNFVIEWNAME, strValue);
    }

    public boolean isTITLELANRESIDNull() {
        return this.IsParamNull(TAG_TITLELANRESID);
    }

    public String getTITLELANRESID() {
        return this.GetParamStringValue(TAG_TITLELANRESID, "");
    }

    public void setTITLELANRESID(String strValue) {
        this.SetParamValue(TAG_TITLELANRESID, strValue);
    }

    public boolean isTITLELANRESNAMENull() {
        return this.IsParamNull(TAG_TITLELANRESNAME);
    }

    public String getTITLELANRESNAME() {
        return this.GetParamStringValue(TAG_TITLELANRESNAME, "");
    }

    public void setTITLELANRESNAME(String strValue) {
        this.SetParamValue(TAG_TITLELANRESNAME, strValue);
    }

    public boolean isPAGEIDNull() {
        return this.IsParamNull(TAG_PAGEID);
    }

    public String getPAGEID() {
        return this.GetParamStringValue(TAG_PAGEID, "");
    }

    public void setPAGEID(String strValue) {
        this.SetParamValue(TAG_PAGEID, strValue);
    }

    public boolean isPAGENAMENull() {
        return this.IsParamNull(TAG_PAGENAME);
    }

    public String getPAGENAME() {
        return this.GetParamStringValue(TAG_PAGENAME, "");
    }

    public void setPAGENAME(String strValue) {
        this.SetParamValue(TAG_PAGENAME, strValue);
    }

    public boolean isORDERFLAGNull() {
        return this.IsParamNull(TAG_ORDERFLAG);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int strValue) {
        this.SetParamValue(TAG_ORDERFLAG, strValue);
    }
}

