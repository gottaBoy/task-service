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

@DEDataSet(id="095ff4eab83529a1b8f093180a7ef3fa",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="7FEA8600-CF0F-4557-8530-B16D2FA5690A",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WFStepDataDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFStepDataDefaultDSModelBase() {
        super();

        this.initAnnotation(WFStepDataDefaultDSModelBase.class);
    }




}