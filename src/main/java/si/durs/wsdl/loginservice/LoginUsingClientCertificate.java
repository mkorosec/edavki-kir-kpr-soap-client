
package si.durs.wsdl.loginservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="taxPayerId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="taxPayerType" type="{http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models}TaxPayerType" minOccurs="0"/>
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
    "taxPayerId",
    "taxPayerType"
})
@XmlRootElement(name = "LoginUsingClientCertificate", namespace = "http://tempuri.org/")
public class LoginUsingClientCertificate {

    @XmlElement(namespace = "http://tempuri.org/")
    protected Integer taxPayerId;
    @XmlElement(namespace = "http://tempuri.org/")
    @XmlSchemaType(name = "string")
    protected TaxPayerType taxPayerType;

    /**
     * Gets the value of the taxPayerId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTaxPayerId() {
        return taxPayerId;
    }

    /**
     * Sets the value of the taxPayerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTaxPayerId(Integer value) {
        this.taxPayerId = value;
    }

    /**
     * Gets the value of the taxPayerType property.
     * 
     * @return
     *     possible object is
     *     {@link TaxPayerType }
     *     
     */
    public TaxPayerType getTaxPayerType() {
        return taxPayerType;
    }

    /**
     * Sets the value of the taxPayerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxPayerType }
     *     
     */
    public void setTaxPayerType(TaxPayerType value) {
        this.taxPayerType = value;
    }

}
