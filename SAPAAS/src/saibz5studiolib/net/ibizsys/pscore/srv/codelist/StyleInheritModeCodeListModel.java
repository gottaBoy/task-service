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

@CodeList(id="94c53ec1f77a4003b9e07dc30b7d0496", name="\u6837\u5f0f\u7ee7\u627f\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u7ee7\u627f\u5e76\u66ff\u6362", realtext="\u7ee7\u627f\u5e76\u66ff\u6362"), @CodeItem(value="2", text="\u4f7f\u7528\u81ea\u8eab\u5b9a\u4e49", realtext="\u4f7f\u7528\u81ea\u8eab\u5b9a\u4e49")})
public class StyleInheritModeCodeListModel
extends StaticCodeListModelBase {
    public static final String INHERIT = "1";
    public static final String SELF = "2";

    public StyleInheritModeCodeListModel() {
        this.initAnnotation(StyleInheritModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.StyleInheritModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.StyleInheritModeCodeListModel");
    }
}

