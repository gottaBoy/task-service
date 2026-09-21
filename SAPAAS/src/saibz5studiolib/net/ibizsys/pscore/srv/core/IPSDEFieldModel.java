/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.IDEFieldModel
 */
package net.ibizsys.pscore.srv.core;

import net.ibizsys.paas.demodel.IDEFieldModel;

public interface IPSDEFieldModel
extends IDEFieldModel {
    public static final String MODELV2TAG = "MODELV2TAG";
    public static final String IGNOREMODELV2 = "IGNOREMODELV2";
    public static final String RESERVEMODELV2 = "RESERVEMODELV2";

    public String getMemo();

    public String getValueRuleName();

    public Integer getLength();

    public Integer getMinValue();

    public Integer getMaxValue();

    public String getCodeName();

    public int getUserInputMode();

    public String getServiceCodeName();
}

