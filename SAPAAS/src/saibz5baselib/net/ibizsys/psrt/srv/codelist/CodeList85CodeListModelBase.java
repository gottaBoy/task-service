/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="de39617d6ec36c77b91b17990efce49e",name="日小时（0～23）",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="00",text="0点",realtext="0点" )
    ,@CodeItem(value="01",text="1点",realtext="1点" )
    ,@CodeItem(value="02",text="2点",realtext="2点" )
    ,@CodeItem(value="03",text="3点",realtext="3点" )
    ,@CodeItem(value="04",text="4点",realtext="4点" )
    ,@CodeItem(value="05",text="5点",realtext="5点" )
    ,@CodeItem(value="06",text="6点",realtext="6点" )
    ,@CodeItem(value="07",text="7点",realtext="7点" )
    ,@CodeItem(value="08",text="8点",realtext="8点" )
    ,@CodeItem(value="09",text="9点",realtext="9点" )
    ,@CodeItem(value="10",text="10点",realtext="10点" )
    ,@CodeItem(value="11",text="11点",realtext="11点" )
    ,@CodeItem(value="12",text="12点",realtext="12点" )
    ,@CodeItem(value="13",text="13点",realtext="13点" )
    ,@CodeItem(value="14",text="14点",realtext="14点" )
    ,@CodeItem(value="15",text="15点",realtext="15点" )
    ,@CodeItem(value="16",text="16点",realtext="16点" )
    ,@CodeItem(value="17",text="17点",realtext="17点" )
    ,@CodeItem(value="18",text="18点",realtext="18点" )
    ,@CodeItem(value="19",text="19点",realtext="19点" )
    ,@CodeItem(value="20",text="20点",realtext="20点" )
    ,@CodeItem(value="21",text="21点",realtext="21点" )
    ,@CodeItem(value="22",text="22点",realtext="22点" )
    ,@CodeItem(value="23",text="23点",realtext="23点" )
})


/**
 * 静态代码表[日小时（0～23）]模型基类
 */
public abstract class CodeList85CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  0点
     */
    public final static String ITEM_00 = "00";
    /**
     *  1点
     */
    public final static String ITEM_01 = "01";
    /**
     *  2点
     */
    public final static String ITEM_02 = "02";
    /**
     *  3点
     */
    public final static String ITEM_03 = "03";
    /**
     *  4点
     */
    public final static String ITEM_04 = "04";
    /**
     *  5点
     */
    public final static String ITEM_05 = "05";
    /**
     *  6点
     */
    public final static String ITEM_06 = "06";
    /**
     *  7点
     */
    public final static String ITEM_07 = "07";
    /**
     *  8点
     */
    public final static String ITEM_08 = "08";
    /**
     *  9点
     */
    public final static String ITEM_09 = "09";
    /**
     *  10点
     */
    public final static String ITEM_10 = "10";
    /**
     *  11点
     */
    public final static String ITEM_11 = "11";
    /**
     *  12点
     */
    public final static String ITEM_12 = "12";
    /**
     *  13点
     */
    public final static String ITEM_13 = "13";
    /**
     *  14点
     */
    public final static String ITEM_14 = "14";
    /**
     *  15点
     */
    public final static String ITEM_15 = "15";
    /**
     *  16点
     */
    public final static String ITEM_16 = "16";
    /**
     *  17点
     */
    public final static String ITEM_17 = "17";
    /**
     *  18点
     */
    public final static String ITEM_18 = "18";
    /**
     *  19点
     */
    public final static String ITEM_19 = "19";
    /**
     *  20点
     */
    public final static String ITEM_20 = "20";
    /**
     *  21点
     */
    public final static String ITEM_21 = "21";
    /**
     *  22点
     */
    public final static String ITEM_22 = "22";
    /**
     *  23点
     */
    public final static String ITEM_23 = "23";


    public CodeList85CodeListModelBase() {
        super();
        this.initAnnotation(CodeList85CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList85CodeListModel", this);
    }

}