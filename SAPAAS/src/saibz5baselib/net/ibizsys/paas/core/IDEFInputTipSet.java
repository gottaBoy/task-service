/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IModelBase2;
import net.ibizsys.paas.core.ISystemObject;

public interface IDEFInputTipSet
extends ISystemObject,
IModelBase2 {
    public String getDEName();

    public String getDEDataSetName();

    public String getEnableCloseField();

    public String getContentField();

    public String getUniqueTagField();

    public String getLinkField();
}

