/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.tssdtaskpolicy.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="7fbddaf527849efd537411955e65800d",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="TSSDTASKPOLICYID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="TSSDTASKPOLICYNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class TSSDTaskPolicyDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public TSSDTaskPolicyDefaultACModelBase() {
        super();

        this.initAnnotation(TSSDTaskPolicyDefaultACModelBase.class);
    }

}