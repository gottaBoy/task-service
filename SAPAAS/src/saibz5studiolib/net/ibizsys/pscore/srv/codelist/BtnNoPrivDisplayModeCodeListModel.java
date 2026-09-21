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

@CodeList(id="7f7e2d79b87848c1811ac1b520c44061", name="\u65e0\u6743\u9650\u6309\u94ae\u663e\u793a\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u5e94\u7528\u8bbe\u7f6e\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u7981\u7528", realtext="\u7981\u7528"), @CodeItem(value="2", text="\u9690\u85cf", realtext="\u9690\u85cf"), @CodeItem(value="6", text="\u9690\u85cf\u4e14\u9ed8\u8ba4\u9690\u85cf", realtext="\u9690\u85cf\u4e14\u9ed8\u8ba4\u9690\u85cf")})
public class BtnNoPrivDisplayModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer DISABLED = 1;
    public static final int INT_DISABLED = 1;
    public static final Integer HIDE = 2;
    public static final int INT_HIDE = 2;
    public static final Integer HIDEDEFAULT = 6;
    public static final int INT_HIDEDEFAULT = 6;

    public BtnNoPrivDisplayModeCodeListModel() {
        this.initAnnotation(BtnNoPrivDisplayModeCodeListModel.class);
        this.setUserData2("BtnNoPrivDisplayMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BtnNoPrivDisplayModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BtnNoPrivDisplayModeCodeListModel");
    }
}

