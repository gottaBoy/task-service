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

@CodeList(id="563afc07d80ac04f78ec514ddd14f6a7", name="\u96c6\u6210\u5143\u7d20\u5f15\u7528\u5143\u7d20\u6392\u5e8f\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="ALL", text="\u5168\u90e8\uff08\u968f\u673a\u6b21\u5e8f\uff0c\u53ea\u80fd\u51fa\u73b0\u4e00\u6b21\uff09", realtext="\u5168\u90e8\uff08\u968f\u673a\u6b21\u5e8f\uff0c\u53ea\u80fd\u51fa\u73b0\u4e00\u6b21\uff09"), @CodeItem(value="CHOICE", text="\u9009\u62e9\u4e00\u9879", realtext="\u9009\u62e9\u4e00\u9879"), @CodeItem(value="SEQUENCE", text="\u6309\u6b21\u5e8f", realtext="\u6309\u6b21\u5e8f")})
public class EAIElementREOrderModeCodeListModel
extends StaticCodeListModelBase {
    public static final String ALL = "ALL";
    public static final String CHOICE = "CHOICE";
    public static final String SEQUENCE = "SEQUENCE";

    public EAIElementREOrderModeCodeListModel() {
        this.initAnnotation(EAIElementREOrderModeCodeListModel.class);
        this.setUserData2("EAIElementREOrderMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.EAIElementREOrderModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.EAIElementREOrderModeCodeListModel");
    }
}

