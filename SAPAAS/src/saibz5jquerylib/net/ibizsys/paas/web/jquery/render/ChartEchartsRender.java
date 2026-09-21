/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.ctrlhandler.CtrlRenderBase
 *  net.ibizsys.paas.ctrlhandler.IChartRender
 *  net.ibizsys.paas.ctrlmodel.IChartModel
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.web.MDAjaxActionResult
 */
package net.ibizsys.paas.web.jquery.render;

import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.ctrlhandler.CtrlRenderBase;
import net.ibizsys.paas.ctrlhandler.IChartRender;
import net.ibizsys.paas.ctrlmodel.IChartModel;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.web.MDAjaxActionResult;

public class ChartEchartsRender
extends CtrlRenderBase
implements IChartRender {
    public void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
    }

    public String getFetchQuickSearch() {
        return null;
    }

    public void fillFetchResult(IChartModel iChartModel, MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
        iChartModel.fillFetchResult(fetchResult, dt);
    }
}

