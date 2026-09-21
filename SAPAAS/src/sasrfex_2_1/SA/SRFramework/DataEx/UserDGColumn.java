/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.DataEx.BaseDataEntityEx;

public class UserDGColumn
extends BaseDataEntityEx {
    public void setUserDGColumnId(int nUserDGColumnId) {
        this.SetParamValue("USERDGCOLUMNID", nUserDGColumnId);
    }

    public void setUserDGThemeId(int nUserDGThemeId) {
        this.SetParamValue("USERDGTHEMEID", nUserDGThemeId);
    }

    public void setDGColumnId(String strDGColumnId) {
        this.SetParamValue("DGCOLUMNID", strDGColumnId);
    }

    public void setVisibleFlag(int nVisibleFlag) {
        this.SetParamValue("VISIBLEFLAG", nVisibleFlag);
    }

    public void setLockFlag(int nLockFlag) {
        this.SetParamValue("LOCKFLAG", nLockFlag);
    }

    public void setWidth(int nWidth) {
        this.SetParamValue("WIDTH", nWidth);
    }

    public void setOrderFlag(int nOrderFlag) {
        this.SetParamValue("ORDERFLAG", nOrderFlag);
    }
}

