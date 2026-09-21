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

@CodeList(id="4c3af7ec61e628b2a547bce36b4d79e7", name="\u5185\u5bb9\u5782\u76f4\u5bf9\u9f50\u65b9\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TOP", text="\u4e0a\u5bf9\u9f50", realtext="\u4e0a\u5bf9\u9f50"), @CodeItem(value="MIDDLE", text="\u5c45\u4e2d", realtext="\u5c45\u4e2d"), @CodeItem(value="BOTTOM", text="\u4e0b\u5bf9\u9f50", realtext="\u4e0b\u5bf9\u9f50")})
public class TextVAlignCodeListModel
extends StaticCodeListModelBase {
    public static final String TOP = "TOP";
    public static final String MIDDLE = "MIDDLE";
    public static final String BOTTOM = "BOTTOM";

    public TextVAlignCodeListModel() {
        this.initAnnotation(TextVAlignCodeListModel.class);
        this.setUserData("IGNOREMODELDSLNAME");
        this.setUserData2("TextVAlign");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.TextVAlignCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.TextVAlignCodeListModel");
    }
}

