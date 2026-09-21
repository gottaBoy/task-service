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

@CodeList(id="fae25ab9117babcc8fc674c055979e12", name="\u5b9e\u4f53\u52a8\u6001\u6a21\u578b\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u975e\u52a8\u6001\u6a21\u578b", realtext="\u975e\u52a8\u6001\u6a21\u578b"), @CodeItem(value="1", text="\u52a8\u6001\u7cfb\u7edf\u6a21\u578b", realtext="\u52a8\u6001\u7cfb\u7edf\u6a21\u578b"), @CodeItem(value="2", text="\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b", realtext="\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b")})
public class DynaModelTypeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer DYNASYS = 1;
    public static final int INT_DYNASYS = 1;
    public static final Integer DYNAINST = 2;
    public static final int INT_DYNAINST = 2;

    public DynaModelTypeCodeListModel() {
        this.initAnnotation(DynaModelTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaModelTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaModelTypeCodeListModel");
    }
}

