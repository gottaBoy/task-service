/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userroledefields.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="c95a8972b0f72a140d65e057a002144a",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="USERROLEDEFIELDSID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="USERROLEDEFIELDSNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class UserRoleDEFieldsDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public UserRoleDEFieldsDefaultACModelBase() {
        super();

        this.initAnnotation(UserRoleDEFieldsDefaultACModelBase.class);
    }

}