/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.control.form.IPSDEFFormItem;
import net.ibizsys.model.control.grid.IPSDEFGridColumn;
import net.ibizsys.model.dataentity.field.IPSDEFieldObject;

public interface IPSDEFUIMode
extends IPSDEFieldObject {
    public IPSDEFFormItem getPSDEFFormItem();

    public IPSDEFGridColumn getPSDEFGridColumn();
}

