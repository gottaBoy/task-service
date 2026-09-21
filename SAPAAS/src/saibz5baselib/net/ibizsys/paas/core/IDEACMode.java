/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.Iterator;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IDataEntityObject;
import net.ibizsys.paas.data.IDataItem;

public interface IDEACMode
extends IDataEntityObject {
    public static final String DATAITEM_VALUE = "value";
    public static final String DATAITEM_TEXT = "text";
    public static final String DATAITEM_REALTEXT = "realtext";

    public void init(IDataEntity var1) throws Exception;

    public String getMinorSortField();

    public String getMinorSortDir();

    public Iterator<IDataItem> getDataItems();

    public boolean isDefaultMode();
}

