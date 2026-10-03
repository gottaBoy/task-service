/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfiaaction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="e1ba3122fd9af91ae76dd18bf015669a",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="WFIAACTIONID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="WFIAACTIONNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class WFIAActionDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public WFIAActionDefaultACModelBase() {
        super();

        this.initAnnotation(WFIAActionDefaultACModelBase.class);
    }

}