/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.ctrlhandler.CtrlRenderBase
 *  net.ibizsys.paas.ctrlhandler.IMDCtrlRender
 */
package net.ibizsys.paas.web.extjs.render;

import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.ctrlhandler.CtrlRenderBase;
import net.ibizsys.paas.ctrlhandler.IMDCtrlRender;

public abstract class MDCtrlRenderBase
extends CtrlRenderBase
implements IMDCtrlRender {
    public void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
    }

    public String getFetchQuickSearch() {
        return null;
    }
}

