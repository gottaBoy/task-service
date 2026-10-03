/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfdynamicuser.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="733170434261be84089d353a6a231373",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="WFDYNAMICUSERID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="WFDYNAMICUSERNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class WFDynamicUserDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public WFDynamicUserDefaultACModelBase() {
        super();

        this.initAnnotation(WFDynamicUserDefaultACModelBase.class);
    }

}