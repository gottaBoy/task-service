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

@CodeList(id="08b62e1695176eb1ce95333dd44a3722", name="\u7cfb\u7edf\u96c6\u6210\u529f\u80fd", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u7edf\u4e00\u8ba4\u8bc1", realtext="\u7edf\u4e00\u8ba4\u8bc1"), @CodeItem(value="2", text="\u7edf\u4e00\u6743\u9650", realtext="\u7edf\u4e00\u6743\u9650"), @CodeItem(value="4", text="\u7cfb\u7edf\u65e5\u5fd7", realtext="\u7cfb\u7edf\u65e5\u5fd7"), @CodeItem(value="8", text="\u5de5\u4f5c\u6d41\u670d\u52a1", realtext="\u5de5\u4f5c\u6d41\u670d\u52a1"), @CodeItem(value="16", text="\u77ed\u4fe1\u7f51\u5173", realtext="\u77ed\u4fe1\u7f51\u5173")})
public abstract class SystemFuncCodeListModelBase
extends StaticCodeListModelBase {
    public static final Integer ITEM_1 = 1;
    public static final int INT_ITEM_1 = 1;
    public static final Integer ITEM_2 = 2;
    public static final int INT_ITEM_2 = 2;
    public static final Integer ITEM_4 = 4;
    public static final int INT_ITEM_4 = 4;
    public static final Integer ITEM_8 = 8;
    public static final int INT_ITEM_8 = 8;
    public static final Integer ITEM_16 = 16;
    public static final int INT_ITEM_16 = 16;

    public SystemFuncCodeListModelBase() {
        this.initAnnotation(SystemFuncCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.SystemFuncCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.SystemFuncCodeListModel");
    }
}

