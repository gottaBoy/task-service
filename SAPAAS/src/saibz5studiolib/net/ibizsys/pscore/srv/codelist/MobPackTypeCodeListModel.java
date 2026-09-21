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

@CodeList(id="6fd2ee3b1e0e127edcb9d32e8103baa2", name="\u79fb\u52a8\u7aef\u6253\u5305\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TEST", text="\u6d4b\u8bd5\u7248\u672c", realtext="\u6d4b\u8bd5\u7248\u672c"), @CodeItem(value="OFFICIAL", text="\u6b63\u5f0f\u7248", realtext="\u6b63\u5f0f\u7248")})
public class MobPackTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String TEST = "TEST";
    public static final String OFFICIAL = "OFFICIAL";

    public MobPackTypeCodeListModel() {
        this.initAnnotation(MobPackTypeCodeListModel.class);
        this.setUserData2("MobAppPackType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.MobPackTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MobPackTypeCodeListModel");
    }
}

