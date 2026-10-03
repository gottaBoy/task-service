/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="b515870bb8cdb6dcd91e672786be3e5e",name="月份（1～12）",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="01",text="1月",realtext="1月" )
    ,@CodeItem(value="02",text="2月",realtext="2月" )
    ,@CodeItem(value="03",text="3月",realtext="3月" )
    ,@CodeItem(value="04",text="4月",realtext="4月" )
    ,@CodeItem(value="05",text="5月",realtext="5月" )
    ,@CodeItem(value="06",text="6月",realtext="6月" )
    ,@CodeItem(value="07",text="7月",realtext="7月" )
    ,@CodeItem(value="08",text="8月",realtext="8月" )
    ,@CodeItem(value="09",text="9月",realtext="9月" )
    ,@CodeItem(value="10",text="10月",realtext="10月" )
    ,@CodeItem(value="11",text="11月",realtext="11月" )
    ,@CodeItem(value="12",text="12月",realtext="12月" )
})


/**
 * 静态代码表[月份（1～12）]模型基类
 */
public abstract class CodeList82CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  1月
     */
    public final static String ITEM_01 = "01";
    /**
     *  2月
     */
    public final static String ITEM_02 = "02";
    /**
     *  3月
     */
    public final static String ITEM_03 = "03";
    /**
     *  4月
     */
    public final static String ITEM_04 = "04";
    /**
     *  5月
     */
    public final static String ITEM_05 = "05";
    /**
     *  6月
     */
    public final static String ITEM_06 = "06";
    /**
     *  7月
     */
    public final static String ITEM_07 = "07";
    /**
     *  8月
     */
    public final static String ITEM_08 = "08";
    /**
     *  9月
     */
    public final static String ITEM_09 = "09";
    /**
     *  10月
     */
    public final static String ITEM_10 = "10";
    /**
     *  11月
     */
    public final static String ITEM_11 = "11";
    /**
     *  12月
     */
    public final static String ITEM_12 = "12";


    public CodeList82CodeListModelBase() {
        super();
        this.initAnnotation(CodeList82CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList82CodeListModel", this);
    }

}