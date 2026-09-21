/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="c0a4a9b8e56cd645bb9a2dd3f5d10e54", name="\u5b9e\u4f53\u5173\u7cfb\u660e\u7ec6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="PAGE", text="\u5185\u5efa\u9875\u9762", realtext="\u5185\u5efa\u9875\u9762"), @CodeItem(value="PAGEPATH", text="\u9875\u9762\u8def\u5f84", realtext="\u9875\u9762\u8def\u5f84"), @CodeItem(value="DER1N", text="1:N\u5173\u7cfb", realtext="1:N\u5173\u7cfb"), @CodeItem(value="DER11", text="1:1\u5173\u7cfb", realtext="1:1\u5173\u7cfb"), @CodeItem(value="WFSTEP", text="\u5de5\u4f5c\u6d41\u5904\u7406\u6b65\u9aa4", realtext="\u5de5\u4f5c\u6d41\u5904\u7406\u6b65\u9aa4"), @CodeItem(value="WFSTEPACTOR", text="\u5de5\u4f5c\u6d41\u5f53\u524d\u5904\u7406\u7528\u6237", realtext="\u5de5\u4f5c\u6d41\u5f53\u524d\u5904\u7406\u7528\u6237"), @CodeItem(value="FILELIST", text="\u9644\u4ef6\u5217\u8868", realtext="\u9644\u4ef6\u5217\u8868"), @CodeItem(value="DATAAUDIT", text="\u884c\u4e3a\u5ba1\u8ba1", realtext="\u884c\u4e3a\u5ba1\u8ba1"), @CodeItem(value="DERTYPE", text="\u5b9e\u4f53\u5173\u7cfb\u5206\u7ec4", realtext="\u5b9e\u4f53\u5173\u7cfb\u5206\u7ec4")})
public abstract class CodeList14CodeListModelBase
extends StaticCodeListModelBase {
    public static final String PAGE = "PAGE";
    public static final String PAGEPATH = "PAGEPATH";
    public static final String DER1N = "DER1N";
    public static final String DER11 = "DER11";
    public static final String WFSTEP = "WFSTEP";
    public static final String WFSTEPACTOR = "WFSTEPACTOR";
    public static final String FILELIST = "FILELIST";
    public static final String DATAAUDIT = "DATAAUDIT";
    public static final String DERTYPE = "DERTYPE";

    public CodeList14CodeListModelBase() {
        this.initAnnotation(CodeList14CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList14CodeListModel", this);
    }
}

