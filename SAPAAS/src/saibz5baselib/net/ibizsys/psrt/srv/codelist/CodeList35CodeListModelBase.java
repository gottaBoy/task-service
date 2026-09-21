/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="56b7a0bf5a7f232e5fb7fff1c40fcc3d", name="\u7cfb\u7edf\u9519\u8bef\u4ee3\u7801", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="0", text="\u6b63\u786e(0)", realtext="\u6b63\u786e(0)"), @CodeItem(value="1", text="\u5185\u90e8\u53d1\u751f\u9519\u8bef(INTERNALERROR)", realtext="\u5185\u90e8\u53d1\u751f\u9519\u8bef(INTERNALERROR)"), @CodeItem(value="2", text="\u8bbf\u95ee\u88ab\u62d2\u7edd(ACCESSDENY)", realtext="\u8bbf\u95ee\u88ab\u62d2\u7edd(ACCESSDENY)"), @CodeItem(value="3", text="\u65e0\u6548\u7684\u6570\u636e(INVALIDDATA)", realtext="\u65e0\u6548\u7684\u6570\u636e(INVALIDDATA)"), @CodeItem(value="4", text="\u65e0\u6548\u7684\u6570\u636e\u952e(INVALIDDATAKEYS)", realtext="\u65e0\u6548\u7684\u6570\u636e\u952e(INVALIDDATAKEYS)"), @CodeItem(value="5", text="\u8f93\u5165\u7684\u4fe1\u606f\u6709\u8bef(INPUTERROR)", realtext="\u8f93\u5165\u7684\u4fe1\u606f\u6709\u8bef(INPUTERROR)"), @CodeItem(value="6", text="\u91cd\u590d\u7684\u6570\u636e\u952e\u503c(DUPLICATEKEY)", realtext="\u91cd\u590d\u7684\u6570\u636e\u952e\u503c(DUPLICATEKEY)"), @CodeItem(value="7", text="\u91cd\u590d\u7684\u6570\u636e(DUPLICATEDATA)", realtext="\u91cd\u590d\u7684\u6570\u636e(DUPLICATEDATA)"), @CodeItem(value="8", text="\u5220\u9664\u62d2\u7edd(DELETEREJECT)", realtext="\u5220\u9664\u62d2\u7edd(DELETEREJECT)"), @CodeItem(value="9", text="\u903b\u8f91\u5904\u7406\u9519\u8bef(LOGICERROR)", realtext="\u903b\u8f91\u5904\u7406\u9519\u8bef(LOGICERROR)")})
public abstract class CodeList35CodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_0 = "0";
    public static final String ITEM_1 = "1";
    public static final String ITEM_2 = "2";
    public static final String ITEM_3 = "3";
    public static final String ITEM_4 = "4";
    public static final String ITEM_5 = "5";
    public static final String ITEM_6 = "6";
    public static final String ITEM_7 = "7";
    public static final String ITEM_8 = "8";
    public static final String ITEM_9 = "9";

    public CodeList35CodeListModelBase() {
        this.initAnnotation(CodeList35CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList35CodeListModel", this);
    }
}

