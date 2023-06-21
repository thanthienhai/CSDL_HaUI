package view;


import controller.ControllerUltility;
import controller.DataUlitility;
import model.Book;
import model.BookReaderManagerment;
import model.Reader;

import java.util.Scanner;

/**@author Than
 * Lớp này có chức năng hiển thị và nhận tương tác từ người dùng.
 */

public class View {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean isActivate = false;

    public static void main(String[] args) {
        int choice = 0;

        DataUlitility dataUlitility = new DataUlitility();
        ControllerUltility controllerUltility = new ControllerUltility();

        Reader[] readers = null;
        Book[] books = null;
        BookReaderManagerment[] managerments = null;

        do {
            System.out.println("\n____________XIN MỜI CHỌN MỘT CHỨC NĂNG____________");
            System.out.println("1. Thêm 1 Reader vào file.");
            System.out.println("2. Hiển thị danh sách Reader.");
            System.out.println("3. Thêm 1 Book vào file.");
            System.out.println("4. Hiển thị danh sách các Book.");
            System.out.println("5. Nhập thông tin Quản lý mượn sách.");
            System.out.println("6. Sắp xếp thông tin mượn sách.");
            System.out.println("7. Tìm kiếm thông tin Reader theo tên.");
            System.out.println("0. Thoát chương trình.");
            System.out.println("Bạn chọn ? ");

            choice = scanner.nextInt();
            scanner.nextLine();// doc bo dong chua lua chon

            switch (choice) {
                case 0:
                    System.out.println("____________Thoát khỏi chương trình____________");
                    System.out.println("Cảm ơn quý vị đã sử dụng dịch vụ của chúng tôi!");
                    break;

                case 1:
                    if(!isActivate){
                        updateId(dataUlitility);
                    }
                    getReaderInfo(dataUlitility);
                    break;

                case 2:
                    readers = readReaderInfo(dataUlitility, "READER.DAT");
                    showReaderInfo(readers);
                    break;

                case 3:
                    getBookInfo(dataUlitility);
                    break;

                case 4:
                    books = readBookInfo(dataUlitility, "BOOK.DAT");
                    showBookInfo(books);
                    break;

                case 5:
                    int readerId;
                    int bookId;
                    Reader reader = null;
                    Book book = null;
                    if (books == null) {
                        books = readBookInfo(dataUlitility, "BOOK.DAT");
                    }
                    if (readers == null) {
                        readers = readReaderInfo(dataUlitility, "READER.DAT");
                    }
                    managerments = dataUlitility.readBRMFromFile("BRM.DAT");
                    managerments = update(controllerUltility, managerments, dataUlitility);
                    boolean done = false;
                    do {
                        showReaderInfo(readers);
                        System.out.println("Nhập mã bạn đọc cần lập thông tin mượn sách: ");
                        readerId = scanner.nextInt();
                        reader = findReaderByID(readers, readerId);
                        if (reader != null) {
                            done = true;
                        }
                        // tìm xem còn đủ đk mượn hay không
                        //managerments = dataUlitility.readBRMFromFile("BRM.DAT");

                        if (done) {
                            break;
                        }
                    } while (true);

                    done = isBorrowable(managerments, readerId);// neu ko the muon them thi thong bao, end
                    if (done) {
                        System.out.println("Danh sách đầu sách đã mượn: ");
                        showBorrowedInfo(managerments, readerId);
                        // nhập đầu sách:
                        showBookInfo(books);
                        do {
                            System.out.println("Nhập mã đầu sách: ");
                            bookId = scanner.nextInt();
                            book = findBookById(books, bookId);
                            if (book != null) {
                                done = true;
                            }
                            if (done) {
                                done = isNotFull(bookId, readerId, managerments);
                            }
                        } while (!done);
                        // nhap so luong va tinh trang:
                        int numOfBorrowedBook = 0;
                        int borrowed = countBorrowed(bookId, readerId, managerments);
                        do {
                            System.out.println("Bạn đã mượn " + borrowed + " cuốn.");
                            System.out.println("Nhập số lượng sách cần mượn, tối đa " + (3 - borrowed) + " cuốn: ");
                            numOfBorrowedBook = scanner.nextInt();
                            numOfBorrowedBook += borrowed;
                            if (numOfBorrowedBook > 0 && numOfBorrowedBook <= 3) {
                                break;
                            }
                        } while (true);
                        scanner.nextLine(); // đọc bỏ dòng hiện thời đi

                        System.out.println("Nhập tình trạng sách");
                        String state = scanner.nextLine();
                        BookReaderManagerment b = new BookReaderManagerment(reader, book,
                                numOfBorrowedBook, state);
                        dataUlitility.writeBRMToFile(b, "BRM.DAT");
                    } else {
                        System.out.println("Bạn đã mượn đủ tối đa số lượng cho phép!");
                    }
                    managerments = readBRMInfo(dataUlitility);
                    managerments = update(controllerUltility, managerments, dataUlitility);
                    showBRMInfo(managerments);

                    break;

                case 6:
                    managerments = readBRMInfo(dataUlitility);
                    managerments = update(controllerUltility, managerments, dataUlitility);
                    int sortChoice = 0;
                    do {
                        System.out.println("___________Lựa chọn sắp xếp___________");
                        System.out.println("1. Sắp xếp theo tên bạn đọc.");
                        System.out.println("2. Sắp xếp theo tổng số lượng mượn.");
                        System.out.println("0. Thoát khỏi chức năng này.");
                        System.out.println("Bạn chọn ? ");
                        sortChoice = scanner.nextInt();
                        switch (sortChoice) {
                            case 0:
                                break;
                            case 1:
                                managerments = sortByName(managerments);
                                showBRMInfo(managerments);
                                break;
                            case 2:
                                managerments = sortByNumOfBorrowed(managerments);
                                showBRMInfo(managerments);
                                break;
                        }
                    } while (sortChoice != 0);

                    break;

                case 7:
                    managerments = readBRMInfo(dataUlitility);
                    managerments = update(controllerUltility, managerments, dataUlitility);

                    System.out.println("Nhập tên của bạn đọc cần tìm: ");
                    String key = scanner.nextLine();
                    BookReaderManagerment[] result = controllerUltility.findByName(managerments, key);
                    showBRMInfo(result);
                    break;

                default:
                    System.out.println("Vui long chon lai chuc nang!");
            }
        } while (choice != 0);
    }

