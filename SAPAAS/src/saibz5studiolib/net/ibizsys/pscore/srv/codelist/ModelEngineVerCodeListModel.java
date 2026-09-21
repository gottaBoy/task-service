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

@CodeList(id="EC63FCFB-5F40-4CF0-A066-FCA535349DC2", name="\u6a21\u578b\u5f15\u64ce\u7248\u672c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="239", text="239", realtext="239"), @CodeItem(value="240", text="240", realtext="240", userdata="\uff081\uff09\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u8f93\u51fa\u590d\u6570\u4ee3\u7801\u6807\u8bc6\uff08CodeName2\uff09")})
public class ModelEngineVerCodeListModel
extends StaticCodeListModelBase {
    public static final Integer V239 = 239;
    public static final int INT_V239 = 239;
    public static final Integer V240 = 240;
    public static final int INT_V240 = 240;

    public ModelEngineVerCodeListModel() {
        this.initAnnotation(ModelEngineVerCodeListModel.class);
        this.setUserData2("ModelEngineVer");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelEngineVerCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelEngineVerCodeListModel");
    }
}

