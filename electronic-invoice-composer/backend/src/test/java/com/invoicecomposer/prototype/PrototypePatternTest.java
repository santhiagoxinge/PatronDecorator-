package com.invoicecomposer.prototype;

import com.invoicecomposer.domain.Customer;
import com.invoicecomposer.domain.InvoiceItem;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class PrototypePatternTest {

    @Test
    void invoiceTemplateCloneCopiesValuesWithoutSharingState() {
        Customer customer = new Customer("Empresa ABC", "900123456-7", "compras@empresaabc.com",
                "Calle 100", "Bogotá", "6015550100");
        List<InvoiceItem> items = List.of(
                new InvoiceItem("Laptop", 2, 3500000),
                new InvoiceItem("Monitor", 1, 1200000)
        );

        InvoiceTemplate base = new InvoiceTemplate("TEMPLATE-01", "FE-1001", "UBL 2.1", customer, items);
        InvoiceTemplate clone = (InvoiceTemplate) base.clone();

        assertNotSame(base, clone);
        assertEquals(base.getInvoiceNumber(), clone.getInvoiceNumber());
        assertEquals(base.getCustomer().getName(), clone.getCustomer().getName());

        clone.getCustomer().setName("Cliente Clone");
        clone.getItems().get(0).setDescription("Cambio de prueba");

        assertEquals("Empresa ABC", base.getCustomer().getName());
        assertEquals("Laptop", base.getItems().get(0).getDescription());
    }
}
