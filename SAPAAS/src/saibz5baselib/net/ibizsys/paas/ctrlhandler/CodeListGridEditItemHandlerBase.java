/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.codelist.IDynamicCodeList;
import net.ibizsys.paas.ctrlhandler.GridEditItemHandlerBase;
import net.ibizsys.paas.ctrlmodel.GridEditItemModel;
import net.ibizsys.paas.ctrlmodel.IFormItemModel;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.sf.json.JSONObject;

public abstract class CodeListGridEditItemHandlerBase
extends GridEditItemHandlerBase {
    protected abstract ICodeList getCodeList() throws Exception;

    @Override
    protected AjaxActionResult onItemFetch() throws Exception {
        MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
        ICodeList iCodeList = this.getCodeList();
        this.fillFetchResult(mdAjaxActionResult, iCodeList);
        return mdAjaxActionResult;
    }

    protected void fillFetchResult(MDAjaxActionResult fetchResult, ICodeList iCodeList) throws Exception {
        String strGridEditItem = this.getWebContext().getParamValue("SRFFORMITEMID");
        GridEditItemModel gridEditItem = (GridEditItemModel)this.getGridModel().getGridEditItem(strGridEditItem, true);
        if (gridEditItem != null) {
            Iterator<ICodeItem> codeItems = null;
            if (iCodeList instanceof IDynamicCodeList) {
                IDynamicCodeList iDynamicCodeList = (IDynamicCodeList)iCodeList;
                codeItems = iDynamicCodeList.queryCodeItems(this.getWebContext(), null);
            } else {
                codeItems = iCodeList.getCodeItems();
            }
            while (codeItems.hasNext()) {
                ICodeItem iCodeItem = codeItems.next();
                JSONObject item = new JSONObject();
                item.put("text", JSONObjectHelper.stripQuotes(this.getCodeItemText(this.getWebContext(), iCodeItem)));
                item.put("value", JSONObjectHelper.stripQuotes(iCodeItem.getValue()));
                if (!StringHelper.isNullOrEmpty(iCodeItem.getParentValue())) {
                    item.put("pvalue", JSONObjectHelper.stripQuotes(iCodeItem.getParentValue()));
                }
                if (iCodeItem.isDisableSelect()) {
                    item.put("disabled", true);
                }
                if (iCodeItem.getCodeItems() == null || !iCodeItem.getCodeItems().hasNext()) {
                    item.put("leaf", true);
                } else if (gridEditItem.getOutputCodeListConfigMode() == IFormItemModel.OUTPUTCODELISTCONFIGMODE_INCLUDECHILD.intValue()) {
                    this.fillCodeListItems(this.getWebContext(), item, iCodeItem);
                }
                fetchResult.getRows().add(item);
            }
            return;
        }
        ICodeListModel iCodeListModel = null;
        if (iCodeList instanceof ICodeListModel) {
            iCodeListModel = (ICodeListModel)iCodeList;
            iCodeListModel.fillFetchResult(fetchResult, this.getWebContext());
        }
    }

    protected void fillCodeListItems(IWebContext iWebContext, JSONObject parentItem, ICodeItem parentCodeItem) throws Exception {
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        Iterator<ICodeItem> items = parentCodeItem.getCodeItems();
        while (items.hasNext()) {
            ICodeItem iCodeItem = items.next();
            JSONObject item = new JSONObject();
            item.put("text", JSONObjectHelper.stripQuotes(this.getCodeItemText(iWebContext, iCodeItem)));
            item.put("value", JSONObjectHelper.stripQuotes(iCodeItem.getValue()));
            if (!StringHelper.isNullOrEmpty(iCodeItem.getParentValue())) {
                item.put("pvalue", JSONObjectHelper.stripQuotes(iCodeItem.getParentValue()));
            }
            if (iCodeItem.isDisableSelect()) {
                item.put("disabled", true);
            }
            if (iCodeItem.getCodeItems() == null || !iCodeItem.getCodeItems().hasNext()) {
                item.put("leaf", true);
            } else {
                this.fillCodeListItems(iWebContext, item, iCodeItem);
            }
            list.add(item);
        }
        parentItem.put("items", (Object)list.toArray());
    }

    protected String getCodeItemText(IWebContext iWebContext, ICodeItem iCodeItem) {
        String strText = iCodeItem.getText();
        String strTextLanResTag = iCodeItem.getTextLanResTag();
        if (!StringHelper.isNullOrEmpty(strTextLanResTag)) {
            strText = iWebContext.getLocalization(strTextLanResTag, strText);
        }
        return strText;
    }
}

