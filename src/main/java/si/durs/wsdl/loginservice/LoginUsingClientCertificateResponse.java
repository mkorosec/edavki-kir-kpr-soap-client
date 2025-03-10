
package si.durs.wsdl.loginservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LoginUsingClientCertificateResult" type="{http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models}TokenResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "loginUsingClientCertificateResult"
})
@XmlRootElement(name = "LoginUsingClientCertificateResponse", namespace = "http://tempuri.org/")
public class LoginUsingClientCertificateResponse {

    @XmlElementRef(name = "LoginUsingClientCertificateResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<TokenResponse> loginUsingClientCertificateResult;

    /**
     * Gets the value of the loginUsingClientCertificateResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TokenResponse }{@code >}
     *     
     */
    public JAXBElement<TokenResponse> getLoginUsingClientCertificateResult() {
        return loginUsingClientCertificateResult;
    }

    /**
     * Sets the value of the loginUsingClientCertificateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TokenResponse }{@code >}
     *     
     */
    public void setLoginUsingClientCertificateResult(JAXBElement<TokenResponse> value) {
        this.loginUsingClientCertificateResult = value;
    }

}
