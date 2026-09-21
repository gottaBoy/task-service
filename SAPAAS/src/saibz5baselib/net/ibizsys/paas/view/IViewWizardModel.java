/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.view;

import java.util.ArrayList;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.view.IViewWizard;
import net.sf.json.JSONObject;

public interface IViewWizardModel
extends IViewWizard {
    public int fillViewWizards(IViewController var1, String var2, ArrayList<IViewWizard> var3) throws Exception;

    public JSONObject toJSONObject(boolean var1) throws Exception;
}

