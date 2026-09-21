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

@CodeList(id="2c0d9273a3a53fda45cb0b1a79860283", name="\u7cfb\u7edf\u540e\u53f0\u4f53\u7cfb\u52a8\u6001\u6a21\u578b\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u4e0d\u4f7f\u7528", realtext="\u4e0d\u4f7f\u7528"), @CodeItem(value="PUB", text="\u4ec5\u53d1\u5e03", realtext="\u4ec5\u53d1\u5e03"), @CodeItem(value="RUNTIME", text="\u8fd0\u884c\u65f6", realtext="\u8fd0\u884c\u65f6"), @CodeItem(value="GENCODE", text="\u4ee3\u7801\u751f\u4ea7", realtext="\u4ee3\u7801\u751f\u4ea7")})
public class SysSFPubDynaModelModeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String PUB = "PUB";
    public static final String RUNTIME = "RUNTIME";
    public static final String GENCODE = "GENCODE";

    public SysSFPubDynaModelModeCodeListModel() {
        this.initAnnotation(SysSFPubDynaModelModeCodeListModel.class);
        this.setUserData2("SFPubDynaModelMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysSFPubDynaModelModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysSFPubDynaModelModeCodeListModel");
    }
}

