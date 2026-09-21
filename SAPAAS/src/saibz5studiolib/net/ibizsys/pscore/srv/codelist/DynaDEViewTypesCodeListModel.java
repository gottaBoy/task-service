/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.CodeItem
 *  net.ibizsys.paas.codelist.CodeItems
 *  net.ibizsys.paas.codelist.CodeList
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 *  net.ibizsys.paas.sysmodel.StaticCodeListModelBase
 */
package net.ibizsys.pscore.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="4715AB97-E8B1-473D-BA28-0D332EFE0D4A", name="\u52a8\u6001\u5b9e\u4f53\u89c6\u56fe\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DYNADEEDITVIEW", text="\u52a8\u6001\u7f16\u8f91\u89c6\u56fe", realtext="\u52a8\u6001\u7f16\u8f91\u89c6\u56fe"), @CodeItem(value="DYNADEGRIDVIEW", text="\u52a8\u6001\u8868\u683c\u89c6\u56fe", realtext="\u52a8\u6001\u8868\u683c\u89c6\u56fe"), @CodeItem(value="DYNADEMPICKUPVIEW2", text="\u52a8\u6001\u5b9e\u4f53\u591a\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09", realtext="\u52a8\u6001\u5b9e\u4f53\u591a\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09"), @CodeItem(value="DYNADEMPICKUPVIEW", text="\u52a8\u6001\u5b9e\u4f53\u6570\u636e\u591a\u9879\u9009\u62e9\u89c6\u56fe", realtext="\u52a8\u6001\u5b9e\u4f53\u6570\u636e\u591a\u9879\u9009\u62e9\u89c6\u56fe"), @CodeItem(value="DYNADEPICKUPVIEW", text="\u52a8\u6001\u5b9e\u4f53\u6570\u636e\u9009\u62e9\u89c6\u56fe", realtext="\u52a8\u6001\u5b9e\u4f53\u6570\u636e\u9009\u62e9\u89c6\u56fe"), @CodeItem(value="DYNADEPICKUPVIEW2", text="\u52a8\u6001\u5b9e\u4f53\u6570\u636e\u9009\u62e9\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09", realtext="\u52a8\u6001\u5b9e\u4f53\u6570\u636e\u9009\u62e9\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09"), @CodeItem(value="DYNADEREDIRECTVIEW", text="\u52a8\u6001\u5b9e\u4f53\u6570\u636e\u91cd\u5b9a\u5411\u89c6\u56fe", realtext="\u52a8\u6001\u5b9e\u4f53\u6570\u636e\u91cd\u5b9a\u5411\u89c6\u56fe"), @CodeItem(value="DYNADEEDITVIEW2", text="\u52a8\u6001\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09", realtext="\u52a8\u6001\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09"), @CodeItem(value="DYNADEPICKUPGRIDVIEW", text="\u52a8\u6001\u5b9e\u4f53\u9009\u62e9\u8868\u683c\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09", realtext="\u52a8\u6001\u5b9e\u4f53\u9009\u62e9\u8868\u683c\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09"), @CodeItem(value="DYNADEWFDATAREDIRECTVIEW", text="\u52a8\u6001\u5b9e\u4f53\u6d41\u7a0b\u6570\u636e\u91cd\u5b9a\u5411\u89c6\u56fe", realtext="\u52a8\u6001\u5b9e\u4f53\u6d41\u7a0b\u6570\u636e\u91cd\u5b9a\u5411\u89c6\u56fe"), @CodeItem(value="DYNADEWFSTARTVIEW", text="\u52a8\u6001\u5b9e\u4f53\u5de5\u4f5c\u6d41\u542f\u52a8\u89c6\u56fe", realtext="\u52a8\u6001\u5b9e\u4f53\u5de5\u4f5c\u6d41\u542f\u52a8\u89c6\u56fe"), @CodeItem(value="DYNADEWFEXPVIEW", text="\u52a8\u6001\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bfc\u822a\u89c6\u56fe", realtext="\u52a8\u6001\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bfc\u822a\u89c6\u56fe"), @CodeItem(value="DYNADEWFACTIONVIEW", text="\u52a8\u6001\u5b9e\u4f53\u5de5\u4f5c\u6d41\u64cd\u4f5c\u89c6\u56fe", realtext="\u52a8\u6001\u5b9e\u4f53\u5de5\u4f5c\u6d41\u64cd\u4f5c\u89c6\u56fe"), @CodeItem(value="DYNADEWFEDITVIEW", text="\u52a8\u6001\u5b9e\u4f53\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe", realtext="\u52a8\u6001\u5b9e\u4f53\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe"), @CodeItem(value="DYNADEWFEDITVIEW2", text="\u52a8\u6001\u5b9e\u4f53\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09", realtext="\u52a8\u6001\u5b9e\u4f53\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09"), @CodeItem(value="DYNADEWFGRIDVIEW", text="\u52a8\u6001\u5b9e\u4f53\u5de5\u4f5c\u6d41\u8868\u683c\u89c6\u56fe", realtext="\u52a8\u6001\u5b9e\u4f53\u5de5\u4f5c\u6d41\u8868\u683c\u89c6\u56fe"), @CodeItem(value="DYNADEWFEDITVIEW3", text="\u52a8\u6001\u5b9e\u4f53\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09", realtext="\u52a8\u6001\u5b9e\u4f53\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09"), @CodeItem(value="DYNADEWFPROXYDATAVIEW", text="\u52a8\u6001\u5b9e\u4f53\u6d41\u7a0b\u4ee3\u7406\u6570\u636e\u89c6\u56fe", realtext="\u52a8\u6001\u5b9e\u4f53\u6d41\u7a0b\u4ee3\u7406\u6570\u636e\u89c6\u56fe")})
public class DynaDEViewTypesCodeListModel
extends StaticCodeListModelBase {
    public static final String DYNADEEDITVIEW = "DYNADEEDITVIEW";
    public static final String DYNADEGRIDVIEW = "DYNADEGRIDVIEW";
    public static final String DYNADEMPICKUPVIEW2 = "DYNADEMPICKUPVIEW2";
    public static final String DYNADEMPICKUPVIEW = "DYNADEMPICKUPVIEW";
    public static final String DYNADEPICKUPVIEW = "DYNADEPICKUPVIEW";
    public static final String DYNADEPICKUPVIEW2 = "DYNADEPICKUPVIEW2";
    public static final String DYNADEREDIRECTVIEW = "DYNADEREDIRECTVIEW";
    public static final String DYNADEEDITVIEW2 = "DYNADEEDITVIEW2";
    public static final String DYNADEPICKUPGRIDVIEW = "DYNADEPICKUPGRIDVIEW";
    public static final String DYNADEWFDATAREDIRECTVIEW = "DYNADEWFDATAREDIRECTVIEW";
    public static final String DYNADEWFSTARTVIEW = "DYNADEWFSTARTVIEW";
    public static final String DYNADEWFEXPVIEW = "DYNADEWFEXPVIEW";
    public static final String DYNADEWFACTIONVIEW = "DYNADEWFACTIONVIEW";
    public static final String DYNADEWFEDITVIEW = "DYNADEWFEDITVIEW";
    public static final String DYNADEWFEDITVIEW2 = "DYNADEWFEDITVIEW2";
    public static final String DYNADEWFGRIDVIEW = "DYNADEWFGRIDVIEW";
    public static final String DYNADEWFEDITVIEW3 = "DYNADEWFEDITVIEW3";
    public static final String DYNADEWFPROXYDATAVIEW = "DYNADEWFPROXYDATAVIEW";

    public DynaDEViewTypesCodeListModel() {
        this.initAnnotation(DynaDEViewTypesCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaDEViewTypesCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaDEViewTypesCodeListModel");
    }
}

