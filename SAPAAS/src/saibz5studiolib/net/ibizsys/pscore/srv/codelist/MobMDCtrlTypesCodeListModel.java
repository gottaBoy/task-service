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

@CodeList(id="2903aa5dc7ab1044b62d238afa3b3bed", name="\u79fb\u52a8\u7aef\u591a\u9879\u6570\u636e\u63a7\u4ef6\u6837\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="ICONVIEW", text="\u56fe\u6807\u89c6\u56fe", realtext="\u56fe\u6807\u89c6\u56fe"), @CodeItem(value="LISTVIEW", text="\u5217\u8868\u89c6\u56fe", realtext="\u5217\u8868\u89c6\u56fe"), @CodeItem(value="SWIPERVIEW", text="\u56fe\u7247\u6ed1\u52a8\u89c6\u56fe", realtext="\u56fe\u7247\u6ed1\u52a8\u89c6\u56fe"), @CodeItem(value="LISTVIEW2", text="\u5217\u8868\u89c6\u56fe\uff08\u65e0\u5237\u65b0\uff09", realtext="\u5217\u8868\u89c6\u56fe\uff08\u65e0\u5237\u65b0\uff09"), @CodeItem(value="LISTVIEW3", text="\u5217\u8868\u89c6\u56fe\uff08\u65e0\u6ed1\u52a8\uff09", realtext="\u5217\u8868\u89c6\u56fe\uff08\u65e0\u6ed1\u52a8\uff09"), @CodeItem(value="LISTVIEW4", text="\u5217\u8868\u89c6\u56fe\uff08\u65e0\u80cc\u666f\uff09", realtext="\u5217\u8868\u89c6\u56fe\uff08\u65e0\u80cc\u666f\uff09"), @CodeItem(value="EXTVIEW1", text="\u6269\u5c55\u89c6\u56fe1", realtext="\u6269\u5c55\u89c6\u56fe1"), @CodeItem(value="EXTVIEW2", text="\u6269\u5c55\u89c6\u56fe2", realtext="\u6269\u5c55\u89c6\u56fe2"), @CodeItem(value="EXTVIEW3", text="\u6269\u5c55\u89c6\u56fe3", realtext="\u6269\u5c55\u89c6\u56fe3"), @CodeItem(value="EXTVIEW4", text="\u6269\u5c55\u89c6\u56fe4", realtext="\u6269\u5c55\u89c6\u56fe4"), @CodeItem(value="EXTVIEW5", text="\u6269\u5c55\u89c6\u56fe5", realtext="\u6269\u5c55\u89c6\u56fe5")})
public class MobMDCtrlTypesCodeListModel
extends StaticCodeListModelBase {
    public static final String ICONVIEW = "ICONVIEW";
    public static final String LISTVIEW = "LISTVIEW";
    public static final String SWIPERVIEW = "SWIPERVIEW";
    public static final String LISTVIEW2 = "LISTVIEW2";
    public static final String LISTVIEW3 = "LISTVIEW3";
    public static final String LISTVIEW4 = "LISTVIEW4";
    public static final String EXTVIEW1 = "EXTVIEW1";
    public static final String EXTVIEW2 = "EXTVIEW2";
    public static final String EXTVIEW3 = "EXTVIEW3";
    public static final String EXTVIEW4 = "EXTVIEW4";
    public static final String EXTVIEW5 = "EXTVIEW5";

    public MobMDCtrlTypesCodeListModel() {
        this.initAnnotation(MobMDCtrlTypesCodeListModel.class);
        this.setUserData2("MobMDCtrlType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.MobMDCtrlTypesCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MobMDCtrlTypesCodeListModel");
    }
}

