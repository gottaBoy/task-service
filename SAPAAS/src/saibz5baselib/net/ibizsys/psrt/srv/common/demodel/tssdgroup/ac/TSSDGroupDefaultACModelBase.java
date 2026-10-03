/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.tssdgroup.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="f37da71b9c7217fb86634c135e6fb7e0",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="TSSDGROUPID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="TSSDGROUPNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class TSSDGroupDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public TSSDGroupDefaultACModelBase() {
        super();

        this.initAnnotation(TSSDGroupDefaultACModelBase.class);
    }

}