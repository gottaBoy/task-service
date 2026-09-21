/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataExport
 */
package net.ibizsys.model.dataentity.dataexport;

import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.paas.core.IDEDataExport;

public interface IPSDEDataExport
extends IPSDataEntityObject,
IDEDataExport {
    public int getMaxRowCount();
}

