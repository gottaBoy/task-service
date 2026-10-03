/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfuiwizard.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="6ad51695d5686e6ed1738d36b5a6b1a2",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="A42F37CA-9CD0-4B2D-9653-CFDC7B59AFBF",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WFUIWizardDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFUIWizardDefaultDSModelBase() {
        super();

        this.initAnnotation(WFUIWizardDefaultDSModelBase.class);
    }




}