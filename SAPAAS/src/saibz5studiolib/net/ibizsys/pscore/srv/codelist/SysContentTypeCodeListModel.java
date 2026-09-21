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

@CodeList(id="3239e2651f3cedcbe3f7517bc3d5743f", name="\u7cfb\u7edf\u5185\u5bb9\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="RAW", text="\u76f4\u63a5\u5185\u5bb9", realtext="\u76f4\u63a5\u5185\u5bb9", userdata="\u5185\u5bb9\u4e3a\u76f4\u63a5\u6587\u672c"), @CodeItem(value="HTML", text="Html\u5185\u5bb9", realtext="Html\u5185\u5bb9", userdata="\u5185\u5bb9\u4e3aHTML\u6587\u672c")})
public class SysContentTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String RAW = "RAW";
    public static final String HTML = "HTML";

    public SysContentTypeCodeListModel() {
        this.initAnnotation(SysContentTypeCodeListModel.class);
        this.setUserData2("SysContentType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysContentTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysContentTypeCodeListModel");
    }
}

