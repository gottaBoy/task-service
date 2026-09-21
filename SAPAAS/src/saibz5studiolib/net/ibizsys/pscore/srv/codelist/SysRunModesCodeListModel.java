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

@CodeList(id="d10f5699c2beabecba7504dd961669fb", name="\u7cfb\u7edf\u8fd0\u884c\u4f1a\u8bdd\u8fd0\u884c\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="STARTX", text="\u542f\u52a8\u7cfb\u7edf", realtext="\u542f\u52a8\u7cfb\u7edf"), @CodeItem(value="PUBCODE", text="\u4ee3\u7801\u53d1\u5e03", realtext="\u4ee3\u7801\u53d1\u5e03"), @CodeItem(value="PACKVER", text="\u6253\u5305\u7248\u672c", realtext="\u6253\u5305\u7248\u672c"), @CodeItem(value="PACKMOBAPP", text="\u6253\u5305\u79fb\u52a8\u5e94\u7528", realtext="\u6253\u5305\u79fb\u52a8\u5e94\u7528"), @CodeItem(value="STARTMSAPI", text="\u542f\u52a8\u5fae\u670d\u52a1", realtext="\u542f\u52a8\u5fae\u670d\u52a1"), @CodeItem(value="STARTMSAPP", text="\u542f\u52a8\u5fae\u670d\u52a1\u5e94\u7528", realtext="\u542f\u52a8\u5fae\u670d\u52a1\u5e94\u7528"), @CodeItem(value="DEPLOYPKG", text="\u90e8\u7f72\u7cfb\u7edf\u7ec4\u4ef6\u5230\u4ed3\u5e93", realtext="\u90e8\u7f72\u7cfb\u7edf\u7ec4\u4ef6\u5230\u4ed3\u5e93"), @CodeItem(value="STARTMSFUNC", text="\u542f\u52a8\u5fae\u670d\u52a1\u529f\u80fd", realtext="\u542f\u52a8\u5fae\u670d\u52a1\u529f\u80fd"), @CodeItem(value="PUBCODE2", text="\u4ee3\u7801\u53d1\u5e03\uff08\u6a21\u677f\u5f00\u53d1\uff09", realtext="\u4ee3\u7801\u53d1\u5e03\uff08\u6a21\u677f\u5f00\u53d1\uff09"), @CodeItem(value="PUBDOC", text="\u6587\u6863\u53d1\u5e03", realtext="\u6587\u6863\u53d1\u5e03"), @CodeItem(value="PUBMODEL", text="\u6a21\u578b\u53d1\u5e03", realtext="\u6a21\u578b\u53d1\u5e03")})
public class SysRunModesCodeListModel
extends StaticCodeListModelBase {
    public static final String STARTX = "STARTX";
    public static final String PUBCODE = "PUBCODE";
    public static final String PACKVER = "PACKVER";
    public static final String PACKMOBAPP = "PACKMOBAPP";
    public static final String STARTMSAPI = "STARTMSAPI";
    public static final String STARTMSAPP = "STARTMSAPP";
    public static final String DEPLOYPKG = "DEPLOYPKG";
    public static final String STARTMSFUNC = "STARTMSFUNC";
    public static final String PUBCODE2 = "PUBCODE2";
    public static final String PUBDOC = "PUBDOC";
    public static final String PUBMODEL = "PUBMODEL";

    public SysRunModesCodeListModel() {
        this.initAnnotation(SysRunModesCodeListModel.class);
        this.setUserData2("SysRunMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysRunModesCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysRunModesCodeListModel");
    }
}

