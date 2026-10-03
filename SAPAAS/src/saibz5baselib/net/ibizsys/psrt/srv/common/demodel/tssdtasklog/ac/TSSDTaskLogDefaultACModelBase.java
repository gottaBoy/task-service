/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.tssdtasklog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="5d9604bc9220d47f935650303d154680",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="TSSDTASKLOGID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="TSSDTASKLOGNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class TSSDTaskLogDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public TSSDTaskLogDefaultACModelBase() {
        super();

        this.initAnnotation(TSSDTaskLogDefaultACModelBase.class);
    }

}