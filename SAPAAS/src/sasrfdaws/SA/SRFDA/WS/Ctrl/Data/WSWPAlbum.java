/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.WS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WSWPAlbum
extends BaseDataEntity {
    public static final String TAG_WSWPALBUMID = "WSWPALBUMID";
    public static final String TAG_WSWPALBUMNAME = "WSWPALBUMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";

    public boolean isWSWPALBUMIDNull() {
        return this.IsParamNull(TAG_WSWPALBUMID);
    }

    public String getWSWPALBUMID() {
        return this.GetParamStringValue(TAG_WSWPALBUMID, "");
    }

    public void setWSWPALBUMID(String strValue) {
        this.SetParamValue(TAG_WSWPALBUMID, strValue);
    }

    public boolean isWSWPALBUMNAMENull() {
        return this.IsParamNull(TAG_WSWPALBUMNAME);
    }

    public String getWSWPALBUMNAME() {
        return this.GetParamStringValue(TAG_WSWPALBUMNAME, "");
    }

    public void setWSWPALBUMNAME(String strValue) {
        this.SetParamValue(TAG_WSWPALBUMNAME, strValue);
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
}

