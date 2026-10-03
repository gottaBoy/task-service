/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="493b7805ad1d21a3fda2237355a7d871",name="应用界面主题",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="APPUITHEME_DEFAULT",text="默认界面主题",realtext="默认界面主题")
    ,@CodeItem(value="APPUITHEME_GRAY",text="界面主题（灰色）",realtext="界面主题（灰色）")
    ,@CodeItem(value="APPUITHEME_RED",text="界面主题（红色）",realtext="界面主题（红色）")
    ,@CodeItem(value="APPUITHEME_SLATE",text="界面主题（石板灰）",realtext="界面主题（石板灰）")
})


/**
 * 静态代码表[应用界面主题]模型基类
 */
public abstract class CodeList58CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  默认界面主题，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String APPUITHEME_DEFAULT = "APPUITHEME_DEFAULT";
    /**
     *  界面主题（灰色），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String APPUITHEME_GRAY = "APPUITHEME_GRAY";
    /**
     *  界面主题（红色），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String APPUITHEME_RED = "APPUITHEME_RED";
    /**
     *  界面主题（石板灰），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String APPUITHEME_SLATE = "APPUITHEME_SLATE";

    public CodeList58CodeListModelBase() {
        super();
        this.initAnnotation(CodeList58CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList58CodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.CodeList58CodeListModel");
    }

}