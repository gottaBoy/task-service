/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="74f593e62bc52670ed4d13aadb4ceedd", name="\u6269\u5c55\u8868\u683c\u5355\u5143\u683c\u8fb9\u6846\u6837\u5f0f", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="LEFT", text="\u5de6\u8fb9\u6846", realtext="\u5de6\u8fb9\u6846"), @CodeItem(value="TOP", text="\u4e0a\u8fb9\u6846", realtext="\u4e0a\u8fb9\u6846"), @CodeItem(value="RIGHT", text="\u53f3\u8fb9\u6846", realtext="\u53f3\u8fb9\u6846"), @CodeItem(value="BOTTOM", text="\u4e0b\u8fb9\u6846", realtext="\u4e0b\u8fb9\u6846")})
public abstract class CodeList76CodeListModelBase
extends StaticCodeListModelBase {
    public static final String LEFT = "LEFT";
    public static final String TOP = "TOP";
    public static final String RIGHT = "RIGHT";
    public static final String BOTTOM = "BOTTOM";

    public CodeList76CodeListModelBase() {
        this.initAnnotation(CodeList76CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList76CodeListModel", this);
    }
}

