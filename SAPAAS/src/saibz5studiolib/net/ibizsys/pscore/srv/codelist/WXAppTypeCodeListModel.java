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

@CodeList(id="435d72fe536899c6104166efdcd86930", name="\u5fae\u4fe1\u4f01\u4e1a\u5e94\u7528\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="H5", text="H5\u4e3b\u9875\u578b", realtext="H5\u4e3b\u9875\u578b"), @CodeItem(value="MSG", text="\u6d88\u606f\u54cd\u5e94\u578b", realtext="\u6d88\u606f\u54cd\u5e94\u578b")})
public class WXAppTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String H5 = "H5";
    public static final String MSG = "MSG";

    public WXAppTypeCodeListModel() {
        this.initAnnotation(WXAppTypeCodeListModel.class);
        this.setUserData2("WXAppType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WXAppTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WXAppTypeCodeListModel");
    }
}

