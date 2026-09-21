/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class GlobalObject
extends BaseDataEntity {
    public static final String TAG_GLOBALOBJECTID = "GLOBALOBJECTID";
    public static final String TAG_GLOBALOBJECTNAME = "GLOBALOBJECTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_GOOBJECT = "GOOBJECT";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_INSTORDER = "INSTORDER";

    public String getGLOBALOBJECTID() {
        return this.GetParamStringValue(TAG_GLOBALOBJECTID, "");
    }

    public void setGLOBALOBJECTID(String strValue) {
        this.SetParamValue(TAG_GLOBALOBJECTID, strValue);
    }

    public String getGLOBALOBJECTNAME() {
        return this.GetParamStringValue(TAG_GLOBALOBJECTNAME, "");
    }

    public void setGLOBALOBJECTNAME(String strValue) {
        this.SetParamValue(TAG_GLOBALOBJECTNAME, strValue);
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

    public String getGOOBJECT() {
        return this.GetParamStringValue(TAG_GOOBJECT, "");
    }

    public void setGOOBJECT(String strValue) {
        this.SetParamValue(TAG_GOOBJECT, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public int getINSTORDER() {
        return this.GetParamIntValue(TAG_INSTORDER, 0);
    }

    public void setINSTORDER(int strValue) {
        this.SetParamValue(TAG_INSTORDER, strValue);
    }
}

