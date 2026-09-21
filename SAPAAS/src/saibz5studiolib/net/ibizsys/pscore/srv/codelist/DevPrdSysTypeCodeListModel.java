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

@CodeList(id="7d062c26969f194ef32083a34562e5d2", name="\u5f00\u53d1\u4ea7\u54c1\u7cfb\u7edf\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TRUNK", text="\u4e3b\u5e72\u7cfb\u7edf", realtext="\u4e3b\u5e72\u7cfb\u7edf"), @CodeItem(value="TEST", text="\u6d4b\u8bd5\u7cfb\u7edf", realtext="\u6d4b\u8bd5\u7cfb\u7edf"), @CodeItem(value="DEVELOP", text="\u5f00\u53d1\u7cfb\u7edf", realtext="\u5f00\u53d1\u7cfb\u7edf")})
public class DevPrdSysTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String TRUNK = "TRUNK";
    public static final String TEST = "TEST";
    public static final String DEVELOP = "DEVELOP";

    public DevPrdSysTypeCodeListModel() {
        this.initAnnotation(DevPrdSysTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevPrdSysTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevPrdSysTypeCodeListModel");
    }
}

