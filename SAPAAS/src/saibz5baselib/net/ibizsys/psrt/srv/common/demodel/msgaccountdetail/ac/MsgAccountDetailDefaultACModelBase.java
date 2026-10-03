/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.msgaccountdetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="b0a62e77dcb2ca3226353cea1c370b79",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="MSGACCOUNTDETAILID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="MSGACCOUNTDETAILNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class MsgAccountDetailDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public MsgAccountDetailDefaultACModelBase() {
        super();

        this.initAnnotation(MsgAccountDetailDefaultACModelBase.class);
    }

}