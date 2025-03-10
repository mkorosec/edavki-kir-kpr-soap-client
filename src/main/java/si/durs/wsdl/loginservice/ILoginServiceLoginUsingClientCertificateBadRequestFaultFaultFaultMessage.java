
package si.durs.wsdl.loginservice;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "BadRequestFault", targetNamespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Soap")
public class ILoginServiceLoginUsingClientCertificateBadRequestFaultFaultFaultMessage
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private BadRequestFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ILoginServiceLoginUsingClientCertificateBadRequestFaultFaultFaultMessage(String message, BadRequestFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ILoginServiceLoginUsingClientCertificateBadRequestFaultFaultFaultMessage(String message, BadRequestFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: si.durs.wsdl.loginservice.BadRequestFault
     */
    public BadRequestFault getFaultInfo() {
        return faultInfo;
    }

}
