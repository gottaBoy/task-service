/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfusergroupdetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="0b60b3e6ed35cc656ceecb6fac698e6e",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="WFUSERGROUPDETAILID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="WFUSERGROUPDETAILNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class WFUserGroupDetailDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public WFUserGroupDetailDefaultACModelBase() {
        super();

        this.initAnnotation(WFUserGroupDetailDefaultACModelBase.class);
    }

}