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

@CodeList(id="0d42dee2ce63943fc569098f9a96f0ab", name="\u8868\u5355\u6570\u636e\u5173\u7cfb\u90e8\u4ef6\u5237\u65b0\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u5ffd\u7565\u52a0\u8f7d", realtext="\u5ffd\u7565\u52a0\u8f7d"), @CodeItem(value="2", text="\u5ffd\u7565\u4fdd\u5b58", realtext="\u5ffd\u7565\u4fdd\u5b58"), @CodeItem(value="4", text="\u9644\u52a0\u754c\u9762\u5237\u65b0\u9879\u53ea\u8d4b\u503c\u4e0d\u5237\u65b0", realtext="\u9644\u52a0\u754c\u9762\u5237\u65b0\u9879\u53ea\u8d4b\u503c\u4e0d\u5237\u65b0")})
public class FormDRPartRefreshIgnoreActionCodeListModel
extends StaticCodeListModelBase {
    public static final Integer LOAD = 1;
    public static final int INT_LOAD = 1;
    public static final Integer SAVE = 2;
    public static final int INT_SAVE = 2;
    public static final Integer REFRESHITEMSSETPARAMONLY = 4;
    public static final int INT_REFRESHITEMSSETPARAMONLY = 4;

    public FormDRPartRefreshIgnoreActionCodeListModel() {
        this.initAnnotation(FormDRPartRefreshIgnoreActionCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FormDRPartRefreshIgnoreActionCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FormDRPartRefreshIgnoreActionCodeListModel");
    }
}

