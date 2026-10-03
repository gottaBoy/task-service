/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfassistwork.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="80bc47afe28e23ebfb7aea12fdbc1acd",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="WFASSISTWORKID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="WFASSISTWORKNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class WFAssistWorkDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public WFAssistWorkDefaultACModelBase() {
        super();

        this.initAnnotation(WFAssistWorkDefaultACModelBase.class);
    }

}