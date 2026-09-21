/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEDataExport;
import net.ibizsys.paas.core.IDEDataExportItem;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.web.IWebContext;

public interface IDEDataExportModel
extends IDEDataExport,
IModelBase3 {
    public String getItemText(IDEDataExportItem var1, IWebContext var2, Object var3, boolean var4) throws Exception;
}

