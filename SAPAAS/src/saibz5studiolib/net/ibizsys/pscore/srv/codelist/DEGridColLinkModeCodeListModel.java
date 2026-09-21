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

@CodeList(id="b071287db9f83520a4b2f4b51a88f613", name="\u5b9e\u4f53\u8868\u683c\u94fe\u63a5\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u542f\u7528", realtext="\u4e0d\u542f\u7528"), @CodeItem(value="1", text="\u542f\u7528", realtext="\u542f\u7528"), @CodeItem(value="2", text="\u542f\u7528\uff08\u81ea\u52a8\u5224\u65ad\uff09", realtext="\u542f\u7528\uff08\u81ea\u52a8\u5224\u65ad\uff09", userdata="\u5982\u679c\u8868\u683c\u5217\u5b58\u5728\u94fe\u63a5\u89c6\u56fe\u5219\u542f\u7528\uff0c\u5426\u5219\u4e0d\u542f\u7528")})
public class DEGridColLinkModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer DISABLE = 0;
    public static final int INT_DISABLE = 0;
    public static final Integer ENABLE = 1;
    public static final int INT_ENABLE = 1;
    public static final Integer AUTO = 2;
    public static final int INT_AUTO = 2;

    public DEGridColLinkModeCodeListModel() {
        this.initAnnotation(DEGridColLinkModeCodeListModel.class);
        this.setUserData2("DEGridColLinkMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridColLinkModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridColLinkModeCodeListModel");
    }
}

