package com.invoicecomposer.abstractfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AbstractFactoryPatternTest {

    @Test
    void standardFactoryCreatesCompatibleFamilies() {
        InvoiceFamilyFactory factory = InvoiceFactoryProvider.createFactory("STANDARD");

        InvoiceDocument invoice = factory.createStandardInvoice();
        InvoiceDocument adjustment = factory.createAdjustmentDocument();
        InvoiceDocument notification = factory.createNotificationDocument();

        assertEquals("Factura Electrónica", invoice.getDocumentType());
        assertEquals("Nota de Ajuste", adjustment.getDocumentType());
        assertEquals("Copia de cortesía", notification.getDocumentType());
        assertNotNull(invoice.buildContent());
    }

    @Test
    void digitalFactoryCreatesDigitalFamily() {
        InvoiceFamilyFactory factory = InvoiceFactoryProvider.createFactory("DIGITAL");

        InvoiceDocument invoice = factory.createStandardInvoice();
        InvoiceDocument adjustment = factory.createAdjustmentDocument();

        assertEquals("Factura Digital", invoice.getDocumentType());
        assertEquals("Nota de Crédito Digital", adjustment.getDocumentType());
    }
}
