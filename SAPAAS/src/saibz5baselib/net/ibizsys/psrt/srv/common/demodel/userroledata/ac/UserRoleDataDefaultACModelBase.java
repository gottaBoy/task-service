/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userroledata.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="c4125399a698dc5f8acca6dc8b38b353",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="USERROLEDATAID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="USERROLEDATANAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class UserRoleDataDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public UserRoleDataDefaultACModelBase() {
        super();

        this.initAnnotation(UserRoleDataDefaultACModelBase.class);
    }

}