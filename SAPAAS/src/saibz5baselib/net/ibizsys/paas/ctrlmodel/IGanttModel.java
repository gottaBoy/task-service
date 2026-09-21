/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.Iterator;
import net.ibizsys.paas.control.gantt.IGanttItem;
import net.ibizsys.paas.ctrlhandler.IGanttItemFetchContext;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IGanttItemModel;

public interface IGanttModel
extends ICtrlModel {
    public static final String ITEM_SEPARATOR = ";";

    public IGanttItemModel getGanttItemModel(String var1) throws Exception;

    public Iterator<IGanttItemModel> getGanttItemModels();

    public boolean isOutputGanttItem(IGanttItemFetchContext var1, IGanttItem var2) throws Exception;

    public boolean isOutputGanttItemModel(IGanttItemFetchContext var1, IGanttItemModel var2) throws Exception;
}

