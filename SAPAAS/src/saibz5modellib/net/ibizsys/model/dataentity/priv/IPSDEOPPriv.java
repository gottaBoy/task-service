/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEOPPriv
 */
package net.ibizsys.model.dataentity.priv;

import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.der.IPSDERBase;
import net.ibizsys.paas.core.IDEOPPriv;

public interface IPSDEOPPriv
extends IPSSystemObject,
IDEOPPriv {
    public IPSDataEntity getPSDataEntity();

    public String getLogicName();

    public String getPSDERName();

    public IPSDERBase getPSDER();

    public String getMapPSDEOPPrivName();
}

