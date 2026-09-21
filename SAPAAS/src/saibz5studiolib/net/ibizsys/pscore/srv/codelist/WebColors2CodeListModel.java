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

@CodeList(id="A546FF05-EC75-41E8-A351-8567722A812A", name="Web\u989c\u8272\uff08\u503c\u5e26\u8bf4\u660e\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="\uff08\u7231\u4e3d\u4e1d\u84dd\uff09AliceBlue", text="AliceBlue", realtext="AliceBlue"), @CodeItem(value="\uff08\u53e4\u8463\u767d\uff09AntiqueWhite", text="AntiqueWhite", realtext="AntiqueWhite"), @CodeItem(value="\uff08\u6c34\u7eff\u8272\uff09Aqua", text="Aqua", realtext="Aqua"), @CodeItem(value="\uff08\u78a7\u7eff\uff09Aquamarine", text="Aquamarine", realtext="Aquamarine"), @CodeItem(value="\uff08\u5929\u84dd\u8272\uff09Azure", text="Azure", realtext="Azure"), @CodeItem(value="\uff08\u7c73\u8272\uff09Beige", text="Beige", realtext="Beige"), @CodeItem(value="\uff08\u6a58\u9ec4\u8272\uff09Bisque", text="Bisque", realtext="Bisque"), @CodeItem(value="\uff08\u9ed1\u8272\uff09Black", text="Black", realtext="Black"), @CodeItem(value="\uff08\u674f\u4ec1\u767d\uff09BlanchedAlmond", text="BlanchedAlmond", realtext="BlanchedAlmond"), @CodeItem(value="\uff08\u84dd\u8272\uff09Blue", text="Blue", realtext="Blue"), @CodeItem(value="\uff08\u84dd\u7d2b\u8272\uff09BlueViolet", text="BlueViolet", realtext="BlueViolet"), @CodeItem(value="\uff08\u8910\u8272\uff09Brown", text="Brown", realtext="Brown"), @CodeItem(value="\uff08\u786c\u6728\u8910\uff09BurlyWood", text="BurlyWood", realtext="BurlyWood"), @CodeItem(value="\uff08\u519b\u670d\u84dd\uff09CadetBlue", text="CadetBlue", realtext="CadetBlue"), @CodeItem(value="\uff08\u9ec4\u7eff\uff09Chartreuse", text="Chartreuse", realtext="Chartreuse"), @CodeItem(value="\uff08\u5de7\u514b\u529b\u8272\uff09Chocolate", text="Chocolate", realtext="Chocolate"), @CodeItem(value="\uff08\u73ca\u745a\u7ea2\uff09Coral", text="Coral", realtext="Coral"), @CodeItem(value="\uff08\u77e2\u8f66\u83ca\u84dd\uff09CornflowerBlue", text="CornflowerBlue", realtext="CornflowerBlue"), @CodeItem(value="\uff08\u7389\u7c73\u7a57\u9ec4\uff09Cornsilk", text="Cornsilk", realtext="Cornsilk"), @CodeItem(value="\uff08\u7eef\u7ea2\uff09Crimson", text="Crimson", realtext="Crimson"), @CodeItem(value="\uff08\u9752\u8272\uff09Cyan", text="Cyan", realtext="Cyan"), @CodeItem(value="\uff08\u6df1\u84dd\uff09DarkBlue", text="DarkBlue", realtext="DarkBlue"), @CodeItem(value="\uff08\u6df1\u9752\uff09DarkCyan", text="DarkCyan", realtext="DarkCyan"), @CodeItem(value="\uff08\u6df1\u91d1\u83ca\u9ec4\uff09DarkGoldenRod", text="DarkGoldenRod", realtext="DarkGoldenRod"), @CodeItem(value="\uff08\u6697\u8272\uff09DarkGray", text="DarkGray", realtext="DarkGray"), @CodeItem(value="\uff08\u6df1\u7eff\uff09DarkGreen", text="DarkGreen", realtext="DarkGreen"), @CodeItem(value="\uff08\u6df1\u5361\u5176\u8272\uff09DarkKhaki", text="DarkKhaki", realtext="DarkKhaki"), @CodeItem(value="\uff08\u6df1\u54c1\u7ea2\uff09DarkMagenta", text="DarkMagenta", realtext="DarkMagenta"), @CodeItem(value="\uff08\u6df1\u6a44\u6984\u7eff\uff09DarkOliveGreen", text="DarkOliveGreen", realtext="DarkOliveGreen"), @CodeItem(value="\uff08\u6df1\u6a59\uff09Darkorange", text="Darkorange", realtext="Darkorange"), @CodeItem(value="\uff08\u6df1\u6d0b\u5170\u7d2b\uff09DarkOrchid", text="DarkOrchid", realtext="DarkOrchid"), @CodeItem(value="\uff08\u6df1\u7ea2\uff09DarkRed", text="DarkRed", realtext="DarkRed"), @CodeItem(value="\uff08\u6df1\u9c91\u7ea2\uff09DarkSalmon", text="DarkSalmon", realtext="DarkSalmon"), @CodeItem(value="\uff08\u6df1\u6d77\u85fb\u7eff\uff09DarkSeaGreen", text="DarkSeaGreen", realtext="DarkSeaGreen"), @CodeItem(value="\uff08\u6df1\u5ca9\u84dd\uff09DarkSlateBlue", text="DarkSlateBlue", realtext="DarkSlateBlue"), @CodeItem(value="\uff08\u6df1\u5ca9\u7070\uff09DarkSlateGray", text="DarkSlateGray", realtext="DarkSlateGray"), @CodeItem(value="\uff08\u6df1\u677e\u77f3\u7eff\uff09DarkTurquoise", text="DarkTurquoise", realtext="DarkTurquoise"), @CodeItem(value="\uff08\u6df1\u7d2b\uff09DarkViolet", text="DarkViolet", realtext="DarkViolet"), @CodeItem(value="\uff08\u6df1\u7ea2\uff09DeepPink", text="DeepPink", realtext="DeepPink"), @CodeItem(value="\uff08\u6df1\u5929\u84dd\uff09DeepSkyBlue", text="DeepSkyBlue", realtext="DeepSkyBlue"), @CodeItem(value="\uff08\u660f\u7070\uff09DimGray", text="DimGray", realtext="DimGray"), @CodeItem(value="\uff08\u6e56\u84dd\uff09DodgerBlue", text="DodgerBlue", realtext="DodgerBlue"), @CodeItem(value="\uff08\u957f\u77f3\u8272\uff09Feldspar", text="Feldspar", realtext="Feldspar"), @CodeItem(value="\uff08\u706b\u7816\u7ea2\uff09FireBrick", text="FireBrick", realtext="FireBrick"), @CodeItem(value="\uff08\u82b1\u5349\u767d\uff09FloralWhite", text="FloralWhite", realtext="FloralWhite"), @CodeItem(value="\uff08\u68ee\u6797\u7eff\uff09ForestGreen", text="ForestGreen", realtext="ForestGreen"), @CodeItem(value="\uff08\u6837\u7ea2\uff09Fuchsia", text="Fuchsia", realtext="Fuchsia"), @CodeItem(value="\uff08\u5e9a\u6c0f\u7070\uff09Gainsboro", text="Gainsboro", realtext="Gainsboro"), @CodeItem(value="\uff08\u5e7d\u7075\u767d\uff09GhostWhite", text="GhostWhite", realtext="GhostWhite"), @CodeItem(value="\uff08\u91d1\u8272\uff09Gold", text="Gold", realtext="Gold"), @CodeItem(value="\uff08\u91d1\u83ca\u9ec4\uff09GoldenRod", text="GoldenRod", realtext="GoldenRod"), @CodeItem(value="\uff08\u7070\u8272\uff09Gray", text="Gray", realtext="Gray"), @CodeItem(value="\uff08\u8c03\u548c\u7eff\uff09Green", text="Green", realtext="Green"), @CodeItem(value="\uff08\u9ec4\u7eff\u8272\uff09GreenYellow", text="GreenYellow", realtext="GreenYellow"), @CodeItem(value="\uff08\u871c\u74dc\u7eff\uff09HoneyDew", text="HoneyDew", realtext="HoneyDew"), @CodeItem(value="\uff08\u8273\u7c89\uff09HotPink", text="HotPink", realtext="HotPink"), @CodeItem(value="\uff08\u5370\u5ea6\u7ea2\uff09IndianRed", text="IndianRed", realtext="IndianRed"), @CodeItem(value="\uff08\u975b\u84dd\uff09Indigo", text="Indigo", realtext="Indigo"), @CodeItem(value="\uff08\u8c61\u7259\u767d\uff09Ivory", text="Ivory", realtext="Ivory"), @CodeItem(value="\uff08\u5361\u5176\u8272\uff09Khaki", text="Khaki", realtext="Khaki"), @CodeItem(value="\uff08\u85b0\u8863\u8349\u7d2b\uff09Lavender", text="Lavender", realtext="Lavender"), @CodeItem(value="\uff08\u85b0\u8863\u8349\u7ea2\uff09LavenderBlush", text="LavenderBlush", realtext="LavenderBlush"), @CodeItem(value="\uff08\u8349\u576a\u7eff\uff09LawnGreen", text="LawnGreen", realtext="LawnGreen"), @CodeItem(value="\uff08\u67e0\u6aac\u7ef8\u9ec4\uff09LemonChiffon", text="LemonChiffon", realtext="LemonChiffon"), @CodeItem(value="\uff08\u6d45\u84dd\uff09LightBlue", text="LightBlue", realtext="LightBlue"), @CodeItem(value="\uff08\u6d45\u73ca\u745a\u7ea2\uff09LightCoral", text="LightCoral", realtext="LightCoral"), @CodeItem(value="\uff08\u6d45\u9752\uff09LightCyan", text="LightCyan", realtext="LightCyan"), @CodeItem(value="\uff08\u6d45\u91d1\u83ca\u9ec4\uff09LightGoldenRodYellow", text="LightGoldenRodYellow", realtext="LightGoldenRodYellow"), @CodeItem(value="\uff08\u4eae\u7070\uff09LightGrey", text="LightGrey", realtext="LightGrey"), @CodeItem(value="\uff08\u6d45\u7eff\uff09LightGreen", text="LightGreen", realtext="LightGreen"), @CodeItem(value="\uff08\u6d45\u7c89\uff09LightPink", text="LightPink", realtext="LightPink"), @CodeItem(value="\uff08\u6d45\u9c91\u7ea2\uff09LightSalmon", text="LightSalmon", realtext="LightSalmon"), @CodeItem(value="\uff08\u6d45\u6d77\u85fb\u7eff\uff09LightSeaGreen", text="LightSeaGreen", realtext="LightSeaGreen"), @CodeItem(value="\uff08\u6d45\u5929\u84dd\uff09LightSkyBlue", text="LightSkyBlue", realtext="LightSkyBlue"), @CodeItem(value="\uff08\u6d45\u5ca9\u84dd\uff09LightSlateBlue", text="LightSlateBlue", realtext="LightSlateBlue"), @CodeItem(value="\uff08\u6d45\u5ca9\u7070\uff09LightSlateGray", text="LightSlateGray", realtext="LightSlateGray"), @CodeItem(value="\uff08\u6d45\u94a2\u9752\uff09LightSteelBlue", text="LightSteelBlue", realtext="LightSteelBlue"), @CodeItem(value="\uff08\u6d45\u9ec4\uff09LightYellow", text="LightYellow", realtext="LightYellow"), @CodeItem(value="\uff08\u7eff\u8272\uff09Lime", text="Lime", realtext="Lime"), @CodeItem(value="\uff08\u9752\u67e0\u7eff\uff09LimeGreen", text="LimeGreen", realtext="LimeGreen"), @CodeItem(value="\uff08\u4e9a\u9ebb\u8272\uff09Linen", text="Linen", realtext="Linen"), @CodeItem(value="\uff08\u6d0b\u7ea2\uff09Magenta", text="Magenta", realtext="Magenta"), @CodeItem(value="\uff08\u6817\u8272\uff09Maroon", text="Maroon", realtext="Maroon"), @CodeItem(value="\uff08\u4e2d\u78a7\u7eff\uff09MediumAquaMarine", text="MediumAquaMarine", realtext="MediumAquaMarine"), @CodeItem(value="\uff08\u4e2d\u84dd\uff09MediumBlue", text="MediumBlue", realtext="MediumBlue"), @CodeItem(value="\uff08\u4e2d\u6d0b\u5170\u7d2b\uff09MediumOrchid", text="MediumOrchid", realtext="MediumOrchid"), @CodeItem(value="\uff08\u4e2d\u7d2b\uff09MediumPurple", text="MediumPurple", realtext="MediumPurple"), @CodeItem(value="\uff08\u4e2d\u6d77\u85fb\u7eff\uff09MediumSeaGreen", text="MediumSeaGreen", realtext="MediumSeaGreen"), @CodeItem(value="\uff08\u4e2d\u5ca9\u84dd\uff09MediumSlateBlue", text="MediumSlateBlue", realtext="MediumSlateBlue"), @CodeItem(value="\uff08\u4e2d\u5ae9\u7eff\uff09MediumSpringGreen", text="MediumSpringGreen", realtext="MediumSpringGreen"), @CodeItem(value="\uff08\u4e2d\u677e\u77f3\u7eff\uff09MediumTurquoise", text="MediumTurquoise", realtext="MediumTurquoise"), @CodeItem(value="\uff08\u4e2d\u7d2b\u7ea2\uff09MediumVioletRed", text="MediumVioletRed", realtext="MediumVioletRed"), @CodeItem(value="\uff08\u5348\u591c\u84dd\uff09MidnightBlue", text="MidnightBlue", realtext="MidnightBlue"), @CodeItem(value="\uff08\u8584\u8377\u4e73\u767d\uff09MintCream", text="MintCream", realtext="MintCream"), @CodeItem(value="\uff08\u96fe\u73ab\u7470\u7ea2\uff09MistyRose", text="MistyRose", realtext="MistyRose"), @CodeItem(value="\uff08\u9e7f\u76ae\u8272\uff09Moccasin", text="Moccasin", realtext="Moccasin"), @CodeItem(value="\uff08\u571f\u8457\u767d\uff09NavajoWhite", text="NavajoWhite", realtext="NavajoWhite"), @CodeItem(value="\uff08\u85cf\u9752\uff09Navy", text="Navy", realtext="Navy"), @CodeItem(value="\uff08\u65e7\u857e\u4e1d\u767d\uff09OldLace", text="OldLace", realtext="OldLace"), @CodeItem(value="\uff08\u6a44\u6984\u8272\uff09Olive", text="Olive", realtext="Olive"), @CodeItem(value="\uff08\u6a44\u6984\u7eff\uff09OliveDrab", text="OliveDrab", realtext="OliveDrab"), @CodeItem(value="\uff08\u6a59\u8272\uff09Orange", text="Orange", realtext="Orange"), @CodeItem(value="\uff08\u6a58\u7ea2\uff09OrangeRed", text="OrangeRed", realtext="OrangeRed"), @CodeItem(value="\uff08\u6d0b\u5170\u7d2b\uff09Orchid", text="Orchid", realtext="Orchid"), @CodeItem(value="\uff08\u767d\u91d1\u83ca\u9ec4\uff09PaleGoldenRod", text="PaleGoldenRod", realtext="PaleGoldenRod"), @CodeItem(value="\uff08\u767d\u7eff\u8272\uff09PaleGreen", text="PaleGreen", realtext="PaleGreen"), @CodeItem(value="\uff08\u767d\u677e\u77f3\u7eff\uff09PaleTurquoise", text="PaleTurquoise", realtext="PaleTurquoise"), @CodeItem(value="\uff08\u767d\u7d2b\u7ea2\uff09PaleVioletRed", text="PaleVioletRed", realtext="PaleVioletRed"), @CodeItem(value="\uff08\u756a\u6728\u74dc\u6a59\uff09PapayaWhip", text="PapayaWhip", realtext="PapayaWhip"), @CodeItem(value="\uff08\u7c89\u6251\u6843\u8272\uff09PeachPuff", text="PeachPuff", realtext="PeachPuff"), @CodeItem(value="\uff08\u79d8\u9c81\u7ea2\uff09Peru", text="Peru", realtext="Peru"), @CodeItem(value="\uff08\u7c89\u8272\uff09Pink", text="Pink", realtext="Pink"), @CodeItem(value="\uff08\u674e\u7d2b\uff09Plum", text="Plum", realtext="Plum"), @CodeItem(value="\uff08\u7c89\u672b\u84dd\uff09PowderBlue", text="PowderBlue", realtext="PowderBlue"), @CodeItem(value="\uff08\u7d2b\u8272\uff09Purple", text="Purple", realtext="Purple"), @CodeItem(value="\uff08\u7ea2\u8272\uff09Red", text="Red", realtext="Red"), @CodeItem(value="\uff08\u73ab\u7470\u8910\uff09RosyBrown", text="RosyBrown", realtext="RosyBrown"), @CodeItem(value="\uff08\u54c1\u84dd\uff09RoyalBlue", text="RoyalBlue", realtext="RoyalBlue"), @CodeItem(value="\uff08\u978d\u8910\uff09SaddleBrown", text="SaddleBrown", realtext="SaddleBrown"), @CodeItem(value="\uff08\u9c91\u7ea2\uff09Salmon", text="Salmon", realtext="Salmon"), @CodeItem(value="\uff08\u6c99\u8910\uff09SandyBrown", text="SandyBrown", realtext="SandyBrown"), @CodeItem(value="\uff08\u6d77\u85fb\u7eff\uff09SeaGreen", text="SeaGreen", realtext="SeaGreen"), @CodeItem(value="\uff08\u8d1d\u58f3\u767d\uff09SeaShell", text="SeaShell", realtext="SeaShell"), @CodeItem(value="\uff08\u571f\u9ec4\u8d6d\uff09Sienna", text="Sienna", realtext="Sienna"), @CodeItem(value="\uff08\u94f6\u8272\uff09Silver", text="Silver", realtext="Silver"), @CodeItem(value="\uff08\u5929\u84dd\uff09SkyBlue", text="SkyBlue", realtext="SkyBlue"), @CodeItem(value="\uff08\u5ca9\u84dd\uff09SlateBlue", text="SlateBlue", realtext="SlateBlue"), @CodeItem(value="\uff08\u5ca9\u7070\uff09SlateGray", text="SlateGray", realtext="SlateGray"), @CodeItem(value="\uff08\u96ea\u767d\uff09Snow", text="Snow", realtext="Snow"), @CodeItem(value="\uff08\u6625\u7eff\uff09SpringGreen", text="SpringGreen", realtext="SpringGreen"), @CodeItem(value="\uff08\u94a2\u9752\uff09SteelBlue", text="SteelBlue", realtext="SteelBlue"), @CodeItem(value="\uff08\u65e5\u6652\u8910\uff09Tan", text="Tan", realtext="Tan"), @CodeItem(value="\uff08\u9e2d\u7fc5\u7eff\uff09Teal", text="Teal", realtext="Teal"), @CodeItem(value="\uff08\u84df\u7d2b\uff09Thistle", text="Thistle", realtext="Thistle"), @CodeItem(value="\uff08\u756a\u8304\u7ea2\uff09Tomato", text="Tomato", realtext="Tomato"), @CodeItem(value="\uff08\u677e\u77f3\u7eff\uff09Turquoise", text="Turquoise", realtext="Turquoise"), @CodeItem(value="\uff08\u7d2b\u7f57\u5170\u8272\uff09Violet", text="Violet", realtext="Violet"), @CodeItem(value="\uff08\u7d2b\u7ea2\u8272\uff09VioletRed", text="VioletRed", realtext="VioletRed"), @CodeItem(value="\uff08\u9ea6\u8272\uff09Wheat", text="Wheat", realtext="Wheat"), @CodeItem(value="\uff08\u767d\u8272\uff09White", text="White", realtext="White"), @CodeItem(value="\uff08\u70df\u96fe\u767d\uff09WhiteSmoke", text="WhiteSmoke", realtext="WhiteSmoke"), @CodeItem(value="\uff08\u9ec4\u8272\uff09Yellow", text="Yellow", realtext="Yellow"), @CodeItem(value="\uff08\u6697\u9ec4\u7eff\u8272\uff09YellowGreen", text="YellowGreen", realtext="YellowGreen")})
public class WebColors2CodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_1 = "\uff08\u7231\u4e3d\u4e1d\u84dd\uff09AliceBlue";
    public static final String ITEM_2 = "\uff08\u53e4\u8463\u767d\uff09AntiqueWhite";
    public static final String ITEM_3 = "\uff08\u6c34\u7eff\u8272\uff09Aqua";
    public static final String ITEM_4 = "\uff08\u78a7\u7eff\uff09Aquamarine";
    public static final String ITEM_5 = "\uff08\u5929\u84dd\u8272\uff09Azure";
    public static final String ITEM_6 = "\uff08\u7c73\u8272\uff09Beige";
    public static final String ITEM_7 = "\uff08\u6a58\u9ec4\u8272\uff09Bisque";
    public static final String ITEM_8 = "\uff08\u9ed1\u8272\uff09Black";
    public static final String ITEM_9 = "\uff08\u674f\u4ec1\u767d\uff09BlanchedAlmond";
    public static final String ITEM_10 = "\uff08\u84dd\u8272\uff09Blue";
    public static final String ITEM_11 = "\uff08\u84dd\u7d2b\u8272\uff09BlueViolet";
    public static final String ITEM_12 = "\uff08\u8910\u8272\uff09Brown";
    public static final String ITEM_13 = "\uff08\u786c\u6728\u8910\uff09BurlyWood";
    public static final String ITEM_14 = "\uff08\u519b\u670d\u84dd\uff09CadetBlue";
    public static final String ITEM_15 = "\uff08\u9ec4\u7eff\uff09Chartreuse";
    public static final String ITEM_16 = "\uff08\u5de7\u514b\u529b\u8272\uff09Chocolate";
    public static final String ITEM_17 = "\uff08\u73ca\u745a\u7ea2\uff09Coral";
    public static final String ITEM_18 = "\uff08\u77e2\u8f66\u83ca\u84dd\uff09CornflowerBlue";
    public static final String ITEM_19 = "\uff08\u7389\u7c73\u7a57\u9ec4\uff09Cornsilk";
    public static final String ITEM_20 = "\uff08\u7eef\u7ea2\uff09Crimson";
    public static final String ITEM_21 = "\uff08\u9752\u8272\uff09Cyan";
    public static final String ITEM_22 = "\uff08\u6df1\u84dd\uff09DarkBlue";
    public static final String ITEM_23 = "\uff08\u6df1\u9752\uff09DarkCyan";
    public static final String ITEM_24 = "\uff08\u6df1\u91d1\u83ca\u9ec4\uff09DarkGoldenRod";
    public static final String ITEM_25 = "\uff08\u6697\u8272\uff09DarkGray";
    public static final String ITEM_26 = "\uff08\u6df1\u7eff\uff09DarkGreen";
    public static final String ITEM_27 = "\uff08\u6df1\u5361\u5176\u8272\uff09DarkKhaki";
    public static final String ITEM_28 = "\uff08\u6df1\u54c1\u7ea2\uff09DarkMagenta";
    public static final String ITEM_29 = "\uff08\u6df1\u6a44\u6984\u7eff\uff09DarkOliveGreen";
    public static final String ITEM_30 = "\uff08\u6df1\u6a59\uff09Darkorange";
    public static final String ITEM_31 = "\uff08\u6df1\u6d0b\u5170\u7d2b\uff09DarkOrchid";
    public static final String ITEM_32 = "\uff08\u6df1\u7ea2\uff09DarkRed";
    public static final String ITEM_33 = "\uff08\u6df1\u9c91\u7ea2\uff09DarkSalmon";
    public static final String ITEM_34 = "\uff08\u6df1\u6d77\u85fb\u7eff\uff09DarkSeaGreen";
    public static final String ITEM_35 = "\uff08\u6df1\u5ca9\u84dd\uff09DarkSlateBlue";
    public static final String ITEM_36 = "\uff08\u6df1\u5ca9\u7070\uff09DarkSlateGray";
    public static final String ITEM_37 = "\uff08\u6df1\u677e\u77f3\u7eff\uff09DarkTurquoise";
    public static final String ITEM_38 = "\uff08\u6df1\u7d2b\uff09DarkViolet";
    public static final String ITEM_39 = "\uff08\u6df1\u7ea2\uff09DeepPink";
    public static final String ITEM_40 = "\uff08\u6df1\u5929\u84dd\uff09DeepSkyBlue";
    public static final String ITEM_41 = "\uff08\u660f\u7070\uff09DimGray";
    public static final String ITEM_42 = "\uff08\u6e56\u84dd\uff09DodgerBlue";
    public static final String ITEM_43 = "\uff08\u957f\u77f3\u8272\uff09Feldspar";
    public static final String ITEM_44 = "\uff08\u706b\u7816\u7ea2\uff09FireBrick";
    public static final String ITEM_45 = "\uff08\u82b1\u5349\u767d\uff09FloralWhite";
    public static final String ITEM_46 = "\uff08\u68ee\u6797\u7eff\uff09ForestGreen";
    public static final String ITEM_47 = "\uff08\u6837\u7ea2\uff09Fuchsia";
    public static final String ITEM_48 = "\uff08\u5e9a\u6c0f\u7070\uff09Gainsboro";
    public static final String ITEM_49 = "\uff08\u5e7d\u7075\u767d\uff09GhostWhite";
    public static final String ITEM_50 = "\uff08\u91d1\u8272\uff09Gold";
    public static final String ITEM_51 = "\uff08\u91d1\u83ca\u9ec4\uff09GoldenRod";
    public static final String ITEM_52 = "\uff08\u7070\u8272\uff09Gray";
    public static final String ITEM_53 = "\uff08\u8c03\u548c\u7eff\uff09Green";
    public static final String ITEM_54 = "\uff08\u9ec4\u7eff\u8272\uff09GreenYellow";
    public static final String ITEM_55 = "\uff08\u871c\u74dc\u7eff\uff09HoneyDew";
    public static final String ITEM_56 = "\uff08\u8273\u7c89\uff09HotPink";
    public static final String ITEM_57 = "\uff08\u5370\u5ea6\u7ea2\uff09IndianRed";
    public static final String ITEM_58 = "\uff08\u975b\u84dd\uff09Indigo";
    public static final String ITEM_59 = "\uff08\u8c61\u7259\u767d\uff09Ivory";
    public static final String ITEM_60 = "\uff08\u5361\u5176\u8272\uff09Khaki";
    public static final String ITEM_61 = "\uff08\u85b0\u8863\u8349\u7d2b\uff09Lavender";
    public static final String ITEM_62 = "\uff08\u85b0\u8863\u8349\u7ea2\uff09LavenderBlush";
    public static final String ITEM_63 = "\uff08\u8349\u576a\u7eff\uff09LawnGreen";
    public static final String ITEM_64 = "\uff08\u67e0\u6aac\u7ef8\u9ec4\uff09LemonChiffon";
    public static final String ITEM_65 = "\uff08\u6d45\u84dd\uff09LightBlue";
    public static final String ITEM_66 = "\uff08\u6d45\u73ca\u745a\u7ea2\uff09LightCoral";
    public static final String ITEM_67 = "\uff08\u6d45\u9752\uff09LightCyan";
    public static final String ITEM_68 = "\uff08\u6d45\u91d1\u83ca\u9ec4\uff09LightGoldenRodYellow";
    public static final String ITEM_69 = "\uff08\u4eae\u7070\uff09LightGrey";
    public static final String ITEM_70 = "\uff08\u6d45\u7eff\uff09LightGreen";
    public static final String ITEM_71 = "\uff08\u6d45\u7c89\uff09LightPink";
    public static final String ITEM_72 = "\uff08\u6d45\u9c91\u7ea2\uff09LightSalmon";
    public static final String ITEM_73 = "\uff08\u6d45\u6d77\u85fb\u7eff\uff09LightSeaGreen";
    public static final String ITEM_74 = "\uff08\u6d45\u5929\u84dd\uff09LightSkyBlue";
    public static final String ITEM_75 = "\uff08\u6d45\u5ca9\u84dd\uff09LightSlateBlue";
    public static final String ITEM_76 = "\uff08\u6d45\u5ca9\u7070\uff09LightSlateGray";
    public static final String ITEM_77 = "\uff08\u6d45\u94a2\u9752\uff09LightSteelBlue";
    public static final String ITEM_78 = "\uff08\u6d45\u9ec4\uff09LightYellow";
    public static final String ITEM_79 = "\uff08\u7eff\u8272\uff09Lime";
    public static final String ITEM_80 = "\uff08\u9752\u67e0\u7eff\uff09LimeGreen";
    public static final String ITEM_81 = "\uff08\u4e9a\u9ebb\u8272\uff09Linen";
    public static final String ITEM_82 = "\uff08\u6d0b\u7ea2\uff09Magenta";
    public static final String ITEM_83 = "\uff08\u6817\u8272\uff09Maroon";
    public static final String ITEM_84 = "\uff08\u4e2d\u78a7\u7eff\uff09MediumAquaMarine";
    public static final String ITEM_85 = "\uff08\u4e2d\u84dd\uff09MediumBlue";
    public static final String ITEM_86 = "\uff08\u4e2d\u6d0b\u5170\u7d2b\uff09MediumOrchid";
    public static final String ITEM_87 = "\uff08\u4e2d\u7d2b\uff09MediumPurple";
    public static final String ITEM_88 = "\uff08\u4e2d\u6d77\u85fb\u7eff\uff09MediumSeaGreen";
    public static final String ITEM_89 = "\uff08\u4e2d\u5ca9\u84dd\uff09MediumSlateBlue";
    public static final String ITEM_90 = "\uff08\u4e2d\u5ae9\u7eff\uff09MediumSpringGreen";
    public static final String ITEM_91 = "\uff08\u4e2d\u677e\u77f3\u7eff\uff09MediumTurquoise";
    public static final String ITEM_92 = "\uff08\u4e2d\u7d2b\u7ea2\uff09MediumVioletRed";
    public static final String ITEM_93 = "\uff08\u5348\u591c\u84dd\uff09MidnightBlue";
    public static final String ITEM_94 = "\uff08\u8584\u8377\u4e73\u767d\uff09MintCream";
    public static final String ITEM_95 = "\uff08\u96fe\u73ab\u7470\u7ea2\uff09MistyRose";
    public static final String ITEM_96 = "\uff08\u9e7f\u76ae\u8272\uff09Moccasin";
    public static final String ITEM_97 = "\uff08\u571f\u8457\u767d\uff09NavajoWhite";
    public static final String ITEM_98 = "\uff08\u85cf\u9752\uff09Navy";
    public static final String ITEM_99 = "\uff08\u65e7\u857e\u4e1d\u767d\uff09OldLace";
    public static final String ITEM_100 = "\uff08\u6a44\u6984\u8272\uff09Olive";
    public static final String ITEM_101 = "\uff08\u6a44\u6984\u7eff\uff09OliveDrab";
    public static final String ITEM_102 = "\uff08\u6a59\u8272\uff09Orange";
    public static final String ITEM_103 = "\uff08\u6a58\u7ea2\uff09OrangeRed";
    public static final String ITEM_104 = "\uff08\u6d0b\u5170\u7d2b\uff09Orchid";
    public static final String ITEM_105 = "\uff08\u767d\u91d1\u83ca\u9ec4\uff09PaleGoldenRod";
    public static final String ITEM_106 = "\uff08\u767d\u7eff\u8272\uff09PaleGreen";
    public static final String ITEM_107 = "\uff08\u767d\u677e\u77f3\u7eff\uff09PaleTurquoise";
    public static final String ITEM_108 = "\uff08\u767d\u7d2b\u7ea2\uff09PaleVioletRed";
    public static final String ITEM_109 = "\uff08\u756a\u6728\u74dc\u6a59\uff09PapayaWhip";
    public static final String ITEM_110 = "\uff08\u7c89\u6251\u6843\u8272\uff09PeachPuff";
    public static final String ITEM_111 = "\uff08\u79d8\u9c81\u7ea2\uff09Peru";
    public static final String ITEM_112 = "\uff08\u7c89\u8272\uff09Pink";
    public static final String ITEM_113 = "\uff08\u674e\u7d2b\uff09Plum";
    public static final String ITEM_114 = "\uff08\u7c89\u672b\u84dd\uff09PowderBlue";
    public static final String ITEM_115 = "\uff08\u7d2b\u8272\uff09Purple";
    public static final String ITEM_116 = "\uff08\u7ea2\u8272\uff09Red";
    public static final String ITEM_117 = "\uff08\u73ab\u7470\u8910\uff09RosyBrown";
    public static final String ITEM_118 = "\uff08\u54c1\u84dd\uff09RoyalBlue";
    public static final String ITEM_119 = "\uff08\u978d\u8910\uff09SaddleBrown";
    public static final String ITEM_120 = "\uff08\u9c91\u7ea2\uff09Salmon";
    public static final String ITEM_121 = "\uff08\u6c99\u8910\uff09SandyBrown";
    public static final String ITEM_122 = "\uff08\u6d77\u85fb\u7eff\uff09SeaGreen";
    public static final String ITEM_123 = "\uff08\u8d1d\u58f3\u767d\uff09SeaShell";
    public static final String ITEM_124 = "\uff08\u571f\u9ec4\u8d6d\uff09Sienna";
    public static final String ITEM_125 = "\uff08\u94f6\u8272\uff09Silver";
    public static final String ITEM_126 = "\uff08\u5929\u84dd\uff09SkyBlue";
    public static final String ITEM_127 = "\uff08\u5ca9\u84dd\uff09SlateBlue";
    public static final String ITEM_128 = "\uff08\u5ca9\u7070\uff09SlateGray";
    public static final String ITEM_129 = "\uff08\u96ea\u767d\uff09Snow";
    public static final String ITEM_130 = "\uff08\u6625\u7eff\uff09SpringGreen";
    public static final String ITEM_131 = "\uff08\u94a2\u9752\uff09SteelBlue";
    public static final String ITEM_132 = "\uff08\u65e5\u6652\u8910\uff09Tan";
    public static final String ITEM_133 = "\uff08\u9e2d\u7fc5\u7eff\uff09Teal";
    public static final String ITEM_134 = "\uff08\u84df\u7d2b\uff09Thistle";
    public static final String ITEM_135 = "\uff08\u756a\u8304\u7ea2\uff09Tomato";
    public static final String ITEM_136 = "\uff08\u677e\u77f3\u7eff\uff09Turquoise";
    public static final String ITEM_137 = "\uff08\u7d2b\u7f57\u5170\u8272\uff09Violet";
    public static final String ITEM_138 = "\uff08\u7d2b\u7ea2\u8272\uff09VioletRed";
    public static final String ITEM_139 = "\uff08\u9ea6\u8272\uff09Wheat";
    public static final String ITEM_140 = "\uff08\u767d\u8272\uff09White";
    public static final String ITEM_141 = "\uff08\u70df\u96fe\u767d\uff09WhiteSmoke";
    public static final String ITEM_142 = "\uff08\u9ec4\u8272\uff09Yellow";
    public static final String ITEM_143 = "\uff08\u6697\u9ec4\u7eff\u8272\uff09YellowGreen";

    public WebColors2CodeListModel() {
        this.initAnnotation(WebColors2CodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WebColors2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WebColors2CodeListModel");
    }
}

