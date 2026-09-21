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

@CodeList(id="7f2245cb311fa82522163471e2d93446", name="\u4e91\u5e94\u7528\u4e2d\u5fc3\u65e5\u5fd7\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="USERCREATE", text="\u7528\u6237\u5efa\u7acb", realtext="\u7528\u6237\u5efa\u7acb"), @CodeItem(value="USERREMOVE", text="\u7528\u6237\u5220\u9664", realtext="\u7528\u6237\u5220\u9664"), @CodeItem(value="USERLOGIN", text="\u7528\u6237\u767b\u5f55", realtext="\u7528\u6237\u767b\u5f55"), @CodeItem(value="DEVSLNCREATE", text="\u5f00\u53d1\u65b9\u6848\u5efa\u7acb", realtext="\u5f00\u53d1\u65b9\u6848\u5efa\u7acb"), @CodeItem(value="DEVSLNREMOVE", text="\u5f00\u53d1\u65b9\u6848\u5220\u9664", realtext="\u5f00\u53d1\u65b9\u6848\u5220\u9664"), @CodeItem(value="DEPSLNCREATE", text="\u90e8\u7f72\u65b9\u6848\u5efa\u7acb", realtext="\u90e8\u7f72\u65b9\u6848\u5efa\u7acb"), @CodeItem(value="DEPSLNREMOVE", text="\u90e8\u7f72\u65b9\u6848\u5220\u9664", realtext="\u90e8\u7f72\u65b9\u6848\u5220\u9664")})
public class DevCenterLogTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String USERCREATE = "USERCREATE";
    public static final String USERREMOVE = "USERREMOVE";
    public static final String USERLOGIN = "USERLOGIN";
    public static final String DEVSLNCREATE = "DEVSLNCREATE";
    public static final String DEVSLNREMOVE = "DEVSLNREMOVE";
    public static final String DEPSLNCREATE = "DEPSLNCREATE";
    public static final String DEPSLNREMOVE = "DEPSLNREMOVE";

    public DevCenterLogTypeCodeListModel() {
        this.initAnnotation(DevCenterLogTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevCenterLogTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevCenterLogTypeCodeListModel");
    }
}

