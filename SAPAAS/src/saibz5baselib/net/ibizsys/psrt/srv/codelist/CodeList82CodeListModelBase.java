/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="b515870bb8cdb6dcd91e672786be3e5e", name="\u6708\u4efd\uff081\uff5e12\uff09", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="01", text="1\u6708", realtext="1\u6708"), @CodeItem(value="02", text="2\u6708", realtext="2\u6708"), @CodeItem(value="03", text="3\u6708", realtext="3\u6708"), @CodeItem(value="04", text="4\u6708", realtext="4\u6708"), @CodeItem(value="05", text="5\u6708", realtext="5\u6708"), @CodeItem(value="06", text="6\u6708", realtext="6\u6708"), @CodeItem(value="07", text="7\u6708", realtext="7\u6708"), @CodeItem(value="08", text="8\u6708", realtext="8\u6708"), @CodeItem(value="09", text="9\u6708", realtext="9\u6708"), @CodeItem(value="10", text="10\u6708", realtext="10\u6708"), @CodeItem(value="11", text="11\u6708", realtext="11\u6708"), @CodeItem(value="12", text="12\u6708", realtext="12\u6708")})
public abstract class CodeList82CodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_01 = "01";
    public static final String ITEM_02 = "02";
    public static final String ITEM_03 = "03";
    public static final String ITEM_04 = "04";
    public static final String ITEM_05 = "05";
    public static final String ITEM_06 = "06";
    public static final String ITEM_07 = "07";
    public static final String ITEM_08 = "08";
    public static final String ITEM_09 = "09";
    public static final String ITEM_10 = "10";
    public static final String ITEM_11 = "11";
    public static final String ITEM_12 = "12";

    public CodeList82CodeListModelBase() {
        this.initAnnotation(CodeList82CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList82CodeListModel", this);
    }
}

