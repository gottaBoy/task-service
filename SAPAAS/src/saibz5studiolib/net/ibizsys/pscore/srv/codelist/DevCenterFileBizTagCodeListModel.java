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

@CodeList(id="f86e351c408651b590223c2f000b7f35", name="\u5e94\u7528\u4e2d\u5fc3\u6587\u4ef6\u4e1a\u52a1\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEVSLNSYS_WORKSHOP", text="\u5f00\u53d1\u7cfb\u7edf\u5de5\u7a0b\u76ee\u5f55", realtext="\u5f00\u53d1\u7cfb\u7edf\u5de5\u7a0b\u76ee\u5f55"), @CodeItem(value="DEVSLNSYS_ROOT", text="\u5f00\u53d1\u7cfb\u7edf\u6839\u76ee\u5f55", realtext="\u5f00\u53d1\u7cfb\u7edf\u6839\u76ee\u5f55"), @CodeItem(value="SRFFILE", text="\u5e73\u53f0\u6587\u4ef6", realtext="\u5e73\u53f0\u6587\u4ef6"), @CodeItem(value="SRFBACKUP", text="\u5e73\u53f0\u5907\u4efd", realtext="\u5e73\u53f0\u5907\u4efd"), @CodeItem(value="SRFDOWNLOAD", text="\u5e73\u53f0\u4e0b\u8f7d", realtext="\u5e73\u53f0\u4e0b\u8f7d")})
public class DevCenterFileBizTagCodeListModel
extends StaticCodeListModelBase {
    public static final String DEVSLNSYS_WORKSHOP = "DEVSLNSYS_WORKSHOP";
    public static final String DEVSLNSYS_ROOT = "DEVSLNSYS_ROOT";
    public static final String SRFFILE = "SRFFILE";
    public static final String SRFBACKUP = "SRFBACKUP";
    public static final String SRFDOWNLOAD = "SRFDOWNLOAD";

    public DevCenterFileBizTagCodeListModel() {
        this.initAnnotation(DevCenterFileBizTagCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevCenterFileBizTagCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevCenterFileBizTagCodeListModel");
    }
}

