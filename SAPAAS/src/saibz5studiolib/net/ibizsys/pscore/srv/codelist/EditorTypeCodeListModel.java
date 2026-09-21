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

@CodeList(id="41C2B59E-B24F-4BCA-882C-54F7A594527F", name="\u7f16\u8f91\u5668\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TEXTBOX", text="\u6587\u672c\u6846", realtext="\u6587\u672c\u6846"), @CodeItem(value="NUMBER", text="\u6570\u503c\u6846", realtext="\u6570\u503c\u6846"), @CodeItem(value="PASSWORD", text="\u5bc6\u7801\u6846", realtext="\u5bc6\u7801\u6846"), @CodeItem(value="HIDDEN", text="\u9690\u85cf\u8868\u5355\u9879", realtext="\u9690\u85cf\u8868\u5355\u9879"), @CodeItem(value="TEXTAREA", text="\u591a\u884c\u8f93\u5165\u6846", realtext="\u591a\u884c\u8f93\u5165\u6846"), @CodeItem(value="TEXTAREA_10", text="\u591a\u884c\u8f93\u5165\u6846\uff0810\u884c\uff09", realtext="\u591a\u884c\u8f93\u5165\u6846\uff0810\u884c\uff09"), @CodeItem(value="IPADDRESSTEXTBOX", text="IP\u5730\u5740\u8f93\u5165\u6846", realtext="IP\u5730\u5740\u8f93\u5165\u6846"), @CodeItem(value="RAW", text="\u76f4\u63a5\u5185\u5bb9", realtext="\u76f4\u63a5\u5185\u5bb9"), @CodeItem(value="STEPPER", text="\u6b65\u8fdb\u5668", realtext="\u6b65\u8fdb\u5668"), @CodeItem(value="RATING", text="\u8bc4\u5206\u5668", realtext="\u8bc4\u5206\u5668"), @CodeItem(value="SLIDER", text="\u6ed1\u52a8\u8f93\u5165\u6761", realtext="\u6ed1\u52a8\u8f93\u5165\u6761"), @CodeItem(value="SPAN", text="\u6807\u7b7e", realtext="\u6807\u7b7e"), @CodeItem(value="SPANEX", text="\u6807\u7b7e\uff08\u65e7\uff09", realtext="\u6807\u7b7e\uff08\u65e7\uff09"), @CodeItem(value="SPAN_LINK", text="\u6807\u7b7e\uff08\u6570\u636e\u94fe\u63a5\uff09", realtext="\u6807\u7b7e\uff08\u6570\u636e\u94fe\u63a5\uff09"), @CodeItem(value="DROPDOWNLIST", text="\u4e0b\u62c9\u5217\u8868\u6846", realtext="\u4e0b\u62c9\u5217\u8868\u6846"), @CodeItem(value="DROPDOWNLIST_100", text="\u4e0b\u62c9\u5217\u8868\u6846\uff08100\u5bbd\u5ea6\uff09", realtext="\u4e0b\u62c9\u5217\u8868\u6846\uff08100\u5bbd\u5ea6\uff09"), @CodeItem(value="MDROPDOWNLIST", text="\u4e0b\u62c9\u5217\u8868\u6846\uff08\u591a\u9009\uff09", realtext="\u4e0b\u62c9\u5217\u8868\u6846\uff08\u591a\u9009\uff09"), @CodeItem(value="CHECKBOX", text="\u9009\u9879\u6846", realtext="\u9009\u9879\u6846"), @CodeItem(value="SWITCH", text="\u5f00\u5173\u90e8\u4ef6", realtext="\u5f00\u5173\u90e8\u4ef6"), @CodeItem(value="RADIOBUTTONLIST", text="\u5355\u9009\u9879\u5217\u8868", realtext="\u5355\u9009\u9879\u5217\u8868"), @CodeItem(value="CHECKBOXLIST", text="\u9009\u9879\u6846\u5217\u8868", realtext="\u9009\u9879\u6846\u5217\u8868"), @CodeItem(value="LISTBOX", text="\u5217\u8868\u6846", realtext="\u5217\u8868\u6846"), @CodeItem(value="LISTBOXPICKUP", text="\u5217\u8868\u6846\uff08\u9009\u62e9\uff09", realtext="\u5217\u8868\u6846\uff08\u9009\u62e9\uff09"), @CodeItem(value="ADDRESSPICKUP", text="\u5730\u5740\u6846\uff08\u9009\u62e9\uff09", realtext="\u5730\u5740\u6846\uff08\u9009\u62e9\uff09"), @CodeItem(value="ADDRESSPICKUP_AC", text="\u5730\u5740\u6846\uff08\u652f\u6301\u9009\u62e9\u3001AC\uff09", realtext="\u5730\u5740\u6846\uff08\u652f\u6301\u9009\u62e9\u3001AC\uff09"), @CodeItem(value="DATEPICKEREX", text="\u65f6\u95f4\u9009\u62e9\u5668\uff08\u65e7\uff09", realtext="\u65f6\u95f4\u9009\u62e9\u5668\uff08\u65e7\uff09"), @CodeItem(value="DATEPICKEREX_NOTIME", text="\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD\uff09", realtext="\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD\uff09"), @CodeItem(value="DATEPICKEREX_NODAY", text="\u65f6\u95f4\u9009\u62e9\u5668\uff08HH:mm:ss\uff09", realtext="\u65f6\u95f4\u9009\u62e9\u5668\uff08HH:mm:ss\uff09"), @CodeItem(value="DATEPICKEREX_HOUR", text="\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD HH\uff09", realtext="\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD HH\uff09"), @CodeItem(value="DATEPICKEREX_MINUTE", text="\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD HH:mm\uff09", realtext="\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD HH:mm\uff09"), @CodeItem(value="DATEPICKEREX_SECOND", text="\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD HH:mm:ss\uff09", realtext="\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD HH:mm:ss\uff09"), @CodeItem(value="DATEPICKEREX_NODAY_NOSECOND", text="\u65f6\u95f4\u9009\u62e9\u5668\uff08HH:mm\uff09", realtext="\u65f6\u95f4\u9009\u62e9\u5668\uff08HH:mm\uff09"), @CodeItem(value="DATEPICKER", text="\u65f6\u95f4\u9009\u62e9\u5668", realtext="\u65f6\u95f4\u9009\u62e9\u5668"), @CodeItem(value="PICKER", text="\u6570\u636e\u9009\u62e9", realtext="\u6570\u636e\u9009\u62e9"), @CodeItem(value="PICKEREX_LINK", text="\u6570\u636e\u9009\u62e9\uff08\u6570\u636e\u94fe\u63a5\uff09", realtext="\u6570\u636e\u9009\u62e9\uff08\u6570\u636e\u94fe\u63a5\uff09"), @CodeItem(value="PICKEREX_NOAC", text="\u6570\u636e\u9009\u62e9\uff08\u65e0AC\uff09", realtext="\u6570\u636e\u9009\u62e9\uff08\u65e0AC\uff09"), @CodeItem(value="PICKEREX_LINKONLY", text="\u6570\u636e\u94fe\u63a5", realtext="\u6570\u636e\u94fe\u63a5"), @CodeItem(value="PICKEREX_NOAC_LINK", text="\u6570\u636e\u9009\u62e9\uff08\u65e0AC\u3001\u6570\u636e\u94fe\u63a5\uff09", realtext="\u6570\u636e\u9009\u62e9\uff08\u65e0AC\u3001\u6570\u636e\u94fe\u63a5\uff09"), @CodeItem(value="PICKEREX_TRIGGER", text="\u6570\u636e\u9009\u62e9\uff08\u4e0b\u62c9\uff09", realtext="\u6570\u636e\u9009\u62e9\uff08\u4e0b\u62c9\uff09"), @CodeItem(value="PICKEREX_TRIGGER_LINK", text="\u6570\u636e\u9009\u62e9\uff08\u4e0b\u62c9\u3001\u6570\u636e\u94fe\u63a5\uff09", realtext="\u6570\u636e\u9009\u62e9\uff08\u4e0b\u62c9\u3001\u6570\u636e\u94fe\u63a5\uff09"), @CodeItem(value="PICKEREX_NOBUTTON", text="\u6570\u636e\u9009\u62e9\uff08\u65e0\u6309\u94ae\uff09", realtext="\u6570\u636e\u9009\u62e9\uff08\u65e0\u6309\u94ae\uff09"), @CodeItem(value="PICKEREX_DROPDOWNVIEW", text="\u6570\u636e\u9009\u62e9\uff08\u4e0b\u62c9\u89c6\u56fe\uff09", realtext="\u6570\u636e\u9009\u62e9\uff08\u4e0b\u62c9\u89c6\u56fe\uff09"), @CodeItem(value="PICKEREX_DROPDOWNVIEW_LINK", text="\u6570\u636e\u9009\u62e9\uff08\u4e0b\u62c9\u89c6\u56fe\u3001\u6570\u636e\u94fe\u63a5\uff09", realtext="\u6570\u636e\u9009\u62e9\uff08\u4e0b\u62c9\u89c6\u56fe\u3001\u6570\u636e\u94fe\u63a5\uff09"), @CodeItem(value="PICKUPVIEW", text="\u6570\u636e\u9009\u62e9\uff08\u5d4c\u5165\u9009\u62e9\u89c6\u56fe\uff09", realtext="\u6570\u636e\u9009\u62e9\uff08\u5d4c\u5165\u9009\u62e9\u89c6\u56fe\uff09"), @CodeItem(value="AC", text="\u81ea\u52a8\u586b\u5145", realtext="\u81ea\u52a8\u586b\u5145"), @CodeItem(value="AC_FS", text="\u81ea\u52a8\u586b\u5145\uff08\u53ea\u80fd\u9009\u62e9\uff09", realtext="\u81ea\u52a8\u586b\u5145\uff08\u53ea\u80fd\u9009\u62e9\uff09"), @CodeItem(value="AC_NOBUTTON", text="\u81ea\u52a8\u586b\u5145\uff08\u65e0\u6309\u94ae\uff09", realtext="\u81ea\u52a8\u586b\u5145\uff08\u65e0\u6309\u94ae\uff09"), @CodeItem(value="AC_FS_NOBUTTON", text="\u81ea\u52a8\u586b\u5145\uff08\u53ea\u80fd\u9009\u62e9\u3001\u65e0\u6309\u94ae\uff09", realtext="\u81ea\u52a8\u586b\u5145\uff08\u53ea\u80fd\u9009\u62e9\u3001\u65e0\u6309\u94ae\uff09"), @CodeItem(value="HTMLEDITOR", text="HTML\u7f16\u8f91\u6846", realtext="HTML\u7f16\u8f91\u6846"), @CodeItem(value="CODE", text="\u4ee3\u7801\u7f16\u8f91\u6846", realtext="\u4ee3\u7801\u7f16\u8f91\u6846"), @CodeItem(value="MARKDOWN", text="Markdown\u7f16\u8f91\u6846", realtext="Markdown\u7f16\u8f91\u6846"), @CodeItem(value="OFFICEEDITOR", text="Office\u6587\u6863\u7f16\u8f91\u5668", realtext="Office\u6587\u6863\u7f16\u8f91\u5668"), @CodeItem(value="OFFICEEDITOR2", text="Office\u6587\u6863\u7f16\u8f91\u56682\uff08\u5f39\u51fa\u7f16\u8f91\uff0c\u8fd4\u56de\u5185\u5bb9\uff09", realtext="Office\u6587\u6863\u7f16\u8f91\u56682\uff08\u5f39\u51fa\u7f16\u8f91\uff0c\u8fd4\u56de\u5185\u5bb9\uff09"), @CodeItem(value="PICTURE", text="\u56fe\u7247\u63a7\u4ef6", realtext="\u56fe\u7247\u63a7\u4ef6"), @CodeItem(value="PICTURE_ONE", text="\u56fe\u7247\u63a7\u4ef6\uff08\u5355\u9879\uff09", realtext="\u56fe\u7247\u63a7\u4ef6\uff08\u5355\u9879\uff09"), @CodeItem(value="PICTURE_ONE_RAW", text="\u56fe\u7247\u63a7\u4ef6\uff08\u5355\u9879\u3001\u76f4\u63a5\u5185\u5bb9\uff09", realtext="\u56fe\u7247\u63a7\u4ef6\uff08\u5355\u9879\u3001\u76f4\u63a5\u5185\u5bb9\uff09"), @CodeItem(value="FILEUPLOADER", text="\u6587\u4ef6\u63a7\u4ef6", realtext="\u6587\u4ef6\u63a7\u4ef6"), @CodeItem(value="PREDEFINED", text="\u9884\u5b9a\u4e49\u7f16\u8f91\u5668", realtext="\u9884\u5b9a\u4e49\u7f16\u8f91\u5668"), @CodeItem(value="FILEUPLOADER_ONE", text="\u6587\u4ef6\u63a7\u4ef6\uff08\u5355\u9879\uff09", realtext="\u6587\u4ef6\u63a7\u4ef6\uff08\u5355\u9879\uff09"), @CodeItem(value="NUMBERRANGE", text="\u6570\u503c\u8303\u56f4\u7f16\u8f91\u6846", realtext="\u6570\u503c\u8303\u56f4\u7f16\u8f91\u6846"), @CodeItem(value="DATERANGE", text="\u65f6\u95f4\u8303\u56f4\u9009\u62e9\u5668", realtext="\u65f6\u95f4\u8303\u56f4\u9009\u62e9\u5668"), @CodeItem(value="DATERANGE_NOTIME", text="\u65f6\u95f4\u8303\u56f4\u9009\u62e9\u5668\uff08YYYY-MM-DD\uff09", realtext="\u65f6\u95f4\u8303\u56f4\u9009\u62e9\u5668\uff08YYYY-MM-DD\uff09"), @CodeItem(value="CASCADER", text="\u7ea7\u8054\u9009\u62e9\u5668", realtext="\u7ea7\u8054\u9009\u62e9\u5668"), @CodeItem(value="ARRAY", text="\u6570\u7ec4\u7f16\u8f91\u5668", realtext="\u6570\u7ec4\u7f16\u8f91\u5668"), @CodeItem(value="COLORPICKER", text="\u989c\u8272\u9009\u62e9\u5668", realtext="\u989c\u8272\u9009\u62e9\u5668"), @CodeItem(value="MAPPICKER", text="\u5730\u56fe\u9009\u62e9\u5668", realtext="\u5730\u56fe\u9009\u62e9\u5668"), @CodeItem(value="USERCONTROL", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="MOBTEXT", text="\u79fb\u52a8\u7aef\u6587\u672c\u6846", realtext="\u79fb\u52a8\u7aef\u6587\u672c\u6846"), @CodeItem(value="MOBNUMBER", text="\u79fb\u52a8\u7aef\u6570\u503c\u6846", realtext="\u79fb\u52a8\u7aef\u6570\u503c\u6846"), @CodeItem(value="MOBTEXTAREA", text="\u79fb\u52a8\u7aef\u591a\u884c\u6587\u672c", realtext="\u79fb\u52a8\u7aef\u591a\u884c\u6587\u672c"), @CodeItem(value="MOBBARCODEREADER", text="\u79fb\u52a8\u7aef\u6761\u7801\u9605\u8bfb\u5668", realtext="\u79fb\u52a8\u7aef\u6761\u7801\u9605\u8bfb\u5668"), @CodeItem(value="MOBSWITCH", text="\u79fb\u52a8\u7aef\u5f00\u5173\u90e8\u4ef6", realtext="\u79fb\u52a8\u7aef\u5f00\u5173\u90e8\u4ef6"), @CodeItem(value="MOB2DBARCODEREADER", text="\u79fb\u52a8\u7aef\u4e8c\u7ef4\u7801\u9605\u8bfb\u5668", realtext="\u79fb\u52a8\u7aef\u4e8c\u7ef4\u7801\u9605\u8bfb\u5668"), @CodeItem(value="MOBRADIOLIST", text="\u79fb\u52a8\u7aef\u5355\u9009\u9879\u5217\u8868", realtext="\u79fb\u52a8\u7aef\u5355\u9009\u9879\u5217\u8868"), @CodeItem(value="MOBDROPDOWNLIST", text="\u79fb\u52a8\u7aef\u4e0b\u62c9\u5217\u8868\uff08\u5355\u9009\uff09", realtext="\u79fb\u52a8\u7aef\u4e0b\u62c9\u5217\u8868\uff08\u5355\u9009\uff09"), @CodeItem(value="MOBCHECKLIST", text="\u79fb\u52a8\u7aef\u4e0b\u62c9\u5217\u8868\uff08\u591a\u9009\uff09", realtext="\u79fb\u52a8\u7aef\u4e0b\u62c9\u5217\u8868\uff08\u591a\u9009\uff09"), @CodeItem(value="MOBPICKER", text="\u79fb\u52a8\u7aef\u6570\u636e\u9009\u62e9", realtext="\u79fb\u52a8\u7aef\u6570\u636e\u9009\u62e9"), @CodeItem(value="MOBPICKER_DROPDOWNVIEW", text="\u79fb\u52a8\u7aef\u6570\u636e\u9009\u62e9\uff08\u4e0b\u62c9\u89c6\u56fe\uff09", realtext="\u79fb\u52a8\u7aef\u6570\u636e\u9009\u62e9\uff08\u4e0b\u62c9\u89c6\u56fe\uff09"), @CodeItem(value="MOBMPICKER", text="\u79fb\u52a8\u7aef\u591a\u6570\u636e\u9009\u62e9", realtext="\u79fb\u52a8\u7aef\u591a\u6570\u636e\u9009\u62e9"), @CodeItem(value="MOBDATE", text="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668", realtext="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668"), @CodeItem(value="MOBDATE_HOUR", text="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD HH\uff09", realtext="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD HH\uff09"), @CodeItem(value="MOBDATE_MINUTE", text="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD HH:mm\uff09", realtext="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD HH:mm\uff09"), @CodeItem(value="MOBDATE_NODAY", text="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08HH:mm:ss\uff09", realtext="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08HH:mm:ss\uff09"), @CodeItem(value="MOBDATE_NODAY_NOSECOND", text="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08HH:mm\uff09", realtext="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08HH:mm\uff09"), @CodeItem(value="MOBDATE_NOTIME", text="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD\uff09", realtext="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD\uff09"), @CodeItem(value="MOBDATE_SECOND", text="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD HH:mm:ss\uff09", realtext="\u79fb\u52a8\u7aef\u65f6\u95f4\u9009\u62e9\u5668\uff08YYYY-MM-DD HH:mm:ss\uff09"), @CodeItem(value="MOBPICTURE", text="\u79fb\u52a8\u7aef\u56fe\u7247\u63a7\u4ef6\uff08\u5355\u9879\uff09", realtext="\u79fb\u52a8\u7aef\u56fe\u7247\u63a7\u4ef6\uff08\u5355\u9879\uff09"), @CodeItem(value="MOBSINGLEFILEUPLOAD", text="\u79fb\u52a8\u7aef\u6587\u4ef6\u63a7\u4ef6\uff08\u5355\u9879\uff09", realtext="\u79fb\u52a8\u7aef\u6587\u4ef6\u63a7\u4ef6\uff08\u5355\u9879\uff09"), @CodeItem(value="MOBPICTURE_RAW", text="\u79fb\u52a8\u7aef\u56fe\u7247\u63a7\u4ef6\uff08\u5355\u9879\u3001\u76f4\u63a5\u5185\u5bb9\uff09", realtext="\u79fb\u52a8\u7aef\u56fe\u7247\u63a7\u4ef6\uff08\u5355\u9879\u3001\u76f4\u63a5\u5185\u5bb9\uff09"), @CodeItem(value="MOBPICTURELIST", text="\u79fb\u52a8\u7aef\u56fe\u7247\u63a7\u4ef6\uff08\u591a\u9879\uff09", realtext="\u79fb\u52a8\u7aef\u56fe\u7247\u63a7\u4ef6\uff08\u591a\u9879\uff09"), @CodeItem(value="MOBMULTIFILEUPLOAD", text="\u79fb\u52a8\u7aef\u6587\u4ef6\u63a7\u4ef6\uff08\u591a\u9879\uff09", realtext="\u79fb\u52a8\u7aef\u6587\u4ef6\u63a7\u4ef6\uff08\u591a\u9879\uff09"), @CodeItem(value="MOBPASSWORD", text="\u79fb\u52a8\u7aef\u5bc6\u7801\u6846", realtext="\u79fb\u52a8\u7aef\u5bc6\u7801\u6846"), @CodeItem(value="MOBSLIDER", text="\u79fb\u52a8\u7aef\u6ed1\u52a8\u8f93\u5165\u6761", realtext="\u79fb\u52a8\u7aef\u6ed1\u52a8\u8f93\u5165\u6761"), @CodeItem(value="MOBSTEPPER", text="\u79fb\u52a8\u7aef\u6b65\u8fdb\u5668", realtext="\u79fb\u52a8\u7aef\u6b65\u8fdb\u5668"), @CodeItem(value="MOBRATING", text="\u79fb\u52a8\u7aef\u8bc4\u5206\u5668", realtext="\u79fb\u52a8\u7aef\u8bc4\u5206\u5668"), @CodeItem(value="MOBHTMLTEXT", text="\u79fb\u52a8\u7aefHTML\u7f16\u8f91\u6846", realtext="\u79fb\u52a8\u7aefHTML\u7f16\u8f91\u6846"), @CodeItem(value="MOBCODE", text="\u79fb\u52a8\u7aef\u4ee3\u7801\u7f16\u8f91\u6846", realtext="\u79fb\u52a8\u7aef\u4ee3\u7801\u7f16\u8f91\u6846"), @CodeItem(value="MOBMARKDOWN", text="\u79fb\u52a8\u7aefMarkdown\u7f16\u8f91\u6846", realtext="\u79fb\u52a8\u7aefMarkdown\u7f16\u8f91\u6846"), @CodeItem(value="MOBNUMBERRANGE", text="\u79fb\u52a8\u7aef\u6570\u503c\u8303\u56f4\u7f16\u8f91\u6846", realtext="\u79fb\u52a8\u7aef\u6570\u503c\u8303\u56f4\u7f16\u8f91\u6846"), @CodeItem(value="MOBDATERANGE", text="\u79fb\u52a8\u7aef\u65f6\u95f4\u8303\u56f4\u9009\u62e9\u5668", realtext="\u79fb\u52a8\u7aef\u65f6\u95f4\u8303\u56f4\u9009\u62e9\u5668"), @CodeItem(value="MOBDATERANGE_NOTIME", text="\u79fb\u52a8\u7aef\u65f6\u95f4\u8303\u56f4\u9009\u62e9\u5668\uff08YYYY-MM-DD\uff09", realtext="\u79fb\u52a8\u7aef\u65f6\u95f4\u8303\u56f4\u9009\u62e9\u5668\uff08YYYY-MM-DD\uff09"), @CodeItem(value="MOBCASCADER", text="\u79fb\u52a8\u7aef\u7ea7\u8054\u9009\u62e9\u5668", realtext="\u79fb\u52a8\u7aef\u7ea7\u8054\u9009\u62e9\u5668"), @CodeItem(value="MOBARRAY", text="\u79fb\u52a8\u7aef\u6570\u7ec4\u7f16\u8f91\u5668", realtext="\u79fb\u52a8\u7aef\u6570\u7ec4\u7f16\u8f91\u5668"), @CodeItem(value="MOBMAPPICKER", text="\u79fb\u52a8\u7aef\u5730\u56fe\u9009\u62e9\u5668", realtext="\u79fb\u52a8\u7aef\u5730\u56fe\u9009\u62e9\u5668"), @CodeItem(value="MOBCOLORPICKER", text="\u79fb\u52a8\u7aef\u989c\u8272\u9009\u62e9\u5668", realtext="\u79fb\u52a8\u7aef\u989c\u8272\u9009\u62e9\u5668")})
public class EditorTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String TEXTBOX = "TEXTBOX";
    public static final String NUMBER = "NUMBER";
    public static final String PASSWORD = "PASSWORD";
    public static final String HIDDEN = "HIDDEN";
    public static final String TEXTAREA = "TEXTAREA";
    public static final String TEXTAREA_10 = "TEXTAREA_10";
    public static final String IPADDRESSTEXTBOX = "IPADDRESSTEXTBOX";
    public static final String RAW = "RAW";
    public static final String STEPPER = "STEPPER";
    public static final String RATING = "RATING";
    public static final String SLIDER = "SLIDER";
    public static final String SPAN = "SPAN";
    public static final String SPANEX = "SPANEX";
    public static final String SPAN_LINK = "SPAN_LINK";
    public static final String DROPDOWNLIST = "DROPDOWNLIST";
    public static final String DROPDOWNLIST_100 = "DROPDOWNLIST_100";
    public static final String MDROPDOWNLIST = "MDROPDOWNLIST";
    public static final String CHECKBOX = "CHECKBOX";
    public static final String SWITCH = "SWITCH";
    public static final String RADIOBUTTONLIST = "RADIOBUTTONLIST";
    public static final String CHECKBOXLIST = "CHECKBOXLIST";
    public static final String LISTBOX = "LISTBOX";
    public static final String LISTBOXPICKUP = "LISTBOXPICKUP";
    public static final String ADDRESSPICKUP = "ADDRESSPICKUP";
    public static final String ADDRESSPICKUP_AC = "ADDRESSPICKUP_AC";
    public static final String DATEPICKEREX = "DATEPICKEREX";
    public static final String DATEPICKEREX_NOTIME = "DATEPICKEREX_NOTIME";
    public static final String DATEPICKEREX_NODAY = "DATEPICKEREX_NODAY";
    public static final String DATEPICKEREX_HOUR = "DATEPICKEREX_HOUR";
    public static final String DATEPICKEREX_MINUTE = "DATEPICKEREX_MINUTE";
    public static final String DATEPICKEREX_SECOND = "DATEPICKEREX_SECOND";
    public static final String DATEPICKEREX_NODAY_NOSECOND = "DATEPICKEREX_NODAY_NOSECOND";
    public static final String DATEPICKER = "DATEPICKER";
    public static final String PICKER = "PICKER";
    public static final String PICKEREX_LINK = "PICKEREX_LINK";
    public static final String PICKEREX_NOAC = "PICKEREX_NOAC";
    public static final String PICKEREX_LINKONLY = "PICKEREX_LINKONLY";
    public static final String PICKEREX_NOAC_LINK = "PICKEREX_NOAC_LINK";
    public static final String PICKEREX_TRIGGER = "PICKEREX_TRIGGER";
    public static final String PICKEREX_TRIGGER_LINK = "PICKEREX_TRIGGER_LINK";
    public static final String PICKEREX_NOBUTTON = "PICKEREX_NOBUTTON";
    public static final String PICKEREX_DROPDOWNVIEW = "PICKEREX_DROPDOWNVIEW";
    public static final String PICKEREX_DROPDOWNVIEW_LINK = "PICKEREX_DROPDOWNVIEW_LINK";
    public static final String PICKUPVIEW = "PICKUPVIEW";
    public static final String AC = "AC";
    public static final String AC_FS = "AC_FS";
    public static final String AC_NOBUTTON = "AC_NOBUTTON";
    public static final String AC_FS_NOBUTTON = "AC_FS_NOBUTTON";
    public static final String HTMLEDITOR = "HTMLEDITOR";
    public static final String CODE = "CODE";
    public static final String MARKDOWN = "MARKDOWN";
    public static final String OFFICEEDITOR = "OFFICEEDITOR";
    public static final String OFFICEEDITOR2 = "OFFICEEDITOR2";
    public static final String PICTURE = "PICTURE";
    public static final String PICTURE_ONE = "PICTURE_ONE";
    public static final String PICTURE_ONE_RAW = "PICTURE_ONE_RAW";
    public static final String FILEUPLOADER = "FILEUPLOADER";
    public static final String PREDEFINED = "PREDEFINED";
    public static final String FILEUPLOADER_ONE = "FILEUPLOADER_ONE";
    public static final String NUMBERRANGE = "NUMBERRANGE";
    public static final String DATERANGE = "DATERANGE";
    public static final String DATERANGE_NOTIME = "DATERANGE_NOTIME";
    public static final String CASCADER = "CASCADER";
    public static final String ARRAY = "ARRAY";
    public static final String COLORPICKER = "COLORPICKER";
    public static final String MAPPICKER = "MAPPICKER";
    public static final String USERCONTROL = "USERCONTROL";
    public static final String MOBTEXT = "MOBTEXT";
    public static final String MOBNUMBER = "MOBNUMBER";
    public static final String MOBTEXTAREA = "MOBTEXTAREA";
    public static final String MOBBARCODEREADER = "MOBBARCODEREADER";
    public static final String MOBSWITCH = "MOBSWITCH";
    public static final String MOB2DBARCODEREADER = "MOB2DBARCODEREADER";
    public static final String MOBRADIOLIST = "MOBRADIOLIST";
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

    public EditorTypeCodeListModel() {
        this.initAnnotation(EditorTypeCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("EditorType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.EditorTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.EditorTypeCodeListModel");
    }
}

