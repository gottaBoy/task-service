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

@CodeList(id="2e48a1b8d22d9e41abd4bd16a22fdbc2", name="\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u670d\u52a1\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFAULT", text="\u9ed8\u8ba4", realtext="\u9ed8\u8ba4"), @CodeItem(value="IBIZCLOUD", text="iBizCloud", realtext="iBizCloud", userdata="\u5728iBizCloud\u5fae\u670d\u52a1\u5e73\u53f0\u8fd0\u884c\u7684\u63a5\u53e3"), @CodeItem(value="APPLICATION", text="\u5e94\u7528", realtext="\u5e94\u7528"), @CodeItem(value="LOCAL", text="\u672c\u5730\u63a5\u53e3", realtext="\u672c\u5730\u63a5\u53e3", userdata="\u4ec5\u5bf9\u672c\u5730\u63d0\u4f9b\u670d\u52a1\u7684\u63a5\u53e3\uff0c\u5f31\u5b89\u5168\u7ea7\u522b"), @CodeItem(value="MIDDLEPLATFORM", text="\u4e2d\u53f0", realtext="\u4e2d\u53f0"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class ServiceTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFAULT = "DEFAULT";
    public static final String IBIZCLOUD = "IBIZCLOUD";
    public static final String APPLICATION = "APPLICATION";
    public static final String LOCAL = "LOCAL";
    public static final String MIDDLEPLATFORM = "MIDDLEPLATFORM";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public ServiceTypeCodeListModel() {
        this.initAnnotation(ServiceTypeCodeListModel.class);
        this.setUserData2("ServiceType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ServiceTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ServiceTypeCodeListModel");
    }
}

