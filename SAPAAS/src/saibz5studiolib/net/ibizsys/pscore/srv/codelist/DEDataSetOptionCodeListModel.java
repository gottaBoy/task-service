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

@CodeList(id="A1DD5B21-A22C-449D-8218-563DDCF27147", name="\u5b9e\u4f53\u6570\u636e\u96c6\u9009\u9879", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\u53c2\u6570\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="65536", text="\u8fd4\u56de\u5168\u90e8\u8ba1\u6570", realtext="\u8fd4\u56de\u5168\u90e8\u8ba1\u6570", userdata="\u8fd4\u56de\u5168\u90e8\u8ba1\u6570\uff0c\u542b\u65e0\u6743\u9650")})
public class DEDataSetOptionCodeListModel
extends StaticCodeListModelBase {
    public static final Integer TOTALX = 65536;
    public static final int INT_TOTALX = 65536;

    public DEDataSetOptionCodeListModel() {
        this.initAnnotation(DEDataSetOptionCodeListModel.class);
        this.setUserData2("DEDataSetOption");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataSetOptionCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataSetOptionCodeListModel");
    }
}

