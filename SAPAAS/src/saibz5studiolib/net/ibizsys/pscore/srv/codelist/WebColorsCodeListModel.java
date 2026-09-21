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

@CodeList(id="23614C04-52EB-4C43-98C5-D5F7CA50490C", name="Web\u989c\u8272", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="AliceBlue", text="\uff08\u7231\u4e3d\u4e1d\u84dd\uff09AliceBlue", realtext="\uff08\u7231\u4e3d\u4e1d\u84dd\uff09AliceBlue"), @CodeItem(value="AntiqueWhite", text="\uff08\u53e4\u8463\u767d\uff09AntiqueWhite", realtext="\uff08\u53e4\u8463\u767d\uff09AntiqueWhite"), @CodeItem(value="Aqua", text="\uff08\u6c34\u7eff\u8272\uff09Aqua", realtext="\uff08\u6c34\u7eff\u8272\uff09Aqua"), @CodeItem(value="Aquamarine", text="\uff08\u78a7\u7eff\uff09Aquamarine", realtext="\uff08\u78a7\u7eff\uff09Aquamarine"), @CodeItem(value="Azure", text="\uff08\u5929\u84dd\u8272\uff09Azure", realtext="\uff08\u5929\u84dd\u8272\uff09Azure"), @CodeItem(value="Beige", text="\uff08\u7c73\u8272\uff09Beige", realtext="\uff08\u7c73\u8272\uff09Beige"), @CodeItem(value="Bisque", text="\uff08\u6a58\u9ec4\u8272\uff09Bisque", realtext="\uff08\u6a58\u9ec4\u8272\uff09Bisque"), @CodeItem(value="Black", text="\uff08\u9ed1\u8272\uff09Black", realtext="\uff08\u9ed1\u8272\uff09Black"), @CodeItem(value="BlanchedAlmond", text="\uff08\u674f\u4ec1\u767d\uff09BlanchedAlmond", realtext="\uff08\u674f\u4ec1\u767d\uff09BlanchedAlmond"), @CodeItem(value="Blue", text="\uff08\u84dd\u8272\uff09Blue", realtext="\uff08\u84dd\u8272\uff09Blue"), @CodeItem(value="BlueViolet", text="\uff08\u84dd\u7d2b\u8272\uff09BlueViolet", realtext="\uff08\u84dd\u7d2b\u8272\uff09BlueViolet"), @CodeItem(value="Brown", text="\uff08\u8910\u8272\uff09Brown", realtext="\uff08\u8910\u8272\uff09Brown"), @CodeItem(value="BurlyWood", text="\uff08\u786c\u6728\u8910\uff09BurlyWood", realtext="\uff08\u786c\u6728\u8910\uff09BurlyWood"), @CodeItem(value="CadetBlue", text="\uff08\u519b\u670d\u84dd\uff09CadetBlue", realtext="\uff08\u519b\u670d\u84dd\uff09CadetBlue"), @CodeItem(value="Chartreuse", text="\uff08\u9ec4\u7eff\uff09Chartreuse", realtext="\uff08\u9ec4\u7eff\uff09Chartreuse"), @CodeItem(value="Chocolate", text="\uff08\u5de7\u514b\u529b\u8272\uff09Chocolate", realtext="\uff08\u5de7\u514b\u529b\u8272\uff09Chocolate"), @CodeItem(value="Coral", text="\uff08\u73ca\u745a\u7ea2\uff09Coral", realtext="\uff08\u73ca\u745a\u7ea2\uff09Coral"), @CodeItem(value="CornflowerBlue", text="\uff08\u77e2\u8f66\u83ca\u84dd\uff09CornflowerBlue", realtext="\uff08\u77e2\u8f66\u83ca\u84dd\uff09CornflowerBlue"), @CodeItem(value="Cornsilk", text="\uff08\u7389\u7c73\u7a57\u9ec4\uff09Cornsilk", realtext="\uff08\u7389\u7c73\u7a57\u9ec4\uff09Cornsilk"), @CodeItem(value="Crimson", text="\uff08\u7eef\u7ea2\uff09Crimson", realtext="\uff08\u7eef\u7ea2\uff09Crimson"), @CodeItem(value="Cyan", text="\uff08\u9752\u8272\uff09Cyan", realtext="\uff08\u9752\u8272\uff09Cyan"), @CodeItem(value="DarkBlue", text="\uff08\u6df1\u84dd\uff09DarkBlue", realtext="\uff08\u6df1\u84dd\uff09DarkBlue"), @CodeItem(value="DarkCyan", text="\uff08\u6df1\u9752\uff09DarkCyan", realtext="\uff08\u6df1\u9752\uff09DarkCyan"), @CodeItem(value="DarkGoldenRod", text="\uff08\u6df1\u91d1\u83ca\u9ec4\uff09DarkGoldenRod", realtext="\uff08\u6df1\u91d1\u83ca\u9ec4\uff09DarkGoldenRod"), @CodeItem(value="DarkGray", text="\uff08\u6697\u8272\uff09DarkGray", realtext="\uff08\u6697\u8272\uff09DarkGray"), @CodeItem(value="DarkGreen", text="\uff08\u6df1\u7eff\uff09DarkGreen", realtext="\uff08\u6df1\u7eff\uff09DarkGreen"), @CodeItem(value="DarkKhaki", text="\uff08\u6df1\u5361\u5176\u8272\uff09DarkKhaki", realtext="\uff08\u6df1\u5361\u5176\u8272\uff09DarkKhaki"), @CodeItem(value="DarkMagenta", text="\uff08\u6df1\u54c1\u7ea2\uff09DarkMagenta", realtext="\uff08\u6df1\u54c1\u7ea2\uff09DarkMagenta"), @CodeItem(value="DarkOliveGreen", text="\uff08\u6df1\u6a44\u6984\u7eff\uff09DarkOliveGreen", realtext="\uff08\u6df1\u6a44\u6984\u7eff\uff09DarkOliveGreen"), @CodeItem(value="Darkorange", text="\uff08\u6df1\u6a59\uff09Darkorange", realtext="\uff08\u6df1\u6a59\uff09Darkorange"), @CodeItem(value="DarkOrchid", text="\uff08\u6df1\u6d0b\u5170\u7d2b\uff09DarkOrchid", realtext="\uff08\u6df1\u6d0b\u5170\u7d2b\uff09DarkOrchid"), @CodeItem(value="DarkRed", text="\uff08\u6df1\u7ea2\uff09DarkRed", realtext="\uff08\u6df1\u7ea2\uff09DarkRed"), @CodeItem(value="DarkSalmon", text="\uff08\u6df1\u9c91\u7ea2\uff09DarkSalmon", realtext="\uff08\u6df1\u9c91\u7ea2\uff09DarkSalmon"), @CodeItem(value="DarkSeaGreen", text="\uff08\u6df1\u6d77\u85fb\u7eff\uff09DarkSeaGreen", realtext="\uff08\u6df1\u6d77\u85fb\u7eff\uff09DarkSeaGreen"), @CodeItem(value="DarkSlateBlue", text="\uff08\u6df1\u5ca9\u84dd\uff09DarkSlateBlue", realtext="\uff08\u6df1\u5ca9\u84dd\uff09DarkSlateBlue"), @CodeItem(value="DarkSlateGray", text="\uff08\u6df1\u5ca9\u7070\uff09DarkSlateGray", realtext="\uff08\u6df1\u5ca9\u7070\uff09DarkSlateGray"), @CodeItem(value="DarkTurquoise", text="\uff08\u6df1\u677e\u77f3\u7eff\uff09DarkTurquoise", realtext="\uff08\u6df1\u677e\u77f3\u7eff\uff09DarkTurquoise"), @CodeItem(value="DarkViolet", text="\uff08\u6df1\u7d2b\uff09DarkViolet", realtext="\uff08\u6df1\u7d2b\uff09DarkViolet"), @CodeItem(value="DeepPink", text="\uff08\u6df1\u7ea2\uff09DeepPink", realtext="\uff08\u6df1\u7ea2\uff09DeepPink"), @CodeItem(value="DeepSkyBlue", text="\uff08\u6df1\u5929\u84dd\uff09DeepSkyBlue", realtext="\uff08\u6df1\u5929\u84dd\uff09DeepSkyBlue"), @CodeItem(value="DimGray", text="\uff08\u660f\u7070\uff09DimGray", realtext="\uff08\u660f\u7070\uff09DimGray"), @CodeItem(value="DodgerBlue", text="\uff08\u6e56\u84dd\uff09DodgerBlue", realtext="\uff08\u6e56\u84dd\uff09DodgerBlue"), @CodeItem(value="Feldspar", text="\uff08\u957f\u77f3\u8272\uff09Feldspar", realtext="\uff08\u957f\u77f3\u8272\uff09Feldspar"), @CodeItem(value="FireBrick", text="\uff08\u706b\u7816\u7ea2\uff09FireBrick", realtext="\uff08\u706b\u7816\u7ea2\uff09FireBrick"), @CodeItem(value="FloralWhite", text="\uff08\u82b1\u5349\u767d\uff09FloralWhite", realtext="\uff08\u82b1\u5349\u767d\uff09FloralWhite"), @CodeItem(value="ForestGreen", text="\uff08\u68ee\u6797\u7eff\uff09ForestGreen", realtext="\uff08\u68ee\u6797\u7eff\uff09ForestGreen"), @CodeItem(value="Fuchsia", text="\uff08\u6837\u7ea2\uff09Fuchsia", realtext="\uff08\u6837\u7ea2\uff09Fuchsia"), @CodeItem(value="Gainsboro", text="\uff08\u5e9a\u6c0f\u7070\uff09Gainsboro", realtext="\uff08\u5e9a\u6c0f\u7070\uff09Gainsboro"), @CodeItem(value="GhostWhite", text="\uff08\u5e7d\u7075\u767d\uff09GhostWhite", realtext="\uff08\u5e7d\u7075\u767d\uff09GhostWhite"), @CodeItem(value="Gold", text="\uff08\u91d1\u8272\uff09Gold", realtext="\uff08\u91d1\u8272\uff09Gold"), @CodeItem(value="GoldenRod", text="\uff08\u91d1\u83ca\u9ec4\uff09GoldenRod", realtext="\uff08\u91d1\u83ca\u9ec4\uff09GoldenRod"), @CodeItem(value="Gray", text="\uff08\u7070\u8272\uff09Gray", realtext="\uff08\u7070\u8272\uff09Gray"), @CodeItem(value="Green", text="\uff08\u8c03\u548c\u7eff\uff09Green", realtext="\uff08\u8c03\u548c\u7eff\uff09Green"), @CodeItem(value="GreenYellow", text="\uff08\u9ec4\u7eff\u8272\uff09GreenYellow", realtext="\uff08\u9ec4\u7eff\u8272\uff09GreenYellow"), @CodeItem(value="HoneyDew", text="\uff08\u871c\u74dc\u7eff\uff09HoneyDew", realtext="\uff08\u871c\u74dc\u7eff\uff09HoneyDew"), @CodeItem(value="HotPink", text="\uff08\u8273\u7c89\uff09HotPink", realtext="\uff08\u8273\u7c89\uff09HotPink"), @CodeItem(value="IndianRed", text="\uff08\u5370\u5ea6\u7ea2\uff09IndianRed", realtext="\uff08\u5370\u5ea6\u7ea2\uff09IndianRed"), @CodeItem(value="Indigo", text="\uff08\u975b\u84dd\uff09Indigo", realtext="\uff08\u975b\u84dd\uff09Indigo"), @CodeItem(value="Ivory", text="\uff08\u8c61\u7259\u767d\uff09Ivory", realtext="\uff08\u8c61\u7259\u767d\uff09Ivory"), @CodeItem(value="Khaki", text="\uff08\u5361\u5176\u8272\uff09Khaki", realtext="\uff08\u5361\u5176\u8272\uff09Khaki"), @CodeItem(value="Lavender", text="\uff08\u85b0\u8863\u8349\u7d2b\uff09Lavender", realtext="\uff08\u85b0\u8863\u8349\u7d2b\uff09Lavender"), @CodeItem(value="LavenderBlush", text="\uff08\u85b0\u8863\u8349\u7ea2\uff09LavenderBlush", realtext="\uff08\u85b0\u8863\u8349\u7ea2\uff09LavenderBlush"), @CodeItem(value="LawnGreen", text="\uff08\u8349\u576a\u7eff\uff09LawnGreen", realtext="\uff08\u8349\u576a\u7eff\uff09LawnGreen"), @CodeItem(value="LemonChiffon", text="\uff08\u67e0\u6aac\u7ef8\u9ec4\uff09LemonChiffon", realtext="\uff08\u67e0\u6aac\u7ef8\u9ec4\uff09LemonChiffon"), @CodeItem(value="LightBlue", text="\uff08\u6d45\u84dd\uff09LightBlue", realtext="\uff08\u6d45\u84dd\uff09LightBlue"), @CodeItem(value="LightCoral", text="\uff08\u6d45\u73ca\u745a\u7ea2\uff09LightCoral", realtext="\uff08\u6d45\u73ca\u745a\u7ea2\uff09LightCoral"), @CodeItem(value="LightCyan", text="\uff08\u6d45\u9752\uff09LightCyan", realtext="\uff08\u6d45\u9752\uff09LightCyan"), @CodeItem(value="LightGoldenRodYellow", text="\uff08\u6d45\u91d1\u83ca\u9ec4\uff09LightGoldenRodYellow", realtext="\uff08\u6d45\u91d1\u83ca\u9ec4\uff09LightGoldenRodYellow"), @CodeItem(value="LightGrey", text="\uff08\u4eae\u7070\uff09LightGrey", realtext="\uff08\u4eae\u7070\uff09LightGrey"), @CodeItem(value="LightGreen", text="\uff08\u6d45\u7eff\uff09LightGreen", realtext="\uff08\u6d45\u7eff\uff09LightGreen"), @CodeItem(value="LightPink", text="\uff08\u6d45\u7c89\uff09LightPink", realtext="\uff08\u6d45\u7c89\uff09LightPink"), @CodeItem(value="LightSalmon", text="\uff08\u6d45\u9c91\u7ea2\uff09LightSalmon", realtext="\uff08\u6d45\u9c91\u7ea2\uff09LightSalmon"), @CodeItem(value="LightSeaGreen", text="\uff08\u6d45\u6d77\u85fb\u7eff\uff09LightSeaGreen", realtext="\uff08\u6d45\u6d77\u85fb\u7eff\uff09LightSeaGreen"), @CodeItem(value="LightSkyBlue", text="\uff08\u6d45\u5929\u84dd\uff09LightSkyBlue", realtext="\uff08\u6d45\u5929\u84dd\uff09LightSkyBlue"), @CodeItem(value="LightSlateBlue", text="\uff08\u6d45\u5ca9\u84dd\uff09LightSlateBlue", realtext="\uff08\u6d45\u5ca9\u84dd\uff09LightSlateBlue"), @CodeItem(value="LightSlateGray", text="\uff08\u6d45\u5ca9\u7070\uff09LightSlateGray", realtext="\uff08\u6d45\u5ca9\u7070\uff09LightSlateGray"), @CodeItem(value="LightSteelBlue", text="\uff08\u6d45\u94a2\u9752\uff09LightSteelBlue", realtext="\uff08\u6d45\u94a2\u9752\uff09LightSteelBlue"), @CodeItem(value="LightYellow", text="\uff08\u6d45\u9ec4\uff09LightYellow", realtext="\uff08\u6d45\u9ec4\uff09LightYellow"), @CodeItem(value="Lime", text="\uff08\u7eff\u8272\uff09Lime", realtext="\uff08\u7eff\u8272\uff09Lime"), @CodeItem(value="LimeGreen", text="\uff08\u9752\u67e0\u7eff\uff09LimeGreen", realtext="\uff08\u9752\u67e0\u7eff\uff09LimeGreen"), @CodeItem(value="Linen", text="\uff08\u4e9a\u9ebb\u8272\uff09Linen", realtext="\uff08\u4e9a\u9ebb\u8272\uff09Linen"), @CodeItem(value="Magenta", text="\uff08\u6d0b\u7ea2\uff09Magenta", realtext="\uff08\u6d0b\u7ea2\uff09Magenta"), @CodeItem(value="Maroon", text="\uff08\u6817\u8272\uff09Maroon", realtext="\uff08\u6817\u8272\uff09Maroon"), @CodeItem(value="MediumAquaMarine", text="\uff08\u4e2d\u78a7\u7eff\uff09MediumAquaMarine", realtext="\uff08\u4e2d\u78a7\u7eff\uff09MediumAquaMarine"), @CodeItem(value="MediumBlue", text="\uff08\u4e2d\u84dd\uff09MediumBlue", realtext="\uff08\u4e2d\u84dd\uff09MediumBlue"), @CodeItem(value="MediumOrchid", text="\uff08\u4e2d\u6d0b\u5170\u7d2b\uff09MediumOrchid", realtext="\uff08\u4e2d\u6d0b\u5170\u7d2b\uff09MediumOrchid"), @CodeItem(value="MediumPurple", text="\uff08\u4e2d\u7d2b\uff09MediumPurple", realtext="\uff08\u4e2d\u7d2b\uff09MediumPurple"), @CodeItem(value="MediumSeaGreen", text="\uff08\u4e2d\u6d77\u85fb\u7eff\uff09MediumSeaGreen", realtext="\uff08\u4e2d\u6d77\u85fb\u7eff\uff09MediumSeaGreen"), @CodeItem(value="MediumSlateBlue", text="\uff08\u4e2d\u5ca9\u84dd\uff09MediumSlateBlue", realtext="\uff08\u4e2d\u5ca9\u84dd\uff09MediumSlateBlue"), @CodeItem(value="MediumSpringGreen", text="\uff08\u4e2d\u5ae9\u7eff\uff09MediumSpringGreen", realtext="\uff08\u4e2d\u5ae9\u7eff\uff09MediumSpringGreen"), @CodeItem(value="MediumTurquoise", text="\uff08\u4e2d\u677e\u77f3\u7eff\uff09MediumTurquoise", realtext="\uff08\u4e2d\u677e\u77f3\u7eff\uff09MediumTurquoise"), @CodeItem(value="MediumVioletRed", text="\uff08\u4e2d\u7d2b\u7ea2\uff09MediumVioletRed", realtext="\uff08\u4e2d\u7d2b\u7ea2\uff09MediumVioletRed"), @CodeItem(value="MidnightBlue", text="\uff08\u5348\u591c\u84dd\uff09MidnightBlue", realtext="\uff08\u5348\u591c\u84dd\uff09MidnightBlue"), @CodeItem(value="MintCream", text="\uff08\u8584\u8377\u4e73\u767d\uff09MintCream", realtext="\uff08\u8584\u8377\u4e73\u767d\uff09MintCream"), @CodeItem(value="MistyRose", text="\uff08\u96fe\u73ab\u7470\u7ea2\uff09MistyRose", realtext="\uff08\u96fe\u73ab\u7470\u7ea2\uff09MistyRose"), @CodeItem(value="Moccasin", text="\uff08\u9e7f\u76ae\u8272\uff09Moccasin", realtext="\uff08\u9e7f\u76ae\u8272\uff09Moccasin"), @CodeItem(value="NavajoWhite", text="\uff08\u571f\u8457\u767d\uff09NavajoWhite", realtext="\uff08\u571f\u8457\u767d\uff09NavajoWhite"), @CodeItem(value="Navy", text="\uff08\u85cf\u9752\uff09Navy", realtext="\uff08\u85cf\u9752\uff09Navy"), @CodeItem(value="OldLace", text="\uff08\u65e7\u857e\u4e1d\u767d\uff09OldLace", realtext="\uff08\u65e7\u857e\u4e1d\u767d\uff09OldLace"), @CodeItem(value="Olive", text="\uff08\u6a44\u6984\u8272\uff09Olive", realtext="\uff08\u6a44\u6984\u8272\uff09Olive"), @CodeItem(value="OliveDrab", text="\uff08\u6a44\u6984\u7eff\uff09OliveDrab", realtext="\uff08\u6a44\u6984\u7eff\uff09OliveDrab"), @CodeItem(value="Orange", text="\uff08\u6a59\u8272\uff09Orange", realtext="\uff08\u6a59\u8272\uff09Orange"), @CodeItem(value="OrangeRed", text="\uff08\u6a58\u7ea2\uff09OrangeRed", realtext="\uff08\u6a58\u7ea2\uff09OrangeRed"), @CodeItem(value="Orchid", text="\uff08\u6d0b\u5170\u7d2b\uff09Orchid", realtext="\uff08\u6d0b\u5170\u7d2b\uff09Orchid"), @CodeItem(value="PaleGoldenRod", text="\uff08\u767d\u91d1\u83ca\u9ec4\uff09PaleGoldenRod", realtext="\uff08\u767d\u91d1\u83ca\u9ec4\uff09PaleGoldenRod"), @CodeItem(value="PaleGreen", text="\uff08\u767d\u7eff\u8272\uff09PaleGreen", realtext="\uff08\u767d\u7eff\u8272\uff09PaleGreen"), @CodeItem(value="PaleTurquoise", text="\uff08\u767d\u677e\u77f3\u7eff\uff09PaleTurquoise", realtext="\uff08\u767d\u677e\u77f3\u7eff\uff09PaleTurquoise"), @CodeItem(value="PaleVioletRed", text="\uff08\u767d\u7d2b\u7ea2\uff09PaleVioletRed", realtext="\uff08\u767d\u7d2b\u7ea2\uff09PaleVioletRed"), @CodeItem(value="PapayaWhip", text="\uff08\u756a\u6728\u74dc\u6a59\uff09PapayaWhip", realtext="\uff08\u756a\u6728\u74dc\u6a59\uff09PapayaWhip"), @CodeItem(value="PeachPuff", text="\uff08\u7c89\u6251\u6843\u8272\uff09PeachPuff", realtext="\uff08\u7c89\u6251\u6843\u8272\uff09PeachPuff"), @CodeItem(value="Peru", text="\uff08\u79d8\u9c81\u7ea2\uff09Peru", realtext="\uff08\u79d8\u9c81\u7ea2\uff09Peru"), @CodeItem(value="Pink", text="\uff08\u7c89\u8272\uff09Pink", realtext="\uff08\u7c89\u8272\uff09Pink"), @CodeItem(value="Plum", text="\uff08\u674e\u7d2b\uff09Plum", realtext="\uff08\u674e\u7d2b\uff09Plum"), @CodeItem(value="PowderBlue", text="\uff08\u7c89\u672b\u84dd\uff09PowderBlue", realtext="\uff08\u7c89\u672b\u84dd\uff09PowderBlue"), @CodeItem(value="Purple", text="\uff08\u7d2b\u8272\uff09Purple", realtext="\uff08\u7d2b\u8272\uff09Purple"), @CodeItem(value="Red", text="\uff08\u7ea2\u8272\uff09Red", realtext="\uff08\u7ea2\u8272\uff09Red"), @CodeItem(value="RosyBrown", text="\uff08\u73ab\u7470\u8910\uff09RosyBrown", realtext="\uff08\u73ab\u7470\u8910\uff09RosyBrown"), @CodeItem(value="RoyalBlue", text="\uff08\u54c1\u84dd\uff09RoyalBlue", realtext="\uff08\u54c1\u84dd\uff09RoyalBlue"), @CodeItem(value="SaddleBrown", text="\uff08\u978d\u8910\uff09SaddleBrown", realtext="\uff08\u978d\u8910\uff09SaddleBrown"), @CodeItem(value="Salmon", text="\uff08\u9c91\u7ea2\uff09Salmon", realtext="\uff08\u9c91\u7ea2\uff09Salmon"), @CodeItem(value="SandyBrown", text="\uff08\u6c99\u8910\uff09SandyBrown", realtext="\uff08\u6c99\u8910\uff09SandyBrown"), @CodeItem(value="SeaGreen", text="\uff08\u6d77\u85fb\u7eff\uff09SeaGreen", realtext="\uff08\u6d77\u85fb\u7eff\uff09SeaGreen"), @CodeItem(value="SeaShell", text="\uff08\u8d1d\u58f3\u767d\uff09SeaShell", realtext="\uff08\u8d1d\u58f3\u767d\uff09SeaShell"), @CodeItem(value="Sienna", text="\uff08\u571f\u9ec4\u8d6d\uff09Sienna", realtext="\uff08\u571f\u9ec4\u8d6d\uff09Sienna"), @CodeItem(value="Silver", text="\uff08\u94f6\u8272\uff09Silver", realtext="\uff08\u94f6\u8272\uff09Silver"), @CodeItem(value="SkyBlue", text="\uff08\u5929\u84dd\uff09SkyBlue", realtext="\uff08\u5929\u84dd\uff09SkyBlue"), @CodeItem(value="SlateBlue", text="\uff08\u5ca9\u84dd\uff09SlateBlue", realtext="\uff08\u5ca9\u84dd\uff09SlateBlue"), @CodeItem(value="SlateGray", text="\uff08\u5ca9\u7070\uff09SlateGray", realtext="\uff08\u5ca9\u7070\uff09SlateGray"), @CodeItem(value="Snow", text="\uff08\u96ea\u767d\uff09Snow", realtext="\uff08\u96ea\u767d\uff09Snow"), @CodeItem(value="SpringGreen", text="\uff08\u6625\u7eff\uff09SpringGreen", realtext="\uff08\u6625\u7eff\uff09SpringGreen"), @CodeItem(value="SteelBlue", text="\uff08\u94a2\u9752\uff09SteelBlue", realtext="\uff08\u94a2\u9752\uff09SteelBlue"), @CodeItem(value="Tan", text="\uff08\u65e5\u6652\u8910\uff09Tan", realtext="\uff08\u65e5\u6652\u8910\uff09Tan"), @CodeItem(value="Teal", text="\uff08\u9e2d\u7fc5\u7eff\uff09Teal", realtext="\uff08\u9e2d\u7fc5\u7eff\uff09Teal"), @CodeItem(value="Thistle", text="\uff08\u84df\u7d2b\uff09Thistle", realtext="\uff08\u84df\u7d2b\uff09Thistle"), @CodeItem(value="Tomato", text="\uff08\u756a\u8304\u7ea2\uff09Tomato", realtext="\uff08\u756a\u8304\u7ea2\uff09Tomato"), @CodeItem(value="Turquoise", text="\uff08\u677e\u77f3\u7eff\uff09Turquoise", realtext="\uff08\u677e\u77f3\u7eff\uff09Turquoise"), @CodeItem(value="Violet", text="\uff08\u7d2b\u7f57\u5170\u8272\uff09Violet", realtext="\uff08\u7d2b\u7f57\u5170\u8272\uff09Violet"), @CodeItem(value="VioletRed", text="\uff08\u7d2b\u7ea2\u8272\uff09VioletRed", realtext="\uff08\u7d2b\u7ea2\u8272\uff09VioletRed"), @CodeItem(value="Wheat", text="\uff08\u9ea6\u8272\uff09Wheat", realtext="\uff08\u9ea6\u8272\uff09Wheat"), @CodeItem(value="White", text="\uff08\u767d\u8272\uff09White", realtext="\uff08\u767d\u8272\uff09White"), @CodeItem(value="WhiteSmoke", text="\uff08\u70df\u96fe\u767d\uff09WhiteSmoke", realtext="\uff08\u70df\u96fe\u767d\uff09WhiteSmoke"), @CodeItem(value="Yellow", text="\uff08\u9ec4\u8272\uff09Yellow", realtext="\uff08\u9ec4\u8272\uff09Yellow"), @CodeItem(value="YellowGreen", text="\uff08\u6697\u9ec4\u7eff\u8272\uff09YellowGreen", realtext="\uff08\u6697\u9ec4\u7eff\u8272\uff09YellowGreen")})
public class WebColorsCodeListModel
extends StaticCodeListModelBase {
    public static final String ALICEBLUE = "AliceBlue";
    public static final String ANTIQUEWHITE = "AntiqueWhite";
    public static final String AQUA = "Aqua";
    public static final String AQUAMARINE = "Aquamarine";
    public static final String AZURE = "Azure";
    public static final String BEIGE = "Beige";
    public static final String BISQUE = "Bisque";
    public static final String BLACK = "Black";
    public static final String BLANCHEDALMOND = "BlanchedAlmond";
    public static final String BLUE = "Blue";
    public static final String BLUEVIOLET = "BlueViolet";
    public static final String BROWN = "Brown";
    public static final String BURLYWOOD = "BurlyWood";
    public static final String CADETBLUE = "CadetBlue";
    public static final String CHARTREUSE = "Chartreuse";
    public static final String CHOCOLATE = "Chocolate";
    public static final String CORAL = "Coral";
    public static final String CORNFLOWERBLUE = "CornflowerBlue";
    public static final String CORNSILK = "Cornsilk";
    public static final String CRIMSON = "Crimson";
    public static final String CYAN = "Cyan";
    public static final String DARKBLUE = "DarkBlue";
    public static final String DARKCYAN = "DarkCyan";
    public static final String DARKGOLDENROD = "DarkGoldenRod";
    public static final String DARKGRAY = "DarkGray";
    public static final String DARKGREEN = "DarkGreen";
    public static final String DARKKHAKI = "DarkKhaki";
    public static final String DARKMAGENTA = "DarkMagenta";
    public static final String DARKOLIVEGREEN = "DarkOliveGreen";
    public static final String DARKORANGE = "Darkorange";
    public static final String DARKORCHID = "DarkOrchid";
    public static final String DARKRED = "DarkRed";
    public static final String DARKSALMON = "DarkSalmon";
    public static final String DARKSEAGREEN = "DarkSeaGreen";
    public static final String DARKSLATEBLUE = "DarkSlateBlue";
    public static final String DARKSLATEGRAY = "DarkSlateGray";
    public static final String DARKTURQUOISE = "DarkTurquoise";
    public static final String DARKVIOLET = "DarkViolet";
    public static final String DEEPPINK = "DeepPink";
    public static final String DEEPSKYBLUE = "DeepSkyBlue";
    public static final String DIMGRAY = "DimGray";
    public static final String DODGERBLUE = "DodgerBlue";
    public static final String FELDSPAR = "Feldspar";
    public static final String FIREBRICK = "FireBrick";
    public static final String FLORALWHITE = "FloralWhite";
    public static final String FORESTGREEN = "ForestGreen";
    public static final String FUCHSIA = "Fuchsia";
    public static final String GAINSBORO = "Gainsboro";
    public static final String GHOSTWHITE = "GhostWhite";
    public static final String GOLD = "Gold";
    public static final String GOLDENROD = "GoldenRod";
    public static final String GRAY = "Gray";
    public static final String GREEN = "Green";
    public static final String GREENYELLOW = "GreenYellow";
    public static final String HONEYDEW = "HoneyDew";
    public static final String HOTPINK = "HotPink";
    public static final String INDIANRED = "IndianRed";
    public static final String INDIGO = "Indigo";
    public static final String IVORY = "Ivory";
    public static final String KHAKI = "Khaki";
    public static final String LAVENDER = "Lavender";
    public static final String LAVENDERBLUSH = "LavenderBlush";
    public static final String LAWNGREEN = "LawnGreen";
    public static final String LEMONCHIFFON = "LemonChiffon";
    public static final String LIGHTBLUE = "LightBlue";
    public static final String LIGHTCORAL = "LightCoral";
    public static final String LIGHTCYAN = "LightCyan";
    public static final String LIGHTGOLDENRODYELLOW = "LightGoldenRodYellow";
    public static final String LIGHTGREY = "LightGrey";
    public static final String LIGHTGREEN = "LightGreen";
    public static final String LIGHTPINK = "LightPink";
    public static final String LIGHTSALMON = "LightSalmon";
    public static final String LIGHTSEAGREEN = "LightSeaGreen";
    public static final String LIGHTSKYBLUE = "LightSkyBlue";
    public static final String LIGHTSLATEBLUE = "LightSlateBlue";
    public static final String LIGHTSLATEGRAY = "LightSlateGray";
    public static final String LIGHTSTEELBLUE = "LightSteelBlue";
    public static final String LIGHTYELLOW = "LightYellow";
    public static final String LIME = "Lime";
    public static final String LIMEGREEN = "LimeGreen";
    public static final String LINEN = "Linen";
    public static final String MAGENTA = "Magenta";
    public static final String MAROON = "Maroon";
    public static final String MEDIUMAQUAMARINE = "MediumAquaMarine";
    public static final String MEDIUMBLUE = "MediumBlue";
    public static final String MEDIUMORCHID = "MediumOrchid";
    public static final String MEDIUMPURPLE = "MediumPurple";
    public static final String MEDIUMSEAGREEN = "MediumSeaGreen";
    public static final String MEDIUMSLATEBLUE = "MediumSlateBlue";
    public static final String MEDIUMSPRINGGREEN = "MediumSpringGreen";
    public static final String MEDIUMTURQUOISE = "MediumTurquoise";
    public static final String MEDIUMVIOLETRED = "MediumVioletRed";
    public static final String MIDNIGHTBLUE = "MidnightBlue";
    public static final String MINTCREAM = "MintCream";
    public static final String MISTYROSE = "MistyRose";
    public static final String MOCCASIN = "Moccasin";
    public static final String NAVAJOWHITE = "NavajoWhite";
    public static final String NAVY = "Navy";
    public static final String OLDLACE = "OldLace";
    public static final String OLIVE = "Olive";
    public static final String OLIVEDRAB = "OliveDrab";
    public static final String ORANGE = "Orange";
    public static final String ORANGERED = "OrangeRed";
    public static final String ORCHID = "Orchid";
    public static final String PALEGOLDENROD = "PaleGoldenRod";
    public static final String PALEGREEN = "PaleGreen";
    public static final String PALETURQUOISE = "PaleTurquoise";
    public static final String PALEVIOLETRED = "PaleVioletRed";
    public static final String PAPAYAWHIP = "PapayaWhip";
    public static final String PEACHPUFF = "PeachPuff";
    public static final String PERU = "Peru";
    public static final String PINK = "Pink";
    public static final String PLUM = "Plum";
    public static final String POWDERBLUE = "PowderBlue";
    public static final String PURPLE = "Purple";
    public static final String RED = "Red";
    public static final String ROSYBROWN = "RosyBrown";
    public static final String ROYALBLUE = "RoyalBlue";
    public static final String SADDLEBROWN = "SaddleBrown";
    public static final String SALMON = "Salmon";
    public static final String SANDYBROWN = "SandyBrown";
    public static final String SEAGREEN = "SeaGreen";
    public static final String SEASHELL = "SeaShell";
    public static final String SIENNA = "Sienna";
    public static final String SILVER = "Silver";
    public static final String SKYBLUE = "SkyBlue";
    public static final String SLATEBLUE = "SlateBlue";
    public static final String SLATEGRAY = "SlateGray";
    public static final String SNOW = "Snow";
    public static final String SPRINGGREEN = "SpringGreen";
    public static final String STEELBLUE = "SteelBlue";
    public static final String TAN = "Tan";
    public static final String TEAL = "Teal";
    public static final String THISTLE = "Thistle";
    public static final String TOMATO = "Tomato";
    public static final String TURQUOISE = "Turquoise";
    public static final String VIOLET = "Violet";
    public static final String VIOLETRED = "VioletRed";
    public static final String WHEAT = "Wheat";
    public static final String WHITE = "White";
    public static final String WHITESMOKE = "WhiteSmoke";
    public static final String YELLOW = "Yellow";
    public static final String YELLOWGREEN = "YellowGreen";

    public WebColorsCodeListModel() {
        this.initAnnotation(WebColorsCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WebColorsCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WebColorsCodeListModel");
    }
}

