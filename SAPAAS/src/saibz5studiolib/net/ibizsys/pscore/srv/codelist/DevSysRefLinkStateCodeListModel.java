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

@CodeList(id="6d1a685f16eb2100bc5037b2b938a9d7", name="\u5f00\u53d1\u7cfb\u7edf\u5f15\u7528\u94fe\u63a5\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u672a\u521b\u5efa", realtext="\u672a\u521b\u5efa"), @CodeItem(value="20", text="\u521b\u5efa\u4e2d", realtext="\u521b\u5efa\u4e2d"), @CodeItem(value="30", text="\u5df2\u521b\u5efa", realtext="\u5df2\u521b\u5efa"), @CodeItem(value="40", text="\u521b\u5efa\u5931\u8d25", realtext="\u521b\u5efa\u5931\u8d25"), @CodeItem(value="41", text="\u5907\u4efd\u94fe\u63a5\u65e0\u6548", realtext="\u5907\u4efd\u94fe\u63a5\u65e0\u6548"), @CodeItem(value="42", text="\u5907\u4efd\u94fe\u63a5\u672a\u6388\u6743", realtext="\u5907\u4efd\u94fe\u63a5\u672a\u6388\u6743")})
public class DevSysRefLinkStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOTCREATED = 10;
    public static final int INT_NOTCREATED = 10;
    public static final Integer CREATING = 20;
    public static final int INT_CREATING = 20;
    public static final Integer CREATED = 30;
    public static final int INT_CREATED = 30;
    public static final Integer FAILED = 40;
    public static final int INT_FAILED = 40;
    public static final Integer LINKFAILED = 41;
    public static final int INT_LINKFAILED = 41;
    public static final Integer LINKUNAUTHORIZED = 42;
    public static final int INT_LINKUNAUTHORIZED = 42;

    public DevSysRefLinkStateCodeListModel() {
        this.initAnnotation(DevSysRefLinkStateCodeListModel.class);
        this.setUserData2("DevSysRefLinkState");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSysRefLinkStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSysRefLinkStateCodeListModel");
    }
}

