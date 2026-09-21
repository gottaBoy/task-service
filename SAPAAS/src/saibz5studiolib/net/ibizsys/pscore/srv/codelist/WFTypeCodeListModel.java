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

@CodeList(id="cae6b3b6e6fd7f51810025530c6dc8f5", name="\u5de5\u4f5c\u6d41\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="ORG", text="\u673a\u6784\u6d41\u7a0b", realtext="\u673a\u6784\u6d41\u7a0b", userdata="\u5de5\u4f5c\u6d41\u4e3a\u90e8\u95e8\u95f4\u6d41\u8f6c\u7684\u6d41\u7a0b"), @CodeItem(value="ORGSECTOR", text="\u90e8\u95e8\u6d41\u7a0b", realtext="\u90e8\u95e8\u6d41\u7a0b", userdata="\u5de5\u4f5c\u6d41\u4e3a\u90e8\u95e8\u5185\u90e8\u6d41\u8f6c\u7684\u6d41\u7a0b"), @CodeItem(value="DEFAULT", text="\u9ed8\u8ba4", realtext="\u9ed8\u8ba4")})
public class WFTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String ORG = "ORG";
    public static final String ORGSECTOR = "ORGSECTOR";
    public static final String DEFAULT = "DEFAULT";

    public WFTypeCodeListModel() {
        this.initAnnotation(WFTypeCodeListModel.class);
        this.setUserData2("WFType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WFTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WFTypeCodeListModel");
    }
}

