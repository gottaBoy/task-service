/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userroledetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="a6ba8b8895f3f2438f9e9ef761ccb29c",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="USERROLEDETAILID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="USERROLEDETAILNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class UserRoleDetailDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public UserRoleDetailDefaultACModelBase() {
        super();

        this.initAnnotation(UserRoleDetailDefaultACModelBase.class);
    }

}