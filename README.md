# Place Order Application

This repository contains a Java-based application for managing customer orders using the MVC (Model-View-Controller) architecture. The application connects to a MySQL database and allows users to search for customers and items, place orders, and update inventory quantities.

---

## Features

- **Search Customer**: Retrieve customer details by entering the Customer ID.
- **Search Item**: Retrieve item details by entering the Item ID.
- **Place Order**: Add items to an order and save it in the database.
- **Update Inventory**: Automatically reduce the item quantities in the inventory after placing an order.

---

## Project Overview

The application consists of the following components:

1. **Graphical User Interface (GUI)**:
   - Built using Java Swing.
   - Provides input fields for Order ID, Customer ID, Item ID, Quantity, and Discount.
   - Displays an order summary table to review added items before placing the order.

2. **MVC Architecture**:
   - **Model**: Manages the application’s data, including customers, items, orders, and database interactions.
   - **View**: Represents the GUI components, such as buttons, text fields, and tables.
   - **Controller**: Processes user inputs, manages the flow of data between the Model and View, and executes business logic.

3. **Database Interaction**:
   - Connects to a MySQL database to fetch customer and item details and save orders.
   - Updates the item inventory by reducing quantities based on placed orders.

---

## Usage Flow

1. **Search for Customer**:
   - Enter the Customer ID and click the "Search" button.
   - The system retrieves and displays customer details.

2. **Search for Item**:
   - Enter the Item ID and click the "Search" button.
   - The system retrieves and displays item details, including name, price, and available quantity.

3. **Place an Order**:
   - Input the item ID, quantity, and any applicable discount.
   - Click "Add" to add the item to the order list.
   - Once all items are added, click "Place Order" to save the order in the database.

4. **Inventory Update**:
   - The system automatically reduces the quantities of ordered items in the inventory.

---

## Technology Stack

- **Programming Language**: Java
- **GUI Framework**: Swing
- **Database**: MySQL
- **JDBC Driver**: MySQL Connector/J
