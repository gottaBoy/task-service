/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfappsetting.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="598b85c09bc9375e762590d2ab97552c",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="WFAPPSETTINGID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="WFAPPSETTINGNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class WFAppSettingDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public WFAppSettingDefaultACModelBase() {
        super();

        this.initAnnotation(WFAppSettingDefaultACModelBase.class);
    }

}