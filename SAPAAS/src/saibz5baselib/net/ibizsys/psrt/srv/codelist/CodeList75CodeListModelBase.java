/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="2381396a56c91424cc5724a02cef9f66", name="\u6269\u5c55\u8868\u683c\u5355\u5143\u683c\u5782\u76f4\u5bf9\u9f50\u65b9\u5f0f", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="TOP", text="\u4e0a\u5bf9\u9f50", realtext="\u4e0a\u5bf9\u9f50"), @CodeItem(value="MIDDLE", text="\u5c45\u4e2d\u5bf9\u9f50", realtext="\u5c45\u4e2d\u5bf9\u9f50"), @CodeItem(value="BOTTOM", text="\u4e0b\u5bf9\u9f50", realtext="\u4e0b\u5bf9\u9f50")})
public abstract class CodeList75CodeListModelBase
extends StaticCodeListModelBase {
    public static final String TOP = "TOP";
    public static final String MIDDLE = "MIDDLE";
    public static final String BOTTOM = "BOTTOM";

    public CodeList75CodeListModelBase() {
        this.initAnnotation(CodeList75CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList75CodeListModel", this);
    }
}

