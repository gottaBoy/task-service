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

@CodeList(id="03925105af739a3cb7b42ac93c703919", name="\u5e73\u53f0\u5fae\u670d\u52a1\u5e73\u53f0\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="IBIZCLOUD", text="iBizCloud", realtext="iBizCloud"), @CodeItem(value="SPRINGCLOUD", text="SpringCloud", realtext="SpringCloud"), @CodeItem(value="DUBBO", text="Dubbo", realtext="Dubbo")})
public class MSPlatformTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String IBIZCLOUD = "IBIZCLOUD";
    public static final String SPRINGCLOUD = "SPRINGCLOUD";
    public static final String DUBBO = "DUBBO";

    public MSPlatformTypeCodeListModel() {
        this.initAnnotation(MSPlatformTypeCodeListModel.class);
        this.setUserData2("MSPlatformType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.MSPlatformTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MSPlatformTypeCodeListModel");
    }
}

