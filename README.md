# Java-DataFrame-Core
A memory-efficient Java implementation of a DataFrame engine using custom-built HashTables, Binary Search Trees (BST), and Linked Lists for optimized tabular data manipulation.

# Java DataFrame Implementation

A high-performance Java implementation of a DataFrame object, modeled after the Pandas library. This project focuses on custom-built data structures (HashTables, Binary Search Trees, and Linked Lists) to manage and index tabular data without external libraries.

## Key Features
* [cite_start]**Custom HashTable ADT:** Implements linear probing, dynamic resizing (SizeUp/SizeDown), and handle-based deletions using BRIDGE markers[cite: 13, 25, 120, 124].
* **Hybrid Indexing (SeriesV2):** Utilizes a dual-structure approach for data storage. [cite_start]A **Linked List** maintains insertion order, while a **Binary Search Tree (BST)** provides $O(\log N)$ lookup performance for row-level searches[cite: 395, 397].
* [cite_start]**Polymorphic Data Support:** Leverages Java generics to support heterogeneous data types across different columns[cite: 171].
* [cite_start]**Memory Efficient:** Includes manual load-factor management to balance memory usage and search speed[cite: 109, 131].

## Technical Implementation
[cite_start]The `DataFrame` class acts as a dictionary where keys are column headers and values are `SeriesV2` objects[cite: 141]. [cite_start]By integrating a BST into the Series implementation, search operations like `loc()` and `drop()` are optimized for large datasets[cite: 536, 538].
