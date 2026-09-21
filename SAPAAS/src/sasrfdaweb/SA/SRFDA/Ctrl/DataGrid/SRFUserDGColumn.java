/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFramework.DataEx.BaseDataEntity;

public class SRFUserDGColumn
extends BaseDataEntity {
    public void setUserDGColumnId(String strUserDGColumnId) {
        this.SetParamValue("USERDGTHEMEID", strUserDGColumnId);
    }

    public void setUserDGThemeId(String strUserDGThemeId) {
        this.SetParamValue("USERDGTHEMEID", strUserDGThemeId);
    }

    public void setDGColumnId(String strDGColumnId) {
        this.SetParamValue("DGCOLUMNID", strDGColumnId);
    }

    public String getDGColumnId() {
        return this.GetParamStringValue("DGCOLUMNID", "");
    }

    public void setVisibleFlag(int nVisibleFlag) {
        this.SetParamValue("VISIBLEFLAG", nVisibleFlag);
    }

    public int getVisibleFlag() {
        return this.GetParamIntValue("VISIBLEFLAG", 1);
    }

    public void setLockFlag(int nLockFlag) {
        this.SetParamValue("LOCKFLAG", nLockFlag);
    }

    public int getLockFlag() {
        return this.GetParamIntValue("LOCKFLAG", 0);
    }

    public void setWidth(int nWidth) {
        this.SetParamValue("WIDTH", nWidth);
    }

    public int getWidth() {
        return this.GetParamIntValue("WIDTH", 100);
    }

    public void setOrderFlag(int nOrderFlag) {
        this.SetParamValue("ORDERFLAG", nOrderFlag);
    }
}

