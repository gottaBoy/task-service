/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfworklist2.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="e888ed9d1cfcb38ac15cceaa4130b162",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="WFWORKLISTID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="WFWORKLISTNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class WFWorkList2DefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public WFWorkList2DefaultACModelBase() {
        super();

        this.initAnnotation(WFWorkList2DefaultACModelBase.class);
    }

}