/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfiaaction.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="e1ba3122fd9af91ae76dd18bf015669a",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="8D5194BA-3765-4525-9028-CD93DBFB2DD0",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WFIAActionDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFIAActionDefaultDSModelBase() {
        super();

        this.initAnnotation(WFIAActionDefaultDSModelBase.class);
    }




}