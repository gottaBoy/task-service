/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="2a1660eb53ea29312d68746ce032bbe3", name="\u6d88\u606f\u7c7b\u578b", type="STATIC", userscope=false)
@CodeItems(value={@CodeItem(value="1", text="\u7cfb\u7edf\u6d88\u606f", realtext="\u7cfb\u7edf\u6d88\u606f"), @CodeItem(value="2", text="\u7535\u5b50\u90ae\u4ef6", realtext="\u7535\u5b50\u90ae\u4ef6"), @CodeItem(value="4", text="\u624b\u673a\u77ed\u4fe1", realtext="\u624b\u673a\u77ed\u4fe1"), @CodeItem(value="8", text="MSN\u6d88\u606f", realtext="MSN\u6d88\u606f"), @CodeItem(value="16", text="\u68c0\u52a1\u901a\u6d88\u606f", realtext="\u68c0\u52a1\u901a\u6d88\u606f"), @CodeItem(value="32", text="\u5fae\u4fe1", realtext="\u5fae\u4fe1")})
public abstract class CodeList29CodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "1";
    public static final String ITEM_2 = "2";
    public static final String ITEM_4 = "4";
    public static final String ITEM_8 = "8";
    public static final String ITEM_16 = "16";
    public static final String ITEM_32 = "32";

    public CodeList29CodeListModelBase() {
        this.initAnnotation(CodeList29CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList29CodeListModel", this);
    }
}

