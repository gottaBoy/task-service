/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.datasyncout2.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="1cecb3d95febd748a2daf8e9c86a8ec5",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="DATASYNCOUT2ID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="DATASYNCOUT2NAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class DataSyncOut2DefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public DataSyncOut2DefaultACModelBase() {
        super();

        this.initAnnotation(DataSyncOut2DefaultACModelBase.class);
    }

}