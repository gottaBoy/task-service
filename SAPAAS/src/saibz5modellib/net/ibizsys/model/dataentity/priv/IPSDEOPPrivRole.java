/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEOPPrivRole
 */
package net.ibizsys.model.dataentity.priv;

import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.model.dataentity.priv.IPSDEUserRole;
import net.ibizsys.paas.core.IDEOPPrivRole;

public interface IPSDEOPPrivRole
extends IPSDataEntityObject,
IDEOPPrivRole {
    public IPSDEOPPriv getPSDEOPPriv();

    public IPSDEDataQuery getPSDEDataQuery();

    public IPSDEUserRole getPSDEUserRole();
}

