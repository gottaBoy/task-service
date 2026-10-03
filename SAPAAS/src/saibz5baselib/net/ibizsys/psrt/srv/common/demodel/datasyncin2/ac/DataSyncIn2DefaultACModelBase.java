/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.datasyncin2.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="04c87ff6cdac6dd390613dbc44f3c51d",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="DATASYNCIN2ID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="DATASYNCIN2NAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class DataSyncIn2DefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public DataSyncIn2DefaultACModelBase() {
        super();

        this.initAnnotation(DataSyncIn2DefaultACModelBase.class);
    }

}