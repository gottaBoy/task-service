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

@CodeList(id="c3d4db7e92d099ceeebbb2d07967f697", name="\u7f16\u8f91\u9879\u9ed8\u8ba4\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u53ea\u8bfb", realtext="\u53ea\u8bfb"), @CodeItem(value="2", text="\u7981\u7528", realtext="\u7981\u7528")})
public class PanelFieldStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer READONLY = 1;
    public static final int INT_READONLY = 1;
    public static final Integer DISABLED = 2;
    public static final int INT_DISABLED = 2;

    public PanelFieldStateCodeListModel() {
        this.initAnnotation(PanelFieldStateCodeListModel.class);
        this.setUserData2("PanelFieldState");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelFieldStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelFieldStateCodeListModel");
    }
}

