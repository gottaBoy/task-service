/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="662096d0067cbc4ce9f66c6956ee998f",name="年份（2010～2020）",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="2010",text="2010年",realtext="2010年" )
    ,@CodeItem(value="2011",text="2011年",realtext="2011年" )
    ,@CodeItem(value="2012",text="2012年",realtext="2012年" )
    ,@CodeItem(value="2013",text="2013年",realtext="2013年" )
    ,@CodeItem(value="2014",text="2014年",realtext="2014年" )
    ,@CodeItem(value="2015",text="2015年",realtext="2015年" )
    ,@CodeItem(value="2016",text="2016年",realtext="2016年" )
    ,@CodeItem(value="2017",text="2017年",realtext="2017年" )
    ,@CodeItem(value="2018",text="2018年",realtext="2018年" )
    ,@CodeItem(value="2019",text="2019年",realtext="2019年" )
    ,@CodeItem(value="2020",text="2020年",realtext="2020年" )
})


/**
 * 静态代码表[年份（2010～2020）]模型基类
 */
public abstract class CodeList81CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  2010年
     */
    public final static String ITEM_2010 = "2010";
    /**
     *  2011年
     */
    public final static String ITEM_2011 = "2011";
    /**
     *  2012年
     */
    public final static String ITEM_2012 = "2012";
    /**
     *  2013年
     */
    public final static String ITEM_2013 = "2013";
    /**
     *  2014年
     */
    public final static String ITEM_2014 = "2014";
    /**
     *  2015年
     */
    public final static String ITEM_2015 = "2015";
    /**
     *  2016年
     */
    public final static String ITEM_2016 = "2016";
    /**
     *  2017年
     */
    public final static String ITEM_2017 = "2017";
    /**
     *  2018年
     */
    public final static String ITEM_2018 = "2018";
    /**
     *  2019年
     */
    public final static String ITEM_2019 = "2019";
    /**
     *  2020年
     */
    public final static String ITEM_2020 = "2020";


    public CodeList81CodeListModelBase() {
        super();
        this.initAnnotation(CodeList81CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList81CodeListModel", this);
    }

}