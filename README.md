# Java-DataFrame-Core
A memory-efficient Java implementation of a DataFrame engine using custom-built HashTables, Binary Search Trees (BST), and Linked Lists for optimized tabular data manipulation.

# Java DataFrame Implementation

A high-performance Java implementation of a DataFrame object, modeled after the Pandas library. This project focuses on custom-built data structures (HashTables, Binary Search Trees, and Linked Lists) to manage and index tabular data without external libraries.

## Key Features
* **Custom HashTable ADT:** Implements linear probing, dynamic resizing (SizeUp/SizeDown), and handle-based deletions using BRIDGE markers.
* **Hybrid Indexing (SeriesV2):** Utilizes a dual-structure approach for data storage. A **Linked List** maintains insertion order, while a **Binary Search Tree (BST)** provides $O(\log N)$ lookup performance for row-level searches.
* **Polymorphic Data Support:** Leverages Java generics to support heterogeneous data types across different columns.
* **Memory Efficient:** Includes manual load-factor management to balance memory usage and search speed.

## Testing & TDD
* **Test-Driven Development:** Developed the core engine using TDD principles to ensure high code coverage and reliability.
* **Robust Test Suites:** Includes comprehensive unit tests (`SeriesTestDouble.java`, `SeriesTestString.java`) to validate generic type handling and edge-case behavior for various data types.

## Technical Implementation
The DataFrame class acts as a dictionary where keys are column headers and values are SeriesV2 objects. By integrating a BST into the Series implementation, search operations like loc() and drop() are optimized for large datasets.
