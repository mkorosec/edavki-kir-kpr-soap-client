
package org.datacontract.schemas._2004._07.endava_edp_invoicebook_web;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfOpenPeriod complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfOpenPeriod">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OpenPeriod" type="{http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models}OpenPeriod" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfOpenPeriod", propOrder = {
    "openPeriod"
})
public class ArrayOfOpenPeriod {

    @XmlElement(name = "OpenPeriod", nillable = true)
    protected List<OpenPeriod> openPeriod;

    /**
     * Gets the value of the openPeriod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the openPeriod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOpenPeriod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OpenPeriod }
     * 
     * 
     */
    public List<OpenPeriod> getOpenPeriod() {
        if (openPeriod == null) {
            openPeriod = new ArrayList<OpenPeriod>();
        }
        return this.openPeriod;
    }

}
