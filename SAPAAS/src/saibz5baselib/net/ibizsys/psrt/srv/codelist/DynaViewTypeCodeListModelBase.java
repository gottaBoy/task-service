/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="d3220274deae2f484dfb18e927885909", name="\u52a8\u6001\u89c6\u56fe\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="APPINDEXVIEW", text="\u5e94\u7528\u9996\u9875\u89c6\u56fe", realtext="\u5e94\u7528\u9996\u9875\u89c6\u56fe"), @CodeItem(value="APPPORTALVIEW", text="\u5e94\u7528\u95e8\u6237\u89c6\u56fe", realtext="\u5e94\u7528\u95e8\u6237\u89c6\u56fe"), @CodeItem(value="DECHARTVIEW", text="\u5b9e\u4f53\u56fe\u8868\u89c6\u56fe", realtext="\u5b9e\u4f53\u56fe\u8868\u89c6\u56fe"), @CodeItem(value="DECUSTOMVIEW", text="\u5b9e\u4f53\u81ea\u5b9a\u4e49\u89c6\u56fe", realtext="\u5b9e\u4f53\u81ea\u5b9a\u4e49\u89c6\u56fe"), @CodeItem(value="DEDATAVIEW", text="\u5b9e\u4f53\u6570\u636e\u89c6\u56fe", realtext="\u5b9e\u4f53\u6570\u636e\u89c6\u56fe"), @CodeItem(value="DEEDITVIEW", text="\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe", realtext="\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe"), @CodeItem(value="DEEDITVIEW2", text="\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09", realtext="\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09"), @CodeItem(value="DEEDITVIEW3", text="\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09", realtext="\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09"), @CodeItem(value="DEEDITVIEW4", text="\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe\uff08\u4e0a\u4e0b\u5173\u7cfb\uff09", realtext="\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe\uff08\u4e0a\u4e0b\u5173\u7cfb\uff09"), @CodeItem(value="DEEDITVIEW9", text="\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe\uff08\u5d4c\u5165\uff09", realtext="\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe\uff08\u5d4c\u5165\uff09"), @CodeItem(value="DEFORMPICKUPDATAVIEW", text="\u5b9e\u4f53\u8868\u5355\u9009\u62e9\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09", realtext="\u5b9e\u4f53\u8868\u5355\u9009\u62e9\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09"), @CodeItem(value="DEGRIDVIEW", text="\u5b9e\u4f53\u8868\u683c\u89c6\u56fe", realtext="\u5b9e\u4f53\u8868\u683c\u89c6\u56fe"), @CodeItem(value="DEGRIDVIEW2", text="\u5b9e\u4f53\u8868\u683c\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09", realtext="\u5b9e\u4f53\u8868\u683c\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09"), @CodeItem(value="DEGRIDVIEW4", text="\u5b9e\u4f53\u8868\u683c\u89c6\u56fe\uff08\u4e0a\u4e0b\u5173\u7cfb\uff09", realtext="\u5b9e\u4f53\u8868\u683c\u89c6\u56fe\uff08\u4e0a\u4e0b\u5173\u7cfb\uff09"), @CodeItem(value="DEGRIDVIEW8", text="\u5b9e\u4f53\u5173\u7cfb\u6570\u636e\u8868\u683c\u89c6\u56fe\uff08\u5d4c\u5165\uff09", realtext="\u5b9e\u4f53\u5173\u7cfb\u6570\u636e\u8868\u683c\u89c6\u56fe\uff08\u5d4c\u5165\uff09"), @CodeItem(value="DEGRIDVIEW9", text="\u5b9e\u4f53\u8868\u683c\u89c6\u56fe\uff08\u5d4c\u5165\uff09", realtext="\u5b9e\u4f53\u8868\u683c\u89c6\u56fe\uff08\u5d4c\u5165\uff09"), @CodeItem(value="DEHTMLVIEW", text="\u5b9e\u4f53HTML\u89c6\u56fe", realtext="\u5b9e\u4f53HTML\u89c6\u56fe"), @CodeItem(value="DEINDEXPICKUPDATAVIEW", text="\u5b9e\u4f53\u7d22\u5f15\u5173\u7cfb\u9009\u62e9\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09", realtext="\u5b9e\u4f53\u7d22\u5f15\u5173\u7cfb\u9009\u62e9\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09"), @CodeItem(value="DEINDEXVIEW", text="\u5b9e\u4f53\u9996\u9875\u89c6\u56fe", realtext="\u5b9e\u4f53\u9996\u9875\u89c6\u56fe"), @CodeItem(value="DEMDCUSTOMVIEW", text="\u5b9e\u4f53\u591a\u6570\u636e\u81ea\u5b9a\u4e49\u89c6\u56fe", realtext="\u5b9e\u4f53\u591a\u6570\u636e\u81ea\u5b9a\u4e49\u89c6\u56fe"), @CodeItem(value="DEMEDITVIEW9", text="\u5b9e\u4f53\u591a\u8868\u5355\u7f16\u8f91\u89c6\u56fe\uff08\u5d4c\u5165\uff09", realtext="\u5b9e\u4f53\u591a\u8868\u5355\u7f16\u8f91\u89c6\u56fe\uff08\u5d4c\u5165\uff09"), @CodeItem(value="DEMOBCUSTOMVIEW", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u81ea\u5b9a\u4e49\u89c6\u56fe", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u81ea\u5b9a\u4e49\u89c6\u56fe"), @CodeItem(value="DEMOBEDITVIEW", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u7f16\u8f91\u89c6\u56fe", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u7f16\u8f91\u89c6\u56fe"), @CodeItem(value="DEMOBFORMPICKUPMDVIEW", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u8868\u5355\u7c7b\u578b\u9009\u62e9\u591a\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u8868\u5355\u7c7b\u578b\u9009\u62e9\u591a\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09"), @CodeItem(value="DEMOBINDEXPICKUPMDVIEW", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u7d22\u5f15\u7c7b\u578b\u9009\u62e9\u591a\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u7d22\u5f15\u7c7b\u578b\u9009\u62e9\u591a\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09"), @CodeItem(value="DEMOBLISTVIEW", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u5217\u8868\u89c6\u56fe", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u5217\u8868\u89c6\u56fe"), @CodeItem(value="DEMOBMDVIEW", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u591a\u6570\u636e\u89c6\u56fe", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u591a\u6570\u636e\u89c6\u56fe"), @CodeItem(value="DEMOBMDVIEW9", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u591a\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u591a\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09"), @CodeItem(value="DEMOBMPICKUPVIEW", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u591a\u6570\u636e\u9009\u62e9\u89c6\u56fe", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u591a\u6570\u636e\u9009\u62e9\u89c6\u56fe"), @CodeItem(value="DEMOBPICKUPLISTVIEW", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u9009\u62e9\u5217\u8868\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u9009\u62e9\u5217\u8868\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09"), @CodeItem(value="DEMOBPICKUPMDVIEW", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u9009\u62e9\u591a\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u9009\u62e9\u591a\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09"), @CodeItem(value="DEMOBPICKUPTREEVIEW", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u9009\u62e9\u6811\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u9009\u62e9\u6811\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09"), @CodeItem(value="DEMOBPICKUPVIEW", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u6570\u636e\u9009\u62e9\u89c6\u56fe", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u6570\u636e\u9009\u62e9\u89c6\u56fe"), @CodeItem(value="DEMOBTABEXPVIEW", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u5206\u9875\u5bfc\u822a\u89c6\u56fe", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u5206\u9875\u5bfc\u822a\u89c6\u56fe"), @CodeItem(value="DEMOBTREEVIEW", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u6811\u89c6\u56fe", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u6811\u89c6\u56fe"), @CodeItem(value="DEMOBWFACTIONVIEW", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u64cd\u4f5c\u89c6\u56fe", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u64cd\u4f5c\u89c6\u56fe"), @CodeItem(value="DEMOBWFEDITVIEW", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe"), @CodeItem(value="DEMOBWFEDITVIEW3", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09"), @CodeItem(value="DEMOBWFMDVIEW", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u591a\u6570\u636e\u89c6\u56fe", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u591a\u6570\u636e\u89c6\u56fe"), @CodeItem(value="DEMOBWFSTARTVIEW", text="\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u542f\u52a8\u89c6\u56fe", realtext="\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u542f\u52a8\u89c6\u56fe"), @CodeItem(value="DEMPICKUPVIEW", text="\u5b9e\u4f53\u6570\u636e\u591a\u9879\u9009\u62e9\u89c6\u56fe", realtext="\u5b9e\u4f53\u6570\u636e\u591a\u9879\u9009\u62e9\u89c6\u56fe"), @CodeItem(value="DEMPICKUPVIEW2", text="\u5b9e\u4f53\u591a\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09", realtext="\u5b9e\u4f53\u591a\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09"), @CodeItem(value="DEOPTVIEW", text="\u5b9e\u4f53\u9009\u9879\u64cd\u4f5c\u89c6\u56fe", realtext="\u5b9e\u4f53\u9009\u9879\u64cd\u4f5c\u89c6\u56fe"), @CodeItem(value="DEPICKUPDATAVIEW", text="\u5b9e\u4f53\u9009\u62e9\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09", realtext="\u5b9e\u4f53\u9009\u62e9\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09"), @CodeItem(value="DEPICKUPGRIDVIEW", text="\u5b9e\u4f53\u9009\u62e9\u8868\u683c\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09", realtext="\u5b9e\u4f53\u9009\u62e9\u8868\u683c\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09"), @CodeItem(value="DEPICKUPTREEVIEW", text="\u5b9e\u4f53\u9009\u62e9\u6811\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09", realtext="\u5b9e\u4f53\u9009\u62e9\u6811\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09"), @CodeItem(value="DEPICKUPVIEW", text="\u5b9e\u4f53\u6570\u636e\u9009\u62e9\u89c6\u56fe", realtext="\u5b9e\u4f53\u6570\u636e\u9009\u62e9\u89c6\u56fe"), @CodeItem(value="DEPICKUPVIEW2", text="\u5b9e\u4f53\u6570\u636e\u9009\u62e9\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09", realtext="\u5b9e\u4f53\u6570\u636e\u9009\u62e9\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09"), @CodeItem(value="DEPORTALVIEW", text="\u5b9e\u4f53\u6570\u636e\u770b\u677f\u89c6\u56fe", realtext="\u5b9e\u4f53\u6570\u636e\u770b\u677f\u89c6\u56fe"), @CodeItem(value="DEREDIRECTVIEW", text="\u5b9e\u4f53\u6570\u636e\u91cd\u5b9a\u5411\u89c6\u56fe", realtext="\u5b9e\u4f53\u6570\u636e\u91cd\u5b9a\u5411\u89c6\u56fe"), @CodeItem(value="DEREPORTVIEW", text="\u5b9e\u4f53\u62a5\u8868\u89c6\u56fe", realtext="\u5b9e\u4f53\u62a5\u8868\u89c6\u56fe"), @CodeItem(value="DETABEXPVIEW", text="\u5b9e\u4f53\u5206\u9875\u5bfc\u822a\u89c6\u56fe", realtext="\u5b9e\u4f53\u5206\u9875\u5bfc\u822a\u89c6\u56fe"), @CodeItem(value="DETREEEXPVIEW", text="\u5b9e\u4f53\u6811\u5bfc\u822a\u89c6\u56fe", realtext="\u5b9e\u4f53\u6811\u5bfc\u822a\u89c6\u56fe"), @CodeItem(value="DETREEEXPVIEW2", text="\u5b9e\u4f53\u6811\u5bfc\u822a\u89c6\u56fe\uff08IFrame\uff09", realtext="\u5b9e\u4f53\u6811\u5bfc\u822a\u89c6\u56fe\uff08IFrame\uff09"), @CodeItem(value="DETREEEXPVIEW3", text="\u5b9e\u4f53\u6811\u5bfc\u822a\u89c6\u56fe\uff08\u83dc\u5355\u6a21\u5f0f\uff09", realtext="\u5b9e\u4f53\u6811\u5bfc\u822a\u89c6\u56fe\uff08\u83dc\u5355\u6a21\u5f0f\uff09"), @CodeItem(value="DETREEGRIDVIEW9", text="\u5b9e\u4f53\u6811\u8868\u683c\u89c6\u56fe\uff08\u5d4c\u5165\uff09", realtext="\u5b9e\u4f53\u6811\u8868\u683c\u89c6\u56fe\uff08\u5d4c\u5165\uff09"), @CodeItem(value="DETREEVIEW", text="\u5b9e\u4f53\u6811\u89c6\u56fe", realtext="\u5b9e\u4f53\u6811\u89c6\u56fe"), @CodeItem(value="DETREEVIEW9", text="\u5b9e\u4f53\u6811\u89c6\u56fe\uff08\u5d4c\u5165\uff09", realtext="\u5b9e\u4f53\u6811\u89c6\u56fe\uff08\u5d4c\u5165\uff09"), @CodeItem(value="DEWFACTIONVIEW", text="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u64cd\u4f5c\u89c6\u56fe", realtext="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u64cd\u4f5c\u89c6\u56fe"), @CodeItem(value="DEWFDATAREDIRECTVIEW", text="\u5b9e\u4f53\u5168\u5c40\u6d41\u7a0b\u6570\u636e\u91cd\u5b9a\u5411\u89c6\u56fe", realtext="\u5b9e\u4f53\u5168\u5c40\u6d41\u7a0b\u6570\u636e\u91cd\u5b9a\u5411\u89c6\u56fe"), @CodeItem(value="DEWFEDITVIEW", text="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe", realtext="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe"), @CodeItem(value="DEWFEDITVIEW2", text="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09", realtext="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09"), @CodeItem(value="DEWFEDITVIEW3", text="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09", realtext="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09"), @CodeItem(value="DEWFEXPVIEW", text="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bfc\u822a\u89c6\u56fe", realtext="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bfc\u822a\u89c6\u56fe"), @CodeItem(value="DEWFGRIDVIEW", text="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u8868\u683c\u89c6\u56fe", realtext="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u8868\u683c\u89c6\u56fe"), @CodeItem(value="DEWFSTARTVIEW", text="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u542f\u52a8\u89c6\u56fe", realtext="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u542f\u52a8\u89c6\u56fe"), @CodeItem(value="DEWIZARDVIEW", text="\u5b9e\u4f53\u5411\u5bfc\u89c6\u56fe", realtext="\u5b9e\u4f53\u5411\u5bfc\u89c6\u56fe")})
public abstract class DynaViewTypeCodeListModelBase
extends StaticCodeListModelBase {
    public static final String APPINDEXVIEW = "APPINDEXVIEW";
    public static final String APPPORTALVIEW = "APPPORTALVIEW";
    public static final String DECHARTVIEW = "DECHARTVIEW";
    public static final String DECUSTOMVIEW = "DECUSTOMVIEW";
    public static final String DEDATAVIEW = "DEDATAVIEW";
    public static final String DEEDITVIEW = "DEEDITVIEW";
    public static final String DEEDITVIEW2 = "DEEDITVIEW2";
    public static final String DEEDITVIEW3 = "DEEDITVIEW3";
    public static final String DEEDITVIEW4 = "DEEDITVIEW4";
    public static final String DEEDITVIEW9 = "DEEDITVIEW9";
    public static final String DEFORMPICKUPDATAVIEW = "DEFORMPICKUPDATAVIEW";
    public static final String DEGRIDVIEW = "DEGRIDVIEW";
    public static final String DEGRIDVIEW2 = "DEGRIDVIEW2";
    public static final String DEGRIDVIEW4 = "DEGRIDVIEW4";
    public static final String DEGRIDVIEW8 = "DEGRIDVIEW8";
    public static final String DEGRIDVIEW9 = "DEGRIDVIEW9";
    public static final String DEHTMLVIEW = "DEHTMLVIEW";
    public static final String DEINDEXPICKUPDATAVIEW = "DEINDEXPICKUPDATAVIEW";
    public static final String DEINDEXVIEW = "DEINDEXVIEW";
    public static final String DEMDCUSTOMVIEW = "DEMDCUSTOMVIEW";
    public static final String DEMEDITVIEW9 = "DEMEDITVIEW9";
    public static final String DEMOBCUSTOMVIEW = "DEMOBCUSTOMVIEW";
    public static final String DEMOBEDITVIEW = "DEMOBEDITVIEW";
    public static final String DEMOBFORMPICKUPMDVIEW = "DEMOBFORMPICKUPMDVIEW";
    public static final String DEMOBINDEXPICKUPMDVIEW = "DEMOBINDEXPICKUPMDVIEW";
    public static final String DEMOBLISTVIEW = "DEMOBLISTVIEW";
    public static final String DEMOBMDVIEW = "DEMOBMDVIEW";
    public static final String DEMOBMDVIEW9 = "DEMOBMDVIEW9";
    public static final String DEMOBMPICKUPVIEW = "DEMOBMPICKUPVIEW";
    public static final String DEMOBPICKUPLISTVIEW = "DEMOBPICKUPLISTVIEW";
    public static final String DEMOBPICKUPMDVIEW = "DEMOBPICKUPMDVIEW";
    public static final String DEMOBPICKUPTREEVIEW = "DEMOBPICKUPTREEVIEW";
    public static final String DEMOBPICKUPVIEW = "DEMOBPICKUPVIEW";
    public static final String DEMOBTABEXPVIEW = "DEMOBTABEXPVIEW";
    public static final String DEMOBTREEVIEW = "DEMOBTREEVIEW";
    public static final String DEMOBWFACTIONVIEW = "DEMOBWFACTIONVIEW";
    public static final String DEMOBWFEDITVIEW = "DEMOBWFEDITVIEW";
    public static final String DEMOBWFEDITVIEW3 = "DEMOBWFEDITVIEW3";
    public static final String DEMOBWFMDVIEW = "DEMOBWFMDVIEW";
    public static final String DEMOBWFSTARTVIEW = "DEMOBWFSTARTVIEW";
    public static final String DEMPICKUPVIEW = "DEMPICKUPVIEW";
    public static final String DEMPICKUPVIEW2 = "DEMPICKUPVIEW2";
    public static final String DEOPTVIEW = "DEOPTVIEW";
    public static final String DEPICKUPDATAVIEW = "DEPICKUPDATAVIEW";
    public static final String DEPICKUPGRIDVIEW = "DEPICKUPGRIDVIEW";
    public static final String DEPICKUPTREEVIEW = "DEPICKUPTREEVIEW";
    public static final String DEPICKUPVIEW = "DEPICKUPVIEW";
    public static final String DEPICKUPVIEW2 = "DEPICKUPVIEW2";
    public static final String DEPORTALVIEW = "DEPORTALVIEW";
    public static final String DEREDIRECTVIEW = "DEREDIRECTVIEW";
    public static final String DEREPORTVIEW = "DEREPORTVIEW";
    public static final String DETABEXPVIEW = "DETABEXPVIEW";
    public static final String DETREEEXPVIEW = "DETREEEXPVIEW";
    public static final String DETREEEXPVIEW2 = "DETREEEXPVIEW2";
    public static final String DETREEEXPVIEW3 = "DETREEEXPVIEW3";
    public static final String DETREEGRIDVIEW9 = "DETREEGRIDVIEW9";
    public static final String DETREEVIEW = "DETREEVIEW";
    public static final String DETREEVIEW9 = "DETREEVIEW9";
    public static final String DEWFACTIONVIEW = "DEWFACTIONVIEW";
    public static final String DEWFDATAREDIRECTVIEW = "DEWFDATAREDIRECTVIEW";
    public static final String DEWFEDITVIEW = "DEWFEDITVIEW";
    public static final String DEWFEDITVIEW2 = "DEWFEDITVIEW2";
    public static final String DEWFEDITVIEW3 = "DEWFEDITVIEW3";
    public static final String DEWFEXPVIEW = "DEWFEXPVIEW";
    public static final String DEWFGRIDVIEW = "DEWFGRIDVIEW";
    public static final String DEWFSTARTVIEW = "DEWFSTARTVIEW";
    public static final String DEWIZARDVIEW = "DEWIZARDVIEW";

    public DynaViewTypeCodeListModelBase() {
        this.initAnnotation(DynaViewTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.DynaViewTypeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.DynaViewTypeCodeListModel");
    }
}

