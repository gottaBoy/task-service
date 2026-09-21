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

@CodeList(id="761c3eb7a4b1db8bd0b9f61133aad42f", name="\u4e91\u5e94\u7528\u4e2d\u5fc3\u673a\u5668\u4eba\u65e5\u5fd7\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SYSBKTASK", text="\u6267\u884c\u7cfb\u7edf\u540e\u53f0\u4efb\u52a1", realtext="\u6267\u884c\u7cfb\u7edf\u540e\u53f0\u4efb\u52a1"), @CodeItem(value="DCBKTASK", text="\u6267\u884c\u4e2d\u5fc3\u540e\u53f0\u4efb\u52a1", realtext="\u6267\u884c\u4e2d\u5fc3\u540e\u53f0\u4efb\u52a1"), @CodeItem(value="INCENERGY", text="\u589e\u52a0\u80fd\u91cf", realtext="\u589e\u52a0\u80fd\u91cf"), @CodeItem(value="DECENERGY", text="\u964d\u4f4e\u80fd\u91cf", realtext="\u964d\u4f4e\u80fd\u91cf")})
public class DCRobotLogTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SYSBKTASK = "SYSBKTASK";
    public static final String DCBKTASK = "DCBKTASK";
    public static final String INCENERGY = "INCENERGY";
    public static final String DECENERGY = "DECENERGY";

    public DCRobotLogTypeCodeListModel() {
        this.initAnnotation(DCRobotLogTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DCRobotLogTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DCRobotLogTypeCodeListModel");
    }
}

