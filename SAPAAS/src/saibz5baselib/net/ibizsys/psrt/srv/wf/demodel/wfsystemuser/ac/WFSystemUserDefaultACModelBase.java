/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfsystemuser.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="3d6fd9746bb1acf4b6af87da05f6a646",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="WFSYSTEMUSERID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="WFSYSTEMUSERNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class WFSystemUserDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public WFSystemUserDefaultACModelBase() {
        super();

        this.initAnnotation(WFSystemUserDefaultACModelBase.class);
    }

}