/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEFIUpdateDetail
 *  net.ibizsys.model.control.form.IPSDEFormItemUpdate
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.form.IPSDEFIUpdateDetail;
import net.ibizsys.model.control.form.IPSDEFormItemUpdate;
import net.ibizsys.model.entity.PSDEFIUDetail;

public interface IPSDEFIUpdateDetailRuntime
extends IPSDEFIUpdateDetail,
IPSModelObjectRuntime {
    public void init(IPSModelStorageContext var1, IPSDEFormItemUpdate var2, PSDEFIUDetail var3) throws Exception;
}

