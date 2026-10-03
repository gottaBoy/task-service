/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.msgaccountdetail.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="b0a62e77dcb2ca3226353cea1c370b79",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="BBEB9F49-775E-43A2-A019-B588F9A9CAE4",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class MsgAccountDetailDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public MsgAccountDetailDefaultDSModelBase() {
        super();

        this.initAnnotation(MsgAccountDetailDefaultDSModelBase.class);
    }




}