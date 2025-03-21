
package org.tempuri;

import javax.xml.ws.WebFault;
import org.datacontract.schemas._2004._07.endava_edp_invoicebook_web.ForbiddenFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ForbiddenFault", targetNamespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Soap")
public class ISoapServiceGetInvoiceBookStatusForbiddenFaultFaultFaultMessage
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ForbiddenFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ISoapServiceGetInvoiceBookStatusForbiddenFaultFaultFaultMessage(String message, ForbiddenFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ISoapServiceGetInvoiceBookStatusForbiddenFaultFaultFaultMessage(String message, ForbiddenFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.datacontract.schemas._2004._07.endava_edp_invoicebook_web.ForbiddenFault
     */
    public ForbiddenFault getFaultInfo() {
        return faultInfo;
    }

}
