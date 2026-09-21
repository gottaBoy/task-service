/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.DataEx.BaseDataEntityEx;

public class UserDGTheme
extends BaseDataEntityEx {
    public void setUserDGThemeId(int nUserDGThemeId) {
        this.SetParamValue("USERDGTHEMEID", nUserDGThemeId);
    }

    public void setProjectId(String strProjectId) {
        this.SetParamValue("PROJECTID", strProjectId);
    }

    public void setDataGridId(String strDataGridId) {
        this.SetParamValue("DATAGRIDID", strDataGridId);
    }

    public void setPersonId(String strPersonId) {
        this.SetParamValue("PERSONID", strPersonId);
    }
}

