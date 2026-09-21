/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataImport
 */
package net.ibizsys.model.dataentity.dataimport;

import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.paas.core.IDEDataImport;

public interface IPSDEDataImport
extends IPSDataEntityObject,
IDEDataImport {
    public IPSDEAction getCreatePSDEAction();

    public IPSDEAction getUpdatePSDEAction();

    public IPSDEOPPriv getCreatePSDEOPPriv();

    public IPSDEOPPriv getUpdatePSDEOPPriv();
}

