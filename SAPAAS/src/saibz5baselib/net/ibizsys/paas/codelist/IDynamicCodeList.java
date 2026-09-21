/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.codelist;

import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.web.IWebContext;

public interface IDynamicCodeList
extends ICodeList {
    public Iterator<ICodeItem> queryCodeItems(IWebContext var1, IDataObject var2) throws Exception;

    public void refresh() throws Exception;

    public int getRefreshTimer();
}

