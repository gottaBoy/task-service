/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEFSearchFormItem
 *  net.ibizsys.model.dataentity.field.IPSDEField
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.form.IPSDEFSearchFormItem;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.entity.PSDEFSearchMode;

public interface IPSDEFSearchFormItemRuntime
extends IPSDEFSearchFormItem {
    public void init(IPSModelStorageContext var1, IPSDEField var2, PSDEFSearchMode var3) throws Exception;
}

