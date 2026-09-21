/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="1e533ab62cd7d0483e65a65e3cf89db5", name="\u6269\u5c55\u8868\u683c\u5355\u5143\u683c\u6c34\u5e73\u5bf9\u9f50\u65b9\u5f0f", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="LEFT", text="\u5de6\u5bf9\u9f50", realtext="\u5de6\u5bf9\u9f50"), @CodeItem(value="CENTER", text="\u5c45\u4e2d", realtext="\u5c45\u4e2d"), @CodeItem(value="RIGHT", text="\u53f3\u5bf9\u9f50", realtext="\u53f3\u5bf9\u9f50")})
public abstract class CodeList74CodeListModelBase
extends StaticCodeListModelBase {
    public static final String LEFT = "LEFT";
    public static final String CENTER = "CENTER";
    public static final String RIGHT = "RIGHT";

    public CodeList74CodeListModelBase() {
        this.initAnnotation(CodeList74CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList74CodeListModel", this);
    }
}

