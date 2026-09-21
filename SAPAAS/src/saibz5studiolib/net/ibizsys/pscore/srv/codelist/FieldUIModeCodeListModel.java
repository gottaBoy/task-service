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

@CodeList(id="00cbe6f0837cc3c01e6396662e962ea2", name="\u5b9e\u4f53\u5c5e\u6027\u754c\u9762\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEFAULT", text="\u9ed8\u8ba4\u6a21\u5f0f", realtext="\u9ed8\u8ba4\u6a21\u5f0f", userdata="\u5c5e\u6027\u5728\u684c\u9762\u7aef\u5e94\u7528\u7684\u9ed8\u8ba4\u754c\u9762\u6a21\u5f0f\uff0c\u8be5\u6a21\u5f0f\u5728\u6240\u5728\u5c5e\u6027\u4e2d\u53ea\u80fd\u88ab\u5b9a\u4e49\u4e00\u6b21"), @CodeItem(value="CUSTOM", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49", userdata="\u81ea\u5b9a\u4e49\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\uff0c\u9700\u8981\u5728\u5e94\u7528\u573a\u5408\u663e\u5f0f\u6307\u5b9a"), @CodeItem(value="MOBILEDEFAULT", text="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u6a21\u5f0f", realtext="\u79fb\u52a8\u7aef\u9ed8\u8ba4\u6a21\u5f0f", userdata="\u5c5e\u6027\u5728\u79fb\u52a8\u7aef\u7aef\u5e94\u7528\u7684\u9ed8\u8ba4\u754c\u9762\u6a21\u5f0f\uff0c\u8be5\u6a21\u5f0f\u5728\u6240\u5728\u5c5e\u6027\u4e2d\u53ea\u80fd\u88ab\u5b9a\u4e49\u4e00\u6b21"), @CodeItem(value="APPDEFAULT", text="\u5e94\u7528\u9ed8\u8ba4\u6a21\u5f0f", realtext="\u5e94\u7528\u9ed8\u8ba4\u6a21\u5f0f", userdata="\u5c5e\u6027\u9488\u5bf9\u6307\u5b9a\u524d\u7aef\u5e94\u7528\u7684\u9ed8\u8ba4\u754c\u9762\u6a21\u5f0f\uff0c\u8be5\u6a21\u5f0f\u5728\u6240\u5728\u5c5e\u6027\u4e2d\u53ea\u6bcf\u4e2a\u5e94\u7528\u53ea\u80fd\u88ab\u5b9a\u4e49\u4e00\u6b21"), @CodeItem(value="MODE1", text="\u6a21\u5f0f1", realtext="\u6a21\u5f0f1", userdata="\u7528\u6237\u6269\u5c55\u6a21\u5f0f1\uff0c\u8be5\u6a21\u5f0f\u5728\u6240\u5728\u5c5e\u6027\u4e2d\u53ea\u80fd\u88ab\u5b9a\u4e49\u4e00\u6b21"), @CodeItem(value="MODE2", text="\u6a21\u5f0f2", realtext="\u6a21\u5f0f2", userdata="\u7528\u6237\u6269\u5c55\u6a21\u5f0f2\uff0c\u8be5\u6a21\u5f0f\u5728\u6240\u5728\u5c5e\u6027\u4e2d\u53ea\u80fd\u88ab\u5b9a\u4e49\u4e00\u6b21"), @CodeItem(value="MODE3", text="\u6a21\u5f0f3", realtext="\u6a21\u5f0f3", userdata="\u7528\u6237\u6269\u5c55\u6a21\u5f0f3\uff0c\u8be5\u6a21\u5f0f\u5728\u6240\u5728\u5c5e\u6027\u4e2d\u53ea\u80fd\u88ab\u5b9a\u4e49\u4e00\u6b21"), @CodeItem(value="MODE4", text="\u6a21\u5f0f4", realtext="\u6a21\u5f0f4", userdata="\u7528\u6237\u6269\u5c55\u6a21\u5f0f4\uff0c\u8be5\u6a21\u5f0f\u5728\u6240\u5728\u5c5e\u6027\u4e2d\u53ea\u80fd\u88ab\u5b9a\u4e49\u4e00\u6b21"), @CodeItem(value="MODE5", text="\u6a21\u5f0f5", realtext="\u6a21\u5f0f5", userdata="\u7528\u6237\u6269\u5c55\u6a21\u5f0f5\uff0c\u8be5\u6a21\u5f0f\u5728\u6240\u5728\u5c5e\u6027\u4e2d\u53ea\u80fd\u88ab\u5b9a\u4e49\u4e00\u6b21"), @CodeItem(value="MODE6", text="\u6a21\u5f0f6", realtext="\u6a21\u5f0f6", userdata="\u7528\u6237\u6269\u5c55\u6a21\u5f0f6\uff0c\u8be5\u6a21\u5f0f\u5728\u6240\u5728\u5c5e\u6027\u4e2d\u53ea\u80fd\u88ab\u5b9a\u4e49\u4e00\u6b21"), @CodeItem(value="MODE7", text="\u6a21\u5f0f7", realtext="\u6a21\u5f0f7", userdata="\u7528\u6237\u6269\u5c55\u6a21\u5f0f7\uff0c\u8be5\u6a21\u5f0f\u5728\u6240\u5728\u5c5e\u6027\u4e2d\u53ea\u80fd\u88ab\u5b9a\u4e49\u4e00\u6b21"), @CodeItem(value="MODE8", text="\u6a21\u5f0f8", realtext="\u6a21\u5f0f8", userdata="\u7528\u6237\u6269\u5c55\u6a21\u5f0f8\uff0c\u8be5\u6a21\u5f0f\u5728\u6240\u5728\u5c5e\u6027\u4e2d\u53ea\u80fd\u88ab\u5b9a\u4e49\u4e00\u6b21"), @CodeItem(value="MODE9", text="\u6a21\u5f0f9", realtext="\u6a21\u5f0f9", userdata="\u7528\u6237\u6269\u5c55\u6a21\u5f0f9\uff0c\u8be5\u6a21\u5f0f\u5728\u6240\u5728\u5c5e\u6027\u4e2d\u53ea\u80fd\u88ab\u5b9a\u4e49\u4e00\u6b21")})
public class FieldUIModeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEFAULT = "DEFAULT";
    public static final String CUSTOM = "CUSTOM";
    public static final String MOBILEDEFAULT = "MOBILEDEFAULT";
    public static final String APPDEFAULT = "APPDEFAULT";
    public static final String MODE1 = "MODE1";
    public static final String MODE2 = "MODE2";
    public static final String MODE3 = "MODE3";
    public static final String MODE4 = "MODE4";
    public static final String MODE5 = "MODE5";
    public static final String MODE6 = "MODE6";
    public static final String MODE7 = "MODE7";
    public static final String MODE8 = "MODE8";
    public static final String MODE9 = "MODE9";

    public FieldUIModeCodeListModel() {
        this.initAnnotation(FieldUIModeCodeListModel.class);
        this.setUserData2("DEFUIMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FieldUIModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FieldUIModeCodeListModel");
    }
}

