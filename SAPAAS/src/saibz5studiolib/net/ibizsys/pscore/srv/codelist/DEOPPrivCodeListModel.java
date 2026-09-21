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

@CodeList(id="e596ad10a27c539eed737350b84e16a4", name="\u7cfb\u7edf\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="CREATE", text="\u5efa\u7acb", realtext="\u5efa\u7acb"), @CodeItem(value="READ", text="\u8bfb\u53d6", realtext="\u8bfb\u53d6"), @CodeItem(value="UPDATE", text="\u66f4\u65b0", realtext="\u66f4\u65b0"), @CodeItem(value="DELETE", text="\u5220\u9664", realtext="\u5220\u9664"), @CodeItem(value="MODIFYCHILD", text="\u4fee\u6539\u5b50\u6570\u636e", realtext="\u4fee\u6539\u5b50\u6570\u636e"), @CodeItem(value="WFSTART", text="\u6d41\u7a0b\u542f\u52a8", realtext="\u6d41\u7a0b\u542f\u52a8"), @CodeItem(value="WFACTION", text="\u5de5\u4f5c\u6d41\u64cd\u4f5c", realtext="\u5de5\u4f5c\u6d41\u64cd\u4f5c"), @CodeItem(value="WFRESTART", text="\u6d41\u7a0b\u91cd\u542f\u52a8", realtext="\u6d41\u7a0b\u91cd\u542f\u52a8"), @CodeItem(value="WFCANCEL", text="\u6d41\u7a0b\u53d6\u6d88", realtext="\u6d41\u7a0b\u53d6\u6d88")})
public class DEOPPrivCodeListModel
extends StaticCodeListModelBase {
    public static final String CREATE = "CREATE";
    public static final String READ = "READ";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE = "DELETE";
    public static final String MODIFYCHILD = "MODIFYCHILD";
    public static final String WFSTART = "WFSTART";
    public static final String WFACTION = "WFACTION";
    public static final String WFRESTART = "WFRESTART";
    public static final String WFCANCEL = "WFCANCEL";

    public DEOPPrivCodeListModel() {
        this.initAnnotation(DEOPPrivCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEOPPrivCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEOPPrivCodeListModel");
    }
}

