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

@CodeList(id="80c83b84e37bd95647ddb1227efc04ab", name="\u754c\u9762\u884c\u4e3a\u524d\u53f0\u5904\u7406\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="WIZARD", text="\u6253\u5f00\u89c6\u56fe\u6216\u5411\u5bfc\uff08\u6a21\u6001\uff09", realtext="\u6253\u5f00\u89c6\u56fe\u6216\u5411\u5bfc\uff08\u6a21\u6001\uff09", userdata="\u4f7f\u7528\u6a21\u6001\u6253\u5f00\u6307\u5b9a\u89c6\u56fe"), @CodeItem(value="TOP", text="\u6253\u5f00\u9876\u7ea7\u89c6\u56fe", realtext="\u6253\u5f00\u9876\u7ea7\u89c6\u56fe", userdata="\u5728\u5e94\u7528\u7684\u4e3b\u5bfc\u822a\u533a\u6253\u5f00\u6307\u5b9a\u89c6\u56fe"), @CodeItem(value="PRINT", text="\u6253\u5f00\u6253\u5370\u89c6\u56fe", realtext="\u6253\u5f00\u6253\u5370\u89c6\u56fe"), @CodeItem(value="DATAIMP", text="\u6253\u5f00\u6570\u636e\u5bfc\u5165\u89c6\u56fe", realtext="\u6253\u5f00\u6570\u636e\u5bfc\u5165\u89c6\u56fe"), @CodeItem(value="DATAEXP", text="\u6253\u5f00\u6570\u636e\u5bfc\u51fa\u89c6\u56fe", realtext="\u6253\u5f00\u6570\u636e\u5bfc\u51fa\u89c6\u56fe"), @CodeItem(value="CHAT", text="\u6253\u5f00\u804a\u5929\u754c\u9762", realtext="\u6253\u5f00\u804a\u5929\u754c\u9762"), @CodeItem(value="OPENHTMLPAGE", text="\u6253\u5f00HTML\u9875\u9762", realtext="\u6253\u5f00HTML\u9875\u9762", userdata="\u76f4\u63a5\u6253\u5f00Html\u7f51\u9875"), @CodeItem(value="EDITFORM", text="\u6253\u5f00\u7f16\u8f91\u8868\u5355", realtext="\u6253\u5f00\u7f16\u8f91\u8868\u5355", userdata="\u6253\u5f00\u7f16\u8f91\u8868\u5355\u8fdb\u884c\u7f16\u8f91"), @CodeItem(value="QUICKEDIT", text="\u6253\u5f00\u5feb\u6377\u7f16\u8f91", realtext="\u6253\u5f00\u5feb\u6377\u7f16\u8f91", userdata="\u4f7f\u7528\u8868\u5355\u6a21\u578b\u8fdb\u884c\u5feb\u901f\u7f16\u8f91"), @CodeItem(value="OTHER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49")})
public class DEUIActionFrontTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String WIZARD = "WIZARD";
    public static final String TOP = "TOP";
    public static final String PRINT = "PRINT";
    public static final String DATAIMP = "DATAIMP";
    public static final String DATAEXP = "DATAEXP";
    public static final String CHAT = "CHAT";
    public static final String OPENHTMLPAGE = "OPENHTMLPAGE";
    public static final String EDITFORM = "EDITFORM";
    public static final String QUICKEDIT = "QUICKEDIT";
    public static final String OTHER = "OTHER";

    public DEUIActionFrontTypeCodeListModel() {
        this.initAnnotation(DEUIActionFrontTypeCodeListModel.class);
        this.setUserData("IGNOREMODELDSL");
        this.setUserData2("UIActionFrontType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUIActionFrontTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUIActionFrontTypeCodeListModel");
    }
}

