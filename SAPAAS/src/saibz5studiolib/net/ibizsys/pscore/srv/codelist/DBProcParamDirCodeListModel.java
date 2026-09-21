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

@CodeList(id="23555b84606ae05c71869b72db29eb69", name="\u5b58\u50a8\u8fc7\u7a0b\u53c2\u6570\u65b9\u5411", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="Input", realtext="Input", userdata="\u8f93\u5165\u53c2\u6570"), @CodeItem(value="2", text="Output", realtext="Output", userdata="\u8f93\u51fa\u53c2\u6570"), @CodeItem(value="3", text="InputOutput", realtext="InputOutput", userdata="\u8f93\u5165\u8f93\u51fa\u53c2\u6570"), @CodeItem(value="4", text="ReturnValue", realtext="ReturnValue"), @CodeItem(value="5", text="None", realtext="None")})
public class DBProcParamDirCodeListModel
extends StaticCodeListModelBase {
    public static final Integer INPUT = 1;
    public static final int INT_INPUT = 1;
    public static final Integer OUTPUT = 2;
    public static final int INT_OUTPUT = 2;
    public static final Integer INPUTOUTPUT = 3;
    public static final int INT_INPUTOUTPUT = 3;
    public static final Integer RETURNVALUE = 4;
    public static final int INT_RETURNVALUE = 4;
    public static final Integer NONE = 5;
    public static final int INT_NONE = 5;

    public DBProcParamDirCodeListModel() {
        this.initAnnotation(DBProcParamDirCodeListModel.class);
        this.setUserData("IGNOREMODELDSLNAME");
        this.setUserData2("DBProcParamDir");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DBProcParamDirCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DBProcParamDirCodeListModel");
    }
}

