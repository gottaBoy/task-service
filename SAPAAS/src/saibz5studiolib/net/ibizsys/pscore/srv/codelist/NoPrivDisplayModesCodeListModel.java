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

@CodeList(id="603e5db08c6e66d759f1527f8648980e", name="\u65e0\u6743\u9650\u5185\u5bb9\u663e\u793a\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u663e\u793a\u7a7a\u6216*\u5185\u5bb9", realtext="\u663e\u793a\u7a7a\u6216*\u5185\u5bb9"), @CodeItem(value="2", text="\u9690\u85cf", realtext="\u9690\u85cf")})
public class NoPrivDisplayModesCodeListModel
extends StaticCodeListModelBase {
    public static final Integer EMPTY = 1;
    public static final int INT_EMPTY = 1;
    public static final Integer HIDE = 2;
    public static final int INT_HIDE = 2;

    public NoPrivDisplayModesCodeListModel() {
        this.initAnnotation(NoPrivDisplayModesCodeListModel.class);
        this.setUserData2("NoPrivDisplayMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.NoPrivDisplayModesCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.NoPrivDisplayModesCodeListModel");
    }
}

