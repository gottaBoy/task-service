/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;
import net.ibizsys.paas.control.map.IMapItem;
import net.ibizsys.paas.ctrlhandler.IMDCtrlRender;
import net.ibizsys.paas.ctrlmodel.IMapModel;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;

public interface IMapRender
extends IMDCtrlRender {
    public String getItemType(IWebContext var1) throws Exception;

    public String getItemId(IWebContext var1) throws Exception;

    public void fillFetchResult(IMapModel var1, MDAjaxActionResult var2, ArrayList<IMapItem> var3) throws Exception;

    public void fillItemResult(IMapModel var1, MDAjaxActionResult var2, IMapItem var3) throws Exception;
}

