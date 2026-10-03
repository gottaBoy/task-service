/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.datasyncagent.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;



@DEACMode(name="DEFAULT",id="eca73ee23612ec7a94bc4d8f40f3c5dc",defaultmode=true,dataitems= {
    @DataItem(name="value",dataitemparams={
        @DataItemParam(name="DATASYNCAGENTID",format="")
    })
    , @DataItem(name="text",dataitemparams={
        @DataItemParam(name="DATASYNCAGENTNAME",format="")
    })
}
         )

/**
 *  实体自动填充 [DEFAULT]对象模型基类
 */
public abstract class DataSyncAgentDefaultACModelBase extends net.ibizsys.paas.demodel.DEACModelBase {

    public final static String NAME = "DEFAULT";

    public DataSyncAgentDefaultACModelBase() {
        super();

        this.initAnnotation(DataSyncAgentDefaultACModelBase.class);
    }

}