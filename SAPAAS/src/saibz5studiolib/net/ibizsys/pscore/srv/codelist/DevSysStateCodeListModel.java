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

@CodeList(id="56b7b5fbc32522cd1342fcaf3a4ec199", name="\u5f00\u53d1\u7cfb\u7edf\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u672a\u521d\u59cb\u5316", realtext="\u672a\u521d\u59cb\u5316"), @CodeItem(value="20", text="\u521b\u5efa\u4e2d", realtext="\u521b\u5efa\u4e2d"), @CodeItem(value="21", text="\u6062\u590d\u4e2d", realtext="\u6062\u590d\u4e2d"), @CodeItem(value="30", text="\u6b63\u5e38", realtext="\u6b63\u5e38"), @CodeItem(value="31", text="\u8fd0\u7ef4\u4e2d", realtext="\u8fd0\u7ef4\u4e2d"), @CodeItem(value="35", text="\u5df2\u79bb\u7ebf", realtext="\u5df2\u79bb\u7ebf"), @CodeItem(value="40", text="\u5df2\u5220\u9664", realtext="\u5df2\u5220\u9664"), @CodeItem(value="41", text="\u5df2\u8d85\u671f", realtext="\u5df2\u8d85\u671f"), @CodeItem(value="42", text="\u521b\u5efa\u5931\u8d25", realtext="\u521b\u5efa\u5931\u8d25")})
public class DevSysStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer UNINITIALIZED = 10;
    public static final int INT_UNINITIALIZED = 10;
    public static final Integer CREATING = 20;
    public static final int INT_CREATING = 20;
    public static final Integer RECOVERING = 21;
    public static final int INT_RECOVERING = 21;
    public static final Integer ONLINE = 30;
    public static final int INT_ONLINE = 30;
    public static final Integer MAINTAIN = 31;
    public static final int INT_MAINTAIN = 31;
    public static final Integer OFFLINE = 35;
    public static final int INT_OFFLINE = 35;
    public static final Integer REMOVED = 40;
    public static final int INT_REMOVED = 40;
    public static final Integer EXPIRED = 41;
    public static final int INT_EXPIRED = 41;
    public static final Integer CREATEFAILED = 42;
    public static final int INT_CREATEFAILED = 42;

    public DevSysStateCodeListModel() {
        this.initAnnotation(DevSysStateCodeListModel.class);
        this.setUserData2("DevSysState");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel");
    }
}

