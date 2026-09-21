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

@CodeList(id="5ffbcf94bc7b3d428c8f0e606132c413", name="\u7cfb\u7edf\u6a21\u578b\u72b6\u6001\u503c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="256", text="9", realtext="9"), @CodeItem(value="512", text="10", realtext="10"), @CodeItem(value="1024", text="11", realtext="11"), @CodeItem(value="2048", text="12", realtext="12"), @CodeItem(value="4096", text="13", realtext="13"), @CodeItem(value="8192", text="14", realtext="14"), @CodeItem(value="16384", text="15", realtext="15"), @CodeItem(value="32768", text="16", realtext="16"), @CodeItem(value="65536", text="17", realtext="17"), @CodeItem(value="131072", text="18", realtext="18"), @CodeItem(value="262144", text="19", realtext="19"), @CodeItem(value="524288", text="20", realtext="20"), @CodeItem(value="1048576", text="21", realtext="21"), @CodeItem(value="2097152", text="22", realtext="22"), @CodeItem(value="4194304", text="23", realtext="23"), @CodeItem(value="8388608", text="24", realtext="24"), @CodeItem(value="16777216", text="25", realtext="25"), @CodeItem(value="33554432", text="26", realtext="26"), @CodeItem(value="67108864", text="27", realtext="27"), @CodeItem(value="134217728", text="28", realtext="28")})
public class ModelStateValueCodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_256 = "256";
    public static final String ITEM_512 = "512";
    public static final String ITEM_1024 = "1024";
    public static final String ITEM_2048 = "2048";
    public static final String ITEM_4096 = "4096";
    public static final String ITEM_8192 = "8192";
    public static final String ITEM_16384 = "16384";
    public static final String ITEM_32768 = "32768";
    public static final String ITEM_65536 = "65536";
    public static final String ITEM_131072 = "131072";
    public static final String ITEM_262144 = "262144";
    public static final String ITEM_524288 = "524288";
    public static final String ITEM_1048576 = "1048576";
    public static final String ITEM_2097152 = "2097152";
    public static final String ITEM_4194304 = "4194304";
    public static final String ITEM_8388608 = "8388608";
    public static final String ITEM_16777216 = "16777216";
    public static final String ITEM_33554432 = "33554432";
    public static final String ITEM_67108864 = "67108864";
    public static final String ITEM_134217728 = "134217728";

    public ModelStateValueCodeListModel() {
        this.initAnnotation(ModelStateValueCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelStateValueCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelStateValueCodeListModel");
    }
}

