/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="aecf6d488539a7c4df72030f9c308e2a", name="\u8f93\u5165\u8f85\u52a9_\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u4ee3\u7801", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="CARETTEMPLGROUP_SRFDA_DEDCCONTEXT", text="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u5f15\u64ce", realtext="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u5f15\u64ce"), @CodeItem(value="CARETTEMPLGROUP_SRFDA_DEACTION", text="\u5b9e\u4f53\u5c5e\u6027\u64cd\u4f5c", realtext="\u5b9e\u4f53\u5c5e\u6027\u64cd\u4f5c")})
public abstract class CodeList103CodeListModelBase
extends StaticCodeListModelBase {
    public static final String CARETTEMPLGROUP_SRFDA_DEDCCONTEXT = "CARETTEMPLGROUP_SRFDA_DEDCCONTEXT";
    public static final String CARETTEMPLGROUP_SRFDA_DEACTION = "CARETTEMPLGROUP_SRFDA_DEACTION";

    public CodeList103CodeListModelBase() {
        this.initAnnotation(CodeList103CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList103CodeListModel", this);
    }
}

