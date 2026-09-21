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

@CodeList(id="390e1a23f0d3ff02f6570a291ff486bb", name="\u5c4f\u5e55\u89e3\u6790\u5ea6", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1080_1920", text="1080*1920", realtext="1080*1920"), @CodeItem(value="1536_2048", text="1536*2048", realtext="1536*2048"), @CodeItem(value="1125_2436", text="1125*2436", realtext="1125*2436"), @CodeItem(value="750_1334", text="750*1334", realtext="750*1334"), @CodeItem(value="640_1136", text="640*1136", realtext="640*1136"), @CodeItem(value="640_960", text="640*960", realtext="640*960"), @CodeItem(value="128_128", text="128*128", realtext="128*128"), @CodeItem(value="96_96", text="96*96", realtext="96*96"), @CodeItem(value="64_64", text="64*64", realtext="64*64"), @CodeItem(value="48_48", text="48*48", realtext="48*48"), @CodeItem(value="32_32", text="32*32", realtext="32*32")})
public class MobSceenResolutionCodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "1080_1920";
    public static final String ITEM_2 = "1536_2048";
    public static final String ITEM_3 = "1125_2436";
    public static final String ITEM_4 = "750_1334";
    public static final String ITEM_5 = "640_1136";
    public static final String ITEM_6 = "640_960";
    public static final String ITEM_7 = "128_128";
    public static final String ITEM_8 = "96_96";
    public static final String ITEM_9 = "64_64";
    public static final String ITEM_10 = "48_48";
    public static final String ITEM_11 = "32_32";

    public MobSceenResolutionCodeListModel() {
        this.initAnnotation(MobSceenResolutionCodeListModel.class);
        this.setUserData2("MobSceenResSpec");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.MobSceenResolutionCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MobSceenResolutionCodeListModel");
    }
}

