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

@CodeList(id="83cae1264c23ac8d7a8dbf64069bbeb6", name="\u754c\u9762\u884c\u4e3a\u754c\u9762\u903b\u8f91\u9644\u52a0\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="REPLACE", text="\u66ff\u6362\u6267\u884c", realtext="\u66ff\u6362\u6267\u884c", userdata="\u66ff\u6362\u754c\u9762\u884c\u4e3a\u6267\u884c\u903b\u8f91"), @CodeItem(value="AFTER", text="\u6267\u884c\u4e4b\u540e", realtext="\u6267\u884c\u4e4b\u540e", userdata="\u754c\u9762\u884c\u4e3a\u6267\u884c\u540e\u89e6\u53d1")})
public class DEUIActionVLExecModeCodeListModel
extends StaticCodeListModelBase {
    public static final String REPLACE = "REPLACE";
    public static final String AFTER = "AFTER";

    public DEUIActionVLExecModeCodeListModel() {
        this.initAnnotation(DEUIActionVLExecModeCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("UIActionVLExecMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUIActionVLExecModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUIActionVLExecModeCodeListModel");
    }
}

