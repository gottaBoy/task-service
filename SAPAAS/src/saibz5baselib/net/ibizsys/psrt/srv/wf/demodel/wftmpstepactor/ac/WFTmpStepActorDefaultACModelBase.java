/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wftmpstepactor.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="0e976da1c2895bf2e955f90554c10b15",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="WFTMPSTEPACTORID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="WFTMPSTEPACTORNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class WFTmpStepActorDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public WFTmpStepActorDefaultACModelBase() {
        super();

        this.initAnnotation(WFTmpStepActorDefaultACModelBase.class);
    }

}