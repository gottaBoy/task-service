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

@CodeList(id="44deafb8efea3224c7ca392a92b03f61", name="\u5e94\u7528\u4e2d\u5fc3\u7ea7\u522b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="Lab\u793e\u533a\u7248\uff08\u9ed8\u8ba4\uff09", realtext="Lab\u793e\u533a\u7248\uff08\u9ed8\u8ba4\uff09"), @CodeItem(value="20", text="Lab\u793e\u533a\u7248\uff08\u4ed8\u8d39\uff09", realtext="Lab\u793e\u533a\u7248\uff08\u4ed8\u8d39\uff09"), @CodeItem(value="30", text="Lab\u793e\u533a\u7248\uff08\u9ad8\u7ea7\uff09", realtext="Lab\u793e\u533a\u7248\uff08\u9ad8\u7ea7\uff09"), @CodeItem(value="50", text="Lab\u4e13\u4e1a\u7248", realtext="Lab\u4e13\u4e1a\u7248"), @CodeItem(value="60", text="Lab\u4f01\u4e1a\u7248", realtext="Lab\u4f01\u4e1a\u7248"), @CodeItem(value="99", text="Lab\u8fd0\u8425\u7248", realtext="Lab\u8fd0\u8425\u7248"), @CodeItem(value="100", text="\u793e\u533a\u7248", realtext="\u793e\u533a\u7248"), @CodeItem(value="200", text="\u4e13\u4e1a\u7248", realtext="\u4e13\u4e1a\u7248"), @CodeItem(value="300", text="\u4f01\u4e1a\u7248", realtext="\u4f01\u4e1a\u7248"), @CodeItem(value="400", text="\u9ad8\u7ea7\u4f01\u4e1a\u7248", realtext="\u9ad8\u7ea7\u4f01\u4e1a\u7248")})
public class DCLevelCodeListModel
extends StaticCodeListModelBase {
    public static final Integer LAB_10 = 10;
    public static final int INT_LAB_10 = 10;
    public static final Integer LAB_20 = 20;
    public static final int INT_LAB_20 = 20;
    public static final Integer LAB_30 = 30;
    public static final int INT_LAB_30 = 30;
    public static final Integer LAB_50 = 50;
    public static final int INT_LAB_50 = 50;
    public static final Integer LAB_60 = 60;
    public static final int INT_LAB_60 = 60;
    public static final Integer LAB_99 = 99;
    public static final int INT_LAB_99 = 99;
    public static final Integer COMMUNITY = 100;
    public static final int INT_COMMUNITY = 100;
    public static final Integer PROFESSIONAL = 200;
    public static final int INT_PROFESSIONAL = 200;
    public static final Integer ENTERPRISE = 300;
    public static final int INT_ENTERPRISE = 300;
    public static final Integer ADVENTERPRISE = 400;
    public static final int INT_ADVENTERPRISE = 400;

    public DCLevelCodeListModel() {
        this.initAnnotation(DCLevelCodeListModel.class);
        this.setUserData2("DevCenterLevel");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DCLevelCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DCLevelCodeListModel");
    }
}

