/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="4bc61b3ad9d6a7d6ae1fd5797228aa9f",name="图表控件_表格位置",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="NONE",text="无表格",realtext="无表格" )
    ,@CodeItem(value="TOPLEFT",text="上左",realtext="上左" )
    ,@CodeItem(value="TOP",text="上中",realtext="上中" )
    ,@CodeItem(value="TOPRIGHT",text="上右",realtext="上右" )
    ,@CodeItem(value="BOTTOMLEFT",text="下左",realtext="下左" )
    ,@CodeItem(value="BOTTOM",text="下中",realtext="下中" )
    ,@CodeItem(value="BOTTOMRIGHT",text="下右",realtext="下右" )
    ,@CodeItem(value="LEFTTOP",text="左上",realtext="左上" )
    ,@CodeItem(value="LEFT",text="左中",realtext="左中" )
    ,@CodeItem(value="LEFTBOTTOM",text="左下",realtext="左下" )
    ,@CodeItem(value="RIGHTTOP",text="右上",realtext="右上" )
    ,@CodeItem(value="RIGHT",text="右中",realtext="右中" )
    ,@CodeItem(value="RIGHTBOTTOM",text="右下",realtext="右下" )
})


/**
 * 静态代码表[图表控件_表格位置]模型基类
 */
public abstract class CodeList52CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  无表格
     */
    public final static String NONE = "NONE";
    /**
     *  上左
     */
    public final static String TOPLEFT = "TOPLEFT";
    /**
     *  上中
     */
    public final static String TOP = "TOP";
    /**
     *  上右
     */
    public final static String TOPRIGHT = "TOPRIGHT";
    /**
     *  下左
     */
    public final static String BOTTOMLEFT = "BOTTOMLEFT";
    /**
     *  下中
     */
    public final static String BOTTOM = "BOTTOM";
    /**
     *  下右
     */
    public final static String BOTTOMRIGHT = "BOTTOMRIGHT";
    /**
     *  左上
     */
    public final static String LEFTTOP = "LEFTTOP";
    /**
     *  左中
     */
    public final static String LEFT = "LEFT";
    /**
     *  左下
     */
    public final static String LEFTBOTTOM = "LEFTBOTTOM";
    /**
     *  右上
     */
    public final static String RIGHTTOP = "RIGHTTOP";
    /**
     *  右中
     */
    public final static String RIGHT = "RIGHT";
    /**
     *  右下
     */
    public final static String RIGHTBOTTOM = "RIGHTBOTTOM";


    public CodeList52CodeListModelBase() {
        super();
        this.initAnnotation(CodeList52CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList52CodeListModel", this);
    }

}