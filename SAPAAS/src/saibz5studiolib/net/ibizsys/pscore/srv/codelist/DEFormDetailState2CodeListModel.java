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

@CodeList(id="B60869D2-4E5A-42C0-9FE0-BD7842DFB232", name="\u8fd0\u884c\u65f6\u8bbe\u8ba1\u63a7\u5236\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="16384", text="\u542f\u7528\u6269\u5c55\u63a7\u5236\u903b\u8f91", realtext="\u542f\u7528\u6269\u5c55\u63a7\u5236\u903b\u8f91", userdata="\u8fd0\u884c\u65f6\u8bbe\u8ba1\u63a7\u5236\u5f00\u5173\uff0c\u542f\u7528\u8be5\u9879\u65f6\u5176\u5b83\u6269\u5c55\u9009\u9879\u624d\u80fd\u751f\u6548"), @CodeItem(value="32768", text="\u542f\u7528\u66f4\u65b0\uff08\u6269\u5c55\uff09", realtext="\u542f\u7528\u66f4\u65b0\uff08\u6269\u5c55\uff09", userdata="\u5141\u8bb8\u66f4\u6539\u8be5\u6210\u5458"), @CodeItem(value="65536", text="\u542f\u7528\u5220\u9664\uff08\u6269\u5c55\uff09", realtext="\u542f\u7528\u5220\u9664\uff08\u6269\u5c55\uff09", userdata="\u5141\u8bb8\u5220\u9664\u8be5\u6210\u5458"), @CodeItem(value="131072", text="\u542f\u7528\u62d6\u52a8\uff08\u6269\u5c55\uff09", realtext="\u542f\u7528\u62d6\u52a8\uff08\u6269\u5c55\uff09", userdata="\u5141\u8bb8\u62d6\u52a8\u8be5\u6210\u5458\u81f3\u5176\u5b83\u4f4d\u7f6e"), @CodeItem(value="262144", text="\u542f\u7528\u62d6\u5165\uff08\u6269\u5c55\uff09", realtext="\u542f\u7528\u62d6\u5165\uff08\u6269\u5c55\uff09", userdata="\u5141\u8bb8\u62d6\u52a8\u5176\u5b83\u6210\u5458\u81f3\u5f53\u524d\u6210\u5458\u533a\u57df\u4e2d"), @CodeItem(value="524288", text="\u542f\u7528\u5360\u4f4d\uff08\u6269\u5c55\uff09", realtext="\u542f\u7528\u5360\u4f4d\uff08\u6269\u5c55\uff09", userdata="\u8bbe\u7f6e\u8be5\u6210\u5458\uff08\u542b\u5b50\u6210\u5458\uff09\u4e3a\u7edf\u4e00\u5360\u4f4d\uff0c\u4e0d\u5c55\u5f00\u660e\u7ec6")})
public class DEFormDetailState2CodeListModel
extends StaticCodeListModelBase {
    public static final Integer ENABLEEXTENSION = 16384;
    public static final int INT_ENABLEEXTENSION = 16384;
    public static final Integer ENABLEUPDATE = 32768;
    public static final int INT_ENABLEUPDATE = 32768;
    public static final Integer ENABLEREMOVE = 65536;
    public static final int INT_ENABLEREMOVE = 65536;
    public static final Integer ENABLEDRAG = 131072;
    public static final int INT_ENABLEDRAG = 131072;
    public static final Integer ENABLEDROP = 262144;
    public static final int INT_ENABLEDROP = 262144;
    public static final Integer ENABLEPLACEHOLDER = 524288;
    public static final int INT_ENABLEPLACEHOLDER = 524288;

    public DEFormDetailState2CodeListModel() {
        this.initAnnotation(DEFormDetailState2CodeListModel.class);
        this.setUserData2("DEFormDetailState");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFormDetailState2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFormDetailState2CodeListModel");
    }
}

