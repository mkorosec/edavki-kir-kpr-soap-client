
package org.datacontract.schemas._2004._07.endava_edp_invoicebook_web;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InvoiceBookFormat.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InvoiceBookFormat">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="XML"/>
 *     &lt;enumeration value="JSON"/>
 *     &lt;enumeration value="CSV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InvoiceBookFormat")
@XmlEnum
public enum InvoiceBookFormat {

    XML,
    JSON,
    CSV;

    public String value() {
        return name();
    }

    public static InvoiceBookFormat fromValue(String v) {
        return valueOf(v);
    }

}
