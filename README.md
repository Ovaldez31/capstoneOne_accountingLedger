## General Ledger Application

This is a simple command-line Java application for managing a general ledger. It allows users to record deposits and payments, and navigate to a ledger screen (functionality for the ledger screen is in a separate `LedgerScreen` class, which is instantiated but not fully shown in this snippet).

## Features

* **Add Deposit:** Allows users to input the vendor and amount for a deposit.
* **Make Payment:** Enables users to record payments by specifying the vendor and payment amount.
* **Go to Ledger:** Navigates the user to a separate ledger screen (implementation details are in the `LedgerScreen` class).
* **Exit:** Closes the application.



## Ledger Screen Functionality

This Java code defines the `LedgerScreen` class, which provides a menu-driven interface for viewing financial ledger data loaded from a CSV file named `transaction.csv`.

## Features

* **Load Transactions:** Reads transaction data from `transaction.csv` upon initialization. Each line is expected to be pipe-separated (`|`) with fields for Date, Time, Description, Vendor, and Amount.
* **Main Ledger Menu:** Presents options to view all transactions, only deposits, only payments, access reports, or return to the home screen.
* **View All Transactions:** Displays all successfully loaded transactions, formatted with columns for Date, Time, Description, Vendor, and Amount.
* **View Deposits:** Shows only the transactions where the amount is positive (indicating a deposit).
* **View Payments:** Displays only the transactions where the amount is negative (indicating a payment).
* **Go to Reports:** Instantiates a `ReportsScreen` class (the implementation of the reports screen is not included in this snippet).
* **Back to Home Screen:** Sets a flag (`backToHome`) to signal the calling code to return to the main application menu.

## Data Source

The ledger data is read from a CSV file named `transaction.csv` located in the same directory as the application (or the path specified by `fileName`). Each line in the file should adhere to the following format:

Date|Time|Description|Vendor|Amount


**Example:**

2025-05-02|10:00|Grocery Shopping|SuperMart|-55.75
2025-05-02|14:30|Salary Deposit|Acme Corp|2500.00


## Usage

The `LedgerScreen` is typically instantiated from another part of the application (e.g., the `HomeScreen`). Upon creation, it automatically loads the transactions from the specified file and presents the ledger menu to the user. The user can then enter a number to navigate through the different options.

## Code Structure

The `LedgerScreen` class includes:

* **`fileName`:** A private string variable storing the name of the transaction data file ("transaction.csv").
* **`backToHome`:** A private boolean flag used to signal when the user wants to return to the main application menu.
* **`scanner`:** A private `Scanner` object for reading user input from the console.
* **`transactions`:** A private `List` of `Transaction` objects, used to store the data loaded from the file.
* **Constructor (`LedgerScreen()`):** Calls `loadTransactionsFromFile()` to read the data and then `displayLedgerMenu()` to present the user interface.
* **`loadTransactionsFromFile()`:** Reads each line from the `transaction.csv` file, splits it into parts, parses the data (including the amount as a float), and creates `Transaction` objects which are added to the `transactions` list. It includes basic error handling for file reading and data parsing.
* **`displayLedgerMenu()`:** Presents the main ledger menu to the user in a loop, takes user input, and calls the appropriate methods based on the user's choice.
* **`showAllLedgers()`:** Displays all the transactions stored in the `transactions` list, formatted with headers.
* **`showFilteredLedgers(boolean isDeposit)`:** Displays either deposits (positive amounts) or payments (negative amounts) based on the `isDeposit` flag.
* **`showReports()`:** A static method that instantiates a `ReportsScreen` (the implementation of which is not shown).
* **`printTransactionHeader()`:** A private helper method to print the column headers for transaction displays.
* **`Transaction` (Inner Static Class):** A simple class to represent a single transaction with attributes for date, time, description, vendor, and amount, along with getter and setter methods.



## The `ReportsScreen` class includes:

* **`fileName`:** A static string variable storing the name of the transaction data file ("transactions.csv").
* **`backToHome`:** A static boolean flag used to signal when the user wants to return to the ledger or home screen.
* **`scanner`:** A static `Scanner` object for reading user input from the console.
* **Constructor (`ReportsScreen()`):** Displays the reports menu in a loop and calls the appropriate methods based on the user's choice.
* **Report Generation Methods (`monthToDate()`, `previousMonth()`, `yearToDate()`, `previousYear()`):** Each of these methods reads the `transactions.csv` file, parses the date of each transaction, and displays the transactions that fall within the specified date range.
* **`searchByVendor()`:** Prompts the user for a vendor name, reads the `transactions.csv` file, and displays all transactions where the vendor name (case-insensitive) contains the user's input.
* **Output Formatting:** Each report method uses `printf` to display the transaction data in a formatted table with columns for Date, Time, Description, Vendor, and Amount.
* **Error Handling:** Basic `try-catch` blocks are used to handle potential `IOException` during file reading.
        