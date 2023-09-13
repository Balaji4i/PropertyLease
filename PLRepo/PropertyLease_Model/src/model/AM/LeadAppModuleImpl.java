package model.AM;


import model.AM.common.LeadAppModule;

import oracle.adf.share.ADFContext;

import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Mar 27 15:45:31 IST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class LeadAppModuleImpl extends ApplicationModuleImpl implements LeadAppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public LeadAppModuleImpl() {
    }

    /**
     * Container's getter for LeadVO1.
     * @return LeadVO1
     */
    public ViewObjectImpl getLeadVO1() {
        return (ViewObjectImpl)findViewObject("LeadVO1");
    }

    /**
     * Container's getter for SearchLeadROVO1.
     * @return SearchLeadROVO1
     */
    public ViewObjectImpl getSearchLeadROVO1() {
        return (ViewObjectImpl)findViewObject("SearchLeadROVO1");
    }
    /**refreshLeadApplication***/ 
    
    public void refreshLeadApplication(){
            if(ADFContext.getCurrent().getSessionScope().get("addEditLead").toString().equalsIgnoreCase("Add")){
                ADFContext.getCurrent().getPageFlowScope().put("resultVal", "NewLead");
            }else if(ADFContext.getCurrent().getSessionScope().get("addEditLead").toString().equalsIgnoreCase("Edit")){
                ADFContext.getCurrent().getPageFlowScope().put("resultVal", "EditLead");
            }
        }


    /**
     * Container's getter for getFunctionCodeROVO1.
     * @return getFunctionCodeROVO1
     */
    public ViewObjectImpl getgetFunctionCodeROVO1() {
        return (ViewObjectImpl)findViewObject("getFunctionCodeROVO1");
    }
}