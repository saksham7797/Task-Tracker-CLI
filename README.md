# Task Tracker CLI

![Java](https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)

A robust, zero-dependency command-line interface (CLI) application to track and manage your daily tasks. Built entirely in **Core Java**, this project focuses on raw file handling, data persistence, and custom JSON parsing logic without using external libraries like Jackson or Gson.

> This project is part of the [roadmap.sh backend developer path](https://roadmap.sh/projects/task-tracker).

## 📖 Table of Contents

- [Features](#-features)
- [Prerequisites](#-prerequisites)
- [Installation](#-installation)
- [Usage](#-usage)
- [Technical Details](#-technical-details)
- [Project Structure](#-project-structure)
- [License](#-license)

## ✨ Features

- **Add Tasks:** Create new tasks with a description.
- **Update Tasks:** Modify the description of existing tasks.
- **Delete Tasks:** Remove tasks permanently by their unique ID.
- **List Tasks:** View all tasks with their ID, description, and status (todo, in-progress, done).
- **Data Persistence:** Automatically saves all data to a local `tasks.json` file.
- **Zero Dependencies:** Implements a custom "Desi" parser to read and write JSON data manually.

## 🛠 Prerequisites

Ensure you have the following installed on your machine:

- **Java Development Kit (JDK):** Version 11 or higher.

Verify your installation:
```bash
🚀 Installation
Clone the repository

Bash

git clone [https://github.com/your-username/task-tracker.git](https://github.com/your-username/task-tracker.git)
Navigate to the project directory

Bash

cd task-tracker
Compile the Java code

Bash

javac TaskTracker.java
💻 Usage
Run the application using the java command followed by the operation arguments.

1. Add a new task
Bash

java TaskTracker add "Buy groceries"
# Output: Task added successfully (ID: 1)
2. List all tasks
Bash

java TaskTracker list
# Output:
# ID: 1 | Status: todo | Description: Buy groceries
# ID: 2 | Status: in-progress | Description: Learn Java
3. Update a task
Requires the Task ID and the New Description.

Bash

java TaskTracker update 1 "Buy groceries and cook dinner"
# Output: Task updated successfully.
4. Delete a task
Requires the Task ID.

Bash

java TaskTracker delete 1
# Output: Task deleted successfully.
🧠 Technical Details
Why No Libraries?
The challenge of this project was to build a backend application without using any external libraries or frameworks. This required understanding the fundamentals of:

File I/O: Using java.nio.file and java.io packages to handle file existence checks, reading, and writing.

String Manipulation: Implementing a custom JSON parser using String.split(), String.replace(), and String.substring().

Data Persistence: Managing state persistence between CLI executions using a JSON file (tasks.json).

The Custom Parser Logic
Since ObjectMapper was not allowed, the application parses data using a marker strategy:

Reading: It reads the raw file string, strips brackets [], and splits task objects using the regex pattern }, { as a delimiter.

Writing: It constructs the JSON string manually using StringBuilder to ensure efficient memory usage.

📂 Project Structure
Bash

task-tracker/
├── TaskTracker.java    # Main entry point and CLI logic
├── Task.java           # Data model class (ID, Description, Status)
├── tasks.json          # Data storage (Auto-generated on first run)
├── LICENSE             # MIT License
└── README.md           # Project documentation
📄 License
This project is licensed under the MIT License. See the LICENSE file for details.
```
<div align="center"> Made with ☕ and Java by <b>Saksham Kumar</b> </div>
