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

@CodeList(id="59D696FD-3255-4F30-9F92-5A88FAF65204", name="\u6587\u672c\u7ed8\u5236\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TEXT", text="\u6587\u672c", realtext="\u6587\u672c"), @CodeItem(value="HEADING1", text="\u6807\u98981", realtext="\u6807\u98981"), @CodeItem(value="HEADING2", text="\u6807\u98982", realtext="\u6807\u98982"), @CodeItem(value="HEADING3", text="\u6807\u98983", realtext="\u6807\u98983"), @CodeItem(value="HEADING4", text="\u6807\u98984", realtext="\u6807\u98984"), @CodeItem(value="HEADING5", text="\u6807\u98985", realtext="\u6807\u98985"), @CodeItem(value="HEADING6", text="\u6807\u98986", realtext="\u6807\u98986"), @CodeItem(value="PARAGRAPH", text="\u6bb5\u843d", realtext="\u6bb5\u843d")})
public class TextRenderModeCodeListModel
extends StaticCodeListModelBase {
    public static final String TEXT = "TEXT";
    public static final String HEADING1 = "HEADING1";
    public static final String HEADING2 = "HEADING2";
    public static final String HEADING3 = "HEADING3";
    public static final String HEADING4 = "HEADING4";
    public static final String HEADING5 = "HEADING5";
    public static final String HEADING6 = "HEADING6";
    public static final String PARAGRAPH = "PARAGRAPH";

    public TextRenderModeCodeListModel() {
        this.initAnnotation(TextRenderModeCodeListModel.class);
        this.setUserData2("TextRenderMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.TextRenderModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.TextRenderModeCodeListModel");
    }
}

