/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userroledefield.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="10d6c2ea8dda8754dcde1bceab9704c5",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="USERROLEDEFIELDID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="USERROLEDEFIELDNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class UserRoleDEFieldDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public UserRoleDEFieldDefaultACModelBase() {
        super();

        this.initAnnotation(UserRoleDEFieldDefaultACModelBase.class);
    }

}