/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="4bff90297bbb99646628959ec2da43e7", name="\u8868\u683c\u5217\u6784\u5efa\u5668", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="NUMBER", text="\u6570\u503c", realtext="\u6570\u503c"), @CodeItem(value="CODELIST", text="\u4ee3\u7801\u8868", realtext="\u4ee3\u7801\u8868")})
public abstract class CodeList9CodeListModelBase
extends StaticCodeListModelBase {
    public static final String NUMBER = "NUMBER";
    public static final String CODELIST = "CODELIST";

    public CodeList9CodeListModelBase() {
        this.initAnnotation(CodeList9CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList9CodeListModel", this);
    }
}

