/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Ctrl.Data.DevImgDetail;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;
import java.util.Hashtable;

public class DevImage
extends BaseDataEntity {
    public static final String IMAGETYPE_ICON16 = "ICON16";
    public static final String IMAGETYPE_ICON32 = "ICON32";
    public static final String IMAGETYPE_ICON48 = "ICON48";
    public static final String TAG_DEVIMAGEID = "DEVIMAGEID";
    public static final String TAG_DEVIMAGENAME = "DEVIMAGENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_IMAGEPATH = "IMAGEPATH";
    public static final String TAG_CSSCLASS = "CSSCLASS";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    protected Hashtable<String, DevImgDetail> imgDetailMap = new Hashtable();

    public void RegisterDevImgDetail(String strStyle, DevImgDetail imgDetail) {
        if (imgDetail != null) {
            this.imgDetailMap.put(strStyle.toUpperCase(), imgDetail);
        } else {
            this.imgDetailMap.remove(strStyle.toUpperCase());
        }
    }

    public DevImgDetail FindDevImgDetail(String strStyle) {
        return this.imgDetailMap.get(strStyle.toUpperCase());
    }

    public void ResetDevImgDetail() {
        this.imgDetailMap.clear();
    }

    public String getDEVIMAGEID() {
        return this.GetParamStringValue(TAG_DEVIMAGEID, "");
    }

    public void setDEVIMAGEID(String strValue) {
        this.SetParamValue(TAG_DEVIMAGEID, strValue);
    }

    public String getDEVIMAGENAME() {
        return this.GetParamStringValue(TAG_DEVIMAGENAME, "");
    }

    public void setDEVIMAGENAME(String strValue) {
        this.SetParamValue(TAG_DEVIMAGENAME, strValue);
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

    public String getIMAGEPATH() {
        return this.GetParamStringValue(TAG_IMAGEPATH, "");
    }

    public void setIMAGEPATH(String strValue) {
        this.SetParamValue(TAG_IMAGEPATH, strValue);
    }

    public String getCSSCLASS() {
        return this.GetParamStringValue(TAG_CSSCLASS, "");
    }

    public void setCSSCLASS(String strValue) {
        this.SetParamValue(TAG_CSSCLASS, strValue);
    }

    public int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public void setWIDTH(int strValue) {
        this.SetParamValue(TAG_WIDTH, strValue);
    }

    public int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public void setHEIGHT(int strValue) {
        this.SetParamValue(TAG_HEIGHT, strValue);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }
}

