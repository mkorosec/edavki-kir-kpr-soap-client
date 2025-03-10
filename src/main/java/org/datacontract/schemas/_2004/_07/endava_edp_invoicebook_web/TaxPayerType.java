
package org.datacontract.schemas._2004._07.endava_edp_invoicebook_web;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaxPayerType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TaxPayerType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FO"/>
 *     &lt;enumeration value="SP"/>
 *     &lt;enumeration value="PO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TaxPayerType")
@XmlEnum
public enum TaxPayerType {

    FO,
    SP,
    PO;

    public String value() {
        return name();
    }

    public static TaxPayerType fromValue(String v) {
        return valueOf(v);
    }

}
