/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfcustomprocess.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="4b334725c65c703dfa12a6ed7103a9da",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="WFCUSTOMPROCESSID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="WFCUSTOMPROCESSNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class WFCustomProcessDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public WFCustomProcessDefaultACModelBase() {
        super();

        this.initAnnotation(WFCustomProcessDefaultACModelBase.class);
    }

}