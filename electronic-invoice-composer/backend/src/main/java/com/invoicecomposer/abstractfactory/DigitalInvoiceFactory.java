package com.invoicecomposer.abstractfactory;

public class DigitalInvoiceFactory implements InvoiceFamilyFactory {

    @Override
    public InvoiceDocument createStandardInvoice() {
        return new PdfInvoiceDocument("Factura Digital");
    }

    @Override
    public InvoiceDocument createAdjustmentDocument() {
        return new PdfInvoiceDocument("Nota de Crédito Digital");
    }

    @Override
    public InvoiceDocument createNotificationDocument() {
        return new XmlInvoiceDocument("Email con XML anexo");
    }
}
