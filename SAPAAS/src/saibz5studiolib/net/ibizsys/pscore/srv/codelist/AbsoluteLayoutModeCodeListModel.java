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

@CodeList(id="819036b0c304bec53f3098d809547ec6", name="\u7edd\u5bf9\u5e03\u5c40\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="LTWH", text="\u5de6\u4e0a\u89d2+\u5bbd\u9ad8", realtext="\u5de6\u4e0a\u89d2+\u5bbd\u9ad8"), @CodeItem(value="LTRB", text="\u5de6\u4e0a\u89d2+\u53f3\u4e0b\u89d2", realtext="\u5de6\u4e0a\u89d2+\u53f3\u4e0b\u89d2"), @CodeItem(value="RBWH", text="\u53f3\u4e0b\u89d2+\u5bbd\u9ad8", realtext="\u53f3\u4e0b\u89d2+\u5bbd\u9ad8")})
public class AbsoluteLayoutModeCodeListModel
extends StaticCodeListModelBase {
    public static final String LTWH = "LTWH";
    public static final String LTRB = "LTRB";
    public static final String RBWH = "RBWH";

    public AbsoluteLayoutModeCodeListModel() {
        this.initAnnotation(AbsoluteLayoutModeCodeListModel.class);
        this.setUserData2("AbsoluteLayoutPos");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AbsoluteLayoutModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AbsoluteLayoutModeCodeListModel");
    }
}

