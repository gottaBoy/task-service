/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataExportItem;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IDataEntityObject;

public interface IDEDataExport
extends IDataEntityObject {
    public void init(IDataEntity var1) throws Exception;

    public Iterator<IDEDataExportItem> getDEDataExportItems();
}

