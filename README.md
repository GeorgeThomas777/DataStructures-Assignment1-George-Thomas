# Data Structures - Assignment 1

## Author
Name: George Thomas  
Student ID: C0911617

---

## Overview

This assignment consists of 5 coding challenges based on fundamental data structures and algorithms. Each challenge explores a different data structure, with a focus on solving real-world inspired problems.

---

## Challenges and Approach

### 1. The Array Artifact
**Description:**  
Implemented an `ArtifactVault` class that uses an array to store ancient artifacts. The methods include:
- **Add an artifact** to the first empty slot.
- **Remove an artifact** by its name.
- **Linear search** to find an artifact.
- **Binary search** to find an artifact, assuming the array is sorted by artifact age.

**Approach:**  
- Used a basic array data structure to handle storage.
- Implemented a linear search by iterating through the array.
- For binary search, ensured the array remained sorted and used the divide-and-conquer algorithm.
  
---

### 2. The Linked List Labyrinth
**Description:**  
Developed a `LabyrinthPath` class using a singly linked list. The methods implemented are:
- **Add a new location** to the path.
- **Remove the last visited location**.
- **Check for loops** to detect traps in the path.
- **Print the entire path**.

**Approach:**  
- Utilized pointers to create a simple singly linked list.
- Implemented a loop detection algorithm using Floyd’s cycle-finding technique.

---

### 3. The Stack of Ancient Texts
**Description:**  
Created a `ScrollStack` class that manages ancient scrolls using a stack. The methods include:
- **Push** a new scroll onto the stack.
- **Pop** the top scroll off.
- **Peek** at the top scroll.
- **Search for a specific scroll** by title.

**Approach:**  
- Used a stack data structure with LIFO (Last In, First Out) logic.
- Efficiently managed the stack operations using an array-based implementation.

---

### 4. The Queue of Explorers
**Description:**  
Built an `ExplorerQueue` class using a circular queue. The operations include:
- **Enqueue** new explorers.
- **Dequeue** explorers as they enter the temple.
- **Display the next explorer** in line.
- **Check if the queue is full or empty**.

**Approach:**  
- Implemented a circular queue using an array, ensuring efficient space utilization.
- Included boundary checks for full and empty states.

---

### 5. The Binary Tree of Clues
**Description:**  
Created a `ClueTree` class representing a binary tree of clues. The methods implemented are:
- **Insert** a new clue.
- Perform **in-order, pre-order, and post-order traversals**.
- **Find a specific clue**.
- **Count the total number of clues** in the tree.

**Approach:**  
- Used a binary tree data structure.
- Implemented recursive methods for traversals and insertion.
- The search function used a depth-first approach.

---

## Assumptions and Design Decisions
- For binary search, it is assumed the artifacts are sorted by age, and methods to maintain this sorting are implicit.
- For linked lists, loop detection assumes the use of Floyd’s cycle-finding algorithm.
- For the circular queue, it's assumed the queue has a fixed size with boundary conditions handled efficiently.

---

## How to Run the Code

1. **Clone the repository:**
   ```bash
   git clone https://github.com/YourGitHubUsername/DataStructures-Assignment1-GeorgeThomas.git
   Open the project in your IDE (e.g., IntelliJ, Visual Studio):

2. Make sure all dependencies are properly installed.
   Compile and run the program:

3. Execute the main class associated with each challenge.
   Follow the on-screen instructions to test each functionality.
