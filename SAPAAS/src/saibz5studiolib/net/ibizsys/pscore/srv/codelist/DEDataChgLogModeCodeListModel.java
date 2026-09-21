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

@CodeList(id="9721c4629990f97c4ab7d30de5ff095f", name="\u5b9e\u4f53\u6570\u636e\u53d8\u66f4\u65e5\u5fd7\u7c7b\u578b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="0", text="\u65e0\u65e5\u5fd7", realtext="\u65e0\u65e5\u5fd7"), @CodeItem(value="2", text="\u5355\u9879\u6570\u636e\uff08\u540c\u6b65\uff09", realtext="\u5355\u9879\u6570\u636e\uff08\u540c\u6b65\uff09", userdata="\u4ee5\u540c\u6b65\u7684\u65b9\u5f0f\u65e5\u5fd7\u5f53\u524d\u6570\u636e\u7684\u53d8\u66f4\u8bb0\u5f55\uff0c\u65e5\u5fd7\u64cd\u4f5c\u5728\u540c\u4e00\u4e2a\u4e8b\u52a1\u4e2d"), @CodeItem(value="3", text="\u5355\u9879\u6570\u636e\uff08\u542b\u5173\u8054\u6570\u636e\uff09\uff08\u540c\u6b65\uff09", realtext="\u5355\u9879\u6570\u636e\uff08\u542b\u5173\u8054\u6570\u636e\uff09\uff08\u540c\u6b65\uff09", userdata="\u4ee5\u540c\u6b65\u7684\u65b9\u5f0f\u65e5\u5fd7\u5f53\u524d\u6570\u636e\u7684\u53d8\u66f4\u8bb0\u5f55\uff0c\u5305\u62ec\u5173\u8054\u6570\u636e\uff0c\u65e5\u5fd7\u64cd\u4f5c\u5728\u540c\u4e00\u4e2a\u4e8b\u52a1\u4e2d"), @CodeItem(value="4", text="\u5355\u9879\u6570\u636e\uff08\u5f02\u6b65\uff09", realtext="\u5355\u9879\u6570\u636e\uff08\u5f02\u6b65\uff09", userdata="\u4ee5\u5f02\u6b65\u7684\u65b9\u5f0f\u65e5\u5fd7\u5f53\u524d\u6570\u636e\u7684\u53d8\u66f4\u8bb0\u5f55\uff0c\u6027\u80fd\u66f4\u4f18\uff0c\u4f46\u5b58\u5728\u65e5\u5fd7\u4e0e\u6570\u636e\u4e0d\u4e00\u81f4\u7684\u60c5\u51b5"), @CodeItem(value="5", text="\u5355\u9879\u6570\u636e\uff08\u542b\u5173\u8054\u6570\u636e\uff09\uff08\u5f02\u6b65\uff09", realtext="\u5355\u9879\u6570\u636e\uff08\u542b\u5173\u8054\u6570\u636e\uff09\uff08\u5f02\u6b65\uff09", userdata="\u4ee5\u5f02\u6b65\u7684\u65b9\u5f0f\u65e5\u5fd7\u5f53\u524d\u6570\u636e\u7684\u53d8\u66f4\u8bb0\u5f55\uff0c\u5305\u62ec\u5173\u8054\u6570\u636e\uff0c\u6027\u80fd\u66f4\u4f18\uff0c\u4f46\u5b58\u5728\u65e5\u5fd7\u4e0e\u6570\u636e\u4e0d\u4e00\u81f4\u7684\u60c5\u51b5")})
public class DEDataChgLogModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer SELF_SYNC = 2;
    public static final int INT_SELF_SYNC = 2;
    public static final Integer SELF_RELATED_SYNC = 3;
    public static final int INT_SELF_RELATED_SYNC = 3;
    public static final Integer SELF_ASYNC = 4;
    public static final int INT_SELF_ASYNC = 4;
    public static final Integer SELF_RELATED_ASYNC = 5;
    public static final int INT_SELF_RELATED_ASYNC = 5;

    public DEDataChgLogModeCodeListModel() {
        this.initAnnotation(DEDataChgLogModeCodeListModel.class);
        this.setUserData2("DEDataChgLogMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataChgLogModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataChgLogModeCodeListModel");
    }
}

