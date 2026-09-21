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

@CodeList(id="026038c806333e9ab4a05fce0a840233", name="\u5f00\u53d1\u7528\u6237\u4e3b\u673a\u5f00\u53d1\u76ee\u6807", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="ADVANCE", text="\u9ad8\u7ea7", realtext="\u9ad8\u7ea7"), @CodeItem(value="PSDEVSLNSYS", text="\u5f00\u53d1\u7cfb\u7edf", realtext="\u5f00\u53d1\u7cfb\u7edf"), @CodeItem(value="PSDEVSLNTEMPL", text="\u5f00\u53d1\u6a21\u677f", realtext="\u5f00\u53d1\u6a21\u677f")})
public class DevSlnCSTargetCodeListModel
extends StaticCodeListModelBase {
    public static final String ADVANCE = "ADVANCE";
    public static final String PSDEVSLNSYS = "PSDEVSLNSYS";
    public static final String PSDEVSLNTEMPL = "PSDEVSLNTEMPL";

    public DevSlnCSTargetCodeListModel() {
        this.initAnnotation(DevSlnCSTargetCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSlnCSTargetCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSlnCSTargetCodeListModel");
    }
}

