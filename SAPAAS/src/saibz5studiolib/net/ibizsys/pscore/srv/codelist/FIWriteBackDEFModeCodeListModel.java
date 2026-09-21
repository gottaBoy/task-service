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

@CodeList(id="2d33eed4d149b24a19ff96c351963efb", name="\u8868\u5355\u9879\u56de\u5199\u5c5e\u6027\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0", realtext="\u65e0", userdata="\u4e0d\u56de\u586b"), @CodeItem(value="1", text="\u59cb\u7ec8\u56de\u5199", realtext="\u59cb\u7ec8\u56de\u5199", userdata="\u59cb\u7ec8\u56de\u586b"), @CodeItem(value="2", text="\u542f\u7528\u56de\u5199", realtext="\u542f\u7528\u56de\u5199", userdata="\u8868\u5355\u9879\u5904\u4e8e\u542f\u7528\u72b6\u6001\u65f6\u8fdb\u884c\u56de\u586b")})
public class FIWriteBackDEFModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer ALWAYS = 1;
    public static final int INT_ALWAYS = 1;
    public static final Integer ENABLED = 2;
    public static final int INT_ENABLED = 2;

    public FIWriteBackDEFModeCodeListModel() {
        this.initAnnotation(FIWriteBackDEFModeCodeListModel.class);
        this.setUserData2("EditItemWriteBackMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FIWriteBackDEFModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FIWriteBackDEFModeCodeListModel");
    }
}

