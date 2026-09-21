/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.panel.IPanel;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.data.IDataObject;
import net.sf.json.JSONObject;

public interface IPanelModel
extends ICtrlModel,
IPanel {
    public void fillOutputDatas(IDataObject var1, JSONObject var2, JSONObject var3) throws Exception;
}

