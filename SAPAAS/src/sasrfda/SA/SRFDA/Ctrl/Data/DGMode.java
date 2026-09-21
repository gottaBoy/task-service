/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class DGMode
extends BaseDataEntity {
    public static final String TAG_DGMODEID = "DGMODEID";
    public static final String TAG_DGMODENAME = "DGMODENAME";
    public static final String TAG_SUMMARYHEIGHT = "SUMMARYHEIGHT";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_ROWCLASSHELPER = "ROWCLASSHELPER";
    public static final String TAG_EXTDSITEM = "EXTDSITEM";
    public static final String TAG_RENDERMODE = "RENDERMODE";

    public String getDGMODEID() {
        return this.GetParamStringValue(TAG_DGMODEID, "");
    }

    public String getDGMODENAME() {
        return this.GetParamStringValue(TAG_DGMODENAME, "");
    }

    public String getDGCOLUMNCAPTION() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public int getSUMMARYHEIGHT() {
        return this.GetParamIntValue(TAG_SUMMARYHEIGHT, 0);
    }

    public String getROWCLASSHELPER() {
        return this.GetParamStringValue(TAG_ROWCLASSHELPER, "");
    }

    public boolean isRENDERMODENull() {
        return this.IsParamNull(TAG_RENDERMODE);
    }

    public String getRENDERMODE() {
        return this.GetParamStringValue(TAG_RENDERMODE, "");
    }

    public void setRENDERMODE(String strValue) {
        this.SetParamValue(TAG_RENDERMODE, strValue);
    }

    public boolean isEXTDSITEMNull() {
        return this.IsParamNull(TAG_EXTDSITEM);
    }

    public String getEXTDSITEM() {
        return this.GetParamStringValue(TAG_EXTDSITEM, "");
    }

    public void setEXTDSITEM(String strValue) {
        this.SetParamValue(TAG_EXTDSITEM, strValue);
    }
}

