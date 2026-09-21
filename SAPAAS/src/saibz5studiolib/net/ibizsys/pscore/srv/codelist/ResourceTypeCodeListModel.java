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

@CodeList(id="58D0D289-C7DD-4E24-910B-1223011135B8", name="\u7cfb\u7edf\u8d44\u6e90\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="IMAGE", text="\u56fe\u7247", realtext="\u56fe\u7247"), @CodeItem(value="STRING", text="\u5b57\u7b26\u4e32", realtext="\u5b57\u7b26\u4e32"), @CodeItem(value="ZIPFILE", text="ZIP\u6587\u4ef6", realtext="ZIP\u6587\u4ef6"), @CodeItem(value="GITPROJECT", text="GIT\u9879\u76ee", realtext="GIT\u9879\u76ee"), @CodeItem(value="SYSCONTENTCAT", text="\u7cfb\u7edf\u5185\u5bb9\u5206\u7c7b", realtext="\u7cfb\u7edf\u5185\u5bb9\u5206\u7c7b"), @CodeItem(value="OSSFILE", text="OSS\u6587\u4ef6", realtext="OSS\u6587\u4ef6"), @CodeItem(value="DEFILE", text="\u5b9e\u4f53\u6587\u4ef6", realtext="\u5b9e\u4f53\u6587\u4ef6"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494"), @CodeItem(value="USER5", text="\u7528\u6237\u81ea\u5b9a\u4e495", realtext="\u7528\u6237\u81ea\u5b9a\u4e495"), @CodeItem(value="USER6", text="\u7528\u6237\u81ea\u5b9a\u4e496", realtext="\u7528\u6237\u81ea\u5b9a\u4e496"), @CodeItem(value="USER7", text="\u7528\u6237\u81ea\u5b9a\u4e497", realtext="\u7528\u6237\u81ea\u5b9a\u4e497"), @CodeItem(value="USER8", text="\u7528\u6237\u81ea\u5b9a\u4e498", realtext="\u7528\u6237\u81ea\u5b9a\u4e498"), @CodeItem(value="USER9", text="\u7528\u6237\u81ea\u5b9a\u4e499", realtext="\u7528\u6237\u81ea\u5b9a\u4e499")})
public class ResourceTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String IMAGE = "IMAGE";
    public static final String STRING = "STRING";
    public static final String ZIPFILE = "ZIPFILE";
    public static final String GITPROJECT = "GITPROJECT";
    public static final String SYSCONTENTCAT = "SYSCONTENTCAT";
    public static final String OSSFILE = "OSSFILE";
    public static final String DEFILE = "DEFILE";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";
    public static final String USER5 = "USER5";
    public static final String USER6 = "USER6";
    public static final String USER7 = "USER7";
    public static final String USER8 = "USER8";
    public static final String USER9 = "USER9";

    public ResourceTypeCodeListModel() {
        this.initAnnotation(ResourceTypeCodeListModel.class);
        this.setUserData2("ResourceType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ResourceTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ResourceTypeCodeListModel");
    }
}

