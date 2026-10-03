/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.msgsendqueue.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="323db6416464fc80757753d4f3666854",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="MSGSENDQUEUEID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="MSGSENDQUEUENAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class MsgSendQueueDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public MsgSendQueueDefaultACModelBase() {
        super();

        this.initAnnotation(MsgSendQueueDefaultACModelBase.class);
    }

}