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

@CodeList(id="4764198ccb7a427821cb9d21a529de5e", name="\u5b9e\u4f53\u63a5\u53e3\u6570\u636e\u5173\u7cfb\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u65b0\u5efa", realtext="\u65b0\u5efa"), @CodeItem(value="2", text="\u66f4\u65b0", realtext="\u66f4\u65b0"), @CodeItem(value="4", text="\u83b7\u53d6", realtext="\u83b7\u53d6"), @CodeItem(value="8", text="\u67e5\u8be2", realtext="\u67e5\u8be2")})
public class DESADataRSModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer CREATE = 1;
    public static final int INT_CREATE = 1;
    public static final Integer UPDATE = 2;
    public static final int INT_UPDATE = 2;
    public static final Integer GET = 4;
    public static final int INT_GET = 4;
    public static final Integer SELECT = 8;
    public static final int INT_SELECT = 8;

    public DESADataRSModeCodeListModel() {
        this.initAnnotation(DESADataRSModeCodeListModel.class);
        this.setUserData2("SADEDataRSMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DESADataRSModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DESADataRSModeCodeListModel");
    }
}

