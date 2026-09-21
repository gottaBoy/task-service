/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class FormItemEx
extends BaseDataEntity {
    public static final String TAG_FORMITEMEXID = "FORMITEMEXID";
    public static final String TAG_FORMITEMEXNAME = "FORMITEMEXNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TAGNAME = "TAGNAME";
    public static final String TAG_CONFIGCLASS = "CONFIGCLASS";
    public static final String TAG_CONTROLCLASS = "CONTROLCLASS";
    public static final String TAG_USERCONTROL = "USERCONTROL";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";

    public String getFORMITEMEXID() {
        return this.GetParamStringValue(TAG_FORMITEMEXID, "");
    }

    public void setFORMITEMEXID(String strValue) {
        this.SetParamValue(TAG_FORMITEMEXID, strValue);
    }

    public String getFORMITEMEXNAME() {
        return this.GetParamStringValue(TAG_FORMITEMEXNAME, "");
    }

    public void setFORMITEMEXNAME(String strValue) {
        this.SetParamValue(TAG_FORMITEMEXNAME, strValue);
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

    public String getTAGNAME() {
        return this.GetParamStringValue(TAG_TAGNAME, "");
    }

    public void setTAGNAME(String strValue) {
        this.SetParamValue(TAG_TAGNAME, strValue);
    }

    public String getCONFIGCLASS() {
        return this.GetParamStringValue(TAG_CONFIGCLASS, "");
    }

    public void setCONFIGCLASS(String strValue) {
        this.SetParamValue(TAG_CONFIGCLASS, strValue);
    }

    public String getCONTROLCLASS() {
        return this.GetParamStringValue(TAG_CONTROLCLASS, "");
    }

    public void setCONTROLCLASS(String strValue) {
        this.SetParamValue(TAG_CONTROLCLASS, strValue);
    }

    public boolean getUSERCONTROL() {
        return this.GetParamIntValue(TAG_USERCONTROL, 0) == 1;
    }

    public void setUSERCONTROL(boolean bValue) {
        this.SetParamValue(TAG_USERCONTROL, bValue ? 1 : 0);
    }

    public boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }
}

