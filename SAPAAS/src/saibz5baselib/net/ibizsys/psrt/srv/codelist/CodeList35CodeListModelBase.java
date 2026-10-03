/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="56b7a0bf5a7f232e5fb7fff1c40fcc3d",name="系统错误代码",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="0",text="正确(0)",realtext="正确(0)" )
    ,@CodeItem(value="1",text="内部发生错误(INTERNALERROR)",realtext="内部发生错误(INTERNALERROR)" )
    ,@CodeItem(value="2",text="访问被拒绝(ACCESSDENY)",realtext="访问被拒绝(ACCESSDENY)" )
    ,@CodeItem(value="3",text="无效的数据(INVALIDDATA)",realtext="无效的数据(INVALIDDATA)" )
    ,@CodeItem(value="4",text="无效的数据键(INVALIDDATAKEYS)",realtext="无效的数据键(INVALIDDATAKEYS)" )
    ,@CodeItem(value="5",text="输入的信息有误(INPUTERROR)",realtext="输入的信息有误(INPUTERROR)" )
    ,@CodeItem(value="6",text="重复的数据键值(DUPLICATEKEY)",realtext="重复的数据键值(DUPLICATEKEY)" )
    ,@CodeItem(value="7",text="重复的数据(DUPLICATEDATA)",realtext="重复的数据(DUPLICATEDATA)" )
    ,@CodeItem(value="8",text="删除拒绝(DELETEREJECT)",realtext="删除拒绝(DELETEREJECT)" )
    ,@CodeItem(value="9",text="逻辑处理错误(LOGICERROR)",realtext="逻辑处理错误(LOGICERROR)" )
})


/**
 * 静态代码表[系统错误代码]模型基类
 */
public abstract class CodeList35CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  正确(0)
     */
    public final static String ITEM_0 = "0";
    /**
     *  内部发生错误(INTERNALERROR)
     */
    public final static String ITEM_1 = "1";
    /**
     *  访问被拒绝(ACCESSDENY)
     */
    public final static String ITEM_2 = "2";
    /**
     *  无效的数据(INVALIDDATA)
     */
    public final static String ITEM_3 = "3";
    /**
     *  无效的数据键(INVALIDDATAKEYS)
     */
    public final static String ITEM_4 = "4";
    /**
     *  输入的信息有误(INPUTERROR)
     */
    public final static String ITEM_5 = "5";
    /**
     *  重复的数据键值(DUPLICATEKEY)
     */
    public final static String ITEM_6 = "6";
    /**
     *  重复的数据(DUPLICATEDATA)
     */
    public final static String ITEM_7 = "7";
    /**
     *  删除拒绝(DELETEREJECT)
     */
    public final static String ITEM_8 = "8";
    /**
     *  逻辑处理错误(LOGICERROR)
     */
    public final static String ITEM_9 = "9";


    public CodeList35CodeListModelBase() {
        super();
        this.initAnnotation(CodeList35CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList35CodeListModel", this);
    }

}