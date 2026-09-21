/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.ctrlhandler.CtrlRenderBase
 *  net.ibizsys.paas.ctrlhandler.ICtrlRender
 *  net.ibizsys.paas.ctrlhandler.IMDCtrlRender
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 */
package net.ibizsys.paas.web.jquery.render;

import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.ctrlhandler.CtrlRenderBase;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.ctrlhandler.IMDCtrlRender;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;

public abstract class BootstrapTableRenderBase
extends CtrlRenderBase
implements ICtrlRender,
IMDCtrlRender {
    public void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        IWebContext iWebContext = WebContext.getCurrent();
        if (iWebContext == null) {
            return;
        }
        String strSort = iWebContext.getPostOrParamValue("sort");
        String strOrder = iWebContext.getPostOrParamValue("order");
        String strLimit = iWebContext.getPostOrParamValue("limit");
        String strOffset = iWebContext.getPostOrParamValue("offset");
        if (!StringHelper.isNullOrEmpty((String)strSort)) {
            deDataSetFetchContextImpl.setSort(strSort);
            deDataSetFetchContextImpl.setSortDir(strOrder);
        }
        int nStartRow = 0;
        if (!StringHelper.isNullOrEmpty((String)strOffset)) {
            nStartRow = Integer.parseInt(strOffset);
        }
        int nSize = 25;
        if (!StringHelper.isNullOrEmpty((String)strLimit)) {
            nSize = Integer.parseInt(strLimit);
        }
        deDataSetFetchContextImpl.setStartRow(nStartRow);
        deDataSetFetchContextImpl.setPageSize(nSize);
    }

    public String getFetchQuickSearch() {
        IWebContext iWebContext = WebContext.getCurrent();
        if (iWebContext == null) {
            return null;
        }
        return iWebContext.getPostOrParamValue("search");
    }
}

