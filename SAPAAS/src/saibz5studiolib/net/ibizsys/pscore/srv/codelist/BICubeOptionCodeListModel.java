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

@CodeList(id="A404CA1F-58B4-402F-9818-FA5A4598E5C5", name="\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53\u9009\u9879", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u5f15\u7528\u68c0\u67e5", realtext="\u5f15\u7528\u68c0\u67e5", userdata="\u8fd4\u56de\u5168\u90e8\u8ba1\u6570\uff0c\u542b\u65e0\u6743\u9650")})
public class BICubeOptionCodeListModel
extends StaticCodeListModelBase {
    public static final Integer REFCHECK = 1;
    public static final int INT_REFCHECK = 1;

    public BICubeOptionCodeListModel() {
        this.initAnnotation(BICubeOptionCodeListModel.class);
        this.setUserData2("BICubeOption");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BICubeOptionCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BICubeOptionCodeListModel");
    }
}