    private static void updateId(DataUlitility dataUlitility) {
        Reader[] readers = readReaderInfo(dataUlitility, "READER.DAT");
        if(readers.length > 0){
            Reader.id = readers[readers.length - 1].getReaderID()+1;
        }

        Book[] books = readBookInfo(dataUlitility, "BOOK.DAT");
        if(books.length > 0){
            Book.id = books[books.length-1].getBookID()+1;
        }

        isActivate = true;
    }

    private static BookReaderManagerment[] update(ControllerUltility controllerUltility,
                                                  BookReaderManagerment[] managerments,
                                                  DataUlitility dataUlitility) {
        Reader[] readers = readReaderInfo(dataUlitility, "READER.DAT");
        Book[] books = readBookInfo(dataUlitility, "BOOK.DAT");
        return controllerUltility.updateBRMInfo(managerments, readers, books);
    }

    private static BookReaderManagerment[] readBRMInfo(DataUlitility dataUlitility) {
        return dataUlitility.readBRMFromFile("BRM.DAT");
    }

    private static BookReaderManagerment[] sortByNumOfBorrowed(BookReaderManagerment[] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i].getTotal() > m[j].getTotal()) {
                    BookReaderManagerment x = m[i];
                    m[i] = m[j];
                    m[j] = x;
                }
            }
        }
        return m;
    }

    private static void showBRMInfo(BookReaderManagerment[] m) {
        System.out.println("____________Thông tin quản lý mượn sách____________");
        System.out.printf("%-10s%-20s%-15s%-20s%-15s%-10s%-15s\n", "ReaderID",
                "Reader Name", "BookID", "Book Name", "Quantity", "State", "Total");
        for (int i = 0; i < m.length; i++) {
            if (m[i] != null) {
                System.out.printf("%-10d%-20s%-15d%-20s%-15d%-10s%-15d\n", m[i].getReader().getReaderID(),
                        m[i].getReader().getFullName(),
                        m[i].getBooks().getBookID(), m[i].getBooks().getBookName(),
                        m[i].getNumOfBorrow(), m[i].getState(), m[i].getTotal());
            }
        }

    }

    private static void showBRMPersonalInfo(BookReaderManagerment[] m, int persionId) {
        System.out.println("____________Thông tin mượn sách của bạn đọc mã " + persionId + "____________");
        System.out.printf("%10s%10s%10s%-10s\n", "ReaderID", "BookID", "Quantity", "State");
        for (int i = 0; i < m.length; i++) {
            if (m[i].getReader().getReaderID() == persionId) {
                System.out.printf("%10d%10d%10d%-10s\n", m[i].getReader().getReaderID(),
                        m[i].getBooks().getBookID(), m[i].getNumOfBorrow(), m[i].getState());
            }
        }

    }

    private static BookReaderManagerment[] sortByName(BookReaderManagerment[] managerments) {
        for (int i = 0; i < managerments.length-1; i++) {
            for (int j = managerments.length-1; j > i; j--) {
                if (check(managerments[j].getReader().getFullName(),
                        managerments[j-1].getReader().getFullName())) {
                    BookReaderManagerment tmp = managerments[j];
                    managerments[j] = managerments[j-1];
                    managerments[j-1] = tmp;
                }
            }
        }
        return managerments;
    }

    private static boolean check(String name1, String name2) {
        String[] items1 = name1.split(" ");
        String[] items2 = name2.split(" ");
        if (items1[items1.length - 1].compareTo(items2[items2.length - 1]) < 0) {
            return true;
        }
        return false;
    }

    private static int countBorrowed(int bookId, int readerId, BookReaderManagerment[] m) {
        for (int i = 0; m != null && i < m.length && m[i] != null; i++) {
            if (m[i].getReader().getReaderID() == readerId &&
                    m[i].getBooks().getBookID() == bookId) {
                return m[i].getNumOfBorrow();
            }
        }
        return 0;
    }

    private static boolean isNotFull(int bookId, int readerId, BookReaderManagerment[] m) {
        for (int i = 0; i < m.length; i++) {
            if (m[i].getReader().getReaderID() == readerId &&
                    m[i].getBooks().getBookID() == bookId
                    && m[i].getNumOfBorrow() == 3) {
                return false;
            }
        }
        return true;
    }

    private static void showBorrowedInfo(BookReaderManagerment[] b, int readerId) {
        System.out.println("Mã sách\tSố lượng đã mượn");
        for (int i = 0; i < b.length; i++) {
            if (b[i].getReader().getReaderID() == readerId) {
                System.out.println(b[i].getBooks().getBookID() + "\t" + b[i].getNumOfBorrow());
            }
        }
        System.out.println("\nMỗi bạn đọc chỉ được mượn tối đa 5 loại sách với mỗi loại tối đa 3 cuốn!");
    }

    private static boolean isBorrowable(BookReaderManagerment[] managerments, int readerId) {
        int count = 0;
        int total = 0;
        for (int i = 0; i < managerments.length; i++) {
            if (managerments[i].getReader().getReaderID() ==
                    readerId) {
                count++;
                total += managerments[i].getNumOfBorrow();
            }
        }
        if (count <= 5 && total < 15)
            return true;
        else
            return false;
    }

    private static Book findBookById(Book[] books, int id) {
        for (int i = 0; i < books.length; i++) {
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

    private static void showBookInfo(Book[] books) {
        System.out.println("____________Thông tin Book trong file____________");
        if (books[0] == null) {
            System.out.println("Danh sách rỗng!");
        } else {
            for (int i = 0; i < books.length; i++) {
                if (books[i] != null) {
                    System.out.println(books[i]);
                }
            }
        }

    }

    private static void getBookInfo(DataUlitility dataUlitility) {
        System.out.println("____________Nhập thông tin Book____________");
        String[] specializations = {"Science", "Art", "Economic", "IT"};

        String bookName, author, spec;
        int quantity, year, specialization;

        System.out.println("Nhập tên sách: ");
        bookName = scanner.nextLine();
        System.out.println("Nhập tác giả: ");
        author = scanner.nextLine();
        do {
            System.out.println("Chọn chuyên ngành: ");
            System.out.println("1. Science.\n2. Art.\n3. Economic.\n4. IT.");
            specialization = scanner.nextInt();
        } while (specialization < 1 || specialization > 4);

        System.out.println("Nhập số lượng: ");
        quantity = scanner.nextInt();
        System.out.println("Nhập năm xuất bản: ");
        year = scanner.nextInt();

        Book book = new Book(bookName, author,
                specializations[specialization - 1], year, quantity);
        dataUlitility.writeBookToFile(book, "BOOK.DAT");
    }

    private static void showReaderInfo(Reader[] readers) {
        System.out.println("____________Thông tin Reader trong file____________");
        if (readers[0] == null) {
            System.out.println("Danh sách rỗng!");
        } else {
            for (int i = 0; i < readers.length; i++) {
                if (readers[i] != null) {
                    System.out.println(readers[i]);
                }
            }
        }
    }

    private static void getReaderInfo(DataUlitility dataUlitility) {
        System.out.println("____________Nhập thông tin Reader____________");
        String name, address, phoneNum;

        System.out.println("Nhập họ và tên: ");
        name = scanner.nextLine();

        System.out.println("Nhập địa chỉ: ");
        address = scanner.nextLine();

        System.out.println("Nhập số điện thoại: ");
        phoneNum = scanner.nextLine();


        Reader reader = new Reader(name, address, phoneNum);
        dataUlitility.writeReaderToFile(reader, "READER.DAT");
    }

    private static Reader[] readReaderInfo(DataUlitility dataUlitility, String s) {
        return dataUlitility.readAllReaderFromFile(s);
    }

    private static Book[] readBookInfo(DataUlitility dataUlitility, String s) {
        return dataUlitility.readAllBookFromFile(s);
    }
}
