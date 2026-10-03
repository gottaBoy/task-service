/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.tssdengine.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="e4da63c72c04866163e5a74ca984d13f",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="TSSDENGINEID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="TSSDENGINENAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class TSSDEngineDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public TSSDEngineDefaultACModelBase() {
        super();

        this.initAnnotation(TSSDEngineDefaultACModelBase.class);
    }

}