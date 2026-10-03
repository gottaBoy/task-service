/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.msgtemplate.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="e2c5b96d6cb0389900da130bc4545add",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="MSGTEMPLATEID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="MSGTEMPLATENAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class MsgTemplateDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public MsgTemplateDefaultACModelBase() {
        super();

        this.initAnnotation(MsgTemplateDefaultACModelBase.class);
    }

}