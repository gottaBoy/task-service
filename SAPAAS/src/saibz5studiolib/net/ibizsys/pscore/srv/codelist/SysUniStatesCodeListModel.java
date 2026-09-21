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

@CodeList(id="0790bb7200e307c199e98ec81ad92f28", name="\u7cfb\u7edf\u72b6\u6001\u534f\u8c03\u72b6\u6001\u5c5e\u6027", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="STATE1", text="\u72b6\u60011", realtext="\u72b6\u60011"), @CodeItem(value="STATE2", text="\u72b6\u60012", realtext="\u72b6\u60012"), @CodeItem(value="STATE3", text="\u72b6\u60013", realtext="\u72b6\u60013"), @CodeItem(value="STATE4", text="\u72b6\u60014", realtext="\u72b6\u60014"), @CodeItem(value="STATE5", text="\u72b6\u60015", realtext="\u72b6\u60015"), @CodeItem(value="STATE6", text="\u72b6\u60016", realtext="\u72b6\u60016"), @CodeItem(value="STATE7", text="\u72b6\u60017", realtext="\u72b6\u60017"), @CodeItem(value="STATE8", text="\u72b6\u60018", realtext="\u72b6\u60018")})
public class SysUniStatesCodeListModel
extends StaticCodeListModelBase {
    public static final String STATE1 = "STATE1";
    public static final String STATE2 = "STATE2";
    public static final String STATE3 = "STATE3";
    public static final String STATE4 = "STATE4";
    public static final String STATE5 = "STATE5";
    public static final String STATE6 = "STATE6";
    public static final String STATE7 = "STATE7";
    public static final String STATE8 = "STATE8";

    public SysUniStatesCodeListModel() {
        this.initAnnotation(SysUniStatesCodeListModel.class);
        this.setUserData2("UniState");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysUniStatesCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysUniStatesCodeListModel");
    }
}

