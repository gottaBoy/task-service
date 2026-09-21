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

@CodeList(id="ee4418b1e98970daf1923a1c944865f7", name="\u89c6\u56fe\u6d88\u606f\u4f4d\u7f6e", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TOP", text="\u89c6\u56fe\u4e0a\u65b9", realtext="\u89c6\u56fe\u4e0a\u65b9", userdata="\u5728\u89c6\u56fe\u7684\u6700\u4e0a\u65b9\u663e\u793a"), @CodeItem(value="BOTTOM", text="\u89c6\u56fe\u4e0b\u65b9", realtext="\u89c6\u56fe\u4e0b\u65b9", userdata="\u5728\u89c6\u56fe\u7684\u6700\u4e0b\u65b9\u663e\u793a"), @CodeItem(value="BODY", text="\u89c6\u56fe\u5185\u5bb9\u533a", realtext="\u89c6\u56fe\u5185\u5bb9\u533a", userdata="\u5728\u89c6\u56fe\u7684\u5185\u5bb9\u533a\u663e\u793a\uff0c\u4e00\u822c\u5728\u5de5\u5177\u680f\u6216\u89c6\u56fe\u6807\u9898\u4e0b\u65b9"), @CodeItem(value="POPUP", text="\u5f39\u51fa", realtext="\u5f39\u51fa", userdata="\u6a21\u6001\u5f39\u51fa\u663e\u793a"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49")})
public class ViewMsgPosCodeListModel
extends StaticCodeListModelBase {
    public static final String TOP = "TOP";
    public static final String BOTTOM = "BOTTOM";
    public static final String BODY = "BODY";
    public static final String POPUP = "POPUP";
    public static final String CUSTOM = "CUSTOM";

    public ViewMsgPosCodeListModel() {
        this.initAnnotation(ViewMsgPosCodeListModel.class);
        this.setUserData2("ViewMsgPos");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewMsgPosCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewMsgPosCodeListModel");
    }
}

