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

@CodeList(id="9b654829e83247f05281b1a2c8a62ddd", name="\u5f00\u53d1\u7cfb\u7edf\u5f15\u7528\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEVSYS01", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u75281", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u75281"), @CodeItem(value="DEVSYS02", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u75282", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u75282"), @CodeItem(value="DEVSYS03", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u75283", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u75283"), @CodeItem(value="DEVSYS04", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u75284", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u75284"), @CodeItem(value="DEVSYS05", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u75285", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u75285"), @CodeItem(value="DEVSYS06", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u75286", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u75286"), @CodeItem(value="DEVSYS07", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u75287", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u75287"), @CodeItem(value="DEVSYS08", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u75288", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u75288"), @CodeItem(value="DEVSYS09", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u75289", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u75289"), @CodeItem(value="DEVSYS10", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752810", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752810"), @CodeItem(value="DEVSYS11", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752811", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752811"), @CodeItem(value="DEVSYS12", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752812", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752812"), @CodeItem(value="DEVSYS13", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752813", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752813"), @CodeItem(value="DEVSYS14", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752814", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752814"), @CodeItem(value="DEVSYS15", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752815", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752815"), @CodeItem(value="DEVSYS16", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752816", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752816"), @CodeItem(value="DEVSYS17", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752817", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752817"), @CodeItem(value="DEVSYS18", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752818", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752818"), @CodeItem(value="DEVSYS19", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752819", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752819"), @CodeItem(value="DEVSYS20", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752820", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752820"), @CodeItem(value="DEVSYS21", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752821", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752821"), @CodeItem(value="DEVSYS22", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752822", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752822"), @CodeItem(value="DEVSYS23", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752823", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752823"), @CodeItem(value="DEVSYS24", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752824", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752824"), @CodeItem(value="DEVSYS25", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752825", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752825"), @CodeItem(value="DEVSYS26", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752826", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752826"), @CodeItem(value="DEVSYS27", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752827", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752827"), @CodeItem(value="DEVSYS28", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752828", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752828"), @CodeItem(value="DEVSYS29", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752829", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752829"), @CodeItem(value="DEVSYS30", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752830", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752830"), @CodeItem(value="DEVSYS31", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752831", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752831"), @CodeItem(value="DEVSYS32", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752832", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752832"), @CodeItem(value="DEVSYS33", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752833", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752833"), @CodeItem(value="DEVSYS34", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752834", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752834"), @CodeItem(value="DEVSYS35", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752835", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752835"), @CodeItem(value="DEVSYS36", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752836", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752836"), @CodeItem(value="DEVSYS37", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752837", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752837"), @CodeItem(value="DEVSYS38", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752838", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752838"), @CodeItem(value="DEVSYS39", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752839", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752839"), @CodeItem(value="DEVSYS40", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752840", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752840"), @CodeItem(value="DEVSYS41", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752841", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752841"), @CodeItem(value="DEVSYS42", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752842", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752842"), @CodeItem(value="DEVSYS43", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752843", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752843"), @CodeItem(value="DEVSYS44", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752844", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752844"), @CodeItem(value="DEVSYS45", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752845", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752845"), @CodeItem(value="DEVSYS46", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752846", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752846"), @CodeItem(value="DEVSYS47", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752847", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752847"), @CodeItem(value="DEVSYS48", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752848", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752848"), @CodeItem(value="DEVSYS49", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752849", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752849"), @CodeItem(value="DEVSYS50", text="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752850", realtext="\u5f00\u53d1\u7cfb\u7edf\u5f15\u752850")})
public class DevSysRefModeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEVSYS01 = "DEVSYS01";
    public static final String DEVSYS02 = "DEVSYS02";
    public static final String DEVSYS03 = "DEVSYS03";
    public static final String DEVSYS04 = "DEVSYS04";
    public static final String DEVSYS05 = "DEVSYS05";
    public static final String DEVSYS06 = "DEVSYS06";
    public static final String DEVSYS07 = "DEVSYS07";
    public static final String DEVSYS08 = "DEVSYS08";
    public static final String DEVSYS09 = "DEVSYS09";
    public static final String DEVSYS10 = "DEVSYS10";
    public static final String DEVSYS11 = "DEVSYS11";
    public static final String DEVSYS12 = "DEVSYS12";
    public static final String DEVSYS13 = "DEVSYS13";
    public static final String DEVSYS14 = "DEVSYS14";
    public static final String DEVSYS15 = "DEVSYS15";
    public static final String DEVSYS16 = "DEVSYS16";
    public static final String DEVSYS17 = "DEVSYS17";
    public static final String DEVSYS18 = "DEVSYS18";
    public static final String DEVSYS19 = "DEVSYS19";
    public static final String DEVSYS20 = "DEVSYS20";
    public static final String DEVSYS21 = "DEVSYS21";
    public static final String DEVSYS22 = "DEVSYS22";
    public static final String DEVSYS23 = "DEVSYS23";
    public static final String DEVSYS24 = "DEVSYS24";
    public static final String DEVSYS25 = "DEVSYS25";
    public static final String DEVSYS26 = "DEVSYS26";
    public static final String DEVSYS27 = "DEVSYS27";
    public static final String DEVSYS28 = "DEVSYS28";
    public static final String DEVSYS29 = "DEVSYS29";
    public static final String DEVSYS30 = "DEVSYS30";
    public static final String DEVSYS31 = "DEVSYS31";
    public static final String DEVSYS32 = "DEVSYS32";
    public static final String DEVSYS33 = "DEVSYS33";
    public static final String DEVSYS34 = "DEVSYS34";
    public static final String DEVSYS35 = "DEVSYS35";
    public static final String DEVSYS36 = "DEVSYS36";
    public static final String DEVSYS37 = "DEVSYS37";
    public static final String DEVSYS38 = "DEVSYS38";
    public static final String DEVSYS39 = "DEVSYS39";
    public static final String DEVSYS40 = "DEVSYS40";
    public static final String DEVSYS41 = "DEVSYS41";
    public static final String DEVSYS42 = "DEVSYS42";
    public static final String DEVSYS43 = "DEVSYS43";
    public static final String DEVSYS44 = "DEVSYS44";
    public static final String DEVSYS45 = "DEVSYS45";
    public static final String DEVSYS46 = "DEVSYS46";
    public static final String DEVSYS47 = "DEVSYS47";
    public static final String DEVSYS48 = "DEVSYS48";
    public static final String DEVSYS49 = "DEVSYS49";
    public static final String DEVSYS50 = "DEVSYS50";

    public DevSysRefModeCodeListModel() {
        this.initAnnotation(DevSysRefModeCodeListModel.class);
        this.setUserData2("DevSysRefMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSysRefModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSysRefModeCodeListModel");
    }
}

