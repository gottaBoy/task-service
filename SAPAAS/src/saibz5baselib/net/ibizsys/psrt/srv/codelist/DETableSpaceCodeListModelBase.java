/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="58f0fed9747366a0a78600542825acf9", name="\u6570\u636e\u8868\u7a7a\u95f4", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="USERSPACE2", text="16K", realtext="16K")})
public abstract class DETableSpaceCodeListModelBase
extends StaticCodeListModelBase {
    public static final String USERSPACE2 = "USERSPACE2";

    public DETableSpaceCodeListModelBase() {
        this.initAnnotation(DETableSpaceCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.DETableSpaceCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.DETableSpaceCodeListModel");
    }
}

