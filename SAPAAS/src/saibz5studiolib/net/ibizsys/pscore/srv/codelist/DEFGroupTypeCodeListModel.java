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

@CodeList(id="0dbef4998a97948c31f2a4ba82430dbf", name="\u5c5e\u6027\u7ec4\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="FIELDS", text="\u6307\u5b9a\u5c5e\u6027", realtext="\u6307\u5b9a\u5c5e\u6027", userdata="\u6307\u5b9a\u5177\u4f53\u7684\u5c5e\u6027\u6e05\u5355"), @CodeItem(value="FORMITEMS", text="\u8868\u5355\u9879", realtext="\u8868\u5355\u9879", userdata="\u4ece\u6307\u5b9a\u7684\u7f16\u8f91\u8868\u5355\u4e2d\u63d0\u53d6\u8868\u5355\u9879\u6784\u5efa\u5c5e\u6027\u96c6\u5408"), @CodeItem(value="GRIDCOLUMNS", text="\u8868\u683c\u5217", realtext="\u8868\u683c\u5217", userdata="\u4ece\u6307\u5b9a\u7684\u8868\u683c\u4e2d\u63d0\u53d6\u5c5e\u6027\u5217\u6784\u5efa\u5c5e\u6027\u96c6\u5408"), @CodeItem(value="BASEFIELDS", text="\u57fa\u7840\u5c5e\u6027", realtext="\u57fa\u7840\u5c5e\u6027", userdata="\u6307\u5b9a\u5c5e\u6027\u7ec4\u7531\u57fa\u7840\u7684\u5c5e\u6027\u7ec4\u6210\uff0c\u5305\u62ec\u4e3b\u952e\u3001\u4e3b\u4fe1\u606f\u3001\u4e3b\u72b6\u6001\u76f8\u5173\u5c5e\u6027\u3001\u8054\u5408\u4e3b\u952e\u53ca\u5b58\u5728\u9884\u5b9a\u6a21\u5f0f\u7684\u76f8\u5173\u5c5e\u6027\u7b49"), @CodeItem(value="AUDITFIELDS", text="\u5ba1\u8ba1\u5c5e\u6027", realtext="\u5ba1\u8ba1\u5c5e\u6027", userdata="\u6307\u5b9a\u5c5e\u6027\u7ec4\u7531\u542f\u7528\u5ba1\u8ba1\u7684\u5c5e\u6027\u7ec4\u6210")})
public class DEFGroupTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String FIELDS = "FIELDS";
    public static final String FORMITEMS = "FORMITEMS";
    public static final String GRIDCOLUMNS = "GRIDCOLUMNS";
    public static final String BASEFIELDS = "BASEFIELDS";
    public static final String AUDITFIELDS = "AUDITFIELDS";

    public DEFGroupTypeCodeListModel() {
        this.initAnnotation(DEFGroupTypeCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("DEFGroupType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFGroupTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFGroupTypeCodeListModel");
    }
}

