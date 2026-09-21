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

@CodeList(id="4D658510-322F-4337-B88B-BAD6ABF2A893", name="\u5b9e\u4f53\u5c5e\u6027\u67e5\u8be2\u7ea7\u522b\uff08\u5e26\u5c5e\u6027\u7ec4\uff09", type="STATIC", userscope=false, emptytext="\uff08\u652f\u6301\u67e5\u8be2\u8f93\u51fa\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u5168\u90e8\u6570\u636e", realtext="\u5168\u90e8\u6570\u636e"), @CodeItem(value="1", text="2\u7ea7\uff08\u65e0\u884c\u5916\u6570\u636e\uff09", realtext="2\u7ea7\uff08\u65e0\u884c\u5916\u6570\u636e\uff09"), @CodeItem(value="2", text="3\u7ea7\uff08\u5173\u952e\u6570\u636e\uff09", realtext="3\u7ea7\uff08\u5173\u952e\u6570\u636e\uff09"), @CodeItem(value="3", text="4\u7ea7\uff08\u4e2a\u522b\u5b57\u6bb5\uff09", realtext="4\u7ea7\uff08\u4e2a\u522b\u5b57\u6bb5\uff09"), @CodeItem(value="100", text="\u6307\u5b9a\u5c5e\u6027\u7ec4", realtext="\u6307\u5b9a\u5c5e\u6027\u7ec4")})
public class DEDataQueryColLevel2CodeListModel
extends StaticCodeListModelBase {
    public static final Integer ALL = 0;
    public static final int INT_ALL = 0;
    public static final Integer LEVEL1 = 1;
    public static final int INT_LEVEL1 = 1;
    public static final Integer LEVEL2 = 2;
    public static final int INT_LEVEL2 = 2;
    public static final Integer LEVEL3 = 3;
    public static final int INT_LEVEL3 = 3;
    public static final Integer DEFGROUP = 100;
    public static final int INT_DEFGROUP = 100;

    public DEDataQueryColLevel2CodeListModel() {
        this.initAnnotation(DEDataQueryColLevel2CodeListModel.class);
        this.setUserData2("DEDataQueryColLevel2");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataQueryColLevel2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataQueryColLevel2CodeListModel");
    }
}

