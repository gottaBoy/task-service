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

@CodeList(id="18bd60ef1be135a69c1aaa6c7e159ce2", name="\u5e94\u7528\u63d2\u4ef6\u6a21\u677f\u4ee3\u7801", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="CODE", text="\u4ee3\u7801", realtext="\u4ee3\u7801"), @CodeItem(value="CODE2", text="\u4ee3\u78012", realtext="\u4ee3\u78012"), @CodeItem(value="CODE3", text="\u4ee3\u78013", realtext="\u4ee3\u78013"), @CodeItem(value="CODE4", text="\u4ee3\u78014", realtext="\u4ee3\u78014")})
public class PITemplCodeCodeListModel
extends StaticCodeListModelBase {
    public static final String CODE = "CODE";
    public static final String CODE2 = "CODE2";
    public static final String CODE3 = "CODE3";
    public static final String CODE4 = "CODE4";

    public PITemplCodeCodeListModel() {
        this.initAnnotation(PITemplCodeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PITemplCodeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PITemplCodeCodeListModel");
    }
}

