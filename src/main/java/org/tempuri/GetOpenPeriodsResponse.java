
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.endava_edp_invoicebook_web.OpenPeriodsResponse;


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
 *         &lt;element name="GetOpenPeriodsResult" type="{http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models}OpenPeriodsResponse" minOccurs="0"/>
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
    "getOpenPeriodsResult"
})
@XmlRootElement(name = "GetOpenPeriodsResponse")
public class GetOpenPeriodsResponse {

    @XmlElementRef(name = "GetOpenPeriodsResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<OpenPeriodsResponse> getOpenPeriodsResult;

    /**
     * Gets the value of the getOpenPeriodsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OpenPeriodsResponse }{@code >}
     *     
     */
    public JAXBElement<OpenPeriodsResponse> getGetOpenPeriodsResult() {
        return getOpenPeriodsResult;
    }

    /**
     * Sets the value of the getOpenPeriodsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OpenPeriodsResponse }{@code >}
     *     
     */
    public void setGetOpenPeriodsResult(JAXBElement<OpenPeriodsResponse> value) {
        this.getOpenPeriodsResult = value;
    }

}
