/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.dynasys.demodel.dsdynaviewinst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="455ba35d2ea0b7be6e2035f54ff60f5b",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="DSDYNAVIEWINSTID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="DSDYNAVIEWINSTNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class DSDynaViewInstDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public DSDynaViewInstDefaultACModelBase() {
        super();

        this.initAnnotation(DSDynaViewInstDefaultACModelBase.class);
    }

}