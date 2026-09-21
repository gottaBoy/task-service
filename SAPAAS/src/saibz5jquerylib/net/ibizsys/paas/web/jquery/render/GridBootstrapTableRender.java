/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlhandler.IGridRender
 *  net.ibizsys.paas.ctrlmodel.IGridModel
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.web.MDAjaxActionResult
 */
package net.ibizsys.paas.web.jquery.render;

import net.ibizsys.paas.ctrlhandler.IGridRender;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.jquery.render.BootstrapTableRenderBase;

public class GridBootstrapTableRender
extends BootstrapTableRenderBase
implements IGridRender {
    public void fillFetchResult(IGridModel iGridModel, MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
        iGridModel.fillFetchResult(fetchResult, dt);
    }
}

