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

@CodeList(id="0931B067-095C-4B45-A853-B7B05AF06AAB", name="\u5b9e\u4f53\u63a5\u53e3\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u4e3b\u63a5\u53e3", realtext="\u4e3b\u63a5\u53e3", userdata="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u4e3a\u9876\u7ea7\u8d44\u6e90\uff0c\u652f\u6301\u72ec\u7acb\u63d0\u4f9b\u8d44\u6e90\u8bbf\u95ee\u80fd\u529b"), @CodeItem(value="0", text="\u4ece\u63a5\u53e3", realtext="\u4ece\u63a5\u53e3", userdata="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u4e3a\u975e\u9876\u7ea7\u8d44\u6e90\uff0c\u5fc5\u987b\u4f5c\u4e3a\u9876\u7ea7\u8d44\u6e90\u7684\u6210\u5458\u63d0\u4f9b\u80fd\u529b"), @CodeItem(value="9", text="\u6570\u636e\u4f20\u8f93\u5bf9\u8c61\uff08DTO\uff09\u5d4c\u5957\u6210\u5458", realtext="\u6570\u636e\u4f20\u8f93\u5bf9\u8c61\uff08DTO\uff09\u5d4c\u5957\u6210\u5458", userdata="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u4e0d\u63d0\u4f9b\u80fd\u529b\uff0c\u4ec5\u4f5c\u4e3a\u5176\u5b83\u63a5\u53e3\u4f20\u8f93\u5bf9\u8c61\u7684\u6570\u636e\u7ed3\u6784\u6210\u5458")})
public class DESAModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer MAJOR = 1;
    public static final int INT_MAJOR = 1;
    public static final Integer MINOR = 0;
    public static final int INT_MINOR = 0;
    public static final Integer NESTED = 9;
    public static final int INT_NESTED = 9;

    public DESAModeCodeListModel() {
        this.initAnnotation(DESAModeCodeListModel.class);
        this.setUserData2("SADEMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DESAModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DESAModeCodeListModel");
    }
}

