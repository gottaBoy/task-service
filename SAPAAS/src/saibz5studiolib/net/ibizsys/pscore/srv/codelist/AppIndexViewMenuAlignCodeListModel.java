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

@CodeList(id="82f6d9b125aed5ee361df46d2b33b974", name="\u5e94\u7528\u9996\u9875\u89c6\u56fe\u4e3b\u83dc\u5355\u65b9\u5411", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="LEFT", text="\u5de6\u4fa7", realtext="\u5de6\u4fa7"), @CodeItem(value="TOP", text="\u4e0a\u65b9", realtext="\u4e0a\u65b9"), @CodeItem(value="CENTER", text="\u4e2d\u95f4", realtext="\u4e2d\u95f4"), @CodeItem(value="TREEEXP", text="\u6811\u5bfc\u822a", realtext="\u6811\u5bfc\u822a"), @CodeItem(value="TABEXP_TOP", text="\u5206\u9875\u5bfc\u822a\uff08\u4e0a\u65b9\u5206\u9875\uff09", realtext="\u5206\u9875\u5bfc\u822a\uff08\u4e0a\u65b9\u5206\u9875\uff09"), @CodeItem(value="TABEXP_LEFT", text="\u5206\u9875\u5bfc\u822a\uff08\u5de6\u4fa7\u5206\u9875\uff09", realtext="\u5206\u9875\u5bfc\u822a\uff08\u5de6\u4fa7\u5206\u9875\uff09"), @CodeItem(value="TABEXP_BOTTOM", text="\u5206\u9875\u5bfc\u822a\uff08\u4e0b\u65b9\u5206\u9875\uff09", realtext="\u5206\u9875\u5bfc\u822a\uff08\u4e0b\u65b9\u5206\u9875\uff09"), @CodeItem(value="TABEXP_RIGHT", text="\u5206\u9875\u5bfc\u822a\uff08\u53f3\u4fa7\u5206\u9875\uff09", realtext="\u5206\u9875\u5bfc\u822a\uff08\u53f3\u4fa7\u5206\u9875\uff09"), @CodeItem(value="NONE", text="\u4e0d\u663e\u793a", realtext="\u4e0d\u663e\u793a")})
public class AppIndexViewMenuAlignCodeListModel
extends StaticCodeListModelBase {
    public static final String LEFT = "LEFT";
    public static final String TOP = "TOP";
    public static final String CENTER = "CENTER";
    public static final String TREEEXP = "TREEEXP";
    public static final String TABEXP_TOP = "TABEXP_TOP";
    public static final String TABEXP_LEFT = "TABEXP_LEFT";
    public static final String TABEXP_BOTTOM = "TABEXP_BOTTOM";
    public static final String TABEXP_RIGHT = "TABEXP_RIGHT";
    public static final String NONE = "NONE";

    public AppIndexViewMenuAlignCodeListModel() {
        this.initAnnotation(AppIndexViewMenuAlignCodeListModel.class);
        this.setUserData2("AppIndexViewMenuAlign");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppIndexViewMenuAlignCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppIndexViewMenuAlignCodeListModel");
    }
}

