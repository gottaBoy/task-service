/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfusercandidate.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="9f2a5bbda357d70344cb5debd7d05c71",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="WFUSERCANDIDATEID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="WFUSERCANDIDATENAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class WFUserCandidateDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public WFUserCandidateDefaultACModelBase() {
        super();

        this.initAnnotation(WFUserCandidateDefaultACModelBase.class);
    }

}