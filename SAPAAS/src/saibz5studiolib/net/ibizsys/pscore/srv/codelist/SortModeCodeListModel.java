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

@CodeList(id="520e5f778eb72e6038bd256f6bd5721c", name="\u8868\u683c\u6392\u5e8f\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="REMOTE", text="\u8fdc\u7a0b\u6392\u5e8f", realtext="\u8fdc\u7a0b\u6392\u5e8f", userdata="\u5c06\u6392\u5e8f\u4fe1\u606f\u53d1\u9001\u5230\u540e\u53f0\u7531\u540e\u53f0\u5bf9\u5168\u90e8\u6570\u636e\u8fdb\u884c\u6392\u5e8f"), @CodeItem(value="LOCAL", text="\u672c\u5730\u6392\u5e8f", realtext="\u672c\u5730\u6392\u5e8f", userdata="\u524d\u7aef\u5bf9\u5f53\u524d\u52a0\u8f7d\u7684\u6570\u636e\u8fdb\u884c\u6392\u5e8f\u5904\u7406")})
public class SortModeCodeListModel
extends StaticCodeListModelBase {
    public static final String REMOTE = "REMOTE";
    public static final String LOCAL = "LOCAL";

    public SortModeCodeListModel() {
        this.initAnnotation(SortModeCodeListModel.class);
        this.setUserData2("SortMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SortModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SortModeCodeListModel");
    }
}

