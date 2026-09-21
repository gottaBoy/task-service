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

@CodeList(id="A685A913-1FBD-40A7-9AB0-25EC015C5F57", name="\u90e8\u4ef6\u754c\u9762\u5f15\u64ce\uff08\u5168\u90e8\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="LOADANDSEARCH", text="\u641c\u7d22\u90e8\u4ef6\u52a0\u8f7d\u5e76\u641c\u7d22\uff08\u53c2\u6570\u53ef\u6307\u5b9a\u89e6\u53d1\u90e8\u4ef6\uff09", realtext="\u641c\u7d22\u90e8\u4ef6\u52a0\u8f7d\u5e76\u641c\u7d22\uff08\u53c2\u6570\u53ef\u6307\u5b9a\u89e6\u53d1\u90e8\u4ef6\uff09"), @CodeItem(value="LOADTRIGGER", text="\u90e8\u4ef6\u52a0\u8f7d\uff08\u53c2\u6570\u53ef\u6307\u5b9a\u89e6\u53d1\u90e8\u4ef6\uff09", realtext="\u90e8\u4ef6\u52a0\u8f7d\uff08\u53c2\u6570\u53ef\u6307\u5b9a\u89e6\u53d1\u90e8\u4ef6\uff09")})
public class ViewCtrlRefUsageAllCodeListModel
extends StaticCodeListModelBase {
    public static final String LOADANDSEARCH = "LOADANDSEARCH";
    public static final String LOADTRIGGER = "LOADTRIGGER";

    public ViewCtrlRefUsageAllCodeListModel() {
        this.initAnnotation(ViewCtrlRefUsageAllCodeListModel.class);
        this.setUserData2("ViewCtrlRefUsageAll");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewCtrlRefUsageAllCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewCtrlRefUsageAllCodeListModel");
    }
}

