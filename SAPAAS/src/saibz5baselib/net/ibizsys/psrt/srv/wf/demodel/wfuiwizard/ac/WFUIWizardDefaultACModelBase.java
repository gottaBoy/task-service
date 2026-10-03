/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfuiwizard.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="6ad51695d5686e6ed1738d36b5a6b1a2",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="WFUIWIZARDID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="WFUIWIZARDNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class WFUIWizardDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public WFUIWizardDefaultACModelBase() {
        super();

        this.initAnnotation(WFUIWizardDefaultACModelBase.class);
    }

}