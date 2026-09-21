/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IDEDataExport;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.web.IWebContext;

public interface IDEDataExportItem
extends IDataItem {
    public IDEDataExport getDEDataExport();

    public String getPrivilegeId();

    public String getCaption();

    public String getText(IWebContext var1, Object var2, boolean var3) throws Exception;

    public String getCapLanResTag();
}

