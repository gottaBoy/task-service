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

@CodeList(id="a3fc9589df3c455fef2f7170e3dd25b3", name="\u4e91\u5e94\u7528\u4e2d\u5fc3\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEVCENTER", text="\u5f00\u53d1\u4e2d\u5fc3", realtext="\u5f00\u53d1\u4e2d\u5fc3"), @CodeItem(value="SPCENTER", text="\u670d\u52a1\u4e2d\u5fc3", realtext="\u670d\u52a1\u4e2d\u5fc3"), @CodeItem(value="RUNCENTER", text="\u8fd0\u884c\u4e2d\u5fc3", realtext="\u8fd0\u884c\u4e2d\u5fc3")})
public class DCTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEVCENTER = "DEVCENTER";
    public static final String SPCENTER = "SPCENTER";
    public static final String RUNCENTER = "RUNCENTER";

    public DCTypeCodeListModel() {
        this.initAnnotation(DCTypeCodeListModel.class);
        this.setUserData2("DevCenterType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DCTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DCTypeCodeListModel");
    }
}

