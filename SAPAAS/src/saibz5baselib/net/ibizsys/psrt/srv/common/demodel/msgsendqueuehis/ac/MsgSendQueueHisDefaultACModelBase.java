/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.msgsendqueuehis.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="6f417c7c7a003110acbb270429717f0f",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="MSGSENDQUEUEHISID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="MSGSENDQUEUEHISNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class MsgSendQueueHisDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public MsgSendQueueHisDefaultACModelBase() {
        super();

        this.initAnnotation(MsgSendQueueHisDefaultACModelBase.class);
    }

}