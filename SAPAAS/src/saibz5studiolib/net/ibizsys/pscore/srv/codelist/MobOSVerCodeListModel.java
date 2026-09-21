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

@CodeList(id="a5b3160aed4be8dd12f6062cea6347b6", name="\u5168\u90e8\u79fb\u52a8\u7cfb\u7edf\u7248\u672c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="V0400", text="4.0\u4ee5\u4e0a", realtext="4.0\u4ee5\u4e0a"), @CodeItem(value="V0500", text="5.0\u4ee5\u4e0a", realtext="5.0\u4ee5\u4e0a"), @CodeItem(value="V0600", text="6.0\u4ee5\u4e0a", realtext="6.0\u4ee5\u4e0a"), @CodeItem(value="V0700", text="7.0\u4ee5\u4e0a", realtext="7.0\u4ee5\u4e0a"), @CodeItem(value="V0800", text="8.0\u4ee5\u4e0a", realtext="8.0\u4ee5\u4e0a"), @CodeItem(value="V0900", text="9.0\u4ee5\u4e0a", realtext="9.0\u4ee5\u4e0a"), @CodeItem(value="V1000", text="10.0\u4ee5\u4e0a", realtext="10.0\u4ee5\u4e0a"), @CodeItem(value="V1100", text="11.0\u4ee5\u4e0a", realtext="11.0\u4ee5\u4e0a")})
public class MobOSVerCodeListModel
extends StaticCodeListModelBase {
    public static final String V0400 = "V0400";
    public static final String V0500 = "V0500";
    public static final String V0600 = "V0600";
    public static final String V0700 = "V0700";
    public static final String V0800 = "V0800";
    public static final String V0900 = "V0900";
    public static final String V1000 = "V1000";
    public static final String V1100 = "V1100";

    public MobOSVerCodeListModel() {
        this.initAnnotation(MobOSVerCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.MobOSVerCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MobOSVerCodeListModel");
    }
}

