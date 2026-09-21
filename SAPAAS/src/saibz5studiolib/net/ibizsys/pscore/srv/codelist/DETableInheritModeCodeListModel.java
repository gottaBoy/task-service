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

@CodeList(id="1f4f6720ff3351844a3e1b1d08464f96", name="\u5b9e\u4f53\u6570\u636e\u8868\u5217\u7ee7\u627f\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u5ffd\u7565\u7ee7\u627f\u6307\u5b9a\u5217", realtext="\u5ffd\u7565\u7ee7\u627f\u6307\u5b9a\u5217"), @CodeItem(value="2", text="\u7ee7\u627f\u6307\u5b9a\u5217", realtext="\u7ee7\u627f\u6307\u5b9a\u5217")})
public class DETableInheritModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer EXCLUDE = 1;
    public static final int INT_EXCLUDE = 1;
    public static final Integer INCLUDE = 2;
    public static final int INT_INCLUDE = 2;

    public DETableInheritModeCodeListModel() {
        this.initAnnotation(DETableInheritModeCodeListModel.class);
        this.setUserData2("TableColInheritMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DETableInheritModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DETableInheritModeCodeListModel");
    }
}

