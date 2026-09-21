/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.form.IEditForm;
import net.ibizsys.paas.ctrlmodel.IFormModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.service.IService;

public interface IEditFormModel
extends IFormModel,
IEditForm {
    public void testValueRule(IService var1, IDataObject var2, boolean var3) throws Exception;

    public boolean convertEntityFieldError(EntityFieldError var1) throws Exception;
}

