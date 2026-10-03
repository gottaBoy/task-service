/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.msgsendqueue.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="323db6416464fc80757753d4f3666854",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="F4834CCA-AF33-42BA-80A4-F70106F4DEC1",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class MsgSendQueueDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public MsgSendQueueDefaultDSModelBase() {
        super();

        this.initAnnotation(MsgSendQueueDefaultDSModelBase.class);
    }




}