/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlmodel.IDynaCtrlModel
 *  net.ibizsys.paas.ctrlmodel.IToolbarModel
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.Iterator;
import net.ibizsys.paas.core.IDynaModelJsonExporter;
import net.ibizsys.paas.core.IDynaModelJsonLoader;
import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.paas.ctrlmodel.IToolbarModel;
import net.ibizsys.paas.ctrlmodel.toolbar.IDynaToolbarItemModel;

public interface IDynaToolbarModel
extends IDynaCtrlModel,
IToolbarModel,
IDynaModelJsonExporter,
IDynaModelJsonLoader {
    public Iterator<IDynaToolbarItemModel> getItemModels();

    public IDynaToolbarItemModel createDynaToolbarItemModel(String var1) throws Exception;
}

