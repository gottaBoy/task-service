/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.view.IView;

public interface IControl
extends IModelBase {
    public String getControlType();

    public IView getView();

    public IDataEntity getDataEntity();
}

