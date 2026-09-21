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

@CodeList(id="5D172E58-CC89-4802-9129-11A9EE1E2685", name="\u5f00\u53d1\u65b9\u6848\u753b\u5e03\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PSSYSCANVAS", text="\u7cfb\u7edf\u753b\u5e03", realtext="\u7cfb\u7edf\u753b\u5e03"), @CodeItem(value="PSSYSERMAP", text="\u7cfb\u7edfER\u56fe", realtext="\u7cfb\u7edfER\u56fe"), @CodeItem(value="PSWORKFLOW", text="\u7cfb\u7edf\u6d41\u7a0b\u56fe", realtext="\u7cfb\u7edf\u6d41\u7a0b\u56fe")})
public class DevSlnCanvasTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String PSSYSCANVAS = "PSSYSCANVAS";
    public static final String PSSYSERMAP = "PSSYSERMAP";
    public static final String PSWORKFLOW = "PSWORKFLOW";

    public DevSlnCanvasTypeCodeListModel() {
        this.initAnnotation(DevSlnCanvasTypeCodeListModel.class);
        this.setUserData2("DevSlnCanvasType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSlnCanvasTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSlnCanvasTypeCodeListModel");
    }
}

