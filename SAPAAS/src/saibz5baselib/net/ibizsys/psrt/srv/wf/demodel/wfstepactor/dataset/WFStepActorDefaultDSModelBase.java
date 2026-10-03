/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfstepactor.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="3860c42c755f4097c4dfe7d806b185bc",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="06AE28C4-AF90-4C78-ABF0-C20F3396AF6E",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WFStepActorDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFStepActorDefaultDSModelBase() {
        super();

        this.initAnnotation(WFStepActorDefaultDSModelBase.class);
    }




}