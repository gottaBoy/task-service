/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEForm
 *  net.ibizsys.model.control.form.IPSDEFormItemUpdate
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.model.control.form.IPSDEFormItemUpdate;
import net.ibizsys.model.entity.PSDEFIUpdate;

public interface IPSDEFormItemUpdateRuntime
extends IPSDEFormItemUpdate {
    public void init(IPSModelStorageContext var1, IPSDEForm var2, PSDEFIUpdate var3) throws Exception;
}

