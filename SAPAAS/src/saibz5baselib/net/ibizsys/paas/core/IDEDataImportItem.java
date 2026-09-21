/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IDEDataImport;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IModelBase;

public interface IDEDataImportItem
extends IModelBase {
    public IDEDataImport getDEDataImport();

    public String getDEFName();

    public String getCaption();

    public String getCapLanResTag();

    public boolean isUniqueItem();

    public IDEField getDEField();
}

