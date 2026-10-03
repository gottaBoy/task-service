/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.dataauditdetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="7d9fefe4909e0cfffcb467129475b02d",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="DATAAUDITDETAILID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="DATAAUDITDETAILNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class DataAuditDetailDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public DataAuditDetailDefaultACModelBase() {
        super();

        this.initAnnotation(DataAuditDetailDefaultACModelBase.class);
    }

}