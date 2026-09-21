/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.ctrlmodel.ExpBarModelBase;
import net.ibizsys.paas.ctrlmodel.ITreeExpBarModel;

public abstract class TreeExpBarModelBase
extends ExpBarModelBase
implements ITreeExpBarModel {
    @Override
    public String getControlType() {
        return "TREEEXPBAR";
    }
}

