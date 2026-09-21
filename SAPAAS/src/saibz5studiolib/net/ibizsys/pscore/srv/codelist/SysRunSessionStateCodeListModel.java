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

@CodeList(id="27198432e824c3e67331e9179c49edbe", name="\u7cfb\u7edf\u8fd0\u884c\u4f1a\u8bdd\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u672a\u542f\u52a8", realtext="\u672a\u542f\u52a8"), @CodeItem(value="20", text="\u6b63\u5728\u8fd0\u884c", realtext="\u6b63\u5728\u8fd0\u884c"), @CodeItem(value="30", text="\u5df2\u7ec8\u6b62", realtext="\u5df2\u7ec8\u6b62")})
public class SysRunSessionStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOTSTARTED = 10;
    public static final int INT_NOTSTARTED = 10;
    public static final Integer RUNNING = 20;
    public static final int INT_RUNNING = 20;
    public static final Integer TERMINATED = 30;
    public static final int INT_TERMINATED = 30;

    public SysRunSessionStateCodeListModel() {
        this.initAnnotation(SysRunSessionStateCodeListModel.class);
        this.setUserData2("SysRunSessionState");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysRunSessionStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysRunSessionStateCodeListModel");
    }
}

