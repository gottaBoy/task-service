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

@CodeList(id="fbf0ab1cf754638ec532216cf81b61fe", name="\u5c5e\u6027\u5b9e\u4f53\u4e3b\u72b6\u6001\u503c", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="STATE1", text="\u72b6\u6001\u5c5e\u60271", realtext="\u72b6\u6001\u5c5e\u60271"), @CodeItem(value="STATE2", text="\u72b6\u6001\u5c5e\u60272", realtext="\u72b6\u6001\u5c5e\u60272"), @CodeItem(value="STATE3", text="\u72b6\u6001\u5c5e\u60273", realtext="\u72b6\u6001\u5c5e\u60273")})
public class DEMSFieldModeCodeListModel
extends StaticCodeListModelBase {
    public static final String STATE1 = "STATE1";
    public static final String STATE2 = "STATE2";
    public static final String STATE3 = "STATE3";

    public DEMSFieldModeCodeListModel() {
        this.initAnnotation(DEMSFieldModeCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("DEMSFieldMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMSFieldModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMSFieldModeCodeListModel");
    }
}

