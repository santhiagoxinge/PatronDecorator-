package com.invoicecomposer.abstractfactory;

public class StandardInvoiceFactory implements InvoiceFamilyFactory {

    @Override
    public InvoiceDocument createStandardInvoice() {
        return new XmlInvoiceDocument("Factura Electrónica");
    }

    @Override
    public InvoiceDocument createAdjustmentDocument() {
        return new XmlInvoiceDocument("Nota de Ajuste");
    }

    @Override
    public InvoiceDocument createNotificationDocument() {
        return new PdfInvoiceDocument("Copia de cortesía");
    }
}
