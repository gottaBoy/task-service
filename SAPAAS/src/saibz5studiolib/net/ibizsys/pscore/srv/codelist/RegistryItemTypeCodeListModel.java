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

@CodeList(id="4EFDD2B3-C10F-436A-98BB-1445C2891F0C", name="\u955c\u50cf\u9879\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="api", text="\u670d\u52a1\u63a5\u53e3", realtext="\u670d\u52a1\u63a5\u53e3"), @CodeItem(value="app", text="\u524d\u7aef\u5e94\u7528", realtext="\u524d\u7aef\u5e94\u7528"), @CodeItem(value="psmodeltool", text="\u6a21\u578b\u5de5\u5177", realtext="\u6a21\u578b\u5de5\u5177"), @CodeItem(value="codegen", text="\u4ee3\u7801\u4ea7\u751f", realtext="\u4ee3\u7801\u4ea7\u751f"), @CodeItem(value="codeserver", text="\u4ee3\u7801\u670d\u52a1\u5668", realtext="\u4ee3\u7801\u670d\u52a1\u5668"), @CodeItem(value="user", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="user2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="user3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="user4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class RegistryItemTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String API = "api";
    public static final String APP = "app";
    public static final String PSMODELTOOL = "psmodeltool";
    public static final String CODEGEN = "codegen";
    public static final String CODESERVER = "codeserver";
    public static final String USER = "user";
    public static final String USER2 = "user2";
    public static final String USER3 = "user3";
    public static final String USER4 = "user4";

    public RegistryItemTypeCodeListModel() {
        this.initAnnotation(RegistryItemTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.RegistryItemTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.RegistryItemTypeCodeListModel");
    }
}

