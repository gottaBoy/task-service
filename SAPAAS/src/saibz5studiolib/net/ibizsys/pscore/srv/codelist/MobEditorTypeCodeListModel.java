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

@CodeList(id="83C6A1C4-695A-4686-823B-B44940026A87", name="\u7f16\u8f91\u5668\u7c7b\u578b\uff08\u79fb\u52a8\u7aef\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="MOBTEXT", text="\u79fb\u52a8\u7aef\u6587\u672c\u6846", realtext="\u79fb\u52a8\u7aef\u6587\u672c\u6846"), @CodeItem(value="MOBNUMBER", text="\u79fb\u52a8\u7aef\u6570\u503c\u6846", realtext="\u79fb\u52a8\u7aef\u6570\u503c\u6846"), @CodeItem(value="MOBTEXTAREA", text="\u79fb\u52a8\u7aef\u591a\u884c\u6587\u672c", realtext="\u79fb\u52a8\u7aef\u591a\u884c\u6587\u672c"), @CodeItem(value="MOBBARCODEREADER", text="\u79fb\u52a8\u7aef\u6761\u7801\u9605\u8bfb\u5668", realtext="\u79fb\u52a8\u7aef\u6761\u7801\u9605\u8bfb\u5668"), @CodeItem(value="MOBSWITCH", text="\u79fb\u52a8\u7aef\u5f00\u5173\u90e8\u4ef6", realtext="\u79fb\u52a8\u7aef\u5f00\u5173\u90e8\u4ef6"), @CodeItem(value="MOBRADIOLIST", text="\u79fb\u52a8\u7aef\u5355\u9009\u9879\u5217\u8868", realtext="\u79fb\u52a8\u7aef\u5355\u9009\u9879\u5217\u8868"), @CodeItem(value="MOB2DBARCODEREADER", text="\u79fb\u52a8\u7aef\u4e8c\u7ef4\u7801\u9605\u8bfb\u5668", realtext="\u79fb\u52a8\u7aef\u4e8c\u7ef4\u7801\u9605\u8bfb\u5668"), @CodeItem(value="MOBDROPDOWNLIST", text="\u79fb\u52a8\u7aef\u4e0b\u62c9\u5217\u8868\uff08\u5355\u9009\uff09", realtext="\u79fb\u52a8\u7aef\u4e0b\u62c9\u5217\u8868\uff08\u5355\u9009\uff09"), @CodeItem(value="MOBCHECKLIST", text="\u79fb\u52a8\u7aef\u4e0b\u62c9\u5217\u8868\uff08\u591a\u9009\uff09", realtext="\u79fb\u52a8\u7aef\u4e0b\u62c9\u5217\u8868\uff08\u591a\u9009\uff09"), @CodeItem(value="MOBPICKER", text="\u79fb\u52a8\u7aef\u6570\u636e\u9009\u62e9", realtext="\u79fb\u52a8\u7aef\u6570\u636e\u9009\u62e9"), @CodeItem(value="MOBPICKER_DROPDOWNVIEW", text="\u79fb\u52a8\u7aef\u6570\u636e\u9009\u62e9\uff08\u4e0b\u62c9\u89c6\u56fe\uff09", realtext="\u79fb\u52a8\u7aef\u6570\u636e\u9009\u62e9\uff08\u4e0b\u62c9\u89c6\u56fe\uff09"), @CodeItem(value="MOBMPICKER", text="\u79fb\u52a8\u7aef\u591a\u6570\u636e\u9009\u62e9", realtext="\u79fb\u52a8\u7aef\u591a\u6570\u636e\u9009\u62e9"), @CodeItem(value="MOBDATE", text="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668", realtext="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668"), @CodeItem(value="MOBDATE_HOUR", text="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD HH\uff09", realtext="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD HH\uff09"), @CodeItem(value="MOBDATE_MINUTE", text="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD HH:mm\uff09", realtext="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD HH:mm\uff09"), @CodeItem(value="MOBDATE_NODAY", text="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08HH:mm:ss\uff09", realtext="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08HH:mm:ss\uff09"), @CodeItem(value="MOBDATE_NODAY_NOSECOND", text="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08HH:mm\uff09", realtext="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08HH:mm\uff09"), @CodeItem(value="MOBDATE_NOTIME", text="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD\uff09", realtext="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD\uff09"), @CodeItem(value="MOBDATE_SECOND", text="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD HH:mm:ss\uff09", realtext="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD HH:mm:ss\uff09"), @CodeItem(value="MOBPICTURE", text="\u79fb\u52a8\u7aef\u56fe\u7247\u63a7\u4ef6\uff08\u5355\u9879\uff09", realtext="\u79fb\u52a8\u7aef\u56fe\u7247\u63a7\u4ef6\uff08\u5355\u9879\uff09"), @CodeItem(value="MOBSINGLEFILEUPLOAD", text="\u79fb\u52a8\u7aef\u6587\u4ef6\u63a7\u4ef6\uff08\u5355\u9879\uff09", realtext="\u79fb\u52a8\u7aef\u6587\u4ef6\u63a7\u4ef6\uff08\u5355\u9879\uff09"), @CodeItem(value="MOBPICTURE_RAW", text="\u79fb\u52a8\u7aef\u56fe\u7247\u63a7\u4ef6\uff08\u5355\u9879\u3001\u76f4\u63a5\u5185\u5bb9\uff09", realtext="\u79fb\u52a8\u7aef\u56fe\u7247\u63a7\u4ef6\uff08\u5355\u9879\u3001\u76f4\u63a5\u5185\u5bb9\uff09"), @CodeItem(value="MOBPICTURELIST", text="\u79fb\u52a8\u7aef\u56fe\u7247\u63a7\u4ef6\uff08\u591a\u9879\uff09", realtext="\u79fb\u52a8\u7aef\u56fe\u7247\u63a7\u4ef6\uff08\u591a\u9879\uff09"), @CodeItem(value="MOBMULTIFILEUPLOAD", text="\u79fb\u52a8\u7aef\u6587\u4ef6\u63a7\u4ef6\uff08\u591a\u9879\uff09", realtext="\u79fb\u52a8\u7aef\u6587\u4ef6\u63a7\u4ef6\uff08\u591a\u9879\uff09"), @CodeItem(value="MOBPASSWORD", text="\u79fb\u52a8\u7aef\u5bc6\u7801\u6846", realtext="\u79fb\u52a8\u7aef\u5bc6\u7801\u6846"), @CodeItem(value="MOBSLIDER", text="\u79fb\u52a8\u7aef\u6ed1\u52a8\u8f93\u5165\u6761", realtext="\u79fb\u52a8\u7aef\u6ed1\u52a8\u8f93\u5165\u6761"), @CodeItem(value="MOBSTEPPER", text="\u79fb\u52a8\u7aef\u6b65\u8fdb\u5668", realtext="\u79fb\u52a8\u7aef\u6b65\u8fdb\u5668"), @CodeItem(value="MOBRATING", text="\u79fb\u52a8\u7aef\u8bc4\u5206\u5668", realtext="\u79fb\u52a8\u7aef\u8bc4\u5206\u5668"), @CodeItem(value="MOBHTMLTEXT", text="\u79fb\u52a8\u7aefHTML\u7f16\u8f91\u6846", realtext="\u79fb\u52a8\u7aefHTML\u7f16\u8f91\u6846"), @CodeItem(value="MOBCODE", text="\u79fb\u52a8\u7aef\u4ee3\u7801\u7f16\u8f91\u6846", realtext="\u79fb\u52a8\u7aef\u4ee3\u7801\u7f16\u8f91\u6846"), @CodeItem(value="MOBMARKDOWN", text="\u79fb\u52a8\u7aefMarkdown\u7f16\u8f91\u6846", realtext="\u79fb\u52a8\u7aefMarkdown\u7f16\u8f91\u6846"), @CodeItem(value="MOBNUMBERRANGE", text="\u79fb\u52a8\u7aef\u6570\u503c\u8303\u56f4\u7f16\u8f91\u6846", realtext="\u79fb\u52a8\u7aef\u6570\u503c\u8303\u56f4\u7f16\u8f91\u6846"), @CodeItem(value="MOBDATERANGE", text="\u79fb\u52a8\u7aef\u65f6\u95f4\u8303\u56f4\u9009\u62e9\u5668", realtext="\u79fb\u52a8\u7aef\u65f6\u95f4\u8303\u56f4\u9009\u62e9\u5668"), @CodeItem(value="MOBDATERANGE_NOTIME", text="\u79fb\u52a8\u7aef\u65f6\u95f4\u8303\u56f4\u9009\u62e9\u5668\uff08YYYY-MM-DD\uff09", realtext="\u79fb\u52a8\u7aef\u65f6\u95f4\u8303\u56f4\u9009\u62e9\u5668\uff08YYYY-MM-DD\uff09"), @CodeItem(value="MOBCASCADER", text="\u79fb\u52a8\u7aef\u7ea7\u8054\u9009\u62e9\u5668", realtext="\u79fb\u52a8\u7aef\u7ea7\u8054\u9009\u62e9\u5668"), @CodeItem(value="MOBARRAY", text="\u79fb\u52a8\u7aef\u6570\u7ec4\u7f16\u8f91\u5668", realtext="\u79fb\u52a8\u7aef\u6570\u7ec4\u7f16\u8f91\u5668"), @CodeItem(value="MOBMAPPICKER", text="\u79fb\u52a8\u7aef\u5730\u56fe\u9009\u62e9\u5668", realtext="\u79fb\u52a8\u7aef\u5730\u56fe\u9009\u62e9\u5668"), @CodeItem(value="MOBCOLORPICKER", text="\u79fb\u52a8\u7aef\u989c\u8272\u9009\u62e9\u5668", realtext="\u79fb\u52a8\u7aef\u989c\u8272\u9009\u62e9\u5668"), @CodeItem(value="USERCONTROL", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49")})
public class MobEditorTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String MOBTEXT = "MOBTEXT";
    public static final String MOBNUMBER = "MOBNUMBER";
    public static final String MOBTEXTAREA = "MOBTEXTAREA";
    public static final String MOBBARCODEREADER = "MOBBARCODEREADER";
    public static final String MOBSWITCH = "MOBSWITCH";
    public static final String MOBRADIOLIST = "MOBRADIOLIST";
    public static final String MOB2DBARCODEREADER = "MOB2DBARCODEREADER";
    public static final String MOBDROPDOWNLIST = "MOBDROPDOWNLIST";
    public static final String MOBCHECKLIST = "MOBCHECKLIST";
    public static final String MOBPICKER = "MOBPICKER";
    public static final String MOBPICKER_DROPDOWNVIEW = "MOBPICKER_DROPDOWNVIEW";
    public static final String MOBMPICKER = "MOBMPICKER";
    public static final String MOBDATE = "MOBDATE";
    public static final String MOBDATE_HOUR = "MOBDATE_HOUR";
    public static final String MOBDATE_MINUTE = "MOBDATE_MINUTE";
    public static final String MOBDATE_NODAY = "MOBDATE_NODAY";
    public static final String MOBDATE_NODAY_NOSECOND = "MOBDATE_NODAY_NOSECOND";
    public static final String MOBDATE_NOTIME = "MOBDATE_NOTIME";
    public static final String MOBDATE_SECOND = "MOBDATE_SECOND";
    public static final String MOBPICTURE = "MOBPICTURE";
    public static final String MOBSINGLEFILEUPLOAD = "MOBSINGLEFILEUPLOAD";
    public static final String MOBPICTURE_RAW = "MOBPICTURE_RAW";
    public static final String MOBPICTURELIST = "MOBPICTURELIST";
    public static final String MOBMULTIFILEUPLOAD = "MOBMULTIFILEUPLOAD";
    public static final String MOBPASSWORD = "MOBPASSWORD";
    public static final String MOBSLIDER = "MOBSLIDER";
    public static final String MOBSTEPPER = "MOBSTEPPER";
    public static final String MOBRATING = "MOBRATING";
    public static final String MOBHTMLTEXT = "MOBHTMLTEXT";
    public static final String MOBCODE = "MOBCODE";
    public static final String MOBMARKDOWN = "MOBMARKDOWN";
    public static final String MOBNUMBERRANGE = "MOBNUMBERRANGE";
    public static final String MOBDATERANGE = "MOBDATERANGE";
    public static final String MOBDATERANGE_NOTIME = "MOBDATERANGE_NOTIME";
    public static final String MOBCASCADER = "MOBCASCADER";
    public static final String MOBARRAY = "MOBARRAY";
    public static final String MOBMAPPICKER = "MOBMAPPICKER";
    public static final String MOBCOLORPICKER = "MOBCOLORPICKER";
    public static final String USERCONTROL = "USERCONTROL";

    public MobEditorTypeCodeListModel() {
        this.initAnnotation(MobEditorTypeCodeListModel.class);
        this.setUserData2("MobEditorType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.MobEditorTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MobEditorTypeCodeListModel");
    }
}

