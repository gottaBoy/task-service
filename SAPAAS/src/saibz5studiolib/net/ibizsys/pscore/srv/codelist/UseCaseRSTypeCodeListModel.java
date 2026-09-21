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

@CodeList(id="33c99e8cc351af667432781d7199d2f0", name="\u7cfb\u7edf\u7528\u4f8b\u5173\u7cfb\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="ASSOCIATION", text="\u5173\u8054(Association)", realtext="\u5173\u8054(Association)"), @CodeItem(value="INHERITANCE", text="\u6cdb\u5316(Inheritance)", realtext="\u6cdb\u5316(Inheritance)"), @CodeItem(value="INCLUDE", text="\u5305\u542b(Include)", realtext="\u5305\u542b(Include)"), @CodeItem(value="EXTEND", text="\u6269\u5c55(Extend)", realtext="\u6269\u5c55(Extend)")})
public class UseCaseRSTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String ASSOCIATION = "ASSOCIATION";
    public static final String INHERITANCE = "INHERITANCE";
    public static final String INCLUDE = "INCLUDE";
    public static final String EXTEND = "EXTEND";

    public UseCaseRSTypeCodeListModel() {
        this.initAnnotation(UseCaseRSTypeCodeListModel.class);
        this.setUserData2("UseCaseRSType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.UseCaseRSTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.UseCaseRSTypeCodeListModel");
    }
}

