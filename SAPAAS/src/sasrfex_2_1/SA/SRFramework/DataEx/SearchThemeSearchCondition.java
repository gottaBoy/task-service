/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.DataEx.SearchCondition;

public class SearchThemeSearchCondition
extends SearchCondition {
    public void setSearchPanelId(String strSearchPanelId) {
        this.SetParamValue("SEARCHPANELID", strSearchPanelId);
    }

    public void setPersonId(String strPersonId) {
        this.SetParamValue("PERSONID", strPersonId);
    }

    public void setProjectId(String strProjectId) {
        this.SetParamValue("PROJECTID", strProjectId);
    }
}

