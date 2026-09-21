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

@CodeList(id="2a1660eb53ea29312d68746ce032bbe3", name="\u6d88\u606f\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u7cfb\u7edf\u6d88\u606f", realtext="\u7cfb\u7edf\u6d88\u606f"), @CodeItem(value="2", text="\u7535\u5b50\u90ae\u4ef6", realtext="\u7535\u5b50\u90ae\u4ef6"), @CodeItem(value="4", text="\u624b\u673a\u77ed\u4fe1", realtext="\u624b\u673a\u77ed\u4fe1"), @CodeItem(value="8", text="MSN\u6d88\u606f", realtext="MSN\u6d88\u606f"), @CodeItem(value="16", text="\u68c0\u52a1\u901a\u6d88\u606f", realtext="\u68c0\u52a1\u901a\u6d88\u606f"), @CodeItem(value="32", text="\u5fae\u4fe1", realtext="\u5fae\u4fe1")})
public abstract class MsgTypeCodeListModelBase
extends StaticCodeListModelBase {
    public static final Integer INTERNAL = 1;
    public static final int INT_INTERNAL = 1;
    public static final Integer EMAIL = 2;
    public static final int INT_EMAIL = 2;
    public static final Integer SMS = 4;
    public static final int INT_SMS = 4;
    public static final Integer MSN = 8;
    public static final int INT_MSN = 8;
    public static final Integer SAIM = 16;
    public static final int INT_SAIM = 16;
    public static final Integer WT = 32;
    public static final int INT_WT = 32;

    public MsgTypeCodeListModelBase() {
        this.initAnnotation(MsgTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.MsgTypeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.MsgTypeCodeListModel");
    }
}

