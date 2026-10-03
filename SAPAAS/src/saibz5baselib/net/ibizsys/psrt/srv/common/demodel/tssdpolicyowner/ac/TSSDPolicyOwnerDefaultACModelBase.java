/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.tssdpolicyowner.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="f19ecba385e1fe480789956e5f638b78",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="TSSDPOLICYOWNERID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="TSSDPOLICYOWNERNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class TSSDPolicyOwnerDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public TSSDPolicyOwnerDefaultACModelBase() {
        super();

        this.initAnnotation(TSSDPolicyOwnerDefaultACModelBase.class);
    }

}