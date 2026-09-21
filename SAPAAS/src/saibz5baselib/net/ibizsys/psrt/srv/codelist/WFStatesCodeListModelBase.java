/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="3ac6db3b9ce065e05ac98656c8363cb5", name="\u5e73\u53f0\u5185\u7f6e\u6d41\u7a0b\u72b6\u6001", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="0", text="\u672a\u542f\u52a8", realtext="\u672a\u542f\u52a8"), @CodeItem(value="1", text="\u6d41\u7a0b\u4e2d", realtext="\u6d41\u7a0b\u4e2d"), @CodeItem(value="2", text="\u5df2\u5b8c\u6210", realtext="\u5df2\u5b8c\u6210"), @CodeItem(value="3", text="\u5df2\u53d6\u6d88", realtext="\u5df2\u53d6\u6d88"), @CodeItem(value="31", text="\u5df2\u53d6\u6d88(\u4eba\u5de5)", realtext="\u5df2\u53d6\u6d88(\u4eba\u5de5)"), @CodeItem(value="32", text="\u5df2\u53d6\u6d88(\u8d85\u65f6)", realtext="\u5df2\u53d6\u6d88(\u8d85\u65f6)"), @CodeItem(value="4", text="\u5904\u7406\u6545\u969c", realtext="\u5904\u7406\u6545\u969c"), @CodeItem(value="5", text="\u53d6\u6d88\u542f\u52a8", realtext="\u53d6\u6d88\u542f\u52a8")})
public abstract class WFStatesCodeListModelBase
extends StaticCodeListModelBase {
    public static final Integer ITEM_0 = 0;
    public static final Integer ITEM_1 = 1;
    public static final Integer ITEM_2 = 2;
    public static final Integer ITEM_3 = 3;
    public static final Integer ITEM_31 = 31;
    public static final Integer ITEM_32 = 32;
    public static final Integer ITEM_4 = 4;
    public static final Integer ITEM_5 = 5;

    public WFStatesCodeListModelBase() {
        this.initAnnotation(WFStatesCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.WFStatesCodeListModel", this);
    }
}

