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

@CodeList(id="097724a74d1a48287d1c406c5eeb8855", name="\u5de5\u4f5c\u6d41\u89d2\u8272\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="USERGROUP", text="\u7528\u6237\u7ec4", realtext="\u7528\u6237\u7ec4"), @CodeItem(value="SYSUSERROLE", text="\u7cfb\u7edf\u89d2\u8272", realtext="\u7cfb\u7edf\u89d2\u8272"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49"), @CodeItem(value="DEDATASET", text="\u5b9e\u4f53\u6570\u636e\u96c6\u5408", realtext="\u5b9e\u4f53\u6570\u636e\u96c6\u5408"), @CodeItem(value="ORG", text="\u5f53\u524d\u7ec4\u7ec7", realtext="\u5f53\u524d\u7ec4\u7ec7"), @CodeItem(value="PORG", text="\u5f53\u524d\u7ec4\u7ec7\u7236\u7ec4\u7ec7", realtext="\u5f53\u524d\u7ec4\u7ec7\u7236\u7ec4\u7ec7"), @CodeItem(value="ORGSECTOR", text="\u5f53\u524d\u90e8\u95e8", realtext="\u5f53\u524d\u90e8\u95e8"), @CodeItem(value="PORGSECTOR", text="\u5f53\u524d\u90e8\u95e8\u7236\u90e8\u95e8", realtext="\u5f53\u524d\u90e8\u95e8\u7236\u90e8\u95e8"), @CodeItem(value="ORGGROUP", text="\u673a\u6784\u7ec4", realtext="\u673a\u6784\u7ec4"), @CodeItem(value="ORGSECTORGROUP", text="\u90e8\u95e8\u7ec4", realtext="\u90e8\u95e8\u7ec4"), @CodeItem(value="ORGUSERGROUP", text="\u673a\u6784\u4eba\u5458\u7ec4", realtext="\u673a\u6784\u4eba\u5458\u7ec4"), @CodeItem(value="ORGSECTORUSERGROUP", text="\u90e8\u95e8\u4eba\u5458\u7ec4", realtext="\u90e8\u95e8\u4eba\u5458\u7ec4"), @CodeItem(value="ORGADMIN", text="\u5f53\u524d\u7ec4\u7ec7\u7ba1\u7406\u5458", realtext="\u5f53\u524d\u7ec4\u7ec7\u7ba1\u7406\u5458"), @CodeItem(value="ORGSECTORADMIN", text="\u5f53\u524d\u90e8\u95e8\u7ba1\u7406\u5458", realtext="\u5f53\u524d\u90e8\u95e8\u7ba1\u7406\u5458")})
public class WFRoleTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String USERGROUP = "USERGROUP";
    public static final String SYSUSERROLE = "SYSUSERROLE";
    public static final String CUSTOM = "CUSTOM";
    public static final String DEDATASET = "DEDATASET";
    public static final String ORG = "ORG";
    public static final String PORG = "PORG";
    public static final String ORGSECTOR = "ORGSECTOR";
    public static final String PORGSECTOR = "PORGSECTOR";
    public static final String ORGGROUP = "ORGGROUP";
    public static final String ORGSECTORGROUP = "ORGSECTORGROUP";
    public static final String ORGUSERGROUP = "ORGUSERGROUP";
    public static final String ORGSECTORUSERGROUP = "ORGSECTORUSERGROUP";
    public static final String ORGADMIN = "ORGADMIN";
    public static final String ORGSECTORADMIN = "ORGSECTORADMIN";

    public WFRoleTypeCodeListModel() {
        this.initAnnotation(WFRoleTypeCodeListModel.class);
        this.setUserData2("WFRoleType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WFRoleTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WFRoleTypeCodeListModel");
    }
}

