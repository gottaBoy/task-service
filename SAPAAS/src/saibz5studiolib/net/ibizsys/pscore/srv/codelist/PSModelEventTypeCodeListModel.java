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

@CodeList(id="1cc04e3f5a8065f98aaacbdaa78a8c54", name="\u6a21\u578b\u70ed\u4ee3\u7801\u89e6\u53d1\u70b9", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="BEFOREGETDRAFT", text="\u83b7\u53d6\u8349\u7a3f\u6570\u636e\uff08\u4e4b\u524d\uff09", realtext="\u83b7\u53d6\u8349\u7a3f\u6570\u636e\uff08\u4e4b\u524d\uff09"), @CodeItem(value="AFTERGETDRAFT", text="\u83b7\u53d6\u8349\u7a3f\u6570\u636e\uff08\u4e4b\u540e\uff09", realtext="\u83b7\u53d6\u8349\u7a3f\u6570\u636e\uff08\u4e4b\u540e\uff09"), @CodeItem(value="BEFORECREATE", text="\u5efa\u7acb\u6570\u636e\uff08\u4e4b\u524d\uff09", realtext="\u5efa\u7acb\u6570\u636e\uff08\u4e4b\u524d\uff09"), @CodeItem(value="AFTERCREATE", text="\u5efa\u7acb\u6570\u636e\uff08\u4e4b\u540e\uff09", realtext="\u5efa\u7acb\u6570\u636e\uff08\u4e4b\u540e\uff09"), @CodeItem(value="BEFOREUPDATE", text="\u66f4\u65b0\u6570\u636e\uff08\u4e4b\u524d\uff09", realtext="\u66f4\u65b0\u6570\u636e\uff08\u4e4b\u524d\uff09"), @CodeItem(value="AFTERUPDATE", text="\u66f4\u65b0\u6570\u636e\uff08\u4e4b\u540e\uff09", realtext="\u66f4\u65b0\u6570\u636e\uff08\u4e4b\u540e\uff09"), @CodeItem(value="BEFOREREMOVE", text="\u5220\u9664\u6570\u636e\uff08\u4e4b\u524d\uff09", realtext="\u5220\u9664\u6570\u636e\uff08\u4e4b\u524d\uff09"), @CodeItem(value="AFTERREMOVE", text="\u5220\u9664\u6570\u636e\uff08\u4e4b\u540e\uff09", realtext="\u5220\u9664\u6570\u636e\uff08\u4e4b\u540e\uff09")})
public class PSModelEventTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String BEFOREGETDRAFT = "BEFOREGETDRAFT";
    public static final String AFTERGETDRAFT = "AFTERGETDRAFT";
    public static final String BEFORECREATE = "BEFORECREATE";
    public static final String AFTERCREATE = "AFTERCREATE";
    public static final String BEFOREUPDATE = "BEFOREUPDATE";
    public static final String AFTERUPDATE = "AFTERUPDATE";
    public static final String BEFOREREMOVE = "BEFOREREMOVE";
    public static final String AFTERREMOVE = "AFTERREMOVE";

    public PSModelEventTypeCodeListModel() {
        this.initAnnotation(PSModelEventTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PSModelEventTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PSModelEventTypeCodeListModel");
    }
}

