/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="a2ba74a0808413318d974ea5bfce3f71", name="\u8868\u683c\u5217\u5bf9\u9f50", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="left", text="\u5de6\u5bf9\u9f50", realtext="\u5de6\u5bf9\u9f50"), @CodeItem(value="center", text="\u5267\u4e2d", realtext="\u5267\u4e2d"), @CodeItem(value="right", text="\u53f3\u5bf9\u9f50", realtext="\u53f3\u5bf9\u9f50")})
public abstract class CodeList18CodeListModelBase
extends StaticCodeListModelBase {
    public static final String LEFT = "left";
    public static final String CENTER = "center";
    public static final String RIGHT = "right";

    public CodeList18CodeListModelBase() {
        this.initAnnotation(CodeList18CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList18CodeListModel", this);
    }
}

