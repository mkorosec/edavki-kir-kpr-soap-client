
package org.datacontract.schemas._2004._07.endava_edp_invoicebook_web;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDocumentPermission complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDocumentPermission">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocumentPermission" type="{http://schemas.datacontract.org/2004/07/Endava.Edp.InvoiceBook.Web.Models}DocumentPermission" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDocumentPermission", propOrder = {
    "documentPermission"
})
public class ArrayOfDocumentPermission {

    @XmlElement(name = "DocumentPermission", nillable = true)
    protected List<DocumentPermission> documentPermission;

    /**
     * Gets the value of the documentPermission property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentPermission property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentPermission().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentPermission }
     * 
     * 
     */
    public List<DocumentPermission> getDocumentPermission() {
        if (documentPermission == null) {
            documentPermission = new ArrayList<DocumentPermission>();
        }
        return this.documentPermission;
    }

}
