
package org.datacontract.schemas._2004._07.endava_edp_invoicebook_web;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocumentPermission complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentPermission">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fill" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="FormCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Mandator" type="{http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models}TaxPayer" minOccurs="0"/>
 *         &lt;element name="Sign" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ViewSent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentPermission", propOrder = {
    "fill",
    "formCode",
    "mandator",
    "sign",
    "viewSent"
})
public class DocumentPermission {

    @XmlElement(name = "Fill")
    protected boolean fill;
    @XmlElementRef(name = "FormCode", namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> formCode;
    @XmlElementRef(name = "Mandator", namespace = "http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models", type = JAXBElement.class, required = false)
    protected JAXBElement<TaxPayer> mandator;
    @XmlElement(name = "Sign")
    protected boolean sign;
    @XmlElement(name = "ViewSent")
    protected boolean viewSent;

    /**
     * Gets the value of the fill property.
     * 
     */
    public boolean isFill() {
        return fill;
    }

    /**
     * Sets the value of the fill property.
     * 
     */
    public void setFill(boolean value) {
        this.fill = value;
    }

    /**
     * Gets the value of the formCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFormCode() {
        return formCode;
    }

    /**
     * Sets the value of the formCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFormCode(JAXBElement<String> value) {
        this.formCode = value;
    }

    /**
     * Gets the value of the mandator property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TaxPayer }{@code >}
     *     
     */
    public JAXBElement<TaxPayer> getMandator() {
        return mandator;
    }

    /**
     * Sets the value of the mandator property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TaxPayer }{@code >}
     *     
     */
    public void setMandator(JAXBElement<TaxPayer> value) {
        this.mandator = value;
    }

    /**
     * Gets the value of the sign property.
     * 
     */
    public boolean isSign() {
        return sign;
    }

    /**
     * Sets the value of the sign property.
     * 
     */
    public void setSign(boolean value) {
        this.sign = value;
    }

    /**
     * Gets the value of the viewSent property.
     * 
     */
    public boolean isViewSent() {
        return viewSent;
    }

    /**
     * Sets the value of the viewSent property.
     * 
     */
    public void setViewSent(boolean value) {
        this.viewSent = value;
    }

}
