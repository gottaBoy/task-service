/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEFDLogic
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.form.IPSDEFDLogic;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.entity.PSDEFDLogic;

public interface IPSDEFDLogicRuntime
extends IPSDEFDLogic {
    public void init(IPSModelStorageContext var1, IPSDEFormDetail var2, IPSDEFDLogic var3, PSDEFDLogic var4) throws Exception;
}

