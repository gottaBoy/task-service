/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="b81e146d9e42c25dd6b3fb8ca27b9399", name="\u8f93\u5165\u8f85\u52a9_\u9875\u9762\u53c2\u6570", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="CARETTEMPLGROUP_SRFDA_PAGEPARAM", text="\u5e38\u89c4\u9875\u9762\u53c2\u6570", realtext="\u5e38\u89c4\u9875\u9762\u53c2\u6570"), @CodeItem(value="CARETTEMPLGROUP_SRFDA_GRIDVIEWPAGEPARAM", text="\u8868\u683c\u9875\u9762\u53c2\u6570", realtext="\u8868\u683c\u9875\u9762\u53c2\u6570"), @CodeItem(value="CARETTEMPLGROUP_SRFDA_EDITVIEWPAGEPARAM", text="\u7f16\u8f91\u9875\u9762\u53c2\u6570", realtext="\u7f16\u8f91\u9875\u9762\u53c2\u6570")})
public abstract class CodeList100CodeListModelBase
extends StaticCodeListModelBase {
    public static final String CARETTEMPLGROUP_SRFDA_PAGEPARAM = "CARETTEMPLGROUP_SRFDA_PAGEPARAM";
    public static final String CARETTEMPLGROUP_SRFDA_GRIDVIEWPAGEPARAM = "CARETTEMPLGROUP_SRFDA_GRIDVIEWPAGEPARAM";
    public static final String CARETTEMPLGROUP_SRFDA_EDITVIEWPAGEPARAM = "CARETTEMPLGROUP_SRFDA_EDITVIEWPAGEPARAM";

    public CodeList100CodeListModelBase() {
        this.initAnnotation(CodeList100CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList100CodeListModel", this);
    }
}

