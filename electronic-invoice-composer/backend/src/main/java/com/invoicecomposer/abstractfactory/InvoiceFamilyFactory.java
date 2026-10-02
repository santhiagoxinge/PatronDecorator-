package com.invoicecomposer.abstractfactory;

/**
 * Abstract Factory: all factories in a product family must build compatible
 * document variants.
 */
public interface InvoiceFamilyFactory {
    InvoiceDocument createStandardInvoice();
    InvoiceDocument createAdjustmentDocument();
    InvoiceDocument createNotificationDocument();
}
