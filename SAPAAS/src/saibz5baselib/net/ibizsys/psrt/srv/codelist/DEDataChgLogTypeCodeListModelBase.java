/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="896c239f8d11ba397f78cec2a6726b69", name="\u6570\u636e\u5b9e\u4f53_\u6570\u636e\u53d8\u66f4\u65e5\u5fd7\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="2", text="\u5355\u9879\u6570\u636e\uff08\u540c\u6b65\uff09", realtext="\u5355\u9879\u6570\u636e\uff08\u540c\u6b65\uff09"), @CodeItem(value="3", text="\u5355\u9879\u6570\u636e\uff08\u542b\u5173\u8054\u6570\u636e\uff09\uff08\u540c\u6b65\uff09", realtext="\u5355\u9879\u6570\u636e\uff08\u542b\u5173\u8054\u6570\u636e\uff09\uff08\u540c\u6b65\uff09"), @CodeItem(value="4", text="\u5355\u9879\u6570\u636e\uff08\u5f02\u6b65\uff09", realtext="\u5355\u9879\u6570\u636e\uff08\u5f02\u6b65\uff09"), @CodeItem(value="5", text="\u5355\u9879\u6570\u636e\uff08\u542b\u5173\u8054\u6570\u636e\uff09\uff08\u5f02\u6b65\uff09", realtext="\u5355\u9879\u6570\u636e\uff08\u542b\u5173\u8054\u6570\u636e\uff09\uff08\u5f02\u6b65\uff09")})
public abstract class DEDataChgLogTypeCodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_2 = "2";
    public static final String ITEM_3 = "3";
    public static final String ITEM_4 = "4";
    public static final String ITEM_5 = "5";

    public DEDataChgLogTypeCodeListModelBase() {
        this.initAnnotation(DEDataChgLogTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.DEDataChgLogTypeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.DEDataChgLogTypeCodeListModel");
    }
}

