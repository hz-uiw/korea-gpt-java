package chapter10.practice1;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InventorySystem {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("===== Inventory System =====");
            System.out.println("1. Add Book");
            System.out.println("2. List All Book");
            System.out.println("3. Search Book");
            System.out.println("4. Search by Category");
            System.out.println("5. Search by Price Range");
            System.out.println("6. Update Stock");
            System.out.println("7. Remove Book");
            System.out.println("8. Exit");
            System.out.print("Select an option >>> ");

            try {
                // scanner.nextLine();
                // : 입력값이 문자열로 인식

                // Integer. parseInt(데이터);
                // : 데이터를 분석하여 Int형태로 변경
                // 숫자형태로 변경할 수 없는 값이 입력되는 경우 NumberFormatException 예외 발생
                // parse :  분석하다
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter Book Id >>> ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Book Title >>> ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Book ISBN >>> ");
                        String isbn = scanner.nextLine();
                        System.out.print("Enter Book Author >>> ");
                        String author = scanner.nextLine();
                        System.out.print("Enter Book Publisher >>> ");
                        String publisher = scanner.nextLine();

                        System.out.print("Enter Book Publish Year >>> ");
                        int year = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Price >>> ");
                        int price = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Stock Quantity >>> ");
                        int stock = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter Category >>> ");
                        String category = scanner.nextLine();

                        manager.add(new Book(id, title, isbn, author, publisher, year, price, stock, category));
                        break;
                    case 2:
                        manager.listAll();
                        break;
                    case 3:
                        System.out.print("Enter search keyword >>> ");
                        String keyword = scanner.nextLine();
                        List<Item> searchResult = manager.search(keyword);
                        if(searchResult.isEmpty()) {
                            System.out.println("No items found in Keyword: " + keyword);
                        } else {
                            for (Item item : searchResult) {
                                item.display();
                            }
                        }
                        break;
                    case 4:
                        System.out.print("Enter Category >>> ");
                        String searchCategory = scanner.nextLine();
                        List<Item> categoryResult = manager.searchByCategory(searchCategory);
                        if(categoryResult.isEmpty()) {
                            System.out.println("No items found in category: " + searchCategory);
                        } else {
                            for (Item item : categoryResult) {
                                item.display();
                            }
                        }
                        break;
                    case 5:
                        System.out.print("Enter Minimum price >>> ");
                        int minPrice = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Maximum price >>> ");
                        int maxPrice = Integer.parseInt(scanner.nextLine());

                        List<Item> priceResults = manager.searchByPriceRange(minPrice, maxPrice);
                        if (priceResults.isEmpty()) {
                            System.out.print("No items found in price rage");
                        } else {
                            for (Item item : priceResults) {
                                item.display();
                            }

                            // priceResults.forEach(Item::display);
                        }
                        break;
                    case 6:
                        System.out.print("Enter book Id to update Stock >>> ");
                        String updateId = scanner.nextLine();
                        System.out.print("Enter Quantity to add / subetract >>> ");
                        int quantity = Integer.parseInt(scanner.nextLine());
                        manager.updateStock(updateId, quantity);
                        break;
                    case 7:
                        System.out.print("Enter Book ID to remove >>> ");
                        String removeId = scanner.nextLine();
                        manager.remove(removeId);
                        break;
                    case 8:
                        System.out.println("== Exiting ==");
                        return;
                    default:
                        System.out.println("Invalid option. Try again");
                }

            } catch(NumberFormatException e) {
                System.out.println("Please Enter a valid number");
            } catch (NoSuchElementException e) {
                // 검색된 내용이 없을 경우 실행될 블럭
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
