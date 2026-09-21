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

@CodeList(id="2E1E2DB2-3957-43AA-8A11-CA24FB927684", name="AI\u6784\u5efa\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u672a\u6784\u5efa", realtext="\u672a\u6784\u5efa"), @CodeItem(value="10", text="\u9009\u9879\u8bf7\u6c42\u4e2d", realtext="\u9009\u9879\u8bf7\u6c42\u4e2d"), @CodeItem(value="11", text="\u9009\u9879\u5df2\u53cd\u9988", realtext="\u9009\u9879\u5df2\u53cd\u9988"), @CodeItem(value="12", text="\u9009\u9879\u5df2\u786e\u8ba4", realtext="\u9009\u9879\u5df2\u786e\u8ba4"), @CodeItem(value="13", text="\u9009\u9879\u5df2\u5931\u8d25", realtext="\u9009\u9879\u5df2\u5931\u8d25"), @CodeItem(value="20", text="\u6a21\u578b\u8bf7\u6c42\u4e2d", realtext="\u6a21\u578b\u8bf7\u6c42\u4e2d"), @CodeItem(value="21", text="\u6a21\u578b\u5df2\u53cd\u9988", realtext="\u6a21\u578b\u5df2\u53cd\u9988"), @CodeItem(value="22", text="\u6a21\u578b\u5df2\u786e\u8ba4", realtext="\u6a21\u578b\u5df2\u786e\u8ba4"), @CodeItem(value="23", text="\u6a21\u578b\u5df2\u5931\u8d25", realtext="\u6a21\u578b\u5df2\u5931\u8d25"), @CodeItem(value="30", text="Agent\u8bf7\u6c42\u4e2d", realtext="Agent\u8bf7\u6c42\u4e2d"), @CodeItem(value="31", text="Agent\u5df2\u53cd\u9988", realtext="Agent\u5df2\u53cd\u9988"), @CodeItem(value="32", text="Agent\u5df2\u786e\u8ba4", realtext="Agent\u5df2\u786e\u8ba4"), @CodeItem(value="33", text="Agent\u5df2\u5931\u8d25", realtext="Agent\u5df2\u5931\u8d25"), @CodeItem(value="99", text="\u6784\u5efa\u7ed3\u675f", realtext="\u6784\u5efa\u7ed3\u675f")})
public class AIBuildStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOTSTARTED = 0;
    public static final int INT_NOTSTARTED = 0;
    public static final Integer CHOICESREQUESTING = 10;
    public static final int INT_CHOICESREQUESTING = 10;
    public static final Integer CHOICESRESPONDED = 11;
    public static final int INT_CHOICESRESPONDED = 11;
    public static final Integer CHOICESCONFIRMED = 12;
    public static final int INT_CHOICESCONFIRMED = 12;
    public static final Integer CHOICESFAILED = 13;
    public static final int INT_CHOICESFAILED = 13;
    public static final Integer MODELREQUESTING = 20;
    public static final int INT_MODELREQUESTING = 20;
    public static final Integer MODELRESPONDED = 21;
    public static final int INT_MODELRESPONDED = 21;
    public static final Integer MODELCONFIRMED = 22;
    public static final int INT_MODELCONFIRMED = 22;
    public static final Integer MODELFAILED = 23;
    public static final int INT_MODELFAILED = 23;
    public static final Integer AGENTREQUESTING = 30;
    public static final int INT_AGENTREQUESTING = 30;
    public static final Integer AGENTRESPONDED = 31;
    public static final int INT_AGENTRESPONDED = 31;
    public static final Integer AGENTCONFIRMED = 32;
    public static final int INT_AGENTCONFIRMED = 32;
    public static final Integer AGENTFAILED = 33;
    public static final int INT_AGENTFAILED = 33;
    public static final Integer FINISHED = 99;
    public static final int INT_FINISHED = 99;

    public AIBuildStateCodeListModel() {
        this.initAnnotation(AIBuildStateCodeListModel.class);
        this.setUserData2("AIBuildState");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AIBuildStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AIBuildStateCodeListModel");
    }
}

