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

@CodeList(id="9BC9CA8C-A271-41BF-AD28-55C77F27A63E", name="\u65e5\u5386\u3001\u90ae\u4ef6\u91cd\u8981\u7a0b\u5ea6\uff08\u6570\u503c\uff09", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="100", text="\u9ad8", realtext="\u9ad8"), @CodeItem(value="50", text="\u666e\u901a", realtext="\u666e\u901a"), @CodeItem(value="10", text="\u4f4e", realtext="\u4f4e")})
public abstract class MsgImportanceLevelCodeListModelBase
extends StaticCodeListModelBase {
    public static final Integer HIGH = 100;
    public static final int INT_HIGH = 100;
    public static final Integer NORMAL = 50;
    public static final int INT_NORMAL = 50;
    public static final Integer LOW = 10;
    public static final int INT_LOW = 10;

    public MsgImportanceLevelCodeListModelBase() {
        this.initAnnotation(MsgImportanceLevelCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.MsgImportanceLevelCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.MsgImportanceLevelCodeListModel");
    }
}

