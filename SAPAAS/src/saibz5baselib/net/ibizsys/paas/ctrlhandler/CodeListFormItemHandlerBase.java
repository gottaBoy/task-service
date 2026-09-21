/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.ctrlhandler.FormItemHandlerBase;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;

public abstract class CodeListFormItemHandlerBase
extends FormItemHandlerBase {
    protected abstract ICodeList getCodeList() throws Exception;

    @Override
    protected AjaxActionResult onItemFetch() throws Exception {
        MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
        ICodeList iCodeList = this.getCodeList();
        this.fillFetchResult(mdAjaxActionResult, iCodeList);
        return mdAjaxActionResult;
    }

    protected void fillFetchResult(MDAjaxActionResult fetchResult, ICodeList iCodeList) throws Exception {
        ICodeListModel iCodeListModel = null;
        if (iCodeList instanceof ICodeListModel) {
            iCodeListModel = (ICodeListModel)iCodeList;
            iCodeListModel.fillFetchResult(fetchResult, this.getWebContext());
        }
    }
}

