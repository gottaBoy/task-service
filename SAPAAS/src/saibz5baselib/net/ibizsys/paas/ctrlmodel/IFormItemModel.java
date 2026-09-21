/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.ctrlmodel.IFormModel;
import net.ibizsys.paas.web.IWebContext;
import net.sf.json.JSONObject;

public interface IFormItemModel
extends IFormItem {
    public static final Integer OUTPUTCODELISTCONFIGMODE_NONE = 0;
    public static final Integer OUTPUTCODELISTCONFIGMODE_SELECTEDONLY = 1;
    public static final Integer OUTPUTCODELISTCONFIGMODE_INCLUDECHILD = 2;

    public IFormModel getFormModel();

    public boolean isOutputCodeListConfig();

    public int getOutputCodeListConfigMode();

    @Override
    public Object getInputValue(IWebContext var1) throws Exception;

    public Object getInputValue(JSONObject var1) throws Exception;

    @Override
    public Object getDefaultValue(IWebContext var1, boolean var2) throws Exception;
}

