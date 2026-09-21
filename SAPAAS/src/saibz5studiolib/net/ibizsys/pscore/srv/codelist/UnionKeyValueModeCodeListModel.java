/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.CodeItem
 *  net.ibizsys.paas.codelist.CodeItems
 *  net.ibizsys.paas.codelist.CodeList
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 *  net.ibizsys.paas.sysmodel.StaticCodeListModelBase
 */
package net.ibizsys.pscore.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="0d0b9b05a6fdf4770e3771576f918e9a", name="\u8054\u5408\u952e\u503c\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="KEY1", text="\u8054\u5408\u952e\u503c1", realtext="\u8054\u5408\u952e\u503c1"), @CodeItem(value="KEY2", text="\u8054\u5408\u952e\u503c2", realtext="\u8054\u5408\u952e\u503c2"), @CodeItem(value="KEY3", text="\u8054\u5408\u952e\u503c3", realtext="\u8054\u5408\u952e\u503c3"), @CodeItem(value="KEY4", text="\u8054\u5408\u952e\u503c4", realtext="\u8054\u5408\u952e\u503c4"), @CodeItem(value="KEY5", text="\u8054\u5408\u952e\u503c5", realtext="\u8054\u5408\u952e\u503c5"), @CodeItem(value="KEY6", text="\u8054\u5408\u952e\u503c6", realtext="\u8054\u5408\u952e\u503c6"), @CodeItem(value="KEY7", text="\u8054\u5408\u952e\u503c7", realtext="\u8054\u5408\u952e\u503c7"), @CodeItem(value="KEY8", text="\u8054\u5408\u952e\u503c8", realtext="\u8054\u5408\u952e\u503c8")})
public class UnionKeyValueModeCodeListModel
extends StaticCodeListModelBase {
    public static final String KEY1 = "KEY1";
    public static final String KEY2 = "KEY2";
    public static final String KEY3 = "KEY3";
    public static final String KEY4 = "KEY4";
    public static final String KEY5 = "KEY5";
    public static final String KEY6 = "KEY6";
    public static final String KEY7 = "KEY7";
    public static final String KEY8 = "KEY8";

    public UnionKeyValueModeCodeListModel() {
        this.initAnnotation(UnionKeyValueModeCodeListModel.class);
        this.setUserData2("UnionKeyValueMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.UnionKeyValueModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.UnionKeyValueModeCodeListModel");
    }
}

