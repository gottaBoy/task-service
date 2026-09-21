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

@CodeList(id="1d1681509772014927fd74e25870d868", name="\u7cfb\u7edf\u6d88\u606f\u961f\u5217\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="RUNTIME", text="Runtime", realtext="Runtime"), @CodeItem(value="DE", text="\u5b9e\u4f53", realtext="\u5b9e\u4f53"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class SysMsgQueueTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String RUNTIME = "RUNTIME";
    public static final String DE = "DE";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public SysMsgQueueTypeCodeListModel() {
        this.initAnnotation(SysMsgQueueTypeCodeListModel.class);
        this.setUserData2("MsgQueueType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysMsgQueueTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysMsgQueueTypeCodeListModel");
    }
}

