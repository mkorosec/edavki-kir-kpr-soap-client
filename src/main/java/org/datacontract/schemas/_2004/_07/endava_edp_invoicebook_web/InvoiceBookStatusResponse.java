
package org.datacontract.schemas._2004._07.endava_edp_invoicebook_web;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InvoiceBookStatusResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvoiceBookStatusResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BackendMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models}InvoiceBookStatus"/>
 *         &lt;element name="ValidationMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvoiceBookStatusResponse", propOrder = {
    "backendMessage",
    "status",
    "validationMessage"
})
public class InvoiceBookStatusResponse {

    @XmlElementRef(name = "BackendMessage", namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> backendMessage;
    @XmlElement(name = "Status", required = true)
    @XmlSchemaType(name = "string")
    protected InvoiceBookStatus status;
    @XmlElementRef(name = "ValidationMessage", namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> validationMessage;

    /**
     * Gets the value of the backendMessage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBackendMessage() {
        return backendMessage;
    }

    /**
     * Sets the value of the backendMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBackendMessage(JAXBElement<String> value) {
        this.backendMessage = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceBookStatus }
     *     
     */
    public InvoiceBookStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceBookStatus }
     *     
     */
    public void setStatus(InvoiceBookStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the validationMessage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getValidationMessage() {
        return validationMessage;
    }

    /**
     * Sets the value of the validationMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setValidationMessage(JAXBElement<String> value) {
        this.validationMessage = value;
    }

}
