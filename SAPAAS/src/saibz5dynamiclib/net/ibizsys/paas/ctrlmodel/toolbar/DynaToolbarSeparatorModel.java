/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel.toolbar;

import net.ibizsys.paas.ctrlmodel.toolbar.DynaToolbarItemModelBase;
import net.ibizsys.paas.ctrlmodel.toolbar.IDynaToolbarSeparatorModel;

public class DynaToolbarSeparatorModel
extends DynaToolbarItemModelBase
implements IDynaToolbarSeparatorModel {
    @Override
    public String getItemType() {
        return "SEPARATOR";
    }
}

