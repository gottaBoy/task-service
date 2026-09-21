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

@CodeList(id="80580401777c9d7d486aef2caf8df0fd", name="\u5b57\u4f53\u6837\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u7c97\u4f53", realtext="\u7c97\u4f53"), @CodeItem(value="2", text="\u659c\u4f53", realtext="\u659c\u4f53"), @CodeItem(value="4", text="\u4e0b\u5212\u7ebf", realtext="\u4e0b\u5212\u7ebf")})
public class FontStyleCodeListModel
extends StaticCodeListModelBase {
    public static final Integer BOLD = 1;
    public static final int INT_BOLD = 1;
    public static final Integer ITALIC = 2;
    public static final int INT_ITALIC = 2;
    public static final Integer UNDERLINE = 4;
    public static final int INT_UNDERLINE = 4;

    public FontStyleCodeListModel() {
        this.initAnnotation(FontStyleCodeListModel.class);
        this.setUserData2("FontStyle");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FontStyleCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FontStyleCodeListModel");
    }
}

