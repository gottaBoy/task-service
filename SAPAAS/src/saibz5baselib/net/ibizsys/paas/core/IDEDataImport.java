/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataImportItem;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IDataEntityObject;

public interface IDEDataImport
extends IDataEntityObject {
    public void init(IDataEntity var1) throws Exception;

    public Iterator<IDEDataImportItem> getDEDataImportItems();

    public boolean isIgnoreError();

    public String getCreateDEActionName();

    public String getUpdateDEActionName();

    public boolean isDefault();

    public String getCreateDataAccessAction();

    public String getUpdateDataAccessAction();
}

