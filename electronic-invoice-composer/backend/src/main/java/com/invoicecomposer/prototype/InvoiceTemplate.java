package com.invoicecomposer.prototype;

import com.invoicecomposer.domain.Customer;
import com.invoicecomposer.domain.InvoiceItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Example of the Prototype pattern in the invoice domain: a template can be
 * cloned with independent deep-copied data.
 */
public class InvoiceTemplate implements InvoicePrototype {

    private String templateCode;
    private String invoiceNumber;
    private String format;
    private Customer customer;
    private List<InvoiceItem> items;

    public InvoiceTemplate() {
    }

    public InvoiceTemplate(String templateCode, String invoiceNumber, String format,
                           Customer customer, List<InvoiceItem> items) {
        this.templateCode = templateCode;
        this.invoiceNumber = invoiceNumber;
        this.format = format;
        this.customer = customer;
        this.items = items;
    }

    @Override
    public InvoiceTemplate clone() {
        Customer clonedCustomer = cloneCustomer(customer);
        List<InvoiceItem> clonedItems = new ArrayList<>();
        for (InvoiceItem item : items) {
            clonedItems.add(new InvoiceItem(
                    item.getDescription(),
                    item.getQuantity(),
                    item.getUnitPrice()
            ));
        }

        return new InvoiceTemplate(templateCode, invoiceNumber, format, clonedCustomer, clonedItems);
    }

    private Customer cloneCustomer(Customer source) {
        if (source == null) {
            return null;
        }

        return new Customer(
                source.getName(),
                source.getNit(),
                source.getEmail(),
                source.getAddress(),
                source.getCity(),
                source.getPhone()
        );
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }
}
