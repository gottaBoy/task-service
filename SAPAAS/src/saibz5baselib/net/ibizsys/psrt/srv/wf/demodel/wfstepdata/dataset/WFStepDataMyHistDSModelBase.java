/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfstepdata.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="E94E1E8C-8EE8-4B7E-92F3-2DBFA2418FF9",name="MyHist",queries= {
    @DEDataSetQuery(queryid="531C91E6-E358-4F02-9FF2-B7EDAF626FD3",queryname="MyHist")
})

/**
 *  实体数据集合[我的历史]模型基类
 */
public abstract class WFStepDataMyHistDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFStepDataMyHistDSModelBase() {
        super();

        this.initAnnotation(WFStepDataMyHistDSModelBase.class);
    }




}