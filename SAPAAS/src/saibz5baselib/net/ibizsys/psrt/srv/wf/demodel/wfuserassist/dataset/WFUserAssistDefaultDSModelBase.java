/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfuserassist.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="c0a02fe821e07837af3333a49fb08b30",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="6A6C850C-1585-4BFF-A726-6B4D021C5B53",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WFUserAssistDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFUserAssistDefaultDSModelBase() {
        super();

        this.initAnnotation(WFUserAssistDefaultDSModelBase.class);
    }




}