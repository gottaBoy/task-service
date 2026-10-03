package SA.SRFDA.PS.Web;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServiceServlet extends HttpServletBase {
   private static final Log log = LogFactory.getLog(ServiceServlet.class);

   @Override
   protected AjaxActionResult onProcessAction() throws Exception {
      MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
      String strDEId = WebContext.getDEId(this.getWebContext());
      String strCall = WebContext.getRemoteCall(this.getWebContext());
      String strRemoteAddr = this.getWebContext().getRemoteAddr();

      try {
         if (StringHelper.isNullOrEmpty(strDEId)) {
            throw new Exception(StringHelper.format("无法识别的远程调用[%1$s]", strCall));
         }

         IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(strDEId);
         IService iService = iDataEntityModel.getService(this.getSessionFactory());
         if (StringHelper.compare(strCall, "SAVE", true) == 0
            || StringHelper.compare(strCall, "GET", true) == 0
            || StringHelper.compare(strCall, "CREATE", true) == 0
            || StringHelper.compare(strCall, "UPDATE", true) == 0
            || StringHelper.compare(strCall, "REMOVE", true) == 0
            || StringHelper.compare(strCall, "GETDRAFT", true) == 0) {
            String strArg = WebContext.getRemoteCallArg(this.getWebContext());
            IEntity iEntity = iService.getDEModel().createEntity();
            JSONObject joArg = JSONObjectHelper.fromString(strArg);
            DataObject.fromJSONObject(iEntity, joArg);
            iService.executeAction(strCall, iEntity);
            ajaxActionResult.getRows().add(DataObject.toJSONString(iEntity, false));
            return ajaxActionResult;
         }

         if (StringHelper.compare(strCall, "SELECT", true) == 0) {
            SelectCond selectCond = new SelectCond();
            String strArg = WebContext.getRemoteCallArg(this.getWebContext());
            JSONObject joArg = JSONObjectHelper.fromString(strArg);
            DataObject.fromJSONObject(selectCond, joArg);

            for (Object objItem : iService.select(selectCond)) {
               IDataObject iDataObject = (IDataObject)objItem;
               ajaxActionResult.getRows().add(DataObject.toJSONString(iDataObject, false));
            }

            return ajaxActionResult;
         } else {
            if (StringHelper.compare(strCall, "FETCH", true) != 0) {
               throw new Exception(StringHelper.format("无法识别的远程调用[%1$s]", strCall));
            }

            String strArg = WebContext.getRemoteCallArg(this.getWebContext());
            new SimpleEntity();
            DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(this.getWebContext());
            deDataSetFetchContextImpl.setSessionFactory(this.getSessionFactory());
            this.onFillFetchConditions(iService.getDEModel(), deDataSetFetchContextImpl.getConditionList());
            DBFetchResult fetchResult = iService.fetchDataSet(strArg, deDataSetFetchContextImpl);
            ajaxActionResult.setTotalRow(fetchResult.getTotalRow());
            ajaxActionResult.setStartRow(deDataSetFetchContextImpl.getStartRow());
            ajaxActionResult.setPageSize(deDataSetFetchContextImpl.getPageSize());
            IDataTable dt = fetchResult.getDataSet().getDataTable(0);
            if (dt.getCachedRowCount() == -1) {
               while (true) {
                  IDataRow iDataRow = dt.next();
                  if (iDataRow == null) {
                     break;
                  }

                  SimpleEntity simpleEntity = new SimpleEntity();
                  DataObject.fromDataRow(simpleEntity, iDataRow);
                  ajaxActionResult.getRows().add(DataObject.toJSONObject(simpleEntity, false));
               }
            } else {
               int nRows = dt.getCachedRowCount();

               for (int i = 0; i < nRows; i++) {
                  IDataRow iDataRow = dt.getCachedRow(i);
                  SimpleEntity simpleEntity = new SimpleEntity();
                  DataObject.fromDataRow(simpleEntity, iDataRow);
                  ajaxActionResult.getRows().add(DataObject.toJSONObject(simpleEntity, false));
               }
            }

            return ajaxActionResult;
         }
      } catch (Exception ex) {
         log.error(StringHelper.format("远程请求发生异常，%1$s", ex.getMessage()), ex);
         ajaxActionResult.setRetCode(1);
         ajaxActionResult.setErrorInfo(ex.getMessage());
         return ajaxActionResult;
      }
   }

   protected void onFillFetchConditions(IDataEntityModel iDEModel, ArrayList<IDEDataSetCond> userConditions) throws Exception {
      Iterator<IDEField> deFields = iDEModel.getDEFields();

      while (deFields.hasNext()) {
         IDEField defield = deFields.next();
         Iterator<IDEFSearchMode> defSearchModes = defield.getDEFSearchModes();
         if (defSearchModes != null) {
            while (defSearchModes.hasNext()) {
               IDEFSearchMode iDEFSearchMode = defSearchModes.next();
               String strFormItemId = iDEFSearchMode.getName();
               String strValue = this.getWebContext().getPostValue(strFormItemId.toLowerCase());
               if (!StringHelper.isNullOrEmpty(strValue)) {
                  DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
                  deDataSetCondImpl.setCondType("DEFIELD");
                  deDataSetCondImpl.setCondOp(iDEFSearchMode.getValueOp());
                  deDataSetCondImpl.setDEFName(defield.getName());
                  deDataSetCondImpl.setCondValue(strValue);
                  userConditions.add(deDataSetCondImpl);
               }
            }
         }
      }
   }
}
