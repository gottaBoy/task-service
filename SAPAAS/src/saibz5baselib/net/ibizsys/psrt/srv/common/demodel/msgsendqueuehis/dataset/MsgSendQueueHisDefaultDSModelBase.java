/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.msgsendqueuehis.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="6f417c7c7a003110acbb270429717f0f",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="0B9D6E00-228F-4715-A0D4-202C0702124E",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class MsgSendQueueHisDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public MsgSendQueueHisDefaultDSModelBase() {
        super();

        this.initAnnotation(MsgSendQueueHisDefaultDSModelBase.class);
    }




}