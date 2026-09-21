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

@CodeList(id="EBC2D369-0D9D-42A8-9D1A-95FC3D2F65C7", name="\u9762\u677f\u903b\u8f91\u5904\u7406\u8282\u70b9\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="BEGIN", text="\u5f00\u59cb", realtext="\u5f00\u59cb", iconpath="psdelntype/icon_beginprocess.png", iconpathx="psdelntype/icon_beginprocess@{0}x.png"), @CodeItem(value="PREPAREMODEL", text="\u51c6\u5907\u53c2\u6570", realtext="\u51c6\u5907\u53c2\u6570", iconpath="psdelntype/icon_prepareparam.png", iconpathx="psdelntype/icon_prepareparam@{0}x.png"), @CodeItem(value="INVOKECTRL", text="\u63a7\u4ef6\u8c03\u7528", realtext="\u63a7\u4ef6\u8c03\u7528", iconpath="psdelntype/icon_deaction.png", iconpathx="psdelntype/icon_deaction@{0}x.png"), @CodeItem(value="RAWJSCODE", text="\u76f4\u63a5\u524d\u53f0\u4ee3\u7801", realtext="\u76f4\u63a5\u524d\u53f0\u4ee3\u7801", iconpath="psdelntype/icon_rawsfcode.png", iconpathx="psdelntype/icon_rawsfcode@{0}x.png")})
public class PanelLogicNodeTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String BEGIN = "BEGIN";
    public static final String PREPAREMODEL = "PREPAREMODEL";
    public static final String INVOKECTRL = "INVOKECTRL";
    public static final String RAWJSCODE = "RAWJSCODE";

    public PanelLogicNodeTypeCodeListModel() {
        this.initAnnotation(PanelLogicNodeTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelLogicNodeTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelLogicNodeTypeCodeListModel");
    }
}

