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

@CodeList(id="72f7f0436a4002c52725dbe85a7264fb", name="\u5f00\u53d1\u7cfb\u7edf\u5fae\u670d\u52a1\u90e8\u7f72\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u672a\u90e8\u7f72", realtext="\u672a\u90e8\u7f72"), @CodeItem(value="20", text="\u5df2\u90e8\u7f72", realtext="\u5df2\u90e8\u7f72"), @CodeItem(value="30", text="\u90e8\u7f72\u5931\u8d25", realtext="\u90e8\u7f72\u5931\u8d25")})
public class MSDeployItemStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOTDEPLOY = 10;
    public static final int INT_NOTDEPLOY = 10;
    public static final Integer DEPLOYED = 20;
    public static final int INT_DEPLOYED = 20;
    public static final Integer DEPLOYFAILED = 30;
    public static final int INT_DEPLOYFAILED = 30;

    public MSDeployItemStateCodeListModel() {
        this.initAnnotation(MSDeployItemStateCodeListModel.class);
        this.setUserData2("MSDeployItemState");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.MSDeployItemStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MSDeployItemStateCodeListModel");
    }
}

