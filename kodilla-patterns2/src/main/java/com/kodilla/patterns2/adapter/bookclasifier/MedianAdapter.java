package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Clasifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MedianAdapter extends MedianAdaptee implements Clasifier {
    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book> signatureBookMap = new HashMap<>();

        signatureBookMap = bookSet.stream()
                .collect(Collectors.toMap(l -> new BookSignature(l.getSignature()),
                        l -> new com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book(
                                l.getAuthor(),
                                l.getTitle(),
                                l.getPublicationYear()
                        )));

        return medianPublicationYear(signatureBookMap);
    }
}
