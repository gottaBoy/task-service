/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="e54566dfbea72b8c8a3d81406b8eb759", name="\u9875\u9762\u6837\u5f0f", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="0", text="\u8df3\u8f6c\u5904\u7406\u754c\u9762", realtext="\u8df3\u8f6c\u5904\u7406\u754c\u9762"), @CodeItem(value="1", text="\u6570\u636e\u7f16\u8f91\u754c\u9762", realtext="\u6570\u636e\u7f16\u8f91\u754c\u9762"), @CodeItem(value="2", text="\u6570\u636e\u8868\u683c\u754c\u9762", realtext="\u6570\u636e\u8868\u683c\u754c\u9762"), @CodeItem(value="9", text="\u6570\u636e\u6811\u5f62\u754c\u9762", realtext="\u6570\u636e\u6811\u5f62\u754c\u9762"), @CodeItem(value="3", text="\u6570\u636e\u9009\u62e9\u754c\u9762", realtext="\u6570\u636e\u9009\u62e9\u754c\u9762"), @CodeItem(value="4", text="\u5de5\u4f5c\u6d41\u6570\u636e\u7f16\u8f91\u754c\u9762", realtext="\u5de5\u4f5c\u6d41\u6570\u636e\u7f16\u8f91\u754c\u9762"), @CodeItem(value="5", text="\u5de5\u4f5c\u6d41\u8868\u683c\u754c\u9762", realtext="\u5de5\u4f5c\u6d41\u8868\u683c\u754c\u9762"), @CodeItem(value="6", text="\u5de5\u4f5c\u6d41\u7ba1\u7406\u8868\u683c\u754c\u9762", realtext="\u5de5\u4f5c\u6d41\u7ba1\u7406\u8868\u683c\u754c\u9762"), @CodeItem(value="7", text="\u5bfc\u822a\u754c\u9762", realtext="\u5bfc\u822a\u754c\u9762"), @CodeItem(value="8", text="\u4fe1\u606f\u5c55\u793a\u754c\u9762", realtext="\u4fe1\u606f\u5c55\u793a\u754c\u9762")})
public abstract class CodeList22CodeListModelBase
extends StaticCodeListModelBase {
    public static final String ITEM_0 = "0";
    public static final String ITEM_1 = "1";
    public static final String ITEM_2 = "2";
    public static final String ITEM_9 = "9";
    public static final String ITEM_3 = "3";
    public static final String ITEM_4 = "4";
    public static final String ITEM_5 = "5";
    public static final String ITEM_6 = "6";
    public static final String ITEM_7 = "7";
    public static final String ITEM_8 = "8";

    public CodeList22CodeListModelBase() {
        this.initAnnotation(CodeList22CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList22CodeListModel", this);
    }
}

