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

@CodeList(id="deb06e299a2d58c5f3e17bf40c8c4d15", name="\u5b9e\u4f53\u89c6\u56fe\u9884\u7f6e\u7c7b\u578b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="PICKUPVIEW", text="\u9ed8\u8ba4\u5355\u9009\u89c6\u56fe", realtext="\u9ed8\u8ba4\u5355\u9009\u89c6\u56fe"), @CodeItem(value="EDITVIEW", text="\u9ed8\u8ba4\u7f16\u8f91\u89c6\u56fe", realtext="\u9ed8\u8ba4\u7f16\u8f91\u89c6\u56fe"), @CodeItem(value="MAINVIEW", text="\u9ed8\u8ba4\u4e3b\u89c6\u56fe", realtext="\u9ed8\u8ba4\u4e3b\u89c6\u56fe", userdata="\u4e3b\u6570\u636e\u89c6\u56fe\uff0c\u5355\u9879\u6570\u636e\u7684\u5c55\u73b0\u5b9e\u4f53"), @CodeItem(value="INDEXDEPICKUPVIEW", text="\u9ed8\u8ba4\u7d22\u5f15\u5b9e\u4f53\u9009\u62e9\u89c6\u56fe", realtext="\u9ed8\u8ba4\u7d22\u5f15\u5b9e\u4f53\u9009\u62e9\u89c6\u56fe"), @CodeItem(value="FORMPICKUPVIEW", text="\u9ed8\u8ba4\u591a\u8868\u5355\u9009\u62e9\u89c6\u56fe", realtext="\u9ed8\u8ba4\u591a\u8868\u5355\u9009\u62e9\u89c6\u56fe"), @CodeItem(value="MPICKUPVIEW", text="\u9ed8\u8ba4\u591a\u9009\u89c6\u56fe", realtext="\u9ed8\u8ba4\u591a\u9009\u89c6\u56fe"), @CodeItem(value="MDATAVIEW", text="\u9ed8\u8ba4\u591a\u9879\u89c6\u56fe", realtext="\u9ed8\u8ba4\u591a\u9879\u89c6\u56fe"), @CodeItem(value="WFEDITVIEW", text="\u9ed8\u8ba4\u6d41\u7a0b\u7f16\u8f91\u89c6\u56fe", realtext="\u9ed8\u8ba4\u6d41\u7a0b\u7f16\u8f91\u89c6\u56fe"), @CodeItem(value="WFMDATAVIEW", text="\u9ed8\u8ba4\u6d41\u7a0b\u591a\u9879\u89c6\u56fe", realtext="\u9ed8\u8ba4\u6d41\u7a0b\u591a\u9879\u89c6\u56fe"), @CodeItem(value="WFSTARTVIEW", text="\u9ed8\u8ba4\u6d41\u7a0b\u542f\u52a8\u89c6\u56fe", realtext="\u9ed8\u8ba4\u6d41\u7a0b\u542f\u52a8\u89c6\u56fe"), @CodeItem(value="WFACTIONVIEW", text="\u9ed8\u8ba4\u6d41\u7a0b\u64cd\u4f5c\u89c6\u56fe", realtext="\u9ed8\u8ba4\u6d41\u7a0b\u64cd\u4f5c\u89c6\u56fe"), @CodeItem(value="WFUTILACTIONVIEW", text="\u9ed8\u8ba4\u6d41\u7a0b\u529f\u80fd\u64cd\u4f5c\u89c6\u56fe", realtext="\u9ed8\u8ba4\u6d41\u7a0b\u529f\u80fd\u64cd\u4f5c\u89c6\u56fe"), @CodeItem(value="REDIRECTVIEW", text="\u9ed8\u8ba4\u6570\u636e\u91cd\u5b9a\u5411\u89c6\u56fe", realtext="\u9ed8\u8ba4\u6570\u636e\u91cd\u5b9a\u5411\u89c6\u56fe"), @CodeItem(value="MOBPICKUPVIEW", text="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u5355\u9009\u89c6\u56fe", realtext="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u5355\u9009\u89c6\u56fe"), @CodeItem(value="MOBEDITVIEW", text="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u7f16\u8f91\u89c6\u56fe", realtext="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u7f16\u8f91\u89c6\u56fe"), @CodeItem(value="MOBMAINVIEW", text="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u4e3b\u89c6\u56fe", realtext="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u4e3b\u89c6\u56fe"), @CodeItem(value="MOBINDEXDEPICKUPVIEW", text="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u7d22\u5f15\u5b9e\u4f53\u9009\u62e9\u89c6\u56fe", realtext="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u7d22\u5f15\u5b9e\u4f53\u9009\u62e9\u89c6\u56fe"), @CodeItem(value="MOBFORMPICKUPVIEW", text="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u591a\u8868\u5355\u9009\u62e9\u89c6\u56fe", realtext="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u591a\u8868\u5355\u9009\u62e9\u89c6\u56fe"), @CodeItem(value="MOBMPICKUPVIEW", text="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u591a\u9009\u89c6\u56fe", realtext="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u591a\u9009\u89c6\u56fe"), @CodeItem(value="MOBMDATAVIEW", text="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u591a\u9879\u89c6\u56fe", realtext="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u591a\u9879\u89c6\u56fe"), @CodeItem(value="MOBWFEDITVIEW", text="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u6d41\u7a0b\u7f16\u8f91\u89c6\u56fe", realtext="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u6d41\u7a0b\u7f16\u8f91\u89c6\u56fe"), @CodeItem(value="MOBWFMDATAVIEW", text="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u6d41\u7a0b\u591a\u9879\u89c6\u56fe", realtext="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u6d41\u7a0b\u591a\u9879\u89c6\u56fe"), @CodeItem(value="MOBWFSTARTVIEW", text="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u6d41\u7a0b\u542f\u52a8\u89c6\u56fe", realtext="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u6d41\u7a0b\u542f\u52a8\u89c6\u56fe"), @CodeItem(value="MOBWFACTIONVIEW", text="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u6d41\u7a0b\u64cd\u4f5c\u89c6\u56fe", realtext="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u6d41\u7a0b\u64cd\u4f5c\u89c6\u56fe"), @CodeItem(value="MOBWFUTILACTIONVIEW", text="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u6d41\u7a0b\u529f\u80fd\u64cd\u4f5c\u89c6\u56fe", realtext="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u6d41\u7a0b\u529f\u80fd\u64cd\u4f5c\u89c6\u56fe"), @CodeItem(value="MOBREDIRECTVIEW", text="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u6570\u636e\u91cd\u5b9a\u5411\u89c6\u56fe", realtext="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u6570\u636e\u91cd\u5b9a\u5411\u89c6\u56fe"), @CodeItem(value="USER", text="\u81ea\u5b9a\u4e49\u529f\u80fd\u89c6\u56fe", realtext="\u81ea\u5b9a\u4e49\u529f\u80fd\u89c6\u56fe"), @CodeItem(value="USER2", text="\u81ea\u5b9a\u4e49\u529f\u80fd\u89c6\u56fe2", realtext="\u81ea\u5b9a\u4e49\u529f\u80fd\u89c6\u56fe2"), @CodeItem(value="USER3", text="\u81ea\u5b9a\u4e49\u529f\u80fd\u89c6\u56fe3", realtext="\u81ea\u5b9a\u4e49\u529f\u80fd\u89c6\u56fe3"), @CodeItem(value="USER4", text="\u81ea\u5b9a\u4e49\u529f\u80fd\u89c6\u56fe4", realtext="\u81ea\u5b9a\u4e49\u529f\u80fd\u89c6\u56fe4")})
public class PredefinedViewTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String PICKUPVIEW = "PICKUPVIEW";
    public static final String EDITVIEW = "EDITVIEW";
    public static final String MAINVIEW = "MAINVIEW";
    public static final String INDEXDEPICKUPVIEW = "INDEXDEPICKUPVIEW";
    public static final String FORMPICKUPVIEW = "FORMPICKUPVIEW";
    public static final String MPICKUPVIEW = "MPICKUPVIEW";
    public static final String MDATAVIEW = "MDATAVIEW";
    public static final String WFEDITVIEW = "WFEDITVIEW";
    public static final String WFMDATAVIEW = "WFMDATAVIEW";
    public static final String WFSTARTVIEW = "WFSTARTVIEW";
    public static final String WFACTIONVIEW = "WFACTIONVIEW";
    public static final String WFUTILACTIONVIEW = "WFUTILACTIONVIEW";
    public static final String REDIRECTVIEW = "REDIRECTVIEW";
    public static final String MOBPICKUPVIEW = "MOBPICKUPVIEW";
    public static final String MOBEDITVIEW = "MOBEDITVIEW";
    public static final String MOBMAINVIEW = "MOBMAINVIEW";
    public static final String MOBINDEXDEPICKUPVIEW = "MOBINDEXDEPICKUPVIEW";
    public static final String MOBFORMPICKUPVIEW = "MOBFORMPICKUPVIEW";
    public static final String MOBMPICKUPVIEW = "MOBMPICKUPVIEW";
    public static final String MOBMDATAVIEW = "MOBMDATAVIEW";
    public static final String MOBWFEDITVIEW = "MOBWFEDITVIEW";
    public static final String MOBWFMDATAVIEW = "MOBWFMDATAVIEW";
    public static final String MOBWFSTARTVIEW = "MOBWFSTARTVIEW";
    public static final String MOBWFACTIONVIEW = "MOBWFACTIONVIEW";
    public static final String MOBWFUTILACTIONVIEW = "MOBWFUTILACTIONVIEW";
    public static final String MOBREDIRECTVIEW = "MOBREDIRECTVIEW";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public PredefinedViewTypeCodeListModel() {
        this.initAnnotation(PredefinedViewTypeCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("PredefinedViewType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PredefinedViewTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PredefinedViewTypeCodeListModel");
    }
}

