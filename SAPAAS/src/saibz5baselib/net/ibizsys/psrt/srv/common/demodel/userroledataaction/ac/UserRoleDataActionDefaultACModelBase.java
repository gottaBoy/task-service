/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userroledataaction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="0cc63f54de2a15b9a7db47ff805af49a",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="USERROLEDATAACTIONID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="USERROLEDATAACTIONNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class UserRoleDataActionDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public UserRoleDataActionDefaultACModelBase() {
        super();

        this.initAnnotation(UserRoleDataActionDefaultACModelBase.class);
    }

}