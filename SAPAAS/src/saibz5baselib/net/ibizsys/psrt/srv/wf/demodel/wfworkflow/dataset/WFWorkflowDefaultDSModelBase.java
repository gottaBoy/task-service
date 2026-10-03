/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfworkflow.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="0166e9c016bf57201ba996cba3a67a45",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="18EFC399-B211-44D6-B9AF-AF182EE81D53",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WFWorkflowDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFWorkflowDefaultDSModelBase() {
        super();

        this.initAnnotation(WFWorkflowDefaultDSModelBase.class);
    }




}