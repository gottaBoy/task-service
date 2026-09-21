/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFramework.DataEx.BaseDataEntity;

public class SRFUserDGTheme
extends BaseDataEntity {
    public void setUserDGThemeId(String strUserDGThemeId) {
        this.SetParamValue("USERDGTHEMEID", strUserDGThemeId);
    }

    public String getUserDGThemeId() {
        return this.GetParamStringValue("USERDGTHEMEID", "");
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

    public void setReserver(String strReserver) {
        this.SetParamValue("RESERVER", strReserver);
    }

    public void setReserver2(String strReserver2) {
        this.SetParamValue("RESERVER2", strReserver2);
    }

    public void setReserver3(String strReserver3) {
        this.SetParamValue("RESERVER3", strReserver3);
    }

    public String getReserver() {
        return this.GetParamStringValue("RESERVER", "");
    }

    public String getReserver2() {
        return this.GetParamStringValue("RESERVER2", "");
    }

    public String getReserver3() {
        return this.GetParamStringValue("RESERVER3", "");
    }

    public void setDGThemeModel(String strDGThemeDGThemeModel) {
        this.SetParamValue("DGTHEMEMODEL", strDGThemeDGThemeModel);
    }

    public String getDGThemeModel() {
        return this.GetParamStringValue("DGTHEMEMODEL", "");
    }
}

