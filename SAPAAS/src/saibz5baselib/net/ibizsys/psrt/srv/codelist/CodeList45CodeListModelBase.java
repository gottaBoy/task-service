/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="207d8f3e5d405336dc290365e30b3af8", name="\u5de5\u4f5c\u65e5\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="1", text="\u5de5\u4f5c\u65e5", realtext="\u5de5\u4f5c\u65e5"), @CodeItem(value="2", text="\u975e\u5de5\u4f5c\u65e5", realtext="\u975e\u5de5\u4f5c\u65e5"), @CodeItem(value="3", text="\u81ea\u5b9a\u4e49\u5de5\u4f5c\u65e5", realtext="\u81ea\u5b9a\u4e49\u5de5\u4f5c\u65e5")})
public abstract class CodeList45CodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "1";
    public static final String ITEM_2 = "2";
    public static final String ITEM_3 = "3";

    public CodeList45CodeListModelBase() {
        this.initAnnotation(CodeList45CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList45CodeListModel", this);
    }
}

