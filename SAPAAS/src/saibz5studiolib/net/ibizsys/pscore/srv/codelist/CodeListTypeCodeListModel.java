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

@CodeList(id="97b3b80b051b0bf519be8d4c4c18f072", name="\u4ee3\u7801\u8868\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="STATIC", text="\u9759\u6001", realtext="\u9759\u6001", userdata="\u4ee3\u7801\u9879\u4e3a\u9759\u6001\u5b9a\u4e49"), @CodeItem(value="DYNAMIC", text="\u52a8\u6001", realtext="\u52a8\u6001", userdata="\u4ee3\u7801\u9879\u5b9a\u4e49\u6765\u81ea\u5916\u90e8\u5b58\u50a8\uff0c\u4f7f\u7528\u65f6\u8fdb\u884c\u52a0\u8f7d"), @CodeItem(value="PREDEFINED", text="\u9884\u5b9a\u4e49", realtext="\u9884\u5b9a\u4e49", userdata="\u7279\u5b9a\u529f\u80fd\u7684\u7684\u4ee3\u7801\u8868\uff0c\u4e00\u822c\u7531\u5185\u7f6e\u7a0b\u5e8f\u63d0\u4f9b")})
public class CodeListTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String STATIC = "STATIC";
    public static final String DYNAMIC = "DYNAMIC";
    public static final String PREDEFINED = "PREDEFINED";

    public CodeListTypeCodeListModel() {
        this.initAnnotation(CodeListTypeCodeListModel.class);
        this.setUserData2("CodeListType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.CodeListTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.CodeListTypeCodeListModel");
    }
}

