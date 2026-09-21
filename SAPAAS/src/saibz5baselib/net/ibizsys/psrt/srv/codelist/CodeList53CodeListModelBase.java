/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="a0e59420bbf0cd26b7e7e4ad5e8029f9", name="\u5b9e\u4f53\u6570\u636e\u5e93\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="INSERT", text="\u63d2\u5165", realtext="\u63d2\u5165"), @CodeItem(value="UPDATE", text="\u66f4\u65b0", realtext="\u66f4\u65b0"), @CodeItem(value="SELECT", text="\u67e5\u8be2", realtext="\u67e5\u8be2"), @CodeItem(value="DELETE", text="\u5220\u9664", realtext="\u5220\u9664"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49")})
public abstract class CodeList53CodeListModelBase
extends StaticCodeListModelBase {
    public static final String INSERT = "INSERT";
    public static final String UPDATE = "UPDATE";
    public static final String SELECT = "SELECT";
    public static final String DELETE = "DELETE";
    public static final String CUSTOM = "CUSTOM";

    public CodeList53CodeListModelBase() {
        this.initAnnotation(CodeList53CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList53CodeListModel", this);
    }
}

