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

@CodeList(id="45d6f26513401ac265c53d029c4fc60b", name="\u8d44\u6e90\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u6b63\u5e38\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u672a\u521d\u59cb\u5316", realtext="\u672a\u521d\u59cb\u5316"), @CodeItem(value="11", text="\u672a\u8bbe\u7f6e", realtext="\u672a\u8bbe\u7f6e"), @CodeItem(value="20", text="\u6b63\u5e38", realtext="\u6b63\u5e38"), @CodeItem(value="40", text="\u5df2\u5931\u6548", realtext="\u5df2\u5931\u6548"), @CodeItem(value="41", text="\u5df2\u8d85\u671f", realtext="\u5df2\u8d85\u671f"), @CodeItem(value="42", text="\u5206\u65f6\u8d44\u6e90\u672a\u5206\u914d", realtext="\u5206\u65f6\u8d44\u6e90\u672a\u5206\u914d")})
public class DevCenterResStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer UNINIT = 10;
    public static final int INT_UNINIT = 10;
    public static final Integer UNSET = 11;
    public static final int INT_UNSET = 11;
    public static final Integer VALID = 20;
    public static final int INT_VALID = 20;
    public static final Integer INVALID = 40;
    public static final int INT_INVALID = 40;
    public static final Integer EXPIRED = 41;
    public static final int INT_EXPIRED = 41;
    public static final Integer UNASSIGNED = 42;
    public static final int INT_UNASSIGNED = 42;

    public DevCenterResStateCodeListModel() {
        this.initAnnotation(DevCenterResStateCodeListModel.class);
        this.setUserData2("DCResState");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevCenterResStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevCenterResStateCodeListModel");
    }
}

