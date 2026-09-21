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

@CodeList(id="039f22c2c1e67274086074ea31a039ae", name="\u52a8\u6001\u7cfb\u7edf\u5f15\u7528\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u672a\u5f15\u7528", realtext="\u672a\u5f15\u7528"), @CodeItem(value="1", text="\u52a8\u6001\u7cfb\u7edf\u5f15\u7528", realtext="\u52a8\u6001\u7cfb\u7edf\u5f15\u7528"), @CodeItem(value="2", text="\u52a8\u6001\u7cfb\u7edf\u5b9e\u4f8b\u5f15\u7528", realtext="\u52a8\u6001\u7cfb\u7edf\u5b9e\u4f8b\u5f15\u7528")})
public class DynaSysRefModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer DYNASYS = 1;
    public static final int INT_DYNASYS = 1;
    public static final Integer DYNASYSINST = 2;
    public static final int INT_DYNASYSINST = 2;

    public DynaSysRefModeCodeListModel() {
        this.initAnnotation(DynaSysRefModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaSysRefModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaSysRefModeCodeListModel");
    }
}

