package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoice() {
        //Given
        Product product = new Product("Mleko");

        Item item1 = new Item(new BigDecimal("8"), 1, new BigDecimal("32"));
        Item item2 = new Item(new BigDecimal("8"), 2, new BigDecimal("34"));

        Invoice invoice = new Invoice("001");

        product.getItems().add(item1);
        product.getItems().add(item2);

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item1.setProduct(product);
        item2.setProduct(product);

        //When
        invoiceDao.save(invoice);
        int invoicesSize = invoiceDao.findByNumber("001").size();
        int invoiceId = invoice.getId();

        //Then
        Assert.assertEquals(1, invoiceId);
        Assert.assertEquals(1,invoicesSize);
        //CleanUp
        invoiceDao.delete(invoiceId);
    }
}