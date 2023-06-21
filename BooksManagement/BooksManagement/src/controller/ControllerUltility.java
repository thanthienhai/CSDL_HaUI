package controller;


import model.Book;
import model.BookReaderManagerment;
import model.Reader;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Lớp này dùng để thực hiện các chức năng như tìm kiếm, cập nhật, chỉnh sửa,
 * xóa, sắp xếp
 */
public class ControllerUltility {
    private DataUlitility ulitility;

    public ControllerUltility() {
        this.ulitility = new DataUlitility();
    }

    public void sortByName(BookReaderManagerment[] args) {
        Arrays.sort(args);
    }

    public void sortByNumofBorrow(BookReaderManagerment[] args) {
        Arrays.sort(args);
    }

    public BookReaderManagerment[] findByName(BookReaderManagerment[] readers, String key) {
        String regex = ".*" + key.toLowerCase() + ".*";
        BookReaderManagerment[] x = new BookReaderManagerment[1000];
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        int count = 0;
        for (int i = 0; i < readers.length; i++) {
            String name = readers[i].getReader().getFullName().toLowerCase();
            if (pattern.matcher(name).find()) {
                boolean isExist = false;
                for (int j = 0; j < count; j++) {
                    if (x[j].getReader().getReaderID() == readers[i].getReader().getReaderID()) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    x[count++] = readers[i];
                }
            }
        }

        return x;
    }

    public BookReaderManagerment[] updateBRMInfo(BookReaderManagerment[] brm,
                                                 Reader[] readers, Book[] books) {
        for (int i = 0; i < brm.length; i++) {
            int bookID = brm[i].getBooks().getBookID();
            int readerId = brm[i].getReader().getReaderID();
            int total = countBookBorrowedByReader(brm, readerId);
            brm[i].setReader(findReaderByID(readers, readerId));
            brm[i].setBooks(findBookById(books, bookID));
            brm = setTotalBookBorrowed(brm, readerId, total);
        }
        return brm;
    }

    public int countBookBorrowedByReader(BookReaderManagerment[] brm, int readerID) {
        int count = 0;
        for (int i = 0; i < brm.length; i++) {
            if (brm[i].getReader().getReaderID() == readerID) {
                count += brm[i].getNumOfBorrow();
            }
        }
        return count;
    }

    public BookReaderManagerment[] setTotalBookBorrowed(BookReaderManagerment[] brm, int readerID, int total) {

        for (int i = 0; i < brm.length; i++) {
            if (readerID == brm[i].getReader().getReaderID()) {
                brm[i].setTotal(total);
            }
        }
        return brm;
    }

    private static Book findBookById(Book[] books, int id) {
        for (int i = 0; books != null && i < books.length && books[i] != null; i++) {
            if (books[i].getBookID() == id) {
                return books[i];
            }
        }
        return null;
    }

    private static Reader findReaderByID(Reader[] readers, int readerId) {
        for (int i = 0; i < readers.length; i++) {
            if (readers[i].getReaderID() == readerId) {
                return readers[i];
            }
        }
        return null;
    }
}
