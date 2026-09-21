/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlmodel.IDynaCtrlModel
 *  net.ibizsys.paas.ctrlmodel.IGridModel
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.core.IDynaModelJsonExporter;
import net.ibizsys.paas.core.IDynaModelJsonLoader;
import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.paas.ctrlmodel.IGridModel;

public interface IDynaGridModel
extends IGridModel,
IDynaCtrlModel,
IDynaModelJsonExporter,
IDynaModelJsonLoader {
    public IGridModel getSourceGridModel();
}

