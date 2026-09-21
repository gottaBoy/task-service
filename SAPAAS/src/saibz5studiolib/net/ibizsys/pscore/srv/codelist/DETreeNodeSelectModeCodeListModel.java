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

@CodeList(id="99C355A1-4609-40E3-86C7-13A27F84189A", name="\u6811\u89c6\u56fe\u8282\u70b9\u9009\u62e9\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u5426", realtext="\u5426", userdata="\u4e0d\u9009\u62e9\u8282\u70b9"), @CodeItem(value="1", text="\u662f", realtext="\u662f", userdata="\u81ea\u52a8\u9009\u62e9\u8282\u70b9"), @CodeItem(value="2", text="\u662f\uff0c\u4ec5\u9996\u8282\u70b9", realtext="\u662f\uff0c\u4ec5\u9996\u8282\u70b9", userdata="\u81ea\u52a8\u9009\u62e9\u9996\u8282\u70b9")})
public class DETreeNodeSelectModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NO = 0;
    public static final int INT_NO = 0;
    public static final Integer YES = 1;
    public static final int INT_YES = 1;
    public static final Integer FIRSTONLY = 2;
    public static final int INT_FIRSTONLY = 2;

    public DETreeNodeSelectModeCodeListModel() {
        this.initAnnotation(DETreeNodeSelectModeCodeListModel.class);
        this.setUserData2("TreeNodeSelectMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DETreeNodeSelectModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DETreeNodeSelectModeCodeListModel");
    }
}

