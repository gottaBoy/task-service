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

@CodeList(id="d9bfee1f532c78ca24ba251dc4a34d52", name="\u4e91\u5e94\u7528\u65b9\u6848\u8bbf\u95ee\u5bf9\u8c61", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u5f00\u53d1\u65b9\u6848", realtext="\u5f00\u53d1\u65b9\u6848"), @CodeItem(value="0", text="\u5f00\u53d1\u7cfb\u7edf", realtext="\u5f00\u53d1\u7cfb\u7edf"), @CodeItem(value="2", text="\u5f00\u53d1\u6a21\u677f", realtext="\u5f00\u53d1\u6a21\u677f"), @CodeItem(value="3", text="\u5f00\u53d1\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b", realtext="\u5f00\u53d1\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b")})
public class DevSlnUserTargetCodeListModel
extends StaticCodeListModelBase {
    public static final Integer ALL = 1;
    public static final int INT_ALL = 1;
    public static final Integer SYS = 0;
    public static final int INT_SYS = 0;
    public static final Integer TEMPL = 2;
    public static final int INT_TEMPL = 2;
    public static final Integer DYNAINST = 3;
    public static final int INT_DYNAINST = 3;

    public DevSlnUserTargetCodeListModel() {
        this.initAnnotation(DevSlnUserTargetCodeListModel.class);
        this.setUserData2("DevSlnUserTarget");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSlnUserTargetCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSlnUserTargetCodeListModel");
    }
}

