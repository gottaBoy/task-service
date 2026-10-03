/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.dedatachg2.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="2be4c985b8c11e06783904ce4e9d8b90",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="DEDATACHG2ID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="DEDATACHG2NAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class DEDataChg2DefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public DEDataChg2DefaultACModelBase() {
        super();

        this.initAnnotation(DEDataChg2DefaultACModelBase.class);
    }

}