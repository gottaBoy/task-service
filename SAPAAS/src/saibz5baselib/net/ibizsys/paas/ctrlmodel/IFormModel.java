/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.form.IForm;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.web.IWebContext;
import net.sf.json.JSONObject;

public interface IFormModel
extends ICtrlModel,
IForm {
    public void fillOutputDatas(IDataObject var1, boolean var2, JSONObject var3, JSONObject var4, JSONObject var5) throws Exception;

    public void fillInputValues(IDataObject var1, boolean var2, boolean var3) throws Exception;

    public Object getItemInputValue(String var1, IWebContext var2) throws Exception;

    public void fillDefaultValues(IDataObject var1, boolean var2) throws Exception;
}

