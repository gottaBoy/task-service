/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="157e71b4a6a4aac6300e048b6272dcb2", name="\u65f6\u95f4\u5206\u7ec4\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="Q", text="\u5b63\u5ea6", realtext="\u5b63\u5ea6"), @CodeItem(value="M", text="\u6708\u4efd", realtext="\u6708\u4efd"), @CodeItem(value="D", text="\u6708\u5929", realtext="\u6708\u5929"), @CodeItem(value="H", text="\u5c0f\u65f6", realtext="\u5c0f\u65f6")})
public abstract class CodeList92CodeListModelBase
extends StaticCodeListModelBase {
    public static final String Q = "Q";
    public static final String M = "M";
    public static final String D = "D";
    public static final String H = "H";

    public CodeList92CodeListModelBase() {
        this.initAnnotation(CodeList92CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList92CodeListModel", this);
    }
}

