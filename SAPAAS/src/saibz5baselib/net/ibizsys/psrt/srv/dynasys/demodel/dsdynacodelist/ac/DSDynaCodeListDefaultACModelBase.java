/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.dynasys.demodel.dsdynacodelist.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="7a90be048da1f8e71d2f8f74e8703c05",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="DSDYNACODELISTID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="DSDYNACODELISTNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class DSDynaCodeListDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public DSDynaCodeListDefaultACModelBase() {
        super();

        this.initAnnotation(DSDynaCodeListDefaultACModelBase.class);
    }

}