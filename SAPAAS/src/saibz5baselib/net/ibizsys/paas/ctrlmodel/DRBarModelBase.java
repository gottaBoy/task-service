/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.ctrlmodel.DRCtrlModelBase;
import net.ibizsys.paas.ctrlmodel.IDRBarModel;

public abstract class DRBarModelBase
extends DRCtrlModelBase
implements IDRBarModel {
    @Override
    public String getControlType() {
        return "DRBAR";
    }
}

