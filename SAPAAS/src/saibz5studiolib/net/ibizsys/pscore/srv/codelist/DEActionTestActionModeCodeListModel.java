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

@CodeList(id="1ec577f953549fff18b3979f97e5ce02", name="\u5b9e\u4f53\u884c\u4e3a\u6d4b\u8bd5\u884c\u4e3a\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0\u6d4b\u8bd5\u884c\u4e3a", realtext="\u65e0\u6d4b\u8bd5\u884c\u4e3a"), @CodeItem(value="1", text="\u6709\u6d4b\u8bd5\u884c\u4e3a", realtext="\u6709\u6d4b\u8bd5\u884c\u4e3a"), @CodeItem(value="3", text="\u516c\u5f00\u6d4b\u8bd5\u884c\u4e3a", realtext="\u516c\u5f00\u6d4b\u8bd5\u884c\u4e3a")})
public class DEActionTestActionModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer PROTECTED = 1;
    public static final int INT_PROTECTED = 1;
    public static final Integer PUBLIC = 3;
    public static final int INT_PUBLIC = 3;

    public DEActionTestActionModeCodeListModel() {
        this.initAnnotation(DEActionTestActionModeCodeListModel.class);
        this.setUserData2("DEActionTestActionMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionTestActionModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionTestActionModeCodeListModel");
    }
}

