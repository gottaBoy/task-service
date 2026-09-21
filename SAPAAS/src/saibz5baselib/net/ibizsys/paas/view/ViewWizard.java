/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.view;

import net.ibizsys.paas.core.ModelBase2Impl;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.view.IViewWizard;
import net.sf.json.JSONObject;

public class ViewWizard
extends ModelBase2Impl
implements IViewWizard {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String URL = "url";
    private String strWizardUrl = null;

    @Override
    public String getWizardUrl() {
        return this.strWizardUrl;
    }

    public void setWizardUrl(String strWizardUrl) {
        this.strWizardUrl = strWizardUrl;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public static JSONObject toJSONObject(JSONObject jsonObject, IViewWizard iViewWizard) throws Exception {
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        jsonObject.put(ID, JSONObjectHelper.stripQuotes(iViewWizard.getId(), true));
        jsonObject.put(NAME, JSONObjectHelper.stripQuotes(iViewWizard.getName(), true));
        jsonObject.put(URL, JSONObjectHelper.stripQuotes(iViewWizard.getWizardUrl(), true));
        return jsonObject;
    }
}

