/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.view;

import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.view.IUIAction;
import net.sf.json.JSONObject;

public interface IUIActionGroupDetail
extends IModelBase {
    public IUIAction getUIAction();

    public JSONObject getUIActionParam();
}

