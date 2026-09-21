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

@CodeList(id="2dae5abdcefd0cc16460662acc20d8ce", name="\u63a5\u53e3\u5b9e\u4f53\u6a21\u578b\u9884\u5b9a\u4e49\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="RESPONSERESULT", text="\u8fd4\u56de\u7ed3\u679c", realtext="\u8fd4\u56de\u7ed3\u679c"), @CodeItem(value="PAGE", text="\u67e5\u8be2\u5206\u9875", realtext="\u67e5\u8be2\u5206\u9875"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class SubSysSADEPredefinedTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String RESPONSERESULT = "RESPONSERESULT";
    public static final String PAGE = "PAGE";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public SubSysSADEPredefinedTypeCodeListModel() {
        this.initAnnotation(SubSysSADEPredefinedTypeCodeListModel.class);
        this.setUserData2("SubSysSADEPredefinedType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SubSysSADEPredefinedTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SubSysSADEPredefinedTypeCodeListModel");
    }
}

