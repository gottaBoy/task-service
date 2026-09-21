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

@CodeList(id="de61e81f8cd436b35b2453d0cdda7837", name="\u5bf9\u8c61\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="VIEW", text="\u89c6\u56fe", realtext="\u89c6\u56fe"), @CodeItem(value="APP", text="\u5e94\u7528\u7a0b\u5e8f", realtext="\u5e94\u7528\u7a0b\u5e8f"), @CodeItem(value="VIEWCTRL", text="\u89c6\u56fe\u90e8\u4ef6", realtext="\u89c6\u56fe\u90e8\u4ef6")})
public class PFPubObjectTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String VIEW = "VIEW";
    public static final String APP = "APP";
    public static final String VIEWCTRL = "VIEWCTRL";

    public PFPubObjectTypeCodeListModel() {
        this.initAnnotation(PFPubObjectTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PFPubObjectTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PFPubObjectTypeCodeListModel");
    }
}

