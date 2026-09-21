/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEForm
 *  net.ibizsys.model.core.IPSModelObject
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSDEForm;
import net.ibizsys.model.entity.PSFormType;

public interface IPSFormType
extends IPSModelObject {
    public void init(IPSModelStorageContext var1, PSFormType var2) throws Exception;

    public IPSDEForm createPSDEForm(PSDEForm var1) throws Exception;
}

