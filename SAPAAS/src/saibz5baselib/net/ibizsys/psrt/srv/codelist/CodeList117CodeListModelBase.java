/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="54d9e0999e903b29cf629dcc1ec68f88", name="\u6027\u80fd\u5206\u6790\u6307\u6807", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="PODBACTION", text="\u6570\u636e\u5e93\u64cd\u4f5c\u6027\u80fd", realtext="\u6570\u636e\u5e93\u64cd\u4f5c\u6027\u80fd"), @CodeItem(value="PODBQUERY", text="\u6570\u636e\u5e93\u67e5\u8be2\u6027\u80fd", realtext="\u6570\u636e\u5e93\u67e5\u8be2\u6027\u80fd"), @CodeItem(value="PODEDC", text="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u6027\u80fd", realtext="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u6027\u80fd"), @CodeItem(value="POWORKFLOW", text="\u5de5\u4f5c\u6d41\u6027\u80fd", realtext="\u5de5\u4f5c\u6d41\u6027\u80fd"), @CodeItem(value="POPAGE", text="\u9875\u9762\u6027\u80fd", realtext="\u9875\u9762\u6027\u80fd"), @CodeItem(value="POPAGEBACKEND", text="\u9875\u9762\u6027\u80fd(\u540e\u53f0)", realtext="\u9875\u9762\u6027\u80fd(\u540e\u53f0)"), @CodeItem(value="POPAGESESSION", text="\u5e76\u53d1\u6027\u80fd", realtext="\u5e76\u53d1\u6027\u80fd")})
public abstract class CodeList117CodeListModelBase
extends StaticCodeListModelBase {
    public static final String PODBACTION = "PODBACTION";
    public static final String PODBQUERY = "PODBQUERY";
    public static final String PODEDC = "PODEDC";
    public static final String POWORKFLOW = "POWORKFLOW";
    public static final String POPAGE = "POPAGE";
    public static final String POPAGEBACKEND = "POPAGEBACKEND";
    public static final String POPAGESESSION = "POPAGESESSION";

    public CodeList117CodeListModelBase() {
        this.initAnnotation(CodeList117CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList117CodeListModel", this);
    }
}

