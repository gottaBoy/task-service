/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.ctrlmodel.DRCtrlModelBase;
import net.ibizsys.paas.ctrlmodel.IDRTabModel;

public abstract class DRTabModelBase
extends DRCtrlModelBase
implements IDRTabModel {
    @Override
    public String getControlType() {
        return "DRTAB";
    }
}

