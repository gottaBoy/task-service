/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IDataEntityObject;

public interface IDEMainState
extends IDataEntityObject {
    public void init(IDataEntity var1) throws Exception;

    public String getLogicName();

    @Deprecated
    public boolean isAllowMode();

    public boolean isActionAllowMode();

    public boolean isOPPrivAllowMode();

    public boolean isDefault();

    public String getMSTag();

    public boolean testDEAction(String var1) throws Exception;

    public boolean testDEOPPriv(String var1) throws Exception;
}

