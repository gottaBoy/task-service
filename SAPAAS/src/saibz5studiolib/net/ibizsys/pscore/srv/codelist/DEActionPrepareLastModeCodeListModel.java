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

@CodeList(id="E05262E0-8159-4883-AD8B-B582112294FB", name="\u5b9e\u4f53\u884c\u4e3a\u51c6\u5907\u4e0a\u6b21\u6570\u636e\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u51c6\u5907", realtext="\u4e0d\u51c6\u5907"), @CodeItem(value="1", text="\u51c6\u5907", realtext="\u51c6\u5907"), @CodeItem(value="2", text="\u51c6\u5907\u5e76\u586b\u5145", realtext="\u51c6\u5907\u5e76\u586b\u5145", userdata="\u51c6\u5907\u4e0a\u4e00\u6b21\u7684\u6570\u636e\u5e76\u5c06\u5199\u56de\u6570\u636e\u5bf9\u8c61\u672a\u63d0\u4f9b\u7684\u5c5e\u6027")})
public class DEActionPrepareLastModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer DISABLED = 0;
    public static final int INT_DISABLED = 0;
    public static final Integer ENABLED = 1;
    public static final int INT_ENABLED = 1;
    public static final Integer FILLED = 2;
    public static final int INT_FILLED = 2;

    public DEActionPrepareLastModeCodeListModel() {
        this.initAnnotation(DEActionPrepareLastModeCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("DEActionPrepareLastMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionPrepareLastModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionPrepareLastModeCodeListModel");
    }
}

