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

@CodeList(id="a76eecf8e283763b30979cc898a0e71c", name="\u5b9e\u4f53\u5173\u7cfb\u5c5e\u6027\u7ee7\u627f\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u5ffd\u7565\u7ee7\u627f\u6307\u5b9a\u5c5e\u6027", realtext="\u5ffd\u7565\u7ee7\u627f\u6307\u5b9a\u5c5e\u6027"), @CodeItem(value="2", text="\u7ee7\u627f\u6307\u5b9a\u5c5e\u6027", realtext="\u7ee7\u627f\u6307\u5b9a\u5c5e\u6027")})
public class DEFDERInheritModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer IGNOREINHERIT = 1;
    public static final int INT_IGNOREINHERIT = 1;
    public static final Integer INHERIT = 2;
    public static final int INT_INHERIT = 2;

    public DEFDERInheritModeCodeListModel() {
        this.initAnnotation(DEFDERInheritModeCodeListModel.class);
        this.setUserData2("DERDEFInheritMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFDERInheritModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFDERInheritModeCodeListModel");
    }
}

