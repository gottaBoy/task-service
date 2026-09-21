/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEForm
 *  net.ibizsys.model.control.form.IPSDEFormItemVR
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.model.control.form.IPSDEFormItemVR;
import net.ibizsys.model.entity.PSDEFormItemVR;

public interface IPSDEFormItemVRRuntime
extends IPSDEFormItemVR {
    public void init(IPSModelStorageContext var1, IPSDEForm var2, PSDEFormItemVR var3) throws Exception;
}

