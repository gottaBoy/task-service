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

@CodeList(id="C602C88E-2121-4254-B299-A1294896D747", name="\u7f16\u8f91\u89c6\u56fe\u6807\u8bb0\u6253\u5f00\u6570\u636e\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="STR", valueseparator=";", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="OPENDATA", text="\u767b\u8bb0\u6253\u5f00\u6570\u636e", realtext="\u767b\u8bb0\u6253\u5f00\u6570\u636e"), @CodeItem(value="EDITDATA", text="\u767b\u8bb0\u66f4\u65b0\u6570\u636e", realtext="\u767b\u8bb0\u66f4\u65b0\u6570\u636e"), @CodeItem(value="DISPLAYOPPERSON", text="\u663e\u793a\u64cd\u4f5c\u4eba\u5458", realtext="\u663e\u793a\u64cd\u4f5c\u4eba\u5458"), @CodeItem(value="NOTICERELOAD", text="\u63d0\u793a\u5237\u65b0\u6570\u636e", realtext="\u63d0\u793a\u5237\u65b0\u6570\u636e")})
public class EditViewMarkOpenDataModeCodeListModel
extends StaticCodeListModelBase {
    public static final String OPENDATA = "OPENDATA";
    public static final String EDITDATA = "EDITDATA";
    public static final String DISPLAYOPPERSON = "DISPLAYOPPERSON";
    public static final String NOTICERELOAD = "NOTICERELOAD";

    public EditViewMarkOpenDataModeCodeListModel() {
        this.initAnnotation(EditViewMarkOpenDataModeCodeListModel.class);
        this.setUserData2("EditViewMarkOpenDataMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.EditViewMarkOpenDataModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.EditViewMarkOpenDataModeCodeListModel");
    }
}

