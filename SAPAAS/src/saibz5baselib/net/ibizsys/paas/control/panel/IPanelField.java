/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.control.panel;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.control.panel.IPanel;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.web.IWebContext;
import net.sf.json.JSONObject;

public interface IPanelField
extends IModelBase {
    public IDataItem getDataItem();

    public JSONObject getConfig(IWebContext var1, IDataObject var2) throws Exception;

    public IPanel getPanel();

    public ICodeList getCodeList() throws Exception;

    public String getCodeListId();

    public Object getOutputValue(IWebContext var1, IDataObject var2, boolean var3) throws Exception;
}

