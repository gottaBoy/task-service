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

@CodeList(id="46a80d3c449cb2dfe4ea799535386576", name="\u5b9e\u4f53\u884c\u4e3a\u6a21\u677f\u9884\u7f6e\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="CREATE", text="\u5efa\u7acb\u6570\u636e", realtext="\u5efa\u7acb\u6570\u636e"), @CodeItem(value="UPDATE", text="\u66f4\u65b0\u6570\u636e", realtext="\u66f4\u65b0\u6570\u636e"), @CodeItem(value="REMOVE", text="\u5220\u9664\u6570\u636e", realtext="\u5220\u9664\u6570\u636e")})
public class DEActionPDTTemplCodeListModel
extends StaticCodeListModelBase {
    public static final String CREATE = "CREATE";
    public static final String UPDATE = "UPDATE";
    public static final String REMOVE = "REMOVE";

    public DEActionPDTTemplCodeListModel() {
        this.initAnnotation(DEActionPDTTemplCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionPDTTemplCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionPDTTemplCodeListModel");
    }
}

