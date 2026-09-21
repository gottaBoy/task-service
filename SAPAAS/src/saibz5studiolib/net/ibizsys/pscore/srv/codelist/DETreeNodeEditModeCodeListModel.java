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

@CodeList(id="6E12F0B0-6858-4B99-98AC-5ABCB855E120", name="\u5b9e\u4f53\u6811\u8282\u70b9\u7f16\u8f91\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u540d\u79f0", realtext="\u540d\u79f0"), @CodeItem(value="2", text="\u62d6\u52a8", realtext="\u62d6\u52a8"), @CodeItem(value="4", text="\u62d6\u5165", realtext="\u62d6\u5165"), @CodeItem(value="8", text="\u6392\u5e8f", realtext="\u6392\u5e8f"), @CodeItem(value="16", text="\u884c\u7f16\u8f91", realtext="\u884c\u7f16\u8f91"), @CodeItem(value="2064", text="\u884c\u7f16\u8f91\uff08\u4ec5\u63d0\u4ea4\u53d8\u5316\u503c\uff09", realtext="\u884c\u7f16\u8f91\uff08\u4ec5\u63d0\u4ea4\u53d8\u5316\u503c\uff09")})
public class DETreeNodeEditModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer TEXT = 1;
    public static final int INT_TEXT = 1;
    public static final Integer DRAG = 2;
    public static final int INT_DRAG = 2;
    public static final Integer DROP = 4;
    public static final int INT_DROP = 4;
    public static final Integer ORDER = 8;
    public static final int INT_ORDER = 8;
    public static final Integer ROWEDIT = 16;
    public static final int INT_ROWEDIT = 16;
    public static final Integer ROWEDITCHANGEDONLY = 2064;
    public static final int INT_ROWEDITCHANGEDONLY = 2064;

    public DETreeNodeEditModeCodeListModel() {
        this.initAnnotation(DETreeNodeEditModeCodeListModel.class);
        this.setUserData2("TreeNodeEditMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DETreeNodeEditModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DETreeNodeEditModeCodeListModel");
    }
}

