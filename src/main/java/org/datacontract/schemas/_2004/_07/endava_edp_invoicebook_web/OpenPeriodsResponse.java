
package org.datacontract.schemas._2004._07.endava_edp_invoicebook_web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OpenPeriodsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OpenPeriodsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OpenPeriods" type="{http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models}ArrayOfOpenPeriod"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpenPeriodsResponse", propOrder = {
    "openPeriods"
})
public class OpenPeriodsResponse {

    @XmlElement(name = "OpenPeriods", required = true, nillable = true)
    protected ArrayOfOpenPeriod openPeriods;

    /**
     * Gets the value of the openPeriods property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfOpenPeriod }
     *     
     */
    public ArrayOfOpenPeriod getOpenPeriods() {
        return openPeriods;
    }

    /**
     * Sets the value of the openPeriods property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfOpenPeriod }
     *     
     */
    public void setOpenPeriods(ArrayOfOpenPeriod value) {
        this.openPeriods = value;
    }

}
