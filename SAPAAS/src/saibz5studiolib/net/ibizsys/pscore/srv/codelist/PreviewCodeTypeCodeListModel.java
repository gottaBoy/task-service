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

@CodeList(id="477d5b46358b32fd624625360b79d1cd", name="\u9884\u89c8\u4ee3\u7801\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="CODE1", text="\u4ee3\u78011", realtext="\u4ee3\u78011"), @CodeItem(value="CODE2", text="\u4ee3\u78012", realtext="\u4ee3\u78012"), @CodeItem(value="CODE3", text="\u4ee3\u78013", realtext="\u4ee3\u78013"), @CodeItem(value="CODE4", text="\u4ee3\u78014", realtext="\u4ee3\u78014")})
public class PreviewCodeTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String CODE1 = "CODE1";
    public static final String CODE2 = "CODE2";
    public static final String CODE3 = "CODE3";
    public static final String CODE4 = "CODE4";

    public PreviewCodeTypeCodeListModel() {
        this.initAnnotation(PreviewCodeTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PreviewCodeTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PreviewCodeTypeCodeListModel");
    }
}

