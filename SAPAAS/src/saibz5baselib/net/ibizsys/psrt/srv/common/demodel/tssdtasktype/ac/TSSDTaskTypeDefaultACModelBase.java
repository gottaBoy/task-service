/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.tssdtasktype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="43332c6488824ab95b327d64b4f23a1b",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="TSSDTASKTYPEID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="TSSDTASKTYPENAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class TSSDTaskTypeDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public TSSDTaskTypeDefaultACModelBase() {
        super();

        this.initAnnotation(TSSDTaskTypeDefaultACModelBase.class);
    }

}