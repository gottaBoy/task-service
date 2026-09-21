/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="2929b68cbf707c6fe610a8122f71ce7c", name="\u754c\u9762\u529f\u80fd\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="INHERIT", text="\u7ee7\u627f\u6a21\u677f", realtext="\u7ee7\u627f\u6a21\u677f"), @CodeItem(value="DEFAULT", text="\u9ed8\u8ba4\u529f\u80fd", realtext="\u9ed8\u8ba4\u529f\u80fd"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49")})
public abstract class CodeList91CodeListModelBase
extends StaticCodeListModelBase {
    public static final String INHERIT = "INHERIT";
    public static final String DEFAULT = "DEFAULT";
    public static final String CUSTOM = "CUSTOM";

    public CodeList91CodeListModelBase() {
        this.initAnnotation(CodeList91CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList91CodeListModel", this);
    }
}

