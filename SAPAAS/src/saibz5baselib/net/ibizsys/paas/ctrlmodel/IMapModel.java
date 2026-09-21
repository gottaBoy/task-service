/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.Iterator;
import net.ibizsys.paas.control.map.IMapItem;
import net.ibizsys.paas.ctrlhandler.IMapItemFetchContext;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IMapItemModel;

public interface IMapModel
extends ICtrlModel {
    public static final String ITEM_SEPARATOR = ";";

    public IMapItemModel getMapItemModel(String var1) throws Exception;

    public Iterator<IMapItemModel> getMapItemModels();

    public boolean isOutputMapItem(IMapItemFetchContext var1, IMapItem var2) throws Exception;

    public boolean isOutputMapItemModel(IMapItemFetchContext var1, IMapItemModel var2) throws Exception;
}

