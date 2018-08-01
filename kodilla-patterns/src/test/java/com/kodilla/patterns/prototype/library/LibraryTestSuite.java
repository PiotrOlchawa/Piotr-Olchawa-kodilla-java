package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {

        //Given
        Library library = new Library("Library1");
        Library libraryShallowCopy = null;
        Library libraryDeepCopy = null;

        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> library.getBooks().add(new Book("Title" + n, "Author", LocalDate.of(2000, 1, 15))));
        try {
            libraryShallowCopy = library.shallowCopy();
            libraryDeepCopy = library.deepcopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //When
        library.getBooks().remove(library.getBooks().iterator().next());

        //Then
        Assert.assertEquals(9, library.getBooks().size());
        Assert.assertEquals(9, libraryShallowCopy.getBooks().size());
        Assert.assertEquals(10,libraryDeepCopy.getBooks().size());
        Assert.assertNotEquals(library.getBooks(),libraryDeepCopy.getBooks());
    }
}
