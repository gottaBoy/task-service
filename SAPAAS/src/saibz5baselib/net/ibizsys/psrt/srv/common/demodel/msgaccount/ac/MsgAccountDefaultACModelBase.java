/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.msgaccount.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="7ce656616f83e08ed4aeba648bb0a30b",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="MSGACCOUNTID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="MSGACCOUNTNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class MsgAccountDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public MsgAccountDefaultACModelBase() {
        super();

        this.initAnnotation(MsgAccountDefaultACModelBase.class);
    }

}