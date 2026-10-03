/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.demodel.demodel.dataentity.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="0cbbb4ccda4e86a9e6f16ed5f3a171c2",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="DEID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="DENAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class DataEntityDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public DataEntityDefaultACModelBase() {
        super();

        this.initAnnotation(DataEntityDefaultACModelBase.class);
    }

}