/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IModelBase2
 */
package net.ibizsys.pscore.srv.core;

import net.ibizsys.paas.core.IModelBase2;
import net.ibizsys.pscore.srv.core.IPSDEFieldModel;

public interface IPSDEFGroupDetailModel
extends IModelBase2 {
    public IPSDEFieldModel getPSDEFieldModel();

    public String getMemo();

    public String getCodeListId();

    public String getValueRuleName();

    public Integer getLength();

    public Integer getMinValue();

    public Integer getMaxValue();
}

