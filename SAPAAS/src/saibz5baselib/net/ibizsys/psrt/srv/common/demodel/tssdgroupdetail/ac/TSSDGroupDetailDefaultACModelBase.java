/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.tssdgroupdetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="e8b6c72b7a73a98f68bf91b812d46c31",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="TSSDGROUPDETAILID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="TSSDGROUPDETAILNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class TSSDGroupDetailDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public TSSDGroupDetailDefaultACModelBase() {
        super();

        this.initAnnotation(TSSDGroupDetailDefaultACModelBase.class);
    }

}